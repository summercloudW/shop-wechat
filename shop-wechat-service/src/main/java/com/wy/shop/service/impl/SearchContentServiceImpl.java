package com.wy.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.wy.shop.entity.Goods;
import com.wy.shop.mapper.GoodsMapper;
import com.wy.shop.service.SearchContentService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyibo
 */
@Service
public class SearchContentServiceImpl implements SearchContentService {

    public static final Logger logger = LoggerFactory.getLogger(SearchContentServiceImpl.class);

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public boolean addGoodsToEs() throws IOException {
        List<Goods> goodsList = goodsMapper.getAllGoods();
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2s");
        for (int i = 0; i < goodsList.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("shop_wechat_goods")
                            .source(JSON.toJSONString(goodsList.get(i)), XContentType.JSON)
            );
        }
        BulkResponse responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        return !responses.hasFailures();
    }

    @Override
    public List<Map<String, Object>> searchPages(String keyword,
                                                 int pageNo,
                                                 int pageSize) throws IOException {

        if (pageNo <=1) {
            pageNo = 1;
        }

        SearchRequest searchRequest = new SearchRequest("shop_wechat_goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 分页
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);
        // 精准匹配
        char[] chars = keyword.toCharArray();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        for (char singleKey : chars) {
            TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", String.valueOf(singleKey));
            boolQueryBuilder.must(termQueryBuilder);
        }
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(10, TimeUnit.SECONDS));
        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<text style='color:red'>");
        highlightBuilder.postTags("</text>");
        searchSourceBuilder.highlighter(highlightBuilder);
        //执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析结果
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit document : response.getHits().getHits()) {
            Map<String, HighlightField> highlightFields = document.getHighlightFields();
            HighlightField title = highlightFields.get("name");
            Map<String, Object> sourceAsMap = document.getSourceAsMap();

            //解析高亮的字段, 将原来的字段替换为我们高亮的字段即可
            if (title != null) {
                Text[] fragments = title.fragments();
                String newTitle = "";
                for (Text text : fragments) {
                    newTitle += text;
                }
                //高亮字段替换原来的字段
                sourceAsMap.put("name", newTitle);
            }
            list.add(sourceAsMap);
        }
        return list;
    }

}

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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangyibo
 */
@Service
public class SearchContentServiceImpl implements SearchContentService {

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

        SearchRequest searchRequest = new SearchRequest("shop_wechat_goods");

        //分页
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);

        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(30, TimeUnit.SECONDS));

        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");

        searchSourceBuilder.highlighter(highlightBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] hits = searchResponse.getHits().getHits();

        //解析结果
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : hits) {
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField name = highlightFields.get("name");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();

            //解析高亮的字段, 将原来的字段替换为我们高亮的字段即可
            if (name != null) {
                Text[] fragments = name.fragments();
                String newName = "";
                for (Text text : fragments) {
                    newName += text;
                }
                //高亮字段替换原来的字段
                sourceAsMap.put("name", newName);
            }
            list.add(sourceAsMap);
        }
        return list;
    }
}

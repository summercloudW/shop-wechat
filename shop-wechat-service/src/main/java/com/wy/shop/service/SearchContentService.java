package com.wy.shop.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangyibo
 */
public interface SearchContentService {



    public boolean addGoodsToEs() throws IOException;

    public List<Map<String, Object>> searchPages(String keyword,
                                                 int pageNo,
                                                 int pageSize) throws IOException;

}

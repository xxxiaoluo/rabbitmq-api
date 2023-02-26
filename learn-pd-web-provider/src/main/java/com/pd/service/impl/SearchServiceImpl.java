package com.pd.service.impl;

import com.pd.es.ItemRepository;
import com.pd.pojo.PdItem;
import com.pd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ItemRepository ir;

    @Override
    public List<SearchHit<PdItem>> search(String key, Pageable pageable) {
        List<SearchHit<PdItem>> result = ir.findByTitleOrSellPoint(key, key, pageable);
        return result;
    }
}

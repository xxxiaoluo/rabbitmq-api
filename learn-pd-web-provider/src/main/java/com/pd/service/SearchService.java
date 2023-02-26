package com.pd.service;

import com.pd.pojo.PdItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;

import java.util.List;


public interface SearchService {
    List<SearchHit<PdItem>> search(String key, Pageable pageable);
}

package com.pd.es;

import com.pd.pojo.PdItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.HighlightParameters;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<PdItem,Long> {
    /**
     * 如果要做高亮显示，高亮结果会封装到 SearchHit 对象
     * 做高亮设置用 @Highlight注解 parameter高亮词前后标签 ，field高亮字段
     */
    @Highlight(
            parameters = @HighlightParameters(
                    preTags = "<em>",
                    postTags = "</em>"
            ),
            fields = {
                    @HighlightField(name = "title"),
                    @HighlightField(name = "sellPoint")
            }
    )
    List<SearchHit<PdItem>> findByTitleOrSellPoint(String key1, String key2, Pageable pageable);
}

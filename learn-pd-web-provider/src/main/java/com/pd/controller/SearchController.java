package com.pd.controller;

import com.pd.pojo.PdItem;
import com.pd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 *  roy
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/search/toSearch.html")  // ...?key=手机&page=0&size=20
    public String search(Model model,String key, Pageable pageable) { //Pageable接收分页参数
        //分页参数在 AbstractPageRequest中
        List<SearchHit<PdItem>> list = searchService.search(key, pageable);

        //把所有SearchHit中的PdItem对象拿出来，放入新的List<PdItem>
        ArrayList<PdItem> arrayList = new ArrayList<>();
        for(SearchHit<PdItem> item : list){
            PdItem pdItem = item.getContent();

            // SearchHit 对象中的高亮数据
            // ["xxx", "<em>", "手机", "</em>", "xxxxx"]
            List<String> titleHighlight = item.getHighlightField("title");
            // 把高亮的 title 放入 item，替换原始的 title
            pdItem.setTitle(highlightTiele(titleHighlight));

            arrayList.add(pdItem);
        }

        //集合放入model对象，传递jsp界面进行显示 ,jsp页面的${list}可以从Model中获取list属性
        model.addAttribute("list", arrayList);
        model.addAttribute("p", pageable);
        return "/search.jsp";
    }

    private String highlightTiele(List<String> titleHighlight) {
        StringBuilder sb = new StringBuilder();
        for (String s : titleHighlight) {
            sb.append(s);
        }
        return sb.toString();
    }

}

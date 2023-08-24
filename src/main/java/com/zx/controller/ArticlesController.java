package com.zx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zx.model.Articles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zx.service.ArticlesBiz;
import com.zx.util.JsonData;
import com.zx.util.PageBean;
import com.zx.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cdl
 * @site www.cdl.com
 * @create 2022-09-17 9:36
 */
@Slf4j
@Controller
@RequestMapping("/article")
public class ArticlesController {

    @Autowired
    private ArticlesBiz articlesBiz;
    private int code;

    //    增加
    @ResponseBody
    @CrossOrigin//跨域
    @RequestMapping("/add")
    public String add(HttpServletResponse resp, Articles article) {
        ObjectMapper om = new ObjectMapper();
        try {
            code = this.articlesBiz.insert(article);
        } catch (Exception e) {
            log.error("add error: " + e);
            code = 0;
        } finally {
            JsonData jsonData = new JsonData(code, code == 0 ? "新增失败" : "新增成功", code);
            try {
                ResponseUtil.write(resp, om.writeValueAsString(jsonData));
            } catch (Exception e) {
                log.error("add ResponseUtil error: " + e);
            }
        }
        return null;
    }

    //    修改
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/edit")
    public String edit(HttpServletResponse resp, Articles article) {
        ObjectMapper om = new ObjectMapper();
        try {
            code = this.articlesBiz.updateByPrimaryKeySelective(article);
        } catch (Exception e) {
            log.error("edit error: " + e);
            code = 0;
        } finally {
            JsonData jsonData = new JsonData(code, code == 0 ? "修改失败" : "修改成功", code);
            try {
                ResponseUtil.write(resp, om.writeValueAsString(jsonData));
            } catch (Exception e) {
                log.error("edit ResponseUtil error: " + e);
            }
        }
        return null;
    }

    //    删除
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/del")
    public String del(HttpServletResponse resp, Integer id) {
        ObjectMapper om = new ObjectMapper();
        try {
            this.articlesBiz.deleteByPrimaryKey(id);
            code = 1;
        } catch (Exception e) {
            log.error("del error: " + e);
            code = 0;
        } finally {
            JsonData jsonData = new JsonData(code, code == 0 ? "删除失败" : "删除成功", code);
            try {
                ResponseUtil.write(resp, om.writeValueAsString(jsonData));
            } catch (Exception e) {
                log.error("del ResponseUtil error: " + e);
            }
        }
        return null;
    }

    ;

    //    查询
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/list")
    public List<Map<String, Object>> selectAll(HttpServletRequest req, HttpServletResponse response, Articles article) {
        ObjectMapper om = new ObjectMapper();
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        Map<String, Object> map = new HashMap<>();
        try {
            if (null == article.getTitle()) {
                article.setTitle("");
            }
            List<Map<String, Object>> articles = articlesBiz.listPager(article, pageBean);
            JsonData jsonData = new JsonData(1, "操作成功", articles);
            jsonData.put("pageBean", pageBean);
            ResponseUtil.write(response, om.writeValueAsString(jsonData));
        } catch (Exception e) {
            log.error("list error: " + e);
        }
        return null;
    }

}
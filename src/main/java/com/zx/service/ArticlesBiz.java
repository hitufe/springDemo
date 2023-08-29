package com.zx.service;

import com.zx.model.Articles;
import com.zx.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author 666
 * @create 2023-08-11 9:36
 */
public interface ArticlesBiz {

    int deleteByPrimaryKey(Articles record);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKeyWithBLOBs(Articles record);

    int updateByPrimaryKey(Articles record);

    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> listPager(Articles record, PageBean pageBean);

}
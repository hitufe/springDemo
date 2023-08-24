package com.zx.mapper;

import com.zx.model.Articles;

import java.util.List;
import java.util.Map;

public interface ArticlesMapper {
    int insert(Articles record);

    int insertSelective(Articles record);

    int deleteByPrimaryKey(Integer id);

    Articles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKeyWithBLOBs(Articles record);

    int updateByPrimaryKey(Articles record);

    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> listPager(Articles record);
}
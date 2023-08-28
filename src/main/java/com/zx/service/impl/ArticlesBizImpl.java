package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zx.service.ArticlesBiz;
import com.zx.mapper.ArticlesMapper;
import com.zx.model.Articles;
import com.zx.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author cdl
 * @site www.cdl.com
 * @create 2022-09-16 22:32
 */
@Service
public class ArticlesBizImpl implements ArticlesBiz {

    @Autowired
    private ArticlesMapper articlesMapper;

    @Override
    public int deleteByPrimaryKey(Articles record) {
        return articlesMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int insert(Articles record) {
        return articlesMapper.insert(record);
    }

    @Override
    public int insertSelective(Articles record) {
        return articlesMapper.insertSelective(record);
    }

    @Override
    public Articles selectByPrimaryKey(Integer id) {
        return articlesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Articles record) {
        return articlesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Articles record) {
        return articlesMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Articles record) {
        return articlesMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> selectAll() {
        return articlesMapper.selectAll();
    }

    @Override
    public List<Map<String, Object>> listPager(Articles record, PageBean pageBean) {
        if (pageBean != null && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }

        List<Map<String, Object>> maps = articlesMapper.listPager(record);

        if (pageBean != null && pageBean.isPagination()) {
            PageInfo info = new PageInfo(maps);
            pageBean.setTotal(info.getTotal() + "");
        }

        return maps;
    }
}
package houwing.top.cake_site.biz.impl;


import houwing.top.cake_site.biz.CatalogBiz;
import houwing.top.cake_site.dao.CatalogDao;
import houwing.top.cake_site.entity.Catalog;
import houwing.top.cake_site.global.DaoFactory;

import java.util.List;

public class CatalogBizImpl implements CatalogBiz {
    private CatalogDao categoryDao=DaoFactory.getInstance().getDao(CatalogDao.class);

    public void add(List<Catalog> list) {
        categoryDao.batchInsert(list);
    }

    public void remove(int id) {
        categoryDao.delete(id);
    }

    public Catalog getRoot() {
        return categoryDao.select(10000);
    }


}

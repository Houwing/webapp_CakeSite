package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Catalog;

import java.util.List;

public interface CatalogBiz {
    void add(List<Catalog> list);
    void remove(int id);
    Catalog getRoot();
}

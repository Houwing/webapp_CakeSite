package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Cake;

import java.util.List;

public interface CakeBiz {
    void add(Cake cake);
    void edit(Cake cake);
    void remove(int id);
    Cake get(int id);
    List<Cake> getAll();

    List<Cake> getSpecial();
    List<Cake> getForIndex();
    List<Cake> getForCatalog(int cid);
}

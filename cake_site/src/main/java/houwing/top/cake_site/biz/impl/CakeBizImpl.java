package houwing.top.cake_site.biz.impl;

import houwing.top.cake_site.biz.CakeBiz;
import houwing.top.cake_site.dao.CakeDao;
import houwing.top.cake_site.entity.Cake;
import houwing.top.cake_site.global.DaoFactory;

import java.util.List;

public class CakeBizImpl implements CakeBiz {
    private CakeDao cakeDao= DaoFactory.getInstance().getDao(CakeDao.class);

    public void add(Cake cake) {
        cakeDao.insert(cake);
    }

    public void edit(Cake cake) {
        cakeDao.update(cake);
    }

    public void remove(int id) {
        cakeDao.delete(id);
    }

    public Cake get(int id) {
        return cakeDao.select(id);
    }

    public List<Cake> getAll() {
        return cakeDao.selectAll();
    }

    public List<Cake> getSpecial() {
        List<Cake> list = cakeDao.selectByStatus("特卖");
        if(list.size()>0)
            return list;
        return null;
    }

    public List<Cake> getForIndex() {
        return cakeDao.selectByStatus("推荐");
    }

    public List<Cake> getForCatalog(int cid) {
        return cakeDao.selectByCatalog(cid);
    }
}

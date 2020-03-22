package houwing.top.cake_site.global;

import houwing.top.cake_site.biz.CatalogBiz;
import houwing.top.cake_site.biz.impl.CatalogBizImpl;
import houwing.top.cake_site.entity.Catalog;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CatalogTreeListener implements ServletContextListener {
    private CatalogBiz catalogBiz=new CatalogBizImpl();

    public void contextInitialized(ServletContextEvent sce) {
        Catalog root=catalogBiz.getRoot();
        sce.getServletContext().setAttribute("root",root);
    }
}

package houwing.top.cake_site.controller;

import houwing.top.cake_site.biz.CatalogBiz;
import houwing.top.cake_site.biz.impl.CatalogBizImpl;
import houwing.top.cake_site.entity.Catalog;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CatalogController {
    Logger log = Logger.getLogger(CatalogController.class);
    private CatalogBiz categroryBiz=new CatalogBizImpl();
    //      /admin/Categrory/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("list.do ...");
        Catalog root=categroryBiz.getRoot();
        request.getServletContext().setAttribute("root",root);
        log.info(root+"go list.jsp");
        request.getRequestDispatcher("/WEB-INF/pages/admin/catalog_list.jsp").forward(request,response);
    }
    //      /admin/Categrory/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Catalog root=categroryBiz.getRoot();
        request.setAttribute("root",root);
        request.getRequestDispatcher("/WEB-INF/pages/admin/catalog_add.jsp").forward(request,response);
    }
    //      /admin/Categrory/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收多个数据使用request.getParameterValues();
        String[] titles=request.getParameterValues("title");
        String[] pids=request.getParameterValues("pid");
        String[] infos=request.getParameterValues("info");
        List<Catalog> list=new ArrayList<Catalog>();
        log.info(titles);
        log.info(pids);
        log.info(infos);

        for (int i=0;i<titles.length;i++){
            log.info(pids[i]);
            Catalog category= new Catalog();
            category.setName(titles[i]);
            category.setParent(Integer.parseInt(pids[i]));
            category.setDescription(infos[i]);

            list.add(category);
        }
        categroryBiz.add(list);
        response.sendRedirect("list.do");
    }
    //      /admin/Categrory/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        categroryBiz.remove(id);
        response.sendRedirect("list.do");
    }

}

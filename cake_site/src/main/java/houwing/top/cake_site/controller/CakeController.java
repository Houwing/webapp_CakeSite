package houwing.top.cake_site.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import houwing.top.cake_site.biz.CakeBiz;
import houwing.top.cake_site.biz.CatalogBiz;
import houwing.top.cake_site.biz.impl.CakeBizImpl;
import houwing.top.cake_site.biz.impl.CatalogBizImpl;
import houwing.top.cake_site.entity.Cake;
import houwing.top.cake_site.entity.Catalog;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CakeController {
    Logger log=Logger.getLogger(CakeController.class);
    private CakeBiz cakeBiz=new CakeBizImpl();
    private CatalogBiz catalogBiz=new CatalogBizImpl();


    // /admin/Cake/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum=request.getParameter("pageNum");
        if(pageNum==null)
            pageNum="1";

        //执行这条语句后，mybatis就会查询前20条信息，因此list里面就是20条信息
        PageHelper.startPage(Integer.parseInt(pageNum),20);
        List<Cake> list = cakeBiz.getAll();
        PageInfo pageInfo=PageInfo.of(list);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_list.jsp").forward(request,response);
    }
    // /admin/Cake/toAdd.do 打开添加页面
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_add.jsp").forward(request,response);
    }
    // /admin/Cake/add.do   用户提交
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        Cake cake = builderCake(request);
        cakeBiz.add(cake);
        response.sendRedirect("/admin/Cake/list.do");
    }
    // /admin/Cake/toEdit
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        int id=Integer.parseInt(request.getParameter("id"));
        Cake cake=cakeBiz.get(id);
        request.setAttribute("cake",cake);
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_edit.jsp").forward(request,response);
    }
    // /admin/Cake/edit
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        Cake cake= builderCake(request);
        cakeBiz.edit(cake);
        response.sendRedirect("/admin/Cake/list.do");
    }

    private Cake builderCake(HttpServletRequest request) throws UnsupportedEncodingException, FileUploadException {
        Cake cake =new Cake();
        //表单设置了编码类型multipart/form-data 不进行编码，使用request.getParameter是接收不到信息得的
        //只能进行解析流的方法
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        List<FileItem> list=upload.parseRequest(request);
        for (FileItem item:list){
            if(item.isFormField()){
                if(item.getFieldName().equals("brand"))
                    cake.setBrand(item.getString("UTF-8"));
                if(item.getFieldName().equals("cakename"))
                    cake.setCakename(item.getString("UTF-8"));
                if(item.getFieldName().equals("status"))
                    cake.setStatus(item.getString("UTF-8"));
                if(item.getFieldName().equals("cid"))
                    cake.setCategory(Integer.parseInt(item.getString("UTF-8")));
                if(item.getFieldName().equals("taste"))
                    cake.setTaste(item.getString("UTF-8"));
                if(item.getFieldName().equals("sweetness"))
                    cake.setSweet(Integer.parseInt(item.getString("UTF-8")));
                if(item.getFieldName().equals("price"))
                    cake.setPrice(Double.parseDouble(item.getString("UTF-8")));
                if(item.getFieldName().equals("weight"))
                    cake.setWeight(Double.parseDouble(item.getString("UTF-8")));
                if(item.getFieldName().equals("size"))
                    cake.setSize(Integer.parseInt(item.getString("UTF-8")));
                if(item.getFieldName().equals("material"))
                    cake.setIngredients(item.getString("UTF-8"));
                if(item.getFieldName().equals("id"))
                    cake.setId(Integer.parseInt(item.getString("UTF-8")));
                if(item.getFieldName().equals("image")&&cake.getImage()==null)
                    cake.setImage(item.getString("UTF-8"));
            }else {
                if(item.getFieldName().equals("image")){
                    if(item.getSize()<=100) continue;
                    String rootPath=request.getServletContext().getRealPath("/");
                    String path=item.getName();
                    String type=".jpg";
                    if(path.indexOf(".")!=-1){
                        type=path.substring(path.lastIndexOf("."));
                    }
                    path="/download/images/"+System.currentTimeMillis()+type;
                    try {
                        item.write(new File(rootPath+path));
                        cake.setImage(path);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return cake;
    }
    // /admin/Cake/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        int id=Integer.parseInt(request.getParameter("id"));
        cakeBiz.remove(id);
        response.sendRedirect("/list.do");
    }
    // /admin/Cake/detail.do
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        int id=Integer.parseInt(request.getParameter("id"));
        Cake cake=cakeBiz.get(id);
        request.setAttribute("cake",cake);
        request.getRequestDispatcher("/WEB-INF/pages/admin/cake_detail.jsp").forward(request,response);
    }
}

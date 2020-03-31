package houwing.top.cake_site.global;

import org.apache.ibatis.annotations.Select;
import sun.security.util.ManifestEntryVerifier;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GlobalController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * .do
        * /login.do             DefaultController login
        * /cake/detail.do       CakeController    detail
        * /admin/cake/add.do    CakeController    add
        * */

        String path=request.getServletPath();
        //截取path
        if(path.indexOf("/admin")!=-1){
          path=path.substring(7);
        }else if(path.indexOf("/my")!=-1){
            path=path.substring(4);

        }else {
            path=path.substring(1);
        }
        /*
         * .do
         * login.do             DefaultController login
         * cake/detail.do       CakeController    detail
         * cake/add.do          CakeController    add
         * */
        //判断是否有模块名
        int index=path.indexOf("/");
        String clazzName=null;
        String methoName=null;
        if(index!=-1){
             clazzName="houwing.top.cake_site.controller."+path.substring(0,index)+"Controller";
             methoName=path.substring(index+1,path.indexOf(".do"));
        }else {
            clazzName="houwing.top.cake_site.controller.DefaultController";
            methoName=path.substring(0,path.indexOf(".do"));
        }

        //通过反射执行方法
        try {
            Class clazz=Class.forName(clazzName);
            Object object=clazz.newInstance();
            Method method=clazz.getMethod(methoName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(object,request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            Throwable throwable = e.getTargetException();
            throwable.printStackTrace();
        }

    }
}

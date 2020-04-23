package Servlet;

import Entity.Account;
import Service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet" ,urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        //前端拿值
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        //封装
        Account account = new Account(uname,upwd);
        AccountService accountService = new AccountService();
        //调AccountService的登录功能
        int result = accountService.login(account);

        if(result==-1){//        -1:账号不存在
            response.getWriter().print("账号不存在!");
        }
        if(result==0){//         0:账号存在,但是密码错误
            response.getWriter().print("密码错误!");
        }
        if(result==1){//         1:账号密码都正确,登陆成功
            response.getWriter().print("登陆成功");
            //这里再跳转到后台管理页面
        }


    }
}

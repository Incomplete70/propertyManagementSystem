package java.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.Service.HouseHolderService;
import java.io.IOException;

import java.Entity.HouseHolder;

@WebServlet(name = "QueryHouseHolderByNumberServlet",urlPatterns = "/QueryHouseHolderByNumberServlet")
public class QueryHouseHolderByNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        int snumber = Integer.parseInt(request.getParameter("snumber"));
        HouseHolderService houseHolderService = new HouseHolderService();
        HouseHolder houseHolder = houseHolderService.queryHouseHolderByNumber(snumber);
        System.out.println(houseHolder);
        //将此人的数据打印到页面显示
        //response.getWriter().print(houseHolder);

        request.setAttribute("houseHolder", houseHolder); //把查询到的户主信息 放到request域里面

        request.getRequestDispatcher("studentInfo.jsp").forward(request,response);//请求转发跳转


    }
}

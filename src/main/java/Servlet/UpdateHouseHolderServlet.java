package Servlet;

import Entity.HouseHolder;
import Service.HouseHolderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdateHouseHolderServlet",urlPatterns = "/UpdateHouseHolderServlet")
public class UpdateHouseHolderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        //获取待修改的人的户号
        int houseHolderNumber = Integer.parseInt(request.getParameter("houseHolderNumber"));

        //获取要修改的内容 前端拿值 改页面注意改这里 Parameter匹配
        String houseHolderName = request.getParameter("houseHolderName");
        int houseHolderId = Integer.parseInt(request.getParameter("houseHolderId"));
        double waterBalance = Integer.parseInt(request.getParameter("waterBalance"));
        double electricityBalance = Integer.parseInt(request.getParameter("electricityBalance"));


        //将修改后的内容封装起来
        HouseHolder houseHolder = new HouseHolder(houseHolderName,houseHolderId,waterBalance,electricityBalance);

        //调HouseHolderService 修改信息.
        HouseHolderService houseHolderService = new HouseHolderService();
        boolean result = houseHolderService.updateHouseHolderByNumber(houseHolderNumber, houseHolder);
        //处理结果
        if(result){
            response.getWriter().print("修改成功!");
            response.sendRedirect("QueryAllHouseHoldersServlet");//再次跳回查询全部Servlet
        }else {
            response.getWriter().print("修改失败!");
        }
    }
}

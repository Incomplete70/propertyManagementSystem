package java.Servlet;

import java.Entity.HouseHolder;
import java.Service.HouseHolderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddHouseHolderServlet" ,urlPatterns = "/AddHouseHolderServlet")
public class AddHouseHolderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理编码
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        System.out.println("doget调用");

        int houseHolderNumber = Integer.parseInt(request.getParameter("houseHolderNumber"));
        String houseHolderName = request.getParameter("houseHolderName");
        int houseHolderId = Integer.parseInt(request.getParameter("houseHolderId"));


        HouseHolder houseHolder = new HouseHolder(houseHolderNumber,houseHolderName,houseHolderId);

        HouseHolderService houseHolderService = new HouseHolderService();
        boolean result = houseHolderService.addHouseHolder(houseHolder);
        PrintWriter out = response.getWriter();

        if(result){//如果增加成功 给request域添加成功数据
            request.setAttribute("success","success");
        }else { //如果增加失败 给request域添加失败数据
            request.setAttribute("error","addError");
        }
            request.getRequestDispatcher("QueryAllHouseHoldersServlet").forward(request,response);
}
}

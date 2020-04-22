package java.Servlet;

import java.Entity.HouseHolder;
import java.Service.HouseHolderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllHouseHoldersServlet",urlPatterns = "/QueryAllHouseHoldersServlet")
public class QueryAllHouseHoldersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        //
        HouseHolderService houseHolderService = new HouseHolderService();
        List<HouseHolder> houseHolders = houseHolderService.queryAllHouseHolders();

        request.setAttribute("houseHolders", houseHolders);
        //因为request域中有数据,因此需要通过请求转发的方式跳转(重定向会丢失request域)
        //pageContext<request<session<application
        //request.getRequestDispatcher("queryResult.jsp").forward(request,response);
    }
}

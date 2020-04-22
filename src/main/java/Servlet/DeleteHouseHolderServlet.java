package java.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.Service.HouseHolderService;
import java.io.IOException;

@WebServlet(name = "DeleteHouseHolderServlet" ,urlPatterns = "/DeleteHouseHolderServlet")
public class DeleteHouseHolderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    //根据学号删除
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        //接收前端传来的户号
        int houseHolderNumber = Integer.parseInt(request.getParameter("houseHolderNumber"));

        HouseHolderService houseHolderService = new HouseHolderService();

        boolean result = houseHolderService.deleteHouseHolderByNumber(houseHolderNumber);
        //处理结果
        if(result){
            response.getWriter().print("删除成功");
            response.sendRedirect("QueryAllHouseHoldersServlet");//删除完之后再查询一次,查询后会再跳到queryResult.jsp
        }else {
            response.getWriter().print("删除失败!");
        }
    }
}

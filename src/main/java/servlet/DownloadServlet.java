package servlet;

import com.alibaba.excel.EasyExcel;
import entity.Card;
import service.CardService;
import service.impl.CardServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/downloadExcel")
public class DownloadServlet extends HttpServlet {

    CardService service = new CardServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String filename = URLEncoder.encode("名片信息", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + filename + ".xlsx");
        List<Card> cardList = service.SelectAll();
        EasyExcel.write(response.getOutputStream(), Card.class)
                .sheet("名片信息")
                .doWrite(cardList);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

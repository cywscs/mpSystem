package servlet;

import entity.Card;
import service.CardService;
import service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/modify2")
public class ModifyServlet2 extends HttpServlet {

    CardService service = new CardServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");

        Card card = new Card();
        card.setId(id);
        card.setName(name);
        card.setAge(age);
        card.setSex(sex);
        card.setEmail(email);
        service.UpdateOne(card);
        resp.sendRedirect("/card");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

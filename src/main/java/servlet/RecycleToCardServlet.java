package servlet;

import entity.Card;
import entity.Recycle;
import service.CardService;
import service.RecycleService;
import service.impl.CardServiceImpl;
import service.impl.RecycleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recycleToCard")
public class RecycleToCardServlet extends HttpServlet {

    RecycleService recycleService = new RecycleServiceImpl();
    CardService cardService = new CardServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Recycle recycle = recycleService.SelectById(id);
        Card card = new Card();
        card.setName(recycle.getName());
        card.setAge(recycle.getAge());
        card.setSex(recycle.getSex());
        card.setUsername(recycle.getUsername());
        card.setPassword(recycle.getPassword());
        card.setEmail(recycle.getEmail());
        cardService.AddOne(card);
        recycleService.DeleteOne(id);
        resp.sendRedirect("/recycle");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

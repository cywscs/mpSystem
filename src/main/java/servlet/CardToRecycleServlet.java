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


@WebServlet("/cardToRecycle")
public class CardToRecycleServlet extends HttpServlet {

    CardService cardService = new CardServiceImpl();
    RecycleService recycleService = new RecycleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Card card = cardService.SelectById(id);
        Recycle recycle = new Recycle();
        recycle.setName(card.getName());
        recycle.setAge(card.getAge());
        recycle.setSex(card.getSex());
        recycle.setUsername(card.getUsername());
        recycle.setPassword(card.getPassword());
        recycle.setEmail(card.getEmail());
        recycleService.AddOne(recycle);
        cardService.DeleteOne(id);
        resp.sendRedirect("/card");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

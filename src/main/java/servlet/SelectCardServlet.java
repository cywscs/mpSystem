package servlet;

import entity.Card;
import entity.User;
import service.CardService;
import service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@WebServlet("/card")
public class SelectCardServlet extends HttpServlet {

    private CardService cardService = new CardServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Card> cards;
        if(Objects.equals(user.getUsername(), "admin")){
            cards = cardService.SelectAll();
        }
        else{
            cards = cardService.SelectByUsername(user.getUsername());
        }
        req.setAttribute("cards", cards);
        req.getRequestDispatcher("/card.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}





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


@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private CardService service = new CardServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        Card card = new Card();
        card.setName(name);
        card.setAge(age);
        card.setSex(sex);
        card.setUsername(user.getUsername());
        card.setPassword(user.getPassword());
        card.setEmail(email);
        service.AddOne(card);
        resp.sendRedirect("/card");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

package servlet;

import entity.Card;
import entity.Recycle;
import entity.User;
import mapper.RecycleMapper;
import service.RecycleService;
import service.impl.RecycleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/recycle")
public class RecycleServlet extends HttpServlet {

    RecycleService recycleService = new RecycleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Recycle> recycles;
        if(Objects.equals(user.getUsername(), "admin")){
            recycles = recycleService.SelectAll();
        }
        else{
            recycles = recycleService.SelectByUsername(user.getUsername());
        }
        req.setAttribute("recycles", recycles);
        req.getRequestDispatcher("/recycle.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

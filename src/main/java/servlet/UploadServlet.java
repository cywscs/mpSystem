package servlet;

import com.alibaba.excel.EasyExcel;
import entity.Card;
import listener.ExcelListener;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/uploadExcel")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = fileUpload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (!fileItem.isFormField()) {
                    InputStream inputStream = fileItem.getInputStream();
                    EasyExcel.read(inputStream, Card.class, new ExcelListener())
                            .sheet().doRead();
                }
            }
            response.sendRedirect("/card");
        } catch (FileUploadException e) {
            String message = "上传失败";
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

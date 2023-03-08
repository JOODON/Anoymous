package chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChatSubmitServlet", value = "/chatSubmitServlet")
public class ChatSubmitServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String chatName=request.getParameter("chatName");
        String chatContent=request.getParameter("chatContent");

        if (chatName == null || chatContent == null || chatName.equals("") || chatContent.equals("")){
            response.getWriter().write("0");
            //오류가 날 경우에는 0이라는 값을 통해서 리턴해주도록 함
        }
        else {
            response.getWriter().write(new ChatDAO().submit(chatName,chatContent)+"");
        }
    }

}

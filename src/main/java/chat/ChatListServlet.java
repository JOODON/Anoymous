package chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ChatListServlet", value = "/ChatListServlet")
public class ChatListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String listType=request.getParameter("listType");
        if (listType == null || listType.equals("")){
            response.getWriter().write("");
        }
        else if (listType.equals("today")){
            response.getWriter().write(getToday());
        }
    }
    public String getToday(){
        StringBuffer result=new StringBuffer("");
        result.append("{\"result\":[");
        ChatDAO chatDAO=new ChatDAO();
        ArrayList<Chat> chatList =chatDAO.getChatList(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        for (int i=0; i<chatList.size();i++){
            result.append("[{\"value\":\"" + chatList.get(i).getChatName()+"\"},");
            result.append("{\"value\":\"" + chatList.get(i).getChatContent()+"\"},");
            result.append("{\"value\":\"" +chatList.get(i).getChatTime()+"\"}],");
            if ( i != chatList.size()-1){
                result.append(",");
            }
            result.append("]}");
        }
        return result.toString();
    }
}

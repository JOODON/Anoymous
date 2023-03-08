package chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class chatDaoTest {
    public static void main(String[] args) {

        ChatDAO chatDAO=new ChatDAO();
        String a=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        chatDAO.getChatList(a);

    }
}

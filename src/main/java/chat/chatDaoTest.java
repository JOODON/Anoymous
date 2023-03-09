package chat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class chatDaoTest {
    public static void main(String[] args) {

        ChatDAO chatDAO=new ChatDAO();
        Date date=new Date();
        System.out.println(chatDAO.getChatList("2023-3-9"));


    }
}

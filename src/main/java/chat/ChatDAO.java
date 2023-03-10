package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChatDAO {

    private Connection conn;

    public ChatDAO(){
        try {
            String dbUrl="jdbc:mysql://localhost:3307/anonymouschat";
            String dbId="root";
            String dbPassword="kkjjss103@";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(dbUrl,dbId,dbPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Chat> getChatList(String nowTime){

        ArrayList<Chat> chatList=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * FROM CHAT WHERE chatTime > ? order By chatTime";
        try {

            ps=conn.prepareStatement(sql);
            ps.setString(1,nowTime);
            rs=ps.executeQuery();

            chatList=new ArrayList<>();
            while (rs.next()){

                Chat chat=new Chat();
                chat.setChatId(rs.getInt("chatId"));
                chat.setChatName(rs.getString("chatName"));
                chat.setChatContent(rs.getString("chatContent").replaceAll(" ","&nbsp;")
                        .replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\n","</br>"));

                chat.setChatTime(rs.getString("chatTime"));
                chatList.add(chat);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {

                if (rs != null) rs.close();
                if (ps != null) ps.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return chatList;
    }

    public ArrayList<Chat> getChatListByRecent(int number){

        ArrayList<Chat> chatList=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * FROM CHAT WHERE chatId >(SELECT MAX(chatId) - ? from chat) ORDER BY chatTime";

        try {

            ps=conn.prepareStatement(sql);
            ps.setInt(1,number);
            rs=ps.executeQuery();

            chatList=new ArrayList<>();
            while (rs.next()){

                Chat chat=new Chat();
                chat.setChatId(rs.getInt("chatId"));
                chat.setChatName(rs.getString("chatName"));
                chat.setChatContent(rs.getString("chatContent").replaceAll(" ","&nbsp;")
                        .replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\n","</br>"));

                chat.setChatTime(rs.getString("chatTime"));
                chatList.add(chat);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {

                if (rs != null) rs.close();
                if (ps != null) ps.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return chatList;
    }

    public ArrayList<Chat> getChatListByRecent(String chatID){

        ArrayList<Chat> chatList=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * FROM CHAT WHERE chatID > ? order By chatTime";
        try {

            ps=conn.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(chatID));
            rs=ps.executeQuery();

            chatList=new ArrayList<>();
            while (rs.next()){

                Chat chat=new Chat();
                chat.setChatId(rs.getInt("chatId"));
                chat.setChatName(rs.getString("chatName"));
                chat.setChatContent(rs.getString("chatContent").replaceAll(" ","&nbsp;")
                        .replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\n","</br>"));

                chat.setChatTime(rs.getString("chatTime"));
                chatList.add(chat);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {

                if (rs != null) rs.close();
                if (ps != null) ps.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return chatList;
    }

    public int submit(String chatName,String chatContent){
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="INSERT INTO chat VALUES (Null ,?,?,now())";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,chatName);
            ps.setString(2,chatContent);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{

                if (rs != null) rs.close();
                if (ps != null) ps.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
}
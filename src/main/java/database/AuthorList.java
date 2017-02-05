package database;

import beans.Author;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Prokop on 19.06.2016.
 */
public class AuthorList implements Serializable {

    private ArrayList<Author> list = new ArrayList<Author>();

    private ArrayList<Author> getAuthors(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM author ORDER BY fio");
            while (rs.next()){
                list.add(new Author(rs.getString(2)));
            }
        } catch (SQLException e) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE,null,e);
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) {
                    connection.close();
                }
                if(statement!=null) {
                    statement.close();
                }
                if(rs!=null) {
                    rs.close();
                }
            }catch (SQLException e1){
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE,null,e1);
                e1.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<Author> getAuthorsList(){
        if(!list.isEmpty()){
            return list;
        }else{
            return getAuthors();
        }
    }
}

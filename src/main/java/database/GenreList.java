package database;

import beans.Author;
import beans.Genre;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Prokop on 30.06.2016.
 */
public class GenreList implements Serializable {
    private ArrayList<Genre> list = new ArrayList<Genre>();

    private ArrayList<Genre> getGenre(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM genre ORDER BY name");
            while (rs.next()){
                list.add(new Genre(rs.getString(2), rs.getLong(1)));
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

    public ArrayList<Genre> getGenreList(){
        if(!list.isEmpty()){
            return list;
        }else{
            return getGenre();
        }
    }
}

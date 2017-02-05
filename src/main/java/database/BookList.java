package database;

import beans.Author;
import beans.Book;
import beans.Genre;
import enums.SearchType;

import javax.swing.*;
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
public class BookList implements Serializable {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    private ArrayList<Book> getBooks(String str) {

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(str);
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPublishDate(rs.getInt("publish_year"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage(rs.getBytes("image"));
                book.setUrl(rs.getString("url"));
                bookList.add(book);
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
        return bookList;
    }

//    public ArrayList<Book> getAllBooks() {
//        if (!bookList.isEmpty()) {
//            return bookList;
//        } else {
//            return getBooks("SELECT * FROM book ORDER BY name");
//        }
//    }

    public ArrayList<Book> getBooksByGenre(long id) {;
        if (id == 0) {
            return getAllBooks();
        } else {
            return getBooks("select b.id,b.name,b.isbn,b.page_count,b.publish_year,b.url, p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                    + "inner join author a on b.author_id=a.id "
                    + "inner join genre g on b.genre_id=g.id "
                    + "inner join publisher p on b.publisher_id=p.id "
                    + "where genre_id=" + id + " order by b.name "
                    + "limit 0,5");
        }
    }

    public ArrayList<Book> getAllBooks() {
        return getBooks("select b.id,b.name,b.isbn,b.page_count,b.publish_year,b.url, p.name as publisher, "
                + "a.fio as author, g.name as genre, b.image from book b inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id inner join publisher p on b.publisher_id=p.id order by b.name");
    }

    public ArrayList<Book> getBooksByLetter(String letter) {;
        return getBooks("select b.id,b.name,b.isbn,b.page_count,b.publish_year, b.url,p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id "
                + "where substr(b.name,1,1)='" + letter + "' order by b.name "
                + "limit 0,5");

    }

    public ArrayList<Book> getBooksBySearch(String searchStr, SearchType type) {
        StringBuilder sql = new StringBuilder("select b.id,b.name,b.isbn,b.page_count,b.publish_year, b.url,p.name as publisher, a.fio as author, g.name as genre, b.image from book b "
                + "inner join author a on b.author_id=a.id "
                + "inner join genre g on b.genre_id=g.id "
                + "inner join publisher p on b.publisher_id=p.id ");

        if (type == SearchType.AUTHOR) {
            sql.append("where lower(a.fio) like '%" + searchStr.toLowerCase() + "%' order by b.name ");

        } else if (type == SearchType.TITLE) {
            sql.append("where lower(b.name) like '%" + searchStr.toLowerCase() + "%' order by b.name ");
        }
        sql.append("limit 0,5");


        return getBooks(sql.toString());


    }
}

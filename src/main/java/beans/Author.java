package beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Prokop on 19.06.2016.
 */
public class Author implements Serializable{
//    private int id;
//    private String name;
//    private Date dateBirth;
//
//    public Author(){
//
//    }
//    public Author(String name) {
//        this.name = name;
//    }
//
//    public Date getDateBirth() {
//        return dateBirth;
//    }
//
//    public void setDateBirth(Date dateBirth) {
//        this.dateBirth = dateBirth;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Author[" +
//                "name='" + name + '\'' +
//                ']';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Author author = (Author) o;
//
//        if (id != author.id) return false;
//        return name.equals(author.name);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + name.hashCode();
//        return result;
//    }

    private String name;

    public Author(){

    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}

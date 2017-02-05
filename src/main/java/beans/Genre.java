package beans;

import java.io.Serializable;

/**
 * Created by Prokop on 19.06.2016.
 */
public class Genre implements Serializable {
//    private int id;
//    private String genre;
//
//    public Genre(){
//    }
//
//    public Genre(String genre) {
//        this.genre = genre;
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
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    @Override
//    public String toString() {
//        return "Genre{" +
//                "genre='" + genre + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Genre genre1 = (Genre) o;
//
//        if (id != genre1.id) return false;
//        return genre.equals(genre1.genre);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + genre.hashCode();
//        return result;
//    }

    private String name;
    private long id;
    public Genre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Genre(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

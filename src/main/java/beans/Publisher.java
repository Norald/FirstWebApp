package beans;

import java.io.Serializable;

/**
 * Created by Prokop on 19.06.2016.
 */
public class Publisher implements Serializable{
    private int id;
    private String publisher;

    public Publisher(){

    }

    public Publisher(String publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher1 = (Publisher) o;

        if (id != publisher1.id) return false;
        return publisher.equals(publisher1.publisher);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + publisher.hashCode();
        return result;
    }
}

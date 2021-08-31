package observer;
import java.util.ArrayList;

public class Customer implements Observer{
    private Subject subject;
    private String firstName;
    private String lastName;
    private ArrayList<Book> wishList;

    public Customer(Subject subject, String firstName, String lastName) {

    }

    public void update(Book book) {

    }

    public void display() {
        
    }
}

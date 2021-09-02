package observer;
import java.util.LinkedList;
import java.util.Queue;

public class Store implements Observer {
    private Subject subject;
    private String title;
    private Queue<Book> bestSellers;
    
    public Store(Subject subject) {
        this.subject = subject;  
        this.bestSellers = new LinkedList<Book>();
        subject.registerObserver(this);    
    }

    public void update(Book book) {
        this.bestSellers.add(book);
        if(this.bestSellers.size()>5) 
            this.bestSellers.remove();
    }

    public void display() {
        System.out.println("Top 5 Best Sellers:");
        for(Book book: bestSellers) {
            System.out.println(book);
        }
    }
}

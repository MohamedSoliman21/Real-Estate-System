package Classes;

public class Booking {
    
    private int BookingID;
    private String BookType;
    private String BookDescription;
    private int BookPrice;
    
    public Booking(int BookID, String BookType, String BookDescription, int BookPrice) {
        this.BookingID = BookID;
        this.BookType = BookType;
        this.BookDescription = BookDescription;
        this.BookPrice = BookPrice;
    }
    public int getBookID() {
        return BookingID;
    }
    public void setBookID(int BookID){
        this.BookingID = BookID;
    }
    
    public String getBookType() {
        return BookType;
    }
    public void setBookType(String BookType){
        this.BookType = BookType;
    }
    public String getBookDescription() {
        return BookDescription;
    }
    public void setBookDescription(String BookDescription){
        this.BookDescription = BookDescription;
    }
        public int getBookPrice() {
        return BookPrice;
    }
    public void setBookPrice(int BookPrice){
        this.BookPrice = BookPrice;
    }
}

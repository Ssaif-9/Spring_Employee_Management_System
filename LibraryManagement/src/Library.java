import java.util.List;

public class Library {
    private String name ;
    private String address ;
    private String phone ;
    private List<Book> books ;

    public Library() {}

     public Library(String name, String address, String phone, List<Book> books) {
         this.name = name;
         this.address = address;
         this.phone = phone;
         this.books = books;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}

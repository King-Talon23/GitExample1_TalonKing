package TK;

public class book {
    private String title;
    private String author;
    private long isbn;
    private int pageCount;

    public book(String title, String author, long isbn, int pageCount) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pageCount = pageCount;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getIsbn() {
        return isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setPageCount(int count) {
        this.pageCount =  count;
    }

}
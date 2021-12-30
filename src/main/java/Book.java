public class Book {

    private String title;
    private String author;
    private int year;
    private boolean availability;

    public Book(String title, String author, int year, boolean availability) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return  " Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Year=" + year;

    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BookHelper {

    public static List<Book> loadBooksFromFile(Path p) {
        List<Book> bookList = new ArrayList<>();
        Book book;
        try {
            for(String line : Files.readAllLines(p)) {
                String[] tab = line.split(",");
                book = new Book(tab[0], tab[1], Integer.parseInt(tab[2]), Boolean.parseBoolean(tab[3]));
                bookList.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static void saveBookToFile (Path p, List<Book> books){
        String[] elements = new String[4];
        StringBuilder sb;
        ArrayList<String> lines = new ArrayList<>();
        for (Book book : books) {
            sb = new StringBuilder();
            elements[0] = book.getTitle()+",";
            elements[1] = book.getAuthor()+",";
            elements[2] = String.valueOf(book.getYear())+",";
            elements[3] = String.valueOf(book.isAvailability())+"";
            for (String element : elements) {
                sb.append(element);
            }
            lines.add(sb.toString());
        }
        try {
            Files.write(p, lines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

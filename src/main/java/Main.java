import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Path path = Paths.get("/Volumes/dev/java/Book_rental_console/books.txt");
    public static List<Book> bookList = BookHelper.loadBooksFromFile(path);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();



    }

    public static void printMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------------------------------");
            System.out.println("1 - dodawanie ksiazki do bazy");
            System.out.println("2 - pokaz liste ksiazek");
            System.out.println("3 - pokaz wolne pozycje");
            System.out.println("4 - pokaz zajete pozycje");
            System.out.println("5 - wypozyczenie ksiazki");
            System.out.println("6 - oddanie ksiazki");
            System.out.println("7 - zakoncz");
            System.out.println("------------------------------");
            System.out.println("Wprowadz numer: ");
            choice = scanner.nextInt();
            parseChoice(choice);

        }while(choice != 7);
    }

    public static void parseChoice(int choice) {
        switch (choice){
            case 1: {
                addBook();
                break;
            }
            case 2: {
                showBooks();
                break;
            }
            case 3: {
                showAvailableBooks();
                break;
            }
            case 4: {
                showNotAvailableBooks();
                break;
            }
            case 5: {
                rentBook();
                break;
            }
            case 6: {
                returnBook();
                break;
            }
            case 7: {
                BookHelper.saveBookToFile(path, bookList);
                System.out.println(ConsoleColors.RED + "KONIEC!" + ConsoleColors.RESET);
                break;
            }
            default : {
                System.out.println("Niepoprawna komenda");
            }
        }
    }

    private static void showNotAvailableBooks() {
        int amountofNotAvailableBooks = 0;
        for (Book book : bookList) {
            if(!book.isAvailability()){
                amountofNotAvailableBooks++;
            }
        }
        System.out.println("Liczba wypozyczonych ksiazek w bazie: " + amountofNotAvailableBooks);
        int counter = 0;
        for (Book book : bookList) {
            if(!book.isAvailability()){
                if(counter < 9){
                    System.out.print("0");
                }
                System.out.println(++counter + "| " + ConsoleColors.GREEN + book + ConsoleColors.RESET);
            }
        }
    }

    private static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytul ksiazki ktora chcesz zwrocic: ");
        String title = scanner.nextLine();
        for (Book book : bookList) {
            if(book.getTitle().equalsIgnoreCase(title) && !book.isAvailability()) {
                book.setAvailability(true);
            }
        }
        System.out.println(ConsoleColors.BLUE + "Ksiazka zostala zwrocona: " + ConsoleColors.RESET);
    }

    private static void rentBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytul ksiazki z listy ktora chcesz wypozyczyc: ");
        String title = scanner.nextLine();
        for (Book book : bookList) {
            if(book.getTitle().equalsIgnoreCase(title) && book.isAvailability()) {
               book.setAvailability(false);
            }
        }
        System.out.println(ConsoleColors.BLUE + "Mozesz zabrac ksiazke" + ConsoleColors.RESET);
    }

    private static void showAvailableBooks() {
        int amountofAvailableBooks = 0;
        for (Book book : bookList) {
            if(book.isAvailability()){
                amountofAvailableBooks++;
            }
        }
        System.out.println("Liczba pozycji w bazie: " + amountofAvailableBooks);
        int counter = 0;
        for (Book book : bookList) {
            if(book.isAvailability()){
                if(counter < 9){
                    System.out.print("0");
                }
                System.out.println(++counter + "| " + ConsoleColors.GREEN + book + ConsoleColors.RESET);
            }
        }
    }

    private static void showBooks() {
        int amountOfbooks = 0;
        for (Book s : bookList) {
            amountOfbooks++;
        }
        System.out.println("Liczba pozycji w bazie: " + amountOfbooks);
        for (int i = 0; i < bookList.size(); i++) {
            if (i < 9){
                System.out.print("0");
            }
            System.out.println(i + 1 + "| " + ConsoleColors.BLUE + bookList.get(i) + ConsoleColors.RESET);
        }
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        String title;
        String author;
        int year;
        boolean availability;
        System.out.println("Podaj tytul: ");
        title = scanner.nextLine();
        System.out.println("Podaj autora: ");
        author = scanner.nextLine();
        System.out.println("Podaj rok wydania: ");
        year = Integer.parseInt(scanner.nextLine());
        bookList.add(new Book(title, author, year, true));
    }


}

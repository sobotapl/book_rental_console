import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> bookList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();



    }

    public static void printMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------------------------------");
            System.out.println("1 - dodawanie ksiazki");
            System.out.println("2 - wypozyczenie ksiazki");
            System.out.println("3 - oddawanie ksiazki");
            System.out.println("4 - wyswietl wolne pozycje");
            System.out.println("5 - zakoncz");
            System.out.println("------------------------------");
            System.out.println("Wprowadz numer: ");
            choice = scanner.nextInt();
            parseChoice(choice);

        }while(choice != 4);
    }

    public static void parseChoice(int choice) {
        switch (choice){
            case 1: {
                addBook();
                break;
            }
            case 2: {
                showFreeBooks();
                break;
            }
            case 3: {
                //rentBook();
                break;
            }
            case 4: {
                //bringBackBook();
                break;
            }
            case 5: {

                break;
            }
            default : {
                System.out.println("Niepoprawna komenda");
            }
        }
    }

    private static void showFreeBooks() {
        String[] tab = bookList.toArray(new String[0]);
        int amountOfbooks = 0;
        for (String s : bookList) {
            amountOfbooks++;
        }
        System.out.println("Liczba pozycji w bazie: " + amountOfbooks);
        for (int i = 0; i < tab.length; i++) {
            System.out.println(i+1 + ": " + tab[i]);
        }
    }

    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadz tytul ksiazki: ");
        String title = scanner.nextLine();
        bookList.add(title);
    }


}

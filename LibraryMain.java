import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

interface YesLim {
    int limitPass = 3;;
}

public class LibraryMain implements YesLim {

    private static int limit;
    static private int amountBook;
    private static int count = 0;

    private static ArrayList<Book> book = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Welcome pals");
        ReadFile r = new ReadFile();
        openFile();
        int user;

        String name, phoneNo, matric, dorm;
        int bookNo, choose;

        Random rand = new Random();
        int randNo = rand.nextInt(1000);
        System.out.print("Press " + randNo + " to login -> ");
        user = Integer.parseInt(input.nextLine());

        if (user == randNo) {
            System.out.println("Authentication Successful");
            System.out.print("Name: ");
            name = input.nextLine();
            System.out.print("Phone: ");
            phoneNo = input.nextLine();
            System.out.print("Matric: ");
            matric = input.nextLine();
            System.out.print("Dormitory address: ");
            dorm = input.nextLine();
            Dormitory d1 = new Dormitory(dorm);
            Student s1 = new Student(name, phoneNo, matric, d1);

            while (limit >= 0 && limit <= limitPass) {
                try {
                    System.out.printf("1. Borrow\n2. Return book\n3. Check profile\n4. Exit\nChoose -> ");
                    choose = Integer.parseInt(input.nextLine());

                    if (choose == 0 || choose > 4) {
                        System.out.println("Wrong input");
                    }
                    if (choose == 1 && limit < limitPass) {
                        System.out.println("\nList of the book are: ");
                        readFile();
                        System.out.print("which book you want to borrow: ");
                        bookNo = Integer.parseInt(input.nextLine());
                        if (bookNo == 1) {
                            s1.borrow(book.get(0));
                        } else if (bookNo == 2) {
                            s1.borrow(book.get(1));
                        } else if (bookNo == 3) {
                            s1.borrow(book.get(2));
                        }
                        System.out.println(s1);
                        limit++;
                    } else if (choose == 1 && limit == 3)
                        System.out.println("You have reach the limit, return the book first then you can borrow again");

                    else if (choose == 2) {
                        if (limit == 0) {
                            System.out.println("No book has been borrowed");
                        } else {
                            int noReturn;
                            System.out.print(
                                    "(press 0 if you want to return all books)\nWhich book you want to return -> ");
                            noReturn = Integer.parseInt(input.nextLine());

                            if (noReturn == 0) {
                                try {
                                    s1.deleteBook(0, 0);
                                } catch (Exception e) {
                                }
                                limit = 0;
                                System.out.println("All books returned, thank you for your cooperation");
                            } else if (noReturn > 0 && noReturn < 4) {
                                s1.deleteBook(noReturn, 1);
                                System.out.println("The book no." + noReturn + " has been returned");
                                limit--;
                            } else
                                System.out.println("Wrong input");
                        }
                    } else if (choose == 3) {
                        System.out.println(s1);
                    } else if (choose == 4) {
                        break;
                    } else if (choose >= limitPass) {
                        System.out.println("Wrong Input, you may be a robot");
                    }

                } catch (Exception e) {
                    System.out.println("no input intended");
                }
            }
        } else
            System.out.println("We asssume you as a robot, you can't login");
        System.out.println("Thank you for using me");
    }

    // input file manager
    static private Scanner x;
    static private Scanner y;

    public static void openFile() {
        try {
            x = new Scanner(new File("src/input.txt"));
        } catch (Exception e) {
            System.out.println("File Can't open");
        }
    }

    public static void readFile() {
        ArrayList just = new ArrayList();
        String title, author, isbn, yearRelease;

        int count = 0;
        while (x.hasNextLine()) {
            title = (x.nextLine());
            author = (x.nextLine());
            isbn = (x.nextLine());
            yearRelease = (x.nextLine());

            x.nextLine();
            book.add(new Book(title, author, isbn, yearRelease));
        }
        for (int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i));
        }
    }
}

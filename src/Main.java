import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Main {
    public static void main(String[] args) {
        phoneBookWork();
    }

    static void phoneBookWork (){
        PhoneBook phoneBook = new PhoneBook();
        boolean marcer = true;
        while (marcer){
        out.println("выберите желаемое действие ");
        out.println("1 добавить контакт");
        out.println("2 поиск контакта по имени");
        out.println("3 поиск контакта по номеру телефона");
        out.println("4 показать все контакты");
        out.println("любая другая цифра: выход");
        Scanner in = new Scanner(System.in);
        System.out.print("\n");
        int inComand = in.nextInt();
        switch (inComand) {
            case 1:
                phoneBook.addContact();
                break;
            case 2:
                phoneBook.searchForName();
                break;
            case 3:
                phoneBook.searchForNumber();
                break;
            case 4:
                phoneBook.getAll();
                break;
            default:
                out.println("добавленные данные не будут сохранены");
                out.println("ожидайте патчей с добавлением долговременной памяти");
                out.println("всего наилучшего");
                marcer = false;
                break;
        }
        }



    }



}


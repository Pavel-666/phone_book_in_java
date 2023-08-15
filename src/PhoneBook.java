import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, String> phoneBook = new HashMap<>();

    void addContact() {
        Scanner in = new Scanner(System.in);
        System.out.print("введите имя контакта ");
        String name = in.next();
        System.out.print("введите номер телефона контакта ");
        String phoneNumber = in.next();
        phoneBook.put(phoneNumber, name);
        System.out.println("контакт был добавлен");
    }

    void searchForNumber() {
        Scanner in = new Scanner(System.in);
        System.out.print("введите телефон для поиска ");
        String phoneNumber = in.next();
        System.out.println("данному номеру соответствует имя : " + phoneBook.get(phoneNumber));
    }

    void searchForName() {
        Scanner in = new Scanner(System.in);
        System.out.print("введите имя контакта ");
        String name = in.next();

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("для имени " + name + " были найдены следующие номера: ");
        for (Map.Entry<String, String> entry :
                phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append("; ");
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }


    private Map<Integer, String> printPhones = new HashMap<>();

    void getAll() {
        StringBuilder nameAndPhone;
        for (Map.Entry<String, String> searchName :
                phoneBook.entrySet()) {
            nameAndPhone = new StringBuilder();
            nameAndPhone.append(searchName.getValue());
            nameAndPhone.append("; номера: ");
            int count = 0;
            for (Map.Entry<String, String> dubleSearchName :
                    phoneBook.entrySet()) {
                //System.out.println(searchName.getValue());
                //System.out.println(dubleSearchName.getValue());
                if (searchName.getValue().equals(dubleSearchName.getValue())) {
                    nameAndPhone.append(dubleSearchName.getKey());
                    nameAndPhone.append(", ");
                    //phoneBook.remove(dubleSearchName.getKey());
                    count += 1;
                    //System.out.println(nameAndPhone);
                }
            }
            printPhones.put(count, nameAndPhone.toString());
        }

        Set<Integer> keys = printPhones.keySet();
        Integer[] array = keys.toArray(new Integer[keys.size()]);
        for (int i = array.length-1; i >= 0 ; i--) {
            System.out.println(printPhones.get(array[i]));
        }
    }
}

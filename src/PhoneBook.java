/*
Урок 5. Хранение и обработка данных ч2: множество коллекций Map
Формат сдачи: ссылка на подписанный git-проект.

Задание

Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут
повторяющиеся имена с разными телефонами, их необходимо считать,
как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов.
 */


import java.util.Map;
import java.util.*;

public class    PhoneBook {
    private Map<String, List<String>> contacts;
    public PhoneBook() {
        contacts = new TreeMap<>();
    }
    public void addContact(String name, String phone) {
        if (!contacts.containsKey(phone)) {
            contacts.put(phone, new ArrayList<>());
        }
        contacts.get(phone).add(name);
    }
    public List<String> getContacts(String phone) {
        return contacts.getOrDefault(phone, Collections.emptyList());
    }
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Любовь", "555-1234");
        phoneBook.addContact("Виктория", "555-5678");
        phoneBook.addContact("Святслав", "555-3435");
        for (String phone : phoneBook.contacts.keySet()) {
            List<String> names = phoneBook.getContacts(phone);
            Collections.sort(names);
            for (String name : names) {
                System.out.printf("%s: %s%n", phone, name);
            }
        }
    }
}





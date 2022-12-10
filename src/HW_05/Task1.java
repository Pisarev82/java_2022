package HW_05;

import java.util.*;

class Taska01 {
    /*
    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов
    Знаю что от меня ожидали реализацию с Ключам в виде телефона, но я захотел наоборот попробовать.
     */
    private Map<String, String> phoneBook = new HashMap<>();


    Taska01 (){
//        phoneBook.
        phoneBook.put("Иванов Иван ", " +7 9999 999 99 99, +7 646 644 64 46");
        phoneBook.put("Иванов Колян "," +7 9999 111 11 11, +7 646 222 222 22");
        phoneBook.put("Волчек Александр ", " +7 999 146 14 68, +7 646 222 22 22");
    }

    public String getContact (String name) {
        String contact = phoneBook.get(name);
        return contact;
    }

    public void createContact (String name, String phone) {
        // метод получения данных от пользователя в ТЗ не указан (консольный или другой)
        int sizeBefor = phoneBook.size();
        phoneBook.put(name, phone);
        if (sizeBefor != phoneBook.size()){
            System.out.println(phoneBook);
        } else {
            System.out.println("Контакт с именем " + name + " уже существует!!!");
        }
    }

    public void addPhone (String name, String phone) {
        if (phoneBook.get(name) != null) {
            phoneBook.put(name, phoneBook.get(name) + ", " + phone);
            System.out.println(phoneBook);
        } else {
            System.out.println("Контакт с именем " + name + " не существует!!!");
        }
    }

    public void solution() {
            System.out.println(phoneBook);
    }
}













    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов
//        HW_05.PhoneBook phoneBook = new HW_05.PhoneBook();
//        phoneBook.fillPhoneBook();
//        phoneBook.printToConsoleMap();
//        phoneBook.tes111();
//        phoneBook.fillPhoneBook();
//        phoneBook.fill();
//        phoneBook.pr();
//}
//
//class PhoneBook {
//    Map<String, int[]> phoneBook = new HashMap<>();
//        //Id          ФИО      Номера
//    Map<Integer, String> test = new HashMap<>();
//    Map<Integer, String> sort = new HashMap<>();
//
//
//    void fill() {
//        sort.put(1, "Иванов Суворов Куминов Зверьков" );
//        sort.put(2, "Сидоров, Захаров, Карманов, Царев");
//        sort.put(10, "Петров");
//    }
//
//    void pr() {
//        Set<Integer> que = sort.keySet();
//
//        Object[] arr = que.toArray();
//        System.out.println("Set " + Arrays.toString(arr) + " " + arr[arr.length - 1]);
////        int i = (Integer) arr[arr.length - 1];
//
//        System.out.println();
//        int i = arr.length;
//        while (i > 0) {
//            System.out.println(sort.get((Integer) arr[i-1]));
//            i--;
//        }
//    }
//
//    void fillPhoneBook () {
//        phoneBook.put("Иванов", new int[] {1, 2, 2});
//        System.out.println((Arrays.toString(phoneBook.get("Иванов"))));
//    }
//    void tes111 () {
//        Map<String, String> ts111 = new HashMap<>();
//        ts111.put("Иванов", "1111яер");
//        ts111.put("Лазарев", "2faяверявепряеe");
//        ts111.put("3333", "aeявапрgrg");
//        System.out.println(ts111);
//        Map<String, String> ts222 = new HashMap<>();
//        ts222.put("111", "1111кря");
//        ts222.put("2222", "2fяавряакпae");
//        ts222.put("3333", "aяврявеапрegrg");
//        ArrayList<Map> zavis = new ArrayList<>();
//        zavis.add(ts111);
//        zavis.add(ts222);
//        System.out.println(zavis);
//        for (Map i : zavis ) {
//            System.out.println(i.get("111"));
//        }
//
//    }
//
//    void printToConsoleMap () {
//        System.out.println(test);
//    }

    /*
    Человек телефон
    Человек телефон
     */







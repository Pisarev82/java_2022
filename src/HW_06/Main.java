package HW_06;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
        Первоначальное заполнение списка ноутбука объектами ноут.
        Список храниться в классе StorageArea
        Можно было бы оставить и заполнение и хранение в одном классе,
        но мне нужно было потренироваться с передачей и работой со списком в разных классах.
         */
        EntriNouts entriNouts = new EntriNouts();
        entriNouts.fillNoutsByRandom(10);
        StorageArea storageArea = new StorageArea(entriNouts.getNouts());
        System.out.println(storageArea.getStorage());
        /*
        Работа с консольным вводом.
         */
        UserInteraction userInteraction = new UserInteraction(storageArea.getStorage());
        userInteraction.hello();
        userInteraction.userSerch();
        /*
        Код сильно не доделан... Не реализован поиск по стринговым значениям... Не отсеянны грубые ошибки ввода...
        Зато можно легко добавить новые интовые значения класса ноутбук (прописать их в конструкторе классе Nout и
        конструкторе класса UserInteraction)
        Из ту ду (которое никогда не будет ту ду)
        1. изменить конструктор класса UserInteraction, что бы новые значения
        в классе ноут сами добавлялись в конструктор класса UserInteraction;
        2. Добавить сортировку и отбор по стринговым значениям класса Nout
         */
    }
}

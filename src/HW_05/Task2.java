package HW_05;

import java.util.*;

public class Task2 {
    /*
    Пусть дан список сотрудников:Иван Иванов
    Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности.
     */

    private final ArrayList<String> staff = new ArrayList<>();

    Task2 () {
        staff.add("Иванов Иван");
        staff.add("Петров Иван");
        staff.add("Петров Иван");
        staff.add("Иванов Иван");
        staff.add("Петров Иван");
        staff.add("Писарев Николай"); // Не выводится в результатирующий, потому что не повторяется.
        staff.add("Петров Иван");
        staff.add("Иванов Иван");
        staff.add("Сидоров Иван");
        staff.add("Иванов Иван");
        staff.add("Сидоров Иван");
        staff.add("Сидоров Иван");
        staff.add("Иванов Иван");
        staff.add("Сидоров Иван");

    }

    void  recurringNames (){
        Map<String, Integer> recurringNames = new HashMap<>();
        for (String emplore: staff) {
            recurringNames.merge(emplore, 1, Integer::sum);
        }

        LinkedList<Integer> repeatOfNames = new LinkedList<>();

        for (Map.Entry<String, Integer> entry : recurringNames.entrySet()) {
            repeatOfNames.add(entry.getValue());
        }


        repeatOfNames.sort(Collections.reverseOrder());

        int valioBefor = 1;
        for (int each: repeatOfNames ) {
            if (each == valioBefor) {
                valioBefor = each;
                continue;
            }
            for (Map.Entry<String, Integer> entry : recurringNames.entrySet()) {
                if (entry.getValue() == each) {
                    System.out.println(entry.getKey() + " повторяется " + each + " раз.");
                }
            }
            valioBefor = each;;
        }
    }
}

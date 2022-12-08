package HW_05;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    /*
    Написать метод, который переведет число из римского формата записи в арабский.
    Например, MMXXII = 2022 (правила см. во вложениях к уроку, где ссылка на репозиторий).
     */
    private  Map<Character, Integer> rimToArabic = new HashMap<>();

    Task3 () {
        fillMap();
    }

    void fillMap () {
        rimToArabic.put('I', 1);
        rimToArabic.put('V', 5);
        rimToArabic.put('X', 10);
        rimToArabic.put('L', 50);
        rimToArabic.put('C', 100);
        rimToArabic.put('D', 500);
        rimToArabic.put('M', 1000);
    }

    void tranleterimToArabic (String rim) {
        int result = 0;
        int number = 0;
        int temp = rimToArabic.get(rim.charAt(rim.length()-1));
        for (int i = rim.length()-2; i >= 0; i--) {
            int x = rimToArabic.get(rim.charAt(i));
            if (x>=temp) {

                result += x;
                temp = x;
                continue;
            } else if (x> rimToArabic.get(rim.charAt(i-1))) {
                result += rimToArabic.get(rim.charAt(i + 1)) - x;
                temp = x;
            } else {
                if (i - 1 >= 0){
                    result += rimToArabic.get(rim.charAt(i + 1)) - x;
                    temp = x;
                    if (i - 1 == 0) {
                        break;
                    }
                }

            }
//        int result = 0;
//        int number = 0;
//        int temp = rimToArabic.get(rim.charAt(0));
//        for (int i = 0; i < rim.length(); i++) {
//            int x = rimToArabic.get(rim.charAt(i));
//            if (x>temp) {
//                result += x;
//            } else {
//                if (i - 1 >= 0){
//                    result += rimToArabic.get(rim.charAt(i - 1)) - x;
//                    temp = x;
//                }
//
//            }
            System.out.println(x);
        }
        System.out.println(result);
    }
}

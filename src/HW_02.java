import java.util.Arrays;

public class HW_02 {
    public static String[] forStar = createFignya(3, 56);

    public static void main(String[] args) {
        //    Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
//        task1();
        //isRevers();

// Рекурсия
//        StringBuilder sb = new StringBuilder("Строка");
//        isReversRecurs(sb);

//        Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().

        System.out.println(Arrays.toString(forStar));
        System.out.println("1");

        //    Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        changeFignyaFitcha(createFignya(3, 56));

        //    Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        changeFignyaFitchaStar();
        System.out.println(Arrays.toString(forStar));

    }



    static void task1 () {
        //    Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
        String stringFirst = "найти наименьшее окно в строке";
        String stringSecond = "содержащей все символы окно  другой строке наверное";
        String[] arr1 = stringFirst.split(" ");
        String[] arr2 = stringSecond.split(" ");
        String[] arr3 = new String[arr1.length > arr2.length ? arr1.length : arr2.length];
        System.out.println(Arrays.toString(arr1));
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].compareTo(arr2[j]) == 0) {
                    arr3[count++] = arr1[i];
                }
            }
        }
        int minLength = 100;
        String result = null;
        for (String each : arr3 ) {
            if (each != null && each.length()<minLength) {
                minLength = each.length();
                result = each;
            }
        }
        System.out.println(result);
    }

    static void isRevers () {
    //    Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
        String stringFirst = "найти наименьшее окно в строке";
        String stringSecond = "екортс в онко еешьнемиан итйан";
        StringBuilder sb = new StringBuilder(stringFirst);
        String stringTemp = sb.reverse().toString();
        System.out.println(stringSecond.compareTo(stringTemp) == 0);
    }

//    *Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
    static StringBuilder isReversRecurs (StringBuilder sb) {
        System.out.print(sb.charAt(sb.length()-1));
        if (sb.length() == 1) {
            return sb;
        }
        return isReversRecurs(sb.deleteCharAt(sb.length()-1));
    }

    static String[] createFignya(int x, int y) {
//    Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        String[] result = new String[3];

        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(" + ");
        sb.append(y);
        sb.append(" = ");
        sb.append(x+y);
        StringBuilder alfa = new StringBuilder();
        alfa.append(x);
        alfa.append(" - ");
        alfa.append(y);
        alfa.append(" = ");
        alfa.append(x-y);
        StringBuilder tinya = new StringBuilder();
        tinya.append(x);
        tinya.append(" * ");
        tinya.append(y);
        tinya.append(" = ");
        tinya.append(x*y);

        result[0] = sb.toString();
        result[1] = alfa.toString();
        result[2] = tinya.toString();

        return result;
    }



    static String[] changeFignyaFitcha(String[] arr){
        //    Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        String[] result = arr;
        for (String each: arr) {
            StringBuilder sb = new StringBuilder(each);
            int serchIndex = sb.indexOf("=");
            sb.deleteCharAt(serchIndex);
            sb.insert(serchIndex, "Равно");
            System.out.println(sb.toString());
        }
        return result;
    }


    static void changeFignyaFitchaStar(){
        for (int i = 0; i < forStar.length; i++) {
            StringBuilder sb = new StringBuilder(forStar[i]);
            sb.replace(7, 8, "Равно");
            forStar[i] = sb.toString();
        }
    }
}

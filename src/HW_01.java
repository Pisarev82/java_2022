import java.util.Arrays;
import java.util.Random;

public class HW_01 {
    public static void main(String[] args) {
        //1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = randomInt();

        //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = msb(i);

        //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        allMultiple(i, n);

        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        allNotMultiple(i, n);
        }

    static int randomInt() {
        //1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
        int i = new Random().nextInt(-1000,1000);
        System.out.printf("Рандомное число равно: %d \n", i);
        return i;
    }

    static int msb (int i) {
        i = Math.abs(i);

        int msb = Integer.toBinaryString(i).length();
        System.out.printf("Cтарший значащий бит числа %d равен %d \n", i,  msb);
        return msb;
    }
    static void allMultiple (int divisible, int divisor) {
        //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1


        System.out.printf("Делитель = " + divisor + "; Начало интервала = " + divisible + " \n ");

        // Определяем размер массива
        int count = 0;
        for (int j = divisible; j < Short.MAX_VALUE; j++) {
            if (j % divisor == 0) {

                count++;
            }
        }

        // Создаем и заполняем массив
        int[] m1 = new int[count];
        count = 0;
        for (int j = divisible; j < Short.MAX_VALUE; j++) {
            if (j % divisor == 0) {
                m1[count] = j;
                count += 1;
            }
        }
        System.out.println("");
        System.out.print(Arrays.toString(m1));

    }

    static void allNotMultiple (int divisible, int divisor) {
        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2


        System.out.printf("Делитель = " + divisor + "; Начало интервала = " + divisible + " \n ");

        // Определяем размер массива
        int count = 0;
        for (int j = Short.MIN_VALUE; j < divisible; j++) {
            if (j % divisor != 0) {

                count++;
            }
        }
        // Создаем и заполняем массив
        int[] m2 = new int[count];
        count = 0;
        for (int j = Short.MIN_VALUE; j < divisible; j++) {
            if (j % divisor != 0) {
                m2[count] = j;
                count += 1;
            }
        }
        System.out.println("");
        System.out.print(Arrays.toString(m2));
    }
}




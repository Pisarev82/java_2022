
import java.util.Scanner;

public class HW_01_new {
    public static void main(String[] args) {
//        int n = Math.abs(userInput());
//        triangularNumber(n);
//        System.out.println(factorial(n));
//        printAllSimpleNum();


        simplCalc ();

    }

    static void triangularNumber (int n) {
//    Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        int result = 0;
        for (int i = 0; i <= n; i++) result += i;
        System.out.println(result);
    }

    static int factorial (int n){
    //    Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        if (n == 0 || n == 1) return 1;
        return n * factorial( n-1);
    }

    static int userInput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int result = sc.nextInt();
        sc.close();
        return result;
    }

    static boolean isSimpleNum (int number){

        if (number > 3) {
            for (int i = 2; i < number; i++) {
                if ((number % i) == 0) return false;
            }
        }
        return true;
    }

    static void printAllSimpleNum() {
    // Вывести все простые числа от 1 до 1000
    // Проверка на соответствие делается в функции isSimpleNum()
        for (int i = 0; i < 1000; i++) {
            if (isSimpleNum(i)) System.out.print(i + "  ");
        }
    }

    static void simplCalc (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double x = sc.nextDouble();
        System.out.print("Введите математический оператор: ");
        char oper = sc.next().charAt(0);
        System.out.print("Введите второе число: ");
        double y = sc.nextDouble();
        sc.close();
        switch (oper) {
            case '+':
                System.out.printf("%.2f + %.2f = %.2f", x, y, x+y);
                break;
            case '-':
                System.out.printf("%.2f - %.2f = %.2f", x, y, x-y);
                break;
            case '*':
                System.out.printf("%.2f * %.2f = %.2f", x, y, x*y);
                break;
            case '/':
                System.out.printf("%.2f / %.2f = %.2f", x, y, x/y);
                break;
        }

    }
}

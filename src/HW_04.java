import javax.swing.text.html.parser.Parser;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

class Hw_04 {
    public static void main(String[] args) {
        System.out.println("Первая задача");
        // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        FirstTaskHw_04 firstTaskHw_04 = new FirstTaskHw_04();
        firstTaskHw_04.fillList();
        System.out.println(firstTaskHw_04.reversLinkList());


        System.out.println("\n Вторая задача");
        // Реализуйте очередь с помощью LinkedList со следующими методами:
        // enqueue() - помещает элемент в конец очереди,
        // dequeue() - возвращает первый элемент из очереди и удаляет его,
        // first() - возвращает первый элемент из очереди, не удаляя.
        SecondTaskHw_04 secondTaskHw_04 = new SecondTaskHw_04();
        secondTaskHw_04.fillList();
        System.out.println(secondTaskHw_04.enqueue(11));
        System.out.println(secondTaskHw_04.dequeue());
        System.out.println(secondTaskHw_04.first());


        System.out.println("\n Третья задача");
        // * В калькулятор добавьте возможность отменить последнюю операцию.
        // Рализованно, отменить последний ввод. Так как опреции не сохраняются(((.
        SimlCalc simlCalc = new SimlCalc();
        simlCalc.calk();
        System.out.println("До свидания");
    }
}

class FirstTaskHw_04 {
//    Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    LinkedList<Integer> innerLinkList = new LinkedList<>();

    void fillList () {
        for (int i = 0; i<10; i++){
            innerLinkList.add(i);
        }
        System.out.println(innerLinkList);
    }
    LinkedList<Integer> reversLinkList () {
        for (int i = 0 ; i < innerLinkList.size() -1; i++){
            innerLinkList.add(i, innerLinkList.pollLast());
        }
        return innerLinkList;
    }
}


class SecondTaskHw_04 {
    // Реализуйте очередь с помощью LinkedList со следующими методами:
    // enqueue() - помещает элемент в конец очереди,
    // dequeue() - возвращает первый элемент из очереди и удаляет его,
    // first() - возвращает первый элемент из очереди, не удаляя.

    LinkedList<Integer> innerLinkList = new LinkedList<>();

    void fillList () {
        for (int i = 0; i<10; i++){
            innerLinkList.add(i);
        }
        System.out.println(innerLinkList);
    }

    LinkedList<Integer> enqueue(int x) {
        innerLinkList.addLast(x);
        return innerLinkList;
    }

    LinkedList<Integer> dequeue() {
        innerLinkList.pollFirst();
        return innerLinkList;
    }

    Integer first() {
        return innerLinkList.peekFirst();
    }
}

class SimlCalc {

    void calk () {
        boolean flag = true;
        boolean flagFirstNotEntered = true;
        boolean flagSecondNotEntered = true;
        boolean flagOperNotEntered = true;
        String[] arr = new String[3];
        Scanner sc = new Scanner(System.in);
        int x = 0;
        char oper = '+';
        int y = 0;
        while (flag) {
            System.out.print("Введите число, математический оператор или команду Help, Dell, Q ");
            String input = sc.next();
            if (input.toLowerCase(Locale.ROOT).equals("help")){
                System.out.println("В каждом отдельном вводе можно ввести только одно число, один математический символ или одну команду \n" +
                        "Вычисление производиться последа ввода знака \"=\" и если до этого были введены число, знак и число \n " +
                        "Реализованны команды \"Help\" - выводит в колсоль данный текст \n" +
                        "\"Dell\" - удаляет предыдущее введенное число или математический символ и \n" +
                        "\"Q\" - завершает работу консольного калькулятора. \n" +
                        "Продолжайте вводить данные или команды: ");
                continue;
            } else if (input.toLowerCase(Locale.ROOT).equals("q")) {
                System.out.println("Работа калькулятора завершена");
                flag = false;
                continue;
            } else if (input.toLowerCase(Locale.ROOT).equals("dell")) {
                if (!flagSecondNotEntered) {
                    flagSecondNotEntered = true;
                    System.out.println("Удаленно " + y);
                    continue;
                } else if (!flagOperNotEntered) {
                    System.out.println("Удаленно " + oper);
                    flagOperNotEntered = true;
                    continue;
                } else if (!flagFirstNotEntered) {
                    System.out.println("Удаленно " + x);
                    flagFirstNotEntered = true;
                    continue;
                } else {
                    System.out.println("Сохранненых данных нет");
                    continue;
                }
            }
            if (isDigit(input)) {
                if (flagFirstNotEntered) {
                    x = Integer.parseInt(input);
                    flagFirstNotEntered = false;
                    continue;
                } else if (flagSecondNotEntered) {
                    y = Integer.parseInt(input);
                    flagSecondNotEntered = false;
                    continue;
                } else {
                    System.out.println("Уже введены оба числа");
                    continue;
                }
            }
            if (input.length() == 1) {
                if (input.contains("+") || input.contains("-") || input.contains("*") || input.contains("/")){
                    oper = input.charAt(0);
                    flagOperNotEntered = false;
                } else if (input.contains("=") && !flagOperNotEntered && !flagFirstNotEntered && !flagSecondNotEntered) {
                    simplCalc(x, oper, y);
                    flagOperNotEntered = true;
                    flagFirstNotEntered = true;
                    flagSecondNotEntered = true;
                } else {
                    System.out.println("Введено что-то непонятное, попробуйте еще");
                }
            }
        }
        sc.close();
    }

    boolean isDigit (String str) {
        char[] chars = str.toCharArray();
        for (char ch :str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
        }


    void simplCalc(int x, char oper, int y) {

        switch (oper) {
            case '+':
                System.out.printf("%d + %d = %d \n", x, y, x + y);
                break;
            case '-':
                System.out.printf("%d - %d = %d \n", x, y, x - y);
                break;
            case '*':
                System.out.printf("%d * %d = %d \n", x, y, x * y);
                break;
            case '/':
                System.out.printf("%d / %d = %d \n", x, y, x / y);
                break;
        }
    }
}
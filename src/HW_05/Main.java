package HW_05;

public class Main {
    public static void main(String[] args) {
        Taska01 taska01 = new Taska01();
        taska01.solution();
        System.out.println(taska01.getContact("Волчек Александр "));
        taska01.createContact("Александр ", " +7 999 146 14 68");
        taska01.createContact("Александр ", " +7 999 146 14 68");
        taska01.addPhone("Александр ", " 222");
        taska01.addPhone("Николай ", " 222");

        Task3 task3 = new Task3();

        task3.tranleterimToArabic("MCDXIV");

    }
}

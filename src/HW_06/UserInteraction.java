package HW_06;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class UserInteraction {

    Map<Integer, String[]> serchOptions = new HashMap<>();
    ArrayList<Nout> storage;
    StorageArea storageArea;

    UserInteraction(ArrayList<Nout> storage) {
        this.storage = storage;
        storageArea = new StorageArea(storage);
        serchOptions.put(1, new String[]{"Оперативная память", "memoryRam"});
        serchOptions.put(2, new String[]{"Жесткий диск", "memoryHD"});
        serchOptions.put(3, new String[]{"Цвет", "color"});

    }

    void hello() {
        int numberNouts = storage.size();
        System.out.println("Привет, у нас есть " + numberNouts + " ноутбуков");
    }

    void userSerch() {
        System.out.println("Для поиска введи цифру соответствующую нужному критерию ");

        for(Map.Entry<Integer, String[]> entry : serchOptions.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
        System.out.print("Введите соответствующую цифру: ");
        Scanner scanner = new Scanner(System.in);
        int userChoes = scanner.nextInt();
        String serchValueToString = serchOptions.get(userChoes)[0];
        String serchValueToApp = serchOptions.get(userChoes)[1];
        System.out.println("Вы ищете по "  + serchValueToString +
                ". Минимальное значение " + serchValueToString +
                " в наших ноутбуках " + storageArea.minValue(serchValueToApp));
        storageArea.sortStorage(serchValueToApp);
        System.out.println(storageArea.getStorage());

        System.out.println("Введите желаемое значение " + serchValueToString + " минимум " + storageArea.minValue(serchValueToApp) +" : ");
        int userChoesMin = scanner.nextInt();
        System.out.println("Введите желаемое значение " + serchValueToString + " максимум " + storageArea.maxValue(serchValueToApp) +" : ");
        int userChoesMax = scanner.nextInt();
        System.out.println("Вам подходят " + storageArea.ansverUserChuse(userChoesMin, userChoesMax, serchValueToApp));

    }


}

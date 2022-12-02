
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HW_02_new {
    private static final Logger log = Logger.getLogger(HW_02_new.class.getName());
    public static void main(String[] args) {


        // Создаем логгер из встроенного класса util
        // И записываем некоторые данные в txt файал, что бы потом было что читать и парсить.

        FileHandler fh;

        try {
            fh = new FileHandler("file.txt", true);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        }catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
//
//        log.log(Level.INFO, "msgSupplier");
//        log.log(Level.WARNING, "Запись лога с уровнем WARNING (Предупреждение)");
//        log.log(Level.SEVERE, "Запись лога с уровнем SEVERE (серъёзная ошибка)");


        // Распарсить файл с логами из заданий, выполненных на семинаре, найти записи уровня INFO/DEBUG.
        FirstTast firstTast = new FirstTast();
        System.out.println(firstTast.logData());

        Bubblesort bubblesort = new Bubblesort(log);
        bubblesort.fillArr();
    }

}

class FirstTast {

    ArrayList logData(){
        ArrayList<String> logDataArr = new ArrayList<>();
        try {
            File file = new File("file.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logDataArr.add((line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return logDataArr;
    }

}

class Bubblesort {

    int[] arr = new int[100];
    Logger log;
    Bubblesort (Logger log){
        this.log = log;
    };

    void fillArr(){
        for (int index = 0; index < arr.length; index++) {
            arr[index] = new Random().nextInt(1,200);
        }
        for (int each: arr){

        }
    }

    void bubbleSort(){
        log.log(Level.INFO, "msgSupplier");
    }


}
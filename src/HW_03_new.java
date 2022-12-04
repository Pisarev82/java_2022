import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HW_03_new {
    public static void main(String[] args) {
        // Реализовать алгоритм сортировки слиянием
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortArray();


        // Пусть дан произвольный список целых чисел, удалить из него четные числа
        ArrayList<Integer> arrayList = mergeSort.getArrayListResult();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i)%2 == 0) {
                arrayList.remove(i);
                i--;
            }
        }
        System.out.println("Массив нечетных чисел: " + arrayList);


        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        int min = Collections.min(arrayList);
        int max = Collections.max(arrayList);
        int sumOfElls = 0;
        int counter = 0;
        for (int i = 0; i<arrayList.size(); i++) {
            sumOfElls += arrayList.get(i);
            counter++;
        }
        int average = sumOfElls/counter;
        System.out.printf("миниманое = %d, максимальное  = %d, среднее = %d, ", min, max, average);

    }
}



class MergeSort {
    // Реализовать алгоритм сортировки слиянием
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayList<Integer> arrayListResult = new ArrayList<>();

    public MergeSort () {
        for (int index = 0; index < 150; index++) {
            arrayList.add(new Random().nextInt(1, 200));
        }
        System.out.println("Исходный массив        " + arrayList.toString());
    }
    public MergeSort (ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
        System.out.println("Исходный массив        " + arrayList.toString());
    }

    public void sortArray () {
        int step = 1;
        ArrayList<Integer> sortArray = sortArrayIter(arrayList, 0, 1);

        step *= 2;
        while (step < sortArray.size() ){
            sortArray = sortArrayIter(sortArray, 0, step);


            step *=2;
        }
        System.out.println("Отсортированный массив " + sortArray);
        arrayListResult = sortArray;
    }

    public ArrayList<Integer> sortArrayIter(ArrayList<Integer> arrayList, int begin, int step) {
        ArrayList<Integer> sortArray = new ArrayList<>();
        int size = arrayList.size();


        for (int i = begin; i < size;   ) {
            ArrayList<Integer> ar1 = new ArrayList<>();
            ArrayList<Integer> ar2 = new ArrayList<>();
            if (i + step + step < size)
            {
                ar1 = sliceArrayList(arrayList, i, i + step);
                i += step;
                ar2 = sliceArrayList(arrayList, i, i + step);
                i += step;
            } else if (i + step < size)
            {
                ar1 = sliceArrayList(arrayList, i, i + step);
                i += step;
                ar2 = sliceArrayList(arrayList, i , size);
                i = size;
            } else
            {
                ar1 = sliceArrayList(sortArray, i - step , i + step );
                sortArray = sliceArrayList(sortArray, 0, (i - step));
                ar2 = sliceArrayList(arrayList, i, size);
                i = size;
            }

            sortArray.addAll(filFromSorted(ar1,ar2));

        }

        return sortArray;
    }


    public ArrayList<Integer> sliceArrayList (ArrayList<Integer> arrayList, int begin, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        if(arrayList.size() <= end ) {
            end = arrayList.size() ;
        }
        for (int i = begin; i < end; i++) {
            result.add(arrayList.get(i));
        }
        return result;
    }

    public ArrayList<Integer> filFromSorted (ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        ArrayList<Integer> sortArray = new ArrayList<>();

        while (!arrayList1.isEmpty() || !arrayList2.isEmpty()) {
            if (arrayList1.isEmpty()) {
                sortArray.add(arrayList2.get(0));
                arrayList2.remove(0);
                continue;
            }
            if (arrayList2.isEmpty()) {
                sortArray.add(arrayList1.get(0));
                arrayList1.remove(0);
                continue;
            }
            if(arrayList1.get(0)< arrayList2.get(0)){
                sortArray.add(arrayList1.get(0));
                arrayList1.remove(0);
            } else {
                sortArray.add(arrayList2.get(0));
                arrayList2.remove(0);
            }
        }

        return sortArray;
    }

    public ArrayList<Integer> getArrayListResult() {
        return arrayListResult;
    }
}
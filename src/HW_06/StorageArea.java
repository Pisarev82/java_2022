package HW_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class StorageArea {
    private ArrayList<Nout> storage;

    StorageArea(ArrayList<Nout> storage) {
        this.storage = storage;
    }

    public ArrayList<Nout> getStorage() {
        return storage;
    }


    public void setStorage(ArrayList<Nout> storage) {
        this.storage = storage;
    }

    public int minValue(String serchValue) {
        if (storage.size() == 0) {
            return 0;
        }
        int minValue = Integer.parseInt(storage.get(0).getAttributes().get(serchValue));
            for (int i = 1; i<storage.size(); i++) {
                int temp = Integer.parseInt(storage.get(i).getAttributes().get(serchValue));
                if(temp<minValue) {
                    minValue = temp;
                }
            }
        return minValue;
    }

    public int maxValue(String serchValue) {
        if (storage.size() == 0) {
            return 0;
        }
        int maxValue = Integer.parseInt(storage.get(0).getAttributes().get(serchValue));
        for (int i = 1; i<storage.size(); i++) {
            int temp = Integer.parseInt(storage.get(i).getAttributes().get(serchValue));
            if(temp>maxValue) {
                maxValue = temp;
            }
        }
        return maxValue;
    }

    public void sortStorage(String serchValue) {
        Comparator<Nout> comporator = Comparator.comparing(obj -> obj.getattributeIntedger(serchValue));
        Collections.sort(storage, comporator);
    }

    public ArrayList<Nout> ansverUserChuse (int min, int max, String serchValue) {
        ArrayList<Nout> result = new ArrayList<>();
        for(Nout each: storage)
            if(each.getattributeIntedger(serchValue) >= min && each.getattributeIntedger(serchValue) <= max) {
                result.add(each);
            }
        return result;
    }

}

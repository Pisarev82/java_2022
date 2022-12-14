package HW_06;

import java.text.Format;
import java.util.ArrayList;

import java.util.Random;

public class EntriNouts {

    private ArrayList<Nout> nouts;
    private final String[] collors = new String[] {"Black", "Silver", "White", "Red", "Gold"};


    EntriNouts () {
        this.nouts = new ArrayList<>();
    }

    EntriNouts (ArrayList<Nout> nouts) {
        this.nouts = nouts;
    }

    Nout entriRandomNout (String name) {
        Random rand = new Random();
        Nout nout = new Nout(name,
                rand.nextInt(4,128),
                rand.nextInt(128, 5000),
                collors[rand.nextInt(0,4)]);
        return nout;
    }

    void fillNoutsByRandom (int numberNouts) {
        for (int i = 1; i <= numberNouts; i++){
            String name = "Ноут номер " + i;
            nouts.add(entriRandomNout(name));
        }
    }

    public ArrayList<Nout> getNouts() {
        return nouts;
    }
}

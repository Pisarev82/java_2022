package HW_06;


import java.util.Map;
import java.util.TreeMap;

public class Nout {
    private final Map<String, String> attributes;

    public Nout(String name, int memoryRam, int memoryHD, String color) {

        attributes = new TreeMap<>();
        attributes.put("name",name);
        attributes.put("memoryRam", Integer.toString(memoryRam));
        attributes.put("memoryHD", Integer.toString(memoryHD));
        attributes.put("color",color);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public int getattributeIntedger (String key) {
        return Integer.parseInt(attributes.get(key));
    }

    @Override
    public String toString() {
        return attributes.toString();
    }
}

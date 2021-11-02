package nl.tsai.javaee.resource;

import java.util.HashMap;
import java.util.Map;

public class ResponseObject {
    private final Map<String, Object> map = new HashMap<>();

    public void put(String s, Object o) {
        map.put(s, o);
    }

    public Map<String, Object> getMap() {
        return map;
    }
}

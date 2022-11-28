package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str : strings) {
           String[] temp = str.split("");
           List<String> list = rsl.get(temp[0]);
           if (rsl.get(temp[0]) == null) {
               list = new ArrayList<>();
           }
           list.add(str);
           rsl.put(temp[0], list);
        }
        return rsl;
    }
}
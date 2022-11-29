package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Info i : list) {
            map.computeIfPresent(i.getCity(), (key, val) -> map.get(i.getCity()) + i.getRainfall());
            map.putIfAbsent(i.getCity(), i.getRainfall());
        }
        for (String key : map.keySet()) {
            Info next = new Info(key, map.get(key));
            rsl.add(next);
            System.out.println(next.getCity() + " " + next.getRainfall());
        }
        return rsl;
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }
    }
}
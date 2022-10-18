package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int count = 0;
        for (Pupil next : pupils) {
            for (Subject sub : next.subjects()) {
                rsl += sub.score();
                count++;
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil next : pupils) {
            double rsl = 0;
            int count = 0;
            for (Subject sub : next.subjects()) {
                rsl += sub.score();
                count++;
            }
            list.add(new Label(next.name(), rsl / count));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            Integer score = 0;
            for (Subject sub : pupil.subjects()) {
                if (map.get(sub.name()) == null) {
                    map.put(sub.name(), sub.score());
                } else {
                    map.put(sub.name(), map.get(sub.name()) + sub.score());
                }
            }
        }
        System.out.println(map);
        List<Label> list = new ArrayList<>();
        double rsl = 0;
        for (String str : map.keySet()) {
            list.add(new Label(str, map.get(str) / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day02 extends Day {
    static {
        currentDay = buildCurrentDay(new Object() {});
    }

    @Override
    public String part1(List<String> input) {
//        System.out.println(input);
        Integer totalSafe = 0;
        for (String line : input) {
            List<Integer> levelList = Arrays.stream(line.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
            System.out.println(levelList);

//            Boolean increasing = null;
//            Boolean withinLimit = null;
            List<Boolean> increasingList = new ArrayList<>();
            List<Boolean> withinLimitList = new ArrayList<>();
            for (int i = 0; i < levelList.size()-1; i++) {
                if (levelList.get(i + 1) - levelList.get(i) > 0 && levelList.get(i + 1) - levelList.get(i) < 4) {
                    increasingList.add(true);
                    withinLimitList.add(true);
                } else if (levelList.get(i + 1) - levelList.get(i) >= 4) {
                    increasingList.add(true);
                    withinLimitList.add(false);
                } else if (levelList.get(i) - levelList.get(i+1) > 0 && levelList.get(i) - levelList.get(i+1) < 4) {
                    increasingList.add(false);
                    withinLimitList.add(true);
                } else {
                    increasingList.add(false);
                    withinLimitList.add(false);
                }
            }
                System.out.println("increasing?:" + increasingList);
                System.out.println("withinLimit?:" + withinLimitList);
                long falseCount = increasingList.stream()
                    .filter(b -> !b)
                    .count();
                if (withinLimitList.contains(false) || falseCount > 0 && falseCount < withinLimitList.size()) {
                    System.out.println("Not safe");
                } else {
                    System.out.println("Safe");
                    totalSafe += 1;
                }
        }
        return totalSafe.toString();
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }
}

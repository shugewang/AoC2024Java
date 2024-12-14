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

    private long getFalseCount(List<Boolean> list) {
        return list.stream()
            .filter(b -> !b)
            .count();
    }
    @Override
    public String part1(List<String> input) {
        int totalSafe = 0;
        for (String line : input) {
            List<Integer> levelList = Arrays.stream(line.split(" "))
                .map(Integer::valueOf)
                .toList();

            List<Boolean> increasingList = new ArrayList<>();
            List<Boolean> withinLimitList = new ArrayList<>();
            for (int i = 0; i < levelList.size()-1; i++) {
                if (isWithinLimitIncrease(levelList, i)) {
                    increasingList.add(true);
                    withinLimitList.add(true);
                } else if (isWithinLimitDecrease(levelList, i)) {
                    increasingList.add(false);
                    withinLimitList.add(true);
                } else {
                    withinLimitList.add(false);
                    break;
                }
            }

            if (getFalseCount(withinLimitList) == 0 && (getFalseCount(increasingList) == 0 || getFalseCount(increasingList) == levelList.size()-1)) {
                totalSafe += 1;
            }
        }
        return Integer.toString(totalSafe);
    }

    private static boolean isWithinLimitDecrease(List<Integer> levelList, int i) {
        return levelList.get(i) - levelList.get(i + 1) > 0 && levelList.get(i) - levelList.get(i + 1) < 4;
    }

    private static boolean isWithinLimitIncrease(List<Integer> levelList, int i) {
        return levelList.get(i + 1) - levelList.get(i) > 0 && levelList.get(i + 1) - levelList.get(i) < 4;
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }
}

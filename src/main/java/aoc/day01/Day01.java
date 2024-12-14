package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Day01 extends Day {

    static {
        currentDay = buildCurrentDay(new Object() {});
    }

    @Override
    public String part1(List<String> input) {
//        List<List<Integer>> pairs = new ArrayList<>();
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (String line:input) {
            String[] splitList = line.split("(\\D)", 2);
            listA.add(Integer.valueOf(splitList[0]));
            listB.add(Integer.valueOf(splitList[1].trim()));
        }

        Collections.sort(listA);
        Collections.sort(listB);

        Integer total = 0;
        for (int i = 0; i < listA.size(); i++) {
            total += Math.abs(listA.get(i) - listB.get(i));
        }

        System.out.println(listA);
        System.out.println(listB);
        System.out.println(total);

        return input.isEmpty() ? "" : input.get(0);
    }

    @Override
    public String part2(List<String> input) {
        return input.isEmpty() ? "" : input.get(0);
    }

}

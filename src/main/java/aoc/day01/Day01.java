package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 extends Day {

    static {
        currentDay = buildCurrentDay(new Object() {});
    }

    private static Result parseLists(List<String> input) {
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (String line: input) {
            String[] splitList = line.split("(\\D)", 2);
            listA.add(Integer.valueOf(splitList[0]));
            listB.add(Integer.valueOf(splitList[1].trim()));
        }
        Result result = new Result(listA, listB);
        return result;
    }

    private record Result(ArrayList<Integer> listA, ArrayList<Integer> listB) {
    }

    @Override
    public String part1(List<String> input) {
        Result lists = parseLists(input);
        Collections.sort(lists.listA());
        Collections.sort(lists.listB());

        int total = 0;
        for (int i = 0; i < lists.listA().size(); i++) {
            total += Math.abs(lists.listA().get(i) - lists.listB().get(i));
        }

        return Integer.toString(total);
    }

    @Override
    public String part2(List<String> input) {
        Result lists = parseLists(input);

        int total = 0;
        for (int number: lists.listA) {
            total += number * Collections.frequency(lists.listB, number);
        }
        return Integer.toString(total);
    }

}

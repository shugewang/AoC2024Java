package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends Day {
    static {
        currentDay = buildCurrentDay(new Object() {});

    }

    @Override
    public String part1(List<String> input) {
        List<String> mulMatches = getMulMatches(input);
        AtomicReference<Integer> total = new AtomicReference<>(0);
        mulMatches.stream().map(Day03::getNumberMatches).forEach( it -> getMultiplication(it, total));
        return String.valueOf(total);
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }

    private static void getMultiplication(int[] it, AtomicReference<Integer> total) {
        total.updateAndGet(v -> v + it[0] * it[1]);
    }

    private static List<String> getMulMatches(List<String> input) {
        String mulRegex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(mulRegex);
        Matcher matcher = pattern.matcher(String.join("", input));

        List<String> muls = new ArrayList<>();
        while (matcher.find()) {
            muls.add(matcher.group());
        }
        return muls;
    }

    private static int[] getNumberMatches(String mul) {
        String numberRegex = "mul\\((\\d+),(\\d+)\\)";
        Pattern numberPattern = Pattern.compile(numberRegex);
        Matcher numberMatcher = numberPattern.matcher(mul);

        if (numberMatcher.find()) {
            int num1 = Integer.parseInt(numberMatcher.group(1));
            int num2 = Integer.parseInt(numberMatcher.group(2));
            return new int[]{num1, num2};
        }
        throw new IllegalArgumentException("No match found");
    }


}

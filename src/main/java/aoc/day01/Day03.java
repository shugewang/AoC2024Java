package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends Day {
    static {
        currentDay = buildCurrentDay(new Object() {});
    }

    @Override
    public String part1(List<String> input) {
        System.out.println(input);
        String mulRegex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(mulRegex);
        Matcher matcher = pattern.matcher(String.join("", input));

        int result = 0;
        while (matcher.find()) {
            System.out.println("Match: " + matcher.group());
            String numberRegex = "mul\\((\\d+),(\\d+)\\)";
            Pattern numberPattern = Pattern.compile(numberRegex);
            Matcher numberMatcher = numberPattern.matcher(matcher.group());

            List<int[]> numberMatches = new ArrayList<>();
            while (numberMatcher.find()) {
                int num1 = Integer.parseInt(numberMatcher.group(1));
                int num2 = Integer.parseInt(numberMatcher.group(2));
                numberMatches.add(new int[]{num1, num2});
            }
            for (int[] numberMatch : numberMatches) {
                result += numberMatch[0] * numberMatch[1];
                System.out.println(Arrays.toString(numberMatch));
            }
        }

        return String.valueOf(result);
    }

    @Override
    public String part2(List<String> input) {
        return "";
    }
}

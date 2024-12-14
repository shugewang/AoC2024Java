package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends Day {
    static {
        currentDay = buildCurrentDay(new Object() {});
    }

    @Override
    public String part1(List<String> input) {
        String mulRegex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

        List<String> mulMatches = getMulMatches(mulRegex, input);
        return getTotal(mulMatches);
    }

    @Override
    public String part2(List<String> input) {
        String regex = "do\\(\\)|don't\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)";

        List<String> mulMatches = getMulMatches(regex, input);
        List<String> enabledMuls = getOnlyEnabledMatches(mulMatches);
        return getTotal(enabledMuls);
    }

    private static List<String> getOnlyEnabledMatches(List<String> mulMatches) {
        List<String> enabledMuls = new ArrayList<>();
        boolean enabled = true;
        for (String mulMatch : mulMatches) {
            if (Objects.equals(mulMatch, "don't()")) {
                enabled = false;
            }
            if (Objects.equals(mulMatch, "do()")) {
                enabled = true;
            } else {
                if (enabled) {
                    enabledMuls.add(mulMatch);
                }
            }
        }
        return enabledMuls;
    }

    private static void getMultiplication(int[] it, AtomicReference<Integer> total) {
        total.updateAndGet(v -> v + it[0] * it[1]);
    }

    private static List<String> getMulMatches(String regex, List<String> input) {
        Pattern pattern = Pattern.compile(regex);
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

    private static String getTotal(List<String> mulMatches) {
        AtomicReference<Integer> total = new AtomicReference<>(0);
        mulMatches.stream().map(Day03::getNumberMatches).forEach(it -> getMultiplication(it, total));
        return String.valueOf(total);
    }
}

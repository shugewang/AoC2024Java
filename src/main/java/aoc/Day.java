package aoc;

import java.io.*;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public abstract class Day {

    protected static Day currentDay;

    public abstract String part1(List<String> input);

    public abstract String part2(List<String> input);

    private List<String> loadInput() {
        String fileName = String.format("day%02d.txt", this.dayNumber());

        InputStream inputForDay = ClassLoader.getSystemResourceAsStream(fileName);
        if (Objects.isNull(inputForDay)) {
            throw new IllegalArgumentException("Can’t find data for day using filename: " + fileName + ". Did you forget to put the file in the resources directory?");
        }
        try (BufferedReader r = new BufferedReader(new InputStreamReader(inputForDay))) {
            return r.lines().collect(toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] unused) {
        if (currentDay == null) {
            throw new RuntimeException("You need to initialise currentDay in a static initialiser block in the child class");
        }
        currentDay.printPart1();
        currentDay.printPart2();
    }

    void printPart2() {
        System.out.println("Day " + this.dayNumber() + ", Part 2: " + this.part2(this.loadInput()));
    }

    void printPart1() {
        System.out.println("Day " + this.dayNumber() + ", Part 1: " + this.part1(this.loadInput()));
    }

    public int dayNumber() {
        return Integer.parseInt(this.getClass().getSimpleName().replaceAll("[^0-9]", ""));
    }

}

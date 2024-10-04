package aoc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DayTest {

    private ByteArrayOutputStream interceptedOut;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        interceptedOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(interceptedOut));
    }

    @Test
    void printPart1() {

        Day day = new FakeDay01();
        day.printPart1();
        day.printPart2();

        assertThat(interceptedOut.toString())
            .containsIgnoringNewLines(
                "Day 1, Part 1: 123",
                "Day 1, Part 2: 456");
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private static class FakeDay01 extends Day {
        public FakeDay01() {
            super(1);
        }

        @Override
        public String part1(List<String> input) {
            return "123";
        }

        @Override
        public String part2(List<String> input) {
            return "456";
        }
    }
}

package test;

import main.ClockConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClockConverterTest {

    private ClockConverter converter;

    @Before
    public void setConverter() {
        converter = new ClockConverter();
    }

    @Test
    public void testMidNight() {
        String time = converter.convert("00:00");
        assertEquals(time, "It's midnight");
    }
    @Test
    public void testTimeThreeFiftySix() {
        String time = converter.convert("03:56");
        assertEquals(time, "It's three fifty six");
    }
    @Test
    public void testTimeTwelveSix() {
        String time = converter.convert("12:06");
        assertEquals(time, "It's twelve six");
    }
    @Test
    public void testEmptyString() {
        String time = converter.convert("");
        assertEquals(time, "Please provide a time to convert");
    }
    @Test
    public void testInvalidTimeWithoutLeadingZero() {
        String time = converter.convert("3:56");
        assertEquals(time, "Time format is invalid, please enter hh:mm");
    }
    @Test
    public void testInvalidTimeWithBigNumber() {
        String time = converter.convert("93:56");
        assertEquals(time, "Time format is invalid, please enter hh:mm");
    }
    @Test
    public void testInvalidTimeWithoutColon() {
        String time = converter.convert("0356");
        assertEquals(time, "Time format is invalid, please enter hh:mm");
    }
}

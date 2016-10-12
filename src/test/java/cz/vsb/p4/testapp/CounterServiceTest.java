package cz.vsb.p4.testapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ruz76 on 12.10.2016.
 */
public class CounterServiceTest {

    private static final Integer INIT_VAL = 123;
    private CounterService counterService;

    @Before
    public void setup() {
        this.counterService = new CounterService(INIT_VAL);
    }

    @Test
    public void shouldReturnInitValueOnFirstCall() {
        CounterValue value = counterService.getAndIncrement();
        Assert.assertEquals(INIT_VAL, value.getValue());
    }

    @Test
    public void shouldReturnInitPlusOneValueOnSecondCall() {
        Integer expectedValue = new Integer(INIT_VAL + 1);
        counterService.getAndIncrement();
        CounterValue value = counterService.getAndIncrement();
        Assert.assertEquals(expectedValue, value.getValue());
    }

}
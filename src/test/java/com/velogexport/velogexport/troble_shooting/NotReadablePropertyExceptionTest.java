package com.velogexport.velogexport.troble_shooting;

import lombok.Data;
import org.junit.jupiter.api.Test;

public class NotReadablePropertyExceptionTest {
    @Test
    void contextLoads() {
        Temp temp = new Temp();
        temp.getValueA();
        temp.isValueB();
        temp.isValueC();

        temp.setValueA("");
        temp.setValueB(false);
        temp.setValueC(false);
    }

    @Data
    class Temp {
        private String valueA;
        private boolean valueB;
        private boolean isValueC;
    }
}

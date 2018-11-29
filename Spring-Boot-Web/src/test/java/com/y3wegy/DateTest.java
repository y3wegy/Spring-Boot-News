package com.y3wegy;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTest {
    private static final Logger logger = Logger.getLogger(DateTest.class);
    Date now = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

    @Test
    public void testFormat() {
        DateFormat dateFormat = DateFormat.getDateInstance(0);
        DateFormat dateFormat1 = DateFormat.getDateInstance(1);
        DateFormat dateFormat2 = DateFormat.getDateInstance(2);
        DateFormat dateFormat3 = DateFormat.getDateInstance(3);

        logger.info(dateFormat.format(now));
        logger.info(dateFormat1.format(now));
        logger.info(dateFormat2.format(now));
        logger.info(dateFormat3.format(now));

    }

    @Test
    public void testFormat2(){
        DateFormat dateFormat = DateFormat.getDateTimeInstance(0,0);
        DateFormat dateFormat1 = DateFormat.getDateTimeInstance(1,1);
        DateFormat dateFormat2 = DateFormat.getDateTimeInstance(2,2);
        DateFormat dateFormat3 = DateFormat.getDateTimeInstance(3,3);

        logger.info(dateFormat.format(now));
        logger.info(dateFormat1.format(now));
        logger.info(dateFormat2.format(now));
        logger.info(dateFormat3.format(now));
    }
}
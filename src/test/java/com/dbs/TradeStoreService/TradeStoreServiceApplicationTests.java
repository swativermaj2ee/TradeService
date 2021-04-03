package com.dbs.TradeStoreService;

import com.dbs.TradeStoreService.entity.TradeData;
import com.dbs.TradeStoreService.exception.IncorrectTradeVersionException;
import com.dbs.TradeStoreService.service.TradePersistenceService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class TradeStoreServiceApplicationTests {
    @InjectMocks
    private TradePersistenceService tradePersistenceService;
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    void contextLoads() throws ParseException {
      //   tradePersistenceService=new TradePersistenceService();
    }

    @Test
    public final void whenLowerVersionTradeSavedThenExceptionIsThrown() throws IncorrectTradeVersionException, ParseException {
        TradeData tradeData1 = new TradeData("T1", 1, "CP-1", "B1", dateformat.parse("20-05-2020"), new Date(), false);
        Exception exception = assertThrows(IncorrectTradeVersionException.class, () -> {
            tradePersistenceService.persist(tradeData1);
        });
        String expectedMessage = "Incorrect version, older version not accepted";
        assertTrue(exception.getLocalizedMessage().contains(expectedMessage));
    }

}

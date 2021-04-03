package com.dbs.TradeStoreService;

import com.dbs.TradeStoreService.entity.TradeData;
import com.dbs.TradeStoreService.service.TradePersistenceService;
import com.dbs.TradeStoreService.util.UpdateTradeExpiryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication

public class TradeStoreServiceApplication implements CommandLineRunner {

	@Autowired
	UpdateTradeExpiryTask updateTradeExpiryTask;

	public static void main(String[] args) {
		SpringApplication.run(TradeStoreServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(updateTradeExpiryTask ::run, 0, 1, TimeUnit.SECONDS);

	}

}

package com.dbs.TradeStoreService.exception;

import org.springframework.stereotype.Component;

public class IncorrectTradeVersionException extends Exception {
    String msg;
    public IncorrectTradeVersionException(String msg) {
        this.msg = msg;
    }
}

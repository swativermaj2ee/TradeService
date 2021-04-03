package com.dbs.TradeStoreService.exception;

import org.springframework.stereotype.Component;

@Component
public class IncorrectTradeVersionException extends Exception {
    String msg;
    public IncorrectTradeVersionException(){}
    public IncorrectTradeVersionException(String msg) {
        this.msg = msg;
    }
}

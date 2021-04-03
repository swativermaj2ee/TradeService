package com.dbs.TradeStoreService.exception;

import org.springframework.stereotype.Component;

public class OldTradeMaturityDateException extends Exception {
    String msg;
    public OldTradeMaturityDateException(String msg) {
        this.msg = msg;
    }
}

package com.dbs.TradeStoreService.util;

import com.dbs.TradeStoreService.entity.TradeData;

import java.util.Comparator;

public class TradeDataVersionComparator implements Comparator<TradeData> {
    @Override
    public int compare(TradeData td1, TradeData td2) {
        int result = 0;
        if (td1.getVersion() < td2.getVersion())
            result = -1;
        if (td1.getVersion() > td2.getVersion())
            result = 1;
        if (td1.getVersion() == td2.getVersion())
            result = 0;

        return result;
    }
}

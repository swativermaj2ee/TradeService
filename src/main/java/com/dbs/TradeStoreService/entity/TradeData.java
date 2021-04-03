package com.dbs.TradeStoreService.entity;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class TradeData {
    String tradeId;
    int version;
    String counterPartyId;
    String bookId;
    Date maturityDate;
    Date createdDate;
    boolean expired;

    public TradeData() {
    }

    public TradeData(String tradeId, int version, String counterPartyId, String bookId, Date maturityDate, Date createdDate, boolean expired) {
        this.tradeId = tradeId;
        this.version = version;
        this.counterPartyId = counterPartyId;
        this.bookId = bookId;
        this.maturityDate = maturityDate;
        this.createdDate = createdDate;
        this.expired = expired;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCounterPartyId() {
        return counterPartyId;
    }

    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeData tradeData = (TradeData) o;
        return Objects.equals(tradeId, tradeData.tradeId) && version == tradeData.version && Objects.equals(counterPartyId, tradeData.counterPartyId) && Objects.equals(bookId, tradeData.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId, version, counterPartyId, bookId);
    }
}

package com.jeremias.dev.designpatterns.service;

import com.jeremias.dev.designpatterns.model.BankType;

public interface ITransferStrategyService {
    public String balance();

    public boolean support(BankType bank);
}

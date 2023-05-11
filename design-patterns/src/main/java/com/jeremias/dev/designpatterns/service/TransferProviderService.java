package com.jeremias.dev.designpatterns.service;

import com.jeremias.dev.designpatterns.model.BankType;

public interface TransferProviderService {
    String transfer(BankType bank);
}

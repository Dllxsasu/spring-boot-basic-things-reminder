package com.jeremias.dev.designpatterns.service.impl;

import com.jeremias.dev.designpatterns.model.BankType;
import com.jeremias.dev.designpatterns.service.ITransferStrategyService;
import org.springframework.stereotype.Component;

@Component
public class InterbankTransferServiceImpl implements ITransferStrategyService {
    @Override
    public String balance() {
        return "balance of INTERBANK";
    }

    @Override
    public boolean support(BankType bank) {
        return bank.equals(BankType.INTERBANK);
    }
}

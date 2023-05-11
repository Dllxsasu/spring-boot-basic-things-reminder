package com.jeremias.dev.designpatterns.service.impl;

import com.jeremias.dev.designpatterns.model.BankType;
import com.jeremias.dev.designpatterns.service.ITransferStrategyService;
import org.springframework.stereotype.Component;

@Component
public class ScotiabankTransferServiceImpl implements ITransferStrategyService {
    @Override
    public String balance() {
        return "BALANCE of SCOTIABANK";
    }

    @Override
    public boolean support(BankType bank) {
        return bank.equals(BankType.SCOTIABANK);
    }
}

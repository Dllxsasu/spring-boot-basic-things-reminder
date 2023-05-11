package com.jeremias.dev.designpatterns.service.impl;

import com.jeremias.dev.designpatterns.model.BankType;
import com.jeremias.dev.designpatterns.service.ITransferStrategyService;
import com.jeremias.dev.designpatterns.service.TransferProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Component
public class TransferProviderServiceImpl implements TransferProviderService {
    private final List<ITransferStrategyService> transferStrategyServices;

    @Override
    public String transfer(BankType bank) {
        return transferStrategyServices.stream()
                .filter(implementation -> implementation.support(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error not found type of bank") )
                .balance();
    }
}

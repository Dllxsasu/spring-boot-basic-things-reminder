package com.jeremias.dev.designpatterns.controller;

import com.jeremias.dev.designpatterns.model.BankType;
import com.jeremias.dev.designpatterns.service.TransferProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {
    private final TransferProviderService transferProviderService;

    @GetMapping("/bcp")
    public String bcp(){
        return transferProviderService.transfer(BankType.BCP);
    }
    @GetMapping("/interbank")
    public String interbank(){
        return transferProviderService.transfer(BankType.INTERBANK);
    }
    @GetMapping("/scotiabank")
    public String scotiabank(){
        return transferProviderService.transfer(BankType.SCOTIABANK);
    }



}

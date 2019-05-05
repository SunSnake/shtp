package com.shtp.askbuy.controller;

import com.shtp.askbuy.bean.AskBuy;
import com.shtp.askbuy.service.AskBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class AskBuyController {
    @Autowired
    AskBuyService askBuyService;

    @RequestMapping(value = "/postAskBuy", method = RequestMethod.POST)
    public void postAskBuy(AskBuy askBuy){
        askBuyService.postAskBuy(askBuy);
    }

    @RequestMapping(value = "/loadAskBuy", method = RequestMethod.GET)
    public List<AskBuy> getAskBuy(){
        return askBuyService.getAllAskBuys();
    }

}

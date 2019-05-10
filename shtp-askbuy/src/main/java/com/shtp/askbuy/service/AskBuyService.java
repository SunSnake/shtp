package com.shtp.askbuy.service;

import com.shtp.askbuy.bean.AskBuy;
import com.shtp.askbuy.mapper.AskBuyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AskBuyService {
    @Autowired
    AskBuyMapper askBuyMapper;

    public void postAskBuy(AskBuy askBuy){askBuyMapper.postAskBuy(askBuy);}

    public List<AskBuy> getAllAskBuys() {
        return askBuyMapper.getAllAskBuys();
    }

    public void updateAskBuy(AskBuy askBuy){
        askBuyMapper.updateAskBuy(askBuy);
    }

    public void deleteAskBuy(int id){
        askBuyMapper.deleteAskBuy(id);
    }
}

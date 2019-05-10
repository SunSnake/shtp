package com.shtp.askbuy.mapper;

import com.shtp.askbuy.bean.AskBuy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskBuyMapper {
    void postAskBuy(AskBuy askBuy);
    List<AskBuy> getAllAskBuys();
    void deleteAskBuy(int id);
    void updateAskBuy(AskBuy askBuy);
}

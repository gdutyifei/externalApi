package com.baiduAI.app.api;

import com.baiduAI.app.service.CardManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@RestController
@RequestMapping(value = "/api/cardList/", method = {RequestMethod.GET, RequestMethod.POST})
public class CardListApi {

    @Autowired
    private CardManagerService cardManagerService;

    @RequestMapping("/saveCardToList")
    public Map<String, Object> saveCardToList(@RequestParam("openid") String openid, @RequestParam("salesId") Long salesId, @RequestParam("way") int way, @RequestParam("relay_name") String relay_name) throws Exception {
        return cardManagerService.saveCardToList(openid, salesId, way, relay_name);
    }

    @RequestMapping("/getCardListByOpenid")
    public Map<String, Object> getCardListByOpenid(@RequestParam("openid") String openid) throws Exception {
        return cardManagerService.getCardListByOpenid(openid);
    }

    @RequestMapping("/saveCardToListTemp")
    public void saveCardToListTemp(@RequestParam("openid") String openid) throws Exception {
        cardManagerService.saveCardToListTemp(openid);
    }
}

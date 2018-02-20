package com.baiduAI.app.service;

import com.baiduAI.app.dao.CardListDAO;
import com.baiduAI.app.dao.SalesInfoDAO;
import com.baiduAI.app.dto.CardListDTO;
import com.baiduAI.app.dto.SalesInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class CardManagerService {

    public static final Logger logger = LoggerFactory.getLogger(CardManagerService.class);

    @Autowired
    private CardListDAO cardListDAO;

    @Autowired
    private SalesInfoDAO salesInfoDAO;

    /**
     * 浏览过的名片保存到名片列表中
     * @param openid
     * @param salesId
     * @param way
     * @return
     */
    public Map<String, Object> saveCardToList(@RequestParam("openid") String openid, @RequestParam("salesId") Long salesId, @RequestParam("way") String way) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        CardListDTO cardListDTO = cardListDAO.getCardByOpenidAndSalesId(openid, salesId);
        if (cardListDTO == null) {
            // 说明之前没有浏览过， 保存到数据库中
            cardListDAO.saveCardToList(openid, salesId, way);
            returnMap.put("msg", "保存到数据库成功");
            return returnMap;
        }
        returnMap.put("msg", "之前已经浏览过这个名片");
        return returnMap;
    }

    /**
     * 根据openid获取名片列表
     * @param openid
     * @return
     */
    public Map<String, Object> getCardListByOpenid(@RequestParam("openid") String openid) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<CardListDTO> cardList = cardListDAO.getCardListByOpenid(openid);
        List<Map<String, Object>> totalData = new ArrayList<Map<String, Object>>();
        Map<String, Object> data = new HashMap<String, Object>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (cardList != null && cardList.size() > 0) {
            for (CardListDTO cardListDTO: cardList) {
                data.put("id", cardListDTO.getId());
                data.put("date", cardListDTO.getFollow_date().format(dtf));
                data.put("way", cardListDTO.getWay());
                Long salesId = cardListDTO.getSales_id();
                SalesInfoDTO salesInfoDTO = salesInfoDAO.getSalesInfoBySalesId(salesId);
                if (salesInfoDTO != null) {
                    data.put("store", salesInfoDTO.getStore());
                    data.put("name", salesInfoDTO.getName());
                    data.put("job", salesInfoDTO.getJob());
                    data.put("tel", salesInfoDTO.getTel());
                    data.put("email", salesInfoDTO.getEmail());
                    data.put("imageUrl", salesInfoDTO.getCover_url());
                    data.put("photos", salesInfoDTO.getPhotos());
                    data.put("openid", salesInfoDTO.getOpenid());
                }
                totalData.add(data);
            }
        }
        returnMap.put("data", totalData);
        returnMap.put("msg", "获取名片列表成功");
        returnMap.put("code", 200);
        return returnMap;
    }
}

package com.baiduAI.app.service;

import com.baiduAI.app.dao.ProductInfoDAO;
import com.baiduAI.app.dao.RankProductReadDetailDAO;
import com.baiduAI.app.dao.WechatInfoDAO;
import com.baiduAI.app.dto.ProductInfoDTO;
import com.baiduAI.app.dto.WechatDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class ProductInfoService {

    public static final Logger logger = LoggerFactory.getLogger(ProductInfoService.class);

    @Autowired
    private ProductInfoDAO productInfoDAO;

    @Autowired
    private RankProductReadDetailDAO rankProductReadDetailDAO;

    @Autowired
    private WechatInfoDAO wechatInfoDAO;

    /**
     * 根据B端用户openid获取产品列表
     * @param openid
     * @return
     */
    public Map<String, Object> getProductListByOpenid(@RequestParam("salesOpenid") String salesOpenid, @RequestParam("sales_id") Long sales_id, @RequestParam("openid") String openid) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<ProductInfoDTO> productList = productInfoDAO.getProductListByOpenid(salesOpenid);
        // 保存产品列表查看次数记录
        WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
        if (wechatDTO == null) {
            returnMap.put("code", 9999);
            returnMap.put("msg", "找不到C端用户信息");
            return returnMap;
        }
        Long cuesrId = wechatDTO.getId();
        rankProductReadDetailDAO.saveProductReadDetail(openid, cuesrId, sales_id);
        returnMap.put("code", 200);
        returnMap.put("msg", "获取产品列表成功");
        returnMap.put("data", productList);
        return returnMap;
    }

    /**
     * B端用户上传产品信息
     * @param openid
     * @param product_name
     * @param product_price
     * @param product_detail
     * @param cover_url
     * @return
     */
    public Map<String, Object> saveProductInfo(@Param("openid") String openid, @Param("product_name") String product_name, @Param("product_price") String product_price, @Param("product_detail") String product_detail, @Param("cover_url") String cover_url) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        productInfoDAO.saveProductInfo(openid, product_name, product_price, product_detail, cover_url);
        returnMap.put("code", 200);
        returnMap.put("msg", "保存信息成功");
        returnMap.put("data", null);
        return returnMap;
    }

    /**
     * 根据产品id获取产品信息
     * @param id
     * @return
     */
    public Map<String, Object> getProductInfoById(@Param("id") Long id) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        ProductInfoDTO productInfoDTO = productInfoDAO.getProductInfoById(id);
        if (productInfoDTO == null) {
            returnMap.put("code", 9999);
            returnMap.put("msg", "找不到该产品信息");
            returnMap.put("data", productInfoDTO);
            return returnMap;
        }
        returnMap.put("code", 200);
        returnMap.put("msg", "成功获取产品信息");
        returnMap.put("data", productInfoDTO);
        return returnMap;
    }
}

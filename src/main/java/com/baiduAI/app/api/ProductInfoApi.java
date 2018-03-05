package com.baiduAI.app.api;

import com.baiduAI.app.service.ProductInfoService;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping(value = "/api/productInfo/", method = {RequestMethod.GET, RequestMethod.POST})
public class ProductInfoApi {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/getProductListByOpenid")
    public Map<String, Object> getProductListByOpenid(@RequestParam("salesOpenid") String salesOpenid, @RequestParam("sales_id") Long sales_id, @RequestParam("openid") String openid) {
        return productInfoService.getProductListByOpenid(salesOpenid, sales_id, openid);
    }

    @RequestMapping("/saveProductInfo")
    public Map<String, Object> saveProductInfo(@Param("openid") String openid, @Param("product_name") String product_name, @Param("product_price") String product_price, @Param("product_detail") String product_detail, @Param("cover_url") String cover_url) {
        return productInfoService.saveProductInfo(openid, product_name, product_price, product_detail, cover_url);
    }

    @RequestMapping("/getProductInfoById")
    public Map<String, Object> getProductInfoById(@Param("id") Long id) {
        return productInfoService.getProductInfoById(id);
    }
}

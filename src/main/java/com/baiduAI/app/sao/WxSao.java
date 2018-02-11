package com.baiduAI.app.sao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by luoyifei on 2018/2/10.
 */
@FeignClient(value = "wx", url="${wx.api.url}")
public interface WxSao {

    @RequestMapping(value="/sns/jscode2session", method = RequestMethod.GET)
    String getJscode2session(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String js_code, @RequestParam("grant_type") String grant_type);

}

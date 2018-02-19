package com.baiduAI.app.sao;

import com.baiduAI.app.bean.TemplateBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luoyifei on 2018/2/10.
 */
@FeignClient(value = "wx", url="${wx.api.url}")
public interface WxSao {

    @RequestMapping(value="/cgi-bin/token", method = RequestMethod.GET, produces="application/json", consumes="application/json")
    String getAccessToken(@RequestParam("appid") String appid, @RequestParam("secret") String secret,@RequestParam("grant_type") String grant_type);

    @RequestMapping(value="/sns/jscode2session", method = RequestMethod.GET)
    String getJscode2session(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String js_code, @RequestParam("grant_type") String grant_type);

    @RequestMapping(value="/cgi-bin/message/wxopen/template/send?access_token={access_token}", method = RequestMethod.POST)
    String send(@PathVariable("access_token") String access_token, @RequestBody TemplateBean templateDTO);
}

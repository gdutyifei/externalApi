package com.baiduAI.app.sao;

import com.baiduAI.app.bean.TemplateBean;
import com.baiduAI.app.bean.WxCodeBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luoyifei on 2018/2/10.
 */
@FeignClient(value = "wx", url="${wx.api.url}")
public interface WxSao {

    /**
     * 获取access_token
     * @param appid
     * @param secret
     * @param grant_type
     * @return
     */
    @RequestMapping(value="/cgi-bin/token", method = RequestMethod.GET, produces="application/json", consumes="application/json")
    String getAccessToken(@RequestParam("appid") String appid, @RequestParam("secret") String secret,@RequestParam("grant_type") String grant_type);

    /**
     * 获取openid
     * @param appid
     * @param secret
     * @param js_code
     * @param grant_type
     * @return
     */
    @RequestMapping(value="/sns/jscode2session", method = RequestMethod.GET)
    String getJscode2session(@RequestParam("appid") String appid, @RequestParam("secret") String secret, @RequestParam("js_code") String js_code, @RequestParam("grant_type") String grant_type);

    /**
     * 发送模板消息
     * @param access_token
     * @param templateDTO
     * @return
     */
    @RequestMapping(value="/cgi-bin/message/wxopen/template/send?access_token={access_token}", method = RequestMethod.POST)
    String send(@PathVariable("access_token") String access_token, @RequestBody TemplateBean templateDTO);

    @RequestMapping(value="/wxa/getwxacodeunlimit?access_token={access_token}", method = RequestMethod.POST)
    byte[] getwxacode(@PathVariable("access_token") String access_token, WxCodeBean wxCodeBean );
}

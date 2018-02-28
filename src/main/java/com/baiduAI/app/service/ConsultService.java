package com.baiduAI.app.service;

import com.baiduAI.app.dao.ConsultDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class ConsultService {

    public static final Logger logger = LoggerFactory.getLogger(ConsultService.class);

    @Autowired
    private ConsultDAO consultDAO;

    @Autowired
    private WechatService wechatService;

    public Map<String, Object> saveConsultInfo(@Param("openid") String openid, @Param("salesOpenid") String salesOpenid, @Param("id") Long productId, @Param("name") String name, @Param("tel") String tel, @Param("title") String title, @Param("content") String content) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        consultDAO.saveConsultInfo(openid, salesOpenid, productId, content);

        // 获取当前系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String[] contentArr = new String[5];
        contentArr[0] = name;
        contentArr[1] = tel;
        contentArr[2] = title;
        contentArr[3] = content;
        contentArr[4] = df.format(new Date());
        // 发送模板消息
        Map<String, Object> templateMsg = wechatService.sendTemplateMsg(salesOpenid, contentArr, "consult", "", "B");
        logger.info("发送模板消息返回接口： {}", templateMsg);
        if (StringUtils.equals(templateMsg.get("code").toString(), "200")) {
            returnMap.put("code", 200);
            returnMap.put("msg", "保存咨询信息并发送模板消息成功");
            returnMap.put("data", "");
        } else {
            returnMap.put("code", 200);
            returnMap.put("msg", "保存咨询信息成功， 发送模板消息失败");
            returnMap.put("data", "");
        }

        return returnMap;
    }
}

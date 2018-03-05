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
import java.util.regex.Pattern;

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

        if (StringUtils.isBlank(name) || StringUtils.isEmpty(name)) {
            returnMap.put("code", 1001);
            returnMap.put("msg", "姓名不能为空");
            return returnMap;
        }

        if (StringUtils.isBlank(tel) || StringUtils.isEmpty(tel)) {
            returnMap.put("code", 1002);
            returnMap.put("msg", "手机号码不能为空");
            return returnMap;
        }

        if (! Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$").matcher(tel).matches()) {
            returnMap.put("code", 1003);
            returnMap.put("msg", "手机号码格式错误");
            return returnMap;
        }

        if (StringUtils.isBlank(title) || StringUtils.isEmpty(title)) {
            returnMap.put("code", 1004);
            returnMap.put("msg", "咨询标题不能为空");
            return returnMap;
        }

        if (StringUtils.isBlank(content) || StringUtils.isEmpty(content)) {
            returnMap.put("code", 1005);
            returnMap.put("msg", "咨询内容不能为空");
            return returnMap;
        }


        // 获取当前系统时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String[] contentArr = new String[5];
        contentArr[0] = name;
        contentArr[1] = tel;
        contentArr[2] = title;
        contentArr[3] = content;
        contentArr[4] = df.format(new Date());

        // 保存咨询信息
        consultDAO.saveConsultInfo(openid, salesOpenid, productId, name, tel, content);

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

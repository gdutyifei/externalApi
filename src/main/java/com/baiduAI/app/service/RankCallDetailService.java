package com.baiduAI.app.service;

import com.baiduAI.app.dao.RankCallDetailDAO;
import com.baiduAI.app.dao.RankReadDetailDAO;
import com.baiduAI.app.dao.WechatInfoDAO;
import com.baiduAI.app.dto.WechatDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Created by luoyifei on 2018/2/28.
 */
@Slf4j
@Service
public class RankCallDetailService {

    @Autowired
    private RankCallDetailDAO rankCallDetailDAO;

    @Autowired
    private WechatInfoDAO wechatInfoDAO;

    /**
     * 保存用户拨打电话详细记录
     * @param openid
     * @param sales_id
     */
    public void saveRankCallDetail(@Param("openid") String openid,  @Param("sales_id") Long sales_id, @Param("phone") String phone) throws Exception {
        WechatDTO wechatDTO = wechatInfoDAO.getWechatInfoByOpenid(openid);
        if (wechatDTO == null) {
            throw new Exception("获取不到C端用户微信信息");
        }
        if (! Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$").matcher(phone).matches()) {
            throw new Exception("手机号码格式错误");
        }
        Long cuser_id = wechatDTO.getId();
        rankCallDetailDAO.saveRankCallDetail(openid, cuser_id, sales_id, phone);
    }
}

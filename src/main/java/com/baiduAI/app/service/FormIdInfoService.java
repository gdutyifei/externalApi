package com.baiduAI.app.service;

import com.baiduAI.app.dao.FormIdInfoDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by luoyifei on 2018/2/20.
 */
@Slf4j
@Service
public class FormIdInfoService {

    @Autowired
    private FormIdInfoDAO formIdInfoDAO;

    /**
     * 保存formId
     * @param openid
     * @param formId
     */
    public void saveFormInfo(@Param("openid") String openid, @Param("formId") String formId) {
        formIdInfoDAO.saveFormInfo(openid, formId);
    }
}

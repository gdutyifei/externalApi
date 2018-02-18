package com.baiduAI.app.service;

import com.baiduAI.app.easemob.common.EasemobAPI;
import com.baiduAI.app.easemob.common.OrgInfo;
import com.baiduAI.app.easemob.common.ResponseHandler;
import com.baiduAI.app.easemob.common.TokenUtil;
import io.swagger.client.ApiException;
import io.swagger.client.api.ChatHistoryApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by luoyifei on 2018/2/10.
 */
@Slf4j
@Service
public class EasemobService {


    /**
     * 获取历史信息
     * @param timeStr
     * @return
     */
    public Object getMessageHistory(@RequestParam("timeStr") String timeStr) {
        ResponseHandler responseHandler = new ResponseHandler();
        ChatHistoryApi api = new ChatHistoryApi();
        return responseHandler.handle(new EasemobAPI() {
            @Override
            public Object invokeEasemobAPI() throws ApiException {
                return api.orgNameAppNameChatmessagesTimeGet(OrgInfo.ORG_NAME,OrgInfo.APP_NAME,TokenUtil.getAccessToken(),timeStr);
            }
        });
    }

}

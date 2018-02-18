package com.baiduAI.app.api;

import com.baiduAI.app.service.BaiduAIService;
import com.baiduAI.app.service.EasemobService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by luoyifei on 2018/2/9.
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/easemob/", method = {RequestMethod.GET, RequestMethod.POST})
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EasemobApi {

    public static final Logger logger = LoggerFactory.getLogger(EasemobApi.class);

    @Autowired
    private EasemobService easemobService;

    @RequestMapping("/getMessageHistory")
    public Object getMessageHistory() {
        SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHH");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        String timeStr = SDF.format(calendar.getTime());
        Object result = easemobService.getMessageHistory("2018021414");
        logger.info("结果");
        logger.info(result.toString());
        if (null == result) {
            logger.error("Failed to get expected response by calling GET chatmessages API, maybe there is no chatmessages history at {}", timeStr);
            logger.info("\n**************************\nFor successful response example:"
                    + "\ncurl -H \"Authorization:Bearer xxxxxx\" -XGET http://a1.easemob.com/easemob-demo/chatdemoui/chatmessages/2017072717"
                    + "\n{\n" + "    \"action\": \"get\",\n" + "    \"application\": \"4d7e4ba0-dc4a-11e3-90d5-e1ffbaacdaf5\",\n"
                    + "    \"uri\": \"http://a1.easemob.com/easemob-demo/chatdemoui/chatmessages/2017072717\",\n" + "    \"data\": [\n"
                    + "        {\n"
                    + "            \"url\": \"http://ebs-chatmessage-a1.easemob.com/history/14D/easemob-demo/chatdemoui/2017072717.gz?Expires=1501155823&OSSAccessKeyId=LTAIlKPZStPokdA8&Signature=4iksrdotTr1Y6KVu8zVHPy6MOxw%3D\"\n"
                    + "        }\n" + "    ],\n" + "    \"timestamp\": 1501154023457,\n" + "    \"duration\": 0,\n"
                    + "    \"organization\": \"easemob-demo\",\n" + "    \"applicationName\": \"chatdemoui\"\n" + "}"
                    + "\n**************************");
            return null;
        } else {
            logger.info(result.toString());
            return result;
        }
    }

}

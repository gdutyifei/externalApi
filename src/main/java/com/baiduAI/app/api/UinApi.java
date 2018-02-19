package com.baiduAI.app.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luoyifei on 2018/2/19.
 */
@RestController
@RequestMapping(value = "/api/", method = {RequestMethod.GET, RequestMethod.POST})
public class UinApi {
}

package com.baiduAI.app.util;

import com.alibaba.fastjson.JSONObject;
import com.baiduAI.app.bean.TemplateBean;
import lombok.Data;

/**
 * Created by luoyifei on 2018/2/19.
 */
public class WeixinTemplateNotice {

    private static final String WORDCOLOR = "#000000";

    @Data
    public class CommonNoticeBean {
        /**
         * 三个关键词的模板
         */
        private String keyword1;
        private String keyword2;
        private String keyword3;
        private String touser;
        private String page;
        private String form_id;
        private String template_id;
        private String emphasis_keyword;

        public String getKeyword1() {
            return keyword1;
        }

        public void setKeyword1(String keyword1) {
            this.keyword1 = keyword1;
        }

        public String getKeyword2() {
            return keyword2;
        }

        public void setKeyword2(String keyword2) {
            this.keyword2 = keyword2;
        }

        public String getKeyword3() {
            return keyword3;
        }

        public void setKeyword3(String keyword3) {
            this.keyword3 = keyword3;
        }

        public String getTouser() {
            return touser;
        }

        public void setTouser(String touser) {
            this.touser = touser;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getForm_id() {
            return form_id;
        }

        public void setForm_id(String form_id) {
            this.form_id = form_id;
        }

        public String getTemplate_id() {
            return template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getEmphasis_keyword() {
            return emphasis_keyword;
        }

        public void setEmphasis_keyword(String emphasis_keyword) {
            this.emphasis_keyword = emphasis_keyword;
        }
    }

    @Data
    public class CommonNoticeFourBean {
        /**
         * 四个关键词的模板
         */
        private String keyword1;
        private String keyword2;
        private String keyword3;
        private String keyword4;
        private String touser;
        private String page;
        private String form_id;
        private String template_id;
        private String emphasis_keyword;

        public String getKeyword1() {
            return keyword1;
        }

        public void setKeyword1(String keyword1) {
            this.keyword1 = keyword1;
        }

        public String getKeyword2() {
            return keyword2;
        }

        public void setKeyword2(String keyword2) {
            this.keyword2 = keyword2;
        }

        public String getKeyword3() {
            return keyword3;
        }

        public void setKeyword3(String keyword3) {
            this.keyword3 = keyword3;
        }

        public String getKeyword4() {
            return keyword4;
        }

        public void setKeyword4(String keyword4) {
            this.keyword4 = keyword4;
        }

        public String getTouser() {
            return touser;
        }

        public void setTouser(String touser) {
            this.touser = touser;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getForm_id() {
            return form_id;
        }

        public void setForm_id(String form_id) {
            this.form_id = form_id;
        }

        public String getTemplate_id() {
            return template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getEmphasis_keyword() {
            return emphasis_keyword;
        }

        public void setEmphasis_keyword(String emphasis_keyword) {
            this.emphasis_keyword = emphasis_keyword;
        }
    }

    @Data
    public class CommonNoticeFiveBean {
        /**
         * 五个关键词的模板
         */
        private String keyword1;
        private String keyword2;
        private String keyword3;
        private String keyword4;
        private String keyword5;
        private String touser;
        private String page;
        private String form_id;
        private String template_id;
        private String emphasis_keyword;

        public String getKeyword1() {
            return keyword1;
        }

        public void setKeyword1(String keyword1) {
            this.keyword1 = keyword1;
        }

        public String getKeyword2() {
            return keyword2;
        }

        public void setKeyword2(String keyword2) {
            this.keyword2 = keyword2;
        }

        public String getKeyword3() {
            return keyword3;
        }

        public void setKeyword3(String keyword3) {
            this.keyword3 = keyword3;
        }

        public String getKeyword4() {
            return keyword4;
        }

        public void setKeyword4(String keyword4) {
            this.keyword4 = keyword4;
        }

        public String getKeyword5() {
            return keyword5;
        }

        public void setKeyword5(String keyword5) {
            this.keyword5 = keyword5;
        }

        public String getTouser() {
            return touser;
        }

        public void setTouser(String touser) {
            this.touser = touser;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getForm_id() {
            return form_id;
        }

        public void setForm_id(String form_id) {
            this.form_id = form_id;
        }

        public String getTemplate_id() {
            return template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getEmphasis_keyword() {
            return emphasis_keyword;
        }

        public void setEmphasis_keyword(String emphasis_keyword) {
            this.emphasis_keyword = emphasis_keyword;
        }
    }

    public static TemplateBean sendCommonNotice(CommonNoticeBean bean) {
        TemplateBean td = new TemplateBean();
        td.setEmphasis_keyword(bean.getEmphasis_keyword());
        td.setForm_id(bean.getForm_id());
        td.setPage(bean.getPage());
        td.setTemplate_id(bean.getTemplate_id());
        td.setTouser(bean.getTouser());
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        jo1.put("value", bean.getKeyword1());
        jo1.put("color", WORDCOLOR);
        JSONObject jo2 = new JSONObject();
        jo2.put("value", bean.getKeyword2());
        jo2.put("color", WORDCOLOR);
        JSONObject jo3 = new JSONObject();
        jo3.put("value", bean.getKeyword3());
        jo3.put("color", WORDCOLOR);
        jo.put("keyword1", jo1);
        jo.put("keyword2", jo2);
        jo.put("keyword3", jo3);
        td.setData(jo);
        return td;
    }
    public static TemplateBean sendCommonFourNotice(CommonNoticeFourBean bean) {
        TemplateBean td = new TemplateBean();
        td.setEmphasis_keyword(bean.getEmphasis_keyword());
        td.setForm_id(bean.getForm_id());
        td.setPage(bean.getPage());
        td.setTemplate_id(bean.getTemplate_id());
        td.setTouser(bean.getTouser());
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        jo1.put("value", bean.getKeyword1());
        jo1.put("color", WORDCOLOR);
        JSONObject jo2 = new JSONObject();
        jo2.put("value", bean.getKeyword2());
        jo2.put("color", WORDCOLOR);
        JSONObject jo3 = new JSONObject();
        jo3.put("value", bean.getKeyword3());
        jo3.put("color", WORDCOLOR);
        JSONObject jo4 = new JSONObject();
        jo4.put("value", bean.getKeyword4());
        jo4.put("color", WORDCOLOR);
        jo.put("keyword1", jo1);
        jo.put("keyword2", jo2);
        jo.put("keyword3", jo3);
        jo.put("keyword4", jo4);
        td.setData(jo);
        return td;
    }

    public static TemplateBean sendCommonFiveNotice(CommonNoticeFiveBean bean) {
        TemplateBean td = new TemplateBean();
        td.setEmphasis_keyword(bean.getEmphasis_keyword());
        td.setForm_id(bean.getForm_id());
        td.setPage(bean.getPage());
        td.setTemplate_id(bean.getTemplate_id());
        td.setTouser(bean.getTouser());
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        jo1.put("value", bean.getKeyword1());
        jo1.put("color", WORDCOLOR);
        JSONObject jo2 = new JSONObject();
        jo2.put("value", bean.getKeyword2());
        jo2.put("color", WORDCOLOR);
        JSONObject jo3 = new JSONObject();
        jo3.put("value", bean.getKeyword3());
        jo3.put("color", WORDCOLOR);
        JSONObject jo4 = new JSONObject();
        jo4.put("value", bean.getKeyword4());
        jo4.put("color", WORDCOLOR);
        JSONObject jo5 = new JSONObject();
        jo5.put("value", bean.getKeyword5());
        jo5.put("color", WORDCOLOR);
        jo.put("keyword1", jo1);
        jo.put("keyword2", jo2);
        jo.put("keyword3", jo3);
        jo.put("keyword4", jo4);
        jo.put("keyword5", jo5);
        td.setData(jo);
        return td;
    }
}

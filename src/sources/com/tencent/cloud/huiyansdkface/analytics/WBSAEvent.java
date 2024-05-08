package com.tencent.cloud.huiyansdkface.analytics;

import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WBSAEvent {
    private String bg_duration;
    private String create_ts;
    private String duration;
    private String event_id;
    private String event_name;
    private String event_type;
    private Map<Object, Object> info;
    private String key;
    private String life_id;
    private String page_id;
    private String refer_page_id;
    private String session_id;
    private String value;

    public WBSAEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<Object, Object> map, String str11) {
        this.event_type = str;
        this.event_id = str2;
        this.life_id = str3;
        this.session_id = str4;
        this.create_ts = str5;
        this.page_id = str6;
        this.refer_page_id = str7;
        this.duration = str8;
        this.key = str9;
        this.value = str10;
        this.info = map;
        this.event_name = str11;
    }

    public static WBSAEvent customEvent(String str, String str2, Map<Object, Object> map, Boolean bool, a aVar) {
        String str3;
        String str4;
        if (bool.booleanValue()) {
            str3 = "8";
            str4 = "$Warn";
        } else {
            str3 = "5";
            str4 = "$Track";
        }
        return new WBSAEvent(str3, aVar.d(), aVar.b(), aVar.c(), String.valueOf(System.currentTimeMillis()), null, null, null, str, str2, map, str4);
    }

    private static String eventName(String str) {
        return "$".concat(String.valueOf(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WBSAEvent wBSAEvent = (WBSAEvent) obj;
            if (this.event_type.equals(wBSAEvent.event_type) && this.event_id.equals(wBSAEvent.event_id) && this.create_ts.equals(wBSAEvent.create_ts)) {
                return true;
            }
        }
        return false;
    }

    public String getBg_duration() {
        return this.bg_duration;
    }

    public String getCreate_ts() {
        return this.create_ts;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getEvent_id() {
        return this.event_id;
    }

    public String getEvent_name() {
        return this.event_name;
    }

    public String getEvent_type() {
        return this.event_type;
    }

    public Map<Object, Object> getInfo() {
        return this.info;
    }

    public String getKey() {
        return this.key;
    }

    public String getLife_id() {
        return this.life_id;
    }

    public String getPage_id() {
        return this.page_id;
    }

    public String getRefer_page_id() {
        return this.refer_page_id;
    }

    public String getSession_id() {
        return this.session_id;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(this.event_type, this.event_id, this.create_ts);
    }

    public void setBg_duration(String str) {
        this.bg_duration = str;
    }

    public void setCreate_ts(String str) {
        this.create_ts = str;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setEvent_id(String str) {
        this.event_id = str;
    }

    public void setEvent_name(String str) {
        this.event_name = str;
    }

    public void setEvent_type(String str) {
        this.event_type = str;
    }

    public void setInfo(Map<Object, Object> map) {
        this.info = map;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLife_id(String str) {
        this.life_id = str;
    }

    public void setPage_id(String str) {
        this.page_id = str;
    }

    public void setRefer_page_id(String str) {
        this.refer_page_id = str;
    }

    public void setSession_id(String str) {
        this.session_id = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}

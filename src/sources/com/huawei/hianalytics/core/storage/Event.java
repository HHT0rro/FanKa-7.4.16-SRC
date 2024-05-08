package com.huawei.hianalytics.core.storage;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import e9.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Event implements Cloneable {
    public static final String TAG = "Event";
    public String content;
    public String evtExHashCode;
    public String evtid;
    public String evttime;
    public String evttype;

    /* renamed from: id, reason: collision with root package name */
    public Long f28743id;
    public String processname;
    public String servicetag;
    public String sessionid;
    public String sessionname;

    public Event() {
    }

    public void formJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.evtid = jSONObject.optString("event");
            this.evttime = jSONObject.optString("eventtime");
            this.evttype = jSONObject.optString("type");
            if (!TextUtils.isEmpty("nc_common_flag")) {
                this.evtExHashCode = jSONObject.optString("nc_common_flag");
            }
            if (!TextUtils.isEmpty(jSONObject.optString("first_session_event"))) {
                this.sessionid = jSONObject.optString("first_session_event");
            }
            if (TextUtils.isEmpty(jSONObject.optString("event_session_name"))) {
                return;
            }
            this.sessionname = jSONObject.optString("event_session_name");
        }
    }

    public String getContent() {
        return this.content;
    }

    public String getEvtExHashCode() {
        return this.evtExHashCode;
    }

    public String getEvtid() {
        return this.evtid;
    }

    public String getEvttime() {
        return this.evttime;
    }

    public String getEvttype() {
        return this.evttype;
    }

    public Long getId() {
        return this.f28743id;
    }

    public String getProcessname() {
        return this.processname;
    }

    public String getServicetag() {
        return this.servicetag;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public String getSessionname() {
        return this.sessionname;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEvtExHashCode(String str) {
        this.evtExHashCode = str;
    }

    public void setEvtid(String str) {
        this.evtid = str;
    }

    public void setEvttime(String str) {
        this.evttime = str;
    }

    public void setEvttype(String str) {
        this.evttype = str;
    }

    public void setId(Long l10) {
        this.f28743id = l10;
    }

    public void setProcessname(String str) {
        this.processname = str;
    }

    public void setServicetag(String str) {
        this.servicetag = str;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }

    public void setSessionname(String str) {
        this.sessionname = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.evttype);
            jSONObject.put("eventtime", this.evttime);
            jSONObject.put("event", this.evtid);
            jSONObject.put("event_session_name", this.sessionname);
            jSONObject.put("first_session_event", this.sessionid);
            String str = this.content;
            if (str != null && !str.isEmpty()) {
                jSONObject.put("properties", new JSONObject(this.content));
                return jSONObject;
            }
            HiLog.sw(TAG, "content is empty: evtId:" + this.evtid);
            return null;
        } catch (JSONException e2) {
            StringBuilder b4 = a.b("JSONException: ");
            b4.append(e2.getMessage());
            HiLog.e(TAG, b4.toString());
            return null;
        }
    }

    public Event(Long l10, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f28743id = l10;
        this.evtid = str;
        this.evttype = str2;
        this.content = str3;
        this.evttime = str4;
        this.servicetag = str5;
        this.sessionid = str6;
        this.sessionname = str7;
        this.evtExHashCode = str8;
        this.processname = str9;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Event m2858clone() {
        return (Event) super.clone();
    }
}

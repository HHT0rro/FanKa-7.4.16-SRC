package com.heytap.msp.push.mode;

import android.text.TextUtils;
import org.json.JSONObject;
import y8.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MessageStat {
    private static final String APP_PACKAGE = "appPackage";
    private static final String EVENT_ID = "eventID";
    private static final String EVENT_TIME = "eventTime";
    private static final String GLOBAL_ID = "globalID";
    private static final String MESSAGE_TYPE = "messageType";
    private static final String PROPERTY = "property";
    private static final String TASK_ID = "taskID";
    private String mAppPackage;
    private String mEventId;
    private long mEventTime;
    private String mGlobalId;
    private String mProperty;
    private String mTaskID;
    private int mType;

    public MessageStat() {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
    }

    public MessageStat(int i10, String str, String str2, String str3) {
        this(i10, str, null, null, str2, str3);
    }

    public MessageStat(int i10, String str, String str2, String str3, String str4, String str5) {
        this.mType = 4096;
        this.mEventTime = System.currentTimeMillis();
        setType(i10);
        setAppPackage(str);
        setGlobalId(str2);
        setTaskID(str3);
        setEventId(str4);
        setProperty(str5);
    }

    public MessageStat(String str, String str2) {
        this(4096, str, null, null, str2, "");
    }

    public MessageStat(String str, String str2, String str3) {
        this(4096, str, null, null, str2, str3);
    }

    public static MessageStat parse(String str) {
        MessageStat messageStat = new MessageStat();
        try {
            JSONObject jSONObject = new JSONObject(str);
            messageStat.setType(jSONObject.optInt(MESSAGE_TYPE, 0));
            messageStat.setAppPackage(jSONObject.optString(APP_PACKAGE));
            messageStat.setEventId(jSONObject.optString(EVENT_ID));
            messageStat.setGlobalId(jSONObject.optString(GLOBAL_ID, ""));
            messageStat.setTaskID(jSONObject.optString(TASK_ID, ""));
            messageStat.setProperty(jSONObject.optString(PROPERTY, ""));
            messageStat.setEventTime(jSONObject.optLong(EVENT_TIME, System.currentTimeMillis()));
            return messageStat;
        } catch (Exception e2) {
            c.b(e2.getLocalizedMessage());
            return null;
        }
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public String getGlobalId() {
        return this.mGlobalId;
    }

    public String getProperty() {
        return this.mProperty;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public int getType() {
        return this.mType;
    }

    public void setAppPackage(String str) {
        this.mAppPackage = str;
    }

    public void setEventId(String str) {
        this.mEventId = str;
    }

    public void setEventTime(long j10) {
        this.mEventTime = j10;
    }

    public void setGlobalId(String str) {
        this.mGlobalId = str;
    }

    public void setProperty(String str) {
        this.mProperty = str;
    }

    public void setTaskID(int i10) {
        this.mTaskID = i10 + "";
    }

    public void setTaskID(String str) {
        this.mTaskID = str;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public String toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MESSAGE_TYPE, Integer.valueOf(this.mType));
            jSONObject.putOpt(EVENT_ID, this.mEventId);
            jSONObject.putOpt(APP_PACKAGE, this.mAppPackage);
            jSONObject.putOpt(EVENT_TIME, Long.valueOf(this.mEventTime));
            if (!TextUtils.isEmpty(this.mGlobalId)) {
                jSONObject.putOpt(GLOBAL_ID, this.mGlobalId);
            }
            if (!TextUtils.isEmpty(this.mTaskID)) {
                jSONObject.putOpt(TASK_ID, this.mTaskID);
            }
            if (!TextUtils.isEmpty(this.mProperty)) {
                jSONObject.putOpt(PROPERTY, this.mProperty);
            }
        } catch (Exception e2) {
            c.b(e2.getLocalizedMessage());
        }
        return jSONObject.toString();
    }
}

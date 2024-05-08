package com.huawei.hms.support.api.entity.push;

import com.alipay.sdk.util.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AttributionReportReq implements IMessageEntity {

    @Packed
    public String appVersion;

    @Packed
    public String campaignId;

    @Packed
    public int eventId;

    @Packed
    public String haStorageId;

    @Packed
    public String msgId;

    @Packed
    public String pkgName;

    @Packed
    public String reqPermission;

    @Packed
    public long timeStamp;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public int getEventId() {
        return this.eventId;
    }

    public String getHaStorageId() {
        return this.haStorageId;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getReqPermission() {
        return this.reqPermission;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setEventId(int i10) {
        this.eventId = i10;
    }

    public void setHaStorageId(String str) {
        this.haStorageId = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setReqPermission(String str) {
        this.reqPermission = str;
    }

    public void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        return " { eventId:" + this.eventId + " pkgName:" + this.pkgName + i.f4738d;
    }
}

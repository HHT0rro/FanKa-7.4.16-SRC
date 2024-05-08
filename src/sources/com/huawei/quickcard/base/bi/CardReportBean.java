package com.huawei.quickcard.base.bi;

import android.text.TextUtils;
import com.huawei.quickcard.base.utils.QuickReportUtils;
import java.util.LinkedHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardReportBean {

    /* renamed from: a, reason: collision with root package name */
    private int f33292a;

    /* renamed from: b, reason: collision with root package name */
    private long f33293b;

    /* renamed from: c, reason: collision with root package name */
    private long f33294c;

    /* renamed from: d, reason: collision with root package name */
    private long f33295d;

    /* renamed from: e, reason: collision with root package name */
    private String f33296e;

    /* renamed from: f, reason: collision with root package name */
    private String f33297f;

    /* renamed from: g, reason: collision with root package name */
    private String f33298g;

    /* renamed from: h, reason: collision with root package name */
    private String f33299h;

    /* renamed from: i, reason: collision with root package name */
    private String f33300i;

    /* renamed from: j, reason: collision with root package name */
    private String f33301j;

    /* renamed from: k, reason: collision with root package name */
    private int f33302k;

    /* renamed from: l, reason: collision with root package name */
    private String f33303l;

    /* renamed from: m, reason: collision with root package name */
    private String f33304m;

    public LinkedHashMap<String, String> convertToMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("TYPE", this.f33296e);
        linkedHashMap.put("STARTTS", QuickReportUtils.formatTime(this.f33293b));
        linkedHashMap.put("ENDTS", QuickReportUtils.formatTime(this.f33294c));
        linkedHashMap.put("ERRORCODE", "" + this.f33292a);
        linkedHashMap.put("DESCRIPTION", this.f33297f);
        linkedHashMap.put("deviceModel", this.f33298g);
        linkedHashMap.put("EngineVer", "" + this.f33295d);
        if (!TextUtils.isEmpty(this.f33299h)) {
            linkedHashMap.put("quickCardUri", this.f33299h);
        }
        linkedHashMap.put("hostPkg", this.f33300i);
        linkedHashMap.put("hostVer", this.f33301j);
        if (!TextUtils.isEmpty(this.f33303l)) {
            linkedHashMap.put("Network", this.f33303l);
        }
        if (!TextUtils.isEmpty(this.f33304m)) {
            linkedHashMap.put("storeUrl", this.f33304m);
        }
        int i10 = this.f33302k;
        if (i10 > 0) {
            linkedHashMap.put("retryTimes", String.valueOf(i10));
        }
        return linkedHashMap;
    }

    public String getDeviceModel() {
        return this.f33298g;
    }

    public long getEndTime() {
        return this.f33294c;
    }

    public long getEngineVersion() {
        return this.f33295d;
    }

    public int getErrorCode() {
        return this.f33292a;
    }

    public String getErrorMsg() {
        return this.f33297f;
    }

    public String getHostPkg() {
        return this.f33300i;
    }

    public String getHostVer() {
        return this.f33301j;
    }

    public String getNetwork() {
        return this.f33303l;
    }

    public String getQuickCardUri() {
        return this.f33299h;
    }

    public int getRetryTimes() {
        return this.f33302k;
    }

    public long getStartTime() {
        return this.f33293b;
    }

    public String getStoreUrl() {
        return this.f33304m;
    }

    public String getType() {
        return this.f33296e;
    }

    public void setDeviceModel(String str) {
        this.f33298g = str;
    }

    public void setEndTime(long j10) {
        this.f33294c = j10;
    }

    public void setEngineVersion(long j10) {
        this.f33295d = j10;
    }

    public void setErrorCode(int i10) {
        this.f33292a = i10;
    }

    public void setErrorMsg(String str) {
        this.f33297f = str;
    }

    public void setHostPkg(String str) {
        this.f33300i = str;
    }

    public void setHostVer(String str) {
        this.f33301j = str;
    }

    public void setNetwork(String str) {
        this.f33303l = str;
    }

    public void setQuickCardUri(String str) {
        this.f33299h = str;
    }

    public void setRetryTimes(int i10) {
        this.f33302k = i10;
    }

    public void setStartTime(long j10) {
        this.f33293b = j10;
    }

    public void setStoreUrl(String str) {
        this.f33304m = str;
    }

    public void setType(String str) {
        this.f33296e = str;
    }
}

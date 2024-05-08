package com.huawei.hms.ads.consent.bean.network;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ApiStatisticsReq {
    private String apiName;
    private long callTime = System.currentTimeMillis();
    private long costTime;
    private String params;
    private int result;
    private int resultCode;
    private String service;

    @AllApi
    public String getApiName() {
        return this.apiName;
    }

    @AllApi
    public long getCallTime() {
        return this.callTime;
    }

    @AllApi
    public long getCostTime() {
        return this.costTime;
    }

    @AllApi
    public String getParams() {
        return this.params;
    }

    @AllApi
    public int getResult() {
        return this.result;
    }

    @AllApi
    public int getResultCode() {
        return this.resultCode;
    }

    @AllApi
    public String getService() {
        return this.service;
    }

    @AllApi
    public void setApiName(String str) {
        this.apiName = str;
    }

    @AllApi
    public void setCallTime(long j10) {
        this.callTime = j10;
    }

    @AllApi
    public void setCostTime(long j10) {
        this.costTime = j10;
    }

    @AllApi
    public void setParams(String str) {
        this.params = str;
    }

    @AllApi
    public void setResult(int i10) {
        this.result = i10;
    }

    @AllApi
    public void setResultCode(int i10) {
        this.resultCode = i10;
    }

    @AllApi
    public void setService(String str) {
        this.service = str;
    }
}

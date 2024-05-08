package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ApiStatisticsReq {
    private String additionId;
    private String apiName;
    private String contentId;
    private long costTime;
    private DelayInfo delayInfo;
    private String isLimitTracking;
    private String oaid;
    private String params;
    private String requestId;
    private int result;
    private int resultCode;
    private String service;
    private long callTime = System.currentTimeMillis();
    private int adType = -1;

    public long B() {
        return this.callTime;
    }

    public void B(String str) {
        this.oaid = str;
    }

    public long C() {
        return this.costTime;
    }

    public void C(String str) {
        this.isLimitTracking = str;
    }

    public String Code() {
        return this.service;
    }

    public void Code(int i10) {
        this.result = i10;
    }

    public void Code(long j10) {
        this.callTime = j10;
    }

    public void Code(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    public void Code(String str) {
        this.service = str;
    }

    public String D() {
        return this.oaid;
    }

    public String F() {
        return this.additionId;
    }

    public void F(String str) {
        this.contentId = str;
    }

    public int I() {
        return this.result;
    }

    public void I(int i10) {
        this.adType = i10;
    }

    public void I(String str) {
        this.params = str;
    }

    public String L() {
        return this.isLimitTracking;
    }

    public String S() {
        return this.params;
    }

    public void S(String str) {
        this.requestId = str;
    }

    public String V() {
        return this.apiName;
    }

    public void V(int i10) {
        this.resultCode = i10;
    }

    public void V(long j10) {
        this.costTime = j10;
    }

    public void V(String str) {
        this.apiName = str;
    }

    public int Z() {
        return this.resultCode;
    }

    public void Z(String str) {
        this.additionId = str;
    }

    public String a() {
        return this.requestId;
    }

    public int b() {
        return this.adType;
    }

    public String c() {
        return this.contentId;
    }

    public DelayInfo d() {
        return this.delayInfo;
    }
}

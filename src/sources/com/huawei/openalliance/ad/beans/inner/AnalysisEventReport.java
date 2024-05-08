package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.inter.data.AdContentData;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AnalysisEventReport {
    private AdContentData adData;
    private String analysisType;
    private int apiVer;
    private String contentId;
    private long duration;
    private int errorCode;
    private long expireTime;
    private int extra;
    private String extraStr1;
    private String extraStr2;
    private String extraStr3;
    private long extraTime1;
    private String slotId;
    private String templateId;
    private String url;

    public String B() {
        return this.analysisType;
    }

    public void B(String str) {
        this.extraStr3 = str;
    }

    public long C() {
        return this.expireTime;
    }

    public void C(String str) {
        this.contentId = str;
    }

    public String Code() {
        return this.url;
    }

    public void Code(int i10) {
        this.errorCode = i10;
    }

    public void Code(long j10) {
        this.expireTime = j10;
    }

    public void Code(AdContentData adContentData) {
        this.adData = adContentData;
    }

    public void Code(String str) {
        this.url = str;
    }

    public String D() {
        return this.extraStr3;
    }

    public String F() {
        return this.extraStr2;
    }

    public void F(String str) {
        this.slotId = str;
    }

    public int I() {
        return this.extra;
    }

    public void I(int i10) {
        this.apiVer = i10;
    }

    public void I(long j10) {
        this.extraTime1 = j10;
    }

    public void I(String str) {
        this.extraStr1 = str;
    }

    public long L() {
        return this.duration;
    }

    public String S() {
        return this.extraStr1;
    }

    public void S(String str) {
        this.templateId = str;
    }

    public int V() {
        return this.errorCode;
    }

    public void V(int i10) {
        this.extra = i10;
    }

    public void V(long j10) {
        this.duration = j10;
    }

    public void V(String str) {
        this.analysisType = str;
    }

    public AdContentData Z() {
        return this.adData;
    }

    public void Z(String str) {
        this.extraStr2 = str;
    }

    public long a() {
        return this.extraTime1;
    }

    public String b() {
        return this.contentId;
    }

    public String c() {
        return this.templateId;
    }

    public String d() {
        return this.slotId;
    }

    public int e() {
        return this.apiVer;
    }
}

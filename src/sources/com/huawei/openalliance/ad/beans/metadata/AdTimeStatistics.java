package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AdTimeStatistics implements Serializable {
    private static final long serialVersionUID = 5562197861234973073L;
    public long adInfoPrepEndTS;
    public long adLoadEndTS;
    public long adLoadStartTS;
    public long adNetReqEndTS;
    public long adNetReqStartTS;
    public long adPhyReqEndTS;
    public long adPhyReqStartTS;
    public long adRspParseEndTS;
    public long adRspParseStartTS;
    public long kitSdkIPCEndTS;
    public long kitSdkIPCStartTS;
    public long sdkKitIPCEndTS;
    public long sdkKitIPCStartTS;
    public long splashAdDownloadTS;
    public long splashAdMaterialLoadedTS;

    public long B() {
        return this.adPhyReqEndTS;
    }

    public void B(long j10) {
        this.adPhyReqEndTS = j10;
    }

    public long C() {
        return this.adNetReqStartTS;
    }

    public void C(long j10) {
        this.adNetReqStartTS = j10;
    }

    public long Code() {
        return this.adLoadStartTS;
    }

    public void Code(long j10) {
        this.adLoadStartTS = j10;
    }

    public long D() {
        return this.adRspParseEndTS;
    }

    public void D(long j10) {
        this.adRspParseEndTS = j10;
    }

    public long F() {
        return this.adRspParseStartTS;
    }

    public void F(long j10) {
        this.adRspParseStartTS = j10;
    }

    public long I() {
        return this.adInfoPrepEndTS;
    }

    public void I(long j10) {
        this.adInfoPrepEndTS = j10;
    }

    public long L() {
        return this.sdkKitIPCStartTS;
    }

    public void L(long j10) {
        this.sdkKitIPCStartTS = j10;
    }

    public long S() {
        return this.adNetReqEndTS;
    }

    public void S(long j10) {
        this.adNetReqEndTS = j10;
    }

    public long V() {
        return this.adLoadEndTS;
    }

    public void V(long j10) {
        this.adLoadEndTS = j10;
    }

    public long Z() {
        return this.adPhyReqStartTS;
    }

    public void Z(long j10) {
        this.adPhyReqStartTS = j10;
    }

    public long a() {
        return this.sdkKitIPCEndTS;
    }

    public void a(long j10) {
        this.sdkKitIPCEndTS = j10;
    }

    public long b() {
        return this.kitSdkIPCStartTS;
    }

    public void b(long j10) {
        this.kitSdkIPCStartTS = j10;
    }

    public long c() {
        return this.kitSdkIPCEndTS;
    }

    public void c(long j10) {
        this.kitSdkIPCEndTS = j10;
    }

    public long d() {
        return this.splashAdDownloadTS;
    }

    public void d(long j10) {
        this.splashAdDownloadTS = j10;
    }

    public long e() {
        return this.splashAdMaterialLoadedTS;
    }

    public void e(long j10) {
        this.splashAdMaterialLoadedTS = j10;
    }
}

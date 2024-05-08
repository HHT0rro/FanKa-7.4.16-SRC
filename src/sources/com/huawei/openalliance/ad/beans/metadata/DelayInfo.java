package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;
import java.util.List;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DelayInfo implements Serializable {
    private static final int AD_LOAD_TIMEOUT_AFTER_RESPONSE = 20;
    private static final int AD_LOAD_TIMEOUT_BEFORE_RESPONSE = 10;
    private static final long serialVersionUID = 5993297861234973073L;
    private Integer adAmount;
    private Long adContentRspParseDuration;
    private Long adFilterDuration;
    private List<String> adIds;
    private long adLoadEndTimestamp;
    private Long adRequestBeforeCost;
    private Long adRequestDuration;
    private long adResponseTime;
    private String contentDownMethod;
    private List<String> contentIds;
    private String costFromServer;
    private Integer creativeType;
    private Integer detailedRetCode;
    private Long e2eDuration;
    private int exSplashFlag;
    private Long resDownloadDuration;
    private int resultCode;
    private Long splashContentLoadedCost;
    private Long splashLoadDuration;
    private Long splashLoadMaterialCost;
    private String splashShowMode;
    private Long threadSwitchCost;
    private long uiThreadSwithCostTime;
    private boolean isSpare = false;
    private AdTimeStatistics timeStatistics = new AdTimeStatistics();

    private Long B(long j10, long j11) {
        if (j10 == 0 || j10 >= j11) {
            return null;
        }
        return Long.valueOf(j11 - j10);
    }

    public long B() {
        Long l10 = this.threadSwitchCost;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void B(long j10) {
        this.adContentRspParseDuration = Long.valueOf(j10);
    }

    public long C() {
        Long l10 = this.adContentRspParseDuration;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void C(long j10) {
        this.resDownloadDuration = Long.valueOf(j10);
    }

    public Long Code() {
        return B(this.timeStatistics.Code(), this.timeStatistics.V());
    }

    public void Code(int i10) {
        this.adAmount = Integer.valueOf(i10);
    }

    public void Code(long j10) {
        this.adRequestDuration = Long.valueOf(j10);
    }

    public void Code(long j10, long j11) {
        this.splashLoadDuration = B(j10, j11);
        this.timeStatistics.d(j11);
        this.timeStatistics.c(j11);
    }

    public void Code(AdTimeStatistics adTimeStatistics) {
        this.timeStatistics = adTimeStatistics;
    }

    public void Code(Integer num) {
        this.creativeType = num;
    }

    public void Code(Long l10) {
        this.e2eDuration = l10;
    }

    public void Code(String str) {
        this.splashShowMode = str;
    }

    public void Code(List<String> list) {
        this.adIds = list;
    }

    public void Code(boolean z10) {
        this.isSpare = z10;
    }

    public int D() {
        Integer num = this.adAmount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void D(long j10) {
        this.uiThreadSwithCostTime = j10;
    }

    public List<String> F() {
        return this.contentIds;
    }

    public void F(long j10) {
        this.adResponseTime = j10;
    }

    public long I() {
        Long l10 = this.adFilterDuration;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void I(int i10) {
        this.resultCode = i10;
    }

    public void I(long j10) {
        this.adRequestBeforeCost = Long.valueOf(j10);
    }

    public void I(long j10, long j11) {
        this.splashLoadMaterialCost = B(j10, j11);
        this.timeStatistics.e(j11);
    }

    public void I(String str) {
        this.costFromServer = str;
    }

    public long L() {
        Long l10 = this.splashLoadDuration;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void L(long j10) {
        this.adLoadEndTimestamp = j10;
    }

    public List<String> S() {
        return this.adIds;
    }

    public void S(long j10) {
        this.e2eDuration = Long.valueOf(j10);
    }

    public long V() {
        Long l10 = this.adRequestDuration;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void V(int i10) {
        this.exSplashFlag = i10;
    }

    public void V(long j10) {
        this.adFilterDuration = Long.valueOf(j10);
    }

    public void V(long j10, long j11) {
        this.adLoadEndTimestamp = j11;
        this.e2eDuration = B(j10, j11);
        this.timeStatistics.Code(j10);
        this.timeStatistics.V(j11);
    }

    public void V(Integer num) {
        this.detailedRetCode = num;
    }

    public void V(Long l10) {
        this.splashLoadDuration = l10;
    }

    public void V(String str) {
        this.contentDownMethod = str;
    }

    public void V(List<String> list) {
        this.contentIds = list;
    }

    public long Z() {
        Long l10 = this.adRequestBeforeCost;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public void Z(long j10) {
        this.threadSwitchCost = Long.valueOf(j10);
    }

    public void Z(long j10, long j11) {
        if (j10 <= 0 || j10 >= j11) {
            return;
        }
        this.splashContentLoadedCost = Long.valueOf(j11 - j10);
    }

    public String a() {
        return this.splashShowMode;
    }

    public String b() {
        return this.contentDownMethod;
    }

    public long c() {
        Long l10 = this.resDownloadDuration;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public long d() {
        Long l10 = this.splashLoadMaterialCost;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public int e() {
        return this.exSplashFlag;
    }

    public int f() {
        return this.resultCode;
    }

    public Long g() {
        return Long.valueOf(this.adResponseTime);
    }

    public boolean h() {
        return this.isSpare;
    }

    public int i() {
        long j10 = this.adLoadEndTimestamp;
        if (j10 == 0) {
            return 0;
        }
        long j11 = this.adResponseTime;
        if (j11 == 0) {
            return 0;
        }
        return j10 <= j11 ? 10 : 20;
    }

    public AdTimeStatistics j() {
        return this.timeStatistics;
    }

    public Integer k() {
        return this.creativeType;
    }

    public Integer l() {
        return this.detailedRetCode;
    }

    public String m() {
        return this.costFromServer;
    }

    public long n() {
        return this.uiThreadSwithCostTime;
    }

    public long o() {
        return this.adLoadEndTimestamp;
    }
}

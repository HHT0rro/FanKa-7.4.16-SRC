package com.cupidapp.live.startup.model;

import b2.a;
import com.cupidapp.live.startup.splashad.FKBaseSplashAd;
import com.cupidapp.live.startup.splashad.HuaweiJHSplashAd;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SplashAdRequestModel implements Serializable {

    @NotNull
    private final FKStartupMediaConfigModel configModel;
    private final boolean isCache;
    private final boolean isSuccess;
    private long mAdShowTime;
    private final int price;

    @Nullable
    private final String reason;
    private final long reqReturnTime;

    @Nullable
    private final FKBaseSplashAd splashAd;
    private final long startReqTime;

    public SplashAdRequestModel(@Nullable FKBaseSplashAd fKBaseSplashAd, boolean z10, int i10, long j10, long j11, @Nullable String str, @NotNull FKStartupMediaConfigModel configModel, boolean z11) {
        s.i(configModel, "configModel");
        this.splashAd = fKBaseSplashAd;
        this.isSuccess = z10;
        this.price = i10;
        this.startReqTime = j10;
        this.reqReturnTime = j11;
        this.reason = str;
        this.configModel = configModel;
        this.isCache = z11;
    }

    @Nullable
    public final FKBaseSplashAd component1() {
        return this.splashAd;
    }

    public final boolean component2() {
        return this.isSuccess;
    }

    public final int component3() {
        return this.price;
    }

    public final long component4() {
        return this.startReqTime;
    }

    public final long component5() {
        return this.reqReturnTime;
    }

    @Nullable
    public final String component6() {
        return this.reason;
    }

    @NotNull
    public final FKStartupMediaConfigModel component7() {
        return this.configModel;
    }

    public final boolean component8() {
        return this.isCache;
    }

    @NotNull
    public final SplashAdRequestModel copy(@Nullable FKBaseSplashAd fKBaseSplashAd, boolean z10, int i10, long j10, long j11, @Nullable String str, @NotNull FKStartupMediaConfigModel configModel, boolean z11) {
        s.i(configModel, "configModel");
        return new SplashAdRequestModel(fKBaseSplashAd, z10, i10, j10, j11, str, configModel, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplashAdRequestModel)) {
            return false;
        }
        SplashAdRequestModel splashAdRequestModel = (SplashAdRequestModel) obj;
        return s.d(this.splashAd, splashAdRequestModel.splashAd) && this.isSuccess == splashAdRequestModel.isSuccess && this.price == splashAdRequestModel.price && this.startReqTime == splashAdRequestModel.startReqTime && this.reqReturnTime == splashAdRequestModel.reqReturnTime && s.d(this.reason, splashAdRequestModel.reason) && s.d(this.configModel, splashAdRequestModel.configModel) && this.isCache == splashAdRequestModel.isCache;
    }

    public final long getAdReqDuration() {
        return this.reqReturnTime - this.startReqTime;
    }

    public final long getAdReturnToShowDuration() {
        return System.currentTimeMillis() - this.reqReturnTime;
    }

    public final long getAdShowToEndDuration() {
        return System.currentTimeMillis() - this.mAdShowTime;
    }

    @NotNull
    public final FKStartupMediaConfigModel getConfigModel() {
        return this.configModel;
    }

    public final long getMAdShowTime() {
        return this.mAdShowTime;
    }

    public final int getPrice() {
        return this.price;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    public final long getReqReturnTime() {
        return this.reqReturnTime;
    }

    @Nullable
    public final FKBaseSplashAd getSplashAd() {
        return this.splashAd;
    }

    public final long getStartReqTime() {
        return this.startReqTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        FKBaseSplashAd fKBaseSplashAd = this.splashAd;
        int hashCode = (fKBaseSplashAd == null ? 0 : fKBaseSplashAd.hashCode()) * 31;
        boolean z10 = this.isSuccess;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int a10 = (((((((hashCode + i10) * 31) + this.price) * 31) + a.a(this.startReqTime)) * 31) + a.a(this.reqReturnTime)) * 31;
        String str = this.reason;
        int hashCode2 = (((a10 + (str != null ? str.hashCode() : 0)) * 31) + this.configModel.hashCode()) * 31;
        boolean z11 = this.isCache;
        return hashCode2 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isCache() {
        return this.isCache;
    }

    public final boolean isNotHuaweiJHSplashAd() {
        return !(this.splashAd instanceof HuaweiJHSplashAd);
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final void setMAdShowTime(long j10) {
        this.mAdShowTime = j10;
    }

    @NotNull
    public String toString() {
        FKBaseSplashAd fKBaseSplashAd = this.splashAd;
        boolean z10 = this.isSuccess;
        int i10 = this.price;
        long j10 = this.startReqTime;
        long j11 = this.reqReturnTime;
        String str = this.reason;
        FKStartupMediaConfigModel fKStartupMediaConfigModel = this.configModel;
        return "SplashAdRequestModel(splashAd=" + ((Object) fKBaseSplashAd) + ", isSuccess=" + z10 + ", price=" + i10 + ", startReqTime=" + j10 + ", reqReturnTime=" + j11 + ", reason=" + str + ", configModel=" + ((Object) fKStartupMediaConfigModel) + ", isCache=" + this.isCache + ")";
    }
}

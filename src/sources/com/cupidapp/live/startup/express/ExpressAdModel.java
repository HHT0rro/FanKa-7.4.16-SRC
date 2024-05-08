package com.cupidapp.live.startup.express;

import com.cupidapp.live.startup.model.FkAdModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKExpressAdManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ExpressAdModel {

    @Nullable
    private FkAdModel adModel;

    @Nullable
    private FKBaseExpressAd baseExpressAd;
    private int reqCount;

    @Nullable
    private String reqId;

    public ExpressAdModel() {
        this(null, null, null, 0, 15, null);
    }

    public ExpressAdModel(@Nullable FkAdModel fkAdModel, @Nullable FKBaseExpressAd fKBaseExpressAd, @Nullable String str, int i10) {
        this.adModel = fkAdModel;
        this.baseExpressAd = fKBaseExpressAd;
        this.reqId = str;
        this.reqCount = i10;
    }

    public static /* synthetic */ ExpressAdModel copy$default(ExpressAdModel expressAdModel, FkAdModel fkAdModel, FKBaseExpressAd fKBaseExpressAd, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            fkAdModel = expressAdModel.adModel;
        }
        if ((i11 & 2) != 0) {
            fKBaseExpressAd = expressAdModel.baseExpressAd;
        }
        if ((i11 & 4) != 0) {
            str = expressAdModel.reqId;
        }
        if ((i11 & 8) != 0) {
            i10 = expressAdModel.reqCount;
        }
        return expressAdModel.copy(fkAdModel, fKBaseExpressAd, str, i10);
    }

    @Nullable
    public final FkAdModel component1() {
        return this.adModel;
    }

    @Nullable
    public final FKBaseExpressAd component2() {
        return this.baseExpressAd;
    }

    @Nullable
    public final String component3() {
        return this.reqId;
    }

    public final int component4() {
        return this.reqCount;
    }

    @NotNull
    public final ExpressAdModel copy(@Nullable FkAdModel fkAdModel, @Nullable FKBaseExpressAd fKBaseExpressAd, @Nullable String str, int i10) {
        return new ExpressAdModel(fkAdModel, fKBaseExpressAd, str, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpressAdModel)) {
            return false;
        }
        ExpressAdModel expressAdModel = (ExpressAdModel) obj;
        return s.d(this.adModel, expressAdModel.adModel) && s.d(this.baseExpressAd, expressAdModel.baseExpressAd) && s.d(this.reqId, expressAdModel.reqId) && this.reqCount == expressAdModel.reqCount;
    }

    @Nullable
    public final FkAdModel getAdModel() {
        return this.adModel;
    }

    @Nullable
    public final FKBaseExpressAd getBaseExpressAd() {
        return this.baseExpressAd;
    }

    public final int getReqCount() {
        return this.reqCount;
    }

    @Nullable
    public final String getReqId() {
        return this.reqId;
    }

    public int hashCode() {
        FkAdModel fkAdModel = this.adModel;
        int hashCode = (fkAdModel == null ? 0 : fkAdModel.hashCode()) * 31;
        FKBaseExpressAd fKBaseExpressAd = this.baseExpressAd;
        int hashCode2 = (hashCode + (fKBaseExpressAd == null ? 0 : fKBaseExpressAd.hashCode())) * 31;
        String str = this.reqId;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.reqCount;
    }

    public final void setAdModel(@Nullable FkAdModel fkAdModel) {
        this.adModel = fkAdModel;
    }

    public final void setBaseExpressAd(@Nullable FKBaseExpressAd fKBaseExpressAd) {
        this.baseExpressAd = fKBaseExpressAd;
    }

    public final void setReqCount(int i10) {
        this.reqCount = i10;
    }

    public final void setReqId(@Nullable String str) {
        this.reqId = str;
    }

    @NotNull
    public String toString() {
        FkAdModel fkAdModel = this.adModel;
        FKBaseExpressAd fKBaseExpressAd = this.baseExpressAd;
        return "ExpressAdModel(adModel=" + ((Object) fkAdModel) + ", baseExpressAd=" + ((Object) fKBaseExpressAd) + ", reqId=" + this.reqId + ", reqCount=" + this.reqCount + ")";
    }

    public /* synthetic */ ExpressAdModel(FkAdModel fkAdModel, FKBaseExpressAd fKBaseExpressAd, String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : fkAdModel, (i11 & 2) != 0 ? null : fKBaseExpressAd, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? 0 : i10);
    }
}

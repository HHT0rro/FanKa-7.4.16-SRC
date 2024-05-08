package com.cupidapp.live.startup.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AdResourceModel {

    @NotNull
    private final List<ApiAdContentModel> ads;

    @NotNull
    private final String bidId;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f18438id;

    public AdResourceModel(@NotNull List<ApiAdContentModel> ads, @NotNull String bidId, @NotNull String id2) {
        s.i(ads, "ads");
        s.i(bidId, "bidId");
        s.i(id2, "id");
        this.ads = ads;
        this.bidId = bidId;
        this.f18438id = id2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdResourceModel copy$default(AdResourceModel adResourceModel, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = adResourceModel.ads;
        }
        if ((i10 & 2) != 0) {
            str = adResourceModel.bidId;
        }
        if ((i10 & 4) != 0) {
            str2 = adResourceModel.f18438id;
        }
        return adResourceModel.copy(list, str, str2);
    }

    @NotNull
    public final List<ApiAdContentModel> component1() {
        return this.ads;
    }

    @NotNull
    public final String component2() {
        return this.bidId;
    }

    @NotNull
    public final String component3() {
        return this.f18438id;
    }

    @NotNull
    public final AdResourceModel copy(@NotNull List<ApiAdContentModel> ads, @NotNull String bidId, @NotNull String id2) {
        s.i(ads, "ads");
        s.i(bidId, "bidId");
        s.i(id2, "id");
        return new AdResourceModel(ads, bidId, id2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdResourceModel)) {
            return false;
        }
        AdResourceModel adResourceModel = (AdResourceModel) obj;
        return s.d(this.ads, adResourceModel.ads) && s.d(this.bidId, adResourceModel.bidId) && s.d(this.f18438id, adResourceModel.f18438id);
    }

    @NotNull
    public final List<ApiAdContentModel> getAds() {
        return this.ads;
    }

    @NotNull
    public final String getBidId() {
        return this.bidId;
    }

    @NotNull
    public final String getId() {
        return this.f18438id;
    }

    public int hashCode() {
        return (((this.ads.hashCode() * 31) + this.bidId.hashCode()) * 31) + this.f18438id.hashCode();
    }

    @NotNull
    public String toString() {
        List<ApiAdContentModel> list = this.ads;
        return "AdResourceModel(ads=" + ((Object) list) + ", bidId=" + this.bidId + ", id=" + this.f18438id + ")";
    }
}

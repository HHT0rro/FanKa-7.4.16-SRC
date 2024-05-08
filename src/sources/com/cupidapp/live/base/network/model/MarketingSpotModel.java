package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MarketingSpotModel {

    @Nullable
    private final String actName;

    @Nullable
    private final String url;

    public MarketingSpotModel(@Nullable String str, @Nullable String str2) {
        this.url = str;
        this.actName = str2;
    }

    public static /* synthetic */ MarketingSpotModel copy$default(MarketingSpotModel marketingSpotModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = marketingSpotModel.url;
        }
        if ((i10 & 2) != 0) {
            str2 = marketingSpotModel.actName;
        }
        return marketingSpotModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.actName;
    }

    @NotNull
    public final MarketingSpotModel copy(@Nullable String str, @Nullable String str2) {
        return new MarketingSpotModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarketingSpotModel)) {
            return false;
        }
        MarketingSpotModel marketingSpotModel = (MarketingSpotModel) obj;
        return s.d(this.url, marketingSpotModel.url) && s.d(this.actName, marketingSpotModel.actName);
    }

    @Nullable
    public final String getActName() {
        return this.actName;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.actName;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MarketingSpotModel(url=" + this.url + ", actName=" + this.actName + ")";
    }
}

package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipDiscountPromptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MarketPopInfoModel {

    @Nullable
    private final String url;

    public MarketPopInfoModel(@Nullable String str) {
        this.url = str;
    }

    public static /* synthetic */ MarketPopInfoModel copy$default(MarketPopInfoModel marketPopInfoModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = marketPopInfoModel.url;
        }
        return marketPopInfoModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final MarketPopInfoModel copy(@Nullable String str) {
        return new MarketPopInfoModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MarketPopInfoModel) && s.d(this.url, ((MarketPopInfoModel) obj).url);
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "MarketPopInfoModel(url=" + this.url + ")";
    }
}

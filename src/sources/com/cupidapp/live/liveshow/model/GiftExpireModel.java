package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftExpireModel implements Serializable {
    private final int count;

    @NotNull
    private final String expireTime;

    public GiftExpireModel(@NotNull String expireTime, int i10) {
        s.i(expireTime, "expireTime");
        this.expireTime = expireTime;
        this.count = i10;
    }

    public static /* synthetic */ GiftExpireModel copy$default(GiftExpireModel giftExpireModel, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = giftExpireModel.expireTime;
        }
        if ((i11 & 2) != 0) {
            i10 = giftExpireModel.count;
        }
        return giftExpireModel.copy(str, i10);
    }

    @NotNull
    public final String component1() {
        return this.expireTime;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final GiftExpireModel copy(@NotNull String expireTime, int i10) {
        s.i(expireTime, "expireTime");
        return new GiftExpireModel(expireTime, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftExpireModel)) {
            return false;
        }
        GiftExpireModel giftExpireModel = (GiftExpireModel) obj;
        return s.d(this.expireTime, giftExpireModel.expireTime) && this.count == giftExpireModel.count;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getExpireTime() {
        return this.expireTime;
    }

    public int hashCode() {
        return (this.expireTime.hashCode() * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "GiftExpireModel(expireTime=" + this.expireTime + ", count=" + this.count + ")";
    }
}

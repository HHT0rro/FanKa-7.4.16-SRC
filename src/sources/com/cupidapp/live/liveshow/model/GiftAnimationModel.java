package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGiftModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftAnimationModel {

    @Nullable
    private final String animationKey;

    @Nullable
    private final String soundKey;

    public GiftAnimationModel(@Nullable String str, @Nullable String str2) {
        this.animationKey = str;
        this.soundKey = str2;
    }

    public static /* synthetic */ GiftAnimationModel copy$default(GiftAnimationModel giftAnimationModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftAnimationModel.animationKey;
        }
        if ((i10 & 2) != 0) {
            str2 = giftAnimationModel.soundKey;
        }
        return giftAnimationModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.animationKey;
    }

    @Nullable
    public final String component2() {
        return this.soundKey;
    }

    @NotNull
    public final GiftAnimationModel copy(@Nullable String str, @Nullable String str2) {
        return new GiftAnimationModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftAnimationModel)) {
            return false;
        }
        GiftAnimationModel giftAnimationModel = (GiftAnimationModel) obj;
        return s.d(this.animationKey, giftAnimationModel.animationKey) && s.d(this.soundKey, giftAnimationModel.soundKey);
    }

    @Nullable
    public final String getAnimationKey() {
        return this.animationKey;
    }

    @Nullable
    public final String getSoundKey() {
        return this.soundKey;
    }

    public int hashCode() {
        String str = this.animationKey;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.soundKey;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GiftAnimationModel(animationKey=" + this.animationKey + ", soundKey=" + this.soundKey + ")";
    }
}

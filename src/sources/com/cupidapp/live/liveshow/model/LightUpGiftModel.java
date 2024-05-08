package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LightUpGiftModel {

    @NotNull
    private final ImageModel giftIcon;
    private final boolean light;

    public LightUpGiftModel(@NotNull ImageModel giftIcon, boolean z10) {
        s.i(giftIcon, "giftIcon");
        this.giftIcon = giftIcon;
        this.light = z10;
    }

    public static /* synthetic */ LightUpGiftModel copy$default(LightUpGiftModel lightUpGiftModel, ImageModel imageModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = lightUpGiftModel.giftIcon;
        }
        if ((i10 & 2) != 0) {
            z10 = lightUpGiftModel.light;
        }
        return lightUpGiftModel.copy(imageModel, z10);
    }

    @NotNull
    public final ImageModel component1() {
        return this.giftIcon;
    }

    public final boolean component2() {
        return this.light;
    }

    @NotNull
    public final LightUpGiftModel copy(@NotNull ImageModel giftIcon, boolean z10) {
        s.i(giftIcon, "giftIcon");
        return new LightUpGiftModel(giftIcon, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LightUpGiftModel)) {
            return false;
        }
        LightUpGiftModel lightUpGiftModel = (LightUpGiftModel) obj;
        return s.d(this.giftIcon, lightUpGiftModel.giftIcon) && this.light == lightUpGiftModel.light;
    }

    @NotNull
    public final ImageModel getGiftIcon() {
        return this.giftIcon;
    }

    public final boolean getLight() {
        return this.light;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.giftIcon.hashCode() * 31;
        boolean z10 = this.light;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.giftIcon;
        return "LightUpGiftModel(giftIcon=" + ((Object) imageModel) + ", light=" + this.light + ")";
    }
}

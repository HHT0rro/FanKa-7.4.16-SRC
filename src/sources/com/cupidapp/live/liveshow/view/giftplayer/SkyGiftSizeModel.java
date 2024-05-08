package com.cupidapp.live.liveshow.view.giftplayer;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SkyGiftLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SkyGiftSizeModel {
    private final int descMarginEnd;
    private final int height;

    public SkyGiftSizeModel(int i10, int i11) {
        this.height = i10;
        this.descMarginEnd = i11;
    }

    public static /* synthetic */ SkyGiftSizeModel copy$default(SkyGiftSizeModel skyGiftSizeModel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = skyGiftSizeModel.height;
        }
        if ((i12 & 2) != 0) {
            i11 = skyGiftSizeModel.descMarginEnd;
        }
        return skyGiftSizeModel.copy(i10, i11);
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.descMarginEnd;
    }

    @NotNull
    public final SkyGiftSizeModel copy(int i10, int i11) {
        return new SkyGiftSizeModel(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkyGiftSizeModel)) {
            return false;
        }
        SkyGiftSizeModel skyGiftSizeModel = (SkyGiftSizeModel) obj;
        return this.height == skyGiftSizeModel.height && this.descMarginEnd == skyGiftSizeModel.descMarginEnd;
    }

    public final int getDescMarginEnd() {
        return this.descMarginEnd;
    }

    public final int getHeight() {
        return this.height;
    }

    public int hashCode() {
        return (this.height * 31) + this.descMarginEnd;
    }

    @NotNull
    public String toString() {
        return "SkyGiftSizeModel(height=" + this.height + ", descMarginEnd=" + this.descMarginEnd + ")";
    }
}

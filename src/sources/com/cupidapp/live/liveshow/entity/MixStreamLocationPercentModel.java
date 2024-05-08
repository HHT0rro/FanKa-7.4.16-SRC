package com.cupidapp.live.liveshow.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ZGMixStreamPublisher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MixStreamLocationPercentModel {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public MixStreamLocationPercentModel(float f10, float f11, float f12, float f13) {
        this.left = f10;
        this.top = f11;
        this.right = f12;
        this.bottom = f13;
    }

    public static /* synthetic */ MixStreamLocationPercentModel copy$default(MixStreamLocationPercentModel mixStreamLocationPercentModel, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = mixStreamLocationPercentModel.left;
        }
        if ((i10 & 2) != 0) {
            f11 = mixStreamLocationPercentModel.top;
        }
        if ((i10 & 4) != 0) {
            f12 = mixStreamLocationPercentModel.right;
        }
        if ((i10 & 8) != 0) {
            f13 = mixStreamLocationPercentModel.bottom;
        }
        return mixStreamLocationPercentModel.copy(f10, f11, f12, f13);
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    @NotNull
    public final MixStreamLocationPercentModel copy(float f10, float f11, float f12, float f13) {
        return new MixStreamLocationPercentModel(f10, f11, f12, f13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MixStreamLocationPercentModel)) {
            return false;
        }
        MixStreamLocationPercentModel mixStreamLocationPercentModel = (MixStreamLocationPercentModel) obj;
        return Float.compare(this.left, mixStreamLocationPercentModel.left) == 0 && Float.compare(this.top, mixStreamLocationPercentModel.top) == 0 && Float.compare(this.right, mixStreamLocationPercentModel.right) == 0 && Float.compare(this.bottom, mixStreamLocationPercentModel.bottom) == 0;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom);
    }

    @NotNull
    public String toString() {
        return "MixStreamLocationPercentModel(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
    }
}

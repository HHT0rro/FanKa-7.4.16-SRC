package com.cupidapp.live.liveshow.entity;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ZGMixStreamPublisher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MixStreamLayoutModel {
    private final float height;

    @NotNull
    private final String liveShowId;
    private final float width;

    /* renamed from: x, reason: collision with root package name */
    private final float f14914x;

    /* renamed from: y, reason: collision with root package name */
    private final float f14915y;

    public MixStreamLayoutModel(@NotNull String liveShowId, float f10, float f11, float f12, float f13) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.f14914x = f10;
        this.f14915y = f11;
        this.width = f12;
        this.height = f13;
    }

    public static /* synthetic */ MixStreamLayoutModel copy$default(MixStreamLayoutModel mixStreamLayoutModel, String str, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mixStreamLayoutModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            f10 = mixStreamLayoutModel.f14914x;
        }
        float f14 = f10;
        if ((i10 & 4) != 0) {
            f11 = mixStreamLayoutModel.f14915y;
        }
        float f15 = f11;
        if ((i10 & 8) != 0) {
            f12 = mixStreamLayoutModel.width;
        }
        float f16 = f12;
        if ((i10 & 16) != 0) {
            f13 = mixStreamLayoutModel.height;
        }
        return mixStreamLayoutModel.copy(str, f14, f15, f16, f13);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    public final float component2() {
        return this.f14914x;
    }

    public final float component3() {
        return this.f14915y;
    }

    public final float component4() {
        return this.width;
    }

    public final float component5() {
        return this.height;
    }

    @NotNull
    public final MixStreamLayoutModel copy(@NotNull String liveShowId, float f10, float f11, float f12, float f13) {
        s.i(liveShowId, "liveShowId");
        return new MixStreamLayoutModel(liveShowId, f10, f11, f12, f13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MixStreamLayoutModel)) {
            return false;
        }
        MixStreamLayoutModel mixStreamLayoutModel = (MixStreamLayoutModel) obj;
        return s.d(this.liveShowId, mixStreamLayoutModel.liveShowId) && Float.compare(this.f14914x, mixStreamLayoutModel.f14914x) == 0 && Float.compare(this.f14915y, mixStreamLayoutModel.f14915y) == 0 && Float.compare(this.width, mixStreamLayoutModel.width) == 0 && Float.compare(this.height, mixStreamLayoutModel.height) == 0;
    }

    public final float getHeight() {
        return this.height;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getX() {
        return this.f14914x;
    }

    public final float getY() {
        return this.f14915y;
    }

    public int hashCode() {
        return (((((((this.liveShowId.hashCode() * 31) + Float.floatToIntBits(this.f14914x)) * 31) + Float.floatToIntBits(this.f14915y)) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height);
    }

    @NotNull
    public String toString() {
        return "MixStreamLayoutModel(liveShowId=" + this.liveShowId + ", x=" + this.f14914x + ", y=" + this.f14915y + ", width=" + this.width + ", height=" + this.height + ")";
    }
}

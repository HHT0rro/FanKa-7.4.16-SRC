package com.cupidapp.live.base.imageloader;

import androidx.annotation.ColorInt;
import com.cupidapp.live.base.utils.h;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageLoaderOptions.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RoundCornerModel {
    private final int borderColor;
    private final int borderWidth;
    private final int radius;
    private boolean roundAsCircle;
    private final boolean roundBottomLeft;
    private final boolean roundBottomRight;
    private final boolean roundTopLeft;
    private final boolean roundTopRight;

    public RoundCornerModel() {
        this(false, 0, 0, 0, false, false, false, false, 255, null);
    }

    public RoundCornerModel(boolean z10, int i10, int i11, @ColorInt int i12, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.roundAsCircle = z10;
        this.radius = i10;
        this.borderWidth = i11;
        this.borderColor = i12;
        this.roundTopLeft = z11;
        this.roundTopRight = z12;
        this.roundBottomRight = z13;
        this.roundBottomLeft = z14;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final boolean getRoundAsCircle() {
        return this.roundAsCircle;
    }

    public final boolean getRoundBottomLeft() {
        return this.roundBottomLeft;
    }

    public final boolean getRoundBottomRight() {
        return this.roundBottomRight;
    }

    public final boolean getRoundTopLeft() {
        return this.roundTopLeft;
    }

    public final boolean getRoundTopRight() {
        return this.roundTopRight;
    }

    public final boolean isAllRoundCorner() {
        return this.radius > 0 && this.roundTopLeft && this.roundTopRight && this.roundBottomRight && this.roundBottomLeft;
    }

    public final void setRoundAsCircle(boolean z10) {
        this.roundAsCircle = z10;
    }

    public /* synthetic */ RoundCornerModel(boolean z10, int i10, int i11, int i12, boolean z11, boolean z12, boolean z13, boolean z14, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? false : z10, (i13 & 2) != 0 ? 0 : i10, (i13 & 4) == 0 ? i11 : 0, (i13 & 8) != 0 ? h.a(-16777216, 0.1f) : i12, (i13 & 16) != 0 ? true : z11, (i13 & 32) != 0 ? true : z12, (i13 & 64) != 0 ? true : z13, (i13 & 128) == 0 ? z14 : true);
    }
}

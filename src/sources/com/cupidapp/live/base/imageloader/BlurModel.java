package com.cupidapp.live.base.imageloader;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageLoaderOptions.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BlurModel {
    private final float radius;
    private final int sampling;

    public BlurModel() {
        this(0.0f, 0, 3, null);
    }

    public BlurModel(float f10, int i10) {
        this.radius = f10;
        this.sampling = i10;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getSampling() {
        return this.sampling;
    }

    public /* synthetic */ BlurModel(float f10, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 25.0f : f10, (i11 & 2) != 0 ? 4 : i10);
    }
}

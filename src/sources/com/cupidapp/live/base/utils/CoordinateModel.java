package com.cupidapp.live.base.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CoordinateModel {
    private final double latitude;
    private final double longitude;

    public CoordinateModel() {
        this(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, 3, null);
    }

    public CoordinateModel(double d10, double d11) {
        this.latitude = d10;
        this.longitude = d11;
    }

    public static /* synthetic */ CoordinateModel copy$default(CoordinateModel coordinateModel, double d10, double d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = coordinateModel.latitude;
        }
        if ((i10 & 2) != 0) {
            d11 = coordinateModel.longitude;
        }
        return coordinateModel.copy(d10, d11);
    }

    public final double component1() {
        return this.latitude;
    }

    public final double component2() {
        return this.longitude;
    }

    @NotNull
    public final CoordinateModel copy(double d10, double d11) {
        return new CoordinateModel(d10, d11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoordinateModel)) {
            return false;
        }
        CoordinateModel coordinateModel = (CoordinateModel) obj;
        return Double.compare(this.latitude, coordinateModel.latitude) == 0 && Double.compare(this.longitude, coordinateModel.longitude) == 0;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return (ce.d.a(this.latitude) * 31) + ce.d.a(this.longitude);
    }

    @NotNull
    public String toString() {
        return "CoordinateModel(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
    }

    public /* synthetic */ CoordinateModel(double d10, double d11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0.0d : d10, (i10 & 2) != 0 ? 0.0d : d11);
    }
}

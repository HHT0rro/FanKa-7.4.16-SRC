package com.cupidapp.live.flutter.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseTransModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RoamingTransModel extends BaseTransModel {

    @NotNull
    private final String cityName;

    public RoamingTransModel(@NotNull String cityName) {
        s.i(cityName, "cityName");
        this.cityName = cityName;
    }

    public static /* synthetic */ RoamingTransModel copy$default(RoamingTransModel roamingTransModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = roamingTransModel.cityName;
        }
        return roamingTransModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.cityName;
    }

    @NotNull
    public final RoamingTransModel copy(@NotNull String cityName) {
        s.i(cityName, "cityName");
        return new RoamingTransModel(cityName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RoamingTransModel) && s.d(this.cityName, ((RoamingTransModel) obj).cityName);
    }

    @NotNull
    public final String getCityName() {
        return this.cityName;
    }

    public int hashCode() {
        return this.cityName.hashCode();
    }

    @NotNull
    public String toString() {
        return "RoamingTransModel(cityName=" + this.cityName + ")";
    }
}

package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByFloatModel {

    @Nullable
    private final MapOverPopResult result;

    public NearByFloatModel(@Nullable MapOverPopResult mapOverPopResult) {
        this.result = mapOverPopResult;
    }

    public static /* synthetic */ NearByFloatModel copy$default(NearByFloatModel nearByFloatModel, MapOverPopResult mapOverPopResult, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mapOverPopResult = nearByFloatModel.result;
        }
        return nearByFloatModel.copy(mapOverPopResult);
    }

    @Nullable
    public final MapOverPopResult component1() {
        return this.result;
    }

    @NotNull
    public final NearByFloatModel copy(@Nullable MapOverPopResult mapOverPopResult) {
        return new NearByFloatModel(mapOverPopResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NearByFloatModel) && s.d(this.result, ((NearByFloatModel) obj).result);
    }

    @Nullable
    public final MapOverPopResult getResult() {
        return this.result;
    }

    public int hashCode() {
        MapOverPopResult mapOverPopResult = this.result;
        if (mapOverPopResult == null) {
            return 0;
        }
        return mapOverPopResult.hashCode();
    }

    @NotNull
    public String toString() {
        return "NearByFloatModel(result=" + ((Object) this.result) + ")";
    }
}

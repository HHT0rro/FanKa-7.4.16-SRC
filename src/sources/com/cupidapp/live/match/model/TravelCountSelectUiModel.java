package com.cupidapp.live.match.model;

import com.amap.api.maps.model.LatLng;
import com.amap.api.services.geocoder.RegeocodeAddress;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelMapModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelCountSelectUiModel {

    @Nullable
    private final RegeocodeAddress adress;

    @NotNull
    private final CheckTravelUseResult countModel;

    @NotNull
    private final LatLng latLng;

    public TravelCountSelectUiModel(@NotNull CheckTravelUseResult countModel, @NotNull LatLng latLng, @Nullable RegeocodeAddress regeocodeAddress) {
        s.i(countModel, "countModel");
        s.i(latLng, "latLng");
        this.countModel = countModel;
        this.latLng = latLng;
        this.adress = regeocodeAddress;
    }

    public static /* synthetic */ TravelCountSelectUiModel copy$default(TravelCountSelectUiModel travelCountSelectUiModel, CheckTravelUseResult checkTravelUseResult, LatLng latLng, RegeocodeAddress regeocodeAddress, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            checkTravelUseResult = travelCountSelectUiModel.countModel;
        }
        if ((i10 & 2) != 0) {
            latLng = travelCountSelectUiModel.latLng;
        }
        if ((i10 & 4) != 0) {
            regeocodeAddress = travelCountSelectUiModel.adress;
        }
        return travelCountSelectUiModel.copy(checkTravelUseResult, latLng, regeocodeAddress);
    }

    @NotNull
    public final CheckTravelUseResult component1() {
        return this.countModel;
    }

    @NotNull
    public final LatLng component2() {
        return this.latLng;
    }

    @Nullable
    public final RegeocodeAddress component3() {
        return this.adress;
    }

    @NotNull
    public final TravelCountSelectUiModel copy(@NotNull CheckTravelUseResult countModel, @NotNull LatLng latLng, @Nullable RegeocodeAddress regeocodeAddress) {
        s.i(countModel, "countModel");
        s.i(latLng, "latLng");
        return new TravelCountSelectUiModel(countModel, latLng, regeocodeAddress);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TravelCountSelectUiModel)) {
            return false;
        }
        TravelCountSelectUiModel travelCountSelectUiModel = (TravelCountSelectUiModel) obj;
        return s.d(this.countModel, travelCountSelectUiModel.countModel) && s.d(this.latLng, travelCountSelectUiModel.latLng) && s.d(this.adress, travelCountSelectUiModel.adress);
    }

    @Nullable
    public final RegeocodeAddress getAdress() {
        return this.adress;
    }

    @NotNull
    public final CheckTravelUseResult getCountModel() {
        return this.countModel;
    }

    @NotNull
    public final LatLng getLatLng() {
        return this.latLng;
    }

    public int hashCode() {
        int hashCode = ((this.countModel.hashCode() * 31) + this.latLng.hashCode()) * 31;
        RegeocodeAddress regeocodeAddress = this.adress;
        return hashCode + (regeocodeAddress == null ? 0 : regeocodeAddress.hashCode());
    }

    @NotNull
    public String toString() {
        return "TravelCountSelectUiModel(countModel=" + ((Object) this.countModel) + ", latLng=" + ((Object) this.latLng) + ", adress=" + ((Object) this.adress) + ")";
    }
}

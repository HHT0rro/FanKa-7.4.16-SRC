package com.cupidapp.live.match.event;

import com.cupidapp.live.match.model.RegionModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChooseAreaResultEvent {

    @Nullable
    private RegionModel region;

    public ChooseAreaResultEvent(@Nullable RegionModel regionModel) {
        this.region = regionModel;
    }

    public static /* synthetic */ ChooseAreaResultEvent copy$default(ChooseAreaResultEvent chooseAreaResultEvent, RegionModel regionModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            regionModel = chooseAreaResultEvent.region;
        }
        return chooseAreaResultEvent.copy(regionModel);
    }

    @Nullable
    public final RegionModel component1() {
        return this.region;
    }

    @NotNull
    public final ChooseAreaResultEvent copy(@Nullable RegionModel regionModel) {
        return new ChooseAreaResultEvent(regionModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChooseAreaResultEvent) && s.d(this.region, ((ChooseAreaResultEvent) obj).region);
    }

    @Nullable
    public final RegionModel getRegion() {
        return this.region;
    }

    public int hashCode() {
        RegionModel regionModel = this.region;
        if (regionModel == null) {
            return 0;
        }
        return regionModel.hashCode();
    }

    public final void setRegion(@Nullable RegionModel regionModel) {
        this.region = regionModel;
    }

    @NotNull
    public String toString() {
        return "ChooseAreaResultEvent(region=" + ((Object) this.region) + ")";
    }
}

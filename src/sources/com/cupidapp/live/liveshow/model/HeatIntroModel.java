package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HeatIntroModel implements Serializable {

    @NotNull
    private final List<HeatItemModel> heatValuesDescs;

    public HeatIntroModel(@NotNull List<HeatItemModel> heatValuesDescs) {
        s.i(heatValuesDescs, "heatValuesDescs");
        this.heatValuesDescs = heatValuesDescs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeatIntroModel copy$default(HeatIntroModel heatIntroModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = heatIntroModel.heatValuesDescs;
        }
        return heatIntroModel.copy(list);
    }

    @NotNull
    public final List<HeatItemModel> component1() {
        return this.heatValuesDescs;
    }

    @NotNull
    public final HeatIntroModel copy(@NotNull List<HeatItemModel> heatValuesDescs) {
        s.i(heatValuesDescs, "heatValuesDescs");
        return new HeatIntroModel(heatValuesDescs);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HeatIntroModel) && s.d(this.heatValuesDescs, ((HeatIntroModel) obj).heatValuesDescs);
    }

    @NotNull
    public final List<HeatItemModel> getHeatValuesDescs() {
        return this.heatValuesDescs;
    }

    public int hashCode() {
        return this.heatValuesDescs.hashCode();
    }

    @NotNull
    public String toString() {
        return "HeatIntroModel(heatValuesDescs=" + ((Object) this.heatValuesDescs) + ")";
    }
}

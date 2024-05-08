package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HeatValuesModel implements Serializable {
    private final int dynamic;
    private final int fixed;

    @Nullable
    private final String increment;
    private final int total;

    public HeatValuesModel(int i10, int i11, int i12, @Nullable String str) {
        this.total = i10;
        this.fixed = i11;
        this.dynamic = i12;
        this.increment = str;
    }

    public static /* synthetic */ HeatValuesModel copy$default(HeatValuesModel heatValuesModel, int i10, int i11, int i12, String str, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = heatValuesModel.total;
        }
        if ((i13 & 2) != 0) {
            i11 = heatValuesModel.fixed;
        }
        if ((i13 & 4) != 0) {
            i12 = heatValuesModel.dynamic;
        }
        if ((i13 & 8) != 0) {
            str = heatValuesModel.increment;
        }
        return heatValuesModel.copy(i10, i11, i12, str);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.fixed;
    }

    public final int component3() {
        return this.dynamic;
    }

    @Nullable
    public final String component4() {
        return this.increment;
    }

    @NotNull
    public final HeatValuesModel copy(int i10, int i11, int i12, @Nullable String str) {
        return new HeatValuesModel(i10, i11, i12, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeatValuesModel)) {
            return false;
        }
        HeatValuesModel heatValuesModel = (HeatValuesModel) obj;
        return this.total == heatValuesModel.total && this.fixed == heatValuesModel.fixed && this.dynamic == heatValuesModel.dynamic && s.d(this.increment, heatValuesModel.increment);
    }

    public final int getDynamic() {
        return this.dynamic;
    }

    public final int getFixed() {
        return this.fixed;
    }

    @Nullable
    public final String getIncrement() {
        return this.increment;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int i10 = ((((this.total * 31) + this.fixed) * 31) + this.dynamic) * 31;
        String str = this.increment;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "HeatValuesModel(total=" + this.total + ", fixed=" + this.fixed + ", dynamic=" + this.dynamic + ", increment=" + this.increment + ")";
    }
}

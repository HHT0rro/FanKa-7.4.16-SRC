package com.cupidapp.live.liveshow.view.dialog;

import com.cupidapp.live.liveshow.model.HeatValuesModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveHeatCountDesDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowLiveHeatCountEvent {

    @Nullable
    private final HeatValuesModel heatValuesModel;
    private final boolean needShow;

    public ShowLiveHeatCountEvent(@Nullable HeatValuesModel heatValuesModel, boolean z10) {
        this.heatValuesModel = heatValuesModel;
        this.needShow = z10;
    }

    public static /* synthetic */ ShowLiveHeatCountEvent copy$default(ShowLiveHeatCountEvent showLiveHeatCountEvent, HeatValuesModel heatValuesModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            heatValuesModel = showLiveHeatCountEvent.heatValuesModel;
        }
        if ((i10 & 2) != 0) {
            z10 = showLiveHeatCountEvent.needShow;
        }
        return showLiveHeatCountEvent.copy(heatValuesModel, z10);
    }

    @Nullable
    public final HeatValuesModel component1() {
        return this.heatValuesModel;
    }

    public final boolean component2() {
        return this.needShow;
    }

    @NotNull
    public final ShowLiveHeatCountEvent copy(@Nullable HeatValuesModel heatValuesModel, boolean z10) {
        return new ShowLiveHeatCountEvent(heatValuesModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowLiveHeatCountEvent)) {
            return false;
        }
        ShowLiveHeatCountEvent showLiveHeatCountEvent = (ShowLiveHeatCountEvent) obj;
        return s.d(this.heatValuesModel, showLiveHeatCountEvent.heatValuesModel) && this.needShow == showLiveHeatCountEvent.needShow;
    }

    @Nullable
    public final HeatValuesModel getHeatValuesModel() {
        return this.heatValuesModel;
    }

    public final boolean getNeedShow() {
        return this.needShow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        HeatValuesModel heatValuesModel = this.heatValuesModel;
        int hashCode = (heatValuesModel == null ? 0 : heatValuesModel.hashCode()) * 31;
        boolean z10 = this.needShow;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        HeatValuesModel heatValuesModel = this.heatValuesModel;
        return "ShowLiveHeatCountEvent(heatValuesModel=" + ((Object) heatValuesModel) + ", needShow=" + this.needShow + ")";
    }
}

package com.cupidapp.live.setting.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushPauseOptionModel {

    @Nullable
    private String countdown;
    private int pushCurrentLabelId;

    @NotNull
    private List<PushLabelModel> pushPauseLabels;

    public PushPauseOptionModel(@Nullable String str, int i10, @NotNull List<PushLabelModel> pushPauseLabels) {
        s.i(pushPauseLabels, "pushPauseLabels");
        this.countdown = str;
        this.pushCurrentLabelId = i10;
        this.pushPauseLabels = pushPauseLabels;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushPauseOptionModel copy$default(PushPauseOptionModel pushPauseOptionModel, String str, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = pushPauseOptionModel.countdown;
        }
        if ((i11 & 2) != 0) {
            i10 = pushPauseOptionModel.pushCurrentLabelId;
        }
        if ((i11 & 4) != 0) {
            list = pushPauseOptionModel.pushPauseLabels;
        }
        return pushPauseOptionModel.copy(str, i10, list);
    }

    @Nullable
    public final String component1() {
        return this.countdown;
    }

    public final int component2() {
        return this.pushCurrentLabelId;
    }

    @NotNull
    public final List<PushLabelModel> component3() {
        return this.pushPauseLabels;
    }

    @NotNull
    public final PushPauseOptionModel copy(@Nullable String str, int i10, @NotNull List<PushLabelModel> pushPauseLabels) {
        s.i(pushPauseLabels, "pushPauseLabels");
        return new PushPauseOptionModel(str, i10, pushPauseLabels);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushPauseOptionModel)) {
            return false;
        }
        PushPauseOptionModel pushPauseOptionModel = (PushPauseOptionModel) obj;
        return s.d(this.countdown, pushPauseOptionModel.countdown) && this.pushCurrentLabelId == pushPauseOptionModel.pushCurrentLabelId && s.d(this.pushPauseLabels, pushPauseOptionModel.pushPauseLabels);
    }

    @Nullable
    public final String getCountdown() {
        return this.countdown;
    }

    public final int getPushCurrentLabelId() {
        return this.pushCurrentLabelId;
    }

    @NotNull
    public final List<PushLabelModel> getPushPauseLabels() {
        return this.pushPauseLabels;
    }

    public int hashCode() {
        String str = this.countdown;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.pushCurrentLabelId) * 31) + this.pushPauseLabels.hashCode();
    }

    public final void setCountdown(@Nullable String str) {
        this.countdown = str;
    }

    public final void setPushCurrentLabelId(int i10) {
        this.pushCurrentLabelId = i10;
    }

    public final void setPushPauseLabels(@NotNull List<PushLabelModel> list) {
        s.i(list, "<set-?>");
        this.pushPauseLabels = list;
    }

    @NotNull
    public String toString() {
        return "PushPauseOptionModel(countdown=" + this.countdown + ", pushCurrentLabelId=" + this.pushCurrentLabelId + ", pushPauseLabels=" + ((Object) this.pushPauseLabels) + ")";
    }

    public /* synthetic */ PushPauseOptionModel(String str, int i10, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, i10, list);
    }
}

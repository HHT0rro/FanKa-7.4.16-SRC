package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushLabelModel {
    private boolean checked;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private Integer f18201id;

    @NotNull
    private String label;
    private boolean pushEnableLocation;

    public PushLabelModel(@Nullable Integer num, @NotNull String label, boolean z10, boolean z11) {
        s.i(label, "label");
        this.f18201id = num;
        this.label = label;
        this.checked = z10;
        this.pushEnableLocation = z11;
    }

    public static /* synthetic */ PushLabelModel copy$default(PushLabelModel pushLabelModel, Integer num, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = pushLabelModel.f18201id;
        }
        if ((i10 & 2) != 0) {
            str = pushLabelModel.label;
        }
        if ((i10 & 4) != 0) {
            z10 = pushLabelModel.checked;
        }
        if ((i10 & 8) != 0) {
            z11 = pushLabelModel.pushEnableLocation;
        }
        return pushLabelModel.copy(num, str, z10, z11);
    }

    @Nullable
    public final Integer component1() {
        return this.f18201id;
    }

    @NotNull
    public final String component2() {
        return this.label;
    }

    public final boolean component3() {
        return this.checked;
    }

    public final boolean component4() {
        return this.pushEnableLocation;
    }

    @NotNull
    public final PushLabelModel copy(@Nullable Integer num, @NotNull String label, boolean z10, boolean z11) {
        s.i(label, "label");
        return new PushLabelModel(num, label, z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushLabelModel)) {
            return false;
        }
        PushLabelModel pushLabelModel = (PushLabelModel) obj;
        return s.d(this.f18201id, pushLabelModel.f18201id) && s.d(this.label, pushLabelModel.label) && this.checked == pushLabelModel.checked && this.pushEnableLocation == pushLabelModel.pushEnableLocation;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    @Nullable
    public final Integer getId() {
        return this.f18201id;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final boolean getPushEnableLocation() {
        return this.pushEnableLocation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.f18201id;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.label.hashCode()) * 31;
        boolean z10 = this.checked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.pushEnableLocation;
        return i11 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    public final void setId(@Nullable Integer num) {
        this.f18201id = num;
    }

    public final void setLabel(@NotNull String str) {
        s.i(str, "<set-?>");
        this.label = str;
    }

    public final void setPushEnableLocation(boolean z10) {
        this.pushEnableLocation = z10;
    }

    @NotNull
    public String toString() {
        Integer num = this.f18201id;
        return "PushLabelModel(id=" + ((Object) num) + ", label=" + this.label + ", checked=" + this.checked + ", pushEnableLocation=" + this.pushEnableLocation + ")";
    }

    public /* synthetic */ PushLabelModel(Integer num, String str, boolean z10, boolean z11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, str, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11);
    }
}

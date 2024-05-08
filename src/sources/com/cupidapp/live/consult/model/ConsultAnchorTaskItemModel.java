package com.cupidapp.live.consult.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorTaskItemModel implements Serializable {
    private final float percent;

    @Nullable
    private final String text;

    public ConsultAnchorTaskItemModel(@Nullable String str, float f10) {
        this.text = str;
        this.percent = f10;
    }

    public static /* synthetic */ ConsultAnchorTaskItemModel copy$default(ConsultAnchorTaskItemModel consultAnchorTaskItemModel, String str, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = consultAnchorTaskItemModel.text;
        }
        if ((i10 & 2) != 0) {
            f10 = consultAnchorTaskItemModel.percent;
        }
        return consultAnchorTaskItemModel.copy(str, f10);
    }

    @Nullable
    public final String component1() {
        return this.text;
    }

    public final float component2() {
        return this.percent;
    }

    @NotNull
    public final ConsultAnchorTaskItemModel copy(@Nullable String str, float f10) {
        return new ConsultAnchorTaskItemModel(str, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultAnchorTaskItemModel)) {
            return false;
        }
        ConsultAnchorTaskItemModel consultAnchorTaskItemModel = (ConsultAnchorTaskItemModel) obj;
        return s.d(this.text, consultAnchorTaskItemModel.text) && Float.compare(this.percent, consultAnchorTaskItemModel.percent) == 0;
    }

    public final float getPercent() {
        return this.percent;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        return ((str == null ? 0 : str.hashCode()) * 31) + Float.floatToIntBits(this.percent);
    }

    @NotNull
    public String toString() {
        return "ConsultAnchorTaskItemModel(text=" + this.text + ", percent=" + this.percent + ")";
    }

    public /* synthetic */ ConsultAnchorTaskItemModel(String str, float f10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? 0.0f : f10);
    }
}

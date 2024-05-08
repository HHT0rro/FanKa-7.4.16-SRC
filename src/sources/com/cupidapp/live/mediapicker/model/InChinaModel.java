package com.cupidapp.live.mediapicker.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InChinaModel {
    private final boolean res;

    public InChinaModel() {
        this(false, 1, null);
    }

    public InChinaModel(boolean z10) {
        this.res = z10;
    }

    public static /* synthetic */ InChinaModel copy$default(InChinaModel inChinaModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = inChinaModel.res;
        }
        return inChinaModel.copy(z10);
    }

    public final boolean component1() {
        return this.res;
    }

    @NotNull
    public final InChinaModel copy(boolean z10) {
        return new InChinaModel(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InChinaModel) && this.res == ((InChinaModel) obj).res;
    }

    public final boolean getRes() {
        return this.res;
    }

    public int hashCode() {
        boolean z10 = this.res;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "InChinaModel(res=" + this.res + ")";
    }

    public /* synthetic */ InChinaModel(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10);
    }
}

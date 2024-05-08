package com.cupidapp.live.setting.adapter;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelTipsModel {
    private final int tips;

    public FKStoryLabelTipsModel(int i10) {
        this.tips = i10;
    }

    public static /* synthetic */ FKStoryLabelTipsModel copy$default(FKStoryLabelTipsModel fKStoryLabelTipsModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = fKStoryLabelTipsModel.tips;
        }
        return fKStoryLabelTipsModel.copy(i10);
    }

    public final int component1() {
        return this.tips;
    }

    @NotNull
    public final FKStoryLabelTipsModel copy(int i10) {
        return new FKStoryLabelTipsModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKStoryLabelTipsModel) && this.tips == ((FKStoryLabelTipsModel) obj).tips;
    }

    public final int getTips() {
        return this.tips;
    }

    public int hashCode() {
        return this.tips;
    }

    @NotNull
    public String toString() {
        return "FKStoryLabelTipsModel(tips=" + this.tips + ")";
    }
}

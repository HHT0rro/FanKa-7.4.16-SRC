package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NobleCardModel {
    private final int barrageCardCount;

    @NotNull
    private final String path;

    @NotNull
    private final String toast;

    public NobleCardModel(@NotNull String toast, @NotNull String path, int i10) {
        s.i(toast, "toast");
        s.i(path, "path");
        this.toast = toast;
        this.path = path;
        this.barrageCardCount = i10;
    }

    public static /* synthetic */ NobleCardModel copy$default(NobleCardModel nobleCardModel, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = nobleCardModel.toast;
        }
        if ((i11 & 2) != 0) {
            str2 = nobleCardModel.path;
        }
        if ((i11 & 4) != 0) {
            i10 = nobleCardModel.barrageCardCount;
        }
        return nobleCardModel.copy(str, str2, i10);
    }

    @NotNull
    public final String component1() {
        return this.toast;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    public final int component3() {
        return this.barrageCardCount;
    }

    @NotNull
    public final NobleCardModel copy(@NotNull String toast, @NotNull String path, int i10) {
        s.i(toast, "toast");
        s.i(path, "path");
        return new NobleCardModel(toast, path, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NobleCardModel)) {
            return false;
        }
        NobleCardModel nobleCardModel = (NobleCardModel) obj;
        return s.d(this.toast, nobleCardModel.toast) && s.d(this.path, nobleCardModel.path) && this.barrageCardCount == nobleCardModel.barrageCardCount;
    }

    public final int getBarrageCardCount() {
        return this.barrageCardCount;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getToast() {
        return this.toast;
    }

    public int hashCode() {
        return (((this.toast.hashCode() * 31) + this.path.hashCode()) * 31) + this.barrageCardCount;
    }

    @NotNull
    public String toString() {
        return "NobleCardModel(toast=" + this.toast + ", path=" + this.path + ", barrageCardCount=" + this.barrageCardCount + ")";
    }
}

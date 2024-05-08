package com.cupidapp.live.base.recyclerview.model;

import javax.annotation.Resource;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEmptyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTitleModel {

    @Resource
    private final int title;

    public FKTitleModel(int i10) {
        this.title = i10;
    }

    public static /* synthetic */ FKTitleModel copy$default(FKTitleModel fKTitleModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = fKTitleModel.title;
        }
        return fKTitleModel.copy(i10);
    }

    public final int component1() {
        return this.title;
    }

    @NotNull
    public final FKTitleModel copy(int i10) {
        return new FKTitleModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKTitleModel) && this.title == ((FKTitleModel) obj).title;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title;
    }

    @NotNull
    public String toString() {
        return "FKTitleModel(title=" + this.title + ")";
    }
}

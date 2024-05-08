package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEmptyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTitleUiModel {

    @Nullable
    private final String title;

    public FKTitleUiModel(@Nullable String str) {
        this.title = str;
    }

    public static /* synthetic */ FKTitleUiModel copy$default(FKTitleUiModel fKTitleUiModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKTitleUiModel.title;
        }
        return fKTitleUiModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final FKTitleUiModel copy(@Nullable String str) {
        return new FKTitleUiModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKTitleUiModel) && s.d(this.title, ((FKTitleUiModel) obj).title);
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKTitleUiModel(title=" + this.title + ")";
    }
}

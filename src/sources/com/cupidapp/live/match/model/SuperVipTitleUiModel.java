package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperVipTitleUiModel {

    @Nullable
    private String description;

    @NotNull
    private final String title;

    public SuperVipTitleUiModel(@NotNull String title, @Nullable String str) {
        s.i(title, "title");
        this.title = title;
        this.description = str;
    }

    public static /* synthetic */ SuperVipTitleUiModel copy$default(SuperVipTitleUiModel superVipTitleUiModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = superVipTitleUiModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = superVipTitleUiModel.description;
        }
        return superVipTitleUiModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final SuperVipTitleUiModel copy(@NotNull String title, @Nullable String str) {
        s.i(title, "title");
        return new SuperVipTitleUiModel(title, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperVipTitleUiModel)) {
            return false;
        }
        SuperVipTitleUiModel superVipTitleUiModel = (SuperVipTitleUiModel) obj;
        return s.d(this.title, superVipTitleUiModel.title) && s.d(this.description, superVipTitleUiModel.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.description;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    @NotNull
    public String toString() {
        return "SuperVipTitleUiModel(title=" + this.title + ", description=" + this.description + ")";
    }

    public /* synthetic */ SuperVipTitleUiModel(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}

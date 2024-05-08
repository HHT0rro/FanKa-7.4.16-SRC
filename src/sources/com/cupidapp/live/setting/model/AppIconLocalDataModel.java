package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppIcon.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AppIconLocalDataModel {

    @NotNull
    private final String activityAliasName;

    @Nullable
    private final String grade;
    private final int iconDisplayDrawableRes;
    private final int iconDisplayNameRes;

    @NotNull
    private final String name;

    public AppIconLocalDataModel(@NotNull String name, @Nullable String str, int i10, int i11, @NotNull String activityAliasName) {
        s.i(name, "name");
        s.i(activityAliasName, "activityAliasName");
        this.name = name;
        this.grade = str;
        this.iconDisplayDrawableRes = i10;
        this.iconDisplayNameRes = i11;
        this.activityAliasName = activityAliasName;
    }

    public static /* synthetic */ AppIconLocalDataModel copy$default(AppIconLocalDataModel appIconLocalDataModel, String str, String str2, int i10, int i11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = appIconLocalDataModel.name;
        }
        if ((i12 & 2) != 0) {
            str2 = appIconLocalDataModel.grade;
        }
        String str4 = str2;
        if ((i12 & 4) != 0) {
            i10 = appIconLocalDataModel.iconDisplayDrawableRes;
        }
        int i13 = i10;
        if ((i12 & 8) != 0) {
            i11 = appIconLocalDataModel.iconDisplayNameRes;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            str3 = appIconLocalDataModel.activityAliasName;
        }
        return appIconLocalDataModel.copy(str, str4, i13, i14, str3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.grade;
    }

    public final int component3() {
        return this.iconDisplayDrawableRes;
    }

    public final int component4() {
        return this.iconDisplayNameRes;
    }

    @NotNull
    public final String component5() {
        return this.activityAliasName;
    }

    @NotNull
    public final AppIconLocalDataModel copy(@NotNull String name, @Nullable String str, int i10, int i11, @NotNull String activityAliasName) {
        s.i(name, "name");
        s.i(activityAliasName, "activityAliasName");
        return new AppIconLocalDataModel(name, str, i10, i11, activityAliasName);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppIconLocalDataModel)) {
            return false;
        }
        AppIconLocalDataModel appIconLocalDataModel = (AppIconLocalDataModel) obj;
        return s.d(this.name, appIconLocalDataModel.name) && s.d(this.grade, appIconLocalDataModel.grade) && this.iconDisplayDrawableRes == appIconLocalDataModel.iconDisplayDrawableRes && this.iconDisplayNameRes == appIconLocalDataModel.iconDisplayNameRes && s.d(this.activityAliasName, appIconLocalDataModel.activityAliasName);
    }

    @NotNull
    public final String getActivityAliasName() {
        return this.activityAliasName;
    }

    @Nullable
    public final String getGrade() {
        return this.grade;
    }

    public final int getIconDisplayDrawableRes() {
        return this.iconDisplayDrawableRes;
    }

    public final int getIconDisplayNameRes() {
        return this.iconDisplayNameRes;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.grade;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.iconDisplayDrawableRes) * 31) + this.iconDisplayNameRes) * 31) + this.activityAliasName.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppIconLocalDataModel(name=" + this.name + ", grade=" + this.grade + ", iconDisplayDrawableRes=" + this.iconDisplayDrawableRes + ", iconDisplayNameRes=" + this.iconDisplayNameRes + ", activityAliasName=" + this.activityAliasName + ")";
    }
}

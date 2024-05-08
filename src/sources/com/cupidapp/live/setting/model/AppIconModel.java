package com.cupidapp.live.setting.model;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppIcon.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AppIconModel {

    @Nullable
    private final String grade;

    @NotNull
    private final String name;

    public AppIconModel(@Nullable String str, @NotNull String name) {
        s.i(name, "name");
        this.grade = str;
        this.name = name;
    }

    public static /* synthetic */ AppIconModel copy$default(AppIconModel appIconModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appIconModel.grade;
        }
        if ((i10 & 2) != 0) {
            str2 = appIconModel.name;
        }
        return appIconModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.grade;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final AppIconModel copy(@Nullable String str, @NotNull String name) {
        s.i(name, "name");
        return new AppIconModel(str, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppIconModel)) {
            return false;
        }
        AppIconModel appIconModel = (AppIconModel) obj;
        return s.d(this.grade, appIconModel.grade) && s.d(this.name, appIconModel.name);
    }

    @Nullable
    public final String getGrade() {
        return this.grade;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.grade;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.name.hashCode();
    }

    @Nullable
    public final AppIconLocalDataModel mapToAppIcon() {
        String str = this.name;
        if (s.d(str, AppIcon.SystemIcon.getValue())) {
            return new AppIconLocalDataModel(this.name, this.grade, R$mipmap.ic_launcher, R$string.default_icon, AppIcon.ClassicDiamond.getActivityAliasName());
        }
        AppIcon appIcon = AppIcon.ClassicDiamond;
        if (s.d(str, appIcon.getValue())) {
            return new AppIconLocalDataModel(this.name, this.grade, R$mipmap.classic_diamond, R$string.classic_icon, appIcon.getActivityAliasName());
        }
        AppIcon appIcon2 = AppIcon.CardiacSignal;
        if (s.d(str, appIcon2.getValue())) {
            return new AppIconLocalDataModel(this.name, this.grade, R$mipmap.cardiac_signal, R$string.cardiac_icon, appIcon2.getActivityAliasName());
        }
        AppIcon appIcon3 = AppIcon.EnglishEdition;
        if (s.d(str, appIcon3.getValue())) {
            return new AppIconLocalDataModel(this.name, this.grade, R$mipmap.english_edition, R$string.edition_icon, appIcon3.getActivityAliasName());
        }
        AppIcon appIcon4 = AppIcon.LoveLaunch;
        if (s.d(str, appIcon4.getValue())) {
            return new AppIconLocalDataModel(this.name, this.grade, R$mipmap.love_launch, R$string.love_launch_icon, appIcon4.getActivityAliasName());
        }
        AppIcon appIcon5 = AppIcon.LoveIsLove;
        if (s.d(str, appIcon5.getValue())) {
            return new AppIconLocalDataModel(this.name, this.grade, R$mipmap.love_is_love, R$string.love_icon, appIcon5.getActivityAliasName());
        }
        return null;
    }

    @NotNull
    public String toString() {
        return "AppIconModel(grade=" + this.grade + ", name=" + this.name + ")";
    }
}

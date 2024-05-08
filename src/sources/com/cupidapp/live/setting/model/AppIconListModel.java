package com.cupidapp.live.setting.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppIcon.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AppIconListModel {

    @Nullable
    private final List<AppIconModel> icons;

    public AppIconListModel(@Nullable List<AppIconModel> list) {
        this.icons = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppIconListModel copy$default(AppIconListModel appIconListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = appIconListModel.icons;
        }
        return appIconListModel.copy(list);
    }

    @Nullable
    public final List<AppIconModel> component1() {
        return this.icons;
    }

    @NotNull
    public final AppIconListModel copy(@Nullable List<AppIconModel> list) {
        return new AppIconListModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppIconListModel) && s.d(this.icons, ((AppIconListModel) obj).icons);
    }

    @Nullable
    public final List<AppIconModel> getIcons() {
        return this.icons;
    }

    public int hashCode() {
        List<AppIconModel> list = this.icons;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppIconListModel(icons=" + ((Object) this.icons) + ")";
    }
}

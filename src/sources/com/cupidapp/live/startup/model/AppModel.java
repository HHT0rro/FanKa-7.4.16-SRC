package com.cupidapp.live.startup.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AppModel {

    @Nullable
    private final String packageName;

    public AppModel(@Nullable String str) {
        this.packageName = str;
    }

    public static /* synthetic */ AppModel copy$default(AppModel appModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appModel.packageName;
        }
        return appModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.packageName;
    }

    @NotNull
    public final AppModel copy(@Nullable String str) {
        return new AppModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppModel) && s.d(this.packageName, ((AppModel) obj).packageName);
    }

    @Nullable
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        String str = this.packageName;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppModel(packageName=" + this.packageName + ")";
    }
}

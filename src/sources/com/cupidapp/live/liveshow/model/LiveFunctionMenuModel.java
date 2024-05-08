package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveFunctionMenuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveFunctionMenuModel {

    @NotNull
    private final ImageModel icon;

    @NotNull
    private final String name;

    @NotNull
    private final String path;

    @Nullable
    private final String point;
    private final boolean unread;

    public LiveFunctionMenuModel(@NotNull ImageModel icon, @NotNull String name, @NotNull String path, @Nullable String str, boolean z10) {
        s.i(icon, "icon");
        s.i(name, "name");
        s.i(path, "path");
        this.icon = icon;
        this.name = name;
        this.path = path;
        this.point = str;
        this.unread = z10;
    }

    public static /* synthetic */ LiveFunctionMenuModel copy$default(LiveFunctionMenuModel liveFunctionMenuModel, ImageModel imageModel, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = liveFunctionMenuModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = liveFunctionMenuModel.name;
        }
        String str4 = str;
        if ((i10 & 4) != 0) {
            str2 = liveFunctionMenuModel.path;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            str3 = liveFunctionMenuModel.point;
        }
        String str6 = str3;
        if ((i10 & 16) != 0) {
            z10 = liveFunctionMenuModel.unread;
        }
        return liveFunctionMenuModel.copy(imageModel, str4, str5, str6, z10);
    }

    @NotNull
    public final ImageModel component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.path;
    }

    @Nullable
    public final String component4() {
        return this.point;
    }

    public final boolean component5() {
        return this.unread;
    }

    @NotNull
    public final LiveFunctionMenuModel copy(@NotNull ImageModel icon, @NotNull String name, @NotNull String path, @Nullable String str, boolean z10) {
        s.i(icon, "icon");
        s.i(name, "name");
        s.i(path, "path");
        return new LiveFunctionMenuModel(icon, name, path, str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveFunctionMenuModel)) {
            return false;
        }
        LiveFunctionMenuModel liveFunctionMenuModel = (LiveFunctionMenuModel) obj;
        return s.d(this.icon, liveFunctionMenuModel.icon) && s.d(this.name, liveFunctionMenuModel.name) && s.d(this.path, liveFunctionMenuModel.path) && s.d(this.point, liveFunctionMenuModel.point) && this.unread == liveFunctionMenuModel.unread;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getPoint() {
        return this.point;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.icon.hashCode() * 31) + this.name.hashCode()) * 31) + this.path.hashCode()) * 31;
        String str = this.point;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.unread;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "LiveFunctionMenuModel(icon=" + ((Object) imageModel) + ", name=" + this.name + ", path=" + this.path + ", point=" + this.point + ", unread=" + this.unread + ")";
    }
}

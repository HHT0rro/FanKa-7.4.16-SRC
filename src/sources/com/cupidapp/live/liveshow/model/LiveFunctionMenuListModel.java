package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveFunctionMenuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveFunctionMenuListModel {

    @NotNull
    private final List<LiveFunctionMenuModel> menus;

    @Nullable
    private final String title;

    @NotNull
    private final String type;

    public LiveFunctionMenuListModel(@Nullable String str, @NotNull String type, @NotNull List<LiveFunctionMenuModel> menus) {
        s.i(type, "type");
        s.i(menus, "menus");
        this.title = str;
        this.type = type;
        this.menus = menus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveFunctionMenuListModel copy$default(LiveFunctionMenuListModel liveFunctionMenuListModel, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveFunctionMenuListModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = liveFunctionMenuListModel.type;
        }
        if ((i10 & 4) != 0) {
            list = liveFunctionMenuListModel.menus;
        }
        return liveFunctionMenuListModel.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final List<LiveFunctionMenuModel> component3() {
        return this.menus;
    }

    @NotNull
    public final LiveFunctionMenuListModel copy(@Nullable String str, @NotNull String type, @NotNull List<LiveFunctionMenuModel> menus) {
        s.i(type, "type");
        s.i(menus, "menus");
        return new LiveFunctionMenuListModel(str, type, menus);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveFunctionMenuListModel)) {
            return false;
        }
        LiveFunctionMenuListModel liveFunctionMenuListModel = (LiveFunctionMenuListModel) obj;
        return s.d(this.title, liveFunctionMenuListModel.title) && s.d(this.type, liveFunctionMenuListModel.type) && s.d(this.menus, liveFunctionMenuListModel.menus);
    }

    @NotNull
    public final List<LiveFunctionMenuModel> getMenus() {
        return this.menus;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.title;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31) + this.menus.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveFunctionMenuListModel(title=" + this.title + ", type=" + this.type + ", menus=" + ((Object) this.menus) + ")";
    }
}

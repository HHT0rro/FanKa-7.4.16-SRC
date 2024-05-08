package com.cupidapp.live.liveshow.view.menu;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveFunctionMenuAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MenuTitleModel {

    @NotNull
    private final String title;

    public MenuTitleModel(@NotNull String title) {
        s.i(title, "title");
        this.title = title;
    }

    public static /* synthetic */ MenuTitleModel copy$default(MenuTitleModel menuTitleModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = menuTitleModel.title;
        }
        return menuTitleModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final MenuTitleModel copy(@NotNull String title) {
        s.i(title, "title");
        return new MenuTitleModel(title);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MenuTitleModel) && s.d(this.title, ((MenuTitleModel) obj).title);
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.title.hashCode();
    }

    @NotNull
    public String toString() {
        return "MenuTitleModel(title=" + this.title + ")";
    }
}

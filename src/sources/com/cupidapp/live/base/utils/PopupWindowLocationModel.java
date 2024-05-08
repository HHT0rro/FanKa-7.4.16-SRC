package com.cupidapp.live.base.utils;

import android.view.View;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPopupWindowWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PopupWindowLocationModel {
    private final int gravity;

    @NotNull
    private final Pair<Integer, Integer> location;

    @NotNull
    private final View parent;

    public PopupWindowLocationModel(@NotNull View parent, int i10, @NotNull Pair<Integer, Integer> location) {
        kotlin.jvm.internal.s.i(parent, "parent");
        kotlin.jvm.internal.s.i(location, "location");
        this.parent = parent;
        this.gravity = i10;
        this.location = location;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopupWindowLocationModel copy$default(PopupWindowLocationModel popupWindowLocationModel, View view, int i10, Pair pair, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            view = popupWindowLocationModel.parent;
        }
        if ((i11 & 2) != 0) {
            i10 = popupWindowLocationModel.gravity;
        }
        if ((i11 & 4) != 0) {
            pair = popupWindowLocationModel.location;
        }
        return popupWindowLocationModel.copy(view, i10, pair);
    }

    @NotNull
    public final View component1() {
        return this.parent;
    }

    public final int component2() {
        return this.gravity;
    }

    @NotNull
    public final Pair<Integer, Integer> component3() {
        return this.location;
    }

    @NotNull
    public final PopupWindowLocationModel copy(@NotNull View parent, int i10, @NotNull Pair<Integer, Integer> location) {
        kotlin.jvm.internal.s.i(parent, "parent");
        kotlin.jvm.internal.s.i(location, "location");
        return new PopupWindowLocationModel(parent, i10, location);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupWindowLocationModel)) {
            return false;
        }
        PopupWindowLocationModel popupWindowLocationModel = (PopupWindowLocationModel) obj;
        return kotlin.jvm.internal.s.d(this.parent, popupWindowLocationModel.parent) && this.gravity == popupWindowLocationModel.gravity && kotlin.jvm.internal.s.d(this.location, popupWindowLocationModel.location);
    }

    public final int getGravity() {
        return this.gravity;
    }

    @NotNull
    public final Pair<Integer, Integer> getLocation() {
        return this.location;
    }

    @NotNull
    public final View getParent() {
        return this.parent;
    }

    public int hashCode() {
        return (((this.parent.hashCode() * 31) + this.gravity) * 31) + this.location.hashCode();
    }

    @NotNull
    public String toString() {
        View view = this.parent;
        return "PopupWindowLocationModel(parent=" + ((Object) view) + ", gravity=" + this.gravity + ", location=" + ((Object) this.location) + ")";
    }
}

package com.cupidapp.live.club.viewholder;

import javax.annotation.Resource;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EmptyListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class EmptyListModel {

    @Resource
    private final int icon;

    @Resource
    private final int text;
    private final int viewHeight;

    public EmptyListModel(int i10, int i11, int i12) {
        this.icon = i10;
        this.text = i11;
        this.viewHeight = i12;
    }

    public static /* synthetic */ EmptyListModel copy$default(EmptyListModel emptyListModel, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = emptyListModel.icon;
        }
        if ((i13 & 2) != 0) {
            i11 = emptyListModel.text;
        }
        if ((i13 & 4) != 0) {
            i12 = emptyListModel.viewHeight;
        }
        return emptyListModel.copy(i10, i11, i12);
    }

    public final int component1() {
        return this.icon;
    }

    public final int component2() {
        return this.text;
    }

    public final int component3() {
        return this.viewHeight;
    }

    @NotNull
    public final EmptyListModel copy(int i10, int i11, int i12) {
        return new EmptyListModel(i10, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmptyListModel)) {
            return false;
        }
        EmptyListModel emptyListModel = (EmptyListModel) obj;
        return this.icon == emptyListModel.icon && this.text == emptyListModel.text && this.viewHeight == emptyListModel.viewHeight;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getText() {
        return this.text;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public int hashCode() {
        return (((this.icon * 31) + this.text) * 31) + this.viewHeight;
    }

    @NotNull
    public String toString() {
        return "EmptyListModel(icon=" + this.icon + ", text=" + this.text + ", viewHeight=" + this.viewHeight + ")";
    }

    public /* synthetic */ EmptyListModel(int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, (i13 & 4) != 0 ? -1 : i12);
    }
}

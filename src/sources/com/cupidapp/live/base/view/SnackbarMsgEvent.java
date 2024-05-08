package com.cupidapp.live.base.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSnackbarView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SnackbarMsgEvent {

    @Nullable
    private final String currentActivityName;

    @NotNull
    private final SnackbarModel model;
    private final boolean showInCurrentActivity;

    public SnackbarMsgEvent(@NotNull SnackbarModel model, @Nullable String str, boolean z10) {
        kotlin.jvm.internal.s.i(model, "model");
        this.model = model;
        this.currentActivityName = str;
        this.showInCurrentActivity = z10;
    }

    public static /* synthetic */ SnackbarMsgEvent copy$default(SnackbarMsgEvent snackbarMsgEvent, SnackbarModel snackbarModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            snackbarModel = snackbarMsgEvent.model;
        }
        if ((i10 & 2) != 0) {
            str = snackbarMsgEvent.currentActivityName;
        }
        if ((i10 & 4) != 0) {
            z10 = snackbarMsgEvent.showInCurrentActivity;
        }
        return snackbarMsgEvent.copy(snackbarModel, str, z10);
    }

    @NotNull
    public final SnackbarModel component1() {
        return this.model;
    }

    @Nullable
    public final String component2() {
        return this.currentActivityName;
    }

    public final boolean component3() {
        return this.showInCurrentActivity;
    }

    @NotNull
    public final SnackbarMsgEvent copy(@NotNull SnackbarModel model, @Nullable String str, boolean z10) {
        kotlin.jvm.internal.s.i(model, "model");
        return new SnackbarMsgEvent(model, str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnackbarMsgEvent)) {
            return false;
        }
        SnackbarMsgEvent snackbarMsgEvent = (SnackbarMsgEvent) obj;
        return kotlin.jvm.internal.s.d(this.model, snackbarMsgEvent.model) && kotlin.jvm.internal.s.d(this.currentActivityName, snackbarMsgEvent.currentActivityName) && this.showInCurrentActivity == snackbarMsgEvent.showInCurrentActivity;
    }

    @Nullable
    public final String getCurrentActivityName() {
        return this.currentActivityName;
    }

    @NotNull
    public final SnackbarModel getModel() {
        return this.model;
    }

    public final boolean getShowInCurrentActivity() {
        return this.showInCurrentActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.model.hashCode() * 31;
        String str = this.currentActivityName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.showInCurrentActivity;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    @NotNull
    public String toString() {
        SnackbarModel snackbarModel = this.model;
        return "SnackbarMsgEvent(model=" + ((Object) snackbarModel) + ", currentActivityName=" + this.currentActivityName + ", showInCurrentActivity=" + this.showInCurrentActivity + ")";
    }

    public /* synthetic */ SnackbarMsgEvent(SnackbarModel snackbarModel, String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(snackbarModel, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? true : z10);
    }
}

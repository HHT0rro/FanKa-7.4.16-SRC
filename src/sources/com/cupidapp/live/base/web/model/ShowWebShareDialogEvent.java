package com.cupidapp.live.base.web.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowWebShareDialogEvent {

    @NotNull
    private final WebShareModel shareModel;

    public ShowWebShareDialogEvent(@NotNull WebShareModel shareModel) {
        s.i(shareModel, "shareModel");
        this.shareModel = shareModel;
    }

    public static /* synthetic */ ShowWebShareDialogEvent copy$default(ShowWebShareDialogEvent showWebShareDialogEvent, WebShareModel webShareModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            webShareModel = showWebShareDialogEvent.shareModel;
        }
        return showWebShareDialogEvent.copy(webShareModel);
    }

    @NotNull
    public final WebShareModel component1() {
        return this.shareModel;
    }

    @NotNull
    public final ShowWebShareDialogEvent copy(@NotNull WebShareModel shareModel) {
        s.i(shareModel, "shareModel");
        return new ShowWebShareDialogEvent(shareModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShowWebShareDialogEvent) && s.d(this.shareModel, ((ShowWebShareDialogEvent) obj).shareModel);
    }

    @NotNull
    public final WebShareModel getShareModel() {
        return this.shareModel;
    }

    public int hashCode() {
        return this.shareModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShowWebShareDialogEvent(shareModel=" + ((Object) this.shareModel) + ")";
    }
}

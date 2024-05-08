package com.cupidapp.live.liveshow.pk.adapter;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkFriendListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkEmptyListModel {

    @NotNull
    private final String emptyTxt;

    public LivePkEmptyListModel(@NotNull String emptyTxt) {
        s.i(emptyTxt, "emptyTxt");
        this.emptyTxt = emptyTxt;
    }

    public static /* synthetic */ LivePkEmptyListModel copy$default(LivePkEmptyListModel livePkEmptyListModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = livePkEmptyListModel.emptyTxt;
        }
        return livePkEmptyListModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.emptyTxt;
    }

    @NotNull
    public final LivePkEmptyListModel copy(@NotNull String emptyTxt) {
        s.i(emptyTxt, "emptyTxt");
        return new LivePkEmptyListModel(emptyTxt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivePkEmptyListModel) && s.d(this.emptyTxt, ((LivePkEmptyListModel) obj).emptyTxt);
    }

    @NotNull
    public final String getEmptyTxt() {
        return this.emptyTxt;
    }

    public int hashCode() {
        return this.emptyTxt.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePkEmptyListModel(emptyTxt=" + this.emptyTxt + ")";
    }
}

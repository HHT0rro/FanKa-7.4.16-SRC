package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushLiveShowItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushLiveShowItemModel {
    private boolean sendPush;

    @NotNull
    private NewPushLiveShowUserModel user;

    public NewPushLiveShowItemModel(@NotNull NewPushLiveShowUserModel user, boolean z10) {
        s.i(user, "user");
        this.user = user;
        this.sendPush = z10;
    }

    public static /* synthetic */ NewPushLiveShowItemModel copy$default(NewPushLiveShowItemModel newPushLiveShowItemModel, NewPushLiveShowUserModel newPushLiveShowUserModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            newPushLiveShowUserModel = newPushLiveShowItemModel.user;
        }
        if ((i10 & 2) != 0) {
            z10 = newPushLiveShowItemModel.sendPush;
        }
        return newPushLiveShowItemModel.copy(newPushLiveShowUserModel, z10);
    }

    @NotNull
    public final NewPushLiveShowUserModel component1() {
        return this.user;
    }

    public final boolean component2() {
        return this.sendPush;
    }

    @NotNull
    public final NewPushLiveShowItemModel copy(@NotNull NewPushLiveShowUserModel user, boolean z10) {
        s.i(user, "user");
        return new NewPushLiveShowItemModel(user, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewPushLiveShowItemModel)) {
            return false;
        }
        NewPushLiveShowItemModel newPushLiveShowItemModel = (NewPushLiveShowItemModel) obj;
        return s.d(this.user, newPushLiveShowItemModel.user) && this.sendPush == newPushLiveShowItemModel.sendPush;
    }

    public final boolean getSendPush() {
        return this.sendPush;
    }

    @NotNull
    public final NewPushLiveShowUserModel getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        boolean z10 = this.sendPush;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setSendPush(boolean z10) {
        this.sendPush = z10;
    }

    public final void setUser(@NotNull NewPushLiveShowUserModel newPushLiveShowUserModel) {
        s.i(newPushLiveShowUserModel, "<set-?>");
        this.user = newPushLiveShowUserModel;
    }

    @NotNull
    public String toString() {
        NewPushLiveShowUserModel newPushLiveShowUserModel = this.user;
        return "NewPushLiveShowItemModel(user=" + ((Object) newPushLiveShowUserModel) + ", sendPush=" + this.sendPush + ")";
    }
}

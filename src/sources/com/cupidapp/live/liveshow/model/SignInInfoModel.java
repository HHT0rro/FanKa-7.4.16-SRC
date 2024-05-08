package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SignInInfoModel implements Serializable {
    private int unreadCount;

    public SignInInfoModel(int i10) {
        this.unreadCount = i10;
    }

    public static /* synthetic */ SignInInfoModel copy$default(SignInInfoModel signInInfoModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = signInInfoModel.unreadCount;
        }
        return signInInfoModel.copy(i10);
    }

    public final int component1() {
        return this.unreadCount;
    }

    @NotNull
    public final SignInInfoModel copy(int i10) {
        return new SignInInfoModel(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SignInInfoModel) && this.unreadCount == ((SignInInfoModel) obj).unreadCount;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public int hashCode() {
        return this.unreadCount;
    }

    public final void setUnreadCount(int i10) {
        this.unreadCount = i10;
    }

    @NotNull
    public String toString() {
        return "SignInInfoModel(unreadCount=" + this.unreadCount + ")";
    }
}

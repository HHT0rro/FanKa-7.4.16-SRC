package com.cupidapp.live.profile.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlohaCancelListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AlohaCancelUserModel {

    @Nullable
    private final String cancelTime;

    @NotNull
    private final User user;

    public AlohaCancelUserModel(@NotNull User user, @Nullable String str) {
        s.i(user, "user");
        this.user = user;
        this.cancelTime = str;
    }

    public static /* synthetic */ AlohaCancelUserModel copy$default(AlohaCancelUserModel alohaCancelUserModel, User user, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = alohaCancelUserModel.user;
        }
        if ((i10 & 2) != 0) {
            str = alohaCancelUserModel.cancelTime;
        }
        return alohaCancelUserModel.copy(user, str);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.cancelTime;
    }

    @NotNull
    public final AlohaCancelUserModel copy(@NotNull User user, @Nullable String str) {
        s.i(user, "user");
        return new AlohaCancelUserModel(user, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlohaCancelUserModel)) {
            return false;
        }
        AlohaCancelUserModel alohaCancelUserModel = (AlohaCancelUserModel) obj;
        return s.d(this.user, alohaCancelUserModel.user) && s.d(this.cancelTime, alohaCancelUserModel.cancelTime);
    }

    @Nullable
    public final String getCancelTime() {
        return this.cancelTime;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        String str = this.cancelTime;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "AlohaCancelUserModel(user=" + ((Object) user) + ", cancelTime=" + this.cancelTime + ")";
    }
}

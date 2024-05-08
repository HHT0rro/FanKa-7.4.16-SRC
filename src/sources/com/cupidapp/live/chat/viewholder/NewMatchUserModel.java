package com.cupidapp.live.chat.viewholder;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKNewMatchUserItemViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewMatchUserModel {
    private boolean shaked;

    @NotNull
    private final User user;
    private final int userCount;

    public NewMatchUserModel(@NotNull User user, int i10, boolean z10) {
        s.i(user, "user");
        this.user = user;
        this.userCount = i10;
        this.shaked = z10;
    }

    public static /* synthetic */ NewMatchUserModel copy$default(NewMatchUserModel newMatchUserModel, User user, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            user = newMatchUserModel.user;
        }
        if ((i11 & 2) != 0) {
            i10 = newMatchUserModel.userCount;
        }
        if ((i11 & 4) != 0) {
            z10 = newMatchUserModel.shaked;
        }
        return newMatchUserModel.copy(user, i10, z10);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    public final int component2() {
        return this.userCount;
    }

    public final boolean component3() {
        return this.shaked;
    }

    @NotNull
    public final NewMatchUserModel copy(@NotNull User user, int i10, boolean z10) {
        s.i(user, "user");
        return new NewMatchUserModel(user, i10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewMatchUserModel)) {
            return false;
        }
        NewMatchUserModel newMatchUserModel = (NewMatchUserModel) obj;
        return s.d(this.user, newMatchUserModel.user) && this.userCount == newMatchUserModel.userCount && this.shaked == newMatchUserModel.shaked;
    }

    public final boolean getShaked() {
        return this.shaked;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.user.hashCode() * 31) + this.userCount) * 31;
        boolean z10 = this.shaked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setShaked(boolean z10) {
        this.shaked = z10;
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "NewMatchUserModel(user=" + ((Object) user) + ", userCount=" + this.userCount + ", shaked=" + this.shaked + ")";
    }

    public /* synthetic */ NewMatchUserModel(User user, int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, i10, (i11 & 4) != 0 ? false : z10);
    }
}

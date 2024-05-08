package com.cupidapp.live.main.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserModifyResult {

    @Nullable
    private final Boolean showSkipButton;

    @NotNull
    private final User user;

    public UserModifyResult(@NotNull User user, @Nullable Boolean bool) {
        s.i(user, "user");
        this.user = user;
        this.showSkipButton = bool;
    }

    public static /* synthetic */ UserModifyResult copy$default(UserModifyResult userModifyResult, User user, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = userModifyResult.user;
        }
        if ((i10 & 2) != 0) {
            bool = userModifyResult.showSkipButton;
        }
        return userModifyResult.copy(user, bool);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final Boolean component2() {
        return this.showSkipButton;
    }

    @NotNull
    public final UserModifyResult copy(@NotNull User user, @Nullable Boolean bool) {
        s.i(user, "user");
        return new UserModifyResult(user, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserModifyResult)) {
            return false;
        }
        UserModifyResult userModifyResult = (UserModifyResult) obj;
        return s.d(this.user, userModifyResult.user) && s.d(this.showSkipButton, userModifyResult.showSkipButton);
    }

    @Nullable
    public final Boolean getShowSkipButton() {
        return this.showSkipButton;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        Boolean bool = this.showSkipButton;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    @NotNull
    public String toString() {
        return "UserModifyResult(user=" + ((Object) this.user) + ", showSkipButton=" + ((Object) this.showSkipButton) + ")";
    }
}

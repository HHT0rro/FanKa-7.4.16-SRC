package com.cupidapp.live.login.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignInModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class QuickLoginResult implements Serializable {

    @Nullable
    private final User info;

    public QuickLoginResult(@Nullable User user) {
        this.info = user;
    }

    public static /* synthetic */ QuickLoginResult copy$default(QuickLoginResult quickLoginResult, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = quickLoginResult.info;
        }
        return quickLoginResult.copy(user);
    }

    @Nullable
    public final User component1() {
        return this.info;
    }

    @NotNull
    public final QuickLoginResult copy(@Nullable User user) {
        return new QuickLoginResult(user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QuickLoginResult) && s.d(this.info, ((QuickLoginResult) obj).info);
    }

    @Nullable
    public final User getInfo() {
        return this.info;
    }

    public int hashCode() {
        User user = this.info;
        if (user == null) {
            return 0;
        }
        return user.hashCode();
    }

    @NotNull
    public String toString() {
        return "QuickLoginResult(info=" + ((Object) this.info) + ")";
    }
}

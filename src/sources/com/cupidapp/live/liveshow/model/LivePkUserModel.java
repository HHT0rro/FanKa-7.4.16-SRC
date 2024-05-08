package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkUserModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f15100id;

    @NotNull
    private final User user;

    public LivePkUserModel(@NotNull String id2, @NotNull User user) {
        s.i(id2, "id");
        s.i(user, "user");
        this.f15100id = id2;
        this.user = user;
    }

    public static /* synthetic */ LivePkUserModel copy$default(LivePkUserModel livePkUserModel, String str, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = livePkUserModel.f15100id;
        }
        if ((i10 & 2) != 0) {
            user = livePkUserModel.user;
        }
        return livePkUserModel.copy(str, user);
    }

    @NotNull
    public final String component1() {
        return this.f15100id;
    }

    @NotNull
    public final User component2() {
        return this.user;
    }

    @NotNull
    public final LivePkUserModel copy(@NotNull String id2, @NotNull User user) {
        s.i(id2, "id");
        s.i(user, "user");
        return new LivePkUserModel(id2, user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkUserModel)) {
            return false;
        }
        LivePkUserModel livePkUserModel = (LivePkUserModel) obj;
        return s.d(this.f15100id, livePkUserModel.f15100id) && s.d(this.user, livePkUserModel.user);
    }

    @NotNull
    public final String getId() {
        return this.f15100id;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.f15100id.hashCode() * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePkUserModel(id=" + this.f15100id + ", user=" + ((Object) this.user) + ")";
    }
}

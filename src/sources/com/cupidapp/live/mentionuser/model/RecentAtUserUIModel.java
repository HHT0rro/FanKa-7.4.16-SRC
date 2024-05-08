package com.cupidapp.live.mentionuser.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AtUserModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RecentAtUserUIModel {

    @NotNull
    private final List<User> list;

    public RecentAtUserUIModel(@NotNull List<User> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentAtUserUIModel copy$default(RecentAtUserUIModel recentAtUserUIModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = recentAtUserUIModel.list;
        }
        return recentAtUserUIModel.copy(list);
    }

    @NotNull
    public final List<User> component1() {
        return this.list;
    }

    @NotNull
    public final RecentAtUserUIModel copy(@NotNull List<User> list) {
        s.i(list, "list");
        return new RecentAtUserUIModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecentAtUserUIModel) && s.d(this.list, ((RecentAtUserUIModel) obj).list);
    }

    @NotNull
    public final List<User> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecentAtUserUIModel(list=" + ((Object) this.list) + ")";
    }
}

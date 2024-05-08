package com.cupidapp.live.profile.holder;

import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKProfileStoryLabelViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKProfileStoryLabelModel implements Serializable {

    @NotNull
    private final User user;

    public FKProfileStoryLabelModel(@NotNull User user) {
        s.i(user, "user");
        this.user = user;
    }

    public static /* synthetic */ FKProfileStoryLabelModel copy$default(FKProfileStoryLabelModel fKProfileStoryLabelModel, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = fKProfileStoryLabelModel.user;
        }
        return fKProfileStoryLabelModel.copy(user);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @NotNull
    public final FKProfileStoryLabelModel copy(@NotNull User user) {
        s.i(user, "user");
        return new FKProfileStoryLabelModel(user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKProfileStoryLabelModel) && s.d(this.user, ((FKProfileStoryLabelModel) obj).user);
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        return this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKProfileStoryLabelModel(user=" + ((Object) this.user) + ")";
    }
}

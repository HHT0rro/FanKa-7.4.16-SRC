package com.cupidapp.live.visitors.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FootmarkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FootmarkModel {

    @Nullable
    private final Boolean isFootmarkHidden;

    @Nullable
    private final String timeStr;

    @NotNull
    private final User user;

    public FootmarkModel(@NotNull User user, @Nullable String str, @Nullable Boolean bool) {
        s.i(user, "user");
        this.user = user;
        this.timeStr = str;
        this.isFootmarkHidden = bool;
    }

    public static /* synthetic */ FootmarkModel copy$default(FootmarkModel footmarkModel, User user, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            user = footmarkModel.user;
        }
        if ((i10 & 2) != 0) {
            str = footmarkModel.timeStr;
        }
        if ((i10 & 4) != 0) {
            bool = footmarkModel.isFootmarkHidden;
        }
        return footmarkModel.copy(user, str, bool);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.timeStr;
    }

    @Nullable
    public final Boolean component3() {
        return this.isFootmarkHidden;
    }

    @NotNull
    public final FootmarkModel copy(@NotNull User user, @Nullable String str, @Nullable Boolean bool) {
        s.i(user, "user");
        return new FootmarkModel(user, str, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FootmarkModel)) {
            return false;
        }
        FootmarkModel footmarkModel = (FootmarkModel) obj;
        return s.d(this.user, footmarkModel.user) && s.d(this.timeStr, footmarkModel.timeStr) && s.d(this.isFootmarkHidden, footmarkModel.isFootmarkHidden);
    }

    @Nullable
    public final String getTimeStr() {
        return this.timeStr;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        String str = this.timeStr;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isFootmarkHidden;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    @Nullable
    public final Boolean isFootmarkHidden() {
        return this.isFootmarkHidden;
    }

    @NotNull
    public String toString() {
        User user = this.user;
        return "FootmarkModel(user=" + ((Object) user) + ", timeStr=" + this.timeStr + ", isFootmarkHidden=" + ((Object) this.isFootmarkHidden) + ")";
    }

    public /* synthetic */ FootmarkModel(User user, String str, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, (i10 & 4) != 0 ? Boolean.FALSE : bool);
    }
}

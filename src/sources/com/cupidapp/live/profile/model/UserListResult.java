package com.cupidapp.live.profile.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserListResult {

    @Nullable
    private final Boolean hasBanUser;

    @Nullable
    private List<User> list;

    @Nullable
    private String nextCursorId;
    private final boolean secret;
    private final boolean svipRequired;

    @Nullable
    private final String title;

    @Nullable
    private final Boolean useFilter;

    public UserListResult(@Nullable List<User> list, @Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, boolean z10, boolean z11, @Nullable String str2) {
        this.list = list;
        this.nextCursorId = str;
        this.useFilter = bool;
        this.hasBanUser = bool2;
        this.secret = z10;
        this.svipRequired = z11;
        this.title = str2;
    }

    public static /* synthetic */ UserListResult copy$default(UserListResult userListResult, List list, String str, Boolean bool, Boolean bool2, boolean z10, boolean z11, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = userListResult.list;
        }
        if ((i10 & 2) != 0) {
            str = userListResult.nextCursorId;
        }
        String str3 = str;
        if ((i10 & 4) != 0) {
            bool = userListResult.useFilter;
        }
        Boolean bool3 = bool;
        if ((i10 & 8) != 0) {
            bool2 = userListResult.hasBanUser;
        }
        Boolean bool4 = bool2;
        if ((i10 & 16) != 0) {
            z10 = userListResult.secret;
        }
        boolean z12 = z10;
        if ((i10 & 32) != 0) {
            z11 = userListResult.svipRequired;
        }
        boolean z13 = z11;
        if ((i10 & 64) != 0) {
            str2 = userListResult.title;
        }
        return userListResult.copy(list, str3, bool3, bool4, z12, z13, str2);
    }

    @Nullable
    public final List<User> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.nextCursorId;
    }

    @Nullable
    public final Boolean component3() {
        return this.useFilter;
    }

    @Nullable
    public final Boolean component4() {
        return this.hasBanUser;
    }

    public final boolean component5() {
        return this.secret;
    }

    public final boolean component6() {
        return this.svipRequired;
    }

    @Nullable
    public final String component7() {
        return this.title;
    }

    @NotNull
    public final UserListResult copy(@Nullable List<User> list, @Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, boolean z10, boolean z11, @Nullable String str2) {
        return new UserListResult(list, str, bool, bool2, z10, z11, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserListResult)) {
            return false;
        }
        UserListResult userListResult = (UserListResult) obj;
        return s.d(this.list, userListResult.list) && s.d(this.nextCursorId, userListResult.nextCursorId) && s.d(this.useFilter, userListResult.useFilter) && s.d(this.hasBanUser, userListResult.hasBanUser) && this.secret == userListResult.secret && this.svipRequired == userListResult.svipRequired && s.d(this.title, userListResult.title);
    }

    @Nullable
    public final Boolean getHasBanUser() {
        return this.hasBanUser;
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public final boolean getSecret() {
        return this.secret;
    }

    public final boolean getSvipRequired() {
        return this.svipRequired;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean getUseFilter() {
        return this.useFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<User> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.nextCursorId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.useFilter;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.hasBanUser;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        boolean z10 = this.secret;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode4 + i10) * 31;
        boolean z11 = this.svipRequired;
        int i12 = (i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str2 = this.title;
        return i12 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setList(@Nullable List<User> list) {
        this.list = list;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    @NotNull
    public String toString() {
        List<User> list = this.list;
        String str = this.nextCursorId;
        Boolean bool = this.useFilter;
        Boolean bool2 = this.hasBanUser;
        return "UserListResult(list=" + ((Object) list) + ", nextCursorId=" + str + ", useFilter=" + ((Object) bool) + ", hasBanUser=" + ((Object) bool2) + ", secret=" + this.secret + ", svipRequired=" + this.svipRequired + ", title=" + this.title + ")";
    }

    public /* synthetic */ UserListResult(List list, String str, Boolean bool, Boolean bool2, boolean z10, boolean z11, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, bool, bool2, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11, str2);
    }
}

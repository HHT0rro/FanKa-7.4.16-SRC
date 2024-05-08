package com.cupidapp.live.chat.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserMatchListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserMatchListResult {

    @Nullable
    private List<User> list;

    @Nullable
    private String newMatchCount;

    @Nullable
    private String nextCursorId;

    public UserMatchListResult(@Nullable List<User> list, @Nullable String str, @Nullable String str2) {
        this.list = list;
        this.nextCursorId = str;
        this.newMatchCount = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserMatchListResult copy$default(UserMatchListResult userMatchListResult, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = userMatchListResult.list;
        }
        if ((i10 & 2) != 0) {
            str = userMatchListResult.nextCursorId;
        }
        if ((i10 & 4) != 0) {
            str2 = userMatchListResult.newMatchCount;
        }
        return userMatchListResult.copy(list, str, str2);
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
    public final String component3() {
        return this.newMatchCount;
    }

    @NotNull
    public final UserMatchListResult copy(@Nullable List<User> list, @Nullable String str, @Nullable String str2) {
        return new UserMatchListResult(list, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserMatchListResult)) {
            return false;
        }
        UserMatchListResult userMatchListResult = (UserMatchListResult) obj;
        return s.d(this.list, userMatchListResult.list) && s.d(this.nextCursorId, userMatchListResult.nextCursorId) && s.d(this.newMatchCount, userMatchListResult.newMatchCount);
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final String getNewMatchCount() {
        return this.newMatchCount;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public int hashCode() {
        List<User> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.nextCursorId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.newMatchCount;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setList(@Nullable List<User> list) {
        this.list = list;
    }

    public final void setNewMatchCount(@Nullable String str) {
        this.newMatchCount = str;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    @NotNull
    public String toString() {
        List<User> list = this.list;
        return "UserMatchListResult(list=" + ((Object) list) + ", nextCursorId=" + this.nextCursorId + ", newMatchCount=" + this.newMatchCount + ")";
    }
}

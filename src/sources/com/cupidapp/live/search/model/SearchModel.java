package com.cupidapp.live.search.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchModel {

    @Nullable
    private final String keyword;

    @NotNull
    private final User user;

    public SearchModel(@Nullable String str, @NotNull User user) {
        s.i(user, "user");
        this.keyword = str;
        this.user = user;
    }

    public static /* synthetic */ SearchModel copy$default(SearchModel searchModel, String str, User user, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = searchModel.keyword;
        }
        if ((i10 & 2) != 0) {
            user = searchModel.user;
        }
        return searchModel.copy(str, user);
    }

    @Nullable
    public final String component1() {
        return this.keyword;
    }

    @NotNull
    public final User component2() {
        return this.user;
    }

    @NotNull
    public final SearchModel copy(@Nullable String str, @NotNull User user) {
        s.i(user, "user");
        return new SearchModel(str, user);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchModel)) {
            return false;
        }
        SearchModel searchModel = (SearchModel) obj;
        return s.d(this.keyword, searchModel.keyword) && s.d(this.user, searchModel.user);
    }

    @Nullable
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.keyword;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchModel(keyword=" + this.keyword + ", user=" + ((Object) this.user) + ")";
    }
}

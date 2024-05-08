package com.cupidapp.live.main.model;

import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchResult {

    @Nullable
    private final String keyword;

    @Nullable
    private final List<User> list;

    public SearchResult(@Nullable List<User> list, @Nullable String str) {
        this.list = list;
        this.keyword = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = searchResult.list;
        }
        if ((i10 & 2) != 0) {
            str = searchResult.keyword;
        }
        return searchResult.copy(list, str);
    }

    @Nullable
    public final List<User> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.keyword;
    }

    @NotNull
    public final SearchResult copy(@Nullable List<User> list, @Nullable String str) {
        return new SearchResult(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) obj;
        return s.d(this.list, searchResult.list) && s.d(this.keyword, searchResult.keyword);
    }

    @Nullable
    public final String getKeyword() {
        return this.keyword;
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    public int hashCode() {
        List<User> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.keyword;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<User> list = this.list;
        return "SearchResult(list=" + ((Object) list) + ", keyword=" + this.keyword + ")";
    }
}

package com.cupidapp.live.match.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchSetttingModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SearchHideResult implements Serializable {

    @Nullable
    private final Boolean hideSearch;

    public SearchHideResult(@Nullable Boolean bool) {
        this.hideSearch = bool;
    }

    public static /* synthetic */ SearchHideResult copy$default(SearchHideResult searchHideResult, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = searchHideResult.hideSearch;
        }
        return searchHideResult.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.hideSearch;
    }

    @NotNull
    public final SearchHideResult copy(@Nullable Boolean bool) {
        return new SearchHideResult(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchHideResult) && s.d(this.hideSearch, ((SearchHideResult) obj).hideSearch);
    }

    @Nullable
    public final Boolean getHideSearch() {
        return this.hideSearch;
    }

    public int hashCode() {
        Boolean bool = this.hideSearch;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchHideResult(hideSearch=" + ((Object) this.hideSearch) + ")";
    }
}

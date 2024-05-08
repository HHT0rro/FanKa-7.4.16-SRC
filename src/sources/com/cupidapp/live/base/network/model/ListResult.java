package com.cupidapp.live.base.network.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Result.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ListResult<T> {

    @Nullable
    private List<T> list;

    @Nullable
    private String nextCursorId;

    public ListResult(@Nullable List<T> list, @Nullable String str) {
        this.list = list;
        this.nextCursorId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListResult copy$default(ListResult listResult, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = listResult.list;
        }
        if ((i10 & 2) != 0) {
            str = listResult.nextCursorId;
        }
        return listResult.copy(list, str);
    }

    @Nullable
    public final List<T> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.nextCursorId;
    }

    @NotNull
    public final ListResult<T> copy(@Nullable List<T> list, @Nullable String str) {
        return new ListResult<>(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListResult)) {
            return false;
        }
        ListResult listResult = (ListResult) obj;
        return s.d(this.list, listResult.list) && s.d(this.nextCursorId, listResult.nextCursorId);
    }

    @Nullable
    public final List<T> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public int hashCode() {
        List<T> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.nextCursorId;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setList(@Nullable List<T> list) {
        this.list = list;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    @NotNull
    public String toString() {
        List<T> list = this.list;
        return "ListResult(list=" + ((Object) list) + ", nextCursorId=" + this.nextCursorId + ")";
    }
}

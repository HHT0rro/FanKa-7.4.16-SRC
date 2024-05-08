package com.cupidapp.live.liveshow.model;

import b2.a;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowNextListResult {

    @Nullable
    private final String data;

    @NotNull
    private final List<LiveShowModel> list;
    private final long ttl;

    public LiveShowNextListResult(@NotNull List<LiveShowModel> list, @Nullable String str, long j10) {
        s.i(list, "list");
        this.list = list;
        this.data = str;
        this.ttl = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveShowNextListResult copy$default(LiveShowNextListResult liveShowNextListResult, List list, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveShowNextListResult.list;
        }
        if ((i10 & 2) != 0) {
            str = liveShowNextListResult.data;
        }
        if ((i10 & 4) != 0) {
            j10 = liveShowNextListResult.ttl;
        }
        return liveShowNextListResult.copy(list, str, j10);
    }

    @NotNull
    public final List<LiveShowModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.data;
    }

    public final long component3() {
        return this.ttl;
    }

    @NotNull
    public final LiveShowNextListResult copy(@NotNull List<LiveShowModel> list, @Nullable String str, long j10) {
        s.i(list, "list");
        return new LiveShowNextListResult(list, str, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowNextListResult)) {
            return false;
        }
        LiveShowNextListResult liveShowNextListResult = (LiveShowNextListResult) obj;
        return s.d(this.list, liveShowNextListResult.list) && s.d(this.data, liveShowNextListResult.data) && this.ttl == liveShowNextListResult.ttl;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final List<LiveShowModel> getList() {
        return this.list;
    }

    public final long getTtl() {
        return this.ttl;
    }

    public int hashCode() {
        int hashCode = this.list.hashCode() * 31;
        String str = this.data;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.ttl);
    }

    @NotNull
    public String toString() {
        List<LiveShowModel> list = this.list;
        return "LiveShowNextListResult(list=" + ((Object) list) + ", data=" + this.data + ", ttl=" + this.ttl + ")";
    }
}

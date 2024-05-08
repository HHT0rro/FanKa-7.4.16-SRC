package com.cupidapp.live.consult.model;

import b2.a;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultLiveNextListResult {

    @Nullable
    private final String data;

    @Nullable
    private final List<ConsultListModel> list;
    private final long ttl;

    public ConsultLiveNextListResult(@Nullable List<ConsultListModel> list, @Nullable String str, long j10) {
        this.list = list;
        this.data = str;
        this.ttl = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsultLiveNextListResult copy$default(ConsultLiveNextListResult consultLiveNextListResult, List list, String str, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = consultLiveNextListResult.list;
        }
        if ((i10 & 2) != 0) {
            str = consultLiveNextListResult.data;
        }
        if ((i10 & 4) != 0) {
            j10 = consultLiveNextListResult.ttl;
        }
        return consultLiveNextListResult.copy(list, str, j10);
    }

    @Nullable
    public final List<ConsultListModel> component1() {
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
    public final ConsultLiveNextListResult copy(@Nullable List<ConsultListModel> list, @Nullable String str, long j10) {
        return new ConsultLiveNextListResult(list, str, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultLiveNextListResult)) {
            return false;
        }
        ConsultLiveNextListResult consultLiveNextListResult = (ConsultLiveNextListResult) obj;
        return s.d(this.list, consultLiveNextListResult.list) && s.d(this.data, consultLiveNextListResult.data) && this.ttl == consultLiveNextListResult.ttl;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final List<ConsultListModel> getList() {
        return this.list;
    }

    public final long getTtl() {
        return this.ttl;
    }

    public int hashCode() {
        List<ConsultListModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.data;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + a.a(this.ttl);
    }

    @NotNull
    public String toString() {
        List<ConsultListModel> list = this.list;
        return "ConsultLiveNextListResult(list=" + ((Object) list) + ", data=" + this.data + ", ttl=" + this.ttl + ")";
    }

    public /* synthetic */ ConsultLiveNextListResult(List list, String str, long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i10 & 4) != 0 ? 60L : j10);
    }
}

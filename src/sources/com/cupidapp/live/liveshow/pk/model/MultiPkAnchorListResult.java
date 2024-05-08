package com.cupidapp.live.liveshow.pk.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkAnchorListResult {
    private final boolean inviteAccept;

    @Nullable
    private final List<MultiPkAnchorModel> list;

    public MultiPkAnchorListResult(@Nullable List<MultiPkAnchorModel> list, boolean z10) {
        this.list = list;
        this.inviteAccept = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiPkAnchorListResult copy$default(MultiPkAnchorListResult multiPkAnchorListResult, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = multiPkAnchorListResult.list;
        }
        if ((i10 & 2) != 0) {
            z10 = multiPkAnchorListResult.inviteAccept;
        }
        return multiPkAnchorListResult.copy(list, z10);
    }

    @Nullable
    public final List<MultiPkAnchorModel> component1() {
        return this.list;
    }

    public final boolean component2() {
        return this.inviteAccept;
    }

    @NotNull
    public final MultiPkAnchorListResult copy(@Nullable List<MultiPkAnchorModel> list, boolean z10) {
        return new MultiPkAnchorListResult(list, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPkAnchorListResult)) {
            return false;
        }
        MultiPkAnchorListResult multiPkAnchorListResult = (MultiPkAnchorListResult) obj;
        return s.d(this.list, multiPkAnchorListResult.list) && this.inviteAccept == multiPkAnchorListResult.inviteAccept;
    }

    public final boolean getInviteAccept() {
        return this.inviteAccept;
    }

    @Nullable
    public final List<MultiPkAnchorModel> getList() {
        return this.list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<MultiPkAnchorModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z10 = this.inviteAccept;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        List<MultiPkAnchorModel> list = this.list;
        return "MultiPkAnchorListResult(list=" + ((Object) list) + ", inviteAccept=" + this.inviteAccept + ")";
    }
}

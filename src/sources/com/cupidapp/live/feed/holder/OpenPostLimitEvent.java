package com.cupidapp.live.feed.holder;

import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LimitPostViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenPostLimitEvent {
    private final int pos;

    @Nullable
    private final String strategyId;

    @NotNull
    private final List<String> userIds;

    public OpenPostLimitEvent(@NotNull List<String> userIds, int i10, @Nullable String str) {
        s.i(userIds, "userIds");
        this.userIds = userIds;
        this.pos = i10;
        this.strategyId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPostLimitEvent copy$default(OpenPostLimitEvent openPostLimitEvent, List list, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = openPostLimitEvent.userIds;
        }
        if ((i11 & 2) != 0) {
            i10 = openPostLimitEvent.pos;
        }
        if ((i11 & 4) != 0) {
            str = openPostLimitEvent.strategyId;
        }
        return openPostLimitEvent.copy(list, i10, str);
    }

    @NotNull
    public final List<String> component1() {
        return this.userIds;
    }

    public final int component2() {
        return this.pos;
    }

    @Nullable
    public final String component3() {
        return this.strategyId;
    }

    @NotNull
    public final OpenPostLimitEvent copy(@NotNull List<String> userIds, int i10, @Nullable String str) {
        s.i(userIds, "userIds");
        return new OpenPostLimitEvent(userIds, i10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenPostLimitEvent)) {
            return false;
        }
        OpenPostLimitEvent openPostLimitEvent = (OpenPostLimitEvent) obj;
        return s.d(this.userIds, openPostLimitEvent.userIds) && this.pos == openPostLimitEvent.pos && s.d(this.strategyId, openPostLimitEvent.strategyId);
    }

    public final int getPos() {
        return this.pos;
    }

    @Nullable
    public final String getStrategyId() {
        return this.strategyId;
    }

    @NotNull
    public final List<String> getUserIds() {
        return this.userIds;
    }

    public int hashCode() {
        int hashCode = ((this.userIds.hashCode() * 31) + this.pos) * 31;
        String str = this.strategyId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        List<String> list = this.userIds;
        return "OpenPostLimitEvent(userIds=" + ((Object) list) + ", pos=" + this.pos + ", strategyId=" + this.strategyId + ")";
    }
}

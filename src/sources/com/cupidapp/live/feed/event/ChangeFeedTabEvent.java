package com.cupidapp.live.feed.event;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChangeFeedTabEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChangeFeedTabEvent {

    @Nullable
    private final String tabName;

    public ChangeFeedTabEvent(@Nullable String str) {
        this.tabName = str;
    }

    public static /* synthetic */ ChangeFeedTabEvent copy$default(ChangeFeedTabEvent changeFeedTabEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = changeFeedTabEvent.tabName;
        }
        return changeFeedTabEvent.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.tabName;
    }

    @NotNull
    public final ChangeFeedTabEvent copy(@Nullable String str) {
        return new ChangeFeedTabEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChangeFeedTabEvent) && s.d(this.tabName, ((ChangeFeedTabEvent) obj).tabName);
    }

    @Nullable
    public final String getTabName() {
        return this.tabName;
    }

    public int hashCode() {
        String str = this.tabName;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChangeFeedTabEvent(tabName=" + this.tabName + ")";
    }
}

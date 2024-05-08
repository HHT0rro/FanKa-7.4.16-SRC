package com.cupidapp.live.base.network.event;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetworkEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class JumpToWebEvent {
    private final boolean isShowCloseIcon;

    @Nullable
    private final String jumpUrl;

    public JumpToWebEvent(@Nullable String str, boolean z10) {
        this.jumpUrl = str;
        this.isShowCloseIcon = z10;
    }

    public static /* synthetic */ JumpToWebEvent copy$default(JumpToWebEvent jumpToWebEvent, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = jumpToWebEvent.jumpUrl;
        }
        if ((i10 & 2) != 0) {
            z10 = jumpToWebEvent.isShowCloseIcon;
        }
        return jumpToWebEvent.copy(str, z10);
    }

    @Nullable
    public final String component1() {
        return this.jumpUrl;
    }

    public final boolean component2() {
        return this.isShowCloseIcon;
    }

    @NotNull
    public final JumpToWebEvent copy(@Nullable String str, boolean z10) {
        return new JumpToWebEvent(str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JumpToWebEvent)) {
            return false;
        }
        JumpToWebEvent jumpToWebEvent = (JumpToWebEvent) obj;
        return s.d(this.jumpUrl, jumpToWebEvent.jumpUrl) && this.isShowCloseIcon == jumpToWebEvent.isShowCloseIcon;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.jumpUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.isShowCloseIcon;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isShowCloseIcon() {
        return this.isShowCloseIcon;
    }

    @NotNull
    public String toString() {
        return "JumpToWebEvent(jumpUrl=" + this.jumpUrl + ", isShowCloseIcon=" + this.isShowCloseIcon + ")";
    }

    public /* synthetic */ JumpToWebEvent(String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}

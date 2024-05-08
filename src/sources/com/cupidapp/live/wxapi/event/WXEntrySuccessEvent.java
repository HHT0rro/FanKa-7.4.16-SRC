package com.cupidapp.live.wxapi.event;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WXEntrySuccessEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WXEntrySuccessEvent {

    @Nullable
    private final String code;

    public WXEntrySuccessEvent(@Nullable String str) {
        this.code = str;
    }

    public static /* synthetic */ WXEntrySuccessEvent copy$default(WXEntrySuccessEvent wXEntrySuccessEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = wXEntrySuccessEvent.code;
        }
        return wXEntrySuccessEvent.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final WXEntrySuccessEvent copy(@Nullable String str) {
        return new WXEntrySuccessEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WXEntrySuccessEvent) && s.d(this.code, ((WXEntrySuccessEvent) obj).code);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        String str = this.code;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "WXEntrySuccessEvent(code=" + this.code + ")";
    }
}

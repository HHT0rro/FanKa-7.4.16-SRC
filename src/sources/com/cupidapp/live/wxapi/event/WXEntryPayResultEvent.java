package com.cupidapp.live.wxapi.event;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WXEntryPayResultEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WXEntryPayResultEvent {

    @Nullable
    private Integer code;

    public WXEntryPayResultEvent(@Nullable Integer num) {
        this.code = num;
    }

    public static /* synthetic */ WXEntryPayResultEvent copy$default(WXEntryPayResultEvent wXEntryPayResultEvent, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = wXEntryPayResultEvent.code;
        }
        return wXEntryPayResultEvent.copy(num);
    }

    @Nullable
    public final Integer component1() {
        return this.code;
    }

    @NotNull
    public final WXEntryPayResultEvent copy(@Nullable Integer num) {
        return new WXEntryPayResultEvent(num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WXEntryPayResultEvent) && s.d(this.code, ((WXEntryPayResultEvent) obj).code);
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    public int hashCode() {
        Integer num = this.code;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    @NotNull
    public String toString() {
        return "WXEntryPayResultEvent(code=" + ((Object) this.code) + ")";
    }
}

package com.cupidapp.live.base.router.jumper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SuperBoostBuyAlertUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenSuperBoostBuyAlertEvent {

    @Nullable
    private final String source;

    public OpenSuperBoostBuyAlertEvent(@Nullable String str) {
        this.source = str;
    }

    public static /* synthetic */ OpenSuperBoostBuyAlertEvent copy$default(OpenSuperBoostBuyAlertEvent openSuperBoostBuyAlertEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = openSuperBoostBuyAlertEvent.source;
        }
        return openSuperBoostBuyAlertEvent.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.source;
    }

    @NotNull
    public final OpenSuperBoostBuyAlertEvent copy(@Nullable String str) {
        return new OpenSuperBoostBuyAlertEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenSuperBoostBuyAlertEvent) && kotlin.jvm.internal.s.d(this.source, ((OpenSuperBoostBuyAlertEvent) obj).source);
    }

    @Nullable
    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.source;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpenSuperBoostBuyAlertEvent(source=" + this.source + ")";
    }
}

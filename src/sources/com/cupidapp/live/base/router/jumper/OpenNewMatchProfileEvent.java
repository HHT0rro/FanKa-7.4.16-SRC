package com.cupidapp.live.base.router.jumper;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewMatchUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OpenNewMatchProfileEvent {

    @Nullable
    private final String userId;

    public OpenNewMatchProfileEvent(@Nullable String str) {
        this.userId = str;
    }

    public static /* synthetic */ OpenNewMatchProfileEvent copy$default(OpenNewMatchProfileEvent openNewMatchProfileEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = openNewMatchProfileEvent.userId;
        }
        return openNewMatchProfileEvent.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.userId;
    }

    @NotNull
    public final OpenNewMatchProfileEvent copy(@Nullable String str) {
        return new OpenNewMatchProfileEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenNewMatchProfileEvent) && kotlin.jvm.internal.s.d(this.userId, ((OpenNewMatchProfileEvent) obj).userId);
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "OpenNewMatchProfileEvent(userId=" + this.userId + ")";
    }
}

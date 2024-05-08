package com.cupidapp.live.profile.event;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ShowGuideBubbleEvent {

    @Nullable
    private final String type;

    public ShowGuideBubbleEvent(@Nullable String str) {
        this.type = str;
    }

    public static /* synthetic */ ShowGuideBubbleEvent copy$default(ShowGuideBubbleEvent showGuideBubbleEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = showGuideBubbleEvent.type;
        }
        return showGuideBubbleEvent.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final ShowGuideBubbleEvent copy(@Nullable String str) {
        return new ShowGuideBubbleEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShowGuideBubbleEvent) && s.d(this.type, ((ShowGuideBubbleEvent) obj).type);
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShowGuideBubbleEvent(type=" + this.type + ")";
    }
}

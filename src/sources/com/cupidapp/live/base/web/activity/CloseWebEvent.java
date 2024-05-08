package com.cupidapp.live.base.web.activity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseWebActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CloseWebEvent {

    @NotNull
    private final String url;

    public CloseWebEvent(@NotNull String url) {
        s.i(url, "url");
        this.url = url;
    }

    public static /* synthetic */ CloseWebEvent copy$default(CloseWebEvent closeWebEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = closeWebEvent.url;
        }
        return closeWebEvent.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final CloseWebEvent copy(@NotNull String url) {
        s.i(url, "url");
        return new CloseWebEvent(url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CloseWebEvent) && s.d(this.url, ((CloseWebEvent) obj).url);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "CloseWebEvent(url=" + this.url + ")";
    }
}

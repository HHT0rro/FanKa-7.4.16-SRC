package com.cupidapp.live.liveshow.activity;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseLiveActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveOpenWebFragmentEvent {
    private final boolean cover;

    @Nullable
    private final String url;

    public FKLiveOpenWebFragmentEvent(@Nullable String str, boolean z10) {
        this.url = str;
        this.cover = z10;
    }

    public final boolean getCover() {
        return this.cover;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ FKLiveOpenWebFragmentEvent(String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}

package com.cupidapp.live.match.event;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserDataChangeEvent {
    private final boolean aloha;

    @Nullable
    private final String userId;

    public UserDataChangeEvent(@Nullable String str, boolean z10) {
        this.userId = str;
        this.aloha = z10;
    }

    public final boolean getAloha() {
        return this.aloha;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }
}

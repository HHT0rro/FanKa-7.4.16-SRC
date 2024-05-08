package com.cupidapp.live.setting.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PushChannelModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushChannelModel {

    @NotNull
    private final String pushChannelId;

    @NotNull
    private final String pushChannelName;

    public PushChannelModel(@NotNull String pushChannelId, @NotNull String pushChannelName) {
        s.i(pushChannelId, "pushChannelId");
        s.i(pushChannelName, "pushChannelName");
        this.pushChannelId = pushChannelId;
        this.pushChannelName = pushChannelName;
    }

    @NotNull
    public final String getPushChannelId() {
        return this.pushChannelId;
    }

    @NotNull
    public final String getPushChannelName() {
        return this.pushChannelName;
    }
}

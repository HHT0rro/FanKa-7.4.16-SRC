package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileSensorContext.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ProfileSensorContext extends FKSensorContext {
    private final boolean isMe;

    @Nullable
    private final String postId;

    @Nullable
    private final String refer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSensorContext(@Nullable String str, @Nullable String str2, boolean z10, @NotNull SensorPosition source, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene) {
        super(z10 ? SensorPosition.MyProfile : SensorPosition.Profile, source, sensorPosition, sensorScene);
        s.i(source, "source");
        this.refer = str;
        this.postId = str2;
        this.isMe = z10;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }

    @Nullable
    public final String getRefer() {
        return this.refer;
    }

    public final boolean isMe() {
        return this.isMe;
    }
}

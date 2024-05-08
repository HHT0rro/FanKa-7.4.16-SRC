package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileSensorContext.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedSensorContext extends FKSensorContext {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSensorContext(@NotNull SensorPosition position, @NotNull SensorPosition source, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene) {
        super(position, source, sensorPosition, sensorScene);
        s.i(position, "position");
        s.i(source, "source");
    }
}

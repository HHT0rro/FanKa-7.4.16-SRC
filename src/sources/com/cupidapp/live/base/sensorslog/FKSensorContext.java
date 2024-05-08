package com.cupidapp.live.base.sensorslog;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSensorContext.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKSensorContext implements Serializable {

    @Nullable
    private final SensorPosition originSource;

    @NotNull
    private final SensorPosition position;

    @Nullable
    private final SensorScene scene;

    @NotNull
    private final SensorPosition source;

    public FKSensorContext(@NotNull SensorPosition position, @NotNull SensorPosition source, @Nullable SensorPosition sensorPosition, @Nullable SensorScene sensorScene) {
        s.i(position, "position");
        s.i(source, "source");
        this.position = position;
        this.source = source;
        this.originSource = sensorPosition;
        this.scene = sensorScene;
    }

    @Nullable
    public final SensorPosition getOriginSource() {
        return this.originSource;
    }

    @NotNull
    public final SensorPosition getPosition() {
        return this.position;
    }

    @Nullable
    public final SensorScene getScene() {
        return this.scene;
    }

    @NotNull
    public final SensorPosition getSource() {
        return this.source;
    }
}

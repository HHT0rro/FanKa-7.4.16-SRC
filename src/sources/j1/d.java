package j1;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.TrackEditInfoType;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogChangeInfo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f50229a = new d();

    public final void a(@NotNull TrackEditInfoType infoType, @NotNull SensorPosition sensorPosition) {
        s.i(infoType, "infoType");
        s.i(sensorPosition, "sensorPosition");
        b(infoType.getValue(), sensorPosition);
    }

    public final void b(@NotNull String infoType, @NotNull SensorPosition sensorPosition) {
        s.i(infoType, "infoType");
        s.i(sensorPosition, "sensorPosition");
        GroupOthersLog.f18702a.x(infoType, sensorPosition.getValue());
    }
}

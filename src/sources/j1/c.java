package j1;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogAppViewScreen.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f50228a = new c();

    public static /* synthetic */ void b(c cVar, SensorPosition sensorPosition, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        cVar.a(sensorPosition, str, str2);
    }

    public final void a(@NotNull SensorPosition screenName, @Nullable String str, @Nullable String str2) {
        s.i(screenName, "screenName");
        GroupOthersLog.f18702a.c(screenName.getValue(), str, str2);
    }
}

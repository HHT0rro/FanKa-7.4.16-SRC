package j1;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogScreenShot.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f50238a = new k();

    public static /* synthetic */ void b(k kVar, SensorPosition sensorPosition, String str, String str2, long j10, int i10, Object obj) {
        kVar.a(sensorPosition, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, j10);
    }

    public final void a(@NotNull SensorPosition screenName, @Nullable String str, @Nullable String str2, long j10) {
        s.i(screenName, "screenName");
        GroupOthersLog.f18702a.y(screenName.getValue(), str, str2, (int) (j10 / 1000));
    }

    public final void c(@NotNull SensorPosition screenName, @Nullable String str, @Nullable String str2, boolean z10) {
        s.i(screenName, "screenName");
        GroupOthersLog.f18702a.h(screenName.getValue(), str, f(z10), str2);
    }

    public final void d(@NotNull SensorPosition screenName, boolean z10) {
        s.i(screenName, "screenName");
        GroupOthersLog.f18702a.h(screenName.getValue(), null, f(z10), null);
    }

    public final void e(@NotNull String screenName, boolean z10) {
        s.i(screenName, "screenName");
        GroupOthersLog.f18702a.h(screenName, null, f(z10), null);
    }

    public final String f(boolean z10) {
        return z10 ? "LONG_SCREENSHOT" : "COMMON_SCREENSHOT";
    }
}

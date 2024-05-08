package j1;

import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogPopup.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a */
    @NotNull
    public static final i f50236a = new i();

    public static /* synthetic */ void d(i iVar, PopupName popupName, PopupButtonName popupButtonName, SensorPosition sensorPosition, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sensorPosition = null;
        }
        iVar.a(popupName, popupButtonName, sensorPosition);
    }

    public static /* synthetic */ void e(i iVar, PopupName popupName, String str, SensorPosition sensorPosition, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sensorPosition = null;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        iVar.b(popupName, str, sensorPosition, str2);
    }

    public static /* synthetic */ void g(i iVar, PopupName popupName, SensorPosition sensorPosition, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            sensorPosition = null;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        iVar.f(popupName, sensorPosition, str);
    }

    public final void a(@NotNull PopupName popupName, @NotNull PopupButtonName buttonName, @Nullable SensorPosition sensorPosition) {
        s.i(popupName, "popupName");
        s.i(buttonName, "buttonName");
        GroupOthersLog.Y(GroupOthersLog.f18702a, popupName.name(), sensorPosition != null ? sensorPosition.getValue() : null, buttonName.getValue(), null, 8, null);
    }

    public final void b(@NotNull PopupName popupName, @NotNull String buttonName, @Nullable SensorPosition sensorPosition, @Nullable String str) {
        s.i(popupName, "popupName");
        s.i(buttonName, "buttonName");
        GroupOthersLog.f18702a.X(popupName.name(), sensorPosition != null ? sensorPosition.getValue() : null, buttonName, str);
    }

    public final void c(@NotNull PopupName popupName, @NotNull String buttonName, @Nullable String str) {
        s.i(popupName, "popupName");
        s.i(buttonName, "buttonName");
        GroupOthersLog.Y(GroupOthersLog.f18702a, popupName.name(), str, buttonName, null, 8, null);
    }

    public final void f(@NotNull PopupName popupName, @Nullable SensorPosition sensorPosition, @Nullable String str) {
        s.i(popupName, "popupName");
        GroupOthersLog.f18702a.Z(popupName.name(), sensorPosition != null ? sensorPosition.getValue() : null, str);
    }
}

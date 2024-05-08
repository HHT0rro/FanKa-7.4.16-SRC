package j1;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogSetting.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f50239a = new l();

    public final void a(boolean z10) {
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.P().c(), Boolean.valueOf(z10))) {
            return;
        }
        gVar.K1().d(Boolean.FALSE);
        gVar.P().d(Boolean.valueOf(z10));
        com.cupidapp.live.base.utils.j.f12332a.a("MiniLiveShow", "上报 MiniWindowPermissionSwitch:" + z10);
    }
}

package u0;

import com.cupidapp.live.base.abtest.ABTestGroup;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import z3.c;

/* compiled from: GroupTestManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f53817a = new a();

    public final void a() {
    }

    public final boolean b() {
        return c.f54829a.e("android_matchTab_redPoint_showRedPoint", false);
    }

    public final boolean c() {
        return s.d(c.f54829a.d("finka_preloadH5_open", ABTestGroup.A.getValue()), ABTestGroup.B.getValue());
    }

    public final boolean d() {
        return s.d(c.f54829a.d("finka_vip_newest_view_entrance", ABTestGroup.A.getValue()), ABTestGroup.B.getValue());
    }

    public final boolean e() {
        return c.f54829a.e("flutter漫游_useFlutterRoaming", false);
    }
}

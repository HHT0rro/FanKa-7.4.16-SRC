package w0;

import android.content.Context;
import com.cupidapp.live.profile.model.User;
import com.tencent.bugly.crashreport.CrashReport;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: CrashHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54093a = new a();

    public final void a(@NotNull Context context, @Nullable String str, @Nullable String str2) {
        s.i(context, "context");
        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(context);
        userStrategy.setAppChannel(com.cupidapp.live.base.network.a.f11902a.r());
        userStrategy.setAppVersion("7.4.16.0");
        userStrategy.setUploadProcess(str == null || s.d(str, str2));
        CrashReport.initCrashReport(context, "a132bebd1b", false, userStrategy);
        b();
    }

    public final void b() {
        User X = g.f52734a.X();
        CrashReport.setUserId(X != null ? X.userId() : null);
    }
}

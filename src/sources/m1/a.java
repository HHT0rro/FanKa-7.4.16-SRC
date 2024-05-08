package m1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.cupidapp.live.R$string;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.openalliance.ad.constant.u;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: OpenAppStoreUtils.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f51796a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Map<String, List<String>> f51797b = i0.g(f.a("huawei", r.e(u.W)), f.a(ADEvent.XIAOMI, r.e("com.xiaomi.market")), f.a(ADEvent.VIVO, r.e("com.bbk.appstore")), f.a("oppo", s.m("com.oppo.market", "com.heytap.market")), f.a("oneplus", s.m("com.oppo.market", "com.heytap.market")), f.a("samsung", r.e("com.sec.android.app.samsungapps")), f.a("meizu", r.e("com.meizu.mstore")));

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static String f51798c;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a aVar, Context context, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        aVar.b(context, function0);
    }

    public final boolean a(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "context");
        Map<String, List<String>> map = f51797b;
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.s.h(MANUFACTURER, "MANUFACTURER");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.s.h(locale, "getDefault()");
        String lowerCase = MANUFACTURER.toLowerCase(locale);
        kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        List<String> list = map.get(lowerCase);
        if (list != null) {
            for (String str : list) {
                if (h.a(context, str)) {
                    f51798c = str;
                }
            }
        }
        return f51798c != null;
    }

    public final void b(@NotNull Context context, @Nullable Function0<p> function0) {
        kotlin.jvm.internal.s.i(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
            String str = f51798c;
            if (str != null) {
                intent.setPackage(str);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.cupidapp.live.base.view.h.f12779a.r(context, R$string.not_install_app_market);
            if (function0 != null) {
                function0.invoke();
            }
        }
    }
}

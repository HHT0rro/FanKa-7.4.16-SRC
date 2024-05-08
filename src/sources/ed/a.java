package ed;

import android.content.Context;
import com.hailiang.advlib.common.d;
import com.hailiang.advlib.core.ADEvent;
import com.hailiang.advlib.core.IADBrowser;
import com.hailiang.advlib.core.IInciteAd;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.IMultiAdRequest;
import com.hailiang.advlib.core.QMConfig;
import com.hailiang.advlib.core._factory;
import com.hailiang.advlib.core.b;
import com.hailiang.advlib.ui.banner.Banner;
import fd.c;
import fd.f;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: LoadRemote.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ClassLoader f49021a;

    /* renamed from: b, reason: collision with root package name */
    public static AtomicInteger f49022b;

    /* compiled from: LoadRemote.java */
    /* renamed from: ed.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0729a implements c {
        @Override // fd.c
        public String b() {
            return a.c();
        }

        @Override // fd.c
        public String c() {
            return ADEvent.HAILIANG;
        }

        @Override // fd.c
        public Map<Class, String> e() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(_factory.class, "com.hailiang.advlib.__remote__.core.ICliFactory");
            linkedHashMap.put(Banner.class, "com.hailiang.advlib.__remote__.ui.banner._imp_adbanner");
            linkedHashMap.put(IADBrowser.class, "com.hailiang.advlib.__remote__.ui.front._imp_adbrowser");
            linkedHashMap.put(IInciteAd.class, "com.hailiang.advlib.__remote__.ui.front._imp_inciteadactivity");
            linkedHashMap.put(IMultiAdRequest.class, "com.hailiang.advlib.__remote__.core.MultiAdRequest");
            linkedHashMap.put(IMultiAdObject.class, "com.hailiang.advlib.__remote__.core.MultiAdObject");
            linkedHashMap.put(b.class, "com.hailiang.advlib.__remote__.__bootstrap__.LibInit");
            return linkedHashMap;
        }
    }

    static {
        d.f27128c = "12.426";
        d.f27129d = "3.460";
        f49021a = null;
        f49022b = new AtomicInteger(0);
    }

    public static boolean a(Context context) {
        return b(new QMConfig.Builder().build(context));
    }

    public static boolean b(QMConfig qMConfig) {
        return f.g(qMConfig, new C0729a());
    }

    public static String c() {
        try {
            Field declaredField = com.hailiang.advlib.common.b.c().b(b.class).getDeclaredField("aisdk_lib_version");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}

package aa;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import y9.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Class, Object> f723a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f723a = concurrentHashMap;
        if (concurrentHashMap.size() <= 0) {
            b(y9.c.class, new d());
        }
    }

    public static Object a(Class cls) {
        if (cls == null) {
            fa.a.c("MarketInstallApiRegiste", "apiClass can not be null");
            return null;
        }
        Object obj = f723a.get(cls);
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return obj;
    }

    public static boolean b(Class cls, a aVar) {
        String str;
        if (cls == null) {
            str = "class is null.";
        } else if (aVar == null) {
            str = "Impl is null.";
        } else {
            if (cls.isAssignableFrom(aVar.getClass())) {
                f723a.put(cls, aVar);
                return true;
            }
            str = "Impl is not extends right class:" + ((Object) cls) + "-" + ((Object) aVar.getClass());
        }
        fa.a.c("MarketInstallApiRegiste", str);
        return false;
    }
}

package x;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static List<i> f54351a;

    static {
        ArrayList arrayList = new ArrayList();
        f54351a = arrayList;
        arrayList.add(new l());
        f54351a.add(new d());
        f54351a.add(new c());
        f54351a.add(new h());
        f54351a.add(new k());
        f54351a.add(new b());
        f54351a.add(new a());
        f54351a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t2;
        for (i iVar : f54351a) {
            if (iVar.a(y.a.a(type)) && (t2 = (T) iVar.b(obj, type)) != null) {
                return t2;
            }
        }
        return null;
    }

    public static final Object b(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("[") && trim.endsWith("]")) {
            bVar = new org.json.alipay.a(trim);
        } else {
            if (!trim.startsWith("{") || !trim.endsWith(com.alipay.sdk.util.i.f4738d)) {
                return a(trim, type);
            }
            bVar = new org.json.alipay.b(trim);
        }
        return a(bVar, type);
    }
}

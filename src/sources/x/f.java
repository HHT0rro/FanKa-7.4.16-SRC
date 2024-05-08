package x;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static List<j> f54352a;

    static {
        ArrayList arrayList = new ArrayList();
        f54352a = arrayList;
        arrayList.add(new l());
        f54352a.add(new d());
        f54352a.add(new c());
        f54352a.add(new h());
        f54352a.add(new b());
        f54352a.add(new a());
        f54352a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b4 = b(obj);
        if (y.a.b(b4.getClass())) {
            return org.json.alipay.b.c(b4.toString());
        }
        if (Collection.class.isAssignableFrom(b4.getClass())) {
            return new org.json.alipay.a((Collection) b4).toString();
        }
        if (Map.class.isAssignableFrom(b4.getClass())) {
            return new org.json.alipay.b((Map) b4).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + ((Object) b4.getClass()));
    }

    public static Object b(Object obj) {
        Object a10;
        if (obj == null) {
            return null;
        }
        for (j jVar : f54352a) {
            if (jVar.a(obj.getClass()) && (a10 = jVar.a(obj)) != null) {
                return a10;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + ((Object) obj.getClass()));
    }
}

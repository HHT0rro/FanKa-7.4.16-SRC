package z8;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f55038a = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        String a(d dVar);
    }

    public static Map<String, a> a() {
        return f55038a;
    }

    public static void b(String str, a aVar) {
        f55038a.put(str, aVar);
    }
}

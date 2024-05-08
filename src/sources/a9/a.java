package a9;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a implements z8.d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f721a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f722b = new Object();

    public static a b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return c(context, context.getPackageName());
    }

    public static a c(Context context, String str) {
        a aVar;
        synchronized (f722b) {
            Map<String, a> map = f721a;
            aVar = map.get(str);
            if (aVar == null) {
                aVar = new b9.d(context, str);
                map.put(str, aVar);
            }
        }
        return aVar;
    }
}

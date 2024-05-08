package b9;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class n implements a9.c {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, String> f1453a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final l f1454b;

    public n(Context context, String str) {
        this.f1454b = new l(context, str);
    }

    @Override // a9.c
    public String getString(String str, String str2) {
        String str3 = this.f1453a.get(str);
        if (str3 != null) {
            return str3;
        }
        String b4 = this.f1454b.b(str, str2);
        if (b4 == null) {
            return str2;
        }
        this.f1453a.put(str, b4);
        return b4;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}

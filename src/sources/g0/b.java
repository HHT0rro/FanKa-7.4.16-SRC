package g0;

import android.content.Context;
import e0.d;
import f0.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public static a f49360a;

    /* renamed from: b, reason: collision with root package name */
    public static e0.a f49361b;

    public static a b(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f49360a == null) {
            f49361b = d.a(context, str);
            f49360a = new b();
        }
        return f49360a;
    }

    @Override // g0.a
    public c a(f0.d dVar) {
        return f0.b.b(f49361b.a(f0.b.a(dVar)));
    }

    @Override // g0.a
    public boolean a(String str) {
        return f49361b.a(str);
    }
}

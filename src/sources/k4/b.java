package k4;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.c;
import com.nostra13.universalimageloader.core.d;
import com.nostra13.universalimageloader.core.e;
import l4.c;
import l4.e;
import l4.g;

/* compiled from: ApngImageLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b extends d {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f50645f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f50646g;

    /* renamed from: h, reason: collision with root package name */
    public static b f50647h;

    /* renamed from: e, reason: collision with root package name */
    public Context f50648e;

    /* compiled from: ApngImageLoader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f50649a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C0769b f50650b;

        public a(e eVar, C0769b c0769b) {
            this.f50649a = eVar;
            this.f50650b = c0769b;
        }

        @Override // l4.c
        public void a(boolean z10, String str, View view) {
            k4.a g3;
            if (z10 && (g3 = k4.a.g(view)) != null) {
                g3.m(this.f50649a);
                int i10 = this.f50650b.f50652a;
                if (i10 > 0) {
                    g3.n(i10);
                }
                g3.o(this.f50650b.f50654c);
                g3.start();
            }
        }
    }

    /* compiled from: ApngImageLoader.java */
    /* renamed from: k4.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class C0769b {

        /* renamed from: a, reason: collision with root package name */
        public int f50652a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f50653b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f50654c;

        public C0769b(int i10, boolean z10, boolean z11) {
            this.f50652a = i10;
            this.f50653b = z10;
            this.f50654c = z11;
        }
    }

    public static b p() {
        if (f50647h == null) {
            synchronized (b.class) {
                if (f50647h == null) {
                    f50647h = new b();
                }
            }
        }
        return f50647h;
    }

    public void l(String str, ImageView imageView, C0769b c0769b, e eVar) {
        super.c(str, imageView, new l4.d(this.f50648e, Uri.parse(str), m(c0769b, eVar)));
    }

    public final c m(C0769b c0769b, e eVar) {
        if (c0769b == null || !c0769b.f50653b) {
            return null;
        }
        return new a(eVar, c0769b);
    }

    public final com.nostra13.universalimageloader.core.e n(Context context) {
        return new e.b(context).z(new ib.b(2097152)).A(2097152).w(52428800).v(100).x(new l4.b(context)).u(new c.b().u(false).v(true).t()).t();
    }

    public final com.nostra13.universalimageloader.core.e o() {
        return new e.b(this.f50648e).z(new ib.b(8388608)).A(8388608).w(52428800).v(100).t();
    }

    public void q(Context context) {
        r(context, null, null);
    }

    public void r(Context context, com.nostra13.universalimageloader.core.e eVar, com.nostra13.universalimageloader.core.e eVar2) {
        this.f50648e = context.getApplicationContext();
        if (eVar == null) {
            eVar = o();
        }
        if (eVar2 == null) {
            eVar2 = n(this.f50648e);
        }
        g.l().g(eVar);
        super.g(eVar2);
    }
}

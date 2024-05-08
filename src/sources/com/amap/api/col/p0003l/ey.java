package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: PluginContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ey extends ContextThemeWrapper {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f5665d = {"android.widget", "android.webkit", "android.app"};

    /* renamed from: a, reason: collision with root package name */
    private Resources f5666a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f5667b;

    /* renamed from: c, reason: collision with root package name */
    private ClassLoader f5668c;

    /* renamed from: e, reason: collision with root package name */
    private a f5669e;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater.Factory f5670f;

    /* compiled from: PluginContext.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public HashSet<String> f5672a = new HashSet<>();

        /* renamed from: b, reason: collision with root package name */
        public HashMap<String, Constructor<?>> f5673b = new HashMap<>();

        public a() {
        }
    }

    public ey(Context context, int i10, ClassLoader classLoader) {
        super(context, i10);
        this.f5669e = new a();
        this.f5670f = new LayoutInflater.Factory() { // from class: com.amap.api.col.3l.ey.1
            @Override // android.view.LayoutInflater.Factory
            public final View onCreateView(String str, Context context2, AttributeSet attributeSet) {
                return ey.this.a(str, context2, attributeSet);
            }
        };
        this.f5666a = ez.a();
        this.f5668c = classLoader;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.f5666a;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f5667b == null) {
                LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
                if (layoutInflater != null) {
                    this.f5667b = layoutInflater.cloneInContext(this);
                }
                this.f5667b.setFactory(this.f5670f);
                this.f5667b = this.f5667b.cloneInContext(this);
            }
            return this.f5667b;
        }
        return super.getSystemService(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View a(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r11 = this;
            com.amap.api.col.3l.ey$a r0 = r11.f5669e
            java.util.HashSet<java.lang.String> r0 = r0.f5672a
            boolean r0 = r0.contains(r12)
            r1 = 0
            if (r0 == 0) goto Lc
            return r1
        Lc:
            com.amap.api.col.3l.ey$a r0 = r11.f5669e
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.f5673b
            java.lang.Object r0 = r0.get(r12)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L86
            java.lang.String r5 = "api.navi"
            boolean r5 = r12.contains(r5)     // Catch: java.lang.Throwable -> L63
            if (r5 == 0) goto L2a
            java.lang.ClassLoader r5 = r11.f5668c     // Catch: java.lang.Throwable -> L63
            java.lang.Class r5 = r5.loadClass(r12)     // Catch: java.lang.Throwable -> L63
            goto L51
        L2a:
            java.lang.String[] r5 = com.amap.api.col.p0003l.ey.f5665d     // Catch: java.lang.Throwable -> L63
            int r6 = r5.length     // Catch: java.lang.Throwable -> L63
            r7 = 0
        L2e:
            if (r7 >= r6) goto L50
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L63
            java.lang.ClassLoader r9 = r11.f5668c     // Catch: java.lang.Throwable -> L4d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r10.<init>()     // Catch: java.lang.Throwable -> L4d
            r10.append(r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "."
            r10.append(r8)     // Catch: java.lang.Throwable -> L4d
            r10.append(r12)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.Class r5 = r9.loadClass(r8)     // Catch: java.lang.Throwable -> L4d
            goto L51
        L4d:
            int r7 = r7 + 1
            goto L2e
        L50:
            r5 = r1
        L51:
            if (r5 != 0) goto L54
            goto L64
        L54:
            java.lang.Class<android.view.ViewStub> r6 = android.view.ViewStub.class
            if (r5 == r6) goto L64
            java.lang.ClassLoader r6 = r5.getClassLoader()     // Catch: java.lang.Throwable -> L64
            java.lang.ClassLoader r7 = r11.f5668c     // Catch: java.lang.Throwable -> L64
            if (r6 == r7) goto L61
            goto L64
        L61:
            r6 = 1
            goto L65
        L63:
            r5 = r1
        L64:
            r6 = 0
        L65:
            if (r6 != 0) goto L6f
            com.amap.api.col.3l.ey$a r13 = r11.f5669e
            java.util.HashSet<java.lang.String> r13 = r13.f5672a
            r13.add(r12)
            return r1
        L6f:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L85
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch: java.lang.Throwable -> L85
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r6[r3] = r7     // Catch: java.lang.Throwable -> L85
            java.lang.reflect.Constructor r0 = r5.getConstructor(r6)     // Catch: java.lang.Throwable -> L85
            com.amap.api.col.3l.ey$a r5 = r11.f5669e     // Catch: java.lang.Throwable -> L85
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r5 = r5.f5673b     // Catch: java.lang.Throwable -> L85
            r5.put(r12, r0)     // Catch: java.lang.Throwable -> L85
            goto L86
        L85:
        L86:
            if (r0 == 0) goto L96
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L96
            r12[r4] = r13     // Catch: java.lang.Throwable -> L96
            r12[r3] = r14     // Catch: java.lang.Throwable -> L96
            java.lang.Object r12 = r0.newInstance(r12)     // Catch: java.lang.Throwable -> L96
            android.view.View r12 = (android.view.View) r12     // Catch: java.lang.Throwable -> L96
            r1 = r12
        L96:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.ey.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }
}

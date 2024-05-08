package com.xiaomi.push;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class x0 implements f5 {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f48462g;

    /* renamed from: b, reason: collision with root package name */
    public u4 f48464b;

    /* renamed from: a, reason: collision with root package name */
    public SimpleDateFormat f48463a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: c, reason: collision with root package name */
    public a f48465c = null;

    /* renamed from: d, reason: collision with root package name */
    public a f48466d = null;

    /* renamed from: e, reason: collision with root package name */
    public x4 f48467e = null;

    /* renamed from: f, reason: collision with root package name */
    public final String f48468f = "[Slim] ";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements z4, g5 {

        /* renamed from: a, reason: collision with root package name */
        public String f48469a;

        public a(boolean z10) {
            this.f48469a = z10 ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.z4
        public void a(k5 k5Var) {
            StringBuilder sb2;
            String str;
            if (x0.f48462g) {
                sb2 = new StringBuilder();
                sb2.append("[Slim] ");
                sb2.append(x0.this.f48463a.format(new Date()));
                sb2.append(this.f48469a);
                sb2.append(" PKT ");
                str = k5Var.f();
            } else {
                sb2 = new StringBuilder();
                sb2.append("[Slim] ");
                sb2.append(x0.this.f48463a.format(new Date()));
                sb2.append(this.f48469a);
                sb2.append(" PKT [");
                sb2.append(k5Var.m());
                sb2.append(",");
                sb2.append(k5Var.l());
                str = "]";
            }
            sb2.append(str);
            fc.c.m(sb2.toString());
        }

        @Override // com.xiaomi.push.g5
        /* renamed from: a, reason: collision with other method in class */
        public boolean mo3064a(k5 k5Var) {
            return true;
        }

        @Override // com.xiaomi.push.z4
        public void b(n4 n4Var) {
            StringBuilder sb2;
            String str;
            if (x0.f48462g) {
                sb2 = new StringBuilder();
                sb2.append("[Slim] ");
                sb2.append(x0.this.f48463a.format(new Date()));
                sb2.append(this.f48469a);
                str = n4Var.toString();
            } else {
                sb2 = new StringBuilder();
                sb2.append("[Slim] ");
                sb2.append(x0.this.f48463a.format(new Date()));
                sb2.append(this.f48469a);
                sb2.append(" Blob [");
                sb2.append(n4Var.d());
                sb2.append(",");
                sb2.append(n4Var.a());
                sb2.append(",");
                sb2.append(n4Var.w());
                str = "]";
            }
            sb2.append(str);
            fc.c.m(sb2.toString());
        }
    }

    public x0(u4 u4Var) {
        this.f48464b = u4Var;
        c();
    }

    public final void c() {
        this.f48465c = new a(true);
        this.f48466d = new a(false);
        u4 u4Var = this.f48464b;
        a aVar = this.f48465c;
        u4Var.i(aVar, aVar);
        u4 u4Var2 = this.f48464b;
        a aVar2 = this.f48466d;
        u4Var2.w(aVar2, aVar2);
        this.f48467e = new y0(this);
    }
}

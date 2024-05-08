package com.xiaomi.push;

import com.xiaomi.push.e2;
import java.io.File;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f2 extends e2.b {

    /* renamed from: c, reason: collision with root package name */
    public File f47230c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f47231d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Date f47232e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Date f47233f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f47234g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f47235h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f47236i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ e2 f47237j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(e2 e2Var, int i10, Date date, Date date2, String str, String str2, boolean z10) {
        super();
        this.f47237j = e2Var;
        this.f47231d = i10;
        this.f47232e = date;
        this.f47233f = date2;
        this.f47234g = str;
        this.f47235h = str2;
        this.f47236i = z10;
    }

    @Override // com.xiaomi.push.e2.b, com.xiaomi.push.r.b
    public void b() {
        if (b.e()) {
            try {
                File file = new File(((Object) this.f47237j.f47199b.getExternalFilesDir(null)) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    d2 d2Var = new d2();
                    d2Var.d(this.f47231d);
                    this.f47230c = d2Var.c(this.f47237j.f47199b, this.f47232e, this.f47233f, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.r.b
    public void c() {
        File file = this.f47230c;
        if (file != null && file.exists()) {
            this.f47237j.f47198a.add(new e2.c(this.f47234g, this.f47235h, this.f47230c, this.f47236i));
        }
        this.f47237j.e(0L);
    }
}

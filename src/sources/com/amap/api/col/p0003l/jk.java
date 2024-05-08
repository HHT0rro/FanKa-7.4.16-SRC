package com.amap.api.col.p0003l;

import java.util.List;

/* compiled from: UploadBufferBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jk extends jh {

    /* renamed from: b, reason: collision with root package name */
    private static jk f6563b = new jk();

    private jk() {
        super(5120);
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static jk b() {
        return f6563b;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, List<? extends jo> list) {
        if (list == null) {
            return null;
        }
        try {
            int size = list.size();
            if (size <= 0 || bArr == null) {
                return null;
            }
            a();
            int a10 = jr.a((lc) this.f6561a, bArr);
            int[] iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                jo joVar = list.get(i10);
                iArr[i10] = jw.a(this.f6561a, (byte) joVar.a(), jw.a(this.f6561a, joVar.b()));
            }
            this.f6561a.c(jr.a(this.f6561a, a10, bArr2 != null ? jr.b(this.f6561a, bArr2) : 0, jr.a(this.f6561a, iArr)));
            return this.f6561a.c();
        } catch (Throwable th) {
            kv.a(th);
            return null;
        }
    }

    public final byte[] c() {
        super.a();
        try {
            this.f6561a.c(ku.a(this.f6561a, kt.a(), this.f6561a.a(kt.f()), this.f6561a.a(kt.c()), (byte) kt.m(), this.f6561a.a(kt.i()), this.f6561a.a(kt.h()), this.f6561a.a(a(kt.g())), this.f6561a.a(a(kt.j())), ks.a(kt.n()), this.f6561a.a(kt.l()), this.f6561a.a(kt.k()), this.f6561a.a(kt.d()), this.f6561a.a(kt.e())));
            return this.f6561a.c();
        } catch (Exception e2) {
            kv.a(e2);
            return null;
        }
    }
}

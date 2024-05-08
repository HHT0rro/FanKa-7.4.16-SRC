package ar.com.hjg.pngj;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: BufferedStreamFeeder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f1041a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f1042b;

    /* renamed from: c, reason: collision with root package name */
    public int f1043c;

    /* renamed from: d, reason: collision with root package name */
    public int f1044d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1045e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1046f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1047g;

    public a(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public void a() {
        this.f1045e = true;
        this.f1042b = null;
        this.f1043c = 0;
        this.f1044d = 0;
        InputStream inputStream = this.f1041a;
        if (inputStream != null && this.f1046f) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
        this.f1041a = null;
    }

    public int b(f fVar) {
        return c(fVar, Integer.MAX_VALUE);
    }

    public int c(f fVar, int i10) {
        if (this.f1043c == 0) {
            e();
        }
        if (i10 < 0 || i10 >= this.f1043c) {
            i10 = this.f1043c;
        }
        int i11 = 0;
        if (i10 > 0 && (i11 = fVar.a(this.f1042b, this.f1044d, i10)) > 0) {
            this.f1044d += i11;
            this.f1043c -= i11;
        }
        if (i11 >= 1 || !this.f1047g) {
            return i11;
        }
        throw new PngjInputException("Failed to feed bytes (premature ending?)");
    }

    public boolean d(f fVar, int i10) {
        while (i10 > 0) {
            int c4 = c(fVar, i10);
            if (c4 < 1) {
                return false;
            }
            i10 -= c4;
        }
        return true;
    }

    public void e() {
        if (this.f1043c > 0 || this.f1045e) {
            return;
        }
        try {
            this.f1044d = 0;
            int read = this.f1041a.read(this.f1042b);
            this.f1043c = read;
            if (read < 0) {
                a();
            }
        } catch (IOException e2) {
            throw new PngjInputException(e2);
        }
    }

    public void f(boolean z10) {
        this.f1046f = z10;
    }

    public void g(boolean z10) {
        this.f1047g = z10;
    }

    public a(InputStream inputStream, int i10) {
        this.f1045e = false;
        this.f1046f = true;
        this.f1047g = false;
        this.f1041a = inputStream;
        this.f1042b = new byte[i10 < 1 ? 8192 : i10];
    }
}

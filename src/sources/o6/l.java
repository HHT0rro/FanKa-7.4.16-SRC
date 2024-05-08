package o6;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import java.util.Arrays;

/* compiled from: DefaultAllocator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f52311a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52312b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final byte[] f52313c;

    /* renamed from: d, reason: collision with root package name */
    public final a[] f52314d;

    /* renamed from: e, reason: collision with root package name */
    public int f52315e;

    /* renamed from: f, reason: collision with root package name */
    public int f52316f;

    /* renamed from: g, reason: collision with root package name */
    public int f52317g;

    /* renamed from: h, reason: collision with root package name */
    public a[] f52318h;

    public l(boolean z10, int i10) {
        this(z10, i10, 0);
    }

    @Override // o6.b
    public synchronized void a() {
        int i10 = 0;
        int max = Math.max(0, j0.l(this.f52315e, this.f52312b) - this.f52316f);
        int i11 = this.f52317g;
        if (max >= i11) {
            return;
        }
        if (this.f52313c != null) {
            int i12 = i11 - 1;
            while (i10 <= i12) {
                a aVar = (a) com.google.android.exoplayer2.util.a.e(this.f52318h[i10]);
                if (aVar.f52287a == this.f52313c) {
                    i10++;
                } else {
                    a aVar2 = (a) com.google.android.exoplayer2.util.a.e(this.f52318h[i12]);
                    if (aVar2.f52287a != this.f52313c) {
                        i12--;
                    } else {
                        a[] aVarArr = this.f52318h;
                        aVarArr[i10] = aVar2;
                        aVarArr[i12] = aVar;
                        i12--;
                        i10++;
                    }
                }
            }
            max = Math.max(max, i10);
            if (max >= this.f52317g) {
                return;
            }
        }
        Arrays.fill(this.f52318h, max, this.f52317g, (Object) null);
        this.f52317g = max;
    }

    @Override // o6.b
    public synchronized void b(a[] aVarArr) {
        int i10 = this.f52317g;
        int length = aVarArr.length + i10;
        a[] aVarArr2 = this.f52318h;
        if (length >= aVarArr2.length) {
            this.f52318h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i10 + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            a[] aVarArr3 = this.f52318h;
            int i11 = this.f52317g;
            this.f52317g = i11 + 1;
            aVarArr3[i11] = aVar;
        }
        this.f52316f -= aVarArr.length;
        notifyAll();
    }

    @Override // o6.b
    public synchronized a c() {
        a aVar;
        this.f52316f++;
        int i10 = this.f52317g;
        if (i10 > 0) {
            a[] aVarArr = this.f52318h;
            int i11 = i10 - 1;
            this.f52317g = i11;
            aVar = (a) com.google.android.exoplayer2.util.a.e(aVarArr[i11]);
            this.f52318h[this.f52317g] = null;
        } else {
            aVar = new a(new byte[this.f52312b], 0);
        }
        return aVar;
    }

    @Override // o6.b
    public synchronized void d(a aVar) {
        a[] aVarArr = this.f52314d;
        aVarArr[0] = aVar;
        b(aVarArr);
    }

    @Override // o6.b
    public int e() {
        return this.f52312b;
    }

    public synchronized int f() {
        return this.f52316f * this.f52312b;
    }

    public synchronized void g() {
        if (this.f52311a) {
            h(0);
        }
    }

    public synchronized void h(int i10) {
        boolean z10 = i10 < this.f52315e;
        this.f52315e = i10;
        if (z10) {
            a();
        }
    }

    public l(boolean z10, int i10, int i11) {
        com.google.android.exoplayer2.util.a.a(i10 > 0);
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        this.f52311a = z10;
        this.f52312b = i10;
        this.f52317g = i11;
        this.f52318h = new a[i11 + 100];
        if (i11 > 0) {
            this.f52313c = new byte[i11 * i10];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f52318h[i12] = new a(this.f52313c, i12 * i10);
            }
        } else {
            this.f52313c = null;
        }
        this.f52314d = new a[1];
    }
}

package com.ss.android.socialbase.appdownloader.n.m;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class m implements w {

    /* renamed from: c, reason: collision with root package name */
    private int f38933c;
    private l dk;

    /* renamed from: e, reason: collision with root package name */
    private int f38934e;

    /* renamed from: hc, reason: collision with root package name */
    private boolean f38935hc;

    /* renamed from: l, reason: collision with root package name */
    private n f38936l;
    private int[] np;

    /* renamed from: oa, reason: collision with root package name */
    private int f38938oa;

    /* renamed from: q, reason: collision with root package name */
    private int f38939q;

    /* renamed from: r, reason: collision with root package name */
    private int f38940r;
    private int sy;
    private int[] ve;

    /* renamed from: w, reason: collision with root package name */
    private int f38941w;
    private boolean ej = false;

    /* renamed from: n, reason: collision with root package name */
    private C0590m f38937n = new C0590m();

    public m() {
        hc();
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x018c, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.n.m.m.e():void");
    }

    private final void hc() {
        this.f38934e = -1;
        this.f38941w = -1;
        this.f38938oa = -1;
        this.f38933c = -1;
        this.ve = null;
        this.sy = -1;
        this.f38940r = -1;
        this.f38939q = -1;
    }

    public int dk() throws e, IOException {
        if (this.dk != null) {
            try {
                e();
                return this.f38934e;
            } catch (IOException e2) {
                m();
                throw e2;
            }
        }
        throw new e("Parser is not opened.", this, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.n.m.hc
    public int ej() {
        return this.f38941w;
    }

    @Override // com.ss.android.socialbase.appdownloader.n.m.hc
    public String l() {
        return "XML line #" + ej();
    }

    public void m(InputStream inputStream) {
        m();
        if (inputStream != null) {
            this.dk = new l(inputStream, false);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.n.m.hc
    public int n() {
        return -1;
    }

    public int np() {
        if (this.f38934e != 2) {
            return -1;
        }
        return this.ve.length / 5;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.n.m.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0590m {
        private int dk;
        private int ej;

        /* renamed from: m, reason: collision with root package name */
        private int[] f38942m = new int[32];

        public final int dk() {
            int i10 = this.dk;
            if (i10 == 0) {
                return 0;
            }
            return this.f38942m[i10 - 1];
        }

        public final boolean ej() {
            int i10;
            int[] iArr;
            int i11;
            int i12 = this.dk;
            if (i12 == 0 || (i11 = (iArr = this.f38942m)[i12 - 1]) == 0) {
                return false;
            }
            int i13 = i11 - 1;
            int i14 = i10 - 2;
            iArr[i14] = i13;
            iArr[i14 - ((i13 * 2) + 1)] = i13;
            this.dk = i12 - 2;
            return true;
        }

        public final int l() {
            return this.ej;
        }

        public final void m() {
            this.dk = 0;
            this.ej = 0;
        }

        public final void n() {
            int i10 = this.dk;
            if (i10 != 0) {
                int i11 = i10 - 1;
                int i12 = this.f38942m[i11] * 2;
                if ((i11 - 1) - i12 != 0) {
                    this.dk = i10 - (i12 + 2);
                    this.ej--;
                }
            }
        }

        public final void np() {
            m(2);
            int i10 = this.dk;
            int[] iArr = this.f38942m;
            iArr[i10] = 0;
            iArr[i10 + 1] = 0;
            this.dk = i10 + 2;
            this.ej++;
        }

        public final void m(int i10, int i11) {
            if (this.ej == 0) {
                np();
            }
            m(2);
            int i12 = this.dk;
            int i13 = i12 - 1;
            int[] iArr = this.f38942m;
            int i14 = iArr[i13];
            int i15 = (i13 - 1) - (i14 * 2);
            int i16 = i14 + 1;
            iArr[i15] = i16;
            iArr[i13] = i10;
            iArr[i13 + 1] = i11;
            iArr[i13 + 2] = i16;
            this.dk = i12 + 2;
        }

        private void m(int i10) {
            int[] iArr = this.f38942m;
            int length = iArr.length;
            int i11 = this.dk;
            int i12 = length - i11;
            if (i12 <= i10) {
                int[] iArr2 = new int[(iArr.length + i12) * 2];
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i11);
                this.f38942m = iArr2;
            }
        }
    }

    private final int np(int i10) {
        if (this.f38934e == 2) {
            int i11 = i10 * 5;
            if (i11 < this.ve.length) {
                return i11;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i10 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public int ej(int i10) {
        return this.ve[np(i10) + 4];
    }

    public String l(int i10) {
        int np = np(i10);
        int[] iArr = this.ve;
        if (iArr[np + 3] == 3) {
            return this.f38936l.m(iArr[np + 2]);
        }
        int i11 = iArr[np + 4];
        return "";
    }

    public void m() {
        if (this.ej) {
            this.ej = false;
            this.dk.m();
            this.dk = null;
            this.f38936l = null;
            this.np = null;
            this.f38937n.m();
            hc();
        }
    }

    public int dk(int i10) {
        return this.ve[np(i10) + 3];
    }

    public String m(int i10) {
        int i11 = this.ve[np(i10) + 1];
        return i11 == -1 ? "" : this.f38936l.m(i11);
    }
}

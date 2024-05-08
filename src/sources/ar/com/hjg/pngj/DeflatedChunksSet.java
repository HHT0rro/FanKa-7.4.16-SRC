package ar.com.hjg.pngj;

import java.util.zip.Inflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DeflatedChunksSet {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f1027a;

    /* renamed from: b, reason: collision with root package name */
    public int f1028b;

    /* renamed from: c, reason: collision with root package name */
    public int f1029c;

    /* renamed from: d, reason: collision with root package name */
    public int f1030d;

    /* renamed from: e, reason: collision with root package name */
    public State f1031e;

    /* renamed from: f, reason: collision with root package name */
    public Inflater f1032f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1033g;

    /* renamed from: h, reason: collision with root package name */
    public d f1034h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1035i;

    /* renamed from: j, reason: collision with root package name */
    public long f1036j;

    /* renamed from: k, reason: collision with root package name */
    public long f1037k;

    /* renamed from: l, reason: collision with root package name */
    public int f1038l;

    /* renamed from: m, reason: collision with root package name */
    public int f1039m;

    /* renamed from: n, reason: collision with root package name */
    public final String f1040n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        WORK_DONE,
        TERMINATED;

        public boolean isDone() {
            return this == WORK_DONE || this == TERMINATED;
        }

        public boolean isTerminated() {
            return this == TERMINATED;
        }
    }

    public DeflatedChunksSet(String str, int i10, int i11, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.f1031e = state;
        this.f1035i = true;
        this.f1036j = 0L;
        this.f1037k = 0L;
        this.f1038l = -1;
        this.f1039m = -1;
        this.f1040n = str;
        this.f1029c = i10;
        if (i10 >= 1 && i11 >= i10) {
            if (inflater != null) {
                this.f1032f = inflater;
                this.f1033g = false;
            } else {
                this.f1032f = new Inflater();
                this.f1033g = true;
            }
            this.f1027a = (bArr == null || bArr.length < i10) ? new byte[i11] : bArr;
            this.f1030d = -1;
            this.f1031e = state;
            try {
                l(i10);
                return;
            } catch (RuntimeException e2) {
                d();
                throw e2;
            }
        }
        throw new PngjException("bad inital row len " + i10);
    }

    public boolean a(String str) {
        if (this.f1031e.isTerminated()) {
            return false;
        }
        if (str.equals(this.f1040n) || b(str)) {
            return true;
        }
        if (this.f1031e.isDone()) {
            if (!j()) {
                q();
            }
            return false;
        }
        throw new PngjInputException("Unexpected chunk " + str + " while " + this.f1040n + " set is not done");
    }

    public boolean b(String str) {
        return false;
    }

    public void c(d dVar) {
        if (this.f1040n.equals(dVar.c().f1494c)) {
            this.f1034h = dVar;
            int i10 = this.f1038l + 1;
            this.f1038l = i10;
            int i11 = this.f1039m;
            if (i11 >= 0) {
                dVar.g(i10 + i11);
                return;
            }
            return;
        }
        throw new PngjInputException("Bad chunk inside IdatSet, id:" + dVar.c().f1494c + ", expected:" + this.f1040n);
    }

    public void d() {
        Inflater inflater;
        try {
            if (!this.f1031e.isTerminated()) {
                this.f1031e = State.TERMINATED;
            }
            if (!this.f1033g || (inflater = this.f1032f) == null) {
                return;
            }
            inflater.end();
            this.f1032f = null;
        } catch (Exception unused) {
        }
    }

    public void e() {
        if (i()) {
            return;
        }
        this.f1031e = State.WORK_DONE;
    }

    public int f() {
        return this.f1030d;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b A[Catch: RuntimeException -> 0x0079, TryCatch #1 {RuntimeException -> 0x0079, blocks: (B:2:0x0000, B:4:0x0006, B:8:0x000e, B:10:0x0012, B:12:0x001d, B:14:0x0023, B:17:0x002b, B:18:0x0038, B:21:0x0045, B:22:0x004c, B:23:0x004d, B:26:0x0067, B:28:0x006b, B:31:0x0055, B:33:0x005d, B:34:0x0060, B:37:0x0065, B:38:0x0017, B:39:0x0071, B:40:0x0078), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g() {
        /*
            r7 = this;
            ar.com.hjg.pngj.DeflatedChunksSet$State r0 = r7.f1031e     // Catch: java.lang.RuntimeException -> L79
            ar.com.hjg.pngj.DeflatedChunksSet$State r1 = ar.com.hjg.pngj.DeflatedChunksSet.State.ROW_READY     // Catch: java.lang.RuntimeException -> L79
            if (r0 == r1) goto L71
            boolean r0 = r0.isDone()     // Catch: java.lang.RuntimeException -> L79
            r2 = 0
            if (r0 == 0) goto Le
            return r2
        Le:
            byte[] r0 = r7.f1027a     // Catch: java.lang.RuntimeException -> L79
            if (r0 == 0) goto L17
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L79
            int r3 = r7.f1029c     // Catch: java.lang.RuntimeException -> L79
            if (r0 >= r3) goto L1d
        L17:
            int r0 = r7.f1029c     // Catch: java.lang.RuntimeException -> L79
            byte[] r0 = new byte[r0]     // Catch: java.lang.RuntimeException -> L79
            r7.f1027a = r0     // Catch: java.lang.RuntimeException -> L79
        L1d:
            int r0 = r7.f1028b     // Catch: java.lang.RuntimeException -> L79
            int r3 = r7.f1029c     // Catch: java.lang.RuntimeException -> L79
            if (r0 >= r3) goto L4d
            java.util.zip.Inflater r0 = r7.f1032f     // Catch: java.lang.RuntimeException -> L79
            boolean r0 = r0.finished()     // Catch: java.lang.RuntimeException -> L79
            if (r0 != 0) goto L4d
            java.util.zip.Inflater r0 = r7.f1032f     // Catch: java.util.zip.DataFormatException -> L44 java.lang.RuntimeException -> L79
            byte[] r3 = r7.f1027a     // Catch: java.util.zip.DataFormatException -> L44 java.lang.RuntimeException -> L79
            int r4 = r7.f1028b     // Catch: java.util.zip.DataFormatException -> L44 java.lang.RuntimeException -> L79
            int r5 = r7.f1029c     // Catch: java.util.zip.DataFormatException -> L44 java.lang.RuntimeException -> L79
            int r5 = r5 - r4
            int r0 = r0.inflate(r3, r4, r5)     // Catch: java.util.zip.DataFormatException -> L44 java.lang.RuntimeException -> L79
            int r3 = r7.f1028b     // Catch: java.lang.RuntimeException -> L79
            int r3 = r3 + r0
            r7.f1028b = r3     // Catch: java.lang.RuntimeException -> L79
            long r3 = r7.f1037k     // Catch: java.lang.RuntimeException -> L79
            long r5 = (long) r0     // Catch: java.lang.RuntimeException -> L79
            long r3 = r3 + r5
            r7.f1037k = r3     // Catch: java.lang.RuntimeException -> L79
            goto L4d
        L44:
            r0 = move-exception
            ar.com.hjg.pngj.PngjInputException r1 = new ar.com.hjg.pngj.PngjInputException     // Catch: java.lang.RuntimeException -> L79
            java.lang.String r2 = "error decompressing zlib stream "
            r1.<init>(r2, r0)     // Catch: java.lang.RuntimeException -> L79
            throw r1     // Catch: java.lang.RuntimeException -> L79
        L4d:
            int r0 = r7.f1028b     // Catch: java.lang.RuntimeException -> L79
            int r3 = r7.f1029c     // Catch: java.lang.RuntimeException -> L79
            if (r0 != r3) goto L55
        L53:
            r0 = r1
            goto L67
        L55:
            java.util.zip.Inflater r0 = r7.f1032f     // Catch: java.lang.RuntimeException -> L79
            boolean r0 = r0.finished()     // Catch: java.lang.RuntimeException -> L79
            if (r0 != 0) goto L60
            ar.com.hjg.pngj.DeflatedChunksSet$State r0 = ar.com.hjg.pngj.DeflatedChunksSet.State.WAITING_FOR_INPUT     // Catch: java.lang.RuntimeException -> L79
            goto L67
        L60:
            int r0 = r7.f1028b     // Catch: java.lang.RuntimeException -> L79
            if (r0 <= 0) goto L65
            goto L53
        L65:
            ar.com.hjg.pngj.DeflatedChunksSet$State r0 = ar.com.hjg.pngj.DeflatedChunksSet.State.WORK_DONE     // Catch: java.lang.RuntimeException -> L79
        L67:
            r7.f1031e = r0     // Catch: java.lang.RuntimeException -> L79
            if (r0 != r1) goto L70
            r7.k()     // Catch: java.lang.RuntimeException -> L79
            r0 = 1
            return r0
        L70:
            return r2
        L71:
            ar.com.hjg.pngj.PngjException r0 = new ar.com.hjg.pngj.PngjException     // Catch: java.lang.RuntimeException -> L79
            java.lang.String r1 = "invalid state"
            r0.<init>(r1)     // Catch: java.lang.RuntimeException -> L79
            throw r0     // Catch: java.lang.RuntimeException -> L79
        L79:
            r0 = move-exception
            r7.d()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ar.com.hjg.pngj.DeflatedChunksSet.g():boolean");
    }

    public boolean h() {
        return this.f1035i;
    }

    public boolean i() {
        return this.f1031e.isDone();
    }

    public boolean j() {
        return this.f1031e.isTerminated();
    }

    public void k() {
    }

    public void l(int i10) {
        this.f1028b = 0;
        this.f1030d++;
        if (i10 < 1) {
            this.f1029c = 0;
            e();
        } else {
            if (this.f1032f.finished()) {
                this.f1029c = 0;
                e();
                return;
            }
            this.f1031e = State.WAITING_FOR_INPUT;
            this.f1029c = i10;
            if (this.f1035i) {
                return;
            }
            g();
        }
    }

    public void m(byte[] bArr, int i10, int i11) {
        this.f1036j += i11;
        if (i11 < 1 || this.f1031e.isDone()) {
            return;
        }
        if (this.f1031e != State.ROW_READY) {
            if (!this.f1032f.needsDictionary() && this.f1032f.needsInput()) {
                this.f1032f.setInput(bArr, i10, i11);
                if (h()) {
                    while (g()) {
                        l(o());
                        if (i()) {
                            n();
                        }
                    }
                    return;
                }
                g();
                return;
            }
            throw new RuntimeException("should not happen");
        }
        throw new PngjInputException("this should only be called if waitingForMoreInput");
    }

    public void n() {
    }

    public int o() {
        throw null;
    }

    public void p(boolean z10) {
        this.f1035i = z10;
    }

    public void q() {
        d();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.f1034h.c().f1494c + " state=" + ((Object) this.f1031e) + " rows=" + this.f1030d + " bytes=" + this.f1036j + "/" + this.f1037k).toString();
    }
}

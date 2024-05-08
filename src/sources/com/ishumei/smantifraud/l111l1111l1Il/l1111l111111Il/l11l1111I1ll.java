package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I1ll extends Exception {
    private static int l111l11111I1l = -2;
    private static int l111l11111Il = -3;
    private static int l111l11111lIl = -1;
    private static int l111l1111l1Il = -4;
    private static String l111l1111llIl = "body is null";
    public final int l1111l111111Il;
    private l111l1111llIl l111l1111lI1l;

    public l11l1111I1ll(int i10) {
        this.l1111l111111Il = i10;
        this.l111l1111lI1l = null;
    }

    private l11l1111I1ll(l111l1111llIl l111l1111llil, int i10) {
        this.l1111l111111Il = i10;
        this.l111l1111lI1l = l111l1111llil;
    }

    public l11l1111I1ll(String str, int i10) {
        super(str);
        this.l1111l111111Il = i10;
        this.l111l1111lI1l = null;
    }

    private l11l1111I1ll(String str, Throwable th, int i10) {
        super(str, th);
        this.l1111l111111Il = i10;
        this.l111l1111lI1l = null;
    }

    public l11l1111I1ll(Throwable th, int i10) {
        super(th);
        this.l1111l111111Il = i10;
        this.l111l1111lI1l = null;
    }
}

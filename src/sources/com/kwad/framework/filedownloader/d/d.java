package com.kwad.framework.filedownloader.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static boolean bF(int i10) {
        return i10 < 0;
    }

    public static boolean bG(int i10) {
        return i10 > 0;
    }

    public static boolean f(com.kwad.framework.filedownloader.a aVar) {
        return aVar.tV() == 0 || aVar.tV() == 3;
    }

    public static boolean t(int i10, int i11) {
        if ((i10 != 3 && i10 != 5 && i10 == i11) || bF(i10)) {
            return false;
        }
        if (i10 > 0 && i10 <= 6 && i11 >= 10 && i11 <= 11) {
            return false;
        }
        if (i10 == 1) {
            return i11 != 0;
        }
        if (i10 == 2) {
            return (i11 == 0 || i11 == 1 || i11 == 6) ? false : true;
        }
        if (i10 == 3) {
            return (i11 == 0 || i11 == 1 || i11 == 2 || i11 == 6) ? false : true;
        }
        if (i10 == 5) {
            return (i11 == 1 || i11 == 6) ? false : true;
        }
        if (i10 != 6) {
            return true;
        }
        return (i11 == 0 || i11 == 1) ? false : true;
    }

    public static boolean u(int i10, int i11) {
        if ((i10 != 3 && i10 != 5 && i10 == i11) || bF(i10)) {
            return false;
        }
        if (i11 == -2 || i11 == -1) {
            return true;
        }
        if (i10 == 0) {
            return i11 == 10;
        }
        if (i10 == 1) {
            return i11 == 6;
        }
        if (i10 == 2 || i10 == 3) {
            return i11 == -3 || i11 == 3 || i11 == 5;
        }
        if (i10 == 5 || i10 == 6) {
            return i11 == 2 || i11 == 5;
        }
        if (i10 == 10) {
            return i11 == 11;
        }
        if (i10 != 11) {
            return false;
        }
        return i11 == -4 || i11 == -3 || i11 == 1;
    }
}

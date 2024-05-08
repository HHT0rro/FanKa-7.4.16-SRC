package com.ishumei.smantifraud;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l1111l111111Il {
    private static boolean l1111l111111Il = false;
    private static String l111l11111I1l = "release";
    private static String l111l11111Il = "";
    private static String l111l11111lIl = "com.ishumei.smantifraud";
    private static int l111l1111l1Il = -1;
    private static boolean l111l1111lI1l = false;
    private static String l111l1111llIl = "";
    private final String l111l1111lIl;
    private final String l11l1111lIIl;

    public l1111l111111Il() {
    }

    public l1111l111111Il(String str, String str2) {
        this.l111l1111lIl = str;
        this.l11l1111lIIl = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            l1111l111111Il l1111l111111il = (l1111l111111Il) obj;
            if (TextUtils.equals(this.l111l1111lIl, l1111l111111il.l111l1111lIl) && TextUtils.equals(this.l11l1111lIIl, l1111l111111il.l11l1111lIIl)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.l111l1111lIl.hashCode() * 31) + this.l11l1111lIIl.hashCode();
    }

    public String l1111l111111Il() {
        return this.l111l1111lIl;
    }

    public String l111l11111lIl() {
        return this.l11l1111lIIl;
    }

    public String toString() {
        return "Header[name=" + this.l111l1111lIl + ",value=" + this.l11l1111lIIl + "]";
    }
}

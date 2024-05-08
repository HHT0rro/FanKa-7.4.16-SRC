package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l11111I1l {
    private final String l1111l111111Il;
    private final String l111l11111lIl;

    public l111l11111I1l(String str, String str2) {
        this.l1111l111111Il = str;
        this.l111l11111lIl = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l111l11111I1l.class == obj.getClass()) {
            l111l11111I1l l111l11111i1l = (l111l11111I1l) obj;
            if (TextUtils.equals(this.l1111l111111Il, l111l11111i1l.l1111l111111Il) && TextUtils.equals(this.l111l11111lIl, l111l11111i1l.l111l11111lIl)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.l1111l111111Il.hashCode() * 31) + this.l111l11111lIl.hashCode();
    }

    public final String l1111l111111Il() {
        return this.l1111l111111Il;
    }

    public final String l111l11111lIl() {
        return this.l111l11111lIl;
    }

    public final String toString() {
        return "Header[name=" + this.l1111l111111Il + ",value=" + this.l111l11111lIl + "]";
    }
}

package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il;

import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111Il;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;
import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l111l1111llIl<T> extends com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<T> {
    private static final String l111l11111I1l = String.format("application/json; charset=%s", "utf-8");
    private static String l111l11111lIl = "utf-8";
    public String l1111l111111Il;
    private final Object l111l11111Il;
    private l11l1111lIIl.l111l11111lIl<T> l111l1111l1Il;

    public l111l1111llIl(int i10, String str, String str2, String str3, l11l1111lIIl.l111l11111lIl<T> l111l11111lil, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        super(i10, str, str2, l1111l111111il);
        this.l111l11111Il = new Object();
        this.l111l1111l1Il = l111l11111lil;
        this.l1111l111111Il = str3;
    }

    @Deprecated
    private l111l1111llIl(String str, String str2, String str3, l11l1111lIIl.l111l11111lIl<T> l111l11111lil, l11l1111lIIl.l1111l111111Il l1111l111111il) {
        this(-1, str, str2, str3, l111l11111lil, l1111l111111il);
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public abstract com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl<T> l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111llIl l111l1111llil);

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public final void l1111l111111Il(T t2) {
        l11l1111lIIl.l111l11111lIl<T> l111l11111lil;
        synchronized (this.l111l11111Il) {
            l111l11111lil = this.l111l1111l1Il;
        }
        if (l111l11111lil != null) {
            l111l11111lil.l1111l111111Il(t2);
        }
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public byte[] l1111l111111Il() {
        try {
            String str = this.l1111l111111Il;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            l11l1111Il.l111l11111Il("Unsupported Encoding while trying to get the bytes of %s using %s", this.l1111l111111Il, "utf-8");
            return null;
        }
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    @Deprecated
    public final String l11l1111I1l() {
        return l111l11111I1l;
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    @Deprecated
    public final byte[] l11l1111I1ll() {
        return l1111l111111Il();
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public final String l11l1111Il() {
        return l111l11111I1l;
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
    public final void l11l1111lIIl() {
        super.l11l1111lIIl();
        synchronized (this.l111l11111Il) {
            this.l111l1111l1Il = null;
        }
    }
}

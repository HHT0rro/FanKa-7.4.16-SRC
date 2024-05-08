package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l11l1111lIIl<T> {
    private static final String l111l11111Il = "volley";
    public final T l1111l111111Il;
    public boolean l111l11111I1l;
    public final l11l1111I1ll l111l11111lIl;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface l1111l111111Il {
        void l1111l111111Il(l11l1111I1ll l11l1111i1ll);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface l111l11111lIl<T> {
        void l1111l111111Il(T t2);
    }

    public l11l1111lIIl() {
    }

    private l11l1111lIIl(l11l1111I1ll l11l1111i1ll) {
        this.l111l11111I1l = false;
        this.l1111l111111Il = null;
        this.l111l11111lIl = l11l1111i1ll;
    }

    private l11l1111lIIl(T t2) {
        this.l111l11111I1l = false;
        this.l1111l111111Il = t2;
        this.l111l11111lIl = null;
    }

    private static l111l1111lIl l1111l111111Il(l111l11111Il l111l11111il) {
        return new l111l1111lIl(l111l11111il);
    }

    public static <T> l11l1111lIIl<T> l1111l111111Il(l11l1111I1ll l11l1111i1ll) {
        return new l11l1111lIIl<>(l11l1111i1ll);
    }

    public static <T> l11l1111lIIl<T> l1111l111111Il(T t2) {
        return new l11l1111lIIl<>(t2);
    }

    public static l111l1111lIl l111l11111lIl() {
        return new l111l1111lIl(new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l11111lIl(new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111l1Il()));
    }

    public final boolean l1111l111111Il() {
        return this.l111l11111lIl == null;
    }
}

package com.ishumei.smantifraud.l1111l111111Il;

import com.ishumei.smantifraud.SmAntiFraud;
import com.ishumei.smantifraud.l1111l111111Il.l11l1111Il;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l1111lIl implements l11l1111lIIl.l111l11111lIl<com.ishumei.smantifraud.l111l11111Il.l111l11111Il> {
    private static final String l1111l111111Il = "Smlog";
    private static l111l1111lIl l111l11111lIl;
    private String l111l11111I1l;

    /* renamed from: com.ishumei.smantifraud.l1111l111111Il.l111l1111lIl$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass3 extends com.ishumei.smantifraud.l111l11111Il.l111l1111llIl<Object> {
        public AnonymousClass3(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
        public final com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl<Object> l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111llIl l111l1111llil) {
            return com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l1111l111111Il(new Object());
        }
    }

    private l111l1111lIl() {
    }

    public static synchronized l111l1111lIl l1111l111111Il() {
        l111l1111lIl l111l1111lil;
        synchronized (l111l1111lIl.class) {
            if (l111l11111lIl == null) {
                l111l11111lIl = new l111l1111lIl();
            }
            l111l1111lil = l111l11111lIl;
        }
        return l111l1111lil;
    }

    public static /* synthetic */ String l1111l111111Il(l111l1111lIl l111l1111lil) {
        l111l11111Il l111l11111lIl2 = l111l1111l1Il.l1111l111111Il().l111l11111lIl();
        boolean z10 = l111l11111lIl2 == null || l111l11111lIl2.l111l1111l1Il();
        return l1111l111111Il.l1111l111111Il().l1111l111111Il((SmAntiFraud.option.l111l1111lI1l() ? 1 : 0) | (z10 ? 2 : 0));
    }

    public static /* synthetic */ void l1111l111111Il(l111l1111lIl l111l1111lil, com.ishumei.smantifraud.l111l11111Il.l111l11111Il l111l11111il) {
        com.ishumei.smantifraud.l111l11111lIl.l111l11111Il.l1111l111111Il().l1111l111111Il(l111l11111il.l1111l111111Il, l111l11111il.l111l11111lIl);
        com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l1111l111111Il(l111l11111il.l111l11111lIl(), true);
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l111l11111lIl();
    }

    public static /* synthetic */ void l1111l111111Il(l111l1111lIl l111l1111lil, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll l11l1111i1ll, String str) {
        int i10 = l11l1111i1ll.l1111l111111Il;
        if (i10 != 1902) {
            l11l11IlIIll.l1111l111111Il(str, l111l1111lil.l111l11111I1l, l111l1111l1Il.l1111l111111Il().l111l11111lIl());
        }
        if (i10 > 0) {
            i10 = -3;
        }
        if (SmAntiFraud.getServerIdCallback() != null) {
            SmAntiFraud.getServerIdCallback().onError(i10);
        }
        l111l1111lil.l111l11111I1l = null;
    }

    public static /* synthetic */ void l1111l111111Il(l111l1111lIl l111l1111lil, Throwable th) {
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l1111l111111Il(new AnonymousClass3(SmAntiFraud.option.l11l1111Il(), SmAntiFraud.option.l11l1111Il1l(), l11l1111Il.l1111l111111Il.l1111l111111Il.l1111l111111Il(th)));
    }

    private void l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll l11l1111i1ll, String str) {
        int i10 = l11l1111i1ll.l1111l111111Il;
        if (i10 != 1902) {
            l11l11IlIIll.l1111l111111Il(str, this.l111l11111I1l, l111l1111l1Il.l1111l111111Il().l111l11111lIl());
        }
        if (i10 > 0) {
            i10 = -3;
        }
        if (SmAntiFraud.getServerIdCallback() != null) {
            SmAntiFraud.getServerIdCallback().onError(i10);
        }
        this.l111l11111I1l = null;
    }

    private void l1111l111111Il(Throwable th) {
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l1111l111111Il(new AnonymousClass3(SmAntiFraud.option.l11l1111Il(), SmAntiFraud.option.l11l1111Il1l(), l11l1111Il.l1111l111111Il.l1111l111111Il.l1111l111111Il(th)));
    }

    private static String l111l11111lIl() {
        l111l11111Il l111l11111lIl2 = l111l1111l1Il.l1111l111111Il().l111l11111lIl();
        boolean z10 = l111l11111lIl2 == null || l111l11111lIl2.l111l1111l1Il();
        return l1111l111111Il.l1111l111111Il().l1111l111111Il((SmAntiFraud.option.l111l1111lI1l() ? 1 : 0) | (z10 ? 2 : 0));
    }

    private static void l111l11111lIl(com.ishumei.smantifraud.l111l11111Il.l111l11111Il l111l11111il) {
        com.ishumei.smantifraud.l111l11111lIl.l111l11111Il.l1111l111111Il().l1111l111111Il(l111l11111il.l1111l111111Il, l111l11111il.l111l11111lIl);
        com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l1111l111111Il(l111l11111il.l111l11111lIl(), true);
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l111l11111lIl();
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l111l11111lIl
    public void l1111l111111Il(com.ishumei.smantifraud.l111l11111Il.l111l11111Il l111l11111il) {
        com.ishumei.smantifraud.l111l11111lIl.l111l11111Il.l1111l111111Il().l1111l111111Il(l111l11111il.l1111l111111Il, l111l11111il.l111l11111lIl);
        com.ishumei.smantifraud.l111l11111lIl.l1111l111111Il.l111l11111Il.l1111l111111Il().l1111l111111Il(l111l11111il.l111l11111lIl(), true);
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l111l11111lIl();
    }

    public final void l1111l111111Il(String str, final String str2) {
        com.ishumei.smantifraud.l111l11111Il.l111l11111I1l l111l11111i1l = new com.ishumei.smantifraud.l111l11111Il.l111l11111I1l(str, str2, this, new l11l1111lIIl.l1111l111111Il() { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l1111lIl.1
            @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl.l1111l111111Il
            public final void l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1ll l11l1111i1ll) {
                l111l1111lIl.l1111l111111Il(l111l1111lIl.this, l11l1111i1ll, str2);
            }
        }) { // from class: com.ishumei.smantifraud.l1111l111111Il.l111l1111lIl.2
            @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il.l111l1111llIl, com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l
            public final byte[] l1111l111111Il() {
                try {
                    if (this.l1111l111111Il == null) {
                        String l1111l111111Il2 = l111l1111lIl.l1111l111111Il(l111l1111lIl.this);
                        this.l1111l111111Il = l1111l111111Il2;
                        l111l1111lIl.this.l111l11111I1l = l1111l111111Il2;
                    }
                } catch (Throwable th) {
                    this.l1111l111111Il = null;
                    l111l1111lIl.l1111l111111Il(l111l1111lIl.this, th);
                }
                return super.l1111l111111Il();
            }
        };
        l111l11111i1l.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l) new com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l1111l111111Il(30000, 0, 0.0f));
        com.ishumei.smantifraud.l111l11111Il.l111l1111l1Il.l1111l111111Il().l1111l111111Il(l111l11111i1l);
    }
}

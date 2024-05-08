package com.kwad.library.solder.lib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c aiX;
    private final com.kwad.library.solder.lib.a.c aiZ;
    private final com.kwad.library.solder.lib.a.f aja;
    private final com.kwad.library.solder.lib.a.b ajb;
    private final com.kwad.library.solder.lib.ext.a ajc;
    private Map<String, b> ajd;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a {
        public final com.kwad.library.solder.lib.a.d ajh;

        /* renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0506a extends a {
            public C0506a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.ajh.wZ().g(eVar);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class b extends a {
            public b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.ajh.xa().k(eVar);
            }
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.ajh = dVar;
        }

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i10) {
            if (i10 != 1) {
                return new C0506a(dVar);
            }
            return new b(dVar);
        }

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {
        private final com.kwad.library.solder.lib.a.e aji;
        private final Future<com.kwad.library.solder.lib.a.e> ajj;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.aji = eVar;
            this.ajj = future;
        }

        public final void cancel() {
            this.aji.cancel();
            this.ajj.cancel(true);
        }
    }

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.aiZ = cVar;
        this.aja = fVar;
        this.ajb = bVar;
        this.aiX = cVar2;
        this.ajc = aVar;
    }

    private b b(@NonNull final com.kwad.library.solder.lib.a.e eVar, @NonNull final a aVar) {
        b bH = bH(eVar.xp());
        if (bH != null) {
            bH.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.aiX.xI().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: xd, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.xp(), bVar);
        return bVar;
    }

    @Nullable
    private synchronized b bH(String str) {
        Map<String, b> c4 = c(this.ajd);
        this.ajd = c4;
        if (str == null) {
            return null;
        }
        return c4.get(str);
    }

    private static Map<String, b> c(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    public final com.kwad.library.solder.lib.a.e a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull a aVar) {
        if (eVar.xl() == null) {
            eVar.a(this);
        }
        eVar.xp();
        eVar.xm();
        aVar.j(eVar);
        return eVar;
    }

    public final void i(@NonNull com.kwad.library.solder.lib.a.e eVar) {
        b bH = bH(eVar.xp());
        if (bH != null) {
            bH.cancel();
        }
        a(eVar.xp(), (b) null);
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c wY() {
        return this.aiX;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c wZ() {
        return this.aiZ;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f xa() {
        return this.aja;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b xb() {
        return this.ajb;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a xc() {
        return this.ajc;
    }

    public final b a(@NonNull com.kwad.library.solder.lib.a.e eVar, @NonNull int i10) {
        return b(eVar, a.a(this, 16));
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> c4 = c(this.ajd);
        this.ajd = c4;
        if (str != null) {
            c4.put(str, bVar);
        }
    }
}

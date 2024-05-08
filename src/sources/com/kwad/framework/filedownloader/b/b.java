package com.kwad.framework.filedownloader.b;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.kwad.framework.filedownloader.b.a {
    public final SparseArray<com.kwad.framework.filedownloader.d.c> afn = new SparseArray<>();
    public final SparseArray<List<com.kwad.framework.filedownloader.d.a>> afo = new SparseArray<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements a.InterfaceC0495a {
        public a() {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0495a
        public final void a(int i10, com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0495a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator2() {
            return new C0496b();
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0495a
        public final void vg() {
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.b.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class C0496b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        public C0496b() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwad.framework.filedownloader.d.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        synchronized (this.afn) {
            this.afn.put(cVar.getId(), cVar);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, long j10, String str, String str2) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, String str, long j10, long j11, int i11) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, Throwable th, long j10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            int id2 = aVar.getId();
            synchronized (this.afo) {
                list = this.afo.get(id2);
                if (list == null) {
                    list = new ArrayList<>();
                    this.afo.put(id2, list);
                }
            }
            list.add(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i10, long j10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bk(cVar.getId()) != null) {
            synchronized (this.afn) {
                this.afn.remove(cVar.getId());
                this.afn.put(cVar.getId(), cVar);
            }
            return;
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bj(int i10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bk(int i10) {
        com.kwad.framework.filedownloader.d.c cVar;
        synchronized (this.afn) {
            cVar = this.afn.get(i10);
        }
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bl(int i10) {
        List<com.kwad.framework.filedownloader.d.a> list;
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (this.afo) {
                list = this.afo.get(i10);
            }
            if (list != null) {
                arrayList.addAll(list);
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bm(int i10) {
        try {
            synchronized (this.afo) {
                this.afo.remove(i10);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bn(int i10) {
        synchronized (this.afn) {
            this.afn.remove(i10);
        }
        return true;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bo(int i10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i10, long j10) {
        bn(i10);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        synchronized (this.afn) {
            this.afn.clear();
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i10, long j10) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void s(int i10, int i11) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0495a vf() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i10, int i11, long j10) {
        List<com.kwad.framework.filedownloader.d.a> list;
        synchronized (this.afo) {
            list = this.afo.get(i10);
        }
        if (list == null) {
            return;
        }
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.getIndex() == i11) {
                aVar.Q(j10);
                return;
            }
        }
    }
}

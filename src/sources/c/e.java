package c;

import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.p;
import ar.com.hjg.pngj.chunks.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChunksList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public final ar.com.hjg.pngj.k f1500b;

    /* renamed from: a, reason: collision with root package name */
    public List<PngChunk> f1499a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f1501c = false;

    /* compiled from: ChunksList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1502a;

        public a(String str) {
            this.f1502a = str;
        }

        @Override // c.c
        public boolean a(PngChunk pngChunk) {
            return pngChunk.f1076a.equals(this.f1502a);
        }
    }

    /* compiled from: ChunksList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1503a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1504b;

        public b(String str, String str2) {
            this.f1503a = str;
            this.f1504b = str2;
        }

        @Override // c.c
        public boolean a(PngChunk pngChunk) {
            if (!pngChunk.f1076a.equals(this.f1503a)) {
                return false;
            }
            if (!(pngChunk instanceof u) || ((u) pngChunk).h().equals(this.f1504b)) {
                return !(pngChunk instanceof p) || ((p) pngChunk).h().equals(this.f1504b);
            }
            return false;
        }
    }

    public e(ar.com.hjg.pngj.k kVar) {
        this.f1500b = kVar;
    }

    public static List<PngChunk> g(List<PngChunk> list, String str, String str2) {
        if (str2 == null) {
            return c.b.b(list, new a(str));
        }
        return c.b.b(list, new b(str, str2));
    }

    public void a(PngChunk pngChunk, int i10) {
        pngChunk.f(i10);
        this.f1499a.add(pngChunk);
        if (pngChunk.f1076a.equals("PLTE")) {
            this.f1501c = true;
        }
    }

    public List<? extends PngChunk> b(String str, String str2) {
        return g(this.f1499a, str, str2);
    }

    public PngChunk c(String str) {
        return e(str, false);
    }

    public PngChunk d(String str, String str2, boolean z10) {
        List<? extends PngChunk> b4 = b(str, str2);
        if (b4.isEmpty()) {
            return null;
        }
        if (b4.size() > 1 && (z10 || !b4.get(0).a())) {
            throw new PngjException("unexpected multiple chunks id=" + str);
        }
        return b4.get(b4.size() - 1);
    }

    public PngChunk e(String str, boolean z10) {
        return d(str, null, z10);
    }

    public List<PngChunk> f() {
        return this.f1499a;
    }

    public String toString() {
        return "ChunkList: read: " + this.f1499a.size();
    }
}

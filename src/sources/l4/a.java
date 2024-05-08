package l4;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.j;
import ar.com.hjg.pngj.k;
import ar.com.hjg.pngj.o;
import ar.com.hjg.pngj.p;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;

/* compiled from: ApngExtractFrames.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* compiled from: ApngExtractFrames.java */
    /* renamed from: l4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class C0784a extends p {

        /* renamed from: h, reason: collision with root package name */
        public File f51602h;

        /* renamed from: i, reason: collision with root package name */
        public FileOutputStream f51603i;

        /* renamed from: j, reason: collision with root package name */
        public File f51604j;

        /* renamed from: k, reason: collision with root package name */
        public k f51605k;

        /* renamed from: l, reason: collision with root package name */
        public int f51606l;

        /* compiled from: ApngExtractFrames.java */
        /* renamed from: l4.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class C0785a extends ar.com.hjg.pngj.c {
            public C0785a(boolean z10) {
                super(z10);
            }

            @Override // ar.com.hjg.pngj.b
            public boolean k(String str) {
                return false;
            }

            @Override // ar.com.hjg.pngj.c, ar.com.hjg.pngj.b
            public void l(ChunkReader chunkReader) {
                super.l(chunkReader);
                try {
                    String str = chunkReader.c().f1494c;
                    PngChunk pngChunk = this.f1064o.f().get(this.f1064o.f().size() - 1);
                    if (str.equals("fcTL")) {
                        C0784a c0784a = C0784a.this;
                        c0784a.f51606l++;
                        c0784a.f51605k = ((ar.com.hjg.pngj.chunks.d) pngChunk).l();
                        C0784a.this.q();
                    }
                    if (str.equals("fdAT") || str.equals("IDAT")) {
                        if (str.equals("IDAT")) {
                            if (C0784a.this.f51603i != null) {
                                chunkReader.c().h(C0784a.this.f51603i);
                            }
                        } else {
                            c.d dVar = new c.d(chunkReader.c().f1492a - 4, c.b.f1489c, true);
                            byte[] bArr = chunkReader.c().f1495d;
                            byte[] bArr2 = dVar.f1495d;
                            System.arraycopy((Object) bArr, 4, (Object) bArr2, 0, bArr2.length);
                            dVar.h(C0784a.this.f51603i);
                        }
                        chunkReader.c().f1495d = null;
                    }
                    if (str.equals("IEND")) {
                        C0784a c0784a2 = C0784a.this;
                        if (c0784a2.f51603i != null) {
                            c0784a2.p();
                        }
                    }
                } catch (Exception e2) {
                    throw new PngjException(e2);
                }
            }

            @Override // ar.com.hjg.pngj.c, ar.com.hjg.pngj.b
            public boolean n(int i10, String str) {
                return false;
            }
        }

        public C0784a(File file) {
            super(file);
            this.f51603i = null;
            this.f51606l = -1;
            this.f51602h = file;
        }

        @Override // ar.com.hjg.pngj.p
        public ar.com.hjg.pngj.c b() {
            return new C0785a(false);
        }

        public final File o() {
            return new File(this.f51602h.getParent(), a.a(this.f51602h, this.f51606l));
        }

        public final void p() throws IOException {
            new j(null).h().h(this.f51603i);
            this.f51603i.close();
            this.f51603i = null;
        }

        public final void q() throws Exception {
            if (this.f51603i != null) {
                p();
            }
            this.f51604j = o();
            FileOutputStream fileOutputStream = new FileOutputStream(this.f51604j);
            this.f51603i = fileOutputStream;
            fileOutputStream.write(o.b());
            new ar.com.hjg.pngj.chunks.k(this.f51605k).j().h(this.f51603i);
            for (PngChunk pngChunk : f(false).f()) {
                String str = pngChunk.f1076a;
                if (!str.equals("IHDR") && !str.equals("fcTL") && !str.equals("acTL")) {
                    if (str.equals("IDAT")) {
                        return;
                    } else {
                        pngChunk.d().h(this.f51603i);
                    }
                }
            }
        }
    }

    public static String a(File file, int i10) {
        String name = file.getName();
        return String.format(Locale.ENGLISH, "%s_%03d.%s", FilenameUtils.getBaseName(name), Integer.valueOf(i10), FilenameUtils.getExtension(name));
    }

    public static int b(File file) {
        C0784a c0784a = new C0784a(file);
        c0784a.d();
        return c0784a.f51606l + 1;
    }
}

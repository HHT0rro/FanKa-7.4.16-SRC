package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: UnZipFile.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bu {

    /* renamed from: a, reason: collision with root package name */
    private b f5170a;

    /* compiled from: UnZipFile.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5172a = false;
    }

    /* compiled from: UnZipFile.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface c {
        void a();

        void a(long j10);
    }

    public bu(br brVar, bq bqVar) {
        this.f5170a = new b(brVar, bqVar);
    }

    public final void a() {
        b bVar = this.f5170a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void b() {
        b bVar = this.f5170a;
        if (bVar != null) {
            a(bVar);
        }
    }

    /* compiled from: UnZipFile.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f5173a;

        /* renamed from: b, reason: collision with root package name */
        private String f5174b;

        /* renamed from: c, reason: collision with root package name */
        private bq f5175c;

        /* renamed from: d, reason: collision with root package name */
        private a f5176d = new a();

        /* renamed from: e, reason: collision with root package name */
        private String f5177e;

        public b(br brVar, bq bqVar) {
            this.f5175c = null;
            this.f5173a = brVar.x();
            this.f5174b = brVar.y();
            this.f5175c = bqVar;
        }

        public final void a(String str) {
            if (str.length() > 1) {
                this.f5177e = str;
            }
        }

        public final String b() {
            return this.f5174b;
        }

        public final String c() {
            return this.f5177e;
        }

        public final bq d() {
            return this.f5175c;
        }

        public final a e() {
            return this.f5176d;
        }

        public final void f() {
            this.f5176d.f5172a = true;
        }

        public final String a() {
            return this.f5173a;
        }
    }

    private static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        final bq d10 = bVar.d();
        if (d10 != null) {
            d10.p();
        }
        String a10 = bVar.a();
        String b4 = bVar.b();
        if (!TextUtils.isEmpty(a10) && !TextUtils.isEmpty(b4)) {
            File file = new File(a10);
            if (!file.exists()) {
                if (bVar.e().f5172a) {
                    if (d10 != null) {
                        d10.r();
                        return;
                    }
                    return;
                } else {
                    if (d10 != null) {
                        d10.q();
                        return;
                    }
                    return;
                }
            }
            File file2 = new File(b4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            c cVar = new c() { // from class: com.amap.api.col.3l.bu.1
                @Override // com.amap.api.col.3l.bu.c
                public final void a(long j10) {
                    try {
                        bq bqVar = bq.this;
                        if (bqVar != null) {
                            bqVar.a(j10);
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.amap.api.col.3l.bu.c
                public final void a() {
                    bq bqVar = bq.this;
                    if (bqVar != null) {
                        bqVar.q();
                    }
                }
            };
            try {
                if (bVar.e().f5172a && d10 != null) {
                    d10.r();
                }
                a(file, file2, cVar, bVar);
                if (bVar.e().f5172a) {
                    if (d10 != null) {
                        d10.r();
                        return;
                    }
                    return;
                } else {
                    if (d10 != null) {
                        d10.b(bVar.c());
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
                if (bVar.e().f5172a) {
                    if (d10 != null) {
                        d10.r();
                        return;
                    }
                    return;
                } else {
                    if (d10 != null) {
                        d10.q();
                        return;
                    }
                    return;
                }
            }
        }
        if (bVar.e().f5172a) {
            if (d10 != null) {
                d10.r();
            }
        } else if (d10 != null) {
            d10.q();
        }
    }

    private static void a(File file, File file2, c cVar, b bVar) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        a e2 = bVar.e();
        long j10 = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
            ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (e2 != null && e2.f5172a) {
                        zipInputStream.closeEntry();
                        zipInputStream.close();
                        checkedInputStream.close();
                        fileInputStream.close();
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if (!a(nextEntry.getName())) {
                            cVar.a();
                            break;
                        } else {
                            stringBuffer.append(nextEntry.getName());
                            stringBuffer.append(";");
                        }
                    }
                    j10 += nextEntry.getSize();
                    zipInputStream.closeEntry();
                } else {
                    break;
                }
            }
            bVar.a(stringBuffer.toString());
            zipInputStream.close();
            checkedInputStream.close();
            fileInputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        a(file2, zipInputStream2, j10, cVar, e2);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    private static void a(File file, ZipInputStream zipInputStream, long j10, c cVar, a aVar) throws Exception {
        int i10 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (aVar != null && aVar.f5172a) {
                zipInputStream.closeEntry();
                return;
            }
            String str = file.getPath() + File.separator + nextEntry.getName();
            if (!a(nextEntry.getName())) {
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            } else {
                File file2 = new File(str);
                a(file2);
                if (nextEntry.isDirectory()) {
                    file2.mkdirs();
                } else {
                    i10 += a(file2, zipInputStream, i10, j10, cVar, aVar);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private static boolean a(String str) {
        return (str.contains("..") || str.contains("/") || str.contains("\\") || str.contains("%")) ? false : true;
    }

    private static int a(File file, ZipInputStream zipInputStream, long j10, long j11, c cVar, a aVar) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i10 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                if (aVar != null && aVar.f5172a) {
                    bufferedOutputStream.close();
                    return i10;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i10 += read;
                if (j11 > 0 && cVar != null) {
                    long j12 = ((i10 + j10) * 100) / j11;
                    if (aVar == null || !aVar.f5172a) {
                        cVar.a(j12);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i10;
            }
        }
    }

    private static void a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        a(parentFile);
        parentFile.mkdir();
    }
}

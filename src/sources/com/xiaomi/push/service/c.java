package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.xiaomi.push.p0;
import com.xiaomi.push.r7;
import com.xiaomi.push.s7;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static long f48262a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f48263a;

        /* renamed from: b, reason: collision with root package name */
        public int f48264b;

        public a(byte[] bArr, int i10) {
            this.f48263a = bArr;
            this.f48264b = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Bitmap f48265a;

        /* renamed from: b, reason: collision with root package name */
        public long f48266b;

        public b(Bitmap bitmap, long j10) {
            this.f48265a = bitmap;
            this.f48266b = j10;
        }
    }

    public static int a(Context context, InputStream inputStream) {
        int i10;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            fc.c.i("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        int i11 = options.outWidth;
        if (i11 <= round || (i10 = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i11 / round, i10 / round);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap b(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a10;
        Uri parse = Uri.parse(str);
        ?? r02 = 0;
        r02 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
                try {
                    a10 = a(context, inputStream);
                    inputStream2 = context.getContentResolver().openInputStream(parse);
                } catch (IOException e2) {
                    e = e2;
                    inputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    s7.b(r02);
                    s7.b(inputStream);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                inputStream2 = null;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a10;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, null, options);
                s7.b(inputStream2);
                s7.b(inputStream);
                return decodeStream;
            } catch (IOException e11) {
                e = e11;
                fc.c.k(e);
                s7.b(inputStream2);
                s7.b(inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            r02 = context;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f4, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f7, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d7, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        if (r1 == null) goto L54;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00f9: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:59:0x00f9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.push.service.c.a c(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.c.c(java.lang.String, boolean):com.xiaomi.push.service.c$a");
    }

    public static b d(Context context, String str, boolean z10) {
        a c4;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        Bitmap g3 = g(context, str);
        try {
            if (g3 != null) {
                bVar.f48265a = g3;
                return bVar;
            }
            try {
                c4 = c(str, z10);
            } catch (Exception e2) {
                e = e2;
            }
            if (c4 == null) {
                s7.b(null);
                return bVar;
            }
            bVar.f48266b = c4.f48264b;
            byte[] bArr = c4.f48263a;
            if (bArr != null) {
                if (z10) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a10 = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a10;
                        bVar.f48265a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e10) {
                        e = e10;
                        byteArrayInputStream = byteArrayInputStream2;
                        fc.c.k(e);
                        s7.b(byteArrayInputStream);
                        return bVar;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        s7.b(byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f48265a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            f(context, c4.f48263a, str);
            s7.b(byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void e(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f48262a == 0) {
                f48262a = r7.a(file);
            }
            if (f48262a > 15728640) {
                try {
                    File[] listFiles = file.listFiles();
                    for (int i10 = 0; i10 < listFiles.length; i10++) {
                        if (!listFiles[i10].isDirectory() && Math.abs(System.currentTimeMillis() - listFiles[i10].lastModified()) > 1209600) {
                            listFiles[i10].delete();
                        }
                    }
                } catch (Exception e2) {
                    fc.c.k(e2);
                }
                f48262a = 0L;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void f(android.content.Context r5, byte[] r6, java.lang.String r7) {
        /*
            if (r6 != 0) goto L8
            java.lang.String r5 = "cannot save small icon cause bitmap is null"
            fc.c.i(r5)
            return
        L8:
            e(r5)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = r5.getCacheDir()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r2 = "mipush_icon"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L37
            r0.mkdirs()
        L37:
            java.io.File r1 = new java.io.File
            java.lang.String r7 = com.xiaomi.push.p0.b(r7)
            r1.<init>(r0, r7)
            r7 = 0
            boolean r0 = r1.exists()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            if (r0 != 0) goto L4a
            r1.createNewFile()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
        L4a:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> La9
            r3.<init>(r0)     // Catch: java.lang.Exception -> L64 java.lang.Throwable -> La9
            r3.write(r6)     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            r3.flush()     // Catch: java.lang.Throwable -> L5e java.lang.Exception -> L61
            com.xiaomi.push.s7.b(r3)
            goto L71
        L5e:
            r5 = move-exception
            r7 = r3
            goto Laa
        L61:
            r6 = move-exception
            r7 = r3
            goto L6b
        L64:
            r6 = move-exception
            goto L6b
        L66:
            r5 = move-exception
            r0 = r7
            goto Laa
        L69:
            r6 = move-exception
            r0 = r7
        L6b:
            fc.c.k(r6)     // Catch: java.lang.Throwable -> La9
            com.xiaomi.push.s7.b(r7)
        L71:
            com.xiaomi.push.s7.b(r0)
            long r6 = com.xiaomi.push.service.c.f48262a
            r3 = 0
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto La8
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.io.File r5 = r5.getCacheDir()
            java.lang.String r5 = r5.getPath()
            r7.append(r5)
            java.lang.String r5 = java.io.File.separator
            r7.append(r5)
            r7.append(r2)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            long r5 = com.xiaomi.push.r7.a(r6)
            long r0 = r1.length()
            long r5 = r5 + r0
            com.xiaomi.push.service.c.f48262a = r5
        La8:
            return
        La9:
            r5 = move-exception
        Laa:
            com.xiaomi.push.s7.b(r7)
            com.xiaomi.push.s7.b(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.c.f(android.content.Context, byte[], java.lang.String):void");
    }

    public static Bitmap g(Context context, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", p0.b(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap2 = BitmapFactory.decodeStream(fileInputStream);
                    file.setLastModified(System.currentTimeMillis());
                    s7.b(fileInputStream);
                    return bitmap2;
                } catch (Exception e2) {
                    e = e2;
                    Bitmap bitmap3 = bitmap2;
                    fileInputStream2 = fileInputStream;
                    bitmap = bitmap3;
                    fc.c.k(e);
                    s7.b(fileInputStream2);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    s7.b(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th3;
                fileInputStream = fileInputStream3;
            }
        } catch (Exception e10) {
            e = e10;
            bitmap = null;
        }
    }
}

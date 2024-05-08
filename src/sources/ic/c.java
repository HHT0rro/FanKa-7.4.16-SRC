package ic;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.push.p0;
import com.xiaomi.push.s7;
import com.xiaomi.push.t0;
import com.xiaomi.push.w5;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public Context f49873a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, ArrayList<gc.d>> f49874b;

    public c(Context context) {
        f(context);
    }

    public static String d(gc.d dVar) {
        return String.valueOf(dVar.f49448a);
    }

    @Override // ic.e
    public void a() {
        int i10;
        RandomAccessFile randomAccessFile;
        t0.c(this.f49873a, "event", "eventUploading");
        File[] f10 = t0.f(this.f49873a, "eventUploading");
        if (f10 == null || f10.length <= 0) {
            return;
        }
        int length = f10.length;
        FileLock fileLock = null;
        RandomAccessFile randomAccessFile2 = null;
        File file = null;
        while (i10 < length) {
            File file2 = f10[i10];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        fc.c.k(e2);
                    }
                }
                s7.b(randomAccessFile2);
                i10 = file == null ? i10 + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
                if (file2.length() > 5242880) {
                    fc.c.n("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                    h(file2.getName(), Formatter.formatFileSize(this.f49873a, file2.length()));
                    file2.delete();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e11) {
                            fc.c.k(e11);
                        }
                    }
                    s7.b(randomAccessFile2);
                    if (file == null) {
                    }
                    file.delete();
                } else {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath + ".lock");
                    try {
                        s7.g(file3);
                        randomAccessFile = new RandomAccessFile(file3, "rw");
                    } catch (Exception e12) {
                        e = e12;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        i(e(absolutePath));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e13) {
                                fc.c.k(e13);
                            }
                        }
                        s7.b(randomAccessFile);
                        file3.delete();
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                    } catch (Exception e14) {
                        e = e14;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        fc.c.k(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e15) {
                                fc.c.k(e15);
                            }
                        }
                        s7.b(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = randomAccessFile;
                        file = file3;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e16) {
                                fc.c.k(e16);
                            }
                        }
                        s7.b(randomAccessFile2);
                        if (file == null) {
                            throw th;
                        }
                        file.delete();
                        throw th;
                    }
                }
            }
        }
    }

    @Override // ic.a
    public void a(HashMap<String, ArrayList<gc.d>> hashMap) {
        this.f49874b = hashMap;
    }

    @Override // ic.f
    public void b() {
        HashMap<String, ArrayList<gc.d>> hashMap = this.f49874b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> iterator2 = this.f49874b.h().iterator2();
            while (iterator2.hasNext()) {
                ArrayList<gc.d> arrayList = this.f49874b.get(iterator2.next());
                if (arrayList != null && arrayList.size() > 0) {
                    gc.d[] dVarArr = new gc.d[arrayList.size()];
                    arrayList.toArray(dVarArr);
                    j(dVarArr);
                }
            }
        }
        this.f49874b.clear();
    }

    @Override // ic.f
    public void c(gc.d dVar) {
        if ((dVar instanceof gc.b) && this.f49874b != null) {
            gc.b bVar = (gc.b) dVar;
            String d10 = d(bVar);
            ArrayList<gc.d> arrayList = this.f49874b.get(d10);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(bVar);
            this.f49874b.put(d10, arrayList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
    
        fc.c.n(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
    
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
        r4 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> e(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
        L15:
            int r9 = r5.read(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = -1
            if (r9 != r4) goto L1d
            goto L66
        L1d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L25
        L21:
            fc.c.n(r6)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L25:
            int r9 = com.xiaomi.push.f.a(r2)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r7 = -573785174(0xffffffffddccbbaa, float:-1.84407149E18)
            if (r9 == r7) goto L2f
            goto L21
        L2f:
            int r9 = r5.read(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r9 != r4) goto L36
            goto L66
        L36:
            if (r9 == r1) goto L3e
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
        L3a:
            fc.c.n(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L66
        L3e:
            int r9 = com.xiaomi.push.f.a(r3)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r4 = 1
            if (r9 < r4) goto L63
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L4a
            goto L63
        L4a:
            byte[] r4 = new byte[r9]     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            int r6 = r5.read(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r6 == r9) goto L55
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            goto L3a
        L55:
            java.lang.String r9 = r8.m(r4)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r4 != 0) goto L15
            r0.add(r9)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            goto L15
        L63:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            goto L3a
        L66:
            com.xiaomi.push.s7.b(r5)
            goto L79
        L6a:
            r9 = move-exception
            r4 = r5
            goto L7a
        L6d:
            r9 = move-exception
            r4 = r5
            goto L73
        L70:
            r9 = move-exception
            goto L7a
        L72:
            r9 = move-exception
        L73:
            fc.c.k(r9)     // Catch: java.lang.Throwable -> L70
            com.xiaomi.push.s7.b(r4)
        L79:
            return r0
        L7a:
            com.xiaomi.push.s7.b(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.c.e(java.lang.String):java.util.List");
    }

    public void f(Context context) {
        this.f49873a = context;
    }

    public final void g(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e2) {
                fc.c.k(e2);
            }
        }
        s7.b(randomAccessFile);
    }

    public final void h(String str, String str2) {
        gc.b d10 = hc.b.e(this.f49873a).d(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d10.d());
        i(arrayList);
    }

    public void i(List<String> list) {
        throw null;
    }

    public void j(gc.d[] dVarArr) {
        if (dVarArr == null || dVarArr.length == 0 || dVarArr[0] == null) {
            fc.c.i("event data write to cache file failed because data null");
            return;
        }
        do {
            dVarArr = k(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0) {
                return;
            }
        } while (dVarArr[0] != null);
    }

    public final gc.d[] k(gc.d[] dVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String l10 = l(dVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(l10)) {
            return null;
        }
        try {
            File file = new File(l10 + ".lock");
            s7.g(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(l10), true));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    s7.b(bufferedOutputStream2);
                    g(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileLock = null;
            }
        } catch (Exception e11) {
            e = e11;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            try {
                int i10 = 0;
                for (gc.d dVar : dVarArr) {
                    if (dVar != null) {
                        byte[] n10 = n(dVar.d());
                        if (n10 != null && n10.length >= 1 && n10.length <= 4096) {
                            if (!t0.d(this.f49873a, l10)) {
                                int length = dVarArr.length - i10;
                                gc.d[] dVarArr2 = new gc.d[length];
                                System.arraycopy(dVarArr, i10, dVarArr2, 0, length);
                                s7.b(bufferedOutputStream);
                                g(randomAccessFile, fileLock);
                                return dVarArr2;
                            }
                            bufferedOutputStream.write(com.xiaomi.push.f.b(-573785174));
                            bufferedOutputStream.write(com.xiaomi.push.f.b(n10.length));
                            bufferedOutputStream.write(n10);
                            bufferedOutputStream.flush();
                            i10++;
                        }
                        fc.c.n("event data throw a invalid item ");
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                s7.b(bufferedOutputStream2);
                g(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fc.c.j("event data write to cache file failed cause exception", e);
            s7.b(bufferedOutputStream);
            g(randomAccessFile, fileLock);
            return null;
        }
        s7.b(bufferedOutputStream);
        g(randomAccessFile, fileLock);
        return null;
    }

    public final String l(gc.d dVar) {
        File externalFilesDir = this.f49873a.getExternalFilesDir("event");
        String d10 = d(dVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + d10;
        for (int i10 = 0; i10 < 100; i10++) {
            String str2 = str + i10;
            if (t0.d(this.f49873a, str2)) {
                return str2;
            }
        }
        return null;
    }

    public String m(byte[] bArr) {
        byte[] e2;
        if (bArr != null && bArr.length >= 1) {
            if (!hc.b.e(this.f49873a).c().f()) {
                return p0.f(bArr);
            }
            String b4 = t0.b(this.f49873a);
            if (!TextUtils.isEmpty(b4) && (e2 = t0.e(b4)) != null && e2.length > 0) {
                try {
                    return p0.f(Base64.decode(w5.b(e2, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e10) {
                    fc.c.k(e10);
                }
            }
        }
        return null;
    }

    public byte[] n(String str) {
        byte[] e2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!hc.b.e(this.f49873a).c().f()) {
            return p0.j(str);
        }
        String b4 = t0.b(this.f49873a);
        byte[] j10 = p0.j(str);
        if (!TextUtils.isEmpty(b4) && j10 != null && j10.length > 1 && (e2 = t0.e(b4)) != null) {
            try {
                if (e2.length > 1) {
                    return w5.c(e2, Base64.encode(j10, 2));
                }
            } catch (Exception e10) {
                fc.c.k(e10);
            }
        }
        return null;
    }
}

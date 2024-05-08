package ic;

import android.text.TextUtils;
import com.xiaomi.push.s7;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g {
    public static gc.c a(gc.c cVar, String str) {
        long[] i10;
        if (cVar == null || (i10 = i(str)) == null) {
            return null;
        }
        cVar.f49446i = i10[0];
        cVar.f49447j = i10[1];
        return cVar;
    }

    public static gc.c b(String str) {
        gc.c cVar = null;
        try {
            String[] j10 = j(str);
            if (j10 == null || j10.length < 4 || TextUtils.isEmpty(j10[0]) || TextUtils.isEmpty(j10[1]) || TextUtils.isEmpty(j10[2]) || TextUtils.isEmpty(j10[3])) {
                return null;
            }
            cVar = gc.c.e();
            cVar.f49448a = Integer.parseInt(j10[0]);
            cVar.f49449b = j10[1];
            cVar.f49450c = Integer.parseInt(j10[2]);
            cVar.f49445h = Integer.parseInt(j10[3]);
            return cVar;
        } catch (Exception unused) {
            fc.c.m("parse per key error");
            return cVar;
        }
    }

    public static String c(gc.c cVar) {
        return cVar.f49448a + "#" + cVar.f49449b + "#" + cVar.f49450c + "#" + cVar.f49445h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    public static HashMap<String, String> d(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
        ?? r12 = 0;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        ?? split = readLine.split("%%%");
                        r12 = split.length;
                        if (r12 >= 2) {
                            r12 = 0;
                            r12 = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                r12 = split[0];
                                hashMap.put(r12, split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader3;
                        fc.c.k(e);
                        s7.b(bufferedReader2);
                        bufferedReader = bufferedReader2;
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        s7.b(bufferedReader);
                        throw th;
                    }
                }
                s7.b(bufferedReader3);
                bufferedReader = r12;
            } catch (Exception e10) {
                e = e10;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d5, code lost:
    
        if (r1 != null) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> e(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.g.e(android.content.Context, java.lang.String):java.util.List");
    }

    public static void f(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e10) {
            bufferedWriter = null;
            e2 = e10;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            s7.b(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : hashMap.h()) {
                    bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                s7.b(bufferedWriter);
                throw th;
            }
        } catch (Exception e11) {
            e2 = e11;
            fc.c.k(e2);
            s7.b(bufferedWriter);
        }
        s7.b(bufferedWriter);
    }

    public static void g(String str, gc.d[] dVarArr) {
        RandomAccessFile randomAccessFile;
        if (dVarArr == null || dVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            s7.g(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> d10 = d(str);
                for (gc.d dVar : dVarArr) {
                    if (dVar != null) {
                        String c4 = c((gc.c) dVar);
                        long j10 = ((gc.c) dVar).f49446i;
                        long j11 = ((gc.c) dVar).f49447j;
                        if (!TextUtils.isEmpty(c4) && j10 > 0 && j11 >= 0) {
                            h(d10, c4, j10, j11);
                        }
                    }
                }
                f(str, d10);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        e = e2;
                        fc.c.k(e);
                        s7.b(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    fc.c.m("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e10) {
                            e = e10;
                            fc.c.k(e);
                            s7.b(randomAccessFile);
                        }
                    }
                    s7.b(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e11) {
                            fc.c.k(e11);
                        }
                    }
                    s7.b(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        s7.b(randomAccessFile);
    }

    public static void h(HashMap<String, String> hashMap, String str, long j10, long j11) {
        StringBuilder sb2;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb2 = new StringBuilder();
        } else {
            long[] i10 = i(str2);
            if (i10 == null || i10[0] <= 0 || i10[1] < 0) {
                sb2 = new StringBuilder();
            } else {
                j10 += i10[0];
                j11 += i10[1];
                sb2 = new StringBuilder();
            }
        }
        sb2.append(j10);
        sb2.append("#");
        sb2.append(j11);
        hashMap.put(str, sb2.toString());
    }

    public static long[] i(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            fc.c.k(e2);
            return null;
        }
    }

    public static String[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}

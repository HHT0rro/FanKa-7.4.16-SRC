package l4;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import ar.com.hjg.pngj.q;
import com.github.sahasbhop.flog.FLog;
import java.io.File;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: AssistUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f51622a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: AssistUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a implements Comparable<a> {

        /* renamed from: b, reason: collision with root package name */
        public long f51623b;

        /* renamed from: c, reason: collision with root package name */
        public File f51624c;

        public a(File file) {
            this.f51624c = file;
            this.f51623b = file.lastModified();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull a aVar) {
            long j10 = aVar.f51623b;
            long j11 = this.f51623b;
            if (j11 < j10) {
                return -1;
            }
            return j11 == j10 ? 0 : 1;
        }
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            char[] cArr2 = f51622a;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
        }
        return new String(cArr);
    }

    public static void b(File file, long j10) {
        long e2 = e(file);
        if (k4.b.f50645f) {
            FLog.g("checkCacheSize: %d", Long.valueOf(e2));
        }
        if (j10 < 1 && e2 >= 5000000) {
            c(file, e2 - 5000000);
        } else {
            if (j10 <= 0 || e2 < j10) {
                return;
            }
            c(file, e2 - j10);
        }
    }

    public static void c(File file, long j10) {
        long j11 = 0;
        for (File file2 : h(file)) {
            j11 += file2.length();
            boolean delete = file2.delete();
            if (k4.b.f50645f) {
                Object[] objArr = new Object[2];
                objArr[0] = delete ? "success" : com.alipay.sdk.util.e.f4721a;
                objArr[1] = file2.getPath();
                FLog.g("Delete(%s): %s", objArr);
            }
            if (j11 >= j10) {
                return;
            }
        }
    }

    public static File d(Context context, String str) {
        String lastPathSegment;
        try {
            lastPathSegment = String.format("%s.png", i(str));
        } catch (Exception unused) {
            lastPathSegment = Uri.parse(str).getLastPathSegment();
        }
        File f10 = f(context);
        if (f10 == null || !f10.exists()) {
            return null;
        }
        return new File(f10, lastPathSegment);
    }

    public static long e(File file) {
        long j10 = 0;
        for (File file2 : h(file)) {
            if (file2.isFile()) {
                j10 += file2.length();
            }
        }
        return j10;
    }

    public static File f(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            return null;
        }
        File file = new File(String.format("%s/apng/.nomedia/", externalCacheDir.getPath()));
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    public static boolean g(File file) {
        try {
            q qVar = new q(file);
            qVar.d();
            return qVar.o() > 1;
        } catch (Exception e2) {
            if (!k4.b.f50646g) {
                return false;
            }
            FLog.h("Error: %s", e2.toString());
            return false;
        }
    }

    public static File[] h(File file) {
        File[] listFiles = file.listFiles();
        a[] aVarArr = new a[listFiles.length];
        for (int i10 = 0; i10 < listFiles.length; i10++) {
            aVarArr[i10] = new a(listFiles[i10]);
        }
        Arrays.sort(aVarArr);
        for (int i11 = 0; i11 < listFiles.length; i11++) {
            listFiles[i11] = aVarArr[i11].f51624c;
        }
        return listFiles;
    }

    public static String i(String str) throws Exception {
        return a(MessageDigest.getInstance("md5").digest(str.getBytes("utf-8")));
    }
}

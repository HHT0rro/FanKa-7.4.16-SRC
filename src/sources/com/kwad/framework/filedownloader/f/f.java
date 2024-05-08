package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.sdk.utils.aq;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    private static int aiu = 65536;
    private static long aiv = 2000;
    private static String aiw;
    private static Boolean aix;
    private static Boolean aiy;
    private static final Pattern aiz = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int A(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.vo().vp().g(str, str2, false);
    }

    public static void B(String str, String str2) {
        bB(str2);
        bC(str);
    }

    public static void V(long j10) {
        if (an(c.wL())) {
            aiv = j10;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static String a(String str, boolean z10, String str2) {
        if (str == null) {
            return null;
        }
        if (!z10) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return z(str, str2);
    }

    public static boolean an(Context context) {
        boolean endsWith;
        Boolean bool = aix;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.wN().aip) {
            endsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService("activity")) == null) {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            endsWith = aq.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean valueOf = Boolean.valueOf(endsWith);
        aix = valueOf;
        return valueOf.booleanValue();
    }

    public static void ao(Context context) {
        File ap = ap(context);
        try {
            ap.getParentFile().mkdirs();
            ap.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static File ap(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String b(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static com.kwad.framework.filedownloader.e.a bA(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(b("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException(b("create new file error  %s", file.getAbsolutePath()));
            }
            return com.kwad.framework.filedownloader.download.b.vo().b(file);
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }

    private static void bB(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bC(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bM(int i10) {
        if (an(c.wL())) {
            aiu = i10;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static String br(String str) {
        return z(wR(), bs(str));
    }

    private static String bs(String str) {
        return bu(str);
    }

    public static String bt(String str) {
        return b("%s.temp", str);
    }

    public static String bu(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b4 : digest) {
                int i10 = b4 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Huh, MD5 should be supported?", e10);
        }
    }

    public static String bv(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = aiz.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String bw(String str) {
        int length = str.length();
        int i10 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        int i11 = (lastIndexOf != -1 || i10 <= 0) ? lastIndexOf : 2;
        if (i11 == -1) {
            return null;
        }
        char charAt = str.charAt(length - 1);
        char c4 = File.separatorChar;
        if (charAt == c4) {
            return null;
        }
        if (str.indexOf(c4) == i11 && str.charAt(i10) == File.separatorChar) {
            return str.substring(0, i11 + 1);
        }
        return str.substring(0, i11);
    }

    public static String bx(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean by(String str) {
        return c.wL().checkCallingOrSelfPermission(str) == 0;
    }

    private static long bz(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static int g(String str, String str2, boolean z10) {
        return com.kwad.framework.filedownloader.download.b.vo().vp().g(str, str2, z10);
    }

    public static boolean i(long j10, long j11) {
        return j10 > ((long) wP()) && j11 > wQ();
    }

    private static int wP() {
        return aiu;
    }

    private static long wQ() {
        return aiv;
    }

    private static String wR() {
        if (!TextUtils.isEmpty(aiw)) {
            return aiw;
        }
        if (c.wL().getExternalCacheDir() == null) {
            return Environment.getDownloadCacheDirectory().getAbsolutePath();
        }
        return c.wL().getExternalCacheDir().getAbsolutePath();
    }

    public static boolean wS() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.wL().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String wT() {
        return b("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }

    private static String z(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return b("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static String a(int i10, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar != null) {
            String bd2 = bVar.bd(DownloadUtils.ETAG);
            if (d.ail) {
                d.c(f.class, "etag find %s for task(%d)", bd2, Integer.valueOf(i10));
            }
            return bd2;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static long b(int i10, com.kwad.framework.filedownloader.a.b bVar) {
        long bz = bz(bVar.bd("Content-Length"));
        String bd2 = bVar.bd(DownloadUtils.TRANSFER_ENCODING);
        if (bz >= 0) {
            return bz;
        }
        if (!(bd2 != null && bd2.equals(DownloadUtils.VALUE_CHUNKED))) {
            if (e.wN().aio) {
                if (d.ail) {
                    d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i10));
                }
            } else {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            }
        }
        return -1L;
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String bv = bv(bVar.bd("Content-Disposition"));
        if (TextUtils.isEmpty(bv)) {
            bv = bs(str);
        }
        return bv.replaceAll("\\/", "_");
    }

    private static boolean a(int i10, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.ail) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i10));
            }
            return false;
        }
        if (cVar.vD() == null) {
            if (d.ail) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i10));
            }
            return false;
        }
        return a(i10, cVar, cVar.vD(), null);
    }

    public static boolean b(int i10, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i10, cVar, (Boolean) null);
    }

    public static boolean a(int i10, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (!d.ail) {
                return false;
            }
            d.c(f.class, "can't continue %d path = null", Integer.valueOf(i10));
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long wl = cVar.wl();
            if (cVar.wo() <= 1 && wl == 0) {
                if (!d.ail) {
                    return false;
                }
                d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i10));
                return false;
            }
            long total = cVar.getTotal();
            if (length >= wl && (total == -1 || (length <= total && wl < total))) {
                if (bool == null || bool.booleanValue() || total != length) {
                    return true;
                }
                if (!d.ail) {
                    return false;
                }
                d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i10));
                return false;
            }
            if (!d.ail) {
                return false;
            }
            d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i10), Long.valueOf(length), Long.valueOf(wl), Long.valueOf(total));
            return false;
        }
        if (!d.ail) {
            return false;
        }
        d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i10), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
        return false;
    }
}

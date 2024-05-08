package ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import com.wangmai.appsdkdex.utils.WMAppEnvironment;
import com.wangmai.common.utils.DebugLog;
import java.io.File;

/* compiled from: FileUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f801a = zc.b.a("GjmfVujmt");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f802b = true;

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (Throwable th) {
            DebugLog.W(f801a, zc.b.a("bqlJogp!fydfqujpo") + th.toString());
            return null;
        }
    }

    public static String b(Context context) {
        String str = "";
        try {
            if (context.getExternalFilesDir(zc.b.a("xn")) != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getExternalFilesDir(zc.b.a("xn")).getAbsolutePath());
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append(zc.b.a("xnbmmpdbujpo"));
                sb2.append(str2);
                sb2.append(zc.b.a("dpogjhvsf"));
                str = sb2.toString();
                DebugLog.D(f801a, zc.b.a("tupsbhf!bwbjmbcmf"));
            } else if (Environment.getExternalStorageState().equals(zc.b.a("npvoufe"))) {
                str = WMAppEnvironment.VERSION_UPDATE_APP_DOWNLOAD_DIR;
                DebugLog.D(f801a, zc.b.a("fyufsobm!tupsbhf!bwbjmbcmf"));
            } else {
                DebugLog.release_e(f801a, zc.b.a("fyufsobm!tupsbhf!opu!bwbjmbcmf\""));
            }
        } catch (Throwable th) {
            DebugLog.E(f801a, zc.b.a("hfuGjmfQbui!fssps�") + th.toString());
        }
        return str;
    }

    public static String c(String str, String str2) {
        if (f802b || !(str == null || str2 == null)) {
            return d(str) > d(str2) ? str : str2;
        }
        throw new AssertionError();
    }

    public static long d(String str) {
        try {
            String[] split = str.split(zc.b.a("]/"));
            long j10 = 0;
            for (int i10 = 0; i10 < split.length; i10++) {
                j10 += Long.parseLong(split[i10]) * ((long) Math.pow(1000L, (split.length - i10) - 1));
            }
            return j10;
        } catch (Throwable th) {
            DebugLog.W(f801a, zc.b.a("wfstjpoObnfUpMpoh!fydfqujpo") + th.toString());
            return 0L;
        }
    }
}

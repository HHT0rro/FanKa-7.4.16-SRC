package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.dh;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static com.ss.android.socialbase.appdownloader.ej.e f38480c;
    private static t dh;
    private static Context dk;

    /* renamed from: e, reason: collision with root package name */
    private static com.ss.android.download.api.config.oa f38481e;
    private static com.ss.android.download.api.config.hc ej;

    /* renamed from: f, reason: collision with root package name */
    private static com.ss.android.download.api.config.sy f38482f;

    /* renamed from: hc, reason: collision with root package name */
    private static com.ss.android.download.api.config.w f38483hc;

    /* renamed from: k, reason: collision with root package name */
    private static dh f38484k;

    /* renamed from: l, reason: collision with root package name */
    private static com.ss.android.download.api.config.ej f38485l;
    private static x li;

    /* renamed from: m, reason: collision with root package name */
    public static final JSONObject f38486m = new JSONObject();
    private static com.ss.android.download.api.dk.m mj;

    /* renamed from: n, reason: collision with root package name */
    private static com.ss.android.download.api.config.e f38487n;
    private static com.ss.android.download.api.config.ve np;

    /* renamed from: oa, reason: collision with root package name */
    private static com.ss.android.download.api.config.dk f38488oa;

    /* renamed from: q, reason: collision with root package name */
    private static com.ss.android.download.api.config.c f38489q;

    /* renamed from: r, reason: collision with root package name */
    private static q f38490r;
    private static com.ss.android.download.api.config.np sy;

    /* renamed from: t, reason: collision with root package name */
    private static r f38491t;
    private static com.ss.android.download.api.config.l ve;

    /* renamed from: w, reason: collision with root package name */
    private static com.ss.android.download.api.model.m f38492w;

    /* renamed from: x, reason: collision with root package name */
    private static k f38493x;

    public static com.ss.android.download.api.config.sy c() {
        return f38482f;
    }

    @NonNull
    public static x dh() {
        if (li == null) {
            li = new x() { // from class: com.ss.android.downloadlib.addownload.c.5
                @Override // com.ss.android.download.api.config.x
                public void m(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i10) {
                }
            };
        }
        return li;
    }

    public static void dk(Context context) {
        if (dk != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        dk = context.getApplicationContext();
    }

    @NonNull
    public static k e() {
        if (f38493x == null) {
            f38493x = new k() { // from class: com.ss.android.downloadlib.addownload.c.3
                @Override // com.ss.android.download.api.config.k
                public void m(String str, int i10, JSONObject jSONObject) {
                }
            };
        }
        return f38493x;
    }

    @NonNull
    public static com.ss.android.download.api.config.ve ej() {
        if (np == null) {
            np = new com.ss.android.download.api.m.m();
        }
        return np;
    }

    @NonNull
    public static t f() {
        return dh;
    }

    public static Context getContext() {
        Context context = dk;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static q hc() {
        return f38490r;
    }

    public static com.ss.android.download.api.config.np k() {
        return sy;
    }

    public static com.ss.android.download.api.config.e l() {
        return f38487n;
    }

    public static String li() {
        try {
            int i10 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i10 == 29 && !Environment.isExternalStorageLegacy()) || i10 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + w().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            dk = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
    public static com.ss.android.download.api.dk.m mj() {
        if (mj == null) {
            mj = new com.ss.android.download.api.dk.m() { // from class: com.ss.android.downloadlib.addownload.c.4
                @Override // com.ss.android.download.api.dk.m
                public void m(Throwable th, String str) {
                }
            };
        }
        return mj;
    }

    public static com.ss.android.socialbase.appdownloader.ej.e n() {
        if (f38480c == null) {
            f38480c = new com.ss.android.socialbase.appdownloader.ej.e() { // from class: com.ss.android.downloadlib.addownload.c.2
                @Override // com.ss.android.socialbase.appdownloader.ej.e
                public void m(DownloadInfo downloadInfo, BaseException baseException, int i10) {
                }
            };
        }
        return f38480c;
    }

    @NonNull
    public static com.ss.android.download.api.config.w np() {
        if (f38483hc == null) {
            f38483hc = new com.ss.android.download.api.m.dk();
        }
        return f38483hc;
    }

    @NonNull
    public static com.ss.android.download.api.model.m oa() {
        if (f38492w == null) {
            f38492w = new m.C0573m().m();
        }
        return f38492w;
    }

    public static com.ss.android.download.api.config.l q() {
        return ve;
    }

    public static String r() {
        return "1.7.0";
    }

    @Nullable
    public static r sy() {
        return f38491t;
    }

    public static com.ss.android.download.api.config.c t() {
        return f38489q;
    }

    public static boolean v() {
        return (ej == null || f38487n == null || f38481e == null || f38488oa == null || dh == null) ? false : true;
    }

    @Nullable
    public static com.ss.android.download.api.config.dk ve() {
        return f38488oa;
    }

    @NonNull
    public static JSONObject w() {
        com.ss.android.download.api.config.oa oaVar = f38481e;
        if (oaVar != null && oaVar.m() != null) {
            return f38481e.m();
        }
        return f38486m;
    }

    public static dh x() {
        return f38484k;
    }

    @NonNull
    public static com.ss.android.download.api.config.ej dk() {
        if (f38485l == null) {
            f38485l = new com.ss.android.download.api.config.ej() { // from class: com.ss.android.downloadlib.addownload.c.1
                @Override // com.ss.android.download.api.config.ej
                public void m(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.ej
                public void m(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f38485l;
    }

    public static void m(@NonNull com.ss.android.download.api.config.hc hcVar) {
        ej = hcVar;
    }

    public static void m(@NonNull com.ss.android.download.api.config.ve veVar) {
        np = veVar;
    }

    public static void m(@NonNull com.ss.android.download.api.config.e eVar) {
        f38487n = eVar;
    }

    public static void m(@NonNull com.ss.android.download.api.config.w wVar) {
        f38483hc = wVar;
    }

    public static void m(@NonNull com.ss.android.download.api.config.oa oaVar) {
        f38481e = oaVar;
    }

    public static void m(@NonNull com.ss.android.download.api.model.m mVar) {
        f38492w = mVar;
    }

    public static void m(@NonNull com.ss.android.download.api.config.dk dkVar) {
        f38488oa = dkVar;
    }

    public static com.ss.android.download.api.config.hc m() {
        return ej;
    }

    public static void m(String str) {
        com.ss.android.socialbase.appdownloader.l.oa().m(str);
    }

    public static void m(t tVar) {
        dh = tVar;
    }

    public static void m(com.ss.android.download.api.dk.m mVar) {
        mj = mVar;
    }
}

package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import android.view.autofill.AutofillManager;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0522a {
    }

    @Nullable
    public static String H(AdInfo adInfo) {
        return du(DownloadParams.transform(adInfo).mFileUrl);
    }

    public static void I(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static void a(@NonNull AdInfo adInfo, boolean z10) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!ag.isNetworkConnected(context)) {
                Context context2 = mContext;
                v.O(context2, w.bX(context2));
                return;
            }
            DownloadParams transform = DownloadParams.transform(adInfo);
            transform.requestInstallPermission = false;
            String str = transform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
                downloadRequest.setDestinationFileName(dv(str));
                downloadRequest.setTag(transform);
                downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
                if (ServiceProvider.KP().showNotification && aW(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                com.kwad.sdk.e.a.a(mContext, transform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void aV(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    com.kwad.sdk.c.xL().init(context);
                    b.De().init(context);
                    mHasInit = true;
                }
            }
        }
    }

    private static boolean aW(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static String du(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ((Object) aw.cL(mContext)) + File.separator + dv(str);
    }

    private static String dv(String str) {
        return ad.bu(str) + ".apk";
    }

    public static void dw(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.e.a.C(mContext, str);
    }

    public static void dx(String str) {
        if (mContext == null) {
            return;
        }
        String du = du(str);
        com.kwad.sdk.e.a.e(mContext, ad.bu(str), du);
    }

    private static URLConnection dy(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(openConnection);
        openConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, "zh-CN");
        openConnection.setConnectTimeout(10000);
        openConnection.setReadTimeout(AutofillManager.MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS);
        openConnection.setUseCaches(false);
        openConnection.setDoInput(true);
        openConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
        openConnection.setRequestProperty("Charset", "UTF-8");
        return openConnection;
    }

    public static void a(String str, File file, boolean z10) {
        a(str, file, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0115 A[Catch: all -> 0x013f, TryCatch #8 {all -> 0x013f, blocks: (B:47:0x0111, B:49:0x0115, B:52:0x013e, B:51:0x0118), top: B:46:0x0111 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0118 A[Catch: all -> 0x013f, TryCatch #8 {all -> 0x013f, blocks: (B:47:0x0111, B:49:0x0115, B:52:0x013e, B:51:0x0118), top: B:46:0x0111 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r10, java.io.File r11, com.kwad.sdk.core.download.a.InterfaceC0522a r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.lang.String, java.io.File, com.kwad.sdk.core.download.a$a, boolean):boolean");
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                boolean z10 = false;
                Iterator<String> iterator2 = value.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    if ("gzip".equalsIgnoreCase(iterator2.next())) {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    try {
                        return new GZIPInputStream(inputStream);
                    } catch (IOException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return inputStream;
    }
}

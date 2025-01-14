package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.bt;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.g;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.IHiAd;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeAppDownloadManager {
    private static NativeAppDownloadManager I;
    private static final byte[] V = new byte[0];
    private IAppDownloadManager B;
    private IHiAd Z;

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AppDownloadListener {
        void onAppOpen(String str, String str2);

        void onDownloadProgress(int i10, String str);

        void onStatusChanged(String str, String str2);
    }

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ResultCode {
        public static final int DOWNLOAD_NO_PERMISSION = -2;
        public static final int DOWNLOAD_PARAMS_ERROR = -1;
        public static final int DOWNLOAD_SUCCESS = 0;
    }

    private NativeAppDownloadManager(Context context) {
        IHiAd hiAd = HiAd.getInstance(context);
        this.Z = hiAd;
        this.B = hiAd.getAppDownloadManager();
    }

    private static NativeAppDownloadManager Code(Context context) {
        NativeAppDownloadManager nativeAppDownloadManager;
        synchronized (V) {
            if (I == null) {
                I = new NativeAppDownloadManager(context);
            }
            nativeAppDownloadManager = I;
        }
        return nativeAppDownloadManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(k kVar) {
        if (kVar == null) {
            return k.DOWNLOAD.toString();
        }
        k kVar2 = kVar == k.DOWNLOADED ? k.INSTALL : kVar;
        if (kVar == k.RESUME) {
            kVar2 = k.DOWNLOADING;
        }
        return kVar2.toString();
    }

    @GlobalApi
    public static NativeAppDownloadManager getInstance(Context context) {
        return Code(context);
    }

    @GlobalApi
    public void cancelDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager == null || !(nativeAd instanceof bt)) {
            gl.V("NativeAppDownloadManager", "ad is not native ad when cancel download");
        } else {
            iAppDownloadManager.C(context, ((bt) nativeAd).Code());
        }
    }

    @GlobalApi
    public String getAppStatus(Context context, NativeAd nativeAd) {
        String str;
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager == null || !(nativeAd instanceof bt)) {
            str = "ad is not native ad when get app status";
        } else {
            k S = iAppDownloadManager.S(context, ((bt) nativeAd).Code());
            if (S != null) {
                return S.name();
            }
            str = "appStatus obj is null when get app status";
        }
        gl.V("NativeAppDownloadManager", str);
        return k.DOWNLOAD.name();
    }

    @GlobalApi
    public int getDownloadProgress(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager != null && (nativeAd instanceof bt)) {
            return iAppDownloadManager.F(context, ((bt) nativeAd).Code());
        }
        gl.V("NativeAppDownloadManager", "ad is not native ad when get download progress");
        return 0;
    }

    @GlobalApi
    public void pauseDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager == null || !(nativeAd instanceof bt)) {
            gl.V("NativeAppDownloadManager", "appDownloadManager is null or nativeAd is invalid when resume download");
        } else {
            iAppDownloadManager.B(context, ((bt) nativeAd).Code());
        }
    }

    @GlobalApi
    public int resumeDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager != null && (nativeAd instanceof bt)) {
            return iAppDownloadManager.Z(context, ((bt) nativeAd).Code());
        }
        gl.V("NativeAppDownloadManager", "appDownloadManager is null or nativeAd is invalid when resume download");
        return -1;
    }

    @GlobalApi
    public void setAppDownloadListener(final AppDownloadListener appDownloadListener) {
        this.Z.setAppDownloadListener(new com.huawei.openalliance.ad.inter.listeners.AppDownloadListener() { // from class: com.huawei.hms.ads.nativead.NativeAppDownloadManager.1
            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(k kVar, AppInfo appInfo) {
                if (appDownloadListener != null) {
                    gl.V("NativeAppDownloadManager", "onStatusChanged: " + kVar.toString());
                    gl.V("NativeAppDownloadManager", "onStatusChanged after switch: " + NativeAppDownloadManager.this.Code(kVar));
                    appDownloadListener.onStatusChanged(NativeAppDownloadManager.this.Code(kVar), appInfo.e());
                }
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(AppInfo appInfo) {
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(AppInfo appInfo, int i10) {
                AppDownloadListener appDownloadListener2 = appDownloadListener;
                if (appDownloadListener2 != null) {
                    appDownloadListener2.onDownloadProgress(i10, appInfo.e());
                }
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(String str) {
                AppDownloadTask Code;
                AppInfo L;
                if (appDownloadListener == null || (Code = g.I().Code(str)) == null || (L = Code.L()) == null) {
                    return;
                }
                appDownloadListener.onAppOpen(str, L.e());
            }
        });
    }

    @GlobalApi
    public int startDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager != null && (nativeAd instanceof bt)) {
            return iAppDownloadManager.Code(context, ((bt) nativeAd).Code());
        }
        gl.V("NativeAppDownloadManager", "appDownloadManager is null or nativeAd is invalid when start download");
        return -1;
    }
}

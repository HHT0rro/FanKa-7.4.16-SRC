package com.kwad.components.core.n.b.a;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.webview.tachikoma.g;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleLoadListener;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.ICrashCustomKeyValue;
import com.kwad.components.offline.api.core.api.ICrashOccurListener;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bk;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j implements IOfflineHostApi {
    private IAsync MQ;
    private IEnvironment MR;
    private IZipper MS;
    private INet MT;
    private IEncrypt MU;
    private IOfflineCompoLogcat MV;
    private ICrash MW;
    private ILoggerReporter MX;
    private IDownloader MY;
    private IImageLoader MZ;
    private IVideo Na;
    private ILive Nb;
    private ICache Nc;
    private IWebView Nd;
    private IVibratorUtil Ne;
    private IIdc Nf;
    private IImagePlayer Ng;
    private ILifeCycle Nh;
    private INetworkManager Ni;
    private ISystemProperties Nj;
    private IFlowUuid Nk;

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.MQ == null) {
            this.MQ = new a();
        }
        return this.MQ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IBundleService bundleService() {
        return new IBundleService() { // from class: com.kwad.components.core.n.b.a.j.4
            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundle(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                com.kwad.components.core.webview.tachikoma.g.sy().b(context, str, new g.b() { // from class: com.kwad.components.core.n.b.a.j.4.1
                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundleWithString(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                com.kwad.components.core.webview.tachikoma.g.sy().a(context, str, new g.b() { // from class: com.kwad.components.core.n.b.a.j.4.2
                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void unloadBundle(String str) {
                com.kwad.components.core.webview.tachikoma.g.sy().unloadBundle(str);
            }
        };
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.Nc == null) {
            this.Nc = new b();
        }
        return this.Nc;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.MW == null) {
            this.MW = new ICrash() { // from class: com.kwad.components.core.n.b.a.j.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addCustomKeyValue(final ICrashCustomKeyValue iCrashCustomKeyValue) {
                    com.kwad.sdk.service.c.b(new com.kwad.sdk.service.a.c() { // from class: com.kwad.components.core.n.b.a.j.1.1
                        @Override // com.kwad.sdk.service.a.c
                        public final String getKey() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getKey();
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.service.a.c
                        public final JSONObject getValue() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getValue();
                            }
                            return null;
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addOnCrashListener(final ICrashOccurListener iCrashOccurListener) {
                    com.kwad.sdk.service.c.a(new com.kwad.sdk.service.a.g() { // from class: com.kwad.components.core.n.b.a.j.1.2
                        @Override // com.kwad.sdk.service.a.g
                        public final void l(int i10, String str) {
                            ICrashOccurListener iCrashOccurListener2 = iCrashOccurListener;
                            if (iCrashOccurListener2 != null) {
                                iCrashOccurListener2.onCrashOccur(i10, str);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    com.kwad.sdk.service.c.gatherException(th);
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(TKExceptionUploadParams tKExceptionUploadParams) {
                    com.kwad.sdk.service.c.G(tKExceptionUploadParams.key, tKExceptionUploadParams.toJson().toString());
                }
            };
        }
        return this.MW;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.MY == null) {
            this.MY = new IDownloader() { // from class: com.kwad.components.core.n.b.a.j.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.d(str, file);
                }
            };
        }
        return this.MY;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.MU == null) {
            this.MU = new c();
        }
        return this.MU;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.MR == null) {
            this.MR = new d();
        }
        return this.MR;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IFlowUuid flowUuid() {
        if (this.Nk == null) {
            this.Nk = new e();
        }
        return this.Nk;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getAppIconId(Context context) {
        return as.getAppIconId(context);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getDrawableId(Context context, String str) {
        return as.at(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getId(Context context, String str) {
        return as.getId(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final long getSystemTimeInMs(Context context, boolean z10) {
        return bk.v(context, z10);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getTKErrorDetailCount() {
        return com.kwad.sdk.core.config.d.getTKErrorDetailCount();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final List<String> getTKPreloadMemCacheTemplates() {
        return com.kwad.sdk.core.config.d.getTKPreloadMemCacheTemplates();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IIdc idc() {
        if (this.Nf == null) {
            this.Nf = new m();
        }
        return this.Nf;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.MZ == null) {
            this.MZ = new f();
        }
        return this.MZ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImagePlayer imagePlayer() {
        com.kwad.components.core.g.d dVar = new com.kwad.components.core.g.d();
        this.Ng = dVar;
        return dVar;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean isOrientationPortrait() {
        return ai.isOrientationPortrait();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILifeCycle lifeCycle() {
        if (this.Nh == null) {
            this.Nh = new g();
        }
        return this.Nh;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.Nb == null) {
            this.Nb = new com.kwad.components.core.n.b.b.a();
        }
        return this.Nb;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.MV == null) {
            this.MV = new k();
        }
        return this.MV;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.MX == null) {
            this.MX = new ILoggerReporter() { // from class: com.kwad.components.core.n.b.a.j.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(com.kwad.sdk.commercial.c cVar) {
                    com.kwad.sdk.commercial.b.d(cVar);
                }
            };
        }
        return this.MX;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.MT == null) {
            this.MT = new h();
        }
        return this.MT;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INetworkManager networkManager() {
        if (this.Ni == null) {
            this.Ni = new i();
        }
        return this.Ni;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final void saveTKTemplateCache(String str, int i10, String str2) {
        com.kwad.components.core.webview.tachikoma.h.sB().b(str, i10, str2);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISystemProperties systemProperty() {
        if (this.Nj == null) {
            this.Nj = new n();
        }
        return this.Nj;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.Ne == null) {
            this.Ne = new o();
        }
        return this.Ne;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.Na == null) {
            this.Na = new com.kwad.components.core.n.b.c.e();
        }
        return this.Na;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.Nd == null) {
            this.Nd = new com.kwad.components.core.n.b.d.b();
        }
        return this.Nd;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.MS == null) {
            this.MS = new p();
        }
        return this.MS;
    }
}

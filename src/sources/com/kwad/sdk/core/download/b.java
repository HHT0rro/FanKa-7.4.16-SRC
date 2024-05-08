package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static final Map<String, Integer> aun = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> auo = new LruHashMap(10);
    private final WeakHashMap<c, AdTemplate> aul;
    private final Map<c, AdTemplate> aum;
    private final com.kwad.sdk.b.a aup;
    private volatile boolean mHasInit;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        public static final b aux = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    public static b De() {
        return a.aux;
    }

    private void N(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String nX = cVar.nX();
                b.aun.put(nX, 12);
                cVar.b(nX, str, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        O(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        N(str);
        com.kwad.sdk.d xN = com.kwad.sdk.c.xL().xN();
        if (xN != null) {
            xN.bT(str);
        }
    }

    public static int dz(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aun.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void O(final String str, final String str2) {
        final e eVar = new e();
        aun.put(str, 8);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final synchronized void aX(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.b.b.Ao().b(this.aup);
            this.aum.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void c(final String str, int i10, final String str2) {
        aun.put(str, 7);
        final e eVar = new e();
        final int i11 = 0;
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i11, str2, eVar);
            }
        });
    }

    public final void dA(final String str) {
        aun.put(str, 1);
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void dB(final String str) {
        final e eVar = new e();
        aun.put(str, 4);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void dC(final String str) {
        final e eVar = new e();
        aun.put(str, 1);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void dD(final String str) {
        final e eVar = new e();
        aun.put(str, 5);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void dE(final String str) {
        final e eVar = new e();
        aun.put(str, 9);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void dF(final String str) {
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final void f(final String str, final Throwable th) {
        final e eVar = new e();
        aun.put(str, 11);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, th, eVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.xL().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                private static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.auo.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String bu = ad.bu(downloadTask.getUrl());
                    b.auo.put(url, bu);
                    return bu;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i10, int i11) {
                    b.this.a(l(downloadTask), i11 > 0 ? (int) ((i10 * 100.0f) / i11) : 0, i10, i11);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
                            com.kwad.sdk.core.e.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.dA(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.dB(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.dD(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    b.this.dC(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.dF(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.O(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th == null || th.getStackTrace().length <= 0) {
                        str = "";
                    } else {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    }
                    b.this.c(l(downloadTask), 0, str);
                }
            });
            com.kwad.sdk.b.b.Ao().a(this.aup);
            this.mHasInit = true;
        }
    }

    public final List<AdTemplate> yv() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aum) {
            for (AdTemplate adTemplate : this.aum.values()) {
                if (adTemplate != null) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    private b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aul = weakHashMap;
        this.aum = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.aup = new com.kwad.sdk.b.a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.b.a
            public final void N(String str) {
                b.this.dG(str);
            }

            @Override // com.kwad.sdk.b.a
            public final void O(String str) {
                b.this.ck(str);
            }
        };
    }

    private void b(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> h10 = this.aum.h();
        synchronized (this.aum) {
            for (c cVar : h10) {
                if (cVar != null && TextUtils.equals(str, cVar.nY())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                    }
                }
            }
        }
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.aum.put(cVar, adTemplate);
    }

    public final void a(c cVar) {
        this.aum.remove(cVar);
    }

    private void O(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String nX = cVar.nX();
                b.aun.put(nX, 0);
                cVar.f(nX, eVar);
            }
        });
    }

    public final void a(final String str, final int i10, final int i11, final int i12) {
        aun.put(str, 2);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i10, i11, i12);
            }
        });
    }

    private void a(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> h10 = this.aum.h();
        synchronized (this.aum) {
            for (c cVar : h10) {
                if (cVar != null && TextUtils.equals(cVar.nX(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                    }
                }
            }
        }
    }
}

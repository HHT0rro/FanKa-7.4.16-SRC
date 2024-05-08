package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.offline.a;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.t;
import java.util.HashMap;
import java.util.List;
import v5.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class DownloadService extends Service {

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap<Class<? extends DownloadService>, b> f21003k = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f21004b;

    /* renamed from: c, reason: collision with root package name */
    @StringRes
    public final int f21005c;

    /* renamed from: d, reason: collision with root package name */
    @StringRes
    public final int f21006d;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.exoplayer2.offline.a f21007e;

    /* renamed from: f, reason: collision with root package name */
    public int f21008f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21009g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21010h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21011i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21012j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements a.InterfaceC0192a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f21013a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.offline.a f21014b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f21015c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final d f21016d;

        /* renamed from: e, reason: collision with root package name */
        public final Class<? extends DownloadService> f21017e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public DownloadService f21018f;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(DownloadService downloadService) {
            downloadService.h(this.f21014b.c());
        }

        @Override // com.google.android.exoplayer2.offline.a.InterfaceC0192a
        public /* synthetic */ void a(com.google.android.exoplayer2.offline.a aVar, Requirements requirements, int i10) {
            u5.b.a(this, aVar, requirements, i10);
        }

        @Override // com.google.android.exoplayer2.offline.a.InterfaceC0192a
        public void b(com.google.android.exoplayer2.offline.a aVar, boolean z10) {
            if (!z10 && !aVar.d() && i()) {
                List<u5.a> c4 = aVar.c();
                int i10 = 0;
                while (true) {
                    if (i10 >= c4.size()) {
                        break;
                    }
                    if (c4.get(i10).f53824a == 0) {
                        h();
                        break;
                    }
                    i10++;
                }
            }
            j();
        }

        public void e(final DownloadService downloadService) {
            com.google.android.exoplayer2.util.a.g(this.f21018f == null);
            this.f21018f = downloadService;
            if (this.f21014b.g()) {
                j0.z().postAtFrontOfQueue(new Runnable() { // from class: u5.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        DownloadService.b.this.g(downloadService);
                    }
                });
            }
        }

        public void f(DownloadService downloadService) {
            com.google.android.exoplayer2.util.a.g(this.f21018f == downloadService);
            this.f21018f = null;
            if (this.f21016d == null || this.f21014b.h()) {
                return;
            }
            this.f21016d.cancel();
        }

        public final void h() {
            if (this.f21015c) {
                j0.P0(this.f21013a, DownloadService.e(this.f21013a, this.f21017e, "com.google.android.exoplayer.downloadService.action.RESTART"));
            } else {
                try {
                    this.f21013a.startService(DownloadService.e(this.f21013a, this.f21017e, "com.google.android.exoplayer.downloadService.action.INIT"));
                } catch (IllegalStateException unused) {
                    m.h("DownloadService", "Failed to restart DownloadService (process is idle).");
                }
            }
        }

        public final boolean i() {
            DownloadService downloadService = this.f21018f;
            return downloadService == null || downloadService.g();
        }

        public final void j() {
            if (this.f21016d == null) {
                return;
            }
            if (this.f21014b.h()) {
                String packageName = this.f21013a.getPackageName();
                if (this.f21016d.b(this.f21014b.e(), packageName, "com.google.android.exoplayer.downloadService.action.RESTART")) {
                    return;
                }
                m.c("DownloadService", "Scheduling downloads failed.");
                return;
            }
            this.f21016d.cancel();
        }

        public b(Context context, com.google.android.exoplayer2.offline.a aVar, boolean z10, @Nullable d dVar, Class<? extends DownloadService> cls) {
            this.f21013a = context;
            this.f21014b = aVar;
            this.f21015c = z10;
            this.f21016d = dVar;
            this.f21017e = cls;
            aVar.b(this);
            j();
        }
    }

    public static Intent e(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    public abstract com.google.android.exoplayer2.offline.a d();

    @Nullable
    public abstract d f();

    public final boolean g() {
        return this.f21011i;
    }

    public final void h(List<u5.a> list) {
    }

    public final void i() {
        if (j0.f22990a < 28 && this.f21010h) {
            stopSelf();
            this.f21011i = true;
        } else {
            this.f21011i |= stopSelfResult(this.f21008f);
        }
    }

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Service
    public void onCreate() {
        String str = this.f21004b;
        if (str != null) {
            t.a(this, str, this.f21005c, this.f21006d, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends DownloadService>, b> hashMap = f21003k;
        b bVar = (b) hashMap.get(cls);
        if (bVar == null) {
            com.google.android.exoplayer2.offline.a d10 = d();
            this.f21007e = d10;
            d10.n();
            bVar = new b(getApplicationContext(), this.f21007e, false, null, cls);
            hashMap.put(cls, bVar);
        } else {
            this.f21007e = bVar.f21014b;
        }
        bVar.e(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f21012j = true;
        ((b) com.google.android.exoplayer2.util.a.e(f21003k.get(getClass()))).f(this);
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i10, int i11) {
        String str;
        this.f21008f = i11;
        this.f21010h = false;
        String str2 = null;
        if (intent != null) {
            str2 = intent.getAction();
            str = intent.getStringExtra("content_id");
            this.f21009g |= intent.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(str2);
        } else {
            str = null;
        }
        if (str2 == null) {
            str2 = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        com.google.android.exoplayer2.offline.a aVar = (com.google.android.exoplayer2.offline.a) com.google.android.exoplayer2.util.a.e(this.f21007e);
        char c4 = 65535;
        switch (str2.hashCode()) {
            case -1931239035:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD")) {
                    c4 = 0;
                    break;
                }
                break;
            case -932047176:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS")) {
                    c4 = 1;
                    break;
                }
                break;
            case -871181424:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.RESTART")) {
                    c4 = 2;
                    break;
                }
                break;
            case -650547439:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS")) {
                    c4 = 3;
                    break;
                }
                break;
            case -119057172:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS")) {
                    c4 = 4;
                    break;
                }
                break;
            case 191112771:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS")) {
                    c4 = 5;
                    break;
                }
                break;
            case 671523141:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.SET_STOP_REASON")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1015676687:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.INIT")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1547520644:
                if (str2.equals("com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) com.google.android.exoplayer2.util.a.e(intent)).getParcelableExtra("download_request");
                if (downloadRequest == null) {
                    m.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                } else {
                    aVar.a(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                }
            case 1:
                aVar.n();
                break;
            case 2:
            case 7:
                break;
            case 3:
                aVar.l();
                break;
            case 4:
                Requirements requirements = (Requirements) ((Intent) com.google.android.exoplayer2.util.a.e(intent)).getParcelableExtra("requirements");
                if (requirements == null) {
                    m.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                } else {
                    d f10 = f();
                    if (f10 != null) {
                        Requirements a10 = f10.a(requirements);
                        if (!a10.equals(requirements)) {
                            int c10 = requirements.c() ^ a10.c();
                            StringBuilder sb2 = new StringBuilder(65);
                            sb2.append("Ignoring requirements not supported by the Scheduler: ");
                            sb2.append(c10);
                            m.h("DownloadService", sb2.toString());
                            requirements = a10;
                        }
                    }
                    aVar.p(requirements);
                    break;
                }
            case 5:
                aVar.k();
                break;
            case 6:
                if (!((Intent) com.google.android.exoplayer2.util.a.e(intent)).hasExtra("stop_reason")) {
                    m.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    aVar.q(str, intent.getIntExtra("stop_reason", 0));
                    break;
                }
            case '\b':
                if (str == null) {
                    m.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                } else {
                    aVar.m(str);
                    break;
                }
            default:
                m.c("DownloadService", str2.length() != 0 ? "Ignored unrecognized action: ".concat(str2) : new String("Ignored unrecognized action: "));
                break;
        }
        if (j0.f22990a >= 26) {
            boolean z10 = this.f21009g;
        }
        this.f21011i = false;
        if (aVar.f()) {
            i();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f21010h = true;
    }
}

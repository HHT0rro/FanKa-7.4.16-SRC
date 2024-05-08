package com.kwad.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static final Map<String, String> ano = new HashMap();
    private final AtomicBoolean anp;
    private final AtomicBoolean anq;
    private final AtomicBoolean anr;
    private final List<String> ans;
    private final List<String> ant;
    private final BroadcastReceiver anu;
    private Context mContext;
    private final List<com.kwad.sdk.b.a> mListeners;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final b anw = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(Context context, @NonNull String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(InstalledAppInfoManager.a(InstalledAppInfoManager.a(packageInfo, packageManager)), 1);
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    public static b Ao() {
        return a.anw;
    }

    private void Ap() {
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.b.b.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                try {
                    b.this.Ar();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                try {
                    b.this.Aq();
                    b.this.As();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq() {
        Context KO = ServiceProvider.KO();
        aH(KO);
        Iterator<AdTemplate> iterator2 = ((f) ServiceProvider.get(f.class)).yv().iterator2();
        while (iterator2.hasNext()) {
            AdInfo dQ = e.dQ(iterator2.next());
            int by = com.kwad.sdk.core.response.b.a.by(dQ);
            String ay = com.kwad.sdk.core.response.b.a.ay(dQ);
            if (by != 12) {
                if (ak.an(KO, ay)) {
                    y(KO, ay);
                }
            } else if (!ak.an(KO, ay)) {
                ck(ay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar() {
        if (this.anr.get()) {
            ServiceProvider.KO().unregisterReceiver(this.anu);
            this.anr.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As() {
        if (this.anr.get()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        ServiceProvider.KO().registerReceiver(this.anu, intentFilter);
        this.anr.set(true);
    }

    private static void B(Context context, String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    c4 = 0;
                    break;
                }
                break;
            case 473713875:
                if (str.equals("com.kuaishou.nebula")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1659293491:
                if (str.equals("com.smile.gifmaker")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                ano.put("com.tencent.mm", k.M(context, "com.tencent.mm"));
                return;
            case 1:
                ano.put("com.kuaishou.nebula", k.M(context, "com.kuaishou.nebula"));
                return;
            case 2:
                ano.put("com.smile.gifmaker", k.M(context, "com.smile.gifmaker"));
                return;
            default:
                return;
        }
    }

    private synchronized void aG(Context context) {
        if (this.anp.get()) {
            return;
        }
        B(context, "com.smile.gifmaker");
        B(context, "com.kuaishou.nebula");
        B(context, "com.tencent.mm");
        this.anp.set(true);
    }

    private void aH(Context context) {
        if (this.anp.get()) {
            for (String str : ano.h()) {
                String str2 = ano.get(str);
                String M = k.M(context, str);
                if (!TextUtils.isEmpty(M) && !Objects.equals(str2, M)) {
                    y(context, str);
                } else if (TextUtils.isEmpty(M) && !TextUtils.isEmpty(str2)) {
                    ck(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(@NonNull String str) {
        c.d("AppInstallManager", "unInstallApp packageName: " + str);
        cp(str);
        co(str);
        cl(str);
    }

    private void cl(String str) {
        com.kwad.sdk.core.c.b.DD();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            cm(str);
            return;
        }
        this.ant.add(str);
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.b.b.4
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.ant.size() > 0) {
                    for (int i10 = 0; i10 < b.this.ant.size(); i10++) {
                        b.cm((String) b.this.ant.get(i10));
                    }
                    b.this.ant.clear();
                }
                com.kwad.sdk.core.c.b.DD();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cm(@NonNull String str) {
        try {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = str;
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).e(InstalledAppInfoManager.a(appPackageInfo), 2);
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private void cn(String str) {
        Iterator<com.kwad.sdk.b.a> iterator2 = this.mListeners.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().N(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private void co(String str) {
        Iterator<com.kwad.sdk.b.a> iterator2 = this.mListeners.iterator2();
        while (iterator2.hasNext()) {
            try {
                iterator2.next().O(str);
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    private static void cp(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    c4 = 0;
                    break;
                }
                break;
            case 473713875:
                if (str.equals("com.kuaishou.nebula")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1659293491:
                if (str.equals("com.smile.gifmaker")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                ano.put("com.tencent.mm", "");
                return;
            case 1:
                ano.put("com.kuaishou.nebula", "");
                return;
            case 2:
                ano.put("com.smile.gifmaker", "");
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Context context, @NonNull String str) {
        c.d("AppInstallManager", "installApp packageName: " + str);
        B(context, str);
        cn(str);
        z(context, str);
    }

    private void z(Context context, String str) {
        com.kwad.sdk.core.c.b.DD();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            A(context, str);
            return;
        }
        this.ans.add(str);
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new d() { // from class: com.kwad.sdk.b.b.3
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                if (b.this.ans.size() > 0) {
                    for (int i10 = 0; i10 < b.this.ans.size(); i10++) {
                        b.A(b.this.mContext, (String) b.this.ans.get(i10));
                    }
                    b.this.ans.clear();
                }
                com.kwad.sdk.core.c.b.DD();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    public final synchronized void checkInit() {
        try {
            if (this.anq.get()) {
                return;
            }
            if (((h) ServiceProvider.get(h.class)).yX()) {
                com.kwad.sdk.core.c.b.DD();
                if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                    As();
                }
                Ap();
            } else {
                As();
            }
            this.anq.set(true);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        aG(context);
        return ano.get(str);
    }

    private b() {
        this.anp = new AtomicBoolean();
        this.anq = new AtomicBoolean();
        this.anr = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.ans = new CopyOnWriteArrayList();
        this.ant = new CopyOnWriteArrayList();
        this.anu = new BroadcastReceiver() { // from class: com.kwad.sdk.b.b.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    b.this.mContext = context;
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        b.this.y(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        b.this.ck(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    c.printStackTrace(th);
                }
            }
        };
    }

    public final void b(com.kwad.sdk.b.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.remove(aVar);
    }

    public final void a(com.kwad.sdk.b.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.add(aVar);
    }
}

package com.kwad.sdk.a.a;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bk;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    private static volatile b alt;
    private Stack<AdTemplate> alr = new Stack<>();
    private File als;
    private boolean mHasInit;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void go();

        void zL();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aG(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        boolean z10 = false;
        Iterator<AdTemplate> it = this.alr.iterator2();
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.ea(it.next()) == com.kwad.sdk.core.response.b.e.ea(adTemplate)) {
                it.remove();
                z10 = true;
            }
        }
        if (z10) {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.als));
            } catch (Exception e10) {
                objectOutputStream = null;
                e2 = e10;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.alr);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e2 = e11;
                com.kwad.sdk.core.e.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + ((Object) e2));
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aH(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        this.alr.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(zI()));
        } catch (Exception e10) {
            objectOutputStream = null;
            e2 = e10;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(this.alr);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e11) {
            e2 = e11;
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File aK(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
        if (q.L(file)) {
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File zI() {
        File file = this.als;
        if (file != null) {
            return file;
        }
        String cO = aw.cO(ServiceProvider.getContext());
        File file2 = new File(cO);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(cO + File.separator + "uninstall_ad");
        this.als = file3;
        if (!file3.exists()) {
            try {
                this.als.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.als;
    }

    public static b zJ() {
        if (alt == null) {
            synchronized (b.class) {
                if (alt == null) {
                    alt = new b();
                }
            }
        }
        return alt;
    }

    public final void aI(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new ay() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.aH(adTemplate);
            }
        });
    }

    public final void aJ(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new ay() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.aG(adTemplate);
            }
        });
    }

    public final synchronized AdTemplate zK() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.alr.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = com.kwad.sdk.core.response.b.e.dQ(adTemplate2).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File aK = aK(adTemplate2);
                if (aK != null && aK.exists() && aK.lastModified() + bk.f9895d > System.currentTimeMillis() && !ak.an(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        g.execute(new ay() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0115 A[Catch: all -> 0x0123, TryCatch #0 {all -> 0x0123, blocks: (B:3:0x0002, B:7:0x0009, B:10:0x0010, B:48:0x00b4, B:54:0x00f0, B:55:0x0111, B:57:0x0115, B:72:0x0119, B:73:0x011c, B:66:0x010a, B:69:0x010e, B:80:0x00d9, B:85:0x011f, B:86:0x0122), top: B:2:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
            @Override // com.kwad.sdk.utils.ay
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 296
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.b.AnonymousClass1.doTask():void");
            }
        });
    }
}

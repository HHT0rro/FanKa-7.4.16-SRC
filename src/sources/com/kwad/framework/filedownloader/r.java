package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class r {
    private static final Object afb = new Object();
    private static final Object afd = new Object();
    private w afc;
    private volatile v afe;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final r aff = new r();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context != null) {
            com.kwad.framework.filedownloader.f.c.am(context.getApplicationContext());
            com.kwad.framework.filedownloader.download.b.vo().a(bVar);
            return;
        }
        throw new IllegalArgumentException("the provided context must not be null!");
    }

    public static void al(Context context) {
        com.kwad.framework.filedownloader.f.c.am(context.getApplicationContext());
    }

    public static com.kwad.framework.filedownloader.a bc(String str) {
        return new c(str);
    }

    private int bg(int i10) {
        List<a.InterfaceC0494a> bb2 = h.uB().bb(i10);
        if (bb2.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i10));
            return 0;
        }
        Iterator<a.InterfaceC0494a> iterator2 = bb2.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().ud().pause();
        }
        return bb2.size();
    }

    public static r uU() {
        return a.aff;
    }

    public static boolean uW() {
        return n.uM().isConnected();
    }

    public final boolean n(int i10, String str) {
        bg(i10);
        if (!n.uM().bf(i10)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(com.kwad.framework.filedownloader.f.f.bt(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }

    public final void uV() {
        if (uW()) {
            return;
        }
        n.uM().ak(com.kwad.framework.filedownloader.f.c.wL());
    }

    public final w uX() {
        if (this.afc == null) {
            synchronized (afb) {
                if (this.afc == null) {
                    this.afc = new ab();
                }
            }
        }
        return this.afc;
    }

    public final v uY() {
        if (this.afe == null) {
            synchronized (afd) {
                if (this.afe == null) {
                    this.afe = new z();
                    a((e) this.afe);
                }
            }
        }
        return this.afe;
    }

    private static void a(e eVar) {
        f.uz().a("event.service.connect.changed", eVar);
    }
}

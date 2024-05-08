package com.kwad.sdk.core.response.b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    private static volatile f azT;
    private String azU = Fk();

    private f() {
    }

    public static f Fi() {
        if (azT == null) {
            synchronized (f.class) {
                if (azT == null) {
                    azT = new f();
                }
            }
        }
        return azT;
    }

    @Nullable
    @WorkerThread
    private static String Fk() {
        try {
            return q.a(new File(aw.cP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return null;
        }
    }

    @WorkerThread
    private static void er(String str) {
        try {
            q.a(new File(aw.cP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
        }
    }

    @Nullable
    @WorkerThread
    public final String Fj() {
        return this.azU;
    }

    @WorkerThread
    public final void eq(String str) {
        if (bg.isEquals(this.azU, str)) {
            return;
        }
        this.azU = str;
        er(str);
    }
}

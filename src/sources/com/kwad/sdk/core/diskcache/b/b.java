package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        g.execute(new ay() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    a.C0519a dp = com.kwad.sdk.core.diskcache.a.a.this.dp(str2);
                    if (dp != null) {
                        outputStream = dp.cZ(0);
                        if (b.a(str, outputStream, new a.C0527a())) {
                            dp.commit();
                        } else {
                            dp.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                }
            }
        });
    }

    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) {
        a.c cVar;
        a.c cVar2 = null;
        try {
            cVar = aVar.m2863do(str);
            if (cVar != null) {
                try {
                    File dc2 = cVar.dc(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    return dc2;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar2 = cVar;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
        return null;
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0527a c0527a) {
        boolean z10 = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0519a dp = aVar.dp(str2);
                if (dp != null) {
                    outputStream = dp.cZ(0);
                    if (a(str, outputStream, c0527a)) {
                        dp.commit();
                        z10 = true;
                    } else {
                        dp.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e2) {
                c0527a.msg = e2.getMessage();
            }
            return z10;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0527a c0527a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0527a, -1L, null);
    }
}

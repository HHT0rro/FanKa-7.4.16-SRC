package com.kwad.framework.filedownloader.f;

import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static Context aik;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        int O(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        com.kwad.framework.filedownloader.a.b be(String str);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0500c {
        com.kwad.framework.filedownloader.b.a wM();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface d {
        int f(String str, String str2, boolean z10);

        int g(String str, String str2, boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static boolean a(int i10, String str, boolean z10, boolean z11) {
        if (!z10 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(i10, file, z11));
                return true;
            }
        }
        return false;
    }

    public static void am(Context context) {
        aik = context;
    }

    public static Context wL() {
        return aik;
    }

    public static boolean a(int i10, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z10) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(i10, cVar.wl(), cVar.getTotal(), z10));
        return true;
    }

    public static boolean a(int i10, long j10, String str, String str2, y yVar) {
        int p10;
        if (str2 == null || str == null || (p10 = yVar.p(str, i10)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(i10, j10, new PathConflictException(p10, str, str2)));
        return true;
    }
}

package pc;

import android.content.Context;
import java.io.File;

/* compiled from: ReLinker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* compiled from: ReLinker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, pc.c cVar);
    }

    /* compiled from: ReLinker.java */
    /* renamed from: pc.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface InterfaceC0807b {
        void a(String str);

        String[] a();

        String b(String str);

        void c(String str);

        String d(String str);
    }

    /* compiled from: ReLinker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface c {
        void a();

        void a(Throwable th);
    }

    /* compiled from: ReLinker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface d {
        void a(String str);
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, c cVar) {
        new pc.c().d(context, str, str2, cVar);
    }
}

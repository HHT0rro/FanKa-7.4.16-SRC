package pc;

import android.content.Context;
import android.util.Log;
import com.android.internal.content.NativeLibraryHelper;
import com.jifen.open.lib.relinkerx.MissingLibraryException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import pc.b;
import qc.i;

/* compiled from: ReLinkerInstance.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Set<String> f52981a;

    /* renamed from: b, reason: collision with root package name */
    public final b.InterfaceC0807b f52982b;

    /* renamed from: c, reason: collision with root package name */
    public final b.a f52983c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f52984d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f52985e;

    /* renamed from: f, reason: collision with root package name */
    public b.d f52986f;

    /* compiled from: ReLinkerInstance.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f52987b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f52988c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f52989d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b.c f52990e;

        public a(Context context, String str, String str2, b.c cVar) {
            this.f52987b = context;
            this.f52988c = str;
            this.f52989d = str2;
            this.f52990e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.this.i(this.f52987b, this.f52988c, this.f52989d);
                this.f52990e.a();
            } catch (MissingLibraryException e2) {
                this.f52990e.a(e2);
            } catch (UnsatisfiedLinkError e10) {
                this.f52990e.a(e10);
            }
        }
    }

    /* compiled from: ReLinkerInstance.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b implements FilenameFilter {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f52992b;

        public b(String str) {
            this.f52992b = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f52992b);
        }
    }

    public c() {
        this(new d(), new pc.a());
    }

    public File a(Context context) {
        return context.getDir(NativeLibraryHelper.LIB_DIR_NAME, 0);
    }

    public void b(Context context, String str) {
        d(context, str, null, null);
    }

    public void c(Context context, String str, String str2) {
        File a10 = a(context);
        File h10 = h(context, str, str2);
        File[] listFiles = a10.listFiles(new b(this.f52982b.d(str)));
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f52984d || !file.getAbsolutePath().equals(h10.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public void d(Context context, String str, String str2, b.c cVar) {
        if (context != null) {
            if (!e.a(str)) {
                f("Beginning load of %s...", str);
                if (cVar == null) {
                    i(context, str, str2);
                    return;
                } else {
                    new Thread(new a(context, str, str2, cVar)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public void e(String str) {
        b.d dVar = this.f52986f;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void f(String str, Object... objArr) {
        e(String.format(Locale.US, str, objArr));
    }

    public File h(Context context, String str, String str2) {
        String d10 = this.f52982b.d(str);
        if (e.a(str2)) {
            return new File(a(context), d10);
        }
        return new File(a(context), d10 + "." + str2);
    }

    public final void i(Context context, String str, String str2) {
        i iVar;
        if (this.f52981a.contains(str) && !this.f52984d) {
            f("%s already loaded previously!", str);
            return;
        }
        try {
            this.f52982b.a(str);
            this.f52981a.add(str);
            f("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e2) {
            f("Loading the library normally failed: %s", Log.getStackTraceString(e2));
            f("%s (%s) was not loaded normally, re-linking...", str, str2);
            File h10 = h(context, str, str2);
            if (!h10.exists() || this.f52984d) {
                if (this.f52984d) {
                    f("Forcing a re-link of %s (%s)...", str, str2);
                }
                c(context, str, str2);
                this.f52983c.a(context, this.f52982b.a(), this.f52982b.d(str), h10, this);
            }
            try {
                if (this.f52985e) {
                    i iVar2 = null;
                    try {
                        iVar = new i(h10);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List<String> g3 = iVar.g();
                        iVar.close();
                        Iterator<String> iterator2 = g3.iterator2();
                        while (iterator2.hasNext()) {
                            b(context, this.f52982b.b(iterator2.next()));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        iVar2 = iVar;
                        iVar2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f52982b.c(h10.getAbsolutePath());
            this.f52981a.add(str);
            f("%s (%s) was re-linked!", str, str2);
        }
    }

    public c(b.InterfaceC0807b interfaceC0807b, b.a aVar) {
        this.f52981a = new HashSet();
        if (interfaceC0807b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar != null) {
            this.f52982b = interfaceC0807b;
            this.f52983c = aVar;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }
}

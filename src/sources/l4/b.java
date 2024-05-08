package l4;

import android.content.Context;
import com.github.sahasbhop.flog.FLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ApngImageDownloader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b extends com.nostra13.universalimageloader.core.download.a {

    /* renamed from: d, reason: collision with root package name */
    public Context f51608d;

    /* renamed from: e, reason: collision with root package name */
    public ExecutorService f51609e;

    /* compiled from: ApngImageDownloader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Callable<InputStream> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f51610b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InputStream f51611c;

        public a(String str, InputStream inputStream) {
            this.f51610b = str;
            this.f51611c = inputStream;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream call() throws Exception {
            return b.this.n(this.f51610b, this.f51611c);
        }
    }

    /* compiled from: ApngImageDownloader.java */
    /* renamed from: l4.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class CallableC0786b implements Callable<InputStream> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f51613b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InputStream f51614c;

        public CallableC0786b(String str, InputStream inputStream) {
            this.f51613b = str;
            this.f51614c = inputStream;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream call() throws Exception {
            return b.this.n(this.f51613b, this.f51614c);
        }
    }

    /* compiled from: ApngImageDownloader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements Callable<InputStream> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f51616b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InputStream f51617c;

        public c(String str, InputStream inputStream) {
            this.f51616b = str;
            this.f51617c = inputStream;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream call() throws Exception {
            return b.this.n(this.f51616b, this.f51617c);
        }
    }

    public b(Context context) {
        super(context);
        this.f51608d = context;
        this.f51609e = Executors.newSingleThreadExecutor();
    }

    @Override // com.nostra13.universalimageloader.core.download.a
    public InputStream c(String str, Object obj) throws IOException {
        try {
            return (InputStream) this.f51609e.submit(new CallableC0786b(str, super.c(str, obj))).get();
        } catch (Exception e2) {
            if (k4.b.f50646g) {
                FLog.h("Error: %s", e2.toString());
            }
            return null;
        }
    }

    @Override // com.nostra13.universalimageloader.core.download.a
    public InputStream f(String str, Object obj) throws IOException {
        try {
            return (InputStream) this.f51609e.submit(new a(str, super.f(str, obj))).get();
        } catch (Exception e2) {
            if (k4.b.f50646g) {
                FLog.h("Error: %s", e2.toString());
            }
            return null;
        }
    }

    @Override // com.nostra13.universalimageloader.core.download.a
    public InputStream g(String str, Object obj) throws IOException {
        try {
            return (InputStream) this.f51609e.submit(new c(str, super.g(str, obj))).get();
        } catch (Exception e2) {
            if (k4.b.f50646g) {
                FLog.h("Error: %s", e2.toString());
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.InputStream n(java.lang.String r6, java.io.InputStream r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L9d
            if (r7 != 0) goto L6
            goto L9d
        L6:
            r0 = 1
            r1 = 0
            android.net.Uri r2 = android.net.Uri.parse(r6)     // Catch: java.lang.Exception -> L1c
            java.lang.String r2 = r2.getPath()     // Catch: java.lang.Exception -> L1c
            if (r2 == 0) goto L1c
            java.lang.String r3 = ".png"
            boolean r2 = r2.endsWith(r3)     // Catch: java.lang.Exception -> L1c
            if (r2 == 0) goto L1c
            r2 = 1
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 != 0) goto L20
            return r7
        L20:
            android.content.Context r2 = r5.f51608d
            java.io.File r2 = l4.f.f(r2)
            r3 = 0
            l4.f.b(r2, r3)
            android.content.Context r2 = r5.f51608d
            java.io.File r2 = l4.f.d(r2, r6)
            if (r2 != 0) goto L41
            boolean r2 = k4.b.f50646g
            if (r2 == 0) goto L9d
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r6
            java.lang.String r6 = "Can't copy a file!!! %s"
            com.github.sahasbhop.flog.FLog.h(r6, r0)
            goto L9d
        L41:
            boolean r3 = r2.exists()
            if (r3 != 0) goto L9d
            boolean r3 = k4.b.f50645f
            if (r3 == 0) goto L5b
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r1] = r6
            java.lang.String r4 = r2.getPath()
            r3[r0] = r4
            java.lang.String r4 = "Copy\nfrom: %s\nto: %s"
            com.github.sahasbhop.flog.FLog.g(r4, r3)
        L5b:
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Exception -> L64 java.net.MalformedURLException -> L66
            r3.<init>(r6)     // Catch: java.lang.Exception -> L64 java.net.MalformedURLException -> L66
            org.apache.commons.io.FileUtils.copyURLToFile(r3, r2)     // Catch: java.lang.Exception -> L64 java.net.MalformedURLException -> L66
            goto L69
        L64:
            r6 = move-exception
            goto L8c
        L66:
            org.apache.commons.io.FileUtils.copyInputStreamToFile(r7, r2)     // Catch: java.lang.Exception -> L64
        L69:
            boolean r6 = k4.b.f50645f     // Catch: java.lang.Exception -> L64
            if (r6 == 0) goto L74
            java.lang.String r6 = "Copy finished"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L64
            com.github.sahasbhop.flog.FLog.g(r6, r3)     // Catch: java.lang.Exception -> L64
        L74:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L64
            r6.<init>(r2)     // Catch: java.lang.Exception -> L64
            jb.a r2 = new jb.a     // Catch: java.lang.Exception -> L64
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L64
            r4 = 32768(0x8000, float:4.5918E-41)
            r3.<init>(r6, r4)     // Catch: java.lang.Exception -> L64
            int r6 = r6.available()     // Catch: java.lang.Exception -> L64
            r2.<init>(r3, r6)     // Catch: java.lang.Exception -> L64
            r7 = r2
            goto L9d
        L8c:
            boolean r2 = k4.b.f50646g
            if (r2 == 0) goto L9d
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r6 = r6.toString()
            r0[r1] = r6
            java.lang.String r6 = "Error: %s"
            com.github.sahasbhop.flog.FLog.h(r6, r0)
        L9d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.b.n(java.lang.String, java.io.InputStream):java.io.InputStream");
    }
}

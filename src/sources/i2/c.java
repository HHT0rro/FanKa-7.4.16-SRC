package i2;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

/* compiled from: UnzipTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<a> f49711a;

    /* compiled from: UnzipTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();

        void b(boolean z10);

        Context getContext();
    }

    public c(a aVar) {
        this.f49711a = new WeakReference<>(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
    
        if (r7 == 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        if (r7 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        q2.a.b(r0.getContext().getAssets(), r13, r6, r3.i());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
    
        q2.a.c(r0.getContext().getAssets(), r13, r6, r3.f());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0097, code lost:
    
        q2.a.c(r0.getContext().getAssets(), r13, r6, r3.a());
     */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Boolean doInBackground(java.lang.String... r13) {
        /*
            r12 = this;
            java.lang.ref.WeakReference<i2.c$a> r0 = r12.f49711a
            java.lang.Object r0 = r0.get()
            i2.c$a r0 = (i2.c.a) r0
            if (r0 != 0) goto Ld
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            return r13
        Ld:
            r1 = 0
            r13 = r13[r1]
            android.content.Context r2 = r0.getContext()
            java.lang.String r3 = "assets"
            java.io.File r2 = r2.getExternalFilesDir(r3)
            java.io.File r3 = new java.io.File
            r3.<init>(r2, r13)
            q2.a.a(r3)
            android.content.Context r2 = r0.getContext()     // Catch: java.lang.Exception -> Lac
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Exception -> Lac
            l2.b r3 = new l2.b     // Catch: java.lang.Exception -> Lac
            android.content.Context r4 = r0.getContext()     // Catch: java.lang.Exception -> Lac
            r3.<init>(r4)     // Catch: java.lang.Exception -> Lac
            java.lang.String[] r2 = r2.list(r13)     // Catch: java.lang.Exception -> Lac
            int r4 = r2.length     // Catch: java.lang.Exception -> Lac
            r5 = 0
        L39:
            if (r5 >= r4) goto La9
            r6 = r2[r5]     // Catch: java.lang.Exception -> Lac
            r7 = -1
            int r8 = r6.hashCode()     // Catch: java.lang.Exception -> Lac
            r9 = -1169454923(0xffffffffba4b88b5, float:-7.7642064E-4)
            r10 = 2
            r11 = 1
            if (r8 == r9) goto L68
            r9 = 1418272793(0x54892019, float:4.7115922E12)
            if (r8 == r9) goto L5e
            r9 = 2043577354(0x79ce840a, float:1.340364E35)
            if (r8 == r9) goto L54
            goto L71
        L54:
            java.lang.String r8 = "3DModelResource.bundle"
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Exception -> Lac
            if (r8 == 0) goto L71
            r7 = 0
            goto L71
        L5e:
            java.lang.String r8 = "ModelResource.bundle"
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Exception -> Lac
            if (r8 == 0) goto L71
            r7 = 1
            goto L71
        L68:
            java.lang.String r8 = "ComposeMakeup.bundle"
            boolean r8 = r6.equals(r8)     // Catch: java.lang.Exception -> Lac
            if (r8 == 0) goto L71
            r7 = 2
        L71:
            if (r7 == 0) goto La6
            if (r7 == r11) goto L97
            if (r7 == r10) goto L87
            android.content.Context r7 = r0.getContext()     // Catch: java.lang.Exception -> Lac
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Exception -> Lac
            java.lang.String r8 = r3.i()     // Catch: java.lang.Exception -> Lac
            q2.a.b(r7, r13, r6, r8)     // Catch: java.lang.Exception -> Lac
            goto La6
        L87:
            android.content.Context r7 = r0.getContext()     // Catch: java.lang.Exception -> Lac
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Exception -> Lac
            java.lang.String r8 = r3.f()     // Catch: java.lang.Exception -> Lac
            q2.a.c(r7, r13, r6, r8)     // Catch: java.lang.Exception -> Lac
            goto La6
        L97:
            android.content.Context r7 = r0.getContext()     // Catch: java.lang.Exception -> Lac
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Exception -> Lac
            java.lang.String r8 = r3.a()     // Catch: java.lang.Exception -> Lac
            q2.a.c(r7, r13, r6, r8)     // Catch: java.lang.Exception -> Lac
        La6:
            int r5 = r5 + 1
            goto L39
        La9:
            java.lang.Boolean r13 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> Lac
            return r13
        Lac:
            r13 = move-exception
            r13.printStackTrace()
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.doInBackground(java.lang.String[]):java.lang.Boolean");
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        a aVar = this.f49711a.get();
        if (aVar == null) {
            return;
        }
        aVar.b(bool.booleanValue());
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        a aVar = this.f49711a.get();
        if (aVar == null) {
            return;
        }
        aVar.a();
        super.onPreExecute();
    }
}

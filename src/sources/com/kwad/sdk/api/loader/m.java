package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.huawei.quickcard.base.Attributes;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.f;
import java.io.File;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class m {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a<T> implements c<T> {
        public c<T> amJ;

        public a(c<T> cVar) {
            this.amJ = cVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b implements f<a.C0509a> {
        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0509a> cVar) {
            try {
                new com.kwad.sdk.api.loader.f(vVar).a(new f.a() { // from class: com.kwad.sdk.api.loader.m.b.1
                    @Override // com.kwad.sdk.api.loader.f.a
                    @WorkerThread
                    public final void a(a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.Ac()) {
                            cVar.g(bVar.ama);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.d.ay(vVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c<T> {
        void g(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d implements f<a.C0509a> {
        public f<a.C0509a> amN;

        public d(f<a.C0509a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0509a> cVar) {
            this.amN.a(vVar, new a<a.C0509a>(cVar) { // from class: com.kwad.sdk.api.loader.m.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                @WorkerThread
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void g(@NonNull a.C0509a c0509a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        j.a(c0509a);
                        file = com.kwad.sdk.api.loader.h.p(vVar.getContext(), c0509a.sdkVersion);
                        i.c(c0509a.alX, file);
                        j.a(c0509a, System.currentTimeMillis() - currentTimeMillis);
                        c0509a.alY = file;
                        cVar.g(c0509a);
                    } catch (Throwable th) {
                        j.a(c0509a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        com.kwad.sdk.api.loader.h.j(file);
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e implements f<Boolean> {
        public f<a.C0509a> amN;

        public e(f<a.C0509a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<Boolean> cVar) {
            this.amN.a(vVar, new c<a.C0509a>() { // from class: com.kwad.sdk.api.loader.m.e.1
                private void a(a.C0509a c0509a, int i10, Throwable th) {
                    com.kwad.sdk.api.loader.h.j(c0509a.alY);
                    j.b(c0509a, i10, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void g(@NonNull a.C0509a c0509a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j.b(c0509a);
                        if (!com.kwad.sdk.api.loader.b.a(vVar.getContext(), AnonymousClass1.class.getClassLoader(), c0509a.alY.getPath(), c0509a.sdkVersion)) {
                            a(c0509a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        com.kwad.sdk.api.loader.g.n(vVar.getContext(), c0509a.sdkVersion);
                        com.kwad.sdk.api.loader.h.j(c0509a.alY);
                        j.b(c0509a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.g(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0509a, 2, th);
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface f<T> {
        void a(v vVar, c<T> cVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g implements f<a.C0509a> {
        public f<a.C0509a> amN;

        public g(f<a.C0509a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(v vVar, final c<a.C0509a> cVar) {
            this.amN.a(vVar, new a<a.C0509a>(cVar) { // from class: com.kwad.sdk.api.loader.m.g.1
                private void a(a.C0509a c0509a, int i10, Throwable th) {
                    com.kwad.sdk.api.loader.h.j(c0509a.alY);
                    j.a(c0509a, i10, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void g(@NonNull a.C0509a c0509a) {
                    try {
                        File file = c0509a.alY;
                        if (!r.k(file)) {
                            a(c0509a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (!r.a(file, c0509a.md5)) {
                            a(c0509a, 2, new RuntimeException("Security checkMd5 fail"));
                        } else {
                            cVar.g(c0509a);
                        }
                    } catch (Throwable th) {
                        a(c0509a, 3, th);
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class h implements f<a.C0509a> {
        public f<a.C0509a> amN;

        public h(f<a.C0509a> fVar) {
            this.amN = fVar;
        }

        @Override // com.kwad.sdk.api.loader.m.f
        public final void a(final v vVar, final c<a.C0509a> cVar) {
            this.amN.a(vVar, new c<a.C0509a>() { // from class: com.kwad.sdk.api.loader.m.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.m.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void g(a.C0509a c0509a) {
                    String az = com.kwad.sdk.api.loader.g.az(vVar.getContext());
                    if (TextUtils.isEmpty(az)) {
                        az = com.kwad.sdk.api.c.zV().getSDKVersion();
                    }
                    String str = c0509a.sdkVersion;
                    t.a(vVar.getContext(), Attributes.Style.INTERVAL, c0509a.interval);
                    t.a(vVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0509a.Ab()) {
                        u.aF(vVar.getContext());
                        new RuntimeException("DynamicType == -1, curVersion: " + az);
                        return;
                    }
                    if (com.kwad.sdk.api.loader.g.K(c0509a.sdkVersion, az) && c0509a.Aa()) {
                        cVar.g(c0509a);
                        return;
                    }
                    new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0509a.sdkVersion + " currentDynamicVersion:" + az + " dynamicType:" + c0509a.alW);
                }
            });
        }
    }

    public static f<Boolean> Aj() {
        return new e(new g(new d(new h(new b()))));
    }
}

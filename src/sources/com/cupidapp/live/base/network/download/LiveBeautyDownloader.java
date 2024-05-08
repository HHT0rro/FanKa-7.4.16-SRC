package com.cupidapp.live.base.network.download;

import android.content.Context;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.LiveBeautyDownloader;
import com.cupidapp.live.base.network.download.b;
import com.cupidapp.live.base.utils.t0;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.liveshow.model.LiveBeautyResourceModel;
import com.cupidapp.live.liveshow.model.LiveBeautyResourceResult;
import com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel;
import com.huawei.quickcard.framework.QuickCardField;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;

/* compiled from: LiveBeautyDownloader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveBeautyDownloader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LiveBeautyDownloader f11939a = new LiveBeautyDownloader();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f11940b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static a f11941c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f11942d;

    /* compiled from: LiveBeautyDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void onError();

        void onFinish();

        void onSuccess();
    }

    /* compiled from: LiveBeautyDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b<V> implements Callable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f11943b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveBeautyResourceResult f11944c;

        public b(boolean z10, LiveBeautyResourceResult liveBeautyResourceResult) {
            this.f11943b = z10;
            this.f11944c = liveBeautyResourceResult;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<String> call() {
            List resources;
            ArrayList arrayList = new ArrayList();
            File s2 = z0.k.f54819a.s(AppApplication.f11612d.c());
            if (s2 == null) {
                return arrayList;
            }
            if (!s2.exists() && !s2.mkdirs()) {
                return arrayList;
            }
            p1.g gVar = p1.g.f52734a;
            if (gVar.Q().c() == null) {
                gVar.Q().d(new LiveBeautyResourceSaveModel(new LinkedHashMap()));
            }
            if (this.f11943b) {
                List<LiveBeautyResourceModel> resources2 = this.f11944c.getResources();
                if (resources2 != null) {
                    resources = new ArrayList();
                    for (LiveBeautyResourceModel liveBeautyResourceModel : resources2) {
                        if (s.d(liveBeautyResourceModel.getName(), "AndroidBeautyLicense.bundle")) {
                            resources.add(liveBeautyResourceModel);
                        }
                    }
                } else {
                    resources = null;
                }
            } else {
                resources = this.f11944c.getResources();
            }
            LiveBeautyDownloader liveBeautyDownloader = LiveBeautyDownloader.f11939a;
            liveBeautyDownloader.n(resources, s2);
            liveBeautyDownloader.s(resources, s2, arrayList);
            return arrayList;
        }
    }

    /* compiled from: LiveBeautyDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<LiveBeautyResourceModel> f11945a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f11946b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ File f11947c;

        public c(List<LiveBeautyResourceModel> list, AtomicInteger atomicInteger, File file) {
            this.f11945a = list;
            this.f11946b = atomicInteger;
            this.f11947c = file;
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onFailure(@NotNull String url) {
            s.i(url, "url");
            LiveBeautyDownloader.f11939a.o();
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onSuccess(@NotNull String url, @NotNull String localPath) {
            s.i(url, "url");
            s.i(localPath, "localPath");
            List<LiveBeautyResourceModel> list = this.f11945a;
            if (list != null) {
                File file = this.f11947c;
                AtomicInteger atomicInteger = this.f11946b;
                for (LiveBeautyResourceModel liveBeautyResourceModel : list) {
                    String name = liveBeautyResourceModel.getName();
                    String url2 = liveBeautyResourceModel.getUrl();
                    if (!(url2 == null || url2.length() == 0)) {
                        if (!(name == null || name.length() == 0) && s.d(url2, url)) {
                            File file2 = new File(file, l1.a.e(url2));
                            t0 t0Var = t0.f12378a;
                            String path = file2.getPath();
                            s.h(path, "unzipFolder.path");
                            t0.b(t0Var, localPath, path, false, 4, null);
                            p1.g gVar = p1.g.f52734a;
                            LiveBeautyResourceSaveModel c4 = gVar.Q().c();
                            Map<String, String> resources = c4 != null ? c4.getResources() : null;
                            if (resources != null) {
                                String path2 = file2.getPath();
                                s.h(path2, "unzipFolder.path");
                                resources.put(name, path2);
                            }
                            gVar.Q().d(new LiveBeautyResourceSaveModel(resources));
                            atomicInteger.decrementAndGet();
                        }
                    }
                }
            }
            if (this.f11946b.get() == 0) {
                LiveBeautyDownloader.f11939a.q();
            }
        }
    }

    /* compiled from: LiveBeautyDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements Consumer {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f11948b;

        public d(Function1 function) {
            s.i(function, "function");
            this.f11948b = function;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object obj) {
            this.f11948b.invoke(obj);
        }
    }

    public static final void p() {
        f11940b = false;
        a aVar = f11941c;
        if (aVar != null) {
            aVar.onError();
        }
    }

    public static final void r() {
        f11940b = false;
        a aVar = f11941c;
        if (aVar != null) {
            aVar.onSuccess();
        }
    }

    public final void k(@NotNull final com.cupidapp.live.base.network.g disposable, final boolean z10, @NotNull a listener) {
        s.i(disposable, "disposable");
        s.i(listener, "listener");
        f11941c = listener;
        f11942d = false;
        Disposable disposed = NetworkClient.f11868a.r().i0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveBeautyResourceResult, p>() { // from class: com.cupidapp.live.base.network.download.LiveBeautyDownloader$checkResources$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveBeautyResourceResult liveBeautyResourceResult) {
                m2462invoke(liveBeautyResourceResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2462invoke(LiveBeautyResourceResult liveBeautyResourceResult) {
                final LiveBeautyResourceResult liveBeautyResourceResult2 = liveBeautyResourceResult;
                com.cupidapp.live.base.network.g gVar = com.cupidapp.live.base.network.g.this;
                Disposable subscribe = Observable.fromCallable(new LiveBeautyDownloader.b(z10, liveBeautyResourceResult2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LiveBeautyDownloader.d(new Function1<List<String>, p>() { // from class: com.cupidapp.live.base.network.download.LiveBeautyDownloader$checkResources$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(List<String> list) {
                        invoke2(list);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<String> downloadUrls) {
                        boolean z11;
                        LiveBeautyDownloader.a aVar;
                        if (downloadUrls.isEmpty()) {
                            aVar = LiveBeautyDownloader.f11941c;
                            if (aVar != null) {
                                aVar.onFinish();
                                return;
                            }
                            return;
                        }
                        z11 = LiveBeautyDownloader.f11940b;
                        if (z11) {
                            return;
                        }
                        LiveBeautyDownloader liveBeautyDownloader = LiveBeautyDownloader.f11939a;
                        LiveBeautyDownloader.f11940b = true;
                        List<LiveBeautyResourceModel> resources = LiveBeautyResourceResult.this.getResources();
                        s.h(downloadUrls, "downloadUrls");
                        liveBeautyDownloader.l(resources, downloadUrls);
                    }
                }), new LiveBeautyDownloader.d(new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.network.download.LiveBeautyDownloader$checkResources$1$3
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                        invoke2(th);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        LiveBeautyDownloader.f11939a.o();
                    }
                }));
                s.h(subscribe, "onlyDownloadLicense: Boo…      }\n                )");
                gVar.H(subscribe);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.network.download.LiveBeautyDownloader$checkResources$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                LiveBeautyDownloader.f11939a.o();
                return Boolean.TRUE;
            }
        }, disposable)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            disposable.H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void l(List<LiveBeautyResourceModel> list, List<String> list2) {
        k.a aVar = z0.k.f54819a;
        AppApplication.a aVar2 = AppApplication.f11612d;
        File s2 = aVar.s(aVar2.c());
        if (s2 == null) {
            o();
        } else {
            new com.cupidapp.live.base.network.download.a(list2, aVar.t(aVar2.c())).g(new c(list, new AtomicInteger(list2.size()), s2)).i();
        }
    }

    @Nullable
    public final File m(@NotNull String resName) {
        s.i(resName, "resName");
        LiveBeautyResourceSaveModel c4 = p1.g.f52734a.Q().c();
        Map<String, String> resources = c4 != null ? c4.getResources() : null;
        String str = resources != null ? resources.get(resName) : null;
        if (str == null || str.length() == 0) {
            return null;
        }
        return new File(str);
    }

    public final void n(List<LiveBeautyResourceModel> list, File file) {
        Context c4 = AppApplication.f11612d.c();
        if (c4 == null) {
            return;
        }
        File file2 = new File(c4.getExternalFilesDir(QuickCardField.ASSETS), UserData.RESOURCE_READY);
        if (list != null) {
            for (LiveBeautyResourceModel liveBeautyResourceModel : list) {
                String name = liveBeautyResourceModel.getName();
                String url = liveBeautyResourceModel.getUrl();
                if (!(url == null || url.length() == 0)) {
                    if (!(name == null || name.length() == 0)) {
                        File file3 = new File(file2, name);
                        if (file3.exists()) {
                            File file4 = new File(file, l1.a.e(url));
                            if (file4.exists()) {
                                FilesKt__UtilsKt.k(file4);
                            }
                            if (FilesKt__UtilsKt.h(file3, new File(file4, name), false, null, 6, null)) {
                                FilesKt__UtilsKt.k(file3);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o() {
        if (f11942d) {
            return;
        }
        f11942d = true;
        AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.base.network.download.i
            @Override // java.lang.Runnable
            public final void run() {
                LiveBeautyDownloader.p();
            }
        });
    }

    public final void q() {
        AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.base.network.download.h
            @Override // java.lang.Runnable
            public final void run() {
                LiveBeautyDownloader.r();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a6, code lost:
    
        if (kotlin.text.p.q(r8, r6, false, 2, null) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
    
        r2 = new java.io.File(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        if (r2.exists() == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b3, code lost:
    
        kotlin.io.FilesKt__UtilsKt.k(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0072, code lost:
    
        if (r0 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0074, code lost:
    
        r2 = r7.getPath();
        kotlin.jvm.internal.s.h(r2, "localFile.path");
        r2 = r0.put(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0083, code lost:
    
        p1.g.f52734a.Q().d(new com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x001b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(java.util.List<com.cupidapp.live.liveshow.model.LiveBeautyResourceModel> r11, java.io.File r12, java.util.List<java.lang.String> r13) {
        /*
            r10 = this;
            p1.g r0 = p1.g.f52734a     // Catch: java.lang.Exception -> Lb8
            p1.a r0 = r0.Q()     // Catch: java.lang.Exception -> Lb8
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Exception -> Lb8
            com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel r0 = (com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel) r0     // Catch: java.lang.Exception -> Lb8
            r1 = 0
            if (r0 == 0) goto L14
            java.util.Map r0 = r0.getResources()     // Catch: java.lang.Exception -> Lb8
            goto L15
        L14:
            r0 = r1
        L15:
            if (r11 == 0) goto Lbc
            java.util.Iterator r11 = r11.iterator2()     // Catch: java.lang.Exception -> Lb8
        L1b:
            boolean r2 = r11.hasNext()     // Catch: java.lang.Exception -> Lb8
            if (r2 == 0) goto Lbc
            java.lang.Object r2 = r11.next()     // Catch: java.lang.Exception -> Lb8
            com.cupidapp.live.liveshow.model.LiveBeautyResourceModel r2 = (com.cupidapp.live.liveshow.model.LiveBeautyResourceModel) r2     // Catch: java.lang.Exception -> Lb8
            java.lang.String r3 = r2.getName()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r2 = r2.getUrl()     // Catch: java.lang.Exception -> Lb8
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3c
            int r6 = r2.length()     // Catch: java.lang.Exception -> Lb8
            if (r6 != 0) goto L3a
            goto L3c
        L3a:
            r6 = 0
            goto L3d
        L3c:
            r6 = 1
        L3d:
            if (r6 != 0) goto L1b
            if (r3 == 0) goto L4a
            int r6 = r3.length()     // Catch: java.lang.Exception -> Lb8
            if (r6 != 0) goto L48
            goto L4a
        L48:
            r6 = 0
            goto L4b
        L4a:
            r6 = 1
        L4b:
            if (r6 != 0) goto L1b
            java.lang.String r6 = l1.a.e(r2)     // Catch: java.lang.Exception -> Lb8
            java.io.File r7 = new java.io.File     // Catch: java.lang.Exception -> Lb8
            r7.<init>(r12, r6)     // Catch: java.lang.Exception -> Lb8
            if (r0 == 0) goto L5f
            java.lang.Object r8 = r0.get(r3)     // Catch: java.lang.Exception -> Lb8
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> Lb8
            goto L60
        L5f:
            r8 = r1
        L60:
            boolean r9 = r7.exists()     // Catch: java.lang.Exception -> Lb8
            if (r9 == 0) goto L92
            if (r8 == 0) goto L70
            int r2 = r8.length()     // Catch: java.lang.Exception -> Lb8
            if (r2 != 0) goto L6f
            goto L70
        L6f:
            r4 = 0
        L70:
            if (r4 == 0) goto L1b
            if (r0 == 0) goto L83
            java.lang.String r2 = r7.getPath()     // Catch: java.lang.Exception -> Lb8
            java.lang.String r4 = "localFile.path"
            kotlin.jvm.internal.s.h(r2, r4)     // Catch: java.lang.Exception -> Lb8
            java.lang.Object r2 = r0.put(r3, r2)     // Catch: java.lang.Exception -> Lb8
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> Lb8
        L83:
            p1.g r2 = p1.g.f52734a     // Catch: java.lang.Exception -> Lb8
            p1.a r2 = r2.Q()     // Catch: java.lang.Exception -> Lb8
            com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel r3 = new com.cupidapp.live.liveshow.model.LiveBeautyResourceSaveModel     // Catch: java.lang.Exception -> Lb8
            r3.<init>(r0)     // Catch: java.lang.Exception -> Lb8
            r2.d(r3)     // Catch: java.lang.Exception -> Lb8
            goto L1b
        L92:
            r13.add(r2)     // Catch: java.lang.Exception -> Lb8
            if (r8 == 0) goto L9f
            int r2 = r8.length()     // Catch: java.lang.Exception -> Lb8
            if (r2 != 0) goto L9e
            goto L9f
        L9e:
            r4 = 0
        L9f:
            if (r4 != 0) goto L1b
            r2 = 2
            boolean r2 = kotlin.text.p.q(r8, r6, r5, r2, r1)     // Catch: java.lang.Exception -> Lb8
            if (r2 != 0) goto L1b
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> Lb8
            r2.<init>(r8)     // Catch: java.lang.Exception -> Lb8
            boolean r3 = r2.exists()     // Catch: java.lang.Exception -> Lb8
            if (r3 == 0) goto L1b
            kotlin.io.FilesKt__UtilsKt.k(r2)     // Catch: java.lang.Exception -> Lb8
            goto L1b
        Lb8:
            r11 = move-exception
            r11.printStackTrace()
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.download.LiveBeautyDownloader.s(java.util.List, java.io.File, java.util.List):void");
    }
}

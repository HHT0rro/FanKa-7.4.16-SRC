package com.cupidapp.live.base.network.download;

import android.content.Context;
import android.os.Handler;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.network.download.b;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ExtraResourceResult;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ImageSizeConstants;
import com.cupidapp.live.base.network.model.PrefetchResourcesModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.helper.SplashAdSelectHelper;
import com.cupidapp.live.startup.model.FKStartupMaterialType;
import com.cupidapp.live.startup.model.FKStartupMediaBaseInfoModel;
import com.cupidapp.live.startup.model.FKStartupMediaConfigModel;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LaunchDownloader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LaunchDownloader {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f11929e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static com.cupidapp.live.base.network.download.a f11930f;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LaunchDownloader f11925a = new LaunchDownloader();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ConcurrentHashMap<String, String> f11926b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final ConcurrentHashMap<String, String> f11927c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final List<String> f11928d = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final List<String> f11931g = new ArrayList();

    /* compiled from: LaunchDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f11932a;

        public a(Map<String, String> map) {
            this.f11932a = map;
        }

        public static final void b(Map urlIdMap, String url, String localPath) {
            s.i(urlIdMap, "$urlIdMap");
            s.i(url, "$url");
            s.i(localPath, "$localPath");
            String str = (String) urlIdMap.get(url);
            if (str != null) {
                SplashAdSelectHelper.f18415a.W(str, localPath);
            }
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onFailure(@NotNull String url) {
            s.i(url, "url");
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onSuccess(@NotNull final String url, @NotNull final String localPath) {
            s.i(url, "url");
            s.i(localPath, "localPath");
            Handler j10 = AppApplication.f11612d.h().j();
            final Map<String, String> map = this.f11932a;
            j10.post(new Runnable() { // from class: com.cupidapp.live.base.network.download.g
                @Override // java.lang.Runnable
                public final void run() {
                    LaunchDownloader.a.b(Map.this, url, localPath);
                }
            });
        }
    }

    /* compiled from: LaunchDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements b.a {
        @Override // com.cupidapp.live.base.network.download.b.a
        public void onFailure(@NotNull String url) {
            s.i(url, "url");
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onSuccess(@NotNull String url, @NotNull String localPath) {
            s.i(url, "url");
            s.i(localPath, "localPath");
            LaunchDownloader.f11925a.x(null, url, localPath);
        }
    }

    /* compiled from: LaunchDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11933a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<String, p> f11934b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f11935c;

        /* compiled from: LaunchDownloader.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0<p> f11936b;

            public a(Function0<p> function0) {
                this.f11936b = function0;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11936b.invoke();
            }
        }

        /* compiled from: LaunchDownloader.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1<String, p> f11937b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f11938c;

            /* JADX WARN: Multi-variable type inference failed */
            public b(Function1<? super String, p> function1, String str) {
                this.f11937b = function1;
                this.f11938c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11937b.invoke(this.f11938c);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(String str, Function1<? super String, p> function1, Function0<p> function0) {
            this.f11933a = str;
            this.f11934b = function1;
            this.f11935c = function0;
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onFailure(@NotNull String url) {
            s.i(url, "url");
            AppApplication.f11612d.h().j().post(new a(this.f11935c));
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onSuccess(@NotNull String url, @NotNull String localPath) {
            s.i(url, "url");
            s.i(localPath, "localPath");
            LaunchDownloader.f11925a.x(this.f11933a, url, localPath);
            AppApplication.f11612d.h().j().post(new b(this.f11934b, localPath));
        }
    }

    public static final p i(Context context, List list, File file, List resourceKeyList) {
        s.i(context, "$context");
        s.i(resourceKeyList, "$resourceKeyList");
        LaunchDownloader launchDownloader = f11925a;
        String absolutePath = file.getAbsolutePath();
        s.h(absolutePath, "hideResourceDir.absolutePath");
        launchDownloader.l(context, list, absolutePath);
        String absolutePath2 = file.getAbsolutePath();
        s.h(absolutePath2, "hideResourceDir.absolutePath");
        launchDownloader.r(resourceKeyList, absolutePath2);
        return p.f51048a;
    }

    public static final void j(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y(String str, String str2, String localPath) {
        s.i(localPath, "$localPath");
        if ((str == null || str.length() == 0) && (str = f11927c.get(str2)) == null) {
            str = "";
        }
        if (str.length() > 0) {
            com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "write: " + str + " -> " + localPath);
            f11926b.put(str, localPath);
            List<String> list = f11928d;
            if (list.contains(str)) {
                list.remove(str);
            }
        }
    }

    public final void h(@NotNull final Context context, @NotNull ConstantsResult constant) {
        s.i(context, "context");
        s.i(constant, "constant");
        final List<PrefetchResourcesModel> prefetchResources = constant.getPrefetchResources();
        final File z10 = z0.k.f54819a.z(context);
        if ((prefetchResources == null || prefetchResources.isEmpty()) || z10 == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (PrefetchResourcesModel prefetchResourcesModel : prefetchResources) {
            if ((prefetchResourcesModel.getKey().length() > 0) && prefetchResourcesModel.checkFirstUrlIsValid()) {
                f11927c.put(prefetchResourcesModel.getUrl().get(0), prefetchResourcesModel.getKey());
                arrayList.add(prefetchResourcesModel.getKey());
            }
        }
        Single observeOn = Single.fromCallable(new Callable() { // from class: com.cupidapp.live.base.network.download.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                p i10;
                i10 = LaunchDownloader.i(context, prefetchResources, z10, arrayList);
                return i10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final LaunchDownloader$checkDownloadResources$3 launchDownloader$checkDownloadResources$3 = new Function1<p, p>() { // from class: com.cupidapp.live.base.network.download.LaunchDownloader$checkDownloadResources$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(p pVar) {
                invoke2(pVar);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(p pVar) {
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.base.network.download.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LaunchDownloader.j(Function1.this, obj);
            }
        };
        final LaunchDownloader$checkDownloadResources$4 launchDownloader$checkDownloadResources$4 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.network.download.LaunchDownloader$checkDownloadResources$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.network.download.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LaunchDownloader.k(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(android.content.Context r9, java.util.List<com.cupidapp.live.base.network.model.PrefetchResourcesModel> r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.download.LaunchDownloader.l(android.content.Context, java.util.List, java.lang.String):void");
    }

    public final void m(@Nullable Context context, @Nullable List<? extends List<? extends List<FKStartupMediaConfigModel>>> list) {
        File r10;
        VideoModel video;
        List<String> urlList;
        if (context != null) {
            if (list == null || list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<? extends List<? extends List<FKStartupMediaConfigModel>>> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                Iterator<? extends List<FKStartupMediaConfigModel>> iterator22 = iterator2.next().iterator2();
                while (iterator22.hasNext()) {
                    for (FKStartupMediaConfigModel fKStartupMediaConfigModel : iterator22.next()) {
                        Integer materialType = fKStartupMediaConfigModel.getAdvertisementBaseInfo().getMaterialType();
                        int type = FKStartupMaterialType.Image.getType();
                        if (materialType == null || materialType.intValue() != type) {
                            int type2 = FKStartupMaterialType.Video.getType();
                            if (materialType != null && materialType.intValue() == type2) {
                            }
                        }
                        arrayList.add(fKStartupMediaConfigModel);
                    }
                }
            }
            if (arrayList.isEmpty() || (r10 = z0.k.f54819a.r(context)) == null) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator<E> iterator23 = arrayList.iterator2();
            while (iterator23.hasNext()) {
                FKStartupMediaBaseInfoModel advertisementBaseInfo = ((FKStartupMediaConfigModel) iterator23.next()).getAdvertisementBaseInfo();
                Integer materialType2 = advertisementBaseInfo.getMaterialType();
                int type3 = FKStartupMaterialType.Image.getType();
                String str = null;
                if (materialType2 != null && materialType2.intValue() == type3) {
                    ImageModel imageStartup = advertisementBaseInfo.getImageStartup();
                    if (imageStartup != null && (urlList = imageStartup.getUrlList(ImageSizeConstants.SQUARE_ORIGIN_SIZE.getWidth())) != null) {
                        str = (String) CollectionsKt___CollectionsKt.V(urlList);
                    }
                } else {
                    int type4 = FKStartupMaterialType.Video.getType();
                    if (materialType2 != null && materialType2.intValue() == type4 && (video = advertisementBaseInfo.getVideo()) != null) {
                        str = video.getUrl();
                    }
                }
                if (!(str == null || str.length() == 0)) {
                    linkedHashMap.put(str, advertisementBaseInfo.getAdId());
                    String E = SplashAdSelectHelper.f18415a.E(advertisementBaseInfo.getAdId());
                    if (E == null || E.length() == 0) {
                        arrayList2.add(str);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                new com.cupidapp.live.base.network.download.a(arrayList2, r10).g(new a(linkedHashMap)).i();
            }
        }
    }

    public final String n(String str) {
        if (str == null || str.length() == 0) {
            return ".png";
        }
        String str2 = (String) CollectionsKt___CollectionsKt.f0(StringsKt__StringsKt.z0(str, new String[]{"."}, false, 0, 6, null));
        if (str2 == null || str2.length() == 0) {
            return ".png";
        }
        return "." + str2;
    }

    public final File o(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return new File(str2, p(str));
    }

    public final String p(String str) {
        return l1.a.e(str) + n(str);
    }

    @Nullable
    public final String q(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return "file://" + str;
    }

    public final void r(List<String> list, String str) {
        com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "readDownloadedResources in " + Thread.currentThread().getName());
        for (String str2 : list) {
            if (!(str2.length() == 0)) {
                LaunchDownloader launchDownloader = f11925a;
                File o10 = launchDownloader.o(str2, str);
                if (o10 != null && o10.exists()) {
                    String absolutePath = o10.getAbsolutePath();
                    s.h(absolutePath, "localFile.absolutePath");
                    launchDownloader.x(str2, null, absolutePath);
                } else {
                    f11928d.add(str2);
                    com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "readDownloadedResources  needDownloadKeyList + 1 key:" + str2);
                }
            }
        }
    }

    @Nullable
    public final String s(@NotNull String key) {
        s.i(key, "key");
        return f11926b.get(key);
    }

    @Nullable
    public final String t(@NotNull String key) {
        s.i(key, "key");
        return f11926b.get(key);
    }

    @Nullable
    public final String u(@NotNull String key) {
        s.i(key, "key");
        return q(f11926b.get(key));
    }

    public final void v(@Nullable Context context) {
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        aVar.a("DownTest", "startDownloadResources in " + Thread.currentThread().getName());
        boolean z10 = f11929e;
        List<String> list = f11928d;
        aVar.a("DownTest", "startDownloadResources isStartedDownload:" + z10 + "  needDownloadKeyList:" + list.isEmpty());
        if (context == null || list.isEmpty() || f11929e) {
            return;
        }
        if (z0.h.g(context) != NetworkStateConstants.WIFI) {
            aVar.c("DownTest", "startDownloadResources current is not WIFI");
            return;
        }
        final File z11 = z0.k.f54819a.z(context);
        if (z11 == null) {
            return;
        }
        f11929e = true;
        Disposable disposed = NetworkClient.f11868a.i().t(list, true).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ExtraResourceResult, p>() { // from class: com.cupidapp.live.base.network.download.LaunchDownloader$startDownloadResources$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ExtraResourceResult extraResourceResult) {
                m2460invoke(extraResourceResult);
                return p.f51048a;
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0012 A[SYNTHETIC] */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void m2460invoke(com.cupidapp.live.base.network.model.ExtraResourceResult r7) {
                /*
                    r6 = this;
                    com.cupidapp.live.base.network.model.ExtraResourceResult r7 = (com.cupidapp.live.base.network.model.ExtraResourceResult) r7
                    java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                    r0.<init>()
                    java.util.List r7 = r7.getList()
                    r1 = 1
                    if (r7 == 0) goto L63
                    java.util.Iterator r7 = r7.iterator2()
                L12:
                    boolean r2 = r7.hasNext()
                    if (r2 == 0) goto L63
                    java.lang.Object r2 = r7.next()
                    com.cupidapp.live.base.network.model.ExtraResourceModel r2 = (com.cupidapp.live.base.network.model.ExtraResourceModel) r2
                    java.lang.String r3 = r2.getKey()
                    r4 = 0
                    if (r3 == 0) goto L32
                    int r3 = r3.length()
                    if (r3 <= 0) goto L2d
                    r3 = 1
                    goto L2e
                L2d:
                    r3 = 0
                L2e:
                    if (r3 != r1) goto L32
                    r3 = 1
                    goto L33
                L32:
                    r3 = 0
                L33:
                    if (r3 == 0) goto L12
                    java.util.List r3 = r2.getUrl()
                    if (r3 == 0) goto L44
                    boolean r3 = r3.isEmpty()
                    if (r3 == 0) goto L42
                    goto L44
                L42:
                    r3 = 0
                    goto L45
                L44:
                    r3 = 1
                L45:
                    if (r3 != 0) goto L12
                    boolean r3 = r2.checkFirstUrlIsValid()
                    if (r3 == 0) goto L12
                    com.cupidapp.live.base.network.download.LaunchDownloader r3 = com.cupidapp.live.base.network.download.LaunchDownloader.f11925a
                    java.lang.String r5 = r2.getKey()
                    java.lang.String r3 = com.cupidapp.live.base.network.download.LaunchDownloader.e(r3, r5)
                    java.util.List r2 = r2.getUrl()
                    java.lang.Object r2 = r2.get(r4)
                    r0.put(r3, r2)
                    goto L12
                L63:
                    boolean r7 = r0.isEmpty()
                    r7 = r7 ^ r1
                    if (r7 == 0) goto L7d
                    com.cupidapp.live.base.network.download.a r7 = new com.cupidapp.live.base.network.download.a
                    java.io.File r1 = java.io.File.this
                    r7.<init>(r0, r1)
                    com.cupidapp.live.base.network.download.LaunchDownloader$b r0 = new com.cupidapp.live.base.network.download.LaunchDownloader$b
                    r0.<init>()
                    com.cupidapp.live.base.network.download.a r7 = r7.g(r0)
                    r7.i()
                L7d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.download.LaunchDownloader$startDownloadResources$$inlined$handle$default$1.m2460invoke(java.lang.Object):void");
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void w(@Nullable Context context, @Nullable final String str, @NotNull final Function1<? super String, p> success, @NotNull final Function0<p> failure) {
        s.i(success, "success");
        s.i(failure, "failure");
        if (context != null) {
            if (!(str == null || str.length() == 0)) {
                List<String> list = f11931g;
                if (!list.contains(str)) {
                    File z10 = z0.k.f54819a.z(context);
                    if (z10 == null) {
                        return;
                    }
                    list.add(str);
                    if (f11930f == null) {
                        f11930f = new com.cupidapp.live.base.network.download.a(z10);
                    }
                    Disposable disposed = NetworkClient.f11868a.i().t(r.e(str), false).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ExtraResourceResult, p>() { // from class: com.cupidapp.live.base.network.download.LaunchDownloader$startSingleDownloadResources$$inlined$handle$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(ExtraResourceResult extraResourceResult) {
                            m2461invoke(extraResourceResult);
                            return p.f51048a;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
                        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
                        /* renamed from: invoke, reason: collision with other method in class */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void m2461invoke(com.cupidapp.live.base.network.model.ExtraResourceResult r7) {
                            /*
                                r6 = this;
                                com.cupidapp.live.base.network.model.ExtraResourceResult r7 = (com.cupidapp.live.base.network.model.ExtraResourceResult) r7
                                java.util.List r7 = r7.getList()
                                if (r7 == 0) goto Lf
                                java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.V(r7)
                                com.cupidapp.live.base.network.model.ExtraResourceModel r7 = (com.cupidapp.live.base.network.model.ExtraResourceModel) r7
                                goto L10
                            Lf:
                                r7 = 0
                            L10:
                                if (r7 == 0) goto L71
                                java.lang.String r0 = r7.getKey()
                                r1 = 1
                                r2 = 0
                                if (r0 == 0) goto L27
                                int r0 = r0.length()
                                if (r0 <= 0) goto L22
                                r0 = 1
                                goto L23
                            L22:
                                r0 = 0
                            L23:
                                if (r0 != r1) goto L27
                                r0 = 1
                                goto L28
                            L27:
                                r0 = 0
                            L28:
                                if (r0 == 0) goto L71
                                java.util.List r0 = r7.getUrl()
                                if (r0 == 0) goto L38
                                boolean r0 = r0.isEmpty()
                                if (r0 == 0) goto L37
                                goto L38
                            L37:
                                r1 = 0
                            L38:
                                if (r1 != 0) goto L71
                                boolean r0 = r7.checkFirstUrlIsValid()
                                if (r0 == 0) goto L71
                                com.cupidapp.live.base.network.download.a r0 = com.cupidapp.live.base.network.download.LaunchDownloader.f()
                                if (r0 == 0) goto L54
                                com.cupidapp.live.base.network.download.LaunchDownloader$c r1 = new com.cupidapp.live.base.network.download.LaunchDownloader$c
                                java.lang.String r3 = java.lang.String.this
                                kotlin.jvm.functions.Function1 r4 = r2
                                kotlin.jvm.functions.Function0 r5 = r3
                                r1.<init>(r3, r4, r5)
                                r0.g(r1)
                            L54:
                                com.cupidapp.live.base.network.download.a r0 = com.cupidapp.live.base.network.download.LaunchDownloader.f()
                                if (r0 == 0) goto L71
                                com.cupidapp.live.base.network.download.LaunchDownloader r1 = com.cupidapp.live.base.network.download.LaunchDownloader.f11925a
                                java.lang.String r3 = r7.getKey()
                                java.lang.String r1 = com.cupidapp.live.base.network.download.LaunchDownloader.e(r1, r3)
                                java.util.List r7 = r7.getUrl()
                                java.lang.Object r7 = r7.get(r2)
                                java.lang.String r7 = (java.lang.String) r7
                                r0.e(r1, r7)
                            L71:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.download.LaunchDownloader$startSingleDownloadResources$$inlined$handle$default$1.m2461invoke(java.lang.Object):void");
                        }
                    }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                    }
                    s.h(disposed, "disposed");
                    return;
                }
            }
        }
        com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "startSingleDownloadResources return");
    }

    public final void x(final String str, final String str2, final String str3) {
        AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.base.network.download.e
            @Override // java.lang.Runnable
            public final void run() {
                LaunchDownloader.y(String.this, str2, str3);
            }
        });
    }
}

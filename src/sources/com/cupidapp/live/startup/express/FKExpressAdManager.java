package com.cupidapp.live.startup.express;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.express.FKExpressAdManager;
import com.cupidapp.live.startup.express.FKExpressAdManager$expressAdListener$2;
import com.cupidapp.live.startup.express.b;
import com.cupidapp.live.startup.express.csj.FKCSJExpressAd;
import com.cupidapp.live.startup.express.gdt.FKGDTCustomExpressAd;
import com.cupidapp.live.startup.express.jd.FKJdExpressAd;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKExpressAdLocalModel;
import com.cupidapp.live.startup.model.FKExpressAdType;
import com.cupidapp.live.startup.model.FKExpressModel;
import com.cupidapp.live.startup.model.FkAdModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: FKExpressAdManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKExpressAdManager {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f18315g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final WeakReference<FragmentActivity> f18316a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Function2<View, Integer, p> f18317b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function2<Integer, Boolean, p> f18318c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Map<Integer, ExpressAdModel> f18319d;

    /* renamed from: e, reason: collision with root package name */
    public SensorPosition f18320e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18321f;

    /* compiled from: FKExpressAdManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* compiled from: FKExpressAdManager.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.startup.express.FKExpressAdManager$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class C0168a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f18322a;

            static {
                int[] iArr = new int[SensorPosition.values().length];
                try {
                    iArr[SensorPosition.Feed.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SensorPosition.PostStream.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f18322a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull SensorPosition sensorPosition) {
            long feedTime;
            FKExpressModel adFeedParam;
            Integer displayInterval;
            s.i(sensorPosition, "sensorPosition");
            g gVar = g.f52734a;
            FKExpressAdLocalModel c4 = gVar.E().c();
            if (c4 == null) {
                return false;
            }
            ConstantsResult q10 = gVar.q();
            int intValue = (q10 == null || (adFeedParam = q10.getAdFeedParam()) == null || (displayInterval = adFeedParam.getDisplayInterval()) == null) ? 300 : displayInterval.intValue();
            int i10 = C0168a.f18322a[sensorPosition.ordinal()];
            if (i10 != 1) {
                feedTime = i10 != 2 ? 0L : c4.getPostStreamTime();
            } else {
                feedTime = c4.getFeedTime();
            }
            long currentTimeMillis = System.currentTimeMillis() - feedTime;
            j.f12332a.a("FKExpressAdListener", "coldTimeInterval: " + currentTimeMillis + " coldTime: " + intValue);
            return currentTimeMillis > ((long) intValue) * 1000;
        }

        public final void b(@NotNull SensorPosition sensorPosition) {
            s.i(sensorPosition, "sensorPosition");
            g gVar = g.f52734a;
            FKExpressAdLocalModel c4 = gVar.E().c();
            if (c4 == null) {
                c4 = new FKExpressAdLocalModel(0L, 0L, 3, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = C0168a.f18322a[sensorPosition.ordinal()];
            if (i10 == 1) {
                c4.setFeedTime(currentTimeMillis);
            } else if (i10 == 2) {
                c4.setPostStreamTime(currentTimeMillis);
            }
            gVar.E().d(c4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FKExpressAdManager(@NotNull WeakReference<FragmentActivity> activity, @NotNull Function2<? super View, ? super Integer, p> addAdCallback, @NotNull Function2<? super Integer, ? super Boolean, p> removeAdCallback) {
        s.i(activity, "activity");
        s.i(addAdCallback, "addAdCallback");
        s.i(removeAdCallback, "removeAdCallback");
        this.f18316a = activity;
        this.f18317b = addAdCallback;
        this.f18318c = removeAdCallback;
        this.f18321f = kotlin.c.b(new Function0<FKExpressAdManager$expressAdListener$2.AnonymousClass1>() { // from class: com.cupidapp.live.startup.express.FKExpressAdManager$expressAdListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.cupidapp.live.startup.express.FKExpressAdManager$expressAdListener$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final FKExpressAdManager fKExpressAdManager = FKExpressAdManager.this;
                return new b() { // from class: com.cupidapp.live.startup.express.FKExpressAdManager$expressAdListener$2.1
                    @Override // com.cupidapp.live.startup.express.b
                    public void a(@NotNull FKAdType type, int i10) {
                        SensorPosition sensorPosition;
                        s.i(type, "type");
                        b.a.a(this, type, i10);
                        j1.b bVar = j1.b.f50227a;
                        sensorPosition = FKExpressAdManager.this.f18320e;
                        if (sensorPosition == null) {
                            s.A("sensorPosition");
                            sensorPosition = null;
                        }
                        bVar.a(sensorPosition, i10 + 1, type.getType());
                    }

                    @Override // com.cupidapp.live.startup.express.b
                    public void b(@NotNull FKAdType type, int i10, @Nullable View view) {
                        Function2 function2;
                        s.i(type, "type");
                        b.a.f(this, type, i10, view);
                        if (view != null) {
                            function2 = FKExpressAdManager.this.f18317b;
                            function2.mo1743invoke(view, Integer.valueOf(i10));
                        }
                    }

                    @Override // com.cupidapp.live.startup.express.b
                    public void c(@NotNull FKAdType type, int i10) {
                        Map map;
                        Map map2;
                        String unitId;
                        WeakReference weakReference;
                        ExpressAdModel expressAdModel;
                        ExpressAdModel expressAdModel2;
                        SensorPosition sensorPosition;
                        SensorPosition sensorPosition2;
                        s.i(type, "type");
                        b.a.g(this, type, i10);
                        map = FKExpressAdManager.this.f18319d;
                        if (map != null && (expressAdModel2 = (ExpressAdModel) map.get(Integer.valueOf(i10))) != null) {
                            FKExpressAdManager fKExpressAdManager2 = FKExpressAdManager.this;
                            j1.b bVar = j1.b.f50227a;
                            FkAdModel adModel = expressAdModel2.getAdModel();
                            String adId = adModel != null ? adModel.getAdId() : null;
                            sensorPosition = fKExpressAdManager2.f18320e;
                            if (sensorPosition == null) {
                                s.A("sensorPosition");
                                sensorPosition2 = null;
                            } else {
                                sensorPosition2 = sensorPosition;
                            }
                            bVar.c(adId, sensorPosition2, i10 + 1, type.getType(), true, (r22 & 32) != 0 ? null : null, (r22 & 64) != 0 ? null : null, expressAdModel2.getReqId(), expressAdModel2.getReqCount());
                        }
                        map2 = FKExpressAdManager.this.f18319d;
                        FkAdModel adModel2 = (map2 == null || (expressAdModel = (ExpressAdModel) map2.get(Integer.valueOf(i10))) == null) ? null : expressAdModel.getAdModel();
                        if (adModel2 == null || (unitId = adModel2.getUnitId()) == null) {
                            return;
                        }
                        FKExpressAdManager fKExpressAdManager3 = FKExpressAdManager.this;
                        Observable<Result<Object>> H = NetworkClient.f11868a.l().H(FKExpressAdType.Program.getType(), unitId);
                        weakReference = fKExpressAdManager3.f18316a;
                        Object obj = (Context) weakReference.get();
                        com.cupidapp.live.base.network.g gVar = obj instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) obj : null;
                        Disposable disposed = H.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.startup.express.FKExpressAdManager$expressAdListener$2$1$onShow$lambda$3$$inlined$handleByContext$default$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ p invoke(Object obj2) {
                                invoke2(obj2);
                                return p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj2) {
                            }
                        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                        if (disposed != null) {
                            s.h(disposed, "disposed");
                            if (gVar != null) {
                                gVar.H(disposed);
                            }
                        }
                        s.h(disposed, "disposed");
                    }

                    @Override // com.cupidapp.live.startup.express.b
                    public void d(@NotNull FKAdType type, int i10, @Nullable String str) {
                        SensorPosition sensorPosition;
                        SensorPosition sensorPosition2;
                        Map map;
                        Map map2;
                        Function2 function2;
                        ExpressAdModel expressAdModel;
                        FKBaseExpressAd baseExpressAd;
                        s.i(type, "type");
                        b.a.b(this, type, i10, str);
                        FKExpressAdManager.a aVar = FKExpressAdManager.f18315g;
                        sensorPosition = FKExpressAdManager.this.f18320e;
                        SensorPosition sensorPosition3 = null;
                        if (sensorPosition == null) {
                            s.A("sensorPosition");
                            sensorPosition = null;
                        }
                        aVar.b(sensorPosition);
                        j1.b bVar = j1.b.f50227a;
                        sensorPosition2 = FKExpressAdManager.this.f18320e;
                        if (sensorPosition2 == null) {
                            s.A("sensorPosition");
                        } else {
                            sensorPosition3 = sensorPosition2;
                        }
                        bVar.b(sensorPosition3, i10 + 1, type.getType(), str);
                        map = FKExpressAdManager.this.f18319d;
                        if (map != null && (expressAdModel = (ExpressAdModel) map.get(Integer.valueOf(i10))) != null && (baseExpressAd = expressAdModel.getBaseExpressAd()) != null) {
                            baseExpressAd.c();
                        }
                        map2 = FKExpressAdManager.this.f18319d;
                        if (map2 != null) {
                        }
                        function2 = FKExpressAdManager.this.f18318c;
                        function2.mo1743invoke(Integer.valueOf(i10), Boolean.TRUE);
                    }

                    @Override // com.cupidapp.live.startup.express.b
                    public void e(@NotNull FKAdType type, int i10, @Nullable Integer num, @Nullable String str) {
                        Map map;
                        Map map2;
                        ExpressAdModel expressAdModel;
                        FkAdModel adModel;
                        ExpressAdModel expressAdModel2;
                        SensorPosition sensorPosition;
                        s.i(type, "type");
                        b.a.d(this, type, i10, num, str);
                        map = FKExpressAdManager.this.f18319d;
                        if (map != null && (expressAdModel2 = (ExpressAdModel) map.get(Integer.valueOf(i10))) != null) {
                            FKExpressAdManager fKExpressAdManager2 = FKExpressAdManager.this;
                            j1.b bVar = j1.b.f50227a;
                            FkAdModel adModel2 = expressAdModel2.getAdModel();
                            SensorPosition sensorPosition2 = null;
                            String adId = adModel2 != null ? adModel2.getAdId() : null;
                            sensorPosition = fKExpressAdManager2.f18320e;
                            if (sensorPosition == null) {
                                s.A("sensorPosition");
                            } else {
                                sensorPosition2 = sensorPosition;
                            }
                            bVar.c(adId, sensorPosition2, i10 + 1, type.getType(), false, num, str, expressAdModel2.getReqId(), expressAdModel2.getReqCount());
                        }
                        map2 = FKExpressAdManager.this.f18319d;
                        if (map2 == null || (expressAdModel = (ExpressAdModel) map2.get(Integer.valueOf(i10))) == null || (adModel = expressAdModel.getAdModel()) == null) {
                            return;
                        }
                        FKExpressAdManager.this.n(i10, adModel);
                    }
                };
            }
        });
    }

    public final FKBaseExpressAd g(FkAdModel fkAdModel, int i10) {
        Map<Integer, ExpressAdModel> map;
        ExpressAdModel expressAdModel;
        FragmentActivity fragmentActivity = this.f18316a.get();
        FKBaseExpressAd fKBaseExpressAd = null;
        if (fragmentActivity != null) {
            WeakReference weakReference = new WeakReference(fragmentActivity);
            String unitId = fkAdModel.getUnitId();
            if (unitId != null) {
                String provider = fkAdModel.getProvider();
                if (s.d(provider, FKAdType.CSJ.getSource())) {
                    fKBaseExpressAd = new FKCSJExpressAd(weakReference, i10, fkAdModel.getAdAppId(), unitId, h());
                } else if (s.d(provider, FKAdType.GDT.getSource())) {
                    fKBaseExpressAd = new com.cupidapp.live.startup.express.gdt.a(weakReference, i10, fkAdModel.getAdAppId(), unitId, h());
                } else if (s.d(provider, FKAdType.GDT_CUSTOM.getSource())) {
                    fKBaseExpressAd = new FKGDTCustomExpressAd(weakReference, i10, fkAdModel.getAdAppId(), unitId, h());
                } else if (s.d(provider, FKAdType.JD.getSource())) {
                    fKBaseExpressAd = new FKJdExpressAd(weakReference, i10, fkAdModel.getAdAppId(), unitId, h());
                } else if (s.d(provider, FKAdType.KS.getSource())) {
                    fKBaseExpressAd = new c(weakReference, i10, fkAdModel.getAdAppId(), unitId, h());
                } else if (s.d(provider, FKAdType.BD.getSource())) {
                    fKBaseExpressAd = new com.cupidapp.live.startup.express.a(weakReference, i10, fkAdModel.getAdAppId(), unitId, h());
                } else if (s.d(provider, FKAdType.HUAWEI.getSource())) {
                    fKBaseExpressAd = new e(weakReference, i10, unitId, h());
                }
            }
        }
        if (fKBaseExpressAd != null && (map = this.f18319d) != null && (expressAdModel = map.get(Integer.valueOf(i10))) != null) {
            expressAdModel.setAdModel(fkAdModel);
            expressAdModel.setBaseExpressAd(fKBaseExpressAd);
        }
        return fKBaseExpressAd;
    }

    public final FKExpressAdManager$expressAdListener$2.AnonymousClass1 h() {
        return (FKExpressAdManager$expressAdListener$2.AnonymousClass1) this.f18321f.getValue();
    }

    public final List<FkAdModel> i() {
        FKExpressModel adFeedParam;
        List<FkAdModel> adFeedConfig;
        ConstantsResult q10 = g.f52734a.q();
        List<FkAdModel> z02 = (q10 == null || (adFeedParam = q10.getAdFeedParam()) == null || (adFeedConfig = adFeedParam.getAdFeedConfig()) == null) ? null : CollectionsKt___CollectionsKt.z0(adFeedConfig);
        if (!h.s() && z02 != null) {
            x.B(z02, new Function1<FkAdModel, Boolean>() { // from class: com.cupidapp.live.startup.express.FKExpressAdManager$getExpressList$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull FkAdModel it) {
                    s.i(it, "it");
                    return Boolean.valueOf(s.d(it.getProvider(), FKAdType.XiaoMi.getSource()));
                }
            });
        }
        return z02;
    }

    public final void j(int i10) {
        ExpressAdModel expressAdModel;
        List<FkAdModel> i11 = i();
        if (i11 == null || i11.isEmpty()) {
            return;
        }
        Map<Integer, ExpressAdModel> map = this.f18319d;
        if (map != null && (expressAdModel = map.get(Integer.valueOf(i10))) != null) {
            expressAdModel.setReqId(UUID.randomUUID().toString());
            expressAdModel.setReqCount(1);
        }
        FkAdModel fkAdModel = i11.get(0);
        FKBaseExpressAd g3 = g(fkAdModel, i10);
        if (g3 == null) {
            j.f12332a.a("FKExpressAdListener", "loadExpressAd getExpressAd == null type:" + ((Object) FKAdType.Companion.a(fkAdModel.getProvider())));
            n(i10, fkAdModel);
            return;
        }
        g3.b();
    }

    public final void k() {
        Map<Integer, ExpressAdModel> map = this.f18319d;
        if (map != null) {
            Iterator<Map.Entry<Integer, ExpressAdModel>> iterator2 = map.entrySet().iterator2();
            while (iterator2.hasNext()) {
                FKBaseExpressAd baseExpressAd = iterator2.next().getValue().getBaseExpressAd();
                if (baseExpressAd != null) {
                    baseExpressAd.c();
                }
            }
        }
        Map<Integer, ExpressAdModel> map2 = this.f18319d;
        if (map2 != null) {
            map2.clear();
        }
        this.f18319d = null;
    }

    public final void l() {
        Map<Integer, ExpressAdModel> map = this.f18319d;
        if (map != null) {
            Iterator<Map.Entry<Integer, ExpressAdModel>> iterator2 = map.entrySet().iterator2();
            while (iterator2.hasNext()) {
                FKBaseExpressAd baseExpressAd = iterator2.next().getValue().getBaseExpressAd();
                if (baseExpressAd != null) {
                    baseExpressAd.d();
                }
            }
        }
    }

    public final void m() {
        Map<Integer, ExpressAdModel> map = this.f18319d;
        if (map != null) {
            Iterator<Map.Entry<Integer, ExpressAdModel>> iterator2 = map.entrySet().iterator2();
            while (iterator2.hasNext()) {
                FKBaseExpressAd baseExpressAd = iterator2.next().getValue().getBaseExpressAd();
                if (baseExpressAd != null) {
                    baseExpressAd.e();
                }
            }
        }
    }

    public final void n(int i10, FkAdModel fkAdModel) {
        ExpressAdModel expressAdModel;
        List<FkAdModel> i11 = i();
        if (!(i11 == null || i11.isEmpty()) && i11.contains(fkAdModel)) {
            int indexOf = i11.indexOf(fkAdModel);
            if (indexOf < i11.size() - 1) {
                Map<Integer, ExpressAdModel> map = this.f18319d;
                if (map != null && (expressAdModel = map.get(Integer.valueOf(i10))) != null) {
                    expressAdModel.setReqCount(expressAdModel.getReqCount() + 1);
                }
                FkAdModel fkAdModel2 = i11.get(indexOf + 1);
                FKBaseExpressAd g3 = g(fkAdModel2, i10);
                if (g3 == null) {
                    j.f12332a.a("FKExpressAdListener", "retryLoadExpressAd getExpressAd == null type:" + ((Object) FKAdType.Companion.a(fkAdModel2.getProvider())));
                    n(i10, fkAdModel2);
                    return;
                }
                g3.b();
                return;
            }
            this.f18318c.mo1743invoke(Integer.valueOf(i10), Boolean.FALSE);
        }
    }

    public final void o(int i10, @NotNull SensorPosition sensorPosition) {
        s.i(sensorPosition, "sensorPosition");
        this.f18320e = sensorPosition;
        if (this.f18319d == null) {
            this.f18319d = new LinkedHashMap();
        }
        Map<Integer, ExpressAdModel> map = this.f18319d;
        if (map != null) {
            map.put(Integer.valueOf(i10), new ExpressAdModel(null, null, null, 0, 15, null));
        }
        j(i10);
    }
}

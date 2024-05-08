package com.amap.api.col.s;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkRouteResultV2;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.Iterator;
import java.util.List;

/* compiled from: MessageHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class y extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private static y f7989a;

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public AutoTChargeStationResult f7990a;

        /* renamed from: b, reason: collision with root package name */
        public AutoTSearch.OnChargeStationListener f7991b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public BusLineResult f7992a;

        /* renamed from: b, reason: collision with root package name */
        public BusLineSearch.OnBusLineSearchListener f7993b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public BusStationResult f7994a;

        /* renamed from: b, reason: collision with root package name */
        public BusStationSearch.OnBusStationSearchListener f7995b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public CloudItemDetail f7996a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f7997b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public CloudResult f7998a;

        /* renamed from: b, reason: collision with root package name */
        public CloudSearch.OnCloudSearchListener f7999b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public GeocodeResult f8000a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f8001b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public List<NearbySearch.NearbyListener> f8002a;

        /* renamed from: b, reason: collision with root package name */
        public NearbySearchResult f8003b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public PoiItem f8004a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f8005b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public PoiItemV2 f8006a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f8007b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public PoiResult f8008a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearch.OnPoiSearchListener f8009b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public PoiResultV2 f8010a;

        /* renamed from: b, reason: collision with root package name */
        public PoiSearchV2.OnPoiSearchListener f8011b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public RegeocodeResult f8012a;

        /* renamed from: b, reason: collision with root package name */
        public GeocodeSearch.OnGeocodeSearchListener f8013b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class m {

        /* renamed from: a, reason: collision with root package name */
        public RoutePOISearchResult f8014a;

        /* renamed from: b, reason: collision with root package name */
        public RoutePOISearch.OnRoutePOISearchListener f8015b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherForecastResult f8016a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f8017b;
    }

    /* compiled from: MessageHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        public LocalWeatherLiveResult f8018a;

        /* renamed from: b, reason: collision with root package name */
        public WeatherSearch.OnWeatherSearchListener f8019b;
    }

    public y() {
    }

    public static synchronized y a() {
        y yVar;
        synchronized (y.class) {
            if (f7989a == null) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    f7989a = new y();
                }
                f7989a = new y(Looper.getMainLooper());
            }
            yVar = f7989a;
        }
        return yVar;
    }

    private static void b(Message message) {
        List list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ((NearbySearch.NearbyListener) iterator2.next()).onNearbyInfoUploaded(message.what);
        }
    }

    private static void c(Message message) {
        List<NearbySearch.NearbyListener> list;
        g gVar = (g) message.obj;
        if (gVar == null || (list = gVar.f8002a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? gVar.f8003b : null;
        Iterator<NearbySearch.NearbyListener> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    private static void d(Message message) {
        List list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ((NearbySearch.NearbyListener) iterator2.next()).onUserInfoCleared(message.what);
        }
    }

    private static void e(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        c cVar = (c) message.obj;
        if (cVar == null || (onBusStationSearchListener = cVar.f7995b) == null) {
            return;
        }
        int i10 = message.what;
        onBusStationSearchListener.onBusStationSearched(i10 == 1000 ? cVar.f7994a : null, i10);
    }

    private static void f(Message message) {
        h hVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i10 = message.what;
        if (i10 == 600) {
            j jVar = (j) message.obj;
            if (jVar == null || (onPoiSearchListener = jVar.f8009b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(jVar.f8008a, data.getInt("errorCode"));
            return;
        }
        if (i10 != 602 || (hVar = (h) message.obj) == null) {
            return;
        }
        PoiSearch.OnPoiSearchListener onPoiSearchListener2 = hVar.f8005b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(hVar.f8004a, data2.getInt("errorCode"));
        }
    }

    private static void g(Message message) {
        i iVar;
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i10 = message.what;
        if (i10 == 603) {
            k kVar = (k) message.obj;
            if (kVar == null || (onPoiSearchListener = kVar.f8011b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(kVar.f8010a, data.getInt("errorCode"));
            return;
        }
        if (i10 != 604 || (iVar = (i) message.obj) == null) {
            return;
        }
        PoiSearchV2.OnPoiSearchListener onPoiSearchListener2 = iVar.f8007b;
        Bundle data2 = message.getData();
        if (data2 != null) {
            onPoiSearchListener2.onPoiItemSearched(iVar.f8006a, data2.getInt("errorCode"));
        }
    }

    private static void h(Message message) {
        a aVar;
        if (message.what != 600 || (aVar = (a) message.obj) == null) {
            return;
        }
        AutoTSearch.OnChargeStationListener onChargeStationListener = aVar.f7991b;
        Bundle data = message.getData();
        if (data != null) {
            int i10 = data.getInt("errorCode");
            if (onChargeStationListener != null) {
                onChargeStationListener.onChargeStationSearched(aVar.f7990a, i10);
            }
        }
    }

    private static void i(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
    }

    private static void j(Message message) {
        f fVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i10 = message.what;
        if (i10 == 201) {
            l lVar = (l) message.obj;
            if (lVar == null || (onGeocodeSearchListener2 = lVar.f8013b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(lVar.f8012a, message.arg2);
            return;
        }
        if (i10 != 200 || (fVar = (f) message.obj) == null || (onGeocodeSearchListener = fVar.f8001b) == null) {
            return;
        }
        onGeocodeSearchListener.onGeocodeSearched(fVar.f8000a, message.arg2);
    }

    private static void k(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
    }

    private static void l(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        b bVar = (b) message.obj;
        if (bVar == null || (onBusLineSearchListener = bVar.f7993b) == null) {
            return;
        }
        int i10 = message.what;
        onBusLineSearchListener.onBusLineSearched(i10 == 1000 ? bVar.f7992a : null, i10);
    }

    private static void m(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i10 = message.what;
        if (i10 == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 != 104 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void n(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i10 = message.what;
        if (i10 == 101) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable("result"), data2.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 100) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResultV2) message.getData().getParcelable("result"), data3.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResultV2) message.getData().getParcelable("result"), data4.getInt("errorCode"));
                return;
            }
            return;
        }
        if (i10 != 103 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onRideRouteSearched((RideRouteResultV2) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void o(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void p(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void q(Message message) {
        d dVar;
        int i10 = message.what;
        if (i10 == 700) {
            e eVar = (e) message.obj;
            if (eVar == null) {
                return;
            }
            eVar.f7999b.onCloudSearched(eVar.f7998a, message.arg2);
            return;
        }
        if (i10 != 701 || (dVar = (d) message.obj) == null) {
            return;
        }
        dVar.f7997b.onCloudItemDetailSearched(dVar.f7996a, message.arg2);
    }

    private static void r(Message message) {
        n nVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i10 = message.what;
        if (i10 == 1301) {
            o oVar = (o) message.obj;
            if (oVar == null || (onWeatherSearchListener2 = oVar.f8019b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(oVar.f8018a, data2.getInt("errorCode"));
            return;
        }
        if (i10 != 1302 || (nVar = (n) message.obj) == null || (onWeatherSearchListener = nVar.f8017b) == null || (data = message.getData()) == null) {
            return;
        }
        onWeatherSearchListener.onWeatherForecastSearched(nVar.f8016a, data.getInt("errorCode"));
    }

    private static void s(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        m mVar = (m) message.obj;
        if (mVar == null || (onRoutePOISearchListener = mVar.f8015b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(mVar.f8014a, data.getInt("errorCode"));
    }

    private static void t(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i10 = message.arg1;
            if (i10 != 101) {
                switch (i10) {
                    case 1:
                        m(message);
                        return;
                    case 2:
                        j(message);
                        return;
                    case 3:
                        l(message);
                        return;
                    case 4:
                        k(message);
                        return;
                    case 5:
                        i(message);
                        return;
                    case 6:
                        f(message);
                        return;
                    case 7:
                        e(message);
                        return;
                    case 8:
                        d(message);
                        return;
                    case 9:
                        c(message);
                        return;
                    case 10:
                        b(message);
                        return;
                    case 11:
                        a(message);
                        return;
                    case 12:
                        q(message);
                        return;
                    case 13:
                        r(message);
                        return;
                    case 14:
                        s(message);
                        return;
                    default:
                        switch (i10) {
                            case 16:
                                t(message);
                                return;
                            case 17:
                                o(message);
                                return;
                            case 18:
                                p(message);
                                return;
                            case 19:
                                g(message);
                                return;
                            case 20:
                                h(message);
                                return;
                            default:
                                return;
                        }
                }
            }
            n(message);
        } catch (Throwable th) {
            com.amap.api.col.s.n.a(th, "MessageHandler", "handleMessage");
        }
    }

    private y(Looper looper) {
        super(looper);
    }

    private static void a(Message message) {
        int i10 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i10);
                return;
            case 1101:
                onShareSearchListener.onLocationShareUrlSearched(string, i10);
                return;
            case 1102:
                onShareSearchListener.onNaviShareUrlSearched(string, i10);
                return;
            case 1103:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i10);
                return;
            case 1104:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i10);
                return;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i10);
                return;
            default:
                return;
        }
    }
}

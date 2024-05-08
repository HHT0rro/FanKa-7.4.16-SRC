package com.cupidapp.live.base.utils;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.LatLng;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.sensorslog.TrackAppErrorType;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LocationUtils {

    /* renamed from: h */
    @NotNull
    public static final Companion f12270h = new Companion(null);

    /* renamed from: i */
    @NotNull
    public static final Lazy<LocationUtils> f12271i = kotlin.c.b(new Function0<LocationUtils>() { // from class: com.cupidapp.live.base.utils.LocationUtils$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final LocationUtils invoke() {
            return new LocationUtils();
        }
    });

    /* renamed from: a */
    public long f12272a;

    /* renamed from: c */
    @Nullable
    public a f12274c;

    /* renamed from: d */
    @Nullable
    public AMapLocationClient f12275d;

    /* renamed from: e */
    @Nullable
    public Context f12276e;

    /* renamed from: g */
    @Nullable
    public SimpleDateFormat f12278g;

    /* renamed from: b */
    @NotNull
    public CoordinateModel f12273b = new CoordinateModel(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);

    /* renamed from: f */
    @NotNull
    public final AMapLocationListener f12277f = new AMapLocationListener() { // from class: com.cupidapp.live.base.utils.e0
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            LocationUtils.p(LocationUtils.this, aMapLocation);
        }
    };

    /* compiled from: LocationUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocationUtils a() {
            return (LocationUtils) LocationUtils.f12271i.getValue();
        }

        public final boolean b(@Nullable Context context) {
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                Object systemService = context.getSystemService("location");
                LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
                if (locationManager == null || !locationManager.isLocationEnabled()) {
                    return false;
                }
            } else {
                try {
                    if (Settings.Secure.getInt(context.getContentResolver(), "location_mode") == 0) {
                        return false;
                    }
                } catch (Settings.SettingNotFoundException e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return true;
        }

        public final boolean c(@Nullable Context context) {
            return (context != null && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36121g) == 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36122h) == 0) ? false : true;
        }

        public final boolean d(@Nullable Context context) {
            return c(context) || !b(context);
        }

        public final void e(@NotNull final Context context, @NotNull xb.b rxPermissions, @Nullable Function0<kotlin.p> function0) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(rxPermissions, "rxPermissions");
            PermissionType permissionType = PermissionType.LocationPermission;
            if (RxPermissionHelperKt.h(context, permissionType)) {
                if (!b(context)) {
                    FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null), R$string.open_location_service_content, 0, 2, null), R$string.go_to_set, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.utils.LocationUtils$Companion$requestLocation$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ kotlin.p invoke() {
                            invoke2();
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                        }
                    }, 2, null), 0, null, 3, null), null, 1, null);
                    return;
                } else {
                    if (function0 != null) {
                        function0.invoke();
                        return;
                    }
                    return;
                }
            }
            RxPermissionHelperKt.m(context, rxPermissions, kotlin.collections.r.e(permissionType), null, false, 24, null);
        }
    }

    /* compiled from: LocationUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(@Nullable Integer num, @Nullable String str);

        void b(double d10, double d11);
    }

    /* compiled from: LocationUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements a {

        /* renamed from: b */
        public final /* synthetic */ Function0<kotlin.p> f12280b;

        /* renamed from: c */
        public final /* synthetic */ Function2<Integer, String, kotlin.p> f12281c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<kotlin.p> function0, Function2<? super Integer, ? super String, kotlin.p> function2) {
            this.f12280b = function0;
            this.f12281c = function2;
        }

        @Override // com.cupidapp.live.base.utils.LocationUtils.a
        public void a(@Nullable Integer num, @Nullable String str) {
            LocationUtils.this.f12274c = null;
            Function2<Integer, String, kotlin.p> function2 = this.f12281c;
            if (function2 != null) {
                function2.mo1743invoke(num, str);
            }
        }

        @Override // com.cupidapp.live.base.utils.LocationUtils.a
        public void b(double d10, double d11) {
            LocationUtils.this.f12274c = null;
            Function0<kotlin.p> function0 = this.f12280b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AMapLocationClient o(LocationUtils locationUtils, Context context, Function0 function0, Function2 function2, Function0 function02, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        if ((i10 & 4) != 0) {
            function2 = null;
        }
        if ((i10 & 8) != 0) {
            function02 = null;
        }
        return locationUtils.n(context, function0, function2, function02);
    }

    public static final void p(LocationUtils this$0, AMapLocation aMapLocation) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (aMapLocation != null) {
            this$0.l(aMapLocation);
            if (!(aMapLocation.getLatitude() == ShadowDrawableWrapper.COS_45)) {
                if (!(aMapLocation.getLongitude() == ShadowDrawableWrapper.COS_45)) {
                    this$0.m(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    this$0.r(aMapLocation);
                    return;
                }
            }
            this$0.s(aMapLocation);
            return;
        }
        this$0.s(null);
    }

    public final boolean f() {
        if (this.f12273b.getLatitude() == ShadowDrawableWrapper.COS_45) {
            if (this.f12273b.getLongitude() == ShadowDrawableWrapper.COS_45) {
                return true;
            }
        }
        return false;
    }

    public final void g() {
        AMapLocationClient aMapLocationClient = this.f12275d;
        if (aMapLocationClient != null) {
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            AMapLocationClient aMapLocationClient2 = this.f12275d;
            if (aMapLocationClient2 != null) {
                aMapLocationClient2.onDestroy();
            }
            this.f12275d = null;
        }
    }

    public final void h(@Nullable AMapLocationClient aMapLocationClient) {
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
        if (aMapLocationClient != null) {
            aMapLocationClient.onDestroy();
        }
    }

    public final synchronized String i(long j10, String str) {
        String format;
        if (TextUtils.isEmpty(str)) {
            str = TimeUtils.STARD_FROMAT;
        }
        SimpleDateFormat simpleDateFormat = this.f12278g;
        if (simpleDateFormat == null) {
            try {
                this.f12278g = new SimpleDateFormat(str, Locale.CHINA);
            } catch (Throwable unused) {
            }
        } else {
            kotlin.jvm.internal.s.f(simpleDateFormat);
            simpleDateFormat.applyPattern(str);
        }
        SimpleDateFormat simpleDateFormat2 = this.f12278g;
        if (simpleDateFormat2 == null) {
            format = "NULL";
        } else {
            kotlin.jvm.internal.s.f(simpleDateFormat2);
            format = simpleDateFormat2.format(Long.valueOf(j10));
            kotlin.jvm.internal.s.h(format, "sdf!!.format(l)");
        }
        return format;
    }

    @NotNull
    public final CoordinateModel j() {
        return this.f12273b;
    }

    public final AMapLocationClientOption k() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(false);
        aMapLocationClientOption.setHttpTimeOut(30000L);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setOnceLocationLatest(false);
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        aMapLocationClientOption.setSensorEnable(false);
        aMapLocationClientOption.setWifiScan(true);
        aMapLocationClientOption.setLocationCacheEnable(false);
        return aMapLocationClientOption;
    }

    public final synchronized String l(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (aMapLocation.getErrorCode() == 0) {
            stringBuffer.append("定位成功\n");
            stringBuffer.append("定位类型: " + aMapLocation.getLocationType() + "\n");
            stringBuffer.append("经    度    : " + aMapLocation.getLongitude() + "\n");
            stringBuffer.append("纬    度    : " + aMapLocation.getLatitude() + "\n");
            stringBuffer.append("精    度    : " + aMapLocation.getAccuracy() + "米\n");
            stringBuffer.append("提供者    : " + aMapLocation.getProvider() + "\n");
            stringBuffer.append("速    度    : " + aMapLocation.getSpeed() + "米/秒\n");
            stringBuffer.append("角    度    : " + aMapLocation.getBearing() + "\n");
            stringBuffer.append("星    数    : " + aMapLocation.getSatellites() + "\n");
            stringBuffer.append("国    家    : " + aMapLocation.getCountry() + "\n");
            stringBuffer.append("省            : " + aMapLocation.getProvince() + "\n");
            stringBuffer.append("市            : " + aMapLocation.getCity() + "\n");
            stringBuffer.append("城市编码 : " + aMapLocation.getCityCode() + "\n");
            stringBuffer.append("区            : " + aMapLocation.getDistrict() + "\n");
            stringBuffer.append("区域 码   : " + aMapLocation.getAdCode() + "\n");
            stringBuffer.append("地    址    : " + aMapLocation.getAddress() + "\n");
            stringBuffer.append("兴趣点    : " + aMapLocation.getPoiName() + "\n");
            stringBuffer.append("DeviceId    : " + AMapLocationClient.getDeviceId(this.f12276e) + "\n");
            stringBuffer.append("定位时间: " + i(aMapLocation.getTime(), TimeUtils.STARD_FROMAT) + "\n");
        } else {
            stringBuffer.append("定位失败\n");
            stringBuffer.append("错误码:" + aMapLocation.getErrorCode() + "\n");
            stringBuffer.append("错误信息:" + aMapLocation.getErrorInfo() + "\n");
            stringBuffer.append("错误描述:" + aMapLocation.getLocationDetail() + "\n");
        }
        stringBuffer.append("回调时间: " + i(System.currentTimeMillis(), TimeUtils.STARD_FROMAT) + "\n");
        j.a aVar = j.f12332a;
        String stringBuffer2 = stringBuffer.toString();
        kotlin.jvm.internal.s.h(stringBuffer2, "sb.toString()");
        aVar.a(com.wangmai.common.utils.LocationUtils.TAG, stringBuffer2);
        return stringBuffer.toString();
    }

    public final void m(double d10, double d11) {
        this.f12273b = new CoordinateModel(d10, d11);
        this.f12272a = System.currentTimeMillis();
        z3.c.f54829a.n(String.valueOf(d10), String.valueOf(d11));
        Disposable disposed = NetworkClient.f11868a.s().c(Double.valueOf(d10), Double.valueOf(d11)).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.base.utils.LocationUtils$handleLocationSuc$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        a aVar = this.f12274c;
        if (aVar != null) {
            aVar.b(d10, d11);
        }
    }

    @Nullable
    public final AMapLocationClient n(@Nullable Context context, @Nullable Function0<kotlin.p> function0, @Nullable Function2<? super Integer, ? super String, kotlin.p> function2, @Nullable Function0<kotlin.p> function02) {
        if (context == null) {
            if (function02 != null) {
                function02.invoke();
            }
            return null;
        }
        this.f12276e = context;
        AMapLocationClient.updatePrivacyShow(context, true, true);
        AMapLocationClient.updatePrivacyAgree(context, true);
        if (f12270h.d(context)) {
            if (function02 != null) {
                function02.invoke();
            }
            return null;
        }
        g();
        AMapLocationClient aMapLocationClient = new AMapLocationClient(context);
        this.f12275d = aMapLocationClient;
        aMapLocationClient.setLocationOption(k());
        AMapLocationClient aMapLocationClient2 = this.f12275d;
        if (aMapLocationClient2 != null) {
            aMapLocationClient2.setLocationListener(this.f12277f);
        }
        AMapLocationClient aMapLocationClient3 = this.f12275d;
        if (aMapLocationClient3 != null) {
            aMapLocationClient3.startLocation();
        }
        this.f12274c = new b(function0, function2);
        return this.f12275d;
    }

    public final boolean q(long j10) {
        return this.f12272a != 0 && System.currentTimeMillis() - this.f12272a > j10;
    }

    public final void r(AMapLocation aMapLocation) {
        GroupOthersLog.f18702a.O("高德", Double.valueOf(aMapLocation.getLongitude()), Double.valueOf(aMapLocation.getLatitude()), "", Integer.valueOf(aMapLocation.getLocationType()), AMapLocationClient.getDeviceId(this.f12276e), String.valueOf(aMapLocation.getAccuracy()), aMapLocation.getProvider(), i(aMapLocation.getTime(), TimeUtils.STARD_FROMAT), i(System.currentTimeMillis(), TimeUtils.STARD_FROMAT), aMapLocation.getAddress());
    }

    public final void s(final AMapLocation aMapLocation) {
        Context context = this.f12276e;
        if (context != null) {
            new d0(context, new Function1<LatLng, kotlin.p>() { // from class: com.cupidapp.live.base.utils.LocationUtils$useSecondGetLocationUtil$locationGps$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(LatLng latLng) {
                    invoke2(latLng);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LatLng it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    LocationUtils.this.m(it.latitude, it.longitude);
                }
            }, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.utils.LocationUtils$useSecondGetLocationUtil$locationGps$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LocationUtils.a aVar;
                    aVar = LocationUtils.this.f12274c;
                    if (aVar != null) {
                        AMapLocation aMapLocation2 = aMapLocation;
                        Integer valueOf = aMapLocation2 != null ? Integer.valueOf(aMapLocation2.getErrorCode()) : null;
                        AMapLocation aMapLocation3 = aMapLocation;
                        aVar.a(valueOf, aMapLocation3 != null ? aMapLocation3.getErrorInfo() : null);
                    }
                    j1.f fVar = j1.f.f50231a;
                    TrackAppErrorType trackAppErrorType = TrackAppErrorType.LOCATION_FAILED;
                    AMapLocation aMapLocation4 = aMapLocation;
                    Integer valueOf2 = aMapLocation4 != null ? Integer.valueOf(aMapLocation4.getErrorCode()) : null;
                    AMapLocation aMapLocation5 = aMapLocation;
                    fVar.a(trackAppErrorType, "第二次谷歌失败，高德错误信息:errorCode:" + ((Object) valueOf2) + ",errorInfo:" + (aMapLocation5 != null ? aMapLocation5.getErrorInfo() : null));
                }
            }).f();
        } else {
            a aVar = this.f12274c;
            if (aVar != null) {
                aVar.a(aMapLocation != null ? Integer.valueOf(aMapLocation.getErrorCode()) : null, aMapLocation != null ? aMapLocation.getErrorInfo() : null);
            }
        }
        j1.f fVar = j1.f.f50231a;
        TrackAppErrorType trackAppErrorType = TrackAppErrorType.LOCATION_FAILED;
        Integer valueOf = aMapLocation != null ? Integer.valueOf(aMapLocation.getErrorCode()) : null;
        fVar.a(trackAppErrorType, "使用高德失败:errorCode:" + ((Object) valueOf) + ",errorInfo:" + (aMapLocation != null ? aMapLocation.getErrorInfo() : null));
    }
}

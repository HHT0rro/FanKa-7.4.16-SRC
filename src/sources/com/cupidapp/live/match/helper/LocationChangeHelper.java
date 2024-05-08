package com.cupidapp.live.match.helper;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LocationChangeModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.UserVipType;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.match.event.ReloadSwipeCardEvent;
import com.cupidapp.live.match.model.LocationChangedModel;
import com.cupidapp.live.match.view.LocationChangedSucDialog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocationChangeHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocationChangeHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LocationChangeHelper f16770a = new LocationChangeHelper();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f16771b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f16772c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f16773d;

    /* compiled from: LocationChangeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements com.cupidapp.live.match.view.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationChangeModel f16774a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f16775b;

        public a(LocationChangeModel locationChangeModel, Context context) {
            this.f16774a = locationChangeModel;
            this.f16775b = context;
        }

        @Override // com.cupidapp.live.match.view.a
        public void a() {
            LocationChangeHelper.f16770a.c(this.f16774a, this.f16775b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(final LocationChangeModel locationChangeModel, final Context context) {
        Observable<Result<LocationChangedModel>> d10 = NetworkClient.f11868a.A().d();
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = d10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LocationChangedModel, p>() { // from class: com.cupidapp.live.match.helper.LocationChangeHelper$changeLocation$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LocationChangedModel locationChangedModel) {
                m2717invoke(locationChangedModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2717invoke(LocationChangedModel locationChangedModel) {
                LocationChangedModel locationChangedModel2 = locationChangedModel;
                if (UserVipType.Companion.a(LocationChangeModel.this.getVipType())) {
                    h hVar = h.f12779a;
                    Context context2 = context;
                    y yVar = y.f51038a;
                    String string = context2.getString(R$string.location_changed_to);
                    s.h(string, "context.getString(R.string.location_changed_to)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{LocationChangeModel.this.getCityName()}, 1));
                    s.h(format, "format(format, *args)");
                    hVar.m(context2, format);
                } else {
                    LocationChangeHelper.f16770a.h(locationChangedModel2, context);
                }
                EventBus.c().o(new ReloadSwipeCardEvent());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(final Context context) {
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null ? s.d(q10.getLocationPrioritySwitch(), Boolean.TRUE) : false) {
            Observable<Result<LocationChangeModel>> l10 = NetworkClient.f11868a.i().l();
            LocationChangeHelper$checkLocationChange$2 locationChangeHelper$checkLocationChange$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.helper.LocationChangeHelper$checkLocationChange$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    return Boolean.TRUE;
                }
            };
            g gVar = context instanceof g ? (g) context : null;
            Disposable disposed = l10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LocationChangeModel, p>() { // from class: com.cupidapp.live.match.helper.LocationChangeHelper$checkLocationChange$$inlined$handleByContext$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(LocationChangeModel locationChangeModel) {
                    m2718invoke(locationChangeModel);
                    return p.f51048a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
                
                    if ((r0.length() > 0) == true) goto L11;
                 */
                /* renamed from: invoke, reason: collision with other method in class */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void m2718invoke(com.cupidapp.live.base.network.model.LocationChangeModel r4) {
                    /*
                        r3 = this;
                        com.cupidapp.live.base.network.model.LocationChangeModel r4 = (com.cupidapp.live.base.network.model.LocationChangeModel) r4
                        java.lang.String r0 = r4.getCityName()
                        r1 = 1
                        r2 = 0
                        if (r0 == 0) goto L16
                        int r0 = r0.length()
                        if (r0 <= 0) goto L12
                        r0 = 1
                        goto L13
                    L12:
                        r0 = 0
                    L13:
                        if (r0 != r1) goto L16
                        goto L17
                    L16:
                        r1 = 0
                    L17:
                        if (r1 == 0) goto L33
                        com.cupidapp.live.match.view.LocationChangeTipDialog$a r0 = com.cupidapp.live.match.view.LocationChangeTipDialog.f16942e
                        android.content.Context r1 = r1
                        com.cupidapp.live.match.view.LocationChangeTipDialog r0 = r0.a(r1)
                        com.cupidapp.live.match.view.LocationChangeTipDialog r0 = r0.d(r4)
                        com.cupidapp.live.match.helper.LocationChangeHelper$a r1 = new com.cupidapp.live.match.helper.LocationChangeHelper$a
                        android.content.Context r2 = r1
                        r1.<init>(r4, r2)
                        com.cupidapp.live.match.view.LocationChangeTipDialog r4 = r0.f(r1)
                        r4.g()
                    L33:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.helper.LocationChangeHelper$checkLocationChange$$inlined$handleByContext$1.m2718invoke(java.lang.Object):void");
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(locationChangeHelper$checkLocationChange$2, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    public final void e(boolean z10) {
        f16771b = z10;
    }

    public final void f(boolean z10) {
        f16772c = z10;
    }

    public final void g(@NotNull Context context) {
        s.i(context, "context");
        if (!f16773d && f16771b && f16772c) {
            f16773d = true;
            d(context);
        }
    }

    public final void h(LocationChangedModel locationChangedModel, Context context) {
        LocationChangedSucDialog.f16946d.a(context).c(locationChangedModel).e();
    }
}

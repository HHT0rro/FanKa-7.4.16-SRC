package com.cupidapp.live.liveshow.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.grpc.GrpcConnectEvent;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.share.view.b;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.web.WebConfigViewModel;
import com.cupidapp.live.base.web.activity.FKTransparentWebActivity;
import com.cupidapp.live.base.web.fragment.FKTransparentWebFragment;
import com.cupidapp.live.base.web.fragment.FKWebViewFragment;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.fragment.LiveShowWebFragment;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog;
import com.cupidapp.live.liveshow.view.dialog.ShowLiveHeatCountEvent;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.huawei.quickcard.base.Attributes;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: FKBaseLiveActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKBaseLiveActivity extends FKBaseActivity {

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public o f14732q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14733r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.view.o f14734s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public FKLiveMiniProfileFragment f14735t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public LiveHeatCountDesDialog f14736u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public FKWebViewFragment f14737v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public FKTransparentWebFragment f14738w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public LiveShowWebFragment f14739x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14740y = new LinkedHashMap();

    /* compiled from: FKBaseLiveActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements FKTransparentWebFragment.b {
        public a() {
        }

        @Override // com.cupidapp.live.base.web.fragment.FKTransparentWebFragment.b
        public void a(boolean z10) {
            if (z10) {
                FrameLayout o12 = FKBaseLiveActivity.this.o1();
                if (o12 == null) {
                    return;
                }
                o12.setVisibility(0);
                return;
            }
            FKBaseLiveActivity.this.m1();
        }
    }

    /* compiled from: FKBaseLiveActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements o.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SensorPosition f14742a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SensorPosition f14743b;

        public b(SensorPosition sensorPosition, SensorPosition sensorPosition2) {
            this.f14742a = sensorPosition;
            this.f14743b = sensorPosition2;
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            User user;
            k kVar = k.f50238a;
            SensorPosition sensorPosition = this.f14742a;
            String value = this.f14743b.getValue();
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            kVar.a(sensorPosition, value, (liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.userId(), j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            User user;
            s.i(imageUriString, "imageUriString");
            k kVar = k.f50238a;
            SensorPosition sensorPosition = this.f14742a;
            String value = this.f14743b.getValue();
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            kVar.c(sensorPosition, value, (liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.userId(), z10);
        }
    }

    /* compiled from: FKBaseLiveActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.base.share.view.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveShowModel f14745b;

        public c(LiveShowModel liveShowModel) {
            this.f14745b = liveShowModel;
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void a(@NotNull ShareItemHandledResult shareItemHandledResult) {
            b.a.a(this, shareItemHandledResult);
        }

        @Override // com.cupidapp.live.base.share.view.b
        public void b(@NotNull ShareBaseType type) {
            s.i(type, "type");
            if (type instanceof SharePlatform) {
                FKBaseLiveActivity.this.z1(this.f14745b, (SharePlatform) type);
            }
        }
    }

    public static /* synthetic */ void C1(FKBaseLiveActivity fKBaseLiveActivity, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWebView");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        fKBaseLiveActivity.B1(str, z10);
    }

    public static final void n1(FKBaseLiveActivity this$0) {
        s.i(this$0, "this$0");
        FrameLayout o12 = this$0.o1();
        if (o12 == null) {
            return;
        }
        o12.setVisibility(4);
    }

    public static final void s1(FKBaseLiveActivity this$0) {
        s.i(this$0, "this$0");
        FrameLayout o12 = this$0.o1();
        if (o12 == null) {
            return;
        }
        o12.setVisibility(0);
    }

    public final void A1() {
        ShareBuilder b4;
        SensorPosition sensorPosition = this.f14733r ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (b4 = com.cupidapp.live.base.share.helper.d.f12255a.b(this, liveShowModel.getUser(), liveShowModel, sensorPosition, null)) == null) {
            return;
        }
        ShareBottomFragment a10 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        s.h(supportFragmentManager, "supportFragmentManager");
        a10.v1(supportFragmentManager, new ShareModel(null, null, b4, null, null, sensorPosition, null, null, null, null, null, 2011, null), new c(liveShowModel));
    }

    public final void B1(@Nullable String str, boolean z10) {
        int l10;
        if (z10) {
            LiveShowWebFragment b4 = LiveShowWebFragment.a.b(LiveShowWebFragment.f15059k, str, false, 2, null);
            this.f14739x = b4;
            if (b4 != null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                s.h(supportFragmentManager, "supportFragmentManager");
                b4.e1(supportFragmentManager);
                return;
            }
            return;
        }
        final FrameLayout o12 = o1();
        if (o12 != null && this.f14737v == null && this.f14738w == null) {
            if (str == null || str.length() == 0) {
                return;
            }
            String queryParameter = Uri.parse(str).getQueryParameter(Attributes.Style.ASPECT_RATIO);
            Float valueOf = queryParameter != null ? Float.valueOf(Float.parseFloat(queryParameter)) : null;
            float k10 = h.k(this) / h.l(this);
            if (valueOf == null) {
                l10 = (int) ((h.k(this) / 3) * 2.0f);
            } else {
                l10 = valueOf.floatValue() >= k10 ? -1 : (int) (h.l(this) * valueOf.floatValue());
            }
            y.o(o12, null, Integer.valueOf(l10), 1, null);
            if (l10 == -1) {
                y.m(o12, null, Integer.valueOf(h.m(this)), null, null, 13, null);
            }
            getWindow().setSoftInputMode(32);
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R$anim.anim_activity_bottom_to_top, 0, 0, R$anim.anim_activity_top_to_bottom).addToBackStack(null).replace(o12.getId(), r1(str)).commit();
            w1(new Function2<Integer, Boolean, p>() { // from class: com.cupidapp.live.liveshow.activity.FKBaseLiveActivity$showWebView$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Boolean bool) {
                    invoke(num.intValue(), bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(int i10, boolean z11) {
                    if (z11) {
                        FrameLayout.this.setTranslationY(-i10);
                    } else {
                        FrameLayout.this.setTranslationY(0.0f);
                    }
                }
            });
        }
    }

    public final void D1() {
        com.cupidapp.live.base.view.o oVar = this.f14734s;
        if (oVar != null) {
            oVar.d();
        }
    }

    public final boolean m1() {
        if (!u1()) {
            return false;
        }
        p0.c(this, true, 0, 2, null);
        getWindow().setSoftInputMode(48);
        this.f14738w = null;
        this.f14737v = null;
        LiveShowWebFragment liveShowWebFragment = this.f14739x;
        if (liveShowWebFragment != null) {
            liveShowWebFragment.dismiss();
        }
        this.f14739x = null;
        LiveHeatCountDesDialog liveHeatCountDesDialog = this.f14736u;
        if (liveHeatCountDesDialog != null) {
            liveHeatCountDesDialog.c();
        }
        getSupportFragmentManager().popBackStackImmediate();
        FrameLayout o12 = o1();
        if (o12 != null) {
            o12.postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    FKBaseLiveActivity.n1(FKBaseLiveActivity.this);
                }
            }, 200L);
        }
        D1();
        return true;
    }

    @Nullable
    public FrameLayout o1() {
        return null;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        p0.c(this, true, 0, 2, null);
        x1();
        this.f14734s = new com.cupidapp.live.base.view.o(this);
        com.cupidapp.live.push.d.f17892a.j(true);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.cupidapp.live.push.d.f17892a.j(false);
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKLiveCloseWebFragmentEvent event) {
        s.i(event, "event");
        m1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        o oVar = this.f14732q;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.push.d.f17892a.j(true);
        o oVar = this.f14732q;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Nullable
    public final LiveHeatCountDesDialog p1() {
        return this.f14736u;
    }

    @Nullable
    public final FKLiveMiniProfileFragment q1() {
        return this.f14735t;
    }

    public final Fragment r1(String str) {
        if (StringsKt__StringsKt.K(str, "showTransparentBg", false, 2, null)) {
            FKTransparentWebFragment b4 = FKTransparentWebFragment.a.b(FKTransparentWebFragment.f13065l, str, null, new a(), 2, null);
            this.f14738w = b4;
            s.f(b4);
            return b4;
        }
        FrameLayout o12 = o1();
        if (o12 != null) {
            o12.postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.activity.a
                @Override // java.lang.Runnable
                public final void run() {
                    FKBaseLiveActivity.s1(FKBaseLiveActivity.this);
                }
            }, 200L);
        }
        FKWebViewFragment e2 = FKWebViewFragment.a.e(FKWebViewFragment.f13075p, str, null, new WebConfigViewModel(false, false, false, false, false, null, false, 126, null), 2, null);
        this.f14737v = e2;
        s.f(e2);
        return e2;
    }

    public void t1(boolean z10) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r0.isAdded() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r0.isAdded() == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u1() {
        /*
            r3 = this;
            com.cupidapp.live.base.web.fragment.FKWebViewFragment r0 = r3.f14737v
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
            kotlin.jvm.internal.s.f(r0)
            boolean r0 = r0.isAdded()
            if (r0 != 0) goto L38
        Lf:
            com.cupidapp.live.base.web.fragment.FKTransparentWebFragment r0 = r3.f14738w
            if (r0 == 0) goto L1c
            kotlin.jvm.internal.s.f(r0)
            boolean r0 = r0.isAdded()
            if (r0 != 0) goto L38
        L1c:
            com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog r0 = r3.f14736u
            if (r0 == 0) goto L28
            boolean r0 = r0.f()
            if (r0 != r2) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            if (r0 != 0) goto L38
            com.cupidapp.live.liveshow.fragment.LiveShowWebFragment r0 = r3.f14739x
            if (r0 == 0) goto L39
            kotlin.jvm.internal.s.f(r0)
            boolean r0 = r0.isAdded()
            if (r0 == 0) goto L39
        L38:
            r1 = 1
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.activity.FKBaseLiveActivity.u1():boolean");
    }

    public final void v1(@NotNull String url) {
        s.i(url, "url");
        m1();
        FKTransparentWebActivity.a.b(FKTransparentWebActivity.f13044w, this, url, false, null, 12, null);
    }

    public final void w1(@NotNull final Function2<? super Integer, ? super Boolean, p> registerCallback) {
        s.i(registerCallback, "registerCallback");
        com.cupidapp.live.base.view.o oVar = this.f14734s;
        if (oVar != null) {
            oVar.b(new Function2<Integer, Boolean, p>() { // from class: com.cupidapp.live.liveshow.activity.FKBaseLiveActivity$registerKeyboardWatcher$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Boolean bool) {
                    invoke(num.intValue(), bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(int i10, boolean z10) {
                    registerCallback.mo1743invoke(Integer.valueOf(i10), Boolean.valueOf(z10));
                }
            });
        }
    }

    public final void x1() {
        o c4 = o.f12354i.c(this);
        this.f14732q = c4;
        boolean z10 = this.f14733r;
        SensorPosition sensorPosition = z10 ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom;
        SensorPosition sensorPosition2 = z10 ? SensorPosition.LiveShowRoom : SensorPosition.LiveShow;
        if (c4 != null) {
            c4.l(new b(sensorPosition, sensorPosition2));
        }
    }

    public final void y1(boolean z10) {
        this.f14733r = z10;
    }

    public final void z1(LiveShowModel liveShowModel, SharePlatform sharePlatform) {
        NetworkClient networkClient = NetworkClient.f11868a;
        Disposable disposed = networkClient.r().M(liveShowModel.getUser().userId(), liveShowModel.getItemId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKBaseLiveActivity$shareAndSta$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
        Disposable disposed2 = networkClient.r().d0(liveShowModel.getUser().userId(), liveShowModel.getItemId(), sharePlatform != null ? sharePlatform.getValue() : null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKBaseLiveActivity$shareAndSta$$inlined$handle$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            H(disposed2);
        }
        s.h(disposed2, "disposed");
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowLiveMiniProfileViewModel event) {
        FKLiveForViewerViewModel W1;
        LiveInRoomSensorModel liveRoomSensor;
        s.i(event, "event");
        String str = null;
        FKLiveForViewerActivity fKLiveForViewerActivity = this instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) this : null;
        if (fKLiveForViewerActivity != null && (W1 = fKLiveForViewerActivity.W1()) != null && (liveRoomSensor = W1.getLiveRoomSensor()) != null) {
            str = liveRoomSensor.getEnterSource();
        }
        this.f14735t = FKLiveMiniProfileFragment.f15750k.a(getSupportFragmentManager(), event, str);
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowLiveHeatCountEvent event) {
        LiveHeatCountDesDialog b4;
        s.i(event, "event");
        if (event.getNeedShow()) {
            LiveHeatCountDesDialog a10 = LiveHeatCountDesDialog.f15405e.a(this);
            this.f14736u = a10;
            if (a10 != null && (b4 = a10.b(event.getHeatValuesModel())) != null) {
                b4.h();
            }
            GroupOthersLog.a0(GroupOthersLog.f18702a, "LIVE_ROOM_HOT", null, null, 6, null);
            return;
        }
        LiveHeatCountDesDialog liveHeatCountDesDialog = this.f14736u;
        if (liveHeatCountDesDialog != null) {
            liveHeatCountDesDialog.b(event.getHeatValuesModel());
        }
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull GrpcConnectEvent event) {
        s.i(event, "event");
        if (!event.getConnect()) {
            com.cupidapp.live.base.view.h.f12779a.q(R$string.network_is_error);
        }
        t1(event.getConnect());
    }
}

package com.cupidapp.live.liveshow.helper;

import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.LiveBeautyDownloader;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.permission.FKRxPermissionOpenModel;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity;
import com.cupidapp.live.liveshow.model.CheckLiveResult;
import com.cupidapp.live.liveshow.view.LiveActivitySelectLayout;
import com.cupidapp.live.liveshow.view.music.view.FKLiveMusicProtocolLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import xb.b;

/* compiled from: FKStartLiveHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKStartLiveHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FKStartLiveHelper f15071a = new FKStartLiveHelper();

    /* compiled from: FKStartLiveHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements LiveBeautyDownloader.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FKBaseActivity f15072a;

        public a(FKBaseActivity fKBaseActivity) {
            this.f15072a = fKBaseActivity;
        }

        @Override // com.cupidapp.live.base.network.download.LiveBeautyDownloader.a
        public void onError() {
            this.f15072a.V0();
        }

        @Override // com.cupidapp.live.base.network.download.LiveBeautyDownloader.a
        public void onFinish() {
            this.f15072a.V0();
            FKStartLiveHelper.f15071a.d(this.f15072a);
        }

        @Override // com.cupidapp.live.base.network.download.LiveBeautyDownloader.a
        public void onSuccess() {
            this.f15072a.V0();
            FKStartLiveHelper.f15071a.d(this.f15072a);
        }
    }

    public final void c(FKBaseActivity fKBaseActivity) {
        LiveBeautyDownloader.f11939a.k(fKBaseActivity, true, new a(fKBaseActivity));
    }

    public final void d(final FKBaseActivity fKBaseActivity) {
        FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
        b bVar = new b(fKBaseActivity);
        PermissionType permissionType = PermissionType.CameraPermission;
        PermissionType permissionType2 = PermissionType.AudioPermission;
        companion.j(fKBaseActivity, bVar, new FKRxPermissionOpenModel(R$string.authorize_app_permission_camera_for_open_live, permissionType, permissionType2, s.m(permissionType, permissionType2), false, new Function0<p>() { // from class: com.cupidapp.live.liveshow.helper.FKStartLiveHelper$openLive$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveForStreamerBeautyActivity.Q.a(FKBaseActivity.this);
            }
        }, null, null, null, false, null, null, 4032, null));
    }

    public final void e(@NotNull final FKBaseActivity activity) {
        kotlin.jvm.internal.s.i(activity, "activity");
        activity.e1();
        Disposable disposed = NetworkClient.f11868a.r().A0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CheckLiveResult, p>() { // from class: com.cupidapp.live.liveshow.helper.FKStartLiveHelper$startLive$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CheckLiveResult checkLiveResult) {
                m2623invoke(checkLiveResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2623invoke(CheckLiveResult checkLiveResult) {
                CheckLiveResult checkLiveResult2 = checkLiveResult;
                FKLiveMusicProtocolLayout.f15811e.b(checkLiveResult2.getLiveAgreement());
                LiveActivitySelectLayout.a aVar = LiveActivitySelectLayout.f15298d;
                FKBaseActivity fKBaseActivity = FKBaseActivity.this;
                Boolean activitySelectEnable = checkLiveResult2.getActivitySelectEnable();
                aVar.e(fKBaseActivity, activitySelectEnable != null ? activitySelectEnable.booleanValue() : false, checkLiveResult2.getSelectedActivities(), checkLiveResult2.getActivities());
                FKStartLiveHelper.f15071a.c(FKBaseActivity.this);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.helper.FKStartLiveHelper$startLive$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FKBaseActivity.this.V0();
                return Boolean.FALSE;
            }
        }, activity)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            activity.H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}

package com.cupidapp.live.base.web.helper;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.security.realidentity.common.BuildConfig;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.helper.TencentFaceHelper;
import com.cupidapp.live.base.web.model.FaceInfoModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener;
import com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: TencentFaceHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TencentFaceHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TencentFaceHelper f13090a = new TencentFaceHelper();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f13091b;

    /* compiled from: TencentFaceHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements WbCloudFaceVerifyLoginListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f13092a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FaceInfoModel f13093b;

        public a(Activity activity, FaceInfoModel faceInfoModel) {
            this.f13092a = activity;
            this.f13093b = faceInfoModel;
        }

        public static final void b(Activity activity, FaceInfoModel model, WbFaceVerifyResult wbFaceVerifyResult) {
            s.i(model, "$model");
            TencentFaceHelper tencentFaceHelper = TencentFaceHelper.f13090a;
            TencentFaceHelper.f13091b = false;
            if (wbFaceVerifyResult != null) {
                if (wbFaceVerifyResult.isSuccess()) {
                    j.f12332a.a("TencentFaceHelper", "刷脸成功!");
                    GroupOthersLog.f18702a.z(true, null);
                    tencentFaceHelper.e(activity, model.getOrderNo(), true, null, null);
                } else {
                    WbFaceError error = wbFaceVerifyResult.getError();
                    String str = "{\"domain\":\"" + error.getDomain() + "\",\"code\":\"" + error.getCode() + "\",\"desc\":\"" + error.getDesc() + "\",\"reason\":\"" + error.getReason() + "\"}";
                    String orderNo = model.getOrderNo();
                    String desc = error.getDesc();
                    if (desc == null) {
                        desc = error.getDomain();
                    }
                    tencentFaceHelper.e(activity, orderNo, false, str, desc);
                    GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                    String desc2 = error.getDesc();
                    if (desc2 == null) {
                        desc2 = error.getDomain();
                    }
                    groupOthersLog.z(false, desc2);
                    j.a aVar = j.f12332a;
                    aVar.c("TencentFaceHelper", "刷脸失败！domain=" + error.getDomain() + " ;code= " + error.getCode() + " ;desc=" + error.getDesc() + ";reason=" + error.getReason());
                    if (s.d(error.getDomain(), WbFaceError.WBFaceErrorDomainCompareServer)) {
                        aVar.c("TencentFaceHelper", "对比失败，liveRate=" + wbFaceVerifyResult.getLiveRate() + "; similarity=" + wbFaceVerifyResult.getSimilarity());
                    }
                }
            } else {
                j.f12332a.c("TencentFaceHelper", "sdk返回结果为空！");
            }
            WbCloudFaceVerifySdk.getInstance().release();
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener
        public void onLoginFailed(@Nullable WbFaceError wbFaceError) {
            j.a aVar = j.f12332a;
            aVar.f("TencentFaceHelper", "onLoginFailed!");
            TencentFaceHelper tencentFaceHelper = TencentFaceHelper.f13090a;
            TencentFaceHelper.f13091b = false;
            if (wbFaceError != null) {
                tencentFaceHelper.e(this.f13092a, this.f13093b.getOrderNo(), false, "{\"domain\":\"" + wbFaceError.getDomain() + "\",\"code\":\"" + wbFaceError.getCode() + "\",\"desc\":\"" + wbFaceError.getDesc() + "\",\"reason\":\"" + wbFaceError.getReason() + "\"}", wbFaceError.getDesc());
                if (s.d(wbFaceError.getDomain(), WbFaceError.WBFaceErrorDomainParams)) {
                    aVar.c("TencentFaceHelper", "登录失败！传入参数有错误：domain=" + wbFaceError.getDomain() + " ;code= " + wbFaceError.getCode() + " ;desc=" + wbFaceError.getDesc() + ";reason=" + wbFaceError.getReason());
                    return;
                }
                aVar.c("TencentFaceHelper", "登录刷脸sdk失败！domain=" + wbFaceError.getDomain() + " ;code= " + wbFaceError.getCode() + " ;desc=" + wbFaceError.getDesc() + ";reason=" + wbFaceError.getReason());
                return;
            }
            aVar.c("TencentFaceHelper", "sdk返回error为空！");
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyLoginListener
        public void onLoginSuccess() {
            WbCloudFaceVerifySdk wbCloudFaceVerifySdk = WbCloudFaceVerifySdk.getInstance();
            final Activity activity = this.f13092a;
            final FaceInfoModel faceInfoModel = this.f13093b;
            wbCloudFaceVerifySdk.startWbFaceVerifySdk(activity, new WbCloudFaceVerifyResultListener() { // from class: com.cupidapp.live.base.web.helper.b
                @Override // com.tencent.cloud.huiyansdkface.facelight.api.listeners.WbCloudFaceVerifyResultListener
                public final void onFinish(WbFaceVerifyResult wbFaceVerifyResult) {
                    TencentFaceHelper.a.b(activity, faceInfoModel, wbFaceVerifyResult);
                }
            });
        }
    }

    public final void c(@NotNull FaceInfoModel model) {
        User X;
        String userId;
        s.i(model, "model");
        if (f13091b || (X = g.f52734a.X()) == null || (userId = X.userId()) == null) {
            return;
        }
        f13090a.d(model, userId);
        GroupOthersLog.f18702a.s0();
    }

    public final void d(@NotNull FaceInfoModel model, @NotNull String uid) {
        s.i(model, "model");
        s.i(uid, "uid");
        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
        Activity activity = a10 != null ? a10.get() : null;
        if (activity == null) {
            return;
        }
        f13091b = true;
        WbCloudFaceVerifySdk.InputData inputData = new WbCloudFaceVerifySdk.InputData(model.getFaceId(), model.getOrderNo(), model.getAppId(), BuildConfig.VERSION_NAME, model.getNonce(), uid, model.getSign(), FaceVerifyStatus.Mode.GRADE, "eJ9hmXHPeMKftSFdr6IISwPdtsTB/5D4HGgcNsXTVwSoc/RUaQv+l+ko2bPnEwuHIWVkKvATySYUNokf7u+pFxj7Peppo+MJLiP4eLGWjNBWDkVgnuWyEall0FbK34bqXglzw6Q0IVA1LlAi2PSPGGrdmga+RFtbqOr4b7rhb/2aB8b3BGuChmne92OvrkaSczionznsG71o3lD1Mp7wxXbHcLPBR+0ZADb9l/rzrlNMasp8NOvD23+gUWDmS3+8fT6EKMF5kAQsw3D22DEjLJ/dIeKaZh/zigYQ4W02wK7M8ByXcROF9K+vQgs/ghQEaDongT6Fhj1tC28jxWv2SA==");
        Bundle bundle = new Bundle();
        bundle.putSerializable(WbCloudFaceContant.INPUT_DATA, inputData);
        bundle.putString(WbCloudFaceContant.LANGUAGE, WbCloudFaceContant.LANGUAGE_ZH_CN);
        bundle.putString(WbCloudFaceContant.COLOR_MODE, WbCloudFaceContant.WHITE);
        bundle.putBoolean(WbCloudFaceContant.VIDEO_UPLOAD, true);
        bundle.putBoolean(WbCloudFaceContant.PLAY_VOICE, false);
        bundle.putString(WbCloudFaceContant.COMPARE_TYPE, WbCloudFaceContant.ID_CARD);
        bundle.putBoolean(WbCloudFaceContant.IS_ENABLE_LOG, false);
        WbCloudFaceVerifySdk.getInstance().initSdk(activity, bundle, new a(activity, model));
    }

    public final void e(final Activity activity, String str, final boolean z10, String str2, final String str3) {
        Disposable disposed = NetworkClient.f11868a.N().P0(str, z10, str2).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.web.helper.TencentFaceHelper$postFaceCallback$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FKWebView fKWebView = (FKWebView) activity.findViewById(R$id.appWebView);
                if (fKWebView != null) {
                    com.cupidapp.live.base.web.bridge.b.f13062a.a(fKWebView, z10, str3);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}

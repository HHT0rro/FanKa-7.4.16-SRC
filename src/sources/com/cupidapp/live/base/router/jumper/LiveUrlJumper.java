package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.liveshow.activity.FKStartLiveShowActivity;
import com.huawei.openalliance.ad.constant.as;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveUrlJumper implements com.cupidapp.live.base.router.h {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == 0 || com.cupidapp.live.liveshow.helper.a.f15073a.a()) {
            return;
        }
        String queryParameter = uri.getQueryParameter(as.f32242q);
        String queryParameter2 = uri.getQueryParameter("shareby");
        String queryParameter3 = uri.getQueryParameter(TTLiveConstants.INIT_CHANNEL);
        String queryParameter4 = uri.getQueryParameter("PushChannel");
        String queryParameter5 = uri.getQueryParameter("enterSource");
        String path = uri.getPath();
        String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
        if (queryParameter2 == null || queryParameter2.length() == 0) {
            if (!(queryParameter4 == null || queryParameter4.length() == 0)) {
                queryParameter5 = "PUSH";
            }
        } else {
            queryParameter5 = "SHARE";
        }
        if (!(queryParameter == null || queryParameter.length() == 0)) {
            Observable<Result<Object>> V = NetworkClient.f11868a.r().V(queryParameter, null, queryParameter2, queryParameter3);
            com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = V.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.LiveUrlJumper$jump$$inlined$handleByContext$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        FKStartLiveShowActivity.f14790s.a(context, A, queryParameter5, SensorPosition.Web.getValue());
    }
}

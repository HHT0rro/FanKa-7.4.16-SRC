package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.push.event.RouterUrlJumperSelectMainTabEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostUrlJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        List z02;
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("postId");
        if (queryParameter == null || queryParameter.length() == 0) {
            String path = uri.getPath();
            String A = path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null;
            queryParameter = (A == null || (z02 = StringsKt__StringsKt.z0(A, new String[]{"&shareby="}, false, 0, 6, null)) == null) ? null : (String) CollectionsKt___CollectionsKt.V(z02);
        }
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        final boolean d10 = kotlin.jvm.internal.s.d(uri.getQueryParameter("source"), SensorPosition.Push.getValue());
        if (d10) {
            EventBus.c().o(new RouterUrlJumperSelectMainTabEvent(MainActivity.MainPagerType.Feed));
        }
        Observable<Result<ListResult<FeedModel>>> J = NetworkClient.f11868a.l().J(queryParameter);
        Object baseContext = AppApplication.f11612d.h().getBaseContext();
        com.cupidapp.live.base.network.g gVar = baseContext instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) baseContext : null;
        Disposable disposed = J.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FeedModel>, kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.PostUrlJumper$jump$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<FeedModel> listResult) {
                m2469invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2469invoke(ListResult<FeedModel> listResult) {
                FeedModel feedModel;
                List<FeedModel> list = listResult.getList();
                if (list == null || (feedModel = (FeedModel) CollectionsKt___CollectionsKt.V(list)) == null) {
                    return;
                }
                FeedDetailActivity.Q.a(context, feedModel, false, new FeedSensorContext(SensorPosition.FeedDetail, d10 ? SensorPosition.Push : SensorPosition.Unknown, SensorPosition.Unknown, null), (r25 & 16) != 0 ? false : false, (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? null : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? null : null);
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
}

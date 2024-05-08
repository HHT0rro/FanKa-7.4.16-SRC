package com.cupidapp.live.notify.fragment;

import android.view.View;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.notify.model.NotifyListResult;
import com.cupidapp.live.notify.model.PostNotifyModel;
import com.cupidapp.live.push.FKPushType;
import com.cupidapp.live.push.d;
import h3.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLikeNotifyFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLikeNotifyFragment extends BaseNotifyFragment {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17546o = new LinkedHashMap();

    @Override // com.cupidapp.live.notify.fragment.BaseNotifyFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17546o.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.NotifyGetLike;
    }

    @Override // com.cupidapp.live.notify.fragment.BaseNotifyFragment
    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17546o;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.notify.fragment.BaseNotifyFragment
    public void n1() {
        d.a aVar = com.cupidapp.live.push.d.f17892a;
        aVar.b(FKPushType.PostLike);
        aVar.b(FKPushType.PostLikeFocus);
        aVar.b(FKPushType.PostLikeIntimate);
        aVar.b(FKPushType.RainbowCommentLike);
        p1.g gVar = p1.g.f52734a;
        gVar.Y2(0);
        gVar.X2(gVar.z0() + gVar.C0());
        EventBus.c().l(new RefreshNotifyTitleUnreadCountEvent());
        if (y1() != null) {
            Disposable disposed = NetworkClient.f11868a.C().h(y1()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.PostLikeNotifyFragment$clearUnreadNotify$$inlined$handle$default$1
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
                    PostLikeNotifyFragment.this.P1(null);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.notify.fragment.BaseNotifyFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.notify.fragment.BaseNotifyFragment
    public void w1(@Nullable final String str) {
        Disposable disposed = a.C0743a.c(NetworkClient.f11868a.C(), str, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NotifyListResult<PostNotifyModel>, p>() { // from class: com.cupidapp.live.notify.fragment.PostLikeNotifyFragment$getNotifyList$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(NotifyListResult<PostNotifyModel> notifyListResult) {
                m2749invoke(notifyListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2749invoke(NotifyListResult<PostNotifyModel> notifyListResult) {
                NotifyListResult<PostNotifyModel> notifyListResult2 = notifyListResult;
                FKAppRatingLayout.f11658f.c(notifyListResult2.getWindows());
                PostLikeNotifyFragment.this.t1(str, notifyListResult2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }
}

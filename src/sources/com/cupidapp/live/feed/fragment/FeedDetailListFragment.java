package com.cupidapp.live.feed.fragment;

import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.NestingRecyclerView;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedDetailListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailListFragment extends BaseFeedListFragment {

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.feed.helper.i f14234t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public FeedSensorContext f14235u;

    /* renamed from: w, reason: collision with root package name */
    public long f14237w;

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14238x = new LinkedHashMap();

    /* renamed from: v, reason: collision with root package name */
    public boolean f14236v = true;

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public void C1(@Nullable final String str) {
        Function1<String, Observable<Result<ListResult<FeedModel>>>> d10;
        Observable<Result<ListResult<FeedModel>>> invoke;
        com.cupidapp.live.feed.helper.i iVar = this.f14234t;
        if (iVar == null || (d10 = iVar.d()) == null || (invoke = d10.invoke(str)) == null) {
            return;
        }
        Disposable disposed = invoke.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FeedModel>, kotlin.p>() { // from class: com.cupidapp.live.feed.fragment.FeedDetailListFragment$loadFeedData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<FeedModel> listResult) {
                m2562invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2562invoke(ListResult<FeedModel> listResult) {
                FKEmptyViewModel U1;
                ListResult<FeedModel> listResult2 = listResult;
                FeedDetailListFragment.this.P1(listResult2.getNextCursorId());
                if (str == null) {
                    FeedDetailListFragment.this.n1().j().clear();
                }
                List<FeedModel> list = listResult2.getList();
                if (list == null || list.isEmpty()) {
                    if (str == null && (U1 = FeedDetailListFragment.this.U1()) != null) {
                        FeedDetailListFragment.this.n1().d(U1);
                    }
                } else {
                    FeedDetailListFragment.this.n1().e(listResult2.getList());
                }
                if (listResult2.getNextCursorId() == null) {
                    FeedDetailListFragment.this.n1().s();
                }
                BaseFeedListFragment.l1(FeedDetailListFragment.this, false, 1, null);
                FeedDetailListFragment.this.p1().c(false);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.fragment.FeedDetailListFragment$loadFeedData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FeedDetailListFragment.this.p1().c(false);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f14238x.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        SensorPosition source;
        FeedSensorContext feedSensorContext = this.f14235u;
        return (feedSensorContext == null || (source = feedSensorContext.getSource()) == null) ? SensorPosition.Unknown : source;
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public boolean R1() {
        com.cupidapp.live.feed.helper.i iVar = this.f14234t;
        if (iVar != null) {
            return iVar.f();
        }
        return false;
    }

    @Nullable
    public FKEmptyViewModel U1() {
        com.cupidapp.live.feed.helper.i iVar = this.f14234t;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    public final void V1(@Nullable com.cupidapp.live.feed.helper.i iVar, @NotNull FeedSensorContext sensorContext, boolean z10) {
        kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
        this.f14234t = iVar;
        this.f14235u = sensorContext;
        this.f14236v = z10;
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f14238x;
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

    public final void W1() {
        com.cupidapp.live.feed.helper.i iVar = this.f14234t;
        if (iVar != null) {
            P1(iVar.c());
            n1().j().clear();
            n1().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
            List<FeedModel> b4 = iVar.b();
            int i10 = 0;
            if (b4 == null || b4.isEmpty()) {
                FKEmptyViewModel U1 = U1();
                if (U1 != null) {
                    n1().d(U1);
                    return;
                }
                return;
            }
            int g3 = iVar.g();
            for (FeedModel feedModel : iVar.b()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                n1().d(feedModel);
                if (iVar.e() && g3 == i10 && g3 < iVar.b().size() - 1) {
                    z1(SensorPosition.PostStream, g3 + 1);
                }
                i10 = i11;
            }
            if (iVar.c() == null) {
                n1().s();
            }
            k1(true);
            ((NestingRecyclerView) W0(R$id.feedRecyclerView)).scrollToPosition(g3);
        }
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public boolean i1() {
        return this.f14236v;
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        I1(event.getUser());
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        F1();
        SensorsLogFeed.f12208a.h(s1().getSource(), (int) ((System.currentTimeMillis() - this.f14237w) / 1000));
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f14237w = System.currentTimeMillis();
        O1();
        N1();
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        W1();
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    @NotNull
    public FeedSensorContext s1() {
        FeedSensorContext feedSensorContext = this.f14235u;
        if (feedSensorContext != null) {
            return feedSensorContext;
        }
        SensorPosition sensorPosition = SensorPosition.Unknown;
        return new FeedSensorContext(sensorPosition, sensorPosition, null, null);
    }

    @Override // com.cupidapp.live.feed.fragment.BaseFeedListFragment
    public int t1() {
        com.cupidapp.live.feed.helper.i iVar = this.f14234t;
        if (iVar != null) {
            return iVar.g();
        }
        return 0;
    }
}

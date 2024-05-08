package com.cupidapp.live.notify.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseScrollViewPager;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.p;
import com.cupidapp.live.main.event.RefreshAllTabUnreadCountEvent;
import com.cupidapp.live.main.model.CountDataModel;
import com.cupidapp.live.notify.adapter.NotifyContainerViewPagerNewAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyContainerNewFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NotifyContainerNewFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f17540h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static boolean f17541i = true;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17544g = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17542e = kotlin.c.b(new Function0<NotifyContainerViewPagerNewAdapter>() { // from class: com.cupidapp.live.notify.fragment.NotifyContainerNewFragment$notifyContainerAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final NotifyContainerViewPagerNewAdapter invoke() {
            FragmentManager childFragmentManager = NotifyContainerNewFragment.this.getChildFragmentManager();
            s.h(childFragmentManager, "childFragmentManager");
            Bundle arguments = NotifyContainerNewFragment.this.getArguments();
            return new NotifyContainerViewPagerNewAdapter(childFragmentManager, arguments != null ? arguments.getBoolean("defaultShowPurchaseDialog") : false);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public NotifyPageType f17543f = NotifyPageType.Follow;

    /* compiled from: NotifyContainerNewFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return NotifyContainerNewFragment.f17541i;
        }

        @NotNull
        public final NotifyContainerNewFragment b(@NotNull NotifyPageType pageType, boolean z10) {
            s.i(pageType, "pageType");
            NotifyContainerNewFragment notifyContainerNewFragment = new NotifyContainerNewFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, pageType);
            bundle.putBoolean("defaultShowPurchaseDialog", z10);
            notifyContainerNewFragment.setArguments(bundle);
            return notifyContainerNewFragment;
        }

        public final void c(boolean z10) {
            NotifyContainerNewFragment.f17541i = z10;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17544g.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return this.f17543f.getPageName();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17544g;
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

    public final void a1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) S0(R$id.containerTitleLayout);
        if (fKTitleBarLayout != null) {
            int index = NotifyPageType.Follow.getIndex();
            p1.g gVar = p1.g.f52734a;
            fKTitleBarLayout.setViewPagerTitleUnreadCount(index, gVar.z0());
            fKTitleBarLayout.setViewPagerTitleUnreadCount(NotifyPageType.Praise.getIndex(), gVar.B0());
            fKTitleBarLayout.setViewPagerTitleUnreadCount(NotifyPageType.Dynamic.getIndex(), gVar.C0());
        }
    }

    public final NotifyContainerViewPagerNewAdapter b1() {
        return (NotifyContainerViewPagerNewAdapter) this.f17542e.getValue();
    }

    public final NotifyPageType c1(int i10) {
        NotifyPageType notifyPageType = NotifyPageType.Follow;
        if (i10 == notifyPageType.getIndex()) {
            return notifyPageType;
        }
        NotifyPageType notifyPageType2 = NotifyPageType.AiIdentify;
        if (i10 != notifyPageType2.getIndex()) {
            notifyPageType2 = NotifyPageType.Praise;
            if (i10 != notifyPageType2.getIndex()) {
                notifyPageType2 = NotifyPageType.Dynamic;
                if (i10 != notifyPageType2.getIndex()) {
                    notifyPageType2 = NotifyPageType.DailyHeart;
                    if (i10 != notifyPageType2.getIndex()) {
                        return notifyPageType;
                    }
                }
            }
        }
        return notifyPageType2;
    }

    public final void d1() {
        FKTitleBarLayout initView$lambda$0 = (FKTitleBarLayout) S0(R$id.containerTitleLayout);
        p pVar = new p(kotlin.collections.s.m(getString(R$string.attention), getString(R$string.ai_identify), getString(R$string.praise), getString(R$string.remind), getString(R$string.heart_beat)), 0.0f, 0, 0, false, 30, null);
        s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.setViewPagerTitlePadding(z0.h.c(initView$lambda$0, 40.0f), 0);
        int i10 = R$id.containerViewPager;
        FKTitleBarLayout.f(initView$lambda$0, pVar, (BaseScrollViewPager) S0(i10), 0, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.notify.fragment.NotifyContainerNewFragment$initView$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i11) {
                NotifyPageType c12;
                NotifyContainerNewFragment notifyContainerNewFragment = NotifyContainerNewFragment.this;
                c12 = notifyContainerNewFragment.c1(i11);
                notifyContainerNewFragment.f17543f = c12;
                NotifyPageType notifyPageType = NotifyPageType.DailyHeart;
                if (i11 == notifyPageType.getIndex()) {
                    p1.g.f52734a.d2(Boolean.FALSE);
                    NotifyContainerNewFragment.this.e1(notifyPageType.getIndex(), false);
                }
                NotifyContainerNewFragment.this.f1();
            }
        }, 4, null);
        a1();
        initView$lambda$0.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.notify.fragment.NotifyContainerNewFragment$initView$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FragmentActivity activity = NotifyContainerNewFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        ((BaseScrollViewPager) S0(i10)).setAdapter(b1());
        ((BaseScrollViewPager) S0(i10)).setCurrentItem(this.f17543f.getIndex());
        e1(NotifyPageType.DailyHeart.getIndex(), s.d(p1.g.f52734a.s(), Boolean.TRUE));
        f1();
    }

    public final void e1(int i10, boolean z10) {
        ((FKTitleBarLayout) S0(R$id.containerTitleLayout)).setViewPagerTitleNewTag(i10, z10);
    }

    public final void f1() {
        j1.c.b(j1.c.f50228a, this.f17543f.getPageName(), null, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_pager_container, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshNotifyTitleUnreadCountEvent event) {
        s.i(event, "event");
        a1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        NotifyPageType notifyPageType;
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (notifyPageType = (NotifyPageType) z0.g.b(arguments, NotifyPageType.class)) == null) {
            notifyPageType = NotifyPageType.Follow;
        }
        this.f17543f = notifyPageType;
        d1();
        f17541i = true;
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RefreshAllTabUnreadCountEvent event) {
        s.i(event, "event");
        Disposable disposed = NetworkClient.f11868a.i().r().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<CountDataModel, kotlin.p>() { // from class: com.cupidapp.live.notify.fragment.NotifyContainerNewFragment$onEvent$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(CountDataModel countDataModel) {
                m2747invoke(countDataModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2747invoke(CountDataModel countDataModel) {
                p1.g.f52734a.S1(countDataModel);
                NotifyContainerNewFragment.this.a1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }
}

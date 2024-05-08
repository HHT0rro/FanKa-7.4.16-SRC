package com.cupidapp.live.liveshow.view.remoteconnect.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.adapter.FKLiveConnectUserViewPagerAdapter;
import com.cupidapp.live.liveshow.adapter.FKLiveRequestViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.model.LiveConnectAcceptResult;
import com.cupidapp.live.liveshow.model.LiveRequestModel;
import com.cupidapp.live.liveshow.model.LiveShowViewerResult;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.ConnectUserViewModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKLiveConnectUserPickerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveConnectUserPickerFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f15841k = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15842e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public i f15843f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f15844g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public LiveRequestModel f15845h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f15846i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15847j = new LinkedHashMap();

    /* compiled from: FKLiveConnectUserPickerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveConnectUserPickerFragment a(@NotNull i listener) {
            s.i(listener, "listener");
            FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment = new FKLiveConnectUserPickerFragment();
            fKLiveConnectUserPickerFragment.f15843f = listener;
            return fKLiveConnectUserPickerFragment;
        }
    }

    public FKLiveConnectUserPickerFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f15842e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ConnectUserViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f15844g = kotlin.c.b(new Function0<FKLiveConnectUserViewPagerAdapter>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$connectUserPickerAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLiveConnectUserViewPagerAdapter invoke() {
                FKLiveConnectUserViewPagerAdapter fKLiveConnectUserViewPagerAdapter = new FKLiveConnectUserViewPagerAdapter();
                final FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment = FKLiveConnectUserPickerFragment.this;
                fKLiveConnectUserViewPagerAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$connectUserPickerAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        if (obj instanceof FKLiveRequestViewModel) {
                            FKLiveConnectUserPickerFragment.this.u1((FKLiveRequestViewModel) obj);
                        }
                    }
                });
                return fKLiveConnectUserViewPagerAdapter;
            }
        });
    }

    public static final void q1(FKLiveConnectUserPickerFragment this$0, LiveShowViewerResult it) {
        s.i(this$0, "this$0");
        s.h(it, "it");
        this$0.j1(it);
        Integer maxConnectCount = it.getMaxConnectCount();
        this$0.i1(maxConnectCount != null ? maxConnectCount.intValue() : 0);
    }

    public static final void r1(FKLiveConnectUserPickerFragment this$0, Boolean it) {
        s.i(this$0, "this$0");
        s.h(it, "it");
        this$0.k1(it.booleanValue());
    }

    public static final void s1(FKLiveConnectUserPickerFragment this$0, LiveConnectAcceptResult liveConnectAcceptResult) {
        User user;
        s.i(this$0, "this$0");
        LinearLayout bottom_menu_layout = (LinearLayout) this$0.Y0(R$id.bottom_menu_layout);
        s.h(bottom_menu_layout, "bottom_menu_layout");
        bottom_menu_layout.setVisibility(4);
        TextView connecting_textview = (TextView) this$0.Y0(R$id.connecting_textview);
        s.h(connecting_textview, "connecting_textview");
        connecting_textview.setVisibility(0);
        i iVar = this$0.f15843f;
        if (iVar != null) {
            LiveRequestModel liveRequestModel = this$0.f15845h;
            iVar.a(liveConnectAcceptResult, (liveRequestModel == null || (user = liveRequestModel.getUser()) == null) ? null : user.userId());
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15847j.clear();
    }

    @Nullable
    public View Y0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15847j;
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

    public final void h1() {
        TextView connect_switch_textview = (TextView) Y0(R$id.connect_switch_textview);
        s.h(connect_switch_textview, "connect_switch_textview");
        y.d(connect_switch_textview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ConnectUserViewModel o12;
                o12 = FKLiveConnectUserPickerFragment.this.o1();
                o12.showCloseConnectDialog();
            }
        });
        FKUniversalButton view_profile_button = (FKUniversalButton) Y0(R$id.view_profile_button);
        s.h(view_profile_button, "view_profile_button");
        y.d(view_profile_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                LiveRequestModel liveRequestModel;
                User user;
                ConnectUserViewModel o12;
                liveRequestModel = FKLiveConnectUserPickerFragment.this.f15845h;
                if (liveRequestModel == null || (user = liveRequestModel.getUser()) == null) {
                    return;
                }
                o12 = FKLiveConnectUserPickerFragment.this.o1();
                o12.showMiniProfile(user.userId());
            }
        });
        FKUniversalButton connect_button = (FKUniversalButton) Y0(R$id.connect_button);
        s.h(connect_button, "connect_button");
        y.d(connect_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ConnectUserViewModel o12;
                LiveRequestModel liveRequestModel;
                o12 = FKLiveConnectUserPickerFragment.this.o1();
                liveRequestModel = FKLiveConnectUserPickerFragment.this.f15845h;
                o12.startConnect(liveRequestModel);
            }
        });
    }

    public final void i1(int i10) {
        FKUniversalButton fKUniversalButton = (FKUniversalButton) Y0(R$id.connect_button);
        if (FKLiveConstantsData.INSTANCE.getFkLiveType() == FKLiveType.CHAT) {
            List<String> c4 = FKLiveUtil.f14913a.c();
            if ((c4 != null ? c4.size() : 0) >= i10) {
                fKUniversalButton.setText(fKUniversalButton.getContext().getString(R$string.max_connect));
                fKUniversalButton.a(false);
                return;
            }
        }
        fKUniversalButton.setText(fKUniversalButton.getContext().getString(R$string.link));
        fKUniversalButton.a(true);
    }

    public final void j1(LiveShowViewerResult liveShowViewerResult) {
        m1().j().clear();
        List<LiveRequestModel> list = liveShowViewerResult.getList();
        if (list == null || list.isEmpty()) {
            TextView connect_title_textview = (TextView) Y0(R$id.connect_title_textview);
            s.h(connect_title_textview, "connect_title_textview");
            connect_title_textview.setVisibility(8);
            LinearLayout bottom_menu_layout = (LinearLayout) Y0(R$id.bottom_menu_layout);
            s.h(bottom_menu_layout, "bottom_menu_layout");
            bottom_menu_layout.setVisibility(4);
            m1().d(new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_connect_live_user_empty), Integer.valueOf(R$string.no_one_link), null, null, null, null, null, false, null, null, 1020, null));
        } else {
            int i10 = R$id.connect_title_textview;
            TextView connect_title_textview2 = (TextView) Y0(i10);
            s.h(connect_title_textview2, "connect_title_textview");
            connect_title_textview2.setVisibility(0);
            ((TextView) Y0(i10)).setText(getString(R$string.wait_count_for_viewer, liveShowViewerResult.getWaitingToConnectCount()));
            LinearLayout bottom_menu_layout2 = (LinearLayout) Y0(R$id.bottom_menu_layout);
            s.h(bottom_menu_layout2, "bottom_menu_layout");
            bottom_menu_layout2.setVisibility(0);
            int i11 = 0;
            for (LiveRequestModel liveRequestModel : liveShowViewerResult.getList()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                LiveRequestModel liveRequestModel2 = liveRequestModel;
                if (i11 == 0) {
                    this.f15845h = liveRequestModel2;
                }
                m1().d(new FKLiveRequestViewModel(liveRequestModel2, i11 == 0));
                i11 = i12;
            }
        }
        m1().notifyDataSetChanged();
    }

    public final void k1(boolean z10) {
        String string;
        this.f15846i = z10;
        TextView textView = (TextView) Y0(R$id.connect_switch_textview);
        if (z10) {
            string = getString(R$string.stop_link_action);
        } else {
            string = getString(R$string.open_link_action);
        }
        textView.setText(string);
    }

    public final void l1() {
        if (isResumed()) {
            LinearLayout bottom_menu_layout = (LinearLayout) Y0(R$id.bottom_menu_layout);
            s.h(bottom_menu_layout, "bottom_menu_layout");
            bottom_menu_layout.setVisibility(0);
            TextView connecting_textview = (TextView) Y0(R$id.connecting_textview);
            s.h(connecting_textview, "connecting_textview");
            connecting_textview.setVisibility(8);
            com.cupidapp.live.base.view.h.f12779a.c(getContext(), R$string.liveshow_connect_timeout);
        }
    }

    public final FKLiveConnectUserViewPagerAdapter m1() {
        return (FKLiveConnectUserViewPagerAdapter) this.f15844g.getValue();
    }

    public final void n1() {
        o1().getRequestList();
    }

    public final ConnectUserViewModel o1() {
        return (ConnectUserViewModel) this.f15842e.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_connect_user_picker, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        t1();
        p1();
        h1();
        n1();
    }

    public final void p1() {
        o1().getRequestListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveConnectUserPickerFragment.q1(FKLiveConnectUserPickerFragment.this, (LiveShowViewerResult) obj);
            }
        });
        o1().getConnectSwitchLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveConnectUserPickerFragment.r1(FKLiveConnectUserPickerFragment.this, (Boolean) obj);
            }
        });
        o1().getShowCloseDialogEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object it) {
                s.i(it, "it");
                FKLiveConnectUserPickerFragment.this.v1();
            }
        }));
        o1().getShowMiniProfileEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                s.i(it, "it");
                FKLiveConnectUserPickerFragment.this.x1(it);
            }
        }));
        o1().getStartLiveConnectLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveConnectUserPickerFragment.s1(FKLiveConnectUserPickerFragment.this, (LiveConnectAcceptResult) obj);
            }
        });
    }

    public final void t1() {
        RecyclerView recyclerView = (RecyclerView) Y0(R$id.connect_user_recyclerview);
        recyclerView.setAdapter(m1());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$initView$1$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                FKLiveConnectUserViewPagerAdapter m12;
                m12 = FKLiveConnectUserPickerFragment.this.m1();
                return m12.u(i10);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator == null) {
            return;
        }
        simpleItemAnimator.setSupportsChangeAnimations(false);
    }

    public final void u1(FKLiveRequestViewModel fKLiveRequestViewModel) {
        if (fKLiveRequestViewModel.isChecked()) {
            return;
        }
        this.f15845h = fKLiveRequestViewModel.getRequestModel();
        List<Object> j10 = m1().j();
        ArrayList<FKLiveRequestViewModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FKLiveRequestViewModel) {
                arrayList.add(obj);
            }
        }
        for (FKLiveRequestViewModel fKLiveRequestViewModel2 : arrayList) {
            fKLiveRequestViewModel2.setChecked(s.d(fKLiveRequestViewModel2.getRequestModel().getId(), fKLiveRequestViewModel.getRequestModel().getId()));
        }
        m1().notifyDataSetChanged();
    }

    public final void v1() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), this.f15846i ? R$string.open_link_action : R$string.stop_link_action, 0, 2, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment$showCloseConnect$1
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
                ConnectUserViewModel o12;
                boolean z10;
                boolean z11;
                o12 = FKLiveConnectUserPickerFragment.this.o1();
                z10 = FKLiveConnectUserPickerFragment.this.f15846i;
                o12.closeConnect(!z10);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.ALLOW_VIEWER_CONNECT;
                z11 = FKLiveConnectUserPickerFragment.this.f15846i;
                iVar.a(popupName, z11 ? PopupButtonName.AllowConnect : PopupButtonName.StopConnectApply, null);
            }
        }, 3, null), 0, null, 3, null), null, 1, null);
        j1.i.g(j1.i.f50236a, PopupName.ALLOW_VIEWER_CONNECT, null, null, 4, null);
    }

    public final void w1(@NotNull FragmentManager manager) {
        s.i(manager, "manager");
        show(manager, FKLiveConnectUserPickerFragment.class.getSimpleName());
    }

    public final void x1(String str) {
        EventBus.c().l(new ShowLiveMiniProfileViewModel(str, SensorsLogMatch.AlohaGetPosition.Connection, null, false, false, false, 60, null));
    }
}

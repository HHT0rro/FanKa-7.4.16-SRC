package com.cupidapp.live.base.share.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.k;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.share.model.BaseShareItemModel;
import com.cupidapp.live.base.share.model.FKShareItemModel;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.SpreadMenuType;
import com.cupidapp.live.base.share.view.ShareItemMenuView;
import com.cupidapp.live.base.share.view.a;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FeedSpreadMenuBottomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedSpreadMenuBottomFragment extends BaseAppCompatDialogFragment implements com.cupidapp.live.base.share.view.a {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f12218h = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FeedSpreadMenuModel f12219d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.share.view.b f12220e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f12221f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12222g = new LinkedHashMap();

    /* compiled from: FeedSpreadMenuBottomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedSpreadMenuBottomFragment a() {
            return new FeedSpreadMenuBottomFragment();
        }
    }

    public FeedSpreadMenuBottomFragment() {
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuBottomFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final FeedSpreadMenuBottomFragment feedSpreadMenuBottomFragment = FeedSpreadMenuBottomFragment.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuBottomFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        FeedSpreadMenuModel feedSpreadMenuModel;
                        s.i(p02, "p0");
                        feedSpreadMenuModel = FeedSpreadMenuBottomFragment.this.f12219d;
                        return new FeedSpreadMenuViewModel(feedSpreadMenuModel);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuBottomFragment$special$$inlined$viewModels$default$1
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
        this.f12221f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(FeedSpreadMenuViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuBottomFragment$special$$inlined$viewModels$default$2
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
        }, function0);
    }

    public static final void W0(FeedSpreadMenuBottomFragment this$0, Pair pair) {
        s.i(this$0, "this$0");
        this$0.a1((Collection) pair.getFirst(), (Collection) pair.getSecond());
    }

    public static final void X0(FeedSpreadMenuBottomFragment this$0, ShareItemHandledResult result) {
        s.i(this$0, "this$0");
        if (result.getType() == SpreadMenuType.FEED_SPREAD) {
            j.a.b(j.f12156c, this$0.getContext(), String.valueOf(result.getData()), null, 4, null);
        }
        com.cupidapp.live.base.share.view.b bVar = this$0.f12220e;
        if (bVar != null) {
            s.h(result, "result");
            bVar.a(result);
        }
        this$0.dismiss();
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment
    public void N0() {
        this.f12222g.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f12222g;
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

    public final FeedSpreadMenuViewModel U0() {
        return (FeedSpreadMenuViewModel) this.f12221f.getValue();
    }

    public final void V0() {
        U0().getModels().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.base.share.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSpreadMenuBottomFragment.W0(FeedSpreadMenuBottomFragment.this, (Pair) obj);
            }
        });
        U0().getHandledResult().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.base.share.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSpreadMenuBottomFragment.X0(FeedSpreadMenuBottomFragment.this, (ShareItemHandledResult) obj);
            }
        });
    }

    public final void Y0() {
        TextView menuCancelTxt = (TextView) S0(R$id.menuCancelTxt);
        s.h(menuCancelTxt, "menuCancelTxt");
        y.d(menuCancelTxt, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.FeedSpreadMenuBottomFragment$initView$1
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
                FeedSpreadMenuBottomFragment.this.dismissAllowingStateLoss();
            }
        });
    }

    @Override // com.cupidapp.live.base.share.view.a
    public void Z(@NotNull ShareBaseType type) {
        s.i(type, "type");
        com.cupidapp.live.base.share.view.b bVar = this.f12220e;
        if (bVar != null) {
            bVar.b(type);
        }
        U0().itemClick(type);
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        FeedSpreadMenuModel feedSpreadMenuModel = this.f12219d;
        groupSocialLog.H(feedSpreadMenuModel != null ? feedSpreadMenuModel.getFeedId() : null, type.toString());
    }

    public final void Z0(Collection<? extends BaseShareItemModel> collection, LinearLayout linearLayout) {
        Context it;
        if (collection == null) {
            return;
        }
        if (linearLayout != null) {
            linearLayout.setWeightSum(U0().getMIN_WEIGHT_NUM());
        }
        for (BaseShareItemModel baseShareItemModel : collection) {
            if ((baseShareItemModel instanceof FKShareItemModel) && (it = getContext()) != null) {
                s.h(it, "it");
                ShareItemMenuView shareItemMenuView = new ShareItemMenuView(it);
                shareItemMenuView.f((FKShareItemModel) baseShareItemModel, this);
                if (linearLayout != null) {
                    linearLayout.addView(shareItemMenuView, new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
            }
        }
    }

    public final void a1(Collection<? extends BaseShareItemModel> collection, Collection<? extends BaseShareItemModel> collection2) {
        Z0(collection, (LinearLayout) S0(R$id.menuFirstLinear));
        if (collection2 == null || collection2.isEmpty()) {
            ((LinearLayout) S0(R$id.menuOperateLinear)).setVisibility(8);
            return;
        }
        int i10 = R$id.menuOperateLinear;
        ((LinearLayout) S0(i10)).setVisibility(0);
        Z0(collection2, (LinearLayout) S0(i10));
    }

    public final void b1(@NotNull FragmentManager manager, @NotNull FeedSpreadMenuModel model, @Nullable com.cupidapp.live.base.share.view.b bVar) {
        s.i(manager, "manager");
        s.i(model, "model");
        this.f12219d = model;
        this.f12220e = bVar;
        super.show(manager, FeedSpreadMenuBottomFragment.class.getSimpleName());
        GroupSocialLog.f18708a.I(model.getFeedId());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_bottom_feed_spread_menu, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setGravity(80);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawableResource(17170445);
            }
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setLayout(-1, -2);
            }
            Window window4 = dialog.getWindow();
            if (window4 != null) {
                window4.setWindowAnimations(R$style.dialog_translate_anim);
            }
        }
        super.onStart();
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Y0();
        V0();
    }

    @Override // com.cupidapp.live.base.share.view.a
    public void q(@NotNull ShareBaseType shareBaseType) {
        a.C0144a.a(this, shareBaseType);
    }
}

package com.cupidapp.live.base.share.fragment;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.permission.b;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.share.logic.ShareRepository;
import com.cupidapp.live.base.share.model.BaseShareItemModel;
import com.cupidapp.live.base.share.model.CustomShareItemModel;
import com.cupidapp.live.base.share.model.FKShareItemModel;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.State;
import com.cupidapp.live.base.share.view.ShareItemCustomMenuView;
import com.cupidapp.live.base.share.view.ShareItemMenuView;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.databinding.FragmentShareMenuBinding;
import com.cupidapp.live.feed.logic.FeedRepository;
import com.cupidapp.live.profile.logic.UserRepository;
import com.cupidapp.live.superlike.helper.CancelAttentionHelper;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.y;

/* compiled from: ShareBottomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareBottomFragment extends BaseAppCompatDialogFragment implements com.cupidapp.live.base.share.view.a {

    /* renamed from: k */
    @NotNull
    public static final a f12224k = new a(null);

    /* renamed from: f */
    @Nullable
    public ShareModel f12227f;

    /* renamed from: g */
    public FragmentShareMenuBinding f12228g;

    /* renamed from: h */
    @Nullable
    public com.cupidapp.live.base.share.view.b f12229h;

    /* renamed from: i */
    @NotNull
    public final Lazy f12230i;

    /* renamed from: j */
    @NotNull
    public Map<Integer, View> f12231j = new LinkedHashMap();

    /* renamed from: d */
    public boolean f12225d = true;

    /* renamed from: e */
    @NotNull
    public final Lazy f12226e = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            Context context = ShareBottomFragment.this.getContext();
            Lifecycle lifecycle = ShareBottomFragment.this.getLifecycle();
            s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(context, lifecycle);
        }
    });

    /* compiled from: ShareBottomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShareBottomFragment a() {
            return new ShareBottomFragment();
        }
    }

    /* compiled from: ShareBottomFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.permission.b {

        /* renamed from: a */
        public final /* synthetic */ String f12232a;

        /* renamed from: b */
        public final /* synthetic */ FragmentActivity f12233b;

        /* renamed from: c */
        public final /* synthetic */ ShareBottomFragment f12234c;

        public b(String str, FragmentActivity fragmentActivity, ShareBottomFragment shareBottomFragment) {
            this.f12232a = str;
            this.f12233b = fragmentActivity;
            this.f12234c = shareBottomFragment;
        }

        @Override // com.cupidapp.live.base.permission.b
        public void a() {
            File file = new File(this.f12232a);
            k.a aVar = k.f54819a;
            FragmentActivity fragmentActivity = this.f12233b;
            String name = file.getName();
            s.h(name, "file.name");
            Uri H = k.a.H(aVar, fragmentActivity, file, name, null, 8, null);
            if (H != null) {
                ShareBottomFragment shareBottomFragment = this.f12234c;
                if (aVar.D(shareBottomFragment.getActivity(), H)) {
                    com.cupidapp.live.base.view.h.f12779a.c(shareBottomFragment.getContext(), R$string.save_success);
                }
            }
        }

        @Override // com.cupidapp.live.base.permission.b
        public void b() {
            b.a.b(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void c() {
            com.cupidapp.live.base.view.h.f12779a.r(this.f12234c.getActivity(), R$string.no_storage_permission);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void d() {
            b.a.a(this);
        }
    }

    public ShareBottomFragment() {
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                final ShareBottomFragment shareBottomFragment = ShareBottomFragment.this;
                return new ViewModelProvider.Factory() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$viewModel$2.1
                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    @NotNull
                    public <T extends ViewModel> T create(@NotNull Class<T> p02) {
                        ShareModel shareModel;
                        s.i(p02, "p0");
                        FeedRepository feedRepository = new FeedRepository();
                        UserRepository userRepository = new UserRepository();
                        ShareRepository shareRepository = new ShareRepository();
                        shareModel = ShareBottomFragment.this.f12227f;
                        if (shareModel == null) {
                            shareModel = new ShareModel(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
                        }
                        return new ShareBottomViewModel(feedRepository, userRepository, shareRepository, shareModel);
                    }

                    @Override // androidx.lifecycle.ViewModelProvider.Factory
                    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                        return androidx.lifecycle.k.b(this, cls, creationExtras);
                    }
                };
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$special$$inlined$viewModels$default$1
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
        this.f12230i = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ShareBottomViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$special$$inlined$viewModels$default$2
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

    public static final void k1(ShareBottomFragment this$0, View view) {
        s.i(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void l1(View view) {
    }

    public static final void m1(View view) {
    }

    public static final void n1(View view) {
    }

    public static final void o1(View view) {
    }

    public static final void q1(ShareBottomFragment this$0, Pair pair) {
        s.i(this$0, "this$0");
        this$0.s1((Collection) pair.getFirst(), (Collection) pair.getSecond());
    }

    public static final void r1(ShareBottomFragment this$0, ShareItemHandledResult result) {
        s.i(this$0, "this$0");
        if (result.getType() == ShareOperateType.DOWNLOAD_IMAGE) {
            this$0.b1();
        } else if (result.getType() == ShareOperateType.FEED_SPREAD) {
            j.a.b(j.f12156c, this$0.getContext(), String.valueOf(result.getData()), null, 4, null);
        }
        com.cupidapp.live.base.share.view.b bVar = this$0.f12229h;
        if (bVar != null) {
            s.h(result, "result");
            bVar.a(result);
        }
        this$0.dismiss();
    }

    public static /* synthetic */ void w1(ShareBottomFragment shareBottomFragment, FragmentManager fragmentManager, ShareModel shareModel, com.cupidapp.live.base.share.view.b bVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bVar = null;
        }
        shareBottomFragment.v1(fragmentManager, shareModel, bVar);
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment
    public void N0() {
        this.f12231j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseAppCompatDialogFragment
    public boolean O0() {
        return this.f12225d;
    }

    @Nullable
    public View X0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f12231j;
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

    @Override // com.cupidapp.live.base.share.view.a
    public void Z(@NotNull ShareBaseType type) {
        s.i(type, "type");
        com.cupidapp.live.base.share.view.b bVar = this.f12229h;
        if (bVar != null) {
            bVar.b(type);
        }
        if (type == ShareOperateType.UN_CLOSE_FRIEND) {
            x1(type);
        } else {
            d1().itemClick(type);
        }
    }

    public final void b1() {
        ShareModel shareModel = this.f12227f;
        String snapWebContentImageUrl = shareModel != null ? shareModel.getSnapWebContentImageUrl() : null;
        FragmentActivity activity = getActivity();
        if ((snapWebContentImageUrl == null || snapWebContentImageUrl.length() == 0) || activity == null) {
            return;
        }
        RxPermissionHelperKt.m(activity, new xb.b(activity), r.e(PermissionType.StoragePermission), new b(snapWebContentImageUrl, activity, this), false, 16, null);
    }

    public final PurchaseDialogManager c1() {
        return (PurchaseDialogManager) this.f12226e.getValue();
    }

    public final ShareBottomViewModel d1() {
        return (ShareBottomViewModel) this.f12230i.getValue();
    }

    public final void e1() {
        int i10 = R$id.blackLayout;
        View findViewById = X0(i10).findViewById(R$id.confirmButton);
        s.h(findViewById, "blackLayout.findViewById<View>(R.id.confirmButton)");
        y.d(findViewById, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initBlackView$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.blackUser();
            }
        });
        View findViewById2 = X0(i10).findViewById(R$id.cancelButton);
        s.h(findViewById2, "blackLayout.findViewById<View>(R.id.cancelButton)");
        y.d(findViewById2, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initBlackView$2
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.setHandleResult(new ShareItemHandledResult(State.CANCEL, ShareOperateType.BLACK, null, 4, null));
            }
        });
    }

    public final void f1() {
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        int i10 = R$id.delOrPrivateLayout;
        View delOrPrivateLayout = X0(i10);
        s.h(delOrPrivateLayout, "delOrPrivateLayout");
        aVar.a(delOrPrivateLayout);
        TextView textView = (TextView) X0(i10).findViewById(R$id.alert_dialog_message_text);
        textView.setVisibility(0);
        textView.setText(R$string.delete_select);
        TextView initDeleteOrPrivateView$lambda$12 = (TextView) X0(i10).findViewById(R$id.horizontal_main_button);
        initDeleteOrPrivateView$lambda$12.setVisibility(0);
        initDeleteOrPrivateView$lambda$12.setText(R$string.see_myself);
        s.h(initDeleteOrPrivateView$lambda$12, "initDeleteOrPrivateView$lambda$12");
        y.d(initDeleteOrPrivateView$lambda$12, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDeleteOrPrivateView$2$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.privateFeed();
            }
        });
        TextView initDeleteOrPrivateView$lambda$13 = (TextView) X0(i10).findViewById(R$id.horizontal_secondary_button);
        initDeleteOrPrivateView$lambda$13.setVisibility(0);
        initDeleteOrPrivateView$lambda$13.setText(R$string.delete);
        s.h(initDeleteOrPrivateView$lambda$13, "initDeleteOrPrivateView$lambda$13");
        y.d(initDeleteOrPrivateView$lambda$13, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDeleteOrPrivateView$3$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.feedDelete();
            }
        });
        TextView initDeleteOrPrivateView$lambda$14 = (TextView) X0(i10).findViewById(R$id.secondary_operation_text);
        initDeleteOrPrivateView$lambda$14.setVisibility(0);
        initDeleteOrPrivateView$lambda$14.setText(2131886363);
        s.h(initDeleteOrPrivateView$lambda$14, "initDeleteOrPrivateView$lambda$14");
        y.d(initDeleteOrPrivateView$lambda$14, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDeleteOrPrivateView$4$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.setHandleResult(new ShareItemHandledResult(State.CANCEL, ShareOperateType.DELETE, null, 4, null));
            }
        });
    }

    public final void g1() {
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        int i10 = R$id.deleteLayout;
        View deleteLayout = X0(i10);
        s.h(deleteLayout, "deleteLayout");
        aVar.a(deleteLayout);
        TextView textView = (TextView) X0(i10).findViewById(R$id.alert_dialog_message_text);
        textView.setVisibility(0);
        textView.setText(R$string.delete_select);
        TextView initDeleteView$lambda$9 = (TextView) X0(i10).findViewById(R$id.horizontal_main_button);
        initDeleteView$lambda$9.setVisibility(0);
        initDeleteView$lambda$9.setText(2131886528);
        s.h(initDeleteView$lambda$9, "initDeleteView$lambda$9");
        y.d(initDeleteView$lambda$9, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDeleteView$2$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.feedDelete();
            }
        });
        TextView initDeleteView$lambda$10 = (TextView) X0(i10).findViewById(R$id.horizontal_secondary_button);
        initDeleteView$lambda$10.setVisibility(0);
        initDeleteView$lambda$10.setText(2131886363);
        s.h(initDeleteView$lambda$10, "initDeleteView$lambda$10");
        y.d(initDeleteView$lambda$10, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDeleteView$3$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.setHandleResult(new ShareItemHandledResult(State.CANCEL, ShareOperateType.DELETE, null, 4, null));
            }
        });
    }

    public final void h1() {
        ShareModel shareModel = this.f12227f;
        boolean d10 = shareModel != null ? s.d(shareModel.getSuperLikedByMe(), Boolean.TRUE) : false;
        int c4 = CancelAttentionHelper.f18615a.c(Boolean.valueOf(d10));
        int i10 = d10 ? R$string.cancel_follow : 2131886528;
        int i11 = d10 ? R$string.think_again : 2131886363;
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        int i12 = R$id.cancelLikeLayout;
        View cancelLikeLayout = X0(i12);
        s.h(cancelLikeLayout, "cancelLikeLayout");
        aVar.a(cancelLikeLayout);
        ShareModel shareModel2 = this.f12227f;
        if (shareModel2 != null ? s.d(shareModel2.getSuperLikedByMe(), Boolean.TRUE) : false) {
            TextView textView = (TextView) X0(i12).findViewById(R$id.alert_dialog_title_text);
            textView.setVisibility(0);
            textView.setText(R$string.confirm_to_cancel_follow);
        }
        TextView textView2 = (TextView) X0(i12).findViewById(R$id.alert_dialog_message_text);
        textView2.setVisibility(0);
        textView2.setText(c4);
        TextView initDisLikeView$lambda$17 = (TextView) X0(i12).findViewById(R$id.horizontal_main_button);
        initDisLikeView$lambda$17.setVisibility(0);
        initDisLikeView$lambda$17.setText(i10);
        s.h(initDisLikeView$lambda$17, "initDisLikeView$lambda$17");
        y.d(initDisLikeView$lambda$17, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDisLikeView$3$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.disLikeUser();
            }
        });
        TextView initDisLikeView$lambda$18 = (TextView) X0(i12).findViewById(R$id.horizontal_secondary_button);
        initDisLikeView$lambda$18.setVisibility(0);
        initDisLikeView$lambda$18.setText(i11);
        s.h(initDisLikeView$lambda$18, "initDisLikeView$lambda$18");
        y.d(initDisLikeView$lambda$18, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDisLikeView$4$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.setHandleResult(new ShareItemHandledResult(State.CANCEL, ShareOperateType.DISLIKE_U, null, 4, null));
            }
        });
    }

    public final void i1() {
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        int i10 = R$id.dontLookHimLayout;
        View dontLookHimLayout = X0(i10);
        s.h(dontLookHimLayout, "dontLookHimLayout");
        aVar.a(dontLookHimLayout);
        TextView textView = (TextView) X0(i10).findViewById(R$id.alert_dialog_title_text);
        textView.setVisibility(0);
        textView.setText(R$string.confirm_dont_look_him);
        TextView textView2 = (TextView) X0(i10).findViewById(R$id.alert_dialog_message_text);
        textView2.setVisibility(0);
        textView2.setText(R$string.dont_look_him_description);
        TextView initDontLookHimView$lambda$21 = (TextView) X0(i10).findViewById(R$id.horizontal_main_button);
        initDontLookHimView$lambda$21.setVisibility(0);
        initDontLookHimView$lambda$21.setText(R$string.determine);
        s.h(initDontLookHimView$lambda$21, "initDontLookHimView$lambda$21");
        y.d(initDontLookHimView$lambda$21, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDontLookHimView$3$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.dontLook();
            }
        });
        TextView initDontLookHimView$lambda$22 = (TextView) X0(i10).findViewById(R$id.horizontal_secondary_button);
        initDontLookHimView$lambda$22.setVisibility(0);
        initDontLookHimView$lambda$22.setText(2131886363);
        s.h(initDontLookHimView$lambda$22, "initDontLookHimView$lambda$22");
        y.d(initDontLookHimView$lambda$22, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initDontLookHimView$4$1
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.setHandleResult(new ShareItemHandledResult(State.CANCEL, ShareOperateType.DONT_LOOK_HIM, null, 4, null));
            }
        });
    }

    public final void j1() {
        FragmentShareMenuBinding fragmentShareMenuBinding = this.f12228g;
        if (fragmentShareMenuBinding == null) {
            s.A("binding");
            fragmentShareMenuBinding = null;
        }
        fragmentShareMenuBinding.f13933h.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.share.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareBottomFragment.k1(ShareBottomFragment.this, view);
            }
        });
        X0(R$id.shareSelect).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.share.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareBottomFragment.l1(view);
            }
        });
        X0(R$id.blackLayout).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.share.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareBottomFragment.m1(view);
            }
        });
        X0(R$id.deleteLayout).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.share.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareBottomFragment.n1(view);
            }
        });
        X0(R$id.cancelLikeLayout).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.share.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareBottomFragment.o1(view);
            }
        });
        e1();
        g1();
        h1();
        i1();
        f1();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        FragmentShareMenuBinding b4 = FragmentShareMenuBinding.b(inflater, viewGroup, false);
        s.h(b4, "inflate(inflater, container, false)");
        this.f12228g = b4;
        if (b4 == null) {
            s.A("binding");
            b4 = null;
        }
        RelativeLayout relativeLayout = b4.f13933h;
        s.h(relativeLayout, "binding.root");
        return relativeLayout;
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
                window3.setLayout(-1, -1);
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
        FragmentShareMenuBinding fragmentShareMenuBinding = this.f12228g;
        FragmentShareMenuBinding fragmentShareMenuBinding2 = null;
        if (fragmentShareMenuBinding == null) {
            s.A("binding");
            fragmentShareMenuBinding = null;
        }
        fragmentShareMenuBinding.setLifecycleOwner(requireActivity());
        FragmentShareMenuBinding fragmentShareMenuBinding3 = this.f12228g;
        if (fragmentShareMenuBinding3 == null) {
            s.A("binding");
        } else {
            fragmentShareMenuBinding2 = fragmentShareMenuBinding3;
        }
        fragmentShareMenuBinding2.d(d1());
        p1();
        j1();
        t1();
    }

    public final void p1() {
        d1().getModels().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.base.share.fragment.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShareBottomFragment.q1(ShareBottomFragment.this, (Pair) obj);
            }
        });
        d1().getHandledResult().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.base.share.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ShareBottomFragment.r1(ShareBottomFragment.this, (ShareItemHandledResult) obj);
            }
        });
        d1().getPurchaseEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<VipPurchaseEntranceType, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(VipPurchaseEntranceType vipPurchaseEntranceType) {
                invoke2(vipPurchaseEntranceType);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull VipPurchaseEntranceType it) {
                PurchaseDialogManager c12;
                s.i(it, "it");
                VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.FeedTop;
                if (it == vipPurchaseEntranceType) {
                    c12 = ShareBottomFragment.this.c1();
                    PurchaseDialogManager.j(c12, vipPurchaseEntranceType, null, null, false, 14, null);
                }
            }
        }));
    }

    @Override // com.cupidapp.live.base.share.view.a
    public void q(@NotNull ShareBaseType type) {
        s.i(type, "type");
        d1().showItemNewDot(type);
    }

    public final void s1(Collection<? extends BaseShareItemModel> collection, Collection<? extends BaseShareItemModel> collection2) {
        float max = Math.max(collection != null ? collection.size() : 0.0f, 5.0f);
        if (collection == null || collection.isEmpty()) {
            ((TextView) X0(R$id.shareSelect).findViewById(R$id.shareTitleTxt)).setVisibility(8);
        } else {
            int i10 = R$id.shareSelect;
            ((TextView) X0(i10).findViewById(R$id.shareTitleTxt)).setVisibility(0);
            u1(collection, (LinearLayout) X0(i10).findViewById(R$id.sharePlatformLinear), max);
        }
        float max2 = Math.max(collection2 != null ? collection2.size() : 0.0f, 5.0f);
        int i11 = R$id.shareSelect;
        u1(collection2, (LinearLayout) X0(i11).findViewById(R$id.shareOperateLinear), max2);
        View findViewById = X0(i11).findViewById(R$id.shareCancelTxt);
        s.h(findViewById, "shareSelect.findViewById…iew>(R.id.shareCancelTxt)");
        y.d(findViewById, new Function1<View, p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$initShareView$1
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
                ShareBottomFragment.this.dismiss();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if ((r1.length() > 0) == true) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t1() {
        /*
            r26 = this;
            r0 = r26
            com.cupidapp.live.base.share.fragment.ShareModel r1 = r0.f12227f
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1a
            java.lang.String r1 = r1.getSnapWebContentImageUrl()
            if (r1 == 0) goto L1a
            int r1 = r1.length()
            if (r1 <= 0) goto L16
            r1 = 1
            goto L17
        L16:
            r1 = 0
        L17:
            if (r1 != r2) goto L1a
            goto L1b
        L1a:
            r2 = 0
        L1b:
            if (r2 == 0) goto L6c
            int r1 = com.cupidapp.live.R$id.snap_web_content_image
            android.view.View r2 = r0.X0(r1)
            com.cupidapp.live.base.imageloader.ImageLoaderView r2 = (com.cupidapp.live.base.imageloader.ImageLoaderView) r2
            r2.setVisibility(r3)
            android.view.View r1 = r0.X0(r1)
            com.cupidapp.live.base.imageloader.ImageLoaderView r1 = (com.cupidapp.live.base.imageloader.ImageLoaderView) r1
            java.lang.String r2 = "snap_web_content_image"
            kotlin.jvm.internal.s.h(r1, r2)
            com.cupidapp.live.base.imageloader.b r2 = new com.cupidapp.live.base.imageloader.b
            r4 = 0
            com.cupidapp.live.base.share.fragment.ShareModel r3 = r0.f12227f
            r5 = 0
            if (r3 == 0) goto L42
            java.lang.String r3 = r3.getSnapWebContentImageUrl()
            r25 = r3
            goto L44
        L42:
            r25 = r5
        L44:
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 524285(0x7fffd, float:7.3468E-40)
            r24 = 0
            r3 = r2
            r0 = r5
            r5 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r3 = 2
            com.cupidapp.live.base.imageloader.ImageLoaderView.f(r1, r2, r0, r3, r0)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.share.fragment.ShareBottomFragment.t1():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u1(Collection<? extends BaseShareItemModel> collection, LinearLayout linearLayout, float f10) {
        int c4;
        Context it;
        if (collection == null) {
            return;
        }
        if (f10 <= 5.0f) {
            c4 = (int) ((z0.h.l(this) - z0.h.c(this, 20.0f)) / f10);
        } else if (z0.h.l(this) > 0) {
            c4 = (int) ((z0.h.l(this) - z0.h.c(this, 10.0f)) / 5.3f);
        } else {
            c4 = z0.h.c(this, 65.0f);
        }
        for (BaseShareItemModel baseShareItemModel : collection) {
            ShareItemCustomMenuView shareItemCustomMenuView = null;
            shareItemCustomMenuView = null;
            shareItemCustomMenuView = null;
            if (baseShareItemModel instanceof FKShareItemModel) {
                Context it2 = getContext();
                if (it2 != null) {
                    s.h(it2, "it");
                    ShareItemMenuView shareItemMenuView = new ShareItemMenuView(it2);
                    shareItemMenuView.f((FKShareItemModel) baseShareItemModel, this);
                    shareItemCustomMenuView = shareItemMenuView;
                }
            } else if ((baseShareItemModel instanceof CustomShareItemModel) && (it = getContext()) != null) {
                s.h(it, "it");
                ShareItemCustomMenuView shareItemCustomMenuView2 = new ShareItemCustomMenuView(it);
                shareItemCustomMenuView2.e((CustomShareItemModel) baseShareItemModel, this);
                shareItemCustomMenuView = shareItemCustomMenuView2;
            }
            if (linearLayout != null) {
                linearLayout.addView(shareItemCustomMenuView, new LinearLayout.LayoutParams(c4, -2));
            }
        }
    }

    public final void v1(@NotNull FragmentManager manager, @NotNull ShareModel model, @Nullable com.cupidapp.live.base.share.view.b bVar) {
        s.i(manager, "manager");
        s.i(model, "model");
        this.f12227f = model;
        this.f12229h = bVar;
        super.show(manager, ShareBottomFragment.class.getSimpleName());
    }

    public final void x1(final ShareBaseType shareBaseType) {
        FKAlertDialog.w(FKAlertDialog.r(FKAlertDialog.o(FKAlertDialog.f12698l.b(getContext(), true).j(false).D(R$string.confirm_un_close_friend), R$string.remove_close_friend_con, 0, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$showUnCloseFriendDialog$1
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
                ShareBottomFragment.this.dismiss();
            }
        }, 1, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$showUnCloseFriendDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ShareBottomViewModel d12;
                d12 = ShareBottomFragment.this.d1();
                d12.itemClick(shareBaseType);
            }
        }, 3, null).u(new Function0<p>() { // from class: com.cupidapp.live.base.share.fragment.ShareBottomFragment$showUnCloseFriendDialog$3
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
                ((RelativeLayout) ShareBottomFragment.this.X0(R$id.root)).setVisibility(4);
            }
        }).F(Integer.valueOf(R$style.dialog_no_animation));
    }
}

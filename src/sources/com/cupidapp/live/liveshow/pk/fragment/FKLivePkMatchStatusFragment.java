package com.cupidapp.live.liveshow.pk.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.model.LivePkRequestResult;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.v;
import z0.y;

/* compiled from: FKLivePkMatchStatusFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkMatchStatusFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f15118h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f15119e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15121g = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final i f15120f = new i();

    /* compiled from: FKLivePkMatchStatusFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKLivePkMatchStatusFragment a(@Nullable FragmentManager fragmentManager, @NotNull b listener) {
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment = new FKLivePkMatchStatusFragment();
            fKLivePkMatchStatusFragment.f15119e = listener;
            fKLivePkMatchStatusFragment.show(fragmentManager, FKLivePkMatchStatusFragment.class.getSimpleName());
            return fKLivePkMatchStatusFragment;
        }
    }

    /* compiled from: FKLivePkMatchStatusFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a();

        void b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i1(FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        fKLivePkMatchStatusFragment.h1(z10, function1);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15121g.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15121g;
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

    public final void c1() {
        View blankView = V0(R$id.blankView);
        s.h(blankView, "blankView");
        y.d(blankView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$bindClickEvent$1
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
                if (FKLiveGrpcEntity.f14907e.a().f() == FKLivePkStatus.LivePkMatching) {
                    return;
                }
                FKLivePkMatchStatusFragment.this.dismiss();
            }
        });
        FKUniversalButton cancelPkMatch = (FKUniversalButton) V0(R$id.cancelPkMatch);
        s.h(cancelPkMatch, "cancelPkMatch");
        y.d(cancelPkMatch, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$bindClickEvent$2
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
                final FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment = FKLivePkMatchStatusFragment.this;
                fKLivePkMatchStatusFragment.h1(true, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$bindClickEvent$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Integer num) {
                        invoke(num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(int i10) {
                        i iVar;
                        FKLivePkMatchStatusFragment.b bVar;
                        iVar = FKLivePkMatchStatusFragment.this.f15120f;
                        iVar.g();
                        FKLivePkMatchStatusFragment.this.dismiss();
                        bVar = FKLivePkMatchStatusFragment.this.f15119e;
                        if (bVar != null) {
                            bVar.a();
                        }
                    }
                });
            }
        });
        FKUniversalButton tryMatchAgain = (FKUniversalButton) V0(R$id.tryMatchAgain);
        s.h(tryMatchAgain, "tryMatchAgain");
        y.d(tryMatchAgain, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$bindClickEvent$3
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
                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.RandomPkMatch);
                ((ConstraintLayout) FKLivePkMatchStatusFragment.this.V0(R$id.livePkMatchingLayout)).setVisibility(0);
                ((LinearLayout) FKLivePkMatchStatusFragment.this.V0(R$id.livePkMatchFailedLayout)).setVisibility(8);
                FKLivePkMatchStatusFragment.this.e1();
                final FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment = FKLivePkMatchStatusFragment.this;
                fKLivePkMatchStatusFragment.h1(false, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$bindClickEvent$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Integer num) {
                        invoke(num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(int i10) {
                        FKLivePkMatchStatusFragment.this.j1(i10);
                    }
                });
            }
        });
        FKUniversalButton challengeFriends = (FKUniversalButton) V0(R$id.challengeFriends);
        s.h(challengeFriends, "challengeFriends");
        y.d(challengeFriends, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$bindClickEvent$4
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
                FKLivePkMatchStatusFragment.b bVar;
                FKLivePkMatchStatusFragment.this.dismiss();
                bVar = FKLivePkMatchStatusFragment.this.f15119e;
                if (bVar != null) {
                    bVar.b();
                }
            }
        });
    }

    public final void d1() {
        User X = g.f52734a.X();
        if (X == null) {
            return;
        }
        ImageLoaderView livePkMyAvatar = (ImageLoaderView) V0(R$id.livePkMyAvatar);
        s.h(livePkMyAvatar, "livePkMyAvatar");
        ImageLoaderView.g(livePkMyAvatar, X.getAvatarImage(), null, null, 6, null);
        ((TextView) V0(R$id.livePkMyName)).setText(X.getName());
        e1();
    }

    public final void e1() {
        ((TextView) V0(R$id.matchStatusTextView)).setText(getString(R$string.pk_matching));
        FKSVGAImageView loadingAnimationView = (FKSVGAImageView) V0(R$id.loadingAnimationView);
        s.h(loadingAnimationView, "loadingAnimationView");
        FKSVGAImageView.F(loadingAnimationView, "loading.svga", null, null, 6, null);
    }

    public final void f1(@NotNull User pkUser) {
        s.i(pkUser, "pkUser");
        this.f15120f.g();
        ((FKUniversalButton) V0(R$id.cancelPkMatch)).setVisibility(8);
        ((TextView) V0(R$id.pkMatchCountDownTextView)).setText(getString(R$string.pk_match_success));
        ((TextView) V0(R$id.matchStatusTextView)).setText(getString(R$string.pk_will_start_right_away));
        ImageLoaderView livePkOthersAvatar = (ImageLoaderView) V0(R$id.livePkOthersAvatar);
        s.h(livePkOthersAvatar, "livePkOthersAvatar");
        ImageLoaderView.g(livePkOthersAvatar, pkUser.getAvatarImage(), null, null, 6, null);
        ((TextView) V0(R$id.livePkOthersName)).setText(pkUser.getName());
        int i10 = R$id.loadingAnimationView;
        ((FKSVGAImageView) V0(i10)).setLoops(1);
        FKSVGAImageView loadingAnimationView = (FKSVGAImageView) V0(i10);
        s.h(loadingAnimationView, "loadingAnimationView");
        FKSVGAImageView.F(loadingAnimationView, "vs.svga", null, null, 6, null);
        int i11 = R$id.pkCountDownImageView;
        ((FKSVGAImageView) V0(i11)).setVisibility(0);
        FKSVGAImageView pkCountDownImageView = (FKSVGAImageView) V0(i11);
        s.h(pkCountDownImageView, "pkCountDownImageView");
        FKSVGAImageView.F(pkCountDownImageView, "count_down_three_seconds.svga", null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$refreshPkUserLayout$1
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
                FKLivePkMatchStatusFragment.this.Q0();
            }
        }, 2, null);
    }

    public final void g1() {
        setCancelable(true);
        i1(this, true, null, 2, null);
        ((TextView) V0(R$id.pkMatchCountDownTextView)).setText(getString(R$string.pk_match_failed));
        ((TextView) V0(R$id.matchStatusTextView)).setText(getString(R$string.no_suitable_match_users));
        ((ConstraintLayout) V0(R$id.livePkMatchingLayout)).setVisibility(8);
        ((LinearLayout) V0(R$id.livePkMatchFailedLayout)).setVisibility(0);
        ((FKSVGAImageView) V0(R$id.loadingAnimationView)).w();
    }

    public final void h1(final boolean z10, @Nullable final Function1<? super Integer, p> function1) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().g(itemId, z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LivePkRequestResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$requestMatchPk$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LivePkRequestResult livePkRequestResult) {
                m2627invoke(livePkRequestResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2627invoke(LivePkRequestResult livePkRequestResult) {
                LivePkRequestResult livePkRequestResult2 = livePkRequestResult;
                Function1 function12 = Function1.this;
                if (function12 != null) {
                    function12.invoke(Integer.valueOf(livePkRequestResult2.getWaitSec()));
                }
                FKLiveGrpcEntity.f14907e.a().t(z10 ? FKLivePkStatus.LivePkInitialize : FKLivePkStatus.LivePkMatching);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void j1(int i10) {
        setCancelable(false);
        this.f15120f.c(Integer.valueOf(i10), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$startCountDown$1
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
                FKLivePkMatchStatusFragment.this.g1();
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$startCountDown$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                ((TextView) FKLivePkMatchStatusFragment.this.V0(R$id.pkMatchCountDownTextView)).setText(v.j(i11));
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_pk_match_status, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f15120f.g();
        ((FKSVGAImageView) V0(R$id.loadingAnimationView)).w();
        ((FKSVGAImageView) V0(R$id.pkCountDownImageView)).w();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        d1();
        c1();
        h1(false, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment$onViewCreated$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                FKLivePkMatchStatusFragment.this.j1(i10);
            }
        });
    }
}

package com.cupidapp.live.liveshow.pk.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LivePkAppointRequestModel;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.pk.model.AcceptInvitingResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkInvitationModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: FKLivePkRequestFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkRequestFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f15127j = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Function1<? super AcceptInvitingResult, p> f15128e;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15132i = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f15129f = c.b(new Function0<LivePkType>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$pkType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final LivePkType invoke() {
            Bundle arguments = FKLivePkRequestFragment.this.getArguments();
            if (arguments != null) {
                return (LivePkType) g.b(arguments, LivePkType.class);
            }
            return null;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f15130g = c.b(new Function0<LivePkAppointRequestModel>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$pkRequestModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final LivePkAppointRequestModel invoke() {
            Bundle arguments = FKLivePkRequestFragment.this.getArguments();
            if (arguments != null) {
                return (LivePkAppointRequestModel) g.b(arguments, LivePkAppointRequestModel.class);
            }
            return null;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f15131h = c.b(new Function0<MultiPkInvitationModel>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$multiPkModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final MultiPkInvitationModel invoke() {
            Bundle arguments = FKLivePkRequestFragment.this.getArguments();
            if (arguments != null) {
                return (MultiPkInvitationModel) g.b(arguments, MultiPkInvitationModel.class);
            }
            return null;
        }
    });

    /* compiled from: FKLivePkRequestFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKLivePkRequestFragment a(@Nullable FragmentManager fragmentManager, @NotNull LivePkType pkType, @Nullable LivePkAppointRequestModel livePkAppointRequestModel, @Nullable MultiPkInvitationModel multiPkInvitationModel, @Nullable Function1<? super AcceptInvitingResult, p> function1) {
            s.i(pkType, "pkType");
            if (fragmentManager == null) {
                return null;
            }
            FKLivePkRequestFragment fKLivePkRequestFragment = new FKLivePkRequestFragment();
            Bundle bundle = new Bundle();
            g.d(bundle, pkType);
            if (livePkAppointRequestModel != null) {
                g.d(bundle, livePkAppointRequestModel);
            }
            if (multiPkInvitationModel != null) {
                g.d(bundle, multiPkInvitationModel);
            }
            fKLivePkRequestFragment.setArguments(bundle);
            fKLivePkRequestFragment.f15128e = function1;
            fKLivePkRequestFragment.show(fragmentManager, FKLivePkRequestFragment.class.getSimpleName());
            return fKLivePkRequestFragment;
        }
    }

    /* compiled from: FKLivePkRequestFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15133a;

        static {
            int[] iArr = new int[LivePkType.values().length];
            try {
                iArr[LivePkType.DoublePk.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LivePkType.MultiPk.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f15133a = iArr;
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15132i.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15132i;
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

    public final void W0() {
        final String itemId;
        String pkLiveShowId;
        MultiPkInvitationModel d12;
        String pkPrepareId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        LivePkType f12 = f1();
        int i10 = f12 == null ? -1 : b.f15133a[f12.ordinal()];
        if (i10 != 1) {
            if (i10 != 2 || (d12 = d1()) == null || (pkPrepareId = d12.getPkPrepareId()) == null) {
                return;
            }
            Disposable disposed = NetworkClient.f11868a.r().H(itemId, pkPrepareId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AcceptInvitingResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$acceptPk$$inlined$handle$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(AcceptInvitingResult acceptInvitingResult) {
                    m2629invoke(acceptInvitingResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2629invoke(AcceptInvitingResult acceptInvitingResult) {
                    Function1 function1;
                    AcceptInvitingResult acceptInvitingResult2 = acceptInvitingResult;
                    FKLivePkRequestFragment.this.dismiss();
                    function1 = FKLivePkRequestFragment.this.f15128e;
                    if (function1 != null) {
                        function1.invoke(acceptInvitingResult2);
                    }
                    GroupLiveLog.f18698a.a(itemId);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$acceptPk$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    FKLivePkRequestFragment.this.dismiss();
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
            return;
        }
        LivePkAppointRequestModel e12 = e1();
        if (e12 == null || (pkLiveShowId = e12.getPkLiveShowId()) == null) {
            return;
        }
        Disposable disposed2 = NetworkClient.f11868a.r().e0(itemId, pkLiveShowId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$acceptPk$$inlined$handle$1
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
                Function1 function1;
                FKLivePkRequestFragment.this.dismiss();
                function1 = FKLivePkRequestFragment.this.f15128e;
                if (function1 != null) {
                    function1.invoke(null);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$acceptPk$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKLivePkRequestFragment.this.dismiss();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            H(disposed2);
        }
        s.h(disposed2, "disposed");
    }

    public final void c1() {
        ImageView refusePkImageView = (ImageView) V0(R$id.refusePkImageView);
        s.h(refusePkImageView, "refusePkImageView");
        y.d(refusePkImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$bindClickEvent$1
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
                FKLivePkRequestFragment.this.i1();
            }
        });
        FKSVGAImageView acceptPkImageView = (FKSVGAImageView) V0(R$id.acceptPkImageView);
        s.h(acceptPkImageView, "acceptPkImageView");
        y.d(acceptPkImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$bindClickEvent$2
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
                FKLivePkRequestFragment.this.W0();
            }
        });
        ImageView notAcceptButton = (ImageView) V0(R$id.notAcceptButton);
        s.h(notAcceptButton, "notAcceptButton");
        y.d(notAcceptButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$bindClickEvent$3
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
                FKLivePkRequestFragment fKLivePkRequestFragment = FKLivePkRequestFragment.this;
                fKLivePkRequestFragment.h1(((ImageView) fKLivePkRequestFragment.V0(R$id.notAcceptButton)).isSelected());
            }
        });
    }

    public final MultiPkInvitationModel d1() {
        return (MultiPkInvitationModel) this.f15131h.getValue();
    }

    public final LivePkAppointRequestModel e1() {
        return (LivePkAppointRequestModel) this.f15130g.getValue();
    }

    public final LivePkType f1() {
        return (LivePkType) this.f15129f.getValue();
    }

    public final void g1() {
        LivePkType f12 = f1();
        int i10 = f12 == null ? -1 : b.f15133a[f12.ordinal()];
        if (i10 == 1) {
            LivePkAppointRequestModel e12 = e1();
            User pkUser = e12 != null ? e12.getPkUser() : null;
            ImageLoaderView pkUserAvatarImageView = (ImageLoaderView) V0(R$id.pkUserAvatarImageView);
            s.h(pkUserAvatarImageView, "pkUserAvatarImageView");
            ImageLoaderView.g(pkUserAvatarImageView, pkUser != null ? pkUser.getAvatarImage() : null, null, null, 6, null);
            ((TextView) V0(R$id.pkUserName)).setText(pkUser != null ? pkUser.getName() : null);
            ((TextView) V0(R$id.requestDescription)).setText(getString(R$string.issued_pk_challenge_to_you));
            ((TextView) V0(R$id.shield_pk_txt)).setText(getString(R$string.not_accept_live_pk_challenge));
        } else if (i10 == 2) {
            MultiPkInvitationModel d12 = d1();
            User inviter = d12 != null ? d12.getInviter() : null;
            ImageLoaderView pkUserAvatarImageView2 = (ImageLoaderView) V0(R$id.pkUserAvatarImageView);
            s.h(pkUserAvatarImageView2, "pkUserAvatarImageView");
            ImageLoaderView.g(pkUserAvatarImageView2, inviter != null ? inviter.getAvatarImage() : null, null, null, 6, null);
            ((TextView) V0(R$id.pkUserName)).setText(inviter != null ? inviter.getName() : null);
            ((TextView) V0(R$id.requestDescription)).setText(getString(R$string.issued_multi_pk_challenge_to_you));
            ((TextView) V0(R$id.shield_pk_txt)).setText(getString(R$string.shield_multi_pk_challenge));
            LinearLayout linearLayout = (LinearLayout) V0(R$id.notAcceptChallengeLayout);
            LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
            linearLayout.setVisibility(fkLiveShowResult != null ? s.d(fkLiveShowResult.getHideBlockInvitationsButton(), Boolean.TRUE) : false ? 8 : 0);
        }
        FKSVGAImageView acceptPkImageView = (FKSVGAImageView) V0(R$id.acceptPkImageView);
        s.h(acceptPkImageView, "acceptPkImageView");
        FKSVGAImageView.F(acceptPkImageView, "call.svga", null, null, 6, null);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    public final void h1(final boolean z10) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().M0(itemId, z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$notAcceptLivePk$$inlined$handle$default$1
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
                ((ImageView) FKLivePkRequestFragment.this.V0(R$id.notAcceptButton)).setSelected(!z10);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void i1() {
        String itemId;
        String pkLiveShowId;
        Observable<Result<Object>> c4;
        String pkPrepareId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        LivePkType f12 = f1();
        int i10 = f12 == null ? -1 : b.f15133a[f12.ordinal()];
        if (i10 == 1) {
            LivePkAppointRequestModel e12 = e1();
            if (e12 == null || (pkLiveShowId = e12.getPkLiveShowId()) == null) {
                return;
            } else {
                c4 = NetworkClient.f11868a.r().c(itemId, pkLiveShowId);
            }
        } else if (i10 != 2) {
            c4 = null;
        } else {
            MultiPkInvitationModel d12 = d1();
            if (d12 == null || (pkPrepareId = d12.getPkPrepareId()) == null) {
                return;
            } else {
                c4 = NetworkClient.f11868a.r().v0(itemId, pkPrepareId);
            }
        }
        if (c4 != null) {
            Disposable disposed = c4.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$refusePk$$inlined$handle$1
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
                    FKLivePkRequestFragment.this.dismiss();
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment$refusePk$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    FKLivePkRequestFragment.this.dismiss();
                    return Boolean.TRUE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_pk_request, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((FKSVGAImageView) V0(R$id.acceptPkImageView)).w();
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
        g1();
        c1();
    }
}

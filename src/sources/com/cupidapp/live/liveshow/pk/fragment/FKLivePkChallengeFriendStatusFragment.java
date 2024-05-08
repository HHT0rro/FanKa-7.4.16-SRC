package com.cupidapp.live.liveshow.pk.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.model.LivePkRequestResult;
import com.cupidapp.live.liveshow.model.LivePkUserModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import com.cupidapp.live.profile.model.User;
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
import z0.v;
import z0.y;

/* compiled from: FKLivePkChallengeFriendStatusFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkChallengeFriendStatusFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15109i = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f15110e;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15113h = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f15111f = c.b(new Function0<LivePkUserModel>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$pkUserModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final LivePkUserModel invoke() {
            Bundle arguments = FKLivePkChallengeFriendStatusFragment.this.getArguments();
            if (arguments != null) {
                return (LivePkUserModel) g.b(arguments, LivePkUserModel.class);
            }
            return null;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final i f15112g = new i();

    /* compiled from: FKLivePkChallengeFriendStatusFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKLivePkChallengeFriendStatusFragment a(@Nullable FragmentManager fragmentManager, @NotNull LivePkUserModel pkUserModel, int i10, @NotNull b listener) {
            s.i(pkUserModel, "pkUserModel");
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment = new FKLivePkChallengeFriendStatusFragment();
            Bundle bundle = new Bundle();
            g.d(bundle, pkUserModel);
            bundle.putInt("COUNT_DOWN_TIME", i10);
            fKLivePkChallengeFriendStatusFragment.setArguments(bundle);
            fKLivePkChallengeFriendStatusFragment.f15110e = listener;
            fKLivePkChallengeFriendStatusFragment.show(fragmentManager, FKLivePkChallengeFriendStatusFragment.class.getSimpleName());
            return fKLivePkChallengeFriendStatusFragment;
        }
    }

    /* compiled from: FKLivePkChallengeFriendStatusFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void b();

        void c();

        void d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c1(FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        fKLivePkChallengeFriendStatusFragment.b1(z10, function1);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15113h.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15113h;
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
        FKUniversalButton cancelInviteFriend = (FKUniversalButton) V0(R$id.cancelInviteFriend);
        s.h(cancelInviteFriend, "cancelInviteFriend");
        y.d(cancelInviteFriend, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$1
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
                final FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment = FKLivePkChallengeFriendStatusFragment.this;
                fKLivePkChallengeFriendStatusFragment.b1(true, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Integer num) {
                        invoke(num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(int i10) {
                        FKLivePkChallengeFriendStatusFragment.b bVar;
                        FKLivePkChallengeFriendStatusFragment.this.dismiss();
                        bVar = FKLivePkChallengeFriendStatusFragment.this.f15110e;
                        if (bVar != null) {
                            bVar.c();
                        }
                    }
                });
            }
        });
        FKUniversalButton randomMatchButton = (FKUniversalButton) V0(R$id.randomMatchButton);
        s.h(randomMatchButton, "randomMatchButton");
        y.d(randomMatchButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$2
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
                FKLivePkChallengeFriendStatusFragment.b bVar;
                FKLivePkChallengeFriendStatusFragment.this.dismiss();
                bVar = FKLivePkChallengeFriendStatusFragment.this.f15110e;
                if (bVar != null) {
                    bVar.b();
                }
                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.RandomPkMatch);
            }
        });
        FKUniversalButton changeOthersButton = (FKUniversalButton) V0(R$id.changeOthersButton);
        s.h(changeOthersButton, "changeOthersButton");
        y.d(changeOthersButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$3
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
                FKLivePkChallengeFriendStatusFragment.b bVar;
                FKLivePkChallengeFriendStatusFragment.this.dismiss();
                bVar = FKLivePkChallengeFriendStatusFragment.this.f15110e;
                if (bVar != null) {
                    bVar.d();
                }
            }
        });
        FKUniversalButton tryInviteAgain = (FKUniversalButton) V0(R$id.tryInviteAgain);
        s.h(tryInviteAgain, "tryInviteAgain");
        y.d(tryInviteAgain, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$4
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
                ((TextView) FKLivePkChallengeFriendStatusFragment.this.V0(R$id.inviteFriendStatusTitle)).setText(FKLivePkChallengeFriendStatusFragment.this.getString(R$string.have_sent_invitation));
                ((TextView) FKLivePkChallengeFriendStatusFragment.this.V0(R$id.inviteFriendStatusDescription)).setVisibility(0);
                ((RelativeLayout) FKLivePkChallengeFriendStatusFragment.this.V0(R$id.inviteFriendInfoLayout)).setVisibility(0);
                ((RelativeLayout) FKLivePkChallengeFriendStatusFragment.this.V0(R$id.inviteFailedLayout)).setVisibility(8);
                final FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment = FKLivePkChallengeFriendStatusFragment.this;
                fKLivePkChallengeFriendStatusFragment.b1(false, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$4.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Integer num) {
                        invoke(num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(int i10) {
                        FKLivePkChallengeFriendStatusFragment.this.g1(i10);
                    }
                });
                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.ChallengeFriends);
            }
        });
        FKUniversalButton randomMatch = (FKUniversalButton) V0(R$id.randomMatch);
        s.h(randomMatch, "randomMatch");
        y.d(randomMatch, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$5
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
                FKLivePkChallengeFriendStatusFragment.b bVar;
                FKLivePkChallengeFriendStatusFragment.this.dismiss();
                bVar = FKLivePkChallengeFriendStatusFragment.this.f15110e;
                if (bVar != null) {
                    bVar.b();
                }
                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.RandomPkMatch);
            }
        });
        FKUniversalButton changeOthers = (FKUniversalButton) V0(R$id.changeOthers);
        s.h(changeOthers, "changeOthers");
        y.d(changeOthers, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$bindClickEvent$6
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
                FKLivePkChallengeFriendStatusFragment.b bVar;
                FKLivePkChallengeFriendStatusFragment.this.dismiss();
                bVar = FKLivePkChallengeFriendStatusFragment.this.f15110e;
                if (bVar != null) {
                    bVar.d();
                }
            }
        });
    }

    public final void b1(final boolean z10, final Function1<? super Integer, p> function1) {
        String itemId;
        LivePkUserModel d12;
        String id2;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || (d12 = d1()) == null || (id2 = d12.getId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().K0(itemId, id2, z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LivePkRequestResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$challengeFriend$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LivePkRequestResult livePkRequestResult) {
                m2624invoke(livePkRequestResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2624invoke(LivePkRequestResult livePkRequestResult) {
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

    public final LivePkUserModel d1() {
        return (LivePkUserModel) this.f15111f.getValue();
    }

    public final void e1() {
        LivePkUserModel d12 = d1();
        User user = d12 != null ? d12.getUser() : null;
        ImageLoaderView inviteFriendAvatar = (ImageLoaderView) V0(R$id.inviteFriendAvatar);
        s.h(inviteFriendAvatar, "inviteFriendAvatar");
        ImageLoaderView.g(inviteFriendAvatar, user != null ? user.getAvatarImage() : null, null, null, 6, null);
        ((TextView) V0(R$id.inviteFriendName)).setText(user != null ? user.getName() : null);
        FKLiveGrpcEntity.f14907e.a().t(FKLivePkStatus.LivePkMatching);
    }

    public final void f1(boolean z10) {
        User user;
        setCancelable(true);
        this.f15112g.g();
        ((TextView) V0(R$id.inviteFriendStatusDescription)).setVisibility(8);
        ((RelativeLayout) V0(R$id.inviteFriendInfoLayout)).setVisibility(8);
        ((TextView) V0(R$id.inviteFriendStatusTitle)).setText(getString(R$string.invite_failed));
        ((RelativeLayout) V0(R$id.inviteFailedLayout)).setVisibility(0);
        Object[] objArr = new Object[1];
        LivePkUserModel d12 = d1();
        objArr[0] = (d12 == null || (user = d12.getUser()) == null) ? null : user.getName();
        String string = getString(R$string.invite_friend_name, objArr);
        s.h(string, "getString(R.string.invit… pkUserModel?.user?.name)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5515265), 0, string.length(), 33);
        if (z10) {
            spannableStringBuilder.append((CharSequence) getString(R$string.refuse_your_invitation));
            FKLiveGrpcEntity.f14907e.a().t(FKLivePkStatus.LivePkInitialize);
        } else {
            spannableStringBuilder.append((CharSequence) getString(R$string.not_accept_invitation_in_limit_time));
            c1(this, true, null, 2, null);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-1), string.length(), spannableStringBuilder.length(), 33);
        ((TextView) V0(R$id.refuseInvitePrompt)).setText(spannableStringBuilder);
        ((LinearLayout) V0(R$id.refuseInviteLayout)).setVisibility(z10 ? 0 : 8);
        ((LinearLayout) V0(R$id.inviteTimeOutLayout)).setVisibility(z10 ? 8 : 0);
    }

    public final void g1(int i10) {
        setCancelable(false);
        this.f15112g.c(Integer.valueOf(i10), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$startCountDown$1
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
                FKLivePkChallengeFriendStatusFragment.this.f1(false);
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment$startCountDown$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                ((TextView) FKLivePkChallengeFriendStatusFragment.this.V0(R$id.inviteFriendStatusTitle)).setText(v.j(i11));
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_pk_challenge_friend_status, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f15112g.g();
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
        e1();
        a1();
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i10 = arguments.getInt("COUNT_DOWN_TIME");
            ((TextView) V0(R$id.inviteLimitTimePrompt)).setText(getString(R$string.invite_limit_time, Integer.valueOf(i10)));
            g1(i10);
        }
    }
}

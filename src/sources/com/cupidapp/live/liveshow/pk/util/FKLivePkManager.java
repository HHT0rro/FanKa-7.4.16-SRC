package com.cupidapp.live.liveshow.pk.util;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.CloseBottomSheetFragmentEvent;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.model.LivePkAppointRequestModel;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.LivePkUserModel;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment;
import com.cupidapp.live.liveshow.pk.model.AcceptInvitingResult;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import com.cupidapp.live.profile.model.User;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkManager {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final FragmentManager f15141a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.pk.util.a f15142b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKLivePkPatternSelectFragment f15143c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FKLivePkMatchStatusFragment f15144d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKLivePkFriendListFragment f15145e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public FKLivePkChallengeFriendStatusFragment f15146f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public FKLivePkRequestFragment f15147g;

    /* compiled from: FKLivePkManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements FKLivePkFriendListFragment.b {
        public a() {
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment.b
        public void a() {
            FKLivePkManager.this.o();
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment.b
        public void b(@NotNull LivePkUserModel pkUserModel, int i10) {
            s.i(pkUserModel, "pkUserModel");
            FKLivePkManager.this.m(pkUserModel, i10);
        }
    }

    /* compiled from: FKLivePkManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements FKLivePkChallengeFriendStatusFragment.b {
        public b() {
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment.b
        public void b() {
            FKLivePkManager.this.n();
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment.b
        public void c() {
            FKLivePkManager.this.l();
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkChallengeFriendStatusFragment.b
        public void d() {
            FKLivePkManager.this.l();
        }
    }

    /* compiled from: FKLivePkManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements FKLivePkMatchStatusFragment.b {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment.b
        public void a() {
            FKLivePkManager.this.o();
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkMatchStatusFragment.b
        public void b() {
            FKLivePkManager.this.l();
        }
    }

    /* compiled from: FKLivePkManager.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements FKLivePkPatternSelectFragment.b {
        public d() {
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment.b
        public void a() {
            com.cupidapp.live.liveshow.pk.util.a aVar = FKLivePkManager.this.f15142b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment.b
        public void b() {
            FKLivePkManager.this.n();
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.FKLivePkPatternSelectFragment.b
        public void c() {
            FKLivePkManager.this.l();
        }
    }

    public FKLivePkManager(@Nullable FragmentManager fragmentManager) {
        this.f15141a = fragmentManager;
    }

    public final void f() {
        FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment;
        if (FKLiveGrpcEntity.f14907e.a().f() == FKLivePkStatus.LivePkMatching) {
            FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment2 = this.f15144d;
            boolean z10 = false;
            if (fKLivePkMatchStatusFragment2 != null && fKLivePkMatchStatusFragment2.isResumed()) {
                z10 = true;
            }
            if (!z10 || (fKLivePkMatchStatusFragment = this.f15144d) == null) {
                return;
            }
            fKLivePkMatchStatusFragment.h1(true, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.util.FKLivePkManager$cancelPkMatch$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Integer num) {
                    invoke(num.intValue());
                    return p.f51048a;
                }

                public final void invoke(int i10) {
                    FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment3;
                    fKLivePkMatchStatusFragment3 = FKLivePkManager.this.f15144d;
                    if (fKLivePkMatchStatusFragment3 != null) {
                        fKLivePkMatchStatusFragment3.dismiss();
                    }
                }
            });
        }
    }

    public final void g(@NotNull String userName, @NotNull Context context) {
        s.i(userName, "userName");
        s.i(context, "context");
        FKLivePkRequestFragment fKLivePkRequestFragment = this.f15147g;
        if (fKLivePkRequestFragment != null && fKLivePkRequestFragment.isAdded()) {
            h.f12779a.s(context, context.getString(R$string.cancel_pk_invitation, userName));
            FKLivePkRequestFragment fKLivePkRequestFragment2 = this.f15147g;
            if (fKLivePkRequestFragment2 != null) {
                fKLivePkRequestFragment2.Q0();
            }
        }
    }

    public final void h() {
        FKLivePkPatternSelectFragment fKLivePkPatternSelectFragment = this.f15143c;
        if (fKLivePkPatternSelectFragment != null) {
            fKLivePkPatternSelectFragment.Q0();
        }
        FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment = this.f15144d;
        if (fKLivePkMatchStatusFragment != null) {
            fKLivePkMatchStatusFragment.Q0();
        }
        FKLivePkFriendListFragment fKLivePkFriendListFragment = this.f15145e;
        if (fKLivePkFriendListFragment != null) {
            fKLivePkFriendListFragment.Q0();
        }
        FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment = this.f15146f;
        if (fKLivePkChallengeFriendStatusFragment != null) {
            fKLivePkChallengeFriendStatusFragment.Q0();
        }
        FKLivePkRequestFragment fKLivePkRequestFragment = this.f15147g;
        if (fKLivePkRequestFragment != null) {
            fKLivePkRequestFragment.Q0();
        }
        EventBus.c().l(new CloseBottomSheetFragmentEvent());
    }

    public final void i() {
        FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment = this.f15146f;
        if (fKLivePkChallengeFriendStatusFragment != null) {
            fKLivePkChallengeFriendStatusFragment.f1(true);
        }
    }

    public final void j(@Nullable User user, int i10) {
        FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment;
        FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment;
        if (i10 == SensorsLogLiveShow.PkRequestType.RandomPkMatch.getType()) {
            if (user == null || (fKLivePkMatchStatusFragment = this.f15144d) == null) {
                return;
            }
            fKLivePkMatchStatusFragment.f1(user);
            return;
        }
        if (i10 != SensorsLogLiveShow.PkRequestType.ChallengeFriends.getType() || (fKLivePkChallengeFriendStatusFragment = this.f15146f) == null) {
            return;
        }
        fKLivePkChallengeFriendStatusFragment.Q0();
    }

    public final void k(@NotNull com.cupidapp.live.liveshow.pk.util.a listener) {
        s.i(listener, "listener");
        this.f15142b = listener;
    }

    public final void l() {
        FKLivePkFriendListFragment fKLivePkFriendListFragment = this.f15145e;
        if (fKLivePkFriendListFragment != null && fKLivePkFriendListFragment.isAdded()) {
            return;
        }
        this.f15145e = FKLivePkFriendListFragment.f15114h.a(this.f15141a, new a());
    }

    public final void m(LivePkUserModel livePkUserModel, int i10) {
        FKLivePkChallengeFriendStatusFragment fKLivePkChallengeFriendStatusFragment = this.f15146f;
        if (fKLivePkChallengeFriendStatusFragment != null && fKLivePkChallengeFriendStatusFragment.isAdded()) {
            return;
        }
        this.f15146f = FKLivePkChallengeFriendStatusFragment.f15109i.a(this.f15141a, livePkUserModel, i10, new b());
    }

    public final void n() {
        FKLivePkMatchStatusFragment fKLivePkMatchStatusFragment = this.f15144d;
        if (fKLivePkMatchStatusFragment != null && fKLivePkMatchStatusFragment.isAdded()) {
            return;
        }
        this.f15144d = FKLivePkMatchStatusFragment.f15118h.a(this.f15141a, new c());
    }

    public final void o() {
        FKLivePkPatternSelectFragment fKLivePkPatternSelectFragment = this.f15143c;
        if (fKLivePkPatternSelectFragment != null && fKLivePkPatternSelectFragment.isAdded()) {
            return;
        }
        this.f15143c = FKLivePkPatternSelectFragment.f15122i.a(this.f15141a, new d());
    }

    public final void p(@NotNull LivePkAppointRequestModel pkRequestModel, @NotNull final Function0<p> acceptCallback) {
        s.i(pkRequestModel, "pkRequestModel");
        s.i(acceptCallback, "acceptCallback");
        FKLivePkRequestFragment fKLivePkRequestFragment = this.f15147g;
        if (fKLivePkRequestFragment != null && fKLivePkRequestFragment.isAdded()) {
            return;
        }
        this.f15147g = FKLivePkRequestFragment.f15127j.a(this.f15141a, LivePkType.DoublePk, pkRequestModel, null, new Function1<AcceptInvitingResult, p>() { // from class: com.cupidapp.live.liveshow.pk.util.FKLivePkManager$showRequestPkFragment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AcceptInvitingResult acceptInvitingResult) {
                invoke2(acceptInvitingResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable AcceptInvitingResult acceptInvitingResult) {
                FKLivePkManager.this.h();
                acceptCallback.invoke();
            }
        });
    }
}

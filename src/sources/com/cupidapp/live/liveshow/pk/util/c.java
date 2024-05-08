package com.cupidapp.live.liveshow.pk.util;

import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkRequestFragment;
import com.cupidapp.live.liveshow.pk.fragment.LivePkAnchorListFragment;
import com.cupidapp.live.liveshow.pk.model.AcceptInvitingResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkInvitationModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInviteStatus;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPkManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final FragmentManager f15157a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public LivePkAnchorListFragment f15158b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKLivePkRequestFragment f15159c;

    public c(@NotNull FragmentManager manager) {
        s.i(manager, "manager");
        this.f15157a = manager;
    }

    public final void a(@NotNull String liveShowId, @NotNull MultiPkInviteStatus inviteStatus) {
        LivePkAnchorListFragment livePkAnchorListFragment;
        s.i(liveShowId, "liveShowId");
        s.i(inviteStatus, "inviteStatus");
        LivePkAnchorListFragment livePkAnchorListFragment2 = this.f15158b;
        if (!(livePkAnchorListFragment2 != null && livePkAnchorListFragment2.isAdded()) || (livePkAnchorListFragment = this.f15158b) == null) {
            return;
        }
        livePkAnchorListFragment.g1(liveShowId, inviteStatus);
    }

    public final void b() {
        LivePkAnchorListFragment livePkAnchorListFragment;
        LivePkAnchorListFragment livePkAnchorListFragment2 = this.f15158b;
        if (!(livePkAnchorListFragment2 != null && livePkAnchorListFragment2.isAdded()) || (livePkAnchorListFragment = this.f15158b) == null) {
            return;
        }
        livePkAnchorListFragment.Q0();
    }

    public final void c() {
        FKLivePkRequestFragment fKLivePkRequestFragment;
        FKLivePkRequestFragment fKLivePkRequestFragment2 = this.f15159c;
        if (!(fKLivePkRequestFragment2 != null && fKLivePkRequestFragment2.isAdded()) || (fKLivePkRequestFragment = this.f15159c) == null) {
            return;
        }
        fKLivePkRequestFragment.Q0();
    }

    public final void d(@Nullable String str, @NotNull com.cupidapp.live.liveshow.pk.fragment.b listener) {
        s.i(listener, "listener");
        LivePkAnchorListFragment livePkAnchorListFragment = this.f15158b;
        if (livePkAnchorListFragment != null && livePkAnchorListFragment.isAdded()) {
            return;
        }
        this.f15158b = LivePkAnchorListFragment.f15134j.a(this.f15157a, str, listener);
    }

    public final void e(@NotNull MultiPkInvitationModel multiPkModel, @NotNull Function1<? super AcceptInvitingResult, p> acceptCallback) {
        s.i(multiPkModel, "multiPkModel");
        s.i(acceptCallback, "acceptCallback");
        FKLivePkRequestFragment fKLivePkRequestFragment = this.f15159c;
        if (fKLivePkRequestFragment != null && fKLivePkRequestFragment.isAdded()) {
            return;
        }
        this.f15159c = FKLivePkRequestFragment.f15127j.a(this.f15157a, LivePkType.MultiPk, null, multiPkModel, acceptCallback);
    }
}

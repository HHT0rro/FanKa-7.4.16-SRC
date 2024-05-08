package com.cupidapp.live.liveshow.fanclub;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubAutoLightUpFragment;
import com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubForAnchorFragment;
import com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubMemberFragment;
import com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment;
import com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment;
import com.cupidapp.live.liveshow.fanclub.model.AutoLightUpResult;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import com.cupidapp.live.liveshow.fanclub.model.FKFanClubResult;
import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.SendGiftResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: FKFanClubManager.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFanClubManager {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f14942a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final FragmentManager f14943b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public AtomicInteger f14944c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FKJoinInFanClubFragment f14945d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKFanClubTaskFragment f14946e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public FKFanClubAutoLightUpFragment f14947f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public FKFanClubResult f14948g;

    public FKFanClubManager(@Nullable Context context, @NotNull FragmentManager fragmentManager) {
        s.i(fragmentManager, "fragmentManager");
        this.f14942a = context;
        this.f14943b = fragmentManager;
        this.f14944c = new AtomicInteger((int) (Math.random() * 10000));
    }

    public static /* synthetic */ void n(FKFanClubManager fKFanClubManager, String str, int i10, Integer num, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            num = null;
        }
        fKFanClubManager.m(str, i10, num, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w(FKFanClubManager fKFanClubManager, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        fKFanClubManager.v(z10, function0);
    }

    public final void j() {
        FKFanClubTaskFragment fKFanClubTaskFragment = this.f14946e;
        if (fKFanClubTaskFragment != null) {
            fKFanClubTaskFragment.dismiss();
        }
    }

    @Nullable
    public final FKFanClubResult k() {
        return this.f14948g;
    }

    public final void l(@NotNull String anchorId, @NotNull final Function1<? super Integer, p> success, @NotNull final Function0<p> failed) {
        s.i(anchorId, "anchorId");
        s.i(success, "success");
        s.i(failed, "failed");
        Observable<Result<FKFanClubResult>> x02 = NetworkClient.f11868a.r().x0(anchorId);
        Object obj = this.f14942a;
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$getFunClubData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                failed.invoke();
                return Boolean.FALSE;
            }
        };
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = x02.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FKFanClubResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$getFunClubData$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FKFanClubResult fKFanClubResult) {
                m2606invoke(fKFanClubResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2606invoke(FKFanClubResult fKFanClubResult) {
                FKFanClubResult fKFanClubResult2 = fKFanClubResult;
                FKFanClubManager.this.o(fKFanClubResult2);
                Function1 function12 = success;
                FKFanClubMemberDataModel profile = fKFanClubResult2.getProfile();
                function12.invoke(profile != null ? Integer.valueOf(profile.getStatus()) : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void m(String str, int i10, Integer num, final Function0<p> function0) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            Observable f10 = a.C0826a.f(NetworkClient.f11868a.r(), liveShowModel.getItemId(), str, Integer.valueOf(i10), false, null, 1, null, num, 88, null);
            Object obj = this.f14942a;
            g gVar = obj instanceof g ? (g) obj : null;
            Disposable disposed = f10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SendGiftResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$sendClubGift$lambda$4$$inlined$handleByContext$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SendGiftResult sendGiftResult) {
                    m2607invoke(sendGiftResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2607invoke(SendGiftResult sendGiftResult) {
                    p1.g.f52734a.W1(sendGiftResult.getBalance());
                    Function0 function02 = Function0.this;
                    if (function02 != null) {
                        function02.invoke();
                    }
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    public final void o(@Nullable FKFanClubResult fKFanClubResult) {
        this.f14948g = fKFanClubResult;
    }

    public final void p(final boolean z10, final Function1<? super Boolean, p> function1) {
        User user;
        String userId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (user = liveShowModel.getUser()) == null || (userId = user.userId()) == null) {
            return;
        }
        Observable<Result<AutoLightUpResult>> k02 = NetworkClient.f11868a.r().k0(userId, z10);
        Object obj = this.f14942a;
        g gVar = obj instanceof g ? (g) obj : null;
        Disposable disposed = k02.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AutoLightUpResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$setFanClubLightUp$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AutoLightUpResult autoLightUpResult) {
                m2608invoke(autoLightUpResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2608invoke(AutoLightUpResult autoLightUpResult) {
                FKFanClubTaskFragment fKFanClubTaskFragment;
                FKFanClubResult d12;
                p1.g.f52734a.W1(autoLightUpResult.getBalance());
                FKFanClubResult k10 = FKFanClubManager.this.k();
                FKFanClubMemberDataModel fKFanClubMemberDataModel = null;
                FKFanClubMemberDataModel profile = k10 != null ? k10.getProfile() : null;
                if (profile != null) {
                    profile.setAutoLightUp(z10);
                }
                fKFanClubTaskFragment = FKFanClubManager.this.f14946e;
                if (fKFanClubTaskFragment != null && (d12 = fKFanClubTaskFragment.d1()) != null) {
                    fKFanClubMemberDataModel = d12.getProfile();
                }
                if (fKFanClubMemberDataModel != null) {
                    fKFanClubMemberDataModel.setAutoLightUp(z10);
                }
                Function1 function12 = function1;
                if (function12 != null) {
                    function12.invoke(Boolean.valueOf(z10));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void q() {
        FKFanClubForAnchorFragment.f14965h.a(this.f14943b);
    }

    public final void r() {
        FKFanClubMemberFragment.f14970g.a(this.f14943b);
    }

    public final void s() {
        this.f14946e = FKFanClubTaskFragment.f14973i.a(this.f14943b, new FKFanClubTaskFragment.b() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showFanClubTaskDialog$1
            @Override // com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment.b
            public void a(boolean z10) {
                FKFanClubMemberDataModel profile;
                if (z10) {
                    FKFanClubManager.this.u();
                    return;
                }
                FKFanClubResult k10 = FKFanClubManager.this.k();
                boolean z11 = false;
                if (k10 != null && (profile = k10.getProfile()) != null && profile.getStatus() == FanClubStatus.Expired.getStatus()) {
                    z11 = true;
                }
                FKFanClubManager.w(FKFanClubManager.this, z11, null, 2, null);
            }

            @Override // com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment.b
            public void b() {
                FKFanClubManager.this.r();
            }

            @Override // com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment.b
            public void c(@NotNull String giftId) {
                AtomicInteger atomicInteger;
                s.i(giftId, "giftId");
                FKFanClubManager fKFanClubManager = FKFanClubManager.this;
                atomicInteger = fKFanClubManager.f14944c;
                int incrementAndGet = atomicInteger.incrementAndGet();
                final FKFanClubManager fKFanClubManager2 = FKFanClubManager.this;
                FKFanClubManager.n(fKFanClubManager, giftId, incrementAndGet, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showFanClubTaskDialog$1$sendClubGift$1
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
                        FKFanClubTaskFragment fKFanClubTaskFragment;
                        fKFanClubTaskFragment = FKFanClubManager.this.f14946e;
                        if (fKFanClubTaskFragment != null) {
                            final FKFanClubManager fKFanClubManager3 = FKFanClubManager.this;
                            fKFanClubTaskFragment.e1(new Function1<FKFanClubResult, p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showFanClubTaskDialog$1$sendClubGift$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ p invoke(FKFanClubResult fKFanClubResult) {
                                    invoke2(fKFanClubResult);
                                    return p.f51048a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull FKFanClubResult result) {
                                    s.i(result, "result");
                                    FKFanClubManager.this.o(result);
                                }
                            });
                        }
                    }
                }, 4, null);
            }
        });
    }

    public final void t(final boolean z10, @NotNull final Function0<p> joinedSuccess) {
        s.i(joinedSuccess, "joinedSuccess");
        FKJoinInFanClubFragment.a aVar = FKJoinInFanClubFragment.f14978h;
        FragmentManager fragmentManager = this.f14943b;
        FKFanClubResult fKFanClubResult = this.f14948g;
        this.f14945d = aVar.a(fragmentManager, fKFanClubResult != null ? fKFanClubResult.getClub() : null, new FKJoinInFanClubFragment.b() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showJoinInClubDialog$1
            @Override // com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment.b
            public void a(@NotNull GiftModel model) {
                AtomicInteger atomicInteger;
                s.i(model, "model");
                FKFanClubManager fKFanClubManager = FKFanClubManager.this;
                String itemId = model.getItemId();
                atomicInteger = FKFanClubManager.this.f14944c;
                int incrementAndGet = atomicInteger.incrementAndGet();
                Integer level = model.getLevel();
                final Function0<p> function0 = joinedSuccess;
                final FKFanClubManager fKFanClubManager2 = FKFanClubManager.this;
                final boolean z11 = z10;
                fKFanClubManager.m(itemId, incrementAndGet, level, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showJoinInClubDialog$1$joinInClub$1
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
                        Context context;
                        FKJoinInFanClubFragment fKJoinInFanClubFragment;
                        function0.invoke();
                        h hVar = h.f12779a;
                        context = fKFanClubManager2.f14942a;
                        hVar.c(context, R$string.join_in_success);
                        fKJoinInFanClubFragment = fKFanClubManager2.f14945d;
                        if (fKJoinInFanClubFragment != null) {
                            fKJoinInFanClubFragment.dismiss();
                        }
                        fKFanClubManager2.s();
                        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                        if (liveShowModel != null) {
                            GroupLiveLog.f18698a.b(true, liveShowModel.getUser().userId(), z11);
                        }
                    }
                });
            }

            @Override // com.cupidapp.live.liveshow.fanclub.fragment.FKJoinInFanClubFragment.b
            public void b() {
                FKFanClubManager.this.r();
            }
        });
    }

    public final void u() {
        this.f14947f = FKFanClubAutoLightUpFragment.f14961h.a(this.f14943b, this.f14948g, new FKFanClubAutoLightUpFragment.b() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpDialog$1
            @Override // com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubAutoLightUpFragment.b
            public void a(boolean z10) {
                FKFanClubMemberDataModel profile;
                boolean z11 = false;
                if (z10) {
                    FKFanClubResult k10 = FKFanClubManager.this.k();
                    if (k10 != null && (profile = k10.getProfile()) != null && profile.getStatus() == FanClubStatus.Expired.getStatus()) {
                        z11 = true;
                    }
                    final FKFanClubManager fKFanClubManager = FKFanClubManager.this;
                    fKFanClubManager.v(z11, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpDialog$1$lightUp$1
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
                            FKFanClubAutoLightUpFragment fKFanClubAutoLightUpFragment;
                            FKFanClubAutoLightUpFragment fKFanClubAutoLightUpFragment2;
                            fKFanClubAutoLightUpFragment = FKFanClubManager.this.f14947f;
                            if (fKFanClubAutoLightUpFragment != null) {
                                fKFanClubAutoLightUpFragment.d1(true);
                            }
                            fKFanClubAutoLightUpFragment2 = FKFanClubManager.this.f14947f;
                            if (fKFanClubAutoLightUpFragment2 != null) {
                                fKFanClubAutoLightUpFragment2.a1(true);
                            }
                        }
                    });
                    return;
                }
                final FKFanClubManager fKFanClubManager2 = FKFanClubManager.this;
                fKFanClubManager2.p(false, new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpDialog$1$lightUp$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return p.f51048a;
                    }

                    public final void invoke(boolean z12) {
                        Context context;
                        FKFanClubAutoLightUpFragment fKFanClubAutoLightUpFragment;
                        h hVar = h.f12779a;
                        context = FKFanClubManager.this.f14942a;
                        hVar.c(context, R$string.close_this_service_prompt);
                        fKFanClubAutoLightUpFragment = FKFanClubManager.this.f14947f;
                        if (fKFanClubAutoLightUpFragment != null) {
                            fKFanClubAutoLightUpFragment.a1(false);
                        }
                    }
                });
            }
        });
    }

    public final void v(final boolean z10, final Function0<p> function0) {
        Context context = this.f14942a;
        if (context != null) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.light_up_automatically_title), z10 ? R$string.expired_description : R$string.light_up_automatically_description, 0, 2, null), z10 ? R$string.turn_on : 2131886528, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpPrompt$1$1
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
                    final FKFanClubManager fKFanClubManager = FKFanClubManager.this;
                    final boolean z11 = z10;
                    final Function0<p> function02 = function0;
                    fKFanClubManager.p(true, new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpPrompt$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return p.f51048a;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                        
                            r3 = r2.f14946e;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void invoke(boolean r3) {
                            /*
                                r2 = this;
                                boolean r3 = r1
                                if (r3 == 0) goto L16
                                com.cupidapp.live.liveshow.fanclub.FKFanClubManager r3 = r2
                                com.cupidapp.live.liveshow.fanclub.fragment.FKFanClubTaskFragment r3 = com.cupidapp.live.liveshow.fanclub.FKFanClubManager.b(r3)
                                if (r3 == 0) goto L16
                                com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpPrompt$1$1$1$1 r0 = new com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpPrompt$1$1$1$1
                                com.cupidapp.live.liveshow.fanclub.FKFanClubManager r1 = r2
                                r0.<init>()
                                r3.e1(r0)
                            L16:
                                kotlin.jvm.functions.Function0<kotlin.p> r3 = r3
                                if (r3 == 0) goto L1d
                                r3.invoke()
                            L1d:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.fanclub.FKFanClubManager$showLightUpPrompt$1$1.AnonymousClass1.invoke(boolean):void");
                        }
                    });
                }
            }, 2, null), 0, null, 3, null), null, 1, null);
        }
    }
}

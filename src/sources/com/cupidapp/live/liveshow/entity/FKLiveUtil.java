package com.cupidapp.live.liveshow.entity;

import android.view.View;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.beauty.zegocapture.FKLiveVideoCaptureFactory;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.j;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.FollowLiveStatusLayout;
import com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment;
import com.cupidapp.live.liveshow.view.music.ZGPlayerState;
import com.cupidapp.live.profile.model.User;
import com.zego.zegoavkit2.ZegoExternalVideoCapture;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FKLiveUtil f14913a = new FKLiveUtil();

    public static /* synthetic */ void D(FKLiveUtil fKLiveUtil, String str, View view, c cVar, e eVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = null;
        }
        if ((i10 & 8) != 0) {
            eVar = null;
        }
        fKLiveUtil.C(str, view, cVar, eVar);
    }

    public static /* synthetic */ void J(FKLiveUtil fKLiveUtil, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        fKLiveUtil.I(str, z10);
    }

    public static /* synthetic */ void k(FKLiveUtil fKLiveUtil, c cVar, String str, View view, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        fKLiveUtil.j(cVar, str, view, z10);
    }

    public static /* synthetic */ void o(FKLiveUtil fKLiveUtil, boolean z10, FKLiveForViewerViewModel fKLiveForViewerViewModel, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            fKLiveForViewerViewModel = null;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        fKLiveUtil.n(z10, fKLiveForViewerViewModel, z11);
    }

    public final void A(@NotNull String streamId, boolean z10, @Nullable View view, boolean z11, @Nullable d dVar, @Nullable e eVar) {
        s.i(streamId, "streamId");
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.h(z10);
            c4.J(dVar);
            c4.B(new ZegoAvConfig(0));
            c4.H(1);
            c4.y();
            c4.P(view);
            c4.Q(streamId, "", 0);
            c4.z(true);
            c4.G(false);
            c4.A(true);
            c4.g(z11);
            if (eVar != null) {
                c4.K(eVar);
                c4.R();
            }
        }
    }

    public final void B(@NotNull String path) {
        s.i(path, "path");
        FKLiveMusicFragment.a aVar = FKLiveMusicFragment.f15772i;
        if (aVar.c() == ZGPlayerState.ZGPlayerStatePlaying || aVar.c() == ZGPlayerState.ZGPlayerStatePaused) {
            H();
        }
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            j.N(c4, path, false, 2, null);
        }
    }

    public final void C(@NotNull String streamId, @Nullable View view, @Nullable c cVar, @Nullable e eVar) {
        s.i(streamId, "streamId");
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            if (cVar != null) {
                c4.F(cVar);
            }
            c4.O(streamId, view);
            c4.D(1, streamId);
            if (eVar != null) {
                c4.K(eVar);
                c4.R();
            }
        }
    }

    public final void E(@NotNull final d publisherCallback, @NotNull final View view) {
        s.i(publisherCallback, "publisherCallback");
        s.i(view, "view");
        final LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null) {
            return;
        }
        j.f14922f.b(new Function2<Boolean, Boolean, p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveUtil$startPublishing$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10, boolean z11) {
                j c4 = j.a.c(j.f14922f, null, 1, null);
                if (c4 != null) {
                    d dVar = d.this;
                    View view2 = view;
                    LiveShowModel liveShowModel2 = liveShowModel;
                    c4.J(dVar);
                    c4.P(view2);
                    c4.Q(liveShowModel2.getStreamId(), "", 2);
                }
                r2.i.f53231b.G(true);
            }
        });
    }

    public final void F() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.W();
            c4.V();
            c4.J(null);
            c4.X();
        }
    }

    public final void G(@NotNull List<String> keepStreamIdList) {
        s.i(keepStreamIdList, "keepStreamIdList");
        List<String> c4 = c();
        if (c4 != null) {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.addAll(c4);
            arrayList.removeAll(keepStreamIdList);
            for (String str : arrayList) {
                j c10 = j.a.c(j.f14922f, null, 1, null);
                if (c10 != null) {
                    c10.T(str);
                }
            }
        }
    }

    public final void H() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.S();
        }
    }

    public final void I(@Nullable String str, boolean z10) {
        j c4;
        if ((str == null || str.length() == 0) || (c4 = j.a.c(j.f14922f, null, 1, null)) == null) {
            return;
        }
        c4.T(str);
        if (z10) {
            c4.X();
        }
    }

    public final void K() {
        j.f14922f.b(new Function2<Boolean, Boolean, p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveUtil$stopPublishing$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10, boolean z11) {
                r2.i.f53231b.G(false);
                j.a aVar = j.f14922f;
                j c4 = j.a.c(aVar, null, 1, null);
                if (c4 != null) {
                    c4.W();
                }
                j c10 = j.a.c(aVar, null, 1, null);
                if (c10 != null) {
                    c10.V();
                }
                j c11 = j.a.c(aVar, null, 1, null);
                if (c11 != null) {
                    c11.J(null);
                }
            }
        });
    }

    public final void L() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.b0();
        }
    }

    public final void M(@Nullable String str, @NotNull View view) {
        j c4;
        s.i(view, "view");
        if ((str == null || str.length() == 0) || (c4 = j.a.c(j.f14922f, null, 1, null)) == null) {
            return;
        }
        c4.c0(str, view);
    }

    public final void a(boolean z10) {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.g(z10);
        }
    }

    @Nullable
    public final String b() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            return c4.j();
        }
        return null;
    }

    @Nullable
    public final List<String> c() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            return c4.k();
        }
        return null;
    }

    public final void d() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.n();
        }
    }

    public final void e(FKLiveForViewerViewModel fKLiveForViewerViewModel, boolean z10) {
        LiveInRoomSensorModel liveRoomSensor;
        LiveInRoomSensorModel liveRoomSensor2;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel != null && fKLiveConstantsData.getLiveShowViewDuration() != null) {
            SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
            String itemId = liveShowModel.getItemId();
            String userId = liveShowModel.getUser().userId();
            Boolean valueOf = Boolean.valueOf(liveShowModel.getUser().getAloha());
            Long liveShowViewDuration = fKLiveConstantsData.getLiveShowViewDuration();
            s.f(liveShowViewDuration);
            sensorsLogLiveShow.d(itemId, userId, valueOf, (int) liveShowViewDuration.longValue(), (fKLiveForViewerViewModel == null || (liveRoomSensor2 = fKLiveForViewerViewModel.getLiveRoomSensor()) == null) ? null : liveRoomSensor2.getScene(), fKLiveConstantsData.getFkLiveStrategyId(), (fKLiveForViewerViewModel == null || (liveRoomSensor = fKLiveForViewerViewModel.getLiveRoomSensor()) == null) ? null : liveRoomSensor.getEnterSource(), fKLiveConstantsData.getFkLiveType(), Boolean.valueOf(z10));
            fKLiveConstantsData.leaveRoomResetData();
            Disposable disposed = NetworkClient.f11868a.r().b(liveShowModel.getItemId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveUtil$leaveRoom$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
        FollowLiveStatusLayout.f15289g.k();
    }

    public final void f(String str) {
        j.f14922f.e(str);
    }

    public final void g() {
        User X = p1.g.f52734a.X();
        f(X != null ? X.userId() : null);
    }

    public final void h() {
        p1.g gVar = p1.g.f52734a;
        User X = gVar.X();
        String userId = X != null ? X.userId() : null;
        f(userId + gVar.g());
    }

    public final void i(@NotNull d publisherCallback, @NotNull View view) {
        s.i(publisherCallback, "publisherCallback");
        s.i(view, "view");
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        aVar.a("ZGEntityLog", "startPublishing liveShowModel: $" + ((Object) fKLiveConstantsData.getLiveShowModel()) + " ");
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null) {
            return;
        }
        j.f14922f.b(new FKLiveUtil$loginAndStartPublishing$1(publisherCallback, liveShowModel, view));
    }

    public final void j(@Nullable final c cVar, @Nullable final String str, @NotNull final View view, final boolean z10) {
        User user;
        s.i(view, "view");
        if (str == null) {
            return;
        }
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        aVar.a("ZGEntityLog", "loginRoomAndStartPlayStream itemId:" + str + "   getLiveShowModel  name:" + ((liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.getName()));
        j.f14922f.b(new Function2<Boolean, Boolean, p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveUtil$loginRoomAndStartPlayStream$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z11, boolean z12) {
                com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "loginRoomAndStartPlayStream  isFirst:" + z12);
                if (z12) {
                    j c4 = j.a.c(j.f14922f, null, 1, null);
                    if (c4 != null) {
                        j.q(c4, String.this, 2, null, 4, null);
                    }
                } else {
                    j.a aVar2 = j.f14922f;
                    j c10 = j.a.c(aVar2, null, 1, null);
                    if (c10 != null) {
                        c10.U();
                    }
                    j c11 = j.a.c(aVar2, null, 1, null);
                    if (c11 != null) {
                        j.Z(c11, String.this, 2, null, 4, null);
                    }
                }
                LiveShowModel liveShowModel2 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel2 != null) {
                    FKLiveUtil.D(FKLiveUtil.f14913a, liveShowModel2.getStreamId(), view, cVar, null, 8, null);
                }
                FKLiveUtil.f14913a.s(z10);
            }
        });
    }

    public final void l() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.t();
        }
    }

    public final void m() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.u();
        }
    }

    public final void n(boolean z10, @Nullable FKLiveForViewerViewModel fKLiveForViewerViewModel, boolean z11) {
        m();
        if (z11) {
            FKLiveGrpcEntity.f14907e.a().v();
        }
        if (z10) {
            e(fKLiveForViewerViewModel, true);
        }
    }

    public final void p() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.w();
        }
    }

    public final void q() {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.x();
        }
    }

    public final void r(boolean z10) {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.A(z10);
        }
    }

    public final void s(boolean z10) {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.i(z10);
        }
    }

    public final void t(int i10) {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.B(new ZegoAvConfig(i10));
        }
    }

    public final void u(@NotNull ZGPlayerState state) {
        s.i(state, "state");
        FKLiveMusicFragment.f15772i.e(state);
    }

    public final void v(@NotNull View view) {
        s.i(view, "view");
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.C(view);
        }
    }

    public final void w(boolean z10, @NotNull String streamId) {
        s.i(streamId, "streamId");
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.E(z10 ? 0 : 100, streamId);
        }
    }

    public final void x(long j10) {
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.I(j10);
        }
    }

    public final void y() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        FKLiveVideoCaptureFactory fKLiveVideoCaptureFactory = new FKLiveVideoCaptureFactory();
        fKLiveConstantsData.setFkLiveVideoCaptureImage(fKLiveVideoCaptureFactory.create(""));
        fKLiveConstantsData.setFkLiveFKLiveVideoCaptureFactory(fKLiveVideoCaptureFactory);
        ZegoExternalVideoCapture.setVideoCaptureFactory(fKLiveConstantsData.getFkLiveFKLiveVideoCaptureFactory(), 0);
    }

    public final void z(@NotNull b callback) {
        s.i(callback, "callback");
        j c4 = j.a.c(j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.L(callback);
        }
    }
}

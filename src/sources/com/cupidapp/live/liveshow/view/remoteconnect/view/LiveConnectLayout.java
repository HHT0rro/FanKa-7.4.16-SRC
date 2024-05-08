package com.cupidapp.live.liveshow.view.remoteconnect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.entity.e;
import com.cupidapp.live.liveshow.model.LiveConnectType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelInfo;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.x;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: LiveConnectLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectLayout extends BaseLayout implements com.cupidapp.live.liveshow.view.remoteconnect.view.a {

    /* renamed from: d */
    @Nullable
    public com.cupidapp.live.liveshow.view.remoteconnect.view.b f15872d;

    /* renamed from: e */
    public boolean f15873e;

    /* renamed from: f */
    public boolean f15874f;

    /* renamed from: g */
    public boolean f15875g;

    /* renamed from: h */
    public boolean f15876h;

    /* renamed from: i */
    public long f15877i;

    /* renamed from: j */
    @NotNull
    public final Lazy f15878j;

    /* renamed from: k */
    public boolean f15879k;

    /* renamed from: l */
    @NotNull
    public final c f15880l;

    /* renamed from: m */
    @NotNull
    public final a f15881m;

    /* renamed from: n */
    @NotNull
    public final b f15882n;

    /* renamed from: o */
    @NotNull
    public Map<Integer, View> f15883o;

    /* compiled from: LiveConnectLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends com.cupidapp.live.liveshow.entity.c {
        public a() {
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i10, @Nullable String str) {
            super.onPlayStateUpdate(i10, str);
            if (!LiveConnectLayout.this.f15873e) {
                LiveConnectLayout.this.s(str, i10 == 0);
            } else if (i10 != 0) {
                LiveConnectLayout.this.z();
            }
        }
    }

    /* compiled from: LiveConnectLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends com.cupidapp.live.liveshow.entity.d {
        public b() {
        }

        @Override // com.cupidapp.live.liveshow.entity.d, com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
        public void onPublishStateUpdate(int i10, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
            super.onPublishStateUpdate(i10, str, hashMap);
            if (i10 == 0) {
                LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
                if (s.d(str, remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null)) {
                    if (LiveConnectLayout.this.f15879k) {
                        return;
                    }
                    LiveConnectLayout.this.f15879k = true;
                    com.cupidapp.live.liveshow.view.remoteconnect.view.b bVar = LiveConnectLayout.this.f15872d;
                    if (bVar != null) {
                        bVar.b();
                    }
                    LiveConnectLayout.this.t();
                    return;
                }
            }
            LiveConnectLayout.this.z();
        }
    }

    /* compiled from: LiveConnectLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends e {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.entity.e, com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback
        public void onCaptureSoundLevelUpdate(@Nullable ZegoSoundLevelInfo zegoSoundLevelInfo) {
            LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
            if (LiveConnectLayout.this.f15873e && LiveConnectLayout.this.v()) {
                super.onCaptureSoundLevelUpdate(zegoSoundLevelInfo);
                if (zegoSoundLevelInfo != null) {
                    if (s.d(zegoSoundLevelInfo.streamID, remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null)) {
                        LiveConnectLayout.this.F(zegoSoundLevelInfo);
                    }
                }
            }
        }

        @Override // com.cupidapp.live.liveshow.entity.e, com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback
        public void onSoundLevelUpdate(@Nullable ZegoSoundLevelInfo[] zegoSoundLevelInfoArr) {
            LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
            ZegoSoundLevelInfo zegoSoundLevelInfo = null;
            if (zegoSoundLevelInfoArr != null) {
                int i10 = 0;
                int length = zegoSoundLevelInfoArr.length;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    ZegoSoundLevelInfo zegoSoundLevelInfo2 = zegoSoundLevelInfoArr[i10];
                    if (s.d(zegoSoundLevelInfo2.streamID, remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null)) {
                        zegoSoundLevelInfo = zegoSoundLevelInfo2;
                        break;
                    }
                    i10++;
                }
            }
            if (zegoSoundLevelInfo != null) {
                super.onSoundLevelUpdate(zegoSoundLevelInfoArr);
                LiveConnectLayout.this.F(zegoSoundLevelInfo);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15883o = new LinkedHashMap();
        this.f15875g = true;
        this.f15878j = kotlin.c.b(LiveConnectLayout$connectPlayTimer$2.INSTANCE);
        this.f15880l = new c();
        this.f15881m = new a();
        this.f15882n = new b();
        u();
    }

    private final i getConnectPlayTimer() {
        return (i) this.f15878j.getValue();
    }

    public static /* synthetic */ void x(LiveConnectLayout liveConnectLayout, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        if ((i10 & 4) != 0) {
            z12 = false;
        }
        liveConnectLayout.w(z10, z11, z12);
    }

    public final void A() {
        User user;
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f15877i;
        long j11 = currentTimeMillis - j10;
        if (j10 == 0 || j11 <= 0) {
            return;
        }
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (remoteConnectLiveShow != null && remoteConnectLiveShow.isStreamer()) {
            GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
            String str = null;
            String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
            if (liveShowModel != null && (user = liveShowModel.getUser()) != null) {
                str = user.userId();
            }
            groupLiveLog.x(itemId, str, (int) (j11 / 1000), remoteConnectLiveShow.getLiveConnectType());
        }
    }

    public final void B() {
        User user;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (remoteConnectLiveShow != null && remoteConnectLiveShow.isStreamer()) {
            this.f15877i = System.currentTimeMillis();
            GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
            String str = null;
            String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
            if (liveShowModel != null && (user = liveShowModel.getUser()) != null) {
                str = user.userId();
            }
            groupLiveLog.z(itemId, str, remoteConnectLiveShow.getLiveConnectType());
        }
    }

    public final void C() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.confirm_to_close_live_connect, 0, 2, null), R$string.liveshow_finish_confirm, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$showCloseConnectDialog$1
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
                LiveConnectLayout.this.r();
            }
        }, 2, null), R$string.continue_live_connect, null, 2, null), null, 1, null);
    }

    public final void D() {
        ArrayList arrayList = new ArrayList();
        FKActionSheetItemModel fKActionSheetItemModel = new FKActionSheetItemModel(R$string.flip_camera, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$showMenuDialog$changeCamera$1
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
                boolean z10;
                boolean z11;
                LiveConnectLayout liveConnectLayout = LiveConnectLayout.this;
                z10 = liveConnectLayout.f15875g;
                liveConnectLayout.f15875g = !z10;
                FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
                z11 = LiveConnectLayout.this.f15875g;
                fKLiveUtil.a(z11);
            }
        }, 30, null);
        FKActionSheetItemModel fKActionSheetItemModel2 = new FKActionSheetItemModel(R$string.end_connect, ActionSheetItemType.Warning, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$showMenuDialog$endConnect$1
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
                LiveConnectLayout.this.C();
            }
        }, 28, null);
        if (!this.f15874f) {
            arrayList.add(fKActionSheetItemModel);
        }
        arrayList.add(fKActionSheetItemModel2);
        FKActionSheetDialog.f12692f.a(getContext()).f(arrayList).h();
    }

    public final void E() {
        User user;
        LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
        if (remoteConnectLiveShow == null || (user = remoteConnectLiveShow.getUser()) == null) {
            return;
        }
        EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), SensorsLogMatch.AlohaGetPosition.Connection, null, false, false, false, 60, null));
    }

    public final void F(ZegoSoundLevelInfo zegoSoundLevelInfo) {
        if (zegoSoundLevelInfo.soundLevel <= 10.0f || zegoSoundLevelInfo.vad != 1) {
            return;
        }
        ((LiveVoiceConnectLayout) e(R$id.voice_connect_layout)).i();
    }

    public final void G(@NotNull final String streamId) {
        s.i(streamId, "streamId");
        i.d(getConnectPlayTimer(), 20, 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$startConnectPlayTimer$1
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
                LiveConnectLayout.this.s(streamId, false);
            }
        }, null, 8, null);
    }

    public final void I() {
        if (v()) {
            FKLiveUtil.f14913a.F();
        }
    }

    @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.a
    public void b() {
        C();
    }

    @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.a
    public void c() {
        if (v()) {
            D();
        } else {
            E();
        }
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15883o;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void r() {
        String itemId;
        LiveShowModel remoteConnectLiveShow;
        String itemId2;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || (remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow()) == null || (itemId2 = remoteConnectLiveShow.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().G(itemId, itemId2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$closeLiveConnect$$inlined$handle$default$1
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
                LiveConnectLayout.this.y();
                b bVar = LiveConnectLayout.this.f15872d;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void s(String str, boolean z10) {
        User user;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
        if (str != null) {
            if (s.d(remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null, str)) {
                if (z10) {
                    getConnectPlayTimer().g();
                    com.cupidapp.live.liveshow.view.remoteconnect.view.b bVar = this.f15872d;
                    if (bVar != null) {
                        bVar.d();
                    }
                } else {
                    getConnectPlayTimer().g();
                    z();
                    com.cupidapp.live.liveshow.view.remoteconnect.view.b bVar2 = this.f15872d;
                    if (bVar2 != null) {
                        bVar2.e();
                    }
                }
                Disposable disposed = NetworkClient.f11868a.r().J0(liveShowModel != null ? liveShowModel.getItemId() : null, z10, (liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.userId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$connectPlaySuccess$$inlined$handle$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    H(disposed);
                }
                s.h(disposed, "disposed");
            }
        }
    }

    public final void setConnectListener(@NotNull com.cupidapp.live.liveshow.view.remoteconnect.view.b connectListener) {
        s.i(connectListener, "connectListener");
        this.f15872d = connectListener;
    }

    public final void t() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
        Disposable disposed = NetworkClient.f11868a.r().a(liveShowModel != null ? liveShowModel.getItemId() : null, remoteConnectLiveShow != null ? remoteConnectLiveShow.getItemId() : null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$connectStreamPublishSuccess$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void u() {
        z.a(this, R$layout.layout_live_connect, true);
        setVisibility(8);
        ((FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout)).setConnectListener(this);
        ((LiveVoiceConnectLayout) e(R$id.voice_connect_layout)).setConnectListener(this);
    }

    public final boolean v() {
        LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
        if (remoteConnectLiveShow != null) {
            return remoteConnectLiveShow.isRemoteConnect();
        }
        return false;
    }

    public final void w(boolean z10, boolean z11, boolean z12) {
        this.f15873e = z10;
        LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
        if (remoteConnectLiveShow == null) {
            setVisibility(8);
            return;
        }
        boolean z13 = false;
        setVisibility(0);
        this.f15874f = LiveConnectType.Companion.a(remoteConnectLiveShow.getLiveConnectType());
        this.f15876h = z12;
        com.cupidapp.live.liveshow.view.remoteconnect.view.b bVar = this.f15872d;
        if (bVar != null) {
            bVar.c(true);
        }
        if (v()) {
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            String streamId = remoteConnectLiveShow.getStreamId();
            boolean z14 = this.f15874f;
            fKLiveUtil.A(streamId, !z14, z14 ? null : ((FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout)).getTextureView(), this.f15875g, this.f15882n, this.f15874f ? this.f15880l : null);
            FKLiveGrpcEntity.f14907e.a().l(remoteConnectLiveShow.getItemId(), false);
        } else {
            FKLiveUtil fKLiveUtil2 = FKLiveUtil.f14913a;
            List<String> c4 = fKLiveUtil2.c();
            if (c4 != null && c4.contains(remoteConnectLiveShow.getStreamId())) {
                z13 = true;
            }
            if (z13) {
                fKLiveUtil2.M(remoteConnectLiveShow.getStreamId(), ((FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout)).getTextureView());
            } else {
                fKLiveUtil2.C(remoteConnectLiveShow.getStreamId(), ((FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout)).getTextureView(), this.f15881m, this.f15874f ? this.f15880l : null);
            }
        }
        if (this.f15874f) {
            ((LiveVoiceConnectLayout) e(R$id.voice_connect_layout)).g(remoteConnectLiveShow, v());
            FKLiveRemoteConnectUserLayout video_connect_layout = (FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout);
            s.h(video_connect_layout, "video_connect_layout");
            video_connect_layout.setVisibility(8);
        } else {
            ((FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout)).h(remoteConnectLiveShow, z11, v());
            LiveVoiceConnectLayout voice_connect_layout = (LiveVoiceConnectLayout) e(R$id.voice_connect_layout);
            s.h(voice_connect_layout, "voice_connect_layout");
            voice_connect_layout.setVisibility(8);
        }
        if (z12) {
            B();
        }
    }

    public final void y() {
        List<LiveShowModel> connectLive;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        final LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
        if (v()) {
            FKLiveUtil.f14913a.F();
            FKLiveGrpcEntity.f14907e.a().l(liveShowModel != null ? liveShowModel.getItemId() : null, true);
        } else {
            FKLiveUtil.f14913a.I(remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null, true);
        }
        A();
        if (liveShowModel != null && (connectLive = liveShowModel.getConnectLive()) != null) {
            x.B(connectLive, new Function1<LiveShowModel, Boolean>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$notifyRemoteConnectEnd$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull LiveShowModel it) {
                    s.i(it, "it");
                    String itemId = it.getItemId();
                    LiveShowModel liveShowModel2 = LiveShowModel.this;
                    return Boolean.valueOf(s.d(itemId, liveShowModel2 != null ? liveShowModel2.getItemId() : null));
                }
            });
        }
        if (this.f15874f) {
            int i10 = R$id.voice_connect_layout;
            ((LiveVoiceConnectLayout) e(i10)).j();
            LiveVoiceConnectLayout voice_connect_layout = (LiveVoiceConnectLayout) e(i10);
            s.h(voice_connect_layout, "voice_connect_layout");
            voice_connect_layout.setVisibility(8);
        } else {
            FKLiveRemoteConnectUserLayout video_connect_layout = (FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout);
            s.h(video_connect_layout, "video_connect_layout");
            video_connect_layout.setVisibility(8);
        }
        setVisibility(8);
        com.cupidapp.live.liveshow.view.remoteconnect.view.b bVar = this.f15872d;
        if (bVar != null) {
            bVar.c(false);
        }
        this.f15879k = false;
    }

    public final void z() {
        List<LiveShowModel> connectLive;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        final LiveShowModel remoteConnectLiveShow = fKLiveConstantsData.getRemoteConnectLiveShow();
        if (v()) {
            FKLiveUtil.f14913a.F();
        } else {
            FKLiveUtil.f14913a.I(remoteConnectLiveShow != null ? remoteConnectLiveShow.getStreamId() : null, true);
        }
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel != null && (connectLive = liveShowModel.getConnectLive()) != null) {
            x.B(connectLive, new Function1<LiveShowModel, Boolean>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout$notifyRemoteConnectTimeOut$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull LiveShowModel it) {
                    s.i(it, "it");
                    String itemId = it.getItemId();
                    LiveShowModel liveShowModel2 = LiveShowModel.this;
                    return Boolean.valueOf(s.d(itemId, liveShowModel2 != null ? liveShowModel2.getItemId() : null));
                }
            });
        }
        if (this.f15874f) {
            int i10 = R$id.voice_connect_layout;
            ((LiveVoiceConnectLayout) e(i10)).j();
            LiveVoiceConnectLayout voice_connect_layout = (LiveVoiceConnectLayout) e(i10);
            s.h(voice_connect_layout, "voice_connect_layout");
            voice_connect_layout.setVisibility(8);
        } else {
            FKLiveRemoteConnectUserLayout video_connect_layout = (FKLiveRemoteConnectUserLayout) e(R$id.video_connect_layout);
            s.h(video_connect_layout, "video_connect_layout");
            video_connect_layout.setVisibility(8);
        }
        setVisibility(8);
        com.cupidapp.live.liveshow.view.remoteconnect.view.b bVar = this.f15872d;
        if (bVar != null) {
            bVar.c(false);
        }
        this.f15879k = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15883o = new LinkedHashMap();
        this.f15875g = true;
        this.f15878j = kotlin.c.b(LiveConnectLayout$connectPlayTimer$2.INSTANCE);
        this.f15880l = new c();
        this.f15881m = new a();
        this.f15882n = new b();
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15883o = new LinkedHashMap();
        this.f15875g = true;
        this.f15878j = kotlin.c.b(LiveConnectLayout$connectPlayTimer$2.INSTANCE);
        this.f15880l = new c();
        this.f15881m = new a();
        this.f15882n = new b();
        u();
    }
}

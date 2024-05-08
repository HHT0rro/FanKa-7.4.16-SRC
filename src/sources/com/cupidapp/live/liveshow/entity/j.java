package com.cupidapp.live.liveshow.entity;

import android.app.Application;
import android.view.View;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.profile.model.User;
import com.zego.zegoavkit2.ZegoMediaPlayer;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelMonitor;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLogHookCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class j {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f14922f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static ZGSdkState f14923g = ZGSdkState.WaitInitState;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static j f14924h;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public ZegoLiveRoom f14925a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public List<String> f14926b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f14927c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14928d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public ZegoMediaPlayer f14929e;

    /* compiled from: FKLiveEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* compiled from: FKLiveEntity.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.liveshow.entity.j$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0158a implements ZegoLiveRoom.SDKContextEx {
            @Override // com.zego.zegoliveroom.ZegoLiveRoom.SDKContext
            @NotNull
            public Application getAppContext() {
                return AppApplication.f11612d.h();
            }

            @Override // com.zego.zegoliveroom.ZegoLiveRoom.SDKContextEx
            public long getLogFileSize() {
                return 10485760L;
            }

            @Override // com.zego.zegoliveroom.ZegoLiveRoom.SDKContextEx
            @Nullable
            public IZegoLogHookCallback getLogHookCallback() {
                return null;
            }

            @Override // com.zego.zegoliveroom.ZegoLiveRoom.SDKContext
            @Nullable
            public String getLogPath() {
                return null;
            }

            @Override // com.zego.zegoliveroom.ZegoLiveRoom.SDKContext
            @Nullable
            public String getSoFullPath() {
                return null;
            }

            @Override // com.zego.zegoliveroom.ZegoLiveRoom.SDKContextEx
            @Nullable
            public String getSubLogFolder() {
                return null;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ j c(a aVar, Function2 function2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                function2 = null;
            }
            return aVar.b(function2);
        }

        public final boolean a() {
            return FKLiveConstantsData.INSTANCE.getLiveShowModel() == null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.cupidapp.live.liveshow.entity.j b(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.p> r6) {
            /*
                r5 = this;
                boolean r0 = r5.a()
                r1 = 0
                if (r0 == 0) goto L8
                return r1
            L8:
                com.cupidapp.live.liveshow.entity.j r0 = com.cupidapp.live.liveshow.entity.j.d()
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L3d
                com.cupidapp.live.liveshow.entity.j r0 = com.cupidapp.live.liveshow.entity.j.d()
                if (r0 == 0) goto L1e
                boolean r0 = com.cupidapp.live.liveshow.entity.j.e(r0)
                if (r0 != 0) goto L1e
                r0 = 1
                goto L1f
            L1e:
                r0 = 0
            L1f:
                if (r0 == 0) goto L22
                goto L3d
            L22:
                if (r6 == 0) goto L4e
                com.cupidapp.live.liveshow.entity.j r0 = com.cupidapp.live.liveshow.entity.j.d()
                if (r0 == 0) goto L32
                boolean r0 = com.cupidapp.live.liveshow.entity.j.e(r0)
                if (r0 != r2) goto L32
                r0 = 1
                goto L33
            L32:
                r0 = 0
            L33:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                java.lang.Boolean r4 = java.lang.Boolean.FALSE
                r6.mo1743invoke(r0, r4)
                goto L4e
            L3d:
                com.cupidapp.live.liveshow.entity.j r0 = new com.cupidapp.live.liveshow.entity.j
                r0.<init>()
                com.cupidapp.live.liveshow.entity.j.f(r0)
                com.cupidapp.live.liveshow.entity.j r0 = com.cupidapp.live.liveshow.entity.j.d()
                if (r0 == 0) goto L4e
                r0.l(r6)
            L4e:
                com.cupidapp.live.liveshow.entity.j r6 = com.cupidapp.live.liveshow.entity.j.d()
                if (r6 == 0) goto L5b
                boolean r6 = com.cupidapp.live.liveshow.entity.j.e(r6)
                if (r6 != r2) goto L5b
                goto L5c
            L5b:
                r2 = 0
            L5c:
                if (r2 == 0) goto L62
                com.cupidapp.live.liveshow.entity.j r1 = com.cupidapp.live.liveshow.entity.j.d()
            L62:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.entity.j.a.b(kotlin.jvm.functions.Function2):com.cupidapp.live.liveshow.entity.j");
        }

        public final void d() {
            ZegoLiveRoom.setSDKContext(new C0158a());
        }

        public final void e(@Nullable String str) {
            if (!(str == null || str.length() == 0)) {
                p1.g gVar = p1.g.f52734a;
                User X = gVar.X();
                String name = X != null ? X.getName() : null;
                if (!(name == null || name.length() == 0)) {
                    User X2 = gVar.X();
                    ZegoLiveRoom.setUser(str, X2 != null ? X2.getName() : null);
                    return;
                }
            }
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "ZegoLiveRoom setUser userID or userName is null or empty");
        }
    }

    public static /* synthetic */ void N(j jVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        jVar.M(str, z10);
    }

    public static /* synthetic */ Boolean Z(j jVar, String str, int i10, IZegoLoginCompletionCallback iZegoLoginCompletionCallback, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            iZegoLoginCompletionCallback = null;
        }
        return jVar.Y(str, i10, iZegoLoginCompletionCallback);
    }

    public static final void a0(IZegoLoginCompletionCallback iZegoLoginCompletionCallback, int i10, ZegoStreamInfo[] zegoStreamInfoArr) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "切换房间  i:" + i10 + "  zegoStreamInfos:" + ((Object) zegoStreamInfoArr));
        if (iZegoLoginCompletionCallback != null) {
            iZegoLoginCompletionCallback.onLoginCompletion(i10, zegoStreamInfoArr);
        }
    }

    public static final void m(j this$0, Function2 function2, int i10) {
        s.i(this$0, "this$0");
        if (i10 == 0) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "sdk已初始化完成  ZGSdkState.InitSuccessState");
            f14923g = ZGSdkState.InitSuccessState;
        } else {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "sdk已初始化失败  ZGSdkState.InitFailureState");
            f14923g = ZGSdkState.InitFailureState;
            this$0.w();
        }
        if (function2 != null) {
            function2.mo1743invoke(Boolean.valueOf(i10 == 0), Boolean.TRUE);
        }
    }

    public static /* synthetic */ Boolean q(j jVar, String str, int i10, IZegoLoginCompletionCallback iZegoLoginCompletionCallback, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            iZegoLoginCompletionCallback = null;
        }
        return jVar.p(str, i10, iZegoLoginCompletionCallback);
    }

    public static final void r(IZegoLoginCompletionCallback iZegoLoginCompletionCallback, int i10, ZegoStreamInfo[] zegoStreamInfoArr) {
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "登陆房间  i:" + i10 + "  zegoStreamInfos:" + ((Object) zegoStreamInfoArr));
        if (iZegoLoginCompletionCallback != null) {
            iZegoLoginCompletionCallback.onLoginCompletion(i10, zegoStreamInfoArr);
        }
    }

    public final void A(boolean z10) {
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.enableCaptureMirror(z10);
        }
    }

    public final void B(@NotNull ZegoAvConfig config) {
        s.i(config, "config");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置推流配置失败: 请先初始化sdk");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置推流配置");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setAVConfig(config);
        }
    }

    public final void C(@NotNull View view) {
        s.i(view, "view");
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.setView(view);
    }

    public final void D(int i10, @NotNull String streamID) {
        s.i(streamID, "streamID");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置拉流预览视图模式失败: 请先初始化SDK");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置拉流预览视图模式 viewMode:" + i10 + "  streamID:" + streamID);
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setViewMode(i10, streamID);
        }
    }

    public final void E(int i10, @NotNull String streamID) {
        ZegoLiveRoom zegoLiveRoom;
        s.i(streamID, "streamID");
        if (!this.f14926b.contains(streamID) || (zegoLiveRoom = this.f14925a) == null) {
            return;
        }
        zegoLiveRoom.setPlayVolume(i10, streamID);
    }

    public final void F(@Nullable c cVar) {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置拉流代理失败: 请先初始化sdk");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置拉流代理");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setZegoLivePlayerCallback(cVar);
        }
    }

    public final void G(boolean z10) {
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.enablePreviewMirror(z10);
        }
    }

    public final void H(int i10) {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置推流预览视图模式失败: 请先初始化sdk");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置推流预览视图模式 viewMode:" + i10);
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setPreviewViewMode(i10);
        }
    }

    public final void I(long j10) {
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.setProcessInterval(j10);
    }

    public final void J(@Nullable d dVar) {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置推流代理失败: 请先初始化sdk");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "设置推流代理");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setZegoLivePublisherCallback(dVar);
        }
    }

    public final void K(@NotNull e soundLevelCallback) {
        s.i(soundLevelCallback, "soundLevelCallback");
        ZegoSoundLevelMonitor.getInstance().enableVAD(true);
        ZegoSoundLevelMonitor.getInstance().setCallback(soundLevelCallback);
    }

    public final void L(@NotNull b callback) {
        s.i(callback, "callback");
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.setEventWithIndexCallback(callback);
    }

    public final void M(@NotNull String path, boolean z10) {
        s.i(path, "path");
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.start(path, z10);
    }

    @Nullable
    public final Boolean O(@NotNull String streamID, @Nullable View view) {
        s.i(streamID, "streamID");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "开始拉流失败: 请先初始化SDK");
            return Boolean.FALSE;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "开始拉流  streamID:" + streamID);
        if (!this.f14926b.contains(streamID)) {
            this.f14926b.add(streamID);
        }
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            return Boolean.valueOf(zegoLiveRoom.startPlayingStream(streamID, view));
        }
        return null;
    }

    public final void P(@Nullable View view) {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "开始预览失败: 请先初始化sdk");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "开始预览");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setPreviewView(view);
        }
        ZegoLiveRoom zegoLiveRoom2 = this.f14925a;
        if (zegoLiveRoom2 != null) {
            zegoLiveRoom2.startPreview();
        }
    }

    @Nullable
    public final Boolean Q(@NotNull String streamID, @NotNull String title, int i10) {
        s.i(streamID, "streamID");
        s.i(title, "title");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "开始推流失败: 请先初始化sdk");
            return Boolean.FALSE;
        }
        this.f14927c = streamID;
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "开始推流, streamID:" + streamID + "  title:" + title + "  flag:" + i10);
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            return Boolean.valueOf(zegoLiveRoom.startPublishing(streamID, title, i10));
        }
        return null;
    }

    public final void R() {
        ZegoSoundLevelMonitor.getInstance().start();
    }

    public final void S() {
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.stop();
    }

    public final void T(@NotNull String streamID) {
        s.i(streamID, "streamID");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止拉流失败: 请先初始化SDK");
            return;
        }
        if (this.f14926b.contains(streamID)) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止拉流  streamID:" + streamID);
            this.f14926b.remove(streamID);
            ZegoLiveRoom zegoLiveRoom = this.f14925a;
            if (zegoLiveRoom != null) {
                zegoLiveRoom.stopPlayingStream(streamID);
            }
        }
    }

    public final void U() {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止拉所有流失败: 请先初始化SDK");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止拉所有流  playStreamIds:" + ((Object) this.f14926b));
        for (String str : this.f14926b) {
            ZegoLiveRoom zegoLiveRoom = this.f14925a;
            if (zegoLiveRoom != null) {
                zegoLiveRoom.stopPlayingStream(str);
            }
        }
        this.f14926b.clear();
    }

    public final void V() {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止预览失败: 请先初始化sdk");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止预览");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.stopPreview();
        }
    }

    public final void W() {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止推流失败: 请先初始化sdk");
            return;
        }
        this.f14927c = null;
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "停止推流");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.stopPublishing();
        }
    }

    public final void X() {
        ZegoSoundLevelMonitor.getInstance().stop();
    }

    @Nullable
    public final Boolean Y(@NotNull String roomId, int i10, @Nullable final IZegoLoginCompletionCallback iZegoLoginCompletionCallback) {
        s.i(roomId, "roomId");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "切换房间失败: 请先InitSdk");
            return Boolean.FALSE;
        }
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        aVar.a("ZGEntityLog", "开始切换房间 zgLiveRoom:" + (this.f14925a == null) + "  roomId:" + roomId + "  role:" + i10);
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        Boolean valueOf = zegoLiveRoom != null ? Boolean.valueOf(zegoLiveRoom.switchRoom(roomId, "", i10, new IZegoLoginCompletionCallback() { // from class: com.cupidapp.live.liveshow.entity.h
            @Override // com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback
            public final void onLoginCompletion(int i11, ZegoStreamInfo[] zegoStreamInfoArr) {
                j.a0(IZegoLoginCompletionCallback.this, i11, zegoStreamInfoArr);
            }
        })) : null;
        aVar.a("ZGEntityLog", "切换房间结果 switchRoomResult:" + ((Object) valueOf));
        return valueOf;
    }

    public final void b0() {
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer != null) {
            if (zegoMediaPlayer != null) {
                zegoMediaPlayer.uninit();
            }
            this.f14929e = null;
        }
    }

    public final void c0(@NotNull String streamID, @NotNull View view) {
        s.i(streamID, "streamID");
        s.i(view, "view");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.updatePlayView(streamID, view);
        }
    }

    public final void g(boolean z10) {
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setFrontCam(z10);
        }
    }

    public final void h(boolean z10) {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "启用摄像头失败: 请先初始化SDK");
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", z10 ? "启用摄像头" : "关闭摄像头");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.enableCamera(z10);
        }
    }

    public final void i(boolean z10) {
        this.f14928d = z10;
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.enableSpeaker(z10);
        }
    }

    @Nullable
    public final String j() {
        return this.f14927c;
    }

    @NotNull
    public final List<String> k() {
        return this.f14926b;
    }

    public final void l(@Nullable final Function2<? super Boolean, ? super Boolean, p> function2) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (!o() && liveShowModel != null) {
            if (this.f14925a == null) {
                this.f14925a = new ZegoLiveRoom();
            }
            ZegoLiveRoom.setConfig("vcap_external_support_preview=true");
            ZegoLiveRoom.setTestEnv(false);
            ZegoLiveRoom.requireHardwareEncoder(true);
            ZegoLiveRoom.setAudioDeviceMode(2);
            String appSign = liveShowModel.getAppSign();
            String substring = liveShowModel.getSalt().substring(0, 8);
            s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            byte[] a10 = l1.a.a(appSign, "243e6994" + substring);
            ZegoLiveRoom zegoLiveRoom = this.f14925a;
            if (zegoLiveRoom != null) {
                zegoLiveRoom.initSDK(liveShowModel.getAppId(), a10, new IZegoInitSDKCompletionCallback() { // from class: com.cupidapp.live.liveshow.entity.g
                    @Override // com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback
                    public final void onInitSDK(int i10) {
                        j.m(j.this, function2, i10);
                    }
                });
                return;
            }
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "sdk已初始化, 无需重复初始化 || fkLiveShowModel == null");
    }

    public final void n() {
        if (o() && this.f14929e == null) {
            ZegoMediaPlayer zegoMediaPlayer = new ZegoMediaPlayer();
            this.f14929e = zegoMediaPlayer;
            zegoMediaPlayer.init(1, 0);
        }
    }

    public final boolean o() {
        return f14923g == ZGSdkState.InitSuccessState;
    }

    @Nullable
    public final Boolean p(@NotNull String roomId, int i10, @Nullable final IZegoLoginCompletionCallback iZegoLoginCompletionCallback) {
        s.i(roomId, "roomId");
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "登陆房间失败: 请先InitSdk");
            return Boolean.FALSE;
        }
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        aVar.a("ZGEntityLog", "开始登陆房间 zgLiveRoom:" + (this.f14925a == null) + "  roomId:" + roomId + "  role:" + i10);
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        Boolean valueOf = zegoLiveRoom != null ? Boolean.valueOf(zegoLiveRoom.loginRoom(roomId, i10, new IZegoLoginCompletionCallback() { // from class: com.cupidapp.live.liveshow.entity.i
            @Override // com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback
            public final void onLoginCompletion(int i11, ZegoStreamInfo[] zegoStreamInfoArr) {
                j.r(IZegoLoginCompletionCallback.this, i11, zegoStreamInfoArr);
            }
        })) : null;
        aVar.a("ZGEntityLog", "登陆房间结果 loginRoomResult:" + ((Object) valueOf));
        return valueOf;
    }

    public final Boolean s() {
        if (!o()) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "退出房间失败: 请先InitSdk");
            return Boolean.FALSE;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "退出房间");
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            return Boolean.valueOf(zegoLiveRoom.logoutRoom());
        }
        return null;
    }

    public final void t() {
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.pause();
    }

    public final void u() {
        W();
        V();
        U();
        s();
        v();
    }

    public final void v() {
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            zegoLiveRoom.setZegoLivePlayerCallback(null);
        }
        ZegoLiveRoom zegoLiveRoom2 = this.f14925a;
        if (zegoLiveRoom2 != null) {
            zegoLiveRoom2.setZegoLivePublisherCallback(null);
        }
    }

    public final boolean w() {
        ZegoLiveRoom zegoLiveRoom = this.f14925a;
        if (zegoLiveRoom != null) {
            f14923g = ZGSdkState.WaitInitState;
            r2 = zegoLiveRoom != null ? zegoLiveRoom.unInitSDK() : false;
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "释放zego SDK! " + r2);
            this.f14925a = null;
        }
        f14924h = null;
        return r2;
    }

    public final void x() {
        ZegoMediaPlayer zegoMediaPlayer = this.f14929e;
        if (zegoMediaPlayer == null || zegoMediaPlayer == null) {
            return;
        }
        zegoMediaPlayer.resume();
    }

    public final void y() {
        if (o()) {
            ZegoLiveRoom zegoLiveRoom = this.f14925a;
            if (zegoLiveRoom != null) {
                zegoLiveRoom.setAECMode(1);
            }
            ZegoLiveRoom zegoLiveRoom2 = this.f14925a;
            if (zegoLiveRoom2 != null) {
                zegoLiveRoom2.enableAEC(true);
            }
            ZegoLiveRoom zegoLiveRoom3 = this.f14925a;
            if (zegoLiveRoom3 != null) {
                zegoLiveRoom3.enableAGC(true);
            }
            ZegoLiveRoom zegoLiveRoom4 = this.f14925a;
            if (zegoLiveRoom4 != null) {
                zegoLiveRoom4.enableNoiseSuppress(true);
            }
            ZegoLiveRoom zegoLiveRoom5 = this.f14925a;
            if (zegoLiveRoom5 != null) {
                zegoLiveRoom5.enableTransientNoiseSuppress(true);
            }
            ZegoLiveRoom zegoLiveRoom6 = this.f14925a;
            if (zegoLiveRoom6 != null) {
                zegoLiveRoom6.setNoiseSuppressMode(1);
            }
        }
    }

    public final void z(boolean z10) {
        if (z10) {
            ZegoLiveRoom zegoLiveRoom = this.f14925a;
            if (zegoLiveRoom != null) {
                zegoLiveRoom.enableBeautifying(3);
                return;
            }
            return;
        }
        ZegoLiveRoom zegoLiveRoom2 = this.f14925a;
        if (zegoLiveRoom2 != null) {
            zegoLiveRoom2.enableBeautifying(0);
        }
    }
}

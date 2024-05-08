package d4;

import android.os.Bundle;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: TRTCEngine.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends IVoiceEngine {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final C0719a f48607d = new C0719a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public TRTCCloud f48608c;

    /* compiled from: TRTCEngine.kt */
    @d
    /* renamed from: d4.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0719a {
        public C0719a() {
        }

        public /* synthetic */ C0719a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TRTCEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f48609a;

        static {
            int[] iArr = new int[IVoiceEngine.AudioOutputPosition.values().length];
            try {
                iArr[IVoiceEngine.AudioOutputPosition.SPEAKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IVoiceEngine.AudioOutputPosition.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f48609a = iArr;
        }
    }

    /* compiled from: TRTCEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends TRTCCloudListener {
        public c() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionLost() {
            a.this.s("onConnectionLost SDK 与云端的连接已经断开");
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionRecovery() {
            a.this.s("onConnectionRecovery SDK 与云端的连接已经恢复");
            IVoiceEngine.a h10 = a.this.h();
            if (h10 != null) {
                h10.d();
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onEnterRoom(long j10) {
            if (j10 > 0) {
                a.this.s("Enter Room Succeed，时间（毫秒）为:" + j10);
                IVoiceEngine.a h10 = a.this.h();
                if (h10 != null) {
                    h10.c(j10);
                    return;
                }
                return;
            }
            a.this.s("Enter Room Failed，错误码为:" + j10);
            IVoiceEngine.a h11 = a.this.h();
            if (h11 != null) {
                h11.f((int) j10);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onError(int i10, @Nullable String str, @Nullable Bundle bundle) {
            a.this.s("onError  errCode:" + i10 + "  errMsg:" + str);
            IVoiceEngine.a h10 = a.this.h();
            if (h10 != null) {
                h10.onError(i10, str);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onExitRoom(int i10) {
            if (i10 == 0) {
                a.this.s("用户主动退出房间");
            } else if (i10 == 1) {
                a.this.s("被踢出当前房间");
            } else {
                if (i10 != 2) {
                    return;
                }
                a.this.s("当前房间被解散");
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onNetworkQuality(@Nullable TRTCCloudDef.TRTCQuality tRTCQuality, @Nullable ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
            TRTCCloudDef.TRTCQuality tRTCQuality2;
            TRTCCloudDef.TRTCQuality tRTCQuality3;
            Integer num = null;
            a.this.s("我-网络质量:" + ((Object) (tRTCQuality != null ? Integer.valueOf(tRTCQuality.quality) : null)) + "   对方-网络质量:" + ((Object) ((arrayList == null || (tRTCQuality3 = (TRTCCloudDef.TRTCQuality) CollectionsKt___CollectionsKt.W(arrayList, 0)) == null) ? null : Integer.valueOf(tRTCQuality3.quality))));
            IVoiceEngine.a h10 = a.this.h();
            if (h10 != null) {
                IVoiceEngine.NetworkStateLevel r10 = a.this.r(tRTCQuality != null ? Integer.valueOf(tRTCQuality.quality) : null);
                a aVar = a.this;
                if (arrayList != null && (tRTCQuality2 = (TRTCCloudDef.TRTCQuality) CollectionsKt___CollectionsKt.W(arrayList, 0)) != null) {
                    num = Integer.valueOf(tRTCQuality2.quality);
                }
                h10.a(r10, aVar.r(num));
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserLeaveRoom(@Nullable String str, int i10) {
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onSwitchRole(int i10, @Nullable String str) {
            if (i10 != 0) {
                a.this.s("onSwitchRole 切换角色失败，errCode:" + i10 + "  errMsg:" + str);
                return;
            }
            a.this.s("onSwitchRole 切换角色成功 errMsg: " + str);
            IVoiceEngine.a h10 = a.this.h();
            if (h10 != null) {
                h10.b();
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onTryToReconnect() {
            a.this.s("onTryToReconnect SDK 与云端的连接尝试重连");
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVoiceVolume(@Nullable ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i10) {
            if (arrayList != null) {
                a aVar = a.this;
                for (TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo : arrayList) {
                    String str = tRTCVolumeInfo.userId;
                    User X = g.f52734a.X();
                    String userId = X != null ? X.userId() : null;
                    aVar.s("onUserVoiceVolume user : " + str + " " + userId + " volume: " + tRTCVolumeInfo.volume + " vad: " + tRTCVolumeInfo.vad + " totalVolume: " + i10);
                }
            }
            if (arrayList != null) {
                a aVar2 = a.this;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList2 = new ArrayList();
                for (TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo2 : arrayList) {
                    if (tRTCVolumeInfo2.volume > 20) {
                        arrayList2.add(tRTCVolumeInfo2);
                    }
                }
                for (TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo3 : arrayList2) {
                    String str2 = tRTCVolumeInfo3.userId;
                    s.h(str2, "it.userId");
                    linkedHashMap.put(str2, Integer.valueOf(tRTCVolumeInfo3.volume));
                }
                IVoiceEngine.a h10 = aVar2.h();
                if (h10 != null) {
                    h10.e(linkedHashMap);
                }
            }
        }
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void a() {
        TRTCCloud sharedInstance = TRTCCloud.sharedInstance(AppApplication.f11612d.c());
        this.f48608c = sharedInstance;
        if (sharedInstance != null) {
            sharedInstance.setListener(new c());
        }
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void c() {
        IVoiceEngine.VoiceEngineOption i10 = i();
        if (i10 == null) {
            return;
        }
        a();
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.sdkAppId = i10.c();
        User X = g.f52734a.X();
        tRTCParams.userId = X != null ? X.userId() : null;
        tRTCParams.strRoomId = i10.b();
        tRTCParams.userSig = i10.d();
        TRTCCloud tRTCCloud = this.f48608c;
        if (tRTCCloud != null) {
            tRTCCloud.startLocalAudio(1);
        }
        TRTCCloud tRTCCloud2 = this.f48608c;
        if (tRTCCloud2 != null) {
            tRTCCloud2.enterRoom(tRTCParams, 2);
        }
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void d() {
        TRTCCloud tRTCCloud;
        IVoiceEngine.VoiceEngineOption i10 = i();
        if (i10 == null) {
            return;
        }
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.sdkAppId = i10.c();
        User X = g.f52734a.X();
        tRTCParams.userId = X != null ? X.userId() : null;
        tRTCParams.strRoomId = i10.b();
        tRTCParams.userSig = i10.d();
        if (i10.a().length() > 0) {
            tRTCParams.privateMapKey = i10.a();
        }
        tRTCParams.role = i10.e() ? 20 : 21;
        if (i10.e() && (tRTCCloud = this.f48608c) != null) {
            tRTCCloud.startLocalAudio(1);
        }
        TRTCCloud tRTCCloud2 = this.f48608c;
        if (tRTCCloud2 != null) {
            tRTCCloud2.enterRoom(tRTCParams, 3);
        }
        TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams = new TRTCCloudDef.TRTCAudioVolumeEvaluateParams();
        TRTCCloud tRTCCloud3 = this.f48608c;
        if (tRTCCloud3 != null) {
            tRTCCloud3.enableAudioVolumeEvaluation(true, tRTCAudioVolumeEvaluateParams);
        }
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void e() {
        TRTCCloud tRTCCloud = this.f48608c;
        if (tRTCCloud != null) {
            if (tRTCCloud != null) {
                tRTCCloud.stopAllRemoteView();
            }
            TRTCCloud tRTCCloud2 = this.f48608c;
            if (tRTCCloud2 != null) {
                tRTCCloud2.stopLocalAudio();
            }
            TRTCCloud tRTCCloud3 = this.f48608c;
            if (tRTCCloud3 != null) {
                tRTCCloud3.exitRoom();
            }
            TRTCCloud tRTCCloud4 = this.f48608c;
            if (tRTCCloud4 != null) {
                tRTCCloud4.setListener(null);
            }
        }
        this.f48608c = null;
        l(null);
        TRTCCloud.destroySharedInstance();
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void f() {
        TRTCCloud tRTCCloud = this.f48608c;
        if (tRTCCloud != null) {
            if (tRTCCloud != null) {
                tRTCCloud.stopAllRemoteView();
            }
            TRTCCloud tRTCCloud2 = this.f48608c;
            if (tRTCCloud2 != null) {
                tRTCCloud2.stopLocalAudio();
            }
            TRTCCloud tRTCCloud3 = this.f48608c;
            if (tRTCCloud3 != null) {
                tRTCCloud3.exitRoom();
            }
        }
        l(null);
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void j(boolean z10) {
        TRTCCloud tRTCCloud = this.f48608c;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalAudio(z10);
        }
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void k(@NotNull IVoiceEngine.AudioOutputPosition position) {
        s.i(position, "position");
        int i10 = b.f48609a[position.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            i11 = 0;
        } else if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        TRTCCloud tRTCCloud = this.f48608c;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioRoute(i11);
        }
    }

    @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine
    public void o(boolean z10, @NotNull String privateMapKey) {
        s.i(privateMapKey, "privateMapKey");
        if (z10) {
            TRTCCloud tRTCCloud = this.f48608c;
            if (tRTCCloud != null) {
                tRTCCloud.switchRole(20, privateMapKey);
            }
            TRTCCloud tRTCCloud2 = this.f48608c;
            if (tRTCCloud2 != null) {
                tRTCCloud2.startLocalAudio(2);
                return;
            }
            return;
        }
        TRTCCloud tRTCCloud3 = this.f48608c;
        if (tRTCCloud3 != null) {
            tRTCCloud3.switchRole(21, privateMapKey);
        }
        TRTCCloud tRTCCloud4 = this.f48608c;
        if (tRTCCloud4 != null) {
            tRTCCloud4.stopLocalAudio();
        }
    }

    public final IVoiceEngine.NetworkStateLevel r(Integer num) {
        boolean z10 = false;
        if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) {
            return IVoiceEngine.NetworkStateLevel.NORMAL;
        }
        if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4)) {
            return IVoiceEngine.NetworkStateLevel.BAD;
        }
        if (((num != null && num.intValue() == 5) || (num != null && num.intValue() == 6)) || (num != null && num.intValue() == 0)) {
            z10 = true;
        }
        return z10 ? IVoiceEngine.NetworkStateLevel.ERROR : IVoiceEngine.NetworkStateLevel.UNKNOWN;
    }

    public final void s(String str) {
        j.f12332a.a("TRTCEngine", str);
    }
}

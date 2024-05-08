package com.cupidapp.live.voiceparty.engine;

import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IVoiceEngine.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class IVoiceEngine {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public VoiceEngineOption f19006a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f19007b;

    /* compiled from: IVoiceEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum AudioOutputPosition {
        SPEAKER,
        EARPIECE
    }

    /* compiled from: IVoiceEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum NetworkStateLevel {
        NORMAL,
        BAD,
        ERROR,
        UNKNOWN
    }

    /* compiled from: IVoiceEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class VoiceEngineOption {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f19008a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19009b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final String f19010c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public final String f19011d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f19012e;

        public VoiceEngineOption(@NotNull String roomId, int i10, @NotNull String userSig, @NotNull String privateMapKey, boolean z10) {
            s.i(roomId, "roomId");
            s.i(userSig, "userSig");
            s.i(privateMapKey, "privateMapKey");
            this.f19008a = roomId;
            this.f19009b = i10;
            this.f19010c = userSig;
            this.f19011d = privateMapKey;
            this.f19012e = z10;
        }

        @NotNull
        public final String a() {
            return this.f19011d;
        }

        @NotNull
        public final String b() {
            return this.f19008a;
        }

        public final int c() {
            return this.f19009b;
        }

        @NotNull
        public final String d() {
            return this.f19010c;
        }

        public final boolean e() {
            return this.f19012e;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VoiceEngineOption)) {
                return false;
            }
            VoiceEngineOption voiceEngineOption = (VoiceEngineOption) obj;
            return s.d(this.f19008a, voiceEngineOption.f19008a) && this.f19009b == voiceEngineOption.f19009b && s.d(this.f19010c, voiceEngineOption.f19010c) && s.d(this.f19011d, voiceEngineOption.f19011d) && this.f19012e == voiceEngineOption.f19012e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.f19008a.hashCode() * 31) + this.f19009b) * 31) + this.f19010c.hashCode()) * 31) + this.f19011d.hashCode()) * 31;
            boolean z10 = this.f19012e;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return hashCode + i10;
        }

        @NotNull
        public String toString() {
            return "VoiceEngineOption(roomId=" + this.f19008a + ", sdkAppID=" + this.f19009b + ", userSig=" + this.f19010c + ", privateMapKey=" + this.f19011d + ", isAnchor=" + this.f19012e + ")";
        }
    }

    /* compiled from: IVoiceEngine.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {

        /* compiled from: IVoiceEngine.kt */
        @d
        /* renamed from: com.cupidapp.live.voiceparty.engine.IVoiceEngine$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0175a {
            public static void a(@NotNull a aVar) {
            }

            public static void b(@NotNull a aVar, @NotNull NetworkStateLevel localLevel, @NotNull NetworkStateLevel remoteLevel) {
                s.i(localLevel, "localLevel");
                s.i(remoteLevel, "remoteLevel");
            }

            public static void c(@NotNull a aVar) {
            }

            public static void d(@NotNull a aVar, @NotNull Map<String, Integer> userVolumes) {
                s.i(userVolumes, "userVolumes");
            }
        }

        void a(@NotNull NetworkStateLevel networkStateLevel, @NotNull NetworkStateLevel networkStateLevel2);

        void b();

        void c(long j10);

        void d();

        void e(@NotNull Map<String, Integer> map);

        void f(int i10);

        void onError(int i10, @Nullable String str);
    }

    public void a() {
        throw null;
    }

    public final boolean b() {
        VoiceEngineOption voiceEngineOption = this.f19006a;
        return voiceEngineOption != null && voiceEngineOption.e();
    }

    public void c() {
        throw null;
    }

    public void d() {
        throw null;
    }

    public void e() {
        throw null;
    }

    public void f() {
        throw null;
    }

    @Nullable
    public final String g() {
        VoiceEngineOption voiceEngineOption = this.f19006a;
        if (voiceEngineOption != null) {
            return voiceEngineOption.b();
        }
        return null;
    }

    @Nullable
    public final a h() {
        return this.f19007b;
    }

    @Nullable
    public final VoiceEngineOption i() {
        return this.f19006a;
    }

    public void j(boolean z10) {
        throw null;
    }

    public void k(@NotNull AudioOutputPosition audioOutputPosition) {
        throw null;
    }

    public final void l(@Nullable VoiceEngineOption voiceEngineOption) {
        this.f19006a = voiceEngineOption;
    }

    public final void m(@NotNull a listener) {
        s.i(listener, "listener");
        this.f19007b = listener;
    }

    public final void n(@NotNull VoiceEngineOption option) {
        s.i(option, "option");
        this.f19006a = option;
    }

    public void o(boolean z10, @NotNull String str) {
        throw null;
    }
}

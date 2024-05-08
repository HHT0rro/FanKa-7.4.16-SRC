package com.cupidapp.live.startup.view;

import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.SplashAdShowState;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseStartupLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b {

    /* compiled from: FKBaseStartupLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull FKAdType type, @Nullable String str) {
            s.i(type, "type");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupClick 点击广告");
        }

        public static /* synthetic */ void b(b bVar, FKAdType fKAdType, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startupClick");
            }
            if ((i10 & 2) != 0) {
                str = null;
            }
            bVar.I(fKAdType, str);
        }

        public static void c(@NotNull b bVar, @NotNull FKAdType type, @Nullable Integer num, @Nullable String str, boolean z10) {
            s.i(type, "type");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupLoadFailed 广告加载失败 错误码:" + ((Object) num) + " 错误信息:" + str + "  reportEventTrack:" + z10);
        }

        public static /* synthetic */ void d(b bVar, FKAdType fKAdType, Integer num, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startupLoadFailed");
            }
            if ((i10 & 2) != 0) {
                num = null;
            }
            if ((i10 & 4) != 0) {
                str = null;
            }
            if ((i10 & 8) != 0) {
                z10 = true;
            }
            bVar.c(fKAdType, num, str, z10);
        }

        public static void e(@NotNull b bVar, @NotNull FKAdType type) {
            s.i(type, "type");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupLoadSuccess 广告加载成功");
        }

        public static void f(@NotNull b bVar, @NotNull FKAdType type, @Nullable Integer num, @Nullable String str) {
            s.i(type, "type");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupShowFailed 广告显示失败 错误码:" + ((Object) num) + " 错误信息:" + str);
        }

        public static void g(@NotNull b bVar, @NotNull FKAdType type) {
            s.i(type, "type");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupShowSuccess 广告显示成功");
        }

        public static void h(@NotNull b bVar, @NotNull FKAdType type) {
            s.i(type, "type");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupSkip 跳过广告");
        }

        public static void i(@NotNull b bVar, @NotNull FKAdType type, @NotNull SplashAdShowState state) {
            s.i(type, "type");
            s.i(state, "state");
            com.cupidapp.live.startup.helper.b.f18418a.a(type.name() + " startupWillClose 广告即将关闭  广告是否完整展示:" + state.name());
        }

        public static void j(@NotNull b bVar, @Nullable FKAdType fKAdType, @NotNull String url) {
            s.i(url, "url");
            com.cupidapp.live.startup.helper.b.f18418a.a((fKAdType != null ? fKAdType.name() : null) + " vipAdFreeBtnClick 会员免广告");
        }
    }

    void I(@NotNull FKAdType fKAdType, @Nullable String str);

    void J0(@NotNull FKAdType fKAdType);

    void P(@NotNull FKAdType fKAdType);

    void Q(@NotNull FKAdType fKAdType, @Nullable Integer num, @Nullable String str);

    void c(@NotNull FKAdType fKAdType, @Nullable Integer num, @Nullable String str, boolean z10);

    void c0(@NotNull FKAdType fKAdType, @NotNull SplashAdShowState splashAdShowState);

    void p0(@NotNull FKAdType fKAdType);

    void v(@Nullable FKAdType fKAdType, @NotNull String str);
}

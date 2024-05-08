package com.cupidapp.live.startup.express;

import android.view.View;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.model.FKAdType;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseExpressAd.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b {

    /* compiled from: FKBaseExpressAd.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull FKAdType type, int i10) {
            s.i(type, "type");
            j.f12332a.a("FKExpressAdListener", "onClicked adPosition: " + i10 + " " + type.getType() + " 广告被点击");
        }

        public static void b(@NotNull b bVar, @NotNull FKAdType type, int i10, @Nullable String str) {
            s.i(type, "type");
            j.f12332a.a("FKExpressAdListener", "onClosed adPosition: " + i10 + " " + type.getType() + " 广告被关闭");
        }

        public static /* synthetic */ void c(b bVar, FKAdType fKAdType, int i10, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClosed");
            }
            if ((i11 & 4) != 0) {
                str = null;
            }
            bVar.d(fKAdType, i10, str);
        }

        public static void d(@NotNull b bVar, @NotNull FKAdType type, int i10, @Nullable Integer num, @Nullable String str) {
            s.i(type, "type");
            j.f12332a.a("FKExpressAdListener", "onFailed adPosition: " + i10 + " " + type.getType() + " 广告展示失败 errorCode: " + ((Object) num) + " errorMessage: " + str);
        }

        public static /* synthetic */ void e(b bVar, FKAdType fKAdType, int i10, Integer num, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
            }
            if ((i11 & 4) != 0) {
                num = null;
            }
            if ((i11 & 8) != 0) {
                str = null;
            }
            bVar.e(fKAdType, i10, num, str);
        }

        public static void f(@NotNull b bVar, @NotNull FKAdType type, int i10, @Nullable View view) {
            s.i(type, "type");
            j.f12332a.a("FKExpressAdListener", "onRenderSuccess adPosition: " + i10 + " " + type.getType() + " 广告渲染成功 view: " + ((Object) view));
        }

        public static void g(@NotNull b bVar, @NotNull FKAdType type, int i10) {
            s.i(type, "type");
            j.f12332a.a("FKExpressAdListener", "onShow adPosition: " + i10 + " " + type.getType() + " 广告展示成功");
        }
    }

    void a(@NotNull FKAdType fKAdType, int i10);

    void b(@NotNull FKAdType fKAdType, int i10, @Nullable View view);

    void c(@NotNull FKAdType fKAdType, int i10);

    void d(@NotNull FKAdType fKAdType, int i10, @Nullable String str);

    void e(@NotNull FKAdType fKAdType, int i10, @Nullable Integer num, @Nullable String str);
}

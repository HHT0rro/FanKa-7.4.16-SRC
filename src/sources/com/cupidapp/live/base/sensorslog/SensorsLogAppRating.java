package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.appdialog.model.RateScene;
import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogAppRating.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogAppRating {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogAppRating f12207a = new SensorsLogAppRating();

    /* compiled from: SensorsLogAppRating.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ButtonName {
        PositiveButton("去好评"),
        NegativeButton("去吐槽"),
        CloseButton("关闭");


        @NotNull
        private final String button;

        ButtonName(String str) {
            this.button = str;
        }

        @NotNull
        public final String getButton() {
            return this.button;
        }
    }

    /* compiled from: SensorsLogAppRating.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PopupWindowType {
        InternalRating("INTERNAL_APP_STORE_RATING"),
        ExternalRating("EXTERNAL_APP_STORE_RATING");


        @NotNull
        private final String type;

        PopupWindowType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    public final void a(@NotNull String buttonName, @Nullable RateScene rateScene, boolean z10) {
        s.i(buttonName, "buttonName");
        GroupOthersLog.f18702a.f(buttonName, rateScene != null ? rateScene.getTriggerMode() : null, b(z10));
    }

    public final String b(boolean z10) {
        return (z10 ? PopupWindowType.InternalRating : PopupWindowType.ExternalRating).getType();
    }

    public final void c(@NotNull RateScene rateScene, boolean z10) {
        s.i(rateScene, "rateScene");
        GroupOthersLog.f18702a.g(rateScene.getTriggerMode(), b(z10));
    }
}

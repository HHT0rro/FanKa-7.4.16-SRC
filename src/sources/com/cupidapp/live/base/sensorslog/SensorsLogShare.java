package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogShare.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogShare {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogShare f12216a = new SensorsLogShare();

    /* compiled from: SensorsLogShare.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ShareLinkContentType {
        PageProfile("HOMEPAGE"),
        LiveShow("LIVE_ROOM"),
        Post("POST"),
        NewHashTag("NEW_TOPIC"),
        ACTIVITY("ACTIVITY");


        @NotNull
        private final String type;

        ShareLinkContentType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    public final void a(@Nullable ShareContent shareContent, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull SensorPosition sensorPosition, @Nullable ShareBtnPos shareBtnPos, @Nullable String str4) {
        s.i(sensorPosition, "sensorPosition");
        GroupOthersLog.f18702a.e0(sensorPosition.getValue(), str2, shareContent, str, shareBtnPos != null ? shareBtnPos.getValue() : null);
    }

    public final void c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        GroupOthersLog.f18702a.t0(str, str2, str3, str4, str5);
    }

    public final void d(@Nullable ShareContent shareContent, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ShareType shareType, @NotNull SensorPosition sensorPosition, @Nullable String str4, @Nullable String str5) {
        s.i(sensorPosition, "sensorPosition");
        GroupOthersLog.f18702a.s(sensorPosition.getValue(), shareType != null ? shareType.name() : null, str2, shareContent, str, str4, str5);
    }

    public final void f(@Nullable ShareContent shareContent, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ShareType shareType, boolean z10, @Nullable String str4, @Nullable SensorPosition sensorPosition, @Nullable String str5, @Nullable String str6) {
        GroupOthersLog.f18702a.g0(sensorPosition != null ? sensorPosition.getValue() : null, shareType != null ? shareType.name() : null, str2, shareContent, str);
    }
}

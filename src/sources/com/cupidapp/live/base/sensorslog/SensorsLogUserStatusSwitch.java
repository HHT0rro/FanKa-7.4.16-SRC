package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.track.group.GroupOthersLog;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SensorsLogUserStatusSwitch.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogUserStatusSwitch {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogUserStatusSwitch f12217a = new SensorsLogUserStatusSwitch();

    /* compiled from: SensorsLogUserStatusSwitch.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum SystemPermission {
        StoragePermission("MEMORY"),
        LocationPermission("LocationPermission"),
        LocationInformation("LOCATION"),
        PushPermission("PUSH");


        @NotNull
        private final String permission;

        SystemPermission(String str) {
            this.permission = str;
        }

        @NotNull
        public final String getPermission() {
            return this.permission;
        }
    }

    public static /* synthetic */ void b(SensorsLogUserStatusSwitch sensorsLogUserStatusSwitch, AppSetting appSetting, boolean z10, SensorPosition sensorPosition, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sensorPosition = null;
        }
        sensorsLogUserStatusSwitch.a(appSetting, z10, sensorPosition);
    }

    public static /* synthetic */ void d(SensorsLogUserStatusSwitch sensorsLogUserStatusSwitch, SystemPermission systemPermission, boolean z10, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bool = null;
        }
        if ((i10 & 8) != 0) {
            bool2 = null;
        }
        sensorsLogUserStatusSwitch.c(systemPermission, z10, bool, bool2);
    }

    public final void a(@NotNull AppSetting appSetting, boolean z10, @Nullable SensorPosition sensorPosition) {
        s.i(appSetting, "appSetting");
        GroupOthersLog.l0(GroupOthersLog.f18702a, appSetting, z10, sensorPosition, null, 8, null);
    }

    public final void c(@NotNull SystemPermission permission, boolean z10, @Nullable Boolean bool, @Nullable Boolean bool2) {
        s.i(permission, "permission");
        GroupOthersLog.f18702a.m0(permission.getPermission(), z10, bool, bool2);
    }
}

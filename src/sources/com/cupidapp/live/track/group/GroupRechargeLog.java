package com.cupidapp.live.track.group;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.irisdt.client.recharge.RechargeProtos;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.c;

/* compiled from: GroupRechargeLog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GroupRechargeLog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GroupRechargeLog f18707a = new GroupRechargeLog();

    /* compiled from: GroupRechargeLog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum DiamondEntrance {
        DIO,
        LIVE
    }

    public final void a(@NotNull DiamondEntrance entrance) {
        s.i(entrance, "entrance");
        c.f54829a.D(RechargeProtos.Event.ENTRANCE_CLICK, (r15 & 2) != 0 ? null : null, (r15 & 4) != 0 ? null : null, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : entrance.name(), (r15 & 32) != 0 ? null : null, (r15 & 64) == 0 ? null : null);
    }

    public final void b(@NotNull String level, int i10, @Nullable SensorPosition sensorPosition, boolean z10, @Nullable String str) {
        String type;
        s.i(level, "level");
        c cVar = c.f54829a;
        RechargeProtos.Event event = RechargeProtos.Event.RECHARGE_CONFIRM_CLICK;
        String value = sensorPosition != null ? sensorPosition.getValue() : null;
        if (z10) {
            type = RechargeType.FirstRecharge.getType();
        } else {
            type = RechargeType.NonFirstRecharge.getType();
        }
        cVar.D(event, (r15 & 2) != 0 ? null : value, (r15 & 4) != 0 ? null : level, (r15 & 8) != 0 ? null : Integer.valueOf(i10), (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? null : type, (r15 & 64) == 0 ? str : null);
    }

    public final void c(@Nullable SensorPosition sensorPosition, boolean z10, @Nullable String str) {
        String type;
        c cVar = c.f54829a;
        RechargeProtos.Event event = RechargeProtos.Event.RECHARGE_PAGE_SHOW;
        String value = sensorPosition != null ? sensorPosition.getValue() : null;
        if (z10) {
            type = RechargeType.FirstRecharge.getType();
        } else {
            type = RechargeType.NonFirstRecharge.getType();
        }
        cVar.D(event, (r15 & 2) != 0 ? null : value, (r15 & 4) != 0 ? null : null, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? null : type, (r15 & 64) == 0 ? str : null);
    }
}

package com.cupidapp.live.push;

import android.content.Context;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.push.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKPushModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {
    public static final void a(@NotNull FKPushModel pushModel, @NotNull Context context, @NotNull FKPushTunnel tunnel) {
        s.i(pushModel, "pushModel");
        s.i(context, "context");
        s.i(tunnel, "tunnel");
        pushModel.getPushMessageModel().setTunnel(tunnel);
        BindPushTokenUtilKt.e(context, pushModel.getPushMessageModel());
        j.f12332a.a("PushMessageMi", "id " + pushModel.getPushMessageModel().getPushId() + " text " + pushModel.getPushMessageModel().getContent() + " channel " + pushModel.getPushMessageModel().getChannel());
        d.a aVar = d.f17892a;
        if (aVar.g().contains(pushModel.getPushMessageModel().getPushId())) {
            aVar.g().remove(pushModel.getPushMessageModel().getPushId());
            return;
        }
        aVar.g().add(pushModel.getPushMessageModel().getPushId());
        if (AppApplication.f11612d.g()) {
            pushModel.applicationActiveAction(context);
        } else {
            pushModel.applicationNotActiveAction(context);
        }
    }
}

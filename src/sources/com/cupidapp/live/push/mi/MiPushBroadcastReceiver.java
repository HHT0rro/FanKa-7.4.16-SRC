package com.cupidapp.live.push.mi;

import android.content.Context;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.push.BindPushTokenUtilKt;
import com.cupidapp.live.push.FKPushMessageModel;
import com.cupidapp.live.push.FKPushTunnel;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.Nullable;

/* compiled from: MiPushBroadcastReceiver.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MiPushBroadcastReceiver extends PushMessageReceiver {
    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(@Nullable Context context, @Nullable MiPushCommandMessage miPushCommandMessage) {
        super.onCommandResult(context, miPushCommandMessage);
        j.f12332a.a("MiPushClient", "onCommandResult " + ((Object) miPushCommandMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(@Nullable Context context, @Nullable MiPushMessage miPushMessage) {
        j.f12332a.a("MiPushClient", "onNotificationMessageArrived " + ((Object) miPushMessage));
        super.onNotificationMessageArrived(context, miPushMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(@Nullable Context context, @Nullable MiPushMessage miPushMessage) {
        j.f12332a.a("MiPushClient", "onNotificationMessageClicked " + ((Object) miPushMessage));
        if (miPushMessage != null) {
            FKPushMessageModel.Companion.d(FKPushMessageModel.Companion, context, miPushMessage.getContent(), null, 4, null);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(@Nullable Context context, @Nullable MiPushMessage miPushMessage) {
        super.onReceivePassThroughMessage(context, miPushMessage);
        j.f12332a.a("MiPushClient", "onReceivePassThroughMessage " + ((Object) miPushMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(@Nullable Context context, @Nullable MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        String str = null;
        String command = miPushCommandMessage != null ? miPushCommandMessage.getCommand() : null;
        List<String> commandArguments = miPushCommandMessage != null ? miPushCommandMessage.getCommandArguments() : null;
        if (commandArguments != null && commandArguments.size() > 0) {
            str = commandArguments.get(0);
        }
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if (s.d("register", command) && miPushCommandMessage.getResultCode() == 0) {
            if (str != null && context != null) {
                BindPushTokenUtilKt.d(context, str, 3, FKPushTunnel.Xiaomi);
            }
            j.f12332a.a("MiPushClient", "onReceiveRegisterResult mRegId " + str);
        }
        j.f12332a.a("MiPushClient", "onReceiveRegisterResult " + ((Object) miPushCommandMessage));
    }
}

package com.cupidapp.live.push.vivo;

import android.content.Context;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.push.FKPushMessageModel;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import java.util.Map;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: VivoPushMessageReceiver.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {
    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(@Nullable Context context, @Nullable UPSNotificationMessage uPSNotificationMessage) {
        if (context != null) {
            boolean z10 = true;
            if (uPSNotificationMessage != null && uPSNotificationMessage.getSkipType() == 1) {
                Map<String, String> params = uPSNotificationMessage.getParams();
                if (params != null && !params.isEmpty()) {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
                try {
                    FKPushMessageModel.Companion.c(context, uPSNotificationMessage.getParams().get("pushModel"), "vivopushscheme");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(@Nullable Context context, @Nullable String str) {
        j.f12332a.a("PushMessage", "v onReceiveRegId " + str);
    }
}

package com.cupidapp.live.push.huawei;

import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.utils.i0;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.push.BindPushTokenUtilKt;
import com.cupidapp.live.push.FKPushTunnel;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: HuaweiPushServices.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HuaweiPushServices extends HmsMessageService {
    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(@Nullable RemoteMessage remoteMessage) {
        MsgContentBean msgContent;
        super.onMessageReceived(remoteMessage);
        j.f12332a.a("HuaweiHmsMessage", "onMessageReceived " + (remoteMessage != null ? remoteMessage.getData() : null));
        HuaweiPushModel huaweiPushModel = (HuaweiPushModel) GsonUtil.f12000a.b().fromJson(remoteMessage != null ? remoteMessage.getData() : null, HuaweiPushModel.class);
        if (huaweiPushModel == null || (msgContent = huaweiPushModel.getMsgContent()) == null) {
            return;
        }
        msgContent.a();
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(@Nullable String str) {
        super.onNewToken(str);
        j.f12332a.a("HuaweiHmsMessage", "onNewToken " + str);
        if (!i0.f12331a.b() || str == null) {
            return;
        }
        BindPushTokenUtilKt.d(this, str, 3, FKPushTunnel.Huawei);
    }
}

package com.tencent.cloud.huiyansdkface.facelight.c.a;

import com.android.internal.logging.nano.MetricsProto;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements com.tencent.cloud.huiyansdkface.a.a.g<com.tencent.cloud.huiyansdkface.a.a.a.d> {
    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.cloud.huiyansdkface.a.a.a.d b(List<com.tencent.cloud.huiyansdkface.a.a.a.d> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        if ("GT-I9508".equals(Param.getDeviceModel())) {
            return new com.tencent.cloud.huiyansdkface.a.a.a.d(1280, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH);
        }
        return null;
    }
}

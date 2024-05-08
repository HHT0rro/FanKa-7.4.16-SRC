package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnUndoMsgReceiveTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ag extends aa {
    public ag(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) vVar;
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f46360a), uVar.e(), uVar.g())) {
            com.vivo.push.util.u.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(uVar.f()));
            String a10 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a10)) {
                hashMap.put("remoteAppId", a10);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f46360a, uVar.d());
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message " + uVar.d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            com.vivo.push.util.u.b(this.f46360a, "回收client通知成功, 上报埋点 1031, messageId = " + uVar.d());
            com.vivo.push.util.f.a(uVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message fail，messageId = " + uVar.d());
        com.vivo.push.util.u.c(this.f46360a, "回收client通知失败，messageId = " + uVar.d());
    }
}

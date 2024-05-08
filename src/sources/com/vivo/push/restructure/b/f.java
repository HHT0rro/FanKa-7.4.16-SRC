package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PushSystemRelyImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f implements b {
    @Override // com.vivo.push.util.o
    public final List<String> a(Context context) {
        k.a("findAllCoreClientPush");
        List<ResolveInfo> list = null;
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            u.d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT);
        } catch (Exception unused) {
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ResolveInfo resolveInfo = list.get(i10);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            u.d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }
}

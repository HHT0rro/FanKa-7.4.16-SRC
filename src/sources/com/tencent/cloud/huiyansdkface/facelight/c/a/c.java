package com.tencent.cloud.huiyansdkface.facelight.c.a;

import android.content.Context;
import android.content.Intent;
import com.huawei.quickcard.base.Attributes;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements com.tencent.cloud.huiyansdkface.a.a.g<String> {

    /* renamed from: a, reason: collision with root package name */
    private Context f40607a;

    public c(Context context) {
        this.f40607a = context;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String b(List<String> list, com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        if (!a()) {
            return null;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.b("PatchFocusModeSelector", "Gionee Phone set camera focus mode auto", new Object[0]);
        return (String) new com.tencent.cloud.huiyansdkface.a.a.b.g(Attributes.LayoutDirection.AUTO).b(list, dVar);
    }

    public boolean a() {
        Intent intent = new Intent();
        intent.setClassName("com.gionee.account", "com.gionee.account.activity.LoginActivity");
        return this.f40607a.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}

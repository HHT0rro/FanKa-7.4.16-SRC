package com.alibaba.security.realidentity.build;

import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.realidentity.build.j;

/* compiled from: GetWuaTokenApi.java */
@aw(a = "getWuaToken")
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class av extends aq {
    private static final int ao = 11;

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "getWuaToken";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        aq.am.execute(new Runnable() { // from class: com.alibaba.security.realidentity.build.av.1
            @Override // java.lang.Runnable
            public final void run() {
                Message obtain = Message.obtain();
                obtain.what = 11;
                obtain.obj = j.a.f3944a.f3901k.g();
                av.this.a(obtain);
            }
        });
        return true;
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final void b(Message message) {
        super.b(message);
        if (message.what == 11) {
            String str = (String) message.obj;
            if (!TextUtils.isEmpty(str)) {
                bf bfVar = new bf();
                bfVar.a(aq.f3120p, str);
                bfVar.f3165a = 1;
                if (RPLogging.isEnable()) {
                    RPLogging.d(aq.f3100a, "GetWuaTokenApi success: " + bfVar.a());
                }
                this.ak.b(bfVar);
                a(bfVar, true);
                return;
            }
            a(aq.a(this.ak), false);
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean b() {
        return true;
    }
}

package kc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.push.service.XMPushService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d0 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMPushService f50786a;

    public d0(XMPushService xMPushService) {
        this.f50786a = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        super.handleMessage(message);
        if (message != null) {
            try {
                int i10 = message.what;
                if (i10 == 17) {
                    Object obj = message.obj;
                    if (obj != null) {
                        this.f50786a.onStart((Intent) obj, XMPushService.f48159w);
                    }
                } else if (i10 == 18) {
                    Message obtain = Message.obtain((Handler) null, 0);
                    obtain.what = 18;
                    Bundle bundle = new Bundle();
                    str = this.f50786a.f48162d;
                    bundle.putString("xmsf_region", str);
                    obtain.setData(bundle);
                    message.replyTo.send(obtain);
                }
            } catch (Throwable unused) {
            }
        }
    }
}

package x8;

import android.content.Context;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import y8.f;
import y8.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements c {

    /* renamed from: x8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class RunnableC0839a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v8.a f54574b;

        public RunnableC0839a(v8.a aVar) {
            this.f54574b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f54574b, t8.b.C());
        }
    }

    @Override // x8.c
    public void a(Context context, BaseMode baseMode, IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            v8.a aVar = (v8.a) baseMode;
            y8.c.a("mcssdk-CallBackResultProcessor:" + aVar.toString());
            f.b(new RunnableC0839a(aVar));
        }
    }

    public final void b(v8.a aVar, t8.b bVar) {
        String str;
        if (aVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (bVar == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (bVar.I() != null) {
                int f10 = aVar.f();
                if (f10 == 12289) {
                    if (aVar.j() == 0) {
                        bVar.l(aVar.h());
                    }
                    bVar.I().onRegister(aVar.j(), aVar.h());
                    return;
                } else {
                    if (f10 == 12290) {
                        bVar.I().onUnRegister(aVar.j());
                        return;
                    }
                    if (f10 == 12298) {
                        bVar.I().onSetPushTime(aVar.j(), aVar.h());
                        return;
                    } else if (f10 == 12306) {
                        bVar.I().onGetPushStatus(aVar.j(), g.a(aVar.h()));
                        return;
                    } else {
                        if (f10 != 12309) {
                            return;
                        }
                        bVar.I().onGetNotificationStatus(aVar.j(), g.a(aVar.h()));
                        return;
                    }
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        y8.c.b(str);
    }
}

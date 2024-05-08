package t8;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.List;
import w8.c;
import y8.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: t8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class RunnableC0824a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f53769b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f53770c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IDataMessageCallBackService f53771d;

        public RunnableC0824a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
            this.f53769b = context;
            this.f53770c = intent;
            this.f53771d = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<BaseMode> b4 = c.b(this.f53769b, this.f53770c);
            if (b4 == null) {
                return;
            }
            for (BaseMode baseMode : b4) {
                if (baseMode != null) {
                    for (x8.c cVar : b.C().H()) {
                        if (cVar != null) {
                            cVar.a(this.f53769b, baseMode, this.f53771d);
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, Intent intent, IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            y8.c.b("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            y8.c.b("intent is null , please check param of parseIntent()");
        } else if (iDataMessageCallBackService == null) {
            y8.c.b("callback is null , please check param of parseIntent()");
        } else {
            f.a(new RunnableC0824a(context, intent, iDataMessageCallBackService));
        }
    }
}

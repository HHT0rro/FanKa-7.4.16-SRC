package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f4789a;

    public c(a aVar) {
        this.f4789a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0098a alertDialogC0098a;
        a.AlertDialogC0098a alertDialogC0098a2;
        Handler handler;
        a.AlertDialogC0098a alertDialogC0098a3;
        alertDialogC0098a = this.f4789a.f4779e;
        if (alertDialogC0098a != null) {
            alertDialogC0098a2 = this.f4789a.f4779e;
            if (alertDialogC0098a2.isShowing()) {
                try {
                    handler = this.f4789a.f4786l;
                    handler.removeMessages(1);
                    alertDialogC0098a3 = this.f4789a.f4779e;
                    alertDialogC0098a3.dismiss();
                } catch (Exception e2) {
                    com.alipay.sdk.util.c.a(e2);
                }
            }
        }
    }
}

package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f4788a;

    public b(a aVar) {
        this.f4788a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0098a alertDialogC0098a;
        a.AlertDialogC0098a alertDialogC0098a2;
        a.AlertDialogC0098a alertDialogC0098a3;
        Handler handler;
        a.AlertDialogC0098a alertDialogC0098a4;
        boolean z10;
        alertDialogC0098a = this.f4788a.f4779e;
        if (alertDialogC0098a == null) {
            a aVar = this.f4788a;
            a aVar2 = this.f4788a;
            aVar.f4779e = new a.AlertDialogC0098a(aVar2.f4780f);
            alertDialogC0098a4 = this.f4788a.f4779e;
            z10 = this.f4788a.f4785k;
            alertDialogC0098a4.setCancelable(z10);
        }
        try {
            alertDialogC0098a2 = this.f4788a.f4779e;
            if (alertDialogC0098a2.isShowing()) {
                return;
            }
            alertDialogC0098a3 = this.f4788a.f4779e;
            alertDialogC0098a3.show();
            handler = this.f4788a.f4786l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }
}

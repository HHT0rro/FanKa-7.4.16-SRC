package com.huawei.appgallery.marketinstallerservice.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.appgallery.marketinstallerservice.R$string;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: com.huawei.appgallery.marketinstallerservice.ui.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0259a {
        void a();

        void b();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC0259a f27647b;

        /* renamed from: c, reason: collision with root package name */
        public int f27648c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f27649d = true;

        public b(InterfaceC0259a interfaceC0259a, int i10) {
            this.f27647b = interfaceC0259a;
            this.f27648c = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            InterfaceC0259a interfaceC0259a;
            if (i10 != -1 || (interfaceC0259a = this.f27647b) == null) {
                return;
            }
            int i11 = this.f27648c;
            if (i11 == -3 || i11 == -2) {
                interfaceC0259a.a();
                this.f27649d = false;
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            InterfaceC0259a interfaceC0259a = this.f27647b;
            if (interfaceC0259a == null || !this.f27649d) {
                return;
            }
            interfaceC0259a.b();
        }
    }

    public static AlertDialog a(Context context, int i10, InterfaceC0259a interfaceC0259a, String str) {
        int i11;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        b bVar = new b(interfaceC0259a, i10);
        if (str == null) {
            str = "";
        }
        if (i10 != -4) {
            if (i10 != -3) {
                if (i10 == -2) {
                    builder.setMessage(context.getResources().getString(R$string.market_install_market_failed, str));
                    i11 = R$string.market_install_retry_download;
                }
                return builder.create();
            }
            builder.setMessage(context.getResources().getString(R$string.market_install_download_failed));
            i11 = R$string.market_install_retry;
            builder.setPositiveButton(i11, bVar);
            builder.setNegativeButton(R$string.market_install_cancel, (DialogInterface.OnClickListener) null);
        } else {
            builder.setMessage(context.getResources().getString(R$string.market_install_can_not_get_market_info, str));
            builder.setPositiveButton(R$string.market_install_alert_dialog_ok, (DialogInterface.OnClickListener) null);
        }
        builder.setOnDismissListener(bVar);
        return builder.create();
    }
}

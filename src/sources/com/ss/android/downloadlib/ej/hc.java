package com.ss.android.downloadlib.ej;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.dk;
import com.ss.android.socialbase.appdownloader.ej.c;
import com.ss.android.socialbase.appdownloader.ej.ve;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class hc extends com.ss.android.socialbase.appdownloader.ej.m {

    /* renamed from: m, reason: collision with root package name */
    private static String f38746m = "hc";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m implements c {

        /* renamed from: m, reason: collision with root package name */
        private Dialog f38751m;

        public m(Dialog dialog) {
            if (dialog != null) {
                this.f38751m = dialog;
                m();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.ej.c
        public boolean dk() {
            Dialog dialog = this.f38751m;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.ej.c
        public void m() {
            Dialog dialog = this.f38751m;
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.m, com.ss.android.socialbase.appdownloader.ej.ej
    public ve m(Context context) {
        return new ve(context) { // from class: com.ss.android.downloadlib.ej.hc.1
            private dk.m ej;

            /* renamed from: l, reason: collision with root package name */
            private DialogInterface.OnClickListener f38747l;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ Context f38748m;

            /* renamed from: n, reason: collision with root package name */
            private DialogInterface.OnCancelListener f38749n;
            private DialogInterface.OnClickListener np;

            {
                this.f38748m = context;
                this.ej = new dk.m(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public ve dk(int i10, DialogInterface.OnClickListener onClickListener) {
                this.ej.l(this.f38748m.getResources().getString(i10));
                this.np = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public ve m(int i10) {
                this.ej.m(this.f38748m.getResources().getString(i10));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public ve m(String str) {
                this.ej.dk(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public ve m(int i10, DialogInterface.OnClickListener onClickListener) {
                this.ej.ej(this.f38748m.getResources().getString(i10));
                this.f38747l = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public ve m(DialogInterface.OnCancelListener onCancelListener) {
                this.f38749n = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public ve m(boolean z10) {
                this.ej.m(z10);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.ej.ve
            public c m() {
                this.ej.m(new dk.InterfaceC0572dk() { // from class: com.ss.android.downloadlib.ej.hc.1.1
                    @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
                    public void dk(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.np != null) {
                            AnonymousClass1.this.np.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
                    public void ej(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f38749n == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f38749n.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.dk.InterfaceC0572dk
                    public void m(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f38747l != null) {
                            AnonymousClass1.this.f38747l.onClick(dialogInterface, -1);
                        }
                    }
                });
                com.ss.android.downloadlib.hc.c.m(hc.f38746m, "getThemedAlertDlgBuilder", null);
                this.ej.m(3);
                return new m(com.ss.android.downloadlib.addownload.c.ej().dk(this.ej.m()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.m, com.ss.android.socialbase.appdownloader.ej.ej
    public boolean m() {
        return true;
    }
}

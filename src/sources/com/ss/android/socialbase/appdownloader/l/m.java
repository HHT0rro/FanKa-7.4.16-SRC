package com.ss.android.socialbase.appdownloader.l;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.ej.c;
import com.ss.android.socialbase.appdownloader.ej.ve;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m extends com.ss.android.socialbase.appdownloader.ej.dk {

    /* renamed from: m, reason: collision with root package name */
    private AlertDialog.Builder f38890m;

    /* renamed from: com.ss.android.socialbase.appdownloader.l.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0589m implements c {

        /* renamed from: m, reason: collision with root package name */
        private AlertDialog f38891m;

        public C0589m(AlertDialog.Builder builder) {
            if (builder != null) {
                this.f38891m = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.ej.c
        public boolean dk() {
            AlertDialog alertDialog = this.f38891m;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.ej.c
        public void m() {
            AlertDialog alertDialog = this.f38891m;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public m(Context context) {
        this.f38890m = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.ve
    public ve dk(int i10, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f38890m;
        if (builder != null) {
            builder.setNegativeButton(i10, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.ve
    public ve m(int i10) {
        AlertDialog.Builder builder = this.f38890m;
        if (builder != null) {
            builder.setTitle(i10);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.ve
    public ve m(String str) {
        AlertDialog.Builder builder = this.f38890m;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.ve
    public ve m(int i10, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.f38890m;
        if (builder != null) {
            builder.setPositiveButton(i10, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.ve
    public ve m(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.f38890m;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.ej.ve
    public c m() {
        return new C0589m(this.f38890m);
    }
}

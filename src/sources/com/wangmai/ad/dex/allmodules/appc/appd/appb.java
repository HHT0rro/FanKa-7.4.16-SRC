package com.wangmai.ad.dex.allmodules.appc.appd;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import appa.appa.appf.appd;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: InterstialDialogNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb extends Dialog {

    /* renamed from: appa, reason: collision with root package name */
    private View f46737appa;

    public appb(Context context, int i10, View view) {
        super(context, i10);
        this.f46737appa = view;
        appb();
    }

    void appa() {
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            getWindow().clearFlags(512);
        } catch (Throwable th) {
            appd.appe("InterstialDialogNew", "quitFullScreen error:" + th.toString());
        }
    }

    void appb() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
                getWindow().setFlags(1024, 1024);
                getWindow().setBackgroundDrawable(new ColorDrawable());
                getWindow().setBackgroundDrawableResource(17170445);
                getWindow().getDecorView().setSystemUiVisibility(4);
                getWindow().getDecorView().setSystemUiVisibility(1280);
            }
        } catch (Throwable th) {
            appd.appe("InterstialDialogNew", "setFullScreen error:" + th.toString());
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        try {
            if (this.f46737appa != null) {
                appa.appa.appf.appb.appb(this.f46737appa);
                this.f46737appa.destroyDrawingCache();
                this.f46737appa = null;
            }
            appa();
        } catch (Throwable th) {
            appd.appe("InterstialDialogNew", "dismiss:" + th.toString());
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f46737appa);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            keyEvent.getAction();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }
}

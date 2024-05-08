package com.wangmai.ad.dex.allmodules.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: DownLoadDialog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appl extends Dialog {

    /* renamed from: appa, reason: collision with root package name */
    private Context f46852appa;
    private View appb;
    private int appc;
    private int appd;
    private OrientationEventListener appe;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DownLoadDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa extends OrientationEventListener {
        appa(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            appl.this.appa(i10);
        }
    }

    public appl(Activity activity, int i10, View view) {
        super(activity, i10);
        this.f46852appa = activity;
        this.appb = view;
        setOwnerActivity(activity);
        this.appc = this.f46852appa.getResources().getConfiguration().orientation;
        this.appe = new appa(activity);
    }

    public void appa(int i10) {
        try {
            this.appc = this.f46852appa.getResources().getConfiguration().orientation;
            if (i10 == 0) {
                this.appc = 1;
            } else if (i10 == 90 || i10 == 180 || i10 == 270) {
                this.appc = 2;
            }
            if (this.appc != this.appd) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.System.getInt(this.f46852appa.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            appa();
                        }
                    } catch (Throwable unused) {
                        appa();
                    }
                } else {
                    appa();
                }
            }
            this.appd = this.appc;
        } catch (Throwable unused2) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        try {
            if (this.appe != null) {
                this.appe.disable();
            }
            if (this.appb == null || !(this.appb.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) this.appb.getParent()).removeView(this.appb);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appe.enable();
        setContentView(this.appb);
        appa();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            keyEvent.getAction();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    private void appa() {
        try {
            Window window = getWindow();
            if (Build.VERSION.SDK_INT >= 21) {
                window.getDecorView().setClipToOutline(false);
            }
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

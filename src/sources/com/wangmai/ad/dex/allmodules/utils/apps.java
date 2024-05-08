package com.wangmai.ad.dex.allmodules.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.wangmai.common.Ilistener.XAdRewardVideoListener;
import com.wangmai.common.utils.Utils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: RewardDialog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class apps extends Dialog {

    /* renamed from: appa, reason: collision with root package name */
    private Context f46860appa;
    private View appb;
    private int appc;
    private int appd;
    private OrientationEventListener appe;
    private XAdRewardVideoListener appf;
    private boolean appg;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: RewardDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa extends OrientationEventListener {
        appa(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            apps.this.appa(i10);
        }
    }

    public apps(Context context, View view, boolean z10, XAdRewardVideoListener xAdRewardVideoListener) {
        super(context, 16973834);
        setOwnerActivity((Activity) context);
        this.f46860appa = context;
        this.appb = view;
        this.appf = xAdRewardVideoListener;
        this.appg = z10;
        this.appc = this.f46860appa.getResources().getConfiguration().orientation;
        Utils.getWindowWidth(this.f46860appa);
        Utils.getWindowHeight(this.f46860appa);
        this.appe = new appa(context);
    }

    public void appa(int i10) {
        try {
            this.appc = this.f46860appa.getResources().getConfiguration().orientation;
            if (i10 == 0) {
                this.appc = 1;
            } else if (i10 == 90 || i10 == 180 || i10 == 270) {
                this.appc = 2;
            }
            if (this.appc != this.appd) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (Settings.System.getInt(this.f46860appa.getContentResolver(), "accelerometer_rotation", 0) == 1) {
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
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("RewardDialog", "onOrientationChanged:" + th.toString());
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
            appa.appa.appf.appd.appe("RewardDialog", "dismiss:" + th.toString());
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appe.enable();
        setContentView(this.appb);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent.getAction() == 0 && this.appg) {
            try {
                if (this.appf != null) {
                    this.appf.onAdClose();
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("RewardDialog", "onKeyDown:" + th.toString());
            }
            dismiss();
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            appa();
        }
    }

    private void appa() {
        try {
            Window window = getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setBackgroundColor(-1);
            if (this.appb != null) {
                ViewGroup.LayoutParams layoutParams = this.appb.getLayoutParams();
                layoutParams.width = attributes.width;
                layoutParams.height = attributes.height;
                this.appb.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("RewardDialog", "resetLayout:" + th.toString());
        }
    }
}

package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import com.kwad.sdk.k;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class d extends AlertDialog {
    public Activity mActivity;
    public final Context mContext;
    public ViewGroup zg;

    public d(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = l.wrapContextIfNeed(activity);
    }

    public float cj() {
        return -1.0f;
    }

    public ViewGroup ck() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            l.h(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        T t2 = (T) this.zg.findViewById(i10);
        return t2 != null ? t2 : (T) super.findViewById(i10);
    }

    public abstract void g(View view);

    @LayoutRes
    public abstract int getLayoutId();

    public boolean ns() {
        return false;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.zg = (ViewGroup) l.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.zg = ck();
            }
            setContentView(this.zg);
            setCanceledOnTouchOutside(ns());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (cj() != -1.0f) {
                attributes.dimAmount = cj();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            g(this.zg);
        } catch (Throwable th) {
            if (k.zd().yp()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                dismiss();
                return;
            }
            throw th;
        }
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        super.setContentView(i10);
        this.zg = (ViewGroup) l.inflate(this.mContext, i10, null);
    }
}

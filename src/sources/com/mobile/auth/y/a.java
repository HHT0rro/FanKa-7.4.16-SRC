package com.mobile.auth.y;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.mobile.auth.gatewayauth.AuthUIConfig;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.utils.k;
import com.nirvana.tools.core.AppUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f37676a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f37677b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f37678c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f37679d;

    /* renamed from: e, reason: collision with root package name */
    private AuthUIConfig f37680e;

    public a(@NonNull Context context, int i10) {
        super(context, i10);
        this.f37676a = context;
    }

    public a(@NonNull Context context, AuthUIConfig authUIConfig) {
        this(context, AppUtils.getResID(context, "authsdk_loading_dialog", "style"));
        this.f37680e = authUIConfig;
    }

    private void a() {
        LinearLayout linearLayout;
        try {
            setContentView(AppUtils.getResID(getContext(), "authsdk_loading_dialog_layout", "layout"));
            setCancelable(false);
            this.f37678c = (ImageView) findViewById(AppUtils.getResID(getContext(), "authsdk_iv_loading", "id"));
            this.f37679d = (LinearLayout) findViewById(AppUtils.getResID(getContext(), "authsdk_lly_loading", "id"));
            Drawable loadingImgDrawable = this.f37680e.getLoadingImgDrawable();
            if (loadingImgDrawable == null) {
                Drawable c4 = k.c(getContext(), this.f37680e.getLoadingImgPath());
                if (c4 != null) {
                    this.f37678c.setImageDrawable(c4);
                }
                this.f37677b = AnimationUtils.loadAnimation(this.f37676a, AppUtils.getResID(getContext(), "authsdk_anim_loading", "anim"));
                this.f37677b.setInterpolator(new LinearInterpolator());
                this.f37678c.startAnimation(this.f37677b);
            } else {
                this.f37678c.setImageDrawable(loadingImgDrawable);
            }
            Drawable loadingBackgroundDrawable = this.f37680e.getLoadingBackgroundDrawable();
            if (loadingBackgroundDrawable == null) {
                loadingBackgroundDrawable = k.c(getContext(), this.f37680e.getLoadingBackgroundPath());
                if (loadingBackgroundDrawable == null) {
                    return;
                } else {
                    linearLayout = this.f37679d;
                }
            } else {
                linearLayout = this.f37679d;
            }
            linearLayout.setBackgroundDrawable(loadingBackgroundDrawable);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            Animation animation = this.f37677b;
            if (animation != null) {
                animation.cancel();
            }
            super.dismiss();
            this.f37680e = null;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            a();
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            Animation animation = this.f37677b;
            if (animation != null) {
                animation.start();
                this.f37678c.startAnimation(this.f37677b);
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
        }
    }
}

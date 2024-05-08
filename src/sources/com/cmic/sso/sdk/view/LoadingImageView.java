package com.cmic.sso.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LoadingImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Animation f11458a;

    /* renamed from: b, reason: collision with root package name */
    private LinearInterpolator f11459b;

    public LoadingImageView(Context context) {
        super(context);
        this.f11458a = null;
        this.f11459b = null;
        a();
    }

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11458a = null;
        this.f11459b = null;
        a();
    }

    public LoadingImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11458a = null;
        this.f11459b = null;
        a();
    }

    public void a() {
        this.f11458a = AnimationUtils.loadAnimation(getContext(), g.c(getContext(), "umcsdk_anim_loading"));
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f11459b = linearInterpolator;
        this.f11458a.setInterpolator(linearInterpolator);
    }
}

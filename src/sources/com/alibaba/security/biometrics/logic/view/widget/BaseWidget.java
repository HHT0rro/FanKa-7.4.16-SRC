package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.alibaba.security.biometrics.build.x;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.skin.model.ButtonSkinData;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.biometrics.skin.model.ImageViewSkinData;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseWidget extends RelativeLayout implements x {

    /* renamed from: a, reason: collision with root package name */
    public ALBiometricsActivityParentView.a f2487a;

    /* renamed from: b, reason: collision with root package name */
    private RPSkinManager f2488b;

    public BaseWidget(Context context) {
        super(context);
        this.f2488b = RPSkinManager.getInstance();
    }

    private void h() {
        this.f2488b = RPSkinManager.getInstance();
    }

    public final ImageViewSkinData a(String str) {
        return (ImageViewSkinData) this.f2488b.getNativeSkinData(getSkinParentKey(), str, ImageViewSkinData.class);
    }

    public abstract void a();

    public final NavigatorSkinData b(String str) {
        return (NavigatorSkinData) this.f2488b.getNativeSkinData(getSkinParentKey(), str, NavigatorSkinData.class);
    }

    public abstract void b();

    public final ButtonSkinData c(String str) {
        return (ButtonSkinData) this.f2488b.getNativeSkinData(getSkinParentKey(), str, ButtonSkinData.class);
    }

    public abstract void c();

    public final TextViewSkinData d(String str) {
        return (TextViewSkinData) this.f2488b.getNativeSkinData(getSkinParentKey(), str, TextViewSkinData.class);
    }

    public void d() {
    }

    public final DetectAnimSkinData e(String str) {
        return (DetectAnimSkinData) this.f2488b.getNativeSkinData(getSkinParentKey(), str, DetectAnimSkinData.class);
    }

    public final ControlSkinData f(String str) {
        return (ControlSkinData) this.f2488b.getNativeSkinData(getSkinParentKey(), str, ControlSkinData.class);
    }

    @Override // com.alibaba.security.biometrics.build.x
    public final boolean g() {
        return getVisibility() == 0;
    }

    public abstract String getSkinParentKey();

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
        b();
    }

    public void setOnBioMainHandlerListener(ALBiometricsActivityParentView.a aVar) {
        this.f2487a = aVar;
    }

    @Override // com.alibaba.security.biometrics.build.x
    public final void e() {
        b();
        setVisibility(0);
    }

    @Override // com.alibaba.security.biometrics.build.x
    public final void f() {
        c();
        setVisibility(8);
    }

    public BaseWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2488b = RPSkinManager.getInstance();
    }

    public BaseWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2488b = RPSkinManager.getInstance();
    }
}

package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.ae;
import com.alibaba.security.biometrics.build.w;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.utils.notch.NotchUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GuideWidget extends AbsGuideWidget {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2527b = "GuideWidget";

    /* renamed from: c, reason: collision with root package name */
    private Button f2528c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f2529d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f2530e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f2531f;

    public GuideWidget(Context context) {
        super(context);
    }

    private static void h() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.f2530e = (LinearLayout) findViewById(R.id.contentContainer);
        this.f2529d = (TextView) findViewById(R.id.tvGuideTip);
        this.f2528c = (Button) findViewById(R.id.btnStartVerify);
        this.f2531f = (FrameLayout) findViewById(R.id.bannerContainer);
        this.f2528c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.GuideWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideWidget.this.setVisibility(8);
                ALBiometricsActivityParentView.a aVar = GuideWidget.this.f2487a;
                if (aVar != null) {
                    aVar.d();
                }
            }
        });
        this.f2529d.setText(Html.fromHtml(getResources().getString(R.string.identity_guide_tip)));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        w.a(this.f2528c, c("mainButton"));
        FrameLayout frameLayout = this.f2531f;
        ControlSkinData f10 = f("bannerControl");
        if (f10 == null || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(ae.a(f10.getBackgroundColor(), 17170450));
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void d() {
        RelativeLayout.LayoutParams layoutParams;
        super.d();
        if (NotchUtils.getStatusBarHeight(getContext()) <= 0 || (layoutParams = (RelativeLayout.LayoutParams) this.f2530e.getLayoutParams()) == null) {
            return;
        }
        layoutParams.setMargins(0, NotchUtils.getStatusBarHeight(getContext()), 0, 0);
        this.f2530e.setLayoutParams(layoutParams);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return "welcomePage";
    }

    public GuideWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

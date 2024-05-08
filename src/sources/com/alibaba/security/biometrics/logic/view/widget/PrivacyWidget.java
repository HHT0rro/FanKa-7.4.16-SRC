package com.alibaba.security.biometrics.logic.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.build.w;
import com.alibaba.security.common.track.model.TrackConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PrivacyWidget extends BaseWidget {

    /* renamed from: b, reason: collision with root package name */
    private Button f2537b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f2538c;

    public PrivacyWidget(Context context) {
        super(context);
    }

    private static void h() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void a() {
        this.f2537b = (Button) findViewById(R.id.btnAgree);
        this.f2538c = (ImageView) findViewById(R.id.ivLogoView);
        this.f2537b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.PrivacyWidget.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrivacyWidget privacyWidget = PrivacyWidget.this;
                if (privacyWidget.f2487a != null) {
                    privacyWidget.setVisibility(8);
                    PrivacyWidget.this.f2487a.e();
                }
            }
        });
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void b() {
        w.a(this.f2537b, c("mainButton"));
        w.a(this.f2538c, a("logoImageView"), R.drawable.rp_face_privacy_logo);
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public final void c() {
    }

    @Override // com.alibaba.security.biometrics.logic.view.widget.BaseWidget
    public String getSkinParentKey() {
        return TrackConstants.Method.PRIVACY_PAGE;
    }

    public PrivacyWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PrivacyWidget(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

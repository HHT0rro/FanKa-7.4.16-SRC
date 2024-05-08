package com.huawei.openalliance.ad.compliance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gi;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.y;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ComplianceView extends PPSBaseDialogContentView {

    /* renamed from: e, reason: collision with root package name */
    private static final String f32174e = "ComplianceView";

    /* renamed from: m, reason: collision with root package name */
    private static String f32175m = ", ";

    /* renamed from: f, reason: collision with root package name */
    private View f32176f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f32177g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f32178h;

    /* renamed from: i, reason: collision with root package name */
    private AdContentData f32179i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f32180j;

    /* renamed from: k, reason: collision with root package name */
    private gi f32181k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f32182l;

    public ComplianceView(Context context) {
        super(context);
    }

    public ComplianceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ComplianceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void B() {
        TextView textView;
        if (!v.d(getContext()) || (textView = this.f32177g) == null || this.f32180j == null) {
            return;
        }
        textView.setTextSize(1, 28.0f);
        this.f32180j.setTextSize(1, 28.0f);
    }

    private void I() {
        if (this.f32176f == null || this.f32178h == null) {
            gl.V(f32174e, "partingLine or whyThisAdClick view not init");
            return;
        }
        Boolean bool = this.f32745c;
        if (bool != null && !bool.booleanValue()) {
            gl.V(f32174e, "not need show why this ad");
            return;
        }
        this.f32176f.setVisibility(0);
        this.f32178h.setVisibility(0);
        this.f32178h.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.compliance.ComplianceView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ComplianceView.this.f32179i != null) {
                    v.Code(ComplianceView.this.getContext(), ComplianceView.this.f32179i.W());
                    if (ComplianceView.this.f32181k != null) {
                        ComplianceView.this.f32181k.Code();
                    }
                }
            }
        });
    }

    private void Z() {
        String value;
        AdContentData adContentData = this.f32179i;
        if (adContentData != null) {
            List<AdvertiserInfo> aG = adContentData.aG();
            StringBuffer stringBuffer = new StringBuffer();
            if (aa.Code(aG)) {
                gl.V(f32174e, "complianceInfo is null");
                return;
            }
            for (int i10 = 0; i10 < aG.size(); i10++) {
                if (i10 != aG.size() - 1) {
                    stringBuffer.append(aG.get(i10).getValue());
                    value = f32175m;
                } else {
                    value = aG.get(i10).getValue();
                }
                stringBuffer.append(value);
            }
            TextView textView = this.f32177g;
            if (textView != null) {
                textView.setText(stringBuffer);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        try {
            gl.V(f32174e, "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f32743a), Integer.valueOf(this.f32744b));
            if (V()) {
                this.V.setPadding(this.f32743a, 0, this.f32744b, 0);
                this.V.requestLayout();
                this.V.getViewTreeObserver().addOnGlobalLayoutListener(this.f32746d);
            }
        } catch (Throwable th) {
            gl.I(f32174e, "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_compliance_choice_view, this);
        this.V = inflate.findViewById(R.id.compliance_view_root);
        this.f32176f = inflate.findViewById(R.id.why_this_ad_line);
        this.f32177g = (TextView) inflate.findViewById(R.id.compliance_info);
        this.f32178h = (RelativeLayout) inflate.findViewById(R.id.why_this_ad_btn);
        this.I = inflate.findViewById(R.id.compliance_scrollview);
        this.f32180j = (TextView) inflate.findViewById(R.id.why_this_ad_tv);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        this.f32182l = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (ay.I()) {
                this.f32182l.setImageBitmap(y.V(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.f32179i = adContentData;
        I();
        Z();
        Code();
        B();
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setViewClickListener(gi giVar) {
        this.f32181k = giVar;
    }
}

package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.ey;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.y;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSplashLabelView extends PPSLabelView {
    private hg B;
    private Integer C;
    private View.OnClickListener F;
    private Integer S;

    public PPSSplashLabelView(Context context) {
        super(context);
        this.F = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ey.Code(PPSSplashLabelView.this.getContext()).Code();
                eo.Code(PPSSplashLabelView.this.getContext());
                Intent intent = new Intent();
                intent.setAction(u.ag);
                intent.setPackage(v.Z(PPSSplashLabelView.this.getContext()));
                PPSSplashLabelView pPSSplashLabelView = PPSSplashLabelView.this;
                intent.putExtra(ax.ah, pPSSplashLabelView.Code(pPSSplashLabelView.C.intValue()));
                if (!(PPSSplashLabelView.this.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ay.Code(PPSSplashLabelView.this.getContext(), intent);
                if (PPSSplashLabelView.this.B != null) {
                    PPSSplashLabelView.this.B.B();
                }
            }
        };
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ey.Code(PPSSplashLabelView.this.getContext()).Code();
                eo.Code(PPSSplashLabelView.this.getContext());
                Intent intent = new Intent();
                intent.setAction(u.ag);
                intent.setPackage(v.Z(PPSSplashLabelView.this.getContext()));
                PPSSplashLabelView pPSSplashLabelView = PPSSplashLabelView.this;
                intent.putExtra(ax.ah, pPSSplashLabelView.Code(pPSSplashLabelView.C.intValue()));
                if (!(PPSSplashLabelView.this.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ay.Code(PPSSplashLabelView.this.getContext(), intent);
                if (PPSSplashLabelView.this.B != null) {
                    PPSSplashLabelView.this.B.B();
                }
            }
        };
    }

    public PPSSplashLabelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.F = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashLabelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ey.Code(PPSSplashLabelView.this.getContext()).Code();
                eo.Code(PPSSplashLabelView.this.getContext());
                Intent intent = new Intent();
                intent.setAction(u.ag);
                intent.setPackage(v.Z(PPSSplashLabelView.this.getContext()));
                PPSSplashLabelView pPSSplashLabelView = PPSSplashLabelView.this;
                intent.putExtra(ax.ah, pPSSplashLabelView.Code(pPSSplashLabelView.C.intValue()));
                if (!(PPSSplashLabelView.this.getContext() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                ay.Code(PPSSplashLabelView.this.getContext(), intent);
                if (PPSSplashLabelView.this.B != null) {
                    PPSSplashLabelView.this.B.B();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Code(int i10) {
        Integer a10 = v.a(getContext());
        if (v.I()) {
            return i10;
        }
        if (a10 != null && a10.intValue() >= 30454100) {
            return i10;
        }
        gl.V("PPSSplashLabelView", "HMS version is low, interactMode is %s", Integer.valueOf(i10));
        if (i10 == 4) {
            i10 = 1;
        }
        if (i10 == 3) {
            return 2;
        }
        return i10;
    }

    private SpannableStringBuilder Code(SpannableString spannableString) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
        ImageSpan clickImageSpan = getClickImageSpan();
        if (clickImageSpan != null) {
            spannableStringBuilder.setSpan(clickImageSpan, spannableString.length() - 1, spannableString.length(), 33);
        }
        return spannableStringBuilder;
    }

    private ImageSpan getClickImageSpan() {
        try {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_chevron_right);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (!ay.I()) {
                return new b(drawable, 2, v.V(getContext(), 4.0f), 0);
            }
            return new b(getContext(), y.V(drawable), 2, v.V(getContext(), 4.0f), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void setClick(SpannableStringBuilder spannableStringBuilder) {
        if (!PPSSplashAdSourceView.Code(getContext(), this.C, this.S)) {
            setText(spannableStringBuilder);
            return;
        }
        spannableStringBuilder.append(" ");
        setText(Code(new SpannableString(spannableStringBuilder)));
        setOnClickListener(this.F);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void Code(AdSource adSource, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (adSource == null) {
            gl.V("PPSSplashLabelView", "adSource is null");
            setClick(spannableStringBuilder);
            return;
        }
        String V = au.V(adSource.Code()) == null ? "" : au.V(adSource.Code());
        if (str == null) {
            str = "";
        }
        String str2 = V + str;
        String V2 = adSource.V();
        if (TextUtils.isEmpty(V) && TextUtils.isEmpty(V2)) {
            setClick(spannableStringBuilder);
        } else if (TextUtils.isEmpty(V) || !TextUtils.isEmpty(V2)) {
            Code(str2, V2);
        } else {
            setClick(new SpannableStringBuilder(str2));
        }
    }

    public void Code(AdSource adSource, String str, Integer num, Integer num2, hg hgVar) {
        this.C = num;
        this.S = num2;
        this.B = hgVar;
        Code(adSource, str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            boolean z10 = !TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            ImageSpan Code = Code(drawable, z10);
            if (Code != null) {
                spannableStringBuilder.setSpan(Code, 0, 1, 33);
            }
            setClick(spannableStringBuilder);
        } catch (Throwable unused) {
            gl.I("PPSSplashLabelView", "setTextWhenImgLoaded error");
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSLabelView
    public void setTextWhenImgLoadFail(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        setClick(spannableStringBuilder);
    }
}

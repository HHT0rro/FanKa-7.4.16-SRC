package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.views.a;
import com.huawei.openalliance.ad.views.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dl extends dk {
    public int I;
    public int Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends c {
        public a(Context context, int i10) {
            super(context);
            Resources resources = context.getResources();
            a.C0341a c0341a = this.V;
            int i11 = R.drawable.hiad_native_tpt_list_page_btn;
            c0341a.Code(resources.getDrawable(i11));
            this.V.V(i10);
            this.V.Code(resources.getColor(R.color.hiad_down_btn_normal));
            this.I.Code(resources.getDrawable(i11));
            this.I.V(i10);
            this.I.Code(resources.getColor(R.color.hiad_down_btn_process));
            this.Z.Code(resources.getDrawable(i11));
            this.Z.V(i10);
            this.Z.Code(resources.getColor(R.color.hiad_down_btn_installing));
        }
    }

    public dl(Context context, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        super(context, appDownloadButton);
        this.I = (int) context.getResources().getDimension(R.dimen.hiad_12_dp);
        this.Z = (int) context.getResources().getDimension(R.dimen.hiad_6_dp);
    }

    @Override // com.huawei.hms.ads.dk
    public void Code() {
        this.V.setAppDownloadButtonStyle(new a(this.Code, this.I));
    }

    @Override // com.huawei.hms.ads.dk
    public void Code(String str) {
        this.V.setMinWidth((int) this.Code.getResources().getDimension(R.dimen.hiad_64_dp));
        this.V.setPadding(0, 0, 0, this.Z);
        this.V.setFontFamily(com.huawei.openalliance.ad.constant.u.cS);
        this.V.setTextSize(this.I);
        this.V.setTextColor(this.Code.getResources().getColor(R.color.hiad_down_btn_normal));
        this.V.setBackground(this.Code.getResources().getDrawable(R.drawable.hiad_native_tpt_list_page_btn));
        if (TextUtils.isEmpty(str)) {
            this.V.setText(this.Code.getString(R.string.hiad_detail));
        } else {
            this.V.setText(str);
        }
    }

    @Override // com.huawei.hms.ads.dk
    public void V(Context context) {
        this.V.setMinWidth((int) context.getResources().getDimension(R.dimen.hiad_64_dp));
        this.V.setPadding(0, 0, 0, this.Z);
        this.V.setFontFamily(com.huawei.openalliance.ad.constant.u.cS);
        this.V.setTextSize(this.I);
        this.V.setVisibility(0);
    }
}

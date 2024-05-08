package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.ca;
import com.huawei.hms.ads.cb;
import com.huawei.hms.ads.cc;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.ct;
import com.huawei.hms.ads.cu;
import com.huawei.hms.ads.cv;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.a;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DTAppDownloadButton extends AppDownloadButton implements com.huawei.hms.ads.template.view.a {
    private cd B;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends com.huawei.openalliance.ad.views.a {
        public a(Context context) {
            super(context);
        }

        public a.C0341a Code(Context context) {
            return this.V;
        }

        @Override // com.huawei.openalliance.ad.views.a
        public a.C0341a Code(Context context, k kVar) {
            return Code(context);
        }
    }

    @GlobalApi
    public DTAppDownloadButton(Context context) {
        super(context);
        Code(context);
    }

    @GlobalApi
    public DTAppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context);
        Code(context);
        if (attributeSet != null) {
            cd cdVar = new cd(this);
            this.B = cdVar;
            cdVar.Code((cj) new ct(this));
            this.B.Code((cj) new ca(this));
            this.B.Code((cj) new cb(this));
            this.B.Code((cj) new cv(this));
            this.B.Code((cj) new cu(this));
            this.B.Code((cj) new cc(this));
            this.B.Code(attributeSet);
        }
    }

    private void Code(Context context) {
        setIsSetProgressDrawable(false);
        setAppDownloadButtonStyle(new a(context));
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cd cdVar = this.B;
        if (cdVar != null) {
            cdVar.Code(jSONObject);
        }
    }
}

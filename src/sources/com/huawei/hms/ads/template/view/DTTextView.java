package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cd;
import com.huawei.hms.ads.ci;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.cm;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.co;
import com.huawei.hms.ads.cp;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.cz;
import com.huawei.hms.ads.da;
import com.huawei.hms.ads.db;
import com.huawei.hms.ads.dc;
import com.huawei.hms.ads.dd;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DTTextView extends TextView implements a {
    private cd Code;

    @GlobalApi
    public DTTextView(Context context) {
        super(context);
    }

    @GlobalApi
    public DTTextView(Context context, AttributeSet attributeSet) {
        this(context);
        if (attributeSet != null) {
            cd cdVar = new cd(this);
            this.Code = cdVar;
            cdVar.Code((cj) new db(this));
            this.Code.Code((cj) new cn(this));
            this.Code.Code((cj) new ci(this));
            this.Code.Code((cj) new cm(this));
            this.Code.Code((cj) new cy(this));
            this.Code.Code((cj) new cz(this));
            this.Code.Code((cj) new dc(this));
            this.Code.Code((cj) new da(this));
            this.Code.Code((cj) new dd(this));
            this.Code.Code((cj) new co(this));
            this.Code.Code((cj) new cp(this));
            this.Code.Code(attributeSet);
        }
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cd cdVar = this.Code;
        if (cdVar != null) {
            cdVar.Code(jSONObject);
        }
    }
}

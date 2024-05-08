package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cd;
import com.huawei.openalliance.ad.views.NativeVideoView;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DTNativeVideoView extends NativeVideoView implements a {
    private cd S;

    @GlobalApi
    public DTNativeVideoView(Context context) {
        super(context);
    }

    @GlobalApi
    public DTNativeVideoView(Context context, AttributeSet attributeSet) {
        super(context);
        cd cdVar = new cd(this);
        this.S = cdVar;
        cdVar.Code(attributeSet);
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cd cdVar = this.S;
        if (cdVar != null) {
            cdVar.Code(jSONObject);
        }
    }
}

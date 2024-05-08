package com.huawei.hms.ads;

import android.util.AttributeSet;
import android.view.View;
import com.huawei.quickcard.base.Attributes;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ch extends cq<View> {
    private ce I;
    private ce V;

    public ch(View view) {
        super(view);
        this.V = new ce(view);
        this.I = new ce(view);
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue(null, Attributes.Style.BACKGROUND);
        String attributeValue2 = attributeSet.getAttributeValue(null, "defaultBackground");
        if (this.V.Code(attributeValue)) {
            return;
        }
        this.V = null;
        this.I.Code(attributeValue2);
    }

    @Override // com.huawei.hms.ads.cq, com.huawei.hms.ads.cf
    public void Code(JSONObject jSONObject) {
        ce ceVar = this.V;
        if (ceVar != null) {
            ceVar.Code(jSONObject);
        }
        ce ceVar2 = this.I;
        if (ceVar2 != null) {
            ceVar2.Code(jSONObject);
        }
    }
}

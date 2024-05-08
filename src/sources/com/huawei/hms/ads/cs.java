package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cs extends cq {
    public cs(View view) {
        super(view);
    }

    @Override // com.huawei.hms.ads.cj
    public void Code(AttributeSet attributeSet) {
        V v2 = this.Code;
        if (v2 == 0 || attributeSet == null) {
            return;
        }
        Context context = v2.getContext();
        String attributeValue = attributeSet.getAttributeValue(null, "padding");
        if (!TextUtils.isEmpty(attributeValue)) {
            int Code = com.huawei.hms.ads.template.util.a.Code(attributeValue, context);
            this.Code.setPadding(Code, Code, Code, Code);
        }
        int paddingStart = this.Code.getPaddingStart();
        String attributeValue2 = attributeSet.getAttributeValue(null, "paddingStart");
        if (!TextUtils.isEmpty(attributeValue2)) {
            paddingStart = com.huawei.hms.ads.template.util.a.Code(attributeValue2, context);
        }
        int paddingEnd = this.Code.getPaddingEnd();
        String attributeValue3 = attributeSet.getAttributeValue(null, "paddingEnd");
        if (!TextUtils.isEmpty(attributeValue3)) {
            paddingEnd = com.huawei.hms.ads.template.util.a.Code(attributeValue3, context);
        }
        int paddingTop = this.Code.getPaddingTop();
        String attributeValue4 = attributeSet.getAttributeValue(null, "paddingTop");
        if (!TextUtils.isEmpty(attributeValue4)) {
            paddingTop = com.huawei.hms.ads.template.util.a.Code(attributeValue4, context);
        }
        int paddingBottom = this.Code.getPaddingBottom();
        String attributeValue5 = attributeSet.getAttributeValue(null, "paddingBottom");
        if (!TextUtils.isEmpty(attributeValue5)) {
            paddingBottom = com.huawei.hms.ads.template.util.a.Code(attributeValue5, context);
        }
        this.Code.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }
}

package com.huawei.flexiblelayout.css.adapter.wrapper;

import android.widget.TextView;
import com.huawei.flexiblelayout.css.adapter.type.CSSColor;
import com.huawei.flexiblelayout.css.adapter.type.CSSColorList;
import com.huawei.flexiblelayout.css.adapter.type.CSSMonoColor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSFontWrapper {
    public void setTextColor(TextView textView, CSSColor cSSColor) {
        if (cSSColor instanceof CSSColorList) {
            textView.setTextColor(((CSSColorList) cSSColor).toColorStateList());
        } else if (cSSColor instanceof CSSMonoColor) {
            textView.setTextColor(((CSSMonoColor) cSSColor).getColor());
        }
    }
}

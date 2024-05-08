package com.huawei.pnodesupport.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.card.props.FLCardProps;
import com.huawei.flexiblelayout.card.props.NumbersPerLineParser;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive;
import com.huawei.flexiblelayout.data.FLPNodeData;

/* compiled from: PNodeDataHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c {
    @Nullable
    public static FLCardProps a(@NonNull FLPNodeData fLPNodeData) {
        CSSPrimitive cSSPrimitive;
        FLCardProps.CardNumbersPerLine parse;
        CSSRule cssRule = fLPNodeData.getCssRule();
        if (cssRule == null || (cSSPrimitive = (CSSPrimitive) cssRule.getPropertyValue("align")) == null || (parse = NumbersPerLineParser.parse(cSSPrimitive.asString())) == null) {
            return null;
        }
        return parse.build();
    }
}

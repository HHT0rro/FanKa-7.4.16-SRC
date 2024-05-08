package com.huawei.quickcard.views.text.view;

import android.content.Context;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQuickText {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Attrs {
        public static final String FONT_FAMILY = "fontFamily";
        public static final String FONT_SIZE = "fontSize";
        public static final String FONT_STYLE = "fontStyle";
        public static final String FONT_WEIGHT = "fontWeight";
        public static final String TEXT_COLOR = "textColor";
        public static final String TEXT_DECORATION = "textDecoration";
    }

    CardContext getCardContext();

    Context getContext();

    Object getFontFamily();

    Float getFontSize();

    String getFontStyle();

    String getFontWeight();

    boolean getForceRefresh();

    Integer getTextColor();

    String getTextDecoration();

    int getTextLineHeight();

    int getTextUnit();

    void setFontFamily(Object obj);

    void setFontSize(int i10, Float f10);

    void setFontStyle(String str);

    void setFontWeight(String str);

    void setForceRefresh(boolean z10);

    void setTextColor(int i10);

    void setTextDecoration(String str);

    void setTextLineHeight(int i10);
}

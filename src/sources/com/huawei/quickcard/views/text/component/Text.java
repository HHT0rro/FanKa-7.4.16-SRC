package com.huawei.quickcard.views.text.component;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.views.text.TextDefaultAttrValue;
import com.huawei.quickcard.views.text.processor.ForceRefresh;
import com.huawei.quickcard.views.text.processor.SelectableProcessor;
import com.huawei.quickcard.views.text.processor.TextColorStyle;
import com.huawei.quickcard.views.text.processor.TextCommonStyle;
import com.huawei.quickcard.views.text.processor.TextFontStyle;
import com.huawei.quickcard.views.text.processor.TextLineStyle;
import com.huawei.quickcard.views.text.processor.ValueAttribute;
import com.huawei.quickcard.views.text.view.QTextView;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Text extends Component<TextView> {
    public Text() {
        ValueAttribute valueAttribute = new ValueAttribute();
        addProcessor("value", valueAttribute);
        addProcessor("content", valueAttribute);
        TextCommonStyle textCommonStyle = new TextCommonStyle();
        addProcessor(Attributes.Style.TEXT_OVERFLOW, textCommonStyle);
        addProcessor(Attributes.Style.TEXT_ALIGN, textCommonStyle);
        addProcessor("textDecoration", textCommonStyle);
        TextFontStyle textFontStyle = new TextFontStyle();
        addProcessor("fontSize", textFontStyle);
        addProcessor("fontWeight", textFontStyle);
        addProcessor("fontFamily", textFontStyle);
        addProcessor("fontStyle", textFontStyle);
        addProcessor("color", new TextColorStyle());
        TextLineStyle textLineStyle = new TextLineStyle();
        addProcessor(Attributes.Style.LINES, textLineStyle);
        addProcessor(Attributes.Style.LINE_HEIGHT, textLineStyle);
        addProcessor(Attributes.SelfStyle.FORCE_REFRESH, new ForceRefresh());
        addProcessor(Attributes.Style.SELECTABLE, new SelectableProcessor());
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return "text";
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public TextView createViewImpl(Context context) {
        QTextView qTextView = new QTextView(context);
        qTextView.setFontSize(2, Float.valueOf(15.0f));
        qTextView.setTextColor(ResourceUtils.getColor(TextDefaultAttrValue.DEFAULT_TEXT_COLOR));
        qTextView.setGravity(16);
        return qTextView;
    }
}

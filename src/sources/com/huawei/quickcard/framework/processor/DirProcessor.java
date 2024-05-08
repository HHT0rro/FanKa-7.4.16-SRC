package com.huawei.quickcard.framework.processor;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.YogaUtils;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DirProcessor<T extends View> implements PropertyProcessor<T> {
    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean isImmediate() {
        return b.a(this);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        if (obj instanceof String) {
            return ParserHelper.parseToString(obj, Attributes.LayoutDirection.AUTO);
        }
        return QuickCardValue.EMPTY;
    }

    public void setAutoDirection(T t2) {
        if (t2.getResources().getConfiguration().getLayoutDirection() == 1) {
            setDirection(t2, 1, 4, YogaDirection.RTL);
        } else {
            setDirection(t2, 0, 3, YogaDirection.LTR);
        }
    }

    public void setDirection(T t2, int i10, int i11, YogaDirection yogaDirection) {
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        t2.setLayoutDirection(i10);
        if (t2 instanceof TextView) {
            t2.setTextDirection(i11);
        }
        if (yogaNode != null) {
            yogaNode.z(yogaDirection);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (quickCardValue != null && !QuickCardValue.EMPTY.equals(quickCardValue) && quickCardValue.getString() != null) {
            String string = quickCardValue.getString();
            string.hashCode();
            if (string.equals(Attributes.LayoutDirection.LTR)) {
                setDirection(t2, 0, 3, YogaDirection.LTR);
                return;
            } else if (!string.equals(Attributes.LayoutDirection.RTL)) {
                setAutoDirection(t2);
                return;
            } else {
                setDirection(t2, 1, 4, YogaDirection.RTL);
                return;
            }
        }
        setAutoDirection(t2);
    }
}

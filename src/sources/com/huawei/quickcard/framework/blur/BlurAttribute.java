package com.huawei.quickcard.framework.blur;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.i;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BlurAttribute<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33820a = "BlurAttribute";

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
        JSONObject json = ParserHelper.parseToJsonObject(obj).getJson();
        if (json == null) {
            CardLogUtils.w(f33820a, "blur failed, no param.");
            return QuickCardValue.EMPTY;
        }
        i iVar = new i();
        iVar.a(json.optString("id"));
        iVar.a(json.optInt("blurRadius", 0));
        iVar.c(Attributes.getFloat(json.optString("topLeftRadius"), 0.0f));
        iVar.d(Attributes.getFloat(json.optString("topRightRadius"), 0.0f));
        iVar.a(Attributes.getFloat(json.optString("bottomLeftRadius"), 0.0f));
        iVar.b(Attributes.getFloat(json.optString("bottomRightRadius"), 0.0f));
        return new QuickCardValue.ObjectValue(iVar);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (t2 instanceof Blurable) {
            Blurable blurable = (Blurable) t2;
            Object object = quickCardValue.getObject();
            if (object instanceof i) {
                i iVar = (i) object;
                if (TextUtils.isEmpty(iVar.f())) {
                    blurable.unBlur();
                    return;
                } else {
                    blurable.doBlur(iVar);
                    return;
                }
            }
            blurable.unBlur();
        }
    }
}

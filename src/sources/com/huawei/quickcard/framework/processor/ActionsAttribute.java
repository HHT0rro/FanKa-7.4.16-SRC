package com.huawei.quickcard.framework.processor;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.StrUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ActionsAttribute<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, EventProcessor<T>> f33864a = new HashMap();

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
        return ParserHelper.parseToJsonObject(obj);
    }

    public void registerProcessor(String str, EventProcessor<T> eventProcessor) {
        this.f33864a.put(str, eventProcessor);
    }

    public void removeProcessor(@NonNull String str) {
        this.f33864a.remove(str);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        JSONObject json = quickCardValue.getJson();
        if (json == null) {
            CardLogUtils.w("ActionsAttribute", "unknown action type:" + StrUtils.objDesc(quickCardValue));
        }
        for (Map.Entry<String, EventProcessor<T>> entry : this.f33864a.entrySet()) {
            String key = entry.getKey();
            EventProcessor<T> value = entry.getValue();
            String optString = json != null ? json.optString(key) : null;
            if (TextUtils.isEmpty(optString)) {
                value.cleanEvent(t2, key);
            } else {
                value.applyEvent(t2, key, StrUtils.strip(optString));
            }
        }
    }
}

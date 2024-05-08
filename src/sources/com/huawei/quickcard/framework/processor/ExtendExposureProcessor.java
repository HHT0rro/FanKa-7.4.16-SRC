package com.huawei.quickcard.framework.processor;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.exposure.extend.ExtendExposureManager;
import com.huawei.quickcard.exposure.extend.IExtendExposureCallback;
import com.huawei.quickcard.exposure.extend.IExtendExposureSupport;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ExtendExposureProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33884a = "ExtendExposureProcessor";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements IExtendExposureCallback {

        /* renamed from: a, reason: collision with root package name */
        private final String f33885a;

        public a(String str) {
            this.f33885a = str;
        }

        @Override // com.huawei.quickcard.exposure.extend.IExtendExposureCallback
        public void onExposure(View view, Map<String, Object> map) {
            CardLogUtils.d(ExtendExposureProcessor.f33884a, "onExposure, eventStr:" + this.f33885a);
            if (TextUtils.isEmpty(this.f33885a)) {
                return;
            }
            ActionsHelper.doAction(view, this.f33885a, map);
        }
    }

    private void a(View view, ExtendExposureManager extendExposureManager) {
        extendExposureManager.unRegisterExtendExposureEvent(view);
    }

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

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (!(t2 instanceof IExtendExposureSupport)) {
            CardLogUtils.e(f33884a, t2.getClass().getName() + " not support extend exposure");
            return;
        }
        CardContext cardContext = ViewUtils.getCardContext(t2);
        if (cardContext == null) {
            CardLogUtils.e(f33884a, "cardContext is null");
            return;
        }
        ExtendExposureManager extendExposureManager = cardContext.getExtendExposureManager();
        if (extendExposureManager == null) {
            CardLogUtils.e(f33884a, "can not find ExtendExposureManager");
            return;
        }
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            a(t2, extendExposureManager);
            return;
        }
        JSONObject json = quickCardValue.getJson();
        if (json == null) {
            a(t2, extendExposureManager);
            return;
        }
        String optString = json.optString(QuickCardBean.Field.SCRIPT, "");
        if (TextUtils.isEmpty(optString)) {
            a(t2, extendExposureManager);
            return;
        }
        int optInt = json.optInt("reportChangePercents", -1);
        ((IExtendExposureSupport) t2).setExtendExposureManager(extendExposureManager);
        extendExposureManager.registerExtendExposureEvent(t2, optInt, cardContext.isResume(), new a(optString));
    }
}

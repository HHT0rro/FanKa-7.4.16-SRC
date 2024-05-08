package com.huawei.quickcard.framework.processor;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.exposure.IExposureCallback;
import com.huawei.quickcard.exposure.IExposureSupport;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ExposureProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33880a = "ExposureProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final int f33881b = 1000;

    /* renamed from: c, reason: collision with root package name */
    private static final int f33882c = 50;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements IExposureCallback {

        /* renamed from: a, reason: collision with root package name */
        private final String f33883a;

        public a(String str) {
            this.f33883a = str;
        }

        @Override // com.huawei.quickcard.exposure.IExposureCallback
        public void onExposure(View view, long j10) {
            CardLogUtils.d(ExposureProcessor.f33880a, "onExposure, eventStr:" + this.f33883a);
            if (TextUtils.isEmpty(this.f33883a)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Long.valueOf(j10));
            ActionsHelper.doAction(view, this.f33883a, hashMap);
        }
    }

    private void a(@NonNull T t2, @NonNull ExposureManager exposureManager) {
        exposureManager.unRegisterExposureEvent(t2);
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
        if (!(t2 instanceof IExposureSupport)) {
            CardLogUtils.e(f33880a, "not support exposure with:" + t2.getClass().getName());
            return;
        }
        CardContext cardContext = ViewUtils.getCardContext(t2);
        if (cardContext == null) {
            CardLogUtils.e(f33880a, "cardContext is null");
            return;
        }
        ExposureManager exposureManager = cardContext.getExposureManager();
        if (exposureManager == null) {
            CardLogUtils.e(f33880a, "exposureMgr not found");
            return;
        }
        if (quickCardValue == null) {
            a(t2, exposureManager);
            return;
        }
        JSONObject json = quickCardValue.getJson();
        if (json == null) {
            a(t2, exposureManager);
            return;
        }
        String optString = json.optString(QuickCardBean.Field.SCRIPT, "");
        if (TextUtils.isEmpty(optString)) {
            a(t2, exposureManager);
            return;
        }
        int optInt = json.optInt("minDuration", 1000);
        int optInt2 = json.optInt("minSizePercent", 50);
        ((IExposureSupport) t2).setExposureManager(exposureManager);
        exposureManager.registerExposureEvent(t2, optInt, optInt2, new a(optString));
    }
}

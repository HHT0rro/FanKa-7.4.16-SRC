package com.huawei.quickcard.extension.global;

import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.extension.ability.NativeAbility;
import com.huawei.quickcard.extension.global.api.IGlobalFunction;
import com.huawei.quickcard.k0;
import com.huawei.quickcard.q0;
import com.huawei.quickcard.q1;
import com.huawei.quickcard.r0;
import com.huawei.quickcard.utils.IntervalTimerMethodUtil;
import com.huawei.quickcard.utils.MediaThemeUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class GlobalFunctionImpl implements IGlobalFunction {

    /* renamed from: d, reason: collision with root package name */
    private static final String f33647d = "GlobalFunctionImpl";

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<CardContext> f33648a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, NativeAbility> f33649b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private int f33650c;

    private void a() {
        WeakReference<CardContext> weakReference = this.f33648a;
        if (weakReference != null) {
            weakReference.clear();
            this.f33648a = null;
        }
    }

    @Override // com.huawei.quickcard.extension.global.api.IGlobalFunction
    public void bindCardContext(CardContext cardContext) {
        CardLogUtils.d(f33647d, "bind context");
        int hashCode = cardContext.hashCode();
        if (this.f33650c != hashCode) {
            a();
            this.f33648a = new WeakReference<>(cardContext);
            this.f33650c = hashCode;
        }
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public void clearAllInterval() {
        IntervalTimerMethodUtil.clearAllInterval(getCardContext());
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public void clearAllTimeout() {
        IntervalTimerMethodUtil.clearAllTimeout(getCardContext());
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public void clearInterval(int i10) {
        IntervalTimerMethodUtil.clearInterval(getCardContext(), i10);
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public void clearTimeout(int i10) {
        IntervalTimerMethodUtil.clearTimeout(getCardContext(), i10);
    }

    @Override // com.huawei.quickcard.extension.global.api.IGlobalFunction
    @Nullable
    public CardContext getCardContext() {
        WeakReference<CardContext> weakReference = this.f33648a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public Object getElementById(@Nullable String str) {
        CardContext cardContext = getCardContext();
        if (cardContext != null) {
            return k0.a(str, cardContext.getRoot());
        }
        return null;
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public Object getLangDir(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        CardLogUtils.d(f33647d, "invoke getLangDir with " + obj + obj2 + obj3);
        return r0.a(obj, obj2, obj3);
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public boolean isNotNull(@Nullable Object obj) {
        CardLogUtils.d(f33647d, "invoke isNotNull with " + obj);
        return q0.a(getCardContext(), obj);
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public Object requireModule(@Nullable String str) {
        CardLogUtils.d(f33647d, "invoke requireModule with " + str);
        return q1.a(str, this, this.f33649b);
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public int setInterval(Object obj, Object obj2) {
        return IntervalTimerMethodUtil.setInterval(getCardContext(), obj, obj2);
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public void setMediaTheme(Object obj, Object obj2) {
        MediaThemeUtils.setMediaTheme(getCardContext(), obj, obj2);
    }

    @Override // com.huawei.quickcard.extension.global.api.IJsFunction
    public int setTimeout(Object obj, Object obj2) {
        return IntervalTimerMethodUtil.setTimeout(getCardContext(), obj, obj2);
    }

    @Override // com.huawei.quickcard.extension.global.api.IGlobalFunction
    public void unbindCardContext() {
        CardLogUtils.d(f33647d, "unBind context");
        a();
    }
}

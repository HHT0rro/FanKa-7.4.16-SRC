package com.huawei.quickcard.extension.ability;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.extension.AsyncEnv;
import com.huawei.quickcard.extension.global.api.IGlobalFunction;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.AsyncFunctionUtils;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import java.util.Locale;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeAbility implements IAbilityCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33644a = "NativeAbility";
    public final IGlobalFunction jsFunction;

    public NativeAbility(@NonNull IGlobalFunction iGlobalFunction) {
        this.jsFunction = iGlobalFunction;
    }

    private void a(@NonNull String str, @NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object... objArr) {
        AsyncFunctionUtils.apply(str, asyncEnv, cardDataObject, objArr);
    }

    @Override // com.huawei.quickcard.extension.IJSCallback
    public void apply(@NonNull String str, @NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object... objArr) {
        a(str, asyncEnv, cardDataObject, objArr);
    }

    @Override // com.huawei.quickcard.extension.ability.IAbilityCallback
    public void cancel(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject) {
        apply(CallbackType.CANCEL.getType(), asyncEnv, cardDataObject, new Object[0]);
    }

    @Override // com.huawei.quickcard.extension.ability.IAbilityCallback
    public void complete(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object obj) {
        apply(CallbackType.COMPLETE.getType(), asyncEnv, cardDataObject, obj);
    }

    @Override // com.huawei.quickcard.extension.ability.IAbilityCallback
    public void fail(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object obj, int i10) {
        apply(CallbackType.FAIL.getType(), asyncEnv, cardDataObject, obj, Integer.valueOf(i10));
    }

    public final Context getAndroidContext() {
        return AsyncFunctionUtils.getAndroidContext(getCardContext());
    }

    @Nullable
    public final CardContext getCardContext() {
        return this.jsFunction.getCardContext();
    }

    public void printLog(int i10, String str, String str2) {
        CardLogUtils.printLogByLevel(i10, str, str2, null);
        CardLogUtils.print2Ide(i10, str, str2);
    }

    public <T extends Enum<T>> T string2Enum(Class<T> cls, String str, T t2) {
        if (str != null) {
            try {
                return (T) Enum.valueOf(cls, str.toUpperCase(Locale.ENGLISH));
            } catch (IllegalArgumentException unused) {
                CardLogUtils.d(f33644a, "enum " + str + " is not support, use default value");
            }
        }
        return t2;
    }

    @Override // com.huawei.quickcard.extension.ability.IAbilityCallback
    public void success(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object obj) {
        apply(CallbackType.SUCCESS.getType(), asyncEnv, cardDataObject, obj);
    }

    @NonNull
    public final QuickCardValue wrapJsValue(Object obj) {
        return QuickCardValueUtil.wrap(obj);
    }

    private void a(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object... objArr) {
        AsyncFunctionUtils.apply(asyncEnv, cardDataObject, objArr);
    }

    @Override // com.huawei.quickcard.extension.IJSCallback
    public void apply(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object... objArr) {
        a(asyncEnv, cardDataObject, objArr);
    }
}

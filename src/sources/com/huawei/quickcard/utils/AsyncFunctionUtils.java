package com.huawei.quickcard.utils;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.utils.CardThreadUtils;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.extension.AsyncEnv;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AsyncFunctionUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34260a = "AsyncFunctionUtils";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(CardDataObject cardDataObject, String str, Object[] objArr, AsyncEnv asyncEnv) {
        if (cardDataObject == null) {
            return;
        }
        Object obj = cardDataObject.get(str);
        a(objArr);
        a(obj, asyncEnv.getCardContext(), objArr);
    }

    public static void apply(@NonNull final String str, @NonNull final AsyncEnv asyncEnv, final CardDataObject cardDataObject, final Object... objArr) {
        CardThreadUtils.runOnMainThread(new Runnable() { // from class: com.huawei.quickcard.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                AsyncFunctionUtils.a(CardDataObject.this, str, objArr, asyncEnv);
            }
        });
    }

    public static Context getAndroidContext(CardContext cardContext) {
        QuickCardRoot root;
        ViewGroup rootViewGroup;
        if (cardContext == null || (root = cardContext.getRoot()) == null || (rootViewGroup = root.getRootViewGroup()) == null) {
            return null;
        }
        return rootViewGroup.getContext();
    }

    public static void apply(@NonNull final AsyncEnv asyncEnv, final CardDataObject cardDataObject, final Object... objArr) {
        CardThreadUtils.runOnMainThread(new Runnable() { // from class: com.huawei.quickcard.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                AsyncFunctionUtils.a(objArr, cardDataObject, asyncEnv);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object[] objArr, CardDataObject cardDataObject, AsyncEnv asyncEnv) {
        a(objArr);
        a(cardDataObject, asyncEnv.getCardContext(), objArr);
    }

    private static void a(Object obj, CardContext cardContext, Object... objArr) {
        if (cardContext != null) {
            cardContext.call(obj, objArr);
        }
    }

    private static void a(Object... objArr) {
        if (objArr != null) {
            for (int i10 = 0; i10 < objArr.length; i10++) {
                objArr[i10] = WrapDataUtils.wrap(objArr[i10]);
            }
        }
    }
}

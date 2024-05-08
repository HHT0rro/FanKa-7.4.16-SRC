package com.huawei.quickcard.utils;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.wrapper.WrapDataUtils;
import com.huawei.quickcard.extension.global.impl.CountDownTimerImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class IntervalTimerMethodUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34276a = "IntervalTimerMethodUtil";

    private static int a(@NonNull CardContext cardContext, @NonNull CardDataObject cardDataObject, Object obj, @NonNull SparseArray<CountDownTimerImpl> sparseArray, boolean z10) {
        CountDownTimerImpl a10 = a(cardContext, sparseArray);
        a10.start(cardDataObject, a(obj), z10);
        return a10.getId();
    }

    private static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.trim().length() == 0) {
            valueOf = null;
        }
        return StrUtils.strip(valueOf);
    }

    public static void clearAllInterval(CardContext cardContext) {
        if (cardContext == null) {
            return;
        }
        a(cardContext.getIntervalTimers());
    }

    public static void clearAllTimeout(CardContext cardContext) {
        if (cardContext == null) {
            return;
        }
        a(cardContext.getTimeoutTimers());
    }

    public static void clearInterval(CardContext cardContext, int i10) {
        if (cardContext == null) {
            return;
        }
        a(i10, cardContext.getIntervalTimers());
    }

    public static void clearTimeout(CardContext cardContext, int i10) {
        if (cardContext == null) {
            return;
        }
        a(i10, cardContext.getTimeoutTimers());
    }

    public static int setInterval(CardContext cardContext, Object obj, Object obj2) {
        if (cardContext == null) {
            return 0;
        }
        SparseArray<CountDownTimerImpl> intervalTimers = cardContext.getIntervalTimers();
        Object wrap = WrapDataUtils.wrap(obj);
        if (wrap instanceof CardDataObject) {
            return a(cardContext, (CardDataObject) wrap, obj2, intervalTimers, true);
        }
        return a(cardContext, obj, obj2, intervalTimers, true);
    }

    public static int setTimeout(CardContext cardContext, Object obj, Object obj2) {
        if (cardContext == null) {
            return 0;
        }
        SparseArray<CountDownTimerImpl> timeoutTimers = cardContext.getTimeoutTimers();
        Object wrap = WrapDataUtils.wrap(obj);
        if (wrap instanceof CardDataObject) {
            return a(cardContext, (CardDataObject) wrap, obj2, timeoutTimers, false);
        }
        return a(cardContext, obj, obj2, timeoutTimers, false);
    }

    private static int a(@NonNull CardContext cardContext, Object obj, Object obj2, @NonNull SparseArray<CountDownTimerImpl> sparseArray, boolean z10) {
        String b4 = b(obj);
        if (b4 == null) {
            return 0;
        }
        CountDownTimerImpl a10 = a(cardContext, sparseArray);
        a10.start(b4, a(obj2), z10);
        return a10.getId();
    }

    @NonNull
    private static CountDownTimerImpl a(@NonNull CardContext cardContext, @NonNull SparseArray<CountDownTimerImpl> sparseArray) {
        int size = sparseArray.size() + 1;
        CountDownTimerImpl countDownTimerImpl = new CountDownTimerImpl(cardContext, size);
        sparseArray.put(size, countDownTimerImpl);
        return countDownTimerImpl;
    }

    private static long a(Object obj) {
        if (obj == null) {
            return 1L;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.trim().length() <= 0) {
            return 1L;
        }
        int i10 = -1;
        int length = valueOf.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = valueOf.charAt(i11);
            if (charAt == '-' || charAt == '+') {
                if (i11 > 0) {
                    return 1L;
                }
            } else if (charAt == '.') {
                if (i10 > 0 || i11 == 0) {
                    return 1L;
                }
                i10 = i11;
            } else if (charAt < '0' || charAt > '9') {
                return 1L;
            }
        }
        if (i10 > 0) {
            valueOf = valueOf.substring(0, i10);
        }
        long parseLong = Long.parseLong(valueOf);
        if (parseLong <= 0) {
            return 1L;
        }
        return parseLong;
    }

    private static void a(int i10, @NonNull SparseArray<CountDownTimerImpl> sparseArray) {
        CountDownTimerImpl countDownTimerImpl = sparseArray.get(i10);
        if (countDownTimerImpl != null) {
            countDownTimerImpl.cancel();
            sparseArray.put(i10, null);
        }
    }

    private static void a(@NonNull SparseArray<CountDownTimerImpl> sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            CountDownTimerImpl valueAt = sparseArray.valueAt(i10);
            if (valueAt != null) {
                valueAt.cancel();
            }
        }
        sparseArray.clear();
    }
}

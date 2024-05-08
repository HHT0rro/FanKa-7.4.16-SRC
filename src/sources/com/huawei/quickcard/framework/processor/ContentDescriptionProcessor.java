package com.huawei.quickcard.framework.processor;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.g1;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.v0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ContentDescriptionProcessor<T extends View> implements PropertyProcessor<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33879a;

        static {
            int[] iArr = new int[v0.values().length];
            f33879a = iArr;
            try {
                iArr[v0.POLITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33879a[v0.ASSERTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void a(@NonNull T t2, @NonNull QuickCardValue quickCardValue) {
        a((ContentDescriptionProcessor<T>) t2).a(a(quickCardValue));
    }

    private void b(@NonNull T t2, @NonNull QuickCardValue quickCardValue) {
        Object object = quickCardValue.getObject();
        if (object instanceof v0) {
            int i10 = a.f33879a[((v0) object).ordinal()];
            if (i10 == 1) {
                t2.setAccessibilityLiveRegion(1);
                return;
            } else if (i10 == 2) {
                t2.setAccessibilityLiveRegion(2);
                return;
            }
        }
        t2.setAccessibilityLiveRegion(0);
    }

    private void c(@NonNull T t2, QuickCardValue quickCardValue) {
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        obtainPropertyCacheBeanFromView.setContentDescription(t2.getContentDescription());
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            t2.setContentDescription(obtainPropertyCacheBeanFromView.getContentDescription());
            return;
        }
        String obj = quickCardValue.toString();
        if (TextUtils.equals(obj, t2.getContentDescription())) {
            return;
        }
        t2.setContentDescription(obj);
    }

    private void d(@NonNull T t2, @NonNull QuickCardValue quickCardValue) {
        if (quickCardValue.getBoolean()) {
            t2.setImportantForAccessibility(2);
        } else {
            t2.setImportantForAccessibility(1);
        }
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
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1551873643:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION_LIVE)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1317433185:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION_ACTION)) {
                    c4 = 1;
                    break;
                }
                break;
            case -863700117:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION)) {
                    c4 = 2;
                    break;
                }
                break;
            case 663425776:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION_SWITCH)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new QuickCardValue.ObjectValue(a(obj));
            case 1:
                return ParserHelper.parseToNumber(obj, 0);
            case 2:
                return ParserHelper.parseToString(obj, "");
            case 3:
                return ParserHelper.parseToBool(obj, false);
            default:
                return QuickCardValue.wrap(obj);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1551873643:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION_LIVE)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1317433185:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION_ACTION)) {
                    c4 = 1;
                    break;
                }
                break;
            case -863700117:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION)) {
                    c4 = 2;
                    break;
                }
                break;
            case 663425776:
                if (str.equals(Attributes.Style.CONTENT_DESCRIPTION_SWITCH)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                b(t2, quickCardValue);
                return;
            case 1:
                a(t2, quickCardValue);
                return;
            case 2:
                c(t2, quickCardValue);
                return;
            case 3:
                d(t2, quickCardValue);
                return;
            default:
                return;
        }
    }

    @NonNull
    private g1 a(@NonNull T t2) {
        if (Build.VERSION.SDK_INT >= 29) {
            View.AccessibilityDelegate accessibilityDelegate = t2.getAccessibilityDelegate();
            if (accessibilityDelegate instanceof g1) {
                return (g1) accessibilityDelegate;
            }
        }
        g1 g1Var = new g1();
        t2.setAccessibilityDelegate(g1Var);
        return g1Var;
    }

    private int a(@NonNull QuickCardValue quickCardValue) {
        int intValue;
        Number number = quickCardValue.getNumber();
        if (number == null || (intValue = number.intValue()) < 0 || intValue > 3) {
            return 0;
        }
        return intValue;
    }

    private v0 a(Object obj) {
        return (v0) ParserHelper.object2Enum(v0.class, obj, v0.NONE);
    }
}

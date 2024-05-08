package com.huawei.quickcard.framework.processor.background;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.e;
import com.huawei.quickcard.framework.background.c;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ValueUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BackgroundImageProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33941a = "BackgroundImageProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33942b = "auto";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33943c = "0dp 0dp";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33944d = "repeat";

    private void a(T t2, QuickCardValue quickCardValue) {
        String[] a10 = e.a(quickCardValue);
        c a11 = e.a(t2);
        if (a11 == null) {
            e.a(a10, ValueUtils.obtainPropertyCacheBeanFromView(t2).getBackgroundImageStyle());
        } else {
            e.a(a10, a11.a());
            a11.invalidateSelf();
        }
    }

    private void b(T t2, QuickCardValue quickCardValue) {
        String string = !QuickCardValueUtil.isInvalidValue(quickCardValue) ? quickCardValue.getString() : f33944d;
        c a10 = e.a(t2);
        if (a10 == null) {
            ValueUtils.obtainPropertyCacheBeanFromView(t2).getBackgroundImageStyle().b(string);
        } else {
            a10.a().b(string);
            a10.invalidateSelf();
        }
    }

    private void c(T t2, QuickCardValue quickCardValue) {
        String[] b4 = e.b(quickCardValue);
        c a10 = e.a(t2);
        if (a10 == null) {
            e.b(b4, ValueUtils.obtainPropertyCacheBeanFromView(t2).getBackgroundImageStyle());
        } else {
            e.b(b4, a10.a());
            a10.invalidateSelf();
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
            case 640435319:
                if (str.equals(Attributes.Style.BACKGROUND_POSITION)) {
                    c4 = 0;
                    break;
                }
                break;
            case 1427464783:
                if (str.equals(Attributes.Style.BACKGROUND_SIZE)) {
                    c4 = 1;
                    break;
                }
                break;
            case 1666471017:
                if (str.equals(Attributes.Style.BACKGROUND_REPEAT)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return ParserHelper.parseToString(obj, f33943c);
            case 1:
                return ParserHelper.parseToString(obj, "auto");
            case 2:
                return ParserHelper.parseToString(obj, f33944d);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 640435319:
                if (str.equals(Attributes.Style.BACKGROUND_POSITION)) {
                    c4 = 0;
                    break;
                }
                break;
            case 1427464783:
                if (str.equals(Attributes.Style.BACKGROUND_SIZE)) {
                    c4 = 1;
                    break;
                }
                break;
            case 1666471017:
                if (str.equals(Attributes.Style.BACKGROUND_REPEAT)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a(t2, quickCardValue);
                return;
            case 1:
                c(t2, quickCardValue);
                return;
            case 2:
                b(t2, quickCardValue);
                return;
            default:
                return;
        }
    }
}

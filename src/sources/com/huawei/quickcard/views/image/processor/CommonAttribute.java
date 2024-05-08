package com.huawei.quickcard.views.image.processor;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.unit.LengthUnit;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.image.view.IImageHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CommonAttribute extends BaseProcessor {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34537a = "dp";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34538b = "%";

    @NonNull
    private LengthValue a(View view, @NonNull QuickCardValue quickCardValue) {
        if (quickCardValue.isDp()) {
            return new LengthValue(ViewUtils.dip2FloatPx(view, quickCardValue.getDp()), LengthUnit.DP);
        }
        if (quickCardValue.isNumber()) {
            return new LengthValue(quickCardValue.getNumber().floatValue(), LengthUnit.DP);
        }
        if (quickCardValue.isPercent()) {
            return new LengthValue(quickCardValue.getPercent(), LengthUnit.PERCENT);
        }
        return new LengthValue(0.0f, LengthUnit.DP);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1274492040:
                if (str.equals(Attributes.Style.FILTER)) {
                    c4 = 0;
                    break;
                }
                break;
            case -676513600:
                if (str.equals(Attributes.Style.NET_WORK_ENHANCE)) {
                    c4 = 1;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 2;
                    break;
                }
                break;
            case 94750472:
                if (str.equals(Attributes.Style.CLIP_X)) {
                    c4 = 3;
                    break;
                }
                break;
            case 94750473:
                if (str.equals(Attributes.Style.CLIP_Y)) {
                    c4 = 4;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    c4 = 5;
                    break;
                }
                break;
            case 2083856961:
                if (str.equals(Attributes.Style.NO_CACHE)) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 2:
                return ParserHelper.parseToString(obj, null);
            case 1:
            case 5:
            case 6:
                return ParserHelper.parseToBool(obj);
            case 3:
            case 4:
                return a(obj, (Number) 0);
            default:
                return new QuickCardValue();
        }
    }

    @Override // com.huawei.quickcard.views.image.processor.BaseProcessor
    public void setProperty(@NonNull ImageView imageView, @NonNull IImageHost iImageHost, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -676513600:
                if (str.equals(Attributes.Style.NET_WORK_ENHANCE)) {
                    c4 = 0;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 1;
                    break;
                }
                break;
            case 94750472:
                if (str.equals(Attributes.Style.CLIP_X)) {
                    c4 = 2;
                    break;
                }
                break;
            case 94750473:
                if (str.equals(Attributes.Style.CLIP_Y)) {
                    c4 = 3;
                    break;
                }
                break;
            case 2083856961:
                if (str.equals(Attributes.Style.NO_CACHE)) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                iImageHost.setNetworkEnhance(quickCardValue.getBoolean());
                return;
            case 1:
                iImageHost.setSrc(StrUtils.null2Empty(quickCardValue.getString()).trim());
                return;
            case 2:
                iImageHost.setClipX(a(imageView, quickCardValue));
                return;
            case 3:
                iImageHost.setClipY(a(imageView, quickCardValue));
                return;
            case 4:
                iImageHost.enableCache(!quickCardValue.getBoolean());
                return;
            default:
                return;
        }
    }

    private QuickCardValue a(Object obj, Number number) {
        if (obj instanceof Number) {
            return new QuickCardValue.NumberValue((Number) obj);
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.endsWith("dp")) {
                return new QuickCardValue.DpValue(ViewUtils.parseFloat(obj2.substring(0, obj2.length() - 2), number.floatValue()));
            }
            if (obj2.endsWith(f34538b)) {
                return new QuickCardValue.Percent(ViewUtils.parseFloat(obj2.substring(0, obj2.indexOf(f34538b)), 0.0f) / 100.0f);
            }
            return ParserHelper.parseToNumber(obj2, number);
        }
        return new QuickCardValue.NumberValue(number);
    }
}

package com.huawei.hms.ads;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dd extends cq<TextView> {
    private int L;

    /* renamed from: a, reason: collision with root package name */
    private Typeface f29075a;

    public dd(TextView textView) {
        super(textView);
        this.L = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.huawei.hms.ads.cj
    public void Code(AttributeSet attributeSet) {
        Typeface typeface;
        char c4;
        if (this.Code == 0 || attributeSet == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "textStyle");
        char c10 = 65535;
        if (!TextUtils.isEmpty(attributeValue)) {
            attributeValue.hashCode();
            switch (attributeValue.hashCode()) {
                case -1178781136:
                    if (attributeValue.equals("italic")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1039745817:
                    if (attributeValue.equals("normal")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3029637:
                    if (attributeValue.equals("bold")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1702544263:
                    if (attributeValue.equals("bold|italic")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    this.L = 2;
                    break;
                case 1:
                    this.L = 0;
                    break;
                case 2:
                    this.L = 1;
                    break;
                case 3:
                    this.L = 3;
                    break;
            }
        }
        String attributeValue2 = attributeSet.getAttributeValue(null, "typeface");
        if (!TextUtils.isEmpty(attributeValue2)) {
            attributeValue2.hashCode();
            switch (attributeValue2.hashCode()) {
                case -1431958525:
                    if (attributeValue2.equals("monospace")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1039745817:
                    if (attributeValue2.equals("normal")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3522707:
                    if (attributeValue2.equals("sans")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 109326717:
                    if (attributeValue2.equals("serif")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    typeface = Typeface.MONOSPACE;
                    break;
                case 1:
                    typeface = Typeface.DEFAULT_BOLD;
                    break;
                case 2:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 3:
                    typeface = Typeface.SERIF;
                    break;
                default:
                    typeface = Typeface.DEFAULT;
                    break;
            }
            this.f29075a = typeface;
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, "fontFamily");
        if (TextUtils.isEmpty(attributeValue3)) {
            ((TextView) this.Code).setTypeface(this.f29075a, this.L);
        } else {
            ((TextView) this.Code).setTypeface(Typeface.create(attributeValue3, this.L));
        }
    }
}

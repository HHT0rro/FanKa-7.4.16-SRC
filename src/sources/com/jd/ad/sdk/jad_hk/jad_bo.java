package com.jd.ad.sdk.jad_hk;

import com.baidu.mobads.sdk.internal.ck;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo {
    public static final /* synthetic */ int jad_an = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an extends ThreadLocal<DecimalFormat> {
        @Override // java.lang.ThreadLocal
        public DecimalFormat initialValue() {
            try {
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
                decimalFormat.applyPattern(ck.f10046d);
                return decimalFormat;
            } catch (Exception unused) {
                return new DecimalFormat(ck.f10046d);
            }
        }
    }

    static {
        new jad_an();
    }
}

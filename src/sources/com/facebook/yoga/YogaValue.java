package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.huawei.quickcard.base.Attributes;

@DoNotStrip
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class YogaValue {

    /* renamed from: c, reason: collision with root package name */
    public static final YogaValue f19198c = new YogaValue(Float.NaN, YogaUnit.UNDEFINED);

    /* renamed from: d, reason: collision with root package name */
    public static final YogaValue f19199d = new YogaValue(0.0f, YogaUnit.POINT);

    /* renamed from: e, reason: collision with root package name */
    public static final YogaValue f19200e = new YogaValue(Float.NaN, YogaUnit.AUTO);

    /* renamed from: a, reason: collision with root package name */
    public final float f19201a;

    /* renamed from: b, reason: collision with root package name */
    public final YogaUnit f19202b;

    /* renamed from: com.facebook.yoga.YogaValue$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19203a;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            f19203a = iArr;
            try {
                iArr[YogaUnit.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19203a[YogaUnit.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19203a[YogaUnit.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19203a[YogaUnit.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public YogaValue(float f10, YogaUnit yogaUnit) {
        this.f19201a = f10;
        this.f19202b = yogaUnit;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YogaValue)) {
            return false;
        }
        YogaValue yogaValue = (YogaValue) obj;
        YogaUnit yogaUnit = this.f19202b;
        if (yogaUnit == yogaValue.f19202b) {
            return yogaUnit == YogaUnit.UNDEFINED || Float.compare(this.f19201a, yogaValue.f19201a) == 0;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f19201a) + this.f19202b.intValue();
    }

    public String toString() {
        int i10 = AnonymousClass1.f19203a[this.f19202b.ordinal()];
        if (i10 == 1) {
            return "undefined";
        }
        if (i10 == 2) {
            return Float.toString(this.f19201a);
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return Attributes.LayoutDirection.AUTO;
            }
            throw new IllegalStateException();
        }
        return this.f19201a + "%";
    }

    @DoNotStrip
    public YogaValue(float f10, int i10) {
        this(f10, YogaUnit.fromInt(i10));
    }
}

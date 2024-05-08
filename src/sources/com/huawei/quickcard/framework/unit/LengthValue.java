package com.huawei.quickcard.framework.unit;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LengthValue {
    public final LengthUnit unit;
    public final float value;

    public LengthValue(float f10, @NonNull LengthUnit lengthUnit) {
        this.value = f10;
        this.unit = lengthUnit;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LengthValue lengthValue = (LengthValue) obj;
        return Float.compare(this.value, lengthValue.value) == 0 && this.unit == lengthValue.unit;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value) + this.unit.hashCode();
    }
}

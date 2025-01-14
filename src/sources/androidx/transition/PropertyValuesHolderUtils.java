package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class PropertyValuesHolderUtils {
    private PropertyValuesHolderUtils() {
    }

    public static PropertyValuesHolder ofPointF(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
    }
}

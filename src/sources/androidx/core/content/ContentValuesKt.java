package androidx.core.content;

import android.content.ContentValues;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContentValues.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues contentValuesOf(@NotNull Pair<String, ? extends Object>... pairs) {
        kotlin.jvm.internal.s.i(pairs, "pairs");
        ContentValues contentValues = new ContentValues(pairs.length);
        for (Pair<String, ? extends Object> pair : pairs) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                contentValues.putNull(component1);
            } else if (component2 instanceof String) {
                contentValues.put(component1, (String) component2);
            } else if (component2 instanceof Integer) {
                contentValues.put(component1, (Integer) component2);
            } else if (component2 instanceof Long) {
                contentValues.put(component1, (Long) component2);
            } else if (component2 instanceof Boolean) {
                contentValues.put(component1, (Boolean) component2);
            } else if (component2 instanceof Float) {
                contentValues.put(component1, (Float) component2);
            } else if (component2 instanceof Double) {
                contentValues.put(component1, (Double) component2);
            } else if (component2 instanceof byte[]) {
                contentValues.put(component1, (byte[]) component2);
            } else if (component2 instanceof Byte) {
                contentValues.put(component1, (Byte) component2);
            } else {
                if (!(component2 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + component1 + '\"');
                }
                contentValues.put(component1, (Short) component2);
            }
        }
        return contentValues;
    }
}

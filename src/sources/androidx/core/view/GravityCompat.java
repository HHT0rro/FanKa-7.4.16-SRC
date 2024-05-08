package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    @RequiresApi(17)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static void apply(int i10, int i11, int i12, Rect rect, Rect rect2, int i13) {
            Gravity.apply(i10, i11, i12, rect, rect2, i13);
        }

        @DoNotInline
        public static void applyDisplay(int i10, Rect rect, Rect rect2, int i11) {
            Gravity.applyDisplay(i10, rect, rect2, i11);
        }

        @DoNotInline
        public static void apply(int i10, int i11, int i12, Rect rect, int i13, int i14, Rect rect2, int i15) {
            Gravity.apply(i10, i11, i12, rect, i13, i14, rect2, i15);
        }
    }

    private GravityCompat() {
    }

    public static void apply(int i10, int i11, int i12, @NonNull Rect rect, @NonNull Rect rect2, int i13) {
        Api17Impl.apply(i10, i11, i12, rect, rect2, i13);
    }

    public static void applyDisplay(int i10, @NonNull Rect rect, @NonNull Rect rect2, int i11) {
        Api17Impl.applyDisplay(i10, rect, rect2, i11);
    }

    public static int getAbsoluteGravity(int i10, int i11) {
        return Gravity.getAbsoluteGravity(i10, i11);
    }

    public static void apply(int i10, int i11, int i12, @NonNull Rect rect, int i13, int i14, @NonNull Rect rect2, int i15) {
        Api17Impl.apply(i10, i11, i12, rect, i13, i14, rect2, i15);
    }
}

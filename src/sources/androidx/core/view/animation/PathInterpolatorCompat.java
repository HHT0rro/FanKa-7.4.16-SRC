package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PathInterpolatorCompat {

    @RequiresApi(21)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static PathInterpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        public static PathInterpolator createPathInterpolator(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        @DoNotInline
        public static PathInterpolator createPathInterpolator(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f10, float f11) {
        return Api21Impl.createPathInterpolator(f10, f11);
    }

    @NonNull
    public static Interpolator create(float f10, float f11, float f12, float f13) {
        return Api21Impl.createPathInterpolator(f10, f11, f12, f13);
    }
}

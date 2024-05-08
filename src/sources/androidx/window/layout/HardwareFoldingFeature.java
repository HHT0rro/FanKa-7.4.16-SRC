package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HardwareFoldingFeature.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class HardwareFoldingFeature implements FoldingFeature {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Bounds featureBounds;

    @NotNull
    private final FoldingFeature.State state;

    @NotNull
    private final Type type;

    /* compiled from: HardwareFoldingFeature.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void validateFeatureBounds$window_release(@NotNull Bounds bounds) {
            s.i(bounds, "bounds");
            if ((bounds.getWidth() == 0 && bounds.getHeight() == 0) ? false : true) {
                if (!(bounds.getLeft() == 0 || bounds.getTop() == 0)) {
                    throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
                }
                return;
            }
            throw new IllegalArgumentException("Bounds must be non zero".toString());
        }
    }

    /* compiled from: HardwareFoldingFeature.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class Type {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Type FOLD = new Type("FOLD");

        @NotNull
        private static final Type HINGE = new Type("HINGE");

        @NotNull
        private final String description;

        /* compiled from: HardwareFoldingFeature.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Type getFOLD() {
                return Type.FOLD;
            }

            @NotNull
            public final Type getHINGE() {
                return Type.HINGE;
            }
        }

        private Type(String str) {
            this.description = str;
        }

        @NotNull
        public String toString() {
            return this.description;
        }
    }

    public HardwareFoldingFeature(@NotNull Bounds featureBounds, @NotNull Type type, @NotNull FoldingFeature.State state) {
        s.i(featureBounds, "featureBounds");
        s.i(type, "type");
        s.i(state, "state");
        this.featureBounds = featureBounds;
        this.type = type;
        this.state = state;
        Companion.validateFeatureBounds$window_release(featureBounds);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!s.d(HardwareFoldingFeature.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) obj;
        return s.d(this.featureBounds, hardwareFoldingFeature.featureBounds) && s.d(this.type, hardwareFoldingFeature.type) && s.d(getState(), hardwareFoldingFeature.getState());
    }

    @Override // androidx.window.layout.DisplayFeature
    @NotNull
    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    @Override // androidx.window.layout.FoldingFeature
    @NotNull
    public FoldingFeature.OcclusionType getOcclusionType() {
        if (this.featureBounds.getWidth() != 0 && this.featureBounds.getHeight() != 0) {
            return FoldingFeature.OcclusionType.FULL;
        }
        return FoldingFeature.OcclusionType.NONE;
    }

    @Override // androidx.window.layout.FoldingFeature
    @NotNull
    public FoldingFeature.Orientation getOrientation() {
        if (this.featureBounds.getWidth() > this.featureBounds.getHeight()) {
            return FoldingFeature.Orientation.HORIZONTAL;
        }
        return FoldingFeature.Orientation.VERTICAL;
    }

    @Override // androidx.window.layout.FoldingFeature
    @NotNull
    public FoldingFeature.State getState() {
        return this.state;
    }

    @NotNull
    public final Type getType$window_release() {
        return this.type;
    }

    public int hashCode() {
        return (((this.featureBounds.hashCode() * 31) + this.type.hashCode()) * 31) + getState().hashCode();
    }

    @Override // androidx.window.layout.FoldingFeature
    public boolean isSeparating() {
        Type type = this.type;
        Type.Companion companion = Type.Companion;
        if (s.d(type, companion.getHINGE())) {
            return true;
        }
        return s.d(this.type, companion.getFOLD()) && s.d(getState(), FoldingFeature.State.HALF_OPENED);
    }

    @NotNull
    public String toString() {
        return ((Object) HardwareFoldingFeature.class.getSimpleName()) + " { " + ((Object) this.featureBounds) + ", type=" + ((Object) this.type) + ", state=" + ((Object) getState()) + " }";
    }
}

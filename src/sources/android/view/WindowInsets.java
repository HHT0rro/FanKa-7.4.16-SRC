package android.view;

import android.graphics.Insets;
import android.graphics.Rect;
import com.alipay.sdk.util.i;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WindowInsets {
    public static final WindowInsets CONSUMED = new WindowInsets(createCompatTypeMap(null), createCompatTypeMap(null), createCompatVisibilityMap(createCompatTypeMap(null)), false, false, 0, null, null, null, null, Type.systemBars(), false);
    private final boolean mAlwaysConsumeSystemBars;
    private final boolean mCompatIgnoreVisibility;
    private final int mCompatInsetsTypes;
    private final DisplayCutout mDisplayCutout;
    private final boolean mDisplayCutoutConsumed;
    private final DisplayShape mDisplayShape;
    private final boolean mIsRound;
    private final PrivacyIndicatorBounds mPrivacyIndicatorBounds;
    private final RoundedCorners mRoundedCorners;
    private final boolean mStableInsetsConsumed;
    private final int mSuppressScrimTypes;
    private final boolean mSystemWindowInsetsConsumed;
    private Rect mTempRect;
    private final Insets[] mTypeInsetsMap;
    private final Insets[] mTypeMaxInsetsMap;
    private final boolean[] mTypeVisibilityMap;

    public WindowInsets(Insets[] typeInsetsMap, Insets[] typeMaxInsetsMap, boolean[] typeVisibilityMap, boolean isRound, boolean alwaysConsumeSystemBars, int suppressScrimTypes, DisplayCutout displayCutout, RoundedCorners roundedCorners, PrivacyIndicatorBounds privacyIndicatorBounds, DisplayShape displayShape, int compatInsetsTypes, boolean compatIgnoreVisibility) {
        Insets[] insetsArr;
        Insets[] insetsArr2;
        boolean z10 = typeInsetsMap == null;
        this.mSystemWindowInsetsConsumed = z10;
        if (z10) {
            insetsArr = new Insets[10];
        } else {
            insetsArr = (Insets[]) typeInsetsMap.clone();
        }
        this.mTypeInsetsMap = insetsArr;
        boolean z11 = typeMaxInsetsMap == null;
        this.mStableInsetsConsumed = z11;
        if (z11) {
            insetsArr2 = new Insets[10];
        } else {
            insetsArr2 = (Insets[]) typeMaxInsetsMap.clone();
        }
        this.mTypeMaxInsetsMap = insetsArr2;
        this.mTypeVisibilityMap = typeVisibilityMap;
        this.mIsRound = isRound;
        this.mAlwaysConsumeSystemBars = alwaysConsumeSystemBars;
        this.mSuppressScrimTypes = suppressScrimTypes;
        this.mCompatInsetsTypes = compatInsetsTypes;
        this.mCompatIgnoreVisibility = compatIgnoreVisibility;
        boolean z12 = displayCutout == null;
        this.mDisplayCutoutConsumed = z12;
        this.mDisplayCutout = (z12 || displayCutout.isEmpty()) ? null : displayCutout;
        this.mRoundedCorners = roundedCorners;
        this.mPrivacyIndicatorBounds = privacyIndicatorBounds;
        this.mDisplayShape = displayShape;
    }

    public WindowInsets(WindowInsets src) {
        this(src.mSystemWindowInsetsConsumed ? null : src.mTypeInsetsMap, src.mStableInsetsConsumed ? null : src.mTypeMaxInsetsMap, src.mTypeVisibilityMap, src.mIsRound, src.mAlwaysConsumeSystemBars, src.mSuppressScrimTypes, displayCutoutCopyConstructorArgument(src), src.mRoundedCorners, src.mPrivacyIndicatorBounds, src.mDisplayShape, src.mCompatInsetsTypes, src.mCompatIgnoreVisibility);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DisplayCutout displayCutoutCopyConstructorArgument(WindowInsets w3) {
        if (w3.mDisplayCutoutConsumed) {
            return null;
        }
        DisplayCutout displayCutout = w3.mDisplayCutout;
        if (displayCutout == null) {
            return DisplayCutout.NO_CUTOUT;
        }
        return displayCutout;
    }

    static Insets getInsets(Insets[] typeInsetsMap, int typeMask) {
        Insets insets;
        Insets result = null;
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((typeMask & i10) != 0 && (insets = typeInsetsMap[Type.indexOf(i10)]) != null) {
                if (result == null) {
                    result = insets;
                } else {
                    result = Insets.max(result, insets);
                }
            }
        }
        return result == null ? Insets.NONE : result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setInsets(Insets[] typeInsetsMap, int typeMask, Insets insets) {
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((typeMask & i10) != 0) {
                typeInsetsMap[Type.indexOf(i10)] = insets;
            }
        }
    }

    public void setStatusBarInsets(Rect insets) {
        if (insets == null) {
            return;
        }
        this.mTypeInsetsMap[Type.indexOf(1)] = Insets.of(0, insets.top, 0, 0);
        this.mTypeMaxInsetsMap[Type.indexOf(1)] = Insets.of(0, insets.top, 0, 0);
    }

    public WindowInsets(Rect systemWindowInsets) {
        this(createCompatTypeMap(systemWindowInsets), null, new boolean[10], false, false, 0, null, null, null, null, Type.systemBars(), false);
    }

    public static Insets[] createCompatTypeMap(Rect insets) {
        if (insets == null) {
            return null;
        }
        Insets[] typeInsetsMap = new Insets[10];
        assignCompatInsets(typeInsetsMap, insets);
        return typeInsetsMap;
    }

    public static void assignCompatInsets(Insets[] typeInsetsMap, Rect insets) {
        typeInsetsMap[Type.indexOf(1)] = Insets.of(0, insets.top, 0, 0);
        typeInsetsMap[Type.indexOf(2)] = Insets.of(insets.left, 0, insets.right, insets.bottom);
    }

    private static boolean[] createCompatVisibilityMap(Insets[] typeInsetsMap) {
        boolean[] typeVisibilityMap = new boolean[10];
        if (typeInsetsMap == null) {
            return typeVisibilityMap;
        }
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            int index = Type.indexOf(i10);
            if (!Insets.NONE.equals(typeInsetsMap[index])) {
                typeVisibilityMap[index] = true;
            }
        }
        return typeVisibilityMap;
    }

    @Deprecated
    public Rect getSystemWindowInsetsAsRect() {
        if (this.mTempRect == null) {
            this.mTempRect = new Rect();
        }
        Insets insets = getSystemWindowInsets();
        this.mTempRect.set(insets.left, insets.top, insets.right, insets.bottom);
        return this.mTempRect;
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        Insets result;
        if (this.mCompatIgnoreVisibility) {
            result = getInsetsIgnoringVisibility(this.mCompatInsetsTypes & (~Type.ime()));
        } else {
            result = getInsets(this.mCompatInsetsTypes);
        }
        if ((this.mCompatInsetsTypes & Type.ime()) != 0 && this.mCompatIgnoreVisibility) {
            return Insets.max(result, getInsets(Type.ime()));
        }
        return result;
    }

    public Insets getInsets(int typeMask) {
        return getInsets(this.mTypeInsetsMap, typeMask);
    }

    public Insets getInsetsIgnoringVisibility(int typeMask) {
        if ((typeMask & 8) != 0) {
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }
        return getInsets(this.mTypeMaxInsetsMap, typeMask);
    }

    public boolean isVisible(int typeMask) {
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((typeMask & i10) != 0 && !this.mTypeVisibilityMap[Type.indexOf(i10)]) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return getSystemWindowInsets().top;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return getSystemWindowInsets().bottom;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !getSystemWindowInsets().equals(Insets.NONE);
    }

    public boolean hasInsets() {
        return (getInsets(this.mTypeInsetsMap, Type.all()).equals(Insets.NONE) && getInsets(this.mTypeMaxInsetsMap, Type.all()).equals(Insets.NONE) && this.mDisplayCutout == null && this.mRoundedCorners == null) ? false : true;
    }

    public DisplayCutout getDisplayCutout() {
        return this.mDisplayCutout;
    }

    public RoundedCorner getRoundedCorner(int position) {
        RoundedCorners roundedCorners = this.mRoundedCorners;
        if (roundedCorners == null) {
            return null;
        }
        return roundedCorners.getRoundedCorner(position);
    }

    public Rect getPrivacyIndicatorBounds() {
        PrivacyIndicatorBounds privacyIndicatorBounds = this.mPrivacyIndicatorBounds;
        if (privacyIndicatorBounds == null) {
            return null;
        }
        return privacyIndicatorBounds.getStaticPrivacyIndicatorBounds();
    }

    public DisplayShape getDisplayShape() {
        return this.mDisplayShape;
    }

    @Deprecated
    public WindowInsets consumeDisplayCutout() {
        return new WindowInsets(this.mSystemWindowInsetsConsumed ? null : this.mTypeInsetsMap, this.mStableInsetsConsumed ? null : this.mTypeMaxInsetsMap, this.mTypeVisibilityMap, this.mIsRound, this.mAlwaysConsumeSystemBars, this.mSuppressScrimTypes, null, this.mRoundedCorners, this.mPrivacyIndicatorBounds, this.mDisplayShape, this.mCompatInsetsTypes, this.mCompatIgnoreVisibility);
    }

    public boolean isConsumed() {
        return this.mSystemWindowInsetsConsumed && this.mStableInsetsConsumed && this.mDisplayCutoutConsumed;
    }

    public boolean isRound() {
        return this.mIsRound;
    }

    @Deprecated
    public WindowInsets consumeSystemWindowInsets() {
        return new WindowInsets(null, null, this.mTypeVisibilityMap, this.mIsRound, this.mAlwaysConsumeSystemBars, this.mSuppressScrimTypes, (this.mCompatInsetsTypes & Type.displayCutout()) != 0 ? null : displayCutoutCopyConstructorArgument(this), this.mRoundedCorners, this.mPrivacyIndicatorBounds, this.mDisplayShape, this.mCompatInsetsTypes, this.mCompatIgnoreVisibility);
    }

    @Deprecated
    public WindowInsets replaceSystemWindowInsets(int left, int top, int right, int bottom) {
        if (this.mSystemWindowInsetsConsumed) {
            return this;
        }
        return new Builder(this).setSystemWindowInsets(Insets.of(left, top, right, bottom)).build();
    }

    @Deprecated
    public WindowInsets replaceSystemWindowInsets(Rect systemWindowInsets) {
        return replaceSystemWindowInsets(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
    }

    @Deprecated
    public Insets getStableInsets() {
        return getInsets(this.mTypeMaxInsetsMap, Type.systemBars());
    }

    @Deprecated
    public int getStableInsetTop() {
        return getStableInsets().top;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetBottom() {
        return getStableInsets().bottom;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return getInsets(this.mTypeInsetsMap, 16);
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return getInsets(this.mTypeInsetsMap, 32);
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return getInsets(this.mTypeInsetsMap, 64);
    }

    @Deprecated
    public WindowInsets consumeStableInsets() {
        return this;
    }

    public boolean shouldAlwaysConsumeSystemBars() {
        return this.mAlwaysConsumeSystemBars;
    }

    public int getSuppressScrimTypes() {
        return this.mSuppressScrimTypes;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("WindowInsets{\n    ");
        for (int i10 = 0; i10 < 10; i10++) {
            Insets insets = this.mTypeInsetsMap[i10];
            Insets maxInsets = this.mTypeMaxInsetsMap[i10];
            boolean visible = this.mTypeVisibilityMap[i10];
            if (!Insets.NONE.equals(insets) || !Insets.NONE.equals(maxInsets) || visible) {
                result.append(Type.toString(1 << i10)).append("=").append((Object) insets).append(" max=").append((Object) maxInsets).append(" vis=").append(visible).append("\n    ");
            }
        }
        result.append(this.mDisplayCutout != null ? "cutout=" + ((Object) this.mDisplayCutout) : "");
        result.append("\n    ");
        result.append(this.mRoundedCorners != null ? "roundedCorners=" + ((Object) this.mRoundedCorners) : "");
        result.append("\n    ");
        result.append(this.mPrivacyIndicatorBounds != null ? "privacyIndicatorBounds=" + ((Object) this.mPrivacyIndicatorBounds) : "");
        result.append("\n    ");
        result.append(this.mDisplayShape != null ? "displayShape=" + ((Object) this.mDisplayShape) : "");
        result.append("\n    ");
        result.append("suppressScrimTypes=" + Type.toString(this.mSuppressScrimTypes));
        result.append("\n    ");
        result.append("compatInsetsTypes=" + Type.toString(this.mCompatInsetsTypes));
        result.append("\n    ");
        result.append("compatIgnoreVisibility=" + this.mCompatIgnoreVisibility);
        result.append("\n    ");
        result.append("systemWindowInsetsConsumed=" + this.mSystemWindowInsetsConsumed);
        result.append("\n    ");
        result.append("stableInsetsConsumed=" + this.mStableInsetsConsumed);
        result.append("\n    ");
        result.append("displayCutoutConsumed=" + this.mDisplayCutoutConsumed);
        result.append("\n    ");
        result.append(isRound() ? "round" : "");
        result.append(i.f4738d);
        return result.toString();
    }

    @Deprecated
    public WindowInsets inset(Rect r10) {
        return inset(r10.left, r10.top, r10.right, r10.bottom);
    }

    public WindowInsets inset(Insets insets) {
        Objects.requireNonNull(insets);
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public WindowInsets inset(int left, int top, int right, int bottom) {
        Preconditions.checkArgumentNonnegative(left);
        Preconditions.checkArgumentNonnegative(top);
        Preconditions.checkArgumentNonnegative(right);
        Preconditions.checkArgumentNonnegative(bottom);
        return insetUnchecked(left, top, right, bottom);
    }

    public WindowInsets insetUnchecked(int left, int top, int right, int bottom) {
        Insets[] insetInsets;
        Insets[] insetInsets2;
        DisplayCutout inset;
        RoundedCorners inset2;
        PrivacyIndicatorBounds inset3;
        if (this.mSystemWindowInsetsConsumed) {
            insetInsets = null;
        } else {
            insetInsets = insetInsets(this.mTypeInsetsMap, left, top, right, bottom);
        }
        if (this.mStableInsetsConsumed) {
            insetInsets2 = null;
        } else {
            insetInsets2 = insetInsets(this.mTypeMaxInsetsMap, left, top, right, bottom);
        }
        boolean[] zArr = this.mTypeVisibilityMap;
        boolean z10 = this.mIsRound;
        boolean z11 = this.mAlwaysConsumeSystemBars;
        int i10 = this.mSuppressScrimTypes;
        if (this.mDisplayCutoutConsumed) {
            inset = null;
        } else {
            DisplayCutout displayCutout = this.mDisplayCutout;
            if (displayCutout == null) {
                inset = DisplayCutout.NO_CUTOUT;
            } else {
                inset = displayCutout.inset(left, top, right, bottom);
            }
        }
        RoundedCorners roundedCorners = this.mRoundedCorners;
        if (roundedCorners == null) {
            inset2 = RoundedCorners.NO_ROUNDED_CORNERS;
        } else {
            inset2 = roundedCorners.inset(left, top, right, bottom);
        }
        PrivacyIndicatorBounds privacyIndicatorBounds = this.mPrivacyIndicatorBounds;
        if (privacyIndicatorBounds == null) {
            inset3 = null;
        } else {
            inset3 = privacyIndicatorBounds.inset(left, top, right, bottom);
        }
        return new WindowInsets(insetInsets, insetInsets2, zArr, z10, z11, i10, inset, inset2, inset3, this.mDisplayShape, this.mCompatInsetsTypes, this.mCompatIgnoreVisibility);
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || !(o10 instanceof WindowInsets)) {
            return false;
        }
        WindowInsets that = (WindowInsets) o10;
        if (this.mIsRound == that.mIsRound && this.mAlwaysConsumeSystemBars == that.mAlwaysConsumeSystemBars && this.mSuppressScrimTypes == that.mSuppressScrimTypes && this.mSystemWindowInsetsConsumed == that.mSystemWindowInsetsConsumed && this.mStableInsetsConsumed == that.mStableInsetsConsumed && this.mDisplayCutoutConsumed == that.mDisplayCutoutConsumed && Arrays.equals(this.mTypeInsetsMap, that.mTypeInsetsMap) && Arrays.equals(this.mTypeMaxInsetsMap, that.mTypeMaxInsetsMap) && Arrays.equals(this.mTypeVisibilityMap, that.mTypeVisibilityMap) && Objects.equals(this.mDisplayCutout, that.mDisplayCutout) && Objects.equals(this.mRoundedCorners, that.mRoundedCorners) && Objects.equals(this.mPrivacyIndicatorBounds, that.mPrivacyIndicatorBounds) && Objects.equals(this.mDisplayShape, that.mDisplayShape)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.mTypeInsetsMap)), Integer.valueOf(Arrays.hashCode(this.mTypeMaxInsetsMap)), Integer.valueOf(Arrays.hashCode(this.mTypeVisibilityMap)), Boolean.valueOf(this.mIsRound), this.mDisplayCutout, this.mRoundedCorners, Boolean.valueOf(this.mAlwaysConsumeSystemBars), Integer.valueOf(this.mSuppressScrimTypes), Boolean.valueOf(this.mSystemWindowInsetsConsumed), Boolean.valueOf(this.mStableInsetsConsumed), Boolean.valueOf(this.mDisplayCutoutConsumed), this.mPrivacyIndicatorBounds, this.mDisplayShape);
    }

    private static Insets[] insetInsets(Insets[] typeInsetsMap, int left, int top, int right, int bottom) {
        Insets insetInsets;
        boolean cloned = false;
        for (int i10 = 0; i10 < 10; i10++) {
            Insets insets = typeInsetsMap[i10];
            if (insets != null && (insetInsets = insetInsets(insets, left, top, right, bottom)) != insets) {
                if (!cloned) {
                    typeInsetsMap = (Insets[]) typeInsetsMap.clone();
                    cloned = true;
                }
                typeInsetsMap[i10] = insetInsets;
            }
        }
        return typeInsetsMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Insets insetInsets(Insets insets, int left, int top, int right, int bottom) {
        int newLeft = Math.max(0, insets.left - left);
        int newTop = Math.max(0, insets.top - top);
        int newRight = Math.max(0, insets.right - right);
        int newBottom = Math.max(0, insets.bottom - bottom);
        if (newLeft == left && newTop == top && newRight == right && newBottom == bottom) {
            return insets;
        }
        return Insets.of(newLeft, newTop, newRight, newBottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSystemWindowInsetsConsumed() {
        return this.mSystemWindowInsetsConsumed;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private boolean mAlwaysConsumeSystemBars;
        private DisplayCutout mDisplayCutout;
        private DisplayShape mDisplayShape;
        private boolean mIsRound;
        private PrivacyIndicatorBounds mPrivacyIndicatorBounds;
        private RoundedCorners mRoundedCorners;
        private boolean mStableInsetsConsumed;
        private int mSuppressScrimTypes;
        private boolean mSystemInsetsConsumed;
        private final Insets[] mTypeInsetsMap;
        private final Insets[] mTypeMaxInsetsMap;
        private final boolean[] mTypeVisibilityMap;

        public Builder() {
            this.mSystemInsetsConsumed = true;
            this.mStableInsetsConsumed = true;
            this.mRoundedCorners = RoundedCorners.NO_ROUNDED_CORNERS;
            this.mDisplayShape = DisplayShape.NONE;
            this.mPrivacyIndicatorBounds = new PrivacyIndicatorBounds();
            this.mTypeInsetsMap = new Insets[10];
            this.mTypeMaxInsetsMap = new Insets[10];
            this.mTypeVisibilityMap = new boolean[10];
        }

        public Builder(WindowInsets insets) {
            this.mSystemInsetsConsumed = true;
            this.mStableInsetsConsumed = true;
            this.mRoundedCorners = RoundedCorners.NO_ROUNDED_CORNERS;
            this.mDisplayShape = DisplayShape.NONE;
            this.mPrivacyIndicatorBounds = new PrivacyIndicatorBounds();
            this.mTypeInsetsMap = (Insets[]) insets.mTypeInsetsMap.clone();
            this.mTypeMaxInsetsMap = (Insets[]) insets.mTypeMaxInsetsMap.clone();
            this.mTypeVisibilityMap = (boolean[]) insets.mTypeVisibilityMap.clone();
            this.mSystemInsetsConsumed = insets.mSystemWindowInsetsConsumed;
            this.mStableInsetsConsumed = insets.mStableInsetsConsumed;
            this.mDisplayCutout = WindowInsets.displayCutoutCopyConstructorArgument(insets);
            this.mRoundedCorners = insets.mRoundedCorners;
            this.mIsRound = insets.mIsRound;
            this.mAlwaysConsumeSystemBars = insets.mAlwaysConsumeSystemBars;
            this.mSuppressScrimTypes = insets.mSuppressScrimTypes;
            this.mPrivacyIndicatorBounds = insets.mPrivacyIndicatorBounds;
            this.mDisplayShape = insets.mDisplayShape;
        }

        @Deprecated
        public Builder setSystemWindowInsets(Insets systemWindowInsets) {
            Preconditions.checkNotNull(systemWindowInsets);
            WindowInsets.assignCompatInsets(this.mTypeInsetsMap, systemWindowInsets.toRect());
            this.mSystemInsetsConsumed = false;
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(Insets insets) {
            WindowInsets.setInsets(this.mTypeInsetsMap, 16, insets);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(Insets insets) {
            WindowInsets.setInsets(this.mTypeInsetsMap, 32, insets);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(Insets insets) {
            WindowInsets.setInsets(this.mTypeInsetsMap, 64, insets);
            return this;
        }

        public Builder setInsets(int typeMask, Insets insets) {
            Preconditions.checkNotNull(insets);
            WindowInsets.setInsets(this.mTypeInsetsMap, typeMask, insets);
            this.mSystemInsetsConsumed = false;
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int typeMask, Insets insets) throws IllegalArgumentException {
            if (typeMask == 8) {
                throw new IllegalArgumentException("Maximum inset not available for IME");
            }
            Preconditions.checkNotNull(insets);
            WindowInsets.setInsets(this.mTypeMaxInsetsMap, typeMask, insets);
            this.mStableInsetsConsumed = false;
            return this;
        }

        public Builder setVisible(int typeMask, boolean visible) {
            for (int i10 = 1; i10 <= 512; i10 <<= 1) {
                if ((typeMask & i10) != 0) {
                    this.mTypeVisibilityMap[Type.indexOf(i10)] = visible;
                }
            }
            return this;
        }

        @Deprecated
        public Builder setStableInsets(Insets stableInsets) {
            Preconditions.checkNotNull(stableInsets);
            WindowInsets.assignCompatInsets(this.mTypeMaxInsetsMap, stableInsets.toRect());
            this.mStableInsetsConsumed = false;
            return this;
        }

        public Builder setDisplayCutout(DisplayCutout displayCutout) {
            DisplayCutout displayCutout2 = displayCutout != null ? displayCutout : DisplayCutout.NO_CUTOUT;
            this.mDisplayCutout = displayCutout2;
            if (!displayCutout2.isEmpty()) {
                Insets safeInsets = Insets.of(this.mDisplayCutout.getSafeInsets());
                int index = Type.indexOf(128);
                this.mTypeInsetsMap[index] = safeInsets;
                this.mTypeMaxInsetsMap[index] = safeInsets;
                this.mTypeVisibilityMap[index] = true;
            }
            return this;
        }

        public Builder setRoundedCorners(RoundedCorners roundedCorners) {
            this.mRoundedCorners = roundedCorners != null ? roundedCorners : RoundedCorners.NO_ROUNDED_CORNERS;
            return this;
        }

        public Builder setRoundedCorner(int position, RoundedCorner roundedCorner) {
            this.mRoundedCorners.setRoundedCorner(position, roundedCorner);
            return this;
        }

        public Builder setPrivacyIndicatorBounds(PrivacyIndicatorBounds bounds) {
            this.mPrivacyIndicatorBounds = bounds;
            return this;
        }

        public Builder setPrivacyIndicatorBounds(Rect bounds) {
            Rect[] boundsArr = {bounds, bounds, bounds, bounds};
            this.mPrivacyIndicatorBounds = new PrivacyIndicatorBounds(boundsArr, 0);
            return this;
        }

        public Builder setDisplayShape(DisplayShape displayShape) {
            this.mDisplayShape = displayShape;
            return this;
        }

        public Builder setRound(boolean round) {
            this.mIsRound = round;
            return this;
        }

        public Builder setAlwaysConsumeSystemBars(boolean alwaysConsumeSystemBars) {
            this.mAlwaysConsumeSystemBars = alwaysConsumeSystemBars;
            return this;
        }

        public Builder setSuppressScrimTypes(int suppressScrimTypes) {
            this.mSuppressScrimTypes = suppressScrimTypes;
            return this;
        }

        public WindowInsets build() {
            return new WindowInsets(this.mSystemInsetsConsumed ? null : this.mTypeInsetsMap, this.mStableInsetsConsumed ? null : this.mTypeMaxInsetsMap, this.mTypeVisibilityMap, this.mIsRound, this.mAlwaysConsumeSystemBars, this.mSuppressScrimTypes, this.mDisplayCutout, this.mRoundedCorners, this.mPrivacyIndicatorBounds, this.mDisplayShape, Type.systemBars(), false);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DEFAULT_VISIBLE = -9;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 512;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 10;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int SYSTEM_OVERLAYS = 512;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public @interface InsetsType {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int indexOf(int type) {
            switch (type) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 4:
                    return 2;
                case 8:
                    return 3;
                case 16:
                    return 4;
                case 32:
                    return 5;
                case 64:
                    return 6;
                case 128:
                    return 7;
                case 256:
                    return 8;
                case 512:
                    return 9;
                default:
                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + type);
            }
        }

        public static String toString(int types) {
            StringBuilder result = new StringBuilder();
            if ((types & 1) != 0) {
                result.append("statusBars ");
            }
            if ((types & 2) != 0) {
                result.append("navigationBars ");
            }
            if ((types & 4) != 0) {
                result.append("captionBar ");
            }
            if ((types & 8) != 0) {
                result.append("ime ");
            }
            if ((types & 16) != 0) {
                result.append("systemGestures ");
            }
            if ((types & 32) != 0) {
                result.append("mandatorySystemGestures ");
            }
            if ((types & 64) != 0) {
                result.append("tappableElement ");
            }
            if ((types & 128) != 0) {
                result.append("displayCutout ");
            }
            if ((types & 256) != 0) {
                result.append("windowDecor ");
            }
            if ((types & 512) != 0) {
                result.append("systemOverlays ");
            }
            if (result.length() > 0) {
                result.delete(result.length() - 1, result.length());
            }
            return result.toString();
        }

        private Type() {
        }

        public static int statusBars() {
            return 1;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int captionBar() {
            return 4;
        }

        public static int ime() {
            return 8;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int tappableElement() {
            return 64;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int systemOverlays() {
            return 512;
        }

        public static int systemBars() {
            return MetricsProto.MetricsEvent.PROVISIONING_PROVISIONING_ACTIVITY_TIME_MS;
        }

        public static int defaultVisible() {
            return -9;
        }

        public static int all() {
            return -1;
        }

        public static boolean hasCompatSystemBars(int types) {
            return (types & 3) != 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Side {
        public static final int BOTTOM = 8;
        public static final int LEFT = 1;
        public static final int RIGHT = 4;
        public static final int TOP = 2;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public @interface InsetsSide {
        }

        private Side() {
        }

        public static int all() {
            return 15;
        }
    }

    public WindowInsets removeCutoutInsets() {
        int compatInsetsTypes = this.mCompatInsetsTypes & (-129);
        WindowInsets insets = new WindowInsets(this.mSystemWindowInsetsConsumed ? null : this.mTypeInsetsMap, this.mStableInsetsConsumed ? null : this.mTypeMaxInsetsMap, this.mTypeVisibilityMap, this.mIsRound, this.mAlwaysConsumeSystemBars, this.mSuppressScrimTypes, DisplayCutout.NO_CUTOUT, this.mRoundedCorners, this.mPrivacyIndicatorBounds, this.mDisplayShape, compatInsetsTypes, false);
        int index = Type.indexOf(128);
        insets.mTypeInsetsMap[index] = null;
        insets.mTypeMaxInsetsMap[index] = null;
        insets.mTypeVisibilityMap[index] = false;
        return insets;
    }
}

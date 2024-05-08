package android.view;

import android.app.WindowConfiguration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemProperties;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.StringJoiner;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InsetsState implements Parcelable {
    static final int ISIDE_BOTTOM = 3;
    static final int ISIDE_FLOATING = 4;
    static final int ISIDE_LEFT = 0;
    static final int ISIDE_RIGHT = 2;
    static final int ISIDE_TOP = 1;
    static final int ISIDE_UNKNOWN = 5;
    private final DisplayCutout.ParcelableWrapper mDisplayCutout;
    private final Rect mDisplayFrame;
    private DisplayShape mDisplayShape;
    private final IInsetsStateExt mExt;
    private PrivacyIndicatorBounds mPrivacyIndicatorBounds;
    private final Rect mRoundedCornerFrame;
    private RoundedCorners mRoundedCorners;
    private final SparseArray<InsetsSource> mSources;
    private final IInsetsStateWrapper mWrapper;
    static boolean LTW_DISABLE = SystemProperties.getBoolean("persist.sys.ltw.disable", false);
    public static final Parcelable.Creator<InsetsState> CREATOR = new Parcelable.Creator<InsetsState>() { // from class: android.view.InsetsState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsetsState createFromParcel(Parcel in) {
            return new InsetsState(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsetsState[] newArray(int size) {
            return new InsetsState[size];
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface InternalInsetsSide {
    }

    public InsetsState() {
        this.mDisplayFrame = new Rect();
        this.mDisplayCutout = new DisplayCutout.ParcelableWrapper();
        this.mRoundedCornerFrame = new Rect();
        this.mRoundedCorners = RoundedCorners.NO_ROUNDED_CORNERS;
        this.mPrivacyIndicatorBounds = new PrivacyIndicatorBounds();
        this.mDisplayShape = DisplayShape.NONE;
        this.mWrapper = new InsetsStateWrapper();
        this.mExt = (IInsetsStateExt) ExtLoader.type(IInsetsStateExt.class).base(this).create();
        this.mSources = new SparseArray<>();
    }

    public InsetsState(InsetsState copy) {
        this(copy, false);
    }

    public InsetsState(InsetsState copy, boolean copySources) {
        this.mDisplayFrame = new Rect();
        this.mDisplayCutout = new DisplayCutout.ParcelableWrapper();
        this.mRoundedCornerFrame = new Rect();
        this.mRoundedCorners = RoundedCorners.NO_ROUNDED_CORNERS;
        this.mPrivacyIndicatorBounds = new PrivacyIndicatorBounds();
        this.mDisplayShape = DisplayShape.NONE;
        this.mWrapper = new InsetsStateWrapper();
        this.mExt = (IInsetsStateExt) ExtLoader.type(IInsetsStateExt.class).base(this).create();
        this.mSources = new SparseArray<>(copy.mSources.size());
        set(copy, copySources);
    }

    public WindowInsets calculateInsets(Rect frame, InsetsState ignoringVisibilityState, boolean isScreenRound, boolean alwaysConsumeSystemBars, int legacySoftInputMode, int legacyWindowFlags, int legacySystemUiFlags, int windowType, int windowingMode, SparseIntArray idSideMap) {
        int suppressScrimTypes;
        int i10;
        boolean[] typeVisibilityMap;
        Insets[] typeMaxInsetsMap;
        Insets[] typeInsetsMap;
        InsetsSource insetsSource;
        InsetsState insetsState = ignoringVisibilityState;
        Insets[] typeInsetsMap2 = new Insets[10];
        Insets[] typeMaxInsetsMap2 = new Insets[10];
        boolean[] typeVisibilityMap2 = new boolean[10];
        Rect relativeFrame = new Rect(frame);
        Rect relativeFrameMax = new Rect(frame);
        int suppressScrimTypes2 = 0;
        int i11 = this.mSources.size() - 1;
        while (i11 >= 0) {
            InsetsSource source = this.mSources.valueAt(i11);
            if ((source.getFlags() & 1) == 0) {
                suppressScrimTypes = suppressScrimTypes2;
            } else {
                suppressScrimTypes = suppressScrimTypes2 | source.getType();
            }
            if (!LTW_DISABLE) {
                this.mExt.updateInsetSource(source, source.getType(), new Rect(frame));
            }
            processSource(source, relativeFrame, false, typeInsetsMap2, idSideMap, typeVisibilityMap2);
            if (source.getType() == WindowInsets.Type.ime()) {
                i10 = i11;
                typeVisibilityMap = typeVisibilityMap2;
                typeMaxInsetsMap = typeMaxInsetsMap2;
                typeInsetsMap = typeInsetsMap2;
            } else {
                if (insetsState != null) {
                    insetsSource = insetsState.peekSource(source.getId());
                } else {
                    insetsSource = source;
                }
                InsetsSource ignoringVisibilitySource = insetsSource;
                if (ignoringVisibilitySource == null) {
                    i10 = i11;
                    typeVisibilityMap = typeVisibilityMap2;
                    typeMaxInsetsMap = typeMaxInsetsMap2;
                    typeInsetsMap = typeInsetsMap2;
                } else {
                    i10 = i11;
                    typeVisibilityMap = typeVisibilityMap2;
                    typeMaxInsetsMap = typeMaxInsetsMap2;
                    typeInsetsMap = typeInsetsMap2;
                    processSource(ignoringVisibilitySource, relativeFrameMax, true, typeMaxInsetsMap, null, null);
                }
            }
            i11 = i10 - 1;
            insetsState = ignoringVisibilityState;
            typeInsetsMap2 = typeInsetsMap;
            typeVisibilityMap2 = typeVisibilityMap;
            suppressScrimTypes2 = suppressScrimTypes;
            typeMaxInsetsMap2 = typeMaxInsetsMap;
        }
        boolean[] typeVisibilityMap3 = typeVisibilityMap2;
        Insets[] typeMaxInsetsMap3 = typeMaxInsetsMap2;
        Insets[] typeInsetsMap3 = typeInsetsMap2;
        int softInputAdjustMode = legacySoftInputMode & 240;
        int compatInsetsTypes = WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        if (softInputAdjustMode == 16) {
            compatInsetsTypes |= WindowInsets.Type.ime();
        }
        if ((legacyWindowFlags & 1024) != 0) {
            compatInsetsTypes &= ~WindowInsets.Type.statusBars();
        }
        if (clearsCompatInsets(windowType, legacyWindowFlags, windowingMode) && !alwaysConsumeSystemBars) {
            compatInsetsTypes = 0;
        }
        return new WindowInsets(typeInsetsMap3, typeMaxInsetsMap3, typeVisibilityMap3, isScreenRound, alwaysConsumeSystemBars, suppressScrimTypes2, calculateRelativeCutout(frame), calculateRelativeRoundedCorners(frame), calculateRelativePrivacyIndicatorBounds(frame), calculateRelativeDisplayShape(frame), compatInsetsTypes, (legacySystemUiFlags & 256) != 0);
    }

    private DisplayCutout calculateRelativeCutout(Rect frame) {
        DisplayCutout raw = this.mDisplayCutout.get();
        if (this.mDisplayFrame.equals(frame)) {
            return raw;
        }
        if (frame == null) {
            return DisplayCutout.NO_CUTOUT;
        }
        int insetLeft = frame.left - this.mDisplayFrame.left;
        int insetTop = frame.top - this.mDisplayFrame.top;
        int insetRight = this.mDisplayFrame.right - frame.right;
        int insetBottom = this.mDisplayFrame.bottom - frame.bottom;
        if (insetLeft >= raw.getSafeInsetLeft() && insetTop >= raw.getSafeInsetTop() && insetRight >= raw.getSafeInsetRight() && insetBottom >= raw.getSafeInsetBottom()) {
            return DisplayCutout.NO_CUTOUT;
        }
        return raw.inset(insetLeft, insetTop, insetRight, insetBottom);
    }

    private RoundedCorners calculateRelativeRoundedCorners(Rect frame) {
        if (frame == null) {
            return RoundedCorners.NO_ROUNDED_CORNERS;
        }
        Rect roundedCornerFrame = new Rect(this.mRoundedCornerFrame);
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            if (source.insetsRoundedCornerFrame()) {
                Insets insets = source.calculateInsets(roundedCornerFrame, false);
                roundedCornerFrame.inset(insets);
            }
        }
        if (!roundedCornerFrame.isEmpty() && !roundedCornerFrame.equals(this.mDisplayFrame)) {
            return this.mRoundedCorners.insetWithFrame(frame, roundedCornerFrame);
        }
        if (this.mDisplayFrame.equals(frame)) {
            return this.mRoundedCorners;
        }
        int insetLeft = frame.left - this.mDisplayFrame.left;
        int insetTop = frame.top - this.mDisplayFrame.top;
        int insetRight = this.mDisplayFrame.right - frame.right;
        int insetBottom = this.mDisplayFrame.bottom - frame.bottom;
        return this.mRoundedCorners.inset(insetLeft, insetTop, insetRight, insetBottom);
    }

    private PrivacyIndicatorBounds calculateRelativePrivacyIndicatorBounds(Rect frame) {
        if (this.mDisplayFrame.equals(frame)) {
            return this.mPrivacyIndicatorBounds;
        }
        if (frame == null) {
            return null;
        }
        int insetLeft = frame.left - this.mDisplayFrame.left;
        int insetTop = frame.top - this.mDisplayFrame.top;
        int insetRight = this.mDisplayFrame.right - frame.right;
        int insetBottom = this.mDisplayFrame.bottom - frame.bottom;
        return this.mPrivacyIndicatorBounds.inset(insetLeft, insetTop, insetRight, insetBottom);
    }

    private DisplayShape calculateRelativeDisplayShape(Rect frame) {
        if (this.mDisplayFrame.equals(frame)) {
            return this.mDisplayShape;
        }
        if (frame == null) {
            return DisplayShape.NONE;
        }
        return this.mDisplayShape.setOffset(-frame.left, -frame.top);
    }

    public Insets calculateInsets(Rect frame, int types, boolean ignoreVisibility) {
        Insets insets = Insets.NONE;
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            if ((source.getType() & types) != 0) {
                insets = Insets.max(source.calculateInsets(frame, ignoreVisibility), insets);
            }
        }
        return insets;
    }

    public Insets calculateInsets(Rect frame, int types, int requestedVisibleTypes) {
        Insets insets = Insets.NONE;
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            if ((source.getType() & types & requestedVisibleTypes) != 0) {
                insets = Insets.max(source.calculateInsets(frame, true), insets);
            }
        }
        return insets;
    }

    public Insets calculateVisibleInsets(Rect frame, int windowType, int windowingMode, int softInputMode, int windowFlags) {
        int visibleInsetsTypes;
        if (clearsCompatInsets(windowType, windowFlags, windowingMode)) {
            return Insets.NONE;
        }
        int softInputAdjustMode = softInputMode & 240;
        if (softInputAdjustMode != 48) {
            visibleInsetsTypes = WindowInsets.Type.systemBars() | WindowInsets.Type.ime();
        } else {
            visibleInsetsTypes = WindowInsets.Type.systemBars();
        }
        Insets insets = Insets.NONE;
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            if ((source.getType() & visibleInsetsTypes) != 0) {
                insets = Insets.max(source.calculateVisibleInsets(frame), insets);
            }
        }
        return insets;
    }

    public int calculateUncontrollableInsetsFromFrame(Rect frame) {
        int blocked = 0;
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            if (!canControlSource(frame, source)) {
                blocked |= source.getType();
            }
        }
        return blocked;
    }

    private static boolean canControlSource(Rect frame, InsetsSource source) {
        Insets insets = source.calculateInsets(frame, true);
        Rect sourceFrame = source.getFrame();
        int sourceWidth = sourceFrame.width();
        int sourceHeight = sourceFrame.height();
        return insets.left == sourceWidth || insets.right == sourceWidth || insets.top == sourceHeight || insets.bottom == sourceHeight;
    }

    private void processSource(InsetsSource source, Rect relativeFrame, boolean ignoreVisibility, Insets[] typeInsetsMap, SparseIntArray idSideMap, boolean[] typeVisibilityMap) {
        Insets insets = source.calculateInsets(relativeFrame, ignoreVisibility);
        int type = source.getType();
        processSourceAsPublicType(source, typeInsetsMap, idSideMap, typeVisibilityMap, insets, type);
        if (type == 32) {
            processSourceAsPublicType(source, typeInsetsMap, idSideMap, typeVisibilityMap, insets, 16);
        }
        if (type == 4) {
            processSourceAsPublicType(source, typeInsetsMap, idSideMap, typeVisibilityMap, insets, 16);
            processSourceAsPublicType(source, typeInsetsMap, idSideMap, typeVisibilityMap, insets, 32);
            processSourceAsPublicType(source, typeInsetsMap, idSideMap, typeVisibilityMap, insets, 64);
        }
    }

    private void processSourceAsPublicType(InsetsSource source, Insets[] typeInsetsMap, SparseIntArray idSideMap, boolean[] typeVisibilityMap, Insets insets, int type) {
        int insetSide;
        int index = WindowInsets.Type.indexOf(type);
        Insets existing = typeInsetsMap[index];
        if (existing == null) {
            typeInsetsMap[index] = insets;
        } else {
            typeInsetsMap[index] = Insets.max(existing, insets);
        }
        if (typeVisibilityMap != null) {
            typeVisibilityMap[index] = source.isVisible();
        }
        if (idSideMap != null && (insetSide = getInsetSide(insets)) != 5) {
            idSideMap.put(source.getId(), insetSide);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInsetSide(Insets insets) {
        if (Insets.NONE.equals(insets)) {
            return 4;
        }
        if (insets.left != 0) {
            return 0;
        }
        if (insets.top != 0) {
            return 1;
        }
        if (insets.right != 0) {
            return 2;
        }
        if (insets.bottom != 0) {
            return 3;
        }
        return 5;
    }

    public InsetsSource getOrCreateSource(int id2, int type) {
        InsetsSource source = this.mSources.get(id2);
        if (source != null) {
            return source;
        }
        InsetsSource source2 = new InsetsSource(id2, type);
        this.mSources.put(id2, source2);
        return source2;
    }

    public InsetsSource peekSource(int id2) {
        return this.mSources.get(id2);
    }

    public int sourceIdAt(int index) {
        return this.mSources.keyAt(index);
    }

    public InsetsSource sourceAt(int index) {
        return this.mSources.valueAt(index);
    }

    public int sourceSize() {
        return this.mSources.size();
    }

    public boolean isSourceOrDefaultVisible(int id2, int type) {
        InsetsSource source = this.mSources.get(id2);
        return source != null ? source.isVisible() : (WindowInsets.Type.defaultVisible() & type) != 0;
    }

    public void setDisplayFrame(Rect frame) {
        this.mDisplayFrame.set(frame);
    }

    public Rect getDisplayFrame() {
        return this.mDisplayFrame;
    }

    public void setDisplayCutout(DisplayCutout cutout) {
        this.mDisplayCutout.set(cutout);
    }

    public DisplayCutout getDisplayCutout() {
        return this.mDisplayCutout.get();
    }

    public void getDisplayCutoutSafe(Rect outBounds) {
        outBounds.set(-100000, -100000, 100000, 100000);
        DisplayCutout cutout = this.mDisplayCutout.get();
        Rect displayFrame = this.mDisplayFrame;
        if (!cutout.isEmpty()) {
            if (cutout.getSafeInsetLeft() > 0) {
                outBounds.left = displayFrame.left + cutout.getSafeInsetLeft();
            }
            if (cutout.getSafeInsetTop() > 0) {
                outBounds.top = displayFrame.top + cutout.getSafeInsetTop();
            }
            if (cutout.getSafeInsetRight() > 0) {
                outBounds.right = displayFrame.right - cutout.getSafeInsetRight();
            }
            if (cutout.getSafeInsetBottom() > 0) {
                outBounds.bottom = displayFrame.bottom - cutout.getSafeInsetBottom();
            }
        }
    }

    public void setRoundedCorners(RoundedCorners roundedCorners) {
        this.mRoundedCorners = roundedCorners;
    }

    public RoundedCorners getRoundedCorners() {
        return this.mRoundedCorners;
    }

    public void setRoundedCornerFrame(Rect frame) {
        this.mRoundedCornerFrame.set(frame);
    }

    public void setPrivacyIndicatorBounds(PrivacyIndicatorBounds bounds) {
        this.mPrivacyIndicatorBounds = bounds;
    }

    public PrivacyIndicatorBounds getPrivacyIndicatorBounds() {
        return this.mPrivacyIndicatorBounds;
    }

    public void setDisplayShape(DisplayShape displayShape) {
        this.mDisplayShape = displayShape;
    }

    public DisplayShape getDisplayShape() {
        return this.mDisplayShape;
    }

    public void removeSource(int id2) {
        this.mSources.delete(id2);
    }

    public void removeSourceAt(int index) {
        this.mSources.removeAt(index);
    }

    public void setSourceVisible(int id2, boolean visible) {
        InsetsSource source = this.mSources.get(id2);
        if (source != null) {
            source.setVisible(visible);
        }
    }

    public void scale(float scale) {
        this.mDisplayFrame.scale(scale);
        this.mDisplayCutout.scale(scale);
        this.mRoundedCorners = this.mRoundedCorners.scale(scale);
        this.mRoundedCornerFrame.scale(scale);
        this.mPrivacyIndicatorBounds = this.mPrivacyIndicatorBounds.scale(scale);
        this.mDisplayShape = this.mDisplayShape.setScale(scale);
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            source.getFrame().scale(scale);
            Rect visibleFrame = source.getVisibleFrame();
            if (visibleFrame != null) {
                visibleFrame.scale(scale);
            }
        }
    }

    public void set(InsetsState other) {
        set(other, false);
    }

    public void set(InsetsState other, boolean copySources) {
        InsetsSource insetsSource;
        this.mDisplayFrame.set(other.mDisplayFrame);
        this.mDisplayCutout.set(other.mDisplayCutout);
        this.mRoundedCorners = other.getRoundedCorners();
        this.mRoundedCornerFrame.set(other.mRoundedCornerFrame);
        this.mPrivacyIndicatorBounds = other.getPrivacyIndicatorBounds();
        this.mDisplayShape = other.getDisplayShape();
        this.mSources.clear();
        int size = other.mSources.size();
        for (int i10 = 0; i10 < size; i10++) {
            InsetsSource otherSource = other.mSources.valueAt(i10);
            SparseArray<InsetsSource> sparseArray = this.mSources;
            int id2 = otherSource.getId();
            if (copySources) {
                insetsSource = new InsetsSource(otherSource);
            } else {
                insetsSource = otherSource;
            }
            sparseArray.append(id2, insetsSource);
        }
        this.mExt.setExtraDisplayCutoutMode(other.mExt.getExtraDisplayCutoutMode());
    }

    public void set(InsetsState other, int types) {
        this.mDisplayFrame.set(other.mDisplayFrame);
        this.mDisplayCutout.set(other.mDisplayCutout);
        this.mRoundedCorners = other.getRoundedCorners();
        this.mRoundedCornerFrame.set(other.mRoundedCornerFrame);
        this.mPrivacyIndicatorBounds = other.getPrivacyIndicatorBounds();
        this.mDisplayShape = other.getDisplayShape();
        this.mExt.setExtraDisplayCutoutMode(other.mExt.getExtraDisplayCutoutMode());
        if (types == 0) {
            return;
        }
        for (int i10 = this.mSources.size() - 1; i10 >= 0; i10--) {
            InsetsSource source = this.mSources.valueAt(i10);
            if ((source.getType() & types) != 0) {
                this.mSources.removeAt(i10);
            }
        }
        for (int i11 = other.mSources.size() - 1; i11 >= 0; i11--) {
            InsetsSource otherSource = other.mSources.valueAt(i11);
            if ((otherSource.getType() & types) != 0) {
                this.mSources.put(otherSource.getId(), otherSource);
            }
        }
    }

    public void addSource(InsetsSource source) {
        this.mSources.put(source.getId(), source);
    }

    public static boolean clearsCompatInsets(int windowType, int windowFlags, int windowingMode) {
        return ((windowFlags & 512) == 0 || windowType == 2013 || windowType == 2010 || WindowConfiguration.inMultiWindowMode(windowingMode) || windowingMode == 100) ? false : true;
    }

    public void dump(String prefix, PrintWriter pw) {
        String newPrefix = prefix + "  ";
        pw.println(prefix + "InsetsState");
        pw.println(newPrefix + "mDisplayFrame=" + ((Object) this.mDisplayFrame));
        pw.println(newPrefix + "mDisplayCutout=" + ((Object) this.mDisplayCutout.get()));
        pw.println(newPrefix + "mRoundedCorners=" + ((Object) this.mRoundedCorners));
        pw.println(newPrefix + "mRoundedCornerFrame=" + ((Object) this.mRoundedCornerFrame));
        pw.println(newPrefix + "mPrivacyIndicatorBounds=" + ((Object) this.mPrivacyIndicatorBounds));
        pw.println(newPrefix + "mDisplayShape=" + ((Object) this.mDisplayShape));
        int cutoutMode = this.mExt.getExtraDisplayCutoutMode();
        if (cutoutMode != -1) {
            pw.println(newPrefix + "mExtraDisplayCutoutMode=" + cutoutMode);
        }
        int size = this.mSources.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mSources.valueAt(i10).dump(newPrefix + "  ", pw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        InsetsSource source = this.mSources.get(InsetsSource.ID_IME);
        if (source != null) {
            source.dumpDebug(proto, 2246267895809L);
        }
        this.mDisplayFrame.dumpDebug(proto, 1146756268034L);
        this.mDisplayCutout.get().dumpDebug(proto, 1146756268035L);
        proto.end(token);
    }

    public boolean equals(Object o10) {
        return equals(o10, false, false);
    }

    public boolean equals(Object o10, boolean excludingCaptionInsets, boolean excludeInvisibleImeFrames) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        InsetsState state = (InsetsState) o10;
        if (!this.mDisplayFrame.equals(state.mDisplayFrame) || !this.mDisplayCutout.equals(state.mDisplayCutout) || !this.mRoundedCorners.equals(state.mRoundedCorners) || !this.mRoundedCornerFrame.equals(state.mRoundedCornerFrame) || !this.mPrivacyIndicatorBounds.equals(state.mPrivacyIndicatorBounds) || !this.mDisplayShape.equals(state.mDisplayShape) || this.mExt.getExtraDisplayCutoutMode() != state.mExt.getExtraDisplayCutoutMode()) {
            return false;
        }
        SparseArray<InsetsSource> thisSources = this.mSources;
        SparseArray<InsetsSource> thatSources = state.mSources;
        if (!excludingCaptionInsets && !excludeInvisibleImeFrames) {
            return thisSources.contentEquals(thatSources);
        }
        int thisSize = thisSources.size();
        int thatSize = thatSources.size();
        int thisIndex = 0;
        int thatIndex = 0;
        while (thisIndex < thisSize && thatIndex < thatSize) {
            InsetsSource thisSource = thisSources.valueAt(thisIndex);
            while (true) {
                InsetsSource insetsSource = null;
                if (thisSource == null || !((excludingCaptionInsets && thisSource.getType() == WindowInsets.Type.captionBar()) || (excludeInvisibleImeFrames && thisSource.getType() == WindowInsets.Type.ime() && !thisSource.isVisible()))) {
                    break;
                }
                thisIndex++;
                if (thisIndex < thisSize) {
                    insetsSource = thisSources.valueAt(thisIndex);
                }
                thisSource = insetsSource;
            }
            InsetsSource thatSource = thatSources.valueAt(thatIndex);
            while (thatSource != null && ((excludingCaptionInsets && thatSource.getType() == WindowInsets.Type.captionBar()) || (excludeInvisibleImeFrames && thatSource.getType() == WindowInsets.Type.ime() && !thatSource.isVisible()))) {
                thatIndex++;
                thatSource = thatIndex < thatSize ? thatSources.valueAt(thatIndex) : null;
            }
            if (!Objects.equals(thisSource, thatSource)) {
                return false;
            }
            thisIndex++;
            thatIndex++;
        }
        return thisIndex >= thisSize && thatIndex >= thatSize;
    }

    public int hashCode() {
        return Objects.hash(this.mDisplayFrame, this.mDisplayCutout, Integer.valueOf(this.mSources.contentHashCode()), this.mRoundedCorners, this.mPrivacyIndicatorBounds, this.mRoundedCornerFrame, this.mDisplayShape, Integer.valueOf(this.mExt.getExtraDisplayCutoutMode()));
    }

    public InsetsState(Parcel in) {
        this.mDisplayFrame = new Rect();
        this.mDisplayCutout = new DisplayCutout.ParcelableWrapper();
        this.mRoundedCornerFrame = new Rect();
        this.mRoundedCorners = RoundedCorners.NO_ROUNDED_CORNERS;
        this.mPrivacyIndicatorBounds = new PrivacyIndicatorBounds();
        this.mDisplayShape = DisplayShape.NONE;
        this.mWrapper = new InsetsStateWrapper();
        this.mExt = (IInsetsStateExt) ExtLoader.type(IInsetsStateExt.class).base(this).create();
        this.mSources = readFromParcel(in);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        this.mDisplayFrame.writeToParcel(dest, flags);
        this.mDisplayCutout.writeToParcel(dest, flags);
        dest.writeTypedObject(this.mRoundedCorners, flags);
        this.mRoundedCornerFrame.writeToParcel(dest, flags);
        dest.writeTypedObject(this.mPrivacyIndicatorBounds, flags);
        dest.writeTypedObject(this.mDisplayShape, flags);
        int size = this.mSources.size();
        dest.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            dest.writeTypedObject(this.mSources.valueAt(i10), flags);
        }
        this.mExt.writeToParcel(dest);
    }

    public SparseArray<InsetsSource> readFromParcel(Parcel in) {
        SparseArray<InsetsSource> sources;
        this.mDisplayFrame.readFromParcel(in);
        this.mDisplayCutout.readFromParcel(in);
        this.mRoundedCorners = (RoundedCorners) in.readTypedObject(RoundedCorners.CREATOR);
        this.mRoundedCornerFrame.readFromParcel(in);
        this.mPrivacyIndicatorBounds = (PrivacyIndicatorBounds) in.readTypedObject(PrivacyIndicatorBounds.CREATOR);
        this.mDisplayShape = (DisplayShape) in.readTypedObject(DisplayShape.CREATOR);
        int size = in.readInt();
        if (this.mSources == null) {
            sources = new SparseArray<>(size);
        } else {
            sources = this.mSources;
            sources.clear();
        }
        for (int i10 = 0; i10 < size; i10++) {
            InsetsSource source = (InsetsSource) in.readTypedObject(InsetsSource.CREATOR);
            sources.append(source.getId(), source);
        }
        this.mExt.readFromParcel(in);
        return sources;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        int size = this.mSources.size();
        for (int i10 = 0; i10 < size; i10++) {
            joiner.add(this.mSources.valueAt(i10).toString());
        }
        return "InsetsState: {mDisplayFrame=" + ((Object) this.mDisplayFrame) + ", mDisplayCutout=" + ((Object) this.mDisplayCutout) + ", mRoundedCorners=" + ((Object) this.mRoundedCorners) + "  mRoundedCornerFrame=" + ((Object) this.mRoundedCornerFrame) + ", mPrivacyIndicatorBounds=" + ((Object) this.mPrivacyIndicatorBounds) + ", mDisplayShape=" + ((Object) this.mDisplayShape) + ", mExtraDisplayCutoutMode=" + this.mExt.getExtraDisplayCutoutMode() + ", mSources= { " + ((Object) joiner) + " }";
    }

    public static void traverse(InsetsState state1, InsetsState state2, OnTraverseCallbacks cb2) {
        cb2.onStart(state1, state2);
        int size1 = state1.sourceSize();
        int size2 = state2.sourceSize();
        int index1 = 0;
        int index2 = 0;
        while (index1 < size1 && index2 < size2) {
            int id1 = state1.sourceIdAt(index1);
            int id2 = state2.sourceIdAt(index2);
            while (id1 != id2) {
                if (id1 < id2) {
                    cb2.onIdNotFoundInState2(index1, state1.sourceAt(index1));
                    index1++;
                    if (index1 >= size1) {
                        break;
                    } else {
                        id1 = state1.sourceIdAt(index1);
                    }
                } else {
                    cb2.onIdNotFoundInState1(index2, state2.sourceAt(index2));
                    index2++;
                    if (index2 >= size2) {
                        break;
                    } else {
                        id2 = state2.sourceIdAt(index2);
                    }
                }
            }
            if (index1 >= size1 || index2 >= size2) {
                break;
            }
            InsetsSource source1 = state1.sourceAt(index1);
            InsetsSource source2 = state2.sourceAt(index2);
            cb2.onIdMatch(source1, source2);
            index1++;
            index2++;
        }
        while (index2 < size2) {
            cb2.onIdNotFoundInState1(index2, state2.sourceAt(index2));
            index2++;
        }
        while (index1 < size1) {
            cb2.onIdNotFoundInState2(index1, state1.sourceAt(index1));
            index1++;
        }
        cb2.onFinish(state1, state2);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnTraverseCallbacks {
        default void onStart(InsetsState state1, InsetsState state2) {
        }

        default void onIdMatch(InsetsSource source1, InsetsSource source2) {
        }

        default void onIdNotFoundInState1(int index2, InsetsSource source2) {
        }

        default void onIdNotFoundInState2(int index1, InsetsSource source1) {
        }

        default void onFinish(InsetsState state1, InsetsState state2) {
        }
    }

    public IInsetsStateWrapper getWrapper() {
        return this.mWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class InsetsStateWrapper implements IInsetsStateWrapper {
        private InsetsStateWrapper() {
        }

        @Override // android.view.IInsetsStateWrapper
        public IInsetsStateExt getExtImpl() {
            return InsetsState.this.mExt;
        }

        @Override // android.view.IInsetsStateWrapper
        public SparseArray<InsetsSource> getSources() {
            return InsetsState.this.mSources;
        }
    }
}

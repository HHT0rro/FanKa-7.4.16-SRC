package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.util.SparseArray;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.View$InspectionCompanion$$ExternalSyntheticLambda0;
import android.view.ViewGroup;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.RemoteViews;
import com.android.internal.R;
import com.huawei.quickcard.base.Attributes;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.util.locale.LanguageTag;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@RemoteViews.RemoteView
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GridLayout extends ViewGroup {
    private static final int ALIGNMENT_MODE = 6;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE;
    public static final Alignment BOTTOM;
    private static final int CAN_STRETCH = 2;
    public static final Alignment CENTER;
    private static final int COLUMN_COUNT = 3;
    private static final int COLUMN_ORDER_PRESERVED = 4;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    private static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END;
    public static final Alignment FILL;
    public static final int HORIZONTAL = 0;
    private static final int INFLEXIBLE = 0;
    private static final Alignment LEADING;
    public static final Alignment LEFT;
    static final int MAX_SIZE = 100000;
    private static final int ORIENTATION = 0;
    public static final Alignment RIGHT;
    private static final int ROW_COUNT = 1;
    private static final int ROW_ORDER_PRESERVED = 2;
    public static final Alignment START;
    public static final Alignment TOP;
    private static final Alignment TRAILING;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH = 0;
    private static final int USE_DEFAULT_MARGINS = 5;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final Printer NO_PRINTER = new Printer() { // from class: android.widget.GridLayout.1
        @Override // android.util.Printer
        public void println(String x10) {
        }
    };
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() { // from class: android.widget.GridLayout.2
        @Override // android.widget.GridLayout.Alignment
        int getGravityOffset(View view, int cellDelta) {
            return Integer.MIN_VALUE;
        }

        @Override // android.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int viewSize, int mode) {
            return Integer.MIN_VALUE;
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface AlignmentMode {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Orientation {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<GridLayout> {
        private int mAlignmentModeId;
        private int mColumnCountId;
        private int mColumnOrderPreservedId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mRowCountId;
        private int mRowOrderPreservedId;
        private int mUseDefaultMarginsId;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            SparseArray<String> alignmentModeEnumMapping = new SparseArray<>();
            alignmentModeEnumMapping.put(0, "alignBounds");
            alignmentModeEnumMapping.put(1, "alignMargins");
            Objects.requireNonNull(alignmentModeEnumMapping);
            this.mAlignmentModeId = propertyMapper.mapIntEnum("alignmentMode", 16843642, new View$InspectionCompanion$$ExternalSyntheticLambda0(alignmentModeEnumMapping));
            this.mColumnCountId = propertyMapper.mapInt("columnCount", 16843639);
            this.mColumnOrderPreservedId = propertyMapper.mapBoolean("columnOrderPreserved", 16843640);
            SparseArray<String> orientationEnumMapping = new SparseArray<>();
            orientationEnumMapping.put(0, Attributes.ProgressType.HORIZONTAL);
            orientationEnumMapping.put(1, "vertical");
            Objects.requireNonNull(orientationEnumMapping);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", 16842948, new View$InspectionCompanion$$ExternalSyntheticLambda0(orientationEnumMapping));
            this.mRowCountId = propertyMapper.mapInt("rowCount", 16843637);
            this.mRowOrderPreservedId = propertyMapper.mapBoolean("rowOrderPreserved", 16843638);
            this.mUseDefaultMarginsId = propertyMapper.mapBoolean("useDefaultMargins", 16843641);
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(GridLayout node, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readIntEnum(this.mAlignmentModeId, node.getAlignmentMode());
            propertyReader.readInt(this.mColumnCountId, node.getColumnCount());
            propertyReader.readBoolean(this.mColumnOrderPreservedId, node.isColumnOrderPreserved());
            propertyReader.readIntEnum(this.mOrientationId, node.getOrientation());
            propertyReader.readInt(this.mRowCountId, node.getRowCount());
            propertyReader.readBoolean(this.mRowOrderPreservedId, node.isRowOrderPreserved());
            propertyReader.readBoolean(this.mUseDefaultMarginsId, node.getUseDefaultMargins());
        }
    }

    static {
        Alignment alignment = new Alignment() { // from class: android.widget.GridLayout.3
            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int cellDelta) {
                return 0;
            }

            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int viewSize, int mode) {
                return 0;
            }
        };
        LEADING = alignment;
        Alignment alignment2 = new Alignment() { // from class: android.widget.GridLayout.4
            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int cellDelta) {
                return cellDelta;
            }

            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int viewSize, int mode) {
                return viewSize;
            }
        };
        TRAILING = alignment2;
        TOP = alignment;
        BOTTOM = alignment2;
        START = alignment;
        END = alignment2;
        LEFT = createSwitchingAlignment(alignment, alignment2);
        RIGHT = createSwitchingAlignment(alignment2, alignment);
        CENTER = new Alignment() { // from class: android.widget.GridLayout.6
            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int cellDelta) {
                return cellDelta >> 1;
            }

            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int viewSize, int mode) {
                return viewSize >> 1;
            }
        };
        BASELINE = new Alignment() { // from class: android.widget.GridLayout.7
            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int cellDelta) {
                return 0;
            }

            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int viewSize, int mode) {
                if (view.getVisibility() == 8) {
                    return 0;
                }
                int baseline = view.getBaseline();
                if (baseline == -1) {
                    return Integer.MIN_VALUE;
                }
                return baseline;
            }

            @Override // android.widget.GridLayout.Alignment
            public Bounds getBounds() {
                return new Bounds() { // from class: android.widget.GridLayout.7.1
                    private int size;

                    @Override // android.widget.GridLayout.Bounds
                    protected void reset() {
                        super.reset();
                        this.size = Integer.MIN_VALUE;
                    }

                    @Override // android.widget.GridLayout.Bounds
                    protected void include(int before, int after) {
                        super.include(before, after);
                        this.size = Math.max(this.size, before + after);
                    }

                    @Override // android.widget.GridLayout.Bounds
                    protected int size(boolean min) {
                        return Math.max(super.size(min), this.size);
                    }

                    @Override // android.widget.GridLayout.Bounds
                    protected int getOffset(GridLayout gl, View c4, Alignment a10, int size, boolean hrz) {
                        return Math.max(0, super.getOffset(gl, c4, a10, size, hrz));
                    }
                };
            }
        };
        FILL = new Alignment() { // from class: android.widget.GridLayout.8
            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int cellDelta) {
                return 0;
            }

            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int viewSize, int mode) {
                return Integer.MIN_VALUE;
            }

            @Override // android.widget.GridLayout.Alignment
            public int getSizeInCell(View view, int viewSize, int cellSize) {
                return cellSize;
            }
        };
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    public GridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public GridLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(17105185);
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.GridLayout, defStyleAttr, defStyleRes);
        saveAttributeDataForStyleable(context, R.styleable.GridLayout, attrs, a10, defStyleAttr, defStyleRes);
        try {
            setRowCount(a10.getInt(1, Integer.MIN_VALUE));
            setColumnCount(a10.getInt(3, Integer.MIN_VALUE));
            setOrientation(a10.getInt(0, 0));
            setUseDefaultMargins(a10.getBoolean(5, false));
            setAlignmentMode(a10.getInt(6, 1));
            setRowOrderPreserved(a10.getBoolean(2, true));
            setColumnOrderPreserved(a10.getBoolean(4, true));
        } finally {
            a10.recycle();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int orientation) {
        if (this.mOrientation != orientation) {
            this.mOrientation = orientation;
            invalidateStructure();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    @RemotableViewMethod
    public void setRowCount(int rowCount) {
        this.mVerticalAxis.setCount(rowCount);
        invalidateStructure();
        requestLayout();
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    @RemotableViewMethod
    public void setColumnCount(int columnCount) {
        this.mHorizontalAxis.setCount(columnCount);
        invalidateStructure();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public void setUseDefaultMargins(boolean useDefaultMargins) {
        this.mUseDefaultMargins = useDefaultMargins;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    @RemotableViewMethod
    public void setAlignmentMode(int alignmentMode) {
        this.mAlignmentMode = alignmentMode;
        requestLayout();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    public void setRowOrderPreserved(boolean rowOrderPreserved) {
        this.mVerticalAxis.setOrderPreserved(rowOrderPreserved);
        invalidateStructure();
        requestLayout();
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public void setColumnOrderPreserved(boolean columnOrderPreserved) {
        this.mHorizontalAxis.setOrderPreserved(columnOrderPreserved);
        invalidateStructure();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        this.mPrinter = printer == null ? NO_PRINTER : printer;
    }

    static int max2(int[] a10, int valueIfEmpty) {
        int result = valueIfEmpty;
        for (int i10 : a10) {
            result = Math.max(result, i10);
        }
        return result;
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static Alignment getAlignment(int gravity, boolean horizontal) {
        int mask = horizontal ? 7 : 112;
        int shift = horizontal ? 0 : 4;
        int flags = (gravity & mask) >> shift;
        switch (flags) {
            case 1:
                return CENTER;
            case 3:
                return horizontal ? LEFT : TOP;
            case 5:
                return horizontal ? RIGHT : BOTTOM;
            case 7:
                return FILL;
            case 8388611:
                return START;
            case 8388613:
                return END;
            default:
                return UNDEFINED_ALIGNMENT;
        }
    }

    private int getDefaultMargin(View c4, boolean horizontal, boolean leading) {
        if (c4.getClass() == Space.class) {
            return 0;
        }
        return this.mDefaultGap / 2;
    }

    private int getDefaultMargin(View c4, boolean isAtEdge, boolean horizontal, boolean leading) {
        return getDefaultMargin(c4, horizontal, leading);
    }

    private int getDefaultMargin(View c4, LayoutParams p10, boolean horizontal, boolean leading) {
        boolean leading1;
        boolean isAtEdge = false;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = horizontal ? p10.columnSpec : p10.rowSpec;
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval span = spec.span;
        if (horizontal && isLayoutRtl()) {
            leading1 = !leading;
        } else {
            leading1 = leading;
        }
        if (!leading1 ? span.max == axis.getCount() : span.min == 0) {
            isAtEdge = true;
        }
        return getDefaultMargin(c4, isAtEdge, horizontal, leading);
    }

    int getMargin1(View view, boolean horizontal, boolean leading) {
        int margin;
        LayoutParams lp = getLayoutParams(view);
        if (horizontal) {
            margin = leading ? lp.leftMargin : lp.rightMargin;
        } else {
            margin = leading ? lp.topMargin : lp.bottomMargin;
        }
        return margin == Integer.MIN_VALUE ? getDefaultMargin(view, lp, horizontal, leading) : margin;
    }

    private int getMargin(View view, boolean horizontal, boolean leading) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, horizontal, leading);
        }
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] margins = leading ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams lp = getLayoutParams(view);
        Spec spec = horizontal ? lp.columnSpec : lp.rowSpec;
        Interval interval = spec.span;
        int index = leading ? interval.min : interval.max;
        return margins[index];
    }

    private int getTotalMargin(View child, boolean horizontal) {
        return getMargin(child, horizontal, true) + getMargin(child, horizontal, false);
    }

    private static boolean fits(int[] a10, int value, int start, int end) {
        if (end > a10.length) {
            return false;
        }
        for (int i10 = start; i10 < end; i10++) {
            if (a10[i10] > value) {
                return false;
            }
        }
        return true;
    }

    private static void procrusteanFill(int[] a10, int start, int end, int value) {
        int length = a10.length;
        Arrays.fill(a10, Math.min(start, length), Math.min(end, length), value);
    }

    private static void setCellGroup(LayoutParams lp, int row, int rowSpan, int col, int colSpan) {
        lp.setRowSpecSpan(new Interval(row, row + rowSpan));
        lp.setColumnSpecSpan(new Interval(col, col + colSpan));
    }

    private static int clip(Interval minorRange, boolean minorWasDefined, int count) {
        int size = minorRange.size();
        if (count == 0) {
            return size;
        }
        int min = minorWasDefined ? Math.min(minorRange.min, count) : 0;
        return Math.min(size, count - min);
    }

    private void validateLayoutParams() {
        int N;
        GridLayout gridLayout = this;
        boolean horizontal = gridLayout.mOrientation == 0;
        Axis axis = horizontal ? gridLayout.mHorizontalAxis : gridLayout.mVerticalAxis;
        int count = axis.definedCount != Integer.MIN_VALUE ? axis.definedCount : 0;
        int major = 0;
        int minor = 0;
        int[] maxSizes = new int[count];
        int i10 = 0;
        int N2 = getChildCount();
        while (i10 < N2) {
            LayoutParams lp = (LayoutParams) gridLayout.getChildAt(i10).getLayoutParams();
            Spec majorSpec = horizontal ? lp.rowSpec : lp.columnSpec;
            Interval majorRange = majorSpec.span;
            boolean majorWasDefined = majorSpec.startDefined;
            int majorSpan = majorRange.size();
            if (majorWasDefined) {
                major = majorRange.min;
            }
            Spec minorSpec = horizontal ? lp.columnSpec : lp.rowSpec;
            Interval minorRange = minorSpec.span;
            boolean minorWasDefined = minorSpec.startDefined;
            Axis axis2 = axis;
            int minorSpan = clip(minorRange, minorWasDefined, count);
            if (minorWasDefined) {
                minor = minorRange.min;
            }
            if (count != 0) {
                if (!majorWasDefined || !minorWasDefined) {
                    while (true) {
                        N = N2;
                        int N3 = minor + minorSpan;
                        if (fits(maxSizes, major, minor, N3)) {
                            break;
                        }
                        if (minorWasDefined) {
                            major++;
                            N2 = N;
                        } else if (minor + minorSpan <= count) {
                            minor++;
                            N2 = N;
                        } else {
                            minor = 0;
                            major++;
                            N2 = N;
                        }
                    }
                } else {
                    N = N2;
                }
                procrusteanFill(maxSizes, minor, minor + minorSpan, major + majorSpan);
            } else {
                N = N2;
            }
            if (horizontal) {
                setCellGroup(lp, major, majorSpan, minor, minorSpan);
            } else {
                setCellGroup(lp, minor, minorSpan, major, majorSpan);
            }
            minor += minorSpan;
            i10++;
            gridLayout = this;
            axis = axis2;
            N2 = N;
        }
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        this.mHorizontalAxis.invalidateStructure();
        this.mVerticalAxis.invalidateStructure();
        invalidateValues();
    }

    private void invalidateValues() {
        Axis axis = this.mHorizontalAxis;
        if (axis != null && this.mVerticalAxis != null) {
            axis.invalidateValues();
            this.mVerticalAxis.invalidateValues();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onSetLayoutParams(View child, ViewGroup.LayoutParams layoutParams) {
        super.onSetLayoutParams(child, layoutParams);
        if (!checkLayoutParams(layoutParams)) {
            handleInvalidParams("supplied LayoutParams are of the wrong type");
        }
        invalidateStructure();
    }

    final LayoutParams getLayoutParams(View c4) {
        return (LayoutParams) c4.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleInvalidParams(String msg) {
        throw new IllegalArgumentException(msg + ". ");
    }

    private void checkLayoutParams(LayoutParams lp, boolean horizontal) {
        String groupName = horizontal ? "column" : "row";
        Spec spec = horizontal ? lp.columnSpec : lp.rowSpec;
        Interval span = spec.span;
        if (span.min != Integer.MIN_VALUE && span.min < 0) {
            handleInvalidParams(groupName + " indices must be positive");
        }
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        int count = axis.definedCount;
        if (count != Integer.MIN_VALUE) {
            if (span.max > count) {
                handleInvalidParams(groupName + " indices (start + span) mustn't exceed the " + groupName + " count");
            }
            if (span.size() > count) {
                handleInvalidParams(groupName + " span mustn't exceed the " + groupName + " count");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p10) {
        if (!(p10 instanceof LayoutParams)) {
            return false;
        }
        LayoutParams lp = (LayoutParams) p10;
        checkLayoutParams(lp, true);
        checkLayoutParams(lp, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (sPreserveMarginParamsInLayoutParamConversion) {
            if (lp instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) lp);
            }
            if (lp instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) lp);
            }
        }
        return new LayoutParams(lp);
    }

    private void drawLine(Canvas graphics, int x12, int y1, int x22, int y22, Paint paint) {
        if (isLayoutRtl()) {
            int width = getWidth();
            graphics.drawLine(width - x12, y1, width - x22, y22, paint);
        } else {
            graphics.drawLine(x12, y1, x22, y22, paint);
        }
    }

    @Override // android.view.ViewGroup
    protected void onDebugDrawMargins(Canvas canvas, Paint paint) {
        LayoutParams lp = new LayoutParams();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View c4 = getChildAt(i10);
            lp.setMargins(getMargin1(c4, true, true), getMargin1(c4, false, true), getMargin1(c4, true, false), getMargin1(c4, false, false));
            lp.onDebugDraw(c4, canvas, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onDebugDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.argb(50, 255, 255, 255));
        Insets insets = getOpticalInsets();
        int top = getPaddingTop() + insets.top;
        int left = getPaddingLeft() + insets.left;
        int right = (getWidth() - getPaddingRight()) - insets.right;
        int bottom = (getHeight() - getPaddingBottom()) - insets.bottom;
        int[] xs = this.mHorizontalAxis.locations;
        if (xs != null) {
            for (int i10 : xs) {
                int x10 = left + i10;
                drawLine(canvas, x10, top, x10, bottom, paint);
            }
        }
        int[] ys = this.mVerticalAxis.locations;
        if (ys != null) {
            int i11 = 0;
            for (int length = ys.length; i11 < length; length = length) {
                int y10 = top + ys[i11];
                drawLine(canvas, left, y10, right, y10, paint);
                i11++;
            }
        }
        super.onDebugDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        invalidateStructure();
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        invalidateStructure();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public void onChildVisibilityChanged(View child, int oldVisibility, int newVisibility) {
        super.onChildVisibilityChanged(child, oldVisibility, newVisibility);
        if (oldVisibility == 8 || newVisibility == 8) {
            invalidateStructure();
        }
    }

    private int computeLayoutParamsHashCode() {
        int result = 1;
        int N = getChildCount();
        for (int i10 = 0; i10 < N; i10++) {
            View c4 = getChildAt(i10);
            if (c4.getVisibility() != 8) {
                LayoutParams lp = (LayoutParams) c4.getLayoutParams();
                result = (result * 31) + lp.hashCode();
            }
        }
        return result;
    }

    private void consistencyCheck() {
        int i10 = this.mLastLayoutParamsHashCode;
        if (i10 == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (i10 != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private void measureChildWithMargins2(View child, int parentWidthSpec, int parentHeightSpec, int childWidth, int childHeight) {
        int childWidthSpec = getChildMeasureSpec(parentWidthSpec, getTotalMargin(child, true), childWidth);
        int childHeightSpec = getChildMeasureSpec(parentHeightSpec, getTotalMargin(child, false), childHeight);
        child.measure(childWidthSpec, childHeightSpec);
    }

    private void measureChildrenWithMargins(int widthSpec, int heightSpec, boolean firstPass) {
        int N = getChildCount();
        for (int i10 = 0; i10 < N; i10++) {
            View c4 = getChildAt(i10);
            if (c4.getVisibility() != 8) {
                LayoutParams lp = getLayoutParams(c4);
                if (firstPass) {
                    measureChildWithMargins2(c4, widthSpec, heightSpec, lp.width, lp.height);
                } else {
                    boolean horizontal = this.mOrientation == 0;
                    Spec spec = horizontal ? lp.columnSpec : lp.rowSpec;
                    if (spec.getAbsoluteAlignment(horizontal) == FILL) {
                        Interval span = spec.span;
                        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
                        int[] locations = axis.getLocations();
                        int cellSize = locations[span.max] - locations[span.min];
                        int viewSize = cellSize - getTotalMargin(c4, horizontal);
                        if (horizontal) {
                            measureChildWithMargins2(c4, widthSpec, heightSpec, viewSize, lp.height);
                        } else {
                            measureChildWithMargins2(c4, widthSpec, heightSpec, lp.width, viewSize);
                        }
                    }
                }
            }
        }
    }

    static int adjust(int measureSpec, int delta) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec + delta), View.MeasureSpec.getMode(measureSpec));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int widthSpec, int heightSpec) {
        int heightSansPadding;
        int widthSansPadding;
        consistencyCheck();
        invalidateValues();
        int hPadding = getPaddingLeft() + getPaddingRight();
        int vPadding = getPaddingTop() + getPaddingBottom();
        int widthSpecSansPadding = adjust(widthSpec, -hPadding);
        int heightSpecSansPadding = adjust(heightSpec, -vPadding);
        measureChildrenWithMargins(widthSpecSansPadding, heightSpecSansPadding, true);
        if (this.mOrientation == 0) {
            widthSansPadding = this.mHorizontalAxis.getMeasure(widthSpecSansPadding);
            measureChildrenWithMargins(widthSpecSansPadding, heightSpecSansPadding, false);
            heightSansPadding = this.mVerticalAxis.getMeasure(heightSpecSansPadding);
        } else {
            heightSansPadding = this.mVerticalAxis.getMeasure(heightSpecSansPadding);
            measureChildrenWithMargins(widthSpecSansPadding, heightSpecSansPadding, false);
            widthSansPadding = this.mHorizontalAxis.getMeasure(widthSpecSansPadding);
        }
        int measuredWidth = Math.max(widthSansPadding + hPadding, getSuggestedMinimumWidth());
        int measuredHeight = Math.max(heightSansPadding + vPadding, getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSizeAndState(measuredWidth, widthSpec, 0), resolveSizeAndState(measuredHeight, heightSpec, 0));
    }

    private int getMeasurement(View c4, boolean horizontal) {
        return horizontal ? c4.getMeasuredWidth() : c4.getMeasuredHeight();
    }

    final int getMeasurementIncludingMargin(View c4, boolean horizontal) {
        if (c4.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(c4, horizontal) + getTotalMargin(c4, horizontal);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        invalidateValues();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int targetHeight;
        int paddingBottom;
        int[] hLocations;
        int[] vLocations;
        int i10;
        GridLayout gridLayout = this;
        consistencyCheck();
        int targetWidth = right - left;
        int targetHeight2 = bottom - top;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        gridLayout.mHorizontalAxis.layout((targetWidth - paddingLeft) - paddingRight);
        gridLayout.mVerticalAxis.layout((targetHeight2 - paddingTop) - paddingBottom2);
        int[] hLocations2 = gridLayout.mHorizontalAxis.getLocations();
        int[] vLocations2 = gridLayout.mVerticalAxis.getLocations();
        int N = getChildCount();
        int cx = 0;
        while (cx < N) {
            View c4 = gridLayout.getChildAt(cx);
            if (c4.getVisibility() == 8) {
                i10 = cx;
                targetHeight = targetHeight2;
                paddingBottom = paddingBottom2;
                hLocations = hLocations2;
                vLocations = vLocations2;
            } else {
                LayoutParams lp = gridLayout.getLayoutParams(c4);
                Spec columnSpec = lp.columnSpec;
                Spec rowSpec = lp.rowSpec;
                Interval colSpan = columnSpec.span;
                targetHeight = targetHeight2;
                Interval rowSpan = rowSpec.span;
                int x12 = hLocations2[colSpan.min];
                int y1 = vLocations2[rowSpan.min];
                int x22 = hLocations2[colSpan.max];
                int y22 = vLocations2[rowSpan.max];
                int cellWidth = x22 - x12;
                int cellHeight = y22 - y1;
                int pWidth = gridLayout.getMeasurement(c4, true);
                paddingBottom = paddingBottom2;
                int pHeight = gridLayout.getMeasurement(c4, false);
                hLocations = hLocations2;
                Alignment hAlign = columnSpec.getAbsoluteAlignment(true);
                vLocations = vLocations2;
                Alignment vAlign = rowSpec.getAbsoluteAlignment(false);
                Bounds boundsX = gridLayout.mHorizontalAxis.getGroupBounds().getValue(cx);
                Bounds boundsY = gridLayout.mVerticalAxis.getGroupBounds().getValue(cx);
                int gravityOffsetX = hAlign.getGravityOffset(c4, cellWidth - boundsX.size(true));
                int gravityOffsetY = vAlign.getGravityOffset(c4, cellHeight - boundsY.size(true));
                int leftMargin = gridLayout.getMargin(c4, true, true);
                int topMargin = gridLayout.getMargin(c4, false, true);
                int rightMargin = gridLayout.getMargin(c4, true, false);
                int bottomMargin = gridLayout.getMargin(c4, false, false);
                int sumMarginsX = leftMargin + rightMargin;
                int sumMarginsY = topMargin + bottomMargin;
                int i11 = pWidth + sumMarginsX;
                i10 = cx;
                int alignmentOffsetX = boundsX.getOffset(this, c4, hAlign, i11, true);
                int alignmentOffsetY = boundsY.getOffset(this, c4, vAlign, pHeight + sumMarginsY, false);
                int width = hAlign.getSizeInCell(c4, pWidth, cellWidth - sumMarginsX);
                int height = vAlign.getSizeInCell(c4, pHeight, cellHeight - sumMarginsY);
                int dx = x12 + gravityOffsetX + alignmentOffsetX;
                int cx2 = !isLayoutRtl() ? paddingLeft + leftMargin + dx : (((targetWidth - width) - paddingRight) - rightMargin) - dx;
                int alignmentOffsetY2 = paddingTop + y1 + gravityOffsetY + alignmentOffsetY + topMargin;
                if (width != c4.getMeasuredWidth() || height != c4.getMeasuredHeight()) {
                    c4.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                }
                c4.layout(cx2, alignmentOffsetY2, cx2 + width, alignmentOffsetY2 + height);
            }
            cx = i10 + 1;
            gridLayout = this;
            targetHeight2 = targetHeight;
            paddingBottom2 = paddingBottom;
            hLocations2 = hLocations;
            vLocations2 = vLocations;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return GridLayout.class.getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int COMPLETE = 2;
        private static final int NEW = 0;
        private static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid;
        public int definedCount;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid;
        public boolean hasWeights;
        public boolean hasWeightsValid;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid;
        public int[] locations;
        public boolean locationsValid;
        private int maxIndex;
        boolean orderPreserved;
        private MutableInt parentMax;
        private MutableInt parentMin;
        public int[] trailingMargins;
        public boolean trailingMarginsValid;

        private Axis(boolean horizontal) {
            this.definedCount = Integer.MIN_VALUE;
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
            this.hasWeightsValid = false;
            this.orderPreserved = true;
            this.parentMin = new MutableInt(0);
            this.parentMax = new MutableInt(-100000);
            this.horizontal = horizontal;
        }

        private int calculateMaxIndex() {
            int result = -1;
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View c4 = GridLayout.this.getChildAt(i10);
                LayoutParams params = GridLayout.this.getLayoutParams(c4);
                Spec spec = this.horizontal ? params.columnSpec : params.rowSpec;
                Interval span = spec.span;
                result = Math.max(Math.max(Math.max(result, span.min), span.max), span.size());
            }
            if (result == -1) {
                return Integer.MIN_VALUE;
            }
            return result;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public void setCount(int count) {
            if (count != Integer.MIN_VALUE && count < getMaxIndex()) {
                GridLayout.handleInvalidParams((this.horizontal ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
            }
            this.definedCount = count;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void setOrderPreserved(boolean orderPreserved) {
            this.orderPreserved = orderPreserved;
            invalidateStructure();
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc<Spec, Bounds> assoc = Assoc.of(Spec.class, Bounds.class);
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View c4 = GridLayout.this.getChildAt(i10);
                LayoutParams lp = GridLayout.this.getLayoutParams(c4);
                Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                Bounds bounds = spec.getAbsoluteAlignment(this.horizontal).getBounds();
                assoc.put(spec, bounds);
            }
            return assoc.pack();
        }

        private void computeGroupBounds() {
            Bounds[] values = this.groupBounds.values;
            for (Bounds bounds : values) {
                bounds.reset();
            }
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View c4 = GridLayout.this.getChildAt(i10);
                LayoutParams lp = GridLayout.this.getLayoutParams(c4);
                Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                int size = GridLayout.this.getMeasurementIncludingMargin(c4, this.horizontal) + (spec.weight == 0.0f ? 0 : getDeltas()[i10]);
                this.groupBounds.getValue(i10).include(GridLayout.this, c4, spec, this, size);
            }
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean min) {
            Assoc<Interval, MutableInt> result = Assoc.of(Interval.class, MutableInt.class);
            Spec[] keys = getGroupBounds().keys;
            int N = keys.length;
            for (int i10 = 0; i10 < N; i10++) {
                Interval span = min ? keys[i10].span : keys[i10].span.inverse();
                result.put(span, new MutableInt());
            }
            return result.pack();
        }

        private void computeLinks(PackedMap<Interval, MutableInt> links, boolean min) {
            MutableInt[] spans = links.values;
            for (MutableInt mutableInt : spans) {
                mutableInt.reset();
            }
            Bounds[] bounds = getGroupBounds().values;
            for (int i10 = 0; i10 < bounds.length; i10++) {
                int size = bounds[i10].size(min);
                MutableInt valueHolder = links.getValue(i10);
                valueHolder.value = Math.max(valueHolder.value, min ? size : -size);
            }
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private void include(List<Arc> arcs, Interval key, MutableInt size, boolean ignoreIfAlreadyPresent) {
            if (key.size() == 0) {
                return;
            }
            if (ignoreIfAlreadyPresent) {
                for (Arc arc : arcs) {
                    Interval span = arc.span;
                    if (span.equals(key)) {
                        return;
                    }
                }
            }
            arcs.add(new Arc(key, size));
        }

        private void include(List<Arc> arcs, Interval key, MutableInt size) {
            include(arcs, key, size, true);
        }

        Arc[][] groupArcsByFirstVertex(Arc[] arcs) {
            int N = getCount() + 1;
            Arc[][] result = new Arc[N];
            int[] sizes = new int[N];
            for (Arc arc : arcs) {
                int i10 = arc.span.min;
                sizes[i10] = sizes[i10] + 1;
            }
            for (int i11 = 0; i11 < sizes.length; i11++) {
                result[i11] = new Arc[sizes[i11]];
            }
            Arrays.fill(sizes, 0);
            for (Arc arc2 : arcs) {
                int i12 = arc2.span.min;
                Arc[] arcArr = result[i12];
                int i13 = sizes[i12];
                sizes[i12] = i13 + 1;
                arcArr[i13] = arc2;
            }
            return result;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.GridLayout$Axis$1] */
        private Arc[] topologicalSort(Arc[] arcs) {
            return new Object(arcs) { // from class: android.widget.GridLayout.Axis.1
                static final /* synthetic */ boolean $assertionsDisabled = false;
                Arc[][] arcsByVertex;
                int cursor;
                Arc[] result;
                final /* synthetic */ Arc[] val$arcs;
                int[] visited;

                {
                    this.val$arcs = arcs;
                    this.result = new Arc[arcs.length];
                    this.cursor = r0.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcs);
                    this.visited = new int[Axis.this.getCount() + 1];
                }

                void walk(int loc) {
                    int[] iArr = this.visited;
                    switch (iArr[loc]) {
                        case 0:
                            iArr[loc] = 1;
                            for (Arc arc : this.arcsByVertex[loc]) {
                                walk(arc.span.max);
                                Arc[] arcArr = this.result;
                                int i10 = this.cursor;
                                this.cursor = i10 - 1;
                                arcArr[i10] = arc;
                            }
                            this.visited[loc] = 2;
                            return;
                        case 1:
                        default:
                            return;
                    }
                }

                Arc[] sort() {
                    int N = this.arcsByVertex.length;
                    for (int loc = 0; loc < N; loc++) {
                        walk(loc);
                    }
                    return this.result;
                }
            }.sort();
        }

        private Arc[] topologicalSort(List<Arc> arcs) {
            return topologicalSort((Arc[]) arcs.toArray(new Arc[arcs.size()]));
        }

        private void addComponentSizes(List<Arc> result, PackedMap<Interval, MutableInt> links) {
            for (int i10 = 0; i10 < links.keys.length; i10++) {
                Interval key = links.keys[i10];
                include(result, key, links.values[i10], false);
            }
        }

        private Arc[] createArcs() {
            List<Arc> mins = new ArrayList<>();
            List<Arc> maxs = new ArrayList<>();
            addComponentSizes(mins, getForwardLinks());
            addComponentSizes(maxs, getBackwardLinks());
            if (this.orderPreserved) {
                for (int i10 = 0; i10 < getCount(); i10++) {
                    include(mins, new Interval(i10, i10 + 1), new MutableInt(0));
                }
            }
            int N = getCount();
            include(mins, new Interval(0, N), this.parentMin, false);
            include(maxs, new Interval(N, 0), this.parentMax, false);
            Arc[] sMins = topologicalSort(mins);
            Arc[] sMaxs = topologicalSort(maxs);
            return (Arc[]) GridLayout.append(sMins, sMaxs);
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        private boolean relax(int[] locations, Arc entry) {
            if (!entry.valid) {
                return false;
            }
            Interval span = entry.span;
            int u10 = span.min;
            int v2 = span.max;
            int value = entry.value.value;
            int candidate = locations[u10] + value;
            if (candidate <= locations[v2]) {
                return false;
            }
            locations[v2] = candidate;
            return true;
        }

        private void init(int[] locations) {
            Arrays.fill(locations, 0);
        }

        private String arcsToString(List<Arc> arcs) {
            String var = this.horizontal ? LanguageTag.PRIVATEUSE : "y";
            StringBuilder result = new StringBuilder();
            boolean first = true;
            for (Arc arc : arcs) {
                if (first) {
                    first = false;
                } else {
                    result = result.append(", ");
                }
                int src = arc.span.min;
                int dst = arc.span.max;
                int value = arc.value.value;
                result.append(src < dst ? var + dst + "-" + var + src + ">=" + value : var + src + "-" + var + dst + "<=" + (-value));
            }
            return result.toString();
        }

        private void logError(String axisName, Arc[] arcs, boolean[] culprits0) {
            List<Arc> culprits = new ArrayList<>();
            List<Arc> removed = new ArrayList<>();
            for (int c4 = 0; c4 < arcs.length; c4++) {
                Arc arc = arcs[c4];
                if (culprits0[c4]) {
                    culprits.add(arc);
                }
                if (!arc.valid) {
                    removed.add(arc);
                }
            }
            GridLayout.this.mPrinter.println(axisName + " constraints: " + arcsToString(culprits) + " are inconsistent; permanently removing: " + arcsToString(removed) + ". ");
        }

        private boolean solve(Arc[] arcs, int[] locations) {
            return solve(arcs, locations, true);
        }

        private boolean solve(Arc[] arcs, int[] locations, boolean modifyOnError) {
            String axisName = this.horizontal ? Attributes.ProgressType.HORIZONTAL : "vertical";
            int N = getCount() + 1;
            boolean[] originalCulprits = null;
            for (int p10 = 0; p10 < arcs.length; p10++) {
                init(locations);
                for (int i10 = 0; i10 < N; i10++) {
                    boolean changed = false;
                    for (Arc arc : arcs) {
                        changed |= relax(locations, arc);
                    }
                    if (!changed) {
                        if (originalCulprits != null) {
                            logError(axisName, arcs, originalCulprits);
                        }
                        return true;
                    }
                }
                if (!modifyOnError) {
                    return false;
                }
                boolean[] culprits = new boolean[arcs.length];
                for (int i11 = 0; i11 < N; i11++) {
                    int length = arcs.length;
                    for (int j10 = 0; j10 < length; j10++) {
                        culprits[j10] = culprits[j10] | relax(locations, arcs[j10]);
                    }
                }
                if (p10 == 0) {
                    originalCulprits = culprits;
                }
                int i12 = 0;
                while (true) {
                    if (i12 >= arcs.length) {
                        break;
                    }
                    if (culprits[i12]) {
                        Arc arc2 = arcs[i12];
                        if (arc2.span.min >= arc2.span.max) {
                            arc2.valid = false;
                            break;
                        }
                    }
                    i12++;
                }
            }
            return true;
        }

        private void computeMargins(boolean leading) {
            int[] margins = leading ? this.leadingMargins : this.trailingMargins;
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View c4 = GridLayout.this.getChildAt(i10);
                if (c4.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(c4);
                    Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                    Interval span = spec.span;
                    int index = leading ? span.min : span.max;
                    margins[index] = Math.max(margins[index], GridLayout.this.getMargin1(c4, this.horizontal, leading));
                }
            }
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[getCount() + 1];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[getCount() + 1];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        private boolean solve(int[] a10) {
            return solve(getArcs(), a10);
        }

        private boolean computeHasWeights() {
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View child = GridLayout.this.getChildAt(i10);
                if (child.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(child);
                    Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                    if (spec.weight != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        private void shareOutDelta(int totalDelta, float totalWeight) {
            Arrays.fill(this.deltas, 0);
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View c4 = GridLayout.this.getChildAt(i10);
                if (c4.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(c4);
                    Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                    float weight = spec.weight;
                    if (weight != 0.0f) {
                        int delta = Math.round((totalDelta * weight) / totalWeight);
                        this.deltas[i10] = delta;
                        totalDelta -= delta;
                        totalWeight -= weight;
                    }
                }
            }
        }

        private void solveAndDistributeSpace(int[] a10) {
            Arrays.fill(getDeltas(), 0);
            solve(a10);
            int deltaMax = (this.parentMin.value * GridLayout.this.getChildCount()) + 1;
            if (deltaMax < 2) {
                return;
            }
            int deltaMin = 0;
            float totalWeight = calculateTotalWeight();
            int validDelta = -1;
            boolean validSolution = true;
            while (deltaMin < deltaMax) {
                int delta = (int) ((deltaMin + deltaMax) / 2);
                invalidateValues();
                shareOutDelta(delta, totalWeight);
                validSolution = solve(getArcs(), a10, false);
                if (validSolution) {
                    validDelta = delta;
                    deltaMin = delta + 1;
                } else {
                    deltaMax = delta;
                }
            }
            if (validDelta > 0 && !validSolution) {
                invalidateValues();
                shareOutDelta(validDelta, totalWeight);
                solve(a10);
            }
        }

        private float calculateTotalWeight() {
            float totalWeight = 0.0f;
            int N = GridLayout.this.getChildCount();
            for (int i10 = 0; i10 < N; i10++) {
                View c4 = GridLayout.this.getChildAt(i10);
                if (c4.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(c4);
                    Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                    totalWeight += spec.weight;
                }
            }
            return totalWeight;
        }

        private void computeLocations(int[] a10) {
            if (!hasWeights()) {
                solve(a10);
            } else {
                solveAndDistributeSpace(a10);
            }
            if (!this.orderPreserved) {
                int a02 = a10[0];
                int N = a10.length;
                for (int i10 = 0; i10 < N; i10++) {
                    a10[i10] = a10[i10] - a02;
                }
            }
        }

        public int[] getLocations() {
            if (this.locations == null) {
                int N = getCount() + 1;
                this.locations = new int[N];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        private int size(int[] locations) {
            return locations[getCount()];
        }

        private void setParentConstraints(int min, int max) {
            this.parentMin.value = min;
            this.parentMax.value = -max;
            this.locationsValid = false;
        }

        private int getMeasure(int min, int max) {
            setParentConstraints(min, max);
            return size(getLocations());
        }

        public int getMeasure(int measureSpec) {
            int mode = View.MeasureSpec.getMode(measureSpec);
            int size = View.MeasureSpec.getSize(measureSpec);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return getMeasure(0, size);
                case 0:
                    return getMeasure(0, 100000);
                case 1073741824:
                    return getMeasure(size, size);
                default:
                    return 0;
            }
        }

        public void layout(int size) {
            setParentConstraints(size, size);
            getLocations();
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN = 6;
        private static final int COLUMN = 1;
        private static final int COLUMN_SPAN = 4;
        private static final int COLUMN_WEIGHT = 6;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN;
        private static final int DEFAULT_SPAN_SIZE;
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY = 0;
        private static final int LEFT_MARGIN = 3;
        private static final int MARGIN = 2;
        private static final int RIGHT_MARGIN = 5;
        private static final int ROW = 2;
        private static final int ROW_SPAN = 3;
        private static final int ROW_WEIGHT = 5;
        private static final int TOP_MARGIN = 4;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            DEFAULT_SPAN = interval;
            DEFAULT_SPAN_SIZE = interval.size();
        }

        private LayoutParams(int width, int height, int left, int top, int right, int bottom, Spec rowSpec, Spec columnSpec) {
            super(width, height);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            setMargins(left, top, right, bottom);
            this.rowSpec = rowSpec;
            this.columnSpec = columnSpec;
        }

        public LayoutParams(Spec rowSpec, Spec columnSpec) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, rowSpec, columnSpec);
        }

        public LayoutParams() {
            this(Spec.UNDEFINED, Spec.UNDEFINED);
        }

        public LayoutParams(ViewGroup.LayoutParams params) {
            super(params);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams params) {
            super(params);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            this.rowSpec = source.rowSpec;
            this.columnSpec = source.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            reInitSuper(context, attrs);
            init(context, attrs);
        }

        private void reInitSuper(Context context, AttributeSet attrs) {
            TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.ViewGroup_MarginLayout);
            try {
                int margin = a10.getDimensionPixelSize(2, Integer.MIN_VALUE);
                this.leftMargin = a10.getDimensionPixelSize(3, margin);
                this.topMargin = a10.getDimensionPixelSize(4, margin);
                this.rightMargin = a10.getDimensionPixelSize(5, margin);
                this.bottomMargin = a10.getDimensionPixelSize(6, margin);
            } finally {
                a10.recycle();
            }
        }

        private void init(Context context, AttributeSet attrs) {
            TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.GridLayout_Layout);
            try {
                int gravity = a10.getInt(0, 0);
                int column = a10.getInt(1, Integer.MIN_VALUE);
                int i10 = DEFAULT_SPAN_SIZE;
                int colSpan = a10.getInt(4, i10);
                float colWeight = a10.getFloat(6, 0.0f);
                this.columnSpec = GridLayout.spec(column, colSpan, GridLayout.getAlignment(gravity, true), colWeight);
                int row = a10.getInt(2, Integer.MIN_VALUE);
                int rowSpan = a10.getInt(3, i10);
                float rowWeight = a10.getFloat(5, 0.0f);
                this.rowSpec = GridLayout.spec(row, rowSpan, GridLayout.getAlignment(gravity, false), rowWeight);
            } finally {
                a10.recycle();
            }
        }

        public void setGravity(int gravity) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(gravity, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(gravity, true));
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray attributes, int widthAttr, int heightAttr) {
            this.width = attributes.getLayoutDimension(widthAttr, -2);
            this.height = attributes.getLayoutDimension(heightAttr, -2);
        }

        final void setRowSpecSpan(Interval span) {
            this.rowSpec = this.rowSpec.copyWriteSpan(span);
        }

        final void setColumnSpecSpan(Interval span) {
            this.columnSpec = this.columnSpec.copyWriteSpan(span);
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || getClass() != o10.getClass()) {
                return false;
            }
            LayoutParams that = (LayoutParams) o10;
            if (this.columnSpec.equals(that.columnSpec) && this.rowSpec.equals(that.rowSpec)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.rowSpec.hashCode();
            return (result * 31) + this.columnSpec.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval span, MutableInt value) {
            this.span = span;
            this.value = value;
        }

        public String toString() {
            return ((Object) this.span) + " " + (!this.valid ? "+>" : "->") + " " + ((Object) this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int value) {
            this.value = value;
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> keyType, Class<V> valueType) {
            this.keyType = keyType;
            this.valueType = valueType;
        }

        public static <K, V> Assoc<K, V> of(Class<K> keyType, Class<V> valueType) {
            return new Assoc<>(keyType, valueType);
        }

        public void put(K key, V value) {
            add(Pair.create(key, value));
        }

        public PackedMap<K, V> pack() {
            int N = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.keyType, N);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.valueType, N);
            for (int i10 = 0; i10 < N; i10++) {
                objArr[i10] = get(i10).first;
                objArr2[i10] = get(i10).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        private PackedMap(K[] kArr, V[] vArr) {
            int[] createIndex = createIndex(kArr);
            this.index = createIndex;
            this.keys = (K[]) compact(kArr, createIndex);
            this.values = (V[]) compact(vArr, createIndex);
        }

        public V getValue(int i10) {
            return this.values[this.index[i10]];
        }

        private static <K> int[] createIndex(K[] keys) {
            int size = keys.length;
            int[] result = new int[size];
            Map<K, Integer> keyToIndex = new HashMap<>();
            for (int i10 = 0; i10 < size; i10++) {
                K key = keys[i10];
                Integer index = keyToIndex.get(key);
                if (index == null) {
                    index = Integer.valueOf(keyToIndex.size());
                    keyToIndex.put(key, index);
                }
                result[i10] = index.intValue();
            }
            return result;
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1));
            for (int i10 = 0; i10 < length; i10++) {
                kArr2[iArr[i10]] = kArr[i10];
            }
            return kArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        private Bounds() {
            reset();
        }

        protected void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        protected void include(int before, int after) {
            this.before = Math.max(this.before, before);
            this.after = Math.max(this.after, after);
        }

        protected int size(boolean min) {
            if (!min && GridLayout.canStretch(this.flexibility)) {
                return 100000;
            }
            return this.before + this.after;
        }

        protected int getOffset(GridLayout gl, View c4, Alignment a10, int size, boolean horizontal) {
            return this.before - a10.getAlignmentValue(c4, size, gl.getLayoutMode());
        }

        protected final void include(GridLayout gl, View c4, Spec spec, Axis axis, int size) {
            this.flexibility &= spec.getFlexibility();
            boolean z10 = axis.horizontal;
            Alignment alignment = spec.getAbsoluteAlignment(axis.horizontal);
            int before = alignment.getAlignmentValue(c4, size, gl.getLayoutMode());
            include(before, size - before);
        }

        public String toString() {
            return "Bounds{before=" + this.before + ", after=" + this.after + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Interval {
        public final int max;
        public final int min;

        public Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }

        int size() {
            return this.max - this.min;
        }

        Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null || getClass() != that.getClass()) {
                return false;
            }
            Interval interval = (Interval) that;
            if (this.max == interval.max && this.min == interval.min) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.min;
            return (result * 31) + this.max;
        }

        public String toString() {
            return "[" + this.min + ", " + this.max + "]";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        private Spec(boolean startDefined, Interval span, Alignment alignment, float weight) {
            this.startDefined = startDefined;
            this.span = span;
            this.alignment = alignment;
            this.weight = weight;
        }

        private Spec(boolean startDefined, int start, int size, Alignment alignment, float weight) {
            this(startDefined, new Interval(start, start + size), alignment, weight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Alignment getAbsoluteAlignment(boolean horizontal) {
            if (this.alignment != GridLayout.UNDEFINED_ALIGNMENT) {
                return this.alignment;
            }
            if (this.weight == 0.0f) {
                return horizontal ? GridLayout.START : GridLayout.BASELINE;
            }
            return GridLayout.FILL;
        }

        final Spec copyWriteSpan(Interval span) {
            return new Spec(this.startDefined, span, this.alignment, this.weight);
        }

        final Spec copyWriteAlignment(Alignment alignment) {
            return new Spec(this.startDefined, this.span, alignment, this.weight);
        }

        final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null || getClass() != that.getClass()) {
                return false;
            }
            Spec spec = (Spec) that;
            if (this.alignment.equals(spec.alignment) && this.span.equals(spec.span)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int result = this.span.hashCode();
            return (result * 31) + this.alignment.hashCode();
        }
    }

    public static Spec spec(int start, int size, Alignment alignment, float weight) {
        return new Spec(start != Integer.MIN_VALUE, start, size, alignment, weight);
    }

    public static Spec spec(int start, Alignment alignment, float weight) {
        return spec(start, 1, alignment, weight);
    }

    public static Spec spec(int start, int size, float weight) {
        return spec(start, size, UNDEFINED_ALIGNMENT, weight);
    }

    public static Spec spec(int start, float weight) {
        return spec(start, 1, weight);
    }

    public static Spec spec(int start, int size, Alignment alignment) {
        return spec(start, size, alignment, 0.0f);
    }

    public static Spec spec(int start, Alignment alignment) {
        return spec(start, 1, alignment);
    }

    public static Spec spec(int start, int size) {
        return spec(start, size, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int start) {
        return spec(start, 1);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class Alignment {
        abstract int getAlignmentValue(View view, int i10, int i11);

        abstract int getGravityOffset(View view, int i10);

        Alignment() {
        }

        int getSizeInCell(View view, int viewSize, int cellSize) {
            return viewSize;
        }

        Bounds getBounds() {
            return new Bounds();
        }
    }

    private static Alignment createSwitchingAlignment(final Alignment ltr, final Alignment rtl) {
        return new Alignment() { // from class: android.widget.GridLayout.5
            @Override // android.widget.GridLayout.Alignment
            int getGravityOffset(View view, int cellDelta) {
                return (!view.isLayoutRtl() ? Alignment.this : rtl).getGravityOffset(view, cellDelta);
            }

            @Override // android.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int viewSize, int mode) {
                return (!view.isLayoutRtl() ? Alignment.this : rtl).getAlignmentValue(view, viewSize, mode);
            }
        };
    }

    static boolean canStretch(int flexibility) {
        return (flexibility & 2) != 0;
    }
}

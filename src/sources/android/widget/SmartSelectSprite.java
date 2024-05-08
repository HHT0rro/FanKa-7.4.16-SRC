package android.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SmartSelectSprite {
    private static final int EXPAND_DURATION = 200;
    static final Comparator<RectF> RECTANGLE_COMPARATOR = Comparator.comparingDouble(new ToDoubleFunction() { // from class: android.widget.SmartSelectSprite$$ExternalSyntheticLambda0
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 double, still in use, count: 1, list:
              (r0v0 double) from 0x0006: RETURN (r0v0 double)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:452)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // java.util.function.ToDoubleFunction
        public final double applyAsDouble(java.lang.Object r3) {
            /*
                r2 = this;
                android.graphics.RectF r3 = (android.graphics.RectF) r3
                double r0 = android.widget.SmartSelectSprite.lambda$static$0(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.SmartSelectSprite$$ExternalSyntheticLambda0.applyAsDouble(java.lang.Object):double");
        }
    }).thenComparingDouble(new ToDoubleFunction() { // from class: android.widget.SmartSelectSprite$$ExternalSyntheticLambda1
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 double, still in use, count: 1, list:
              (r0v0 double) from 0x0006: RETURN (r0v0 double)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:452)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // java.util.function.ToDoubleFunction
        public final double applyAsDouble(java.lang.Object r3) {
            /*
                r2 = this;
                android.graphics.RectF r3 = (android.graphics.RectF) r3
                double r0 = android.widget.SmartSelectSprite.lambda$static$1(r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.widget.SmartSelectSprite$$ExternalSyntheticLambda1.applyAsDouble(java.lang.Object):double");
        }
    });
    private Animator mActiveAnimator = null;
    private Drawable mExistingDrawable = null;
    private RectangleList mExistingRectangleList = null;
    private final Interpolator mExpandInterpolator;
    private final int mFillColor;
    private final Runnable mInvalidator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RectangleWithTextSelectionLayout {
        private final RectF mRectangle;
        private final int mTextSelectionLayout;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RectangleWithTextSelectionLayout(RectF rectangle, int textSelectionLayout) {
            this.mRectangle = (RectF) Objects.requireNonNull(rectangle);
            this.mTextSelectionLayout = textSelectionLayout;
        }

        public RectF getRectangle() {
            return this.mRectangle;
        }

        public int getTextSelectionLayout() {
            return this.mTextSelectionLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RoundedRectangleShape extends Shape {
        private static final String PROPERTY_ROUND_RATIO = "roundRatio";
        private final RectF mBoundingRectangle;
        private final float mBoundingWidth;
        private final Path mClipPath;
        private final RectF mDrawRect;
        private final int mExpansionDirection;
        private final boolean mInverted;
        private float mLeftBoundary;
        private float mRightBoundary;
        private float mRoundRatio;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        private @interface ExpansionDirection {
            public static final int CENTER = 0;
            public static final int LEFT = -1;
            public static final int RIGHT = 1;
        }

        private static int invert(int expansionDirection) {
            return expansionDirection * (-1);
        }

        private RoundedRectangleShape(RectF boundingRectangle, int expansionDirection, boolean inverted) {
            this.mRoundRatio = 1.0f;
            this.mDrawRect = new RectF();
            this.mClipPath = new Path();
            this.mLeftBoundary = 0.0f;
            this.mRightBoundary = 0.0f;
            this.mBoundingRectangle = new RectF(boundingRectangle);
            this.mBoundingWidth = boundingRectangle.width();
            this.mInverted = inverted && expansionDirection != 0;
            if (inverted) {
                this.mExpansionDirection = invert(expansionDirection);
            } else {
                this.mExpansionDirection = expansionDirection;
            }
            if (boundingRectangle.height() > boundingRectangle.width()) {
                setRoundRatio(0.0f);
            } else {
                setRoundRatio(1.0f);
            }
        }

        @Override // android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            if (this.mLeftBoundary == this.mRightBoundary) {
                return;
            }
            float cornerRadius = getCornerRadius();
            float adjustedCornerRadius = getAdjustedCornerRadius();
            this.mDrawRect.set(this.mBoundingRectangle);
            this.mDrawRect.left = (this.mBoundingRectangle.left + this.mLeftBoundary) - (cornerRadius / 2.0f);
            this.mDrawRect.right = this.mBoundingRectangle.left + this.mRightBoundary + (cornerRadius / 2.0f);
            canvas.save();
            this.mClipPath.reset();
            this.mClipPath.addRoundRect(this.mDrawRect, adjustedCornerRadius, adjustedCornerRadius, Path.Direction.CW);
            canvas.clipPath(this.mClipPath);
            canvas.drawRect(this.mBoundingRectangle, paint);
            canvas.restore();
        }

        void setRoundRatio(float roundRatio) {
            this.mRoundRatio = roundRatio;
        }

        float getRoundRatio() {
            return this.mRoundRatio;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartBoundary(float startBoundary) {
            if (this.mInverted) {
                this.mRightBoundary = this.mBoundingWidth - startBoundary;
            } else {
                this.mLeftBoundary = startBoundary;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndBoundary(float endBoundary) {
            if (this.mInverted) {
                this.mLeftBoundary = this.mBoundingWidth - endBoundary;
            } else {
                this.mRightBoundary = endBoundary;
            }
        }

        private float getCornerRadius() {
            return Math.min(this.mBoundingRectangle.width(), this.mBoundingRectangle.height());
        }

        private float getAdjustedCornerRadius() {
            return getCornerRadius() * this.mRoundRatio;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getBoundingWidth() {
            return (int) (this.mBoundingRectangle.width() + getCornerRadius());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RectangleList extends Shape {
        private static final String PROPERTY_LEFT_BOUNDARY = "leftBoundary";
        private static final String PROPERTY_RIGHT_BOUNDARY = "rightBoundary";
        private int mDisplayType;
        private final Path mOutlinePolygonPath;
        private final List<RoundedRectangleShape> mRectangles;
        private final List<RoundedRectangleShape> mReversedRectangles;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        private @interface DisplayType {
            public static final int POLYGON = 1;
            public static final int RECTANGLES = 0;
        }

        private RectangleList(List<RoundedRectangleShape> rectangles) {
            this.mDisplayType = 0;
            this.mRectangles = new ArrayList(rectangles);
            ArrayList arrayList = new ArrayList(rectangles);
            this.mReversedRectangles = arrayList;
            Collections.reverse(arrayList);
            this.mOutlinePolygonPath = generateOutlinePolygonPath(rectangles);
        }

        private void setLeftBoundary(float leftBoundary) {
            float boundarySoFar = getTotalWidth();
            for (RoundedRectangleShape rectangle : this.mReversedRectangles) {
                float rectangleLeftBoundary = boundarySoFar - rectangle.getBoundingWidth();
                if (leftBoundary < rectangleLeftBoundary) {
                    rectangle.setStartBoundary(0.0f);
                } else if (leftBoundary > boundarySoFar) {
                    rectangle.setStartBoundary(rectangle.getBoundingWidth());
                } else {
                    rectangle.setStartBoundary((rectangle.getBoundingWidth() - boundarySoFar) + leftBoundary);
                }
                boundarySoFar = rectangleLeftBoundary;
            }
        }

        private void setRightBoundary(float rightBoundary) {
            float boundarySoFar = 0.0f;
            for (RoundedRectangleShape rectangle : this.mRectangles) {
                float rectangleRightBoundary = rectangle.getBoundingWidth() + boundarySoFar;
                if (rectangleRightBoundary < rightBoundary) {
                    rectangle.setEndBoundary(rectangle.getBoundingWidth());
                } else if (boundarySoFar > rightBoundary) {
                    rectangle.setEndBoundary(0.0f);
                } else {
                    rectangle.setEndBoundary(rightBoundary - boundarySoFar);
                }
                boundarySoFar = rectangleRightBoundary;
            }
        }

        void setDisplayType(int displayType) {
            this.mDisplayType = displayType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getTotalWidth() {
            int sum = 0;
            for (RoundedRectangleShape rectangle : this.mRectangles) {
                sum = (int) (sum + rectangle.getBoundingWidth());
            }
            return sum;
        }

        @Override // android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            if (this.mDisplayType == 1) {
                drawPolygon(canvas, paint);
            } else {
                drawRectangles(canvas, paint);
            }
        }

        private void drawRectangles(Canvas canvas, Paint paint) {
            for (RoundedRectangleShape rectangle : this.mRectangles) {
                rectangle.draw(canvas, paint);
            }
        }

        private void drawPolygon(Canvas canvas, Paint paint) {
            canvas.drawPath(this.mOutlinePolygonPath, paint);
        }

        private static Path generateOutlinePolygonPath(List<RoundedRectangleShape> rectangles) {
            Path path = new Path();
            for (RoundedRectangleShape shape : rectangles) {
                Path rectanglePath = new Path();
                rectanglePath.addRect(shape.mBoundingRectangle, Path.Direction.CW);
                path.op(rectanglePath, Path.Op.UNION);
            }
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmartSelectSprite(Context context, int highlightColor, Runnable invalidator) {
        this.mExpandInterpolator = AnimationUtils.loadInterpolator(context, 17563661);
        this.mFillColor = highlightColor;
        this.mInvalidator = (Runnable) Objects.requireNonNull(invalidator);
    }

    public void startAnimation(PointF pointF, List<RectangleWithTextSelectionLayout> list, Runnable runnable) {
        RectangleWithTextSelectionLayout rectangleWithTextSelectionLayout;
        cancelAnimation();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: android.widget.SmartSelectSprite$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartSelectSprite.this.lambda$startAnimation$2(valueAnimator);
            }
        };
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        int i10 = 0;
        Iterator<RectangleWithTextSelectionLayout> iterator2 = list.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                rectangleWithTextSelectionLayout = null;
                break;
            }
            RectangleWithTextSelectionLayout next = iterator2.next();
            RectF rectangle = next.getRectangle();
            if (contains(rectangle, pointF)) {
                rectangleWithTextSelectionLayout = next;
                break;
            }
            i10 = (int) (i10 + rectangle.width());
        }
        if (rectangleWithTextSelectionLayout == null) {
            throw new IllegalArgumentException("Center point is not inside any of the rectangles!");
        }
        int i11 = (int) (i10 + (pointF.x - rectangleWithTextSelectionLayout.getRectangle().left));
        int[] generateDirections = generateDirections(rectangleWithTextSelectionLayout, list);
        int i12 = 0;
        while (true) {
            byte b4 = 0;
            if (i12 < size) {
                RectangleWithTextSelectionLayout rectangleWithTextSelectionLayout2 = list.get(i12);
                arrayList.add(new RoundedRectangleShape(rectangleWithTextSelectionLayout2.getRectangle(), generateDirections[i12], rectangleWithTextSelectionLayout2.getTextSelectionLayout() == 0));
                i12++;
            } else {
                RectangleList rectangleList = new RectangleList(arrayList);
                ShapeDrawable shapeDrawable = new ShapeDrawable(rectangleList);
                Paint paint = shapeDrawable.getPaint();
                paint.setColor(this.mFillColor);
                paint.setStyle(Paint.Style.FILL);
                this.mExistingRectangleList = rectangleList;
                this.mExistingDrawable = shapeDrawable;
                Animator createAnimator = createAnimator(rectangleList, i11, i11, animatorUpdateListener, runnable);
                this.mActiveAnimator = createAnimator;
                createAnimator.start();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnimation$2(ValueAnimator valueAnimator) {
        this.mInvalidator.run();
    }

    public boolean isAnimationActive() {
        Animator animator = this.mActiveAnimator;
        return animator != null && animator.isRunning();
    }

    private Animator createAnimator(RectangleList rectangleList, float startingOffsetLeft, float startingOffsetRight, ValueAnimator.AnimatorUpdateListener updateListener, Runnable onAnimationEnd) {
        ObjectAnimator rightBoundaryAnimator = ObjectAnimator.ofFloat(rectangleList, "rightBoundary", startingOffsetRight, rectangleList.getTotalWidth());
        ObjectAnimator leftBoundaryAnimator = ObjectAnimator.ofFloat(rectangleList, "leftBoundary", startingOffsetLeft, 0.0f);
        rightBoundaryAnimator.setDuration(200L);
        leftBoundaryAnimator.setDuration(200L);
        rightBoundaryAnimator.addUpdateListener(updateListener);
        leftBoundaryAnimator.addUpdateListener(updateListener);
        rightBoundaryAnimator.setInterpolator(this.mExpandInterpolator);
        leftBoundaryAnimator.setInterpolator(this.mExpandInterpolator);
        AnimatorSet boundaryAnimator = new AnimatorSet();
        boundaryAnimator.playTogether(leftBoundaryAnimator, rightBoundaryAnimator);
        setUpAnimatorListener(boundaryAnimator, onAnimationEnd);
        return boundaryAnimator;
    }

    private void setUpAnimatorListener(Animator animator, final Runnable onAnimationEnd) {
        animator.addListener(new Animator.AnimatorListener() { // from class: android.widget.SmartSelectSprite.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                SmartSelectSprite.this.mExistingRectangleList.setDisplayType(1);
                SmartSelectSprite.this.mInvalidator.run();
                onAnimationEnd.run();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
            }
        });
    }

    private static int[] generateDirections(RectangleWithTextSelectionLayout centerRectangle, List<RectangleWithTextSelectionLayout> rectangles) {
        int[] result = new int[rectangles.size()];
        int centerRectangleIndex = rectangles.indexOf(centerRectangle);
        for (int i10 = 0; i10 < centerRectangleIndex - 1; i10++) {
            result[i10] = -1;
        }
        int i11 = rectangles.size();
        if (i11 == 1) {
            result[centerRectangleIndex] = 0;
        } else if (centerRectangleIndex == 0) {
            result[centerRectangleIndex] = -1;
        } else if (centerRectangleIndex == rectangles.size() - 1) {
            result[centerRectangleIndex] = 1;
        } else {
            result[centerRectangleIndex] = 0;
        }
        for (int i12 = centerRectangleIndex + 1; i12 < result.length; i12++) {
            result[i12] = 1;
        }
        return result;
    }

    private static boolean contains(RectF rectangle, PointF point) {
        float x10 = point.x;
        float y10 = point.y;
        return x10 >= rectangle.left && x10 <= rectangle.right && y10 >= rectangle.top && y10 <= rectangle.bottom;
    }

    private void removeExistingDrawables() {
        this.mExistingDrawable = null;
        this.mExistingRectangleList = null;
        this.mInvalidator.run();
    }

    public void cancelAnimation() {
        Animator animator = this.mActiveAnimator;
        if (animator != null) {
            animator.cancel();
            this.mActiveAnimator = null;
            removeExistingDrawables();
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.mExistingDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }
}

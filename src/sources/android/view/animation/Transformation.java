package android.view.animation;

import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.Rect;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Transformation {
    public static final int TYPE_ALPHA = 1;
    public static final int TYPE_BOTH = 3;
    public static final int TYPE_IDENTITY = 0;
    public static final int TYPE_MATRIX = 2;
    protected float mAlpha;
    private boolean mHasClipRect;
    protected Matrix mMatrix;
    protected int mTransformationType;
    private Rect mClipRect = new Rect();
    private Insets mInsets = Insets.NONE;

    public Transformation() {
        clear();
    }

    public void clear() {
        Matrix matrix = this.mMatrix;
        if (matrix == null) {
            this.mMatrix = new Matrix();
        } else {
            matrix.reset();
        }
        this.mClipRect.setEmpty();
        this.mHasClipRect = false;
        this.mAlpha = 1.0f;
        this.mTransformationType = 3;
    }

    public int getTransformationType() {
        return this.mTransformationType;
    }

    public void setTransformationType(int transformationType) {
        this.mTransformationType = transformationType;
    }

    public void set(Transformation t2) {
        this.mAlpha = t2.getAlpha();
        this.mMatrix.set(t2.getMatrix());
        if (t2.mHasClipRect) {
            setClipRect(t2.getClipRect());
        } else {
            this.mHasClipRect = false;
            this.mClipRect.setEmpty();
        }
        this.mTransformationType = t2.getTransformationType();
    }

    public void compose(Transformation t2) {
        this.mAlpha *= t2.getAlpha();
        this.mMatrix.preConcat(t2.getMatrix());
        if (t2.mHasClipRect) {
            Rect bounds = t2.getClipRect();
            if (this.mHasClipRect) {
                setClipRect(this.mClipRect.left + bounds.left, this.mClipRect.top + bounds.top, this.mClipRect.right + bounds.right, this.mClipRect.bottom + bounds.bottom);
            } else {
                setClipRect(bounds);
            }
        }
        setInsets(Insets.add(getInsets(), t2.getInsets()));
    }

    public void postCompose(Transformation t2) {
        this.mAlpha *= t2.getAlpha();
        this.mMatrix.postConcat(t2.getMatrix());
        if (t2.mHasClipRect) {
            Rect bounds = t2.getClipRect();
            if (this.mHasClipRect) {
                setClipRect(this.mClipRect.left + bounds.left, this.mClipRect.top + bounds.top, this.mClipRect.right + bounds.right, this.mClipRect.bottom + bounds.bottom);
            } else {
                setClipRect(bounds);
            }
        }
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setAlpha(float alpha) {
        this.mAlpha = alpha;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setClipRect(Rect r10) {
        setClipRect(r10.left, r10.top, r10.right, r10.bottom);
    }

    public void setClipRect(int l10, int t2, int r10, int b4) {
        this.mClipRect.set(l10, t2, r10, b4);
        this.mHasClipRect = true;
    }

    public Rect getClipRect() {
        return this.mClipRect;
    }

    public boolean hasClipRect() {
        return this.mHasClipRect;
    }

    public void setInsets(Insets insets) {
        this.mInsets = insets;
    }

    public void setInsets(int left, int top, int right, int bottom) {
        this.mInsets = Insets.of(left, top, right, bottom);
    }

    public Insets getInsets() {
        return this.mInsets;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Transformation");
        toShortString(sb2);
        return sb2.toString();
    }

    public String toShortString() {
        StringBuilder sb2 = new StringBuilder(64);
        toShortString(sb2);
        return sb2.toString();
    }

    public void toShortString(StringBuilder sb2) {
        sb2.append("{alpha=");
        sb2.append(this.mAlpha);
        sb2.append(" matrix=");
        sb2.append(this.mMatrix.toShortString());
        sb2.append('}');
    }

    public void printShortString(PrintWriter pw) {
        pw.print("{alpha=");
        pw.print(this.mAlpha);
        pw.print(" matrix=");
        this.mMatrix.dump(pw);
        pw.print('}');
    }
}

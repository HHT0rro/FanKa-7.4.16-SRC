package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.animation.HasNativeInterpolator;
import android.graphics.animation.NativeInterpolator;
import android.graphics.animation.NativeInterpolatorFactory;
import android.os.Debug;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.util.PathParser;
import android.view.InflateException;
import com.android.internal.R;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@HasNativeInterpolator
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PathInterpolator extends BaseInterpolator implements NativeInterpolator {
    private static boolean DEBUG = SystemProperties.getBoolean("persist.sys.assert.panic", false);
    private static final float PRECISION = 0.002f;
    private static final String TAG = "PathInterpolator";
    private float[] mX;
    private float[] mY;

    public PathInterpolator(Path path) {
        initPath(path);
    }

    public PathInterpolator(float controlX, float controlY) {
        initQuad(controlX, controlY);
    }

    public PathInterpolator(float controlX1, float controlY1, float controlX2, float controlY2) {
        initCubic(controlX1, controlY1, controlX2, controlY2);
    }

    public PathInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public PathInterpolator(Resources res, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.PathInterpolator, 0, 0);
        } else {
            a10 = res.obtainAttributes(attrs, R.styleable.PathInterpolator);
        }
        parseInterpolatorFromTypeArray(a10);
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    private void parseInterpolatorFromTypeArray(TypedArray a10) {
        if (a10.hasValue(4)) {
            String pathData = a10.getString(4);
            Path path = PathParser.createPathFromPathData(pathData);
            if (path == null) {
                throw new InflateException("The path is null, which is created from " + pathData);
            }
            initPath(path);
            return;
        }
        if (!a10.hasValue(0)) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (a10.hasValue(1)) {
            float x12 = a10.getFloat(0, 0.0f);
            float y1 = a10.getFloat(1, 0.0f);
            boolean hasX2 = a10.hasValue(2);
            boolean hasY2 = a10.hasValue(3);
            if (hasX2 != hasY2) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            if (!hasX2) {
                initQuad(x12, y1);
                return;
            }
            float x22 = a10.getFloat(2, 0.0f);
            float y22 = a10.getFloat(3, 0.0f);
            initCubic(x12, y1, x22, y22);
            return;
        }
        throw new InflateException("pathInterpolator requires the controlY1 attribute");
    }

    private void initQuad(float controlX, float controlY) {
        if (DEBUG) {
            Log.d(TAG, "initQuad: controlX = " + controlX + " controlY = " + controlY + " " + Debug.getCallers(10));
        }
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(controlX, controlY, 1.0f, 1.0f);
        initPath(path);
    }

    private void initCubic(float x12, float y1, float x22, float y22) {
        if (DEBUG) {
            Log.d(TAG, "initQuad: x1 = " + x12 + " y1 = " + y1 + " x2 = " + x22 + " y2 = " + y22 + " " + Debug.getCallers(10));
        }
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(x12, y1, x22, y22, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        float[] pointComponents = path.approximate(0.002f);
        int numPoints = pointComponents.length / 3;
        if (pointComponents[1] != 0.0f || pointComponents[2] != 0.0f || pointComponents[pointComponents.length - 2] != 1.0f || pointComponents[pointComponents.length - 1] != 1.0f) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1)");
        }
        if (DEBUG) {
            Log.d(TAG, "initPath: " + Arrays.toString(pointComponents));
        }
        this.mX = new float[numPoints];
        this.mY = new float[numPoints];
        float prevX = 0.0f;
        float prevFraction = 0.0f;
        int componentIndex = 0;
        int i10 = 0;
        while (i10 < numPoints) {
            int componentIndex2 = componentIndex + 1;
            float fraction = pointComponents[componentIndex];
            int componentIndex3 = componentIndex2 + 1;
            float x10 = pointComponents[componentIndex2];
            int componentIndex4 = componentIndex3 + 1;
            float y10 = pointComponents[componentIndex3];
            if (fraction == prevFraction && x10 != prevX) {
                if (DEBUG) {
                    Log.w(TAG, "fraction = " + fraction + " prevFraction = " + prevFraction + " x = " + x10 + " prevX = " + prevX);
                }
                throw new IllegalArgumentException("The Path cannot have discontinuity in the X axis.");
            }
            if (x10 < prevX) {
                throw new IllegalArgumentException("The Path cannot loop back on itself.");
            }
            this.mX[i10] = x10;
            this.mY[i10] = y10;
            prevX = x10;
            prevFraction = fraction;
            i10++;
            componentIndex = componentIndex4;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t2) {
        if (t2 <= 0.0f) {
            return 0.0f;
        }
        if (t2 >= 1.0f) {
            return 1.0f;
        }
        int startIndex = 0;
        int endIndex = this.mX.length - 1;
        while (endIndex - startIndex > 1) {
            int midIndex = (startIndex + endIndex) / 2;
            if (t2 < this.mX[midIndex]) {
                endIndex = midIndex;
            } else {
                startIndex = midIndex;
            }
        }
        float[] fArr = this.mX;
        float f10 = fArr[endIndex];
        float f11 = fArr[startIndex];
        float xRange = f10 - f11;
        if (xRange == 0.0f) {
            return this.mY[startIndex];
        }
        float tInRange = t2 - f11;
        float fraction = tInRange / xRange;
        float[] fArr2 = this.mY;
        float startY = fArr2[startIndex];
        float endY = fArr2[endIndex];
        return ((endY - startY) * fraction) + startY;
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createPathInterpolator(this.mX, this.mY);
    }
}

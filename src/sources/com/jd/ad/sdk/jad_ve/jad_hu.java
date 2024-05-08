package com.jd.ad.sdk.jad_ve;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Build;
import java.io.Closeable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_hu {
    public static final ThreadLocal<PathMeasure> jad_an = new jad_an();
    public static final ThreadLocal<Path> jad_bo = new jad_bo();
    public static final ThreadLocal<Path> jad_cp = new jad_cp();
    public static final ThreadLocal<float[]> jad_dq = new jad_dq();
    public static final float jad_er = (float) (Math.sqrt(2.0d) / 2.0d);
    public static float jad_fs = -1.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_an extends ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_bo extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_cp extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public Path initialValue() {
            return new Path();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_dq extends ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        public float[] initialValue() {
            return new float[4];
        }
    }

    public static float jad_an() {
        if (jad_fs == -1.0f) {
            jad_fs = Resources.getSystem().getDisplayMetrics().density;
        }
        return jad_fs;
    }

    public static float jad_an(Matrix matrix) {
        float[] fArr = jad_dq.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f10 = jad_er;
        fArr[2] = f10;
        fArr[3] = f10;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void jad_an(Canvas canvas, RectF rectF, Paint paint, int i10) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i10);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("Utils#saveLayer");
    }

    public static void jad_an(Path path, float f10, float f11, float f12) {
        PathMeasure pathMeasure = jad_an.get();
        Path path2 = jad_bo.get();
        Path path3 = jad_cp.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f10 == 1.0f && f11 == 0.0f) {
            com.jd.ad.sdk.jad_js.jad_dq.jad_an("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f11 - f10) - 1.0f) < 0.01d) {
            com.jd.ad.sdk.jad_js.jad_dq.jad_an("applyTrimPathIfNeeded");
            return;
        }
        float f13 = f10 * length;
        float f14 = f11 * length;
        float f15 = f12 * length;
        float min = Math.min(f13, f14) + f15;
        float max = Math.max(f13, f14) + f15;
        if (min >= length && max >= length) {
            min = jad_jt.jad_an(min, length);
            max = jad_jt.jad_an(max, length);
        }
        if (min < 0.0f) {
            min = jad_jt.jad_an(min, length);
        }
        if (max < 0.0f) {
            max = jad_jt.jad_an(max, length);
        }
        if (min == max) {
            path.reset();
        } else {
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
            } else {
                if (min < 0.0f) {
                    path3.reset();
                    pathMeasure.getSegment(min + length, length, path3, true);
                }
                path.set(path2);
            }
            path2.addPath(path3);
            path.set(path2);
        }
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("applyTrimPathIfNeeded");
    }

    public static void jad_an(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}

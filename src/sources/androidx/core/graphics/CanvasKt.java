package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Canvas.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CanvasKt {
    public static final void withClip(@NotNull Canvas canvas, @NotNull Rect clipRect, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(clipRect, "clipRect");
        s.i(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withMatrix(@NotNull Canvas canvas, @NotNull Matrix matrix, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(matrix, "matrix");
        s.i(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Function1 block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matrix = new Matrix();
        }
        s.i(canvas, "<this>");
        s.i(matrix, "matrix");
        s.i(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withRotation(@NotNull Canvas canvas, float f10, float f11, float f12, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f10, float f11, float f12, Function1 block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.rotate(f10, f11, f12);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withSave(@NotNull Canvas canvas, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withScale(@NotNull Canvas canvas, float f10, float f11, float f12, float f13, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f10, float f11, float f12, float f13, Function1 block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.scale(f10, f11, f12, f13);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withSkew(@NotNull Canvas canvas, float f10, float f11, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.skew(f10, f11);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f10, float f11, Function1 block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.skew(f10, f11);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withTranslation(@NotNull Canvas canvas, float f10, float f11, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.translate(f10, f11);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f10, float f11, Function1 block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.translate(f10, f11);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, @NotNull RectF clipRect, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(clipRect, "clipRect");
        s.i(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, int i10, int i11, int i12, int i13, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.clipRect(i10, i11, i12, i13);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, float f10, float f11, float f12, float f13, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(block, "block");
        int save = canvas.save();
        canvas.clipRect(f10, f11, f12, f13);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }

    public static final void withClip(@NotNull Canvas canvas, @NotNull Path clipPath, @NotNull Function1<? super Canvas, p> block) {
        s.i(canvas, "<this>");
        s.i(clipPath, "clipPath");
        s.i(block, "block");
        int save = canvas.save();
        canvas.clipPath(clipPath);
        try {
            block.invoke(canvas);
        } finally {
            r.b(1);
            canvas.restoreToCount(save);
            r.a(1);
        }
    }
}

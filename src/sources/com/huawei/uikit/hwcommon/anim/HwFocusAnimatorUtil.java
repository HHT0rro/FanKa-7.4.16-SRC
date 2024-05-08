package com.huawei.uikit.hwcommon.anim;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.huawei.appgallery.agd.agdpro.R$dimen;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwFocusAnimatorUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f34878a = "HwFocusAnimatorUtil";

    /* renamed from: b, reason: collision with root package name */
    public static final int f34879b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f34880c;

    public static void disableViewClipChildren(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    public static int getFocusedPathPadding(@NonNull Context context) {
        int i10 = f34880c;
        if (i10 != 0) {
            return i10;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.hwcommon_focused_path_padding);
        f34880c = dimensionPixelSize;
        return dimensionPixelSize;
    }

    @RequiresApi(api = 24)
    public static void resetOutlinePath(@NonNull Context context, @NonNull ViewOutlineProvider viewOutlineProvider, @NonNull View view, @NonNull Rect rect, @NonNull Path path) {
        resetOutlinePath(viewOutlineProvider, view, getFocusedPathPadding(context), rect, path);
    }

    @RequiresApi(api = 24)
    public static void resetOutlinePath(@NonNull ViewOutlineProvider viewOutlineProvider, @NonNull View view, int i10, @NonNull Rect rect, @NonNull Path path) {
        if (viewOutlineProvider == null || view == null || path == null || rect == null) {
            return;
        }
        Outline outline = new Outline();
        viewOutlineProvider.getOutline(view, outline);
        float radius = outline.getRadius();
        Rect rect2 = new Rect();
        outline.getRect(rect2);
        Rect rect3 = new Rect(rect2.left - i10, rect2.top - i10, rect2.right + i10, rect2.bottom + i10);
        if (rect3.equals(rect)) {
            return;
        }
        RectF rectF = new RectF(rect3.left, rect3.top, rect3.right, rect3.bottom);
        if (Float.compare(radius, 0.0f) != 0) {
            radius += i10;
        }
        path.reset();
        path.addRoundRect(rectF, radius, radius, Path.Direction.CW);
        rect.left = rect3.left;
        rect.top = rect3.top;
        rect.right = rect3.right;
        rect.bottom = rect3.bottom;
    }
}

package u3;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;

/* compiled from: SmartUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public static final float f53820a;

    /* renamed from: b, reason: collision with root package name */
    public static final float f53821b;

    static {
        float f10 = 1.0f / f(1.0f);
        f53820a = f10;
        f53821b = 1.0f - (f10 * f(1.0f));
    }

    public static boolean a(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (d(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(R$id.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean a10 = a(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return a10;
            }
        }
        return true;
    }

    public static boolean b(View view) {
        if (view instanceof q3.a) {
            return false;
        }
        return c(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static boolean c(View view) {
        if (view instanceof q3.a) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static boolean d(@NonNull View view, @NonNull View view2, float f10, float f11, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f10, f11};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z10 = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z10 && pointF != null) {
            pointF.set(fArr[0] - f10, fArr[1] - f11);
        }
        return z10;
    }

    public static void e(@NonNull AbsListView absListView, int i10) {
        absListView.scrollListBy(i10);
    }

    public static float f(float f10) {
        float f11 = f10 * 8.0f;
        if (f11 < 1.0f) {
            return f11 - (1.0f - ((float) Math.exp(-f11)));
        }
        return ((1.0f - ((float) Math.exp(1.0f - f11))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float f11 = f53820a * f(f10);
        return f11 > 0.0f ? f11 + f53821b : f11;
    }
}

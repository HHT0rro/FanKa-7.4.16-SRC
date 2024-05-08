package com.huawei.quickcard.views.list;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BounceHandler {

    /* renamed from: i, reason: collision with root package name */
    private static final String f34549i = "BounceHandler";

    /* renamed from: j, reason: collision with root package name */
    public static final int f34550j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static final int f34551k = 1;

    /* renamed from: l, reason: collision with root package name */
    public static final float f34552l = 0.5f;

    /* renamed from: m, reason: collision with root package name */
    public static final float f34553m = 0.3f;

    /* renamed from: n, reason: collision with root package name */
    public static final int f34554n = 350;

    /* renamed from: o, reason: collision with root package name */
    public static final int f34555o = 100;

    /* renamed from: a, reason: collision with root package name */
    public View f34556a;

    /* renamed from: b, reason: collision with root package name */
    public int f34557b;

    /* renamed from: c, reason: collision with root package name */
    public long f34558c;

    /* renamed from: d, reason: collision with root package name */
    public long f34559d;

    /* renamed from: e, reason: collision with root package name */
    public Rect f34560e;

    /* renamed from: f, reason: collision with root package name */
    public float f34561f;

    /* renamed from: g, reason: collision with root package name */
    public float f34562g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34563h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface BounceView {
        boolean isBottom();

        boolean isLeft();

        boolean isRight();

        boolean isTop();
    }

    public BounceHandler(HorizontalScrollView horizontalScrollView) {
        this(horizontalScrollView, 1);
    }

    private void a(View view, int i10) {
        if (view instanceof BounceView) {
            this.f34556a = view;
            this.f34557b = i10;
            view.setOverScrollMode(2);
            return;
        }
        throw new ClassCastException("View is not BounceView");
    }

    private boolean e(MotionEvent motionEvent) {
        if (!i() && !f()) {
            return false;
        }
        float y10 = motionEvent.getY();
        float f10 = this.f34562g;
        float f11 = y10 - f10;
        if (f10 == 0.0f) {
            f11 = 0.0f;
        }
        this.f34562g = y10;
        if (i() && e() + ((int) (f11 * 0.5f)) > this.f34560e.top) {
            a(0.0f, f11);
        }
        if (f() && b() + ((int) (0.5f * f11)) < this.f34560e.bottom) {
            a(0.0f, f11);
        }
        return this.f34563h;
    }

    public boolean b(MotionEvent motionEvent) {
        return d(motionEvent);
    }

    public boolean c(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 2) {
            return false;
        }
        float x10 = motionEvent.getX();
        float f10 = this.f34561f;
        float f11 = x10 - f10;
        if (f10 == 0.0f) {
            f11 = 0.0f;
        }
        this.f34561f = x10;
        if (g()) {
            if (c() + ((int) (0.5f * f11)) > this.f34560e.left) {
                a(f11, 0.0f);
                return this.f34563h;
            }
        } else if (h() && d() + ((int) (0.5f * f11)) < this.f34560e.right) {
            a(f11, 0.0f);
            return this.f34563h;
        }
        return false;
    }

    public boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 2 && action != 1 && action != 3) {
            return false;
        }
        if (action != 1 && action != 3) {
            int i10 = this.f34557b;
            if (i10 == 1) {
                return c(motionEvent);
            }
            if (i10 == 0) {
                return e(motionEvent);
            }
            CardLogUtils.d(f34549i, "Other cases.");
            return false;
        }
        if (this.f34563h) {
            this.f34563h = false;
            this.f34559d = System.currentTimeMillis();
            a();
        }
        this.f34560e.setEmpty();
        return false;
    }

    public boolean f() {
        try {
            return ((BounceView) this.f34556a).isBottom();
        } catch (Exception unused) {
            CardLogUtils.e(f34549i, "isBottom() exception.");
            return false;
        }
    }

    public boolean g() {
        try {
            return ((BounceView) this.f34556a).isLeft();
        } catch (Exception unused) {
            CardLogUtils.e(f34549i, "isLeft() exception.");
            return false;
        }
    }

    public boolean h() {
        try {
            return ((BounceView) this.f34556a).isRight();
        } catch (ClassCastException unused) {
            CardLogUtils.w(f34549i, "isRight() ClassCastException.");
            return false;
        } catch (IndexOutOfBoundsException unused2) {
            CardLogUtils.w(f34549i, "isRight() IndexOutOfBoundsException ");
            return false;
        } catch (Exception unused3) {
            CardLogUtils.w(f34549i, "isRight() Exception.");
            return false;
        }
    }

    public boolean i() {
        try {
            return ((BounceView) this.f34556a).isTop();
        } catch (ClassCastException unused) {
            CardLogUtils.e(f34549i, "isTop() class cast exception.");
            return false;
        }
    }

    public boolean j() {
        return this.f34557b == 0;
    }

    public BounceHandler(ListView listView) {
        this(listView, 0);
    }

    public int b() {
        return this.f34556a.getBottom();
    }

    public BounceHandler(RecyclerView recyclerView) {
        this(recyclerView, 1);
    }

    public BounceHandler(ScrollView scrollView) {
        this(scrollView, 0);
    }

    public BounceHandler(View view, int i10) {
        this.f34558c = 0L;
        this.f34559d = 0L;
        this.f34560e = new Rect();
        this.f34561f = 0.0f;
        this.f34562g = 0.0f;
        this.f34563h = false;
        a(view, i10);
    }

    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.f34561f = 0.0f;
        this.f34562g = 0.0f;
        this.f34558c = System.currentTimeMillis();
        this.f34560e.setEmpty();
        this.f34560e.set(c(), e(), d(), b());
        return false;
    }

    public int d() {
        return this.f34556a.getRight();
    }

    public void a(float f10, float f11) {
        this.f34563h = true;
        int i10 = (int) (f10 * 0.5f);
        int i11 = (int) (f11 * 0.5f);
        int c4 = c();
        int e2 = e();
        int d10 = d() + i10;
        int b4 = b() + i11;
        this.f34556a.layout(c4 + i10, e2 + i11, d10, b4);
    }

    public int e() {
        return this.f34556a.getTop();
    }

    public int c() {
        return this.f34556a.getLeft();
    }

    public void a() {
        long j10 = ((float) (this.f34559d - this.f34558c)) * 0.3f;
        if (j10 > 350) {
            j10 = 350;
        } else if (j10 < 100) {
            j10 = 100;
        } else {
            CardLogUtils.d(f34549i, "Other cases.");
        }
        TranslateAnimation translateAnimation = null;
        int i10 = this.f34557b;
        if (i10 == 1) {
            translateAnimation = new TranslateAnimation(c() - this.f34560e.left, 0.0f, 0.0f, 0.0f);
        } else if (i10 == 0) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, e() - this.f34560e.top, 0.0f);
        } else {
            CardLogUtils.d(f34549i, "Other cases.");
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(j10);
            this.f34556a.startAnimation(translateAnimation);
        }
        View view = this.f34556a;
        Rect rect = this.f34560e;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}

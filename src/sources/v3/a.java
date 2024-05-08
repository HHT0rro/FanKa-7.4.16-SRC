package v3;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.cupidapp.live.R$id;
import java.util.LinkedList;
import q3.b;
import q3.c;
import s3.e;

/* compiled from: RefreshContentWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements b, s3.a, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public View f54023b;

    /* renamed from: c, reason: collision with root package name */
    public View f54024c;

    /* renamed from: d, reason: collision with root package name */
    public View f54025d;

    /* renamed from: e, reason: collision with root package name */
    public View f54026e;

    /* renamed from: f, reason: collision with root package name */
    public int f54027f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f54028g = true;

    /* renamed from: h, reason: collision with root package name */
    public t3.a f54029h = new t3.a();

    public a(@NonNull View view) {
        this.f54025d = view;
        this.f54024c = view;
        this.f54023b = view;
    }

    @Override // q3.b
    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f54023b.getLeft(), -this.f54023b.getTop());
        View view = this.f54025d;
        View view2 = this.f54023b;
        if (view != view2) {
            this.f54025d = j(view2, pointF, view);
        }
        if (this.f54025d == this.f54023b) {
            this.f54029h.f53763a = null;
        } else {
            this.f54029h.f53763a = pointF;
        }
    }

    @Override // q3.b
    public void b(boolean z10) {
        this.f54029h.f53765c = z10;
    }

    @Override // q3.b
    public void c(c cVar, View view) {
        i(this.f54023b, cVar);
        if (view != null) {
            this.f54026e = view;
            FrameLayout frameLayout = new FrameLayout(this.f54023b.getContext());
            int indexOfChild = cVar.c().getLayout().indexOfChild(this.f54023b);
            cVar.c().getLayout().removeView(this.f54023b);
            frameLayout.addView(this.f54023b, 0, new ViewGroup.LayoutParams(-1, -1));
            cVar.c().getLayout().addView(frameLayout, indexOfChild, this.f54023b.getLayoutParams());
            this.f54023b = frameLayout;
            view.setTag(R$id.srl_tag, "fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = u3.a.b(view);
            viewGroup.addView(new Space(this.f54023b.getContext()), indexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // q3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            r2 = -1
            if (r6 == r2) goto L20
            android.view.View r2 = r4.f54024c
            android.view.View r6 = r2.findViewById(r6)
            if (r6 == 0) goto L20
            if (r5 <= 0) goto L15
            r2 = 1
            float r3 = (float) r5
            r6.setTranslationY(r3)
            goto L21
        L15:
            float r2 = r6.getTranslationY()
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 <= 0) goto L20
            r6.setTranslationY(r1)
        L20:
            r2 = 0
        L21:
            if (r2 != 0) goto L2a
            android.view.View r6 = r4.f54024c
            float r1 = (float) r5
            r6.setTranslationY(r1)
            goto L2f
        L2a:
            android.view.View r6 = r4.f54024c
            r6.setTranslationY(r1)
        L2f:
            android.view.View r6 = r4.f54026e
            if (r6 == 0) goto L3b
            int r5 = java.lang.Math.max(r0, r5)
            float r5 = (float) r5
            r6.setTranslationY(r5)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.a.d(int, int):void");
    }

    @Override // q3.b
    @NonNull
    public View e() {
        return this.f54025d;
    }

    @Override // q3.b
    public boolean f() {
        return this.f54028g && this.f54029h.a(this.f54023b);
    }

    @Override // q3.b
    public void g(e eVar) {
        if (eVar instanceof t3.a) {
            this.f54029h = (t3.a) eVar;
        } else {
            this.f54029h.f53764b = eVar;
        }
    }

    @Override // q3.b
    @NonNull
    public View getView() {
        return this.f54023b;
    }

    @Override // s3.a
    public void h(boolean z10, boolean z11) {
        this.f54028g = z10;
    }

    public void i(View view, c cVar) {
        boolean isInEditMode = this.f54023b.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = k(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                u3.a.a(view, cVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f54025d = view2;
        }
    }

    public View j(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (u3.b.d(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && u3.b.b(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View j10 = j(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return j10;
                }
            }
        }
        return view2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View k(View view, boolean z10) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z10 || view3 != view) && u3.b.b(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        linkedList.add(viewGroup.getChildAt(i10));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.f54027f) * this.f54025d.getScaleY();
            View view = this.f54025d;
            if (view instanceof AbsListView) {
                u3.b.e((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f54027f = intValue;
    }
}

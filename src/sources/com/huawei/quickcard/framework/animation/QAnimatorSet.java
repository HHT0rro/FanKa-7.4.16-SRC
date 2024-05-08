package com.huawei.quickcard.framework.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.d1;
import com.huawei.quickcard.f1;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.framework.ui.RenderCommand;
import com.huawei.quickcard.framework.ui.RenderPipeline;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QAnimatorSet {

    /* renamed from: b, reason: collision with root package name */
    private f1 f33762b;

    /* renamed from: c, reason: collision with root package name */
    private AnimatorSet f33763c;

    /* renamed from: d, reason: collision with root package name */
    private d1 f33764d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<View> f33765e;

    /* renamed from: f, reason: collision with root package name */
    private int f33766f;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, QuickCardValue> f33769i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private String f33761a = "none";

    /* renamed from: g, reason: collision with root package name */
    private boolean f33767g = false;

    /* renamed from: h, reason: collision with root package name */
    private m f33768h = new m();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FillMode {
        public static final String FORWARDS = "forwards";
        public static final String NONE = "none";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QuickCardValue quickCardValue = (QuickCardValue) QAnimatorSet.this.f33769i.get(Attributes.Style.OPACITY);
                if (quickCardValue == null) {
                    quickCardValue = QuickCardValue.EMPTY;
                }
                QAnimatorSet.this.a(Attributes.Style.OPACITY, quickCardValue);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QuickCardValue quickCardValue = (QuickCardValue) QAnimatorSet.this.f33769i.get("width");
                if (quickCardValue == null) {
                    quickCardValue = QuickCardValue.EMPTY;
                }
                QAnimatorSet.this.a("width", quickCardValue);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QuickCardValue quickCardValue = (QuickCardValue) QAnimatorSet.this.f33769i.get("height");
                if (quickCardValue == null) {
                    quickCardValue = QuickCardValue.EMPTY;
                }
                QAnimatorSet.this.a("height", quickCardValue);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            ValueAnimator valueAnimator;
            PropertyValuesHolder[] values;
            super.onAnimationStart(animator);
            if (QAnimatorSet.this.f33764d != null) {
                QAnimatorSet.this.f33764d.a((View) QAnimatorSet.this.f33765e.get());
                QAnimatorSet.this.f33764d.a();
            }
            Iterator<Animator> iterator2 = QAnimatorSet.this.f33763c.getChildAnimations().iterator2();
            while (iterator2.hasNext()) {
                Animator next = iterator2.next();
                if ((next instanceof ValueAnimator) && (values = (valueAnimator = (ValueAnimator) next).getValues()) != null && values.length >= 1) {
                    valueAnimator.setRepeatCount(Math.max(QAnimatorSet.this.f33766f - 1, 0));
                    QAnimatorSet.this.a(valueAnimator, values[0].getPropertyName());
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QuickCardValue quickCardValue = (QuickCardValue) QAnimatorSet.this.f33769i.get(Attributes.Style.BACKGROUND);
                if (quickCardValue == null) {
                    quickCardValue = QuickCardValue.EMPTY;
                }
                QAnimatorSet.this.a(Attributes.Style.BACKGROUND, quickCardValue);
                QuickCardValue quickCardValue2 = (QuickCardValue) QAnimatorSet.this.f33769i.get("backgroundColor");
                if (quickCardValue2 == null) {
                    quickCardValue2 = QuickCardValue.EMPTY;
                }
                QAnimatorSet.this.a("backgroundColor", quickCardValue2);
                QuickCardValue quickCardValue3 = (QuickCardValue) QAnimatorSet.this.f33769i.get("backgroundImage");
                if (quickCardValue3 == null) {
                    quickCardValue3 = QuickCardValue.EMPTY;
                }
                QAnimatorSet.this.a("backgroundImage", quickCardValue3);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.a();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.b();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.c();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.f();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.g();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class k extends AnimatorListenerAdapter {
        public k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.d();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class l extends AnimatorListenerAdapter {
        public l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (QAnimatorSet.this.d()) {
                QAnimatorSet.this.f33762b.e();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class m implements View.OnAttachStateChangeListener {
        public m() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            QAnimatorSet.this.a();
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public QAnimatorSet(View view) {
        this.f33765e = new WeakReference<>(view);
        this.f33762b = ValueUtils.obtainPropertyCacheBeanFromView(view).getQTransform(view);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f33763c = animatorSet;
        animatorSet.setInterpolator(new z());
        this.f33763c.addListener(new d());
    }

    private void h(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new l());
    }

    private void i(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new i());
    }

    private void j(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new j());
    }

    private void k(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new b());
    }

    private void b(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new e());
    }

    private void c(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new c());
    }

    private void d(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new f());
    }

    private void e(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new g());
    }

    private void f(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new h());
    }

    private void g(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return "none".equals(this.f33761a);
    }

    public void b(long j10) {
        this.f33763c.setStartDelay(j10);
    }

    public boolean c() {
        return this.f33767g;
    }

    public boolean e() {
        return this.f33763c.isRunning();
    }

    public void f() {
        this.f33767g = false;
        this.f33763c.start();
        View view = this.f33765e.get();
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.f33768h);
            view.addOnAttachStateChangeListener(this.f33768h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ValueAnimator valueAnimator, String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c4 = 4;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c4 = 5;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c4 = 6;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c4 = 7;
                    break;
                }
                break;
            case 92909918:
                if (str.equals(Key.ALPHA)) {
                    c4 = '\b';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                e(valueAnimator);
                return;
            case 1:
                f(valueAnimator);
                return;
            case 2:
                i(valueAnimator);
                return;
            case 3:
                j(valueAnimator);
                return;
            case 4:
                c(valueAnimator);
                return;
            case 5:
                g(valueAnimator);
                return;
            case 6:
                h(valueAnimator);
                return;
            case 7:
                d(valueAnimator);
                return;
            case '\b':
                a(valueAnimator);
                return;
            case '\t':
                k(valueAnimator);
                return;
            case '\n':
                b(valueAnimator);
                return;
            default:
                return;
        }
    }

    public Map<String, QuickCardValue> b() {
        return this.f33769i;
    }

    private void a(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, QuickCardValue quickCardValue) {
        View view = this.f33765e.get();
        if (view == null) {
            return;
        }
        Component component = ViewUtils.getComponent(view);
        Object tag = view.getTag(R.id.quick_card_context);
        if (component == null || !(tag instanceof CardContext)) {
            return;
        }
        CardContext cardContext = (CardContext) tag;
        RenderCommand buildRenderCommand = component.buildRenderCommand(view, str, quickCardValue);
        if (buildRenderCommand != null) {
            RenderPipeline renderPipeline = new RenderPipeline();
            renderPipeline.addCommand(buildRenderCommand);
            if (ViewUtils.hasCSSTag(cardContext, view)) {
                component.bindAllPseudoStylesRenderCommand(view, renderPipeline);
            }
            renderPipeline.render(cardContext, view);
        }
    }

    public void a(String str) {
        this.f33761a = str;
    }

    public void a(d1 d1Var) {
        this.f33764d = d1Var;
    }

    public void a(int i10) {
        this.f33766f = i10;
    }

    public void a(long j10) {
        this.f33763c.setDuration(j10);
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.f33763c.setInterpolator(timeInterpolator);
    }

    public void a() {
        this.f33763c.cancel();
    }

    public void a(Animator[] animatorArr) {
        this.f33763c.playTogether(animatorArr);
    }

    public void a(boolean z10) {
        this.f33767g = z10;
    }
}

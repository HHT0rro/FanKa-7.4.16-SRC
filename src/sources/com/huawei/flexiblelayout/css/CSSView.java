package com.huawei.flexiblelayout.css;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.adapter.RenderAdapterRegister;
import com.huawei.flexiblelayout.services.effect.FLEffect;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSView {

    /* renamed from: a, reason: collision with root package name */
    private View f27958a;

    /* renamed from: b, reason: collision with root package name */
    private CSSRule f27959b;

    /* renamed from: c, reason: collision with root package name */
    private CSSLink f27960c;

    public CSSView(View view) {
        this.f27958a = view;
    }

    private List<FLEffect> a(View view, CSSRule cSSRule) {
        if (view == null || cSSRule == null) {
            return null;
        }
        Class<?> cls = view.getClass();
        if (view instanceof ViewGroup) {
            cls = ViewGroup.class;
        }
        return RenderAdapterRegister.get(cls).create(view).render(view, cSSRule);
    }

    public static CSSView wrap(View view) {
        return new CSSView(view);
    }

    public CSSView cssLink(CSSLink cSSLink) {
        this.f27960c = cSSLink;
        return this;
    }

    public CSSView render() {
        if (this.f27958a != null) {
            renderSelf();
            a(this.f27958a, true);
        }
        return this;
    }

    public List<FLEffect> renderSelf() {
        CSSRule.a aVar = new CSSRule.a();
        String a10 = e.a(this.f27958a);
        if (a10 != null) {
            aVar.a(CSSSelector.build(a10).getRule(this.f27960c));
        }
        aVar.a(this.f27959b);
        CSSRule a11 = aVar.a();
        a11.setParent(this.f27960c);
        return a(this.f27958a, a11);
    }

    public static CSSView wrap(View view, CSSRule cSSRule) {
        com.huawei.flexiblelayout.common.d.a(view, CSSRule.CSSRULE_TAG, cSSRule);
        return new CSSView(view, cSSRule);
    }

    public CSSView(View view, CSSRule cSSRule) {
        this.f27958a = view;
        this.f27959b = cSSRule;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view, boolean z10) {
        CSSRule rule;
        boolean z11;
        String a10 = e.a(view);
        if (a10 != null && (rule = CSSSelector.build(a10).getRule(this.f27960c)) != null) {
            if (view instanceof RenderListener) {
                if (!((RenderListener) view).onRenderReady(new CSSViewProxy(view, rule))) {
                    z11 = false;
                    if (z11 && !z10) {
                        a(view, rule);
                    }
                }
            }
            z11 = true;
            if (z11) {
                a(view, rule);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                a(viewGroup.getChildAt(i10), false);
            }
        }
    }
}

package com.huawei.quickcard.views.text.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.exposure.extend.ExtendExposureManager;
import com.huawei.quickcard.exposure.extend.IExtendExposureSupport;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.IVirtualView;
import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.framework.b;
import com.huawei.quickcard.framework.c;
import com.huawei.quickcard.framework.d;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.GestureDelegate;
import com.huawei.quickcard.views.text.span.Span;
import com.huawei.quickcard.views.text.utils.SpannableUtils;
import com.huawei.quickcard.views.text.view.IQuickText;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QTextView extends TextView implements IComponentSupport, IVirtualViewParent, IQuickText, IExtendExposureSupport {

    /* renamed from: a, reason: collision with root package name */
    private ExposureManager f34678a;

    /* renamed from: b, reason: collision with root package name */
    private ExtendExposureManager f34679b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f34680c;

    /* renamed from: d, reason: collision with root package name */
    private Float f34681d;

    /* renamed from: e, reason: collision with root package name */
    private String f34682e;

    /* renamed from: f, reason: collision with root package name */
    private String f34683f;

    /* renamed from: g, reason: collision with root package name */
    private Object f34684g;

    /* renamed from: h, reason: collision with root package name */
    private String f34685h;

    /* renamed from: i, reason: collision with root package name */
    private int f34686i;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, Span> f34687j;

    /* renamed from: k, reason: collision with root package name */
    private int f34688k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f34689l;

    public QTextView(Context context) {
        this(context, null);
    }

    private void a(LinkedList<SpannableString> linkedList, Span span, IQuickText iQuickText) {
        SpannableString makeSpan = SpannableUtils.makeSpan(span, iQuickText);
        if (makeSpan != null && makeSpan.length() > 0) {
            linkedList.add(makeSpan);
        }
        LinkedHashMap<String, Span> children = span.getChildren();
        if (children.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, Span>> iterator2 = children.entrySet().iterator2();
        while (iterator2.hasNext()) {
            a(linkedList, iterator2.next().getValue(), span);
        }
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void addChild(String str, IVirtualView iVirtualView) {
        if (iVirtualView instanceof Span) {
            Span span = (Span) iVirtualView;
            span.setSubRef(str);
            a(span);
            this.f34687j.put(str, span);
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        b.a(this, obj);
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public CardContext getCardContext() {
        return (CardContext) getTag(R.id.quick_card_context);
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public Object getFontFamily() {
        return this.f34684g;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public Float getFontSize() {
        return this.f34681d;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public String getFontStyle() {
        return this.f34682e;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public String getFontWeight() {
        return this.f34683f;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public boolean getForceRefresh() {
        return this.f34689l;
    }

    @Override // com.huawei.quickcard.framework.IVirtualView
    @Nullable
    public String getName() {
        return "text";
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public Integer getTextColor() {
        return this.f34680c;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public String getTextDecoration() {
        return this.f34685h;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public int getTextLineHeight() {
        return this.f34688k;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public int getTextUnit() {
        return this.f34686i;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return c.a(this, view);
    }

    @Override // com.huawei.quickcard.framework.IVirtualView
    public /* synthetic */ QuickCardValue makeAttr(String str, Object obj) {
        return d.a(this, str, obj);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExposureManager exposureManager = this.f34678a;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
        ExtendExposureManager extendExposureManager = this.f34679b;
        if (extendExposureManager != null) {
            extendExposureManager.onAttachedToWindow(this);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExposureManager exposureManager = this.f34678a;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
        ExtendExposureManager extendExposureManager = this.f34679b;
        if (extendExposureManager != null) {
            extendExposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34678a;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return GestureDelegate.onTouchEvent(this, motionEvent) | super.onTouchEvent(motionEvent);
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        c.b(this, cardContext);
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34678a;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
        ExtendExposureManager extendExposureManager = this.f34679b;
        if (extendExposureManager != null) {
            extendExposureManager.onVisibilityChanged(this, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void renderChildren() {
        if (this.f34687j.size() <= 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        LinkedList<SpannableString> linkedList = new LinkedList<>();
        Iterator<Map.Entry<String, Span>> iterator2 = this.f34687j.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Span value = iterator2.next().getValue();
            if (value != null) {
                a(linkedList, value, this);
            }
        }
        Iterator<E> it = linkedList.iterator2();
        while (it.hasNext()) {
            spannableStringBuilder.append((CharSequence) it.next());
        }
        ViewUtils.dirty(this);
        setText(spannableStringBuilder);
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void setChildProperties(String str, String str2, String str3, QuickCardValue quickCardValue) {
        if (this.f34687j.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Span> entry : this.f34687j.entrySet()) {
            Span value = entry.getValue();
            if (entry.getKey().equals(str)) {
                SpannableUtils.applySpanAttr(value, str3, quickCardValue);
            } else {
                value.setChildProperties(str, str2, str3, quickCardValue);
            }
            entry.setValue(value);
        }
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34678a = exposureManager;
    }

    @Override // com.huawei.quickcard.exposure.extend.IExtendExposureSupport
    public void setExtendExposureManager(ExtendExposureManager extendExposureManager) {
        this.f34679b = extendExposureManager;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontFamily(Object obj) {
        this.f34684g = obj;
        a("fontFamily");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontSize(int i10, Float f10) {
        this.f34681d = f10;
        this.f34686i = i10;
        setTextSize(i10, f10.floatValue());
        a("fontSize");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontStyle(String str) {
        this.f34682e = str;
        a("fontStyle");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontWeight(String str) {
        this.f34683f = str;
        a("fontWeight");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setForceRefresh(boolean z10) {
        this.f34689l = z10;
    }

    @Override // android.widget.TextView, com.huawei.quickcard.views.text.view.IQuickText
    public void setTextColor(int i10) {
        this.f34680c = Integer.valueOf(i10);
        super.setTextColor(i10);
        a(IQuickText.Attrs.TEXT_COLOR);
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setTextDecoration(String str) {
        this.f34685h = str;
        a("textDecoration");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setTextLineHeight(int i10) {
        this.f34688k = i10;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        c.c(this, viewParent);
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void updateChildren(String str, String str2, String str3, Object obj) {
        if (this.f34687j.size() <= 0) {
            return;
        }
        QuickCardValue wrapQuickcardValue = SpannableUtils.wrapQuickcardValue(str3, obj);
        for (Map.Entry<String, Span> entry : this.f34687j.entrySet()) {
            Span value = entry.getValue();
            if (value != null) {
                if (entry.getKey().equals(str)) {
                    SpannableUtils.applySpanAttr(value, str3, wrapQuickcardValue);
                } else {
                    value.updateChildren(str, str2, str3, obj);
                }
                entry.setValue(value);
            }
        }
        renderChildren();
    }

    public QTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public QTextView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public QTextView(Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f34687j = new LinkedHashMap<>();
        this.f34688k = -1;
        this.f34689l = true;
    }

    private void a(Span span) {
        span.setCardContext(getCardContext());
        span.setContext(getContext());
        span.setParentFontStyle(this.f34682e);
        span.setParentFontWeight(this.f34683f);
        span.setParentFontFamily(this.f34684g);
        span.setParentTextDecoration(this.f34685h);
        span.setParentTextColor(this.f34680c);
        span.setParentFontSize(this.f34686i, this.f34681d);
    }

    private void a(String str) {
        SpannableUtils.updateChildrenAttrsOrStyles(str, this.f34687j, this);
        renderChildren();
    }
}

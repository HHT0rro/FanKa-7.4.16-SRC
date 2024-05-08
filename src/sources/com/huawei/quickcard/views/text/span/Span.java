package com.huawei.quickcard.views.text.span;

import android.content.Context;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.IVirtualView;
import com.huawei.quickcard.framework.IVirtualViewParent;
import com.huawei.quickcard.framework.d;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.text.utils.SpannableUtils;
import com.huawei.quickcard.views.text.view.IQuickText;
import com.huawei.quickcard.views.text.view.a;
import java.util.LinkedHashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Span implements IVirtualViewParent, IQuickText {

    /* renamed from: a, reason: collision with root package name */
    private Integer f34655a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f34656b;

    /* renamed from: c, reason: collision with root package name */
    private Float f34657c;

    /* renamed from: d, reason: collision with root package name */
    private Float f34658d;

    /* renamed from: e, reason: collision with root package name */
    private String f34659e;

    /* renamed from: f, reason: collision with root package name */
    private Object f34660f;

    /* renamed from: g, reason: collision with root package name */
    private Object f34661g;

    /* renamed from: i, reason: collision with root package name */
    private String f34663i;

    /* renamed from: j, reason: collision with root package name */
    private String f34664j;

    /* renamed from: k, reason: collision with root package name */
    private String f34665k;

    /* renamed from: l, reason: collision with root package name */
    private String f34666l;

    /* renamed from: m, reason: collision with root package name */
    private String f34667m;

    /* renamed from: n, reason: collision with root package name */
    private String f34668n;

    /* renamed from: o, reason: collision with root package name */
    private String f34669o;

    /* renamed from: r, reason: collision with root package name */
    private CardContext f34672r;

    /* renamed from: s, reason: collision with root package name */
    private Context f34673s;

    /* renamed from: h, reason: collision with root package name */
    private String f34662h = "";

    /* renamed from: p, reason: collision with root package name */
    private int f34670p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f34671q = -1;

    /* renamed from: t, reason: collision with root package name */
    private final LinkedHashMap<String, Span> f34674t = new LinkedHashMap<>();

    private void a(Span span) {
        span.setCardContext(getCardContext());
        span.setContext(getContext());
        span.setParentTextDecoration(getTextDecoration());
        span.setParentFontFamily(getFontFamily());
        span.setParentFontWeight(getFontWeight());
        span.setParentFontStyle(getFontStyle());
        span.setParentTextColor(getTextColor());
        span.setParentFontSize(getTextUnit(), getFontSize());
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void addChild(String str, IVirtualView iVirtualView) {
        if (iVirtualView instanceof Span) {
            Span span = (Span) iVirtualView;
            span.setSubRef(str);
            a(span);
            this.f34674t.put(str, span);
        }
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public CardContext getCardContext() {
        return this.f34672r;
    }

    public LinkedHashMap<String, Span> getChildren() {
        return this.f34674t;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public Context getContext() {
        return this.f34673s;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public Object getFontFamily() {
        Object obj = this.f34660f;
        return obj == null ? this.f34661g : obj;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public Float getFontSize() {
        Float f10 = this.f34657c;
        return f10 == null ? this.f34658d : f10;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public String getFontStyle() {
        String str = this.f34668n;
        return str == null ? this.f34669o : str;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public String getFontWeight() {
        String str = this.f34663i;
        return str == null ? this.f34664j : str;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public /* synthetic */ boolean getForceRefresh() {
        return a.a(this);
    }

    public String getHref() {
        return this.f34667m;
    }

    @Override // com.huawei.quickcard.framework.IVirtualView
    public String getName() {
        return "span";
    }

    public String getSubRef() {
        return this.f34659e;
    }

    public Integer getTextColor() {
        Integer num = this.f34655a;
        return num == null ? this.f34656b : num;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public String getTextDecoration() {
        String str = this.f34665k;
        return str == null ? this.f34666l : str;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public /* synthetic */ int getTextLineHeight() {
        return a.b(this);
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public int getTextUnit() {
        int i10 = this.f34670p;
        return i10 == -1 ? this.f34671q : i10;
    }

    public String getValue() {
        return this.f34662h;
    }

    @Override // com.huawei.quickcard.framework.IVirtualView
    public /* synthetic */ QuickCardValue makeAttr(String str, Object obj) {
        return d.a(this, str, obj);
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void renderChildren() {
    }

    public void setCardContext(CardContext cardContext) {
        this.f34672r = cardContext;
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void setChildProperties(String str, String str2, String str3, QuickCardValue quickCardValue) {
        if (this.f34674t.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Span> entry : this.f34674t.entrySet()) {
            Span value = entry.getValue();
            if (entry.getKey().equals(str)) {
                SpannableUtils.applySpanAttr(value, str3, quickCardValue);
            } else {
                value.setChildProperties(str, str2, str3, quickCardValue);
            }
            entry.setValue(value);
        }
    }

    public void setContext(Context context) {
        this.f34673s = context;
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontFamily(Object obj) {
        this.f34660f = obj;
        a("fontFamily");
    }

    public void setFontSize(Float f10) {
        this.f34657c = f10;
        a("fontSize");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontStyle(String str) {
        this.f34668n = str;
        a("fontStyle");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontWeight(String str) {
        this.f34663i = str;
        a("fontWeight");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public /* synthetic */ void setForceRefresh(boolean z10) {
        a.c(this, z10);
    }

    public void setHref(String str) {
        this.f34667m = str;
    }

    public void setParentFontFamily(Object obj) {
        this.f34661g = obj;
    }

    public void setParentFontSize(int i10, Float f10) {
        this.f34671q = i10;
        this.f34658d = f10;
    }

    public void setParentFontStyle(String str) {
        this.f34669o = str;
    }

    public void setParentFontWeight(String str) {
        this.f34664j = str;
    }

    public void setParentTextColor(Integer num) {
        this.f34656b = num;
    }

    public void setParentTextDecoration(String str) {
        this.f34666l = str;
    }

    public void setSubRef(String str) {
        this.f34659e = str;
    }

    public void setTextColor(int i10) {
        this.f34655a = Integer.valueOf(i10);
        a(IQuickText.Attrs.TEXT_COLOR);
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setTextDecoration(String str) {
        this.f34665k = str;
        a("textDecoration");
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public /* synthetic */ void setTextLineHeight(int i10) {
        a.d(this, i10);
    }

    public void setValue(String str) {
        this.f34662h = str;
    }

    @Override // com.huawei.quickcard.framework.IVirtualViewParent
    public void updateChildren(String str, String str2, String str3, Object obj) {
        if (this.f34674t.size() <= 0) {
            return;
        }
        QuickCardValue wrapQuickcardValue = SpannableUtils.wrapQuickcardValue(str3, obj);
        for (Map.Entry<String, Span> entry : this.f34674t.entrySet()) {
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
    }

    @Override // com.huawei.quickcard.views.text.view.IQuickText
    public void setFontSize(int i10, Float f10) {
        this.f34670p = i10;
        this.f34657c = f10;
        a("fontSize");
    }

    private void a(String str) {
        SpannableUtils.updateChildrenAttrsOrStyles(str, this.f34674t, this);
    }
}

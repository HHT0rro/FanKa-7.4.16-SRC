package com.huawei.quickcard.framework.bean;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.watcher.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardElement {

    /* renamed from: a, reason: collision with root package name */
    private String f33792a;

    /* renamed from: b, reason: collision with root package name */
    private String f33793b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, QuickCardValue> f33794c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Map<String, QuickCardValue>> f33795d;

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f33796e;

    /* renamed from: f, reason: collision with root package name */
    private List<CardElement> f33797f;

    /* renamed from: g, reason: collision with root package name */
    private String f33798g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33799h = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Field {
        public static final String ATTRIBUTES = "attr";
        public static final String CHILDREN = "children";
        public static final String EVENTS = "event";
        public static final String REF = "ref";
        public static final String STYLES = "style";
        public static final String TYPE = "type";
    }

    public void addChild(CardElement cardElement) {
        if (this.f33797f == null) {
            this.f33797f = new ArrayList();
        }
        this.f33797f.add(cardElement);
    }

    public String getAttrString(String str) {
        Map<String, QuickCardValue> map = this.f33794c;
        if (map == null) {
            return null;
        }
        QuickCardValue quickCardValue = map.get(str);
        if (quickCardValue instanceof QuickCardValue.ExpressionValue) {
            Expression expression = quickCardValue.getExpression();
            if (expression != null) {
                return expression.getSrc();
            }
            return null;
        }
        if (quickCardValue instanceof QuickCardValue.StringValue) {
            return quickCardValue.getString();
        }
        if (quickCardValue instanceof QuickCardValue.BooleanValue) {
            return String.valueOf(quickCardValue.getBoolean());
        }
        return null;
    }

    public Map<String, QuickCardValue> getAttributes() {
        return this.f33794c;
    }

    public List<CardElement> getChildren() {
        return this.f33797f;
    }

    public String getComponentType() {
        return this.f33798g;
    }

    public Set<String> getEvents() {
        return this.f33796e;
    }

    public boolean getHasAnimation() {
        return this.f33799h;
    }

    public String getRef() {
        return this.f33792a;
    }

    public Map<String, Map<String, QuickCardValue>> getStyles() {
        return this.f33795d;
    }

    public String getType() {
        return this.f33793b;
    }

    public void setAttributes(Map<String, QuickCardValue> map) {
        this.f33794c = map;
    }

    public void setChildren(List<CardElement> list) {
        this.f33797f = list;
    }

    public void setComponentType(String str) {
        this.f33798g = str;
    }

    public void setEvents(Set<String> set) {
        this.f33796e = set;
    }

    public void setHasAnimation(boolean z10) {
        this.f33799h = z10;
    }

    public void setRef(String str) {
        this.f33792a = str;
    }

    public void setStyles(Map<String, Map<String, QuickCardValue>> map) {
        this.f33795d = map;
    }

    public void setType(String str) {
        this.f33793b = str;
    }
}

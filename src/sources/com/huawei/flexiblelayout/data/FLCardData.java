package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLCardData {

    /* renamed from: a, reason: collision with root package name */
    private String f28024a;

    /* renamed from: b, reason: collision with root package name */
    private String f28025b;

    /* renamed from: c, reason: collision with root package name */
    private FLMap f28026c;

    /* renamed from: d, reason: collision with root package name */
    private CSSRule f28027d;

    /* renamed from: e, reason: collision with root package name */
    private a f28028e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28029f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28030g = false;

    /* renamed from: h, reason: collision with root package name */
    private FLCardData f28031h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f28032i;

    public FLCardData(String str) {
        this.f28025b = str;
    }

    public void a(String str) {
        this.f28024a = str;
    }

    public void b(String str) {
    }

    public boolean b() {
        return this.f28030g;
    }

    public CSSRule getCssRule() {
        return this.f28027d;
    }

    public FLMap getData() {
        return this.f28026c;
    }

    public String getId() {
        return this.f28024a;
    }

    public FLCardData getParent() {
        return this.f28031h;
    }

    public String getReuseIdentifier() {
        return getType();
    }

    public Object getTag(String str) {
        Map<String, Object> map = this.f28032i;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public String getType() {
        return this.f28025b;
    }

    public boolean isVisible() {
        return this.f28029f;
    }

    public void setTag(String str, Object obj) {
        if (this.f28032i == null) {
            this.f28032i = new HashMap();
        }
        this.f28032i.put(str, obj);
    }

    public void setVisible(boolean z10) {
        if (this.f28029f != z10) {
            this.f28029f = z10;
            this.f28030g = true;
            update();
        }
    }

    public void update() {
        a aVar = this.f28028e;
        if (aVar != null) {
            aVar.update(this);
            return;
        }
        FLCardData parent = getParent();
        if (parent != null) {
            parent.update();
        }
    }

    public void a(FLMap fLMap) {
        this.f28026c = fLMap;
    }

    public void a(FLCardData fLCardData) {
        this.f28031h = fLCardData;
    }

    public void a() {
        this.f28030g = false;
    }

    public void a(a aVar) {
        this.f28028e = aVar;
    }

    public void a(CSSRule cSSRule) {
        this.f28027d = cSSRule;
    }
}

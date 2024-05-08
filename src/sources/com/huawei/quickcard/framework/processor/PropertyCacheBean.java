package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.f;
import com.huawei.quickcard.f1;
import com.huawei.quickcard.framework.animation.QAnimatorSet;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.u;
import com.huawei.quickcard.utils.FullScreenImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PropertyCacheBean {

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Object> f33920f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, View> f33921g;

    /* renamed from: h, reason: collision with root package name */
    private String f33922h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f33923i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33924j;

    /* renamed from: k, reason: collision with root package name */
    private float[] f33925k;

    /* renamed from: l, reason: collision with root package name */
    private u f33926l;

    /* renamed from: m, reason: collision with root package name */
    private ConditionalData f33927m;

    /* renamed from: n, reason: collision with root package name */
    private Border f33928n;

    /* renamed from: o, reason: collision with root package name */
    private Set<String> f33929o;

    /* renamed from: p, reason: collision with root package name */
    private Set<String> f33930p;

    /* renamed from: r, reason: collision with root package name */
    private String f33932r;

    /* renamed from: s, reason: collision with root package name */
    private FullScreenImpl f33933s;

    /* renamed from: t, reason: collision with root package name */
    private f f33934t;

    /* renamed from: u, reason: collision with root package name */
    private f1 f33935u;

    /* renamed from: v, reason: collision with root package name */
    private QAnimatorSet f33936v;

    /* renamed from: a, reason: collision with root package name */
    private float f33915a = -1.0f;

    /* renamed from: b, reason: collision with root package name */
    private float f33916b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33917c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33918d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33919e = false;

    /* renamed from: q, reason: collision with root package name */
    private Map<String, QuickCardValue> f33931q = new HashMap();

    /* renamed from: w, reason: collision with root package name */
    private final List<WeakReference<View>> f33937w = new ArrayList();

    /* renamed from: x, reason: collision with root package name */
    private Map<String, View.OnFocusChangeListener> f33938x = new HashMap();

    /* renamed from: y, reason: collision with root package name */
    private Map<String, String> f33939y = new HashMap();

    /* renamed from: z, reason: collision with root package name */
    private long f33940z = 0;
    private long A = 0;
    private final List<WeakReference<View>> B = new ArrayList();

    public Map<String, QuickCardValue> getAttrAndStyle() {
        return this.f33931q;
    }

    public Set<String> getAttrNames() {
        return this.f33929o;
    }

    public QuickCardValue getAttrOrStyle(String str) {
        return this.f33931q.get(str);
    }

    public f getBackgroundImageStyle() {
        if (this.f33934t == null) {
            this.f33934t = new f();
        }
        return this.f33934t;
    }

    public Border getBorder() {
        return this.f33928n;
    }

    public float[] getBorderRadius() {
        return this.f33925k;
    }

    public String getComponentName() {
        return this.f33932r;
    }

    @Nullable
    public u getConditionChildren() {
        return this.f33926l;
    }

    @Nullable
    public ConditionalData getConditionalData() {
        return this.f33927m;
    }

    public CharSequence getContentDescription() {
        return this.f33923i;
    }

    public Map<String, View.OnFocusChangeListener> getFocusChangeListeners() {
        return this.f33938x;
    }

    public List<WeakReference<View>> getFoolProofViews() {
        return this.B;
    }

    public long getFoolProofingTime() {
        return this.A;
    }

    public FullScreenImpl getFullScreenImpl() {
        if (this.f33933s == null) {
            this.f33933s = new FullScreenImpl();
        }
        return this.f33933s;
    }

    public String getId() {
        return this.f33922h;
    }

    public long getLastClickTime() {
        return this.f33940z;
    }

    public QAnimatorSet getQAnimatorSet(View view) {
        if (this.f33936v == null) {
            this.f33936v = new QAnimatorSet(view);
        }
        return this.f33936v;
    }

    public f1 getQTransform(View view) {
        if (this.f33935u == null) {
            this.f33935u = new f1(view);
        }
        return this.f33935u;
    }

    @NonNull
    public Map<String, Object> getRadioMap() {
        if (this.f33920f == null) {
            this.f33920f = new HashMap(10);
        }
        return this.f33920f;
    }

    public List<WeakReference<View>> getSavedAnimationList() {
        return this.f33937w;
    }

    public Set<String> getStyleNames() {
        return this.f33930p;
    }

    public Map<String, String> getSupportTouchEvent() {
        return this.f33939y;
    }

    @Nullable
    public View getViewById(String str) {
        Map<String, View> map = this.f33921g;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public float getViewHeightPercent() {
        return this.f33915a;
    }

    public float getViewWidthPercent() {
        return this.f33916b;
    }

    public boolean isAnimationView() {
        return this.f33919e;
    }

    public boolean isHeightDefined() {
        return this.f33917c;
    }

    public boolean isWidthDefined() {
        return this.f33918d;
    }

    @NonNull
    public u obtainConditionChildren() {
        if (this.f33926l == null) {
            this.f33926l = new u();
        }
        return this.f33926l;
    }

    public void putViewIntoIdMap(String str, View view) {
        if (this.f33921g == null) {
            this.f33921g = new HashMap();
        }
        this.f33921g.put(str, view);
    }

    public void removeViewFromIdMap(String str) {
        Map<String, View> map = this.f33921g;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    public void saveAttrOrStyle(String str, QuickCardValue quickCardValue) {
        this.f33931q.put(str, quickCardValue);
    }

    public void saveFoolProofView(View view) {
        this.B.add(new WeakReference<>(view));
    }

    public void setAttrNames(Set<String> set) {
        this.f33929o = set;
    }

    public void setBorder(Border border) {
        this.f33928n = border;
    }

    public void setBorderRadius(float[] fArr) {
        this.f33925k = fArr;
    }

    public void setComponentName(String str) {
        this.f33932r = str;
    }

    public void setConditionalData(ConditionalData conditionalData) {
        this.f33927m = conditionalData;
    }

    public void setContentDescription(CharSequence charSequence) {
        if (this.f33924j) {
            return;
        }
        this.f33923i = charSequence;
        this.f33924j = true;
    }

    public void setFoolProofingTime(long j10) {
        this.A = j10;
    }

    public void setHeightDefined(boolean z10) {
        this.f33917c = z10;
    }

    public void setId(String str) {
        this.f33922h = str;
    }

    public void setIsAnimationView(boolean z10) {
        this.f33919e = z10;
    }

    public void setLastClickTime(long j10) {
        this.f33940z = j10;
    }

    public void setStyleNames(Set<String> set) {
        this.f33930p = set;
    }

    public void setViewHeightPercent(float f10) {
        this.f33915a = f10;
    }

    public void setViewWidthPercent(float f10) {
        this.f33916b = f10;
    }

    public void setWidthDefined(boolean z10) {
        this.f33918d = z10;
    }
}

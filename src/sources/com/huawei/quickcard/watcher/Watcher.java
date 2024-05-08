package com.huawei.quickcard.watcher;

import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.condition.ConditionalData;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Watcher {

    /* renamed from: a, reason: collision with root package name */
    private final CardContext f34722a;

    /* renamed from: b, reason: collision with root package name */
    private final Expression f34723b;

    /* renamed from: c, reason: collision with root package name */
    private String f34724c;

    /* renamed from: d, reason: collision with root package name */
    private final IWatcherCallback f34725d;

    /* renamed from: e, reason: collision with root package name */
    private Object f34726e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34727f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f34728g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<ConditionalData> f34729h;

    public Watcher(CardContext cardContext, Expression expression, IWatcherCallback iWatcherCallback) {
        this.f34722a = cardContext;
        this.f34723b = expression;
        this.f34724c = expression.getSrc();
        this.f34725d = iWatcherCallback;
        this.f34727f = false;
    }

    public Object get() {
        return this.f34726e;
    }

    public ConditionalData getConditionalData() {
        WeakReference<ConditionalData> weakReference = this.f34729h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Expression getExpr() {
        return this.f34723b;
    }

    public Set<String> getFirstFieldsSet() {
        Expression expression = this.f34723b;
        return expression != null ? expression.getFirstFieldsSet() : Collections.emptySet();
    }

    public String getScript() {
        return this.f34724c;
    }

    public Set<String> getVariableSet() {
        Expression expression = this.f34723b;
        return expression != null ? expression.getVariablesSet() : Collections.emptySet();
    }

    public boolean hasUpdate() {
        return this.f34728g;
    }

    public boolean hasValue() {
        return this.f34727f;
    }

    public void reset() {
        this.f34727f = false;
    }

    public void setConditionalData(ConditionalData conditionalData) {
        this.f34729h = new WeakReference<>(conditionalData);
    }

    public void setNewValue(Object obj) {
        boolean equals = Objects.equals(obj, this.f34726e);
        this.f34726e = obj;
        this.f34727f = true;
        if (equals) {
            return;
        }
        this.f34728g = false;
    }

    public void setScript(@NonNull String str) {
        this.f34724c = str;
    }

    public void update() {
        IWatcherCallback iWatcherCallback = this.f34725d;
        if (iWatcherCallback != null) {
            if (this.f34727f) {
                this.f34728g = true;
                iWatcherCallback.onUpdate(this.f34726e);
                return;
            }
            Object executeWatcher = this.f34722a.executeWatcher(this);
            this.f34726e = executeWatcher;
            this.f34728g = true;
            this.f34727f = true;
            this.f34725d.onUpdate(executeWatcher);
        }
    }

    public Watcher(CardContext cardContext, String str, IWatcherCallback iWatcherCallback) {
        this.f34722a = cardContext;
        this.f34723b = Expression.create(str);
        this.f34725d = iWatcherCallback;
    }

    public void update(Object obj) {
        this.f34726e = obj;
        this.f34727f = true;
        update();
    }
}

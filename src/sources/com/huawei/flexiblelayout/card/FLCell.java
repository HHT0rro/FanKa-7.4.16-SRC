package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.data.FLDataGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLCell<T> {

    /* renamed from: a, reason: collision with root package name */
    private FLParent f27759a;

    /* renamed from: b, reason: collision with root package name */
    private View f27760b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f27761c;

    /* renamed from: d, reason: collision with root package name */
    private final List<OnReadyListener> f27762d = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface OnReadyListener {
        void onReady(FLCell fLCell);
    }

    public void addOnReadyListener(OnReadyListener onReadyListener) {
        if (isReady()) {
            onReadyListener.onReady(this);
        } else {
            this.f27762d.add(onReadyListener);
        }
    }

    public abstract void bind(FLContext fLContext, FLDataGroup fLDataGroup, T t2);

    public abstract View build(FLContext fLContext, T t2, ViewGroup viewGroup);

    public abstract T getData();

    public FLParent getParent() {
        return this.f27759a;
    }

    public View getRootView() {
        return this.f27760b;
    }

    public abstract String getType();

    public boolean isReady() {
        return this.f27761c;
    }

    public void setParent(FLParent fLParent) {
        this.f27759a = fLParent;
    }

    public void setReady(boolean z10) {
        this.f27761c = z10;
        if (z10) {
            Iterator<OnReadyListener> iterator2 = this.f27762d.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onReady(this);
            }
        }
        this.f27762d.clear();
    }

    public void setRootView(View view) {
        this.f27760b = view;
    }

    public abstract void setVisibility(int i10);

    public void unbind(FLContext fLContext) {
        setReady(false);
    }

    public boolean visit(@NonNull Visitor visitor) {
        return visitor.onVisitCard(this);
    }
}

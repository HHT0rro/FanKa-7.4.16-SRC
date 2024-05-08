package com.huawei.quickcard.framework.condition;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.QuickCardView;
import com.huawei.quickcard.j0;
import com.huawei.quickcard.p0;
import com.huawei.quickcard.utils.StrUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.watcher.Watcher;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ConditionalData {

    /* renamed from: a, reason: collision with root package name */
    private j0 f33839a;

    /* renamed from: b, reason: collision with root package name */
    private p0 f33840b;

    /* renamed from: c, reason: collision with root package name */
    private int f33841c;

    /* renamed from: d, reason: collision with root package name */
    private Object f33842d;

    /* renamed from: e, reason: collision with root package name */
    private String f33843e;

    /* renamed from: f, reason: collision with root package name */
    private List<Watcher> f33844f;

    /* renamed from: g, reason: collision with root package name */
    private int f33845g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<View> f33846h;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<ConditionalData> f33848j;

    /* renamed from: i, reason: collision with root package name */
    private List<WeakReference<View>> f33847i = new LinkedList();

    /* renamed from: k, reason: collision with root package name */
    private String f33849k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f33850l = "";

    public ConditionalData(j0 j0Var, p0 p0Var, String str) {
        this.f33839a = j0Var;
        this.f33840b = p0Var;
        this.f33843e = str;
    }

    public static ConditionalData findNearlyConditionData(View view) {
        if (view instanceof QuickCardView) {
            return null;
        }
        ConditionalData conditionalData = ValueUtils.getConditionalData(view);
        if (conditionalData != null) {
            return conditionalData;
        }
        Object viewParent = ViewUtils.getViewParent(view);
        if (viewParent instanceof View) {
            return findNearlyConditionData((View) viewParent);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.quickcard.framework.condition.ConditionalData findSuperConditionData(@androidx.annotation.NonNull com.huawei.quickcard.watcher.IWatcherManager r2, @androidx.annotation.NonNull android.view.View r3) {
        /*
            android.view.ViewParent r3 = com.huawei.quickcard.utils.ViewUtils.getViewParent(r3)
            r0 = 0
        L5:
            if (r0 != 0) goto L1b
            boolean r1 = r3 instanceof android.view.View
            if (r1 == 0) goto L1b
            boolean r1 = r3 instanceof com.huawei.quickcard.QuickCardView
            if (r1 != 0) goto L1b
            r0 = r3
            android.view.View r0 = (android.view.View) r0
            com.huawei.quickcard.framework.condition.ConditionalData r0 = com.huawei.quickcard.utils.ValueUtils.getConditionalData(r0)
            android.view.ViewParent r3 = r3.getParent()
            goto L5
        L1b:
            if (r0 == 0) goto L1e
            goto L22
        L1e:
            com.huawei.quickcard.framework.condition.ConditionalData r0 = r2.getRootConditionData()
        L22:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.framework.condition.ConditionalData.findSuperConditionData(com.huawei.quickcard.watcher.IWatcherManager, android.view.View):com.huawei.quickcard.framework.condition.ConditionalData");
    }

    public void addChildWithForCondition(View view) {
        ConditionalData conditionalData = ValueUtils.getConditionalData(view);
        if (conditionalData != null) {
            conditionalData.setSuperConditionalData(this);
            this.f33847i.add(new WeakReference<>(view));
        }
    }

    public View getConditionalView() {
        WeakReference<View> weakReference = this.f33846h;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public List<WeakReference<View>> getConditionalViews() {
        return this.f33847i;
    }

    public int getIndex() {
        return this.f33841c;
    }

    public Object getKey() {
        return this.f33842d;
    }

    public String getParentForChains() {
        return StrUtils.null2Empty(this.f33849k);
    }

    public String getRef() {
        return this.f33843e;
    }

    public String getSelfForChains() {
        return StrUtils.null2Empty(this.f33850l);
    }

    public ConditionalData getSuperConditionalData() {
        WeakReference<ConditionalData> weakReference = this.f33848j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getViewHashCode() {
        return this.f33845g;
    }

    public List<Watcher> getWatchers() {
        return this.f33844f;
    }

    public boolean isRoot() {
        return this.f33840b == null && this.f33839a == null;
    }

    public void removeChildWithForCondition(View view) {
        Iterator<WeakReference<View>> iterator2 = this.f33847i.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().get() == view) {
                iterator2.remove();
            }
        }
    }

    public void setConditionalView(View view) {
        this.f33846h = new WeakReference<>(view);
    }

    public void setForAliasData(int i10, boolean z10, Object obj) {
        this.f33841c = i10;
        this.f33842d = obj;
    }

    public void setForChains(@NonNull String str, @NonNull String str2) {
        this.f33849k = str;
        this.f33850l = str2;
    }

    public void setRef(String str) {
        this.f33843e = str;
    }

    public void setSuperConditionalData(ConditionalData conditionalData) {
        this.f33848j = new WeakReference<>(conditionalData);
    }

    public void setViewHashCode(int i10) {
        this.f33845g = i10;
    }

    public void setWatchers(List<Watcher> list) {
        this.f33844f = list;
        Iterator<Watcher> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setConditionalData(this);
        }
    }

    public void updateAllChildren(CardContext cardContext) {
        cardContext.batchUpdateExp(this.f33844f, true);
        for (int i10 = 0; i10 < this.f33847i.size(); i10++) {
            ConditionalData conditionalData = ValueUtils.getConditionalData(this.f33847i.get(i10).get());
            if (conditionalData != null) {
                conditionalData.updateAllChildren(cardContext);
            }
        }
    }

    public ConditionalData() {
    }
}

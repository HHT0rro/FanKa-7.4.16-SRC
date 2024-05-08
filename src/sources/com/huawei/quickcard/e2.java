package com.huawei.quickcard;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.MapSet;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.WeakMapSet;
import com.huawei.quickcard.watcher.Expression;
import com.huawei.quickcard.watcher.ForWatcher;
import com.huawei.quickcard.watcher.IVirtualViewWatchCallback;
import com.huawei.quickcard.watcher.IWatchAttrCallback;
import com.huawei.quickcard.watcher.IWatchConditionCallback;
import com.huawei.quickcard.watcher.IWatcherCallback;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e2 implements IWatcherManager {

    /* renamed from: l, reason: collision with root package name */
    private static final String f33602l = "WatcherManager";

    /* renamed from: g, reason: collision with root package name */
    private final CardContext f33609g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Collection<Watcher>> f33610h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final ConditionalData f33611i = new ConditionalData();

    /* renamed from: j, reason: collision with root package name */
    private final MapSet<String, Watcher> f33612j = new MapSet<>();

    /* renamed from: k, reason: collision with root package name */
    private Collection<String> f33613k = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, List<Watcher>> f33603a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<Watcher>> f33604b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<Watcher>> f33605c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final List<Watcher> f33606d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    private final Map<Integer, Map<String, y>> f33607e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final Map<Integer, Map<String, y>> f33608f = new HashMap();

    public e2(CardContext cardContext) {
        this.f33609g = cardContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IWatchAttrCallback iWatchAttrCallback, String str, Object obj) {
        if (iWatchAttrCallback != null) {
            iWatchAttrCallback.onUpdate(str, obj);
        }
    }

    public List<Watcher> a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> iterator2 = set.iterator2();
        while (iterator2.hasNext()) {
            List<Watcher> list = this.f33605c.get(iterator2.next());
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void associatePathAndWatcher(String str, Watcher watcher) {
        this.f33612j.putChild(str, watcher);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void collectNewWatchers(Collection collection) {
        this.f33610h.add(collection);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public ConditionalData getRootConditionData() {
        return this.f33611i;
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public List<Watcher> getWatchersByField(String str) {
        List<Watcher> list = this.f33605c.get(str);
        return list != null ? list : Collections.EMPTY_LIST;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void removeConditionalDPSWatcher(ConditionalData conditionalData) {
        View conditionalView = conditionalData.getConditionalView();
        if (conditionalView == null) {
            return;
        }
        if (conditionalView instanceof ViewGroup) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((ViewGroup) conditionalView);
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ViewGroup viewGroup = (ViewGroup) arrayList.get(i10);
                this.f33607e.remove(Integer.valueOf(viewGroup.hashCode()));
                this.f33608f.remove(Integer.valueOf(viewGroup.hashCode()));
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof ViewGroup) {
                        arrayList.add((ViewGroup) childAt);
                    } else {
                        this.f33607e.remove(Integer.valueOf(childAt.hashCode()));
                        this.f33608f.remove(Integer.valueOf(childAt.hashCode()));
                    }
                }
            }
            return;
        }
        this.f33607e.remove(Integer.valueOf(conditionalView.hashCode()));
        this.f33608f.remove(Integer.valueOf(conditionalView.hashCode()));
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void removeDPWatcher(int i10, String str) {
        Map<String, y> map = this.f33607e.get(Integer.valueOf(i10));
        if (map != null) {
            map.remove(str);
        }
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void removeSPWatcher(int i10, String str) {
        Map<String, y> map = this.f33608f.get(Integer.valueOf(i10));
        if (map != null) {
            map.remove(str);
        }
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void removeWatchersByConditionData(ConditionalData conditionalData) {
        View view;
        ConditionalData conditionalData2;
        if (conditionalData == null) {
            return;
        }
        List<Watcher> watchers = conditionalData.getWatchers();
        if (watchers != null) {
            this.f33606d.removeAll(watchers);
            a(watchers, this.f33603a);
            a(watchers, this.f33604b);
            a(watchers, this.f33605c);
        }
        this.f33607e.remove(Integer.valueOf(conditionalData.getViewHashCode()));
        this.f33608f.remove(Integer.valueOf(conditionalData.getViewHashCode()));
        List<WeakReference<View>> conditionalViews = conditionalData.getConditionalViews();
        if (conditionalViews == null) {
            return;
        }
        for (WeakReference<View> weakReference : conditionalViews) {
            if (weakReference != null && (view = weakReference.get()) != null && (conditionalData2 = ValueUtils.obtainPropertyCacheBeanFromView(view).getConditionalData()) != null) {
                removeWatchersByConditionData(conditionalData2);
            }
        }
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void resetByVar(Collection<String> collection) {
        Iterator<Watcher> iterator2 = a(collection).iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().reset();
        }
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void setCommonWatchers(List<Watcher> list) {
        this.f33611i.setWatchers(list);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void setMessageKeys(Collection<String> collection) {
        this.f33613k.clear();
        this.f33613k.addAll(collection);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void setValueByExpr(String str, Object obj) {
        List<Watcher> list = this.f33604b.get(str);
        if (list != null) {
            Iterator<Watcher> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().setNewValue(obj);
            }
        }
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void stopCollectNewWatchers(Collection collection) {
        this.f33610h.remove(collection);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public int updateAll() {
        Iterator<Watcher> iterator2 = this.f33606d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().reset();
        }
        a(this.f33611i);
        return this.f33606d.size();
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public int updateByFields(Set<String> set) {
        List<Watcher> a10 = a(set);
        updateWatchers(a10);
        return a10.size();
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateByScripts(Collection<String> collection) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            List<Watcher> list = this.f33604b.get(iterator2.next());
            if (list != null) {
                linkedList.addAll(list);
            }
        }
        updateWatchers(linkedList);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateByVar(String str) {
        updateWatchers(a(str));
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateByVars(Collection<String> collection) {
        updateWatchers(a(collection));
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateDPWatchers() {
        a(this.f33607e);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateExprWatchersMap(String str, Watcher watcher) {
        List<Watcher> list = this.f33604b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f33604b.put(str, list);
        }
        list.add(watcher);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public int updateOnBind() {
        updateWatchers(this.f33606d);
        return this.f33606d.size();
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateSPWatchers() {
        a(this.f33608f);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void updateWatchers(Collection<Watcher> collection) {
        HashSet hashSet = new HashSet();
        WeakMapSet weakMapSet = new WeakMapSet();
        for (Watcher watcher : collection) {
            watcher.reset();
            ConditionalData conditionalData = watcher.getConditionalData();
            if (conditionalData != null && !conditionalData.isRoot()) {
                if (weakMapSet.putChild(conditionalData, watcher)) {
                    while (true) {
                        ConditionalData superConditionalData = conditionalData.getSuperConditionalData();
                        if (superConditionalData == null || superConditionalData.isRoot()) {
                            break;
                        } else if (!weakMapSet.putChild(superConditionalData, conditionalData)) {
                            break;
                        } else {
                            conditionalData = superConditionalData;
                        }
                    }
                    hashSet.add(conditionalData);
                }
            } else {
                hashSet.add(watcher);
            }
        }
        this.f33609g.batchUpdateExp(collection, false);
        a(weakMapSet, hashSet);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public Watcher watchAttr(final String str, Expression expression, final IWatchAttrCallback iWatchAttrCallback) {
        Watcher watcher = new Watcher(this.f33609g, expression, new IWatcherCallback() { // from class: com.huawei.quickcard.k2
            @Override // com.huawei.quickcard.watcher.IWatcherCallback
            public final void onUpdate(Object obj) {
                e2.b(IWatchAttrCallback.this, str, obj);
            }
        });
        a(watcher);
        return watcher;
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void watchDPAttr(int i10, String str, QuickCardValue quickCardValue, IWatchAttrCallback iWatchAttrCallback) {
        a(i10, str, quickCardValue, iWatchAttrCallback, this.f33607e);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public Watcher watchIfCondition(final String str, Expression expression, final IWatchConditionCallback iWatchConditionCallback) {
        Watcher watcher = new Watcher(this.f33609g, expression, new IWatcherCallback() { // from class: com.huawei.quickcard.l2
            @Override // com.huawei.quickcard.watcher.IWatcherCallback
            public final void onUpdate(Object obj) {
                e2.a(IWatchConditionCallback.this, str, obj);
            }
        });
        a(watcher);
        return watcher;
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public void watchSPAttr(int i10, String str, QuickCardValue quickCardValue, IWatchAttrCallback iWatchAttrCallback) {
        a(i10, str, quickCardValue, iWatchAttrCallback, this.f33608f);
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public Watcher watchVirtualViewAttr(final String str, final String str2, final String str3, Expression expression, final IVirtualViewWatchCallback iVirtualViewWatchCallback) {
        Watcher watcher = new Watcher(this.f33609g, expression, new IWatcherCallback() { // from class: com.huawei.quickcard.i2
            @Override // com.huawei.quickcard.watcher.IWatcherCallback
            public final void onUpdate(Object obj) {
                e2.a(IVirtualViewWatchCallback.this, str, str2, str3, obj);
            }
        });
        a(watcher);
        return watcher;
    }

    @Override // com.huawei.quickcard.watcher.IWatcherManager
    public ForWatcher watcherForCondition(final String str, Expression expression, final IWatchConditionCallback iWatchConditionCallback) {
        ForWatcher forWatcher = new ForWatcher(this.f33609g, expression, new IWatcherCallback() { // from class: com.huawei.quickcard.m2
            @Override // com.huawei.quickcard.watcher.IWatcherCallback
            public final void onUpdate(Object obj) {
                e2.b(IWatchConditionCallback.this, str, obj);
            }
        });
        a(forWatcher);
        return forWatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IWatchConditionCallback iWatchConditionCallback, String str, Object obj) {
        if (iWatchConditionCallback != null) {
            iWatchConditionCallback.onUpdate(str);
        }
    }

    private void a(int i10, final String str, QuickCardValue quickCardValue, final IWatchAttrCallback iWatchAttrCallback, Map<Integer, Map<String, y>> map) {
        if (quickCardValue == null) {
            return;
        }
        y yVar = new y(i10, str, quickCardValue, new IWatcherCallback() { // from class: com.huawei.quickcard.j2
            @Override // com.huawei.quickcard.watcher.IWatcherCallback
            public final void onUpdate(Object obj) {
                e2.a(IWatchAttrCallback.this, str, obj);
            }
        });
        Map<String, y> map2 = map.get(Integer.valueOf(i10));
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(Integer.valueOf(i10), map2);
        }
        map2.put(str, yVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IWatchAttrCallback iWatchAttrCallback, String str, Object obj) {
        if (iWatchAttrCallback != null) {
            iWatchAttrCallback.onUpdate(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IWatchConditionCallback iWatchConditionCallback, String str, Object obj) {
        if (iWatchConditionCallback != null) {
            iWatchConditionCallback.onUpdate(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IVirtualViewWatchCallback iVirtualViewWatchCallback, String str, String str2, String str3, Object obj) {
        if (iVirtualViewWatchCallback != null) {
            iVirtualViewWatchCallback.onUpdate(str, str2, str3, obj);
        }
    }

    public List<Watcher> a() {
        return this.f33606d;
    }

    private void a(WeakMapSet weakMapSet, ConditionalData conditionalData) {
        a(weakMapSet, weakMapSet.getChildren(conditionalData));
    }

    private void a(WeakMapSet weakMapSet, Set set) {
        for (Object obj : set) {
            if (obj instanceof Watcher) {
                Watcher watcher = (Watcher) obj;
                if (!watcher.hasValue() || !watcher.hasUpdate()) {
                    watcher.update();
                }
            } else if (obj instanceof ConditionalData) {
                a(weakMapSet, (ConditionalData) obj);
            } else {
                CardLogUtils.e(f33602l, "unexpect branch");
            }
        }
    }

    private void a(ConditionalData conditionalData) {
        this.f33609g.batchUpdateExp(conditionalData.getWatchers(), true);
        Iterator<WeakReference<View>> iterator2 = conditionalData.getConditionalViews().iterator2();
        while (iterator2.hasNext()) {
            View view = iterator2.next().get();
            if (view == null) {
                iterator2.remove();
            } else {
                ConditionalData conditionalData2 = ValueUtils.getConditionalData(view);
                if (conditionalData2 != null) {
                    a(conditionalData2);
                }
            }
        }
    }

    private void a(Watcher watcher) {
        a(watcher, watcher.getVariableSet(), this.f33603a);
        a(watcher, watcher.getFirstFieldsSet(), this.f33605c);
        this.f33606d.add(watcher);
        updateExprWatchersMap(watcher.getScript(), watcher);
        for (int i10 = 0; i10 < this.f33610h.size(); i10++) {
            this.f33610h.get(i10).add(watcher);
        }
    }

    private void a(Watcher watcher, Set<String> set, Map<String, List<Watcher>> map) {
        for (String str : set) {
            List<Watcher> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>();
                map.put(str, list);
            }
            list.add(watcher);
        }
    }

    @NonNull
    private List<Watcher> a(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        return a(linkedList);
    }

    @NonNull
    private List<Watcher> a(Collection<String> collection) {
        boolean z10 = !this.f33612j.isEmpty();
        LinkedList linkedList = new LinkedList();
        for (String str : collection) {
            Collection children = z10 ? this.f33612j.getChildren(str) : this.f33603a.get(str);
            if (children != null) {
                linkedList.addAll(children);
            }
        }
        return linkedList;
    }

    private void a(Map<Integer, Map<String, y>> map) {
        Iterator<Map.Entry<Integer, Map<String, y>>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map<String, y> value = iterator2.next().getValue();
            if (value != null) {
                Iterator<Map.Entry<String, y>> iterator22 = value.entrySet().iterator2();
                while (iterator22.hasNext()) {
                    y value2 = iterator22.next().getValue();
                    if (value2 != null) {
                        value2.c();
                    }
                }
            }
        }
    }

    private void a(List<Watcher> list, Map<String, List<Watcher>> map) {
        Collection<List<Watcher>> values;
        if (list == null || list.isEmpty() || (values = map.values()) == null || (r3 = values.iterator2()) == null) {
            return;
        }
        for (List<Watcher> list2 : values) {
            if (list2 != null) {
                list2.removeAll(list);
            }
        }
    }
}

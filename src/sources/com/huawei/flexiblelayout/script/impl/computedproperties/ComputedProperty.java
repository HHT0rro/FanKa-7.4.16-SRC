package com.huawei.flexiblelayout.script.impl.computedproperties;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.script.impl.computedproperties.DataAccessedWatchable;
import com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable;
import com.koushikdutta.quack.JavaScriptObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ComputedProperty implements DataChangedWatchable, DataChangedWatchable.DataChangedListener {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private String f28475a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final JSProperty f28476b;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Object f28480f;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final Map<Integer, Watchable> f28477c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final List<DataChangedWatchable.DataChangedListener> f28478d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private Set<String> f28479e = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private boolean f28481g = false;

    public ComputedProperty(@NonNull JavaScriptObject javaScriptObject) {
        this.f28476b = new JSProperty(javaScriptObject);
    }

    private void a(@Nullable Object obj, @Nullable Object obj2) {
        Iterator<DataChangedWatchable.DataChangedListener> iterator2 = this.f28478d.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onDataChanged(this, "", obj, obj2);
        }
    }

    private void b() {
        Object obj = this.f28480f;
        Object a10 = a();
        this.f28480f = a10;
        if (Objects.equals(obj, a10)) {
            return;
        }
        a(obj, this.f28480f);
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable
    public void addListener(@NonNull DataChangedWatchable.DataChangedListener dataChangedListener) {
        this.f28478d.add(dataChangedListener);
    }

    @Nullable
    public Object get() {
        if (this.f28481g) {
            return this.f28480f;
        }
        Object a10 = a();
        this.f28480f = a10;
        this.f28481g = true;
        return a10;
    }

    public String getName() {
        return this.f28475a;
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable.DataChangedListener
    public void onDataChanged(@NonNull Object obj, @NonNull String str, @Nullable Object obj2, @Nullable Object obj3) {
        if (obj instanceof Watchable) {
            if (this.f28479e.contains(System.identityHashCode(obj) + str)) {
                b();
            }
        }
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable
    public void removeListener(@NonNull DataChangedWatchable.DataChangedListener dataChangedListener) {
        this.f28478d.remove(dataChangedListener);
    }

    public boolean set(@Nullable Object obj) {
        if (!this.f28476b.set(obj)) {
            return false;
        }
        b();
        return true;
    }

    public void setName(String str) {
        this.f28475a = str;
    }

    public void unwatch(@NonNull Watchable watchable) {
        int identityHashCode = System.identityHashCode(watchable);
        if (this.f28477c.containsKey(Integer.valueOf(identityHashCode))) {
            this.f28477c.remove(Integer.valueOf(identityHashCode));
            watchable.removeListener(this);
        }
    }

    public void watch(@NonNull Watchable watchable) {
        this.f28477c.put(Integer.valueOf(System.identityHashCode(watchable)), watchable);
        watchable.addListener(this);
    }

    @NonNull
    private Set<String> a(@NonNull Runnable runnable) {
        final HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        for (final Map.Entry<Integer, Watchable> entry : this.f28477c.entrySet()) {
            DataAccessedWatchable.DataAccessedListener dataAccessedListener = new DataAccessedWatchable.DataAccessedListener() { // from class: com.huawei.flexiblelayout.script.impl.computedproperties.a
                @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataAccessedWatchable.DataAccessedListener
                public final void onDataAccessed(Object obj, String str, Object obj2) {
                    ComputedProperty.a(Set.this, entry, obj, str, obj2);
                }
            };
            entry.getValue().addListener(dataAccessedListener);
            hashMap.put(entry.getKey(), dataAccessedListener);
        }
        runnable.run();
        for (Map.Entry<Integer, Watchable> entry2 : this.f28477c.entrySet()) {
            DataAccessedWatchable.DataAccessedListener dataAccessedListener2 = (DataAccessedWatchable.DataAccessedListener) hashMap.get(entry2.getKey());
            if (dataAccessedListener2 != null) {
                entry2.getValue().removeListener(dataAccessedListener2);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Set set, Map.Entry entry, Object obj, String str, Object obj2) {
        set.add(entry.getKey() + str);
    }

    @Nullable
    private Object a() {
        final AtomicReference atomicReference = new AtomicReference(null);
        this.f28479e = a(new Runnable() { // from class: com.huawei.flexiblelayout.script.impl.computedproperties.b
            @Override // java.lang.Runnable
            public final void run() {
                ComputedProperty.this.a(atomicReference);
            }
        });
        return atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AtomicReference atomicReference) {
        atomicReference.set(this.f28476b.get());
    }
}

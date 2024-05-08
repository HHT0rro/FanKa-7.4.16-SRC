package com.huawei.qcardsupport.cards;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.script.impl.computedproperties.ComputedProperty;
import com.huawei.flexiblelayout.script.impl.computedproperties.DataAccessedWatchable;
import com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable;
import com.huawei.flexiblelayout.script.impl.computedproperties.Watchable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ObservableObject.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements FLMap, Watchable, DataChangedWatchable.DataChangedListener {

    /* renamed from: e, reason: collision with root package name */
    private static final String f33120e = "ObservableObject";

    /* renamed from: a, reason: collision with root package name */
    private final FLMap f33121a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DataChangedWatchable.DataChangedListener> f33122b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private final List<DataAccessedWatchable.DataAccessedListener> f33123c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, ComputedProperty> f33124d = new HashMap();

    public a(@Nullable Map<String, Object> map) {
        this.f33121a = a(map);
    }

    @NonNull
    public static FLMap a(@Nullable Map<String, Object> map) {
        if (map == null) {
            return Jsons.toJson(new JSONObject());
        }
        return Jsons.toJson(new JSONObject(map));
    }

    private boolean b(String str, @Nullable Object obj) {
        if (obj instanceof ComputedProperty) {
            a(str, (ComputedProperty) obj);
            return true;
        }
        ComputedProperty computedProperty = this.f33124d.get(str);
        if (computedProperty == null) {
            return false;
        }
        if (!computedProperty.set(obj)) {
            Log.w(f33120e, "write failed, computed property '" + str + "' is readonly");
        }
        return true;
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataAccessedWatchable
    public void addListener(@NonNull DataAccessedWatchable.DataAccessedListener dataAccessedListener) {
        this.f33123c.add(dataAccessedListener);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public Object get(String str) {
        return a(str, true);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public boolean isEmpty() {
        return this.f33121a.isEmpty();
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public String[] keys() {
        return this.f33121a.keys();
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable.DataChangedListener
    public void onDataChanged(@NonNull Object obj, @NonNull String str, @Nullable Object obj2, @Nullable Object obj3) {
        if (obj instanceof ComputedProperty) {
            String name = ((ComputedProperty) obj).getName();
            if (TextUtils.isEmpty(name)) {
                return;
            }
            a(name, obj3, true);
        }
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str) {
        boolean optBoolean = this.f33121a.optBoolean(str);
        a(str, Boolean.valueOf(optBoolean));
        return optBoolean;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str) {
        double optDouble = this.f33121a.optDouble(str);
        a(str, Double.valueOf(optDouble));
        return optDouble;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str) {
        int optInt = this.f33121a.optInt(str);
        a(str, Integer.valueOf(optInt));
        return optInt;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str) {
        long optLong = this.f33121a.optLong(str);
        a(str, Long.valueOf(optLong));
        return optLong;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str) {
        String optString = this.f33121a.optString(str);
        a(str, optString);
        return optString;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    @NonNull
    public FLMap put(@NonNull String str, Object obj) {
        return a(str, obj, false);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap
    public Object remove(@NonNull String str) {
        if (b(str, null)) {
            return this;
        }
        Object remove = this.f33121a.remove(str);
        a(str, remove, (Object) null);
        return remove;
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataAccessedWatchable
    public void removeListener(@NonNull DataAccessedWatchable.DataAccessedListener dataAccessedListener) {
        this.f33123c.remove(dataAccessedListener);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.MapModel
    public int size() {
        return this.f33121a.size();
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable
    public void addListener(@NonNull DataChangedWatchable.DataChangedListener dataChangedListener) {
        this.f33122b.add(dataChangedListener);
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLArray optArray(@NonNull String str) {
        FLArray optArray = this.f33121a.optArray(str);
        a(str, optArray);
        return optArray;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLMap, com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public FLMap optMap(@NonNull String str) {
        FLMap optMap = this.f33121a.optMap(str);
        a(str, optMap);
        return optMap;
    }

    @Override // com.huawei.flexiblelayout.script.impl.computedproperties.DataChangedWatchable
    public void removeListener(@NonNull DataChangedWatchable.DataChangedListener dataChangedListener) {
        this.f33122b.remove(dataChangedListener);
    }

    @NonNull
    private FLMap a(@NonNull String str, Object obj, boolean z10) {
        if (!z10 && b(str, obj)) {
            return this;
        }
        Object a10 = a(str, false);
        this.f33121a.put(str, obj);
        a(str, a10, obj);
        return this;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public boolean optBoolean(@NonNull String str, boolean z10) {
        boolean optBoolean = this.f33121a.optBoolean(str, z10);
        a(str, Boolean.valueOf(optBoolean));
        return optBoolean;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public double optDouble(@NonNull String str, double d10) {
        double optDouble = this.f33121a.optDouble(str, d10);
        a(str, Double.valueOf(optDouble));
        return optDouble;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public int optInt(@NonNull String str, int i10) {
        int optInt = this.f33121a.optInt(str, i10);
        a(str, Integer.valueOf(optInt));
        return optInt;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    public long optLong(@NonNull String str, long j10) {
        long optLong = this.f33121a.optLong(str, j10);
        a(str, Long.valueOf(optLong));
        return optLong;
    }

    @Override // com.huawei.flexiblelayout.data.primitive.FLImmutableMap
    @NonNull
    public String optString(@NonNull String str, String str2) {
        String optString = this.f33121a.optString(str, str2);
        a(str, optString);
        return optString;
    }

    private void a(String str, ComputedProperty computedProperty) {
        ComputedProperty remove = this.f33124d.remove(str);
        if (remove != null) {
            remove.removeListener(this);
            remove.unwatch(this);
        }
        computedProperty.watch(this);
        this.f33124d.put(str, computedProperty);
        computedProperty.setName(str);
        computedProperty.addListener(this);
        a(str, computedProperty.get(), true);
    }

    private Object a(String str, boolean z10) {
        Object obj = this.f33121a.get(str);
        if (z10) {
            a(str, obj);
        }
        return obj;
    }

    private void a(@NonNull String str, @Nullable Object obj, @Nullable Object obj2) {
        String str2 = "." + str;
        Iterator<DataChangedWatchable.DataChangedListener> iterator2 = this.f33122b.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onDataChanged(this, str2, obj, obj2);
        }
    }

    private void a(@NonNull String str, @Nullable Object obj) {
        String str2 = "." + str;
        Iterator<DataAccessedWatchable.DataAccessedListener> iterator2 = this.f33123c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onDataAccessed(this, str2, obj);
        }
    }
}

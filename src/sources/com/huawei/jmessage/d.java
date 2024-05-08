package com.huawei.jmessage;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.quickcard.base.Attributes;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: IntentFilterWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final IntentFilter f32019a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f32020b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32021c;

    /* renamed from: d, reason: collision with root package name */
    private final Set<Integer> f32022d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f32023e;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f32024f;

    /* compiled from: IntentFilterWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a<T> {
        void a(T t2) throws IntentFilter.MalformedMimeTypeException;
    }

    public d(@NonNull String str) {
        this.f32022d = new LinkedHashSet();
        this.f32023e = new Object();
        IntentFilter intentFilter = new IntentFilter(str);
        this.f32019a = intentFilter;
        this.f32020b = false;
        this.f32021c = c.a(intentFilter);
    }

    @NonNull
    public String a() {
        return this.f32021c;
    }

    @NonNull
    public IntentFilter b() {
        return this.f32019a;
    }

    public boolean c(int i10) {
        boolean contains;
        synchronized (this.f32023e) {
            contains = this.f32022d.contains(Integer.valueOf(i10));
        }
        return contains;
    }

    public boolean d() {
        return this.f32020b;
    }

    public boolean e() {
        boolean isEmpty;
        synchronized (this.f32023e) {
            isEmpty = this.f32022d.isEmpty();
        }
        return isEmpty;
    }

    public void a(@NonNull FLMap fLMap, @NonNull String str, @NonNull a<String> aVar) throws IntentFilter.MalformedMimeTypeException {
        FLArray optArray = fLMap.optArray(str);
        if (optArray != null) {
            int size = optArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                String optString = optArray.optString(i10);
                if (!TextUtils.isEmpty(optString)) {
                    aVar.a(optString);
                }
            }
        }
    }

    public boolean b(int i10) {
        boolean isEmpty;
        synchronized (this.f32023e) {
            this.f32022d.remove(Integer.valueOf(i10));
            isEmpty = this.f32022d.isEmpty();
        }
        return isEmpty;
    }

    public BroadcastReceiver c() {
        return this.f32024f;
    }

    public d(@NonNull IntentFilter intentFilter) {
        this.f32022d = new LinkedHashSet();
        this.f32023e = new Object();
        this.f32019a = intentFilter;
        this.f32020b = false;
        this.f32021c = c.a(intentFilter);
    }

    public void a(int i10) {
        synchronized (this.f32023e) {
            this.f32022d.add(Integer.valueOf(i10));
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        this.f32024f = broadcastReceiver;
    }

    public d(@NonNull FLMap fLMap) throws IntentFilter.MalformedMimeTypeException {
        this.f32022d = new LinkedHashSet();
        this.f32023e = new Object();
        final IntentFilter intentFilter = new IntentFilter();
        Object obj = fLMap.get("intentFilter");
        if (obj instanceof IntentFilter) {
            intentFilter = (IntentFilter) obj;
        } else {
            a(fLMap, Attributes.Style.ACTIONS, new a() { // from class: com.huawei.jmessage.h
                @Override // com.huawei.jmessage.d.a
                public final void a(Object obj2) {
                    intentFilter.addAction((String) obj2);
                }
            });
            a(fLMap, "categories", new a() { // from class: com.huawei.jmessage.i
                @Override // com.huawei.jmessage.d.a
                public final void a(Object obj2) {
                    intentFilter.addCategory((String) obj2);
                }
            });
            a(fLMap, "dataSchemes", new a() { // from class: com.huawei.jmessage.j
                @Override // com.huawei.jmessage.d.a
                public final void a(Object obj2) {
                    intentFilter.addDataScheme((String) obj2);
                }
            });
            a(fLMap, "dataTypes", new a() { // from class: com.huawei.jmessage.k
                @Override // com.huawei.jmessage.d.a
                public final void a(Object obj2) {
                    intentFilter.addDataType((String) obj2);
                }
            });
        }
        this.f32019a = intentFilter;
        boolean optBoolean = fLMap.optBoolean("system", false);
        this.f32020b = optBoolean;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(optBoolean ? "system" : "");
        sb2.append(c.a(intentFilter));
        this.f32021c = sb2.toString();
    }
}

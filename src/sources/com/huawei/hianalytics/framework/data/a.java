package com.huawei.hianalytics.framework.data;

import com.huawei.hianalytics.core.storage.IStorageHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public IStorageHandler f28780b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f28779a = false;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Long> f28781c = new ConcurrentHashMap();

    public void a(boolean z10) {
        this.f28779a = z10;
    }

    public boolean b() {
        return this.f28779a;
    }

    public long a(String str) {
        Long l10 = this.f28781c.get(str);
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public void a(String str, long j10) {
        this.f28781c.put(str, Long.valueOf(j10));
    }

    public IStorageHandler a() {
        return this.f28780b;
    }

    public void a(IStorageHandler iStorageHandler) {
        this.f28780b = iStorageHandler;
    }
}

package com.huawei.jmessage.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.creator.ObjectCreator;
import com.huawei.hmf.annotation.ApiDefine;
import com.huawei.hmf.annotation.Singleton;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.internal.ApplicationContext;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.EventSourceManager;
import com.huawei.jmessage.sources.BroadcastSource;
import com.huawei.jmessage.sources.LifecycleSource;
import com.huawei.jmessage.sources.MessageChannelSource;
import com.huawei.jmessage.sources.PackageInstallSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: EventSourceManagerImpl.java */
@ApiDefine(uri = EventSourceManager.class)
@Singleton
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements EventSourceManager {

    /* renamed from: c, reason: collision with root package name */
    private final Object f32035c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Class<? extends EventSource>> f32033a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, b> f32034b = new HashMap();

    public a() {
        register(PackageInstallSource.TOPIC, (String) new PackageInstallSource(ApplicationContext.getContext()));
        register(LifecycleSource.TOPIC, LifecycleSource.class);
        register(BroadcastSource.TOPIC, (String) new BroadcastSource(ApplicationContext.getContext()));
        register(MessageChannelSource.TOPIC, MessageChannelSource.class);
    }

    public static a a() {
        return (a) ComponentRepository.getRepository().lookup(jmessage.name).create(EventSourceManager.class);
    }

    @Override // com.huawei.jmessage.api.EventSourceManager
    public <T extends EventSource> T findEventSource(String str) {
        b a10 = a(str);
        if (a10 != null) {
            return (T) a10.a();
        }
        return null;
    }

    @Override // com.huawei.jmessage.api.EventSourceManager
    public void register(@NonNull String str, Class<? extends EventSource> cls) {
        if (cls != null) {
            synchronized (this.f32035c) {
                this.f32033a.put(str, cls);
            }
        }
    }

    @Override // com.huawei.jmessage.api.EventSourceManager
    public void unregister(@NonNull String str) {
        synchronized (this.f32035c) {
            this.f32033a.remove(str);
            b bVar = this.f32034b.get(str);
            if (bVar != null) {
                bVar.d();
                this.f32034b.remove(str);
            }
        }
    }

    public <T extends EventSource> b a(@NonNull String str, T t2) {
        if (t2 == null) {
            return null;
        }
        synchronized (this.f32035c) {
            if (this.f32034b.get(str) != null) {
                return null;
            }
            b bVar = new b(str, t2);
            this.f32034b.put(str, bVar);
            return bVar;
        }
    }

    @Override // com.huawei.jmessage.api.EventSourceManager
    public <T extends EventSource> void register(@NonNull String str, T t2) {
        a(str, t2);
    }

    public b a(String str) {
        b bVar;
        Class<? extends EventSource> cls;
        synchronized (this.f32035c) {
            bVar = this.f32034b.get(str);
            if (bVar == null && (cls = this.f32033a.get(str)) != null) {
                bVar = a(str, (EventSource) ObjectCreator.create(cls));
            }
        }
        return bVar;
    }

    public b a(int i10) {
        synchronized (this.f32035c) {
            Iterator<Map.Entry<String, b>> iterator2 = this.f32034b.entrySet().iterator2();
            while (iterator2.hasNext()) {
                b value = iterator2.next().getValue();
                if (value.a(i10)) {
                    return value;
                }
            }
            return null;
        }
    }
}

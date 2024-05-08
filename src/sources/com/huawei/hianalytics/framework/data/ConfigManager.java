package com.huawei.hianalytics.framework.data;

import com.huawei.hianalytics.core.storage.IStorageHandler;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.IMandatoryParameters;
import com.huawei.hianalytics.framework.policy.IStoragePolicy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ConfigManager {

    /* renamed from: e, reason: collision with root package name */
    public static ConfigManager f28774e = new ConfigManager();

    /* renamed from: a, reason: collision with root package name */
    public IMandatoryParameters f28775a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, ICollectorConfig> f28776b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public Map<String, a> f28777c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public Map<String, IStoragePolicy> f28778d = new ConcurrentHashMap();

    public static ConfigManager getInstance() {
        return f28774e;
    }

    public boolean checkServiceTag(String str) {
        return this.f28776b.containsKey(str);
    }

    public Map<String, ICollectorConfig> getAllConfigs() {
        return this.f28776b;
    }

    public ICollectorConfig getConfig(String str) {
        return this.f28776b.get(str);
    }

    public a getHAFrameworkConfigInfo(String str) {
        return this.f28777c.get(str);
    }

    public IMandatoryParameters getParameters() {
        return this.f28775a;
    }

    public IStoragePolicy getPolicy(String str) {
        return this.f28778d.get(str);
    }

    public synchronized void init(String str, ICollectorConfig iCollectorConfig, IMandatoryParameters iMandatoryParameters, IStorageHandler iStorageHandler, IStoragePolicy iStoragePolicy) {
        this.f28776b.put(str, iCollectorConfig);
        a aVar = new a();
        aVar.a(iStorageHandler);
        this.f28777c.put(str, aVar);
        this.f28778d.put(str, iStoragePolicy);
        if (this.f28775a == null && iMandatoryParameters != null) {
            this.f28775a = iMandatoryParameters;
        }
    }
}

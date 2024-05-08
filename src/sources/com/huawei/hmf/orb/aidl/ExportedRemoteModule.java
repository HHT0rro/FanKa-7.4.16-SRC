package com.huawei.hmf.orb.aidl;

import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExportedRemoteModule {
    private static ExportedRemoteModule exportedModule = new ExportedRemoteModule();
    private Set<String> mModules = new HashSet();

    private ExportedRemoteModule() {
    }

    public static ExportedRemoteModule getInstance() {
        return exportedModule;
    }

    public void add(String str) {
        this.mModules.add(str);
    }

    public void addAll(Set<String> set) {
        this.mModules.addAll(set);
    }

    public Set<String> get() {
        return this.mModules;
    }
}

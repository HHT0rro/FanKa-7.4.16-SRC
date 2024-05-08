package com.huawei.hianalytics.framework.policy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IStoragePolicy {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum PolicyType {
        NETWORK,
        STORAGECYCLY,
        STORAGELENGTH,
        STORAGESIZE,
        PARAMS
    }

    boolean decide(PolicyType policyType, String str);

    boolean decide(PolicyType policyType, String str, long j10);
}

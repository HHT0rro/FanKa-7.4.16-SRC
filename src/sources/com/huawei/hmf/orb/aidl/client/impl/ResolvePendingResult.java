package com.huawei.hmf.orb.aidl.client.impl;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.aidl.client.ApiClient;
import com.huawei.hmf.orb.aidl.client.Result;
import com.huawei.hmf.orb.aidl.client.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResolvePendingResult<T extends IMessageEntity> extends PendingResultImpl<ResolveResult<T>, T> {
    public ResolvePendingResult(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        super(apiClient, str, iMessageEntity, cls);
    }

    public static <R extends IMessageEntity> ResolvePendingResult<R> build(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<R> cls) {
        return new ResolvePendingResult<>(apiClient, str, iMessageEntity, cls);
    }

    public T get() {
        return (T) await().getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hmf.orb.aidl.client.impl.PendingResultImpl
    public /* bridge */ /* synthetic */ Result onComplete(IMessageEntity iMessageEntity) {
        return onComplete((ResolvePendingResult<T>) iMessageEntity);
    }

    @Override // com.huawei.hmf.orb.aidl.client.impl.PendingResultImpl
    public ResolveResult<T> onComplete(T t2) {
        ResolveResult<T> resolveResult = new ResolveResult<>(t2);
        resolveResult.setStatus(new Status(0));
        return resolveResult;
    }
}

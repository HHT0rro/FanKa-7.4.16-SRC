package com.huawei.hmf.orb.bridge;

import com.huawei.hmf.orb.IndexedObject;
import com.huawei.hmf.orb.RemoteInvoker;
import com.huawei.hmf.orb.RemoteTarget;
import com.huawei.hmf.orb.aidl.client.impl.ResolvePendingResult;
import com.huawei.hmf.orb.aidl.communicate.AIDLResponse;
import com.huawei.hmf.orb.aidl.request.InvokeService;
import com.huawei.hmf.services.codec.TypeToken;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Bridge {
    IndexedObject<? extends RemoteTarget> handle(Object obj, AIDLResponse aIDLResponse);

    Object send(RemoteInvoker remoteInvoker, ResolvePendingResult<InvokeService.Response> resolvePendingResult, TypeToken typeToken);
}

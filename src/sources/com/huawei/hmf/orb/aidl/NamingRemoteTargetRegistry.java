package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.orb.CommonCode;
import com.huawei.hmf.orb.exception.GeneralException;
import com.huawei.hmf.services.codec.Variant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class NamingRemoteTargetRegistry {
    private static Map<String, RemoteTargetFactory> mMap;

    static {
        HashMap hashMap = new HashMap();
        mMap = hashMap;
        hashMap.put(IRemoteActivity.Uri, RemoteActivity.FACTORY);
    }

    public static NamingRemoteTarget create(String str, String str2, List<Variant> list) throws GeneralException {
        RemoteTargetFactory remoteTargetFactory = mMap.get(str);
        if (remoteTargetFactory == null) {
            return null;
        }
        try {
            return remoteTargetFactory.create(str2, list);
        } catch (Exception e2) {
            throw new GeneralException(CommonCode.ErrorCode.INTERNAL_ERROR, e2);
        }
    }
}

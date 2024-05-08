package com.huawei.hmf.orb;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RemoteSessionManager {
    private static Map<String, RemoteSession> mRemoteSession = new HashMap();

    public static RemoteSession add(String str) {
        if (!mRemoteSession.containsKey(str)) {
            mRemoteSession.put(str, new RemoteSession());
        }
        return get(str);
    }

    public static RemoteSession get(String str) {
        return mRemoteSession.get(str);
    }

    public static void remove(String str) {
        RemoteSession remove = mRemoteSession.remove(str);
        if (remove != null) {
            remove.release();
        }
    }
}

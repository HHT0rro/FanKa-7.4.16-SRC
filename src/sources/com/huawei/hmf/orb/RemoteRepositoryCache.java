package com.huawei.hmf.orb;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteRepositoryCache {
    private static Map<String, RemoteRepository> repositoryMap = new HashMap();

    public static void addRemoteRepository(String str, RemoteRepository remoteRepository) {
        if (str != null) {
            repositoryMap.put(str, remoteRepository);
        }
    }

    public static RemoteRepository getRemoteRepository(String str) {
        return repositoryMap.get(str);
    }

    public static RemoteRepository removeRemoteRepository(String str) {
        return repositoryMap.remove(str);
    }
}

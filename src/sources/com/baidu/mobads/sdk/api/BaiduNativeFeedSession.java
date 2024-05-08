package com.baidu.mobads.sdk.api;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaiduNativeFeedSession {
    private static HashMap<String, String> sessionHashMap = new HashMap<>();
    private static BaiduNativeFeedSession theInstance;

    private BaiduNativeFeedSession() {
    }

    public static synchronized BaiduNativeFeedSession getInstance() {
        BaiduNativeFeedSession baiduNativeFeedSession;
        synchronized (BaiduNativeFeedSession.class) {
            if (theInstance == null) {
                theInstance = new BaiduNativeFeedSession();
            }
            baiduNativeFeedSession = theInstance;
        }
        return baiduNativeFeedSession;
    }

    public int getSequenceId(int i10) {
        int i11 = 1;
        if (i10 < 1) {
            return 1;
        }
        try {
            if (sessionHashMap.containsKey(i10 + "")) {
                int parseInt = Integer.parseInt(sessionHashMap.get(i10 + "")) + 1;
                if (parseInt >= 1) {
                    i11 = parseInt;
                }
                sessionHashMap.put(i10 + "", i11 + "");
            } else {
                sessionHashMap.put(i10 + "", "1");
            }
        } catch (Exception unused) {
        }
        return i11;
    }
}

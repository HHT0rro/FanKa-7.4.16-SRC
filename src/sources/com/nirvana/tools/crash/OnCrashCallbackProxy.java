package com.nirvana.tools.crash;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class OnCrashCallbackProxy {
    private HashMap<String, OnCrashCallback> crashCallbackHashMap;

    public void onCrashOccurred(String str, String str2, String str3, String str4, boolean z10, String str5) {
        OnCrashCallback onCrashCallback;
        HashMap<String, OnCrashCallback> hashMap = this.crashCallbackHashMap;
        if (hashMap == null || (onCrashCallback = hashMap.get(str2)) == null) {
            return;
        }
        onCrashCallback.onCrashOccurred(str, str2, str3, str4, z10, str5);
    }

    public void onCrashUploadFailed(String str, String str2, String str3) {
        OnCrashCallback onCrashCallback;
        HashMap<String, OnCrashCallback> hashMap = this.crashCallbackHashMap;
        if (hashMap == null || (onCrashCallback = hashMap.get(str)) == null) {
            return;
        }
        onCrashCallback.onCrashUploadFailed(str, str2, str3);
    }

    public void registerCrashCallback(String str, OnCrashCallback onCrashCallback) {
        if (this.crashCallbackHashMap == null) {
            this.crashCallbackHashMap = new HashMap<>();
        }
        this.crashCallbackHashMap.put(str, onCrashCallback);
    }

    public void unRegisterCrashCallback(String str) {
        HashMap<String, OnCrashCallback> hashMap = this.crashCallbackHashMap;
        if (hashMap != null && hashMap.containsKey(str)) {
            this.crashCallbackHashMap.remove(str);
        }
    }
}

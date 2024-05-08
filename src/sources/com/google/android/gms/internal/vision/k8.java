package com.google.android.gms.internal.vision;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k8 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f25526a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Integer> f25527b = new HashMap<>();

    public static boolean a(String str, String str2) {
        synchronized (f25526a) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(str2);
            String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            HashMap<String, Integer> hashMap = f25527b;
            int intValue = hashMap.containsKey(concat) ? hashMap.get(concat).intValue() : 0;
            if ((intValue & 1) != 0) {
                return true;
            }
            try {
                System.loadLibrary(str2);
                hashMap.put(concat, Integer.valueOf(intValue | 1));
                return true;
            } catch (UnsatisfiedLinkError e2) {
                if ((intValue & 4) == 0) {
                    q7.a.b(e2, "System.loadLibrary failed: %s", str2);
                    f25527b.put(concat, Integer.valueOf(intValue | 4));
                }
                return false;
            }
        }
    }
}

package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Process;
import com.hailiang.advlib.core.ADEvent;
import java.io.File;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class MtmV0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f45638a = kC0XR.a(kC0XR.A0);

    /* renamed from: b, reason: collision with root package name */
    public static final String f45639b = kC0XR.a(kC0XR.B0);

    /* renamed from: c, reason: collision with root package name */
    public static boolean f45640c = false;

    public static String a(Context context) {
        File dir = context.getDir(f45638a, 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dir.getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("1");
        File file = new File(sb2.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str + f45639b;
    }

    public static void a(Context context, fenkF fenkf) {
        try {
            if (f45640c) {
                return;
            }
            f45640c = true;
            long a10 = fenkf.a(context, "502");
            int myUid = Process.myUid();
            if (a10 == 0 || myUid == 0 || myUid == a10) {
                return;
            }
            fenkf.a(context, ADEvent.PRICE_LOW, "", true);
            fenkf.b(context, 0L);
            HashMap hashMap = new HashMap();
            hashMap.put("901", "");
            fenkF.a(context, hashMap);
            new File(a(context)).delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

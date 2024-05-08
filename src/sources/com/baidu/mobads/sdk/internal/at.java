package com.baidu.mobads.sdk.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.aw;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class at extends aw.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9828a = "debug";

    @Override // com.baidu.mobads.sdk.internal.aw.a
    @NonNull
    public String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.aw.a
    public boolean a(String str, int i10) {
        return aw.f9845a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.aw.a
    public void a(int i10, String str, String str2, Throwable th) {
        a(i10, str, str2);
    }

    private static void a(int i10, String str, String str2) {
        try {
            if (i10 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i10, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}

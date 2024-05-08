package com.tencent.open.a;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f45160a = new HashMap<>();

    public b(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f45160a.put(str, bundle.getString(str));
            }
        }
    }
}

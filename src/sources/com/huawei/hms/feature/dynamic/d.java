package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final String f29891b = "d";

    /* renamed from: c, reason: collision with root package name */
    public static final d f29892c = new d();

    /* renamed from: a, reason: collision with root package name */
    public Set<String> f29893a;

    public static d a() {
        return f29892c;
    }

    public void a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.w(f29891b, "Get installed module name failed.");
            this.f29893a = new HashSet();
            return;
        }
        Logger.i(f29891b, "Installed module name:" + ((Object) stringArrayList));
        this.f29893a = new HashSet(stringArrayList);
    }
}

package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.openalliance.ad.constant.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27214a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public c(Context context) {
        this.f27214a = context;
    }

    public final <T extends c9.b> T a(String str) {
        StringBuilder sb2;
        String localizedMessage;
        try {
            Class<?> cls = Class.forName(str);
            if (c9.b.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append((Object) cls);
            sb3.append(" must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Can not found service class, ");
            sb4.append(e2.getMessage());
            return null;
        } catch (IllegalAccessException e10) {
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            localizedMessage = e10.getLocalizedMessage();
            sb2.append(localizedMessage);
            return null;
        } catch (InstantiationException e11) {
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            localizedMessage = e11.getLocalizedMessage();
            sb2.append(localizedMessage);
            return null;
        }
    }

    public List<c9.a> b() {
        List<String> c4 = c();
        ArrayList arrayList = new ArrayList();
        Iterator<String> iterator2 = c4.iterator2();
        while (iterator2.hasNext()) {
            c9.b a10 = a(iterator2.next());
            if (a10 != null) {
                a10.initialize(this.f27214a);
                List<c9.a> a11 = a10.a(this.f27214a);
                if (a11 != null) {
                    arrayList.addAll(a11);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("services:");
        sb2.append(arrayList.size());
        return arrayList;
    }

    public final List<String> c() {
        StringBuilder sb2;
        ArrayList arrayList = new ArrayList();
        Bundle d10 = d();
        if (d10 == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : d10.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(d10.getString(str))) {
                String[] split = str.split(u.bD);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e2) {
                        sb2 = new StringBuilder();
                        sb2.append("registrar configuration format error:");
                        str = e2.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("registrar configuration error, ");
                    sb2.append(str);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        Iterator<E> iterator2 = arrayList2.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(((Map.Entry) iterator2.next()).getKey());
        }
        return arrayList;
    }

    public final Bundle d() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f27214a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f27214a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get ServiceDiscovery exception.");
            sb2.append(e2.getLocalizedMessage());
        }
        if (serviceInfo == null) {
            return null;
        }
        return serviceInfo.metaData;
    }
}

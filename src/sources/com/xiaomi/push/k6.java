package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k6 {
    public static HashMap<String, ArrayList<hu>> a(Context context, List<hu> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<hu>> hashMap = new HashMap<>();
        for (hu huVar : list) {
            d(context, huVar);
            ArrayList<hu> arrayList = hashMap.get(huVar.c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(huVar.c(), arrayList);
            }
            arrayList.add(huVar);
        }
        return hashMap;
    }

    public static void b(Context context, m6 m6Var, HashMap<String, ArrayList<hu>> hashMap) {
        for (Map.Entry<String, ArrayList<hu>> entry : hashMap.entrySet()) {
            try {
                ArrayList<hu> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    m6Var.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, m6 m6Var, List<hu> list) {
        HashMap<String, ArrayList<hu>> a10 = a(context, list);
        if (a10 != null && a10.size() != 0) {
            b(context, m6Var, a10);
            return;
        }
        fc.c.i("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    public static void d(Context context, hu huVar) {
        if (huVar.f304a) {
            huVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(huVar.d())) {
            huVar.f(kc.z.a());
        }
        huVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(huVar.e())) {
            huVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(huVar.c())) {
            huVar.e(huVar.e());
        }
    }
}

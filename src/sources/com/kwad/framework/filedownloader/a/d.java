package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String bd2 = bVar.bd("Location");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (bi(responseCode)) {
            if (bd2 != null) {
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", bd2, Integer.valueOf(responseCode), arrayList);
                }
                bVar.ve();
                bVar = a(map, bd2);
                arrayList.add(bd2);
                bVar.execute();
                responseCode = bVar.getResponseCode();
                bd2 = bVar.bd("Location");
                i10++;
                if (i10 >= 10) {
                    throw new IllegalAccessException(f.b("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(f.b("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.vd()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean bi(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 300 || i10 == 307 || i10 == 308;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bh = com.kwad.framework.filedownloader.download.b.vo().bh(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> iterator2 = value.iterator2();
                while (iterator2.hasNext()) {
                    bh.addHeader(key, iterator2.next());
                }
            }
        }
        return bh;
    }
}

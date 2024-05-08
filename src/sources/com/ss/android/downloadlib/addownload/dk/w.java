package com.ss.android.downloadlib.addownload.dk;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m {

        /* renamed from: m, reason: collision with root package name */
        private static w f38589m = new w();
    }

    private w() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences ej() {
        return c.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.m.dk> dk() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.m.dk> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = ej().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.m.dk dk = com.ss.android.downloadad.api.m.dk.dk(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && dk != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), dk);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    public static w m() {
        return m.f38589m;
    }

    public void m(com.ss.android.downloadad.api.m.dk dkVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dkVar);
        m((Collection<com.ss.android.downloadad.api.m.dk>) arrayList);
    }

    public synchronized void m(final Collection<com.ss.android.downloadad.api.m.dk> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.addownload.dk.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = w.this.ej().edit();
                        for (com.ss.android.downloadad.api.m.dk dkVar : collection) {
                            if (dkVar != null && dkVar.dk() != 0) {
                                edit.putString(String.valueOf(dkVar.dk()), dkVar.gx().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void m(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.addownload.dk.w.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = w.this.ej().edit();
                Iterator iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    edit.remove((String) iterator2.next());
                }
                edit.apply();
            }
        }, true);
    }
}

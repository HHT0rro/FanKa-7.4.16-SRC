package com.kwad.sdk.i;

import androidx.annotation.WorkerThread;
import com.kwad.sdk.i.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m {
    private static final Map<String, k> aJv = new ConcurrentHashMap();
    private static long aJw;

    public static void Jp() {
        long currentTimeMillis = System.currentTimeMillis() - aJw;
        if (aJv.size() <= 0 || currentTimeMillis <= h.Jc().Ji()) {
            return;
        }
        aJw = System.currentTimeMillis();
        final List<k> actionList = getActionList();
        actionList.size();
        j.Jn();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.i.l.a
            public final void onSuccess() {
                j.Jn();
                m.x(List.this);
            }
        });
    }

    @WorkerThread
    public static synchronized void a(i iVar, boolean z10) {
        synchronized (m.class) {
            Map<String, k> map = aJv;
            if (map.size() > 200) {
                j.logE("LogRequestManger", "enqueueAction fail size limit");
            } else {
                k b4 = b(iVar, z10);
                map.put(b4.actionId, b4);
            }
            Jp();
        }
    }

    private static k b(i iVar, boolean z10) {
        c.a Oo;
        if (z10) {
            Oo = c.a.On();
        } else {
            Oo = c.a.Oo();
        }
        com.kwai.adclient.kscommerciallogger.model.c Op = Oo.b(BusinessType.OTHER).b(SubBusinessType.OTHER).hm("ad_sdk_local_log").hl(iVar.aJo).A(iVar.toJson()).Op();
        return new k(Op.Oh(), Op.toString(), iVar);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        synchronized (m.class) {
            Map<String, k> map = aJv;
            arrayList = new ArrayList(map.size());
            Iterator<Map.Entry<String, k>> iterator2 = map.entrySet().iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getValue());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void x(List<k> list) {
        synchronized (m.class) {
            if (list != null) {
                Iterator<k> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    aJv.remove(iterator2.next().actionId);
                }
            }
        }
    }
}

package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> axH = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void j(@NonNull T t2) {
        this.axH.put(t2.actionId, t2);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<T> EI() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.axH.size());
        Iterator<Map.Entry<String, T>> iterator2 = this.axH.entrySet().iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.axH.size();
        com.kwad.sdk.core.e.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<T> list) {
        for (T t2 : list) {
            if (t2 != null) {
                this.axH.remove(t2.actionId);
            }
        }
    }
}

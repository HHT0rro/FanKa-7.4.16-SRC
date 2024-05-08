package com.huawei.flexiblelayout.log;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JsonLogFilter implements LogFilter {

    /* renamed from: a, reason: collision with root package name */
    private JsonFilter f28221a;

    public JsonLogFilter() {
    }

    @Override // com.huawei.flexiblelayout.log.LogFilter
    public String anonymize(@NonNull String str) {
        JsonFilter jsonFilter = this.f28221a;
        return jsonFilter == null ? str : jsonFilter.process(str);
    }

    public JsonLogFilter(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        this.f28221a = new JsonFilter();
        Iterator<String> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            this.f28221a.addMatchString(iterator2.next());
        }
    }
}

package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private final Executor ahb = com.kwad.framework.filedownloader.f.b.o(10, "EventPool");
    private final HashMap<String, LinkedList<c>> ahc = new HashMap<>();

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.ail) {
            d.e(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList<c> linkedList = this.ahc.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = this.ahc.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.ahc;
                        LinkedList<c> linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(cVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    public final boolean b(b bVar) {
        if (d.ail) {
            d.e(this, "publish %s", bVar.getId());
        }
        if (bVar != null) {
            String id2 = bVar.getId();
            LinkedList<c> linkedList = this.ahc.get(id2);
            if (linkedList == null) {
                synchronized (id2.intern()) {
                    linkedList = this.ahc.get(id2);
                    if (linkedList == null) {
                        if (d.ail) {
                            d.c(this, "No listener for this event %s", id2);
                        }
                        return false;
                    }
                }
            }
            a(linkedList, bVar);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    public final void c(final b bVar) {
        if (d.ail) {
            d.e(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.ahb.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.ahh;
        if (runnable != null) {
            runnable.run();
        }
    }
}

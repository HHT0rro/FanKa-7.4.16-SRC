package com.huawei.quickcard.framework.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardEventBus {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<Subscriber>> f33851a = new HashMap();

    public void post(CardEvent cardEvent) {
        CopyOnWriteArrayList<Subscriber> copyOnWriteArrayList = this.f33851a.get(cardEvent.name());
        if (copyOnWriteArrayList != null) {
            Iterator<Subscriber> iterator2 = copyOnWriteArrayList.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onEvent(cardEvent);
            }
        }
    }

    public void register(String str, Subscriber subscriber) {
        CopyOnWriteArrayList<Subscriber> copyOnWriteArrayList = this.f33851a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f33851a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(subscriber);
    }
}

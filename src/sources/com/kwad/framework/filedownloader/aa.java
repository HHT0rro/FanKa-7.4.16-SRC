package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0494a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.tV() == -3) {
            Iterator<a.InterfaceC0494a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().ue().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0494a> iterator22 = list.iterator2();
        while (iterator22.hasNext()) {
            if (iterator22.next().ue().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.tV()) {
            Iterator<a.InterfaceC0494a> iterator23 = list.iterator2();
            while (iterator23.hasNext()) {
                if (iterator23.next().ue().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).ue().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0494a> ba2 = h.uB().ba(messageSnapshot.getId());
            if (ba2.size() > 0) {
                a ud2 = ba2.get(0).ud();
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(ud2.tV()), Byte.valueOf(messageSnapshot.tV()), Integer.valueOf(ba2.size()));
                }
                if (!a(ba2, messageSnapshot)) {
                    StringBuilder sb2 = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.tV()) + " task-count:" + ba2.size());
                    for (a.InterfaceC0494a interfaceC0494a : ba2) {
                        sb2.append(" | ");
                        sb2.append((int) interfaceC0494a.ud().tV());
                    }
                    com.kwad.framework.filedownloader.f.d.b(this, sb2.toString(), new Object[0]);
                }
            } else {
                com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.tV()));
            }
        }
    }
}

package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SystemManager {

    /* renamed from: a, reason: collision with root package name */
    private static SystemManager f28998a = new SystemManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f28999b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static SystemNotifier f29000c = new a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f28998a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f29000c;
    }

    public void notifyNoticeResult(int i10) {
        f29000c.notifyNoticeObservers(i10);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f29000c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i10) {
        f29000c.notifyObservers(i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements SystemNotifier {

        /* renamed from: a, reason: collision with root package name */
        private final List<SystemObserver> f29001a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i10) {
            synchronized (SystemManager.f28999b) {
                Iterator<SystemObserver> iterator2 = this.f29001a.iterator2();
                while (iterator2.hasNext()) {
                    if (iterator2.next().onNoticeResult(i10)) {
                        iterator2.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f28999b) {
                Iterator<SystemObserver> iterator2 = this.f29001a.iterator2();
                while (iterator2.hasNext()) {
                    if (iterator2.next().onSolutionResult(intent, str)) {
                        iterator2.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f29001a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.f28999b) {
                this.f29001a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f28999b) {
                this.f29001a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i10) {
            synchronized (SystemManager.f28999b) {
                Iterator<SystemObserver> iterator2 = this.f29001a.iterator2();
                while (iterator2.hasNext()) {
                    if (iterator2.next().onUpdateResult(i10)) {
                        iterator2.remove();
                    }
                }
            }
        }
    }
}

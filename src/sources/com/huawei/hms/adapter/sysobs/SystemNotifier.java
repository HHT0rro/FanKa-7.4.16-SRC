package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i10);

    void notifyObservers(int i10);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}

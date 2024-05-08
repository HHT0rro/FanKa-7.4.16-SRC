package com.wangmai.common.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MessageEvent {
    public static final String EVENT_FAIL = "event_fail";
    public static final String EVENT_SUCCESS = "event_success";
    public static final String TAG = "MessageEvent";
    public static CopyOnWriteArrayList<IMessageCallback> messageCallbackList = new CopyOnWriteArrayList<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface IMessageCallback {
        void handleMessage(String str);
    }

    public static void attachObserver(IMessageCallback iMessageCallback) {
        CopyOnWriteArrayList<IMessageCallback> copyOnWriteArrayList = messageCallbackList;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.contains(iMessageCallback)) {
            return;
        }
        messageCallbackList.add(iMessageCallback);
    }

    public static void detachObserver(IMessageCallback iMessageCallback) {
        CopyOnWriteArrayList<IMessageCallback> copyOnWriteArrayList = messageCallbackList;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.contains(iMessageCallback)) {
            return;
        }
        messageCallbackList.remove(iMessageCallback);
    }

    public static void notify(String str) {
        Iterator<IMessageCallback> iterator2 = messageCallbackList.iterator2();
        while (iterator2.hasNext()) {
            IMessageCallback next = iterator2.next();
            detachObserver(next);
            next.handleMessage(str);
        }
    }
}

package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface PushMessageCallback {
    boolean isAllowNet(Context context);

    void onBind(Context context, int i10, String str);

    void onDelAlias(Context context, int i10, List<String> list, List<String> list2, String str);

    void onDelTags(Context context, int i10, List<String> list, List<String> list2, String str);

    void onListTags(Context context, int i10, List<String> list, String str);

    void onLog(Context context, String str, int i10, boolean z10);

    NotifyArriveCallbackByUser onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage);

    void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage);

    void onPublish(Context context, int i10, String str);

    void onReceiveRegId(Context context, String str);

    void onSetAlias(Context context, int i10, List<String> list, List<String> list2, String str);

    void onSetTags(Context context, int i10, List<String> list, List<String> list2, String str);

    void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage);

    void onUnBind(Context context, int i10, String str);
}

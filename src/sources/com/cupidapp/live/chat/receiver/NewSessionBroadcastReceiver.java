package com.cupidapp.live.chat.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.cupidapp.live.push.FKPushType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NewSessionBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public a f13176a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(Intent intent);
    }

    public NewSessionBroadcastReceiver(a aVar) {
        this.f13176a = aVar;
    }

    public final boolean a(Activity activity) {
        return activity == null;
    }

    public void b(Activity activity) {
        if (a(activity)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FKPushType.InboxMessageNew.getType());
        activity.registerReceiver(this, intentFilter);
    }

    public void c(Activity activity) {
        if (a(activity)) {
            return;
        }
        activity.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a aVar;
        if (!FKPushType.InboxMessageNew.getType().equals(intent.getAction()) || (aVar = this.f13176a) == null) {
            return;
        }
        aVar.a(intent);
    }
}

package im.zego.internal.screencapture;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoScreenCaptureService extends Service {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b extends Binder {
        public b() {
        }
    }

    public final void a() {
        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            builder.setChannelId("notification_id");
        }
        if (i10 >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("notification_id", "notification_name", 2));
        }
        Notification build = builder.build();
        build.defaults = 1;
        startForeground(110, build);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a();
        return new b();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        stopForeground(true);
        return super.onUnbind(intent);
    }
}

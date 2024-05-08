package com.alimm.tanx.ui.image.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NotificationTarget extends SimpleTarget<Bitmap> {
    public final Context context;
    public final Notification notification;
    public final int notificationId;
    public final RemoteViews remoteViews;
    public final int viewId;

    public NotificationTarget(Context context, RemoteViews remoteViews, int i10, Notification notification, int i11) {
        this(context, remoteViews, i10, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i11);
    }

    private void update() {
        ((NotificationManager) this.context.getSystemService("notification")).notify(this.notificationId, this.notification);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
    }

    public NotificationTarget(Context context, RemoteViews remoteViews, int i10, int i11, int i12, Notification notification, int i13) {
        super(i11, i12);
        Objects.requireNonNull(context, "Context must not be null!");
        Objects.requireNonNull(notification, "Notification object can not be null!");
        Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
        this.context = context;
        this.viewId = i10;
        this.notification = notification;
        this.notificationId = i13;
        this.remoteViews = remoteViews;
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}

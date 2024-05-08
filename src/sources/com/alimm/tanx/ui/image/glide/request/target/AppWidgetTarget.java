package com.alimm.tanx.ui.image.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {
    public final ComponentName componentName;
    public final Context context;
    public final RemoteViews remoteViews;
    public final int viewId;
    public final int[] widgetIds;

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, int i11, int i12, int... iArr) {
        super(i11, i12);
        Objects.requireNonNull(context, "Context can not be null!");
        Objects.requireNonNull(iArr, "WidgetIds can not be null!");
        if (iArr.length != 0) {
            Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
            this.context = context;
            this.remoteViews = remoteViews;
            this.viewId = i10;
            this.widgetIds = iArr;
            this.componentName = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, int... iArr) {
        this(context, remoteViews, i10, Integer.MIN_VALUE, Integer.MIN_VALUE, iArr);
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, int i11, int i12, ComponentName componentName) {
        super(i11, i12);
        Objects.requireNonNull(context, "Context can not be null!");
        Objects.requireNonNull(componentName, "ComponentName can not be null!");
        Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
        this.context = context;
        this.remoteViews = remoteViews;
        this.viewId = i10;
        this.componentName = componentName;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i10, ComponentName componentName) {
        this(context, remoteViews, i10, Integer.MIN_VALUE, Integer.MIN_VALUE, componentName);
    }
}

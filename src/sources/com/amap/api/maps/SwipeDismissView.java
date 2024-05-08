package com.amap.api.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.WearMapView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SwipeDismissView extends RelativeLayout {
    public WearMapView.OnDismissCallback onDismissCallback;

    public SwipeDismissView(Context context, View view) {
        super(context);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public void setCallback(WearMapView.OnDismissCallback onDismissCallback) {
        this.onDismissCallback = onDismissCallback;
    }

    public void setOnTouchListener(View view) {
        setOnTouchListener(new SwipeDismissTouchListener(view, new Object(), new SwipeDismissCallBack(this)));
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, View view) {
        super(context, attributeSet);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public SwipeDismissView(Context context, AttributeSet attributeSet, int i10, View view) {
        super(context, attributeSet, i10);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }
}

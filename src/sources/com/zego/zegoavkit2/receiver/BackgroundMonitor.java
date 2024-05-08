package com.zego.zegoavkit2.receiver;

import android.app.Application;
import android.content.Context;
import com.zego.zegoavkit2.receiver.Background;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BackgroundMonitor implements Background.Listener {
    public static final String TAG = "BackgroundMonitor";
    private Background.Binding mListenerBinding;
    private long mThis;

    public static native void onBackgroundStatusChanged(long j10, boolean z10);

    public int init(Context context) {
        if (context == null || !(context instanceof Application)) {
            return -1;
        }
        this.mListenerBinding = Background.get().init((Application) context).addListener(this);
        return 0;
    }

    public boolean isBackground() {
        return Background.get().isBackground();
    }

    public boolean isInited() {
        if (this.mListenerBinding == null) {
            return false;
        }
        return Background.get().isInited();
    }

    @Override // com.zego.zegoavkit2.receiver.Background.Listener
    public void onBecameBackground() {
        onBackgroundStatusChanged(this.mThis, true);
    }

    @Override // com.zego.zegoavkit2.receiver.Background.Listener
    public void onBecameForeground() {
        onBackgroundStatusChanged(this.mThis, false);
    }

    public void setThis(long j10) {
        this.mThis = j10;
    }

    public int uninit() {
        Background.Binding binding = this.mListenerBinding;
        if (binding == null) {
            return 0;
        }
        binding.unbind();
        Background.get().uninit();
        return 0;
    }
}

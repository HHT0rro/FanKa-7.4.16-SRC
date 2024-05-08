package com.alimm.tanx.core.view.player.core;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxPlayerListener {
    void onComplete();

    void onEndBuffering();

    void onError(Exception exc);

    void onPause();

    void onRelease();

    void onStart();

    void onStartBuffering();

    void onStop();
}

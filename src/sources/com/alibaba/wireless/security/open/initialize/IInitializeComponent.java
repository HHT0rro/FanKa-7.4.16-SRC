package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IInitializeComponent {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface IInitFinishListener {
        void onError();

        void onSuccess();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface IInitFinishListenerV2 extends IInitFinishListener {
        void onStart();
    }

    int initialize(Context context) throws SecException;

    void initializeAsync(Context context);

    boolean isSoValid(Context context) throws SecException;

    void loadLibraryAsync(Context context) throws SecException;

    int loadLibrarySync(Context context) throws SecException;

    int loadLibrarySync(Context context, String str) throws SecException;

    void registerInitFinishListener(IInitFinishListener iInitFinishListener) throws SecException;

    void unregisterInitFinishListener(IInitFinishListener iInitFinishListener) throws SecException;
}

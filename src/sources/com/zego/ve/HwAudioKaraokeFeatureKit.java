package com.zego.ve;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.zego.ve.IHwAudioKaraokeFeature;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HwAudioKit.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class HwAudioKaraokeFeatureKit {
    private Context mContext;
    private FeatureKitManager mFeatureKitManager;
    private IHwAudioKaraokeFeature mIHwAudioKaraokeFeatureAidl;
    private boolean mIsServiceConnected = false;
    private IBinder mService = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.zego.ve.HwAudioKaraokeFeatureKit.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HwAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl = IHwAudioKaraokeFeature.Stub.asInterface(iBinder);
            if (HwAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl != null) {
                HwAudioKaraokeFeatureKit.this.mIsServiceConnected = true;
                HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = HwAudioKaraokeFeatureKit.this;
                if (hwAudioKaraokeFeatureKit.serviceInit(hwAudioKaraokeFeatureKit.mContext.getPackageName()) < 0) {
                    HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1002);
                } else {
                    HwAudioKaraokeFeatureKit.this.serviceLinkToDeath(iBinder);
                    HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1000);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HwAudioKaraokeFeatureKit.this.mIsServiceConnected = false;
            if (HwAudioKaraokeFeatureKit.this.mFeatureKitManager != null) {
                HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1001);
            }
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.zego.ve.HwAudioKaraokeFeatureKit.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HwAudioKaraokeFeatureKit.this.mService.unlinkToDeath(HwAudioKaraokeFeatureKit.this.mDeathRecipient, 0);
            HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1003);
            HwAudioKaraokeFeatureKit.this.mService = null;
        }
    };

    public HwAudioKaraokeFeatureKit(Context context) {
        this.mFeatureKitManager = null;
        this.mFeatureKitManager = FeatureKitManager.getInstance();
        this.mContext = context;
    }

    private void bindService(Context context) {
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager == null || this.mIsServiceConnected) {
            return;
        }
        featureKitManager.bindService(context, this.mConnection, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int serviceInit(String str) {
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                iHwAudioKaraokeFeature.init(str);
            }
            return 0;
        } catch (Exception e2) {
            Log.e("HwAudioKaraokeFeatureKit", "serviceInit" + e2.getMessage());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(1002);
            }
        }
    }

    public void destroy() {
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
    }

    public int enableKaraokeFeature(boolean z10) {
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature == null || !this.mIsServiceConnected) {
                return -2;
            }
            return iHwAudioKaraokeFeature.enableKaraokeFeature(z10);
        } catch (RemoteException unused) {
            return -2;
        }
    }

    public void initialize(Context context) {
        if (context == null) {
            return;
        }
        if (!this.mFeatureKitManager.isMediaKitSupport(context)) {
            this.mFeatureKitManager.onCallBack(2);
        } else {
            bindService(context);
        }
    }

    public int setParameter(String str, int i10) {
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature == null || !this.mIsServiceConnected) {
                return -2;
            }
            return iHwAudioKaraokeFeature.setParameter(str, i10);
        } catch (RemoteException unused) {
            return -2;
        }
    }
}

package com.zego.ve;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.zego.ve.IHwAudioEngine;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class HwAudioKit {
    public static final int APP_CONTEXT_NULL = 7;
    public static final int AUDIO_KIT_SERVICE_DIED = 6;
    public static final int AUDIO_KIT_SERVICE_DISCONNECTED = 4;
    public static final int AUDIO_KIT_SERVICE_LINKFAILED = 5;
    public static final int AUDIO_KIT_SUCCESS = 0;
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioEngineService";
    public static final int GET_LATENCY_FAIL = -1;
    public static final int KARAOKE_SERVICE_DIED = 1003;
    public static final int KARAOKE_SERVICE_DISCONNECTED = 1001;
    public static final int KARAOKE_SERVICE_LINKFAIL = 1002;
    public static final int KARAOKE_SUCCESS = 1000;
    public static final int KARAOKE_WIRED_HEADSET_NOT_PLUG_IN = 1805;
    public static final int PARAME_VALUE_ERROR = 1807;
    public static final int PLATEFORM_NOT_SUPPORT = 1806;
    public static final int SERVICE_BIND_ERROR = -2;
    private static final String TAG = "HwAudioKit.HwAudioKit";
    public static final int VENDOR_NOT_SUPPORTED = 2;
    public IAudioKitCallback _callBack;
    private Context mContext;
    private IHwAudioEngine mIHwAudioEngine = null;
    private boolean mIsServiceConnected = false;
    private FeatureKitManager mFeatureKitManager = FeatureKitManager.getInstance();
    private IBinder mService = null;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.zego.ve.HwAudioKit.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HwAudioKit.this.mIHwAudioEngine = IHwAudioEngine.Stub.asInterface(iBinder);
            if (HwAudioKit.this.mIHwAudioEngine != null) {
                HwAudioKit.this.mIsServiceConnected = true;
                HwAudioKit.this.mFeatureKitManager.onCallBack(0);
                HwAudioKit hwAudioKit = HwAudioKit.this;
                hwAudioKit.serviceInit(hwAudioKit.mContext.getPackageName(), "1.0.1");
                HwAudioKit.this.serviceLinkToDeath(iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HwAudioKit.this.mIHwAudioEngine = null;
            HwAudioKit.this.mIsServiceConnected = false;
            HwAudioKit.this.mFeatureKitManager.onCallBack(4);
        }
    };
    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.zego.ve.HwAudioKit.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HwAudioKit.this.mService.unlinkToDeath(HwAudioKit.this.mDeathRecipient, 0);
            HwAudioKit.this.mFeatureKitManager.onCallBack(6);
            HwAudioKit.this.mService = null;
        }
    };
    public HwAudioKaraokeFeatureKit _hwAudioKaraokeFeatureKit = null;
    public state _state = state.state_none;
    public CountDownLatch barrier = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum state {
        state_none,
        state_audiokit_success,
        state_audiokit_failed,
        state_karaoke_success,
        state_karaoke_failed
    }

    public HwAudioKit(Context context) {
        this.mContext = null;
        IAudioKitCallback iAudioKitCallback = new IAudioKitCallback() { // from class: com.zego.ve.HwAudioKit.3
            @Override // com.zego.ve.IAudioKitCallback
            public void onResult(int i10) {
                Log.i(HwAudioKit.TAG, "audiokit callback " + i10);
                if (i10 == 0) {
                    HwAudioKit.this._state = state.state_audiokit_success;
                } else if (i10 != 2 && i10 != 4 && i10 != 5 && i10 != 6) {
                    switch (i10) {
                        case 1000:
                            HwAudioKit.this._state = state.state_karaoke_success;
                            break;
                        case 1001:
                        case 1002:
                        case 1003:
                            HwAudioKit.this._state = state.state_karaoke_failed;
                            break;
                    }
                } else {
                    HwAudioKit.this._state = state.state_audiokit_failed;
                }
                CountDownLatch countDownLatch = HwAudioKit.this.barrier;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };
        this._callBack = iAudioKitCallback;
        this.mFeatureKitManager.setCallBack(iAudioKitCallback);
        this.mContext = context;
    }

    private void bindService(Context context) {
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager == null || this.mIsServiceConnected) {
            return;
        }
        featureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceInit(String str, String str2) {
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine == null || !this.mIsServiceConnected) {
                return;
            }
            iHwAudioEngine.init(str, str2);
        } catch (RemoteException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(5);
            }
        }
    }

    public boolean createFeatureKaraoke() {
        this.barrier = new CountDownLatch(1);
        this._hwAudioKaraokeFeatureKit = this.mFeatureKitManager.createFeatureKit(1, this.mContext);
        try {
            if (!this.barrier.await(1000L, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "createFeatureKaraoke timeout");
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.barrier = null;
        return this._state == state.state_karaoke_success;
    }

    public void destroy() {
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this._hwAudioKaraokeFeatureKit;
        if (hwAudioKaraokeFeatureKit != null) {
            hwAudioKaraokeFeatureKit.destroy();
        }
    }

    public int enableKaraokeFeature(boolean z10) {
        return this._hwAudioKaraokeFeatureKit.enableKaraokeFeature(z10);
    }

    public boolean initialize() {
        this.barrier = new CountDownLatch(1);
        Context context = this.mContext;
        if (context == null) {
            this.mFeatureKitManager.onCallBack(7);
        } else if (!this.mFeatureKitManager.isMediaKitSupport(context)) {
            this.mFeatureKitManager.onCallBack(2);
        } else {
            bindService(this.mContext);
        }
        try {
            if (!this.barrier.await(1000L, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "initialize timeout");
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.barrier = null;
        return this._state == state.state_audiokit_success;
    }

    public boolean isFeatureKaraokeOn() {
        return this._state == state.state_karaoke_success;
    }

    public void setKaraokeReverbMode(int i10) {
        this._hwAudioKaraokeFeatureKit.setParameter("Karaoke_reverb_mode=", i10);
    }

    public void setKaraokeVolume(int i10) {
        if (i10 > 100) {
            i10 = 100;
        }
        this._hwAudioKaraokeFeatureKit.setParameter("Karaoke_volume=", i10);
    }
}

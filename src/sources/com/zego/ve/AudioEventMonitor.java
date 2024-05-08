package com.zego.ve;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRouting;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.android.internal.os.PowerProfile;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AudioEventMonitor extends BroadcastReceiver {
    private static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final String TAG = "device";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    public Context _context = null;
    public AudioManager _audioManager = null;
    public int _mode = 0;
    public boolean no_duck_by_other = false;
    public boolean duck_other_when_voip_ = false;
    public int duck_value_in_percent_ = 20;
    public int volume_before_duck_ = -1;
    public AudioRoutChange _audioRouteChange = null;
    public boolean audio_route_change_valid_ = false;
    public boolean on_receiver_first_arrive_ = true;
    public boolean wait_check_sco_ = false;
    public int audio_route_ = 0;
    public int cap_original_route_ = 15;
    private int _bluetoothOpSeq = 0;
    public Handler _handler = new Handler(Looper.getMainLooper());
    public PhoneStateListener _phoneStateListener = null;
    public AudioManager.OnAudioFocusChangeListener _audioFocusChangeListener = null;
    public AudioManager.AudioPlaybackCallback _audioPlayListener = null;
    public boolean play_active_in_voip_ = false;
    public boolean _isCalling = false;
    public boolean _once_call_come_in = false;
    private boolean has_entered_comm_mode = false;
    private int current_route_type = 0;
    public boolean has_inited_ = false;
    public IEventNotify event_notify_ = null;
    private Object event_lock_ = new Object();
    private Object duck_lock_ = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class AudioRoutChange extends AudioDeviceCallback implements AudioRouting.OnRoutingChangedListener {
        public int invoke_times = 0;
        private Method _getAddress = null;

        public AudioRoutChange() {
        }

        private String getDirection(AudioDeviceInfo audioDeviceInfo) {
            return audioDeviceInfo.isSource() ? "input" : audioDeviceInfo.isSink() ? "output" : "";
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            int routeType;
            try {
                if (this._getAddress == null) {
                    this._getAddress = AudioDeviceInfo.class.getDeclaredMethod("getAddress", new Class[0]);
                }
                if (this.invoke_times > 0) {
                    AudioEventMonitor.this.audio_route_change_valid_ = true;
                }
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    Log.i("device", "add device:" + audioDeviceInfo.getId() + ", " + ((Object) audioDeviceInfo.getProductName()) + "|" + AudioDeviceHelper.getDeviceTypeStr(audioDeviceInfo.getType()) + "|" + getDirection(audioDeviceInfo) + "|" + ((String) this._getAddress.invoke(audioDeviceInfo, new Object[0])));
                    if (audioDeviceInfo.isSink() && this.invoke_times > 0 && -1 != (routeType = AudioDeviceHelper.getRouteType(audioDeviceInfo.getType()))) {
                        if (6 == routeType) {
                            if (AudioDeviceHelper.scoConnect(AudioEventMonitor.this._context)) {
                                routeType = 2;
                            } else if (3 == AudioEventMonitor.this._mode) {
                                Log.i("device", "onAudioDevicesAdded ignore A2DP in VOIP");
                            }
                        }
                        AudioEventMonitor.this.ChangeAudioRoute(routeType);
                    }
                }
                this.invoke_times++;
            } catch (Exception e2) {
                Log.w("device", "onAudioDevicesAdded " + e2.toString());
            }
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            try {
                AudioEventMonitor.this.audio_route_change_valid_ = true;
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    Log.i("device", "remove device:" + audioDeviceInfo.getId() + ", " + ((Object) audioDeviceInfo.getProductName()) + "|" + AudioDeviceHelper.getDeviceTypeStr(audioDeviceInfo.getType()) + "|" + getDirection(audioDeviceInfo));
                    if (audioDeviceInfo.isSink() && -1 != AudioDeviceHelper.getRouteType(audioDeviceInfo.getType())) {
                        AudioEventMonitor.this.RemoveAudioRoute();
                    }
                }
            } catch (Exception e2) {
                Log.w("device", "onAudioDevicesRemoved " + e2.toString());
            }
        }

        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public void onRoutingChanged(AudioRouting audioRouting) {
            AudioDeviceInfo routedDevice;
            if (audioRouting == null || (routedDevice = audioRouting.getRoutedDevice()) == null) {
                return;
            }
            Log.i("device", ((Object) audioRouting) + " routing changed device:" + routedDevice.getId() + ", type:" + routedDevice.getType() + "(" + AudioDeviceHelper.getDeviceTypeStr(routedDevice.getType()) + ")");
            if (routedDevice.isSource()) {
                AudioEventMonitor.this.cap_original_route_ = AudioDeviceHelper.getRouteType(routedDevice.getType());
                AudioEventMonitor audioEventMonitor = AudioEventMonitor.this;
                if (2 != audioEventMonitor.audio_route_ || 2 == audioEventMonitor.cap_original_route_ || audioEventMonitor.wait_check_sco_) {
                    return;
                }
                synchronized (audioEventMonitor.event_lock_) {
                    IEventNotify iEventNotify = AudioEventMonitor.this.event_notify_;
                    if (iEventNotify != null) {
                        iEventNotify.OnRoutingChange();
                    }
                }
                return;
            }
            if (routedDevice.isSink()) {
                AudioEventMonitor audioEventMonitor2 = AudioEventMonitor.this;
                if (audioEventMonitor2.no_duck_by_other && audioEventMonitor2.has_entered_comm_mode && AudioEventMonitor.this.current_route_type != routedDevice.getType()) {
                    AudioEventMonitor.this.current_route_type = routedDevice.getType();
                    AudioEventMonitor.this.RestoreMediaVolume();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IEventNotify {
        void OnAudioFocusChange(int i10);

        void OnAudioRouteChanged(int i10);

        void OnAudioVolumeChanged(int i10);

        void OnInterruptionBegin();

        void OnInterruptionEnd();

        void OnRoutingChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DuckActivePlayWhenVoip() {
        int streamVolume = this._audioManager.getStreamVolume(0);
        int streamVolume2 = this._audioManager.getStreamVolume(3);
        float streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
        int i10 = (int) ((this.duck_value_in_percent_ * streamMaxVolume) / 100.0d);
        if (i10 == 0) {
            i10 = 1;
        }
        Log.i("device", "Duck other app play starting(api>=29), voip curr:" + streamVolume + " set:" + i10 + " max:" + streamMaxVolume);
        this._audioManager.setStreamVolume(0, i10, 0);
        this._audioManager.setStreamVolume(3, 0, 0);
        this._audioManager.setStreamVolume(3, streamVolume2, 0);
        this._audioManager.setStreamVolume(0, streamVolume, 0);
    }

    private void InitAudioFocusChangeListener() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.zego.ve.AudioEventMonitor.7
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i10) {
                synchronized (AudioEventMonitor.this.event_lock_) {
                    IEventNotify iEventNotify = AudioEventMonitor.this.event_notify_;
                    if (iEventNotify != null) {
                        iEventNotify.OnAudioFocusChange(i10);
                    }
                }
            }
        };
        this._audioFocusChangeListener = onAudioFocusChangeListener;
        try {
            int requestAudioFocus = this._audioManager.requestAudioFocus(onAudioFocusChangeListener, 0, 1);
            Log.i("device", "trace request audio focus status: " + requestAudioFocus + "(" + (requestAudioFocus != 0 ? requestAudioFocus != 1 ? requestAudioFocus != 2 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "DELAYED" : "GRANTED" : "FAILED") + ")");
        } catch (Throwable th) {
            Log.e("device", "trace request audio focus failed, " + th.getMessage());
            this._audioManager.abandonAudioFocus(this._audioFocusChangeListener);
            this._audioFocusChangeListener = null;
        }
    }

    private void InitAudioPlaybackListener() {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        AudioManager.AudioPlaybackCallback audioPlaybackCallback = new AudioManager.AudioPlaybackCallback() { // from class: com.zego.ve.AudioEventMonitor.6
            @Override // android.media.AudioManager.AudioPlaybackCallback
            public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> list) {
                AudioEventMonitor audioEventMonitor = AudioEventMonitor.this;
                if (3 == audioEventMonitor._mode && audioEventMonitor.duck_other_when_voip_) {
                    boolean currentActiveStatus = audioEventMonitor.getCurrentActiveStatus(true);
                    synchronized (AudioEventMonitor.this.duck_lock_) {
                        AudioEventMonitor audioEventMonitor2 = AudioEventMonitor.this;
                        if (currentActiveStatus != audioEventMonitor2.play_active_in_voip_) {
                            audioEventMonitor2.play_active_in_voip_ = currentActiveStatus;
                            if (currentActiveStatus) {
                                audioEventMonitor2.DuckActivePlayWhenVoip();
                            }
                        }
                    }
                }
                AudioEventMonitor audioEventMonitor3 = AudioEventMonitor.this;
                if (audioEventMonitor3._mode == 0) {
                    audioEventMonitor3._handler.post(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int mode = AudioEventMonitor.this._audioManager.getMode();
                            if (3 == mode) {
                                if (AudioEventMonitor.this.has_entered_comm_mode) {
                                    return;
                                }
                                AudioEventMonitor.this.has_entered_comm_mode = true;
                                AudioEventMonitor audioEventMonitor4 = AudioEventMonitor.this;
                                if (audioEventMonitor4.no_duck_by_other) {
                                    audioEventMonitor4.RestoreMediaVolume();
                                    return;
                                }
                                return;
                            }
                            if (mode == 0 && AudioEventMonitor.this.has_entered_comm_mode) {
                                AudioEventMonitor.this.has_entered_comm_mode = false;
                                Log.i("device", "exit communication mode and to restore media volume");
                                AudioEventMonitor.this.RestoreMediaVolume();
                            }
                        }
                    });
                }
            }
        };
        this._audioPlayListener = audioPlaybackCallback;
        this._audioManager.registerAudioPlaybackCallback(audioPlaybackCallback, null);
    }

    private void InitPhoneStateListener() {
        this._handler.post(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.4
            @Override // java.lang.Runnable
            public void run() {
                AudioEventMonitor audioEventMonitor = AudioEventMonitor.this;
                audioEventMonitor._isCalling = false;
                audioEventMonitor._phoneStateListener = new PhoneStateListener() { // from class: com.zego.ve.AudioEventMonitor.4.1
                    @Override // android.telephony.PhoneStateListener
                    public void onCallStateChanged(int i10, String str) {
                        super.onCallStateChanged(i10, str);
                        synchronized (AudioEventMonitor.this.event_lock_) {
                            AudioEventMonitor audioEventMonitor2 = AudioEventMonitor.this;
                            IEventNotify iEventNotify = audioEventMonitor2.event_notify_;
                            if (iEventNotify != null) {
                                if (i10 != 0) {
                                    if (i10 == 1) {
                                        audioEventMonitor2._isCalling = true;
                                        iEventNotify.OnInterruptionBegin();
                                    } else if (i10 == 2) {
                                        audioEventMonitor2._isCalling = true;
                                        iEventNotify.OnInterruptionBegin();
                                    }
                                } else if (audioEventMonitor2._isCalling) {
                                    audioEventMonitor2._once_call_come_in = true;
                                    audioEventMonitor2._isCalling = false;
                                    iEventNotify.OnInterruptionEnd();
                                }
                            }
                        }
                    }
                };
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) AudioEventMonitor.this._context.getSystemService("phone");
                    int callState = telephonyManager.getCallState();
                    telephonyManager.listen(AudioEventMonitor.this._phoneStateListener, 32);
                    Log.i("device", "trace init call state: " + callState);
                } catch (Throwable th) {
                    Log.e("device", "InitPhoneStateListener failed, " + th);
                    AudioEventMonitor.this._phoneStateListener = null;
                }
            }
        });
    }

    private int RegisterAudioRouteListen() {
        this.on_receiver_first_arrive_ = true;
        this.audio_route_change_valid_ = false;
        if (Build.VERSION.SDK_INT >= 24) {
            AudioRoutChange audioRoutChange = new AudioRoutChange();
            this._audioRouteChange = audioRoutChange;
            this._audioManager.registerAudioDeviceCallback(audioRoutChange, null);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        this._context.registerReceiver(this, intentFilter);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RemoveAudioRoute() {
        ChangeAudioRoute(AudioDeviceHelper.getCurrentRoute(this._context, this._mode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RestoreMediaVolume() {
        int streamVolume = this._audioManager.getStreamVolume(0);
        int streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
        Log.i("device", "Restore media volume, voice curr:" + streamVolume + " media curr:" + this._audioManager.getStreamVolume(3) + " voice max:" + streamMaxVolume + " media max:" + this._audioManager.getStreamMaxVolume(3));
        try {
            this._audioManager.setStreamVolume(0, streamMaxVolume, 0);
            this._audioManager.adjustStreamVolume(3, -1, 0);
            this._audioManager.adjustStreamVolume(3, 1, 0);
            this._audioManager.setStreamVolume(0, streamVolume, 0);
        } catch (SecurityException unused) {
            Log.e("device", "not allow to set volume");
        }
    }

    private void SetModeWithDucking() {
        if (3 == this._mode) {
            int streamVolume = this._audioManager.getStreamVolume(3);
            if (this.volume_before_duck_ < 0) {
                this.volume_before_duck_ = streamVolume;
            }
            if (Build.VERSION.SDK_INT < 29) {
                int i10 = (int) ((this.duck_value_in_percent_ * r1) / 100.0d);
                Log.i("device", "Duck other app(api < 29), media curr:" + streamVolume + " set:" + i10 + " max:" + this._audioManager.getStreamMaxVolume(3));
                if (i10 < streamVolume) {
                    this._audioManager.setStreamVolume(3, i10, 0);
                }
                this._audioManager.setMode(this._mode);
                return;
            }
            int streamVolume2 = this._audioManager.getStreamVolume(0);
            float streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
            int i11 = (int) ((this.duck_value_in_percent_ * streamMaxVolume) / 100.0d);
            if (i11 == 0) {
                i11 = 1;
            }
            Log.i("device", "Duck other app(api>= 29), voip curr:" + streamVolume2 + " set:" + i11 + " max:" + streamMaxVolume);
            if (i11 < streamVolume2) {
                this._audioManager.setStreamVolume(0, i11, 0);
            }
            this._audioManager.setMode(this._mode);
            if (i11 < streamVolume2) {
                this._audioManager.setStreamVolume(0, streamVolume2, 0);
            }
            synchronized (this.duck_lock_) {
                this.play_active_in_voip_ = getCurrentActiveStatus(true);
            }
            return;
        }
        int i12 = this.volume_before_duck_;
        if (i12 > 0) {
            if (Build.VERSION.SDK_INT < 29) {
                this._audioManager.setStreamVolume(3, i12, 0);
            } else {
                this._audioManager.setStreamVolume(3, this._audioManager.getStreamVolume(3), 0);
            }
        }
        this.volume_before_duck_ = -1;
        this._audioManager.setMode(this._mode);
    }

    private void UninitAudioFocusChangeListener() {
        try {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this._audioFocusChangeListener;
            if (onAudioFocusChangeListener != null) {
                this._audioManager.abandonAudioFocus(onAudioFocusChangeListener);
                this._audioFocusChangeListener = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void UninitAudioPlaybackListener() {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        this._audioManager.unregisterAudioPlaybackCallback(this._audioPlayListener);
        this._audioPlayListener = null;
    }

    private void UninitPhoneStateListener() {
        this._handler.post(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AudioEventMonitor.this._phoneStateListener != null) {
                        Log.i("device", "trace interruption stop call state listen");
                        ((TelephonyManager) AudioEventMonitor.this._context.getSystemService("phone")).listen(AudioEventMonitor.this._phoneStateListener, 0);
                        AudioEventMonitor.this._phoneStateListener = null;
                    }
                } catch (Throwable th) {
                    Log.e("device", "UninitPhoneStateListener failed, " + th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getCurrentActiveStatus(boolean z10) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Iterator<AudioPlaybackConfiguration> iterator2 = this._audioManager.getActivePlaybackConfigurations().iterator2();
        while (iterator2.hasNext()) {
            int usage = iterator2.next().getAudioAttributes().getUsage();
            if (z10) {
                if (usage == 1 || usage == 14) {
                    return true;
                }
            } else if (usage == 2) {
                return true;
            }
        }
        return false;
    }

    public void ChangeAudioRoute(int i10) {
        if (i10 != this.audio_route_) {
            if (2 == i10) {
                this.wait_check_sco_ = true;
            }
            if (this.no_duck_by_other && this.has_entered_comm_mode) {
                RestoreMediaVolume();
            }
            this.audio_route_ = i10;
            synchronized (this.event_lock_) {
                IEventNotify iEventNotify = this.event_notify_;
                if (iEventNotify != null) {
                    iEventNotify.OnAudioRouteChanged(i10);
                }
            }
        }
    }

    public void CheckAudioRoute(int i10, boolean z10) {
        if (6 != i10 && 2 != i10) {
            if (this._audioManager.isBluetoothScoOn()) {
                SetBluetoothScoOn(false);
            }
            if (z10) {
                boolean z11 = i10 == 0;
                this._audioManager.setSpeakerphoneOn(z11);
                Log.i("device", "setSpeakerphoneOn:" + z11);
                if (this.no_duck_by_other && this.has_entered_comm_mode && z11) {
                    RestoreMediaVolume();
                    return;
                }
                return;
            }
            return;
        }
        boolean z12 = 2 == i10 && this._mode == 3;
        this._audioManager.setSpeakerphoneOn(false);
        if (this._once_call_come_in) {
            this._once_call_come_in = false;
            SetBluetoothScoOn(false);
            if (z12) {
                SetBluetoothScoOn(true);
                return;
            }
            return;
        }
        SetBluetoothScoOn(z12);
    }

    public boolean CheckBluetoothSCO() {
        this.wait_check_sco_ = false;
        return this.audio_route_ != 2 || this.cap_original_route_ == 2;
    }

    public int CheckPhoneState() {
        this._handler.postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (((TelephonyManager) AudioEventMonitor.this._context.getSystemService("phone")).getCallState() == 0 && AudioEventMonitor.this._isCalling) {
                        Log.w("device", "interruption check call state idle, resume it");
                        AudioEventMonitor audioEventMonitor = AudioEventMonitor.this;
                        audioEventMonitor._once_call_come_in = true;
                        audioEventMonitor._isCalling = false;
                        synchronized (audioEventMonitor.event_lock_) {
                            IEventNotify iEventNotify = AudioEventMonitor.this.event_notify_;
                            if (iEventNotify != null) {
                                iEventNotify.OnInterruptionEnd();
                            }
                        }
                    }
                } catch (Throwable th) {
                    Log.e("device", "CheckPhoneState failed, " + th);
                }
            }
        }, 500L);
        return 0;
    }

    public void DuckUnpluginHeadsetWhenVoip() {
        if (3 != this._mode) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            this._audioManager.setMode(0);
            int streamVolume = this._audioManager.getStreamVolume(3);
            int i10 = (int) ((this.duck_value_in_percent_ * r2) / 100.0d);
            Log.i("device", "Duck reset at headset unplugin(api<29), music curr:" + streamVolume + " set:" + i10 + " max:" + this._audioManager.getStreamMaxVolume(3));
            if (i10 < streamVolume) {
                this._audioManager.setStreamVolume(3, i10, 0);
            }
            this._audioManager.setMode(3);
            return;
        }
        int streamVolume2 = this._audioManager.getStreamVolume(0);
        float streamMaxVolume = this._audioManager.getStreamMaxVolume(0);
        int i11 = (int) ((this.duck_value_in_percent_ * streamMaxVolume) / 100.0d);
        if (i11 == 0) {
            i11 = 1;
        }
        Log.i("device", "Duck reset at headset unplugin(api >= 29), voip curr:" + streamVolume2 + " set:" + i11 + " max:" + streamMaxVolume);
        this._audioManager.setStreamVolume(0, i11, 0);
        this._audioManager.setStreamVolume(0, streamVolume2, 0);
    }

    public AudioManager GetAudioManager() {
        return this._audioManager;
    }

    public int GetAudioRoute() {
        return this.audio_route_;
    }

    public int GetCaptrueRoute() {
        return this.cap_original_route_;
    }

    public int GetMode() {
        return this._mode;
    }

    public AudioRoutChange GetRouteChangeHandle() {
        return this._audioRouteChange;
    }

    public void Init(Context context, boolean z10) {
        Handler handler;
        synchronized (this.event_lock_) {
            if (!this.has_inited_) {
                this._context = context;
                try {
                    this._audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
                    this.has_inited_ = true;
                    RegisterAudioRouteListen();
                    InitPhoneStateListener();
                    if (z10) {
                        InitAudioFocusChangeListener();
                    }
                    InitAudioPlaybackListener();
                } catch (Throwable th) {
                    Log.e("device", "getSystemService failed, " + th.getMessage());
                }
            } else if (this.no_duck_by_other && this.has_entered_comm_mode && (handler = this._handler) != null) {
                handler.postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioEventMonitor.this.RestoreMediaVolume();
                    }
                }, 1000L);
            }
        }
    }

    public boolean IsInited() {
        return this.has_inited_;
    }

    public int SetBluetoothScoOn(boolean z10) {
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            return 0;
        }
        try {
            if (z10) {
                audioManager.startBluetoothSco();
                this._audioManager.setBluetoothScoOn(z10);
            } else {
                audioManager.setBluetoothScoOn(z10);
                this._audioManager.stopBluetoothSco();
            }
            return 0;
        } catch (Exception e2) {
            Log.e("device", "setBluetoothScoOn failed, " + e2.getMessage());
            return -1;
        }
    }

    public void SetEeventHandler(IEventNotify iEventNotify) {
        synchronized (this.event_lock_) {
            this.event_notify_ = iEventNotify;
        }
    }

    public int SetMode(int i10) {
        this._mode = i10;
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            return 0;
        }
        if (!this.duck_other_when_voip_) {
            audioManager.setMode(i10);
            return 0;
        }
        SetModeWithDucking();
        return 0;
    }

    public void SetRoutInfo(int i10) {
        if (2 == i10) {
            this.wait_check_sco_ = true;
        }
        synchronized (this.event_lock_) {
            this.audio_route_ = i10;
        }
    }

    public void SetWaitSocFlag() {
        if (2 == this.audio_route_) {
            this.wait_check_sco_ = true;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("android.media.VOLUME_CHANGED_ACTION".equals(action)) {
            int intExtra = intent.getIntExtra(EXTRA_VOLUME_STREAM_TYPE, -1);
            IEventNotify iEventNotify = this.event_notify_;
            if (iEventNotify != null) {
                iEventNotify.OnAudioVolumeChanged(intExtra);
                return;
            }
            return;
        }
        if (!this.audio_route_change_valid_ && !this.on_receiver_first_arrive_) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("action: ");
            sb2.append(action);
            if (extras == null || extras.size() <= 0) {
                str = "";
            } else {
                str = ", " + extras.toString();
            }
            sb2.append(str);
            Log.i("device", "onReceive " + sb2.toString());
            if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                if (intent.hasExtra("state")) {
                    if (intent.getIntExtra("state", 0) == 1) {
                        ChangeAudioRoute(1);
                        return;
                    } else {
                        RemoveAudioRoute();
                        return;
                    }
                }
                return;
            }
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                if (intExtra2 == 10) {
                    this._bluetoothOpSeq++;
                    RemoveAudioRoute();
                    return;
                } else {
                    if (intExtra2 == 12) {
                        final int i10 = this._bluetoothOpSeq + 1;
                        this._bluetoothOpSeq = i10;
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BluetoothAdapter defaultAdapter;
                                if (AudioEventMonitor.this._bluetoothOpSeq == i10 && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null && 2 == defaultAdapter.getProfileConnectionState(2)) {
                                    AudioEventMonitor.this.ChangeAudioRoute(6);
                                }
                            }
                        }, 1500L);
                        return;
                    }
                    return;
                }
            }
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", Integer.MIN_VALUE);
                if (intExtra3 == 2) {
                    final int i11 = this._bluetoothOpSeq + 1;
                    this._bluetoothOpSeq = i11;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zego.ve.AudioEventMonitor.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AudioEventMonitor.this._bluetoothOpSeq == i11) {
                                AudioEventMonitor.this.ChangeAudioRoute(2);
                            }
                        }
                    }, 1500L);
                    return;
                } else {
                    if (intExtra3 == 0) {
                        this._bluetoothOpSeq++;
                        RemoveAudioRoute();
                        return;
                    }
                    return;
                }
            }
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                if (AudioDeviceHelper.HasUsbAudioDevice(intent)) {
                    ChangeAudioRoute(4);
                    return;
                }
                return;
            } else {
                if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    RemoveAudioRoute();
                    return;
                }
                return;
            }
        }
        this.on_receiver_first_arrive_ = false;
    }
}

package com.zego.ve;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.framework.configuration.device.IManufacturerDeviceInfo;
import com.zego.ve.AudioEventMonitor;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AudioDevice implements AudioEventMonitor.IEventNotify {
    private static final int ApiAAudio = 4;
    private static final int ApiAudioRecord = 1;
    private static final int ApiAudioRecordLatency = 2;
    private static final int ApiAudioTrack = 1;
    private static final int ApiAudioTrackLatency = 2;
    private static final int ApiOpensles = 3;
    private static final int CAP_SR_16000 = 2;
    private static final int CAP_SR_32000 = 1;
    private static final int CAP_SR_48000 = 0;
    private static final int CAP_SR_8000 = 3;
    private static final String TAG = "device";
    public static AudioEventMonitor event_monitor_stc_ = new AudioEventMonitor();
    public int _audio_source;
    public ByteBuffer _capBuf;
    public ByteBuffer _rndBuf;
    public byte[] _rndBufArray;
    public int _stream_type;
    public Context _context = null;
    public AudioTrack _rndDev = null;
    public AudioTrack _devRoute = null;
    public AudioRecord _capDev = null;
    public AudioManager _audioManager = null;
    public int _NativeOutputSampleRate = 44100;
    public final int _frameSizeMs = 20;
    public int _capSampleRate = 32000;
    public int[] _capSampleRateTable = {48000, 32000, 16000, 8000};
    public int _framesPerBuffer = 256;
    public int _capProfile = 1;
    public volatile long _pthis = 0;
    public KaraokeHelper _Karaoke = null;
    public AudioEventMonitor.AudioRoutChange _audioRouteChange = null;

    public AudioDevice() {
        this._rndBuf = null;
        this._capBuf = null;
        this._rndBufArray = null;
        this._stream_type = 3;
        this._audio_source = 1;
        this._rndBuf = ByteBuffer.allocateDirect(3840);
        this._rndBufArray = new byte[3840];
        this._capBuf = ByteBuffer.allocateDirect(1920);
        this._audio_source = 7;
        this._stream_type = 0;
    }

    public static void LogDeviceInfo() {
        Log.i("device", "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Android AudioEffect AEC: ");
        sb2.append(AcousticEchoCanceler.isAvailable());
        sb2.append(", AGC: ");
        sb2.append(AutomaticGainControl.isAvailable());
        sb2.append(", NS: ");
        sb2.append(NoiseSuppressor.isAvailable());
        Log.i("device", sb2.toString());
    }

    private static native void OnAudioDeviceInited(long j10, int i10, boolean z10);

    private static native void OnAudioFocusChange(long j10, int i10);

    private static native void OnAudioRouteChanged(long j10, int i10);

    private static native void OnAudioVolumeChanged(long j10, int i10);

    private static native void OnInterruptionBegin(long j10);

    private static native void OnInterruptionEnd(long j10);

    public void AttemptToBluetoothSco() {
        int i10 = Build.VERSION.SDK_INT;
        AudioManager audioManager = (AudioManager) this._context.getSystemService(PowerProfile.POWER_AUDIO);
        if (i10 < 31) {
            audioManager.stopBluetoothSco();
            audioManager.startBluetoothSco();
            return;
        }
        for (AudioDeviceInfo audioDeviceInfo : audioManager.getAvailableCommunicationDevices()) {
            if (audioDeviceInfo.getType() == 7) {
                audioManager.clearCommunicationDevice();
                audioManager.setCommunicationDevice(audioDeviceInfo);
                return;
            }
        }
    }

    public int CheckAudioRoute(int i10, boolean z10) {
        event_monitor_stc_.CheckAudioRoute(i10, z10);
        return 0;
    }

    public int CheckBluetoothSCO() {
        if (event_monitor_stc_.CheckBluetoothSCO()) {
            return 0;
        }
        AttemptToBluetoothSco();
        return 0;
    }

    public int CheckPermission() {
        return PermissionChecker.checkSelfPermission(this._context, "android.permission.RECORD_AUDIO") ? 1 : 0;
    }

    public int CheckPhoneState() {
        return event_monitor_stc_.CheckPhoneState();
    }

    public int DoCap(int i10) {
        try {
            return this._capDev.read(this._capBuf, i10);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int DoRnd(int i10) {
        try {
            this._rndBuf.rewind();
            ByteBuffer byteBuffer = this._rndBuf;
            byteBuffer.get(this._rndBufArray, 0, byteBuffer.capacity());
            AudioTrack audioTrack = this._rndDev;
            if (audioTrack != null) {
                return audioTrack.write(this._rndBufArray, 0, i10);
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int DuckUnpluginHeadsetWhenVoip() {
        event_monitor_stc_.DuckUnpluginHeadsetWhenVoip();
        return 0;
    }

    public int EnableHWKaraoke(int i10) {
        return this._Karaoke.EnableHWKaraoke(i10);
    }

    public int EnableMediaVolumeAntiRestrain(boolean z10) {
        event_monitor_stc_.no_duck_by_other = z10;
        Log.i("device", "EnableAntiRestrain:" + z10);
        return 0;
    }

    public int EnableVivoKaraoke(int i10) {
        return this._Karaoke.EnableVivoKaraoke(i10);
    }

    public int EnableXiaomiKaraoke(int i10) {
        return this._Karaoke.EnableXiaomiKaraoke(i10);
    }

    public int GetApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public int GetDeviceHardware() {
        return this._Karaoke.GetDeviceHardware();
    }

    public int GetDeviceManufacturer() {
        return this._Karaoke.GetDeviceManufacturer();
    }

    public int GetOutputFramePerBuffer() {
        return this._framesPerBuffer;
    }

    public int GetPlayoutSampleRate() {
        int i10 = this._NativeOutputSampleRate;
        AudioEventMonitor audioEventMonitor = event_monitor_stc_;
        if (3 != audioEventMonitor._mode) {
            return i10;
        }
        int i11 = audioEventMonitor.audio_route_;
        if (2 == i11 || 6 == i11) {
            return 16000;
        }
        return i10;
    }

    public int GetRecordingSampleRate() {
        return this._capSampleRate;
    }

    public int Init(long j10, boolean z10, boolean z11) {
        if (this._context == null) {
            return -1;
        }
        this._pthis = j10;
        int currentRoute = AudioDeviceHelper.getCurrentRoute(this._context, z11 ? 3 : 0);
        event_monitor_stc_.SetRoutInfo(currentRoute);
        OnAudioDeviceInited(this._pthis, currentRoute, false);
        event_monitor_stc_.SetEeventHandler(this);
        event_monitor_stc_.Init(this._context, z10);
        if (!event_monitor_stc_.IsInited()) {
            return -1;
        }
        this._audioManager = event_monitor_stc_.GetAudioManager();
        this._audioRouteChange = event_monitor_stc_.GetRouteChangeHandle();
        String property = this._audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property != null) {
            this._NativeOutputSampleRate = Integer.parseInt(property);
        }
        String property2 = this._audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        if (property2 != null) {
            this._framesPerBuffer = Integer.parseInt(property2);
        }
        this._capSampleRate = 32000;
        this._Karaoke = new KaraokeHelper(this._context, this._audioManager);
        boolean hasSystemFeature = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        boolean hasSystemFeature2 = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.pro");
        LogDeviceInfo();
        Log.i("device", "hasLowLatencyFeature:" + hasSystemFeature + ", hasProFeature:" + hasSystemFeature2 + ", OUTPUT_SAMPLE_RATE:" + this._NativeOutputSampleRate + ", OUTPUT_FRAMES_PER_BUFFER:" + this._framesPerBuffer);
        return 0;
    }

    public int InitCapDev(int i10) {
        AudioRecord audioRecord;
        if (this._capDev != null) {
            return 0;
        }
        int i11 = this._capProfile;
        if (!PermissionChecker.checkSelfPermission(this._context, "android.permission.RECORD_AUDIO")) {
            Log.w("device", "init cap no permission");
        }
        if (this._capProfile <= 1 && this._audio_source == 7) {
            i11 = 2;
        }
        int i12 = i10 == 2 ? 12 : 16;
        while (true) {
            int[] iArr = this._capSampleRateTable;
            if (i11 >= iArr.length) {
                return -1;
            }
            int i13 = iArr[i11];
            this._capSampleRate = i13;
            int minBufferSize = AudioRecord.getMinBufferSize(i13, i12, 2);
            if (minBufferSize <= 0) {
                Log.w("device", "init cap, mini buffer size(" + minBufferSize + ") <= 0 ");
            }
            int i14 = this._capSampleRate;
            int i15 = minBufferSize < i14 * i10 ? i14 * i10 : minBufferSize;
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    this._capDev = new AudioRecord.Builder().setAudioSource(this._audio_source).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(this._capSampleRate).setChannelMask(i12).build()).setBufferSizeInBytes(i15).build();
                } else {
                    this._capDev = new AudioRecord(this._audio_source, this._capSampleRate, i12, 2, i15);
                }
                audioRecord = this._capDev;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (audioRecord != null) {
                if (audioRecord.getState() == 1) {
                    if (this._audioRouteChange == null) {
                        return 0;
                    }
                    event_monitor_stc_.SetWaitSocFlag();
                    this._capDev.addOnRoutingChangedListener(this._audioRouteChange, (Handler) null);
                    return 0;
                }
                Log.w("device", "AudioRecord state is not AudioRecord.STATE_INITIALIZED\n");
                this._capDev.release();
                this._capDev = null;
                return 1;
            }
            i11++;
        }
    }

    public int InitRndDev(int i10, int i11, boolean z10) {
        if (this._rndDev != null) {
            return 0;
        }
        int i12 = i11 == 2 ? 12 : 16;
        int minBufferSize = AudioTrack.getMinBufferSize(i10, i12, 2) * 2;
        AudioTrack createAudioTrack = createAudioTrack(minBufferSize, i10, i12, z10);
        this._rndDev = createAudioTrack;
        if (createAudioTrack == null) {
            this._rndDev = createAudioTrack(minBufferSize, i10, i12, z10);
        }
        AudioTrack audioTrack = this._rndDev;
        if (audioTrack == null) {
            return -1;
        }
        AudioEventMonitor.AudioRoutChange audioRoutChange = this._audioRouteChange;
        if (audioRoutChange != null) {
            audioTrack.addOnRoutingChangedListener(audioRoutChange, (Handler) null);
        }
        return 0;
    }

    public int InitVivoKtvEnv() {
        return this._Karaoke.InitVivoKtvEnv(this._NativeOutputSampleRate);
    }

    public int InitXiaomiKtvEnv() {
        return this._Karaoke.InitXiaomiKtvEnv();
    }

    public boolean IsHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return IManufacturerDeviceInfo.OS_HARMONY.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public int LogRecordAudioEffect(int i10) {
        return 0;
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnAudioFocusChange(int i10) {
        if (this._pthis != 0) {
            OnAudioFocusChange(this._pthis, i10);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnAudioRouteChanged(int i10) {
        if (this._pthis != 0) {
            OnAudioVolumeChanged(this._stream_type);
            OnAudioRouteChanged(this._pthis, i10);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnAudioVolumeChanged(int i10) {
        if (i10 != this._stream_type || this._pthis == 0) {
            return;
        }
        OnAudioVolumeChanged(this._pthis, (int) (((this._audioManager.getStreamVolume(i10) / this._audioManager.getStreamMaxVolume(i10)) + 0.005f) * 100.0f));
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnInterruptionBegin() {
        if (this._pthis != 0) {
            OnInterruptionBegin(this._pthis);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnInterruptionEnd() {
        if (this._pthis != 0) {
            OnInterruptionEnd(this._pthis);
        }
    }

    @Override // com.zego.ve.AudioEventMonitor.IEventNotify
    public void OnRoutingChange() {
        if (this._pthis != 0) {
            OnAudioRouteChanged(this._pthis, -100);
        }
    }

    public int SetAudioSource(int i10) {
        this._audio_source = i10;
        return 0;
    }

    public int SetCapProfile(int i10) {
        this._capProfile = i10;
        return 0;
    }

    public int SetCaptureDevId(int i10) {
        if (Build.VERSION.SDK_INT < 23) {
            return 100;
        }
        int i11 = 1;
        AudioDeviceInfo[] devices = this._audioManager.getDevices(1);
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i13 >= devices.length) {
                i13 = -1;
                break;
            }
            if (i10 == devices[i13].getId()) {
                break;
            }
            i13++;
        }
        if (-1 != i13) {
            int type = devices[i13].getType();
            if (type == 7) {
                if (this._audioManager.isBluetoothScoOn()) {
                    this._capDev.stop();
                    this._capDev.setPreferredDevice(devices[i13]);
                    this._capDev.startRecording();
                } else {
                    i11 = 2;
                    i12 = type;
                }
            } else {
                this._capDev.stop();
                this._capDev.setPreferredDevice(devices[i13]);
                this._capDev.startRecording();
            }
            i12 = type;
            i11 = 0;
        } else {
            this._capDev.stop();
            this._capDev.setPreferredDevice(null);
            this._capDev.startRecording();
        }
        return (i12 << 16) | i11;
    }

    public int SetCustomMode(int i10) {
        return this._Karaoke.SetCustomMode(i10);
    }

    public int SetDuckConfig(boolean z10, int i10) {
        AudioEventMonitor audioEventMonitor = event_monitor_stc_;
        audioEventMonitor.duck_value_in_percent_ = i10;
        audioEventMonitor.duck_other_when_voip_ = z10;
        Log.i("device", "SetDuckConfig duck_others:" + z10 + " duck_percent:" + i10);
        return 0;
    }

    public int SetHWKaraokeReverbMode(int i10) {
        return this._Karaoke.SetHWKaraokeReverbMode(i10);
    }

    public int SetHWKaraokeVolume(int i10) {
        return this._Karaoke.SetHWKaraokeVolume(i10);
    }

    public int SetMode(int i10) {
        return event_monitor_stc_.SetMode(i10);
    }

    public int SetRenderDevId(int i10) {
        if (Build.VERSION.SDK_INT < 23) {
            return 100;
        }
        int i11 = 2;
        AudioDeviceInfo[] devices = this._audioManager.getDevices(2);
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i13 >= devices.length) {
                i13 = -1;
                break;
            }
            if (i10 == devices[i13].getId()) {
                break;
            }
            i13++;
        }
        if (-1 != i13) {
            int type = devices[i13].getType();
            if (type == 7) {
                if (this._audioManager.isBluetoothScoOn()) {
                    this._rndDev.stop();
                    this._rndDev.setPreferredDevice(devices[i13]);
                    this._rndDev.play();
                    i12 = type;
                    i11 = 0;
                }
                i12 = type;
            } else {
                if (type == 8) {
                    if (this._audioManager.isBluetoothScoOn()) {
                        i11 = 3;
                        i12 = type;
                    } else {
                        this._rndDev.stop();
                        this._rndDev.setPreferredDevice(devices[i13]);
                        this._rndDev.play();
                    }
                } else {
                    this._rndDev.stop();
                    this._rndDev.setPreferredDevice(devices[i13]);
                    this._rndDev.play();
                }
                i12 = type;
                i11 = 0;
            }
        } else {
            this._rndDev.stop();
            this._rndDev.setPreferredDevice(null);
            this._rndDev.play();
            i11 = 1;
        }
        return (i12 << 16) | i11;
    }

    public int SetStreamType(int i10) {
        this._stream_type = i10;
        OnAudioVolumeChanged(i10);
        return 0;
    }

    public int SetThreadUrgentPriority() {
        try {
            Process.setThreadPriority(-19);
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int SetVivoKaraokeVolume(int i10) {
        return this._Karaoke.SetVivoKaraokeVolume(i10);
    }

    public int SetXiaomiKaraokeVolume(int i10) {
        return this._Karaoke.SetXiaomiKaraokeVolume(i10);
    }

    public int StartCapDev() {
        AudioRecord audioRecord = this._capDev;
        if (audioRecord == null) {
            return -1;
        }
        try {
            audioRecord.startRecording();
            if (this._capDev.getRecordingState() != 3) {
                return -3;
            }
            LogRecordAudioEffect(this._capDev.getAudioSessionId());
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2;
        }
    }

    public int StartRndDev() {
        AudioTrack audioTrack = this._rndDev;
        if (audioTrack == null) {
            return -1;
        }
        try {
            audioTrack.play();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public int StopCapDev() {
        try {
            this._capDev.stop();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int StopModule() {
        this._pthis = 0L;
        event_monitor_stc_.SetEeventHandler(null);
        try {
            event_monitor_stc_.SetMode(0);
            event_monitor_stc_.SetBluetoothScoOn(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this._audioRouteChange = null;
        this._Karaoke = null;
        this._audioManager = null;
        return 0;
    }

    public int StopRndDev() {
        try {
            this._rndDev.stop();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int SupportHWKaraokeLowlatency() {
        return this._Karaoke.SupportHWKaraokeLowlatency();
    }

    public int SupportVivoKaraokeLowlatency() {
        return this._Karaoke.SupportVivoKaraokeLowlatency();
    }

    public int SupportXiaomiKaraokeLowlatency() {
        return this._Karaoke.SupportXiaomiKaraokeLowlatency();
    }

    public int UninitCapDev() {
        AudioRecord audioRecord = this._capDev;
        if (audioRecord == null) {
            return 0;
        }
        try {
            AudioEventMonitor.AudioRoutChange audioRoutChange = this._audioRouteChange;
            if (audioRoutChange != null) {
                audioRecord.removeOnRoutingChangedListener(audioRoutChange);
            }
            this._capDev.release();
            this._capDev = null;
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int UninitHWKtvEnv() {
        return this._Karaoke.UninitHWKtvEnv();
    }

    public int UninitRndDev() {
        AudioTrack audioTrack = this._rndDev;
        if (audioTrack == null) {
            return 0;
        }
        try {
            AudioEventMonitor.AudioRoutChange audioRoutChange = this._audioRouteChange;
            if (audioRoutChange != null) {
                audioTrack.removeOnRoutingChangedListener(audioRoutChange);
            }
            this._rndDev.release();
            this._rndDev = null;
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int UninitVivoKtvEnv() {
        return this._Karaoke.UninitVivoKtvEnv();
    }

    public int UninitXiaomiKtvEnv() {
        return this._Karaoke.UninitXiaomiKtvEnv();
    }

    public AudioTrack createAudioTrack(int i10, int i11, int i12, boolean z10) {
        AudioTrack audioTrack;
        int i13;
        int i14;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                int i15 = z10 ? 1 : 0;
                if (3 == this._stream_type) {
                    i13 = 1;
                    i14 = 2;
                } else {
                    i13 = 2;
                    i14 = 1;
                }
                audioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(i13).setContentType(i14).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(i11).setChannelMask(i12).build()).setTransferMode(1).setBufferSizeInBytes(i10).setSessionId(0).setPerformanceMode(i15).build();
                try {
                    audioTrack.setBufferSizeInFrames((((i11 * 10) * (12 == i12 ? 2 : 1)) * 2) / 1000);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (audioTrack != null) {
                        audioTrack.release();
                        return null;
                    }
                    return audioTrack;
                }
            } else {
                audioTrack = new AudioTrack(this._stream_type, i11, i12, 2, i10, 1);
            }
        } catch (Exception e10) {
            e = e10;
            audioTrack = null;
        }
        if (audioTrack.getState() == 1) {
            return audioTrack;
        }
        audioTrack.release();
        return null;
    }

    public void setEQParams(int i10) {
        this._Karaoke.setEQParams(i10);
    }

    public void setReverbParams(int i10) {
        this._Karaoke.setReverbParams(i10);
    }
}

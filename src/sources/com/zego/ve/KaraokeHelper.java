package com.zego.ve;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import com.alipay.sdk.data.a;
import com.hailiang.advlib.core.ADEvent;
import java.util.StringTokenizer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class KaraokeHelper {
    public static final int MODE_CUSTOM_3DDRAEMY = 6;
    public static final int MODE_CUSTOM_AIRY = 4;
    public static final int MODE_CUSTOM_ATTRACTIVE = 3;
    public static final int MODE_CUSTOM_DISTANT = 5;
    public static final int MODE_CUSTOM_GRAMOPHONE = 7;
    public static final int MODE_CUSTOM_KTV = 1;
    public static final int MODE_CUSTOM_NOEFFECT = 8;
    public static final int MODE_CUSTOM_RECSTUDIO = 0;
    public static final int MODE_CUSTOM_WARM = 2;
    private static final String TAG = "device";
    private static final String TAG_ECHO_ENABLE = "vivo_ktv_echo_enable";
    private static final String TAG_MEQ_BAND_1 = "vivo_ktv_miceq_band1";
    private static final String TAG_MEQ_BAND_2 = "vivo_ktv_miceq_band2";
    private static final String TAG_MEQ_BAND_3 = "vivo_ktv_miceq_band3";
    private static final String TAG_MEQ_BAND_4 = "vivo_ktv_miceq_band4";
    private static final String TAG_MEQ_BAND_5 = "vivo_ktv_miceq_band5";
    private static final String TAG_RB_DAMP = "vivo_ktv_rb_damp";
    private static final String TAG_RB_DRY = "vivo_ktv_rb_dry";
    private static final String TAG_RB_GAIN = "vivo_ktv_rb_gain";
    private static final String TAG_RB_ROOMSIZE = "vivo_ktv_rb_roomsize";
    private static final String TAG_RB_WET = "vivo_ktv_rb_wet";
    private static final String TAG_RB_WIDTH = "vivo_ktv_rb_width";
    public AudioManager _audioManager;
    public Context _context;
    public int _deviceHardware;
    public int _deviceManufacturer;
    private static final int[][] ReverbCustomParams = {new int[]{200, 1000, 500, 4500, 1000, 1500}, new int[]{5000, 4500, 1200, 4500, 6500, 1200}, new int[]{4500, 8000, 1000, 4000, 6500, 1500}, new int[]{2500, 3000, 1500, 4000, 5000, 1500}, new int[]{a.f4564a, 5500, 1500, 5000, 5500, 1500}, new int[]{4000, 3000, 1000, 2500, 5500, 1200}, new int[]{500, 5000, 800, 4500, 3000, 1200}, new int[]{20, 500, 60, 4500, 5000, 1500}, new int[]{0, 0, 0, 4000, 0, 1200}};
    private static final int[][] EQCustomGain = {new int[]{0, 0, 0, 2, 2}, new int[]{0, 0, 0, 0, 0}, new int[]{3, 4, 2, 0, -3}, new int[]{3, 2, 0, 0, 2}, new int[]{3, 2, 0, -1, -3}, new int[]{2, 2, 2, 0, 0}, new int[]{5, 2, -2, 1, 3}, new int[]{-2, 0, 1, 2, 1}, new int[]{0, 0, 0, 0, 0}};
    public HwAudioKit _hwAudioKit = null;
    public SilentPlayer _silentPlayer = null;
    public boolean _initVivoKtv = false;
    public boolean _initXiaomiKtv = false;
    public int _volume = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class SilentPlayer {
        private PlaybackThread mPlaybackThread;
        private int mSampleRate;
        private int mChannelConfig = 12;
        private int mAudioFormat = 2;
        private boolean mIsPlaying = false;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class PlaybackThread extends Thread {
            private boolean isStop = false;

            public PlaybackThread() {
            }

            public synchronized void closeThread() {
                this.isStop = true;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int minBufferSize = AudioTrack.getMinBufferSize(SilentPlayer.this.mSampleRate, SilentPlayer.this.mChannelConfig, SilentPlayer.this.mAudioFormat);
                AudioTrack audioTrack = new AudioTrack(3, SilentPlayer.this.mSampleRate, SilentPlayer.this.mChannelConfig, SilentPlayer.this.mAudioFormat, minBufferSize, 1);
                if (audioTrack.getState() == 1) {
                    audioTrack.play();
                    byte[] bArr = new byte[minBufferSize];
                    for (int i10 = 0; i10 < minBufferSize; i10++) {
                        bArr[i10] = 0;
                    }
                    while (!this.isStop && !isInterrupted()) {
                        try {
                            audioTrack.write(bArr, 0, minBufferSize);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    audioTrack.stop();
                    audioTrack.flush();
                }
                audioTrack.release();
            }
        }

        public SilentPlayer(int i10) {
            this.mSampleRate = i10;
        }

        public boolean isPlaying() {
            return this.mIsPlaying;
        }

        public void play() {
            if (!this.mIsPlaying && this.mPlaybackThread == null) {
                this.mIsPlaying = true;
                PlaybackThread playbackThread = new PlaybackThread();
                this.mPlaybackThread = playbackThread;
                playbackThread.start();
            }
        }

        public void stop() {
            PlaybackThread playbackThread = this.mPlaybackThread;
            if (playbackThread != null) {
                this.mIsPlaying = false;
                playbackThread.closeThread();
                try {
                    this.mPlaybackThread.join(200L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.mPlaybackThread = null;
            }
        }
    }

    public KaraokeHelper(Context context, AudioManager audioManager) {
        this._deviceManufacturer = 0;
        this._deviceHardware = 0;
        this._context = context;
        this._audioManager = audioManager;
        String str = Build.MANUFACTURER;
        if ("HUAWEI".equalsIgnoreCase(str)) {
            this._deviceManufacturer = 1;
        } else if (ADEvent.VIVO.equalsIgnoreCase(str)) {
            this._deviceManufacturer = 2;
        } else if ("OPPO".equalsIgnoreCase(str)) {
            this._deviceManufacturer = 3;
        } else if ("Xiaomi".equalsIgnoreCase(str)) {
            this._deviceManufacturer = 4;
        } else if ("Google".equalsIgnoreCase(str)) {
            this._deviceManufacturer = 5;
        } else if ("samsung".equalsIgnoreCase(str)) {
            this._deviceManufacturer = 6;
        } else if ("HONOR".equalsIgnoreCase(str)) {
            this._deviceManufacturer = 7;
        }
        String str2 = Build.HARDWARE;
        if (str2.trim().contains("qcom")) {
            this._deviceHardware = 1;
            return;
        }
        if (str2.trim().contains("mt")) {
            this._deviceHardware = 2;
        } else if (str2.trim().contains("kirin")) {
            this._deviceHardware = 3;
        } else if (str2.trim().contains("exynos")) {
            this._deviceHardware = 4;
        }
    }

    public int EnableHWKaraoke(int i10) {
        HwAudioKit hwAudioKit = this._hwAudioKit;
        if (hwAudioKit == null) {
            return -1;
        }
        if (!hwAudioKit.isFeatureKaraokeOn()) {
            this._hwAudioKit.destroy();
            this._hwAudioKit = null;
            HwAudioKit hwAudioKit2 = new HwAudioKit(this._context);
            this._hwAudioKit = hwAudioKit2;
            hwAudioKit2.initialize();
            this._hwAudioKit.createFeatureKaraoke();
        }
        int enableKaraokeFeature = this._hwAudioKit.enableKaraokeFeature(i10 == 1);
        Log.i("device", "EnableHWKaraoke:" + i10 + " result:" + enableKaraokeFeature);
        return enableKaraokeFeature;
    }

    public int EnableVivoKaraoke(int i10) {
        if (!this._initVivoKtv) {
            return -1;
        }
        AudioManager audioManager = this._audioManager;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vivo_ktv_play_source=");
        sb2.append(i10 == 0 ? "0" : "1");
        audioManager.setParameters(sb2.toString());
        return 0;
    }

    public int EnableXiaomiKaraoke(int i10) {
        if (!this._initXiaomiKtv) {
            return -1;
        }
        this._audioManager.setParameters("audio_karaoke_enable=" + i10);
        if (i10 != 1) {
            return 0;
        }
        this._audioManager.setParameters("audio_karaoke_volume=" + this._volume);
        this._audioManager.setParameters("audio_karaoke_EQ=0");
        this._audioManager.setParameters("audio_karaoke_Reverb=0");
        return 0;
    }

    public int GetDeviceHardware() {
        return this._deviceHardware;
    }

    public int GetDeviceManufacturer() {
        return this._deviceManufacturer;
    }

    public int InitVivoKtvEnv(int i10) {
        this._audioManager.setParameters("vivo_ktv_play_source=1");
        this._audioManager.setParameters("vivo_ktv_mode=1");
        this._audioManager.setParameters("vivo_ktv_rec_source=0");
        if (this._silentPlayer == null) {
            this._silentPlayer = new SilentPlayer(i10);
        }
        SilentPlayer silentPlayer = this._silentPlayer;
        if (silentPlayer != null && !silentPlayer.isPlaying()) {
            this._silentPlayer.play();
        }
        this._initVivoKtv = true;
        return 0;
    }

    public int InitXiaomiKtvEnv() {
        this._audioManager.setParameters("audio_karaoke_ktvmode=enable");
        this._audioManager.setParameters("audio_karaoke_volume=8");
        this._audioManager.setParameters("audio_karaoke_EQ=0");
        this._audioManager.setParameters("audio_karaoke_Reverb=0");
        this._audioManager.setParameters("audio_karaoke_enable=1");
        this._initXiaomiKtv = true;
        this._volume = 8;
        return 0;
    }

    public int SetCustomMode(int i10) {
        setReverbParams(i10);
        setEQParams(i10);
        return 0;
    }

    public int SetHWKaraokeReverbMode(int i10) {
        HwAudioKit hwAudioKit = this._hwAudioKit;
        if (hwAudioKit == null) {
            return 0;
        }
        hwAudioKit.setKaraokeReverbMode(i10);
        return 0;
    }

    public int SetHWKaraokeVolume(int i10) {
        HwAudioKit hwAudioKit = this._hwAudioKit;
        if (hwAudioKit == null) {
            return 0;
        }
        hwAudioKit.setKaraokeVolume(i10);
        return 0;
    }

    public int SetVivoKaraokeVolume(int i10) {
        if (!this._initVivoKtv) {
            return 0;
        }
        int i11 = i10 / 6;
        if (i11 > 15) {
            i11 = 15;
        }
        this._audioManager.setParameters("vivo_ktv_volume_mic=" + i11);
        return 0;
    }

    public int SetXiaomiKaraokeVolume(int i10) {
        if (!this._initXiaomiKtv) {
            return 0;
        }
        int i11 = i10 / 6;
        if (i11 > 15) {
            i11 = 15;
        }
        this._audioManager.setParameters("audio_karaoke_volume=" + i11);
        this._volume = i11;
        return 0;
    }

    public int SupportHWKaraokeLowlatency() {
        if (Build.VERSION.SDK_INT >= 29) {
            HwAudioKit hwAudioKit = new HwAudioKit(this._context);
            this._hwAudioKit = hwAudioKit;
            if (!hwAudioKit.initialize()) {
                this._hwAudioKit.destroy();
                this._hwAudioKit = null;
                return -1;
            }
            if (!this._hwAudioKit.createFeatureKaraoke()) {
                this._hwAudioKit.destroy();
                this._hwAudioKit = null;
                return -1;
            }
        }
        HwAudioKit hwAudioKit2 = this._hwAudioKit;
        if (hwAudioKit2 == null || !hwAudioKit2.isFeatureKaraokeOn()) {
            return ("true".equals(this._audioManager.getProperty("android.media.property.SUPPORT_HWKARAOKE_EFFECT")) && this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency")) ? 0 : -1;
        }
        return 1;
    }

    public int SupportVivoKaraokeLowlatency() {
        int parseInt;
        StringTokenizer stringTokenizer = new StringTokenizer(this._audioManager.getParameters("vivo_ktv_mic_type"), "=");
        if (stringTokenizer.countTokens() == 2 && stringTokenizer.nextToken().equals("vivo_ktv_mic_type") && ((parseInt = Integer.parseInt(stringTokenizer.nextToken())) == 1 || parseInt == 0)) {
            return Build.VERSION.SDK_INT >= 27 ? 0 : 1;
        }
        return -1;
    }

    public int SupportXiaomiKaraokeLowlatency() {
        return this._audioManager.getParameters("audio_karaoke_support").contains("true") ? 0 : -1;
    }

    public int UninitHWKtvEnv() {
        HwAudioKit hwAudioKit;
        if (this._deviceManufacturer == 1 && (hwAudioKit = this._hwAudioKit) != null) {
            hwAudioKit.enableKaraokeFeature(false);
            this._hwAudioKit.destroy();
            this._hwAudioKit = null;
        }
        return 0;
    }

    public int UninitVivoKtvEnv() {
        if (this._initVivoKtv) {
            SilentPlayer silentPlayer = this._silentPlayer;
            if (silentPlayer != null) {
                silentPlayer.stop();
                this._silentPlayer = null;
            }
            this._initVivoKtv = false;
            this._audioManager.setParameters("vivo_ktv_mode=0");
        }
        return 0;
    }

    public int UninitXiaomiKtvEnv() {
        if (this._initXiaomiKtv) {
            this._initXiaomiKtv = false;
            this._audioManager.setParameters("audio_karaoke_ktvmode=disable");
        }
        return 0;
    }

    public void setEQParams(int i10) {
        AudioManager audioManager = this._audioManager;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vivo_ktv_miceq_band1=");
        int[][] iArr = EQCustomGain;
        sb2.append(iArr[i10][0] + 8);
        audioManager.setParameters(sb2.toString());
        this._audioManager.setParameters("vivo_ktv_miceq_band2=" + (iArr[i10][1] + 8));
        this._audioManager.setParameters("vivo_ktv_miceq_band3=" + (iArr[i10][2] + 8));
        this._audioManager.setParameters("vivo_ktv_miceq_band4=" + (iArr[i10][3] + 8));
        this._audioManager.setParameters("vivo_ktv_miceq_band5=" + (iArr[i10][4] + 8));
    }

    public void setReverbParams(int i10) {
        AudioManager audioManager = this._audioManager;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vivo_ktv_rb_roomsize=");
        int[][] iArr = ReverbCustomParams;
        sb2.append(iArr[i10][0]);
        audioManager.setParameters(sb2.toString());
        this._audioManager.setParameters("vivo_ktv_rb_damp=" + iArr[i10][1]);
        this._audioManager.setParameters("vivo_ktv_rb_wet=" + iArr[i10][2]);
        this._audioManager.setParameters("vivo_ktv_rb_dry=" + iArr[i10][3]);
        this._audioManager.setParameters("vivo_ktv_rb_width=" + iArr[i10][4]);
        this._audioManager.setParameters("vivo_ktv_rb_gain=" + iArr[i10][5]);
        this._audioManager.setParameters("vivo_ktv_echo_enable=0");
    }
}

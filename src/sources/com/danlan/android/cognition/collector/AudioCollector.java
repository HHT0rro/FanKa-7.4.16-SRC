package com.danlan.android.cognition.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.util.Arrays;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AudioCollector extends SubCollector {
    private AudioManager audioManager;
    private Context mcontext;

    public AudioCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.audioManager = null;
        this.mcontext = context;
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("SFBpSkJRS3FJTEpGclZUUU5RUA=="), hasMicroPhoneSupport());
            safeJSONObject.put(StringFog.decrypt("SFBpSkJRS3FJTEpGYFVFSE1CRk9E"), isMicroPhoneAvailable());
            safeJSONObject.put(StringFog.decrypt("SFBpVlJKR2BCV01VRA=="), isMusicActive());
            safeJSONObject.put(StringFog.decrypt("U0pKRERRaU5FRg=="), getRingerMode());
            safeJSONObject.put(StringFog.decrypt("QFZASk51S01UTkE="), getAudioVolume());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("QFZASk4="), safeJSONObject);
        collectDone();
    }

    public final JSONArray getAudioDeviceInfo() {
        JSONArray jSONArray = new JSONArray();
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) this.mcontext.getSystemService(StringFog.decrypt("QFZASk4="));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            for (AudioDeviceInfo audioDeviceInfo : this.audioManager.getDevices(3)) {
                SafeJSONObject safeJSONObject = new SafeJSONObject();
                safeJSONObject.put(StringFog.decrypt("UVFLR1RAUG9ATkE="), audioDeviceInfo.getProductName());
                safeJSONObject.put(StringFog.decrypt("SEc="), audioDeviceInfo.getId());
                safeJSONObject.put(StringFog.decrypt("VVpURg=="), audioDeviceInfo.getType());
                safeJSONObject.put(StringFog.decrypt("UkJJU01GdkBVRlc="), Arrays.toString(audioDeviceInfo.getSampleRates()));
                jSONArray.put(safeJSONObject);
            }
        }
        return jSONArray;
    }

    public final SafeJSONObject getAudioVolume() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        if (this.audioManager == null) {
            this.audioManager = (AudioManager) this.mcontext.getSystemService(StringFog.decrypt("QFZASk4="));
        }
        if (this.audioManager == null) {
            return safeJSONObject;
        }
        SafeJSONObject safeJSONObject2 = new SafeJSONObject();
        try {
            int streamVolume = this.audioManager.getStreamVolume(0);
            int streamMaxVolume = this.audioManager.getStreamMaxVolume(0);
            int streamMinVolume = Build.VERSION.SDK_INT >= 28 ? this.audioManager.getStreamMinVolume(0) : 0;
            safeJSONObject2.put(StringFog.decrypt("QlZWUURNUH5XTEhWTEY="), streamVolume);
            safeJSONObject2.put(StringFog.decrypt("TEJcfFdMSFRMRg=="), streamMaxVolume);
            safeJSONObject2.put(StringFog.decrypt("TEpKfFdMSFRMRg=="), streamMinVolume);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        SafeJSONObject safeJSONObject3 = new SafeJSONObject();
        try {
            int streamVolume2 = this.audioManager.getStreamVolume(3);
            int streamMaxVolume2 = this.audioManager.getStreamMaxVolume(3);
            int streamMinVolume2 = Build.VERSION.SDK_INT >= 28 ? this.audioManager.getStreamMinVolume(3) : 0;
            safeJSONObject3.put(StringFog.decrypt("QlZWUURNUH5XTEhWTEY="), streamVolume2);
            safeJSONObject3.put(StringFog.decrypt("TEJcfFdMSFRMRg=="), streamMaxVolume2);
            safeJSONObject3.put(StringFog.decrypt("TEpKfFdMSFRMRg=="), streamMinVolume2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        SafeJSONObject safeJSONObject4 = new SafeJSONObject();
        try {
            int streamVolume3 = this.audioManager.getStreamVolume(2);
            int streamMaxVolume3 = this.audioManager.getStreamMaxVolume(2);
            int streamMinVolume3 = Build.VERSION.SDK_INT >= 28 ? this.audioManager.getStreamMinVolume(2) : 0;
            safeJSONObject4.put(StringFog.decrypt("QlZWUURNUH5XTEhWTEY="), streamVolume3);
            safeJSONObject4.put(StringFog.decrypt("TEJcfFdMSFRMRg=="), streamMaxVolume3);
            safeJSONObject4.put(StringFog.decrypt("TEpKfFdMSFRMRg=="), streamMinVolume3);
        } catch (Exception unused) {
        }
        safeJSONObject.put(StringFog.decrypt("V0xNQEQ="), safeJSONObject2);
        safeJSONObject.put(StringFog.decrypt("TFZXSkI="), safeJSONObject3);
        safeJSONObject.put(StringFog.decrypt("U0pKRA=="), safeJSONObject4);
        return safeJSONObject;
    }

    public final String getRingerMode() {
        try {
            if (this.audioManager == null) {
                this.audioManager = (AudioManager) this.mcontext.getSystemService(StringFog.decrypt("QFZASk4="));
            }
            int ringerMode = this.audioManager.getRingerMode();
            return ringerMode != 0 ? ringerMode != 1 ? ringerMode != 2 ? StringFog.decrypt("VE1PTE9MUw==") : StringFog.decrypt("T0xWTkBP") : StringFog.decrypt("V0pGUUBXQQ==") : StringFog.decrypt("UkpIRk9X");
        } catch (Exception unused) {
            return StringFog.decrypt("VE1PTE9MUw==");
        }
    }

    public final boolean hasMicroPhoneSupport() {
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager != null) {
            return packageManager.hasSystemFeature(StringFog.decrypt("QE1AUU5KQA9JQlZHVkJWRA9OTUBTTFRJTk1B"));
        }
        return false;
    }

    public final boolean isMicroPhoneAvailable() {
        try {
            if (this.audioManager == null) {
                this.audioManager = (AudioManager) this.mcontext.getSystemService(StringFog.decrypt("QFZASk4="));
            }
        } catch (Exception unused) {
        }
        return this.audioManager.getMode() == 0;
    }

    public final boolean isMusicActive() {
        try {
            if (this.audioManager == null) {
                this.audioManager = (AudioManager) this.mcontext.getSystemService(StringFog.decrypt("QFZASk4="));
            }
            return this.audioManager.isMusicActive();
        } catch (Exception unused) {
            return false;
        }
    }
}

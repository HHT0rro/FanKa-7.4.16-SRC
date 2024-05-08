package com.zego.zegoavkit2.audioaux;

import com.zego.zegoavkit2.audioaux.ZegoAudioAuxJNI;
import com.zego.zegoavkit2.entities.AuxDataEx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioAux implements ZegoAudioAuxJNI.IJniZegoAuxCallback {
    private IZegoAudioAuxCallbackEx mZegoAudioAuxCallbackEx = null;

    public boolean enableAux(boolean z10) {
        return ZegoAudioAuxJNI.enableAux(z10);
    }

    public boolean muteAux(boolean z10) {
        return ZegoAudioAuxJNI.muteAux(z10);
    }

    @Override // com.zego.zegoavkit2.audioaux.ZegoAudioAuxJNI.IJniZegoAuxCallback
    public AuxDataEx onAuxCallback(int i10) {
        IZegoAudioAuxCallbackEx iZegoAudioAuxCallbackEx = this.mZegoAudioAuxCallbackEx;
        if (iZegoAudioAuxCallbackEx != null) {
            return iZegoAudioAuxCallbackEx.onAuxCallback(i10);
        }
        return null;
    }

    public void setAuxPlayVolume(int i10) {
        ZegoAudioAuxJNI.setAuxPlayVolume(i10);
    }

    public void setAuxPublishVolume(int i10) {
        ZegoAudioAuxJNI.setAuxPublishVolume(i10);
    }

    public void setAuxVolume(int i10) {
        ZegoAudioAuxJNI.setAuxVolume(i10);
    }

    public void setZegoAuxCallbackEx(IZegoAudioAuxCallbackEx iZegoAudioAuxCallbackEx) {
        this.mZegoAudioAuxCallbackEx = iZegoAudioAuxCallbackEx;
        if (iZegoAudioAuxCallbackEx != null) {
            ZegoAudioAuxJNI.setCallback(this);
        } else {
            ZegoAudioAuxJNI.setCallback(null);
        }
    }
}

package com.zego.zegoavkit2.mixstream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoStreamMixer {
    public static final String NON_EXIST_STREAM_ID_KEY = "NonExists";
    public static final String SEQ_KEY = "ReqSeq";

    public boolean mixStream(ZegoCompleteMixStreamInfo zegoCompleteMixStreamInfo, int i10) {
        return ZegoMixStreamJNI.mixStream(zegoCompleteMixStreamInfo, i10);
    }

    public int mixStreamEx(ZegoMixStreamConfig zegoMixStreamConfig, String str) {
        int i10;
        String str2;
        String str3;
        if (str.length() == 0) {
            return -1;
        }
        ZegoMixStreamInfo[] zegoMixStreamInfoArr = zegoMixStreamConfig.inputStreamList;
        int i11 = 0;
        if (zegoMixStreamInfoArr != null && zegoMixStreamInfoArr.length > 0) {
            int i12 = 0;
            while (true) {
                ZegoMixStreamInfo[] zegoMixStreamInfoArr2 = zegoMixStreamConfig.inputStreamList;
                if (i12 >= zegoMixStreamInfoArr2.length) {
                    break;
                }
                ZegoMixStreamInfo zegoMixStreamInfo = zegoMixStreamInfoArr2[i12];
                if (zegoMixStreamInfo == null || (str3 = zegoMixStreamInfo.streamID) == null || str3.length() < 1 || zegoMixStreamInfo.streamID.length() > 1024) {
                    break;
                }
                i12++;
            }
            return -1;
        }
        ZegoMixStreamOutput[] zegoMixStreamOutputArr = zegoMixStreamConfig.outputList;
        if (zegoMixStreamOutputArr != null && zegoMixStreamOutputArr.length > 0) {
            while (true) {
                ZegoMixStreamOutput[] zegoMixStreamOutputArr2 = zegoMixStreamConfig.outputList;
                if (i11 >= zegoMixStreamOutputArr2.length) {
                    break;
                }
                ZegoMixStreamOutput zegoMixStreamOutput = zegoMixStreamOutputArr2[i11];
                if (zegoMixStreamOutput == null || (str2 = zegoMixStreamOutput.target) == null || str2.length() < 1 || zegoMixStreamOutput.target.length() >= 1024) {
                    break;
                }
                i11++;
            }
        }
        if (zegoMixStreamConfig.outputRateControlMode != 1 || ((i10 = zegoMixStreamConfig.outputQuality) >= 1 && i10 <= 51)) {
            return ZegoMixStreamJNI.mixStreamEx(zegoMixStreamConfig, str);
        }
        return -1;
    }

    public void setCallback(IZegoMixStreamCallback iZegoMixStreamCallback) {
        ZegoMixStreamJNI.setCallback(iZegoMixStreamCallback);
    }

    public void setMixStreamExCallback(IZegoMixStreamExCallback iZegoMixStreamExCallback) {
        ZegoMixStreamJNI.setMixStreamExCallback(iZegoMixStreamExCallback);
    }

    public void setRelayCDNStateCallback(IZegoMixStreamRelayCDNCallback iZegoMixStreamRelayCDNCallback) {
        ZegoMixStreamJNI.setRelayCDNCallback(iZegoMixStreamRelayCDNCallback);
    }

    public void setSoundLevelInMixStreamCallback(IZegoSoundLevelInMixStreamCallback iZegoSoundLevelInMixStreamCallback) {
        ZegoMixStreamJNI.setSoundLevelInMixStreamCallback(iZegoSoundLevelInMixStreamCallback);
    }
}

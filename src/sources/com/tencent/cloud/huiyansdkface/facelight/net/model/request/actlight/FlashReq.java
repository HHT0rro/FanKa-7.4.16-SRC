package com.tencent.cloud.huiyansdkface.facelight.net.model.request.actlight;

import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FlashReq {
    public String colorData;
    public YTImageInfo eyeImage;
    public YTImageInfo liveImage;
    public SelectData liveSelectData;
    public YTImageInfo mouthImage;
    public String platform = "2";
    public ReflectColorData reflectData;

    public String toString() {
        return "FlashReq{platform='" + this.platform + "', liveSelectData=" + ((Object) this.liveSelectData) + ", colorData='" + this.colorData + "', reflectData=" + ((Object) this.reflectData) + ", liveImage=" + ((Object) this.liveImage) + ", eyeImage=" + ((Object) this.eyeImage) + ", mouthImage=" + ((Object) this.mouthImage) + '}';
    }
}

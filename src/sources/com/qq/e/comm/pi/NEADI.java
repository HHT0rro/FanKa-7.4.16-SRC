package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface NEADI extends ADI {
    String getAdNetWorkName();

    void loadAd(int i10);

    void loadAd(int i10, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i10);

    void setMinVideoDuration(int i10);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);
}

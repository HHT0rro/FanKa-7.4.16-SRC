package com.huawei.quickcard.video.view;

import com.huawei.quickcard.framework.border.BorderRadius;
import com.huawei.quickcard.video.processor.IVideoEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IVideoHost {
    void setAutoGoOnLength(int i10);

    void setAutoPlay(boolean z10);

    void setAutoStopLength(int i10);

    void setBlockAutoContinuePlay(boolean z10);

    void setBorderRadius(BorderRadius borderRadius);

    void setControls(boolean z10);

    void setErrorListener(IVideoEvent iVideoEvent);

    void setFinishListener(IVideoEvent iVideoEvent);

    void setFullScreenChangeListener(IVideoEvent iVideoEvent);

    void setFullScreenEnable(boolean z10);

    void setIdleListener(IVideoEvent iVideoEvent);

    void setMultiPlayEnable(boolean z10);

    void setMuted(boolean z10);

    void setNetworkChangeListener(IVideoEvent iVideoEvent);

    void setObjectFit(String str);

    void setOrientation(String str);

    void setPauseListener(IVideoEvent iVideoEvent);

    void setPlayingListener(IVideoEvent iVideoEvent);

    void setPoster(String str);

    void setPreparedListener(IVideoEvent iVideoEvent);

    void setSeekedListener(IVideoEvent iVideoEvent);

    void setSeekingListener(IVideoEvent iVideoEvent);

    void setStartListener(IVideoEvent iVideoEvent);

    void setTimeupdateListener(IVideoEvent iVideoEvent);

    void setTitle(String str);

    void setTitleBar(boolean z10);

    void setVideoDir(int i10);

    void setVideoURI(String str);
}

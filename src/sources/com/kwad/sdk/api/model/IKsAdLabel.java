package com.kwad.sdk.api.model;

import androidx.annotation.Keep;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IKsAdLabel {
    @Keep
    String getChannel();

    @Keep
    long getCpmBidFloor();

    @Keep
    String getHistoryTitle();

    @Keep
    String getPostTitle();

    @Keep
    String getPrevTitle();

    @Keep
    int getThirdAge();

    @Keep
    int getThirdGender();

    @Keep
    String getThirdInterest();

    @Keep
    void setChannel(String str);

    @Keep
    void setCpmBidFloor(long j10);

    @Keep
    void setHistoryTitle(String str);

    @Keep
    void setPostTitle(String str);

    @Keep
    void setPrevTitle(String str);

    @Keep
    void setThirdAge(int i10);

    @Keep
    void setThirdGender(int i10);

    @Keep
    void setThirdInterest(String str);
}

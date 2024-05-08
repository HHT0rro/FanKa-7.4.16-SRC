package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILiveProvider;
import com.bytedance.android.live.base.api.outer.data.OpenUserInfo;
import com.bytedance.android.live.base.api.push.ILivePush;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IOuterLiveRoomService {
    void addEventListener(IEventListener iEventListener);

    Object callExpandMethod(String str, Object... objArr);

    void enterRoomWithDraw();

    ILiveProvider getLiveProvider();

    ILivePush getPushService();

    OpenUserInfo getUserInfo();

    IBaseHorizontalLiveListView makeFollowListView(Context context, Bundle bundle, ILiveBorderAnimController iLiveBorderAnimController);

    void removeEventListener(IEventListener iEventListener);

    @Deprecated
    void setEventListener(IEventListener iEventListener);

    void setNeedPersonalRecommend(boolean z10);

    void setUseBlackNavigationBar(boolean z10);
}

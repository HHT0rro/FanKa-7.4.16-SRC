package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IFeedProvider extends IService {
    IBaseHorizontalLiveListView getFollowListView(Context context, Bundle bundle, ILiveBorderAnimController iLiveBorderAnimController);
}

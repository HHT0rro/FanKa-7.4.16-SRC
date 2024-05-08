package com.bytedance.android.live.base.api.outer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.api.outer.ILivePreviewLayout;
import com.bytedance.android.live.base.api.outer.data.RoomInfo;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILiveProvider {
    ILivePreviewLayout getILivePreviewLayout(ILivePreviewLayout.Builder builder);

    String getIdentity();

    ILiveView getLiveView(Context context, int i10, String str, boolean z10, Bundle bundle);

    List<RoomInfo> getRoomInfoList(int i10, int i11, int i12);

    IStandalonePreviewView makeStandalonePreviewView(Context context, int i10, Bundle bundle);

    void startLive(Context context, int i10, String str, Bundle bundle);
}

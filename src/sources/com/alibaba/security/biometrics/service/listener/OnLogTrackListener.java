package com.alibaba.security.biometrics.service.listener;

import android.os.Bundle;
import com.alibaba.security.common.track.model.TrackLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnLogTrackListener {
    void onLogTrack(TrackLog trackLog);

    void onOldLogRecord(Bundle bundle);
}

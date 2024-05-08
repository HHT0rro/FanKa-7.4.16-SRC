package com.huawei.quickcard.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.action.ActionsHelper;
import com.huawei.quickcard.framework.processor.EventProcessor;
import com.huawei.quickcard.video.VideoAttributes;
import com.huawei.quickcard.video.processor.IVideoEvent;
import com.huawei.quickcard.video.view.VideoHostView;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements EventProcessor<VideoHostView> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements IVideoEvent {

        /* renamed from: a, reason: collision with root package name */
        private final String f34358a;

        public a(String str) {
            this.f34358a = str;
        }

        @Override // com.huawei.quickcard.video.processor.IVideoEvent
        public void onCallback(VideoHostView videoHostView, @Nullable Map<String, Object> map) {
            ActionsHelper.doAction(videoHostView, this.f34358a, map);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void applyEvent(@NonNull VideoHostView videoHostView, String str, String str2) {
        if (videoHostView == null || str == null || str2 == null) {
            return;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1865705685:
                if (str.equals("fullscreenchange")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1279552451:
                if (str.equals(VideoAttributes.Event.PREPARED)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1274442605:
                if (str.equals("finish")) {
                    c4 = 2;
                    break;
                }
                break;
            case -906224361:
                if (str.equals(VideoAttributes.Event.SEEKED)) {
                    c4 = 3;
                    break;
                }
                break;
            case -493563858:
                if (str.equals(VideoAttributes.Event.PLAYING)) {
                    c4 = 4;
                    break;
                }
                break;
            case 3227604:
                if (str.equals(VideoAttributes.Event.IDLE)) {
                    c4 = 5;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    c4 = 6;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c4 = 7;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1665587398:
                if (str.equals(VideoAttributes.Event.NETWORK_CHANGED)) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1762557398:
                if (str.equals(VideoAttributes.Event.TIME_UPDATE)) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1971820138:
                if (str.equals(VideoAttributes.Event.SEEKING)) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                videoHostView.setFullScreenChangeListener(new a(str2));
                return;
            case 1:
                videoHostView.setPreparedListener(new a(str2));
                return;
            case 2:
                videoHostView.setFinishListener(new a(str2));
                return;
            case 3:
                videoHostView.setSeekedListener(new a(str2));
                return;
            case 4:
                videoHostView.setPlayingListener(new a(str2));
                return;
            case 5:
                videoHostView.setIdleListener(new a(str2));
                return;
            case 6:
                videoHostView.setErrorListener(new a(str2));
                return;
            case 7:
                videoHostView.setPauseListener(new a(str2));
                return;
            case '\b':
                videoHostView.setStartListener(new a(str2));
                return;
            case '\t':
                videoHostView.setNetworkChangeListener(new a(str2));
                return;
            case '\n':
                videoHostView.setTimeupdateListener(new a(str2));
                return;
            case 11:
                videoHostView.setSeekingListener(new a(str2));
                return;
            default:
                return;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.EventProcessor
    public /* synthetic */ void cleanEvent(VideoHostView videoHostView, String str) {
        com.huawei.quickcard.framework.processor.a.a(this, videoHostView, str);
    }
}

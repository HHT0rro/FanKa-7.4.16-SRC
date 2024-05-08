package com.huawei.quickcard.video.component;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.ui.Component;
import com.huawei.quickcard.video.VideoAttributes;
import com.huawei.quickcard.video.d;
import com.huawei.quickcard.video.processor.PosterRadiusStyle;
import com.huawei.quickcard.video.processor.VideoCommonAttribute;
import com.huawei.quickcard.video.processor.VideoDir;
import com.huawei.quickcard.video.processor.VideoFocusableProcessor;
import com.huawei.quickcard.video.view.VideoHostView;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Video extends Component<VideoHostView> {
    public Video() {
        VideoCommonAttribute videoCommonAttribute = new VideoCommonAttribute();
        addProcessor("src", videoCommonAttribute);
        addProcessor(VideoAttributes.Style.POSTER, videoCommonAttribute);
        addProcessor("autoplay", videoCommonAttribute);
        addProcessor("muted", videoCommonAttribute);
        addProcessor(VideoAttributes.Style.CONTROLS, videoCommonAttribute);
        addProcessor("objectFit", videoCommonAttribute);
        addProcessor("orientation", videoCommonAttribute);
        addProcessor(VideoAttributes.Style.TITLEBAR, videoCommonAttribute);
        addProcessor("title", videoCommonAttribute);
        addProcessor(VideoAttributes.Style.FULLSCREEN_ENABLE, videoCommonAttribute);
        addProcessor(VideoAttributes.Style.AUTO_STOP_LENGTH, videoCommonAttribute);
        addProcessor(VideoAttributes.Style.AUTO_GO_ON_LENGTH, videoCommonAttribute);
        addProcessor(VideoAttributes.Style.MULTI_PLAY_ENABLE, videoCommonAttribute);
        PosterRadiusStyle posterRadiusStyle = new PosterRadiusStyle();
        addProcessor(Attributes.Style.BORDER_RADIUS, posterRadiusStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_LEFT_RADIUS, posterRadiusStyle);
        addProcessor(Attributes.Style.BORDER_BOTTOM_RIGHT_RADIUS, posterRadiusStyle);
        addProcessor(Attributes.Style.BORDER_TOP_LEFT_RADIUS, posterRadiusStyle);
        addProcessor(Attributes.Style.BORDER_TOP_RIGHT_RADIUS, posterRadiusStyle);
        VideoDir videoDir = new VideoDir();
        addProcessor(Attributes.Style.DIR, videoDir);
        addProcessor("flexDirection", videoDir);
        addProcessor(Attributes.Style.FOCUSABLE, new VideoFocusableProcessor());
        d dVar = new d();
        addEventProcessor(VideoAttributes.Event.PREPARED, dVar);
        addEventProcessor("start", dVar);
        addEventProcessor(VideoAttributes.Event.PLAYING, dVar);
        addEventProcessor("pause", dVar);
        addEventProcessor("error", dVar);
        addEventProcessor("finish", dVar);
        addEventProcessor(VideoAttributes.Event.TIME_UPDATE, dVar);
        addEventProcessor(VideoAttributes.Event.SEEKING, dVar);
        addEventProcessor(VideoAttributes.Event.SEEKED, dVar);
        addEventProcessor("fullscreenchange", dVar);
        addEventProcessor(VideoAttributes.Event.NETWORK_CHANGED, dVar);
        addEventProcessor(VideoAttributes.Event.IDLE, dVar);
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    @NonNull
    public String getName() {
        return "video";
    }

    @Override // com.huawei.quickcard.framework.ui.Component
    public VideoHostView createViewImpl(Context context) {
        return new VideoHostView(context);
    }
}

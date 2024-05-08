package com.wangmai.common.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.widget.VideoView;
import java.lang.reflect.Field;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CustomVideoView extends VideoView {
    public int mVideoHeight;
    public int mVideoWidth;

    public CustomVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(VideoView.getDefaultSize(this.mVideoWidth, i10), VideoView.getDefaultSize(this.mVideoHeight, i11));
    }

    public void setVolume(float f10, VideoView videoView) {
        try {
            Field declaredField = Class.forName("android.widget.VideoView").getDeclaredField("mMediaPlayer");
            declaredField.setAccessible(true);
            MediaPlayer mediaPlayer = (MediaPlayer) declaredField.get(videoView);
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f10, f10);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public CustomVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

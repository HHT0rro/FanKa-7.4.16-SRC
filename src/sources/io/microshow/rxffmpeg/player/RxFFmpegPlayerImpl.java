package io.microshow.rxffmpeg.player;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RxFFmpegPlayerImpl extends RxFFmpegPlayer implements TextureView.SurfaceTextureListener {
    private static SurfaceTexture mSurfaceTexture;
    private WeakReference<TextureView> mWeakTextureView;

    private TextureView getTextureView() {
        TextureView textureView;
        WeakReference<TextureView> weakReference = this.mWeakTextureView;
        if (weakReference == null || (textureView = weakReference.get()) == null) {
            return null;
        }
        return textureView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        if (getTextureView() == null) {
            return;
        }
        if (mSurfaceTexture == null) {
            mSurfaceTexture = surfaceTexture;
            setSurface(new Surface(mSurfaceTexture));
        } else if (getTextureView() != null) {
            getTextureView().setSurfaceTexture(mSurfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void play(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        stop();
        setDataSource(str);
        setLooping(z10);
        setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerImpl.1
            @Override // io.microshow.rxffmpeg.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                RxFFmpegPlayerImpl.this.start();
            }
        });
        prepare();
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayer, io.microshow.rxffmpeg.player.IMediaPlayer
    public void release() {
        stop();
        super.release();
        SurfaceTexture surfaceTexture = mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            mSurfaceTexture = null;
        }
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setTextureView(TextureView textureView) {
        if (textureView != null) {
            this.mWeakTextureView = new WeakReference<>(textureView);
            textureView.setSurfaceTextureListener(this);
        }
    }
}

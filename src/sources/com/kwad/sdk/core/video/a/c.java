package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface c {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void av(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void oZ();
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0530c {
        boolean l(int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface d {
        boolean m(int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface e {
        void a(c cVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface f {
        void ry();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface g {
        void pa();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface h {
        void a(TimedText timedText);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface i {
        void k(int i10, int i11);
    }

    boolean FZ();

    void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar);

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0530c interfaceC0530c);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void a(i iVar);

    void b(e eVar);

    void c(d dVar);

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j10);

    void setAudioStreamType(int i10);

    void setDataSource(Context context, Uri uri);

    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z10);

    void setScreenOnWhilePlaying(boolean z10);

    void setSpeed(float f10);

    void setSurface(Surface surface);

    void setVolume(float f10, float f11);

    void start();

    void stop();
}

package com.huawei.quickcard.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.video.ITextureVideoView;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends TextureView implements ITextureVideoView {
    private static final String E = "TextureVideoView";
    private ITextureVideoView.VideoSurfaceTextureListener A;
    private ITextureVideoView.VideoStateListener B;
    private ITextureVideoView.AudioFocusListener C;
    private TextureView.SurfaceTextureListener D;

    /* renamed from: a, reason: collision with root package name */
    private final MediaPlayer.OnPreparedListener f34324a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaPlayer.OnVideoSizeChangedListener f34325b;

    /* renamed from: c, reason: collision with root package name */
    private final MediaPlayer.OnCompletionListener f34326c;

    /* renamed from: d, reason: collision with root package name */
    private final MediaPlayer.OnErrorListener f34327d;

    /* renamed from: e, reason: collision with root package name */
    private final MediaPlayer.OnInfoListener f34328e;

    /* renamed from: f, reason: collision with root package name */
    private final MediaPlayer.OnBufferingUpdateListener f34329f;

    /* renamed from: g, reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f34330g;

    /* renamed from: h, reason: collision with root package name */
    private String f34331h;

    /* renamed from: i, reason: collision with root package name */
    private int f34332i;

    /* renamed from: j, reason: collision with root package name */
    private int f34333j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34334k;

    /* renamed from: l, reason: collision with root package name */
    private SurfaceTexture f34335l;

    /* renamed from: m, reason: collision with root package name */
    private Surface f34336m;

    /* renamed from: n, reason: collision with root package name */
    private MediaPlayer f34337n;

    /* renamed from: o, reason: collision with root package name */
    private AudioManager f34338o;

    /* renamed from: p, reason: collision with root package name */
    private String f34339p;

    /* renamed from: q, reason: collision with root package name */
    private int f34340q;

    /* renamed from: r, reason: collision with root package name */
    private int f34341r;

    /* renamed from: s, reason: collision with root package name */
    private int f34342s;

    /* renamed from: t, reason: collision with root package name */
    private int f34343t;

    /* renamed from: u, reason: collision with root package name */
    private int f34344u;

    /* renamed from: v, reason: collision with root package name */
    private Map<String, String> f34345v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f34346w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f34347x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f34348y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f34349z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            c.this.f34332i = 2;
            c cVar = c.this;
            cVar.f34347x = cVar.f34348y = cVar.f34349z = true;
            if (c.this.B != null) {
                c.this.B.onPrepared();
            }
            c.this.f34340q = mediaPlayer.getVideoWidth();
            c.this.f34341r = mediaPlayer.getVideoHeight();
            if (c.this.f34342s != 0) {
                c cVar2 = c.this;
                cVar2.seekTo(cVar2.f34342s);
            }
            if (c.this.f34340q != 0 && c.this.f34341r != 0) {
                c.this.getSurfaceTexture().setDefaultBufferSize(c.this.f34340q, c.this.f34341r);
            }
            if (c.this.f34333j == 3) {
                c.this.start();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements MediaPlayer.OnVideoSizeChangedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            c.this.f34340q = mediaPlayer.getVideoWidth();
            c.this.f34341r = mediaPlayer.getVideoHeight();
            if (c.this.f34340q == 0 || c.this.f34341r == 0) {
                return;
            }
            c.this.getSurfaceTexture().setDefaultBufferSize(c.this.f34340q, c.this.f34341r);
            c.this.requestLayout();
        }
    }

    /* renamed from: com.huawei.quickcard.video.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class C0344c implements MediaPlayer.OnCompletionListener {
        public C0344c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            c.this.f34332i = 5;
            c.this.f34333j = 5;
            if (c.this.B != null) {
                c.this.B.onCompletion();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            c.this.f34332i = -1;
            c.this.f34333j = -1;
            if (c.this.B != null) {
                return c.this.B.onError(i10, i11);
            }
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class e implements MediaPlayer.OnInfoListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            if (i10 == 801) {
                c.this.f34334k = false;
            }
            if (c.this.B == null) {
                return true;
            }
            c.this.B.onInfo(i10);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class f implements MediaPlayer.OnBufferingUpdateListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            c.this.f34344u = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class g implements AudioManager.OnAudioFocusChangeListener {
        public g() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            if (c.this.C != null) {
                c.this.C.onAudioFocusChange(i10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class h implements TextureView.SurfaceTextureListener {
        public h() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            if (c.this.f34335l != null) {
                c cVar = c.this;
                cVar.setSurfaceTexture(cVar.f34335l);
            } else {
                c.this.f34335l = surfaceTexture;
            }
            if (c.this.A != null) {
                c.this.A.onVideoSurfaceTextureAvailable();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (c.this.f34346w) {
                if (c.this.f34335l != null) {
                    c.this.f34335l.release();
                    c.this.f34335l = null;
                }
                if (c.this.A != null) {
                    c.this.A.onVideoSurfaceTextureDestroyed();
                }
                c.this.a(false);
            } else {
                c.this.f34346w = true;
            }
            return c.this.f34335l == null;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
            boolean z10 = c.this.f34333j == 3;
            boolean z11 = i10 > 0 && i11 > 0;
            if (c.this.f34337n != null && z10 && z11) {
                if (c.this.f34342s != 0) {
                    c cVar = c.this;
                    cVar.seekTo(cVar.f34342s);
                }
                c.this.start();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public c(Context context) {
        this(context, null);
    }

    private void setMediaPlayerListener(@NonNull MediaPlayer mediaPlayer) {
        mediaPlayer.setOnPreparedListener(this.f34324a);
        mediaPlayer.setOnCompletionListener(this.f34326c);
        mediaPlayer.setOnErrorListener(this.f34327d);
        mediaPlayer.setOnInfoListener(this.f34328e);
        mediaPlayer.setOnVideoSizeChangedListener(this.f34325b);
        mediaPlayer.setOnBufferingUpdateListener(this.f34329f);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.f34347x;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public boolean canSeek() {
        return this.f34334k && d();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.f34334k && this.f34348y;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.f34334k && this.f34349z;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void destroy() {
        SurfaceTexture surfaceTexture = this.f34335l;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f34335l = null;
        }
        a(true);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return this.f34343t;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f34337n != null) {
            return this.f34344u;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (!d()) {
            return 0;
        }
        if (this.f34332i == 5) {
            return this.f34337n.getDuration();
        }
        return this.f34337n.getCurrentPosition();
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public int getCurrentState() {
        return this.f34332i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (d()) {
            return this.f34337n.getDuration();
        }
        return -1;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public int getTargetState() {
        return this.f34333j;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public String getVideoURI() {
        return this.f34339p;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return d() && this.f34337n.isPlaying();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(c.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(c.class.getName());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int defaultSize = TextureView.getDefaultSize(this.f34340q, i10);
        int defaultSize2 = TextureView.getDefaultSize(this.f34341r, i11);
        if (this.f34340q > 0 && this.f34341r > 0) {
            int size = View.MeasureSpec.getSize(i10);
            float f10 = size / this.f34340q;
            float size2 = View.MeasureSpec.getSize(i11) / this.f34341r;
            String str = this.f34331h;
            str.hashCode();
            char c4 = 65535;
            switch (str.hashCode()) {
                case 3143043:
                    if (str.equals(Attributes.ImageMode.FILL)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 94852023:
                    if (str.equals(Attributes.ImageMode.COVER)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1877637957:
                    if (str.equals("scale-down")) {
                        c4 = 3;
                        break;
                    }
                    break;
            }
            float f11 = 1.0f;
            switch (c4) {
                case 0:
                    f11 = 0.0f;
                    break;
                case 1:
                    f11 = Math.max(f10, size2);
                    i10 = defaultSize;
                    i11 = defaultSize2;
                    break;
                case 2:
                    f11 = Math.min(f10, size2);
                    i10 = defaultSize;
                    i11 = defaultSize2;
                    break;
                case 3:
                    f11 = Math.min(Math.min(f10, size2), 1.0f);
                    i10 = defaultSize;
                    i11 = defaultSize2;
                    break;
                default:
                    i10 = defaultSize;
                    i11 = defaultSize2;
                    break;
            }
            if (f11 != 0.0f) {
                defaultSize = (int) (this.f34340q * f11);
                defaultSize2 = (int) (this.f34341r * f11);
            } else {
                defaultSize = i10;
                defaultSize2 = i11;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void openVideoURI(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f34339p = null;
        } else {
            a(str, (Map<String, String>) null);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (d() && this.f34337n.isPlaying()) {
            try {
                this.f34337n.pause();
                this.f34332i = 4;
                ITextureVideoView.VideoStateListener videoStateListener = this.B;
                if (videoStateListener != null) {
                    videoStateListener.onPause();
                }
            } catch (Exception unused) {
                CardLogUtils.e(E, "mediaplayer pause fail");
                this.f34327d.onError(this.f34337n, 1, 0);
                return;
            }
        }
        this.f34333j = 4;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void resume() {
        e();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i10) {
        if (this.f34334k) {
            if (d()) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.f34337n.seekTo(i10, 3);
                    } else {
                        this.f34337n.seekTo(i10);
                    }
                    this.f34342s = 0;
                    return;
                } catch (Exception unused) {
                    CardLogUtils.e(E, "mediaplayer seek fail");
                    this.f34327d.onError(this.f34337n, 1, 0);
                    return;
                }
            }
            this.f34342s = i10;
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setAudioFocusListener(ITextureVideoView.AudioFocusListener audioFocusListener) {
        this.C = audioFocusListener;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setMuted(boolean z10) {
        MediaPlayer mediaPlayer = this.f34337n;
        if (mediaPlayer != null) {
            if (z10) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setObjectFitType(String str) {
        this.f34331h = str;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setShouldReleaseSurface(boolean z10) {
        this.f34346w = z10;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setVideoStateListener(ITextureVideoView.VideoStateListener videoStateListener) {
        this.B = videoStateListener;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setVideoSurfaceTextureListener(ITextureVideoView.VideoSurfaceTextureListener videoSurfaceTextureListener) {
        this.A = videoSurfaceTextureListener;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void setVideoURI(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f34339p = null;
        } else {
            this.f34339p = str;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (this.f34337n == null) {
            e();
        } else {
            g();
        }
        if (d()) {
            try {
                this.f34337n.start();
                this.f34332i = 3;
                ITextureVideoView.VideoStateListener videoStateListener = this.B;
                if (videoStateListener != null) {
                    videoStateListener.onPlaying();
                }
            } catch (Exception unused) {
                CardLogUtils.e(E, "mediaplayer start fail");
                this.f34327d.onError(this.f34337n, 1, 0);
                return;
            }
        }
        this.f34333j = 3;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void stopPlayback() {
        MediaPlayer mediaPlayer = this.f34337n;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f34337n.release();
                this.f34337n = null;
                this.f34332i = 0;
                this.f34333j = 0;
                ITextureVideoView.VideoStateListener videoStateListener = this.B;
                if (videoStateListener != null) {
                    videoStateListener.onIdle();
                }
            } catch (Exception unused) {
                CardLogUtils.e(E, "mediaplayer stop fail");
                this.f34327d.onError(this.f34337n, 1, 0);
                return;
            }
        }
        a();
        com.huawei.quickcard.video.e.a(this.f34335l);
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView
    public void suspend() {
        a(true);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g() {
        AudioManager audioManager = this.f34338o;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.f34330g, 3, 1);
        }
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f34324a = new a();
        this.f34325b = new b();
        this.f34326c = new C0344c();
        this.f34327d = new d();
        this.f34328e = new e();
        this.f34329f = new f();
        this.f34330g = new g();
        this.f34331h = "contain";
        this.f34332i = 0;
        this.f34333j = 0;
        this.f34334k = true;
        h hVar = new h();
        this.D = hVar;
        this.f34340q = 0;
        this.f34341r = 0;
        this.f34332i = 0;
        this.f34333j = 0;
        this.f34346w = true;
        setSurfaceTextureListener(hVar);
        b();
    }

    private void f() {
        Surface surface = this.f34336m;
        if (surface != null) {
            surface.release();
            this.f34336m = null;
        }
    }

    private void b() {
        Object systemService = getContext().getApplicationContext().getSystemService(PowerProfile.POWER_AUDIO);
        if (systemService instanceof AudioManager) {
            this.f34338o = (AudioManager) systemService;
        }
    }

    private void c() {
        e();
        requestLayout();
        invalidate();
    }

    private boolean d() {
        int i10;
        return (this.f34337n == null || (i10 = this.f34332i) == -1 || i10 == 0 || i10 == 1) ? false : true;
    }

    private void e() {
        if (TextUtils.isEmpty(this.f34339p) || this.f34335l == null) {
            return;
        }
        a(false);
        if (this.f34336m == null) {
            this.f34336m = new Surface(this.f34335l);
        }
        g();
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f34337n = mediaPlayer;
            int i10 = this.f34343t;
            if (i10 != 0) {
                mediaPlayer.setAudioSessionId(i10);
            } else {
                this.f34343t = mediaPlayer.getAudioSessionId();
            }
            setMediaPlayerListener(this.f34337n);
            this.f34344u = 0;
            this.f34337n.setDataSource(getContext().getApplicationContext(), Uri.parse(this.f34339p), this.f34345v);
            this.f34337n.setSurface(this.f34336m);
            this.f34337n.setVolume(0.0f, 0.0f);
            this.f34337n.setAudioStreamType(3);
            this.f34337n.setScreenOnWhilePlaying(true);
            this.f34337n.prepareAsync();
            this.f34332i = 1;
            ITextureVideoView.VideoStateListener videoStateListener = this.B;
            if (videoStateListener != null) {
                videoStateListener.onPreparing();
            }
        } catch (Exception unused) {
            CardLogUtils.e(E, "mediaplayer prepare fail");
            this.f34327d.onError(this.f34337n, 1, 0);
        }
    }

    public void a(String str, Map<String, String> map) {
        this.f34339p = str;
        this.f34345v = map;
        this.f34342s = 0;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        MediaPlayer mediaPlayer = this.f34337n;
        if (mediaPlayer != null) {
            a(mediaPlayer);
            this.f34337n = null;
            f();
            this.f34332i = 0;
            if (z10) {
                this.f34333j = 0;
                ITextureVideoView.VideoStateListener videoStateListener = this.B;
                if (videoStateListener != null) {
                    videoStateListener.onIdle();
                }
            }
            this.f34334k = true;
            a();
        }
    }

    private void a(@NonNull MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.stop();
        } catch (Exception e2) {
            CardLogUtils.e(E, "MediaPlayer stop fail cause : " + e2.getMessage());
        }
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    public c(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f34324a = new a();
        this.f34325b = new b();
        this.f34326c = new C0344c();
        this.f34327d = new d();
        this.f34328e = new e();
        this.f34329f = new f();
        this.f34330g = new g();
        this.f34331h = "contain";
        this.f34332i = 0;
        this.f34333j = 0;
        this.f34334k = true;
        this.D = new h();
    }

    private void a() {
        AudioManager audioManager = this.f34338o;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.f34330g);
        }
    }
}

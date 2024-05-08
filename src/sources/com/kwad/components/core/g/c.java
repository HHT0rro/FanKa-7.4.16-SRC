package com.kwad.components.core.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.g.a;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements ImageLoadingListener {
    private b LF;

    @Nullable
    private a LG;
    private long LJ;
    private long hj;
    private int LH = 1;
    private int LI = 16;
    private List<h> LK = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.g.c$6, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.LG = aVar;
        aVar.a(new a.InterfaceC0462a() { // from class: com.kwad.components.core.g.c.1
            private boolean LL = false;
            private boolean LM = false;

            private void lb() {
                if (this.LL) {
                    return;
                }
                c.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.1.2
                    private static void e(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        e(hVar);
                    }
                });
                this.LL = true;
            }

            private void oD() {
                if (this.LM) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("KSImagePlayer", "onFirstFrame: ");
                this.LM = true;
                c.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.1.3
                    private static void e(h hVar) {
                        hVar.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        e(hVar);
                    }
                });
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0462a
            public final void y(final long j10) {
                com.kwad.sdk.core.e.c.d("KSImagePlayer", "onTimerProgress: " + j10);
                if (j10 == 0) {
                    oD();
                }
                c.this.hj = j10;
                c.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: e, reason: merged with bridge method [inline-methods] */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(c.this.LJ, j10);
                    }
                });
                if (c.this.hj < c.this.LJ || c.this.LJ <= 0) {
                    return;
                }
                lb();
            }
        });
    }

    public static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    private void oC() {
        b bVar = this.LF;
        if (bVar != null) {
            bVar.setImageGravity(this.LH | this.LI);
        }
    }

    public final void c(h hVar) {
        if (hVar != null) {
            this.LK.add(hVar);
        }
    }

    public final void d(h hVar) {
        if (hVar != null) {
            this.LK.remove(hVar);
        }
    }

    public final void destroy() {
        this.LK.clear();
        b bVar = this.LF;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.LF.getParent()).removeView(this.LF);
        }
        this.LF = null;
        a aVar = this.LG;
        if (aVar != null) {
            aVar.destroy();
            this.LG = null;
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.LF == null) {
            this.LF = new b(context);
        }
        return this.LF;
    }

    public final long getPlayDuration() {
        return this.hj;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void accept(h hVar) {
                hVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    public final void pause() {
        a aVar = this.LG;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.2
            private static void e(h hVar) {
                hVar.onMediaPlayPaused();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void play() {
        a aVar = this.LG;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void resume() {
        a aVar = this.LG;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.3
                private static void e(h hVar) {
                    hVar.onMediaPlaying();
                }

                @Override // com.kwad.sdk.g.a
                public final /* synthetic */ void accept(h hVar) {
                    e(hVar);
                }
            });
        }
    }

    public final void setHorizontalGravity(int i10) {
        this.LI = com.kwad.components.core.b.c.aj(i10);
        oC();
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.LF;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setRadius(float f10, float f11, float f12, float f13) {
        b bVar = this.LF;
        if (bVar != null) {
            bVar.setRadius(f10, f11, f12, f13);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        b bVar = this.LF;
        if (bVar != null) {
            bVar.a(str, this);
        }
    }

    public final void setVerticalGravity(int i10) {
        this.LI = com.kwad.components.core.b.c.ai(i10);
        oC();
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.core.g.c.4
            private static void e(h hVar) {
                hVar.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(h hVar) {
                e(hVar);
            }
        });
    }

    public final void stop() {
        a aVar = this.LG;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public final void z(long j10) {
        this.LJ = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void b(com.kwad.sdk.g.a<h> aVar) {
        List<h> list;
        if (aVar == null || (list = this.LK) == null) {
            return;
        }
        Iterator<h> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            aVar.accept(iterator2.next());
        }
    }

    private static int a(FailReason.FailType failType) {
        int i10 = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i10 == 1) {
            return -2;
        }
        if (i10 == 2) {
            return -3;
        }
        if (i10 != 3) {
            return i10 != 4 ? -1 : -5;
        }
        return -4;
    }
}

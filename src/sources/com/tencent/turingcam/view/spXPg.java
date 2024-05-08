package com.tencent.turingcam.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class spXPg extends SurfaceView {

    /* renamed from: a, reason: collision with root package name */
    private SurfaceHolderC0653spXPg f45466a;

    public spXPg(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private void a() {
        getHolder();
    }

    @Override // android.view.SurfaceView
    public SurfaceHolder getHolder() {
        if (this.f45466a == null) {
            this.f45466a = new SurfaceHolderC0653spXPg(this, super.getHolder());
        }
        return this.f45466a;
    }

    /* renamed from: com.tencent.turingcam.view.spXPg$spXPg, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class SurfaceHolderC0653spXPg implements SurfaceHolder {

        /* renamed from: a, reason: collision with root package name */
        private SurfaceHolder f45467a;

        /* renamed from: b, reason: collision with root package name */
        private List<SurfaceHolder.Callback> f45468b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private SurfaceHolder.Callback f45469c;

        /* renamed from: com.tencent.turingcam.view.spXPg$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public class SurfaceHolderCallbackC0654spXPg implements SurfaceHolder.Callback {
            public SurfaceHolderCallbackC0654spXPg() {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                if (SurfaceHolderC0653spXPg.this.f45468b != null) {
                    Iterator iterator2 = SurfaceHolderC0653spXPg.this.f45468b.iterator2();
                    while (iterator2.hasNext()) {
                        ((SurfaceHolder.Callback) iterator2.next()).surfaceChanged(surfaceHolder, i10, i11, i12);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (SurfaceHolderC0653spXPg.this.f45468b != null) {
                    Iterator iterator2 = SurfaceHolderC0653spXPg.this.f45468b.iterator2();
                    while (iterator2.hasNext()) {
                        ((SurfaceHolder.Callback) iterator2.next()).surfaceCreated(surfaceHolder);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (SurfaceHolderC0653spXPg.this.f45468b != null) {
                    Iterator iterator2 = SurfaceHolderC0653spXPg.this.f45468b.iterator2();
                    while (iterator2.hasNext()) {
                        ((SurfaceHolder.Callback) iterator2.next()).surfaceDestroyed(surfaceHolder);
                    }
                    SurfaceHolderC0653spXPg.this.f45468b.clear();
                }
            }
        }

        public SurfaceHolderC0653spXPg(spXPg spxpg, SurfaceHolder surfaceHolder) {
            this.f45467a = null;
            SurfaceHolderCallbackC0654spXPg surfaceHolderCallbackC0654spXPg = new SurfaceHolderCallbackC0654spXPg();
            this.f45469c = surfaceHolderCallbackC0654spXPg;
            this.f45467a = surfaceHolder;
            surfaceHolder.addCallback(surfaceHolderCallbackC0654spXPg);
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
            List<SurfaceHolder.Callback> list = this.f45468b;
            if (list == null || list.contains(callback)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[method: addCallback ] ");
            sb2.append((Object) callback);
            this.f45468b.add(callback);
        }

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                return surfaceHolder.getSurface();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                return surfaceHolder.getSurfaceFrame();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                return surfaceHolder.isCreating();
            }
            return false;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                return surfaceHolder.lockCanvas();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
            List<SurfaceHolder.Callback> list = this.f45468b;
            if (list != null) {
                list.remove(callback);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i10, int i11) {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                surfaceHolder.setFixedSize(i10, i11);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int i10) {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                surfaceHolder.setFormat(i10);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z10) {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(z10);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                surfaceHolder.setSizeFromLayout();
            }
        }

        @Override // android.view.SurfaceHolder
        public void setType(int i10) {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                surfaceHolder.setType(i10);
            }
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect rect) {
            SurfaceHolder surfaceHolder = this.f45467a;
            if (surfaceHolder != null) {
                return surfaceHolder.lockCanvas(rect);
            }
            return null;
        }
    }

    public spXPg(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}

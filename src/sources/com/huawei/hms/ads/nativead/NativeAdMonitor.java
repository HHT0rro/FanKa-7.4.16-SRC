package com.huawei.hms.ads.nativead;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.bt;
import com.huawei.hms.ads.bv;
import com.huawei.hms.ads.bw;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hh;
import com.huawei.hms.ads.hi;
import com.huawei.hms.ads.lh;
import com.huawei.hms.ads.li;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class NativeAdMonitor implements View.OnAttachStateChangeListener, hh {
    private static final String Code = NativeAdMonitor.class.getSimpleName();
    private static WeakHashMap<View, NativeAdMonitor> V = new WeakHashMap<>();
    private View B;
    private bv C;
    private li D;
    private lh F;
    private List<View> I;
    private n L;
    private hi S;
    private List<View> Z;

    /* renamed from: f, reason: collision with root package name */
    private PPSNativeView.b f29369f;

    /* renamed from: g, reason: collision with root package name */
    private PPSNativeView.e f29370g;

    /* renamed from: h, reason: collision with root package name */
    private DislikeAdListener f29371h;

    /* renamed from: a, reason: collision with root package name */
    private boolean f29364a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f29365b = false;

    /* renamed from: c, reason: collision with root package name */
    private final String f29366c = u.ah + hashCode();

    /* renamed from: d, reason: collision with root package name */
    private final String f29367d = u.ai + hashCode();

    /* renamed from: e, reason: collision with root package name */
    private boolean f29368e = false;

    /* renamed from: i, reason: collision with root package name */
    private View.OnClickListener f29372i = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NativeAdMonitor.this.f29364a) {
                NativeAdMonitor.this.f29364a = false;
                gl.V(NativeAdMonitor.Code, "onClick");
                NativeAdMonitor.this.f29368e = true;
                if (NativeAdMonitor.this.f29369f != null) {
                    NativeAdMonitor.this.f29369f.Code(view);
                }
                NativeAdMonitor.this.C.V();
                NativeAdMonitor.this.Code((Integer) 1, true);
                ba.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeAdMonitor.this.f29364a = true;
                    }
                }, 500L);
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private View.OnClickListener f29373j = new View.OnClickListener() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @GlobalApi
    public NativeAdMonitor(View view, Map<String, View> map, Map<String, View> map2) {
        String str;
        String str2;
        this.I = new ArrayList();
        this.Z = new ArrayList();
        if (view instanceof NativeView) {
            str = Code;
            str2 = "containerView can't be an instance of NativeView class or NativeView subclass";
        } else if (view == null) {
            str = Code;
            str2 = "containerView can't be null";
        } else {
            if (V.get(view) == null) {
                V.put(view, this);
                this.B = view;
                this.C = new bw(this.B.getContext(), this.B);
                this.S = new hi(view, this);
                this.B.addOnAttachStateChangeListener(this);
                if (map != null) {
                    this.I = new ArrayList(map.values());
                }
                if (map2 != null) {
                    this.Z = new ArrayList(map2.values());
                    return;
                }
                return;
            }
            str = Code;
            str2 = "containerView has been existed in other NativeAdMonitor object.";
        }
        gl.I(str, str2);
    }

    private void C() {
        n nVar = this.L;
        if (this.B == null || nVar == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                n nVar2 = NativeAdMonitor.this.L;
                if (NativeAdMonitor.this.B == null || nVar2 == null) {
                    return;
                }
                NativeAdMonitor.this.S.a();
            }
        }, this.f29367d, nVar.r() / 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MediaView Code(View view) {
        LinkedList linkedList = new LinkedList();
        if (view instanceof ViewGroup) {
            linkedList.add(view);
        }
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (view2 instanceof MediaView) {
                return (MediaView) view2;
            }
            if (view2 instanceof ViewGroup) {
                int i10 = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i10 < viewGroup.getChildCount()) {
                        linkedList.offer(viewGroup.getChildAt(i10));
                        i10++;
                    }
                }
            }
        }
        return null;
    }

    private void Code(NativeAd nativeAd) {
        View view = this.B;
        if (view == null || V.get(view) == null) {
            gl.V(Code, "container view is null, please add a container view first.");
            return;
        }
        if (nativeAd instanceof bt) {
            g Code2 = ((bt) nativeAd).Code();
            if (Code2 instanceof n) {
                n nVar = (n) Code2;
                this.L = nVar;
                this.S.V(nVar.r(), this.L.s());
                this.C.Code(this.L);
                View view2 = this.B;
                if (view2 != null) {
                    view2.setOnClickListener(this.f29372i);
                }
                MediaView Code3 = Code(this.B);
                if (Code3 != null) {
                    b mediaViewAdapter = Code3.getMediaViewAdapter();
                    mediaViewAdapter.Code(nativeAd);
                    VideoOperator videoOperator = nativeAd.getVideoOperator();
                    if (videoOperator instanceof c) {
                        ((c) videoOperator).Code(Code3);
                    }
                    View B = mediaViewAdapter.B();
                    if (B instanceof NativeVideoView) {
                        NativeVideoView nativeVideoView = (NativeVideoView) B;
                        this.F = nativeVideoView;
                        nativeVideoView.setCoverClickListener(this.f29373j);
                        this.F.setNativeAd(Code2);
                    }
                    if (B instanceof NativeWindowImageView) {
                        NativeWindowImageView nativeWindowImageView = (NativeWindowImageView) B;
                        this.D = nativeWindowImageView;
                        nativeWindowImageView.setNativeAd(Code2);
                        this.D.setDisplayView(this.B);
                    }
                }
                V(this.I);
                I(this.Z);
            }
        }
        S();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        n nVar = this.L;
        if (nVar == null || nVar.R()) {
            return;
        }
        PPSNativeView.e eVar = this.f29370g;
        if (eVar != null) {
            eVar.B();
        }
        this.L.Z(true);
        this.C.Code(l10, num, num2, z10);
    }

    private void D() {
        if (aa.Code(this.Z)) {
            return;
        }
        for (View view : this.Z) {
            if (view != null) {
                view.setClickable(true);
            }
        }
    }

    private void F() {
        if (aa.Code(this.I)) {
            return;
        }
        for (View view : this.I) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
    }

    private void I(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) view).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.f29373j);
                    videoView.getPreviewImageView().setOnClickListener(null);
                }
            } else if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
            }
        }
    }

    private void S() {
        n nVar;
        if (!Code() || (nVar = this.L) == null || nVar.T()) {
            return;
        }
        gl.V(Code, " maybe report show start.");
        I();
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof MediaView) {
                NativeVideoView videoView = ((MediaView) view).getVideoView();
                if (videoView != null) {
                    videoView.setCoverClickListener(this.f29372i);
                    videoView.getPreviewImageView().setOnClickListener(this.f29372i);
                }
            } else if (view != null) {
                view.setOnClickListener(this.f29372i);
            }
        }
    }

    @Override // com.huawei.hms.ads.hh
    public void Code(long j10, int i10) {
        ba.Code(this.f29366c);
        if (!this.S.Code(j10) || this.f29365b) {
            return;
        }
        this.f29365b = true;
        Code(Long.valueOf(j10), Integer.valueOf(i10), null, false);
    }

    public void Code(DislikeAdListener dislikeAdListener) {
        this.f29371h = dislikeAdListener;
    }

    public void Code(PPSNativeView.b bVar) {
        this.f29369f = bVar;
    }

    public void Code(PPSNativeView.e eVar) {
        this.f29370g = eVar;
        this.C.Code(eVar);
    }

    public void Code(Integer num, boolean z10) {
        Code(Long.valueOf(System.currentTimeMillis() - this.S.Z()), Integer.valueOf(this.S.I()), num, z10);
    }

    public void Code(List<String> list) {
        gl.V(Code, "onClose keyWords");
        this.C.Code(list);
        Code((Integer) 3, false);
        lh lhVar = this.F;
        if (lhVar != null) {
            lhVar.S();
        }
        DislikeAdListener dislikeAdListener = this.f29371h;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        unregister();
    }

    public boolean Code() {
        hi hiVar = this.S;
        if (hiVar != null) {
            return hiVar.d();
        }
        return false;
    }

    @Override // com.huawei.hms.ads.hh
    public void I() {
        PPSNativeView.e eVar;
        this.f29365b = false;
        String valueOf = String.valueOf(v.Code());
        n nVar = this.L;
        if (nVar == null) {
            gl.V(Code, "nativeAd is null, please register first");
            return;
        }
        nVar.Z(false);
        this.L.B(true);
        if (this.f29368e && (eVar = this.f29370g) != null) {
            this.f29368e = false;
            eVar.Z();
        }
        if (!this.L.Q()) {
            this.L.V(true);
        }
        this.C.Code(valueOf);
        lh lhVar = this.F;
        if (lhVar != null) {
            lhVar.Code(valueOf);
        }
        this.C.Code();
    }

    @Override // com.huawei.hms.ads.hh
    public void V(long j10, int i10) {
        ba.Code(this.f29366c);
        n nVar = this.L;
        if (nVar != null) {
            nVar.B(false);
        }
        this.C.Code(j10, i10);
    }

    public void Z() {
        gl.V(Code, "onClose");
        Code((List<String>) null);
    }

    @Override // com.huawei.hms.ads.hh
    public void a_() {
        n nVar = this.L;
        if (nVar != null) {
            ba.Code(new Runnable() { // from class: com.huawei.hms.ads.nativead.NativeAdMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    n nVar2 = NativeAdMonitor.this.L;
                    if (nVar2 != null) {
                        NativeAdMonitor.this.Code(Long.valueOf(nVar2.r()), Integer.valueOf(NativeAdMonitor.this.S.I()), null, false);
                    }
                }
            }, this.f29366c, nVar.r());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        hi hiVar = this.S;
        if (hiVar != null) {
            hiVar.D();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        gl.V(Code, "onDetachedFromWindow");
        hi hiVar = this.S;
        if (hiVar != null) {
            hiVar.L();
        }
    }

    @GlobalApi
    public void setNativeAd(NativeAd nativeAd) {
        ba.Code(this.f29367d);
        ba.Code(this.f29366c);
        if (nativeAd == null) {
            gl.V(Code, "nativeAd is null, can't set the nativeAd now.");
            return;
        }
        if (nativeAd instanceof bt) {
            ((bt) nativeAd).Code(this);
        }
        Code(nativeAd);
    }

    @GlobalApi
    public void unregister() {
        ba.Code(this.f29367d);
        ba.Code(this.f29366c);
        n nVar = this.L;
        if (nVar != null) {
            nVar.B(false);
        }
        View view = this.B;
        if (view != null) {
            view.setOnClickListener(null);
        }
        this.L = null;
        this.S.V();
        this.C.Code((n) null);
        this.f29371h = null;
        F();
        D();
        lh lhVar = this.F;
        if (lhVar != null) {
            lhVar.setNativeAd(null);
        }
        this.F = null;
    }
}

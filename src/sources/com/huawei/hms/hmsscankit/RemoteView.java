package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.y3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RemoteView extends FrameLayout {
    private static final int MAX_BITMAP_SIZE = 52428800;
    public static final int REQUEST_CODE_PHOTO = 4371;
    private static final String TAG = "ScanKitRemoteView";
    private static boolean flagForGallery = false;
    private static boolean isOnStop = true;
    private Context mContext;
    private boolean mContinuouslyScan;
    private OnErrorCallback mOnErrorCallback;
    private a mRemoteHelper;
    private boolean mReturnedBitmap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {
        public Activity mContext;
        public HmsScanAnalyzerOptions mFormat;
        public Rect mRect;
        public boolean mIsCustomed = true;
        public boolean mContinuouslyScan = true;
        public boolean mReturnedBitmap = false;

        public RemoteView build() {
            Activity activity = this.mContext;
            boolean z10 = this.mIsCustomed;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mFormat;
            return new RemoteView(activity, z10, hmsScanAnalyzerOptions == null ? 0 : hmsScanAnalyzerOptions.mode, this.mRect).setContinuouslyScan(this.mContinuouslyScan).enableReturnBitmap(this.mReturnedBitmap);
        }

        public Builder enableReturnBitmap() {
            this.mReturnedBitmap = true;
            return this;
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setContinuouslyScan(boolean z10) {
            this.mContinuouslyScan = z10;
            return this;
        }

        public Builder setFormat(int i10, int... iArr) {
            this.mFormat = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i10, iArr).create();
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends DeferredLifecycleHelper<b> {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f30250a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f30251b;

        /* renamed from: c, reason: collision with root package name */
        private OnDelegateCreatedListener<b> f30252c;

        /* renamed from: d, reason: collision with root package name */
        private IRemoteViewDelegate f30253d;

        /* renamed from: e, reason: collision with root package name */
        private IOnResultCallback f30254e = null;

        /* renamed from: f, reason: collision with root package name */
        private boolean f30255f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f30256g;

        /* renamed from: h, reason: collision with root package name */
        private int f30257h;

        /* renamed from: i, reason: collision with root package name */
        private IOnLightCallback f30258i;

        /* renamed from: j, reason: collision with root package name */
        private Rect f30259j;

        /* renamed from: k, reason: collision with root package name */
        private Bundle f30260k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f30261l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f30262m;

        /* renamed from: n, reason: collision with root package name */
        private int f30263n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f30264o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f30265p;

        /* renamed from: com.huawei.hms.hmsscankit.RemoteView$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class ViewOnClickListenerC0322a implements View.OnClickListener {
            public ViewOnClickListenerC0322a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.f30251b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.f30251b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        public a(Activity activity, ViewGroup viewGroup, boolean z10, int i10, Rect rect) {
            this.f30250a = viewGroup;
            this.f30251b = activity;
            this.f30255f = z10;
            this.f30257h = i10;
            this.f30259j = rect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOnLight();
                return true;
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper
        public void createDelegate(OnDelegateCreatedListener<b> onDelegateCreatedListener) {
            Bundle bundle;
            IRemoteCreator d10;
            this.f30252c = onDelegateCreatedListener;
            if (onDelegateCreatedListener == null || getDelegate() != null) {
                return;
            }
            this.f30253d = null;
            try {
                bundle = new Bundle();
                boolean z10 = this.f30255f;
                if (!z10 && this.f30257h == 0 && this.f30259j == null) {
                    o4.d(RemoteView.TAG, "!mCustomed && mFormatValue == 0 && mRect == null");
                } else {
                    bundle.putBoolean(DetailRect.CUSTOMED_FLAG, z10);
                    bundle.putInt(DetailRect.FORMAT_FLAG, this.f30257h);
                    Rect rect = this.f30259j;
                    if (rect != null) {
                        bundle.putParcelable(DetailRect.RECT_FLAG, rect);
                    }
                }
                boolean z11 = this.f30261l;
                if (z11) {
                    bundle.putBoolean(DetailRect.SCAN_OFFSCEEN_FLAG, z11);
                }
                boolean z12 = this.f30256g;
                if (z12) {
                    bundle.putBoolean(DetailRect.DEEPLINK_JUMP_FLAG, z12);
                    bundle.putAll(this.f30260k);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.RETURN_BITMAP, this.f30262m);
                bundle.putAll(y3.a(this.f30251b));
                bundle.putBoolean(DetailRect.SCAN_NEW_UI, true);
                bundle.putInt(DetailRect.SCAN_VIEWTYPE_FLAG, this.f30263n);
                bundle.putBoolean(DetailRect.SCAN_CAMERA_PERMISSION, this.f30264o);
                bundle.putBoolean(HmsScanBase.SCAN_GUIDE_FLAG, this.f30265p);
                d10 = g.d(this.f30251b);
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
            if (d10 == null) {
                return;
            }
            this.f30253d = d10.newRemoteViewDelegate(ObjectWrapper.wrap(this.f30251b), ObjectWrapper.wrap(bundle));
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate == null) {
                return;
            }
            try {
                IOnResultCallback iOnResultCallback = this.f30254e;
                if (iOnResultCallback != null) {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                    this.f30253d.setOnClickListener(ObjectWrapper.wrap(new ViewOnClickListenerC0322a()));
                }
                this.f30253d.setOnClickListener(ObjectWrapper.wrap(new b()));
                IOnLightCallback iOnLightCallback = this.f30258i;
                if (iOnLightCallback != null) {
                    this.f30253d.setOnLightVisbleCallBack(iOnLightCallback);
                }
            } catch (RemoteException unused2) {
                o4.b("exception", "RemoteException");
            }
            this.f30252c.onDelegateCreated(new b(this.f30250a, this.f30253d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.pauseContinuouslyScan();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.resumeContinuouslyScan();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOffLight();
                return true;
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        public void b(boolean z10) {
            this.f30261l = z10;
        }

        public void c(boolean z10) {
            this.f30262m = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.f30251b != null) {
                this.f30251b = null;
            }
            if (this.f30250a != null) {
                this.f30250a = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                return iRemoteViewDelegate.getLightStatus();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        public a(Activity activity, ViewGroup viewGroup, boolean z10, int i10, Rect rect, int i11) {
            this.f30250a = viewGroup;
            this.f30251b = activity;
            this.f30255f = z10;
            this.f30257h = i10;
            this.f30259j = rect;
            this.f30263n = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z10) {
            this.f30256g = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Bundle bundle) {
            this.f30260k = bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnResultCallback iOnResultCallback) {
            this.f30254e = iOnResultCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnErrorCallback iOnErrorCallback) {
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnErrorCallback(iOnErrorCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        public a(Activity activity, ViewGroup viewGroup, boolean z10, int i10, Rect rect, int i11, boolean z11, boolean z12) {
            this.f30250a = viewGroup;
            this.f30251b = activity;
            this.f30255f = z10;
            this.f30257h = i10;
            this.f30259j = rect;
            this.f30263n = i11;
            this.f30264o = z11;
            this.f30265p = z12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnLightCallback iOnLightCallback) {
            this.f30258i = iOnLightCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.f30253d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnLightVisbleCallBack(iOnLightCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        
            com.huawei.hms.scankit.p.o4.e("ScanUtil", "input image is too large:" + r3.getWidth());
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0064 A[Catch: Error -> 0x0068, Exception -> 0x006e, RemoteException -> 0x0074, IllegalStateException -> 0x007a, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x0074, Error -> 0x0068, IllegalStateException -> 0x007a, Exception -> 0x006e, blocks: (B:7:0x000b, B:9:0x0017, B:12:0x0026, B:13:0x0060, B:15:0x0064, B:21:0x0043, B:22:0x005d), top: B:6:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r3, int r4, android.content.Intent r5) {
            /*
                r2 = this;
                java.lang.String r0 = "ScanKitRemoteView"
                r1 = -1
                if (r4 != r1) goto L7f
                if (r5 == 0) goto L7f
                r4 = 4371(0x1113, float:6.125E-42)
                if (r3 != r4) goto L7f
                com.huawei.hms.hmsscankit.RemoteView r3 = com.huawei.hms.hmsscankit.RemoteView.this     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                android.content.Context r3 = com.huawei.hms.hmsscankit.RemoteView.access$1300(r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                android.graphics.Bitmap r3 = com.huawei.hms.scankit.p.w7.a(r3, r5)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                if (r3 == 0) goto L41
                int r4 = r3.getWidth()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r5 = r3.getHeight()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r4 = r4 * r5
                r5 = 52428800(0x3200000, float:4.7019774E-37)
                if (r4 <= r5) goto L26
                goto L41
            L26:
                com.huawei.hms.hmsscankit.RemoteView r4 = com.huawei.hms.hmsscankit.RemoteView.this     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                android.content.Context r4 = com.huawei.hms.hmsscankit.RemoteView.access$1300(r4)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$Creator r5 = new com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$Creator     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r5.<init>()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r1 = 1
                com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$Creator r5 = r5.setPhotoMode(r1)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r5 = r5.create()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r1 = r2.f30257h     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.ml.scan.HmsScan[] r3 = com.huawei.hms.hmsscankit.f.a(r4, r3, r5, r1)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                goto L60
            L41:
                if (r3 == 0) goto L5d
                java.lang.String r4 = "ScanUtil"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r5.<init>()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                java.lang.String r1 = "input image is too large:"
                r5.append(r1)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r3 = r3.getWidth()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r5.append(r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                java.lang.String r3 = r5.toString()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.scankit.p.o4.e(r4, r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
            L5d:
                r3 = 0
                com.huawei.hms.ml.scan.HmsScan[] r3 = new com.huawei.hms.ml.scan.HmsScan[r3]     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
            L60:
                com.huawei.hms.hmsscankit.api.IOnResultCallback r4 = r2.f30254e     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                if (r4 == 0) goto L7f
                r4.onResult(r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                goto L7f
            L68:
                java.lang.String r3 = "Exception in error"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
                goto L7f
            L6e:
                java.lang.String r3 = "Exception in remoteview"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
                goto L7f
            L74:
                java.lang.String r3 = "RemoteException in remoteview"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
                goto L7f
            L7a:
                java.lang.String r3 = "IllegalStateException in remoteview"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
            L7f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.RemoteView.a.a(int, int, android.content.Intent):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements LifecycleDelegate {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f30269a;

        /* renamed from: b, reason: collision with root package name */
        private View f30270b;

        /* renamed from: c, reason: collision with root package name */
        private IRemoteViewDelegate f30271c;

        public b(ViewGroup viewGroup, IRemoteViewDelegate iRemoteViewDelegate) {
            this.f30269a = viewGroup;
            this.f30271c = iRemoteViewDelegate;
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.f30271c.onCreate(bundle);
                this.f30270b = (View) ObjectWrapper.unwrap(this.f30271c.getView());
                this.f30269a.removeAllViews();
                this.f30269a.addView(this.f30270b);
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return new View(null);
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.f30271c.onDestroy();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.f30271c.onPause();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                if (!RemoteView.isOnStop) {
                    if (RemoteView.flagForGallery) {
                        this.f30271c.onStart();
                    } else {
                        this.f30271c.onResume();
                    }
                } else {
                    this.f30271c.onResume();
                }
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.f30271c.onStart();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.f30271c.onStop();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }
    }

    public RemoteView(Activity activity, boolean z10, int i10, Rect rect) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z10, i10, rect);
    }

    private boolean checkPhotoPermission(Activity activity) {
        return Build.VERSION.SDK_INT >= 33 ? w7.b((Context) activity) || activity.checkPermission("android.permission.READ_MEDIA_IMAGES", Process.myPid(), Process.myUid()) == 0 : w7.b((Context) activity) || activity.checkPermission(com.kuaishou.weapon.p0.g.f36123i, Process.myPid(), Process.myUid()) == 0;
    }

    private void requestPhotoPermission(Activity activity) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            activity.requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES"}, REQUEST_CODE_PHOTO);
        } else if (i10 >= 23) {
            activity.requestPermissions(new String[]{com.kuaishou.weapon.p0.g.f36123i}, REQUEST_CODE_PHOTO);
        }
    }

    private void startActivityForGallery(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (w7.g(activity)) {
                if (w7.a(new Intent(), "com.android.gallery3d", activity) != null && w7.a("com.android.gallery3d", activity)) {
                    o4.d(TAG, "Start Gallery:com.android.gallery3d");
                    intent.setPackage("com.android.gallery3d");
                } else if (w7.a(new Intent(), "com.huawei.photos", activity) != null && w7.a("com.huawei.photos", activity)) {
                    intent.setPackage("com.huawei.photos");
                    o4.d(TAG, "Start Gallery:com.huawei.photos");
                }
            }
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            flagForGallery = true;
            activity.startActivityForResult(intent, REQUEST_CODE_PHOTO);
        } catch (Exception unused) {
            o4.b(TAG, "startPhotoCode Exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoCode(Activity activity) {
        if (checkPhotoPermission(activity)) {
            startActivityForGallery(activity);
            return;
        }
        o4.d(TAG, "no photo permission");
        if (this.mOnErrorCallback == null) {
            requestPhotoPermission(activity);
        } else {
            o4.b(TAG, "no photo permission, report error2");
            this.mOnErrorCallback.onError(2);
        }
    }

    public RemoteView enableReturnBitmap(boolean z10) {
        this.mReturnedBitmap = z10;
        this.mRemoteHelper.c(z10);
        return this;
    }

    public boolean getLightStatus() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            return aVar.c();
        }
        return false;
    }

    @Override // android.view.View
    public void onActivityResult(int i10, int i11, Intent intent) {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(i10, i11, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.mContext).getWindow().setFlags(16777216, 16777216);
        }
        this.mRemoteHelper.onCreate(bundle);
    }

    public final void onDestroy() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onDestroy();
            this.mRemoteHelper.b();
            this.mRemoteHelper = null;
        }
    }

    public final void onPause() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onPause();
        }
        a aVar2 = this.mRemoteHelper;
        if (aVar2 != null && flagForGallery) {
            aVar2.onStop();
        }
        isOnStop = false;
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr, Activity activity) {
        if (i10 == 4371 && iArr.length == 1 && iArr[0] == 0) {
            startPhotoCode(activity);
        }
    }

    public final void onResume() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onResume();
        }
        flagForGallery = false;
    }

    public final void onStart() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onStart();
        }
        flagForGallery = false;
    }

    public final void onStop() {
        a aVar = this.mRemoteHelper;
        if (aVar != null && !flagForGallery) {
            aVar.onStop();
        }
        isOnStop = true;
    }

    public void pauseContinuouslyScan() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void resumeContinuouslyScan() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void selectPictureFromLocalFile() {
        startPhotoCode((Activity) this.mContext);
    }

    public RemoteView setContinuouslyScan(boolean z10) {
        this.mContinuouslyScan = z10;
        return this;
    }

    public void setOnErrorCallback(OnErrorCallback onErrorCallback) {
        this.mOnErrorCallback = onErrorCallback;
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(new c(this.mOnErrorCallback));
        }
    }

    public void setOnLightVisibleCallback(OnLightVisibleCallBack onLightVisibleCallBack) {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(new d(onLightVisibleCallBack));
        }
    }

    public void setOnResultCallback(OnResultCallback onResultCallback) {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(new e(onResultCallback, this.mContinuouslyScan));
        }
    }

    public boolean switchLight() {
        if (this.mRemoteHelper != null) {
            return !getLightStatus() ? this.mRemoteHelper.g() : this.mRemoteHelper.f();
        }
        return false;
    }

    public RemoteView(Activity activity, boolean z10, int i10, Rect rect, int i11) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z10, i10, rect, i11);
    }

    public RemoteView(Activity activity, boolean z10, int i10, Rect rect, int i11, boolean z11, boolean z12) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z10, i10, rect, i11, z11, z12);
    }

    public RemoteView(Activity activity, boolean z10, int i10, Rect rect, boolean z11) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        a aVar = new a(activity, this, z10, i10, rect);
        this.mRemoteHelper = aVar;
        aVar.b(z11);
    }

    public RemoteView(Activity activity, boolean z10, Bundle bundle) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        a aVar = new a(activity, this, false, 0, null);
        this.mRemoteHelper = aVar;
        aVar.a(z10);
        this.mRemoteHelper.a(bundle);
    }
}

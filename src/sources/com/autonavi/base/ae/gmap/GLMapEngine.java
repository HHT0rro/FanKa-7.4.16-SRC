package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.amap.api.col.p0003l.dv;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.je;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLMapEngine implements IGLMapEngine, IAMapEngineCallback, NetworkState.NetworkChangeListener {
    private Context context;
    private int mEngineID;
    private IAMapDelegate mGlMapView;
    private IAMapListener mMapListener;
    public boolean mRequestDestroy;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    public GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;
    private String userAgent;
    private long mNativeMapengineInstance = 0;
    private final List<AbstractCameraUpdateMessage> mStateMessageList = new Vector();
    private final List<AbstractGestureMapMessage> mGestureMessageList = new Vector();
    private List<AbstractGestureMapMessage> mGestureEndMessageList = new Vector();
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList = new Vector();
    public boolean isMoveCameraStep = false;
    public boolean isGestureStep = false;
    private int mapGestureCount = 0;
    private GLMapState copyGLMapState = null;
    private Lock mLock = new ReentrantLock();
    private Object mutLock = new Object();
    private NetworkState mNetworkState = null;
    public GLOverlayBundle<BaseMapOverlay<?, ?>> bundle = null;
    private boolean isEngineRenderComplete = false;
    public Map<Long, AMapLoader> aMapLoaderHashtable = new ConcurrentHashMap();
    public boolean isNetworkConnected = false;
    private AtomicInteger mRequestID = new AtomicInteger(1);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class InitParam {
        public String mRootPath = "";
        public String mConfigPath = "";
        public String mConfigContent = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mIntersectionResPath = "";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f9678x;

        /* renamed from: y, reason: collision with root package name */
        public int f9679y;
    }

    public GLMapEngine(Context context, IAMapDelegate iAMapDelegate) {
        this.mGlMapView = null;
        this.mapAnimationMgr = null;
        this.mRequestDestroy = false;
        this.terrainTileProvider = null;
        this.mRequestDestroy = false;
        if (context == null) {
            return;
        }
        this.context = context.getApplicationContext();
        this.mGlMapView = iAMapDelegate;
        this.mTextTextureGenerator = new TextTextureGenerator();
        AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
        this.mapAnimationMgr = adglMapAnimationMgr;
        adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.5
            @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
            public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
            }
        });
        this.userAgent = System.getProperty("http.agent") + " amap/" + GlMapUtil.getAppVersionName(context);
        this.terrainTileProvider = new TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer());
        this.mEngineID = GLEngineIDController.getController().generate();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:12|(2:13|14)|16|17|18|19|(4:24|(1:26)|27|(1:31)(2:29|30))(1:23)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0056, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0052, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0053, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float adapterDpiScale(android.util.DisplayMetrics r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            java.lang.String r0 = getEMUI()
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L87
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L87
            java.lang.String r2 = "EmotionUI_8"
            int r2 = r0.indexOf(r2)
            r3 = -1
            if (r2 != r3) goto L1f
            java.lang.String r2 = "EmotionUI_9"
            int r0 = r0.indexOf(r2)
            if (r0 == r3) goto L87
        L1f:
            if (r11 <= 0) goto L87
            r0 = 1
            r2 = 0
            java.lang.Class<android.util.DisplayMetrics> r3 = android.util.DisplayMetrics.class
            java.lang.String r4 = "noncompatWidthPixels"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L38
            r3.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L38
            int r3 = r3.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L38
            goto L3d
        L33:
            r3 = move-exception
            r3.printStackTrace()
            goto L3c
        L38:
            r3 = move-exception
            r3.printStackTrace()
        L3c:
            r3 = 0
        L3d:
            java.lang.Class<android.util.DisplayMetrics> r4 = android.util.DisplayMetrics.class
            java.lang.String r5 = "noncompatHeightPixels"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            r4.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            int r4 = r4.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L52
            goto L57
        L4d:
            r4 = move-exception
            r4.printStackTrace()
            goto L56
        L52:
            r4 = move-exception
            r4.printStackTrace()
        L56:
            r4 = 0
        L57:
            java.lang.Class<android.util.DisplayMetrics> r5 = android.util.DisplayMetrics.class
            java.lang.String r6 = "noncompatDensityDpi"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L6c
            r5.setAccessible(r0)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L6c
            int r2 = r5.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L6c
            goto L70
        L67:
            r8 = move-exception
            r8.printStackTrace()
            goto L70
        L6c:
            r8 = move-exception
            r8.printStackTrace()
        L70:
            if (r2 > r11) goto L76
            if (r3 > r9) goto L76
            if (r4 <= r10) goto L87
        L76:
            float r8 = (float) r2
            float r9 = (float) r11
            float r8 = r8 / r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 <= 0) goto L81
            r8 = 1073741824(0x40000000, float:2.0)
        L81:
            int r9 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r9 >= 0) goto L86
            goto L87
        L86:
            r1 = r8
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.adapterDpiScale(android.util.DisplayMetrics, int, int, int):float");
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onCancel();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onFinish();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i10 = this.mapGestureCount - 1;
        this.mapGestureCount = i10;
        if (i10 == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() > 0) {
            return;
        }
        synchronized (this.mAnimateStateMessageList) {
            remove = this.mAnimateStateMessageList.size() > 0 ? this.mAnimateStateMessageList.remove(0) : null;
        }
        if (remove != null) {
            remove.generateMapAnimation(this);
        }
    }

    private void initNetworkState() {
        NetworkState networkState = new NetworkState();
        this.mNetworkState = networkState;
        networkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean isNetworkConnected = NetworkState.isNetworkConnected(this.context.getApplicationContext());
        this.isNetworkConnected = isNetworkConnected;
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetNetStatus(j10, isNetworkConnected ? 1 : 0);
        }
    }

    public static native void nativeAddGestureSingleTapMessage(int i10, long j10, float f10, float f11);

    public static native String nativeAddNativeOverlay(int i10, long j10, int i11, int i12);

    private static native boolean nativeAddOverlayTexture(int i10, long j10, int i11, int i12, float f10, float f11, Bitmap bitmap, boolean z10, boolean z11);

    private static native void nativeCancelDownLoad(long j10);

    private static native void nativeCreateAMapEngineWithFrame(long j10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, float f10, float f11, float f12, int i17);

    private static native long nativeCreateAMapInstance(float f10, float f11, float f12, int i10);

    public static native long nativeCreateOverlay(int i10, long j10, int i11);

    private static native int nativeCreateTextureFromImage(int i10, long j10, Bitmap bitmap);

    private static native void nativeDestroy(long j10);

    private static native void nativeDestroyCurrentState(long j10, long j11);

    public static native void nativeDestroyOverlay(int i10, long j10);

    private static native void nativeFailedDownLoad(long j10, int i10);

    private static native void nativeFinishDownLoad(long j10);

    private static native void nativeGetCurTileIDs(int i10, long j10, int[] iArr, int i11);

    private static native long nativeGetCurrentMapState(int i10, long j10);

    private static native long nativeGetGlOverlayMgrPtr(int i10, long j10);

    public static native String nativeGetMapEngineVersion(int i10);

    private static native int[] nativeGetMapModeState(int i10, long j10, boolean z10);

    public static native String nativeGetMapSDKDeps();

    public static native String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int i10, long j10);

    public static native int[] nativeGetScreenShot(int i10, long j10, int i11, int i12, int i13, int i14);

    private static native boolean nativeGetSrvViewStateBoolValue(int i10, long j10, int i11);

    public static native int nativeHideBuildings(int i10, long j10, LatLng[] latLngArr);

    private static native void nativeInitAMapEngineCallback(long j10, Object obj);

    private static native void nativeInitContourLineOptions(long j10, boolean z10);

    private static native void nativeInitOpenLayer(int i10, long j10, byte[] bArr);

    private static native void nativeInitParam(String str, String str2, String str3, String str4, String str5, String str6, int i10);

    private static native boolean nativeIsEngineCreated(long j10, int i10);

    private static native void nativePopRenderState(int i10, long j10);

    private static native void nativePostRenderAMap(long j10, int i10);

    private static native void nativePushRendererState(int i10, long j10);

    private static native void nativeReceiveNetData(byte[] bArr, long j10, int i10);

    public static native void nativeRemoveNativeAllOverlay(int i10, long j10);

    public static native void nativeRemoveNativeOverlay(int i10, long j10, String str);

    private static native void nativeRenderAMap(long j10, int i10);

    private static native void nativeSetAllContentEnable(int i10, long j10, boolean z10);

    private static native void nativeSetBuildingEnable(int i10, long j10, boolean z10);

    private static native void nativeSetBuildingTextureEnable(int i10, long j10, boolean z10);

    private static native void nativeSetCustomStyleData(int i10, long j10, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i10, long j10, byte[] bArr);

    private static native void nativeSetCustomThirdLayerStyle(int i10, long j10, String str);

    private static native void nativeSetHighlightSubwayEnable(int i10, long j10, boolean z10);

    private static native void nativeSetIndoorBuildingToBeActive(int i10, long j10, String str, int i11, String str2);

    private static native void nativeSetIndoorEnable(int i10, long j10, boolean z10);

    private static native void nativeSetLabelEnable(int i10, long j10, boolean z10);

    private static native boolean nativeSetMapModeAndStyle(int i10, long j10, int[] iArr);

    private static native void nativeSetNaviLabelEnable(int i10, long j10, boolean z10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetNetStatus(long j10, int i10);

    private static native void nativeSetOfflineDataEnable(int i10, long j10, boolean z10);

    private static native void nativeSetOpenLayerEnable(int i10, long j10, boolean z10);

    private static native void nativeSetParameter(int i10, long j10, int i11, int i12, int i13, int i14, int i15);

    private static native void nativeSetProjectionCenter(int i10, long j10, float f10, float f11);

    private static native void nativeSetRenderListenerStatus(int i10, long j10);

    private static native void nativeSetRoadArrowEnable(int i10, long j10, boolean z10);

    private static native void nativeSetServiceViewRect(int i10, long j10, int i11, int i12, int i13, int i14, int i15, int i16);

    private static native void nativeSetSetBackgroundTexture(int i10, long j10, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i10, long j10, boolean z10);

    private static native void nativeSetSkyTexture(int i10, long j10, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i10, long j10, int i11, boolean z10);

    private static native void nativeSetStyleChangeGradualEnable(int i10, long j10, boolean z10);

    public static native void nativeSetTerrainAuth(int i10, long j10, boolean z10);

    private static native void nativeSetTrafficEnable(int i10, long j10, boolean z10);

    private static native void nativeSetTrafficTexture(int i10, long j10, byte[] bArr, long j11, int i11, int i12, int i13, int i14, int i15);

    private static native void nativeSetTrafficTextureAllInOne(int i10, long j10, byte[] bArr);

    public static native void nativeSetVectorOverlayPath(int i10, long j10, String str);

    public static native void nativeShowHideBuildings(int i10, long j10, int i11);

    public static native void nativeUpdateNativeArrowOverlay(int i10, long j10, String str, int[] iArr, int[] iArr2, int i11, int i12, int i13, float f10, boolean z10, int i14, int i15, int i16);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        if (r2.width != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        r2.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        if (r2.height != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r2.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
    
        r3 = r2.getMapGestureState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r3 != 100) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        gestureBegin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        if (r3 != 101) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        r2.runCameraUpdate(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r3 != 102) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        gestureEnd();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processGestureMessage(com.autonavi.base.ae.gmap.GLMapState r6) {
        /*
            r5 = this;
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r0 = r5.mGestureMessageList
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L10
            boolean r6 = r5.isGestureStep
            if (r6 == 0) goto Lf
            r5.isGestureStep = r1
        Lf:
            return r1
        L10:
            r0 = 1
            r5.isGestureStep = r0
            if (r6 != 0) goto L16
            return r1
        L16:
            r2 = 0
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList
            monitor-enter(r3)
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r4 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L73
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L73
            if (r4 <= 0) goto L2a
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L73
            java.lang.Object r2 = r2.remove(r1)     // Catch: java.lang.Throwable -> L73
            com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage r2 = (com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage) r2     // Catch: java.lang.Throwable -> L73
        L2a:
            if (r2 != 0) goto L39
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r6 = r5.mGestureEndMessageList
            int r6 = r6.size()
            if (r6 <= 0) goto L38
            r5.recycleMessage()
        L38:
            return r0
        L39:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            int r3 = r2.width
            if (r3 != 0) goto L46
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapWidth()
            r2.width = r3
        L46:
            int r3 = r2.height
            if (r3 != 0) goto L52
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r5.mGlMapView
            int r3 = r3.getMapHeight()
            r2.height = r3
        L52:
            int r3 = r2.getMapGestureState()
            r4 = 100
            if (r3 != r4) goto L5e
            r5.gestureBegin()
            goto L6d
        L5e:
            r4 = 101(0x65, float:1.42E-43)
            if (r3 != r4) goto L66
            r2.runCameraUpdate(r6)
            goto L6d
        L66:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L6d
            r5.gestureEnd()
        L6d:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureEndMessageList
            r3.add(r2)
            goto L16
        L73:
            r6 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L73
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processGestureMessage(com.autonavi.base.ae.gmap.GLMapState):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        r1.setCameraDegree(com.amap.api.col.p0003l.dx.a(r6.mGlMapView.getMapConfig(), r1.getCameraDegree(), r1.getMapZoomer()));
        setMapState(r6.mEngineID, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean processMessage() {
        /*
            r6 = this;
            r0 = 0
            int r1 = r6.mEngineID     // Catch: java.lang.Exception -> L61
            com.autonavi.amap.api.mapcore.IGLMapState r1 = r6.getNewMapState(r1)     // Catch: java.lang.Exception -> L61
            com.autonavi.base.ae.gmap.GLMapState r1 = (com.autonavi.base.ae.gmap.GLMapState) r1     // Catch: java.lang.Exception -> L61
            boolean r2 = r6.processGestureMessage(r1)     // Catch: java.lang.Exception -> L61
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r6.mGestureMessageList     // Catch: java.lang.Exception -> L61
            int r3 = r3.size()     // Catch: java.lang.Exception -> L61
            r4 = 1
            if (r3 > 0) goto L23
            if (r2 != 0) goto L21
            boolean r2 = r6.processStateMapMessage(r1)     // Catch: java.lang.Exception -> L61
            if (r2 == 0) goto L1f
            goto L21
        L1f:
            r2 = 0
            goto L34
        L21:
            r2 = 1
            goto L34
        L23:
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r3 = r6.mStateMessageList     // Catch: java.lang.Exception -> L61
            monitor-enter(r3)     // Catch: java.lang.Exception -> L61
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L5e
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L5e
            if (r5 <= 0) goto L33
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L5e
            r5.clear()     // Catch: java.lang.Throwable -> L5e
        L33:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5e
        L34:
            if (r2 != 0) goto L3e
            boolean r2 = r6.processAnimations(r1)     // Catch: java.lang.Exception -> L61
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r4 = 0
        L3e:
            if (r4 == 0) goto L5a
            float r2 = r1.getCameraDegree()     // Catch: java.lang.Exception -> L61
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r6.mGlMapView     // Catch: java.lang.Exception -> L61
            com.autonavi.base.amap.mapcore.MapConfig r3 = r3.getMapConfig()     // Catch: java.lang.Exception -> L61
            float r5 = r1.getMapZoomer()     // Catch: java.lang.Exception -> L61
            float r2 = com.amap.api.col.p0003l.dx.a(r3, r2, r5)     // Catch: java.lang.Exception -> L61
            r1.setCameraDegree(r2)     // Catch: java.lang.Exception -> L61
            int r2 = r6.mEngineID     // Catch: java.lang.Exception -> L61
            r6.setMapState(r2, r1)     // Catch: java.lang.Exception -> L61
        L5a:
            r1.recycle()     // Catch: java.lang.Exception -> L61
            return r4
        L5e:
            r1 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5e
            throw r1     // Catch: java.lang.Exception -> L61
        L61:
            r1 = move-exception
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mStateMessageList) {
                remove = this.mStateMessageList.size() > 0 ? this.mStateMessageList.remove(0) : null;
                if (remove == null) {
                    return true;
                }
            }
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void OnIndoorBuildingActivity(int i10, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i10, bArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i10, AbstractGestureMapMessage abstractGestureMapMessage, boolean z10, int i11, int i12) {
        if (abstractGestureMapMessage == null) {
            return;
        }
        abstractGestureMapMessage.isGestureScaleByMapCenter = z10;
        synchronized (this.mGestureMessageList) {
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    public void addGestureSingleTapMessage(float f10, float f11) {
        nativeAddGestureSingleTapMessage(this.mEngineID, this.mNativeMapengineInstance, f10, f11);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i10, int i11, float f10, int i12, int i13, int i14, int i15, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i11);
        adglMapAnimGroup.setToCameraDegree(i13, 0);
        adglMapAnimGroup.setToMapAngle(i12, 0);
        adglMapAnimGroup.setToMapLevel(f10, 0);
        adglMapAnimGroup.setToMapCenterGeo(i14, i15, 0);
        if (this.mapAnimationMgr == null || !adglMapAnimGroup.isValid()) {
            return;
        }
        this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z10) {
        if (z10) {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
            return;
        }
        synchronized (this.mStateMessageList) {
            this.mStateMessageList.add(abstractCameraUpdateMessage);
        }
    }

    public String addNativeOverlay(int i10, int i11, int i12) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0) {
            return null;
        }
        String nativeAddNativeOverlay = nativeAddNativeOverlay(i10, j10, i11, i12);
        if (TextUtils.isEmpty(nativeAddNativeOverlay)) {
            return null;
        }
        return nativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i10, GLTextureProperty gLTextureProperty) {
        Bitmap bitmap;
        if (this.mNativeMapengineInstance == 0 || gLTextureProperty == null || (bitmap = gLTextureProperty.mBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        nativeAddOverlayTexture(i10, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
    }

    public boolean canStopMapRender(int i10) {
        return this.isEngineRenderComplete;
    }

    public synchronized void cancelAllAMapDownload() {
        try {
            Iterator iterator2 = new ConcurrentHashMap(this.aMapLoaderHashtable).entrySet().iterator2();
            while (iterator2.hasNext()) {
                ((AMapLoader) ((Map.Entry) iterator2.next()).getValue()).doCancelAndNotify();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void cancelRequireMapData(Object obj) {
        if (obj == null || !(obj instanceof AMapLoader)) {
            return;
        }
        ((AMapLoader) obj).doCancel();
    }

    public void changeSurface(int i10, int i11) {
    }

    public void clearAllMessages(int i10) {
    }

    public void clearAnimations(int i10, boolean z10) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.f9678x, mapViewInitParam.f9679y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                setCustomStyleData(mapViewInitParam.engineId, FileUtil.uncompressToByteArray(FileUtil.readFileContentsFromAssets(this.context, "map_assets/style_1_17_for_terrain.data")), null);
            }
        }
    }

    public boolean createAMapInstance(InitParam initParam) {
        if (initParam == null) {
            return false;
        }
        synchronized (GLMapEngine.class) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            int i10 = displayMetrics.densityDpi;
            float f10 = displayMetrics.density;
            float adapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, i10);
            this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());
            int i11 = MapsInitializer.isTerrainEnable() ? 1 : 0;
            nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath, "http://mpsapi.amap.com/", "http://m5.amap.com/", i10);
            InitStorageParam.Holder.initPath(initParam.mP3dCrossPath);
            long nativeCreateAMapInstance = nativeCreateAMapInstance(i10, f10, adapterDpiScale, i11);
            this.mNativeMapengineInstance = nativeCreateAMapInstance;
            if (nativeCreateAMapInstance == 0) {
                return false;
            }
            if (MapsInitializer.isTerrainEnable()) {
                nativeInitContourLineOptions(this.mNativeMapengineInstance, MapsInitializer.isContourLineEnable());
            }
            nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
            initNetworkState();
            return true;
        }
    }

    public long createOverlay(int i10, int i11) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            return nativeCreateOverlay(i10, j10, i11);
        }
        return 0L;
    }

    public int createOverlayTexture(int i10, Bitmap bitmap) {
        if (this.mNativeMapengineInstance == 0 || bitmap == null || bitmap.isRecycled()) {
            return -1;
        }
        return nativeCreateTextureFromImage(i10, this.mNativeMapengineInstance, bitmap);
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    this.mLock.lock();
                    try {
                        GLMapState gLMapState = this.copyGLMapState;
                        if (gLMapState != null) {
                            gLMapState.recycle();
                        }
                        this.mLock.unlock();
                        nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                        nativeDestroy(this.mNativeMapengineInstance);
                    } catch (Throwable th) {
                        this.mLock.unlock();
                        throw th;
                    }
                }
                this.mNativeMapengineInstance = 0L;
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            dv.b();
        } catch (Throwable th2) {
            th2.printStackTrace();
            dx.a(th2);
        }
    }

    public void destroyOverlay(int i10, long j10) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i10, j10);
        }
    }

    public synchronized void finishDownLoad(int i10, long j10) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j10))) {
            nativeFinishDownLoad(j10);
            this.aMapLoaderHashtable.remove(Long.valueOf(j10));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j10 = this.mNativeMapengineInstance;
            if (j10 != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(this.mEngineID, j10);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
            return this.copyGLMapState;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i10, int[] iArr) {
        if (iArr != null) {
            for (int i11 = 0; i11 < iArr.length; i11++) {
                iArr[i11] = 0;
            }
            nativeGetCurTileIDs(i10, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public BitmapDescriptor getDefaultTerrainImage() {
        return this.terrainTileProvider.getDefaultTerrain();
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int i10) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int i10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            return nativeGetGlOverlayMgrPtr(i10, j10);
        }
        return 0L;
    }

    public boolean getIsProcessBuildingMark(int i10) {
        return false;
    }

    public boolean getMapDataTaskIsCancel(int i10, long j10) {
        return !this.aMapLoaderHashtable.containsKey(Long.valueOf(j10));
    }

    public int[] getMapModeState(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0) {
            return null;
        }
        nativeGetMapModeState(i10, j10, z10);
        return null;
    }

    public GLMapState getMapState(int i10) {
        this.mLock.lock();
        try {
            long j10 = this.mNativeMapengineInstance;
            if (j10 != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i10, j10);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(i10, this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public long getMapStateInstance(int i10) {
        return 0L;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            return nativeGetNativeMapController(i10, j10);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int i10) {
        this.mLock.lock();
        try {
            long j10 = this.mNativeMapengineInstance;
            if (j10 != 0) {
                return new GLMapState(i10, j10);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i10) {
        return this.bundle;
    }

    public Bitmap getScreenShot(int i10, int i11, int i12, int i13, int i14) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            return dx.a(nativeGetScreenShot(i10, j10, i11, i12, i13, i14), i13 - i11, i14 - i12, true);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i10, int i11) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            return nativeGetSrvViewStateBoolValue(i10, j10, i11);
        }
        return false;
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            if (this.mStateMessageList.size() == 0) {
                return null;
            }
            return this.mStateMessageList.remove(0);
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public InitStorageParam getStorageInitParam() {
        return InitStorageParam.obtain();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public int hideBuildings(List<LatLng> list) {
        if (this.mNativeMapengineInstance == 0) {
            return -1;
        }
        LatLng[] latLngArr = new LatLng[list.size()];
        list.toArray(latLngArr);
        return nativeHideBuildings(this.mEngineID, this.mNativeMapengineInstance, latLngArr);
    }

    public void initMapOpenLayer(String str) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0 || str == null) {
            return;
        }
        nativeInitOpenLayer(this.mEngineID, j10, str.getBytes());
    }

    public void initNativeTexture(int i10) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap2 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            Bitmap bitmap3 = fromAsset3 != null ? fromAsset3.getBitmap() : null;
            addOverlayTexture(i10, bitmap, 111, 4);
            addOverlayTexture(i10, bitmap2, 222, 4);
            addOverlayTexture(i10, bitmap3, 333, 4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(this.mEngineID, false);
            } catch (Throwable th) {
                gy.b(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            return nativeIsEngineCreated(j10, i10);
        }
        return false;
    }

    public boolean isInMapAction(int i10) {
        return false;
    }

    public boolean isInMapAnimation(int i10) {
        return getAnimateionsCount() > 0;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public synchronized void netCancel(int i10, long j10, int i11) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j10))) {
            nativeFailedDownLoad(j10, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j10));
        }
    }

    public synchronized void netError(int i10, long j10, int i11, int i12) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j10))) {
            nativeFailedDownLoad(j10, i12);
            this.aMapLoaderHashtable.remove(Long.valueOf(j10));
            try {
                if (MapsInitializer.getExceptionLogger() != null) {
                    MapsInitializer.getExceptionLogger().onDownloaderException(i11, i12);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void netStop(int i10, long j10, int i11) {
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j10))) {
            nativeFailedDownLoad(j10, -1);
            this.aMapLoaderHashtable.remove(Long.valueOf(j10));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
    public void networkStateChanged(Context context) {
        if (this.mRequestDestroy || this.mNativeMapengineInstance == 0 || this.mGlMapView == null) {
            return;
        }
        this.isNetworkConnected = NetworkState.isNetworkConnected(context);
        this.mGlMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.4
            @Override // java.lang.Runnable
            public void run() {
                GLMapEngine.nativeSetNetStatus(GLMapEngine.this.mNativeMapengineInstance, GLMapEngine.this.isNetworkConnected ? 1 : 0);
            }
        });
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.onAMapAppResourceRequest(aMapAppRequestParam);
        }
    }

    public void onClearCache(int i10) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapBlandClick(double d10, double d11) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapBlankClick(d10, d11);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapPOIClick(MapPoi mapPoi) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapPOIClick(mapPoi);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapRender(int i10, int i11) {
        try {
            if (i11 == 5) {
                IAMapListener iAMapListener = this.mMapListener;
                if (iAMapListener != null) {
                    iAMapListener.beforeDrawLabel(i10, getMapState(i10));
                    return;
                }
                return;
            }
            if (i11 == 6) {
                IAMapListener iAMapListener2 = this.mMapListener;
                if (iAMapListener2 != null) {
                    iAMapListener2.afterDrawLabel(i10, getMapState(i10));
                    return;
                }
                return;
            }
            if (i11 != 7) {
                if (i11 != 13) {
                    return;
                }
                this.isEngineRenderComplete = true;
            } else {
                IAMapListener iAMapListener3 = this.mMapListener;
                if (iAMapListener3 != null) {
                    iAMapListener3.afterRendererOver(i10, getMapState(i10));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void popRendererState() {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativePopRenderState(this.mEngineID, j10);
        }
    }

    public void pushRendererState() {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativePushRendererState(this.mEngineID, j10);
        }
    }

    public void putResourceData(int i10, byte[] bArr) {
    }

    public synchronized void receiveNetData(int i10, long j10, byte[] bArr, int i11) {
        if (this.mRequestDestroy) {
            return;
        }
        if (this.aMapLoaderHashtable.containsKey(Long.valueOf(j10))) {
            nativeReceiveNetData(bArr, j10, i11);
        }
    }

    public void releaseNetworkState() {
        NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener(null);
            this.mNetworkState = null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i10, String str, int i11) {
    }

    public void removeNativeAllOverlay(int i10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeRemoveNativeAllOverlay(i10, j10);
        }
    }

    public void removeNativeOverlay(int i10, String str) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0 || str == null) {
            return;
        }
        nativeRemoveNativeOverlay(i10, j10, str);
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
                nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (this.isEngineRenderComplete) {
                return;
            }
            nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharBitmap(int i10, int i11, int i12) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i11, i12);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharsWidths(int i10, int[] iArr, int i11, int i12) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int requireMapDataAsyn(int i10, byte[] bArr) {
        if (bArr != null) {
            AMapLoader.ADataRequestParam aDataRequestParam = new AMapLoader.ADataRequestParam();
            int i11 = GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = GLConvertUtil.getString(bArr, 4, i11);
            int i12 = i11 + 4;
            int i13 = GLConvertUtil.getInt(bArr, i12);
            int i14 = i12 + 4;
            aDataRequestParam.requestUrl = GLConvertUtil.getString(bArr, i14, i13);
            int i15 = i14 + i13;
            aDataRequestParam.handler = GLConvertUtil.getLong(bArr, i15);
            int i16 = i15 + 8;
            aDataRequestParam.nRequestType = GLConvertUtil.getInt(bArr, i16);
            int i17 = i16 + 4;
            int i18 = GLConvertUtil.getInt(bArr, i17);
            int i19 = i17 + 4;
            aDataRequestParam.enCodeString = GLConvertUtil.getSubBytes(bArr, i19, i18);
            aDataRequestParam.nCompress = GLConvertUtil.getInt(bArr, i19 + i18);
            final AMapLoader aMapLoader = new AMapLoader(i10, this, aDataRequestParam);
            this.aMapLoaderHashtable.put(Long.valueOf(aDataRequestParam.handler), aMapLoader);
            try {
                dv.a().a(new je() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.1
                    @Override // com.amap.api.col.p0003l.je
                    public void runTask() {
                        try {
                            if (GLMapEngine.this.mRequestDestroy) {
                                aMapLoader.doCancelAndNotify();
                            } else {
                                aMapLoader.doRequest();
                            }
                        } catch (Throwable th) {
                            gy.b(th, "download Thread", "AMapLoader doRequest");
                            dx.a(th);
                        }
                    }
                });
            } catch (Throwable th) {
                gy.b(th, "download Thread", "requireMapData");
                dx.a(th);
            }
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i10, int i11, int i12) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireMapResource(int i10, String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String concat = "map_assets/".concat(str);
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (this.mGlMapView.getCustomStyleManager() != null) {
                    bArr = this.mGlMapView.getCustomStyleManager().a(str);
                    if (bArr != null) {
                        return bArr;
                    }
                } else {
                    bArr = null;
                }
                if (str.startsWith("icons_5")) {
                    bArr = FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = FileUtil.readFileContentsFromAssets(this.context, concat);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = dx.a(bArr, customBackgroundColor);
                    }
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return FileUtil.readFileContentsFromAssets(this.context, concat);
        } catch (Throwable th) {
            dx.a(th);
            return null;
        }
    }

    public void setAllContentEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            if (z10) {
                nativeSetAllContentEnable(i10, j10, true);
            } else {
                nativeSetAllContentEnable(i10, j10, false);
            }
            setSimple3DEnable(i10, false);
        }
    }

    public void setBackgroundTexture(int i10, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetSetBackgroundTexture(i10, j10, bArr);
        }
    }

    public void setBuildingEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetBuildingEnable(i10, j10, z10);
        }
    }

    public void setBuildingTextureEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetBuildingTextureEnable(i10, j10, z10);
        }
    }

    public void setCustomStyleData(int i10, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return;
        }
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetCustomStyleData(i10, j10, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i10, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetCustomStyleTexture(i10, j10, bArr);
        }
    }

    public void setCustomThirdLayerStyle(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetCustomThirdLayerStyle(this.mEngineID, j10, str);
        }
    }

    public void setHighlightSubwayEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetHighlightSubwayEnable(i10, j10, z10);
        }
    }

    public void setIndoorBuildingToBeActive(int i10, String str, int i11, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetIndoorBuildingToBeActive(i10, j10, str, i11, str2);
        }
    }

    public void setIndoorEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetIndoorEnable(i10, j10, z10);
        }
    }

    public void setInternaltexture(int i10, byte[] bArr, int i11) {
    }

    public void setLabelEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetLabelEnable(i10, j10, z10);
        }
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setMapLoaderToTask(int i10, long j10, AMapLoader aMapLoader) {
    }

    public boolean setMapModeAndStyle(int i10, int i11, int i12, boolean z10, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i10, i11, i12);
        if (styleItemArr != null && z10) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                setBackgroundTexture(i10, dx.a(FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME), customBackgroundColor));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i10, FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i11 == 0 && i12 == 0) {
            Context context = this.context;
            StringBuilder sb2 = new StringBuilder(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            String str = File.separator;
            sb2.append(str);
            sb2.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i10, FileUtil.readFileContentsFromAssets(context, sb2.toString()));
            setCustomStyleTexture(i10, FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + str + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetOpenLayerEnable(this.mEngineID, j10, z10);
        }
    }

    public void setMapState(int i10, GLMapState gLMapState) {
        setMapState(i10, gLMapState, true);
    }

    public boolean setNativeMapModeAndStyle(int i10, int i11, int i12) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i10, j10, new int[]{i11, i12});
    }

    public void setNaviLabelEnable(int i10, boolean z10, int i11, int i12) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetNaviLabelEnable(i10, j10, z10, i11, i12);
        }
    }

    public void setOfflineDataEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetOfflineDataEnable(i10, j10, z10);
        }
    }

    public void setOvelayBundle(int i10, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.mLock.lock();
        try {
            long j10 = this.mNativeMapengineInstance;
            if (j10 != 0) {
                nativeSetParameter(i10, j10, i11, i12, i13, i14, i15);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i10, int i11, int i12) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetProjectionCenter(i10, j10, i11, i12);
        }
    }

    public void setRoadArrowEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetRoadArrowEnable(i10, j10, z10);
        }
    }

    public void setServiceViewRect(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        nativeSetServiceViewRect(i10, this.mNativeMapengineInstance, i11, i12, i13, i14, i15, i16);
    }

    public void setSimple3DEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetSimple3DEnable(i10, j10, z10);
        }
    }

    public void setSkyTexture(int i10, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetSkyTexture(i10, j10, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i10, int i11, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetSrvViewStateBoolValue(i10, j10, i11, z10);
        }
    }

    public void setStyleChangeGradualEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetStyleChangeGradualEnable(i10, j10, z10);
        }
    }

    public void setTerrainAuth(boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0) {
            return;
        }
        nativeSetTerrainAuth(this.mEngineID, j10, z10);
    }

    public void setTrafficEnable(int i10, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 != 0) {
            nativeSetTrafficEnable(i10, j10, z10);
        }
    }

    public void setTrafficStyleWithTexture(int i10, byte[] bArr, MyTrafficStyle myTrafficStyle) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0 || myTrafficStyle == null) {
            return;
        }
        nativeSetTrafficTexture(i10, j10, bArr, bArr.length, myTrafficStyle.getExtremelySmoothColor(), myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
    }

    public void setTrafficStyleWithTextureData(int i10, byte[] bArr) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0 || bArr == null) {
            return;
        }
        nativeSetTrafficTextureAllInOne(i10, j10, bArr);
    }

    public void setVectorOverlayPath(String str) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0) {
            return;
        }
        nativeSetVectorOverlayPath(this.mEngineID, j10, str);
    }

    public void showHideBuildings(int i10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0) {
            return;
        }
        nativeShowHideBuildings(this.mEngineID, j10, i10);
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i10, Point point, float f10, float f11) {
        if (point == null) {
            return;
        }
        try {
            clearAnimations(i10, true);
            GLMapState cloneMapState = getCloneMapState();
            cloneMapState.reset();
            cloneMapState.recalculate();
            float abs = Math.abs(f10);
            float abs2 = Math.abs(f11);
            if ((abs > abs2 ? abs : abs2) > 12000.0f) {
                if (abs > abs2) {
                    f10 = f10 > 0.0f ? 12000.0f : -12000.0f;
                    f11 = (12000.0f / abs) * f11;
                } else {
                    float f12 = (12000.0f / abs2) * f10;
                    if (f11 > 0.0f) {
                        f10 = f12;
                        f11 = 12000.0f;
                    } else {
                        f10 = f12;
                        f11 = -12000.0f;
                    }
                }
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                AdglMapAnimFlingP20 adglMapAnimFlingP20 = new AdglMapAnimFlingP20(500);
                adglMapAnimFlingP20.setPositionAndVelocity(f10, f11);
                adglMapAnimFlingP20.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFlingP20, null);
                return;
            }
            int mapWidth = this.mGlMapView.getMapWidth() >> 1;
            int mapHeight = this.mGlMapView.getMapHeight() >> 1;
            if (this.mGlMapView.isUseAnchor()) {
                mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
            }
            AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
            adglMapAnimFling.setPositionAndVelocity(f10, f11);
            adglMapAnimFling.commitAnimation(cloneMapState);
            this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startPivotZoomRotateAnim(int i10, Point point, float f10, int i11, int i12) {
    }

    public void updateNativeArrowOverlay(int i10, String str, int[] iArr, int[] iArr2, int i11, int i12, int i13, float f10, int i14, int i15, int i16, boolean z10) {
        long j10 = this.mNativeMapengineInstance;
        if (j10 == 0 || str == null) {
            return;
        }
        nativeUpdateNativeArrowOverlay(i10, j10, str, iArr, iArr2, i11, i12, i13, f10, z10, i14, i15, i16);
    }

    public void clearAnimations(int i10, boolean z10, int i11) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void setMapState(int i10, GLMapState gLMapState, boolean z10) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (z10 && (iAMapDelegate = this.mGlMapView) != null && iAMapDelegate.getMapConfig() != null) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i10, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void addOverlayTexture(int i10, Bitmap bitmap, int i11, int i12) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i11;
        gLTextureProperty.mAnchor = i12;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i10, gLTextureProperty);
    }
}

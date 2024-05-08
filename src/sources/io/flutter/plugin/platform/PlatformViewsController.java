package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    private static Class[] VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY = {SurfaceView.class};
    private static boolean enableImageRenderTarget = true;
    private static boolean enableSurfaceProducerRenderTarget = false;
    private AndroidTouchProcessor androidTouchProcessor;
    private Context context;
    private FlutterView flutterView;
    private PlatformViewsChannel platformViewsChannel;

    @Nullable
    private TextInputPlugin textInputPlugin;

    @Nullable
    private TextureRegistry textureRegistry;
    private int nextOverlayLayerId = 0;
    private boolean flutterViewConvertedToImageView = false;
    private boolean synchronizeToNativeViewHierarchy = true;
    private boolean usesSoftwareRendering = false;
    private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new AnonymousClass1();
    private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();

    @VisibleForTesting
    public final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();
    private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();

    @VisibleForTesting
    public final HashMap<Context, View> contextToEmbeddedView = new HashMap<>();
    private final SparseArray<PlatformOverlayView> overlayLayerViews = new SparseArray<>();
    private final HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private final HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    private final SparseArray<PlatformViewWrapper> viewWrappers = new SparseArray<>();
    private final SparseArray<PlatformView> platformViews = new SparseArray<>();
    private final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();

    /* renamed from: io.flutter.plugin.platform.PlatformViewsController$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class AnonymousClass1 implements PlatformViewsChannel.PlatformViewsHandler {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$resize$0(VirtualDisplayController virtualDisplayController, float f10, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            PlatformViewsController.this.unlockInputConnection(virtualDisplayController);
            if (PlatformViewsController.this.context != null) {
                f10 = PlatformViewsController.this.getDisplayDensity();
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(virtualDisplayController.getRenderTargetWidth(), f10), PlatformViewsController.this.toLogicalPixels(virtualDisplayController.getRenderTargetHeight(), f10)));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void clearFocus(int i10) {
            View view;
            if (PlatformViewsController.this.usesVirtualDisplay(i10)) {
                view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i10)).getView();
            } else {
                PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i10);
                if (platformView == null) {
                    Log.e(PlatformViewsController.TAG, "Clearing focus on an unknown view with id: " + i10);
                    return;
                }
                view = platformView.getView();
            }
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Clearing focus on a null view with id: " + i10);
                return;
            }
            view.clearFocus();
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void createForPlatformViewLayer(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.enforceMinimumAndroidApiVersion(19);
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            PlatformViewsController.this.configureForHybridComposition(PlatformViewsController.this.createPlatformView(platformViewCreationRequest, false), platformViewCreationRequest);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public long createForTextureLayer(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            PlatformViewsController.this.ensureValidRequest(platformViewCreationRequest);
            int i10 = platformViewCreationRequest.viewId;
            if (PlatformViewsController.this.viewWrappers.get(i10) == null) {
                if (PlatformViewsController.this.textureRegistry != null) {
                    if (PlatformViewsController.this.flutterView != null) {
                        PlatformView createPlatformView = PlatformViewsController.this.createPlatformView(platformViewCreationRequest, true);
                        View view = createPlatformView.getView();
                        if (view.getParent() == null) {
                            if (!(Build.VERSION.SDK_INT >= 23 && !ViewUtils.hasChildViewOfType(view, PlatformViewsController.VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY))) {
                                if (platformViewCreationRequest.displayMode == PlatformViewsChannel.PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK) {
                                    PlatformViewsController.this.configureForHybridComposition(createPlatformView, platformViewCreationRequest);
                                    return -2L;
                                }
                                if (!PlatformViewsController.this.usesSoftwareRendering) {
                                    return PlatformViewsController.this.configureForVirtualDisplay(createPlatformView, platformViewCreationRequest);
                                }
                            }
                            return PlatformViewsController.this.configureForTextureLayerComposition(createPlatformView, platformViewCreationRequest);
                        }
                        throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
                    }
                    throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i10);
                }
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i10);
            }
            throw new IllegalStateException("Trying to create an already created platform view, view id: " + i10);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void dispose(int i10) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i10);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Disposing unknown platform view with id: " + i10);
                return;
            }
            if (platformView.getView() != null) {
                View view = platformView.getView();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            }
            PlatformViewsController.this.platformViews.remove(i10);
            try {
                platformView.dispose();
            } catch (RuntimeException e2) {
                Log.e(PlatformViewsController.TAG, "Disposing platform view threw an exception", e2);
            }
            if (PlatformViewsController.this.usesVirtualDisplay(i10)) {
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i10));
                View view2 = virtualDisplayController.getView();
                if (view2 != null) {
                    PlatformViewsController.this.contextToEmbeddedView.remove(view2.getContext());
                }
                virtualDisplayController.dispose();
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(i10));
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i10);
            if (platformViewWrapper != null) {
                platformViewWrapper.removeAllViews();
                platformViewWrapper.release();
                platformViewWrapper.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup2 = (ViewGroup) platformViewWrapper.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(platformViewWrapper);
                }
                PlatformViewsController.this.viewWrappers.remove(i10);
                return;
            }
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i10);
            if (flutterMutatorView != null) {
                flutterMutatorView.removeAllViews();
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup3 = (ViewGroup) flutterMutatorView.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(flutterMutatorView);
                }
                PlatformViewsController.this.platformViewParent.remove(i10);
            }
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void offset(int i10, double d10, double d11) {
            if (PlatformViewsController.this.usesVirtualDisplay(i10)) {
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i10);
            if (platformViewWrapper == null) {
                Log.e(PlatformViewsController.TAG, "Setting offset for unknown platform view with id: " + i10);
                return;
            }
            int physicalPixels = PlatformViewsController.this.toPhysicalPixels(d10);
            int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(d11);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
            layoutParams.topMargin = physicalPixels;
            layoutParams.leftMargin = physicalPixels2;
            platformViewWrapper.setLayoutParams(layoutParams);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i10 = platformViewTouch.viewId;
            float f10 = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            if (PlatformViewsController.this.usesVirtualDisplay(i10)) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(i10)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f10, platformViewTouch, true));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i10);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to an unknown view with id: " + i10);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to a null view with id: " + i10);
                return;
            }
            view.dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f10, platformViewTouch, false));
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void resize(@NonNull PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, @NonNull final PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            int physicalPixels = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
            int physicalPixels2 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
            int i10 = platformViewResizeRequest.viewId;
            if (PlatformViewsController.this.usesVirtualDisplay(i10)) {
                final float displayDensity = PlatformViewsController.this.getDisplayDensity();
                final VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i10));
                PlatformViewsController.this.lockInputConnection(virtualDisplayController);
                virtualDisplayController.resize(physicalPixels, physicalPixels2, new Runnable() { // from class: io.flutter.plugin.platform.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlatformViewsController.AnonymousClass1.this.lambda$resize$0(virtualDisplayController, displayDensity, platformViewBufferResized);
                    }
                });
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i10);
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i10);
            if (platformView != null && platformViewWrapper != null) {
                if (physicalPixels > platformViewWrapper.getRenderTargetWidth() || physicalPixels2 > platformViewWrapper.getRenderTargetHeight()) {
                    platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
                }
                ViewGroup.LayoutParams layoutParams = platformViewWrapper.getLayoutParams();
                layoutParams.width = physicalPixels;
                layoutParams.height = physicalPixels2;
                platformViewWrapper.setLayoutParams(layoutParams);
                View view = platformView.getView();
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    layoutParams2.width = physicalPixels;
                    layoutParams2.height = physicalPixels2;
                    view.setLayoutParams(layoutParams2);
                }
                platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getRenderTargetWidth()), PlatformViewsController.this.toLogicalPixels(platformViewWrapper.getRenderTargetHeight())));
                return;
            }
            Log.e(PlatformViewsController.TAG, "Resizing unknown platform view with id: " + i10);
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void setDirection(int i10, int i11) {
            View view;
            if (PlatformViewsController.validateDirection(i11)) {
                if (PlatformViewsController.this.usesVirtualDisplay(i10)) {
                    view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i10)).getView();
                } else {
                    PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i10);
                    if (platformView == null) {
                        Log.e(PlatformViewsController.TAG, "Setting direction to an unknown view with id: " + i10);
                        return;
                    }
                    view = platformView.getView();
                }
                if (view == null) {
                    Log.e(PlatformViewsController.TAG, "Setting direction to a null view with id: " + i10);
                    return;
                }
                view.setLayoutDirection(i11);
                return;
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i11 + "(view id: " + i10 + ")");
        }

        @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
        public void synchronizeToNativeViewHierarchy(boolean z10) {
            PlatformViewsController.this.synchronizeToNativeViewHierarchy = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureForHybridComposition(@NonNull PlatformView platformView, @NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(19);
        Log.i(TAG, "Using hybrid composition for platform view: " + platformViewCreationRequest.viewId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long configureForVirtualDisplay(@NonNull PlatformView platformView, @NonNull final PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        enforceMinimumAndroidApiVersion(20);
        Log.i(TAG, "Hosting view in a virtual display for platform view: " + platformViewCreationRequest.viewId);
        PlatformViewRenderTarget makePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
        VirtualDisplayController create = VirtualDisplayController.create(this.context, this.accessibilityEventsDelegate, platformView, makePlatformViewRenderTarget, toPhysicalPixels(platformViewCreationRequest.logicalWidth), toPhysicalPixels(platformViewCreationRequest.logicalHeight), platformViewCreationRequest.viewId, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                PlatformViewsController.this.lambda$configureForVirtualDisplay$0(platformViewCreationRequest, view, z10);
            }
        });
        if (create != null) {
            this.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), create);
            View view = platformView.getView();
            this.contextToEmbeddedView.put(view.getContext(), view);
            return makePlatformViewRenderTarget.getId();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
    }

    private void diposeAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enforceMinimumAndroidApiVersion(int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= i10) {
            return;
        }
        throw new IllegalStateException("Trying to use platform views with API " + i11 + ", required API level is: " + i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureValidRequest(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        if (validateDirection(platformViewCreationRequest.direction)) {
            return;
        }
        throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
    }

    private void finishFrame(boolean z10) {
        for (int i10 = 0; i10 < this.overlayLayerViews.size(); i10++) {
            int keyAt = this.overlayLayerViews.keyAt(i10);
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i10);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                this.flutterView.attachOverlaySurfaceToRender(valueAt);
                z10 &= valueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
                this.flutterView.removeView(valueAt);
            }
        }
        for (int i11 = 0; i11 < this.platformViewParent.size(); i11++) {
            int keyAt2 = this.platformViewParent.keyAt(i11);
            FlutterMutatorView flutterMutatorView = this.platformViewParent.get(keyAt2);
            if (this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) && (z10 || !this.synchronizeToNativeViewHierarchy)) {
                flutterMutatorView.setVisibility(0);
            } else {
                flutterMutatorView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    private void initializeRootImageViewIfNeeded() {
        if (!this.synchronizeToNativeViewHierarchy || this.flutterViewConvertedToImageView) {
            return;
        }
        this.flutterView.convertToImageView();
        this.flutterViewConvertedToImageView = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureForTextureLayerComposition$1(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z10) {
        if (z10) {
            this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(platformViewCreationRequest.viewId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureForVirtualDisplay$0(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z10) {
        if (z10) {
            this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializePlatformViewIfNeeded$2(int i10, View view, boolean z10) {
        if (z10) {
            this.platformViewsChannel.invokeViewFocused(i10);
            return;
        }
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEndFrame$3() {
        finishFrame(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.lockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionLocked();
    }

    private static PlatformViewRenderTarget makePlatformViewRenderTarget(TextureRegistry textureRegistry) {
        if (enableSurfaceProducerRenderTarget && Build.VERSION.SDK_INT >= 33) {
            TextureRegistry.SurfaceProducer createSurfaceProducer = textureRegistry.createSurfaceProducer();
            Log.i(TAG, "PlatformView is using SurfaceProducer backend");
            return new SurfaceProducerPlatformViewRenderTarget(createSurfaceProducer);
        }
        if (enableImageRenderTarget && Build.VERSION.SDK_INT >= 33) {
            TextureRegistry.ImageTextureEntry createImageTexture = textureRegistry.createImageTexture();
            Log.i(TAG, "PlatformView is using ImageReader backend");
            return new ImageReaderPlatformViewRenderTarget(createImageTexture);
        }
        TextureRegistry.SurfaceTextureEntry createSurfaceTexture = textureRegistry.createSurfaceTexture();
        Log.i(TAG, "PlatformView is using SurfaceTexture backend");
        return new SurfaceTexturePlatformViewRenderTarget(createSurfaceTexture);
    }

    private void maybeInvokeOnFlutterViewAttached(PlatformView platformView) {
        FlutterView flutterView = this.flutterView;
        if (flutterView == null) {
            Log.i(TAG, "null flutterView");
        } else {
            platformView.onFlutterViewAttached(flutterView);
        }
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f10) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        double d10 = f10;
        pointerCoords.toolMajor = (float) (((Double) list.get(3)).doubleValue() * d10);
        pointerCoords.toolMinor = (float) (((Double) list.get(4)).doubleValue() * d10);
        pointerCoords.touchMajor = (float) (((Double) list.get(5)).doubleValue() * d10);
        pointerCoords.touchMinor = (float) (((Double) list.get(6)).doubleValue() * d10);
        pointerCoords.f810x = (float) (((Double) list.get(7)).doubleValue() * d10);
        pointerCoords.f811y = (float) (((Double) list.get(8)).doubleValue() * d10);
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f10) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = ((List) obj).iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(parsePointerCoords(iterator2.next(), f10));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.f812id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = ((List) obj).iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(parsePointerProperties(iterator2.next()));
        }
        return arrayList;
    }

    private void removeOverlaySurfaces() {
        if (this.flutterView == null) {
            Log.e(TAG, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i10 = 0; i10 < this.overlayLayerViews.size(); i10++) {
            this.flutterView.removeView(this.overlayLayerViews.valueAt(i10));
        }
        this.overlayLayerViews.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toLogicalPixels(double d10, float f10) {
        return (int) Math.round(d10 / f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toPhysicalPixels(double d10) {
        return (int) Math.round(d10 * getDisplayDensity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockInputConnection(@NonNull VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.textInputPlugin;
        if (textInputPlugin == null) {
            return;
        }
        textInputPlugin.unlockPlatformViewInputConnection();
        virtualDisplayController.onInputConnectionUnlocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validateDirection(int i10) {
        return i10 == 0 || i10 == 1;
    }

    public void attach(@Nullable Context context, @NonNull TextureRegistry textureRegistry, @NonNull DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context;
            this.textureRegistry = textureRegistry;
            PlatformViewsChannel platformViewsChannel = new PlatformViewsChannel(dartExecutor);
            this.platformViewsChannel = platformViewsChannel;
            platformViewsChannel.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError((Object) "A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void attachAccessibilityBridge(@NonNull AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void attachTextInputPlugin(@NonNull TextInputPlugin textInputPlugin) {
        this.textInputPlugin = textInputPlugin;
    }

    public void attachToFlutterRenderer(@NonNull FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void attachToView(@NonNull FlutterView flutterView) {
        this.flutterView = flutterView;
        for (int i10 = 0; i10 < this.viewWrappers.size(); i10++) {
            this.flutterView.addView(this.viewWrappers.valueAt(i10));
        }
        for (int i11 = 0; i11 < this.platformViewParent.size(); i11++) {
            this.flutterView.addView(this.platformViewParent.valueAt(i11));
        }
        for (int i12 = 0; i12 < this.platformViews.size(); i12++) {
            this.platformViews.valueAt(i12).onFlutterViewAttached(this.flutterView);
        }
    }

    public boolean checkInputConnectionProxy(@Nullable View view) {
        if (view == null || !this.contextToEmbeddedView.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.contextToEmbeddedView.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    @VisibleForTesting(otherwise = 3)
    public long configureForTextureLayerComposition(@NonNull PlatformView platformView, @NonNull final PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        PlatformViewWrapper platformViewWrapper;
        long j10;
        enforceMinimumAndroidApiVersion(23);
        Log.i(TAG, "Hosting view in view hierarchy for platform view: " + platformViewCreationRequest.viewId);
        int physicalPixels = toPhysicalPixels(platformViewCreationRequest.logicalWidth);
        int physicalPixels2 = toPhysicalPixels(platformViewCreationRequest.logicalHeight);
        if (this.usesSoftwareRendering) {
            platformViewWrapper = new PlatformViewWrapper(this.context);
            j10 = -1;
        } else {
            PlatformViewRenderTarget makePlatformViewRenderTarget = makePlatformViewRenderTarget(this.textureRegistry);
            PlatformViewWrapper platformViewWrapper2 = new PlatformViewWrapper(this.context, makePlatformViewRenderTarget);
            long id2 = makePlatformViewRenderTarget.getId();
            platformViewWrapper = platformViewWrapper2;
            j10 = id2;
        }
        platformViewWrapper.setTouchProcessor(this.androidTouchProcessor);
        platformViewWrapper.resizeRenderTarget(physicalPixels, physicalPixels2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(physicalPixels, physicalPixels2);
        int physicalPixels3 = toPhysicalPixels(platformViewCreationRequest.logicalTop);
        int physicalPixels4 = toPhysicalPixels(platformViewCreationRequest.logicalLeft);
        layoutParams.topMargin = physicalPixels3;
        layoutParams.leftMargin = physicalPixels4;
        platformViewWrapper.setLayoutParams(layoutParams);
        View view = platformView.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(physicalPixels, physicalPixels2));
        view.setImportantForAccessibility(4);
        platformViewWrapper.addView(view);
        platformViewWrapper.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                PlatformViewsController.this.lambda$configureForTextureLayerComposition$1(platformViewCreationRequest, view2, z10);
            }
        });
        this.flutterView.addView(platformViewWrapper);
        this.viewWrappers.append(platformViewCreationRequest.viewId, platformViewWrapper);
        maybeInvokeOnFlutterViewAttached(platformView);
        return j10;
    }

    @NonNull
    @VisibleForTesting
    public FlutterOverlaySurface createOverlaySurface(@NonNull PlatformOverlayView platformOverlayView) {
        int i10 = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i10 + 1;
        this.overlayLayerViews.put(i10, platformOverlayView);
        return new FlutterOverlaySurface(i10, platformOverlayView.getSurface());
    }

    @VisibleForTesting(otherwise = 3)
    public PlatformView createPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, boolean z10) {
        PlatformViewFactory factory = this.registry.getFactory(platformViewCreationRequest.viewType);
        if (factory != null) {
            PlatformView create = factory.create(z10 ? new MutableContextWrapper(this.context) : this.context, platformViewCreationRequest.viewId, platformViewCreationRequest.params != null ? factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params) : null);
            View view = create.getView();
            if (view != null) {
                view.setLayoutDirection(platformViewCreationRequest.direction);
                this.platformViews.put(platformViewCreationRequest.viewId, create);
                maybeInvokeOnFlutterViewAttached(create);
                return create;
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
    }

    public void destroyOverlaySurfaces() {
        for (int i10 = 0; i10 < this.overlayLayerViews.size(); i10++) {
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i10);
            valueAt.detachFromRenderer();
            valueAt.closeImageReader();
        }
    }

    @UiThread
    public void detach() {
        PlatformViewsChannel platformViewsChannel = this.platformViewsChannel;
        if (platformViewsChannel != null) {
            platformViewsChannel.setPlatformViewsHandler(null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public void detachAccessibilityBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge(null);
    }

    public void detachFromView() {
        for (int i10 = 0; i10 < this.viewWrappers.size(); i10++) {
            this.flutterView.removeView(this.viewWrappers.valueAt(i10));
        }
        for (int i11 = 0; i11 < this.platformViewParent.size(); i11++) {
            this.flutterView.removeView(this.platformViewParent.valueAt(i11));
        }
        destroyOverlaySurfaces();
        removeOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
        for (int i12 = 0; i12 < this.platformViews.size(); i12++) {
            this.platformViews.valueAt(i12).onFlutterViewDetached();
        }
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    @VisibleForTesting
    public void disposePlatformView(int i10) {
        this.channelHandler.dispose(i10);
    }

    @VisibleForTesting
    public SparseArray<PlatformOverlayView> getOverlayLayerViews() {
        return this.overlayLayerViews;
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    @Nullable
    public View getPlatformViewById(int i10) {
        if (usesVirtualDisplay(i10)) {
            return this.vdControllers.get(Integer.valueOf(i10)).getView();
        }
        PlatformView platformView = this.platformViews.get(i10);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    @VisibleForTesting
    public void initializePlatformViewIfNeeded(final int i10) {
        PlatformView platformView = this.platformViews.get(i10);
        if (platformView != null) {
            if (this.platformViewParent.get(i10) != null) {
                return;
            }
            View view = platformView.getView();
            if (view != null) {
                if (view.getParent() == null) {
                    Context context = this.context;
                    FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                    flutterMutatorView.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.d
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view2, boolean z10) {
                            PlatformViewsController.this.lambda$initializePlatformViewIfNeeded$2(i10, view2, z10);
                        }
                    });
                    this.platformViewParent.put(i10, flutterMutatorView);
                    view.setImportantForAccessibility(4);
                    flutterMutatorView.addView(view);
                    this.flutterView.addView(flutterMutatorView);
                    return;
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
    }

    public void onAttachedToJNI() {
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onDetachedFromJNI() {
        diposeAllViews();
    }

    public void onDisplayOverlaySurface(int i10, int i11, int i12, int i13, int i14) {
        if (this.overlayLayerViews.get(i10) != null) {
            initializeRootImageViewIfNeeded();
            PlatformOverlayView platformOverlayView = this.overlayLayerViews.get(i10);
            if (platformOverlayView.getParent() == null) {
                this.flutterView.addView(platformOverlayView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i13, i14);
            layoutParams.leftMargin = i11;
            layoutParams.topMargin = i12;
            platformOverlayView.setLayoutParams(layoutParams);
            platformOverlayView.setVisibility(0);
            platformOverlayView.bringToFront();
            this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i10));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i10 + ") doesn't exist");
    }

    public void onDisplayPlatformView(int i10, int i11, int i12, int i13, int i14, int i15, int i16, @NonNull FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        initializePlatformViewIfNeeded(i10);
        FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i10);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i11, i12, i13, i14);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i15, i16);
        View view = this.platformViews.get(i10).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i10));
    }

    public void onEndFrame() {
        boolean z10 = false;
        if (this.flutterViewConvertedToImageView && this.currentFrameUsedPlatformViewIds.isEmpty()) {
            this.flutterViewConvertedToImageView = false;
            this.flutterView.revertImageView(new Runnable() { // from class: io.flutter.plugin.platform.g
                @Override // java.lang.Runnable
                public final void run() {
                    PlatformViewsController.this.lambda$onEndFrame$3();
                }
            });
        } else {
            if (this.flutterViewConvertedToImageView && this.flutterView.acquireLatestImageViewFrame()) {
                z10 = true;
            }
            finishFrame(z10);
        }
    }

    public void onPreEngineRestart() {
        diposeAllViews();
    }

    public void setSoftwareRendering(boolean z10) {
        this.usesSoftwareRendering = z10;
    }

    @VisibleForTesting
    public MotionEvent toMotionEvent(float f10, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z10) {
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch.motionEventId));
        if (!z10 && pop != null) {
            return pop;
        }
        return MotionEvent.obtain(platformViewTouch.downTime.longValue(), platformViewTouch.eventTime.longValue(), platformViewTouch.action, platformViewTouch.pointerCount, (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch.pointerCount]), (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch.rawPointerCoords, f10).toArray(new MotionEvent.PointerCoords[platformViewTouch.pointerCount]), platformViewTouch.metaState, platformViewTouch.buttonState, platformViewTouch.xPrecision, platformViewTouch.yPrecision, platformViewTouch.deviceId, platformViewTouch.edgeFlags, platformViewTouch.source, platformViewTouch.flags);
    }

    @Override // io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate
    public boolean usesVirtualDisplay(int i10) {
        return this.vdControllers.containsKey(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toLogicalPixels(double d10) {
        return toLogicalPixels(d10, getDisplayDensity());
    }

    @NonNull
    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new PlatformOverlayView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), this.accessibilityEventsDelegate));
    }
}

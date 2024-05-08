package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.quickcard.base.Attributes;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PlatformViewsChannel {
    private static final String TAG = "PlatformViewsChannel";
    private final MethodChannel channel;
    private PlatformViewsHandler handler;
    private final MethodChannel.MethodCallHandler parsingHandler;

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class AnonymousClass1 implements MethodChannel.MethodCallHandler {
        public AnonymousClass1() {
        }

        private void clearFocus(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void create(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            PlatformViewCreationRequest.RequestedDisplayMode requestedDisplayMode;
            Map map = (Map) methodCall.arguments();
            boolean z10 = true;
            boolean z11 = map.containsKey(com.baidu.mobads.sdk.internal.a.f9695g) && ((Boolean) map.get(com.baidu.mobads.sdk.internal.a.f9695g)).booleanValue();
            ByteBuffer wrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z11) {
                    PlatformViewsChannel.this.handler.createForPlatformViewLayer(new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get(bg.e.F), ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue(), PlatformViewCreationRequest.RequestedDisplayMode.HYBRID_ONLY, wrap));
                    result.success(null);
                    return;
                }
                if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                    z10 = false;
                }
                if (z10) {
                    requestedDisplayMode = PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK;
                } else {
                    requestedDisplayMode = PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK;
                }
                PlatformViewCreationRequest.RequestedDisplayMode requestedDisplayMode2 = requestedDisplayMode;
                int intValue = ((Integer) map.get("id")).intValue();
                String str = (String) map.get(bg.e.F);
                boolean containsKey = map.containsKey("top");
                double d10 = ShadowDrawableWrapper.COS_45;
                double doubleValue = containsKey ? ((Double) map.get("top")).doubleValue() : 0.0d;
                if (map.containsKey("left")) {
                    d10 = ((Double) map.get("left")).doubleValue();
                }
                long createForTextureLayer = PlatformViewsChannel.this.handler.createForTextureLayer(new PlatformViewCreationRequest(intValue, str, doubleValue, d10, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue(), requestedDisplayMode2, wrap));
                if (createForTextureLayer != -2) {
                    result.success(Long.valueOf(createForTextureLayer));
                } else {
                    if (z10) {
                        result.success(null);
                        return;
                    }
                    throw new AssertionError((Object) "Platform view attempted to fall back to hybrid mode when not requested.");
                }
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void dispose(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.dispose(((Integer) ((Map) methodCall.arguments()).get("id")).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$resize$0(MethodChannel.Result result, PlatformViewBufferSize platformViewBufferSize) {
            if (platformViewBufferSize == null) {
                result.error("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("width", Double.valueOf(platformViewBufferSize.width));
            hashMap.put("height", Double.valueOf(platformViewBufferSize.height));
            result.success(hashMap);
        }

        private void offset(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.offset(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void resize(@NonNull MethodCall methodCall, @NonNull final MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.resize(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new PlatformViewBufferResized() { // from class: io.flutter.embedding.engine.systemchannels.c
                    @Override // io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewBufferResized
                    public final void run(PlatformViewsChannel.PlatformViewBufferSize platformViewBufferSize) {
                        PlatformViewsChannel.AnonymousClass1.lambda$resize$0(MethodChannel.Result.this, platformViewBufferSize);
                    }
                });
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void setDirection(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)).intValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void synchronizeToNativeViewHierarchy(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.handler.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                result.success(null);
            } catch (IllegalStateException e2) {
                result.error("error", PlatformViewsChannel.detailedExceptionString(e2), null);
            }
        }

        private void touch(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            MethodChannel.Result result2;
            List list = (List) methodCall.arguments();
            try {
                PlatformViewsChannel.this.handler.onTouch(new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                result2 = result;
                try {
                    result2.success(null);
                } catch (IllegalStateException e2) {
                    e = e2;
                    result2.error("error", PlatformViewsChannel.detailedExceptionString(e), null);
                }
            } catch (IllegalStateException e10) {
                e = e10;
                result2 = result;
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
        public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
            if (PlatformViewsChannel.this.handler == null) {
                return;
            }
            Log.v(PlatformViewsChannel.TAG, "Received '" + methodCall.method + "' message.");
            String str = methodCall.method;
            str.hashCode();
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1019779949:
                    if (str.equals(Attributes.Style.OFFSET)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case -308988850:
                    if (str.equals("synchronizeToNativeViewHierarchy")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c4 = 7;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    create(methodCall, result);
                    return;
                case 1:
                    offset(methodCall, result);
                    return;
                case 2:
                    resize(methodCall, result);
                    return;
                case 3:
                    clearFocus(methodCall, result);
                    return;
                case 4:
                    synchronizeToNativeViewHierarchy(methodCall, result);
                    return;
                case 5:
                    touch(methodCall, result);
                    return;
                case 6:
                    setDirection(methodCall, result);
                    return;
                case 7:
                    dispose(methodCall, result);
                    return;
                default:
                    result.notImplemented();
                    return;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface PlatformViewBufferResized {
        void run(@Nullable PlatformViewBufferSize platformViewBufferSize);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class PlatformViewBufferSize {
        public final int height;
        public final int width;

        public PlatformViewBufferSize(int i10, int i11) {
            this.width = i10;
            this.height = i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class PlatformViewCreationRequest {
        public final int direction;
        public final RequestedDisplayMode displayMode;
        public final double logicalHeight;
        public final double logicalLeft;
        public final double logicalTop;
        public final double logicalWidth;

        @Nullable
        public final ByteBuffer params;
        public final int viewId;

        @NonNull
        public final String viewType;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public enum RequestedDisplayMode {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public PlatformViewCreationRequest(int i10, @NonNull String str, double d10, double d11, double d12, double d13, int i11, @Nullable ByteBuffer byteBuffer) {
            this(i10, str, d10, d11, d12, d13, i11, RequestedDisplayMode.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBuffer);
        }

        public PlatformViewCreationRequest(int i10, @NonNull String str, double d10, double d11, double d12, double d13, int i11, RequestedDisplayMode requestedDisplayMode, @Nullable ByteBuffer byteBuffer) {
            this.viewId = i10;
            this.viewType = str;
            this.logicalTop = d10;
            this.logicalLeft = d11;
            this.logicalWidth = d12;
            this.logicalHeight = d13;
            this.direction = i11;
            this.displayMode = requestedDisplayMode;
            this.params = byteBuffer;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i10, double d10, double d11) {
            this.viewId = i10;
            this.newLogicalWidth = d10;
            this.newLogicalHeight = d11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;

        @NonNull
        public final Number downTime;
        public final int edgeFlags;

        @NonNull
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;

        @NonNull
        public final Object rawPointerCoords;

        @NonNull
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i10, @NonNull Number number, @NonNull Number number2, int i11, int i12, @NonNull Object obj, @NonNull Object obj2, int i13, int i14, float f10, float f11, int i15, int i16, int i17, int i18, long j10) {
            this.viewId = i10;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i11;
            this.pointerCount = i12;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i13;
            this.buttonState = i14;
            this.xPrecision = f10;
            this.yPrecision = f11;
            this.deviceId = i15;
            this.edgeFlags = i16;
            this.source = i17;
            this.flags = i18;
            this.motionEventId = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface PlatformViewsHandler {
        public static final long NON_TEXTURE_FALLBACK = -2;

        void clearFocus(int i10);

        void createForPlatformViewLayer(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        long createForTextureLayer(@NonNull PlatformViewCreationRequest platformViewCreationRequest);

        void dispose(int i10);

        void offset(int i10, double d10, double d11);

        void onTouch(@NonNull PlatformViewTouch platformViewTouch);

        void resize(@NonNull PlatformViewResizeRequest platformViewResizeRequest, @NonNull PlatformViewBufferResized platformViewBufferResized);

        void setDirection(int i10, int i11);

        void synchronizeToNativeViewHierarchy(boolean z10);
    }

    public PlatformViewsChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.parsingHandler = anonymousClass1;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String detailedExceptionString(Exception exc) {
        return Log.getStackTraceString(exc);
    }

    public void invokeViewFocused(int i10) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            return;
        }
        methodChannel.invokeMethod("viewFocused", Integer.valueOf(i10));
    }

    public void setPlatformViewsHandler(@Nullable PlatformViewsHandler platformViewsHandler) {
        this.handler = platformViewsHandler;
    }
}

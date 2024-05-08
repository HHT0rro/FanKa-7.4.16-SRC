package android.view;

import android.graphics.Bitmap;
import android.graphics.HardwareRenderer;
import android.graphics.Rect;
import android.os.Handler;
import android.view.PixelCopy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class PixelCopy {
    public static final int ERROR_DESTINATION_INVALID = 5;
    public static final int ERROR_SOURCE_INVALID = 4;
    public static final int ERROR_SOURCE_NO_DATA = 3;
    public static final int ERROR_TIMEOUT = 2;
    public static final int ERROR_UNKNOWN = 1;
    public static final int SUCCESS = 0;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface CopyResultStatus {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnPixelCopyFinishedListener {
        void onPixelCopyFinished(int i10);
    }

    public static void request(SurfaceView source, Bitmap dest, OnPixelCopyFinishedListener listener, Handler listenerThread) {
        request(source.getHolder().getSurface(), dest, listener, listenerThread);
    }

    public static void request(SurfaceView source, Rect srcRect, Bitmap dest, OnPixelCopyFinishedListener listener, Handler listenerThread) {
        request(source.getHolder().getSurface(), srcRect, dest, listener, listenerThread);
    }

    public static void request(Surface source, Bitmap dest, OnPixelCopyFinishedListener listener, Handler listenerThread) {
        request(source, (Rect) null, dest, listener, listenerThread);
    }

    public static void request(Surface source, Rect srcRect, Bitmap dest, OnPixelCopyFinishedListener listener, Handler listenerThread) {
        validateBitmapDest(dest);
        if (!source.isValid()) {
            throw new IllegalArgumentException("Surface isn't valid, source.isValid() == false");
        }
        if (srcRect != null && srcRect.isEmpty()) {
            throw new IllegalArgumentException("sourceRect is empty");
        }
        HardwareRenderer.copySurfaceInto(source, new AnonymousClass1(srcRect, dest, listenerThread, listener));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: android.view.PixelCopy$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass1 extends HardwareRenderer.CopyRequest {
        final /* synthetic */ OnPixelCopyFinishedListener val$listener;
        final /* synthetic */ Handler val$listenerThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Rect srcRect, Bitmap destinationBitmap, Handler handler, OnPixelCopyFinishedListener onPixelCopyFinishedListener) {
            super(srcRect, destinationBitmap);
            this.val$listenerThread = handler;
            this.val$listener = onPixelCopyFinishedListener;
        }

        public void onCopyFinished(final int result) {
            Handler handler = this.val$listenerThread;
            final OnPixelCopyFinishedListener onPixelCopyFinishedListener = this.val$listener;
            handler.post(new Runnable() { // from class: android.view.PixelCopy$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PixelCopy.OnPixelCopyFinishedListener.this.onPixelCopyFinished(result);
                }
            });
        }
    }

    public static void request(Window source, Bitmap dest, OnPixelCopyFinishedListener listener, Handler listenerThread) {
        request(source, (Rect) null, dest, listener, listenerThread);
    }

    public static void request(Window source, Rect srcRect, Bitmap dest, OnPixelCopyFinishedListener listener, Handler listenerThread) {
        validateBitmapDest(dest);
        Rect insets = new Rect();
        Surface surface = sourceForWindow(source, insets);
        request(surface, adjustSourceRectForInsets(insets, srcRect), dest, listener, listenerThread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateBitmapDest(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("Bitmap cannot be null");
        }
        if (bitmap.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is recycled");
        }
        if (!bitmap.isMutable()) {
            throw new IllegalArgumentException("Bitmap is immutable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Surface sourceForWindow(Window source, Rect outInsets) {
        if (source == null) {
            throw new IllegalArgumentException("source is null");
        }
        if (source.peekDecorView() == null) {
            throw new IllegalArgumentException("Only able to copy windows with decor views");
        }
        Surface surface = null;
        ViewRootImpl root = source.peekDecorView().getViewRootImpl();
        if (root != null) {
            surface = root.mSurface;
            Rect surfaceInsets = root.mWindowAttributes.surfaceInsets;
            outInsets.set(surfaceInsets.left, surfaceInsets.top, root.mWidth + surfaceInsets.left, root.mHeight + surfaceInsets.top);
        }
        if (surface == null || !surface.isValid()) {
            throw new IllegalArgumentException("Window doesn't have a backing surface!");
        }
        return surface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect adjustSourceRectForInsets(Rect insets, Rect srcRect) {
        if (srcRect == null) {
            return insets;
        }
        if (insets != null) {
            srcRect.offset(insets.left, insets.top);
        }
        return srcRect;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Result {
        private Bitmap mBitmap;
        private int mStatus;

        private Result(int status, Bitmap bitmap) {
            this.mStatus = status;
            this.mBitmap = bitmap;
        }

        public int getStatus() {
            return this.mStatus;
        }

        private void validateStatus() {
            if (this.mStatus != 0) {
                throw new IllegalStateException("Copy request didn't succeed, status = " + this.mStatus);
            }
        }

        public Bitmap getBitmap() {
            validateStatus();
            return this.mBitmap;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Request {
        private Bitmap mDest;
        private final Surface mSource;
        private final Rect mSourceInsets;
        private Rect mSrcRect;

        private Request(Surface source, Rect sourceInsets) {
            this.mSource = source;
            this.mSourceInsets = sourceInsets;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public static final class Builder {
            private Request mRequest;

            private Builder(Request request) {
                this.mRequest = request;
            }

            public static Builder ofWindow(Window source) {
                Rect insets = new Rect();
                Surface surface = PixelCopy.sourceForWindow(source, insets);
                return new Builder(new Request(surface, insets));
            }

            public static Builder ofWindow(View source) {
                if (source == null || !source.isAttachedToWindow()) {
                    throw new IllegalArgumentException("View must not be null & must be attached to window");
                }
                Rect insets = new Rect();
                Surface surface = null;
                ViewRootImpl root = source.getViewRootImpl();
                if (root != null) {
                    surface = root.mSurface;
                    insets.set(root.mWindowAttributes.surfaceInsets);
                }
                if (surface == null || !surface.isValid()) {
                    throw new IllegalArgumentException("Window doesn't have a backing surface!");
                }
                return new Builder(new Request(surface, insets));
            }

            public static Builder ofSurface(Surface surface) {
                if (surface == null || !surface.isValid()) {
                    throw new IllegalArgumentException("Source must not be null & must be valid");
                }
                return new Builder(new Request(surface, null));
            }

            public static Builder ofSurface(SurfaceView source) {
                return ofSurface(source.getHolder().getSurface());
            }

            private void requireNotBuilt() {
                if (this.mRequest == null) {
                    throw new IllegalStateException("build() already called on this builder");
                }
            }

            public Builder setSourceRect(Rect srcRect) {
                requireNotBuilt();
                this.mRequest.mSrcRect = srcRect;
                return this;
            }

            public Builder setDestinationBitmap(Bitmap destination) {
                requireNotBuilt();
                if (destination != null) {
                    PixelCopy.validateBitmapDest(destination);
                }
                this.mRequest.mDest = destination;
                return this;
            }

            public Request build() {
                requireNotBuilt();
                Request ret = this.mRequest;
                this.mRequest = null;
                return ret;
            }
        }

        public Bitmap getDestinationBitmap() {
            return this.mDest;
        }

        public Rect getSourceRect() {
            return this.mSrcRect;
        }

        public void request(Executor callbackExecutor, final Consumer<Result> listener) {
            if (!this.mSource.isValid()) {
                callbackExecutor.execute(new Runnable() { // from class: android.view.PixelCopy$Request$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Consumer.this.accept(new PixelCopy.Result(4, null));
                    }
                });
            } else {
                HardwareRenderer.copySurfaceInto(this.mSource, new AnonymousClass1(PixelCopy.adjustSourceRectForInsets(this.mSourceInsets, this.mSrcRect), this.mDest, callbackExecutor, listener));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* renamed from: android.view.PixelCopy$Request$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public class AnonymousClass1 extends HardwareRenderer.CopyRequest {
            final /* synthetic */ Executor val$callbackExecutor;
            final /* synthetic */ Consumer val$listener;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Rect srcRect, Bitmap destinationBitmap, Executor executor, Consumer consumer) {
                super(srcRect, destinationBitmap);
                this.val$callbackExecutor = executor;
                this.val$listener = consumer;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onCopyFinished$0(Consumer listener, int result) {
                listener.accept(new Result(result, this.mDestinationBitmap));
            }

            public void onCopyFinished(final int result) {
                Executor executor = this.val$callbackExecutor;
                final Consumer consumer = this.val$listener;
                executor.execute(new Runnable() { // from class: android.view.PixelCopy$Request$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PixelCopy.Request.AnonymousClass1.this.lambda$onCopyFinished$0(consumer, result);
                    }
                });
            }
        }
    }

    public static void request(Request request, Executor callbackExecutor, Consumer<Result> listener) {
        request.request(callbackExecutor, listener);
    }

    private PixelCopy() {
    }
}

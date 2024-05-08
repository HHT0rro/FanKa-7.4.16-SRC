package io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";

    @NonNull
    private final FlutterJNI flutterJNI;

    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;

    @Nullable
    private Surface surface;

    @NonNull
    private final AtomicLong nextTextureId = new AtomicLong(0);
    private boolean isDisplayingFlutterUi = false;
    private int isRenderingToImageViewCount = 0;
    private Handler handler = new Handler();

    @NonNull
    private final Set<WeakReference<TextureRegistry.OnTrimMemoryListener>> onTrimMemoryListeners = new HashSet();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum DisplayFeatureState {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);

        public final int encodedValue;

        DisplayFeatureState(int i10) {
            this.encodedValue = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum DisplayFeatureType {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);

        public final int encodedValue;

        DisplayFeatureType(int i10) {
            this.encodedValue = i10;
        }
    }

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer {
        private static final int MAX_IMAGES = 4;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private ImageReader activeReader;

        /* renamed from: id, reason: collision with root package name */
        private final long f49974id;
        private PerImage lastConsumedImage;
        private PerImage lastProducedImage;
        private boolean released;
        private boolean ignoringFence = false;
        private int requestedWidth = 0;
        private int requestedHeight = 0;
        private final Set<ImageReader> readersToClose = new HashSet();
        private final Handler onImageAvailableHandler = new Handler();
        private final ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.ImageReaderSurfaceProducer.1
            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader imageReader) {
                Image image;
                try {
                    image = imageReader.acquireLatestImage();
                } catch (IllegalStateException e2) {
                    Log.e(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e2.toString());
                    image = null;
                }
                if (image == null) {
                    return;
                }
                ImageReaderSurfaceProducer imageReaderSurfaceProducer = ImageReaderSurfaceProducer.this;
                imageReaderSurfaceProducer.onImage(new PerImage(imageReader, image));
            }
        };

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class PerImage {
            public final Image image;
            public final ImageReader reader;

            public PerImage(ImageReader imageReader, Image image) {
                this.reader = imageReader;
                this.image = image;
            }

            public void close() {
                this.image.close();
                ImageReaderSurfaceProducer.this.maybeCloseReader(this.reader);
            }
        }

        public ImageReaderSurfaceProducer(long j10) {
            this.f49974id = j10;
        }

        private ImageReader createImageReader() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 33) {
                return createImageReader33();
            }
            if (i10 >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        private ImageReader createImageReader29() {
            ImageReader newInstance = ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 4, 256L);
            newInstance.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
            return newInstance;
        }

        private ImageReader createImageReader33() {
            ImageReader.Builder builder = new ImageReader.Builder(this.requestedWidth, this.requestedHeight);
            builder.setMaxImages(4);
            builder.setImageFormat(34);
            builder.setUsage(256L);
            ImageReader build = builder.build();
            build.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
            return build;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeCloseReader(ImageReader imageReader) {
            synchronized (this) {
                if (this.readersToClose.contains(imageReader)) {
                    PerImage perImage = this.lastConsumedImage;
                    if (perImage == null || perImage.reader != imageReader) {
                        PerImage perImage2 = this.lastProducedImage;
                        if (perImage2 == null || perImage2.reader != imageReader) {
                            this.readersToClose.remove(imageReader);
                            imageReader.close();
                        }
                    }
                }
            }
        }

        private void maybeCreateReader() {
            synchronized (this) {
                if (this.activeReader != null) {
                    return;
                }
                this.activeReader = createImageReader();
            }
        }

        private void maybeWaitOnFence(Image image) {
            boolean z10;
            if (image == null || (z10 = this.ignoringFence)) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                if (z10) {
                    return;
                }
                this.ignoringFence = true;
                Log.w(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onImage(PerImage perImage) {
            if (this.released) {
                return;
            }
            synchronized (this) {
                if (this.readersToClose.contains(perImage.reader)) {
                    Log.i(TAG, "Skipped frame because resize is in flight.");
                    perImage.close();
                    return;
                }
                PerImage perImage2 = this.lastProducedImage;
                this.lastProducedImage = perImage;
                if (perImage2 != null) {
                    Log.i(TAG, "Dropping rendered frame that was not acquired in time.");
                    perImage2.close();
                }
                FlutterRenderer.this.markTextureFrameAvailable(this.f49974id);
            }
        }

        private void releaseInternal() {
            this.released = true;
            PerImage perImage = this.lastProducedImage;
            if (perImage != null) {
                perImage.close();
                this.lastProducedImage = null;
            }
            PerImage perImage2 = this.lastConsumedImage;
            if (perImage2 != null) {
                perImage2.close();
                this.lastConsumedImage = null;
            }
            Iterator<ImageReader> iterator2 = this.readersToClose.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().close();
            }
            this.readersToClose.clear();
            ImageReader imageReader = this.activeReader;
            if (imageReader != null) {
                imageReader.close();
                this.activeReader = null;
            }
        }

        private void waitOnFence(Image image) {
            try {
                if (image.getFence().awaitForever()) {
                    return;
                }
                Log.e(TAG, "acquireLatestImage image's fence was never signalled.");
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            PerImage perImage;
            PerImage perImage2;
            synchronized (this) {
                perImage = this.lastProducedImage;
                this.lastProducedImage = null;
                perImage2 = this.lastConsumedImage;
                this.lastConsumedImage = perImage;
            }
            if (perImage2 != null) {
                perImage2.close();
            }
            if (perImage == null) {
                return null;
            }
            maybeWaitOnFence(perImage.image);
            return perImage.image;
        }

        @VisibleForTesting
        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.f49974id, FlutterRenderer.this.flutterJNI));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            maybeCreateReader();
            return this.activeReader.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer, io.flutter.view.TextureRegistry.TextureEntry
        public long id() {
            return this.f49974id;
        }

        @VisibleForTesting
        public int readersToCloseSize() {
            return this.readersToClose.size();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer, io.flutter.view.TextureRegistry.TextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer.this.unregisterTexture(this.f49974id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int i10, int i11) {
            if (this.requestedWidth == i10 && this.requestedHeight == i11) {
                return;
            }
            this.requestedHeight = i11;
            this.requestedWidth = i10;
            synchronized (this) {
                ImageReader imageReader = this.activeReader;
                if (imageReader != null) {
                    this.readersToClose.add(imageReader);
                    this.activeReader = null;
                }
            }
        }
    }

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";

        /* renamed from: id, reason: collision with root package name */
        private final long f49975id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        public ImageTextureRegistryEntry(long j10) {
            this.f49975id = j10;
        }

        private void maybeWaitOnFence(Image image) {
            boolean z10;
            if (image == null || (z10 = this.ignoringFence)) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                if (z10) {
                    return;
                }
                this.ignoringFence = true;
                Log.w(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        private void waitOnFence(Image image) {
            try {
                if (image.getFence().awaitForever()) {
                    return;
                }
                Log.e(TAG, "acquireLatestImage image's fence was never signalled.");
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image);
            return image;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.f49975id, FlutterRenderer.this.flutterJNI));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public long id() {
            return this.f49975id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image image2;
            if (this.released) {
                return;
            }
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                Log.e(TAG, "Dropping PlatformView Frame");
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.markTextureFrameAvailable(this.f49975id);
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer.this.unregisterTexture(this.f49975id);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.OnTrimMemoryListener {

        @Nullable
        private TextureRegistry.OnFrameConsumedListener frameConsumedListener;

        /* renamed from: id, reason: collision with root package name */
        private final long f49976id;
        private final Runnable onFrameConsumed;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener;
        private boolean released;

        @NonNull
        private final SurfaceTextureWrapper textureWrapper;

        @Nullable
        private TextureRegistry.OnTrimMemoryListener trimMemoryListener;

        public SurfaceTextureRegistryEntry(long j10, @NonNull SurfaceTexture surfaceTexture) {
            Runnable runnable = new Runnable() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SurfaceTextureRegistryEntry.this.frameConsumedListener != null) {
                        SurfaceTextureRegistryEntry.this.frameConsumedListener.onFrameConsumed();
                    }
                }
            };
            this.onFrameConsumed = runnable;
            this.onFrameListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture2) {
                    if (SurfaceTextureRegistryEntry.this.released || !FlutterRenderer.this.flutterJNI.isAttached()) {
                        return;
                    }
                    SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = SurfaceTextureRegistryEntry.this;
                    FlutterRenderer.this.markTextureFrameAvailable(surfaceTextureRegistryEntry.f49976id);
                }
            };
            this.f49976id = j10;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture, runnable);
            surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
        }

        private void removeListener() {
            FlutterRenderer.this.removeOnTrimMemoryListener(this);
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.f49976id, FlutterRenderer.this.flutterJNI));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public long id() {
            return this.f49976id;
        }

        @Override // io.flutter.view.TextureRegistry.OnTrimMemoryListener
        public void onTrimMemory(int i10) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = this.trimMemoryListener;
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(i10);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.f49976id + ").");
            this.textureWrapper.release();
            FlutterRenderer.this.unregisterTexture(this.f49976id);
            removeListener();
            this.released = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(@Nullable TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            this.frameConsumedListener = onFrameConsumedListener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnTrimMemoryListener(@Nullable TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
            this.trimMemoryListener = onTrimMemoryListener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        @NonNull
        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TextureFinalizerRunnable implements Runnable {
        private final FlutterJNI flutterJNI;

        /* renamed from: id, reason: collision with root package name */
        private final long f49977id;

        public TextureFinalizerRunnable(long j10, @NonNull FlutterJNI flutterJNI) {
            this.f49977id = j10;
            this.flutterJNI = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.flutterJNI.isAttached()) {
                Log.v(FlutterRenderer.TAG, "Releasing a Texture (" + this.f49977id + ").");
                this.flutterJNI.unregisterTexture(this.f49977id);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public int width = 0;
        public int height = 0;
        public int viewPaddingTop = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewInsetTop = 0;
        public int viewInsetRight = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int systemGestureInsetTop = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int physicalTouchSlop = -1;
        public List<DisplayFeature> displayFeatures = new ArrayList();

        public boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI) {
        FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.1
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = flutterUiDisplayListener;
        this.flutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    private void clearDeadListeners() {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> iterator2 = this.onTrimMemoryListeners.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().get() == null) {
                iterator2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markTextureFrameAvailable(long j10) {
        this.flutterJNI.markTextureFrameAvailable(j10);
    }

    private void registerImageTexture(long j10, @NonNull TextureRegistry.ImageConsumer imageConsumer) {
        this.flutterJNI.registerImageTexture(j10, imageConsumer);
    }

    private void registerTexture(long j10, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        this.flutterJNI.registerTexture(j10, surfaceTextureWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTexture(long j10) {
        this.flutterJNI.unregisterTexture(j10);
    }

    public void SetRenderingToImageView(boolean z10) {
        if (z10) {
            this.isRenderingToImageViewCount++;
        } else {
            this.isRenderingToImageViewCount--;
        }
        this.flutterJNI.SetIsRenderingToImageView(this.isRenderingToImageViewCount > 0);
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    @VisibleForTesting
    public void addOnTrimMemoryListener(@NonNull TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
        clearDeadListeners();
        this.onTrimMemoryListeners.add(new WeakReference<>(onTrimMemoryListener));
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry createImageTexture() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.nextTextureId.getAndIncrement());
        Log.v(TAG, "New ImageTextureEntry ID: " + imageTextureRegistryEntry.id());
        registerImageTexture(imageTextureRegistryEntry.id(), imageTextureRegistryEntry);
        return imageTextureRegistryEntry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer createSurfaceProducer() {
        ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(this.nextTextureId.getAndIncrement());
        Log.v(TAG, "New SurfaceProducer ID: " + imageReaderSurfaceProducer.id());
        registerImageTexture(imageReaderSurfaceProducer.id(), imageReaderSurfaceProducer);
        return imageReaderSurfaceProducer;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i10) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i10);
    }

    public void dispatchSemanticsAction(int i10, int i11, @Nullable ByteBuffer byteBuffer, int i12) {
        this.flutterJNI.dispatchSemanticsAction(i10, i11, byteBuffer, i12);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    @Override // io.flutter.view.TextureRegistry
    public void onTrimMemory(int i10) {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> iterator2 = this.onTrimMemoryListeners.iterator2();
        while (iterator2.hasNext()) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = iterator2.next().get();
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(i10);
            } else {
                iterator2.remove();
            }
        }
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
        registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        addOnTrimMemoryListener(surfaceTextureRegistryEntry);
        return surfaceTextureRegistryEntry;
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    @VisibleForTesting
    public void removeOnTrimMemoryListener(@NonNull TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
        for (WeakReference<TextureRegistry.OnTrimMemoryListener> weakReference : this.onTrimMemoryListeners) {
            if (weakReference.get() == onTrimMemoryListener) {
                this.onTrimMemoryListeners.remove(weakReference);
                return;
            }
        }
    }

    public void setAccessibilityFeatures(int i10) {
        this.flutterJNI.setAccessibilityFeatures(i10);
    }

    public void setSemanticsEnabled(boolean z10) {
        this.flutterJNI.setSemanticsEnabled(z10);
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        if (viewportMetrics.validate()) {
            Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.viewPaddingLeft + ", T: " + viewportMetrics.viewPaddingTop + ", R: " + viewportMetrics.viewPaddingRight + ", B: " + viewportMetrics.viewPaddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.systemGestureInsetRight + "\nDisplay Features: " + viewportMetrics.displayFeatures.size());
            int[] iArr = new int[viewportMetrics.displayFeatures.size() * 4];
            int[] iArr2 = new int[viewportMetrics.displayFeatures.size()];
            int[] iArr3 = new int[viewportMetrics.displayFeatures.size()];
            for (int i10 = 0; i10 < viewportMetrics.displayFeatures.size(); i10++) {
                DisplayFeature displayFeature = viewportMetrics.displayFeatures.get(i10);
                int i11 = i10 * 4;
                Rect rect = displayFeature.bounds;
                iArr[i11] = rect.left;
                iArr[i11 + 1] = rect.top;
                iArr[i11 + 2] = rect.right;
                iArr[i11 + 3] = rect.bottom;
                iArr2[i10] = displayFeature.type.encodedValue;
                iArr3[i10] = displayFeature.state.encodedValue;
            }
            this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.viewPaddingTop, viewportMetrics.viewPaddingRight, viewportMetrics.viewPaddingBottom, viewportMetrics.viewPaddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft, viewportMetrics.physicalTouchSlop, iArr, iArr2, iArr3);
        }
    }

    public void startRenderingToSurface(@NonNull Surface surface, boolean z10) {
        if (!z10) {
            stopRenderingToSurface();
        }
        this.surface = surface;
        if (z10) {
            this.flutterJNI.onSurfaceWindowChanged(surface);
        } else {
            this.flutterJNI.onSurfaceCreated(surface);
        }
    }

    public void stopRenderingToSurface() {
        if (this.surface != null) {
            this.flutterJNI.onSurfaceDestroyed();
            if (this.isDisplayingFlutterUi) {
                this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
            this.isDisplayingFlutterUi = false;
            this.surface = null;
        }
    }

    public void surfaceChanged(int i10, int i11) {
        this.flutterJNI.onSurfaceChanged(i10, i11);
    }

    public void swapSurface(@NonNull Surface surface) {
        this.surface = surface;
        this.flutterJNI.onSurfaceWindowChanged(surface);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DisplayFeature {
        public final Rect bounds;
        public final DisplayFeatureState state;
        public final DisplayFeatureType type;

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType, DisplayFeatureState displayFeatureState) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = displayFeatureState;
        }

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = DisplayFeatureState.UNKNOWN;
        }
    }
}

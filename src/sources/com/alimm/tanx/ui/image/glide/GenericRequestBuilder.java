package com.alimm.tanx.ui.image.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.MultiTransformation;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.manager.Lifecycle;
import com.alimm.tanx.ui.image.glide.manager.RequestTracker;
import com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.GenericRequest;
import com.alimm.tanx.ui.image.glide.request.Request;
import com.alimm.tanx.ui.image.glide.request.RequestCoordinator;
import com.alimm.tanx.ui.image.glide.request.RequestFutureTarget;
import com.alimm.tanx.ui.image.glide.request.RequestListener;
import com.alimm.tanx.ui.image.glide.request.ThumbnailRequestCoordinator;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.animation.NoAnimation;
import com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation;
import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.target.PreloadTarget;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import com.alimm.tanx.ui.image.glide.signature.EmptySignature;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.File;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    public GlideAnimationFactory<TranscodeType> animationFactory;
    public final Context context;
    public DiskCacheStrategy diskCacheStrategy;
    public int errorId;
    public Drawable errorPlaceholder;
    public Drawable fallbackDrawable;
    public int fallbackResource;
    public final Glide glide;
    public boolean isCacheable;
    public boolean isModelSet;
    public boolean isThumbnailBuilt;
    public boolean isTransformationSet;
    public final Lifecycle lifecycle;
    public ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider;
    public ModelType model;
    public final Class<ModelType> modelClass;
    public int overrideHeight;
    public int overrideWidth;
    public Drawable placeholderDrawable;
    public int placeholderId;
    public Priority priority;
    public RequestListener<? super ModelType, TranscodeType> requestListener;
    public final RequestTracker requestTracker;
    public Key signature;
    public Float sizeMultiplier;
    public Float thumbSizeMultiplier;
    public GenericRequestBuilder<?, ?, ?, TranscodeType> thumbnailRequestBuilder;
    public final Class<TranscodeType> transcodeClass;
    public Transformation<ResourceType> transformation;

    /* renamed from: com.alimm.tanx.ui.image.glide.GenericRequestBuilder$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public GenericRequestBuilder(LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        this(genericRequestBuilder.context, genericRequestBuilder.modelClass, loadProvider, cls, genericRequestBuilder.glide, genericRequestBuilder.requestTracker, genericRequestBuilder.lifecycle);
        this.model = genericRequestBuilder.model;
        this.isModelSet = genericRequestBuilder.isModelSet;
        this.signature = genericRequestBuilder.signature;
        this.diskCacheStrategy = genericRequestBuilder.diskCacheStrategy;
        this.isCacheable = genericRequestBuilder.isCacheable;
    }

    private Request buildRequest(Target<TranscodeType> target) {
        if (this.priority == null) {
            this.priority = Priority.NORMAL;
        }
        return buildRequestRecursive(target, null);
    }

    private Request buildRequestRecursive(Target<TranscodeType> target, ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder = this.thumbnailRequestBuilder;
        if (genericRequestBuilder != null) {
            if (!this.isThumbnailBuilt) {
                if (genericRequestBuilder.animationFactory.equals(NoAnimation.getFactory())) {
                    this.thumbnailRequestBuilder.animationFactory = this.animationFactory;
                }
                GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder2 = this.thumbnailRequestBuilder;
                if (genericRequestBuilder2.priority == null) {
                    genericRequestBuilder2.priority = getThumbnailPriority();
                }
                if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder3 = this.thumbnailRequestBuilder;
                    if (!Util.isValidDimensions(genericRequestBuilder3.overrideWidth, genericRequestBuilder3.overrideHeight)) {
                        this.thumbnailRequestBuilder.override(this.overrideWidth, this.overrideHeight);
                    }
                }
                ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
                Request obtainRequest = obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator2);
                this.isThumbnailBuilt = true;
                Request buildRequestRecursive = this.thumbnailRequestBuilder.buildRequestRecursive(target, thumbnailRequestCoordinator2);
                this.isThumbnailBuilt = false;
                thumbnailRequestCoordinator2.setRequests(obtainRequest, buildRequestRecursive);
                return thumbnailRequestCoordinator2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.thumbSizeMultiplier != null) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
            thumbnailRequestCoordinator3.setRequests(obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator3), obtainRequest(target, this.thumbSizeMultiplier.floatValue(), getThumbnailPriority(), thumbnailRequestCoordinator3));
            return thumbnailRequestCoordinator3;
        }
        return obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator);
    }

    private Priority getThumbnailPriority() {
        Priority priority = this.priority;
        if (priority == Priority.LOW) {
            return Priority.NORMAL;
        }
        if (priority == Priority.NORMAL) {
            return Priority.HIGH;
        }
        return Priority.IMMEDIATE;
    }

    private Request obtainRequest(Target<TranscodeType> target, float f10, Priority priority, RequestCoordinator requestCoordinator) {
        return GenericRequest.obtain(this.loadProvider, this.model, this.signature, this.context, priority, target, f10, this.placeholderDrawable, this.placeholderId, this.errorPlaceholder, this.errorId, this.fallbackDrawable, this.fallbackResource, this.requestListener, requestCoordinator, this.glide.getEngine(), this.transformation, this.transcodeClass, this.isCacheable, this.animationFactory, this.overrideWidth, this.overrideHeight, this.diskCacheStrategy);
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(int i10) {
        return animate(new ViewAnimationFactory(this.context, i10));
    }

    public void applyCenterCrop() {
    }

    public void applyFitCenter() {
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> cacheDecoder(ResourceDecoder<File, ResourceType> resourceDecoder) {
        ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setCacheDecoder(resourceDecoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> decoder(ResourceDecoder<DataType, ResourceType> resourceDecoder) {
        ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setSourceDecoder(resourceDecoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        this.diskCacheStrategy = diskCacheStrategy;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> dontAnimate() {
        return animate(NoAnimation.getFactory());
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> dontTransform() {
        return transform(UnitTransformation.get());
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> encoder(ResourceEncoder<ResourceType> resourceEncoder) {
        ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setEncoder(resourceEncoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> error(int i10) {
        this.errorId = i10;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> fallback(Drawable drawable) {
        this.fallbackDrawable = drawable;
        return this;
    }

    public <Y extends Target<TranscodeType>> Y into(Y y10) {
        Util.assertMainThread();
        if (y10 != null) {
            if (this.isModelSet) {
                Request request = y10.getRequest();
                if (request != null) {
                    request.clear();
                    this.requestTracker.removeRequest(request);
                    request.recycle();
                }
                Request buildRequest = buildRequest(y10);
                y10.setRequest(buildRequest);
                this.lifecycle.addListener(y10);
                this.requestTracker.runRequest(buildRequest);
                return y10;
            }
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        throw new IllegalArgumentException("You must pass in a non null Target");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> listener(RequestListener<? super ModelType, TranscodeType> requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> load(ModelType modeltype) {
        this.model = modeltype;
        this.isModelSet = true;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> override(int i10, int i11) {
        if (Util.isValidDimensions(i10, i11)) {
            this.overrideWidth = i10;
            this.overrideHeight = i11;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> placeholder(int i10) {
        this.placeholderId = i10;
        return this;
    }

    public Target<TranscodeType> preload(int i10, int i11) {
        return into((GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType>) PreloadTarget.obtain(i10, i11));
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> priority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> signature(Key key) {
        Objects.requireNonNull(key, "Signature must not be null");
        this.signature = key;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> sizeMultiplier(float f10) {
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.sizeMultiplier = Float.valueOf(f10);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> skipMemoryCache(boolean z10) {
        this.isCacheable = !z10;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> sourceEncoder(Encoder<DataType> encoder) {
        ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setSourceEncoder(encoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> thumbnail(GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        if (!equals(genericRequestBuilder)) {
            this.thumbnailRequestBuilder = genericRequestBuilder;
            return this;
        }
        throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcoder(ResourceTranscoder<ResourceType, TranscodeType> resourceTranscoder) {
        ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setTranscoder(resourceTranscoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transform(Transformation<ResourceType>... transformationArr) {
        this.isTransformationSet = true;
        if (transformationArr.length == 1) {
            this.transformation = transformationArr[0];
        } else {
            this.transformation = new MultiTransformation(transformationArr);
        }
        return this;
    }

    @Deprecated
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(Animation animation) {
        return animate(new ViewAnimationFactory(animation));
    }

    @Override // 
    /* renamed from: clone */
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo1954clone() {
        try {
            GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> genericRequestBuilder = (GenericRequestBuilder) super.clone();
            ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
            genericRequestBuilder.loadProvider = childLoadProvider != null ? childLoadProvider.m1955clone() : null;
            return genericRequestBuilder;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> error(Drawable drawable) {
        this.errorPlaceholder = drawable;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> fallback(int i10) {
        this.fallbackResource = i10;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> placeholder(Drawable drawable) {
        this.placeholderDrawable = drawable;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(ViewPropertyAnimation.Animator animator) {
        return animate(new ViewPropertyAnimationFactory(animator));
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        Objects.requireNonNull(glideAnimationFactory, "Animation factory must not be null!");
        this.animationFactory = glideAnimationFactory;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> thumbnail(float f10) {
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.thumbSizeMultiplier = Float.valueOf(f10);
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public GenericRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> cls2, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        this.signature = EmptySignature.obtain();
        this.sizeMultiplier = Float.valueOf(1.0f);
        this.priority = null;
        this.isCacheable = true;
        this.animationFactory = NoAnimation.getFactory();
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.diskCacheStrategy = DiskCacheStrategy.RESULT;
        this.transformation = UnitTransformation.get();
        this.context = context;
        this.modelClass = cls;
        this.transcodeClass = cls2;
        this.glide = glide;
        this.requestTracker = requestTracker;
        this.lifecycle = lifecycle;
        this.loadProvider = loadProvider != null ? new ChildLoadProvider<>(loadProvider) : null;
        Objects.requireNonNull(context, "Context can't be null");
        if (cls != null) {
            Objects.requireNonNull(loadProvider, "LoadProvider must not be null");
        }
    }

    public Target<TranscodeType> into(ImageView imageView) {
        Util.assertMainThread();
        if (imageView != null) {
            if (!this.isTransformationSet && imageView.getScaleType() != null) {
                int i10 = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
                if (i10 == 1) {
                    applyCenterCrop();
                } else if (i10 == 2 || i10 == 3 || i10 == 4) {
                    applyFitCenter();
                }
            }
            return into((GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType>) this.glide.buildImageViewTarget(imageView, this.transcodeClass));
        }
        throw new IllegalArgumentException("You must pass in a non null View");
    }

    public FutureTarget<TranscodeType> into(int i10, int i11) {
        final RequestFutureTarget requestFutureTarget = new RequestFutureTarget(this.glide.getMainHandler(), i10, i11);
        this.glide.getMainHandler().post(new Runnable() { // from class: com.alimm.tanx.ui.image.glide.GenericRequestBuilder.1
            @Override // java.lang.Runnable
            public void run() {
                if (requestFutureTarget.isCancelled()) {
                    return;
                }
                GenericRequestBuilder.this.into((GenericRequestBuilder) requestFutureTarget);
            }
        });
        return requestFutureTarget;
    }
}

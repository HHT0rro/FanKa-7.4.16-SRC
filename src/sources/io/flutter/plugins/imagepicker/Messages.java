package io.flutter.plugins.imagepicker;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.imagepicker.Messages;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Messages {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CacheRetrievalError {

        @NonNull
        private String code;

        @Nullable
        private String message;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private String code;

            @Nullable
            private String message;

            @NonNull
            public CacheRetrievalError build() {
                CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
                cacheRetrievalError.setCode(this.code);
                cacheRetrievalError.setMessage(this.message);
                return cacheRetrievalError;
            }

            @NonNull
            public Builder setCode(@NonNull String str) {
                this.code = str;
                return this;
            }

            @NonNull
            public Builder setMessage(@Nullable String str) {
                this.message = str;
                return this;
            }
        }

        @NonNull
        public static CacheRetrievalError fromList(@NonNull ArrayList<Object> arrayList) {
            CacheRetrievalError cacheRetrievalError = new CacheRetrievalError();
            cacheRetrievalError.setCode((String) arrayList.get(0));
            cacheRetrievalError.setMessage((String) arrayList.get(1));
            return cacheRetrievalError;
        }

        @NonNull
        public String getCode() {
            return this.code;
        }

        @Nullable
        public String getMessage() {
            return this.message;
        }

        public void setCode(@NonNull String str) {
            if (str != null) {
                this.code = str;
                return;
            }
            throw new IllegalStateException("Nonnull field \"code\" is null.");
        }

        public void setMessage(@Nullable String str) {
            this.message = str;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.code);
            arrayList.add(this.message);
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CacheRetrievalResult {

        @Nullable
        private CacheRetrievalError error;

        @NonNull
        private List<String> paths;

        @NonNull
        private CacheRetrievalType type;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private CacheRetrievalError error;

            @Nullable
            private List<String> paths;

            @Nullable
            private CacheRetrievalType type;

            @NonNull
            public CacheRetrievalResult build() {
                CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
                cacheRetrievalResult.setType(this.type);
                cacheRetrievalResult.setError(this.error);
                cacheRetrievalResult.setPaths(this.paths);
                return cacheRetrievalResult;
            }

            @NonNull
            public Builder setError(@Nullable CacheRetrievalError cacheRetrievalError) {
                this.error = cacheRetrievalError;
                return this;
            }

            @NonNull
            public Builder setPaths(@NonNull List<String> list) {
                this.paths = list;
                return this;
            }

            @NonNull
            public Builder setType(@NonNull CacheRetrievalType cacheRetrievalType) {
                this.type = cacheRetrievalType;
                return this;
            }
        }

        @NonNull
        public static CacheRetrievalResult fromList(@NonNull ArrayList<Object> arrayList) {
            CacheRetrievalResult cacheRetrievalResult = new CacheRetrievalResult();
            Object obj = arrayList.get(0);
            cacheRetrievalResult.setType(obj == null ? null : CacheRetrievalType.values()[((Integer) obj).intValue()]);
            Object obj2 = arrayList.get(1);
            cacheRetrievalResult.setError(obj2 != null ? CacheRetrievalError.fromList((ArrayList) obj2) : null);
            cacheRetrievalResult.setPaths((List) arrayList.get(2));
            return cacheRetrievalResult;
        }

        @Nullable
        public CacheRetrievalError getError() {
            return this.error;
        }

        @NonNull
        public List<String> getPaths() {
            return this.paths;
        }

        @NonNull
        public CacheRetrievalType getType() {
            return this.type;
        }

        public void setError(@Nullable CacheRetrievalError cacheRetrievalError) {
            this.error = cacheRetrievalError;
        }

        public void setPaths(@NonNull List<String> list) {
            if (list != null) {
                this.paths = list;
                return;
            }
            throw new IllegalStateException("Nonnull field \"paths\" is null.");
        }

        public void setType(@NonNull CacheRetrievalType cacheRetrievalType) {
            if (cacheRetrievalType != null) {
                this.type = cacheRetrievalType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            CacheRetrievalType cacheRetrievalType = this.type;
            arrayList.add(cacheRetrievalType == null ? null : Integer.valueOf(cacheRetrievalType.index));
            CacheRetrievalError cacheRetrievalError = this.error;
            arrayList.add(cacheRetrievalError != null ? cacheRetrievalError.toList() : null);
            arrayList.add(this.paths);
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum CacheRetrievalType {
        IMAGE(0),
        VIDEO(1);

        public final int index;

        CacheRetrievalType(int i10) {
            this.index = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class GeneralOptions {

        @NonNull
        private Boolean allowMultiple;

        @NonNull
        private Boolean usePhotoPicker;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private Boolean allowMultiple;

            @Nullable
            private Boolean usePhotoPicker;

            @NonNull
            public GeneralOptions build() {
                GeneralOptions generalOptions = new GeneralOptions();
                generalOptions.setAllowMultiple(this.allowMultiple);
                generalOptions.setUsePhotoPicker(this.usePhotoPicker);
                return generalOptions;
            }

            @NonNull
            public Builder setAllowMultiple(@NonNull Boolean bool) {
                this.allowMultiple = bool;
                return this;
            }

            @NonNull
            public Builder setUsePhotoPicker(@NonNull Boolean bool) {
                this.usePhotoPicker = bool;
                return this;
            }
        }

        @NonNull
        public static GeneralOptions fromList(@NonNull ArrayList<Object> arrayList) {
            GeneralOptions generalOptions = new GeneralOptions();
            generalOptions.setAllowMultiple((Boolean) arrayList.get(0));
            generalOptions.setUsePhotoPicker((Boolean) arrayList.get(1));
            return generalOptions;
        }

        @NonNull
        public Boolean getAllowMultiple() {
            return this.allowMultiple;
        }

        @NonNull
        public Boolean getUsePhotoPicker() {
            return this.usePhotoPicker;
        }

        public void setAllowMultiple(@NonNull Boolean bool) {
            if (bool != null) {
                this.allowMultiple = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"allowMultiple\" is null.");
        }

        public void setUsePhotoPicker(@NonNull Boolean bool) {
            if (bool != null) {
                this.usePhotoPicker = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"usePhotoPicker\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.allowMultiple);
            arrayList.add(this.usePhotoPicker);
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ImagePickerApi {

        /* renamed from: io.flutter.plugins.imagepicker.Messages$ImagePickerApi$-CC, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final /* synthetic */ class CC {
            @NonNull
            public static MessageCodec<Object> a() {
                return ImagePickerApiCodec.INSTANCE;
            }

            public static /* synthetic */ void b(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
                final ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) obj;
                imagePickerApi.pickImages((SourceSpecification) arrayList2.get(0), (ImageSelectionOptions) arrayList2.get(1), (GeneralOptions) arrayList2.get(2), new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.1
                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void error(Throwable th) {
                        reply.reply(Messages.wrapError(th));
                    }

                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void success(List<String> list) {
                        ArrayList.this.add(0, list);
                        reply.reply(ArrayList.this);
                    }
                });
            }

            public static /* synthetic */ void c(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
                final ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) obj;
                imagePickerApi.pickVideos((SourceSpecification) arrayList2.get(0), (VideoSelectionOptions) arrayList2.get(1), (GeneralOptions) arrayList2.get(2), new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.2
                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void error(Throwable th) {
                        reply.reply(Messages.wrapError(th));
                    }

                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void success(List<String> list) {
                        ArrayList.this.add(0, list);
                        reply.reply(ArrayList.this);
                    }
                });
            }

            public static /* synthetic */ void d(ImagePickerApi imagePickerApi, Object obj, final BasicMessageChannel.Reply reply) {
                final ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) obj;
                imagePickerApi.pickMedia((MediaSelectionOptions) arrayList2.get(0), (GeneralOptions) arrayList2.get(1), new Result<List<String>>() { // from class: io.flutter.plugins.imagepicker.Messages.ImagePickerApi.3
                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void error(Throwable th) {
                        reply.reply(Messages.wrapError(th));
                    }

                    @Override // io.flutter.plugins.imagepicker.Messages.Result
                    public void success(List<String> list) {
                        ArrayList.this.add(0, list);
                        reply.reply(ArrayList.this);
                    }
                });
            }

            public static /* synthetic */ void e(ImagePickerApi imagePickerApi, Object obj, BasicMessageChannel.Reply reply) {
                ArrayList<Object> arrayList = new ArrayList<>();
                try {
                    arrayList.add(0, imagePickerApi.retrieveLostResults());
                } catch (Throwable th) {
                    arrayList = Messages.wrapError(th);
                }
                reply.reply(arrayList);
            }

            public static void f(@NonNull BinaryMessenger binaryMessenger, @Nullable final ImagePickerApi imagePickerApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.pickImages", a(), binaryMessenger.makeBackgroundTaskQueue());
                if (imagePickerApi != null) {
                    basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.j
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.b(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    basicMessageChannel.setMessageHandler(null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.pickVideos", a(), binaryMessenger.makeBackgroundTaskQueue());
                if (imagePickerApi != null) {
                    basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.k
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.c(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    basicMessageChannel2.setMessageHandler(null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.pickMedia", a());
                if (imagePickerApi != null) {
                    basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.l
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.d(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    basicMessageChannel3.setMessageHandler(null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.ImagePickerApi.retrieveLostResults", a(), binaryMessenger.makeBackgroundTaskQueue());
                if (imagePickerApi != null) {
                    basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.imagepicker.m
                        @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                        public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                            Messages.ImagePickerApi.CC.e(Messages.ImagePickerApi.this, obj, reply);
                        }
                    });
                } else {
                    basicMessageChannel4.setMessageHandler(null);
                }
            }
        }

        void pickImages(@NonNull SourceSpecification sourceSpecification, @NonNull ImageSelectionOptions imageSelectionOptions, @NonNull GeneralOptions generalOptions, @NonNull Result<List<String>> result);

        void pickMedia(@NonNull MediaSelectionOptions mediaSelectionOptions, @NonNull GeneralOptions generalOptions, @NonNull Result<List<String>> result);

        void pickVideos(@NonNull SourceSpecification sourceSpecification, @NonNull VideoSelectionOptions videoSelectionOptions, @NonNull GeneralOptions generalOptions, @NonNull Result<List<String>> result);

        @Nullable
        CacheRetrievalResult retrieveLostResults();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ImagePickerApiCodec extends StandardMessageCodec {
        public static final ImagePickerApiCodec INSTANCE = new ImagePickerApiCodec();

        private ImagePickerApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b4, @NonNull ByteBuffer byteBuffer) {
            switch (b4) {
                case Byte.MIN_VALUE:
                    return CacheRetrievalError.fromList((ArrayList) readValue(byteBuffer));
                case -127:
                    return CacheRetrievalResult.fromList((ArrayList) readValue(byteBuffer));
                case -126:
                    return GeneralOptions.fromList((ArrayList) readValue(byteBuffer));
                case -125:
                    return ImageSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -124:
                    return MediaSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                case -123:
                    return SourceSpecification.fromList((ArrayList) readValue(byteBuffer));
                case -122:
                    return VideoSelectionOptions.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b4, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CacheRetrievalError) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((CacheRetrievalError) obj).toList());
                return;
            }
            if (obj instanceof CacheRetrievalResult) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((CacheRetrievalResult) obj).toList());
                return;
            }
            if (obj instanceof GeneralOptions) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((GeneralOptions) obj).toList());
                return;
            }
            if (obj instanceof ImageSelectionOptions) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((ImageSelectionOptions) obj).toList());
                return;
            }
            if (obj instanceof MediaSelectionOptions) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, ((MediaSelectionOptions) obj).toList());
            } else if (obj instanceof SourceSpecification) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, ((SourceSpecification) obj).toList());
            } else if (obj instanceof VideoSelectionOptions) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, ((VideoSelectionOptions) obj).toList());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ImageSelectionOptions {

        @Nullable
        private Double maxHeight;

        @Nullable
        private Double maxWidth;

        @NonNull
        private Long quality;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private Double maxHeight;

            @Nullable
            private Double maxWidth;

            @Nullable
            private Long quality;

            @NonNull
            public ImageSelectionOptions build() {
                ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
                imageSelectionOptions.setMaxWidth(this.maxWidth);
                imageSelectionOptions.setMaxHeight(this.maxHeight);
                imageSelectionOptions.setQuality(this.quality);
                return imageSelectionOptions;
            }

            @NonNull
            public Builder setMaxHeight(@Nullable Double d10) {
                this.maxHeight = d10;
                return this;
            }

            @NonNull
            public Builder setMaxWidth(@Nullable Double d10) {
                this.maxWidth = d10;
                return this;
            }

            @NonNull
            public Builder setQuality(@NonNull Long l10) {
                this.quality = l10;
                return this;
            }
        }

        @NonNull
        public static ImageSelectionOptions fromList(@NonNull ArrayList<Object> arrayList) {
            Long valueOf;
            ImageSelectionOptions imageSelectionOptions = new ImageSelectionOptions();
            imageSelectionOptions.setMaxWidth((Double) arrayList.get(0));
            imageSelectionOptions.setMaxHeight((Double) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                valueOf = null;
            } else {
                valueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            imageSelectionOptions.setQuality(valueOf);
            return imageSelectionOptions;
        }

        @Nullable
        public Double getMaxHeight() {
            return this.maxHeight;
        }

        @Nullable
        public Double getMaxWidth() {
            return this.maxWidth;
        }

        @NonNull
        public Long getQuality() {
            return this.quality;
        }

        public void setMaxHeight(@Nullable Double d10) {
            this.maxHeight = d10;
        }

        public void setMaxWidth(@Nullable Double d10) {
            this.maxWidth = d10;
        }

        public void setQuality(@NonNull Long l10) {
            if (l10 != null) {
                this.quality = l10;
                return;
            }
            throw new IllegalStateException("Nonnull field \"quality\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.maxWidth);
            arrayList.add(this.maxHeight);
            arrayList.add(this.quality);
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MediaSelectionOptions {

        @NonNull
        private ImageSelectionOptions imageSelectionOptions;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private ImageSelectionOptions imageSelectionOptions;

            @NonNull
            public MediaSelectionOptions build() {
                MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
                mediaSelectionOptions.setImageSelectionOptions(this.imageSelectionOptions);
                return mediaSelectionOptions;
            }

            @NonNull
            public Builder setImageSelectionOptions(@NonNull ImageSelectionOptions imageSelectionOptions) {
                this.imageSelectionOptions = imageSelectionOptions;
                return this;
            }
        }

        @NonNull
        public static MediaSelectionOptions fromList(@NonNull ArrayList<Object> arrayList) {
            MediaSelectionOptions mediaSelectionOptions = new MediaSelectionOptions();
            Object obj = arrayList.get(0);
            mediaSelectionOptions.setImageSelectionOptions(obj == null ? null : ImageSelectionOptions.fromList((ArrayList) obj));
            return mediaSelectionOptions;
        }

        @NonNull
        public ImageSelectionOptions getImageSelectionOptions() {
            return this.imageSelectionOptions;
        }

        public void setImageSelectionOptions(@NonNull ImageSelectionOptions imageSelectionOptions) {
            if (imageSelectionOptions != null) {
                this.imageSelectionOptions = imageSelectionOptions;
                return;
            }
            throw new IllegalStateException("Nonnull field \"imageSelectionOptions\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            ImageSelectionOptions imageSelectionOptions = this.imageSelectionOptions;
            arrayList.add(imageSelectionOptions == null ? null : imageSelectionOptions.toList());
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Result<T> {
        void error(@NonNull Throwable th);

        void success(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum SourceCamera {
        REAR(0),
        FRONT(1);

        public final int index;

        SourceCamera(int i10) {
            this.index = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SourceSpecification {

        @Nullable
        private SourceCamera camera;

        @NonNull
        private SourceType type;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private SourceCamera camera;

            @Nullable
            private SourceType type;

            @NonNull
            public SourceSpecification build() {
                SourceSpecification sourceSpecification = new SourceSpecification();
                sourceSpecification.setType(this.type);
                sourceSpecification.setCamera(this.camera);
                return sourceSpecification;
            }

            @NonNull
            public Builder setCamera(@Nullable SourceCamera sourceCamera) {
                this.camera = sourceCamera;
                return this;
            }

            @NonNull
            public Builder setType(@NonNull SourceType sourceType) {
                this.type = sourceType;
                return this;
            }
        }

        @NonNull
        public static SourceSpecification fromList(@NonNull ArrayList<Object> arrayList) {
            SourceSpecification sourceSpecification = new SourceSpecification();
            Object obj = arrayList.get(0);
            sourceSpecification.setType(obj == null ? null : SourceType.values()[((Integer) obj).intValue()]);
            Object obj2 = arrayList.get(1);
            sourceSpecification.setCamera(obj2 != null ? SourceCamera.values()[((Integer) obj2).intValue()] : null);
            return sourceSpecification;
        }

        @Nullable
        public SourceCamera getCamera() {
            return this.camera;
        }

        @NonNull
        public SourceType getType() {
            return this.type;
        }

        public void setCamera(@Nullable SourceCamera sourceCamera) {
            this.camera = sourceCamera;
        }

        public void setType(@NonNull SourceType sourceType) {
            if (sourceType != null) {
                this.type = sourceType;
                return;
            }
            throw new IllegalStateException("Nonnull field \"type\" is null.");
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            SourceType sourceType = this.type;
            arrayList.add(sourceType == null ? null : Integer.valueOf(sourceType.index));
            SourceCamera sourceCamera = this.camera;
            arrayList.add(sourceCamera != null ? Integer.valueOf(sourceCamera.index) : null);
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum SourceType {
        CAMERA(0),
        GALLERY(1);

        public final int index;

        SourceType(int i10) {
            this.index = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class VideoSelectionOptions {

        @Nullable
        private Long maxDurationSeconds;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {

            @Nullable
            private Long maxDurationSeconds;

            @NonNull
            public VideoSelectionOptions build() {
                VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
                videoSelectionOptions.setMaxDurationSeconds(this.maxDurationSeconds);
                return videoSelectionOptions;
            }

            @NonNull
            public Builder setMaxDurationSeconds(@Nullable Long l10) {
                this.maxDurationSeconds = l10;
                return this;
            }
        }

        @NonNull
        public static VideoSelectionOptions fromList(@NonNull ArrayList<Object> arrayList) {
            long longValue;
            Long valueOf;
            VideoSelectionOptions videoSelectionOptions = new VideoSelectionOptions();
            Object obj = arrayList.get(0);
            if (obj == null) {
                valueOf = null;
            } else {
                if (obj instanceof Integer) {
                    longValue = ((Integer) obj).intValue();
                } else {
                    longValue = ((Long) obj).longValue();
                }
                valueOf = Long.valueOf(longValue);
            }
            videoSelectionOptions.setMaxDurationSeconds(valueOf);
            return videoSelectionOptions;
        }

        @Nullable
        public Long getMaxDurationSeconds() {
            return this.maxDurationSeconds;
        }

        public void setMaxDurationSeconds(@Nullable Long l10) {
            this.maxDurationSeconds = l10;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.maxDurationSeconds);
            return arrayList;
        }
    }

    @NonNull
    public static ArrayList<Object> wrapError(@NonNull Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + ((Object) th.getCause()) + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}

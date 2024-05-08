package com.cupidapp.live.mediapicker.model;

import android.content.Context;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;
import z0.l;

/* compiled from: PublishViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PublishViewModel$fileUploadImage$1 extends Lambda implements Function1<Boolean, p> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ImageAttributeModel $imageAttribute;
    public final /* synthetic */ File $imageFile;
    public final /* synthetic */ Function1<Throwable, p> $publishError;
    public final /* synthetic */ long $time;
    public final /* synthetic */ UploadImageModel $uploadImage;
    public final /* synthetic */ SensorPosition $uploadPosition;
    public final /* synthetic */ String $webTitle;
    public final /* synthetic */ PublishViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PublishViewModel$fileUploadImage$1(long j10, PublishViewModel publishViewModel, File file, ImageAttributeModel imageAttributeModel, Context context, UploadImageModel uploadImageModel, SensorPosition sensorPosition, String str, Function1<? super Throwable, p> function1) {
        super(1);
        this.$time = j10;
        this.this$0 = publishViewModel;
        this.$imageFile = file;
        this.$imageAttribute = imageAttributeModel;
        this.$context = context;
        this.$uploadImage = uploadImageModel;
        this.$uploadPosition = sensorPosition;
        this.$webTitle = str;
        this.$publishError = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return p.f51048a;
    }

    public final void invoke(boolean z10) {
        j.f12332a.a("fileUploadImage", "end time " + (System.currentTimeMillis() - this.$time) + " has face " + z10);
        this.this$0.setUploadStartTime(System.currentTimeMillis());
        final long a10 = l.a(this.$imageFile);
        final int width = this.$imageAttribute.getWidth();
        final int height = this.$imageAttribute.getHeight();
        Observable<R> flatMap = NetworkClient.f11868a.i().f(com.cupidapp.live.base.network.f.a(this.$imageFile), Boolean.valueOf(z10)).observeOn(AndroidSchedulers.mainThread()).flatMap(new com.cupidapp.live.base.network.i());
        final PublishViewModel publishViewModel = this.this$0;
        final Context context = this.$context;
        final UploadImageModel uploadImageModel = this.$uploadImage;
        final SensorPosition sensorPosition = this.$uploadPosition;
        final String str = this.$webTitle;
        final Function1<UploadImageFileResult, p> function1 = new Function1<UploadImageFileResult, p>() { // from class: com.cupidapp.live.mediapicker.model.PublishViewModel$fileUploadImage$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadImageFileResult uploadImageFileResult) {
                invoke2(uploadImageFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UploadImageFileResult uploadImageFileResult) {
                PublishViewModel.this.imageUploadSuccess(context, uploadImageModel, uploadImageFileResult.getImage());
                PublishViewModel.this.uploadFilesSensorLog(a10, width, height, "图片", sensorPosition, null, str);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.model.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PublishViewModel$fileUploadImage$1.invoke$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = this.$publishError;
        final PublishViewModel publishViewModel2 = this.this$0;
        final SensorPosition sensorPosition2 = this.$uploadPosition;
        final String str2 = this.$webTitle;
        final Function1<Throwable, p> function13 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.model.PublishViewModel$fileUploadImage$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable t2) {
                Function1<Throwable, p> function14 = function12;
                s.h(t2, "t");
                function14.invoke(t2);
                publishViewModel2.uploadFilesSensorLog(a10, width, height, "图片", sensorPosition2, t2, str2);
            }
        };
        flatMap.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.model.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PublishViewModel$fileUploadImage$1.invoke$lambda$1(Function1.this, obj);
            }
        });
    }
}

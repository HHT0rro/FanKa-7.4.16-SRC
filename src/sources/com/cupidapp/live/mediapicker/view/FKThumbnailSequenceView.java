package com.cupidapp.live.mediapicker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import ce.n;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.q;
import com.cupidapp.live.base.view.scroll.FKHorizontalScrollView;
import com.cupidapp.live.mediapicker.model.ThumbnailBitmapModel;
import com.cupidapp.live.mediapicker.model.VideoEditAttributeModel;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wseemann.media.FFmpegMediaMetadataRetriever;
import z0.v;

/* compiled from: FKThumbnailSequenceView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKThumbnailSequenceView extends FKHorizontalScrollView {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public static final a f17389n = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public b f17390g;

    /* renamed from: h, reason: collision with root package name */
    public double f17391h;

    /* renamed from: i, reason: collision with root package name */
    public int f17392i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Disposable f17393j;

    /* renamed from: k, reason: collision with root package name */
    public long f17394k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public FKHorizontalScrollView.ScrollType f17395l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17396m;

    /* compiled from: FKThumbnailSequenceView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FKThumbnailSequenceView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a();

        void b(int i10);
    }

    /* compiled from: FKThumbnailSequenceView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements FKHorizontalScrollView.a {
        public c() {
        }

        @Override // com.cupidapp.live.base.view.scroll.FKHorizontalScrollView.a
        public void a(@NotNull FKHorizontalScrollView.ScrollType type) {
            b bVar;
            s.i(type, "type");
            FKThumbnailSequenceView.this.f17395l = type;
            if (type != FKHorizontalScrollView.ScrollType.IDLE || (bVar = FKThumbnailSequenceView.this.f17390g) == null) {
                return;
            }
            bVar.a();
        }
    }

    /* compiled from: FKThumbnailSequenceView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements Observer<ThumbnailBitmapModel> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f17399c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FFmpegMediaMetadataRetriever f17400d;

        public d(LinearLayout linearLayout, FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever) {
            this.f17399c = linearLayout;
            this.f17400d = fFmpegMediaMetadataRetriever;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@NotNull ThumbnailBitmapModel model) {
            View view;
            s.i(model, "model");
            if (model.getBitmap() == null && model.getIndex() == -1) {
                View view2 = new View(FKThumbnailSequenceView.this.getContext());
                view2.setLayoutParams(new FrameLayout.LayoutParams(model.getWidth(), model.getHeight()));
                view = view2;
            } else {
                Context context = FKThumbnailSequenceView.this.getContext();
                s.h(context, "context");
                ImageLoaderView imageLoaderView = new ImageLoaderView(context);
                imageLoaderView.setLayoutParams(new FrameLayout.LayoutParams(model.getWidth(), model.getHeight()));
                ImageLoaderView.f(imageLoaderView, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, model.getBitmap(), 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524223, null), null, 2, null);
                view = imageLoaderView;
            }
            this.f17399c.addView(view);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f17400d.release();
        }

        @Override // io.reactivex.Observer
        public void onError(@NotNull Throwable e2) {
            s.i(e2, "e");
            e2.printStackTrace();
            if (e2 instanceof FileNotFoundException) {
                com.cupidapp.live.base.view.h.f12779a.s(FKThumbnailSequenceView.this.getContext(), "此文件不存在");
            } else if (e2 instanceof IOException) {
                com.cupidapp.live.base.view.h.f12779a.s(FKThumbnailSequenceView.this.getContext(), "检索器创建失败");
            } else {
                com.cupidapp.live.base.view.h.f12779a.s(FKThumbnailSequenceView.this.getContext(), "获取失败:" + e2.getMessage());
            }
            this.f17400d.release();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(@NotNull Disposable d10) {
            s.i(d10, "d");
            FKThumbnailSequenceView.this.f17393j = d10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKThumbnailSequenceView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17396m = new LinkedHashMap();
        this.f17395l = FKHorizontalScrollView.ScrollType.IDLE;
        n();
    }

    public static final void m(int i10, FKThumbnailSequenceView this$0, long j10, long j11, VideoEditAttributeModel model, long j12, FFmpegMediaMetadataRetriever retriever, ObservableEmitter subscribe) {
        int i11;
        int i12;
        s.i(this$0, "this$0");
        s.i(model, "$model");
        s.i(retriever, "$retriever");
        s.i(subscribe, "subscribe");
        int rint = (int) Math.rint(i10 / 9.0f);
        int c4 = z0.h.c(this$0, 62.0f);
        double d10 = j10 / 9.0d;
        double d11 = j11;
        double d12 = (0 * d10) + d11;
        if (model.getWidth() <= 0 || model.getHeight() <= 0) {
            i11 = rint;
            i12 = c4;
        } else {
            float d13 = n.d(rint, c4) / n.d(model.getWidth(), model.getHeight());
            i12 = (int) (model.getHeight() * d13);
            i11 = (int) (model.getWidth() * d13);
        }
        subscribe.onNext(new ThumbnailBitmapModel(-1, null, this$0.f17392i, c4));
        long j13 = j12;
        int i13 = 0;
        while (d12 < j13) {
            int i14 = i13;
            Bitmap scaledFrameAtTime = retriever.getScaledFrameAtTime(v.o((long) d12), 0, i11, i12);
            s.h(scaledFrameAtTime, "retriever.getScaledFrame… height\n                )");
            subscribe.onNext(new ThumbnailBitmapModel(i14, z0.f.t(scaledFrameAtTime, model.getRotation()), rint, c4));
            int i15 = i14 + 1;
            d12 = (i15 * d10) + d11;
            j13 = j12;
            i13 = i15;
        }
        subscribe.onNext(new ThumbnailBitmapModel(-1, null, this$0.f17392i, c4));
        subscribe.onComplete();
    }

    public static final void r(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final ObservableSource s(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    public static final boolean u(boolean z10, FKThumbnailSequenceView this$0, View view, MotionEvent motionEvent) {
        b bVar;
        s.i(this$0, "this$0");
        view.performClick();
        if (!z10) {
            return true;
        }
        if (this$0.f17395l == FKHorizontalScrollView.ScrollType.IDLE && ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && (bVar = this$0.f17390g) != null)) {
            bVar.a();
        }
        return false;
    }

    public final Observable<ThumbnailBitmapModel> l(final FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever, final VideoEditAttributeModel videoEditAttributeModel, final long j10, final long j11, final long j12, final int i10) {
        Observable<ThumbnailBitmapModel> subscribeOn = Observable.create(new ObservableOnSubscribe() { // from class: com.cupidapp.live.mediapicker.view.b
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                FKThumbnailSequenceView.m(i10, this, j12, j10, videoEditAttributeModel, j11, fFmpegMediaMetadataRetriever, observableEmitter);
            }
        }).subscribeOn(Schedulers.io());
        s.h(subscribeOn, "create<ThumbnailBitmapMo…scribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public final void n() {
        setHorizontalScrollBarEnabled(false);
        removeAllViews();
        setScrollViewListener(new c());
    }

    public final long o(int i10) {
        double floor = Math.floor(((i10 + getScrollX()) / this.f17391h) + 0.5d) + this.f17394k;
        if (floor < ShadowDrawableWrapper.COS_45) {
            floor = 0.0d;
        }
        return (long) floor;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        b bVar = this.f17390g;
        if (bVar != null) {
            bVar.b(i10);
        }
    }

    public final int p(long j10) {
        long j11 = j10 - this.f17394k;
        if (j11 < 0) {
            j11 = 0;
        }
        return ((int) Math.floor((j11 * this.f17391h) + 0.5d)) - getScrollX();
    }

    public final void q(@NotNull final VideoEditAttributeModel model, final long j10, final long j11, final long j12) {
        s.i(model, "model");
        t();
        this.f17394k = j10;
        final int l10 = z0.h.l(this) - (this.f17392i * 2);
        this.f17391h = l10 / j12;
        final FFmpegMediaMetadataRetriever fFmpegMediaMetadataRetriever = new FFmpegMediaMetadataRetriever();
        String g3 = q.f12371a.g(getContext(), model.getUriString());
        LinearLayout linearLayout = new LinearLayout(getContext());
        addView(linearLayout);
        Observable subscribeOn = Observable.just(g3).subscribeOn(Schedulers.io());
        final Function1<String, p> function1 = new Function1<String, p>() { // from class: com.cupidapp.live.mediapicker.view.FKThumbnailSequenceView$obtainThumbnailData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FFmpegMediaMetadataRetriever.this.setDataSource(str);
            }
        };
        Observable doOnNext = subscribeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.mediapicker.view.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKThumbnailSequenceView.r(Function1.this, obj);
            }
        });
        final Function1<String, ObservableSource<? extends ThumbnailBitmapModel>> function12 = new Function1<String, ObservableSource<? extends ThumbnailBitmapModel>>() { // from class: com.cupidapp.live.mediapicker.view.FKThumbnailSequenceView$obtainThumbnailData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ObservableSource<? extends ThumbnailBitmapModel> invoke(@NotNull String it) {
                Observable l11;
                s.i(it, "it");
                l11 = FKThumbnailSequenceView.this.l(fFmpegMediaMetadataRetriever, model, j10, j11, j12, l10);
                return l11;
            }
        };
        doOnNext.flatMap(new Function() { // from class: com.cupidapp.live.mediapicker.view.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource s2;
                s2 = FKThumbnailSequenceView.s(Function1.this, obj);
                return s2;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(linearLayout, fFmpegMediaMetadataRetriever));
    }

    public final void setBothSideWhiteSpace(int i10, final boolean z10) {
        this.f17392i = i10;
        setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.mediapicker.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean u10;
                u10 = FKThumbnailSequenceView.u(z10, this, view, motionEvent);
                return u10;
            }
        });
    }

    public final void setOnScrollChangeListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f17390g = listener;
    }

    public final void t() {
        Disposable disposable;
        Disposable disposable2 = this.f17393j;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f17393j) != null) {
            disposable.dispose();
        }
        removeAllViews();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKThumbnailSequenceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17396m = new LinkedHashMap();
        this.f17395l = FKHorizontalScrollView.ScrollType.IDLE;
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKThumbnailSequenceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17396m = new LinkedHashMap();
        this.f17395l = FKHorizontalScrollView.ScrollType.IDLE;
        n();
    }
}

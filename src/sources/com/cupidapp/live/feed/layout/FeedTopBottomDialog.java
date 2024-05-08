package com.cupidapp.live.feed.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.feed.model.FeedTopIntroModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedTopBottomDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopBottomDialog extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f14489f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public SensorPosition f14490b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f14491c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14492d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14493e;

    /* compiled from: FeedTopBottomDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedTopBottomDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FeedTopBottomDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedTopBottomDialog(Context context) {
        super(context);
        this.f14493e = new LinkedHashMap();
        this.f14492d = true;
        d();
    }

    public /* synthetic */ FeedTopBottomDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final void getData() {
        Observable<Result<FeedTopIntroModel>> a10 = NetworkClient.f11868a.l().a();
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = a10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedTopIntroModel, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedTopBottomDialog$getData$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedTopIntroModel feedTopIntroModel) {
                m2576invoke(feedTopIntroModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2576invoke(FeedTopIntroModel feedTopIntroModel) {
                final FeedTopIntroModel feedTopIntroModel2 = feedTopIntroModel;
                if (feedTopIntroModel2.getTitle() != null) {
                    FeedTopBottomDialog feedTopBottomDialog = FeedTopBottomDialog.this;
                    int i10 = R$id.feed_top_title;
                    ((TextView) feedTopBottomDialog.a(i10)).setVisibility(0);
                    ((TextView) FeedTopBottomDialog.this.a(i10)).setText(feedTopIntroModel2.getTitle());
                }
                if (feedTopIntroModel2.getDesc() != null) {
                    FeedTopBottomDialog feedTopBottomDialog2 = FeedTopBottomDialog.this;
                    int i11 = R$id.feed_top_content;
                    ((TextView) feedTopBottomDialog2.a(i11)).setVisibility(0);
                    ((TextView) FeedTopBottomDialog.this.a(i11)).setText(feedTopIntroModel2.getDesc());
                }
                if (feedTopIntroModel2.getNote() != null) {
                    FeedTopBottomDialog feedTopBottomDialog3 = FeedTopBottomDialog.this;
                    int i12 = R$id.feed_top_tip;
                    ((TextView) feedTopBottomDialog3.a(i12)).setVisibility(0);
                    ((TextView) FeedTopBottomDialog.this.a(i12)).setText(feedTopIntroModel2.getNote());
                }
                if (feedTopIntroModel2.getButtonName() != null) {
                    FeedTopBottomDialog feedTopBottomDialog4 = FeedTopBottomDialog.this;
                    int i13 = R$id.feed_top_btn;
                    ((TextView) feedTopBottomDialog4.a(i13)).setVisibility(0);
                    ((TextView) FeedTopBottomDialog.this.a(i13)).setText(feedTopIntroModel2.getButtonName());
                    TextView feed_top_btn = (TextView) FeedTopBottomDialog.this.a(i13);
                    kotlin.jvm.internal.s.h(feed_top_btn, "feed_top_btn");
                    final FeedTopBottomDialog feedTopBottomDialog5 = FeedTopBottomDialog.this;
                    y.d(feed_top_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedTopBottomDialog$getData$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                            invoke2(view);
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable View view) {
                            AlertDialog alertDialog;
                            SensorPosition sensorPosition;
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FeedTopBottomDialog.this.getContext(), feedTopIntroModel2.getJumpUrl(), null, 4, null);
                            alertDialog = FeedTopBottomDialog.this.f14491c;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                            j1.i iVar = j1.i.f50236a;
                            PopupName popupName = PopupName.SET_POST_TOP;
                            PopupButtonName popupButtonName = PopupButtonName.TRY;
                            sensorPosition = FeedTopBottomDialog.this.f14490b;
                            iVar.a(popupName, popupButtonName, sensorPosition);
                        }
                    });
                }
                if (feedTopIntroModel2.getImage() != null) {
                    ImageLoaderView feed_top_icon = (ImageLoaderView) FeedTopBottomDialog.this.a(R$id.feed_top_icon);
                    kotlin.jvm.internal.s.h(feed_top_icon, "feed_top_icon");
                    ImageLoaderView.g(feed_top_icon, feedTopIntroModel2.getImage(), null, null, 6, null);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14493e;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void d() {
        z.a(this, R$layout.dialog_feed_top_bottom, true);
        ImageView feed_top_close = (ImageView) a(R$id.feed_top_close);
        kotlin.jvm.internal.s.h(feed_top_close, "feed_top_close");
        y.d(feed_top_close, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedTopBottomDialog$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog;
                alertDialog = FeedTopBottomDialog.this.f14491c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        getData();
    }

    @NotNull
    public final FeedTopBottomDialog e(@NotNull SensorPosition position) {
        kotlin.jvm.internal.s.i(position, "position");
        this.f14490b = position;
        return this;
    }

    public final void f() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f14491c = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f14492d);
        }
        AlertDialog alertDialog = this.f14491c;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f14491c;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        j1.i.g(j1.i.f50236a, PopupName.SET_POST_TOP, this.f14490b, null, 4, null);
    }
}

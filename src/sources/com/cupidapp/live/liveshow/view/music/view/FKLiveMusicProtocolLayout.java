package com.cupidapp.live.liveshow.view.music.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.LinkDictModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveMusicProtocolLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMusicProtocolLayout extends BaseLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f15811e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static LinkDictModel f15812f;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15813d;

    /* compiled from: FKLiveMusicProtocolLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {

        /* compiled from: FKLiveMusicProtocolLayout.kt */
        @d
        /* renamed from: com.cupidapp.live.liveshow.view.music.view.FKLiveMusicProtocolLayout$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0161a implements com.cupidapp.live.liveshow.view.music.view.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertDialog f15814a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0<p> f15815b;

            public C0161a(AlertDialog alertDialog, Function0<p> function0) {
                this.f15814a = alertDialog;
                this.f15815b = function0;
            }

            @Override // com.cupidapp.live.liveshow.view.music.view.a
            public void a() {
                this.f15814a.dismiss();
                this.f15815b.invoke();
            }

            @Override // com.cupidapp.live.liveshow.view.music.view.a
            public void b() {
                this.f15814a.dismiss();
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final LinkDictModel a() {
            return FKLiveMusicProtocolLayout.f15812f;
        }

        public final void b(@Nullable LinkDictModel linkDictModel) {
            FKLiveMusicProtocolLayout.f15812f = linkDictModel;
        }

        public final void c(@NotNull Context context, @NotNull Function0<p> agreeCallback) {
            s.i(context, "context");
            s.i(agreeCallback, "agreeCallback");
            FKLiveMusicProtocolLayout fKLiveMusicProtocolLayout = new FKLiveMusicProtocolLayout(context);
            AlertDialog create = z0.b.f54812a.e(context).setView(fKLiveMusicProtocolLayout).create();
            create.setCanceledOnTouchOutside(false);
            LinkDictModel a10 = a();
            s.f(a10);
            fKLiveMusicProtocolLayout.i(a10, new C0161a(create, agreeCallback));
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            create.show();
        }
    }

    /* compiled from: FKLiveMusicProtocolLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f15817c;

        public b(Map.Entry<String, String> entry) {
            this.f15817c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, FKLiveMusicProtocolLayout.this.getContext(), this.f15817c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMusicProtocolLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15813d = new LinkedHashMap();
        j();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15813d;
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

    public final void i(final LinkDictModel linkDictModel, final com.cupidapp.live.liveshow.view.music.view.a aVar) {
        SpannableStringBuilder c4;
        if (linkDictModel.getLinkDict() != null && linkDictModel.getLinkDict().size() > 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            for (Map.Entry<String, String> entry : linkDictModel.getLinkDict().entrySet()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                Map.Entry<String, String> entry2 = entry;
                arrayList.add(i10, entry2.getKey());
                arrayList2.add(i10, new b(entry2));
                i10 = i11;
            }
            c4 = q1.d.f53006a.c(linkDictModel.getContent(), arrayList, (r18 & 4) != 0 ? null : -12871682, (r18 & 8) != 0 ? null : -1, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.protocolDescription;
            ((TextView) e(i12)).setText(c4);
            ((TextView) e(i12)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) e(R$id.protocolTitle)).setText(getContext().getString(R$string.live_protocol_update, CollectionsKt___CollectionsKt.V(arrayList)));
            FKUniversalButton agreeButton = (FKUniversalButton) e(R$id.agreeButton);
            s.h(agreeButton, "agreeButton");
            y.d(agreeButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKLiveMusicProtocolLayout$configLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    Observable<Result<Object>> q10 = NetworkClient.f11868a.r().q(LinkDictModel.this.getVersion());
                    FKLiveMusicProtocolLayout fKLiveMusicProtocolLayout = this;
                    final a aVar2 = aVar;
                    Disposable disposed = q10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKLiveMusicProtocolLayout$configLayout$2$invoke$$inlined$handle$default$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Object obj) {
                            invoke2(obj);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                            FKLiveMusicProtocolLayout.f15811e.b(null);
                            a.this.a();
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, fKLiveMusicProtocolLayout)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (fKLiveMusicProtocolLayout != null) {
                            fKLiveMusicProtocolLayout.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            });
            TextView disagreeButton = (TextView) e(R$id.disagreeButton);
            s.h(disagreeButton, "disagreeButton");
            y.d(disagreeButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKLiveMusicProtocolLayout$configLayout$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    a.this.b();
                }
            });
            return;
        }
        ((TextView) e(R$id.protocolDescription)).setText(linkDictModel.getContent());
    }

    public final void j() {
        z.a(this, R$layout.layout_live_music_protocol, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMusicProtocolLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15813d = new LinkedHashMap();
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMusicProtocolLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15813d = new LinkedHashMap();
        j();
    }
}

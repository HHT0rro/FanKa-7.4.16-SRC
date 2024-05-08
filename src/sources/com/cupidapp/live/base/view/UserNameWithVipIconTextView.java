package com.cupidapp.live.base.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.ImageSizeModel;
import com.cupidapp.live.base.utils.ImageWithHeightModel;
import com.cupidapp.live.base.utils.LocalImageModel;
import com.cupidapp.live.base.utils.NetWorkDrawableHelper;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import com.cupidapp.live.profile.model.VipIconSize;
import com.huawei.quickcard.framework.bean.CardElement;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;

/* compiled from: UserNameWithVipIconTextView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserNameWithVipIconTextView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12590b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserNameWithVipIconTextView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12590b = new LinkedHashMap();
    }

    public static final void d(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void e(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void c(@Nullable String str, @NotNull VipIconSize size, @NotNull UserVipDetailModel userVipModel, @Nullable final SensorPosition sensorPosition, @NotNull final UserIconViewLayout.VipIconPositionRef ref, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable final String str2, @Nullable ImageModel imageModel3) {
        kotlin.jvm.internal.s.i(size, "size");
        kotlin.jvm.internal.s.i(userVipModel, "userVipModel");
        kotlin.jvm.internal.s.i(ref, "ref");
        if (str == null) {
            return;
        }
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        final ArrayList arrayList = new ArrayList();
        if (imageModel3 != null) {
            arrayList.add(new ImageWithHeightModel(imageModel3, z0.h.c(this, 18.0f), null));
        }
        Integer vipIcon = userVipModel.getVipIcon(size);
        if (vipIcon != null) {
            arrayList.add(new LocalImageModel(vipIcon.intValue(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.view.UserNameWithVipIconTextView$configUserWithIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConstantsUrlModel urlModel;
                    ConstantsResult q10 = p1.g.f52734a.q();
                    String urlVipMe = (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlVipMe();
                    if (!(urlVipMe == null || urlVipMe.length() == 0)) {
                        j.a.b(com.cupidapp.live.base.router.j.f12156c, UserNameWithVipIconTextView.this.getContext(), x.a(urlVipMe, CardElement.Field.REF, ref.getValue()), null, 4, null);
                    }
                    SensorPosition sensorPosition2 = sensorPosition;
                    if (sensorPosition2 == null) {
                        sensorPosition2 = SensorPosition.Unknown;
                    }
                    z3.d.f54832a.j(sensorPosition2.getValue());
                }
            }));
        }
        if (imageModel != null) {
            arrayList.add(new ImageWithHeightModel(imageModel, z0.h.c(this, 16.0f), null));
        }
        if (imageModel2 != null) {
            arrayList.add(new ImageWithHeightModel(imageModel2, z0.h.c(this, 20.0f), new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.view.UserNameWithVipIconTextView$configUserWithIcon$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, UserNameWithVipIconTextView.this.getContext(), str2, null, 4, null);
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            NetWorkDrawableHelper netWorkDrawableHelper = NetWorkDrawableHelper.f12282a;
            Context context = getContext();
            kotlin.jvm.internal.s.h(context, "context");
            Flowable<List<a>> observeOn = netWorkDrawableHelper.d(context, arrayList).onErrorReturnItem(kotlin.collections.s.j()).observeOn(AndroidSchedulers.mainThread());
            final Function1<List<? extends a>, kotlin.p> function1 = new Function1<List<? extends a>, kotlin.p>() { // from class: com.cupidapp.live.base.view.UserNameWithVipIconTextView$configUserWithIcon$3

                /* compiled from: UserNameWithVipIconTextView.kt */
                @kotlin.d
                /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
                public static final class a extends ClickableSpan {

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ List<ImageSizeModel> f12591b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ int f12592c;

                    public a(List<ImageSizeModel> list, int i10) {
                        this.f12591b = list;
                        this.f12592c = i10;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NotNull View widget) {
                        kotlin.jvm.internal.s.i(widget, "widget");
                        Function0<kotlin.p> clickCallback = this.f12591b.get(this.f12592c).getClickCallback();
                        if (clickCallback != null) {
                            clickCallback.invoke();
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends com.cupidapp.live.base.view.a> list) {
                    invoke2((List<com.cupidapp.live.base.view.a>) list);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<com.cupidapp.live.base.view.a> list) {
                    kotlin.jvm.internal.s.h(list, "list");
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    List<ImageSizeModel> list2 = arrayList;
                    int i10 = 0;
                    for (com.cupidapp.live.base.view.a aVar : list) {
                        int i11 = i10 + 1;
                        if (i10 < 0) {
                            kotlin.collections.s.s();
                        }
                        com.cupidapp.live.base.view.a aVar2 = aVar;
                        if (aVar2 != null) {
                            spannableStringBuilder2.append((CharSequence) "   ");
                            spannableStringBuilder2.setSpan(aVar2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
                            spannableStringBuilder2.setSpan(new a(list2, i10), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
                        }
                        i10 = i11;
                    }
                    UserNameWithVipIconTextView.this.setText(spannableStringBuilder);
                    UserNameWithVipIconTextView.this.setMovementMethod(LinkMovementMethod.getInstance());
                }
            };
            Consumer<? super List<a>> consumer = new Consumer() { // from class: com.cupidapp.live.base.view.q
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    UserNameWithVipIconTextView.d(Function1.this, obj);
                }
            };
            final UserNameWithVipIconTextView$configUserWithIcon$4 userNameWithVipIconTextView$configUserWithIcon$4 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.base.view.UserNameWithVipIconTextView$configUserWithIcon$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                    invoke2(th);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }
            };
            observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.view.r
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    UserNameWithVipIconTextView.e(Function1.this, obj);
                }
            });
            return;
        }
        setText(spannableStringBuilder);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserNameWithVipIconTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12590b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserNameWithVipIconTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12590b = new LinkedHashMap();
    }
}

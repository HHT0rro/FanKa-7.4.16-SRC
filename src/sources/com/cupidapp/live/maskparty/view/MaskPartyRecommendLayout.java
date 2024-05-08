package com.cupidapp.live.maskparty.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.maskparty.activity.MaskPartyChatActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyMatchActivity;
import com.cupidapp.live.maskparty.model.MaskPartyEntrance;
import com.cupidapp.live.maskparty.model.MaskPartyRecommendUserModel;
import com.cupidapp.live.maskparty.model.MaskPartyRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyRecommendLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyRecommendLayout extends BaseLayout {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f16437o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    public static boolean f16438p;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f16439d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f16440e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public MaskPartyRecommendUserModel f16441f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public SensorPosition f16442g;

    /* renamed from: h, reason: collision with root package name */
    public int f16443h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f16444i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public ValueAnimator f16445j;

    /* renamed from: k, reason: collision with root package name */
    public int f16446k;

    /* renamed from: l, reason: collision with root package name */
    public float f16447l;

    /* renamed from: m, reason: collision with root package name */
    public float f16448m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16449n;

    /* compiled from: MaskPartyRecommendLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MaskPartyRecommendLayout a(@NotNull ViewGroup viewContainer) {
            s.i(viewContainer, "viewContainer");
            Context context = viewContainer.getContext();
            s.h(context, "viewContainer.context");
            return new MaskPartyRecommendLayout(context, viewContainer);
        }

        public final boolean b() {
            return MaskPartyRecommendLayout.f16438p;
        }
    }

    /* compiled from: MaskPartyRecommendLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            s.i(animation, "animation");
            if (MaskPartyRecommendLayout.this.f16443h == 0) {
                ViewGroup viewGroup = MaskPartyRecommendLayout.this.f16439d;
                if (viewGroup == null) {
                    s.A("parentView");
                    viewGroup = null;
                }
                viewGroup.removeView(MaskPartyRecommendLayout.this);
            }
        }
    }

    /* compiled from: Animator.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            MaskPartyRecommendLayout.this.s();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyRecommendLayout(@NotNull Context context, @NotNull ViewGroup parentView) {
        super(context);
        s.i(context, "context");
        s.i(parentView, "parentView");
        this.f16449n = new LinkedHashMap();
        this.f16443h = -1;
        this.f16439d = parentView;
        t();
    }

    public static final void w(MaskPartyRecommendLayout this$0, MaskPartyRecommendUserModel model, int i10, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.f16446k = ((Integer) animatedValue).intValue();
        ((FKUniversalButton) this$0.f(R$id.start_chat_button)).setText(this$0.getContext().getString(R$string.start_chat_count_down, model.getButtonDesc(), Integer.valueOf(i10 - this$0.f16446k)));
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f16449n;
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

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f16438p = false;
        x();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull HideMaskPartyRecommendEvent event) {
        s.i(event, "event");
        s();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f16447l = motionEvent.getX();
            this.f16448m = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f16447l);
            float f10 = -(motionEvent.getY() - this.f16448m);
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (f10 > abs && f10 > scaledTouchSlop) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            s();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        FKUniversalButton refuse_button = (FKUniversalButton) f(R$id.refuse_button);
        s.h(refuse_button, "refuse_button");
        y.d(refuse_button, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyRecommendLayout$bindClickEvent$1
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
                MaskPartyRecommendUserModel maskPartyRecommendUserModel;
                PopupName popupName;
                SensorPosition sensorPosition;
                MaskPartyRecommendLayout.this.s();
                maskPartyRecommendUserModel = MaskPartyRecommendLayout.this.f16441f;
                Integer valueOf = maskPartyRecommendUserModel != null ? Integer.valueOf(maskPartyRecommendUserModel.getType()) : null;
                int type = MaskPartyType.MessageChat.getType();
                if (valueOf != null && valueOf.intValue() == type) {
                    popupName = PopupName.CHAT_ROOM_TOP_BANNER;
                } else {
                    popupName = (valueOf != null && valueOf.intValue() == MaskPartyType.ScriptKill.getType()) ? PopupName.DOUBLE_PLAY_TOP_BANNER : null;
                }
                if (popupName != null) {
                    MaskPartyRecommendLayout maskPartyRecommendLayout = MaskPartyRecommendLayout.this;
                    GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                    String name = popupName.name();
                    sensorPosition = maskPartyRecommendLayout.f16442g;
                    GroupOthersLog.Y(groupOthersLog, name, sensorPosition != null ? sensorPosition.getValue() : null, PopupButtonName.Cancel.getValue(), null, 8, null);
                }
            }
        });
        FKUniversalButton start_chat_button = (FKUniversalButton) f(R$id.start_chat_button);
        s.h(start_chat_button, "start_chat_button");
        y.d(start_chat_button, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyRecommendLayout$bindClickEvent$2
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
                String str;
                MaskPartyRecommendUserModel maskPartyRecommendUserModel;
                String str2;
                MaskPartyRecommendUserModel maskPartyRecommendUserModel2;
                SensorPosition sensorPosition;
                MaskPartyRecommendUserModel maskPartyRecommendUserModel3;
                str = MaskPartyRecommendLayout.this.f16440e;
                if (str == null || str.length() == 0) {
                    return;
                }
                maskPartyRecommendUserModel = MaskPartyRecommendLayout.this.f16441f;
                if (maskPartyRecommendUserModel != null) {
                    MaskPartyRecommendLayout.this.s();
                    z2.a z10 = NetworkClient.f11868a.z();
                    str2 = MaskPartyRecommendLayout.this.f16440e;
                    s.f(str2);
                    maskPartyRecommendUserModel2 = MaskPartyRecommendLayout.this.f16441f;
                    s.f(maskPartyRecommendUserModel2);
                    Observable<Result<MaskPartyRoomModel>> B = z10.B(str2, maskPartyRecommendUserModel2.getType());
                    Object context = MaskPartyRecommendLayout.this.getContext();
                    final MaskPartyRecommendLayout maskPartyRecommendLayout = MaskPartyRecommendLayout.this;
                    Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyRecommendLayout$bindClickEvent$2.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Throwable it) {
                            MaskPartyRecommendUserModel maskPartyRecommendUserModel4;
                            s.i(it, "it");
                            MaskPartyMatchActivity.a aVar = MaskPartyMatchActivity.f16245r;
                            Context context2 = MaskPartyRecommendLayout.this.getContext();
                            maskPartyRecommendUserModel4 = MaskPartyRecommendLayout.this.f16441f;
                            s.f(maskPartyRecommendUserModel4);
                            MaskPartyMatchActivity.a.b(aVar, context2, r.e(Integer.valueOf(maskPartyRecommendUserModel4.getType())), false, false, MaskPartyEntrance.RecommendMatch.getEntrance(), 12, null);
                            return Boolean.FALSE;
                        }
                    };
                    PopupName popupName = null;
                    com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                    Disposable disposed = B.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MaskPartyRoomModel, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyRecommendLayout$bindClickEvent$2$invoke$$inlined$handleByContext$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(MaskPartyRoomModel maskPartyRoomModel) {
                            m2682invoke(maskPartyRoomModel);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2682invoke(MaskPartyRoomModel maskPartyRoomModel) {
                            MaskPartyRecommendUserModel maskPartyRecommendUserModel4;
                            int i10;
                            MaskPartyRecommendUserModel maskPartyRecommendUserModel5;
                            MaskPartyRoomModel maskPartyRoomModel2 = maskPartyRoomModel;
                            MaskPartyChatActivity.a aVar = MaskPartyChatActivity.f16230s;
                            Context context2 = MaskPartyRecommendLayout.this.getContext();
                            String roomId = maskPartyRoomModel2.getRoomId();
                            maskPartyRecommendUserModel4 = MaskPartyRecommendLayout.this.f16441f;
                            s.f(maskPartyRecommendUserModel4);
                            aVar.c(context2, roomId, maskPartyRecommendUserModel4.getType(), true);
                            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                            PostAndSocialProtos.Type type = PostAndSocialProtos.Type.MATCH;
                            String roomId2 = maskPartyRoomModel2.getRoomId();
                            i10 = MaskPartyRecommendLayout.this.f16446k;
                            Integer valueOf = Integer.valueOf(i10);
                            MaskPartyType.a aVar2 = MaskPartyType.Companion;
                            maskPartyRecommendUserModel5 = MaskPartyRecommendLayout.this.f16441f;
                            s.f(maskPartyRecommendUserModel5);
                            groupSocialLog.R(type, (r15 & 2) != 0 ? null : roomId2, (r15 & 4) != 0 ? null : null, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : valueOf, (r15 & 32) != 0 ? false : true, (r15 & 64) == 0 ? r.e(aVar2.a(Integer.valueOf(maskPartyRecommendUserModel5.getType()))) : null);
                        }
                    }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                    sensorPosition = MaskPartyRecommendLayout.this.f16442g;
                    if (sensorPosition != null) {
                        maskPartyRecommendUserModel3 = MaskPartyRecommendLayout.this.f16441f;
                        Integer valueOf = maskPartyRecommendUserModel3 != null ? Integer.valueOf(maskPartyRecommendUserModel3.getType()) : null;
                        int type = MaskPartyType.MessageChat.getType();
                        if (valueOf != null && valueOf.intValue() == type) {
                            popupName = PopupName.CHAT_ROOM_TOP_BANNER;
                        } else {
                            int type2 = MaskPartyType.ScriptKill.getType();
                            if (valueOf != null && valueOf.intValue() == type2) {
                                popupName = PopupName.DOUBLE_PLAY_TOP_BANNER;
                            }
                        }
                        if (popupName != null) {
                            GroupOthersLog.Y(GroupOthersLog.f18702a, popupName.name(), sensorPosition.getValue(), PopupButtonName.Confirm.getValue(), null, 8, null);
                        }
                    }
                }
            }
        });
    }

    public final void q() {
        measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<MaskPartyRecommendLayout, Float>) View.Y, -getMeasuredHeight(), 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new b());
        this.f16444i = ofFloat;
    }

    @NotNull
    public final MaskPartyRecommendLayout r(@NotNull String matchUserId, @NotNull MaskPartyRecommendUserModel recommendModel, @NotNull SensorPosition currentPage) {
        s.i(matchUserId, "matchUserId");
        s.i(recommendModel, "recommendModel");
        s.i(currentPage, "currentPage");
        this.f16440e = matchUserId;
        this.f16441f = recommendModel;
        this.f16442g = currentPage;
        ((TextView) f(R$id.recommend_title_text)).setText(recommendModel.getTitle());
        ImageLoaderView recommend_avatar_image = (ImageLoaderView) f(R$id.recommend_avatar_image);
        s.h(recommend_avatar_image, "recommend_avatar_image");
        ImageLoaderView.g(recommend_avatar_image, recommendModel.getAvatar(), null, null, 6, null);
        ((TextView) f(R$id.basic_info_text)).setText(recommendModel.getBasicInfo());
        ((TextView) f(R$id.self_introduction_textview)).setText(recommendModel.getCommonHobby());
        ImageView match_friend_imageview = (ImageView) f(R$id.match_friend_imageview);
        s.h(match_friend_imageview, "match_friend_imageview");
        match_friend_imageview.setVisibility(recommendModel.getMatch() ? 0 : 8);
        return this;
    }

    public final void s() {
        this.f16443h = 0;
        ObjectAnimator objectAnimator = this.f16444i;
        if (objectAnimator != null) {
            objectAnimator.reverse();
        }
        this.f16444i = null;
    }

    public final void t() {
        z.a(this, R$layout.layout_mask_party_recommend, true);
        ConstraintLayout recommend_container_layout = (ConstraintLayout) f(R$id.recommend_container_layout);
        s.h(recommend_container_layout, "recommend_container_layout");
        y.m(recommend_container_layout, null, Integer.valueOf(z0.h.m(getContext())), null, null, 13, null);
        ((TextView) f(R$id.recommend_title_text)).getPaint().setFakeBoldText(true);
        ((TextView) f(R$id.on_line_text)).getPaint().setFakeBoldText(true);
        ((TextView) f(R$id.basic_info_text)).getPaint().setFakeBoldText(true);
        q();
        p();
    }

    public final void u() {
        View view;
        PopupName popupName;
        ViewGroup viewGroup = this.f16439d;
        if (viewGroup == null) {
            s.A("parentView");
            viewGroup = null;
        }
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            } else {
                view = it.next();
                if (view instanceof MaskPartyRecommendLayout) {
                    break;
                }
            }
        }
        if (view == null) {
            f16438p = true;
            ViewGroup viewGroup2 = this.f16439d;
            if (viewGroup2 == null) {
                s.A("parentView");
                viewGroup2 = null;
            }
            viewGroup2.addView(this);
            this.f16443h = 1;
            ObjectAnimator objectAnimator = this.f16444i;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            v();
            MaskPartyRecommendUserModel maskPartyRecommendUserModel = this.f16441f;
            Integer valueOf = maskPartyRecommendUserModel != null ? Integer.valueOf(maskPartyRecommendUserModel.getType()) : null;
            int type = MaskPartyType.MessageChat.getType();
            if (valueOf != null && valueOf.intValue() == type) {
                popupName = PopupName.CHAT_ROOM_TOP_BANNER;
            } else {
                popupName = (valueOf != null && valueOf.intValue() == MaskPartyType.ScriptKill.getType()) ? PopupName.DOUBLE_PLAY_TOP_BANNER : null;
            }
            if (popupName != null) {
                GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
                String name = popupName.name();
                SensorPosition sensorPosition = this.f16442g;
                GroupOthersLog.a0(groupOthersLog, name, sensorPosition != null ? sensorPosition.getValue() : null, null, 4, null);
            }
        }
    }

    public final void v() {
        final MaskPartyRecommendUserModel maskPartyRecommendUserModel = this.f16441f;
        if (maskPartyRecommendUserModel != null) {
            final int countDownSeconds = maskPartyRecommendUserModel.getCountDownSeconds();
            ValueAnimator startCountDown$lambda$6$lambda$5 = ValueAnimator.ofInt(countDownSeconds);
            startCountDown$lambda$6$lambda$5.setDuration(countDownSeconds * 1000);
            startCountDown$lambda$6$lambda$5.setInterpolator(new LinearInterpolator());
            startCountDown$lambda$6$lambda$5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.maskparty.view.n
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MaskPartyRecommendLayout.w(MaskPartyRecommendLayout.this, maskPartyRecommendUserModel, countDownSeconds, valueAnimator);
                }
            });
            s.h(startCountDown$lambda$6$lambda$5, "startCountDown$lambda$6$lambda$5");
            startCountDown$lambda$6$lambda$5.addListener(new c());
            this.f16445j = startCountDown$lambda$6$lambda$5;
            startCountDown$lambda$6$lambda$5.start();
        }
    }

    public final void x() {
        ValueAnimator valueAnimator = this.f16445j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f16445j = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyRecommendLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16449n = new LinkedHashMap();
        this.f16443h = -1;
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyRecommendLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16449n = new LinkedHashMap();
        this.f16443h = -1;
        t();
    }
}

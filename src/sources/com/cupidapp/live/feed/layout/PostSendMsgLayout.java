package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.security.common.utils.UIUtils;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: PostSendMsgLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostSendMsgLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.view.o f14563d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14564e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f14565f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public User f14566g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public FKSensorContext f14567h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final List<FaceUIModel> f14568i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14569j;

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            int length = editable != null ? editable.length() : 0;
            ((ImageView) PostSendMsgLayout.this.h(R$id.post_send_btn)).setVisibility(length > 0 ? 0 : 8);
            if (PostSendMsgLayout.this.f14564e && length <= 0) {
                ((LinearLayout) PostSendMsgLayout.this.h(R$id.post_face_root)).setVisibility(0);
            } else {
                ((LinearLayout) PostSendMsgLayout.this.h(R$id.post_face_root)).setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostSendMsgLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14569j = new LinkedHashMap();
        this.f14568i = kotlin.collections.s.o(new FaceUIModel(R$string.full_score_msg_icon, R$string.full_score_icon_name, R$string.full_score_msg), new FaceUIModel(R$string.heart_msg_icon, R$string.heart_icon_name, R$string.heart_msg), new FaceUIModel(R$string.cool_msg_icon, R$string.cool_icon_name, R$string.cool_msg), new FaceUIModel(R$string.super_star_msg_icon, R$string.super_star_icon_name, R$string.super_star_msg), new FaceUIModel(R$string.awesome_msg_icon, R$string.awesome_icon_name, R$string.awesome_msg), new FaceUIModel(R$string.attractive_msg_icon, R$string.attractive_icon_name, R$string.attractive_msg));
        s();
    }

    public static final void t(PostSendMsgLayout this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (this$0.f14564e) {
            return;
        }
        this$0.y();
    }

    public static final boolean u(PostSendMsgLayout this$0, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (i10 != 4) {
            return true;
        }
        this$0.x(((EditText) this$0.h(R$id.post_send_txt)).getText().toString(), MsgType.TEXT);
        return true;
    }

    public static final boolean v(PostSendMsgLayout this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (!this$0.f14564e) {
            return false;
        }
        if (motionEvent.getRawY() < ((LinearLayout) this$0.h(R$id.post_send_ll)).getTop() && motionEvent.getAction() == 1) {
            Context context = this$0.getContext();
            kotlin.jvm.internal.s.h(context, "context");
            z0.h.p(context, (EditText) this$0.h(R$id.post_send_txt));
        }
        return true;
    }

    @Nullable
    public View h(int i10) {
        Map<Integer, View> map = this.f14569j;
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        if (this.f14564e) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    public final void p(@NotNull String postLimitId, @Nullable User user, @Nullable FKSensorContext fKSensorContext) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        this.f14567h = fKSensorContext;
        this.f14565f = postLimitId;
        this.f14566g = user;
    }

    public final void q() {
        int i10 = R$id.post_send_txt;
        EditText editText = (EditText) h(i10);
        if (editText != null) {
            editText.setMaxLines(Integer.MAX_VALUE);
        }
        EditText editText2 = (EditText) h(i10);
        if (editText2 != null) {
            editText2.setCursorVisible(false);
        }
        EditText editText3 = (EditText) h(i10);
        if (editText3 != null) {
            editText3.setSingleLine(true);
        }
        EditText editText4 = (EditText) h(i10);
        if (editText4 != null) {
            editText4.setFocusable(false);
        }
        EditText editText5 = (EditText) h(i10);
        if (editText5 != null) {
            editText5.setFocusableInTouchMode(false);
        }
        EditText editText6 = (EditText) h(i10);
        if (editText6 != null) {
            editText6.setEllipsize(TextUtils.TruncateAt.END);
        }
        EditText editText7 = (EditText) h(i10);
        if (editText7 != null) {
            editText7.setKeyListener(null);
        }
        ((LinearLayout) h(R$id.post_face_root)).setVisibility(8);
        ((ConstraintLayout) h(R$id.post_send_root)).setBackground(null);
    }

    public final void r() {
        int i10 = 0;
        for (FaceUIModel faceUIModel : this.f14568i) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final FaceUIModel faceUIModel2 = faceUIModel;
            View itemView = LayoutInflater.from(getContext()).inflate(R$layout.item_post_face, (ViewGroup) null);
            TextView textView = (TextView) itemView.findViewById(R$id.item_post_face_name);
            TextView textView2 = (TextView) itemView.findViewById(R$id.item_post_face_icon);
            textView.setText(getContext().getString(faceUIModel2.getName()));
            textView2.setText(getContext().getString(faceUIModel2.getIcon()));
            kotlin.jvm.internal.s.h(itemView, "itemView");
            y.d(itemView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostSendMsgLayout$initFaceView$1$1
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
                    PostSendMsgLayout postSendMsgLayout = PostSendMsgLayout.this;
                    String string = postSendMsgLayout.getContext().getString(faceUIModel2.getMsgContent());
                    kotlin.jvm.internal.s.h(string, "context.getString(item.msgContent)");
                    postSendMsgLayout.x(string, MsgType.EMOJI);
                }
            });
            if (i10 < 3) {
                LinearLayout linearLayout = (LinearLayout) h(R$id.face_first_linear);
                if (linearLayout != null) {
                    linearLayout.addView(itemView, new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
            } else {
                LinearLayout linearLayout2 = (LinearLayout) h(R$id.face_second_linear);
                if (linearLayout2 != null) {
                    linearLayout2.addView(itemView, new LinearLayout.LayoutParams(0, -2, 1.0f));
                }
            }
            i10 = i11;
        }
    }

    public final void s() {
        z.a(this, R$layout.layout_post_send_msg, true);
        int i10 = R$id.post_send_txt;
        ((EditText) h(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.feed.layout.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostSendMsgLayout.t(PostSendMsgLayout.this, view);
            }
        });
        EditText post_send_txt = (EditText) h(i10);
        kotlin.jvm.internal.s.h(post_send_txt, "post_send_txt");
        post_send_txt.addTextChangedListener(new a());
        r();
        ((EditText) h(i10)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.feed.layout.v
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean u10;
                u10 = PostSendMsgLayout.u(PostSendMsgLayout.this, textView, i11, keyEvent);
                return u10;
            }
        });
        ImageView post_send_btn = (ImageView) h(R$id.post_send_btn);
        kotlin.jvm.internal.s.h(post_send_btn, "post_send_btn");
        y.d(post_send_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostSendMsgLayout$initView$4
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
                PostSendMsgLayout postSendMsgLayout = PostSendMsgLayout.this;
                postSendMsgLayout.x(((EditText) postSendMsgLayout.h(R$id.post_send_txt)).getText().toString(), MsgType.TEXT);
            }
        });
        ((ConstraintLayout) h(R$id.post_send_root)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.feed.layout.u
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean v2;
                v2 = PostSendMsgLayout.v(PostSendMsgLayout.this, view, motionEvent);
                return v2;
            }
        });
    }

    public final void w() {
        if (this.f14563d == null) {
            Context context = getContext();
            kotlin.jvm.internal.s.g(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            this.f14563d = new com.cupidapp.live.base.view.o((FragmentActivity) context);
        }
        com.cupidapp.live.base.view.o oVar = this.f14563d;
        if (oVar != null) {
            oVar.b(new Function2<Integer, Boolean, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostSendMsgLayout$register$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
                    invoke(num.intValue(), bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(int i10, boolean z10) {
                    if (PostSendMsgLayout.this.f14564e == z10) {
                        return;
                    }
                    PostSendMsgLayout.this.f14564e = z10;
                    if (!z10) {
                        PostSendMsgLayout.this.q();
                        ((LinearLayout) PostSendMsgLayout.this.h(R$id.post_face_root)).setVisibility(8);
                    } else {
                        PostSendMsgLayout postSendMsgLayout = PostSendMsgLayout.this;
                        int i11 = R$id.post_send_txt;
                        EditText editText = (EditText) postSendMsgLayout.h(i11);
                        if (editText != null) {
                            editText.setFocusable(true);
                        }
                        EditText editText2 = (EditText) PostSendMsgLayout.this.h(i11);
                        if (editText2 != null) {
                            editText2.setFocusableInTouchMode(true);
                        }
                        EditText editText3 = (EditText) PostSendMsgLayout.this.h(i11);
                        if (editText3 != null) {
                            editText3.setCursorVisible(true);
                        }
                        EditText editText4 = (EditText) PostSendMsgLayout.this.h(i11);
                        if (editText4 != null) {
                            editText4.requestFocus();
                        }
                        Editable text = ((EditText) PostSendMsgLayout.this.h(i11)).getText();
                        kotlin.jvm.internal.s.h(text, "post_send_txt.text");
                        if (text.length() > 0) {
                            ((LinearLayout) PostSendMsgLayout.this.h(R$id.post_face_root)).setVisibility(8);
                        } else {
                            ((LinearLayout) PostSendMsgLayout.this.h(R$id.post_face_root)).setVisibility(0);
                        }
                        ((ConstraintLayout) PostSendMsgLayout.this.h(R$id.post_send_root)).setBackgroundColor(ContextCompat.getColor(PostSendMsgLayout.this.getContext(), R$color.app_black_45_alpha));
                    }
                    EventBus.c().l(new SoftKeyboardEvent(PostSendMsgLayout.this.f14564e));
                }
            });
        }
    }

    public final void x(String str, final MsgType msgType) {
        if (StringsKt__StringsKt.P0(str).toString().length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.l(getContext(), R$string.no_send_empty_msg);
            return;
        }
        if (this.f14565f == null || this.f14566g == null) {
            return;
        }
        d();
        x1.b j10 = NetworkClient.f11868a.j();
        String str2 = this.f14565f;
        kotlin.jvm.internal.s.f(str2);
        User user = this.f14566g;
        kotlin.jvm.internal.s.f(user);
        Observable<Result<Object>> e2 = j10.e(str2, str, user.userId());
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.layout.PostSendMsgLayout$sendMsg$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKSensorContext fKSensorContext;
                FKSensorContext fKSensorContext2;
                User user2;
                User user3;
                User user4;
                User user5;
                User user6;
                kotlin.jvm.internal.s.i(it, "it");
                PostSendMsgLayout.this.a();
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                fKSensorContext = PostSendMsgLayout.this.f14567h;
                SensorPosition position = fKSensorContext != null ? fKSensorContext.getPosition() : null;
                fKSensorContext2 = PostSendMsgLayout.this.f14567h;
                SensorPosition source = fKSensorContext2 != null ? fKSensorContext2.getSource() : null;
                user2 = PostSendMsgLayout.this.f14566g;
                String sensorRelationship = user2 != null ? user2.getSensorRelationship() : null;
                user3 = PostSendMsgLayout.this.f14566g;
                Boolean valueOf = user3 != null ? Boolean.valueOf(user3.getSuperLikedByMe()) : null;
                user4 = PostSendMsgLayout.this.f14566g;
                Boolean valueOf2 = user4 != null ? Boolean.valueOf(user4.getFocus()) : null;
                user5 = PostSendMsgLayout.this.f14566g;
                Boolean valueOf3 = user5 != null ? Boolean.valueOf(user5.getCloseFriend()) : null;
                String c4 = com.cupidapp.live.base.network.j.c(com.cupidapp.live.base.network.j.f12008a, it, false, 2, null);
                user6 = PostSendMsgLayout.this.f14566g;
                sensorsLogFeed.B(position, source, sensorRelationship, valueOf, valueOf2, valueOf3, c4, user6 != null ? user6.userId() : null, msgType.name(), (r23 & 512) != 0 ? Boolean.FALSE : null);
                return Boolean.FALSE;
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = e2.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostSendMsgLayout$sendMsg$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FKSensorContext fKSensorContext;
                FKSensorContext fKSensorContext2;
                User user2;
                User user3;
                User user4;
                User user5;
                User user6;
                PostSendMsgLayout.this.a();
                Context context2 = PostSendMsgLayout.this.getContext();
                kotlin.jvm.internal.s.h(context2, "context");
                PostSendMsgLayout postSendMsgLayout = PostSendMsgLayout.this;
                int i10 = R$id.post_send_txt;
                z0.h.p(context2, (EditText) postSendMsgLayout.h(i10));
                ((EditText) PostSendMsgLayout.this.h(i10)).setText((CharSequence) null);
                ((LinearLayout) PostSendMsgLayout.this.h(R$id.post_face_root)).setVisibility(8);
                com.cupidapp.live.base.view.h.f12779a.m(PostSendMsgLayout.this.getContext(), PostSendMsgLayout.this.getContext().getString(R$string.already_send_msg));
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                fKSensorContext = PostSendMsgLayout.this.f14567h;
                SensorPosition position = fKSensorContext != null ? fKSensorContext.getPosition() : null;
                fKSensorContext2 = PostSendMsgLayout.this.f14567h;
                SensorPosition source = fKSensorContext2 != null ? fKSensorContext2.getSource() : null;
                user2 = PostSendMsgLayout.this.f14566g;
                String sensorRelationship = user2 != null ? user2.getSensorRelationship() : null;
                user3 = PostSendMsgLayout.this.f14566g;
                Boolean valueOf = user3 != null ? Boolean.valueOf(user3.getSuperLikedByMe()) : null;
                user4 = PostSendMsgLayout.this.f14566g;
                Boolean valueOf2 = user4 != null ? Boolean.valueOf(user4.getFocus()) : null;
                user5 = PostSendMsgLayout.this.f14566g;
                Boolean valueOf3 = user5 != null ? Boolean.valueOf(user5.getCloseFriend()) : null;
                user6 = PostSendMsgLayout.this.f14566g;
                sensorsLogFeed.B(position, source, sensorRelationship, valueOf, valueOf2, valueOf3, null, user6 != null ? user6.userId() : null, msgType.name(), (r23 & 512) != 0 ? Boolean.FALSE : null);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        H(disposed);
    }

    public final void y() {
        int i10 = R$id.post_send_txt;
        ((EditText) h(i10)).setKeyListener(new TextKeyListener(TextKeyListener.Capitalize.NONE, false));
        ((EditText) h(i10)).setImeOptions(4);
        ((EditText) h(i10)).setInputType(131072);
        ((EditText) h(i10)).setSingleLine(false);
        ((EditText) h(i10)).setMaxLines(3);
        ((EditText) h(i10)).setFocusable(true);
        ((EditText) h(i10)).setFocusableInTouchMode(true);
        ((EditText) h(i10)).requestFocus();
        ((EditText) h(i10)).setCursorVisible(true);
        UIUtils.showInputMethod(getContext(), (EditText) h(i10));
    }

    public final void z() {
        com.cupidapp.live.base.view.o oVar = this.f14563d;
        if (oVar != null) {
            oVar.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostSendMsgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14569j = new LinkedHashMap();
        this.f14568i = kotlin.collections.s.o(new FaceUIModel(R$string.full_score_msg_icon, R$string.full_score_icon_name, R$string.full_score_msg), new FaceUIModel(R$string.heart_msg_icon, R$string.heart_icon_name, R$string.heart_msg), new FaceUIModel(R$string.cool_msg_icon, R$string.cool_icon_name, R$string.cool_msg), new FaceUIModel(R$string.super_star_msg_icon, R$string.super_star_icon_name, R$string.super_star_msg), new FaceUIModel(R$string.awesome_msg_icon, R$string.awesome_icon_name, R$string.awesome_msg), new FaceUIModel(R$string.attractive_msg_icon, R$string.attractive_icon_name, R$string.attractive_msg));
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostSendMsgLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14569j = new LinkedHashMap();
        this.f14568i = kotlin.collections.s.o(new FaceUIModel(R$string.full_score_msg_icon, R$string.full_score_icon_name, R$string.full_score_msg), new FaceUIModel(R$string.heart_msg_icon, R$string.heart_icon_name, R$string.heart_msg), new FaceUIModel(R$string.cool_msg_icon, R$string.cool_icon_name, R$string.cool_msg), new FaceUIModel(R$string.super_star_msg_icon, R$string.super_star_icon_name, R$string.super_star_msg), new FaceUIModel(R$string.awesome_msg_icon, R$string.awesome_icon_name, R$string.awesome_msg), new FaceUIModel(R$string.attractive_msg_icon, R$string.attractive_icon_name, R$string.attractive_msg));
        s();
    }
}

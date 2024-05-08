package com.cupidapp.live.liveshow.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.helper.ShareResultEvent;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.liveshow.activity.FKLiveCoverAlbumActivity;
import com.cupidapp.live.liveshow.model.FKLiveCoverModel;
import com.cupidapp.live.liveshow.model.LiveActivityItemModel;
import com.cupidapp.live.liveshow.model.LivePushModel;
import com.cupidapp.live.liveshow.model.LiveReserveResult;
import com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout;
import com.cupidapp.live.liveshow.view.LiveActivitySelectLayout;
import com.cupidapp.live.liveshow.view.music.view.FKLiveMusicProtocolLayout;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: FKLiveStreamerOpenLiveLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveStreamerOpenLiveLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f15265d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15266e;

    /* renamed from: f, reason: collision with root package name */
    public int f15267f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public SharePlatform f15268g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15269h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public c f15270i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f15271j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15272k;

    /* compiled from: FKLiveStreamerOpenLiveLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15273a;

        static {
            int[] iArr = new int[SharePlatform.values().length];
            try {
                iArr[SharePlatform.Wechat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SharePlatform.Weibo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SharePlatform.WechatMoments.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15273a = iArr;
        }
    }

    /* compiled from: FKLiveStreamerOpenLiveLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f15274b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f15275c;

        public b(Context context, Map.Entry<String, String> entry) {
            this.f15274b = context;
            this.f15275c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(com.cupidapp.live.base.router.j.f12156c, this.f15274b, this.f15275c.getValue(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveStreamerOpenLiveLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15272k = new LinkedHashMap();
        this.f15267f = -1;
        this.f15271j = kotlin.c.b(new FKLiveStreamerOpenLiveLayout$touchListener$2(this));
        F();
    }

    private final View.OnTouchListener getTouchListener() {
        return (View.OnTouchListener) this.f15271j.getValue();
    }

    public static final void v(FKLiveStreamerOpenLiveLayout this$0, RadioGroup radioGroup, int i10) {
        SharePlatform sharePlatform;
        s.i(this$0, "this$0");
        this$0.f15267f = i10;
        if (i10 == ((RadioButton) this$0.h(R$id.weChatShareRadioBtn)).getId()) {
            sharePlatform = SharePlatform.Wechat;
        } else if (i10 == ((RadioButton) this$0.h(R$id.weiBoShareRadioBtn)).getId()) {
            sharePlatform = SharePlatform.Weibo;
        } else {
            sharePlatform = i10 == ((RadioButton) this$0.h(R$id.weChatTimeLineShareRadioBtn)).getId() ? SharePlatform.WechatMoments : null;
        }
        this$0.f15268g = sharePlatform;
    }

    public static final void w(FKLiveStreamerOpenLiveLayout this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        ((FKUniversalButton) this$0.h(R$id.startLiveShowButton)).a(z10);
    }

    public static final void x(FKLiveStreamerOpenLiveLayout this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        if (compoundButton.isPressed()) {
            if (z10) {
                this$0.D(true);
            }
            GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
            AppSetting appSetting = AppSetting.NOTICE_FANS;
            if (this$0.f15266e) {
                z10 = false;
            }
            SensorPosition sensorPosition = SensorPosition.PreviewLiveShow;
            User X = p1.g.f52734a.X();
            groupOthersLog.k0(appSetting, z10, sensorPosition, X != null ? X.userId() : null);
        }
    }

    public final void A() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKLiveStreamerOpenLiveLayout, Float>) View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    public final void B() {
        Disposable disposed = NetworkClient.f11868a.r().u0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FKLiveCoverModel, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$initLiveCoverData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FKLiveCoverModel fKLiveCoverModel) {
                m2638invoke(fKLiveCoverModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2638invoke(FKLiveCoverModel fKLiveCoverModel) {
                FKLiveCoverModel fKLiveCoverModel2 = fKLiveCoverModel;
                ImageLoaderView open_live_cover_img = (ImageLoaderView) FKLiveStreamerOpenLiveLayout.this.h(R$id.open_live_cover_img);
                s.h(open_live_cover_img, "open_live_cover_img");
                ImageLoaderView.g(open_live_cover_img, fKLiveCoverModel2.getCover(), null, null, 6, null);
                if (s.d(fKLiveCoverModel2.getHasUpload(), Boolean.FALSE)) {
                    ((TextView) FKLiveStreamerOpenLiveLayout.this.h(R$id.open_live_upload_cover_tip)).setVisibility(0);
                }
                String title = fKLiveCoverModel2.getTitle();
                if (title == null || title.length() == 0) {
                    return;
                }
                FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = FKLiveStreamerOpenLiveLayout.this;
                int i10 = R$id.liveTitleEditText;
                ((EditText) fKLiveStreamerOpenLiveLayout.h(i10)).setText(fKLiveCoverModel2.getTitle());
                ((EditText) FKLiveStreamerOpenLiveLayout.this.h(i10)).setSelection(fKLiveCoverModel2.getTitle().length());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void C(Context context, LinkDictTipsModel linkDictTipsModel) {
        SpannableStringBuilder c4;
        if (linkDictTipsModel.getLinkDict() != null && !linkDictTipsModel.getLinkDict().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            for (Map.Entry<String, String> entry : linkDictTipsModel.getLinkDict().entrySet()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                Map.Entry<String, String> entry2 = entry;
                arrayList.add(i10, entry2.getKey());
                arrayList2.add(i10, new b(context, entry2));
                i10 = i11;
            }
            c4 = q1.d.f53006a.c(linkDictTipsModel.getContent(), arrayList, (r18 & 4) != 0 ? null : -1, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.liveRulesTextView;
            ((TextView) h(i12)).setText(c4);
            ((TextView) h(i12)).setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        ((TextView) h(R$id.liveRulesTextView)).setText(linkDictTipsModel.getContent());
    }

    public final void D(final boolean z10) {
        if (this.f15265d != null) {
            ((CheckBox) h(R$id.push_fans_checkbox)).setChecked(false);
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().W().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LivePushModel, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$initPushStatus$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LivePushModel livePushModel) {
                m2639invoke(livePushModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2639invoke(LivePushModel livePushModel) {
                Long pushEnableTime;
                LivePushModel livePushModel2 = livePushModel;
                if (livePushModel2.getPushEnableTime() != null && ((pushEnableTime = livePushModel2.getPushEnableTime()) == null || pushEnableTime.longValue() != 0)) {
                    FKLiveStreamerOpenLiveLayout.this.f15266e = true;
                    ((CheckBox) FKLiveStreamerOpenLiveLayout.this.h(R$id.push_fans_checkbox)).setChecked(false);
                    if (z10) {
                        FKLiveStreamerOpenLiveLayout.this.M(livePushModel2.getPushEnableTime().longValue());
                        return;
                    }
                    return;
                }
                FKLiveStreamerOpenLiveLayout.this.f15266e = false;
                ((CheckBox) FKLiveStreamerOpenLiveLayout.this.h(R$id.push_fans_checkbox)).setChecked(true);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void E() {
        int id2;
        SharePlatform c4 = p1.g.f52734a.u1().c();
        if (c4 != null) {
            this.f15268g = c4;
            int i10 = a.f15273a[c4.ordinal()];
            if (i10 == 1) {
                id2 = ((RadioButton) h(R$id.weChatShareRadioBtn)).getId();
            } else if (i10 != 2) {
                id2 = i10 != 3 ? 0 : ((RadioButton) h(R$id.weChatTimeLineShareRadioBtn)).getId();
            } else {
                id2 = ((RadioButton) h(R$id.weiBoShareRadioBtn)).getId();
            }
            this.f15267f = id2;
            ((RadioGroup) h(R$id.shareButtonRadioGroup)).check(this.f15267f);
        }
    }

    public final void F() {
        LinkDictTipsModel startLiveTips;
        z.a(this, R$layout.layout_live_streamer_open_live, true);
        Context context = getContext();
        s.h(context, "context");
        EditText liveTitleEditText = (EditText) h(R$id.liveTitleEditText);
        s.h(liveTitleEditText, "liveTitleEditText");
        z0.h.v(context, liveTitleEditText);
        B();
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null && (startLiveTips = q10.getStartLiveTips()) != null) {
            Context context2 = getContext();
            s.h(context2, "context");
            C(context2, startLiveTips);
        }
        E();
        u();
        D(false);
    }

    public final void G(int i10, int i11, @Nullable Intent intent) {
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
        if (i10 == 221203 && i11 == -1) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("ACTIVITY_RESULT_IMAGE_MODEL") : null;
            ImageModel imageModel = serializableExtra instanceof ImageModel ? (ImageModel) serializableExtra : null;
            if (imageModel != null) {
                ImageLoaderView open_live_cover_img = (ImageLoaderView) h(R$id.open_live_cover_img);
                s.h(open_live_cover_img, "open_live_cover_img");
                ImageLoaderView.g(open_live_cover_img, imageModel, null, null, 6, null);
                ((TextView) h(R$id.open_live_upload_cover_tip)).setVisibility(8);
            }
        }
    }

    public final void I() {
        Context context = getContext();
        final FKBaseActivity fKBaseActivity = context instanceof FKBaseActivity ? (FKBaseActivity) context : null;
        if (fKBaseActivity == null) {
            return;
        }
        FKRxPermissionAlertDialog.Companion companion = FKRxPermissionAlertDialog.f12016a;
        Context context2 = getContext();
        s.h(context2, "context");
        companion.m(context2, new xb.b(fKBaseActivity), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$openAlbum$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveCoverAlbumActivity.f14746v.a(FKBaseActivity.this, new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.LiveCover, SensorPosition.PreviewLiveShow, null, 152, null));
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    public final void J(boolean z10) {
        ((FKUniversalButton) h(R$id.startLiveShowButton)).setEnabled(z10);
    }

    public final void K() {
        LiveActivitySelectLayout.a aVar = LiveActivitySelectLayout.f15298d;
        if (aVar.b()) {
            List<LiveActivityItemModel> c4 = aVar.c();
            final ArrayList arrayList = new ArrayList();
            for (LiveActivityItemModel liveActivityItemModel : c4) {
                String id2 = liveActivityItemModel.getId();
                if (!(id2 == null || id2.length() == 0)) {
                    arrayList.add(liveActivityItemModel);
                }
            }
            u2.a r10 = NetworkClient.f11868a.r();
            ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                String id3 = ((LiveActivityItemModel) iterator2.next()).getId();
                s.f(id3);
                arrayList2.add(id3);
            }
            Disposable disposed = r10.H0(arrayList2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$selectLiveActivity$$inlined$handle$default$1
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
                    GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                    List list = List.this;
                    ArrayList arrayList3 = new ArrayList(t.t(list, 10));
                    Iterator<E> iterator22 = list.iterator2();
                    while (iterator22.hasNext()) {
                        arrayList3.add(((LiveActivityItemModel) iterator22.next()).getTitle());
                    }
                    groupLiveLog.n(arrayList3);
                    LiveActivitySelectLayout.f15298d.f(false);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void L() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKLiveStreamerOpenLiveLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    public final void M(long j10) {
        TextView push_fans_prompt_textview = (TextView) h(R$id.push_fans_prompt_textview);
        s.h(push_fans_prompt_textview, "push_fans_prompt_textview");
        push_fans_prompt_textview.setVisibility(0);
        com.cupidapp.live.base.utils.i iVar = new com.cupidapp.live.base.utils.i();
        this.f15265d = iVar;
        iVar.c(Integer.valueOf((int) j10), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$startCountDown$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveStreamerOpenLiveLayout.this.f15266e = false;
                FKLiveStreamerOpenLiveLayout.this.f15265d = null;
                TextView push_fans_prompt_textview2 = (TextView) FKLiveStreamerOpenLiveLayout.this.h(R$id.push_fans_prompt_textview);
                s.h(push_fans_prompt_textview2, "push_fans_prompt_textview");
                push_fans_prompt_textview2.setVisibility(8);
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$startCountDown$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                ((TextView) FKLiveStreamerOpenLiveLayout.this.h(R$id.push_fans_prompt_textview)).setText(FKLiveStreamerOpenLiveLayout.this.getContext().getString(R$string.push_fans_prompt, v.f(i10)));
            }
        });
    }

    public final void N() {
        com.cupidapp.live.base.utils.i iVar = this.f15265d;
        if (iVar != null) {
            iVar.g();
        }
        this.f15265d = null;
    }

    public final void O() {
        J(false);
        this.f15269h = false;
        Context context = getContext();
        s.h(context, "context");
        z0.h.q(context, null, 1, null);
        setVisibility(8);
        String str = this.f15266e ? "COOLING" : ((CheckBox) h(R$id.push_fans_checkbox)).isChecked() ? "START" : "CLOSE";
        c cVar = this.f15270i;
        if (cVar != null) {
            cVar.b(StringsKt__StringsKt.P0(((EditText) h(R$id.liveTitleEditText)).getText().toString()).toString(), true ^ ((CheckBox) h(R$id.push_fans_checkbox)).isChecked(), str);
        }
        K();
        N();
    }

    @Nullable
    public View h(int i10) {
        Map<Integer, View> map = this.f15272k;
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

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShareResultEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (getVisibility() == 8) {
            return;
        }
        O();
    }

    public final void setOpenLiveLayoutListener(@NotNull c listener) {
        s.i(listener, "listener");
        this.f15270i = listener;
    }

    public final void t() {
        if (this.f15268g == SharePlatform.Wechat && this.f15269h) {
            O();
        }
    }

    public final void u() {
        FKUniversalButton startLiveShowButton = (FKUniversalButton) h(R$id.startLiveShowButton);
        s.h(startLiveShowButton, "startLiveShowButton");
        y.d(startLiveShowButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$bindClickEvent$1
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
                FKLiveMusicProtocolLayout.a aVar = FKLiveMusicProtocolLayout.f15811e;
                if (aVar.a() != null) {
                    Context context = FKLiveStreamerOpenLiveLayout.this.getContext();
                    s.h(context, "context");
                    final FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = FKLiveStreamerOpenLiveLayout.this;
                    aVar.c(context, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$bindClickEvent$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FKLiveStreamerOpenLiveLayout.this.y();
                        }
                    });
                    return;
                }
                FKLiveStreamerOpenLiveLayout.this.y();
            }
        });
        ((FKTitleBarLayout) h(R$id.openLiveTitleBarLayout)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$bindClickEvent$2
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
                Context context = FKLiveStreamerOpenLiveLayout.this.getContext();
                s.h(context, "context");
                z0.h.q(context, null, 1, null);
                Context context2 = FKLiveStreamerOpenLiveLayout.this.getContext();
                Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        ((RadioButton) h(R$id.weChatShareRadioBtn)).setOnTouchListener(getTouchListener());
        ((RadioButton) h(R$id.weiBoShareRadioBtn)).setOnTouchListener(getTouchListener());
        ((RadioButton) h(R$id.weChatTimeLineShareRadioBtn)).setOnTouchListener(getTouchListener());
        ((RadioGroup) h(R$id.shareButtonRadioGroup)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.cupidapp.live.liveshow.view.h
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                FKLiveStreamerOpenLiveLayout.v(FKLiveStreamerOpenLiveLayout.this, radioGroup, i10);
            }
        });
        TextView openLiveBeautyView = (TextView) h(R$id.openLiveBeautyView);
        s.h(openLiveBeautyView, "openLiveBeautyView");
        y.d(openLiveBeautyView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$bindClickEvent$4
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
                c cVar;
                cVar = FKLiveStreamerOpenLiveLayout.this.f15270i;
                if (cVar != null) {
                    cVar.c();
                }
            }
        });
        TextView openLiveChangeView = (TextView) h(R$id.openLiveChangeView);
        s.h(openLiveChangeView, "openLiveChangeView");
        y.d(openLiveChangeView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$bindClickEvent$5
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
                c cVar;
                cVar = FKLiveStreamerOpenLiveLayout.this.f15270i;
                if (cVar != null) {
                    cVar.a();
                }
            }
        });
        ((CheckBox) h(R$id.openLiveAgreeCheckBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.liveshow.view.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKLiveStreamerOpenLiveLayout.w(FKLiveStreamerOpenLiveLayout.this, compoundButton, z10);
            }
        });
        ImageLoaderView open_live_cover_img = (ImageLoaderView) h(R$id.open_live_cover_img);
        s.h(open_live_cover_img, "open_live_cover_img");
        y.d(open_live_cover_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$bindClickEvent$7
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
                FKLiveStreamerOpenLiveLayout.this.I();
            }
        });
        ((CheckBox) h(R$id.push_fans_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.liveshow.view.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKLiveStreamerOpenLiveLayout.x(FKLiveStreamerOpenLiveLayout.this, compoundButton, z10);
            }
        });
    }

    public final void y() {
        if (z0.h.g(getContext()) == NetworkStateConstants.MOBILE) {
            Context context = getContext();
            s.h(context, "context");
            z0.h.q(context, null, 1, null);
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.liveshow_4G_alert_title, 0, 2, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$checkNetwork$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKLiveStreamerOpenLiveLayout.this.z();
                }
            }, 3, null), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$checkNetwork$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Context context2 = FKLiveStreamerOpenLiveLayout.this.getContext();
                    s.h(context2, "context");
                    z0.h.q(context2, null, 1, null);
                }
            }, 1, null), null, 1, null);
            return;
        }
        z();
    }

    public final void z() {
        if (this.f15267f != -1) {
            NetworkClient networkClient = NetworkClient.f11868a;
            u2.a r10 = networkClient.r();
            p1.g gVar = p1.g.f52734a;
            User X = gVar.X();
            String userId = X != null ? X.userId() : null;
            SharePlatform sharePlatform = this.f15268g;
            Disposable disposed = r10.d0(userId, null, sharePlatform != null ? sharePlatform.getValue() : null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$checkShare$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
            Context context = getContext();
            FKBaseActivity fKBaseActivity = context instanceof FKBaseActivity ? (FKBaseActivity) context : null;
            if (fKBaseActivity != null) {
                fKBaseActivity.e1();
            }
            gVar.u1().d(this.f15268g);
            Disposable disposed2 = networkClient.r().T().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveReserveResult, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$checkShare$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(LiveReserveResult liveReserveResult) {
                    m2637invoke(liveReserveResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2637invoke(LiveReserveResult liveReserveResult) {
                    SharePlatform sharePlatform2;
                    LiveReserveResult liveReserveResult2 = liveReserveResult;
                    Context context2 = FKLiveStreamerOpenLiveLayout.this.getContext();
                    FKBaseActivity fKBaseActivity2 = context2 instanceof FKBaseActivity ? (FKBaseActivity) context2 : null;
                    if (fKBaseActivity2 != null) {
                        fKBaseActivity2.V0();
                    }
                    String shareLink = liveReserveResult2.getUser().getShareLink();
                    String shareTitle = liveReserveResult2.getUser().getShareTitle();
                    String shareContent = liveReserveResult2.getUser().getShareContent();
                    ImageModel avatarImage = liveReserveResult2.getUser().getAvatarImage();
                    Context context3 = FKLiveStreamerOpenLiveLayout.this.getContext();
                    ShareBuilder shareBuilder = new ShareBuilder(shareLink, shareTitle, shareContent, avatarImage, context3 instanceof Activity ? (Activity) context3 : null, liveReserveResult2.getUser().userId(), null, null, null, null, null, 0, null, null, null, 32704, null);
                    sharePlatform2 = FKLiveStreamerOpenLiveLayout.this.f15268g;
                    int i10 = sharePlatform2 == null ? -1 : FKLiveStreamerOpenLiveLayout.a.f15273a[sharePlatform2.ordinal()];
                    if (i10 == 1) {
                        FKLiveStreamerOpenLiveLayout.this.f15269h = true;
                        com.cupidapp.live.base.share.helper.d.f12255a.o(SharePlatform.Wechat, shareBuilder, SensorPosition.PreviewLiveShow);
                    } else if (i10 == 2) {
                        com.cupidapp.live.base.share.helper.d.f12255a.o(SharePlatform.Weibo, shareBuilder, SensorPosition.PreviewLiveShow);
                    } else if (i10 != 3) {
                        FKLiveStreamerOpenLiveLayout.this.O();
                    } else {
                        com.cupidapp.live.base.share.helper.d.f12255a.o(SharePlatform.WechatMoments, shareBuilder, SensorPosition.PreviewLiveShow);
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout$checkShare$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    Context context2 = FKLiveStreamerOpenLiveLayout.this.getContext();
                    FKBaseActivity fKBaseActivity2 = context2 instanceof FKBaseActivity ? (FKBaseActivity) context2 : null;
                    if (fKBaseActivity2 != null) {
                        fKBaseActivity2.V0();
                    }
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed2 != null) {
                s.h(disposed2, "disposed");
                H(disposed2);
            }
            s.h(disposed2, "disposed");
            return;
        }
        p1.g.f52734a.u1().d(null);
        O();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveStreamerOpenLiveLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15272k = new LinkedHashMap();
        this.f15267f = -1;
        this.f15271j = kotlin.c.b(new FKLiveStreamerOpenLiveLayout$touchListener$2(this));
        F();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveStreamerOpenLiveLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15272k = new LinkedHashMap();
        this.f15267f = -1;
        this.f15271j = kotlin.c.b(new FKLiveStreamerOpenLiveLayout$touchListener$2(this));
        F();
    }
}

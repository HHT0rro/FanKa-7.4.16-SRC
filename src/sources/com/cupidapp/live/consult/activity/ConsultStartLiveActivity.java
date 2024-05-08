package com.cupidapp.live.consult.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.helper.ShareResultEvent;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.consult.activity.ConsultAnchorActivity;
import com.cupidapp.live.consult.activity.ConsultStartLiveActivity;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.consult.model.ConsultCoverResult;
import com.cupidapp.live.consult.model.ConsultLiveCategory;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultReserveResult;
import com.cupidapp.live.liveshow.activity.FKLiveCoverAlbumActivity;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.y;

/* compiled from: ConsultStartLiveActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultStartLiveActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f13722v = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public ConsultLiveCategory f13724r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public SharePlatform f13725s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13726t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13727u = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f13723q = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$mRxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(ConsultStartLiveActivity.this);
        }
    });

    /* compiled from: ConsultStartLiveActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            if (context == null) {
                return;
            }
            FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodEnterLive, false, true, 2, null);
            context.startActivity(new Intent(context, (Class<?>) ConsultStartLiveActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ConsultStartLiveActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13728a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13729b;

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
            f13728a = iArr;
            int[] iArr2 = new int[ConsultLiveCategory.values().length];
            try {
                iArr2[ConsultLiveCategory.ASTROLABE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ConsultLiveCategory.TAROT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ConsultLiveCategory.PSYCHOLOGY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f13729b = iArr2;
        }
    }

    /* compiled from: ConsultStartLiveActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends h0 {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f13731c;

        public c(Map.Entry<String, String> entry) {
            this.f13731c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, ConsultStartLiveActivity.this, this.f13731c.getValue(), null, 4, null);
        }
    }

    public static final void J1(ConsultStartLiveActivity this$0) {
        s.i(this$0, "this$0");
        h.q(this$0, null, 1, null);
    }

    public static final boolean x1(ConsultStartLiveActivity this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        RadioButton radioButton = view instanceof RadioButton ? (RadioButton) view : null;
        if (motionEvent.getAction() == 0) {
            if (radioButton != null && radioButton.isChecked()) {
                ((RadioGroup) this$0.n1(R$id.consult_start_live_share_radio_group)).clearCheck();
                return true;
            }
        }
        return false;
    }

    public static final void y1(ConsultStartLiveActivity this$0, RadioGroup radioGroup, int i10) {
        SharePlatform sharePlatform;
        s.i(this$0, "this$0");
        if (i10 == ((RadioButton) this$0.n1(R$id.consult_start_live_wechat_share_radio)).getId()) {
            sharePlatform = SharePlatform.Wechat;
        } else if (i10 == ((RadioButton) this$0.n1(R$id.consult_start_live_weibo_share_radio)).getId()) {
            sharePlatform = SharePlatform.Weibo;
        } else {
            sharePlatform = i10 == ((RadioButton) this$0.n1(R$id.consult_start_live_wechat_time_share_radio)).getId() ? SharePlatform.WechatMoments : null;
        }
        this$0.f13725s = sharePlatform;
    }

    public static final void z1(ConsultStartLiveActivity this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        ((FKUniversalButton) this$0.n1(R$id.consult_start_live_btn)).a(z10);
    }

    public final void A1(ConsultLiveCategory consultLiveCategory) {
        int i10 = R$id.consult_astrolabe_category_layout;
        ((LinearLayout) n1(i10)).setBackgroundResource(R$drawable.rect_cor_6_sk_1affffff_sd_1affffff);
        int i11 = R$id.consult_astrolabe_category_checkbox;
        ((CheckBox) n1(i11)).setChecked(false);
        int i12 = R$id.consult_tarot_category_layout;
        ((LinearLayout) n1(i12)).setBackgroundResource(R$drawable.rect_cor_6_sk_1affffff_sd_1affffff);
        int i13 = R$id.consult_tarot_category_checkbox;
        ((CheckBox) n1(i13)).setChecked(false);
        int i14 = R$id.consult_psychological_category_layout;
        ((LinearLayout) n1(i14)).setBackgroundResource(R$drawable.rect_cor_6_sk_1affffff_sd_1affffff);
        int i15 = R$id.consult_psychological_category_checkbox;
        ((CheckBox) n1(i15)).setChecked(false);
        int i16 = b.f13729b[consultLiveCategory.ordinal()];
        if (i16 == 1) {
            ((LinearLayout) n1(i10)).setBackgroundResource(R$drawable.rect_cor_6_sk_ffffff_sd_1affffff);
            ((CheckBox) n1(i11)).setChecked(true);
            ((ConstraintLayout) n1(R$id.consult_start_live_root_layout)).setBackgroundResource(R$mipmap.bg_consult_astrolabe);
        } else if (i16 == 2) {
            ((LinearLayout) n1(i12)).setBackgroundResource(R$drawable.rect_cor_6_sk_ffffff_sd_1affffff);
            ((CheckBox) n1(i13)).setChecked(true);
            ((ConstraintLayout) n1(R$id.consult_start_live_root_layout)).setBackgroundResource(R$mipmap.bg_consult_tarot);
        } else if (i16 == 3) {
            ((LinearLayout) n1(i14)).setBackgroundResource(R$drawable.rect_cor_6_sk_ffffff_sd_1affffff);
            ((CheckBox) n1(i15)).setChecked(true);
            ((ConstraintLayout) n1(R$id.consult_start_live_root_layout)).setBackgroundResource(R$mipmap.bg_consult_psychology);
        }
        this.f13724r = consultLiveCategory;
    }

    public final void B1() {
        if (StringsKt__StringsKt.P0(((EditText) n1(R$id.consult_start_live_edit_title_text)).getText().toString()).toString().length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.start_live_need_title_tip);
        } else if (this.f13724r == null) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.start_live_need_category_tip);
        } else {
            FKRxPermissionAlertDialog.f12016a.i(this, D1(), new Function0<p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$checkRequiredFieldsAndPermission$1
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
                    ConsultStartLiveActivity.this.C1();
                }
            });
        }
    }

    public final void C1() {
        if (this.f13725s == null) {
            I1();
            return;
        }
        com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, null, false, 3, null);
        Disposable disposed = NetworkClient.f11868a.v().q().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultReserveResult, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$checkShare$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultReserveResult consultReserveResult) {
                m2531invoke(consultReserveResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2531invoke(ConsultReserveResult consultReserveResult) {
                SharePlatform sharePlatform;
                ConsultReserveResult consultReserveResult2 = consultReserveResult;
                com.cupidapp.live.base.view.dialog.h.f12743a.b();
                ShareBuilder shareBuilder = new ShareBuilder(consultReserveResult2.getUser().getShareLink(), consultReserveResult2.getUser().getShareTitle(), consultReserveResult2.getUser().getShareContent(), consultReserveResult2.getUser().getAvatarImage(), ConsultStartLiveActivity.this, consultReserveResult2.getUser().userId(), null, null, null, null, null, 0, null, null, null, 32704, null);
                SensorPosition Q0 = ConsultStartLiveActivity.this.Q0();
                sharePlatform = ConsultStartLiveActivity.this.f13725s;
                int i10 = sharePlatform == null ? -1 : ConsultStartLiveActivity.b.f13728a[sharePlatform.ordinal()];
                if (i10 == 1) {
                    ConsultStartLiveActivity.this.f13726t = true;
                    com.cupidapp.live.base.share.helper.d.f12255a.o(SharePlatform.Wechat, shareBuilder, Q0);
                } else if (i10 == 2) {
                    com.cupidapp.live.base.share.helper.d.f12255a.o(SharePlatform.Weibo, shareBuilder, Q0);
                } else if (i10 != 3) {
                    ConsultStartLiveActivity.this.I1();
                } else {
                    com.cupidapp.live.base.share.helper.d.f12255a.o(SharePlatform.WechatMoments, shareBuilder, Q0);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$checkShare$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                com.cupidapp.live.base.view.dialog.h.f12743a.b();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final xb.b D1() {
        return (xb.b) this.f13723q.getValue();
    }

    public final void E1() {
        SpannableStringBuilder c4;
        ConstantsResult q10 = g.f52734a.q();
        LinkDictTipsModel startLiveTips = q10 != null ? q10.getStartLiveTips() : null;
        if (startLiveTips != null) {
            boolean z10 = true;
            if (startLiveTips.getContent().length() == 0) {
                return;
            }
            Map<String, String> linkDict = startLiveTips.getLinkDict();
            if (linkDict != null && !linkDict.isEmpty()) {
                z10 = false;
            }
            if (z10) {
                ((TextView) n1(R$id.consult_start_live_rules_text)).setText(startLiveTips.getContent());
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            for (Map.Entry<String, String> entry : startLiveTips.getLinkDict().entrySet()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                Map.Entry<String, String> entry2 = entry;
                arrayList.add(i10, entry2.getKey());
                arrayList2.add(i10, new c(entry2));
                i10 = i11;
            }
            c4 = q1.d.f53006a.c(startLiveTips.getContent(), arrayList, (r18 & 4) != 0 ? null : -5658199, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
            int i12 = R$id.consult_start_live_rules_text;
            ((TextView) n1(i12)).setText(c4);
            ((TextView) n1(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public final void F1() {
        EditText consult_start_live_edit_title_text = (EditText) n1(R$id.consult_start_live_edit_title_text);
        s.h(consult_start_live_edit_title_text, "consult_start_live_edit_title_text");
        h.v(this, consult_start_live_edit_title_text);
        E1();
        Disposable disposed = NetworkClient.f11868a.v().u().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultCoverResult, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$initView$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultCoverResult consultCoverResult) {
                m2532invoke(consultCoverResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2532invoke(ConsultCoverResult consultCoverResult) {
                ConsultCoverResult consultCoverResult2 = consultCoverResult;
                ImageLoaderView consult_start_live_cover_img = (ImageLoaderView) ConsultStartLiveActivity.this.n1(R$id.consult_start_live_cover_img);
                s.h(consult_start_live_cover_img, "consult_start_live_cover_img");
                ImageLoaderView.g(consult_start_live_cover_img, consultCoverResult2.getCover(), null, null, 6, null);
                if (s.d(consultCoverResult2.getHasUpload(), Boolean.FALSE)) {
                    ((TextView) ConsultStartLiveActivity.this.n1(R$id.consult_start_live_upload_cover_tip)).setVisibility(0);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void G1() {
        FKRxPermissionAlertDialog.f12016a.m(this, D1(), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$openAlbum$1
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
                FKLiveCoverAlbumActivity.f14746v.a(ConsultStartLiveActivity.this, new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.LiveCover, ConsultStartLiveActivity.this.Q0(), null, 152, null));
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }

    public final void H1() {
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.consult_live_instructions).l(R$string.consult_live_instructions_desc, 8388611), R$string.i_know_it, null, null, 6, null), null, 1, null);
    }

    public final void I1() {
        int i10 = R$id.consult_start_live_edit_title_text;
        ((EditText) n1(i10)).postDelayed(new Runnable() { // from class: com.cupidapp.live.consult.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                ConsultStartLiveActivity.J1(ConsultStartLiveActivity.this);
            }
        }, 10L);
        String obj = StringsKt__StringsKt.P0(((EditText) n1(i10)).getText().toString()).toString();
        if (obj.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.start_live_need_title_tip);
            return;
        }
        ConsultLiveCategory consultLiveCategory = this.f13724r;
        if (consultLiveCategory == null) {
            com.cupidapp.live.base.view.h.f12779a.l(this, R$string.start_live_need_category_tip);
            return;
        }
        com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, null, false, 3, null);
        this.f13726t = false;
        Observable<Result<ConsultLiveModel>> delay = NetworkClient.f11868a.v().b(obj, consultLiveCategory.getValue(), ((CheckBox) n1(R$id.consult_start_live_push_fans_checkbox)).isChecked()).delay(1L, TimeUnit.SECONDS);
        s.h(delay, "NetworkClient.mConsultSe…elay(1, TimeUnit.SECONDS)");
        Disposable disposed = delay.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultLiveModel, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$startLive$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveModel consultLiveModel) {
                m2533invoke(consultLiveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2533invoke(ConsultLiveModel consultLiveModel) {
                com.cupidapp.live.base.view.dialog.h.f12743a.b();
                ConsultAnchorActivity.a.b(ConsultAnchorActivity.f13716v, ConsultStartLiveActivity.this, consultLiveModel, false, 4, null);
                ConsultStartLiveActivity.this.d1(R$anim.anim_activity_nothing, null);
                ConsultStartLiveActivity.this.finish();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$startLive$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                com.cupidapp.live.base.view.dialog.h.f12743a.b();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PREVIEW_CONSULT_SHOW;
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f13727u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
        if (i10 == 221203 && i11 == -1) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("ACTIVITY_RESULT_IMAGE_MODEL") : null;
            ImageModel imageModel = serializableExtra instanceof ImageModel ? (ImageModel) serializableExtra : null;
            if (imageModel != null) {
                ImageLoaderView consult_start_live_cover_img = (ImageLoaderView) n1(R$id.consult_start_live_cover_img);
                s.h(consult_start_live_cover_img, "consult_start_live_cover_img");
                ImageLoaderView.g(consult_start_live_cover_img, imageModel, null, null, 6, null);
                ((TextView) n1(R$id.consult_start_live_upload_cover_tip)).setVisibility(8);
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_consult_start_live);
        p0.c(this, true, 0, 2, null);
        ConsultFloatWindowHelper.f13810b.i();
        F1();
        w1();
        GroupOthersLog.d(GroupOthersLog.f18702a, SensorPosition.PREVIEW_CONSULT_SHOW.getValue(), null, null, 6, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShareResultEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        I1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f13725s == SharePlatform.Wechat && this.f13726t) {
            I1();
        }
    }

    public final void w1() {
        ((FKTitleBarLayout) n1(R$id.consult_start_live_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$1
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
                ConsultStartLiveActivity.this.onBackPressed();
            }
        });
        ImageLoaderView consult_start_live_cover_img = (ImageLoaderView) n1(R$id.consult_start_live_cover_img);
        s.h(consult_start_live_cover_img, "consult_start_live_cover_img");
        y.d(consult_start_live_cover_img, new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$2
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
                ConsultStartLiveActivity.this.G1();
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.cupidapp.live.consult.activity.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x12;
                x12 = ConsultStartLiveActivity.x1(ConsultStartLiveActivity.this, view, motionEvent);
                return x12;
            }
        };
        ((RadioButton) n1(R$id.consult_start_live_wechat_share_radio)).setOnTouchListener(onTouchListener);
        ((RadioButton) n1(R$id.consult_start_live_weibo_share_radio)).setOnTouchListener(onTouchListener);
        ((RadioButton) n1(R$id.consult_start_live_wechat_time_share_radio)).setOnTouchListener(onTouchListener);
        ((RadioGroup) n1(R$id.consult_start_live_share_radio_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.cupidapp.live.consult.activity.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                ConsultStartLiveActivity.y1(ConsultStartLiveActivity.this, radioGroup, i10);
            }
        });
        LinearLayout consult_astrolabe_category_layout = (LinearLayout) n1(R$id.consult_astrolabe_category_layout);
        s.h(consult_astrolabe_category_layout, "consult_astrolabe_category_layout");
        y.d(consult_astrolabe_category_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$4
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
                ConsultStartLiveActivity.this.A1(ConsultLiveCategory.ASTROLABE);
            }
        });
        LinearLayout consult_tarot_category_layout = (LinearLayout) n1(R$id.consult_tarot_category_layout);
        s.h(consult_tarot_category_layout, "consult_tarot_category_layout");
        y.d(consult_tarot_category_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$5
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
                ConsultStartLiveActivity.this.A1(ConsultLiveCategory.TAROT);
            }
        });
        LinearLayout consult_psychological_category_layout = (LinearLayout) n1(R$id.consult_psychological_category_layout);
        s.h(consult_psychological_category_layout, "consult_psychological_category_layout");
        y.d(consult_psychological_category_layout, new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$6
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
                ConsultStartLiveActivity.this.A1(ConsultLiveCategory.PSYCHOLOGY);
            }
        });
        TextView consult_start_live_instructions_text = (TextView) n1(R$id.consult_start_live_instructions_text);
        s.h(consult_start_live_instructions_text, "consult_start_live_instructions_text");
        y.d(consult_start_live_instructions_text, new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$7
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
                ConsultStartLiveActivity.this.H1();
            }
        });
        FKUniversalButton consult_start_live_btn = (FKUniversalButton) n1(R$id.consult_start_live_btn);
        s.h(consult_start_live_btn, "consult_start_live_btn");
        y.d(consult_start_live_btn, new Function1<View, p>() { // from class: com.cupidapp.live.consult.activity.ConsultStartLiveActivity$bindClickEvent$8
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
                ConsultStartLiveActivity.this.B1();
                SensorsLogKeyButtonClick.PreviewConsultShow.Start.click();
            }
        });
        ((CheckBox) n1(R$id.consult_start_live_rules_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.consult.activity.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ConsultStartLiveActivity.z1(ConsultStartLiveActivity.this, compoundButton, z10);
            }
        });
    }
}

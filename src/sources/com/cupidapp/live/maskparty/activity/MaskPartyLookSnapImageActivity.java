package com.cupidapp.live.maskparty.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.download.SnapFileDownloader;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageResult;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.k;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: MaskPartyLookSnapImageActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyLookSnapImageActivity extends FKBaseActivity {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f16234x = new a(null);

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public static MaskPartyChatMessageModel f16235y;

    /* renamed from: r, reason: collision with root package name */
    public boolean f16237r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f16238s;

    /* renamed from: t, reason: collision with root package name */
    public MaskPartyChatMessageModel f16239t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f16240u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public o f16241v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16242w = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final SnapFileDownloader f16236q = new SnapFileDownloader();

    /* compiled from: MaskPartyLookSnapImageActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable MaskPartyChatMessageModel maskPartyChatMessageModel) {
            MaskPartyLookSnapImageActivity.f16235y = maskPartyChatMessageModel;
        }

        public final void b(@Nullable Context context) {
            if (context == null) {
                return;
            }
            context.startActivity(new Intent(context, (Class<?>) MaskPartyLookSnapImageActivity.class));
        }
    }

    /* compiled from: MaskPartyLookSnapImageActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements SnapFileDownloader.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.network.download.SnapFileDownloader.c
        public void a(@NotNull String url) {
            s.i(url, "url");
            MaskPartyLookSnapImageActivity.this.f16237r = true;
        }
    }

    /* compiled from: MaskPartyLookSnapImageActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements o.c {
        public c() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            o.c.a.a(this, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            s.i(imageUriString, "imageUriString");
            k kVar = k.f50238a;
            SensorPosition sensorPosition = SensorPosition.ChatRoom;
            MaskPartyChatMessageModel maskPartyChatMessageModel = MaskPartyLookSnapImageActivity.this.f16239t;
            if (maskPartyChatMessageModel == null) {
                s.A("mMessage");
                maskPartyChatMessageModel = null;
            }
            User sender = maskPartyChatMessageModel.getSender();
            kVar.c(sensorPosition, "BURN_AFTER_READING", sender != null ? sender.userId() : null, z10);
            MaskPartyLookSnapImageActivity.this.F1();
        }
    }

    public static final boolean w1(MaskPartyLookSnapImageActivity this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        view.performClick();
        if (motionEvent.getAction() == 1) {
            this$0.A1();
            if (!this$0.f16240u) {
                this$0.finish();
            }
            this$0.f16240u = false;
        }
        return false;
    }

    public static final boolean x1(MaskPartyLookSnapImageActivity this$0, View view) {
        s.i(this$0, "this$0");
        this$0.f16240u = true;
        if (this$0.f16238s) {
            this$0.z1();
        } else {
            this$0.y1();
            this$0.B1();
        }
        return true;
    }

    public final void A1() {
        ((ImageLoaderView) l1(R$id.look_snap_blur_thumb_image)).setVisibility(0);
        ((Group) l1(R$id.look_snap_image_tip_group)).setVisibility(0);
        ((ImageLoaderView) l1(R$id.look_snap_image)).setVisibility(8);
        ((ProgressBar) l1(R$id.decrypt_snap_image_progress_bar)).setVisibility(8);
    }

    public final void B1() {
        MaskPartyChatMessageModel maskPartyChatMessageModel = this.f16239t;
        MaskPartyChatMessageModel maskPartyChatMessageModel2 = null;
        if (maskPartyChatMessageModel == null) {
            s.A("mMessage");
            maskPartyChatMessageModel = null;
        }
        String itemId = maskPartyChatMessageModel.getItemId();
        MaskPartyChatMessageModel maskPartyChatMessageModel3 = this.f16239t;
        if (maskPartyChatMessageModel3 == null) {
            s.A("mMessage");
            maskPartyChatMessageModel3 = null;
        }
        if (maskPartyChatMessageModel3.passwordIsNullOrEmpty()) {
            if (!(itemId == null || itemId.length() == 0)) {
                Disposable disposed = NetworkClient.f11868a.z().a(itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyChatMessageResult, p>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity$decryptImageMessage$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                        m2681invoke(maskPartyChatMessageResult);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2681invoke(MaskPartyChatMessageResult maskPartyChatMessageResult) {
                        MaskPartyChatMessageResult maskPartyChatMessageResult2 = maskPartyChatMessageResult;
                        List<MaskPartyChatMessageModel> list = maskPartyChatMessageResult2.getList();
                        if (list == null || list.isEmpty()) {
                            return;
                        }
                        MaskPartyChatMessageModel maskPartyChatMessageModel4 = maskPartyChatMessageResult2.getList().get(0);
                        MaskPartyChatMessageModel maskPartyChatMessageModel5 = MaskPartyLookSnapImageActivity.this.f16239t;
                        MaskPartyChatMessageModel maskPartyChatMessageModel6 = null;
                        if (maskPartyChatMessageModel5 == null) {
                            s.A("mMessage");
                            maskPartyChatMessageModel5 = null;
                        }
                        maskPartyChatMessageModel5.setPassword(maskPartyChatMessageModel4.getPassword());
                        maskPartyChatMessageModel5.setCountdownLeftSeconds(maskPartyChatMessageModel4.getCountdownLeftSeconds());
                        MaskPartyLookSnapImageActivity maskPartyLookSnapImageActivity = MaskPartyLookSnapImageActivity.this;
                        MaskPartyChatMessageModel maskPartyChatMessageModel7 = maskPartyLookSnapImageActivity.f16239t;
                        if (maskPartyChatMessageModel7 == null) {
                            s.A("mMessage");
                        } else {
                            maskPartyChatMessageModel6 = maskPartyChatMessageModel7;
                        }
                        final MaskPartyLookSnapImageActivity maskPartyLookSnapImageActivity2 = MaskPartyLookSnapImageActivity.this;
                        maskPartyLookSnapImageActivity.D1(maskPartyChatMessageModel6, new Function0<p>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity$decryptImageMessage$1$2
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
                                MaskPartyChatMessageModel maskPartyChatMessageModel8 = MaskPartyLookSnapImageActivity.this.f16239t;
                                if (maskPartyChatMessageModel8 == null) {
                                    s.A("mMessage");
                                    maskPartyChatMessageModel8 = null;
                                }
                                maskPartyChatMessageModel8.startSnapCountDown();
                            }
                        });
                    }
                }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    H(disposed);
                }
                s.h(disposed, "disposed");
                return;
            }
        }
        MaskPartyChatMessageModel maskPartyChatMessageModel4 = this.f16239t;
        if (maskPartyChatMessageModel4 == null) {
            s.A("mMessage");
        } else {
            maskPartyChatMessageModel2 = maskPartyChatMessageModel4;
        }
        D1(maskPartyChatMessageModel2, new Function0<p>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity$decryptImageMessage$2
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
                MaskPartyChatMessageModel maskPartyChatMessageModel5 = MaskPartyLookSnapImageActivity.this.f16239t;
                if (maskPartyChatMessageModel5 == null) {
                    s.A("mMessage");
                    maskPartyChatMessageModel5 = null;
                }
                maskPartyChatMessageModel5.startSnapCountDown();
            }
        });
    }

    public final void C1() {
        ImageLoaderView look_snap_blur_thumb_image = (ImageLoaderView) l1(R$id.look_snap_blur_thumb_image);
        s.h(look_snap_blur_thumb_image, "look_snap_blur_thumb_image");
        MaskPartyChatMessageModel maskPartyChatMessageModel = this.f16239t;
        if (maskPartyChatMessageModel == null) {
            s.A("mMessage");
            maskPartyChatMessageModel = null;
        }
        MaskPartyChatMessageModel maskPartyChatMessageModel2 = null;
        ImageLoaderView.f(look_snap_blur_thumb_image, new com.cupidapp.live.base.imageloader.b(false, maskPartyChatMessageModel.getSnapImageThumbUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        MaskPartyChatMessageModel maskPartyChatMessageModel3 = this.f16239t;
        if (maskPartyChatMessageModel3 == null) {
            s.A("mMessage");
        } else {
            maskPartyChatMessageModel2 = maskPartyChatMessageModel3;
        }
        this.f16236q.f(maskPartyChatMessageModel2.getSnapImageLargeUrl(), new b());
    }

    public final void D1(MaskPartyChatMessageModel maskPartyChatMessageModel, final Function0<p> function0) {
        final String snapImageLargeUrl = maskPartyChatMessageModel.getSnapImageLargeUrl();
        String completePassword = maskPartyChatMessageModel.getCompletePassword(this);
        if (snapImageLargeUrl == null || snapImageLargeUrl.length() == 0) {
            return;
        }
        if ((completePassword == null || completePassword.length() == 0) || !this.f16237r || this.f16238s) {
            return;
        }
        this.f16236q.g(snapImageLargeUrl, completePassword, new Function1<Bitmap, p>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity$loadDecryptedBitmap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                SnapFileDownloader snapFileDownloader;
                boolean z10;
                if (bitmap != null) {
                    MaskPartyLookSnapImageActivity.this.f16238s = true;
                    ImageLoaderView look_snap_image = (ImageLoaderView) MaskPartyLookSnapImageActivity.this.l1(R$id.look_snap_image);
                    s.h(look_snap_image, "look_snap_image");
                    ImageLoaderView.f(look_snap_image, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, bitmap, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524223, null), null, 2, null);
                    z10 = MaskPartyLookSnapImageActivity.this.f16240u;
                    if (z10) {
                        MaskPartyLookSnapImageActivity.this.z1();
                    }
                    Function0<p> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                        return;
                    }
                    return;
                }
                h.f12779a.r(MaskPartyLookSnapImageActivity.this, R$string.image_get_failed_try_later);
                snapFileDownloader = MaskPartyLookSnapImageActivity.this.f16236q;
                snapFileDownloader.e(snapImageLargeUrl);
            }
        });
    }

    public final boolean E1(Integer num) {
        return num == null || num.intValue() <= 0;
    }

    public final void F1() {
        String userId;
        MaskPartyChatMessageModel maskPartyChatMessageModel = this.f16239t;
        if (maskPartyChatMessageModel == null) {
            s.A("mMessage");
            maskPartyChatMessageModel = null;
        }
        String roomId = maskPartyChatMessageModel.getRoomId();
        if (roomId == null) {
            return;
        }
        MaskPartyChatMessageModel maskPartyChatMessageModel2 = this.f16239t;
        if (maskPartyChatMessageModel2 == null) {
            s.A("mMessage");
            maskPartyChatMessageModel2 = null;
        }
        User sender = maskPartyChatMessageModel2.getSender();
        if (sender == null || (userId = sender.userId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().A(roomId, userId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity$sendScreenCaptureCallback$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void G1() {
        o c4 = o.f12354i.c(this);
        this.f16241v = c4;
        if (c4 != null) {
            c4.l(new c());
        }
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f16242w;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_mask_party_look_snap_image);
        p0.a(this);
        MaskPartyChatMessageModel maskPartyChatMessageModel = null;
        d1(R$anim.anim_activity_nothing, null);
        MaskPartyChatMessageModel maskPartyChatMessageModel2 = f16235y;
        if (maskPartyChatMessageModel2 != null) {
            if (!E1(maskPartyChatMessageModel2 != null ? maskPartyChatMessageModel2.getCountdownLeftSeconds() : null)) {
                MaskPartyChatMessageModel maskPartyChatMessageModel3 = f16235y;
                s.f(maskPartyChatMessageModel3);
                this.f16239t = maskPartyChatMessageModel3;
                if (maskPartyChatMessageModel3 == null) {
                    s.A("mMessage");
                } else {
                    maskPartyChatMessageModel = maskPartyChatMessageModel3;
                }
                maskPartyChatMessageModel.setProgressCallback(new Function1<Float, p>() { // from class: com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity$onCreate$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Float f10) {
                        invoke(f10.floatValue());
                        return p.f51048a;
                    }

                    public final void invoke(float f10) {
                        if (f10 <= 0.0f) {
                            MaskPartyLookSnapImageActivity.this.finish();
                            return;
                        }
                        MaskPartyLookSnapImageActivity maskPartyLookSnapImageActivity = MaskPartyLookSnapImageActivity.this;
                        int i10 = R$id.look_snap_image_count_down_view;
                        maskPartyLookSnapImageActivity.l1(i10).setVisibility(0);
                        View look_snap_image_count_down_view = MaskPartyLookSnapImageActivity.this.l1(i10);
                        s.h(look_snap_image_count_down_view, "look_snap_image_count_down_view");
                        y.o(look_snap_image_count_down_view, Integer.valueOf((int) (f10 * z0.h.l(MaskPartyLookSnapImageActivity.this))), null, 2, null);
                    }
                });
                C1();
                v1();
                G1();
                return;
            }
        }
        finish();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MaskPartyChatMessageModel maskPartyChatMessageModel = this.f16239t;
        if (maskPartyChatMessageModel != null) {
            if (maskPartyChatMessageModel == null) {
                s.A("mMessage");
                maskPartyChatMessageModel = null;
            }
            maskPartyChatMessageModel.setProgressCallback(null);
        }
        super.onDestroy();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        o oVar = this.f16241v;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        o oVar = this.f16241v;
        if (oVar != null) {
            oVar.m();
        }
    }

    public final void v1() {
        int i10 = R$id.look_snap_root_layout;
        ((ConstraintLayout) l1(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.maskparty.activity.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w12;
                w12 = MaskPartyLookSnapImageActivity.w1(MaskPartyLookSnapImageActivity.this, view, motionEvent);
                return w12;
            }
        });
        ((ConstraintLayout) l1(i10)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cupidapp.live.maskparty.activity.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean x12;
                x12 = MaskPartyLookSnapImageActivity.x1(MaskPartyLookSnapImageActivity.this, view);
                return x12;
            }
        });
    }

    public final void y1() {
        ((ImageLoaderView) l1(R$id.look_snap_blur_thumb_image)).setVisibility(0);
        ((ProgressBar) l1(R$id.decrypt_snap_image_progress_bar)).setVisibility(0);
        ((ImageLoaderView) l1(R$id.look_snap_image)).setVisibility(8);
        ((Group) l1(R$id.look_snap_image_tip_group)).setVisibility(8);
    }

    public final void z1() {
        ((ImageLoaderView) l1(R$id.look_snap_image)).setVisibility(0);
        ((ImageLoaderView) l1(R$id.look_snap_blur_thumb_image)).setVisibility(8);
        ((Group) l1(R$id.look_snap_image_tip_group)).setVisibility(8);
        ((ProgressBar) l1(R$id.decrypt_snap_image_progress_bar)).setVisibility(8);
    }
}

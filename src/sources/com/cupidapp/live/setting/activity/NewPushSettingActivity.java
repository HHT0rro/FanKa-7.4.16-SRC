package com.cupidapp.live.setting.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.DateFormatPattern;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorsLogUserStatusSwitch;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKItemSwitchLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.setting.activity.NewPushSettingDetailActivity;
import com.cupidapp.live.setting.adapter.PushChannelAdapter;
import com.cupidapp.live.setting.model.NewPushSafeEditResult;
import com.cupidapp.live.setting.model.NewPushSettingResult;
import com.cupidapp.live.setting.model.PushChannelModel;
import com.cupidapp.live.setting.model.PushPostRange;
import com.cupidapp.live.setting.view.PushCustomTimeSettingLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushSettingActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f17970t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public NewPushSettingResult f17971q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17973s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17972r = kotlin.c.b(new Function0<PushChannelAdapter>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$pushChannelAdapter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PushChannelAdapter invoke() {
            return new PushChannelAdapter();
        }
    });

    /* compiled from: NewPushSettingActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) NewPushSettingActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static /* synthetic */ void K1(NewPushSettingActivity newPushSettingActivity, boolean z10, Long l10, Long l11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            l11 = null;
        }
        newPushSettingActivity.J1(z10, l10, l11);
    }

    public final void A1(boolean z10) {
        ((FKItemLayout) j1(R$id.pushSafeCustomTimeLayout)).setVisibility(z10 ? 0 : 8);
    }

    public final void B1(NewPushSettingResult newPushSettingResult) {
        if (newPushSettingResult == null) {
            return;
        }
        this.f17971q = newPushSettingResult;
        y1(Boolean.valueOf(newPushSettingResult.getPushEnable()));
        ((FKItemSwitchLayout) j1(R$id.newPushSettingLayout)).setChecked(newPushSettingResult.getPushEnable());
        ((FKItemLayout) j1(R$id.recoveryPushSettingLayout)).setFkValueText(newPushSettingResult.getPushPauseTemp());
        ((FKItemSwitchLayout) j1(R$id.safeModeSettingLayout)).setChecked(newPushSettingResult.getPushSafeMode());
        A1(newPushSettingResult.getPushSafeMode());
        ((FKItemSwitchLayout) j1(R$id.pushHideDetailLayout)).setChecked(newPushSettingResult.getPushHideDetail());
        ((FKItemSwitchLayout) j1(R$id.friendsMessageLayout)).setChecked(newPushSettingResult.getPushInbox());
        ((FKItemSwitchLayout) j1(R$id.unMatchMessageLayout)).setChecked(newPushSettingResult.getPushGreet());
        ((FKItemSwitchLayout) j1(R$id.attentionLayout)).setChecked(newPushSettingResult.getPushAloha());
        ((FKItemSwitchLayout) j1(R$id.newFriendLayout)).setChecked(newPushSettingResult.getPushNewMatch());
        ((FKItemLayout) j1(R$id.atUserLayout)).setFkValueText(E1(newPushSettingResult.getPushPostAtV2()));
        ((FKItemLayout) j1(R$id.commentLayout)).setFkValueText(E1(newPushSettingResult.getPushPostCommentV2()));
        ((FKItemLayout) j1(R$id.praiseLayout)).setFkValueText(E1(newPushSettingResult.getPushPostLikeV2()));
        ((FKItemLayout) j1(R$id.push_post_publish_switch)).setFkValueText(E1(newPushSettingResult.getPushPostPublishV2()));
        z1();
    }

    public final void C1(String str, Object obj) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(str, obj);
        Disposable disposed = NetworkClient.f11868a.B().i(hashMap).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$editPushSwitchSetting$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj2) {
                invoke2(obj2);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj2) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$editPushSwitchSetting$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final PushChannelAdapter D1() {
        return (PushChannelAdapter) this.f17972r.getValue();
    }

    public final String E1(Integer num) {
        int value = PushPostRange.CLOSE.getValue();
        if (num != null && num.intValue() == value) {
            String string = getString(R$string.no_push);
            kotlin.jvm.internal.s.h(string, "getString(R.string.no_push)");
            return string;
        }
        int value2 = PushPostRange.FOCUS.getValue();
        if (num != null && num.intValue() == value2) {
            String string2 = getString(R$string.only_focus_and_close_friend);
            kotlin.jvm.internal.s.h(string2, "getString(R.string.only_focus_and_close_friend)");
            return string2;
        }
        int value3 = PushPostRange.ALL.getValue();
        if (num != null && num.intValue() == value3) {
            String string3 = getString(R$string.all);
            kotlin.jvm.internal.s.h(string3, "getString(R.string.all)");
            return string3;
        }
        String string4 = getString(R$string.no_push);
        kotlin.jvm.internal.s.h(string4, "getString(R.string.no_push)");
        return string4;
    }

    public final void F1() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((LinearLayout) j1(R$id.soundAndVibrateLayout)).setVisibility(0);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            int i10 = R$id.pushChannelRecycler;
            ((RecyclerView) j1(i10)).setLayoutManager(linearLayoutManager);
            ((RecyclerView) j1(i10)).setAdapter(D1());
            PushChannelAdapter D1 = D1();
            String string = getResources().getString(R$string.push_channel_message);
            kotlin.jvm.internal.s.h(string, "resources.getString(R.string.push_channel_message)");
            String string2 = getResources().getString(R$string.push_channel_relationship);
            kotlin.jvm.internal.s.h(string2, "resources.getString(R.st…ush_channel_relationship)");
            String string3 = getResources().getString(R$string.push_channel_interaction);
            kotlin.jvm.internal.s.h(string3, "resources.getString(R.st…push_channel_interaction)");
            String string4 = getResources().getString(R$string.push_channel_live);
            kotlin.jvm.internal.s.h(string4, "resources.getString(R.string.push_channel_live)");
            String string5 = getResources().getString(R$string.push_channel_free);
            kotlin.jvm.internal.s.h(string5, "resources.getString(R.string.push_channel_free)");
            String string6 = getResources().getString(R$string.push_channel_system);
            kotlin.jvm.internal.s.h(string6, "resources.getString(R.string.push_channel_system)");
            D1.e(kotlin.collections.s.f(new PushChannelModel("push_channel_message", string), new PushChannelModel("push_channel_relationship", string2), new PushChannelModel("push_channel_interaction", string3), new PushChannelModel("push_channel_live", string4), new PushChannelModel("push_channel_free", string5), new PushChannelModel("push_channel_system", string6)));
            D1().notifyDataSetChanged();
            D1().l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$initPushChannel$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof PushChannelModel) {
                        Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                        intent.putExtra("android.provider.extra.APP_PACKAGE", NewPushSettingActivity.this.getApplicationInfo().packageName);
                        intent.putExtra("android.provider.extra.CHANNEL_ID", ((PushChannelModel) obj).getPushChannelId());
                        NewPushSettingActivity.this.startActivity(intent);
                    }
                }
            });
        }
    }

    public final void G1() {
        ((TextView) j1(R$id.privacyProtection)).getPaint().setFakeBoldText(true);
        ((TextView) j1(R$id.privacyChat)).getPaint().setFakeBoldText(true);
        int i10 = R$id.notification;
        ((TextView) j1(i10)).getPaint().setFakeBoldText(true);
        ((TextView) j1(i10)).getPaint().setFakeBoldText(true);
        ((TextView) j1(R$id.soundAndVibrate)).getPaint().setFakeBoldText(true);
    }

    public final void H1() {
        B1(p1.g.f52734a.v0().c());
        Disposable disposed = NetworkClient.f11868a.B().a().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NewPushSettingResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$loadConfig$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NewPushSettingResult newPushSettingResult) {
                m2786invoke(newPushSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2786invoke(NewPushSettingResult newPushSettingResult) {
                NewPushSettingResult newPushSettingResult2 = newPushSettingResult;
                p1.g.f52734a.v0().d(newPushSettingResult2);
                NewPushSettingActivity.this.f17971q = newPushSettingResult2;
                NewPushSettingActivity.this.B1(newPushSettingResult2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void I1() {
        Window window;
        Window window2;
        AlertDialog.Builder e2 = z0.b.f54812a.e(this);
        final PushCustomTimeSettingLayout pushCustomTimeSettingLayout = new PushCustomTimeSettingLayout(this);
        NewPushSettingResult newPushSettingResult = this.f17971q;
        Long pushStartTime = newPushSettingResult != null ? newPushSettingResult.getPushStartTime() : null;
        NewPushSettingResult newPushSettingResult2 = this.f17971q;
        pushCustomTimeSettingLayout.setTime(pushStartTime, newPushSettingResult2 != null ? newPushSettingResult2.getPushEndTime() : null);
        e2.setView(pushCustomTimeSettingLayout);
        final AlertDialog create = e2.create();
        TextView textView = (TextView) pushCustomTimeSettingLayout.a(R$id.customTimeCancel);
        kotlin.jvm.internal.s.h(textView, "pushCustomTimeSettingLayout.customTimeCancel");
        z0.y.d(textView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$openAlertDialog$1
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
                create.dismiss();
            }
        });
        pushCustomTimeSettingLayout.setResultData(new Function2<Long, Long, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$openAlertDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Long l10, Long l11) {
                invoke2(l10, l11);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Long l10, @Nullable Long l11) {
                if (!kotlin.jvm.internal.s.d(l10, l11)) {
                    create.dismiss();
                    this.J1(true, l10, l11);
                } else {
                    com.cupidapp.live.base.view.h.f12779a.r(this, R$string.new_push_action_time_tips);
                }
            }
        });
        TextView textView2 = (TextView) pushCustomTimeSettingLayout.a(R$id.customTimeConfirm);
        kotlin.jvm.internal.s.h(textView2, "pushCustomTimeSettingLayout.customTimeConfirm");
        z0.y.d(textView2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$openAlertDialog$3
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
                PushCustomTimeSettingLayout.this.f();
            }
        });
        if (create != null && (window2 = create.getWindow()) != null) {
            window2.setBackgroundDrawableResource(R$drawable.shape_custom_time_dialog_white_bg);
        }
        if (create != null) {
            create.show();
        }
        WindowManager.LayoutParams attributes = (create == null || (window = create.getWindow()) == null) ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = z0.h.c(this, 270.0f);
        }
        Window window3 = create != null ? create.getWindow() : null;
        if (window3 == null) {
            return;
        }
        window3.setAttributes(attributes);
    }

    public final void J1(boolean z10, Long l10, Long l11) {
        Disposable disposed = NetworkClient.f11868a.B().f(z10, l10, l11).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NewPushSafeEditResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$safeEdit$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NewPushSafeEditResult newPushSafeEditResult) {
                m2788invoke(newPushSafeEditResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2788invoke(NewPushSafeEditResult newPushSafeEditResult) {
                NewPushSettingResult newPushSettingResult;
                NewPushSettingResult newPushSettingResult2;
                NewPushSettingResult newPushSettingResult3;
                NewPushSafeEditResult newPushSafeEditResult2 = newPushSafeEditResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushStartTime(newPushSafeEditResult2.getPushStartTime());
                }
                newPushSettingResult2 = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult2 != null) {
                    newPushSettingResult2.setPushEndTime(newPushSafeEditResult2.getPushEndTime());
                }
                newPushSettingResult3 = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult3 != null) {
                    newPushSettingResult3.setPushSafeMode(newPushSafeEditResult2.getPushSafeMode());
                }
                NewPushSettingActivity.this.z1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$safeEdit$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void L1(final Function1<? super PushPostRange, kotlin.p> function1) {
        ArrayList arrayList = new ArrayList();
        ActionSheetItemType actionSheetItemType = ActionSheetItemType.Default;
        arrayList.add(new FKActionSheetItemModel(R$string.all, actionSheetItemType, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$showPostPushActionSheet$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(PushPostRange.ALL);
            }
        }, 28, null));
        arrayList.add(new FKActionSheetItemModel(R$string.only_focus_and_close_friend, actionSheetItemType, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$showPostPushActionSheet$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(PushPostRange.FOCUS);
            }
        }, 28, null));
        arrayList.add(new FKActionSheetItemModel(R$string.no_push, actionSheetItemType, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$showPostPushActionSheet$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(PushPostRange.CLOSE);
            }
        }, 28, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, android.app.Activity
    public void finish() {
        p1.g.f52734a.v0().d(this.f17971q);
        super.finish();
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17973s;
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
        if (i11 == 102) {
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("id", -1)) : null;
            if (valueOf == null || valueOf.intValue() == -1) {
                return;
            }
            Disposable disposed = NetworkClient.f11868a.B().c(valueOf.intValue()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NewPushSettingResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$onActivityResult$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(NewPushSettingResult newPushSettingResult) {
                    m2787invoke(newPushSettingResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2787invoke(NewPushSettingResult newPushSettingResult) {
                    NewPushSettingResult newPushSettingResult2;
                    NewPushSettingResult newPushSettingResult3;
                    NewPushSettingResult newPushSettingResult4;
                    NewPushSettingResult newPushSettingResult5 = newPushSettingResult;
                    newPushSettingResult2 = NewPushSettingActivity.this.f17971q;
                    if (newPushSettingResult2 != null) {
                        newPushSettingResult2.setPushPauseOption(newPushSettingResult5.getPushPauseOption());
                    }
                    newPushSettingResult3 = NewPushSettingActivity.this.f17971q;
                    if (newPushSettingResult3 != null) {
                        newPushSettingResult3.setPushPauseTemp(newPushSettingResult5.getPushPauseTemp());
                    }
                    ((FKItemLayout) NewPushSettingActivity.this.j1(R$id.recoveryPushSettingLayout)).setFkValueText(newPushSettingResult5.getPushPauseTemp());
                    p1.d<NewPushSettingResult> v02 = p1.g.f52734a.v0();
                    newPushSettingResult4 = NewPushSettingActivity.this.f17971q;
                    v02.d(newPushSettingResult4);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$onActivityResult$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_new_push_setting);
        G1();
        F1();
        H1();
        w1();
        if (r0.f12373a.a(this)) {
            return;
        }
        ((FrameLayout) j1(R$id.pushOpenNotificationLayout)).setVisibility(0);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i10 = R$id.pushOpenNotificationLayout;
        if (((FrameLayout) j1(i10)).getVisibility() == 0 && r0.f12373a.a(this)) {
            ((FrameLayout) j1(i10)).setVisibility(8);
        }
    }

    public final void w1() {
        ((FKTitleBarLayout) j1(R$id.newPushSettingTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$1
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
                NewPushSettingActivity.this.finish();
            }
        });
        ((FKItemSwitchLayout) j1(R$id.newPushSettingLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingActivity.this.y1(Boolean.valueOf(z10));
                NewPushSettingActivity.this.x1(Boolean.valueOf(z10));
                SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.NEW_MSG, z10, null, 4, null);
            }
        });
        FKItemLayout recoveryPushSettingLayout = (FKItemLayout) j1(R$id.recoveryPushSettingLayout);
        kotlin.jvm.internal.s.h(recoveryPushSettingLayout, "recoveryPushSettingLayout");
        z0.y.d(recoveryPushSettingLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$3
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
                NewPushSettingDetailActivity.f17974t.a(NewPushSettingActivity.this, NewPushSettingDetailActivity.Companion.PushSettingDetail.RecoveryPushSetting);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.safeModeSettingLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingResult newPushSettingResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushSafeMode(z10);
                }
                NewPushSettingActivity.K1(NewPushSettingActivity.this, z10, null, null, 6, null);
                NewPushSettingActivity.this.A1(z10);
                SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.SAFE_MODE, z10, null, 4, null);
            }
        });
        FKItemLayout pushSafeCustomTimeLayout = (FKItemLayout) j1(R$id.pushSafeCustomTimeLayout);
        kotlin.jvm.internal.s.h(pushSafeCustomTimeLayout, "pushSafeCustomTimeLayout");
        z0.y.d(pushSafeCustomTimeLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$5
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
                NewPushSettingActivity.this.I1();
            }
        });
        ((FKItemSwitchLayout) j1(R$id.pushHideDetailLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingResult newPushSettingResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushHideDetail(z10);
                }
                NewPushSettingActivity.this.C1("pushHideDetail", Boolean.valueOf(z10));
                SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.HIDE_NOTICE_DETAIL, z10, null, 4, null);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.friendsMessageLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingResult newPushSettingResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushInbox(z10);
                }
                NewPushSettingActivity.this.C1("pushInbox", Boolean.valueOf(z10));
            }
        });
        ((FKItemSwitchLayout) j1(R$id.unMatchMessageLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingResult newPushSettingResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushGreet(z10);
                }
                NewPushSettingActivity.this.C1("pushGreet", Boolean.valueOf(z10));
            }
        });
        ((FKItemSwitchLayout) j1(R$id.attentionLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingResult newPushSettingResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushAloha(z10);
                }
                NewPushSettingActivity.this.C1("pushAloha", Boolean.valueOf(z10));
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIKE_YOU, z10, null, null, 12, null);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.newFriendLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                NewPushSettingResult newPushSettingResult;
                newPushSettingResult = NewPushSettingActivity.this.f17971q;
                if (newPushSettingResult != null) {
                    newPushSettingResult.setPushNewMatch(z10);
                }
                NewPushSettingActivity.this.C1("pushNewMatch", Boolean.valueOf(z10));
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.NEW_FRIEND, z10, null, null, 12, null);
            }
        });
        FKItemLayout atUserLayout = (FKItemLayout) j1(R$id.atUserLayout);
        kotlin.jvm.internal.s.h(atUserLayout, "atUserLayout");
        z0.y.d(atUserLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$11
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
                final NewPushSettingActivity newPushSettingActivity = NewPushSettingActivity.this;
                newPushSettingActivity.L1(new Function1<PushPostRange, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$11.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(PushPostRange pushPostRange) {
                        invoke2(pushPostRange);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PushPostRange range) {
                        NewPushSettingResult newPushSettingResult;
                        String E1;
                        kotlin.jvm.internal.s.i(range, "range");
                        newPushSettingResult = NewPushSettingActivity.this.f17971q;
                        if (newPushSettingResult != null) {
                            newPushSettingResult.setPushPostAtV2(Integer.valueOf(range.getValue()));
                        }
                        FKItemLayout fKItemLayout = (FKItemLayout) NewPushSettingActivity.this.j1(R$id.atUserLayout);
                        E1 = NewPushSettingActivity.this.E1(Integer.valueOf(range.getValue()));
                        fKItemLayout.setFkValueText(E1);
                        NewPushSettingActivity.this.C1("pushPostAtV2", Integer.valueOf(range.getValue()));
                    }
                });
            }
        });
        FKItemLayout commentLayout = (FKItemLayout) j1(R$id.commentLayout);
        kotlin.jvm.internal.s.h(commentLayout, "commentLayout");
        z0.y.d(commentLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$12
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
                final NewPushSettingActivity newPushSettingActivity = NewPushSettingActivity.this;
                newPushSettingActivity.L1(new Function1<PushPostRange, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$12.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(PushPostRange pushPostRange) {
                        invoke2(pushPostRange);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PushPostRange range) {
                        NewPushSettingResult newPushSettingResult;
                        String E1;
                        kotlin.jvm.internal.s.i(range, "range");
                        newPushSettingResult = NewPushSettingActivity.this.f17971q;
                        if (newPushSettingResult != null) {
                            newPushSettingResult.setPushPostCommentV2(Integer.valueOf(range.getValue()));
                        }
                        FKItemLayout fKItemLayout = (FKItemLayout) NewPushSettingActivity.this.j1(R$id.commentLayout);
                        E1 = NewPushSettingActivity.this.E1(Integer.valueOf(range.getValue()));
                        fKItemLayout.setFkValueText(E1);
                        NewPushSettingActivity.this.C1("pushPostCommentV2", Integer.valueOf(range.getValue()));
                    }
                });
            }
        });
        FKItemLayout praiseLayout = (FKItemLayout) j1(R$id.praiseLayout);
        kotlin.jvm.internal.s.h(praiseLayout, "praiseLayout");
        z0.y.d(praiseLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$13
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
                final NewPushSettingActivity newPushSettingActivity = NewPushSettingActivity.this;
                newPushSettingActivity.L1(new Function1<PushPostRange, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$13.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(PushPostRange pushPostRange) {
                        invoke2(pushPostRange);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PushPostRange range) {
                        NewPushSettingResult newPushSettingResult;
                        String E1;
                        kotlin.jvm.internal.s.i(range, "range");
                        newPushSettingResult = NewPushSettingActivity.this.f17971q;
                        if (newPushSettingResult != null) {
                            newPushSettingResult.setPushPostLikeV2(Integer.valueOf(range.getValue()));
                        }
                        FKItemLayout fKItemLayout = (FKItemLayout) NewPushSettingActivity.this.j1(R$id.praiseLayout);
                        E1 = NewPushSettingActivity.this.E1(Integer.valueOf(range.getValue()));
                        fKItemLayout.setFkValueText(E1);
                        NewPushSettingActivity.this.C1("pushPostLikeV2", Integer.valueOf(range.getValue()));
                    }
                });
            }
        });
        FKItemLayout push_post_publish_switch = (FKItemLayout) j1(R$id.push_post_publish_switch);
        kotlin.jvm.internal.s.h(push_post_publish_switch, "push_post_publish_switch");
        z0.y.d(push_post_publish_switch, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$14
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
                final NewPushSettingActivity newPushSettingActivity = NewPushSettingActivity.this;
                newPushSettingActivity.L1(new Function1<PushPostRange, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$14.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(PushPostRange pushPostRange) {
                        invoke2(pushPostRange);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull PushPostRange range) {
                        NewPushSettingResult newPushSettingResult;
                        String E1;
                        kotlin.jvm.internal.s.i(range, "range");
                        newPushSettingResult = NewPushSettingActivity.this.f17971q;
                        if (newPushSettingResult != null) {
                            newPushSettingResult.setPushPostPublishV2(Integer.valueOf(range.getValue()));
                        }
                        FKItemLayout fKItemLayout = (FKItemLayout) NewPushSettingActivity.this.j1(R$id.push_post_publish_switch);
                        E1 = NewPushSettingActivity.this.E1(Integer.valueOf(range.getValue()));
                        fKItemLayout.setFkValueText(E1);
                        NewPushSettingActivity.this.C1("pushPostPublishV2", Integer.valueOf(range.getValue()));
                    }
                });
            }
        });
        FKItemLayout push_help_layout = (FKItemLayout) j1(R$id.push_help_layout);
        kotlin.jvm.internal.s.h(push_help_layout, "push_help_layout");
        z0.y.d(push_help_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$bindClickEvent$15
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
                GroupOthersLog.p0(GroupOthersLog.f18702a, GroupOthersLog.TipsType.PUSH_HAS_PROBLEM, null, 2, null);
                FKOpenPushSettingHelpActivity.f17958r.a(NewPushSettingActivity.this);
            }
        });
    }

    public final void x1(Boolean bool) {
        if (bool == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.B().h(bool.booleanValue()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NewPushSettingResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$configAllPushServices$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NewPushSettingResult newPushSettingResult) {
                m2785invoke(newPushSettingResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2785invoke(NewPushSettingResult newPushSettingResult) {
                NewPushSettingResult newPushSettingResult2 = newPushSettingResult;
                p1.g.f52734a.v0().d(newPushSettingResult2);
                NewPushSettingActivity.this.f17971q = newPushSettingResult2;
                ((FKItemLayout) NewPushSettingActivity.this.j1(R$id.recoveryPushSettingLayout)).setFkValueText(newPushSettingResult2.getPushPauseTemp());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingActivity$configAllPushServices$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void y1(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            ((FKItemSwitchLayout) j1(R$id.newPushSettingLayout)).setItemSwitchContent(null);
            ((LinearLayout) j1(R$id.newPushSettingContainerLayout)).setVisibility(0);
            ((FKItemLayout) j1(R$id.recoveryPushSettingLayout)).setVisibility(8);
        } else {
            ((FKItemSwitchLayout) j1(R$id.newPushSettingLayout)).setItemSwitchContent(getString(R$string.push_new_stop_receiver_all_push));
            ((LinearLayout) j1(R$id.newPushSettingContainerLayout)).setVisibility(8);
            ((FKItemLayout) j1(R$id.recoveryPushSettingLayout)).setVisibility(0);
        }
    }

    public final void z1() {
        NewPushSettingResult newPushSettingResult = this.f17971q;
        if ((newPushSettingResult != null ? newPushSettingResult.getPushStartTime() : null) != null) {
            NewPushSettingResult newPushSettingResult2 = this.f17971q;
            if ((newPushSettingResult2 != null ? newPushSettingResult2.getPushEndTime() : null) != null) {
                NewPushSettingResult newPushSettingResult3 = this.f17971q;
                kotlin.jvm.internal.s.f(newPushSettingResult3);
                Long pushStartTime = newPushSettingResult3.getPushStartTime();
                kotlin.jvm.internal.s.f(pushStartTime);
                long longValue = pushStartTime.longValue();
                DateFormatPattern dateFormatPattern = DateFormatPattern.HHmm;
                String s2 = z0.v.s(longValue, dateFormatPattern);
                NewPushSettingResult newPushSettingResult4 = this.f17971q;
                kotlin.jvm.internal.s.f(newPushSettingResult4);
                Long pushEndTime = newPushSettingResult4.getPushEndTime();
                kotlin.jvm.internal.s.f(pushEndTime);
                ((FKItemLayout) j1(R$id.pushSafeCustomTimeLayout)).setFkValueText(getString(R$string.new_push_safe_time, new Object[]{s2, z0.v.s(pushEndTime.longValue(), dateFormatPattern)}));
            }
        }
    }
}

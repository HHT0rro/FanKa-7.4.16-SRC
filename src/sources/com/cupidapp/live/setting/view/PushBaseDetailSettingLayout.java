package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.setting.adapter.BasePushDetailAdapter;
import com.cupidapp.live.setting.model.NewPushLiveShowItemModel;
import com.cupidapp.live.setting.model.NewPushLiveShowModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PushBaseDetailSettingLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PushBaseDetailSettingLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function3<? super String, ? super Boolean, ? super Boolean, p> f18215b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function2<? super Boolean, ? super Boolean, p> f18216c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f18217d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18218e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushBaseDetailSettingLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18218e = new LinkedHashMap();
        this.f18217d = c.b(new Function0<BasePushDetailAdapter>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BasePushDetailAdapter invoke() {
                BasePushDetailAdapter basePushDetailAdapter = new BasePushDetailAdapter();
                final PushBaseDetailSettingLayout pushBaseDetailSettingLayout = PushBaseDetailSettingLayout.this;
                basePushDetailAdapter.l().i(i0.h(f.a(Integer.valueOf(R$id.pushItemHeaderSwitch), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2$1$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i10) {
                        if (obj instanceof NewPushLiveShowModel) {
                            NewPushLiveShowModel newPushLiveShowModel = (NewPushLiveShowModel) obj;
                            newPushLiveShowModel.setPushLiveShow(z10);
                            Function2<Boolean, Boolean, p> headerClick = PushBaseDetailSettingLayout.this.getHeaderClick();
                            if (headerClick != null) {
                                headerClick.mo1743invoke(Boolean.valueOf(z10), Boolean.TRUE);
                            }
                            PushBaseDetailSettingLayout.this.d(newPushLiveShowModel);
                            GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIVE_START_NOTICE, z10, null, null, 12, null);
                        }
                    }
                }), f.a(Integer.valueOf(R$id.pushItemSwitch), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i10) {
                        if (obj instanceof NewPushLiveShowItemModel) {
                            NewPushLiveShowItemModel newPushLiveShowItemModel = (NewPushLiveShowItemModel) obj;
                            newPushLiveShowItemModel.setSendPush(z10);
                            Function3<String, Boolean, Boolean, p> itemClick = PushBaseDetailSettingLayout.this.getItemClick();
                            if (itemClick != null) {
                                itemClick.invoke(newPushLiveShowItemModel.getUser().getUserId(), Boolean.valueOf(z10), Boolean.TRUE);
                            }
                            GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIVE_START_NOTICE, z10, null, null, 12, null);
                        }
                    }
                })));
                return basePushDetailAdapter;
            }
        });
        c();
    }

    private final BasePushDetailAdapter getBasePushDetailAdapter() {
        return (BasePushDetailAdapter) this.f18217d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18218e;
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

    public final void c() {
        z.a(this, R$layout.layout_push_setting_recyclerview, true);
        RecyclerView recyclerView = (RecyclerView) a(R$id.pushSettingRecyclerView);
        recyclerView.setAdapter(getBasePushDetailAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    public final void d(NewPushLiveShowModel newPushLiveShowModel) {
        getBasePushDetailAdapter().j().clear();
        getBasePushDetailAdapter().d(newPushLiveShowModel);
        if (newPushLiveShowModel.getPushLiveShow()) {
            getBasePushDetailAdapter().e(newPushLiveShowModel.getAnchorList());
        }
        getBasePushDetailAdapter().notifyDataSetChanged();
    }

    @Nullable
    public final Function2<Boolean, Boolean, p> getHeaderClick() {
        return this.f18216c;
    }

    @Nullable
    public final Function3<String, Boolean, Boolean, p> getItemClick() {
        return this.f18215b;
    }

    public final void setData(@NotNull NewPushLiveShowModel model) {
        s.i(model, "model");
        d(model);
    }

    public final void setHeaderClick(@Nullable Function2<? super Boolean, ? super Boolean, p> function2) {
        this.f18216c = function2;
    }

    public final void setItemClick(@Nullable Function3<? super String, ? super Boolean, ? super Boolean, p> function3) {
        this.f18215b = function3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushBaseDetailSettingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18218e = new LinkedHashMap();
        this.f18217d = c.b(new Function0<BasePushDetailAdapter>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BasePushDetailAdapter invoke() {
                BasePushDetailAdapter basePushDetailAdapter = new BasePushDetailAdapter();
                final PushBaseDetailSettingLayout pushBaseDetailSettingLayout = PushBaseDetailSettingLayout.this;
                basePushDetailAdapter.l().i(i0.h(f.a(Integer.valueOf(R$id.pushItemHeaderSwitch), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2$1$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i10) {
                        if (obj instanceof NewPushLiveShowModel) {
                            NewPushLiveShowModel newPushLiveShowModel = (NewPushLiveShowModel) obj;
                            newPushLiveShowModel.setPushLiveShow(z10);
                            Function2<Boolean, Boolean, p> headerClick = PushBaseDetailSettingLayout.this.getHeaderClick();
                            if (headerClick != null) {
                                headerClick.mo1743invoke(Boolean.valueOf(z10), Boolean.TRUE);
                            }
                            PushBaseDetailSettingLayout.this.d(newPushLiveShowModel);
                            GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIVE_START_NOTICE, z10, null, null, 12, null);
                        }
                    }
                }), f.a(Integer.valueOf(R$id.pushItemSwitch), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i10) {
                        if (obj instanceof NewPushLiveShowItemModel) {
                            NewPushLiveShowItemModel newPushLiveShowItemModel = (NewPushLiveShowItemModel) obj;
                            newPushLiveShowItemModel.setSendPush(z10);
                            Function3<String, Boolean, Boolean, p> itemClick = PushBaseDetailSettingLayout.this.getItemClick();
                            if (itemClick != null) {
                                itemClick.invoke(newPushLiveShowItemModel.getUser().getUserId(), Boolean.valueOf(z10), Boolean.TRUE);
                            }
                            GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIVE_START_NOTICE, z10, null, null, 12, null);
                        }
                    }
                })));
                return basePushDetailAdapter;
            }
        });
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushBaseDetailSettingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18218e = new LinkedHashMap();
        this.f18217d = c.b(new Function0<BasePushDetailAdapter>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BasePushDetailAdapter invoke() {
                BasePushDetailAdapter basePushDetailAdapter = new BasePushDetailAdapter();
                final PushBaseDetailSettingLayout pushBaseDetailSettingLayout = PushBaseDetailSettingLayout.this;
                basePushDetailAdapter.l().i(i0.h(f.a(Integer.valueOf(R$id.pushItemHeaderSwitch), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2$1$1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i102) {
                        if (obj instanceof NewPushLiveShowModel) {
                            NewPushLiveShowModel newPushLiveShowModel = (NewPushLiveShowModel) obj;
                            newPushLiveShowModel.setPushLiveShow(z10);
                            Function2<Boolean, Boolean, p> headerClick = PushBaseDetailSettingLayout.this.getHeaderClick();
                            if (headerClick != null) {
                                headerClick.mo1743invoke(Boolean.valueOf(z10), Boolean.TRUE);
                            }
                            PushBaseDetailSettingLayout.this.d(newPushLiveShowModel);
                            GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIVE_START_NOTICE, z10, null, null, 12, null);
                        }
                    }
                }), f.a(Integer.valueOf(R$id.pushItemSwitch), new Function3<Object, Boolean, Integer, p>() { // from class: com.cupidapp.live.setting.view.PushBaseDetailSettingLayout$basePushDetailAdapter$2$1$2
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ p invoke(Object obj, Boolean bool, Integer num) {
                        invoke(obj, bool.booleanValue(), num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, boolean z10, int i102) {
                        if (obj instanceof NewPushLiveShowItemModel) {
                            NewPushLiveShowItemModel newPushLiveShowItemModel = (NewPushLiveShowItemModel) obj;
                            newPushLiveShowItemModel.setSendPush(z10);
                            Function3<String, Boolean, Boolean, p> itemClick = PushBaseDetailSettingLayout.this.getItemClick();
                            if (itemClick != null) {
                                itemClick.invoke(newPushLiveShowItemModel.getUser().getUserId(), Boolean.valueOf(z10), Boolean.TRUE);
                            }
                            GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.LIVE_START_NOTICE, z10, null, null, 12, null);
                        }
                    }
                })));
                return basePushDetailAdapter;
            }
        });
        c();
    }
}

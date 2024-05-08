package com.cupidapp.live.profile.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKCheckBoxItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.match.view.MBTIEntranceLayout;
import com.cupidapp.live.profile.model.AddInfoOptionsModel;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileOptionsActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileOptionsActivity extends FKBaseProfileSpecActivity {

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public static final a f17666z = new a(null);

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public FKCheckBoxItemLayout f17667v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public AddInfoOptionsModel f17668w;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17670y = new LinkedHashMap();

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public List<String> f17669x = new ArrayList();

    /* compiled from: ProfileOptionsActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ProfileOptionsActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements MBTIEntranceLayout.a {
        public b() {
        }

        @Override // com.cupidapp.live.match.view.MBTIEntranceLayout.a
        public void a(boolean z10) {
            if (z10) {
                ((LinearLayout) ProfileOptionsActivity.this.n1(R$id.root_ll)).setPadding(0, 0, 0, z0.h.c(this, 90.0f));
            } else {
                ((LinearLayout) ProfileOptionsActivity.this.n1(R$id.root_ll)).setPadding(0, 0, 0, 0);
            }
        }
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17670y;
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
        setContentView(R$layout.activity_profile_options);
        u1();
        t1();
    }

    public final void t1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) n1(R$id.profileOptionsTitleLayout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileOptionsActivity$bindClickEvent$1$1
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
                ProfileOptionsActivity.this.finish();
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileOptionsActivity$bindClickEvent$1$2
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
                ArrayList arrayList;
                List<AddInfoOptionsModel> options;
                ProfileSpecListModel k12 = ProfileOptionsActivity.this.k1();
                if (k12 == null || (options = k12.getOptions()) == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (AddInfoOptionsModel addInfoOptionsModel : options) {
                        if (addInfoOptionsModel.getChecked()) {
                            arrayList2.add(addInfoOptionsModel);
                        }
                    }
                    arrayList = new ArrayList(kotlin.collections.t.t(arrayList2, 10));
                    Iterator<E> iterator2 = arrayList2.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(((AddInfoOptionsModel) iterator2.next()).getValue());
                    }
                }
                ProfileOptionsActivity.this.m1(arrayList);
            }
        });
        FKCheckBoxItemLayout purposeClearLayout = (FKCheckBoxItemLayout) n1(R$id.purposeClearLayout);
        kotlin.jvm.internal.s.h(purposeClearLayout, "purposeClearLayout");
        z0.y.d(purposeClearLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileOptionsActivity$bindClickEvent$2
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
                List list;
                List<AddInfoOptionsModel> options;
                int childCount = ((LinearLayout) ProfileOptionsActivity.this.n1(R$id.optionsLayout)).getChildCount();
                ProfileOptionsActivity profileOptionsActivity = ProfileOptionsActivity.this;
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = ((LinearLayout) profileOptionsActivity.n1(R$id.optionsLayout)).getChildAt(i10);
                    FKCheckBoxItemLayout fKCheckBoxItemLayout = childAt instanceof FKCheckBoxItemLayout ? (FKCheckBoxItemLayout) childAt : null;
                    if (fKCheckBoxItemLayout != null) {
                        fKCheckBoxItemLayout.setChecked(false);
                    }
                }
                ProfileSpecListModel k12 = ProfileOptionsActivity.this.k1();
                if (k12 != null && (options = k12.getOptions()) != null) {
                    Iterator<AddInfoOptionsModel> iterator2 = options.iterator2();
                    while (iterator2.hasNext()) {
                        iterator2.next().setChecked(false);
                    }
                }
                ((FKCheckBoxItemLayout) ProfileOptionsActivity.this.n1(R$id.purposeClearLayout)).setChecked(true);
                list = ProfileOptionsActivity.this.f17669x;
                list.clear();
            }
        });
    }

    public final void u1() {
        List<AddInfoOptionsModel> options;
        List<String> valueList;
        FKTitleBarLayout profileOptionsTitleLayout = (FKTitleBarLayout) n1(R$id.profileOptionsTitleLayout);
        kotlin.jvm.internal.s.h(profileOptionsTitleLayout, "profileOptionsTitleLayout");
        ProfileSpecListModel k12 = k1();
        FKTitleBarLayout.setSingleTitle$default(profileOptionsTitleLayout, k12 != null ? k12.getName() : null, null, 2, null);
        int i10 = R$id.mtbi_entrance_layout;
        ((MBTIEntranceLayout) n1(i10)).setVisibilityListener(new b());
        ((MBTIEntranceLayout) n1(i10)).h(v1());
        ProfileSpecListModel k13 = k1();
        if (k13 != null && (valueList = k13.getValueList()) != null) {
            this.f17669x = CollectionsKt___CollectionsKt.z0(valueList);
        }
        ProfileSpecListModel k14 = k1();
        if (k14 != null && (options = k14.getOptions()) != null) {
            ((LinearLayout) n1(R$id.optionsLayout)).removeAllViews();
            int i11 = 0;
            for (AddInfoOptionsModel addInfoOptionsModel : options) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.s.s();
                }
                final AddInfoOptionsModel addInfoOptionsModel2 = addInfoOptionsModel;
                final FKCheckBoxItemLayout fKCheckBoxItemLayout = new FKCheckBoxItemLayout(this);
                fKCheckBoxItemLayout.setTitleTextValue(addInfoOptionsModel2.getLabel());
                fKCheckBoxItemLayout.setChecked(addInfoOptionsModel2.getChecked());
                fKCheckBoxItemLayout.setBottomLineValue(Boolean.TRUE);
                if (addInfoOptionsModel2.getChecked()) {
                    this.f17667v = fKCheckBoxItemLayout;
                    this.f17668w = addInfoOptionsModel2;
                } else if (i11 == kotlin.collections.s.l(options) && this.f17667v == null) {
                    int i13 = R$id.purposeClearLayout;
                    this.f17667v = (FKCheckBoxItemLayout) n1(i13);
                    ((FKCheckBoxItemLayout) n1(i13)).setChecked(true);
                    this.f17668w = null;
                }
                z0.y.d(fKCheckBoxItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileOptionsActivity$initView$3$1$1
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
                        List list;
                        List list2;
                        List list3;
                        List list4;
                        FKCheckBoxItemLayout fKCheckBoxItemLayout2;
                        AddInfoOptionsModel addInfoOptionsModel3;
                        FKCheckBoxItemLayout fKCheckBoxItemLayout3;
                        AddInfoOptionsModel addInfoOptionsModel4;
                        ProfileOptionsActivity profileOptionsActivity = ProfileOptionsActivity.this;
                        int i14 = R$id.purposeClearLayout;
                        ((FKCheckBoxItemLayout) profileOptionsActivity.n1(i14)).setChecked(false);
                        ProfileSpecListModel k15 = ProfileOptionsActivity.this.k1();
                        String type = k15 != null ? k15.getType() : null;
                        if (kotlin.jvm.internal.s.d(type, "select")) {
                            fKCheckBoxItemLayout2 = ProfileOptionsActivity.this.f17667v;
                            if (fKCheckBoxItemLayout2 != null) {
                                fKCheckBoxItemLayout2.setChecked(false);
                            }
                            addInfoOptionsModel3 = ProfileOptionsActivity.this.f17668w;
                            if (addInfoOptionsModel3 != null) {
                                addInfoOptionsModel3.setChecked(false);
                            }
                            ProfileOptionsActivity.this.f17667v = fKCheckBoxItemLayout;
                            ProfileOptionsActivity.this.f17668w = addInfoOptionsModel2;
                            fKCheckBoxItemLayout3 = ProfileOptionsActivity.this.f17667v;
                            if (fKCheckBoxItemLayout3 != null) {
                                fKCheckBoxItemLayout3.setChecked(true);
                            }
                            addInfoOptionsModel4 = ProfileOptionsActivity.this.f17668w;
                            if (addInfoOptionsModel4 == null) {
                                return;
                            }
                            addInfoOptionsModel4.setChecked(true);
                            return;
                        }
                        if (kotlin.jvm.internal.s.d(type, Attributes.InputType.CHECK_BOX)) {
                            if (addInfoOptionsModel2.getChecked()) {
                                addInfoOptionsModel2.setChecked(false);
                                fKCheckBoxItemLayout.setChecked(false);
                                list4 = ProfileOptionsActivity.this.f17669x;
                                list4.remove(addInfoOptionsModel2.getValue());
                            } else {
                                list = ProfileOptionsActivity.this.f17669x;
                                if (list.size() < 3) {
                                    addInfoOptionsModel2.setChecked(true);
                                    fKCheckBoxItemLayout.setChecked(true);
                                    list2 = ProfileOptionsActivity.this.f17669x;
                                    list2.add(addInfoOptionsModel2.getValue());
                                } else {
                                    FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, ProfileOptionsActivity.this, false, 2, null), R$string.most_select, 0, 2, null), 2131886528, null, null, 6, null), null, 1, null);
                                }
                            }
                            FKCheckBoxItemLayout fKCheckBoxItemLayout4 = (FKCheckBoxItemLayout) ProfileOptionsActivity.this.n1(i14);
                            list3 = ProfileOptionsActivity.this.f17669x;
                            fKCheckBoxItemLayout4.setChecked(list3 == null || list3.isEmpty());
                        }
                    }
                });
                ((LinearLayout) n1(R$id.optionsLayout)).addView(fKCheckBoxItemLayout);
                i11 = i12;
            }
        }
        if (v1()) {
            j1.c cVar = j1.c.f50228a;
            SensorPosition sensorPosition = SensorPosition.MBTI_SETTING;
            ProfileSpecListModel k15 = k1();
            j1.c.b(cVar, sensorPosition, k15 != null ? k15.getName() : null, null, 4, null);
        }
    }

    public final boolean v1() {
        ProfileSpecListModel k12 = k1();
        return kotlin.text.p.r(k12 != null ? k12.getName() : null, "MBTI", true);
    }
}

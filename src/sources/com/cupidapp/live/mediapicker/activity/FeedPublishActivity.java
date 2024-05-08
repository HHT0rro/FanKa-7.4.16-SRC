package com.cupidapp.live.mediapicker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.permission.FKRxPermissionOpenModel;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.o;
import com.cupidapp.live.feed.layout.EditTextSelectable;
import com.cupidapp.live.feed.model.PostBoostModel;
import com.cupidapp.live.hashtag.list.HashTagListActivity;
import com.cupidapp.live.hashtag.list.HashTagListType;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.hashtag.model.HashTagTowardNewResult;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.mediapicker.activity.FeedPublishRangeActivity;
import com.cupidapp.live.mediapicker.adapter.LocationAdapter;
import com.cupidapp.live.mediapicker.event.FeedPublishSuccessEvent;
import com.cupidapp.live.mediapicker.fragment.FeedPublishPreviewFragment;
import com.cupidapp.live.mediapicker.helper.PublishManager;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.mediapicker.model.ImageContentModel;
import com.cupidapp.live.mediapicker.model.ImagePublishViewViewModel;
import com.cupidapp.live.mediapicker.model.Location;
import com.cupidapp.live.mediapicker.model.UploadImageModel;
import com.cupidapp.live.mediapicker.model.UploadVideoModel;
import com.cupidapp.live.mediapicker.model.VideoContentModel;
import com.cupidapp.live.mediapicker.model.VideoPublishViewViewModel;
import com.cupidapp.live.mentionuser.atuser.AtUserActivity;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.EnterWayType;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FeedPublishActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedPublishActivity extends FKBaseActivity implements TextWatcher {

    @NotNull
    public static final a K = new a(null);

    @Nullable
    public FeedPublishPreviewFragment A;
    public boolean B;
    public boolean C;

    @Nullable
    public String D;
    public boolean E;
    public boolean F;

    @NotNull
    public final Lazy G;

    @Nullable
    public com.cupidapp.live.feed.helper.f H;
    public boolean I;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public Location f17079q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public HashTagSimpleModel f17080r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f17081s;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public ImageContentModel f17084v;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public String f17087y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    public final LocationAdapter f17088z;

    @NotNull
    public Map<Integer, View> J = new LinkedHashMap();

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f17082t = kotlin.c.b(new Function0<VideoContentModel>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$videoContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final VideoContentModel invoke() {
            Bundle extras = FeedPublishActivity.this.getIntent().getExtras();
            if (extras != null) {
                return (VideoContentModel) z0.g.b(extras, VideoContentModel.class);
            }
            return null;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public final Lazy f17083u = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(FeedPublishActivity.this);
        }
    });

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public final Lazy f17085w = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishMethod$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String string;
            Bundle extras = FeedPublishActivity.this.getIntent().getExtras();
            return (extras == null || (string = extras.getString("PublishMethod")) == null) ? "其他" : string;
        }
    });

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public final Lazy f17086x = kotlin.c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishPosition$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SensorPosition invoke() {
            SensorPosition sensorPosition;
            Bundle extras = FeedPublishActivity.this.getIntent().getExtras();
            return (extras == null || (sensorPosition = (SensorPosition) z0.g.b(extras, SensorPosition.class)) == null) ? SensorPosition.Unknown : sensorPosition;
        }
    });

    /* compiled from: FeedPublishActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Activity activity, @Nullable ImageContentModel imageContentModel, @Nullable VideoContentModel videoContentModel, @Nullable HashTagSimpleModel hashTagSimpleModel, int i10, @NotNull String publishMethod, @Nullable SensorPosition sensorPosition, boolean z10, boolean z11, @Nullable String str) {
            s.i(publishMethod, "publishMethod");
            Intent intent = new Intent(activity, (Class<?>) FeedPublishActivity.class);
            Bundle bundle = new Bundle();
            if (imageContentModel != null) {
                z0.g.d(bundle, imageContentModel);
            }
            if (videoContentModel != null) {
                z0.g.d(bundle, videoContentModel);
            }
            if (hashTagSimpleModel != null) {
                z0.g.d(bundle, hashTagSimpleModel);
            }
            bundle.putString("PublishMethod", publishMethod);
            bundle.putString("publishFromWebTitle", str);
            if (sensorPosition != null) {
                z0.g.d(bundle, sensorPosition);
            }
            bundle.putBoolean("IsTakePhoto", z10);
            bundle.putBoolean("isUserEdit", z11);
            intent.putExtras(bundle);
            if (activity != null) {
                activity.startActivityForResult(intent, i10);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    public FeedPublishActivity() {
        LocationAdapter locationAdapter = new LocationAdapter();
        locationAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$locationAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                String str;
                if (obj instanceof Location) {
                    Location location = (Location) obj;
                    FeedPublishActivity.this.f17079q = location;
                    FeedPublishActivity.this.f17087y = "从推荐中添加";
                    FeedPublishActivity.this.T1(location.getName());
                    FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                    PostAndSocialProtos.Type type = PostAndSocialProtos.Type.LOCATION_RECOMMEND;
                    str = feedPublishActivity.D;
                    feedPublishActivity.t2(type, str);
                }
            }
        });
        this.f17088z = locationAdapter;
        this.B = true;
        this.G = kotlin.c.b(new Function0<o>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$softKeyboardWatcher$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final o invoke() {
                return new o(FeedPublishActivity.this);
            }
        });
    }

    public static final List a2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static final void b2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void c2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l2(FeedPublishActivity this$0) {
        s.i(this$0, "this$0");
        ImageView imageView = (ImageView) this$0.p1(R$id.publish_at_user_tip_img);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public static final void m2(FeedPublishActivity this$0) {
        s.i(this$0, "this$0");
        this$0.o1();
    }

    public final void Q1() {
        TextView publishTxt = (TextView) p1(R$id.publishTxt);
        s.h(publishTxt, "publishTxt");
        y.d(publishTxt, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$1
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
                String W1;
                HashTagSimpleModel hashTagSimpleModel;
                boolean z10;
                boolean z11;
                ImageContentModel imageContentModel;
                FeedPublishActivity.this.o2();
                SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                W1 = FeedPublishActivity.this.W1();
                hashTagSimpleModel = FeedPublishActivity.this.f17080r;
                String itemId = hashTagSimpleModel != null ? hashTagSimpleModel.getItemId() : null;
                z10 = FeedPublishActivity.this.C;
                z11 = FeedPublishActivity.this.I;
                imageContentModel = FeedPublishActivity.this.f17084v;
                sensorsLogFeed.e(W1, itemId, z10, z11, imageContentModel != null ? imageContentModel.getFrameType() : null);
            }
        });
        ((FKTitleBarLayout) p1(R$id.feedPublishTitleBarLayout)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$2
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
                FeedPublishActivity.this.onBackPressed();
            }
        });
        View locationLayout = p1(R$id.locationLayout);
        s.h(locationLayout, "locationLayout");
        y.d(locationLayout, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$3
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
                FeedPublishActivity.this.w2();
            }
        });
        ImageView clearlocationImage = (ImageView) p1(R$id.clearlocationImage);
        s.h(clearlocationImage, "clearlocationImage");
        y.d(clearlocationImage, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$4
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
                FeedPublishActivity.this.f17079q = null;
                FeedPublishActivity.this.T1(null);
                ((RecyclerView) FeedPublishActivity.this.p1(R$id.locationRecyclerView)).scrollToPosition(0);
                FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                PostAndSocialProtos.Type type = PostAndSocialProtos.Type.LOCATION;
                str = feedPublishActivity.D;
                feedPublishActivity.t2(type, str);
            }
        });
        FrameLayout imageContainerLayout = (FrameLayout) p1(R$id.imageContainerLayout);
        s.h(imageContainerLayout, "imageContainerLayout");
        y.d(imageContainerLayout, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$5
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
                ImageContentModel imageContentModel;
                VideoContentModel h22;
                VideoContentModel h23;
                VideoContentModel h24;
                UploadImageModel coverImage;
                UploadVideoModel uploadVideo;
                ImageContentModel imageContentModel2;
                ArrayList arrayList;
                List<UploadImageModel> uploadImageList;
                imageContentModel = FeedPublishActivity.this.f17084v;
                String str = null;
                str = null;
                if (imageContentModel != null) {
                    imageContentModel2 = FeedPublishActivity.this.f17084v;
                    if (imageContentModel2 == null || (uploadImageList = imageContentModel2.getUploadImageList()) == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList(t.t(uploadImageList, 10));
                        Iterator<UploadImageModel> iterator2 = uploadImageList.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList2.add(iterator2.next().getLocalPath());
                        }
                        arrayList = new ArrayList();
                        for (Object obj : arrayList2) {
                            String str2 = (String) obj;
                            if (!(str2 == null || str2.length() == 0)) {
                                arrayList.add(obj);
                            }
                        }
                    }
                    ArrayList arrayList3 = arrayList instanceof ArrayList ? arrayList : null;
                    if (arrayList3 != null) {
                        FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                        if (arrayList3.size() > 0) {
                            feedPublishActivity.X1(arrayList3, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                h22 = FeedPublishActivity.this.h2();
                if (h22 != null) {
                    String[] strArr = new String[2];
                    h23 = FeedPublishActivity.this.h2();
                    strArr[0] = (h23 == null || (uploadVideo = h23.getUploadVideo()) == null) ? null : uploadVideo.getLocalPath();
                    h24 = FeedPublishActivity.this.h2();
                    if (h24 != null && (coverImage = h24.getCoverImage()) != null) {
                        str = coverImage.getLocalPath();
                    }
                    strArr[1] = str;
                    FeedPublishActivity.this.X1(kotlin.collections.s.f(strArr), true);
                }
            }
        });
        View rangeLayout = p1(R$id.rangeLayout);
        s.h(rangeLayout, "rangeLayout");
        y.d(rangeLayout, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$6
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
                boolean z10;
                FeedPublishRangeActivity.a aVar = FeedPublishRangeActivity.f17089t;
                FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                z10 = feedPublishActivity.I;
                aVar.a(feedPublishActivity, 9, z10);
            }
        });
        View hashTagLayout = p1(R$id.hashTagLayout);
        s.h(hashTagLayout, "hashTagLayout");
        y.d(hashTagLayout, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$7
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
                boolean z10;
                String str;
                z10 = FeedPublishActivity.this.B;
                if (z10) {
                    HashTagListActivity.f14718r.b(FeedPublishActivity.this, HashTagListType.DATA_SELECT_HASHTAG, 4);
                } else {
                    FeedTagPickerActivity.f17093u.a(FeedPublishActivity.this, 3);
                }
                FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                PostAndSocialProtos.Type type = PostAndSocialProtos.Type.TOPIC;
                str = feedPublishActivity.D;
                feedPublishActivity.t2(type, str);
            }
        });
        ImageView clearHashTagImage = (ImageView) p1(R$id.clearHashTagImage);
        s.h(clearHashTagImage, "clearHashTagImage");
        y.d(clearHashTagImage, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$8
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
                FeedPublishActivity.this.f17080r = null;
                FeedPublishActivity.this.S1(null);
                FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                PostAndSocialProtos.Type type = PostAndSocialProtos.Type.TOPIC;
                str = feedPublishActivity.D;
                feedPublishActivity.t2(type, str);
            }
        });
        RelativeLayout root = (RelativeLayout) p1(R$id.root);
        s.h(root, "root");
        y.d(root, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$9
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
                FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                z0.h.p(feedPublishActivity, (EditTextSelectable) feedPublishActivity.p1(R$id.feedSummaryTextView));
                ((FrameLayout) FeedPublishActivity.this.p1(R$id.imageContainerLayout)).setVisibility(0);
            }
        });
        g2().b(new Function2<Integer, Boolean, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$10
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(int i10, boolean z10) {
                FeedPublishActivity.this.F = z10;
                if (z10) {
                    ((ImageView) FeedPublishActivity.this.p1(R$id.publish_at_user_tip_img)).setVisibility(8);
                    p1.g.f52734a.i3(Boolean.FALSE);
                    ((FrameLayout) FeedPublishActivity.this.p1(R$id.imageContainerLayout)).setVisibility(8);
                    return;
                }
                ((FrameLayout) FeedPublishActivity.this.p1(R$id.imageContainerLayout)).setVisibility(0);
            }
        });
        ImageView publish_at_user_img = (ImageView) p1(R$id.publish_at_user_img);
        s.h(publish_at_user_img, "publish_at_user_img");
        y.d(publish_at_user_img, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$bindEvent$11
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
                ((ImageView) FeedPublishActivity.this.p1(R$id.publish_at_user_tip_img)).setVisibility(8);
                p1.g.f52734a.i3(Boolean.FALSE);
                AtUserActivity.f17473u.a(FeedPublishActivity.this, 8, false);
                GroupSocialLog.f18708a.Q(SensorPosition.EditFeed, EnterWayType.CLICK);
            }
        });
    }

    public final void R1() {
        int i10 = R$id.rangeLayout;
        ((ImageView) p1(i10).findViewById(R$id.rangeIcon)).setSelected(this.I);
        int i11 = this.I ? -15066598 : -5658199;
        ((TextView) p1(i10).findViewById(R$id.rangeTitle)).setTextColor(i11);
        View p12 = p1(i10);
        int i12 = R$id.rangeSelect;
        ((TextView) p12.findViewById(i12)).setTextColor(i11);
        ((TextView) p1(i10).findViewById(i12)).setText(this.I ? R$string.close_friend : R$string.open);
    }

    public final void S1(HashTagSimpleModel hashTagSimpleModel) {
        if (hashTagSimpleModel == null) {
            ((LinearLayout) p1(R$id.hashTagContentLinear)).setVisibility(8);
            ((TextView) p1(R$id.hashTagPlaceHolder)).setVisibility(0);
            ((ImageView) p1(R$id.hashTagIcon)).setImageResource(R$mipmap.icon_select_hashtag_gray);
        } else {
            ((TextView) p1(R$id.hashTagPlaceHolder)).setVisibility(8);
            ((LinearLayout) p1(R$id.hashTagContentLinear)).setVisibility(0);
            ((TextView) p1(R$id.hashTagTextView)).setText(hashTagSimpleModel.getName());
            ((ImageView) p1(R$id.hashTagIcon)).setImageResource(R$mipmap.icon_select_hashtag_black);
        }
        u2();
    }

    public final void T1(String str) {
        if (str == null || str.length() == 0) {
            ((LinearLayout) p1(R$id.locationContentLinear)).setVisibility(4);
            ((TextView) p1(R$id.locationPlaceHolder)).setVisibility(0);
            ((ImageView) p1(R$id.locationIcon)).setImageResource(R$mipmap.icon_location_gray);
            ((RecyclerView) p1(R$id.locationRecyclerView)).setVisibility(0);
            return;
        }
        ((LinearLayout) p1(R$id.locationContentLinear)).setVisibility(0);
        ((TextView) p1(R$id.locationPlaceHolder)).setVisibility(4);
        ((TextView) p1(R$id.locationTextView)).setText(str);
        ((ImageView) p1(R$id.locationIcon)).setImageResource(R$mipmap.icon_location_black);
        ((RecyclerView) p1(R$id.locationRecyclerView)).setVisibility(8);
    }

    public final void U1() {
        if (this.E) {
            Editable text = ((EditTextSelectable) p1(R$id.feedSummaryTextView)).getText();
            V1(text != null ? text.length() : 0);
            ((TextView) p1(R$id.tipsNumberTxt)).setVisibility(0);
            return;
        }
        ((TextView) p1(R$id.tipsNumberTxt)).setVisibility(8);
    }

    public final void V1(int i10) {
        TextView textView = (TextView) p1(R$id.tipsNumberTxt);
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String string = getString(R$string.number);
        s.h(string, "getString(R.string.number)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i10), 1000}, 2));
        s.h(format, "format(format, *args)");
        textView.setText(z0.t.k(format, -49088, new String[]{String.valueOf(i10)}, false, 4, null));
    }

    public final String W1() {
        String valueOf = String.valueOf(((EditTextSelectable) p1(R$id.feedSummaryTextView)).getText());
        int length = valueOf.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean z11 = s.k(valueOf.charAt(!z10 ? i10 : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                }
                length--;
            } else if (z11) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return valueOf.subSequence(i10, length + 1).toString();
    }

    public final void X1(ArrayList<String> arrayList, boolean z10) {
        FrameAspectRatio frameType;
        ((FrameLayout) p1(R$id.publishPreviewLayout)).setVisibility(0);
        FeedPublishPreviewFragment.a aVar = FeedPublishPreviewFragment.f17160h;
        ImageContentModel imageContentModel = this.f17084v;
        this.A = aVar.a(arrayList, (imageContentModel == null || (frameType = imageContentModel.getFrameType()) == null) ? 0.0f : frameType.getRatio(), z10);
        FragmentTransaction customAnimations = getSupportFragmentManager().beginTransaction().setCustomAnimations(R$anim.alpha_in, 0, 0, R$anim.alpha_out);
        FeedPublishPreviewFragment feedPublishPreviewFragment = this.A;
        s.f(feedPublishPreviewFragment);
        customAnimations.replace(R$id.publishPreviewLayout, feedPublishPreviewFragment).commitNowAllowingStateLoss();
    }

    public final void Y1() {
        EventBus.c().o(new FeedPublishSuccessEvent());
        setResult(-1);
        finish();
    }

    public final void Z1() {
        Observable observeOn = Observable.just(LocationUtils.f12270h.a().j()).observeOn(Schedulers.io());
        final Function1<CoordinateModel, List<Location>> function1 = new Function1<CoordinateModel, List<Location>>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$getLocationInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List<Location> invoke(@NotNull CoordinateModel it) {
                s.i(it, "it");
                PoiSearchV2.Query query = new PoiSearchV2.Query("", "");
                query.setPageSize(6);
                query.setPageNum(0);
                PoiSearchV2 poiSearchV2 = new PoiSearchV2(FeedPublishActivity.this, query);
                poiSearchV2.setBound(new PoiSearchV2.SearchBound(new LatLonPoint(it.getLatitude(), it.getLongitude()), 3000, true));
                PoiResultV2 searchPOI = poiSearchV2.searchPOI();
                ArrayList arrayList = new ArrayList();
                if (searchPOI.getQuery() != null) {
                    ArrayList<PoiItemV2> poiItems = searchPOI.getPois();
                    s.h(poiItems, "poiItems");
                    for (PoiItemV2 poiItemV2 : poiItems) {
                        String poiId = poiItemV2.getPoiId();
                        s.h(poiId, "itemV2.poiId");
                        arrayList.add(new Location(poiId, poiItemV2.getSnippet(), poiItemV2.getTitle(), Double.valueOf(poiItemV2.getLatLonPoint().getLatitude()), Double.valueOf(poiItemV2.getLatLonPoint().getLongitude()), poiItemV2.getCityName()));
                    }
                }
                return arrayList;
            }
        };
        Observable observeOn2 = observeOn.map(new Function() { // from class: com.cupidapp.live.mediapicker.activity.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List a22;
                a22 = FeedPublishActivity.a2(Function1.this, obj);
                return a22;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<List<Location>, p> function12 = new Function1<List<Location>, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$getLocationInfo$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<Location> list) {
                invoke2(list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Location> list) {
                LocationAdapter locationAdapter;
                LocationAdapter locationAdapter2;
                LocationAdapter locationAdapter3;
                if (list == null || list.isEmpty()) {
                    return;
                }
                locationAdapter = FeedPublishActivity.this.f17088z;
                locationAdapter.j().clear();
                locationAdapter2 = FeedPublishActivity.this.f17088z;
                locationAdapter2.e(list);
                locationAdapter3 = FeedPublishActivity.this.f17088z;
                locationAdapter3.notifyDataSetChanged();
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.mediapicker.activity.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedPublishActivity.b2(Function1.this, obj);
            }
        };
        final FeedPublishActivity$getLocationInfo$3 feedPublishActivity$getLocationInfo$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$getLocationInfo$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable subscribe = observeOn2.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.mediapicker.activity.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedPublishActivity.c2(Function1.this, obj);
            }
        });
        s.h(subscribe, "private fun getLocationI…       })\n        )\n    }");
        H(subscribe);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        SpannableStringBuilder d10 = z0.t.d(new SpannableStringBuilder(editable));
        int length = d10.length();
        int i10 = R$id.feedSummaryTextView;
        if (!s.d(String.valueOf(((EditTextSelectable) p1(i10)).getText()), d10.toString())) {
            ((EditTextSelectable) p1(i10)).setText(d10);
            ((EditTextSelectable) p1(i10)).setSelection(length);
        }
        this.E = length > 1000;
        U1();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
    }

    public final String d2() {
        return (String) this.f17085w.getValue();
    }

    public final SensorPosition e2() {
        return (SensorPosition) this.f17086x.getValue();
    }

    public final xb.b f2() {
        return (xb.b) this.f17083u.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, android.app.Activity
    public void finish() {
        z0.h.q(this, null, 1, null);
        super.finish();
    }

    public final o g2() {
        return (o) this.G.getValue();
    }

    public final VideoContentModel h2() {
        return (VideoContentModel) this.f17082t.getValue();
    }

    public final void i2(String str) {
        if (str == null || str.length() == 0) {
            com.cupidapp.live.base.view.h.f12779a.r(this, R$string.cant_find_image);
            finish();
        } else {
            ImageLoaderView publishImageView = (ImageLoaderView) p1(R$id.publishImageView);
            s.h(publishImageView, "publishImageView");
            ImageLoaderView.f(publishImageView, new com.cupidapp.live.base.imageloader.b(false, str, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        }
    }

    public final void j2() {
        Disposable disposed = NetworkClient.f11868a.l().P().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<HashTagTowardNewResult, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$initToward$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(HashTagTowardNewResult hashTagTowardNewResult) {
                m2737invoke(hashTagTowardNewResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2737invoke(HashTagTowardNewResult hashTagTowardNewResult) {
                HashTagSimpleModel hashTagSimpleModel;
                FeedPublishActivity feedPublishActivity = FeedPublishActivity.this;
                Boolean towardNew = hashTagTowardNewResult.getTowardNew();
                feedPublishActivity.B = towardNew != null ? towardNew.booleanValue() : false;
                FeedPublishActivity feedPublishActivity2 = FeedPublishActivity.this;
                hashTagSimpleModel = feedPublishActivity2.f17080r;
                feedPublishActivity2.S1(hashTagSimpleModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void k2() {
        List<UploadImageModel> uploadImageList;
        UploadImageModel uploadImageModel;
        UploadImageModel coverImage;
        Bundle extras = getIntent().getExtras();
        String str = null;
        this.f17080r = extras != null ? (HashTagSimpleModel) z0.g.b(extras, HashTagSimpleModel.class) : null;
        int i10 = R$id.feedSummaryTextView;
        ((EditTextSelectable) p1(i10)).addTextChangedListener(this);
        EditTextSelectable feedSummaryTextView = (EditTextSelectable) p1(i10);
        s.h(feedSummaryTextView, "feedSummaryTextView");
        this.H = new com.cupidapp.live.feed.helper.f(feedSummaryTextView, new Function1<Boolean, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                GroupSocialLog.f18708a.Q(SensorPosition.EditFeed, z10 ? EnterWayType.WRITE : EnterWayType.CLICK);
                AtUserActivity.f17473u.a(FeedPublishActivity.this, 8, z10);
            }
        });
        if (h2() != null) {
            ((ImageView) p1(R$id.videoIconImageView)).setVisibility(0);
            VideoContentModel h22 = h2();
            if (h22 != null && (coverImage = h22.getCoverImage()) != null) {
                str = coverImage.getLocalPath();
            }
            i2(str);
        } else if (this.f17084v != null) {
            ImageView imageView = (ImageView) p1(R$id.multiImageView);
            ImageContentModel imageContentModel = this.f17084v;
            s.f(imageContentModel);
            imageView.setVisibility(imageContentModel.getUploadImageList().size() > 1 ? 0 : 8);
            ImageContentModel imageContentModel2 = this.f17084v;
            if (imageContentModel2 != null && (uploadImageList = imageContentModel2.getUploadImageList()) != null && (uploadImageModel = (UploadImageModel) CollectionsKt___CollectionsKt.V(uploadImageList)) != null) {
                str = uploadImageModel.getLocalPath();
            }
            i2(str);
        }
        int i11 = R$id.locationRecyclerView;
        ((RecyclerView) p1(i11)).setLayoutManager(new LinearLayoutManager(this, 0, false));
        ((RecyclerView) p1(i11)).setAdapter(this.f17088z);
        p1.g gVar = p1.g.f52734a;
        if (s.d(gVar.R0(), Boolean.TRUE)) {
            gVar.i3(Boolean.FALSE);
            int i12 = R$id.publish_at_user_tip_img;
            ((ImageView) p1(i12)).setVisibility(0);
            ((ImageView) p1(i12)).postDelayed(new Runnable() { // from class: com.cupidapp.live.mediapicker.activity.e
                @Override // java.lang.Runnable
                public final void run() {
                    FeedPublishActivity.l2(FeedPublishActivity.this);
                }
            }, 5000L);
            return;
        }
        ((ImageView) p1(R$id.publish_at_user_tip_img)).setVisibility(8);
    }

    public final void n2() {
        t2(PostAndSocialProtos.Type.LOCATION, this.D);
        LocationForFeedAct.A1(this, 1);
    }

    public final void o1() {
        int i10 = R$id.feedSummaryTextView;
        ((EditTextSelectable) p1(i10)).setCursorVisible(true);
        ((EditTextSelectable) p1(i10)).setFocusable(true);
        ((EditTextSelectable) p1(i10)).setFocusableInTouchMode(true);
        ((EditTextSelectable) p1(i10)).requestFocus();
        EditTextSelectable feedSummaryTextView = (EditTextSelectable) p1(i10);
        s.h(feedSummaryTextView, "feedSummaryTextView");
        z0.h.v(this, feedSummaryTextView);
    }

    public final void o2() {
        e1();
        Disposable disposed = NetworkClient.f11868a.E().c(W1()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishFeed$$inlined$handle$1
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
                VideoContentModel h22;
                h22 = FeedPublishActivity.this.h2();
                if (h22 != null) {
                    FeedPublishActivity.this.r2();
                } else {
                    FeedPublishActivity.this.p2();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishFeed$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FeedPublishActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        com.cupidapp.live.feed.helper.f fVar;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && intent != null) {
            if (i10 == 1) {
                Bundle extras = intent.getExtras();
                Serializable serializable = extras != null ? extras.getSerializable("location") : null;
                Location location = serializable instanceof Location ? (Location) serializable : null;
                this.f17079q = location;
                this.f17087y = "从列表添加";
                T1(location != null ? location.getName() : null);
            } else if (i10 == 3) {
                Bundle extras2 = intent.getExtras();
                Serializable serializable2 = extras2 != null ? extras2.getSerializable("SELECT_HASH_TAG_RESULT") : null;
                HashTag hashTag = serializable2 instanceof HashTag ? (HashTag) serializable2 : null;
                HashTagSimpleModel simpleHashTag = hashTag != null ? hashTag.getSimpleHashTag() : null;
                this.f17080r = simpleHashTag;
                S1(simpleHashTag);
            } else if (i10 == 4) {
                Bundle extras3 = intent.getExtras();
                Serializable serializable3 = extras3 != null ? extras3.getSerializable("select_hashtag_result") : null;
                HashTag hashTag2 = serializable3 instanceof HashTag ? (HashTag) serializable3 : null;
                HashTagSimpleModel simpleHashTag2 = hashTag2 != null ? hashTag2.getSimpleHashTag() : null;
                this.f17080r = simpleHashTag2;
                S1(simpleHashTag2);
            } else if (i10 == 8) {
                Bundle extras4 = intent.getExtras();
                Serializable serializable4 = extras4 != null ? extras4.getSerializable(UserData.NAME) : null;
                User user = serializable4 instanceof User ? (User) serializable4 : null;
                Bundle extras5 = intent.getExtras();
                boolean z10 = extras5 != null ? extras5.getBoolean("hasInsertAtSymbol") : false;
                if (user != null && (fVar = this.H) != null) {
                    com.cupidapp.live.feed.helper.f.c(fVar, user.userId(), user.getName(), z10, 0, 8, null);
                }
            } else if (i10 == 9) {
                Bundle extras6 = intent.getExtras();
                this.I = extras6 != null ? extras6.getBoolean("closeFriendOnly") : this.I;
                R1();
            }
        }
        if (i10 == 8) {
            ((EditTextSelectable) p1(R$id.feedSummaryTextView)).postDelayed(new Runnable() { // from class: com.cupidapp.live.mediapicker.activity.d
                @Override // java.lang.Runnable
                public final void run() {
                    FeedPublishActivity.m2(FeedPublishActivity.this);
                }
            }, 300L);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FeedPublishPreviewFragment feedPublishPreviewFragment = this.A;
        if (feedPublishPreviewFragment != null) {
            if (feedPublishPreviewFragment != null && feedPublishPreviewFragment.isAdded()) {
                FragmentTransaction customAnimations = getSupportFragmentManager().beginTransaction().setCustomAnimations(0, R$anim.alpha_out, 0, 0);
                FeedPublishPreviewFragment feedPublishPreviewFragment2 = this.A;
                s.f(feedPublishPreviewFragment2);
                customAnimations.remove(feedPublishPreviewFragment2).commitNowAllowingStateLoss();
                this.A = null;
                return;
            }
        }
        v2();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_feed_publish);
        Bundle extras = getIntent().getExtras();
        this.f17084v = extras != null ? (ImageContentModel) z0.g.b(extras, ImageContentModel.class) : null;
        Bundle extras2 = getIntent().getExtras();
        this.C = extras2 != null ? extras2.getBoolean("isUserEdit") : false;
        Bundle extras3 = getIntent().getExtras();
        this.D = extras3 != null ? extras3.getString("publishFromWebTitle") : null;
        k2();
        Q1();
        s2();
        j2();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        g2().d();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ((FrameLayout) p1(R$id.imageContainerLayout)).setVisibility(0);
        super.onPause();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Nullable
    public View p1(int i10) {
        Map<Integer, View> map = this.J;
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

    public final void p2() {
        ImageContentModel imageContentModel = this.f17084v;
        if (imageContentModel == null) {
            return;
        }
        Location location = this.f17079q;
        if (location != null) {
            imageContentModel.setLocation(location);
        }
        imageContentModel.setHashTag(this.f17080r);
        imageContentModel.setCloseFriendOnly(this.I);
        imageContentModel.setDescription(W1());
        com.cupidapp.live.feed.helper.f fVar = this.H;
        imageContentModel.setReplaceAtList(fVar != null ? fVar.f() : null);
        String publishMethod = d2();
        s.h(publishMethod, "publishMethod");
        imageContentModel.setPublishMethod(publishMethod);
        imageContentModel.setPublishPosition(e2());
        imageContentModel.setAddPlaceMethod(this.f17087y);
        imageContentModel.setWebTitle(this.D);
        ImagePublishViewViewModel imagePublishViewViewModel = new ImagePublishViewViewModel();
        imagePublishViewViewModel.setImageContent(imageContentModel);
        PublishManager.f17234a.h(this, imagePublishViewViewModel, new Function2<PostBoostModel, String, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishImageFeed$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(PostBoostModel postBoostModel, String str) {
                invoke2(postBoostModel, str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable PostBoostModel postBoostModel, @Nullable String str) {
                FeedPublishActivity.this.q2(postBoostModel, str);
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishImageFeed$2
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
                FeedPublishActivity.this.V0();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if ((r1.length() > 0) == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q2(final com.cupidapp.live.feed.model.PostBoostModel r23, java.lang.String r24) {
        /*
            r22 = this;
            r6 = r22
            r0 = r23
            r22.V0()
            if (r24 != 0) goto L85
            java.lang.String r1 = r6.D
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1b
            int r1 = r1.length()
            if (r1 <= 0) goto L17
            r1 = 1
            goto L18
        L17:
            r1 = 0
        L18:
            if (r1 != r2) goto L1b
            goto L1c
        L1b:
            r2 = 0
        L1c:
            if (r2 == 0) goto L1f
            goto L85
        L1f:
            if (r0 == 0) goto L26
            java.lang.String r1 = r23.getPostBoostWebUrl()
            goto L27
        L26:
            r1 = 0
        L27:
            if (r1 == 0) goto L81
            com.cupidapp.live.base.view.g r1 = com.cupidapp.live.base.view.g.f12778a
            r2 = 2131886983(0x7f120387, float:1.940856E38)
            java.lang.String r8 = r6.getString(r2)
            r2 = 2131888558(0x7f1209ae, float:1.9411755E38)
            java.lang.String r10 = r6.getString(r2)
            r2 = 1116209152(0x42880000, float:68.0)
            int r2 = z0.h.c(r6, r2)
            r4 = 1105199104(0x41e00000, float:28.0)
            int r4 = z0.h.c(r6, r4)
            com.cupidapp.live.base.view.SnackbarModel r5 = new com.cupidapp.live.base.view.SnackbarModel
            java.lang.String r7 = "getString(R.string.feed_…read_to_earn_interaction)"
            kotlin.jvm.internal.s.h(r8, r7)
            r9 = 1094713344(0x41400000, float:12.0)
            r11 = -1
            r7 = 2131231967(0x7f0804df, float:1.808003E38)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            r13 = 1094713344(0x41400000, float:12.0)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
            r2 = 2131690369(0x7f0f0381, float:1.900978E38)
            java.lang.Integer r16 = java.lang.Integer.valueOf(r2)
            r17 = 0
            r18 = 0
            com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishSuccess$1 r2 = new com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishSuccess$1
            r2.<init>()
            r20 = 1536(0x600, float:2.152E-42)
            r21 = 0
            r7 = r5
            r19 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            java.lang.String r0 = r22.getLocalClassName()
            r1.b(r5, r0, r3)
        L81:
            r22.Y1()
            return
        L85:
            com.cupidapp.live.MainActivity$a r0 = com.cupidapp.live.MainActivity.F
            java.lang.String r1 = "feed"
            java.lang.String r2 = "follow"
            r0.e(r1, r6, r2)
            com.cupidapp.live.base.router.j$a r0 = com.cupidapp.live.base.router.j.f12156c
            r3 = 0
            r4 = 4
            r5 = 0
            r1 = r22
            r2 = r24
            com.cupidapp.live.base.router.j.a.b(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.mediapicker.activity.FeedPublishActivity.q2(com.cupidapp.live.feed.model.PostBoostModel, java.lang.String):void");
    }

    public final void r2() {
        VideoContentModel h22 = h2();
        if (h22 == null) {
            return;
        }
        Location location = this.f17079q;
        if (location != null) {
            h22.setLocation(location);
        }
        h22.setHashTag(this.f17080r);
        h22.setCloseFriendOnly(this.I);
        if (W1().length() > 0) {
            h22.setDescription(W1());
        }
        com.cupidapp.live.feed.helper.f fVar = this.H;
        h22.setReplaceAtList(fVar != null ? fVar.f() : null);
        String publishMethod = d2();
        s.h(publishMethod, "publishMethod");
        h22.setPublishMethod(publishMethod);
        h22.setPublishPosition(e2());
        h22.setAddPlaceMethod(this.f17087y);
        h22.setWebTitle(this.D);
        VideoPublishViewViewModel videoPublishViewViewModel = new VideoPublishViewViewModel();
        videoPublishViewViewModel.setVideoContent(h22);
        PublishManager.f17234a.h(this, videoPublishViewViewModel, new Function2<PostBoostModel, String, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishVideoFeed$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(PostBoostModel postBoostModel, String str) {
                invoke2(postBoostModel, str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable PostBoostModel postBoostModel, @Nullable String str) {
                FeedPublishActivity.this.q2(postBoostModel, str);
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$publishVideoFeed$2
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
                FeedPublishActivity.this.V0();
            }
        });
    }

    public final void s2() {
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (companion.d(this)) {
            return;
        }
        LocationUtils.o(companion.a(), this, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$resetLocationAndGetLocation$1
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
                FeedPublishActivity.this.Z1();
            }
        }, new Function2<Integer, String, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$resetLocationAndGetLocation$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, String str) {
                invoke2(num, str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num, @Nullable String str) {
                if (LocationUtils.f12270h.a().f()) {
                    return;
                }
                FeedPublishActivity.this.Z1();
            }
        }, null, 8, null);
    }

    public final void t2(PostAndSocialProtos.Type type, String str) {
        SensorsLogFeed.f12208a.d(type, str);
    }

    public final void u2() {
        if (this.B) {
            if (this.f17080r == null) {
                ((TextView) p1(R$id.hashtagTip)).setVisibility(0);
                return;
            } else {
                ((TextView) p1(R$id.hashtagTip)).setVisibility(8);
                return;
            }
        }
        ((TextView) p1(R$id.hashtagTip)).setVisibility(8);
    }

    public final void v2() {
        if (!(W1().length() > 0) && this.f17081s == null && this.f17080r == null) {
            super.onBackPressed();
        } else {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.media_edit_back_alert, 0, 2, null), R$string.continue_to_return, null, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$showReturnAlert$1
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
                    super/*com.cupidapp.live.base.activity.FKBaseActivity*/.onBackPressed();
                }
            }, 2, null), 0, null, 3, null), null, 1, null);
        }
    }

    public final void w2() {
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (companion.d(this)) {
            FKRxPermissionAlertDialog.Companion companion2 = FKRxPermissionAlertDialog.f12016a;
            xb.b f22 = f2();
            PermissionType permissionType = PermissionType.LocationPermission;
            companion2.g(this, f22, new FKRxPermissionOpenModel(R$string.no_have_location_permission, permissionType, null, r.e(permissionType), false, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$startLocation$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, null, null, null, true, null, null, 3520, null));
            return;
        }
        if (companion.a().f()) {
            e1();
            LocationUtils.o(companion.a(), this, new Function0<p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$startLocation$2
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
                    FeedPublishActivity.this.V0();
                    FeedPublishActivity.this.n2();
                }
            }, new Function2<Integer, String, p>() { // from class: com.cupidapp.live.mediapicker.activity.FeedPublishActivity$startLocation$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, String str) {
                    invoke2(num, str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num, @Nullable String str) {
                    FeedPublishActivity.this.V0();
                }
            }, null, 8, null);
        } else {
            n2();
        }
    }
}

package com.cupidapp.live.base.web.bridge;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.dialog.h;
import com.cupidapp.live.base.web.helper.TencentFaceHelper;
import com.cupidapp.live.base.web.model.FaceInfoModel;
import com.cupidapp.live.base.web.model.ShowWebShareDialogEvent;
import com.cupidapp.live.base.web.model.WebShareModel;
import com.cupidapp.live.chat2.fragment.ChatDetailFragment;
import com.cupidapp.live.chat2.model.MessageBubbleModel;
import com.cupidapp.live.liveshow.activity.FKLiveCloseWebFragmentEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.LiveStickerViewInfoModel;
import com.cupidapp.live.liveshow.view.liveinfo.JoinedFanClubEvent;
import com.cupidapp.live.liveshow.view.miniprofile.FollowActorEvent;
import com.cupidapp.live.liveshow.view.sticker.LiveSelectedStickerEvent;
import com.cupidapp.live.match.model.FilterRcmdMBTIEvent;
import com.cupidapp.live.match.model.FilterRcmdMBTITypeListModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z3.c;

/* compiled from: FKH5CallNativeHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKH5CallNativeHelper {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public WebShareModel f13058a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f13059b;

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class CanOpenAppModel {

        @Nullable
        private final String callback;

        @Nullable
        private final String name;

        public CanOpenAppModel(@Nullable String str, @Nullable String str2) {
            this.name = str;
            this.callback = str2;
        }

        public static /* synthetic */ CanOpenAppModel copy$default(CanOpenAppModel canOpenAppModel, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = canOpenAppModel.name;
            }
            if ((i10 & 2) != 0) {
                str2 = canOpenAppModel.callback;
            }
            return canOpenAppModel.copy(str, str2);
        }

        @Nullable
        public final String component1() {
            return this.name;
        }

        @Nullable
        public final String component2() {
            return this.callback;
        }

        @NotNull
        public final CanOpenAppModel copy(@Nullable String str, @Nullable String str2) {
            return new CanOpenAppModel(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CanOpenAppModel)) {
                return false;
            }
            CanOpenAppModel canOpenAppModel = (CanOpenAppModel) obj;
            return s.d(this.name, canOpenAppModel.name) && s.d(this.callback, canOpenAppModel.callback);
        }

        @Nullable
        public final String getCallback() {
            return this.callback;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            String str = this.name;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.callback;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CanOpenAppModel(name=" + this.name + ", callback=" + this.callback + ")";
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class OpenNobleModel {
        private final int barrageCardCount;

        public OpenNobleModel(int i10) {
            this.barrageCardCount = i10;
        }

        public static /* synthetic */ OpenNobleModel copy$default(OpenNobleModel openNobleModel, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = openNobleModel.barrageCardCount;
            }
            return openNobleModel.copy(i10);
        }

        public final int component1() {
            return this.barrageCardCount;
        }

        @NotNull
        public final OpenNobleModel copy(int i10) {
            return new OpenNobleModel(i10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenNobleModel) && this.barrageCardCount == ((OpenNobleModel) obj).barrageCardCount;
        }

        public final int getBarrageCardCount() {
            return this.barrageCardCount;
        }

        public int hashCode() {
            return this.barrageCardCount;
        }

        @NotNull
        public String toString() {
            return "OpenNobleModel(barrageCardCount=" + this.barrageCardCount + ")";
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ScreenshotShareModel {

        @Nullable
        private final String imgUrl;

        public ScreenshotShareModel(@Nullable String str) {
            this.imgUrl = str;
        }

        public static /* synthetic */ ScreenshotShareModel copy$default(ScreenshotShareModel screenshotShareModel, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = screenshotShareModel.imgUrl;
            }
            return screenshotShareModel.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.imgUrl;
        }

        @NotNull
        public final ScreenshotShareModel copy(@Nullable String str) {
            return new ScreenshotShareModel(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScreenshotShareModel) && s.d(this.imgUrl, ((ScreenshotShareModel) obj).imgUrl);
        }

        @Nullable
        public final String getImgUrl() {
            return this.imgUrl;
        }

        public int hashCode() {
            String str = this.imgUrl;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            return "ScreenshotShareModel(imgUrl=" + this.imgUrl + ")";
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ShowAlertDialogModel {

        @Nullable
        private final String cancelAction;

        @Nullable
        private final String cancelText;

        @Nullable
        private final String confirmAction;

        @Nullable
        private final String confirmText;

        @Nullable
        private final String message;

        @Nullable
        private final String title;

        public ShowAlertDialogModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            this.title = str;
            this.message = str2;
            this.cancelText = str3;
            this.confirmText = str4;
            this.cancelAction = str5;
            this.confirmAction = str6;
        }

        public static /* synthetic */ ShowAlertDialogModel copy$default(ShowAlertDialogModel showAlertDialogModel, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = showAlertDialogModel.title;
            }
            if ((i10 & 2) != 0) {
                str2 = showAlertDialogModel.message;
            }
            String str7 = str2;
            if ((i10 & 4) != 0) {
                str3 = showAlertDialogModel.cancelText;
            }
            String str8 = str3;
            if ((i10 & 8) != 0) {
                str4 = showAlertDialogModel.confirmText;
            }
            String str9 = str4;
            if ((i10 & 16) != 0) {
                str5 = showAlertDialogModel.cancelAction;
            }
            String str10 = str5;
            if ((i10 & 32) != 0) {
                str6 = showAlertDialogModel.confirmAction;
            }
            return showAlertDialogModel.copy(str, str7, str8, str9, str10, str6);
        }

        @Nullable
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final String component2() {
            return this.message;
        }

        @Nullable
        public final String component3() {
            return this.cancelText;
        }

        @Nullable
        public final String component4() {
            return this.confirmText;
        }

        @Nullable
        public final String component5() {
            return this.cancelAction;
        }

        @Nullable
        public final String component6() {
            return this.confirmAction;
        }

        @NotNull
        public final ShowAlertDialogModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            return new ShowAlertDialogModel(str, str2, str3, str4, str5, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowAlertDialogModel)) {
                return false;
            }
            ShowAlertDialogModel showAlertDialogModel = (ShowAlertDialogModel) obj;
            return s.d(this.title, showAlertDialogModel.title) && s.d(this.message, showAlertDialogModel.message) && s.d(this.cancelText, showAlertDialogModel.cancelText) && s.d(this.confirmText, showAlertDialogModel.confirmText) && s.d(this.cancelAction, showAlertDialogModel.cancelAction) && s.d(this.confirmAction, showAlertDialogModel.confirmAction);
        }

        @Nullable
        public final String getCancelAction() {
            return this.cancelAction;
        }

        @Nullable
        public final String getCancelText() {
            return this.cancelText;
        }

        @Nullable
        public final String getConfirmAction() {
            return this.confirmAction;
        }

        @Nullable
        public final String getConfirmText() {
            return this.confirmText;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.cancelText;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.confirmText;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.cancelAction;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.confirmAction;
            return hashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ShowAlertDialogModel(title=" + this.title + ", message=" + this.message + ", cancelText=" + this.cancelText + ", confirmText=" + this.confirmText + ", cancelAction=" + this.cancelAction + ", confirmAction=" + this.confirmAction + ")";
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ShowToastModel {

        @Nullable
        private final String message;

        @Nullable
        private final String style;

        public ShowToastModel(@Nullable String str, @Nullable String str2) {
            this.message = str;
            this.style = str2;
        }

        public static /* synthetic */ ShowToastModel copy$default(ShowToastModel showToastModel, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = showToastModel.message;
            }
            if ((i10 & 2) != 0) {
                str2 = showToastModel.style;
            }
            return showToastModel.copy(str, str2);
        }

        @Nullable
        public final String component1() {
            return this.message;
        }

        @Nullable
        public final String component2() {
            return this.style;
        }

        @NotNull
        public final ShowToastModel copy(@Nullable String str, @Nullable String str2) {
            return new ShowToastModel(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowToastModel)) {
                return false;
            }
            ShowToastModel showToastModel = (ShowToastModel) obj;
            return s.d(this.message, showToastModel.message) && s.d(this.style, showToastModel.style);
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final String getStyle() {
            return this.style;
        }

        public int hashCode() {
            String str = this.message;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.style;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ShowToastModel(message=" + this.message + ", style=" + this.style + ")";
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum ShowToastStyle {
        NO_ICON("text"),
        WARNING("warning"),
        SUCCESS("success");


        @NotNull
        private final String value;

        ShowToastStyle(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class TeenModeModel {
        private final boolean isOpen;

        public TeenModeModel(boolean z10) {
            this.isOpen = z10;
        }

        public static /* synthetic */ TeenModeModel copy$default(TeenModeModel teenModeModel, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = teenModeModel.isOpen;
            }
            return teenModeModel.copy(z10);
        }

        public final boolean component1() {
            return this.isOpen;
        }

        @NotNull
        public final TeenModeModel copy(boolean z10) {
            return new TeenModeModel(z10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TeenModeModel) && this.isOpen == ((TeenModeModel) obj).isOpen;
        }

        public int hashCode() {
            boolean z10 = this.isOpen;
            if (z10) {
                return 1;
            }
            return z10 ? 1 : 0;
        }

        public final boolean isOpen() {
            return this.isOpen;
        }

        @NotNull
        public String toString() {
            return "TeenModeModel(isOpen=" + this.isOpen + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:3:0x0029, B:5:0x0032, B:7:0x003a, B:9:0x0047, B:11:0x004d, B:13:0x0055, B:18:0x0061, B:20:0x006e, B:21:0x0072), top: B:2:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(boolean r4, kotlin.jvm.internal.Ref$ObjectRef r5) {
        /*
            java.lang.String r0 = "$model"
            kotlin.jvm.internal.s.i(r5, r0)
            com.cupidapp.live.base.utils.j$a r0 = com.cupidapp.live.base.utils.j.f12332a
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "canOpenApp  installed:"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = "  currentThread:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "FKH5CallNativeHelper"
            r0.a(r2, r1)
            com.cupidapp.live.base.activity.a$a r0 = com.cupidapp.live.base.activity.a.f11763c     // Catch: java.lang.Exception -> L8c
            java.lang.ref.WeakReference r0 = r0.a()     // Catch: java.lang.Exception -> L8c
            r1 = 0
            if (r0 == 0) goto L44
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L8c
            android.app.Activity r0 = (android.app.Activity) r0     // Catch: java.lang.Exception -> L8c
            if (r0 == 0) goto L44
            r2 = 2131362098(0x7f0a0132, float:1.8343967E38)
            android.view.View r0 = r0.findViewById(r2)     // Catch: java.lang.Exception -> L8c
            com.cupidapp.live.base.web.FKWebView r0 = (com.cupidapp.live.base.web.FKWebView) r0     // Catch: java.lang.Exception -> L8c
            goto L45
        L44:
            r0 = r1
        L45:
            if (r0 == 0) goto L90
            T r2 = r5.element     // Catch: java.lang.Exception -> L8c
            com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$CanOpenAppModel r2 = (com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.CanOpenAppModel) r2     // Catch: java.lang.Exception -> L8c
            if (r2 == 0) goto L52
            java.lang.String r2 = r2.getCallback()     // Catch: java.lang.Exception -> L8c
            goto L53
        L52:
            r2 = r1
        L53:
            if (r2 == 0) goto L5e
            int r2 = r2.length()     // Catch: java.lang.Exception -> L8c
            if (r2 != 0) goto L5c
            goto L5e
        L5c:
            r2 = 0
            goto L5f
        L5e:
            r2 = 1
        L5f:
            if (r2 != 0) goto L90
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8c
            r2.<init>()     // Catch: java.lang.Exception -> L8c
            java.lang.String r3 = "event"
            T r5 = r5.element     // Catch: java.lang.Exception -> L8c
            com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$CanOpenAppModel r5 = (com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.CanOpenAppModel) r5     // Catch: java.lang.Exception -> L8c
            if (r5 == 0) goto L72
            java.lang.String r1 = r5.getCallback()     // Catch: java.lang.Exception -> L8c
        L72:
            r2.put(r3, r1)     // Catch: java.lang.Exception -> L8c
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8c
            r5.<init>()     // Catch: java.lang.Exception -> L8c
            java.lang.String r1 = "canOpen"
            r5.put(r1, r4)     // Catch: java.lang.Exception -> L8c
            java.lang.String r4 = "params"
            r2.put(r4, r5)     // Catch: java.lang.Exception -> L8c
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Exception -> L8c
            r0.x(r4)     // Catch: java.lang.Exception -> L8c
            goto L90
        L8c:
            r4 = move-exception
            r4.printStackTrace()
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.b(boolean, kotlin.jvm.internal.Ref$ObjectRef):void");
    }

    public final void c() {
        this.f13058a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, java.lang.Object] */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void canOpenApp(@org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            r6 = this;
            com.cupidapp.live.base.utils.j$a r0 = com.cupidapp.live.base.utils.j.f12332a
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "canOpenApp  data:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = "  currentThread:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "FKH5CallNativeHelper"
            r0.a(r2, r1)
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L31
            int r2 = r7.length()
            if (r2 != 0) goto L2f
            goto L31
        L2f:
            r2 = 0
            goto L32
        L31:
            r2 = 1
        L32:
            if (r2 == 0) goto L35
            return
        L35:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r3 = 0
            com.cupidapp.live.base.network.gson.GsonUtil r4 = com.cupidapp.live.base.network.gson.GsonUtil.f12000a     // Catch: java.lang.Exception -> L71
            com.google.gson.Gson r4 = r4.b()     // Catch: java.lang.Exception -> L71
            java.lang.Class<com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$CanOpenAppModel> r5 = com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.CanOpenAppModel.class
            java.lang.Object r7 = r4.fromJson(r7, r5)     // Catch: java.lang.Exception -> L71
            r2.element = r7     // Catch: java.lang.Exception -> L71
            com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$CanOpenAppModel r7 = (com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.CanOpenAppModel) r7     // Catch: java.lang.Exception -> L71
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Exception -> L71
            if (r7 == 0) goto L5a
            int r4 = r7.length()     // Catch: java.lang.Exception -> L71
            if (r4 != 0) goto L58
            goto L5a
        L58:
            r4 = 0
            goto L5b
        L5a:
            r4 = 1
        L5b:
            if (r4 != 0) goto L75
            com.cupidapp.live.AppApplication$a r4 = com.cupidapp.live.AppApplication.f11612d     // Catch: java.lang.Exception -> L71
            android.content.Context r4 = r4.c()     // Catch: java.lang.Exception -> L71
            if (r4 == 0) goto L75
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Exception -> L71
            if (r4 == 0) goto L75
            android.content.pm.PackageInfo r7 = r4.getPackageInfo(r7, r1)     // Catch: java.lang.Exception -> L71
            r3 = r7
            goto L75
        L71:
            r7 = move-exception
            r7.printStackTrace()
        L75:
            if (r3 == 0) goto L78
            goto L79
        L78:
            r0 = 0
        L79:
            com.cupidapp.live.AppApplication$a r7 = com.cupidapp.live.AppApplication.f11612d
            com.cupidapp.live.AppApplication r7 = r7.h()
            android.os.Handler r7 = r7.j()
            com.cupidapp.live.base.web.bridge.a r1 = new com.cupidapp.live.base.web.bridge.a
            r1.<init>()
            r7.post(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.canOpenApp(java.lang.String):void");
    }

    public final void d() {
        this.f13059b = null;
    }

    @Nullable
    public final String e() {
        return this.f13059b;
    }

    @Nullable
    public final WebShareModel f() {
        return this.f13058a;
    }

    @JavascriptInterface
    public final void faceVerify(@Nullable String str) {
        j.f12332a.a("FKH5CallNativeHelper", "faceVerify  data:" + str);
        Disposable disposed = NetworkClient.f11868a.N().G().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FaceInfoModel, p>() { // from class: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$faceVerify$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FaceInfoModel faceInfoModel) {
                m2477invoke(faceInfoModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2477invoke(FaceInfoModel faceInfoModel) {
                TencentFaceHelper.f13090a.c(faceInfoModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void g(String str) {
        j.f12332a.a("FKH5CallNativeHelper", "msg:" + str);
    }

    @JavascriptInterface
    public final void getShareDetail(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            WebShareModel webShareModel = (WebShareModel) GsonUtil.f12000a.b().fromJson(str, WebShareModel.class);
            this.f13058a = webShareModel;
            j.f12332a.a("FKH5CallNativeHelper", "getShareDetail data:" + str + "  webShareModel:" + ((Object) webShareModel));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void hideLoading() {
        h.f12743a.b();
    }

    @JavascriptInterface
    public final void likeUserTrack(@Nullable String str) {
        g("likeUserTrack data:" + str);
        if (str == null || str.length() == 0) {
            return;
        }
        LikeUserTrackModel likeUserTrackModel = null;
        try {
            likeUserTrackModel = (LikeUserTrackModel) GsonUtil.f12000a.b().fromJson(str, LikeUserTrackModel.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (likeUserTrackModel == null) {
            return;
        }
        c.f54829a.B(PostAndSocialProtos.Event.MATCH_PAGE_LIKE, (r137 & 2) != 0 ? null : null, (r137 & 4) != 0 ? null : null, (r137 & 8) != 0 ? null : likeUserTrackModel.getUserId(), (r137 & 16) != 0 ? null : likeUserTrackModel.isMatched(), (r137 & 32) != 0 ? null : null, (r137 & 64) != 0 ? null : null, (r137 & 128) != 0 ? null : null, (r137 & 256) != 0 ? null : likeUserTrackModel.getScene(), (r137 & 512) != 0 ? null : likeUserTrackModel.getPosition(), (r137 & 1024) != 0 ? null : null, (r137 & 2048) != 0 ? null : null, (r137 & 4096) != 0 ? null : null, (r137 & 8192) != 0 ? null : null, (r137 & 16384) != 0 ? null : null, (r137 & 32768) != 0 ? null : null, (r137 & 65536) != 0 ? null : null, (r137 & 131072) != 0 ? null : null, (r137 & 262144) != 0 ? null : null, (r137 & 524288) != 0 ? null : null, (r137 & 1048576) != 0 ? null : null, (r137 & 2097152) != 0 ? null : likeUserTrackModel.isRecommend(), (r137 & 4194304) != 0 ? null : null, (r137 & 8388608) != 0 ? null : null, (r137 & 16777216) != 0 ? null : null, (r137 & 33554432) != 0 ? null : null, (r137 & 67108864) != 0 ? null : null, (r137 & 134217728) != 0 ? null : null, (r137 & 268435456) != 0 ? null : null, (r137 & 536870912) != 0 ? null : null, (r137 & 1073741824) != 0 ? null : null, (r137 & Integer.MIN_VALUE) != 0 ? null : null, (r138 & 1) != 0 ? null : null, (r138 & 2) != 0 ? null : null, (r138 & 4) != 0 ? null : null, (r138 & 8) != 0 ? null : null, (r138 & 16) != 0 ? null : null, (r138 & 32) != 0 ? null : null, (r138 & 64) != 0 ? null : null, (r138 & 128) != 0 ? false : false, (r138 & 256) != 0 ? null : null, (r138 & 512) != 0 ? null : null, (r138 & 1024) != 0 ? null : null, (r138 & 2048) != 0 ? null : null, (r138 & 4096) != 0 ? null : null, (r138 & 8192) != 0 ? null : null, (r138 & 16384) != 0 ? null : null, (r138 & 32768) != 0 ? null : null, (r138 & 65536) != 0 ? null : null, (r138 & 131072) != 0 ? null : null, (r138 & 262144) != 0 ? null : null, (r138 & 524288) != 0 ? null : null, (r138 & 1048576) != 0 ? null : null, (r138 & 2097152) != 0 ? null : null, (r138 & 4194304) != 0 ? null : null, (r138 & 8388608) != 0 ? null : null, (r138 & 16777216) != 0 ? null : null, (r138 & 33554432) != 0 ? null : null, (r138 & 67108864) != 0 ? null : null, (r138 & 134217728) != 0 ? null : null, (r138 & 268435456) != 0 ? null : null, (r138 & 536870912) != 0 ? null : null, (r138 & 1073741824) != 0 ? null : null, (r138 & Integer.MIN_VALUE) != 0 ? null : null, (r139 & 1) != 0 ? null : null, (r139 & 2) != 0 ? null : null, (r139 & 4) != 0 ? null : null, (r139 & 8) != 0 ? null : null, (r139 & 16) != 0 ? null : null);
    }

    @JavascriptInterface
    public final void liveShowActivatedNoble(@Nullable String str) {
        try {
            OpenNobleModel openNobleModel = (OpenNobleModel) GsonUtil.f12000a.b().fromJson(str, OpenNobleModel.class);
            LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
            if (fkLiveShowResult == null) {
                return;
            }
            fkLiveShowResult.setBarrageCardCount(openNobleModel.getBarrageCardCount());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void liveShowJoinedFansGroup(@Nullable String str) {
        try {
            EventBus.c().l(new JoinedFanClubEvent(FanClubStatus.HasJoined));
            j.f12332a.a("FKH5CallNativeHelper", "liveShowJoinedFansGroup data: " + str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void liveShowLikedAnchor(@Nullable String str) {
        try {
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel != null) {
                liveShowModel.getUser().setAloha(true);
                EventBus.c().l(new FollowActorEvent(liveShowModel.getUser()));
            }
            j.f12332a.a("FKH5CallNativeHelper", "liveShowLikedAnchor data: " + str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012 A[Catch: Exception -> 0x000b, TryCatch #0 {Exception -> 0x000b, blocks: (B:15:0x0002, B:5:0x0020, B:13:0x0012), top: B:14:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void liveShowOpenGift(@org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Ld
            int r0 = r5.length()     // Catch: java.lang.Exception -> Lb
            if (r0 != 0) goto L9
            goto Ld
        L9:
            r0 = 0
            goto Le
        Lb:
            r5 = move-exception
            goto L40
        Ld:
            r0 = 1
        Le:
            if (r0 == 0) goto L12
            r0 = 0
            goto L20
        L12:
            com.cupidapp.live.base.network.gson.GsonUtil r0 = com.cupidapp.live.base.network.gson.GsonUtil.f12000a     // Catch: java.lang.Exception -> Lb
            com.google.gson.Gson r0 = r0.b()     // Catch: java.lang.Exception -> Lb
            java.lang.Class<com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent> r1 = com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent.class
            java.lang.Object r0 = r0.fromJson(r5, r1)     // Catch: java.lang.Exception -> Lb
            com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent r0 = (com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent) r0     // Catch: java.lang.Exception -> Lb
        L20:
            org.greenrobot.eventbus.EventBus r1 = org.greenrobot.eventbus.EventBus.c()     // Catch: java.lang.Exception -> Lb
            r1.l(r0)     // Catch: java.lang.Exception -> Lb
            com.cupidapp.live.base.utils.j$a r0 = com.cupidapp.live.base.utils.j.f12332a     // Catch: java.lang.Exception -> Lb
            java.lang.String r1 = "FKH5CallNativeHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb
            r2.<init>()     // Catch: java.lang.Exception -> Lb
            java.lang.String r3 = "liveShowOpenGift data: "
            r2.append(r3)     // Catch: java.lang.Exception -> Lb
            r2.append(r5)     // Catch: java.lang.Exception -> Lb
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> Lb
            r0.a(r1, r5)     // Catch: java.lang.Exception -> Lb
            goto L43
        L40:
            r5.printStackTrace()
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper.liveShowOpenGift(java.lang.String):void");
    }

    @JavascriptInterface
    public final void liveShowSelectedSticker(@Nullable String str) {
        try {
            LiveStickerViewInfoModel model = (LiveStickerViewInfoModel) GsonUtil.f12000a.b().fromJson(str, LiveStickerViewInfoModel.class);
            EventBus c4 = EventBus.c();
            s.h(model, "model");
            c4.l(new LiveSelectedStickerEvent(model));
            EventBus.c().l(new FKLiveCloseWebFragmentEvent());
            j.f12332a.a("FKH5CallNativeHelper", "liveShowSelectedSticker data:" + str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void mbtiSuccessCallback(@Nullable String str) {
        try {
            FilterRcmdMBTITypeListModel model = (FilterRcmdMBTITypeListModel) GsonUtil.f12000a.b().fromJson(str, FilterRcmdMBTITypeListModel.class);
            EventBus c4 = EventBus.c();
            s.h(model, "model");
            c4.o(new FilterRcmdMBTIEvent(model));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void savedMessageBubble(@Nullable String str) {
        j.f12332a.a("FKH5CallNativeHelper", "savedMessageBubble  data:" + str);
        Disposable disposed = NetworkClient.f11868a.h().l().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MessageBubbleModel, p>() { // from class: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$savedMessageBubble$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MessageBubbleModel messageBubbleModel) {
                m2478invoke(messageBubbleModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2478invoke(MessageBubbleModel messageBubbleModel) {
                ChatDetailFragment.a aVar = ChatDetailFragment.f13305o;
                aVar.d(true);
                aVar.e(messageBubbleModel);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @JavascriptInterface
    public final void screenshotShareData(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String imgUrl = ((ScreenshotShareModel) GsonUtil.f12000a.b().fromJson(str, ScreenshotShareModel.class)).getImgUrl();
            this.f13059b = imgUrl;
            j.f12332a.a("FKH5CallNativeHelper", "screenshotShareData size:" + ((Object) (imgUrl != null ? Integer.valueOf(imgUrl.length()) : null)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void setTeenMode(@Nullable String str) {
        try {
            TeenModeModel teenModeModel = (TeenModeModel) GsonUtil.f12000a.b().fromJson(str, TeenModeModel.class);
            g.f52734a.I3(Boolean.valueOf(teenModeModel.isOpen()));
            GroupLiveLog.f18698a.O(teenModeModel.isOpen());
            EventBus.c().o(teenModeModel);
            j.f12332a.a("FKH5CallNativeHelper", "setTeenMode  data:" + str + " isOpen: " + teenModeModel.isOpen());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void share(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            WebShareModel shareModel = (WebShareModel) GsonUtil.f12000a.b().fromJson(str, WebShareModel.class);
            EventBus c4 = EventBus.c();
            s.h(shareModel, "shareModel");
            c4.l(new ShowWebShareDialogEvent(shareModel));
            j.f12332a.a("FKH5CallNativeHelper", "share data: " + str + " shareModel: " + ((Object) shareModel));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void showAlert(@Nullable String str) {
        final ShowAlertDialogModel showAlertDialogModel;
        g("showAlert data:" + str);
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            showAlertDialogModel = (ShowAlertDialogModel) GsonUtil.f12000a.b().fromJson(str, ShowAlertDialogModel.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            showAlertDialogModel = null;
        }
        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
        final Activity activity = a10 != null ? a10.get() : null;
        if (showAlertDialogModel != null) {
            String title = showAlertDialogModel.getTitle();
            if (title == null || title.length() == 0) {
                return;
            }
            String message = showAlertDialogModel.getMessage();
            if ((message == null || message.length() == 0) || activity == null) {
                return;
            }
            FKAlertDialog.G(FKAlertDialog.y(FKAlertDialog.a.c(FKAlertDialog.f12698l, activity, false, 2, null).E(showAlertDialogModel.getTitle()).n(showAlertDialogModel.getMessage()).s(showAlertDialogModel.getCancelText(), new Function0<p>() { // from class: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$showAlert$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    b.f13062a.d(activity, showAlertDialogModel.getCancelAction(), null);
                }
            }), showAlertDialogModel.getConfirmText(), null, new Function0<p>() { // from class: com.cupidapp.live.base.web.bridge.FKH5CallNativeHelper$showAlert$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    b.f13062a.d(activity, showAlertDialogModel.getConfirmAction(), null);
                }
            }, 2, null), null, 1, null);
        }
    }

    @JavascriptInterface
    public final void showLoading() {
        h.d(h.f12743a, null, false, 3, null);
    }

    @JavascriptInterface
    public final void showToast(@Nullable String str) {
        g("showToast data:" + str);
        if (str == null || str.length() == 0) {
            return;
        }
        ShowToastModel showToastModel = null;
        try {
            showToastModel = (ShowToastModel) GsonUtil.f12000a.b().fromJson(str, ShowToastModel.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (showToastModel != null) {
            String message = showToastModel.getMessage();
            if (message == null || message.length() == 0) {
                return;
            }
            String style = showToastModel.getStyle();
            if (style == null || style.length() == 0) {
                return;
            }
            String style2 = showToastModel.getStyle();
            if (s.d(style2, ShowToastStyle.NO_ICON.getValue())) {
                com.cupidapp.live.base.view.h.f12779a.n(showToastModel.getMessage());
            } else if (s.d(style2, ShowToastStyle.WARNING.getValue())) {
                com.cupidapp.live.base.view.h.f12779a.t(showToastModel.getMessage());
            } else if (s.d(style2, ShowToastStyle.SUCCESS.getValue())) {
                com.cupidapp.live.base.view.h.f12779a.e(showToastModel.getMessage());
            }
        }
    }

    /* compiled from: FKH5CallNativeHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class LikeUserTrackModel {

        @Nullable
        private final Boolean isMatched;

        @Nullable
        private final Boolean isRecommend;

        @Nullable
        private final String position;

        @Nullable
        private final String scene;

        @Nullable
        private final String userId;

        public LikeUserTrackModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable Boolean bool2) {
            this.scene = str;
            this.position = str2;
            this.userId = str3;
            this.isMatched = bool;
            this.isRecommend = bool2;
        }

        public static /* synthetic */ LikeUserTrackModel copy$default(LikeUserTrackModel likeUserTrackModel, String str, String str2, String str3, Boolean bool, Boolean bool2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = likeUserTrackModel.scene;
            }
            if ((i10 & 2) != 0) {
                str2 = likeUserTrackModel.position;
            }
            String str4 = str2;
            if ((i10 & 4) != 0) {
                str3 = likeUserTrackModel.userId;
            }
            String str5 = str3;
            if ((i10 & 8) != 0) {
                bool = likeUserTrackModel.isMatched;
            }
            Boolean bool3 = bool;
            if ((i10 & 16) != 0) {
                bool2 = likeUserTrackModel.isRecommend;
            }
            return likeUserTrackModel.copy(str, str4, str5, bool3, bool2);
        }

        @Nullable
        public final String component1() {
            return this.scene;
        }

        @Nullable
        public final String component2() {
            return this.position;
        }

        @Nullable
        public final String component3() {
            return this.userId;
        }

        @Nullable
        public final Boolean component4() {
            return this.isMatched;
        }

        @Nullable
        public final Boolean component5() {
            return this.isRecommend;
        }

        @NotNull
        public final LikeUserTrackModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable Boolean bool2) {
            return new LikeUserTrackModel(str, str2, str3, bool, bool2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LikeUserTrackModel)) {
                return false;
            }
            LikeUserTrackModel likeUserTrackModel = (LikeUserTrackModel) obj;
            return s.d(this.scene, likeUserTrackModel.scene) && s.d(this.position, likeUserTrackModel.position) && s.d(this.userId, likeUserTrackModel.userId) && s.d(this.isMatched, likeUserTrackModel.isMatched) && s.d(this.isRecommend, likeUserTrackModel.isRecommend);
        }

        @Nullable
        public final String getPosition() {
            return this.position;
        }

        @Nullable
        public final String getScene() {
            return this.scene;
        }

        @Nullable
        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            String str = this.scene;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.position;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.userId;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isMatched;
            int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isRecommend;
            return hashCode4 + (bool2 != null ? bool2.hashCode() : 0);
        }

        @Nullable
        public final Boolean isMatched() {
            return this.isMatched;
        }

        @Nullable
        public final Boolean isRecommend() {
            return this.isRecommend;
        }

        @NotNull
        public String toString() {
            return "LikeUserTrackModel(scene=" + this.scene + ", position=" + this.position + ", userId=" + this.userId + ", isMatched=" + ((Object) this.isMatched) + ", isRecommend=" + ((Object) this.isRecommend) + ")";
        }

        public /* synthetic */ LikeUserTrackModel(String str, String str2, String str3, Boolean bool, Boolean bool2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, bool, (i10 & 16) != 0 ? Boolean.FALSE : bool2);
        }
    }
}

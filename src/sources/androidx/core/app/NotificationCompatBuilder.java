package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private final Bundle mExtras = new Bundle();

    @RequiresApi(16)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static Notification build(Notification.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        public static Notification.Builder setPriority(Notification.Builder builder, int i10) {
            return builder.setPriority(i10);
        }

        @DoNotInline
        public static Notification.Builder setSubText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        @DoNotInline
        public static Notification.Builder setUsesChronometer(Notification.Builder builder, boolean z10) {
            return builder.setUsesChronometer(z10);
        }
    }

    @RequiresApi(17)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static Notification.Builder setShowWhen(Notification.Builder builder, boolean z10) {
            return builder.setShowWhen(z10);
        }
    }

    @RequiresApi(19)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static Notification.Builder setExtras(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    @RequiresApi(20)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        public static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @DoNotInline
        public static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @DoNotInline
        public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @DoNotInline
        public static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        public static Notification.Action.Builder createBuilder(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i10, charSequence, pendingIntent);
        }

        @DoNotInline
        public static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        public static Notification.Builder setGroup(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @DoNotInline
        public static Notification.Builder setGroupSummary(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        @DoNotInline
        public static Notification.Builder setLocalOnly(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        @DoNotInline
        public static Notification.Builder setSortKey(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    @RequiresApi(21)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Notification.Builder addPerson(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @DoNotInline
        public static Notification.Builder setCategory(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @DoNotInline
        public static Notification.Builder setColor(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        @DoNotInline
        public static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @DoNotInline
        public static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        @DoNotInline
        public static Notification.Builder setVisibility(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    @RequiresApi(23)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @DoNotInline
        public static Notification.Builder setSmallIcon(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    @RequiresApi(24)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        @DoNotInline
        public static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @DoNotInline
        public static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @DoNotInline
        public static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @DoNotInline
        public static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    @RequiresApi(26)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Notification.Builder createBuilder(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        @DoNotInline
        public static Notification.Builder setBadgeIconType(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        @DoNotInline
        public static Notification.Builder setColorized(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        @DoNotInline
        public static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        @DoNotInline
        public static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @DoNotInline
        public static Notification.Builder setShortcutId(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @DoNotInline
        public static Notification.Builder setTimeoutAfter(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    @RequiresApi(28)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Notification.Builder addPerson(Notification.Builder builder, android.app.Person person) {
            return builder.addPerson(person);
        }

        @DoNotInline
        public static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    @RequiresApi(29)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        @DoNotInline
        public static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @DoNotInline
        public static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }

        @DoNotInline
        public static Notification.Builder setLocusId(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    @RequiresApi(31)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        @DoNotInline
        public static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        List list;
        int i10;
        Object obj;
        this.mBuilderCompat = builder;
        Context context = builder.mContext;
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder = Api26Impl.createBuilder(context, builder.mChannelId);
        } else {
            this.mBuilder = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.mNotification;
        this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.mFullScreenIntent, (notification.flags & 128) != 0).setLargeIcon(builder.mLargeIcon).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        Api16Impl.setPriority(Api16Impl.setUsesChronometer(Api16Impl.setSubText(this.mBuilder, builder.mSubText), builder.mUseChronometer), builder.mPriority);
        Iterator<NotificationCompat.Action> iterator2 = builder.mActions.iterator2();
        while (iterator2.hasNext()) {
            addAction(iterator2.next());
        }
        Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        Api17Impl.setShowWhen(this.mBuilder, builder.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, builder.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, builder.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, builder.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, builder.mGroupSummary);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, builder.mCategory);
        Api21Impl.setColor(this.mBuilder, builder.mColor);
        Api21Impl.setVisibility(this.mBuilder, builder.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, builder.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, notification.sound, notification.audioAttributes);
        if (i11 < 28) {
            list = combineLists(getPeople(builder.mPersonList), builder.mPeople);
        } else {
            list = builder.mPeople;
        }
        if (list != null && !list.isEmpty()) {
            Iterator iterator22 = list.iterator2();
            while (iterator22.hasNext()) {
                Api21Impl.addPerson(this.mBuilder, (String) iterator22.next());
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = builder.getExtras().getBundle(NotificationCompat.CarExtender.EXTRA_CAR_EXTENDER);
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < builder.mInvisibleActions.size(); i12++) {
                bundle4.putBundle(Integer.toString(i12), NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i12)));
            }
            bundle2.putBundle(NotificationCompat.CarExtender.EXTRA_INVISIBLE_ACTIONS, bundle4);
            bundle3.putBundle(NotificationCompat.CarExtender.EXTRA_INVISIBLE_ACTIONS, bundle4);
            builder.getExtras().putBundle(NotificationCompat.CarExtender.EXTRA_CAR_EXTENDER, bundle2);
            this.mExtras.putBundle(NotificationCompat.CarExtender.EXTRA_CAR_EXTENDER, bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 23 && (obj = builder.mSmallIcon) != null) {
            Api23Impl.setSmallIcon(this.mBuilder, obj);
        }
        if (i13 >= 24) {
            Api19Impl.setExtras(this.mBuilder, builder.mExtras);
            Api24Impl.setRemoteInputHistory(this.mBuilder, builder.mRemoteInputHistory);
            RemoteViews remoteViews = builder.mContentView;
            if (remoteViews != null) {
                Api24Impl.setCustomContentView(this.mBuilder, remoteViews);
            }
            RemoteViews remoteViews2 = builder.mBigContentView;
            if (remoteViews2 != null) {
                Api24Impl.setCustomBigContentView(this.mBuilder, remoteViews2);
            }
            RemoteViews remoteViews3 = builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                Api24Impl.setCustomHeadsUpContentView(this.mBuilder, remoteViews3);
            }
        }
        if (i13 >= 26) {
            Api26Impl.setBadgeIconType(this.mBuilder, builder.mBadgeIcon);
            Api26Impl.setSettingsText(this.mBuilder, builder.mSettingsText);
            Api26Impl.setShortcutId(this.mBuilder, builder.mShortcutId);
            Api26Impl.setTimeoutAfter(this.mBuilder, builder.mTimeout);
            Api26Impl.setGroupAlertBehavior(this.mBuilder, builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                Api26Impl.setColorized(this.mBuilder, builder.mColorized);
            }
            if (!TextUtils.isEmpty(builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i13 >= 28) {
            Iterator<Person> iterator23 = builder.mPersonList.iterator2();
            while (iterator23.hasNext()) {
                Api28Impl.addPerson(this.mBuilder, iterator23.next().toAndroidPerson());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, builder.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            LocusIdCompat locusIdCompat = builder.mLocusId;
            if (locusIdCompat != null) {
                Api29Impl.setLocusId(this.mBuilder, locusIdCompat.toLocusId());
            }
        }
        if (i14 >= 31 && (i10 = builder.mFgsDeferBehavior) != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, i10);
        }
        if (builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            int i15 = notification.defaults & (-2) & (-3);
            notification.defaults = i15;
            this.mBuilder.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
                }
                Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(NotificationCompat.Action action) {
        Notification.Action.Builder createBuilder;
        Bundle bundle;
        int i10 = Build.VERSION.SDK_INT;
        IconCompat iconCompat = action.getIconCompat();
        if (i10 >= 23) {
            createBuilder = Api23Impl.createBuilder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent());
        } else {
            createBuilder = Api20Impl.createBuilder(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        }
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(action.getRemoteInputs())) {
                Api20Impl.addRemoteInput(createBuilder, remoteInput);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean(NotificationCompatJellybean.EXTRA_ALLOW_GENERATED_REPLIES, action.getAllowGeneratedReplies());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            Api24Impl.setAllowGeneratedReplies(createBuilder, action.getAllowGeneratedReplies());
        }
        bundle.putInt(NotificationCompat.Action.EXTRA_SEMANTIC_ACTION, action.getSemanticAction());
        if (i11 >= 28) {
            Api28Impl.setSemanticAction(createBuilder, action.getSemanticAction());
        }
        if (i11 >= 29) {
            Api29Impl.setContextual(createBuilder, action.isContextual());
        }
        if (i11 >= 31) {
            Api31Impl.setAuthenticationRequired(createBuilder, action.isAuthenticationRequired());
        }
        bundle.putBoolean(NotificationCompat.Action.EXTRA_SHOWS_USER_INTERFACE, action.getShowsUserInterface());
        Api20Impl.addExtras(createBuilder, bundle);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(createBuilder));
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Person> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    public Notification build() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification buildInternal = buildInternal();
        if (makeContentView != null) {
            buildInternal.contentView = makeContentView;
        } else {
            RemoteViews remoteViews = this.mBuilderCompat.mContentView;
            if (remoteViews != null) {
                buildInternal.contentView = remoteViews;
            }
        }
        if (style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            buildInternal.bigContentView = makeBigContentView;
        }
        if (style != null && (makeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            buildInternal.headsUpContentView = makeHeadsUpContentView;
        }
        if (style != null && (extras = NotificationCompat.getExtras(buildInternal)) != null) {
            style.addCompatExtras(extras);
        }
        return buildInternal;
    }

    public Notification buildInternal() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return Api16Impl.build(this.mBuilder);
        }
        if (i10 >= 24) {
            Notification build = Api16Impl.build(this.mBuilder);
            if (this.mGroupAlertBehavior != 0) {
                if (Api20Impl.getGroup(build) != null && (build.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                    removeSoundAndVibration(build);
                }
                if (Api20Impl.getGroup(build) != null && (build.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(build);
                }
            }
            return build;
        }
        Api19Impl.setExtras(this.mBuilder, this.mExtras);
        Notification build2 = Api16Impl.build(this.mBuilder);
        RemoteViews remoteViews = this.mContentView;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.mBigContentView;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.mHeadsUpContentView;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.mGroupAlertBehavior != 0) {
            if (Api20Impl.getGroup(build2) != null && (build2.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                removeSoundAndVibration(build2);
            }
            if (Api20Impl.getGroup(build2) != null && (build2.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                removeSoundAndVibration(build2);
            }
        }
        return build2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    public Context getContext() {
        return this.mContext;
    }
}

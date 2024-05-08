package android.widget;

import android.app.ActivityOptions;
import android.app.ActivityThread;
import android.app.Application;
import android.app.LoadedApk;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.StrictMode;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.system.Os;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.IntArray;
import android.util.Log;
import android.util.LongArray;
import android.util.Pair;
import android.util.SizeF;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter;
import com.android.internal.R;
import com.android.internal.util.ContrastColorUtil;
import com.android.internal.util.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RemoteViews implements Parcelable, LayoutInflater.Filter {
    private static final int ATTRIBUTE_REFLECTION_ACTION_TAG = 32;
    private static final int BITMAP_REFLECTION_ACTION_TAG = 12;
    private static final int COMPLEX_UNIT_DIMENSION_REFLECTION_ACTION_TAG = 25;
    private static final int DEBUG_LOG_INTERVAL = 100;
    public static final String EXTRA_CHECKED = "android.widget.extra.CHECKED";
    static final String EXTRA_REMOTEADAPTER_APPWIDGET_ID = "remoteAdapterAppWidgetId";
    static final String EXTRA_REMOTEADAPTER_ON_LIGHT_BACKGROUND = "remoteAdapterOnLightBackground";
    public static final String EXTRA_SHARED_ELEMENT_BOUNDS = "android.widget.extra.SHARED_ELEMENT_BOUNDS";
    static final int FLAG_MASK_TO_PROPAGATE = 6;
    public static final int FLAG_REAPPLY_DISALLOWED = 1;
    public static final int FLAG_USE_LIGHT_BACKGROUND_LAYOUT = 4;
    public static final int FLAG_WIDGET_IS_COLLECTION_CHILD = 2;
    private static final int LAYOUT_PARAM_ACTION_TAG = 19;
    private static final String LOG_TAG = "RemoteViews";
    public static final int MARGIN_BOTTOM = 3;
    public static final int MARGIN_END = 5;
    public static final int MARGIN_LEFT = 0;
    public static final int MARGIN_RIGHT = 2;
    public static final int MARGIN_START = 4;
    public static final int MARGIN_TOP = 1;
    private static final int MAX_INIT_VIEW_COUNT = 16;
    private static final int MAX_NESTED_VIEWS = 10;
    private static final int MODE_HAS_LANDSCAPE_AND_PORTRAIT = 1;
    private static final int MODE_HAS_SIZED_REMOTEVIEWS = 2;
    private static final int MODE_NORMAL = 0;
    private static final int NIGHT_MODE_REFLECTION_ACTION_TAG = 30;
    private static final int OVERRIDE_TEXT_COLORS_TAG = 20;
    private static final int REFLECTION_ACTION_TAG = 2;
    private static final int REMOVE_FROM_PARENT_ACTION_TAG = 23;
    private static final int RESOURCE_REFLECTION_ACTION_TAG = 24;
    private static final int SET_COMPOUND_BUTTON_CHECKED_TAG = 26;
    private static final int SET_DRAWABLE_TINT_TAG = 3;
    private static final int SET_EMPTY_VIEW_ACTION_TAG = 6;
    private static final int SET_INT_TAG_TAG = 22;
    private static final int SET_ON_CHECKED_CHANGE_RESPONSE_TAG = 29;
    private static final int SET_ON_CLICK_RESPONSE_TAG = 1;
    private static final int SET_PENDING_INTENT_TEMPLATE_TAG = 8;
    private static final int SET_RADIO_GROUP_CHECKED = 27;
    private static final int SET_REMOTE_COLLECTION_ITEMS_ADAPTER_TAG = 31;
    private static final int SET_REMOTE_INPUTS_ACTION_TAG = 18;
    private static final int SET_REMOTE_VIEW_ADAPTER_INTENT_TAG = 10;
    private static final int SET_REMOTE_VIEW_ADAPTER_LIST_TAG = 15;
    private static final int SET_RIPPLE_DRAWABLE_COLOR_TAG = 21;
    private static final int SET_VIEW_OUTLINE_RADIUS_TAG = 28;
    private static final int TEXT_VIEW_DRAWABLE_ACTION_TAG = 11;
    private static final int TEXT_VIEW_SIZE_ACTION_TAG = 13;
    static final int VALUE_TYPE_ATTRIBUTE = 4;
    static final int VALUE_TYPE_COMPLEX_UNIT = 2;
    static final int VALUE_TYPE_RAW = 1;
    static final int VALUE_TYPE_RESOURCE = 3;
    private static final int VIEW_CONTENT_NAVIGATION_TAG = 5;
    private static final int VIEW_GROUP_ACTION_ADD_TAG = 4;
    private static final int VIEW_GROUP_ACTION_REMOVE_TAG = 7;
    private static final int VIEW_PADDING_ACTION_TAG = 14;
    private ArrayList<Action> mActions;
    public ApplicationInfo mApplication;
    private ApplicationInfoCache mApplicationInfoCache;
    private int mApplyFlags;
    private BitmapCache mBitmapCache;
    private Map<Class, Object> mClassCookies;
    private SizeF mIdealSize;
    private boolean mIsRoot;
    private RemoteViews mLandscape;
    private int mLayoutId;
    private int mLightBackgroundLayoutId;
    private RemoteViews mPortrait;
    private long mProviderInstanceId;
    private List<RemoteViews> mSizedRemoteViews;
    private int mViewId;
    private static boolean DEBUG_REMOTEVIEWS = SystemProperties.getBoolean("persist.sys.assert.panic", false);
    private static final int DEBUG_DEPTH = SystemProperties.getInt("debug.remoteviews.depth", 10);
    private static final Parcel.ReadWriteHelper ALTERNATIVE_DEFAULT = new Parcel.ReadWriteHelper();
    private static final LayoutInflater.Filter INFLATER_FILTER = new LayoutInflater.Filter() { // from class: android.widget.RemoteViews$$ExternalSyntheticLambda0
        @Override // android.view.LayoutInflater.Filter
        public final boolean onLoadClass(Class cls) {
            boolean isAnnotationPresent;
            isAnnotationPresent = cls.isAnnotationPresent(RemoteViews.RemoteView.class);
            return isAnnotationPresent;
        }
    };
    private static final InteractionHandler DEFAULT_INTERACTION_HANDLER = new InteractionHandler() { // from class: android.widget.RemoteViews$$ExternalSyntheticLambda1
        @Override // android.widget.RemoteViews.InteractionHandler
        public final boolean onInteraction(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse remoteResponse) {
            boolean startPendingIntent;
            startPendingIntent = RemoteViews.startPendingIntent(view, pendingIntent, remoteResponse.getLaunchOptions(view));
            return startPendingIntent;
        }
    };
    private static final ArrayMap<MethodKey, MethodArgs> sMethods = new ArrayMap<>();
    private static final MethodKey sLookupKey = new MethodKey();
    private static final Action ACTION_NOOP = new RuntimeAction() { // from class: android.widget.RemoteViews.1
        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
        }
    };
    public static final Parcelable.Creator<RemoteViews> CREATOR = new Parcelable.Creator<RemoteViews>() { // from class: android.widget.RemoteViews.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteViews createFromParcel(Parcel parcel) {
            return new RemoteViews(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteViews[] newArray(int size) {
            return new RemoteViews[size];
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ApplyFlags {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface InteractionHandler {
        boolean onInteraction(View view, PendingIntent pendingIntent, RemoteResponse remoteResponse);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface MarginType {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface RemoteView {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    @interface ValueType {
    }

    public void setRemoteInputs(int viewId, RemoteInput[] remoteInputs) {
        this.mActions.add(new SetRemoteInputsAction(viewId, remoteInputs));
    }

    public void reduceImageSizes(int maxWidth, int maxHeight) {
        ArrayList<Bitmap> cache = this.mBitmapCache.mBitmaps;
        for (int i10 = 0; i10 < cache.size(); i10++) {
            Bitmap bitmap = cache.get(i10);
            cache.set(i10, Icon.scaleDownIfNecessary(bitmap, maxWidth, maxHeight));
        }
    }

    public void overrideTextColors(int textColor) {
        addAction(new OverrideTextColorsAction(textColor));
    }

    public void setIntTag(int viewId, int key, int tag) {
        addAction(new SetIntTagAction(viewId, key, tag));
    }

    public void addFlags(int flags) {
        this.mApplyFlags |= flags;
        int flagsToPropagate = flags & 6;
        if (flagsToPropagate != 0) {
            if (hasSizedRemoteViews()) {
                for (RemoteViews remoteView : this.mSizedRemoteViews) {
                    remoteView.addFlags(flagsToPropagate);
                }
                return;
            }
            if (hasLandscapeAndPortraitLayouts()) {
                this.mLandscape.addFlags(flagsToPropagate);
                this.mPortrait.addFlags(flagsToPropagate);
            }
        }
    }

    public boolean hasFlags(int flag) {
        return (this.mApplyFlags & flag) == flag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class MethodKey {
        public String methodName;
        public Class paramClass;
        public Class targetClass;

        MethodKey() {
        }

        public boolean equals(Object o10) {
            if (!(o10 instanceof MethodKey)) {
                return false;
            }
            MethodKey p10 = (MethodKey) o10;
            return Objects.equals(p10.targetClass, this.targetClass) && Objects.equals(p10.paramClass, this.paramClass) && Objects.equals(p10.methodName, this.methodName);
        }

        public int hashCode() {
            return (Objects.hashCode(this.targetClass) ^ Objects.hashCode(this.paramClass)) ^ Objects.hashCode(this.methodName);
        }

        public void set(Class targetClass, Class paramClass, String methodName) {
            this.targetClass = targetClass;
            this.paramClass = paramClass;
            this.methodName = methodName;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class MethodArgs {
        public MethodHandle asyncMethod;
        public String asyncMethodName;
        public MethodHandle syncMethod;

        MethodArgs() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ActionException extends RuntimeException {
        public ActionException(Exception ex) {
            super(ex);
        }

        public ActionException(String message) {
            super(message);
        }

        public ActionException(Throwable t2) {
            super(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class Action implements Parcelable {
        public static final int MERGE_APPEND = 1;
        public static final int MERGE_IGNORE = 2;
        public static final int MERGE_REPLACE = 0;
        int viewId;

        public abstract void apply(View view, ViewGroup viewGroup, ActionApplyParams actionApplyParams) throws ActionException;

        public abstract int getActionTag();

        private Action() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void setHierarchyRootData(HierarchyRootData root) {
        }

        public int mergeBehavior() {
            return 0;
        }

        public String getUniqueKey() {
            return getActionTag() + "_" + this.viewId;
        }

        public Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            return this;
        }

        public boolean prefersAsyncApply() {
            return false;
        }

        public void visitUris(Consumer<Uri> visitor) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static abstract class RuntimeAction extends Action {
        private RuntimeAction() {
            super();
        }

        @Override // android.widget.RemoteViews.Action
        public final int getActionTag() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            throw new UnsupportedOperationException();
        }
    }

    public void mergeRemoteViews(RemoteViews newRv) {
        if (newRv == null) {
            return;
        }
        RemoteViews copy = new RemoteViews(newRv);
        HashMap<String, Action> map = new HashMap<>();
        if (this.mActions == null) {
            this.mActions = new ArrayList<>();
        }
        int count = this.mActions.size();
        for (int i10 = 0; i10 < count; i10++) {
            Action a10 = this.mActions.get(i10);
            map.put(a10.getUniqueKey(), a10);
        }
        ArrayList<Action> newActions = copy.mActions;
        if (newActions == null) {
            return;
        }
        int count2 = newActions.size();
        for (int i11 = 0; i11 < count2; i11++) {
            Action a11 = newActions.get(i11);
            String key = newActions.get(i11).getUniqueKey();
            int mergeBehavior = newActions.get(i11).mergeBehavior();
            if (map.containsKey(key) && mergeBehavior == 0) {
                this.mActions.remove(map.get(key));
                map.remove(key);
            }
            if (mergeBehavior == 0 || mergeBehavior == 1) {
                this.mActions.add(a11);
            }
        }
        reconstructCaches();
    }

    public void visitUris(Consumer<Uri> visitor) {
        if (this.mActions != null) {
            for (int i10 = 0; i10 < this.mActions.size(); i10++) {
                this.mActions.get(i10).visitUris(visitor);
            }
        }
        if (this.mSizedRemoteViews != null) {
            for (int i11 = 0; i11 < this.mSizedRemoteViews.size(); i11++) {
                this.mSizedRemoteViews.get(i11).visitUris(visitor);
            }
        }
        RemoteViews remoteViews = this.mLandscape;
        if (remoteViews != null) {
            remoteViews.visitUris(visitor);
        }
        RemoteViews remoteViews2 = this.mPortrait;
        if (remoteViews2 != null) {
            remoteViews2.visitUris(visitor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void visitIconUri(Icon icon, Consumer<Uri> visitor) {
        if (icon != null) {
            if (icon.getType() == 4 || icon.getType() == 6) {
                visitor.accept(icon.getUri());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteViewsContextWrapper extends ContextWrapper {
        private final Context mContextForResources;

        RemoteViewsContextWrapper(Context context, Context contextForResources) {
            super(context);
            this.mContextForResources = contextForResources;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Resources getResources() {
            return this.mContextForResources.getResources();
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Resources.Theme getTheme() {
            return this.mContextForResources.getTheme();
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public String getPackageName() {
            return this.mContextForResources.getPackageName();
        }

        public UserHandle getUser() {
            return this.mContextForResources.getUser();
        }

        public int getUserId() {
            return this.mContextForResources.getUserId();
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public boolean isRestricted() {
            return this.mContextForResources.isRestricted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetEmptyView extends Action {
        int emptyViewId;

        SetEmptyView(int viewId, int emptyViewId) {
            super();
            this.viewId = viewId;
            this.emptyViewId = emptyViewId;
        }

        SetEmptyView(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.emptyViewId = in.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.viewId);
            out.writeInt(this.emptyViewId);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View view = root.findViewById(this.viewId);
            if (view instanceof AdapterView) {
                AdapterView<?> adapterView = (AdapterView) view;
                View emptyView = root.findViewById(this.emptyViewId);
                if (emptyView == null) {
                    return;
                }
                adapterView.setEmptyView(emptyView);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetPendingIntentTemplate extends Action {
        PendingIntent pendingIntentTemplate;

        public SetPendingIntentTemplate(int id2, PendingIntent pendingIntentTemplate) {
            super();
            this.viewId = id2;
            this.pendingIntentTemplate = pendingIntentTemplate;
        }

        public SetPendingIntentTemplate(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.pendingIntentTemplate = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntentTemplate, dest);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, final ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (target instanceof AdapterView) {
                AdapterView<?> av = (AdapterView) target;
                AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() { // from class: android.widget.RemoteViews$SetPendingIntentTemplate$$ExternalSyntheticLambda0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                        RemoteViews.SetPendingIntentTemplate.this.lambda$apply$0(params, adapterView, view, i10, j10);
                    }
                };
                av.setOnItemClickListener(listener);
                av.setTag(this.pendingIntentTemplate);
                return;
            }
            Log.e(RemoteViews.LOG_TAG, "Cannot setPendingIntentTemplate on a view which is notan AdapterView (id: " + this.viewId + ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$apply$0(ActionApplyParams params, AdapterView parent, View view, int position, long id2) {
            RemoteResponse response = findRemoteResponseTag(view);
            if (response != null) {
                response.handleViewInteraction(view, params.handler);
            }
        }

        private RemoteResponse findRemoteResponseTag(View rootView) {
            if (rootView == null) {
                return null;
            }
            ArrayDeque<View> viewsToCheck = new ArrayDeque<>();
            viewsToCheck.addLast(rootView);
            while (!viewsToCheck.isEmpty()) {
                View view = viewsToCheck.removeFirst();
                Object tag = view.getTag(16909015);
                if (tag instanceof RemoteResponse) {
                    return (RemoteResponse) tag;
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        viewsToCheck.addLast(viewGroup.getChildAt(i10));
                    }
                }
            }
            return null;
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetRemoteViewsAdapterList extends Action {
        ArrayList<RemoteViews> list;
        int viewTypeCount;

        public SetRemoteViewsAdapterList(int id2, ArrayList<RemoteViews> list, int viewTypeCount) {
            super();
            this.viewId = id2;
            this.list = list;
            this.viewTypeCount = viewTypeCount;
        }

        public SetRemoteViewsAdapterList(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.viewTypeCount = parcel.readInt();
            this.list = parcel.createTypedArrayList(RemoteViews.CREATOR);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.viewTypeCount);
            dest.writeTypedList(this.list, flags);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (!(rootParent instanceof AppWidgetHostView)) {
                Log.e(RemoteViews.LOG_TAG, "SetRemoteViewsAdapterIntent action can only be used for AppWidgets (root id: " + this.viewId + ")");
                return;
            }
            if (!(target instanceof AbsListView) && !(target instanceof AdapterViewAnimator)) {
                Log.e(RemoteViews.LOG_TAG, "Cannot setRemoteViewsAdapter on a view which is not an AbsListView or AdapterViewAnimator (id: " + this.viewId + ")");
                return;
            }
            if (target instanceof AbsListView) {
                AbsListView v2 = (AbsListView) target;
                Adapter a10 = v2.getAdapter();
                if ((a10 instanceof RemoteViewsListAdapter) && this.viewTypeCount <= a10.getViewTypeCount()) {
                    ((RemoteViewsListAdapter) a10).setViewsList(this.list);
                    return;
                } else {
                    v2.setAdapter((ListAdapter) new RemoteViewsListAdapter(v2.getContext(), this.list, this.viewTypeCount, params.colorResources));
                    return;
                }
            }
            if (target instanceof AdapterViewAnimator) {
                AdapterViewAnimator v10 = (AdapterViewAnimator) target;
                Adapter a11 = v10.getAdapter();
                if ((a11 instanceof RemoteViewsListAdapter) && this.viewTypeCount <= a11.getViewTypeCount()) {
                    ((RemoteViewsListAdapter) a11).setViewsList(this.list);
                } else {
                    v10.setAdapter(new RemoteViewsListAdapter(v10.getContext(), this.list, this.viewTypeCount, params.colorResources));
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 15;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ApplicationInfoCache {
        private final Map<Pair<String, Integer>, ApplicationInfo> mPackageUserToApplicationInfo = new ArrayMap();

        ApplicationInfoCache() {
        }

        ApplicationInfo getOrPut(final ApplicationInfo applicationInfo) {
            Pair<String, Integer> key = RemoteViews.getPackageUserKey(applicationInfo);
            if (key == null) {
                return null;
            }
            return this.mPackageUserToApplicationInfo.computeIfAbsent(key, new Function() { // from class: android.widget.RemoteViews$ApplicationInfoCache$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return RemoteViews.ApplicationInfoCache.lambda$getOrPut$0(applicationInfo, (Pair) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ ApplicationInfo lambda$getOrPut$0(ApplicationInfo applicationInfo, Pair ignored) {
            return applicationInfo;
        }

        void put(ApplicationInfo applicationInfo) {
            Pair<String, Integer> key = RemoteViews.getPackageUserKey(applicationInfo);
            if (key == null) {
                return;
            }
            this.mPackageUserToApplicationInfo.put(key, applicationInfo);
        }

        ApplicationInfo get(ApplicationInfo applicationInfo) {
            Pair<String, Integer> key = RemoteViews.getPackageUserKey(applicationInfo);
            if (key == null) {
                return null;
            }
            return this.mPackageUserToApplicationInfo.get(key);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SetRemoteCollectionItemListAdapterAction extends Action {
        private final RemoteCollectionItems mItems;

        SetRemoteCollectionItemListAdapterAction(int id2, RemoteCollectionItems items) {
            super();
            this.viewId = id2;
            this.mItems = items;
            items.setHierarchyRootData(RemoteViews.this.getHierarchyRootData());
        }

        SetRemoteCollectionItemListAdapterAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.mItems = new RemoteCollectionItems(parcel, RemoteViews.this.getHierarchyRootData());
        }

        @Override // android.widget.RemoteViews.Action
        public void setHierarchyRootData(HierarchyRootData rootData) {
            this.mItems.setHierarchyRootData(rootData);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            this.mItems.writeToParcel(dest, flags, true);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) throws ActionException {
            ActionException actionException;
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (!(rootParent instanceof AppWidgetHostView)) {
                Log.e(RemoteViews.LOG_TAG, "setRemoteAdapter can only be used for AppWidgets (root id: " + this.viewId + ")");
                return;
            }
            if (!(target instanceof AdapterView)) {
                Log.e(RemoteViews.LOG_TAG, "Cannot call setRemoteAdapter on a view which is not an AdapterView (id: " + this.viewId + ")");
                return;
            }
            AdapterView adapterView = (AdapterView) target;
            Adapter adapter = adapterView.getAdapter();
            if ((adapter instanceof RemoteCollectionItemsAdapter) && adapter.getViewTypeCount() >= this.mItems.getViewTypeCount()) {
                try {
                    ((RemoteCollectionItemsAdapter) adapter).setData(this.mItems, params.handler, params.colorResources);
                } finally {
                }
            } else {
                try {
                    adapterView.setAdapter(new RemoteCollectionItemsAdapter(this.mItems, params.handler, params.colorResources));
                } finally {
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 31;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SetRemoteViewsAdapterIntent extends Action {
        Intent intent;
        boolean isAsync;

        public SetRemoteViewsAdapterIntent(int id2, Intent intent) {
            super();
            this.isAsync = false;
            this.viewId = id2;
            this.intent = intent;
        }

        public SetRemoteViewsAdapterIntent(Parcel parcel) {
            super();
            this.isAsync = false;
            this.viewId = parcel.readInt();
            this.intent = (Intent) parcel.readTypedObject(Intent.CREATOR);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeTypedObject(this.intent, flags);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (!(rootParent instanceof AppWidgetHostView)) {
                Log.e(RemoteViews.LOG_TAG, "setRemoteAdapter can only be used for AppWidgets (root id: " + this.viewId + ")");
                return;
            }
            if (!(target instanceof AbsListView) && !(target instanceof AdapterViewAnimator)) {
                Log.e(RemoteViews.LOG_TAG, "Cannot setRemoteAdapter on a view which is not an AbsListView or AdapterViewAnimator (id: " + this.viewId + ")");
                return;
            }
            AppWidgetHostView host = (AppWidgetHostView) rootParent;
            this.intent.putExtra(RemoteViews.EXTRA_REMOTEADAPTER_APPWIDGET_ID, host.getAppWidgetId()).putExtra(RemoteViews.EXTRA_REMOTEADAPTER_ON_LIGHT_BACKGROUND, RemoteViews.this.hasFlags(4));
            if (target instanceof AbsListView) {
                AbsListView v2 = (AbsListView) target;
                v2.setRemoteViewsAdapter(this.intent, this.isAsync);
                v2.setRemoteViewsInteractionHandler(params.handler);
            } else if (target instanceof AdapterViewAnimator) {
                AdapterViewAnimator v10 = (AdapterViewAnimator) target;
                v10.setRemoteViewsAdapter(this.intent, this.isAsync);
                v10.setRemoteViewsOnClickHandler(params.handler);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            SetRemoteViewsAdapterIntent copy = new SetRemoteViewsAdapterIntent(this.viewId, this.intent);
            copy.isAsync = true;
            return copy;
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SetOnClickResponse extends Action {
        final RemoteResponse mResponse;

        SetOnClickResponse(int id2, RemoteResponse response) {
            super();
            this.viewId = id2;
            this.mResponse = response;
        }

        SetOnClickResponse(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            RemoteResponse remoteResponse = new RemoteResponse();
            this.mResponse = remoteResponse;
            remoteResponse.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            this.mResponse.writeToParcel(dest, flags);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, final ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (this.mResponse.mPendingIntent != null) {
                if (RemoteViews.this.hasFlags(2)) {
                    Log.w(RemoteViews.LOG_TAG, "Cannot SetOnClickResponse for collection item (id: " + this.viewId + ")");
                    ApplicationInfo appInfo = root.getContext().getApplicationInfo();
                    if (appInfo != null && appInfo.targetSdkVersion >= 16) {
                        return;
                    }
                }
                target.setTagInternal(16909357, this.mResponse.mPendingIntent);
            } else if (this.mResponse.mFillIntent != null) {
                if (!RemoteViews.this.hasFlags(2)) {
                    Log.e(RemoteViews.LOG_TAG, "The method setOnClickFillInIntent is available only from RemoteViewsFactory (ie. on collection items).");
                    return;
                } else if (target == root) {
                    target.setTagInternal(16909015, this.mResponse);
                    return;
                }
            } else {
                target.setOnClickListener(null);
                target.setTagInternal(16909357, null);
                target.setTagInternal(16909015, null);
                return;
            }
            target.setOnClickListener(new View.OnClickListener() { // from class: android.widget.RemoteViews$SetOnClickResponse$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RemoteViews.SetOnClickResponse.this.lambda$apply$0(params, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$apply$0(ActionApplyParams params, View v2) {
            this.mResponse.handleViewInteraction(v2, params.handler);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SetOnCheckedChangeResponse extends Action {
        private final RemoteResponse mResponse;

        SetOnCheckedChangeResponse(int id2, RemoteResponse response) {
            super();
            this.viewId = id2;
            this.mResponse = response;
        }

        SetOnCheckedChangeResponse(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            RemoteResponse remoteResponse = new RemoteResponse();
            this.mResponse = remoteResponse;
            remoteResponse.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            this.mResponse.writeToParcel(dest, flags);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, final ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (!(target instanceof CompoundButton)) {
                Log.w(RemoteViews.LOG_TAG, "setOnCheckedChange methods cannot be used on non-CompoundButton child (id: " + this.viewId + ")");
                return;
            }
            CompoundButton button = (CompoundButton) target;
            if (this.mResponse.mPendingIntent != null) {
                if (RemoteViews.this.hasFlags(2)) {
                    Log.w(RemoteViews.LOG_TAG, "Cannot setOnCheckedChangePendingIntent for collection item (id: " + this.viewId + ")");
                    return;
                }
                target.setTagInternal(16909357, this.mResponse.mPendingIntent);
            } else if (this.mResponse.mFillIntent != null) {
                if (!RemoteViews.this.hasFlags(2)) {
                    Log.e(RemoteViews.LOG_TAG, "The method setOnCheckedChangeFillInIntent is available only from RemoteViewsFactory (ie. on collection items).");
                    return;
                }
            } else {
                button.setOnCheckedChangeListener(null);
                button.setTagInternal(16909421, null);
                return;
            }
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: android.widget.RemoteViews$SetOnCheckedChangeResponse$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    RemoteViews.SetOnCheckedChangeResponse.this.lambda$apply$0(params, compoundButton, z10);
                }
            };
            button.setTagInternal(16909421, onCheckedChangeListener);
            button.setOnCheckedChangeListener(onCheckedChangeListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$apply$0(ActionApplyParams params, CompoundButton v2, boolean isChecked) {
            this.mResponse.handleViewInteraction(v2, params.handler);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 29;
        }
    }

    public static Rect getSourceBounds(View v2) {
        float appScale = v2.getContext().getResources().getCompatibilityInfo().applicationScale;
        int[] pos = new int[2];
        v2.getLocationOnScreen(pos);
        Rect rect = new Rect();
        rect.left = (int) ((pos[0] * appScale) + 0.5f);
        rect.top = (int) ((pos[1] * appScale) + 0.5f);
        rect.right = (int) (((pos[0] + v2.getWidth()) * appScale) + 0.5f);
        rect.bottom = (int) (((pos[1] + v2.getHeight()) * appScale) + 0.5f);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<?> getParameterType(int type) {
        switch (type) {
            case 1:
                return Boolean.TYPE;
            case 2:
                return Byte.TYPE;
            case 3:
                return Short.TYPE;
            case 4:
                return Integer.TYPE;
            case 5:
                return Long.TYPE;
            case 6:
                return Float.TYPE;
            case 7:
                return Double.TYPE;
            case 8:
                return Character.TYPE;
            case 9:
                return String.class;
            case 10:
                return CharSequence.class;
            case 11:
                return Uri.class;
            case 12:
                return Bitmap.class;
            case 13:
                return Bundle.class;
            case 14:
                return Intent.class;
            case 15:
                return ColorStateList.class;
            case 16:
                return Icon.class;
            case 17:
                return BlendMode.class;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MethodHandle getMethod(View view, String methodName, Class<?> paramType, boolean async) {
        Method method;
        Class<?> cls = view.getClass();
        ArrayMap<MethodKey, MethodArgs> arrayMap = sMethods;
        synchronized (arrayMap) {
            MethodKey methodKey = sLookupKey;
            methodKey.set(cls, paramType, methodName);
            MethodArgs result = arrayMap.get(methodKey);
            if (result == null) {
                try {
                    if (paramType == null) {
                        method = cls.getMethod(methodName, new Class[0]);
                    } else {
                        method = cls.getMethod(methodName, paramType);
                    }
                    if (!method.isAnnotationPresent(RemotableViewMethod.class)) {
                        throw new ActionException("view: " + cls.getName() + " can't use method with RemoteViews: " + methodName + getParameters(paramType));
                    }
                    result = new MethodArgs();
                    result.syncMethod = MethodHandles.publicLookup().unreflect(method);
                    result.asyncMethodName = ((RemotableViewMethod) method.getAnnotation(RemotableViewMethod.class)).asyncImpl();
                    MethodKey key = new MethodKey();
                    key.set(cls, paramType, methodName);
                    arrayMap.put(key, result);
                } catch (IllegalAccessException | NoSuchMethodException e2) {
                    throw new ActionException("view: " + cls.getName() + " doesn't have method: " + methodName + getParameters(paramType));
                }
            }
            if (!async) {
                return result.syncMethod;
            }
            if (result.asyncMethodName.isEmpty()) {
                return null;
            }
            if (result.asyncMethod == null) {
                MethodType asyncType = result.syncMethod.type().dropParameterTypes(0, 1).changeReturnType(Runnable.class);
                try {
                    result.asyncMethod = MethodHandles.publicLookup().findVirtual(cls, result.asyncMethodName, asyncType);
                } catch (IllegalAccessException | NoSuchMethodException e10) {
                    throw new ActionException("Async implementation declared as " + result.asyncMethodName + " but not defined for " + methodName + ": public Runnable " + result.asyncMethodName + " (" + TextUtils.join(",", asyncType.parameterArray()) + ")");
                }
            }
            return result.asyncMethod;
        }
    }

    private static String getParameters(Class<?> paramType) {
        return paramType == null ? "()" : "(" + ((Object) paramType) + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetDrawableTint extends Action {
        int colorFilter;
        PorterDuff.Mode filterMode;
        boolean targetBackground;

        SetDrawableTint(int id2, boolean targetBackground, int colorFilter, PorterDuff.Mode mode) {
            super();
            this.viewId = id2;
            this.targetBackground = targetBackground;
            this.colorFilter = colorFilter;
            this.filterMode = mode;
        }

        SetDrawableTint(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.targetBackground = parcel.readInt() != 0;
            this.colorFilter = parcel.readInt();
            this.filterMode = PorterDuff.intToMode(parcel.readInt());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.targetBackground ? 1 : 0);
            parcel.writeInt(this.colorFilter);
            parcel.writeInt(PorterDuff.modeToInt(this.filterMode));
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            Drawable targetDrawable = null;
            if (this.targetBackground) {
                targetDrawable = target.getBackground();
            } else if (target instanceof ImageView) {
                ImageView imageView = (ImageView) target;
                targetDrawable = imageView.getDrawable();
            }
            if (targetDrawable != null) {
                targetDrawable.mutate().setColorFilter(this.colorFilter, this.filterMode);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class SetRippleDrawableColor extends Action {
        ColorStateList mColorStateList;

        SetRippleDrawableColor(int id2, ColorStateList colorStateList) {
            super();
            this.viewId = id2;
            this.mColorStateList = colorStateList;
        }

        SetRippleDrawableColor(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.mColorStateList = (ColorStateList) parcel.readParcelable(null, ColorStateList.class);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeParcelable(this.mColorStateList, 0);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            Drawable targetDrawable = target.getBackground();
            if (targetDrawable instanceof RippleDrawable) {
                ((RippleDrawable) targetDrawable.mutate()).setColor(this.mColorStateList);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 21;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ViewContentNavigation extends Action {
        final boolean mNext;

        ViewContentNavigation(int viewId, boolean next) {
            super();
            this.viewId = viewId;
            this.mNext = next;
        }

        ViewContentNavigation(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.mNext = in.readBoolean();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.viewId);
            out.writeBoolean(this.mNext);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View view = root.findViewById(this.viewId);
            if (view == null) {
                return;
            }
            try {
                (void) RemoteViews.getMethod(view, this.mNext ? "showNext" : "showPrevious", null, false).invoke(view);
            } catch (Throwable ex) {
                throw new ActionException(ex);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return 2;
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class BitmapCache {
        SparseIntArray mBitmapHashes;
        int mBitmapMemory;
        ArrayList<Bitmap> mBitmaps;

        public BitmapCache() {
            this.mBitmapMemory = -1;
            this.mBitmaps = new ArrayList<>();
            this.mBitmapHashes = new SparseIntArray();
        }

        public BitmapCache(Parcel source) {
            this.mBitmapMemory = -1;
            this.mBitmaps = source.createTypedArrayList(Bitmap.CREATOR);
            this.mBitmapHashes = new SparseIntArray();
            for (int i10 = 0; i10 < this.mBitmaps.size(); i10++) {
                Bitmap b4 = this.mBitmaps.get(i10);
                if (b4 != null) {
                    this.mBitmapHashes.put(b4.hashCode(), i10);
                }
            }
        }

        public int getBitmapId(Bitmap b4) {
            if (b4 == null) {
                return -1;
            }
            int hash = b4.hashCode();
            int hashId = this.mBitmapHashes.get(hash, -1);
            if (hashId != -1) {
                return hashId;
            }
            if (b4.isMutable()) {
                b4 = b4.asShared();
            }
            this.mBitmaps.add(b4);
            this.mBitmapHashes.put(hash, this.mBitmaps.size() - 1);
            this.mBitmapMemory = -1;
            return this.mBitmaps.size() - 1;
        }

        public Bitmap getBitmapForId(int id2) {
            if (id2 == -1 || id2 >= this.mBitmaps.size()) {
                return null;
            }
            return this.mBitmaps.get(id2);
        }

        public void writeBitmapsToParcel(Parcel dest, int flags) {
            dest.writeTypedList(this.mBitmaps, flags);
        }

        public int getBitmapMemory() {
            if (this.mBitmapMemory < 0) {
                this.mBitmapMemory = 0;
                int count = this.mBitmaps.size();
                for (int i10 = 0; i10 < count; i10++) {
                    this.mBitmapMemory += this.mBitmaps.get(i10).getAllocationByteCount();
                }
            }
            int count2 = this.mBitmapMemory;
            return count2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class BitmapReflectionAction extends Action {
        Bitmap bitmap;
        int bitmapId;
        String methodName;

        BitmapReflectionAction(int viewId, String methodName, Bitmap bitmap) {
            super();
            this.bitmap = bitmap;
            this.viewId = viewId;
            this.methodName = methodName;
            this.bitmapId = RemoteViews.this.mBitmapCache.getBitmapId(bitmap);
        }

        BitmapReflectionAction(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.methodName = in.readString8();
            this.bitmapId = in.readInt();
            this.bitmap = RemoteViews.this.mBitmapCache.getBitmapForId(this.bitmapId);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeString8(this.methodName);
            dest.writeInt(this.bitmapId);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) throws ActionException {
            ReflectionAction ra2 = new ReflectionAction(this.viewId, this.methodName, 12, this.bitmap);
            ra2.apply(root, rootParent, params);
        }

        @Override // android.widget.RemoteViews.Action
        public void setHierarchyRootData(HierarchyRootData rootData) {
            this.bitmapId = rootData.mBitmapCache.getBitmapId(this.bitmap);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 12;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static abstract class BaseReflectionAction extends Action {
        static final int BITMAP = 12;
        static final int BLEND_MODE = 17;
        static final int BOOLEAN = 1;
        static final int BUNDLE = 13;
        static final int BYTE = 2;
        static final int CHAR = 8;
        static final int CHAR_SEQUENCE = 10;
        static final int COLOR_STATE_LIST = 15;
        static final int DOUBLE = 7;
        static final int FLOAT = 6;
        static final int ICON = 16;
        static final int INT = 4;
        static final int INTENT = 14;
        static final int LONG = 5;
        static final int SHORT = 3;
        static final int STRING = 9;
        static final int URI = 11;
        String methodName;
        int type;

        protected abstract Object getParameterValue(View view) throws ActionException;

        BaseReflectionAction(int viewId, String methodName, int type) {
            super();
            this.viewId = viewId;
            this.methodName = methodName;
            this.type = type;
        }

        BaseReflectionAction(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.methodName = in.readString8();
            this.type = in.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.viewId);
            out.writeString8(this.methodName);
            out.writeInt(this.type);
        }

        @Override // android.widget.RemoteViews.Action
        public final void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View view = root.findViewById(this.viewId);
            if (view == null) {
                return;
            }
            Class<?> param = RemoteViews.getParameterType(this.type);
            if (param == null) {
                throw new ActionException("bad type: " + this.type);
            }
            Object value = getParameterValue(view);
            try {
                (void) RemoteViews.getMethod(view, this.methodName, param, false).invoke(view, value);
            } catch (Throwable ex) {
                throw new ActionException(ex);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public final Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            Bitmap bitmap;
            View view = root.findViewById(this.viewId);
            if (view == null) {
                return RemoteViews.ACTION_NOOP;
            }
            Class<?> param = RemoteViews.getParameterType(this.type);
            if (param == null) {
                throw new ActionException("bad type: " + this.type);
            }
            Object value = getParameterValue(view);
            try {
                MethodHandle method = RemoteViews.getMethod(view, this.methodName, param, true);
                if (value instanceof Bitmap) {
                    ((Bitmap) value).prepareToDraw();
                }
                if (value instanceof Icon) {
                    Icon icon = (Icon) value;
                    if ((icon.getType() == 1 || icon.getType() == 5) && (bitmap = icon.getBitmap()) != null) {
                        bitmap.prepareToDraw();
                    }
                }
                if (method != null) {
                    Runnable endAction = (Runnable) method.invoke(view, value);
                    if (endAction == null) {
                        return RemoteViews.ACTION_NOOP;
                    }
                    if (endAction instanceof ViewStub.ViewReplaceRunnable) {
                        root.createTree();
                        root.findViewTreeById(this.viewId).replaceView(((ViewStub.ViewReplaceRunnable) endAction).view);
                    }
                    return new RunnableAction(endAction);
                }
                return this;
            } catch (Throwable ex) {
                throw new ActionException(ex);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public final int mergeBehavior() {
            if (this.methodName.equals("smoothScrollBy")) {
                return 1;
            }
            return 0;
        }

        @Override // android.widget.RemoteViews.Action
        public final String getUniqueKey() {
            return super.getUniqueKey() + this.methodName + this.type;
        }

        @Override // android.widget.RemoteViews.Action
        public final boolean prefersAsyncApply() {
            int i10 = this.type;
            return i10 == 11 || i10 == 16;
        }

        @Override // android.widget.RemoteViews.Action
        public void visitUris(Consumer<Uri> visitor) {
            switch (this.type) {
                case 11:
                    Uri uri = (Uri) getParameterValue(null);
                    if (uri != null) {
                        visitor.accept(uri);
                        return;
                    }
                    return;
                case 16:
                    Icon icon = (Icon) getParameterValue(null);
                    if (icon != null) {
                        RemoteViews.visitIconUri(icon, visitor);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ReflectionAction extends BaseReflectionAction {
        Object value;

        ReflectionAction(int viewId, String methodName, int type, Object value) {
            super(viewId, methodName, type);
            this.value = value;
        }

        ReflectionAction(Parcel in) {
            super(in);
            switch (this.type) {
                case 1:
                    this.value = Boolean.valueOf(in.readBoolean());
                    return;
                case 2:
                    this.value = Byte.valueOf(in.readByte());
                    return;
                case 3:
                    this.value = Short.valueOf((short) in.readInt());
                    return;
                case 4:
                    this.value = Integer.valueOf(in.readInt());
                    return;
                case 5:
                    this.value = Long.valueOf(in.readLong());
                    return;
                case 6:
                    this.value = Float.valueOf(in.readFloat());
                    return;
                case 7:
                    this.value = Double.valueOf(in.readDouble());
                    return;
                case 8:
                    this.value = Character.valueOf((char) in.readInt());
                    return;
                case 9:
                    this.value = in.readString8();
                    return;
                case 10:
                    this.value = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
                    return;
                case 11:
                    this.value = in.readTypedObject(Uri.CREATOR);
                    return;
                case 12:
                    this.value = in.readTypedObject(Bitmap.CREATOR);
                    return;
                case 13:
                    if (in.hasReadWriteHelper()) {
                        this.value = in.readBundle();
                        return;
                    }
                    in.setReadWriteHelper(RemoteViews.ALTERNATIVE_DEFAULT);
                    this.value = in.readBundle();
                    in.setReadWriteHelper(null);
                    return;
                case 14:
                    this.value = in.readTypedObject(Intent.CREATOR);
                    return;
                case 15:
                    this.value = in.readTypedObject(ColorStateList.CREATOR);
                    return;
                case 16:
                    this.value = in.readTypedObject(Icon.CREATOR);
                    return;
                case 17:
                    this.value = BlendMode.fromValue(in.readInt());
                    return;
                default:
                    return;
            }
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            switch (this.type) {
                case 1:
                    out.writeBoolean(((Boolean) this.value).booleanValue());
                    return;
                case 2:
                    out.writeByte(((Byte) this.value).byteValue());
                    return;
                case 3:
                    out.writeInt(((Short) this.value).shortValue());
                    return;
                case 4:
                    out.writeInt(((Integer) this.value).intValue());
                    return;
                case 5:
                    out.writeLong(((Long) this.value).longValue());
                    return;
                case 6:
                    out.writeFloat(((Float) this.value).floatValue());
                    return;
                case 7:
                    out.writeDouble(((Double) this.value).doubleValue());
                    return;
                case 8:
                    out.writeInt(((Character) this.value).charValue());
                    return;
                case 9:
                    out.writeString8((String) this.value);
                    return;
                case 10:
                    TextUtils.writeToParcel((CharSequence) this.value, out, flags);
                    return;
                case 11:
                case 12:
                case 14:
                case 15:
                case 16:
                    out.writeTypedObject((Parcelable) this.value, flags);
                    return;
                case 13:
                    out.writeBundle((Bundle) this.value);
                    return;
                case 17:
                    out.writeInt(BlendMode.toValue((BlendMode) this.value));
                    return;
                default:
                    return;
            }
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction
        protected Object getParameterValue(View view) throws ActionException {
            return this.value;
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ResourceReflectionAction extends BaseReflectionAction {
        static final int COLOR_RESOURCE = 2;
        static final int DIMEN_RESOURCE = 1;
        static final int STRING_RESOURCE = 3;
        private final int mResId;
        private final int mResourceType;

        ResourceReflectionAction(int viewId, String methodName, int parameterType, int resourceType, int resId) {
            super(viewId, methodName, parameterType);
            this.mResourceType = resourceType;
            this.mResId = resId;
        }

        ResourceReflectionAction(Parcel in) {
            super(in);
            this.mResourceType = in.readInt();
            this.mResId = in.readInt();
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.mResourceType);
            dest.writeInt(this.mResId);
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction
        protected Object getParameterValue(View view) throws ActionException {
            if (view == null) {
                return null;
            }
            Resources resources = view.getContext().getResources();
            try {
                switch (this.mResourceType) {
                    case 1:
                        switch (this.type) {
                            case 4:
                                int i10 = this.mResId;
                                return Integer.valueOf(i10 != 0 ? resources.getDimensionPixelSize(i10) : 0);
                            case 5:
                            default:
                                throw new ActionException("dimen resources must be used as INT or FLOAT, not " + this.type);
                            case 6:
                                int i11 = this.mResId;
                                return Float.valueOf(i11 == 0 ? 0.0f : resources.getDimension(i11));
                        }
                    case 2:
                        switch (this.type) {
                            case 4:
                                return Integer.valueOf(this.mResId != 0 ? view.getContext().getColor(this.mResId) : 0);
                            case 15:
                                return this.mResId != 0 ? view.getContext().getColorStateList(this.mResId) : null;
                            default:
                                throw new ActionException("color resources must be used as INT or COLOR_STATE_LIST, not " + this.type);
                        }
                    case 3:
                        switch (this.type) {
                            case 9:
                                int i12 = this.mResId;
                                return i12 != 0 ? resources.getString(i12) : null;
                            case 10:
                                int i13 = this.mResId;
                                return i13 != 0 ? resources.getText(i13) : null;
                            default:
                                throw new ActionException("string resources must be used as STRING or CHAR_SEQUENCE, not " + this.type);
                        }
                    default:
                        throw new ActionException("unknown resource type: " + this.mResourceType);
                }
            } catch (ActionException ex) {
                throw ex;
            } catch (Throwable t2) {
                throw new ActionException(t2);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 24;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class AttributeReflectionAction extends BaseReflectionAction {
        static final int COLOR_RESOURCE = 2;
        static final int DIMEN_RESOURCE = 1;
        static final int STRING_RESOURCE = 3;
        private final int mAttrId;
        private final int mResourceType;

        AttributeReflectionAction(int viewId, String methodName, int parameterType, int resourceType, int attrId) {
            super(viewId, methodName, parameterType);
            this.mResourceType = resourceType;
            this.mAttrId = attrId;
        }

        AttributeReflectionAction(Parcel in) {
            super(in);
            this.mResourceType = in.readInt();
            this.mAttrId = in.readInt();
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.mResourceType);
            dest.writeInt(this.mAttrId);
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction
        protected Object getParameterValue(View view) throws ActionException {
            TypedArray typedArray = view.getContext().obtainStyledAttributes(new int[]{this.mAttrId});
            try {
                try {
                    if (this.mAttrId != 0 && typedArray.getType(0) == 0) {
                        throw new ActionException("Attribute 0x" + Integer.toHexString(this.mAttrId) + " is not defined");
                    }
                    switch (this.mResourceType) {
                        case 1:
                            switch (this.type) {
                                case 4:
                                    return Integer.valueOf(typedArray.getDimensionPixelSize(0, 0));
                                case 5:
                                default:
                                    throw new ActionException("dimen attribute 0x" + Integer.toHexString(this.mAttrId) + " must be used as INT or FLOAT, not " + this.type);
                                case 6:
                                    return Float.valueOf(typedArray.getDimension(0, 0.0f));
                            }
                        case 2:
                            switch (this.type) {
                                case 4:
                                    return Integer.valueOf(typedArray.getColor(0, 0));
                                case 15:
                                    return typedArray.getColorStateList(0);
                                default:
                                    throw new ActionException("color attribute 0x" + Integer.toHexString(this.mAttrId) + " must be used as INT or COLOR_STATE_LIST, not " + this.type);
                            }
                        case 3:
                            switch (this.type) {
                                case 9:
                                    return typedArray.getString(0);
                                case 10:
                                    return typedArray.getText(0);
                                default:
                                    throw new ActionException("string attribute 0x" + Integer.toHexString(this.mAttrId) + " must be used as STRING or CHAR_SEQUENCE, not " + this.type);
                            }
                        default:
                            throw new ActionException("Unknown resource type: " + this.mResourceType);
                    }
                } catch (ActionException ex) {
                    throw ex;
                } catch (Throwable t2) {
                    throw new ActionException(t2);
                }
            } finally {
                typedArray.recycle();
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 32;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ComplexUnitDimensionReflectionAction extends BaseReflectionAction {
        private final int mUnit;
        private final float mValue;

        ComplexUnitDimensionReflectionAction(int viewId, String methodName, int parameterType, float value, int unit) {
            super(viewId, methodName, parameterType);
            this.mValue = value;
            this.mUnit = unit;
        }

        ComplexUnitDimensionReflectionAction(Parcel in) {
            super(in);
            this.mValue = in.readFloat();
            this.mUnit = in.readInt();
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeFloat(this.mValue);
            dest.writeInt(this.mUnit);
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction
        protected Object getParameterValue(View view) throws ActionException {
            if (view == null) {
                return null;
            }
            DisplayMetrics dm = view.getContext().getResources().getDisplayMetrics();
            try {
                int data = TypedValue.createComplexDimension(this.mValue, this.mUnit);
                switch (this.type) {
                    case 4:
                        return Integer.valueOf(TypedValue.complexToDimensionPixelSize(data, dm));
                    case 5:
                    default:
                        throw new ActionException("parameter type must be INT or FLOAT, not " + this.type);
                    case 6:
                        return Float.valueOf(TypedValue.complexToDimension(data, dm));
                }
            } catch (ActionException ex) {
                throw ex;
            } catch (Throwable t2) {
                throw new ActionException(t2);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 25;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class NightModeReflectionAction extends BaseReflectionAction {
        private final Object mDarkValue;
        private final Object mLightValue;

        NightModeReflectionAction(int viewId, String methodName, int type, Object lightValue, Object darkValue) {
            super(viewId, methodName, type);
            this.mLightValue = lightValue;
            this.mDarkValue = darkValue;
        }

        NightModeReflectionAction(Parcel in) {
            super(in);
            switch (this.type) {
                case 4:
                    this.mLightValue = Integer.valueOf(in.readInt());
                    this.mDarkValue = Integer.valueOf(in.readInt());
                    return;
                case 15:
                    this.mLightValue = in.readTypedObject(ColorStateList.CREATOR);
                    this.mDarkValue = in.readTypedObject(ColorStateList.CREATOR);
                    return;
                case 16:
                    this.mLightValue = in.readTypedObject(Icon.CREATOR);
                    this.mDarkValue = in.readTypedObject(Icon.CREATOR);
                    return;
                default:
                    throw new ActionException("Unexpected night mode action type: " + this.type);
            }
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            switch (this.type) {
                case 4:
                    out.writeInt(((Integer) this.mLightValue).intValue());
                    out.writeInt(((Integer) this.mDarkValue).intValue());
                    return;
                case 15:
                case 16:
                    out.writeTypedObject((Parcelable) this.mLightValue, flags);
                    out.writeTypedObject((Parcelable) this.mDarkValue, flags);
                    return;
                default:
                    return;
            }
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction
        protected Object getParameterValue(View view) throws ActionException {
            if (view == null) {
                return null;
            }
            Configuration configuration = view.getResources().getConfiguration();
            return configuration.isNightModeActive() ? this.mDarkValue : this.mLightValue;
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 30;
        }

        @Override // android.widget.RemoteViews.BaseReflectionAction, android.widget.RemoteViews.Action
        public void visitUris(Consumer<Uri> visitor) {
            if (this.type == 16) {
                RemoteViews.visitIconUri((Icon) this.mDarkValue, visitor);
                RemoteViews.visitIconUri((Icon) this.mLightValue, visitor);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static final class RunnableAction extends RuntimeAction {
        private final Runnable mRunnable;

        RunnableAction(Runnable r10) {
            super();
            this.mRunnable = r10;
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            this.mRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasStableId(View view) {
        Object tag = view.getTag(16909429);
        return tag != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getStableId(View view) {
        Integer id2 = (Integer) view.getTag(16909429);
        if (id2 == null) {
            return -1;
        }
        return id2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setStableId(View view, int stableId) {
        view.setTagInternal(16909429, Integer.valueOf(stableId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getNextRecyclableChild(ViewGroup vg) {
        Integer tag = (Integer) vg.getTag(16909427);
        if (tag == null) {
            return -1;
        }
        return tag.intValue();
    }

    private static int getViewLayoutId(View v2) {
        return ((Integer) v2.getTag(16908312)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setNextRecyclableChild(ViewGroup vg, int nextChild, int numChildren) {
        if (nextChild < 0 || nextChild >= numChildren) {
            vg.setTagInternal(16909427, -1);
        } else {
            vg.setTagInternal(16909427, Integer.valueOf(nextChild));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finalizeViewRecycling(ViewGroup root) {
        int nextChild = getNextRecyclableChild(root);
        if (nextChild >= 0 && nextChild < root.getChildCount()) {
            root.removeViews(nextChild, root.getChildCount() - nextChild);
        }
        setNextRecyclableChild(root, -1, 0);
        for (int i10 = 0; i10 < root.getChildCount(); i10++) {
            View child = root.getChildAt(i10);
            if ((child instanceof ViewGroup) && !child.isRootNamespace()) {
                finalizeViewRecycling((ViewGroup) child);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ViewGroupActionAdd extends Action {
        static final int NO_ID = -1;
        private int mIndex;
        private RemoteViews mNestedViews;
        private int mStableId;

        ViewGroupActionAdd(RemoteViews remoteViews, int viewId, RemoteViews nestedViews) {
            this(viewId, nestedViews, -1, -1);
        }

        ViewGroupActionAdd(RemoteViews remoteViews, int viewId, RemoteViews nestedViews, int index) {
            this(viewId, nestedViews, index, -1);
        }

        ViewGroupActionAdd(int viewId, RemoteViews nestedViews, int index, int stableId) {
            super();
            this.viewId = viewId;
            this.mNestedViews = nestedViews;
            this.mIndex = index;
            this.mStableId = stableId;
            nestedViews.configureAsChild(RemoteViews.this.getHierarchyRootData());
        }

        ViewGroupActionAdd(Parcel parcel, ApplicationInfo info, int depth) {
            super();
            this.viewId = parcel.readInt();
            this.mIndex = parcel.readInt();
            this.mStableId = parcel.readInt();
            RemoteViews remoteViews = new RemoteViews(parcel, RemoteViews.this.getHierarchyRootData(), info, depth);
            this.mNestedViews = remoteViews;
            remoteViews.addFlags(RemoteViews.this.mApplyFlags);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.mIndex);
            dest.writeInt(this.mStableId);
            this.mNestedViews.writeToParcel(dest, flags);
        }

        @Override // android.widget.RemoteViews.Action
        public void setHierarchyRootData(HierarchyRootData root) {
            this.mNestedViews.configureAsChild(root);
        }

        private int findViewIndexToRecycle(ViewGroup target, RemoteViews newContent) {
            for (int nextChild = RemoteViews.getNextRecyclableChild(target); nextChild < target.getChildCount(); nextChild++) {
                View child = target.getChildAt(nextChild);
                if (RemoteViews.getStableId(child) == this.mStableId) {
                    return nextChild;
                }
            }
            return -1;
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            int recycledViewIndex;
            Context context = root.getContext();
            ViewGroup target = (ViewGroup) root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            int nextChild = RemoteViews.getNextRecyclableChild(target);
            RemoteViews rvToApply = this.mNestedViews.getRemoteViewsToApply(context);
            int flagsToPropagate = RemoteViews.this.mApplyFlags & 6;
            if (flagsToPropagate != 0) {
                rvToApply.addFlags(flagsToPropagate);
            }
            if (nextChild >= 0 && this.mStableId != -1 && (recycledViewIndex = findViewIndexToRecycle(target, rvToApply)) >= 0) {
                View child = target.getChildAt(recycledViewIndex);
                if (rvToApply.canRecycleView(child)) {
                    if (nextChild < recycledViewIndex) {
                        target.removeViews(nextChild, recycledViewIndex - nextChild);
                    }
                    RemoteViews.setNextRecyclableChild(target, nextChild + 1, target.getChildCount());
                    rvToApply.reapplyNestedViews(context, child, rootParent, params);
                    return;
                }
                target.removeViews(nextChild, (recycledViewIndex - nextChild) + 1);
            }
            View nestedView = rvToApply.apply(context, target, rootParent, (SizeF) null, params);
            int i10 = this.mStableId;
            if (i10 != -1) {
                RemoteViews.setStableId(nestedView, i10);
            }
            int i11 = this.mIndex;
            if (i11 < 0) {
                i11 = nextChild;
            }
            target.addView(nestedView, i11);
            if (nextChild >= 0) {
                RemoteViews.setNextRecyclableChild(target, nextChild + 1, target.getChildCount());
            }
        }

        @Override // android.widget.RemoteViews.Action
        public Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            root.createTree();
            ViewTree target = root.findViewTreeById(this.viewId);
            if (target == null || !(target.mRoot instanceof ViewGroup)) {
                return RemoteViews.ACTION_NOOP;
            }
            final ViewGroup targetVg = (ViewGroup) target.mRoot;
            Context context = root.mRoot.getContext();
            final int nextChild = RemoteViews.getNextRecyclableChild(targetVg);
            if (nextChild >= 0 && this.mStableId != -1) {
                RemoteViews rvToApply = this.mNestedViews.getRemoteViewsToApply(context);
                final int recycledViewIndex = target.findChildIndex(nextChild, new Predicate() { // from class: android.widget.RemoteViews$ViewGroupActionAdd$$ExternalSyntheticLambda0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean lambda$initActionAsync$0;
                        lambda$initActionAsync$0 = RemoteViews.ViewGroupActionAdd.this.lambda$initActionAsync$0((View) obj);
                        return lambda$initActionAsync$0;
                    }
                });
                if (recycledViewIndex >= 0) {
                    ViewTree recycled = (ViewTree) target.mChildren.get(recycledViewIndex);
                    if (rvToApply.canRecycleView(recycled.mRoot)) {
                        if (recycledViewIndex > nextChild) {
                            target.removeChildren(nextChild, recycledViewIndex - nextChild);
                        }
                        RemoteViews.setNextRecyclableChild(targetVg, nextChild + 1, target.mChildren.size());
                        final AsyncApplyTask reapplyTask = rvToApply.getInternalAsyncApplyTask(context, targetVg, null, params, null, recycled.mRoot);
                        final ViewTree tree = reapplyTask.doInBackground(new Void[0]);
                        if (tree == null) {
                            throw new ActionException(reapplyTask.mError);
                        }
                        return new RuntimeAction() { // from class: android.widget.RemoteViews.ViewGroupActionAdd.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super();
                            }

                            @Override // android.widget.RemoteViews.Action
                            public void apply(View root2, ViewGroup rootParent2, ActionApplyParams params2) throws ActionException {
                                reapplyTask.onPostExecute(tree);
                                int i10 = recycledViewIndex;
                                int i11 = nextChild;
                                if (i10 > i11) {
                                    targetVg.removeViews(i11, i10 - i11);
                                }
                            }
                        };
                    }
                    target.removeChildren(nextChild, (recycledViewIndex - nextChild) + 1);
                    return insertNewView(context, target, params, new Runnable() { // from class: android.widget.RemoteViews$ViewGroupActionAdd$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewGroup.this.removeViews(r1, (recycledViewIndex - nextChild) + 1);
                        }
                    });
                }
            }
            return insertNewView(context, target, params, new Runnable() { // from class: android.widget.RemoteViews$ViewGroupActionAdd$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteViews.ViewGroupActionAdd.lambda$initActionAsync$2();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initActionAsync$0(View view) {
            return RemoteViews.getStableId(view) == this.mStableId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$initActionAsync$2() {
        }

        private Action insertNewView(Context context, ViewTree target, ActionApplyParams params, final Runnable finalizeAction) {
            final ViewGroup targetVg = (ViewGroup) target.mRoot;
            int nextChild = RemoteViews.getNextRecyclableChild(targetVg);
            final AsyncApplyTask task = this.mNestedViews.getInternalAsyncApplyTask(context, targetVg, null, params, null, null);
            final ViewTree tree = task.doInBackground(new Void[0]);
            if (tree == null) {
                throw new ActionException(task.mError);
            }
            if (this.mStableId != -1) {
                RemoteViews.setStableId(task.mResult, this.mStableId);
            }
            int i10 = this.mIndex;
            if (i10 < 0) {
                i10 = nextChild;
            }
            final int insertIndex = i10;
            target.addChild(tree, insertIndex);
            if (nextChild >= 0) {
                RemoteViews.setNextRecyclableChild(targetVg, nextChild + 1, target.mChildren.size());
            }
            return new RuntimeAction() { // from class: android.widget.RemoteViews.ViewGroupActionAdd.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.widget.RemoteViews.Action
                public void apply(View root, ViewGroup rootParent, ActionApplyParams params2) {
                    task.onPostExecute(tree);
                    finalizeAction.run();
                    targetVg.addView(task.mResult, insertIndex);
                }
            };
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return 1;
        }

        @Override // android.widget.RemoteViews.Action
        public boolean prefersAsyncApply() {
            return this.mNestedViews.prefersAsyncApply();
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 4;
        }

        @Override // android.widget.RemoteViews.Action
        public final void visitUris(Consumer<Uri> visitor) {
            this.mNestedViews.visitUris(visitor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ViewGroupActionRemove extends Action {
        private static final int REMOVE_ALL_VIEWS_ID = -2;
        private int mViewIdToKeep;

        ViewGroupActionRemove(int viewId) {
            this(viewId, -2);
        }

        ViewGroupActionRemove(int viewId, int viewIdToKeep) {
            super();
            this.viewId = viewId;
            this.mViewIdToKeep = viewIdToKeep;
        }

        ViewGroupActionRemove(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.mViewIdToKeep = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.mViewIdToKeep);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            ViewGroup target = (ViewGroup) root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (this.mViewIdToKeep == -2) {
                for (int i10 = target.getChildCount() - 1; i10 >= 0; i10--) {
                    if (!RemoteViews.hasStableId(target.getChildAt(i10))) {
                        target.removeViewAt(i10);
                    }
                }
                RemoteViews.setNextRecyclableChild(target, 0, target.getChildCount());
                return;
            }
            removeAllViewsExceptIdToKeep(target);
        }

        @Override // android.widget.RemoteViews.Action
        public Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            root.createTree();
            ViewTree target = root.findViewTreeById(this.viewId);
            if (target == null || !(target.mRoot instanceof ViewGroup)) {
                return RemoteViews.ACTION_NOOP;
            }
            final ViewGroup targetVg = (ViewGroup) target.mRoot;
            if (this.mViewIdToKeep == -2) {
                target.mChildren.removeIf(new Predicate() { // from class: android.widget.RemoteViews$ViewGroupActionRemove$$ExternalSyntheticLambda0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return RemoteViews.ViewGroupActionRemove.lambda$initActionAsync$0((RemoteViews.ViewTree) obj);
                    }
                });
                RemoteViews.setNextRecyclableChild(targetVg, 0, target.mChildren.size());
            } else {
                target.mChildren.removeIf(new Predicate() { // from class: android.widget.RemoteViews$ViewGroupActionRemove$$ExternalSyntheticLambda1
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        boolean lambda$initActionAsync$1;
                        lambda$initActionAsync$1 = RemoteViews.ViewGroupActionRemove.this.lambda$initActionAsync$1((RemoteViews.ViewTree) obj);
                        return lambda$initActionAsync$1;
                    }
                });
                if (target.mChildren.isEmpty()) {
                    target.mChildren = null;
                }
            }
            return new RuntimeAction() { // from class: android.widget.RemoteViews.ViewGroupActionRemove.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.widget.RemoteViews.Action
                public void apply(View root2, ViewGroup rootParent2, ActionApplyParams params2) {
                    if (ViewGroupActionRemove.this.mViewIdToKeep == -2) {
                        for (int i10 = targetVg.getChildCount() - 1; i10 >= 0; i10--) {
                            if (!RemoteViews.hasStableId(targetVg.getChildAt(i10))) {
                                targetVg.removeViewAt(i10);
                            }
                        }
                        return;
                    }
                    ViewGroupActionRemove.this.removeAllViewsExceptIdToKeep(targetVg);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean lambda$initActionAsync$0(ViewTree childTree) {
            return !RemoteViews.hasStableId(childTree.mRoot);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initActionAsync$1(ViewTree childTree) {
            return childTree.mRoot.getId() != this.mViewIdToKeep;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAllViewsExceptIdToKeep(ViewGroup viewGroup) {
            for (int index = viewGroup.getChildCount() - 1; index >= 0; index--) {
                if (viewGroup.getChildAt(index).getId() != this.mViewIdToKeep) {
                    viewGroup.removeViewAt(index);
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 7;
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoveFromParentAction extends Action {
        RemoveFromParentAction(int viewId) {
            super();
            this.viewId = viewId;
        }

        RemoveFromParentAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null || target == root) {
                return;
            }
            ViewParent parent = target.getParent();
            if (parent instanceof ViewManager) {
                ((ViewManager) parent).removeView(target);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            root.createTree();
            final ViewTree target = root.findViewTreeById(this.viewId);
            if (target == null || target == root) {
                return RemoteViews.ACTION_NOOP;
            }
            ViewTree parent = root.findViewTreeParentOf(target);
            if (parent == null || !(parent.mRoot instanceof ViewManager)) {
                return RemoteViews.ACTION_NOOP;
            }
            final ViewManager parentVg = (ViewManager) parent.mRoot;
            parent.mChildren.remove(target);
            return new RuntimeAction() { // from class: android.widget.RemoteViews.RemoveFromParentAction.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.widget.RemoteViews.Action
                public void apply(View root2, ViewGroup rootParent2, ActionApplyParams params2) {
                    parentVg.removeView(target.mRoot);
                }
            };
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 23;
        }

        @Override // android.widget.RemoteViews.Action
        public int mergeBehavior() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class TextViewDrawableAction extends Action {

        /* renamed from: d1, reason: collision with root package name */
        int f826d1;

        /* renamed from: d2, reason: collision with root package name */
        int f827d2;

        /* renamed from: d3, reason: collision with root package name */
        int f828d3;

        /* renamed from: d4, reason: collision with root package name */
        int f829d4;
        boolean drawablesLoaded;

        /* renamed from: i1, reason: collision with root package name */
        Icon f830i1;

        /* renamed from: i2, reason: collision with root package name */
        Icon f831i2;

        /* renamed from: i3, reason: collision with root package name */
        Icon f832i3;

        /* renamed from: i4, reason: collision with root package name */
        Icon f833i4;
        Drawable id1;
        Drawable id2;
        Drawable id3;
        Drawable id4;
        boolean isRelative;
        boolean useIcons;

        public TextViewDrawableAction(int viewId, boolean isRelative, int d12, int d22, int d32, int d42) {
            super();
            this.isRelative = false;
            this.useIcons = false;
            this.drawablesLoaded = false;
            this.viewId = viewId;
            this.isRelative = isRelative;
            this.useIcons = false;
            this.f826d1 = d12;
            this.f827d2 = d22;
            this.f828d3 = d32;
            this.f829d4 = d42;
        }

        public TextViewDrawableAction(int viewId, boolean isRelative, Icon i12, Icon i22, Icon i32, Icon i42) {
            super();
            this.isRelative = false;
            this.useIcons = false;
            this.drawablesLoaded = false;
            this.viewId = viewId;
            this.isRelative = isRelative;
            this.useIcons = true;
            this.f830i1 = i12;
            this.f831i2 = i22;
            this.f832i3 = i32;
            this.f833i4 = i42;
        }

        public TextViewDrawableAction(Parcel parcel) {
            super();
            this.isRelative = false;
            this.useIcons = false;
            this.drawablesLoaded = false;
            this.viewId = parcel.readInt();
            this.isRelative = parcel.readInt() != 0;
            boolean z10 = parcel.readInt() != 0;
            this.useIcons = z10;
            if (z10) {
                this.f830i1 = (Icon) parcel.readTypedObject(Icon.CREATOR);
                this.f831i2 = (Icon) parcel.readTypedObject(Icon.CREATOR);
                this.f832i3 = (Icon) parcel.readTypedObject(Icon.CREATOR);
                this.f833i4 = (Icon) parcel.readTypedObject(Icon.CREATOR);
                return;
            }
            this.f826d1 = parcel.readInt();
            this.f827d2 = parcel.readInt();
            this.f828d3 = parcel.readInt();
            this.f829d4 = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.viewId);
            parcel.writeInt(this.isRelative ? 1 : 0);
            parcel.writeInt(this.useIcons ? 1 : 0);
            if (this.useIcons) {
                parcel.writeTypedObject(this.f830i1, 0);
                parcel.writeTypedObject(this.f831i2, 0);
                parcel.writeTypedObject(this.f832i3, 0);
                parcel.writeTypedObject(this.f833i4, 0);
                return;
            }
            parcel.writeInt(this.f826d1);
            parcel.writeInt(this.f827d2);
            parcel.writeInt(this.f828d3);
            parcel.writeInt(this.f829d4);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            TextView target = (TextView) root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (this.drawablesLoaded) {
                if (this.isRelative) {
                    target.setCompoundDrawablesRelativeWithIntrinsicBounds(this.id1, this.id2, this.id3, this.id4);
                    return;
                } else {
                    target.setCompoundDrawablesWithIntrinsicBounds(this.id1, this.id2, this.id3, this.id4);
                    return;
                }
            }
            if (this.useIcons) {
                Context ctx = target.getContext();
                Icon icon = this.f830i1;
                Drawable id1 = icon == null ? null : icon.loadDrawable(ctx);
                Icon icon2 = this.f831i2;
                Drawable id2 = icon2 == null ? null : icon2.loadDrawable(ctx);
                Icon icon3 = this.f832i3;
                Drawable id3 = icon3 == null ? null : icon3.loadDrawable(ctx);
                Icon icon4 = this.f833i4;
                Drawable id4 = icon4 != null ? icon4.loadDrawable(ctx) : null;
                if (this.isRelative) {
                    target.setCompoundDrawablesRelativeWithIntrinsicBounds(id1, id2, id3, id4);
                    return;
                } else {
                    target.setCompoundDrawablesWithIntrinsicBounds(id1, id2, id3, id4);
                    return;
                }
            }
            if (this.isRelative) {
                target.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f826d1, this.f827d2, this.f828d3, this.f829d4);
            } else {
                target.setCompoundDrawablesWithIntrinsicBounds(this.f826d1, this.f827d2, this.f828d3, this.f829d4);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public Action initActionAsync(ViewTree root, ViewGroup rootParent, ActionApplyParams params) {
            TextViewDrawableAction copy;
            TextView target = (TextView) root.findViewById(this.viewId);
            if (target == null) {
                return RemoteViews.ACTION_NOOP;
            }
            if (this.useIcons) {
                copy = new TextViewDrawableAction(this.viewId, this.isRelative, this.f830i1, this.f831i2, this.f832i3, this.f833i4);
            } else {
                copy = new TextViewDrawableAction(this.viewId, this.isRelative, this.f826d1, this.f827d2, this.f828d3, this.f829d4);
            }
            copy.drawablesLoaded = true;
            Context ctx = target.getContext();
            if (this.useIcons) {
                Icon icon = this.f830i1;
                copy.id1 = icon == null ? null : icon.loadDrawable(ctx);
                Icon icon2 = this.f831i2;
                copy.id2 = icon2 == null ? null : icon2.loadDrawable(ctx);
                Icon icon3 = this.f832i3;
                copy.id3 = icon3 == null ? null : icon3.loadDrawable(ctx);
                Icon icon4 = this.f833i4;
                copy.id4 = icon4 != null ? icon4.loadDrawable(ctx) : null;
            } else {
                int i10 = this.f826d1;
                copy.id1 = i10 == 0 ? null : ctx.getDrawable(i10);
                int i11 = this.f827d2;
                copy.id2 = i11 == 0 ? null : ctx.getDrawable(i11);
                int i12 = this.f828d3;
                copy.id3 = i12 == 0 ? null : ctx.getDrawable(i12);
                int i13 = this.f829d4;
                copy.id4 = i13 != 0 ? ctx.getDrawable(i13) : null;
            }
            return copy;
        }

        @Override // android.widget.RemoteViews.Action
        public boolean prefersAsyncApply() {
            return this.useIcons;
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 11;
        }

        @Override // android.widget.RemoteViews.Action
        public void visitUris(Consumer<Uri> visitor) {
            if (this.useIcons) {
                RemoteViews.visitIconUri(this.f830i1, visitor);
                RemoteViews.visitIconUri(this.f831i2, visitor);
                RemoteViews.visitIconUri(this.f832i3, visitor);
                RemoteViews.visitIconUri(this.f833i4, visitor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class TextViewSizeAction extends Action {
        float size;
        int units;

        TextViewSizeAction(int viewId, int units, float size) {
            super();
            this.viewId = viewId;
            this.units = units;
            this.size = size;
        }

        TextViewSizeAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.units = parcel.readInt();
            this.size = parcel.readFloat();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.units);
            dest.writeFloat(this.size);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            TextView target = (TextView) root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            target.setTextSize(this.units, this.size);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ViewPaddingAction extends Action {
        int bottom;
        int left;
        int right;
        int top;

        public ViewPaddingAction(int viewId, int left, int top, int right, int bottom) {
            super();
            this.viewId = viewId;
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        public ViewPaddingAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.left = parcel.readInt();
            this.top = parcel.readInt();
            this.right = parcel.readInt();
            this.bottom = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.left);
            dest.writeInt(this.top);
            dest.writeInt(this.right);
            dest.writeInt(this.bottom);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            target.setPadding(this.left, this.top, this.right, this.bottom);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 14;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class LayoutParamAction extends Action {
        static final int LAYOUT_HEIGHT = 9;
        static final int LAYOUT_MARGIN_BOTTOM = 3;
        static final int LAYOUT_MARGIN_END = 5;
        static final int LAYOUT_MARGIN_LEFT = 0;
        static final int LAYOUT_MARGIN_RIGHT = 2;
        static final int LAYOUT_MARGIN_START = 4;
        static final int LAYOUT_MARGIN_TOP = 1;
        static final int LAYOUT_WIDTH = 8;
        final int mProperty;
        final int mValue;
        final int mValueType;

        LayoutParamAction(int viewId, int property, float value, int units) {
            super();
            this.viewId = viewId;
            this.mProperty = property;
            this.mValueType = 2;
            this.mValue = TypedValue.createComplexDimension(value, units);
        }

        LayoutParamAction(int viewId, int property, int value, int valueType) {
            super();
            this.viewId = viewId;
            this.mProperty = property;
            this.mValueType = valueType;
            this.mValue = value;
        }

        public LayoutParamAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.mProperty = parcel.readInt();
            this.mValueType = parcel.readInt();
            this.mValue = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.mProperty);
            dest.writeInt(this.mValueType);
            dest.writeInt(this.mValue);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            ViewGroup.LayoutParams layoutParams;
            View target = root.findViewById(this.viewId);
            if (target == null || (layoutParams = target.getLayoutParams()) == null) {
                return;
            }
            switch (this.mProperty) {
                case 0:
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = getPixelOffset(target);
                        target.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                case 1:
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = getPixelOffset(target);
                        target.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                case 2:
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = getPixelOffset(target);
                        target.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                case 3:
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = getPixelOffset(target);
                        target.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                case 4:
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(getPixelOffset(target));
                        target.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                case 5:
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(getPixelOffset(target));
                        target.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                case 6:
                case 7:
                default:
                    throw new IllegalArgumentException("Unknown property " + this.mProperty);
                case 8:
                    layoutParams.width = getPixelSize(target);
                    target.setLayoutParams(layoutParams);
                    return;
                case 9:
                    layoutParams.height = getPixelSize(target);
                    target.setLayoutParams(layoutParams);
                    return;
            }
        }

        private int getPixelOffset(View target) {
            try {
                switch (this.mValueType) {
                    case 2:
                        return TypedValue.complexToDimensionPixelOffset(this.mValue, target.getResources().getDisplayMetrics());
                    case 3:
                        if (this.mValue == 0) {
                            return 0;
                        }
                        return target.getResources().getDimensionPixelOffset(this.mValue);
                    case 4:
                        TypedArray typedArray = target.getContext().obtainStyledAttributes(new int[]{this.mValue});
                        try {
                            return typedArray.getDimensionPixelOffset(0, 0);
                        } finally {
                            typedArray.recycle();
                        }
                    default:
                        return this.mValue;
                }
            } catch (Throwable t2) {
                throw new ActionException(t2);
            }
            throw new ActionException(t2);
        }

        private int getPixelSize(View target) {
            try {
                switch (this.mValueType) {
                    case 2:
                        return TypedValue.complexToDimensionPixelSize(this.mValue, target.getResources().getDisplayMetrics());
                    case 3:
                        if (this.mValue == 0) {
                            return 0;
                        }
                        return target.getResources().getDimensionPixelSize(this.mValue);
                    case 4:
                        TypedArray typedArray = target.getContext().obtainStyledAttributes(new int[]{this.mValue});
                        try {
                            return typedArray.getDimensionPixelSize(0, 0);
                        } finally {
                            typedArray.recycle();
                        }
                    default:
                        return this.mValue;
                }
            } catch (Throwable t2) {
                throw new ActionException(t2);
            }
            throw new ActionException(t2);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 19;
        }

        @Override // android.widget.RemoteViews.Action
        public String getUniqueKey() {
            return super.getUniqueKey() + this.mProperty;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetRemoteInputsAction extends Action {
        final Parcelable[] remoteInputs;

        public SetRemoteInputsAction(int viewId, RemoteInput[] remoteInputs) {
            super();
            this.viewId = viewId;
            this.remoteInputs = remoteInputs;
        }

        public SetRemoteInputsAction(Parcel parcel) {
            super();
            this.viewId = parcel.readInt();
            this.remoteInputs = (Parcelable[]) parcel.createTypedArray(RemoteInput.CREATOR);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeTypedArray(this.remoteInputs, flags);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            target.setTagInternal(16909425, this.remoteInputs);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class OverrideTextColorsAction extends Action {
        private final int textColor;

        public OverrideTextColorsAction(int textColor) {
            super();
            this.textColor = textColor;
        }

        public OverrideTextColorsAction(Parcel parcel) {
            super();
            this.textColor = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.textColor);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            Stack<View> viewsToProcess = new Stack<>();
            viewsToProcess.add(root);
            while (!viewsToProcess.isEmpty()) {
                View v2 = viewsToProcess.pop();
                if (v2 instanceof TextView) {
                    TextView textView = (TextView) v2;
                    textView.setText(ContrastColorUtil.clearColorSpans(textView.getText()));
                    textView.setTextColor(this.textColor);
                }
                if (v2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v2;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        viewsToProcess.push(viewGroup.getChildAt(i10));
                    }
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 20;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetIntTagAction extends Action {
        private final int mKey;
        private final int mTag;
        private final int mViewId;

        SetIntTagAction(int viewId, int key, int tag) {
            super();
            this.mViewId = viewId;
            this.mKey = key;
            this.mTag = tag;
        }

        SetIntTagAction(Parcel parcel) {
            super();
            this.mViewId = parcel.readInt();
            this.mKey = parcel.readInt();
            this.mTag = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mViewId);
            dest.writeInt(this.mKey);
            dest.writeInt(this.mTag);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) {
            View target = root.findViewById(this.mViewId);
            if (target == null) {
                return;
            }
            target.setTagInternal(this.mKey, Integer.valueOf(this.mTag));
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 22;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetCompoundButtonCheckedAction extends Action {
        private final boolean mChecked;

        SetCompoundButtonCheckedAction(int viewId, boolean checked) {
            super();
            this.viewId = viewId;
            this.mChecked = checked;
        }

        SetCompoundButtonCheckedAction(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.mChecked = in.readBoolean();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeBoolean(this.mChecked);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) throws ActionException {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (!(target instanceof CompoundButton)) {
                Log.w(RemoteViews.LOG_TAG, "Cannot set checked to view " + this.viewId + " because it is not a CompoundButton");
                return;
            }
            CompoundButton button = (CompoundButton) target;
            Object tag = button.getTag(16909421);
            if (tag instanceof CompoundButton.OnCheckedChangeListener) {
                button.setOnCheckedChangeListener(null);
                button.setChecked(this.mChecked);
                button.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) tag);
                return;
            }
            button.setChecked(this.mChecked);
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 26;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetRadioGroupCheckedAction extends Action {
        private final int mCheckedId;

        SetRadioGroupCheckedAction(int viewId, int checkedId) {
            super();
            this.viewId = viewId;
            this.mCheckedId = checkedId;
        }

        SetRadioGroupCheckedAction(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.mCheckedId = in.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.mCheckedId);
        }

        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) throws ActionException {
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            if (!(target instanceof RadioGroup)) {
                Log.w(RemoteViews.LOG_TAG, "Cannot check " + this.viewId + " because it's not a RadioGroup");
                return;
            }
            RadioGroup group = (RadioGroup) target;
            for (int i10 = 0; i10 < group.getChildCount(); i10++) {
                View child = group.getChildAt(i10);
                if ((child instanceof CompoundButton) && (child.getTag(16909421) instanceof CompoundButton.OnCheckedChangeListener)) {
                    ((CompoundButton) child).setOnCheckedChangeListener(null);
                }
            }
            int i11 = this.mCheckedId;
            group.check(i11);
            for (int i12 = 0; i12 < group.getChildCount(); i12++) {
                View child2 = group.getChildAt(i12);
                if (child2 instanceof CompoundButton) {
                    Object tag = child2.getTag(16909421);
                    if (tag instanceof CompoundButton.OnCheckedChangeListener) {
                        ((CompoundButton) child2).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) tag);
                    }
                }
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 27;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SetViewOutlinePreferredRadiusAction extends Action {
        private final int mValue;
        private final int mValueType;

        SetViewOutlinePreferredRadiusAction(int viewId, int value, int valueType) {
            super();
            this.viewId = viewId;
            this.mValueType = valueType;
            this.mValue = value;
        }

        SetViewOutlinePreferredRadiusAction(int viewId, float radius, int units) {
            super();
            this.viewId = viewId;
            this.mValueType = 2;
            this.mValue = TypedValue.createComplexDimension(radius, units);
        }

        SetViewOutlinePreferredRadiusAction(Parcel in) {
            super();
            this.viewId = in.readInt();
            this.mValueType = in.readInt();
            this.mValue = in.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.viewId);
            dest.writeInt(this.mValueType);
            dest.writeInt(this.mValue);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000c. Please report as an issue. */
        @Override // android.widget.RemoteViews.Action
        public void apply(View root, ViewGroup rootParent, ActionApplyParams params) throws ActionException {
            float radius;
            View target = root.findViewById(this.viewId);
            if (target == null) {
                return;
            }
            try {
                switch (this.mValueType) {
                    case 2:
                        radius = TypedValue.complexToDimension(this.mValue, target.getResources().getDisplayMetrics());
                        target.setOutlineProvider(new RemoteViewOutlineProvider(radius));
                        return;
                    case 3:
                        radius = this.mValue != 0 ? target.getResources().getDimension(this.mValue) : 0.0f;
                        target.setOutlineProvider(new RemoteViewOutlineProvider(radius));
                        return;
                    case 4:
                        TypedArray typedArray = target.getContext().obtainStyledAttributes(new int[]{this.mValue});
                        try {
                            radius = typedArray.getDimension(0, 0.0f);
                            typedArray.recycle();
                            target.setOutlineProvider(new RemoteViewOutlineProvider(radius));
                            return;
                        } catch (Throwable th) {
                            typedArray.recycle();
                            throw th;
                        }
                    default:
                        radius = this.mValue;
                        target.setOutlineProvider(new RemoteViewOutlineProvider(radius));
                        return;
                }
            } catch (Throwable t2) {
                throw new ActionException(t2);
            }
        }

        @Override // android.widget.RemoteViews.Action
        public int getActionTag() {
            return 28;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RemoteViewOutlineProvider extends ViewOutlineProvider {
        private final float mRadius;

        public RemoteViewOutlineProvider(float radius) {
            this.mRadius = radius;
        }

        public float getRadius() {
            return this.mRadius;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.mRadius);
        }
    }

    public RemoteViews(String packageName, int layoutId) {
        this(getApplicationInfo(packageName, UserHandle.myUserId()), layoutId);
    }

    public RemoteViews(String packageName, int layoutId, int viewId) {
        this(packageName, layoutId);
        this.mViewId = viewId;
    }

    protected RemoteViews(ApplicationInfo application, int layoutId) {
        this.mLightBackgroundLayoutId = 0;
        this.mBitmapCache = new BitmapCache();
        ApplicationInfoCache applicationInfoCache = new ApplicationInfoCache();
        this.mApplicationInfoCache = applicationInfoCache;
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mSizedRemoteViews = null;
        this.mIdealSize = null;
        this.mApplyFlags = 0;
        this.mViewId = -1;
        this.mProviderInstanceId = -1L;
        this.mApplication = application;
        this.mLayoutId = layoutId;
        applicationInfoCache.put(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasMultipleLayouts() {
        return hasLandscapeAndPortraitLayouts() || hasSizedRemoteViews();
    }

    private boolean hasLandscapeAndPortraitLayouts() {
        return (this.mLandscape == null || this.mPortrait == null) ? false : true;
    }

    private boolean hasSizedRemoteViews() {
        return this.mSizedRemoteViews != null;
    }

    private SizeF getIdealSize() {
        return this.mIdealSize;
    }

    private void setIdealSize(SizeF size) {
        this.mIdealSize = size;
    }

    private RemoteViews findSmallestRemoteView() {
        return this.mSizedRemoteViews.get(r0.size() - 1);
    }

    public RemoteViews(RemoteViews landscape, RemoteViews portrait) {
        this.mLightBackgroundLayoutId = 0;
        this.mBitmapCache = new BitmapCache();
        this.mApplicationInfoCache = new ApplicationInfoCache();
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mSizedRemoteViews = null;
        this.mIdealSize = null;
        this.mApplyFlags = 0;
        this.mViewId = -1;
        this.mProviderInstanceId = -1L;
        if (landscape == null || portrait == null) {
            throw new IllegalArgumentException("Both RemoteViews must be non-null");
        }
        if (!landscape.hasSameAppInfo(portrait.mApplication)) {
            throw new IllegalArgumentException("Both RemoteViews must share the same package and user");
        }
        this.mApplication = portrait.mApplication;
        this.mLayoutId = portrait.mLayoutId;
        this.mViewId = portrait.mViewId;
        this.mLightBackgroundLayoutId = portrait.mLightBackgroundLayoutId;
        this.mLandscape = landscape;
        this.mPortrait = portrait;
        Map<Class, Object> map = portrait.mClassCookies;
        this.mClassCookies = map == null ? landscape.mClassCookies : map;
        configureDescendantsAsChildren();
    }

    public RemoteViews(Map<SizeF, RemoteViews> remoteViews) {
        this.mLightBackgroundLayoutId = 0;
        this.mBitmapCache = new BitmapCache();
        this.mApplicationInfoCache = new ApplicationInfoCache();
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mSizedRemoteViews = null;
        this.mIdealSize = null;
        this.mApplyFlags = 0;
        this.mViewId = -1;
        this.mProviderInstanceId = -1L;
        if (remoteViews.isEmpty()) {
            throw new IllegalArgumentException("The set of RemoteViews cannot be empty");
        }
        if (remoteViews.size() <= 16) {
            if (remoteViews.size() == 1) {
                RemoteViews single = remoteViews.values().iterator2().next();
                initializeFrom(single, single);
                return;
            }
            this.mClassCookies = initializeSizedRemoteViews(remoteViews.entrySet().stream().map(new Function() { // from class: android.widget.RemoteViews$$ExternalSyntheticLambda2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return RemoteViews.lambda$new$2((Map.Entry) obj);
                }
            }).iterator());
            RemoteViews smallestView = findSmallestRemoteView();
            this.mApplication = smallestView.mApplication;
            this.mLayoutId = smallestView.mLayoutId;
            this.mViewId = smallestView.mViewId;
            this.mLightBackgroundLayoutId = smallestView.mLightBackgroundLayoutId;
            configureDescendantsAsChildren();
            return;
        }
        throw new IllegalArgumentException("Too many RemoteViews in constructor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ RemoteViews lambda$new$2(Map.Entry entry) {
        ((RemoteViews) entry.getValue()).setIdealSize((SizeF) entry.getKey());
        return (RemoteViews) entry.getValue();
    }

    private Map<Class, Object> initializeSizedRemoteViews(Iterator<RemoteViews> remoteViews) {
        List<RemoteViews> sizedRemoteViews = new ArrayList<>();
        Map<Class, Object> classCookies = null;
        float viewArea = Float.MAX_VALUE;
        RemoteViews smallestView = null;
        while (remoteViews.hasNext()) {
            RemoteViews view = remoteViews.next();
            SizeF size = view.getIdealSize();
            if (size == null) {
                throw new IllegalStateException("Expected RemoteViews to have ideal size");
            }
            float newViewArea = size.getWidth() * size.getHeight();
            if (smallestView != null && !view.hasSameAppInfo(smallestView.mApplication)) {
                throw new IllegalArgumentException("All RemoteViews must share the same package and user");
            }
            if (smallestView == null || newViewArea < viewArea) {
                if (smallestView != null) {
                    sizedRemoteViews.add(smallestView);
                }
                viewArea = newViewArea;
                smallestView = view;
            } else {
                sizedRemoteViews.add(view);
            }
            view.setIdealSize(size);
            if (classCookies == null) {
                classCookies = view.mClassCookies;
            }
        }
        sizedRemoteViews.add(smallestView);
        this.mSizedRemoteViews = sizedRemoteViews;
        return classCookies;
    }

    public RemoteViews(RemoteViews src) {
        this.mLightBackgroundLayoutId = 0;
        this.mBitmapCache = new BitmapCache();
        this.mApplicationInfoCache = new ApplicationInfoCache();
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mSizedRemoteViews = null;
        this.mIdealSize = null;
        this.mApplyFlags = 0;
        this.mViewId = -1;
        this.mProviderInstanceId = -1L;
        initializeFrom(src, null);
    }

    private RemoteViews() {
        this.mLightBackgroundLayoutId = 0;
        this.mBitmapCache = new BitmapCache();
        this.mApplicationInfoCache = new ApplicationInfoCache();
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mSizedRemoteViews = null;
        this.mIdealSize = null;
        this.mApplyFlags = 0;
        this.mViewId = -1;
        this.mProviderInstanceId = -1L;
    }

    private static RemoteViews createInitializedFrom(RemoteViews src, RemoteViews hierarchyRoot) {
        RemoteViews child = new RemoteViews();
        child.initializeFrom(src, hierarchyRoot);
        return child;
    }

    private void initializeFrom(RemoteViews src, RemoteViews hierarchyRoot) {
        if (hierarchyRoot == null) {
            this.mBitmapCache = src.mBitmapCache;
            this.mApplicationInfoCache = src.mApplicationInfoCache;
        } else {
            this.mBitmapCache = hierarchyRoot.mBitmapCache;
            this.mApplicationInfoCache = hierarchyRoot.mApplicationInfoCache;
        }
        if (hierarchyRoot == null || src.mIsRoot) {
            this.mIsRoot = true;
            hierarchyRoot = this;
        } else {
            this.mIsRoot = false;
        }
        this.mApplication = src.mApplication;
        this.mLayoutId = src.mLayoutId;
        this.mLightBackgroundLayoutId = src.mLightBackgroundLayoutId;
        this.mApplyFlags = src.mApplyFlags;
        this.mClassCookies = src.mClassCookies;
        this.mIdealSize = src.mIdealSize;
        this.mProviderInstanceId = src.mProviderInstanceId;
        if (src.hasLandscapeAndPortraitLayouts()) {
            this.mLandscape = createInitializedFrom(src.mLandscape, hierarchyRoot);
            this.mPortrait = createInitializedFrom(src.mPortrait, hierarchyRoot);
        }
        if (src.hasSizedRemoteViews()) {
            this.mSizedRemoteViews = new ArrayList(src.mSizedRemoteViews.size());
            for (RemoteViews srcView : src.mSizedRemoteViews) {
                this.mSizedRemoteViews.add(createInitializedFrom(srcView, hierarchyRoot));
            }
        }
        if (src.mActions != null) {
            Parcel p10 = Parcel.obtain();
            p10.putClassCookies(this.mClassCookies);
            src.writeActionsToParcel(p10, 0);
            p10.setDataPosition(0);
            readActionsFromParcel(p10, 0);
            p10.recycle();
        }
        if (this.mIsRoot) {
            reconstructCaches();
        }
    }

    public RemoteViews(Parcel parcel) {
        this(parcel, null, null, 0);
    }

    private RemoteViews(Parcel parcel, HierarchyRootData rootData, ApplicationInfo info, int depth) {
        this.mLightBackgroundLayoutId = 0;
        this.mBitmapCache = new BitmapCache();
        this.mApplicationInfoCache = new ApplicationInfoCache();
        this.mIsRoot = true;
        this.mLandscape = null;
        this.mPortrait = null;
        this.mSizedRemoteViews = null;
        this.mIdealSize = null;
        this.mApplyFlags = 0;
        this.mViewId = -1;
        this.mProviderInstanceId = -1L;
        if (depth > 10 && UserHandle.getAppId(Binder.getCallingUid()) != 1000) {
            throw new IllegalArgumentException("Too many nested views.");
        }
        int depth2 = depth + 1;
        int mode = parcel.readInt();
        if (rootData == null) {
            this.mBitmapCache = new BitmapCache(parcel);
            this.mClassCookies = parcel.copyClassCookies();
        } else {
            configureAsChild(rootData);
        }
        if (mode == 0) {
            this.mApplication = (ApplicationInfo) ApplicationInfo.CREATOR.createFromParcel(parcel);
            this.mIdealSize = parcel.readInt() != 0 ? (SizeF) SizeF.CREATOR.createFromParcel(parcel) : null;
            this.mLayoutId = parcel.readInt();
            this.mViewId = parcel.readInt();
            this.mLightBackgroundLayoutId = parcel.readInt();
            readActionsFromParcel(parcel, depth2);
        } else if (mode == 2) {
            int numViews = parcel.readInt();
            if (numViews > 16) {
                throw new IllegalArgumentException("Too many views in mapping from size to RemoteViews.");
            }
            List<RemoteViews> remoteViews = new ArrayList<>(numViews);
            for (int i10 = 0; i10 < numViews; i10++) {
                RemoteViews view = new RemoteViews(parcel, getHierarchyRootData(), info, depth2);
                info = view.mApplication;
                remoteViews.add(view);
            }
            initializeSizedRemoteViews(remoteViews.iterator2());
            RemoteViews smallestView = findSmallestRemoteView();
            this.mApplication = smallestView.mApplication;
            this.mLayoutId = smallestView.mLayoutId;
            this.mViewId = smallestView.mViewId;
            this.mLightBackgroundLayoutId = smallestView.mLightBackgroundLayoutId;
        } else {
            this.mLandscape = new RemoteViews(parcel, getHierarchyRootData(), info, depth2);
            RemoteViews remoteViews2 = new RemoteViews(parcel, getHierarchyRootData(), this.mLandscape.mApplication, depth2);
            this.mPortrait = remoteViews2;
            this.mApplication = remoteViews2.mApplication;
            this.mLayoutId = remoteViews2.mLayoutId;
            this.mViewId = remoteViews2.mViewId;
            this.mLightBackgroundLayoutId = remoteViews2.mLightBackgroundLayoutId;
        }
        this.mApplyFlags = parcel.readInt();
        this.mProviderInstanceId = parcel.readLong();
        if (this.mIsRoot) {
            configureDescendantsAsChildren();
        }
    }

    private void readActionsFromParcel(Parcel parcel, int depth) {
        int count = parcel.readInt();
        if (count > 0) {
            this.mActions = new ArrayList<>(count);
            for (int i10 = 0; i10 < count; i10++) {
                this.mActions.add(getActionFromParcel(parcel, depth));
            }
        }
    }

    private Action getActionFromParcel(Parcel parcel, int depth) {
        int tag = parcel.readInt();
        switch (tag) {
            case 1:
                return new SetOnClickResponse(parcel);
            case 2:
                return new ReflectionAction(parcel);
            case 3:
                return new SetDrawableTint(parcel);
            case 4:
                return new ViewGroupActionAdd(parcel, this.mApplication, depth);
            case 5:
                return new ViewContentNavigation(parcel);
            case 6:
                return new SetEmptyView(parcel);
            case 7:
                return new ViewGroupActionRemove(parcel);
            case 8:
                return new SetPendingIntentTemplate(parcel);
            case 9:
            case 16:
            case 17:
            default:
                throw new ActionException("Tag " + tag + " not found");
            case 10:
                return new SetRemoteViewsAdapterIntent(parcel);
            case 11:
                return new TextViewDrawableAction(parcel);
            case 12:
                return new BitmapReflectionAction(parcel);
            case 13:
                return new TextViewSizeAction(parcel);
            case 14:
                return new ViewPaddingAction(parcel);
            case 15:
                return new SetRemoteViewsAdapterList(parcel);
            case 18:
                return new SetRemoteInputsAction(parcel);
            case 19:
                return new LayoutParamAction(parcel);
            case 20:
                return new OverrideTextColorsAction(parcel);
            case 21:
                return new SetRippleDrawableColor(parcel);
            case 22:
                return new SetIntTagAction(parcel);
            case 23:
                return new RemoveFromParentAction(parcel);
            case 24:
                return new ResourceReflectionAction(parcel);
            case 25:
                return new ComplexUnitDimensionReflectionAction(parcel);
            case 26:
                return new SetCompoundButtonCheckedAction(parcel);
            case 27:
                return new SetRadioGroupCheckedAction(parcel);
            case 28:
                return new SetViewOutlinePreferredRadiusAction(parcel);
            case 29:
                return new SetOnCheckedChangeResponse(parcel);
            case 30:
                return new NightModeReflectionAction(parcel);
            case 31:
                return new SetRemoteCollectionItemListAdapterAction(parcel);
            case 32:
                return new AttributeReflectionAction(parcel);
        }
    }

    @Deprecated
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RemoteViews m1367clone() {
        Preconditions.checkState(this.mIsRoot, "RemoteView has been attached to another RemoteView. May only clone the root of a RemoteView hierarchy.");
        return new RemoteViews(this);
    }

    public String getPackage() {
        ApplicationInfo applicationInfo = this.mApplication;
        if (applicationInfo != null) {
            return applicationInfo.packageName;
        }
        return null;
    }

    public int getLayoutId() {
        int i10;
        return (!hasFlags(4) || (i10 = this.mLightBackgroundLayoutId) == 0) ? this.mLayoutId : i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureAsChild(HierarchyRootData rootData) {
        this.mIsRoot = false;
        this.mBitmapCache = rootData.mBitmapCache;
        this.mApplicationInfoCache = rootData.mApplicationInfoCache;
        this.mClassCookies = rootData.mClassCookies;
        configureDescendantsAsChildren();
    }

    private void configureDescendantsAsChildren() {
        this.mApplication = this.mApplicationInfoCache.getOrPut(this.mApplication);
        HierarchyRootData rootData = getHierarchyRootData();
        if (hasSizedRemoteViews()) {
            for (RemoteViews remoteView : this.mSizedRemoteViews) {
                remoteView.configureAsChild(rootData);
            }
            return;
        }
        if (hasLandscapeAndPortraitLayouts()) {
            this.mLandscape.configureAsChild(rootData);
            this.mPortrait.configureAsChild(rootData);
            return;
        }
        ArrayList<Action> arrayList = this.mActions;
        if (arrayList != null) {
            Iterator<Action> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                Action action = iterator2.next();
                action.setHierarchyRootData(rootData);
            }
        }
    }

    private void reconstructCaches() {
        if (this.mIsRoot) {
            this.mBitmapCache = new BitmapCache();
            ApplicationInfoCache applicationInfoCache = new ApplicationInfoCache();
            this.mApplicationInfoCache = applicationInfoCache;
            this.mApplication = applicationInfoCache.getOrPut(this.mApplication);
            configureDescendantsAsChildren();
        }
    }

    public int estimateMemoryUsage() {
        return this.mBitmapCache.getBitmapMemory();
    }

    private void addAction(Action a10) {
        if (hasMultipleLayouts()) {
            throw new RuntimeException("RemoteViews specifying separate layouts for orientation or size cannot be modified. Instead, fully configure each layouts individually before constructing the combined layout.");
        }
        if (this.mActions == null) {
            this.mActions = new ArrayList<>();
        }
        this.mActions.add(a10);
        if (DEBUG_REMOTEVIEWS && this.mActions.size() % 100 == 0) {
            Log.w(LOG_TAG, "addAction " + a10.getUniqueKey() + "\nmActions size = " + this.mActions.size() + "\nstack trace = " + Debug.getCallers(DEBUG_DEPTH));
        }
    }

    public void addView(int viewId, RemoteViews nestedView) {
        Action viewGroupActionAdd;
        if (nestedView == null) {
            viewGroupActionAdd = new ViewGroupActionRemove(viewId);
        } else {
            viewGroupActionAdd = new ViewGroupActionAdd(this, viewId, nestedView);
        }
        addAction(viewGroupActionAdd);
    }

    public void addStableView(int viewId, RemoteViews nestedView, int stableId) {
        addAction(new ViewGroupActionAdd(viewId, nestedView, -1, stableId));
    }

    public void addView(int viewId, RemoteViews nestedView, int index) {
        addAction(new ViewGroupActionAdd(this, viewId, nestedView, index));
    }

    public void removeAllViews(int viewId) {
        addAction(new ViewGroupActionRemove(viewId));
    }

    public void removeAllViewsExceptId(int viewId, int viewIdToKeep) {
        addAction(new ViewGroupActionRemove(viewId, viewIdToKeep));
    }

    public void removeFromParent(int viewId) {
        addAction(new RemoveFromParentAction(viewId));
    }

    @Deprecated
    public void showNext(int viewId) {
        addAction(new ViewContentNavigation(viewId, true));
    }

    @Deprecated
    public void showPrevious(int viewId) {
        addAction(new ViewContentNavigation(viewId, false));
    }

    public void setDisplayedChild(int viewId, int childIndex) {
        setInt(viewId, "setDisplayedChild", childIndex);
    }

    public void setViewVisibility(int viewId, int visibility) {
        setInt(viewId, "setVisibility", visibility);
    }

    public void setTextViewText(int viewId, CharSequence text) {
        setCharSequence(viewId, "setText", text);
    }

    public void setTextViewTextSize(int viewId, int units, float size) {
        addAction(new TextViewSizeAction(viewId, units, size));
    }

    public void setTextViewCompoundDrawables(int viewId, int left, int top, int right, int bottom) {
        addAction(new TextViewDrawableAction(viewId, false, left, top, right, bottom));
    }

    public void setTextViewCompoundDrawablesRelative(int viewId, int start, int top, int end, int bottom) {
        addAction(new TextViewDrawableAction(viewId, true, start, top, end, bottom));
    }

    public void setTextViewCompoundDrawables(int viewId, Icon left, Icon top, Icon right, Icon bottom) {
        addAction(new TextViewDrawableAction(viewId, false, left, top, right, bottom));
    }

    public void setTextViewCompoundDrawablesRelative(int viewId, Icon start, Icon top, Icon end, Icon bottom) {
        addAction(new TextViewDrawableAction(viewId, true, start, top, end, bottom));
    }

    public void setImageViewResource(int viewId, int srcId) {
        setInt(viewId, "setImageResource", srcId);
    }

    public void setImageViewUri(int viewId, Uri uri) {
        setUri(viewId, "setImageURI", uri);
    }

    public void setImageViewBitmap(int viewId, Bitmap bitmap) {
        setBitmap(viewId, "setImageBitmap", bitmap);
    }

    public void setImageViewIcon(int viewId, Icon icon) {
        setIcon(viewId, "setImageIcon", icon);
    }

    public void setEmptyView(int viewId, int emptyViewId) {
        addAction(new SetEmptyView(viewId, emptyViewId));
    }

    public void setChronometer(int viewId, long base, String format, boolean started) {
        setLong(viewId, "setBase", base);
        setString(viewId, "setFormat", format);
        setBoolean(viewId, "setStarted", started);
    }

    public void setChronometerCountDown(int viewId, boolean isCountDown) {
        setBoolean(viewId, "setCountDown", isCountDown);
    }

    public void setProgressBar(int viewId, int max, int progress, boolean indeterminate) {
        setBoolean(viewId, "setIndeterminate", indeterminate);
        if (!indeterminate) {
            setInt(viewId, "setMax", max);
            setInt(viewId, "setProgress", progress);
        }
    }

    public void setOnClickPendingIntent(int viewId, PendingIntent pendingIntent) {
        setOnClickResponse(viewId, RemoteResponse.fromPendingIntent(pendingIntent));
    }

    public void setOnClickResponse(int viewId, RemoteResponse response) {
        addAction(new SetOnClickResponse(viewId, response));
    }

    public void setPendingIntentTemplate(int viewId, PendingIntent pendingIntentTemplate) {
        addAction(new SetPendingIntentTemplate(viewId, pendingIntentTemplate));
    }

    public void setOnClickFillInIntent(int viewId, Intent fillInIntent) {
        setOnClickResponse(viewId, RemoteResponse.fromFillInIntent(fillInIntent));
    }

    public void setOnCheckedChangeResponse(int viewId, RemoteResponse response) {
        addAction(new SetOnCheckedChangeResponse(viewId, response.setInteractionType(1)));
    }

    public void setDrawableTint(int viewId, boolean targetBackground, int colorFilter, PorterDuff.Mode mode) {
        addAction(new SetDrawableTint(viewId, targetBackground, colorFilter, mode));
    }

    public void setRippleDrawableColor(int viewId, ColorStateList colorStateList) {
        addAction(new SetRippleDrawableColor(viewId, colorStateList));
    }

    public void setProgressTintList(int viewId, ColorStateList tint) {
        addAction(new ReflectionAction(viewId, "setProgressTintList", 15, tint));
    }

    public void setProgressBackgroundTintList(int viewId, ColorStateList tint) {
        addAction(new ReflectionAction(viewId, "setProgressBackgroundTintList", 15, tint));
    }

    public void setProgressIndeterminateTintList(int viewId, ColorStateList tint) {
        addAction(new ReflectionAction(viewId, "setIndeterminateTintList", 15, tint));
    }

    public void setTextColor(int viewId, int color) {
        setInt(viewId, "setTextColor", color);
    }

    public void setTextColor(int viewId, ColorStateList colors) {
        addAction(new ReflectionAction(viewId, "setTextColor", 15, colors));
    }

    @Deprecated
    public void setRemoteAdapter(int appWidgetId, int viewId, Intent intent) {
        setRemoteAdapter(viewId, intent);
    }

    public void setRemoteAdapter(int viewId, Intent intent) {
        addAction(new SetRemoteViewsAdapterIntent(viewId, intent));
    }

    @Deprecated
    public void setRemoteAdapter(int viewId, ArrayList<RemoteViews> list, int viewTypeCount) {
        addAction(new SetRemoteViewsAdapterList(viewId, list, viewTypeCount));
    }

    public void setRemoteAdapter(int viewId, RemoteCollectionItems items) {
        addAction(new SetRemoteCollectionItemListAdapterAction(viewId, items));
    }

    public void setScrollPosition(int viewId, int position) {
        setInt(viewId, "smoothScrollToPosition", position);
    }

    public void setRelativeScrollPosition(int viewId, int offset) {
        setInt(viewId, "smoothScrollByOffset", offset);
    }

    public void setViewPadding(int viewId, int left, int top, int right, int bottom) {
        addAction(new ViewPaddingAction(viewId, left, top, right, bottom));
    }

    public void setViewLayoutMarginDimen(int viewId, int type, int dimen) {
        addAction(new LayoutParamAction(viewId, type, dimen, 3));
    }

    public void setViewLayoutMarginAttr(int viewId, int type, int attr) {
        addAction(new LayoutParamAction(viewId, type, attr, 4));
    }

    public void setViewLayoutMargin(int viewId, int type, float value, int units) {
        addAction(new LayoutParamAction(viewId, type, value, units));
    }

    public void setViewLayoutWidth(int viewId, float width, int units) {
        addAction(new LayoutParamAction(viewId, 8, width, units));
    }

    public void setViewLayoutWidthDimen(int viewId, int widthDimen) {
        addAction(new LayoutParamAction(viewId, 8, widthDimen, 3));
    }

    public void setViewLayoutWidthAttr(int viewId, int widthAttr) {
        addAction(new LayoutParamAction(viewId, 8, widthAttr, 4));
    }

    public void setViewLayoutHeight(int viewId, float height, int units) {
        addAction(new LayoutParamAction(viewId, 9, height, units));
    }

    public void setViewLayoutHeightDimen(int viewId, int heightDimen) {
        addAction(new LayoutParamAction(viewId, 9, heightDimen, 3));
    }

    public void setViewLayoutHeightAttr(int viewId, int heightAttr) {
        addAction(new LayoutParamAction(viewId, 9, heightAttr, 4));
    }

    public void setViewOutlinePreferredRadius(int viewId, float radius, int units) {
        addAction(new SetViewOutlinePreferredRadiusAction(viewId, radius, units));
    }

    public void setViewOutlinePreferredRadiusDimen(int viewId, int resId) {
        addAction(new SetViewOutlinePreferredRadiusAction(viewId, resId, 3));
    }

    public void setViewOutlinePreferredRadiusAttr(int viewId, int attrId) {
        addAction(new SetViewOutlinePreferredRadiusAction(viewId, attrId, 4));
    }

    public void setBoolean(int viewId, String methodName, boolean value) {
        addAction(new ReflectionAction(viewId, methodName, 1, Boolean.valueOf(value)));
    }

    public void setByte(int viewId, String methodName, byte value) {
        addAction(new ReflectionAction(viewId, methodName, 2, Byte.valueOf(value)));
    }

    public void setShort(int viewId, String methodName, short value) {
        addAction(new ReflectionAction(viewId, methodName, 3, Short.valueOf(value)));
    }

    public void setInt(int viewId, String methodName, int value) {
        addAction(new ReflectionAction(viewId, methodName, 4, Integer.valueOf(value)));
    }

    public void setIntDimen(int viewId, String methodName, int dimenResource) {
        addAction(new ResourceReflectionAction(viewId, methodName, 4, 1, dimenResource));
    }

    public void setIntDimen(int viewId, String methodName, float value, int unit) {
        addAction(new ComplexUnitDimensionReflectionAction(viewId, methodName, 4, value, unit));
    }

    public void setIntDimenAttr(int viewId, String methodName, int dimenAttr) {
        addAction(new AttributeReflectionAction(viewId, methodName, 4, 1, dimenAttr));
    }

    public void setColor(int viewId, String methodName, int colorResource) {
        addAction(new ResourceReflectionAction(viewId, methodName, 4, 2, colorResource));
    }

    public void setColorAttr(int viewId, String methodName, int colorAttribute) {
        addAction(new AttributeReflectionAction(viewId, methodName, 4, 2, colorAttribute));
    }

    public void setColorInt(int viewId, String methodName, int notNight, int night) {
        addAction(new NightModeReflectionAction(viewId, methodName, 4, Integer.valueOf(notNight), Integer.valueOf(night)));
    }

    public void setColorStateList(int viewId, String methodName, ColorStateList value) {
        addAction(new ReflectionAction(viewId, methodName, 15, value));
    }

    public void setColorStateList(int viewId, String methodName, ColorStateList notNight, ColorStateList night) {
        addAction(new NightModeReflectionAction(viewId, methodName, 15, notNight, night));
    }

    public void setColorStateList(int viewId, String methodName, int colorResource) {
        addAction(new ResourceReflectionAction(viewId, methodName, 15, 2, colorResource));
    }

    public void setColorStateListAttr(int viewId, String methodName, int colorAttr) {
        addAction(new AttributeReflectionAction(viewId, methodName, 15, 2, colorAttr));
    }

    public void setLong(int viewId, String methodName, long value) {
        addAction(new ReflectionAction(viewId, methodName, 5, Long.valueOf(value)));
    }

    public void setFloat(int viewId, String methodName, float value) {
        addAction(new ReflectionAction(viewId, methodName, 6, Float.valueOf(value)));
    }

    public void setFloatDimen(int viewId, String methodName, int dimenResource) {
        addAction(new ResourceReflectionAction(viewId, methodName, 6, 1, dimenResource));
    }

    public void setFloatDimen(int viewId, String methodName, float value, int unit) {
        addAction(new ComplexUnitDimensionReflectionAction(viewId, methodName, 6, value, unit));
    }

    public void setFloatDimenAttr(int viewId, String methodName, int dimenAttr) {
        addAction(new AttributeReflectionAction(viewId, methodName, 6, 1, dimenAttr));
    }

    public void setDouble(int viewId, String methodName, double value) {
        addAction(new ReflectionAction(viewId, methodName, 7, Double.valueOf(value)));
    }

    public void setChar(int viewId, String methodName, char value) {
        addAction(new ReflectionAction(viewId, methodName, 8, Character.valueOf(value)));
    }

    public void setString(int viewId, String methodName, String value) {
        addAction(new ReflectionAction(viewId, methodName, 9, value));
    }

    public void setCharSequence(int viewId, String methodName, CharSequence value) {
        addAction(new ReflectionAction(viewId, methodName, 10, value));
    }

    public void setCharSequence(int viewId, String methodName, int stringResource) {
        addAction(new ResourceReflectionAction(viewId, methodName, 10, 3, stringResource));
    }

    public void setCharSequenceAttr(int viewId, String methodName, int stringAttribute) {
        addAction(new AttributeReflectionAction(viewId, methodName, 10, 3, stringAttribute));
    }

    public void setUri(int viewId, String methodName, Uri value) {
        if (value != null) {
            value = value.getCanonicalUri();
            if (StrictMode.vmFileUriExposureEnabled()) {
                value.checkFileUriExposed("RemoteViews.setUri()");
            }
        }
        addAction(new ReflectionAction(viewId, methodName, 11, value));
    }

    public void setBitmap(int viewId, String methodName, Bitmap value) {
        addAction(new BitmapReflectionAction(viewId, methodName, value));
    }

    public void setBlendMode(int viewId, String methodName, BlendMode value) {
        addAction(new ReflectionAction(viewId, methodName, 17, value));
    }

    public void setBundle(int viewId, String methodName, Bundle value) {
        addAction(new ReflectionAction(viewId, methodName, 13, value));
    }

    public void setIntent(int viewId, String methodName, Intent value) {
        addAction(new ReflectionAction(viewId, methodName, 14, value));
    }

    public void setIcon(int viewId, String methodName, Icon value) {
        addAction(new ReflectionAction(viewId, methodName, 16, value));
    }

    public void setIcon(int viewId, String methodName, Icon notNight, Icon night) {
        addAction(new NightModeReflectionAction(viewId, methodName, 16, notNight, night));
    }

    public void setContentDescription(int viewId, CharSequence contentDescription) {
        setCharSequence(viewId, "setContentDescription", contentDescription);
    }

    public void setAccessibilityTraversalBefore(int viewId, int nextId) {
        setInt(viewId, "setAccessibilityTraversalBefore", nextId);
    }

    public void setAccessibilityTraversalAfter(int viewId, int nextId) {
        setInt(viewId, "setAccessibilityTraversalAfter", nextId);
    }

    public void setLabelFor(int viewId, int labeledId) {
        setInt(viewId, "setLabelFor", labeledId);
    }

    public void setCompoundButtonChecked(int viewId, boolean checked) {
        addAction(new SetCompoundButtonCheckedAction(viewId, checked));
    }

    public void setRadioGroupChecked(int viewId, int checkedId) {
        addAction(new SetRadioGroupCheckedAction(viewId, checkedId));
    }

    public void setLightBackgroundLayoutId(int layoutId) {
        this.mLightBackgroundLayoutId = layoutId;
    }

    public RemoteViews getDarkTextViews() {
        if (hasFlags(4)) {
            return this;
        }
        try {
            addFlags(4);
            return new RemoteViews(this);
        } finally {
            this.mApplyFlags &= -5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RemoteViews getRemoteViewsToApply(Context context) {
        if (hasLandscapeAndPortraitLayouts()) {
            int orientation = context.getResources().getConfiguration().orientation;
            if (orientation == 2) {
                return this.mLandscape;
            }
            return this.mPortrait;
        }
        if (hasSizedRemoteViews()) {
            return findSmallestRemoteView();
        }
        return this;
    }

    private static float squareDistance(SizeF p12, SizeF p22) {
        float dx = p12.getWidth() - p22.getWidth();
        float dy = p12.getHeight() - p22.getHeight();
        return (dx * dx) + (dy * dy);
    }

    private static boolean fitsIn(SizeF sizeLayout, SizeF sizeWidget) {
        return sizeWidget != null && Math.ceil((double) sizeWidget.getWidth()) + 1.0d > ((double) sizeLayout.getWidth()) && Math.ceil((double) sizeWidget.getHeight()) + 1.0d > ((double) sizeLayout.getHeight());
    }

    private RemoteViews findBestFitLayout(SizeF widgetSize) {
        RemoteViews bestFit = null;
        float bestSqDist = Float.MAX_VALUE;
        for (RemoteViews layout : this.mSizedRemoteViews) {
            SizeF layoutSize = layout.getIdealSize();
            if (layoutSize == null) {
                throw new IllegalStateException("Expected RemoteViews to have ideal size");
            }
            if (fitsIn(layoutSize, widgetSize)) {
                if (bestFit == null) {
                    bestFit = layout;
                    bestSqDist = squareDistance(layoutSize, widgetSize);
                } else {
                    float newSqDist = squareDistance(layoutSize, widgetSize);
                    if (newSqDist < bestSqDist) {
                        bestFit = layout;
                        bestSqDist = newSqDist;
                    }
                }
            }
        }
        if (bestFit == null) {
            Log.w(LOG_TAG, "Could not find a RemoteViews fitting the current size: " + ((Object) widgetSize));
            return findSmallestRemoteView();
        }
        return bestFit;
    }

    public RemoteViews getRemoteViewsToApply(Context context, SizeF widgetSize) {
        if (!hasSizedRemoteViews() || widgetSize == null) {
            return getRemoteViewsToApply(context);
        }
        return findBestFitLayout(widgetSize);
    }

    public RemoteViews getRemoteViewsToApplyIfDifferent(SizeF oldSize, SizeF newSize) {
        if (!hasSizedRemoteViews()) {
            return null;
        }
        RemoteViews oldBestFit = oldSize == null ? findSmallestRemoteView() : findBestFitLayout(oldSize);
        RemoteViews newBestFit = findBestFitLayout(newSize);
        if (oldBestFit != newBestFit) {
            return newBestFit;
        }
        return null;
    }

    public View apply(Context context, ViewGroup parent) {
        return apply(context, parent, null);
    }

    public View apply(Context context, ViewGroup parent, InteractionHandler handler) {
        return apply(context, parent, handler, (SizeF) null);
    }

    public View apply(Context context, ViewGroup parent, InteractionHandler handler, SizeF size) {
        return apply(context, parent, size, new ActionApplyParams().withInteractionHandler(handler));
    }

    public View applyWithTheme(Context context, ViewGroup parent, InteractionHandler handler, int applyThemeResId) {
        return apply(context, parent, (SizeF) null, new ActionApplyParams().withInteractionHandler(handler).withThemeResId(applyThemeResId));
    }

    public View apply(Context context, ViewGroup parent, InteractionHandler handler, SizeF size, ColorResources colorResources) {
        return apply(context, parent, size, new ActionApplyParams().withInteractionHandler(handler).withColorResources(colorResources));
    }

    public View apply(Context context, ViewGroup parent, SizeF size, ActionApplyParams params) {
        return apply(context, parent, parent, size, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View apply(Context context, ViewGroup directParent, ViewGroup rootParent, SizeF size, ActionApplyParams params) {
        RemoteViews rvToApply = getRemoteViewsToApply(context, size);
        View result = inflateView(context, rvToApply, directParent, params.applyThemeResId, params.colorResources);
        rvToApply.performApply(result, rootParent, params);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View inflateView(Context context, RemoteViews rv, ViewGroup parent, int applyThemeResId, ColorResources colorResources) {
        Context contextForResources = getContextForResourcesEnsuringCorrectCachedApkPaths(context);
        if (colorResources != null) {
            colorResources.apply(contextForResources);
        }
        Context inflationContext = new RemoteViewsContextWrapper(context, contextForResources);
        if (applyThemeResId != 0) {
            inflationContext = new ContextThemeWrapper(inflationContext, applyThemeResId);
        }
        LayoutInflater inflater = LayoutInflater.from(context).cloneInContext(inflationContext);
        inflater.setFilter(shouldUseStaticFilter() ? INFLATER_FILTER : this);
        View v2 = inflater.inflate(rv.getLayoutId(), parent, false);
        int i10 = this.mViewId;
        if (i10 != -1) {
            v2.setId(i10);
            v2.setTagInternal(16909428, Integer.valueOf(this.mViewId));
        }
        v2.setTagInternal(16908312, Integer.valueOf(rv.getLayoutId()));
        return v2;
    }

    protected boolean shouldUseStaticFilter() {
        return getClass().equals(RemoteViews.class);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnViewAppliedListener {
        void onError(Exception exc);

        void onViewApplied(View view);

        default void onViewInflated(View v2) {
        }
    }

    public CancellationSignal applyAsync(Context context, ViewGroup parent, Executor executor, OnViewAppliedListener listener) {
        return applyAsync(context, parent, executor, listener, null);
    }

    public CancellationSignal applyAsync(Context context, ViewGroup parent, Executor executor, OnViewAppliedListener listener, InteractionHandler handler) {
        return applyAsync(context, parent, executor, listener, handler, null);
    }

    public CancellationSignal applyAsync(Context context, ViewGroup parent, Executor executor, OnViewAppliedListener listener, InteractionHandler handler, SizeF size) {
        return applyAsync(context, parent, executor, listener, handler, size, null);
    }

    public CancellationSignal applyAsync(Context context, ViewGroup parent, Executor executor, OnViewAppliedListener listener, InteractionHandler handler, SizeF size, ColorResources colorResources) {
        ActionApplyParams params = new ActionApplyParams().withInteractionHandler(handler).withColorResources(colorResources).withExecutor(executor);
        return new AsyncApplyTask(getRemoteViewsToApply(context, size), parent, context, listener, params, null, true).startTaskOnExecutor(executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AsyncApplyTask getInternalAsyncApplyTask(Context context, ViewGroup parent, OnViewAppliedListener listener, ActionApplyParams params, SizeF size, View result) {
        return new AsyncApplyTask(getRemoteViewsToApply(context, size), parent, context, listener, params, result, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AsyncApplyTask extends AsyncTask<Void, Void, ViewTree> implements CancellationSignal.OnCancelListener {
        private Action[] mActions;
        final ActionApplyParams mApplyParams;
        final CancellationSignal mCancelSignal;
        final Context mContext;
        private Exception mError;
        final OnViewAppliedListener mListener;
        final ViewGroup mParent;
        final RemoteViews mRV;
        private View mResult;
        final boolean mTopLevel;
        private ViewTree mTree;

        private AsyncApplyTask(RemoteViews rv, ViewGroup parent, Context context, OnViewAppliedListener listener, ActionApplyParams applyParams, View result, boolean topLevel) {
            this.mCancelSignal = new CancellationSignal();
            this.mRV = rv;
            this.mParent = parent;
            this.mContext = context;
            this.mListener = listener;
            this.mTopLevel = topLevel;
            this.mApplyParams = applyParams;
            this.mResult = result;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public ViewTree doInBackground(Void... params) {
            try {
                if (this.mResult == null) {
                    this.mResult = RemoteViews.this.inflateView(this.mContext, this.mRV, this.mParent, 0, this.mApplyParams.colorResources);
                }
                this.mTree = new ViewTree(this.mResult);
                if (this.mRV.mActions != null) {
                    int count = this.mRV.mActions.size();
                    this.mActions = new Action[count];
                    for (int i10 = 0; i10 < count && !isCancelled(); i10++) {
                        this.mActions[i10] = ((Action) this.mRV.mActions.get(i10)).initActionAsync(this.mTree, this.mParent, this.mApplyParams);
                    }
                } else {
                    this.mActions = null;
                }
                return this.mTree;
            } catch (Exception e2) {
                this.mError = e2;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(ViewTree viewTree) {
            this.mCancelSignal.setOnCancelListener(null);
            if (this.mError == null) {
                OnViewAppliedListener onViewAppliedListener = this.mListener;
                if (onViewAppliedListener != null) {
                    onViewAppliedListener.onViewInflated(viewTree.mRoot);
                }
                try {
                    if (this.mActions != null) {
                        ActionApplyParams applyParams = this.mApplyParams.m1368clone();
                        if (applyParams.handler == null) {
                            applyParams.handler = RemoteViews.DEFAULT_INTERACTION_HANDLER;
                        }
                        for (Action a10 : this.mActions) {
                            a10.apply(viewTree.mRoot, this.mParent, applyParams);
                        }
                    }
                    if (this.mTopLevel) {
                        View view = this.mResult;
                        if (view instanceof ViewGroup) {
                            RemoteViews.this.finalizeViewRecycling((ViewGroup) view);
                        }
                    }
                } catch (Exception e2) {
                    this.mError = e2;
                }
            }
            OnViewAppliedListener onViewAppliedListener2 = this.mListener;
            if (onViewAppliedListener2 != null) {
                Exception exc = this.mError;
                if (exc != null) {
                    onViewAppliedListener2.onError(exc);
                    return;
                } else {
                    onViewAppliedListener2.onViewApplied(viewTree.mRoot);
                    return;
                }
            }
            Exception exc2 = this.mError;
            if (exc2 != null) {
                if (exc2 instanceof ActionException) {
                    throw ((ActionException) exc2);
                }
                throw new ActionException(this.mError);
            }
        }

        @Override // android.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CancellationSignal startTaskOnExecutor(Executor executor) {
            this.mCancelSignal.setOnCancelListener(this);
            executeOnExecutor(executor == null ? AsyncTask.THREAD_POOL_EXECUTOR : executor, new Void[0]);
            return this.mCancelSignal;
        }
    }

    public void reapply(Context context, View v2) {
        reapply(context, v2, null, new ActionApplyParams());
    }

    public void reapply(Context context, View v2, InteractionHandler handler) {
        reapply(context, v2, null, new ActionApplyParams().withInteractionHandler(handler));
    }

    public void reapply(Context context, View v2, InteractionHandler handler, SizeF size, ColorResources colorResources) {
        reapply(context, v2, size, new ActionApplyParams().withInteractionHandler(handler).withColorResources(colorResources));
    }

    public void reapply(Context context, View v2, SizeF size, ActionApplyParams params) {
        reapply(context, v2, (ViewGroup) v2.getParent(), size, params, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reapplyNestedViews(Context context, View v2, ViewGroup rootParent, ActionApplyParams params) {
        reapply(context, v2, rootParent, null, params, false);
    }

    private void reapply(Context context, View v2, ViewGroup rootParent, SizeF size, ActionApplyParams params, boolean topLevel) {
        RemoteViews rvToApply = getRemoteViewsToReapply(context, v2, size);
        rvToApply.performApply(v2, rootParent, params);
        if (topLevel && (v2 instanceof ViewGroup)) {
            finalizeViewRecycling((ViewGroup) v2);
        }
    }

    public boolean canRecycleView(View v2) {
        Integer previousLayoutId;
        if (v2 == null || (previousLayoutId = (Integer) v2.getTag(16908312)) == null) {
            return false;
        }
        Integer overrideIdTag = (Integer) v2.getTag(16909428);
        int overrideId = overrideIdTag == null ? -1 : overrideIdTag.intValue();
        return previousLayoutId.intValue() == getLayoutId() && this.mViewId == overrideId;
    }

    private RemoteViews getRemoteViewsToReapply(Context context, View v2, SizeF size) {
        RemoteViews rvToApply = getRemoteViewsToApply(context, size);
        if ((hasMultipleLayouts() || rvToApply.mViewId != -1 || v2.getTag(16909428) != null) && !rvToApply.canRecycleView(v2)) {
            throw new RuntimeException("Attempting to re-apply RemoteViews to a view that that does not share the same root layout id.");
        }
        return rvToApply;
    }

    public CancellationSignal reapplyAsync(Context context, View v2, Executor executor, OnViewAppliedListener listener) {
        return reapplyAsync(context, v2, executor, listener, null);
    }

    public CancellationSignal reapplyAsync(Context context, View v2, Executor executor, OnViewAppliedListener listener, InteractionHandler handler) {
        return reapplyAsync(context, v2, executor, listener, handler, null, null);
    }

    public CancellationSignal reapplyAsync(Context context, View v2, Executor executor, OnViewAppliedListener listener, InteractionHandler handler, SizeF size, ColorResources colorResources) {
        RemoteViews rvToApply = getRemoteViewsToReapply(context, v2, size);
        ActionApplyParams params = new ActionApplyParams().withColorResources(colorResources).withInteractionHandler(handler).withExecutor(executor);
        return new AsyncApplyTask(rvToApply, (ViewGroup) v2.getParent(), context, listener, params, v2, true).startTaskOnExecutor(executor);
    }

    private void performApply(View v2, ViewGroup parent, ActionApplyParams params) {
        ActionApplyParams params2 = params.m1368clone();
        if (params2.handler == null) {
            params2.handler = DEFAULT_INTERACTION_HANDLER;
        }
        ArrayList<Action> arrayList = this.mActions;
        if (arrayList != null) {
            int count = arrayList.size();
            for (int i10 = 0; i10 < count; i10++) {
                this.mActions.get(i10).apply(v2, parent, params2);
            }
        }
    }

    public boolean prefersAsyncApply() {
        ArrayList<Action> arrayList = this.mActions;
        if (arrayList != null) {
            int count = arrayList.size();
            for (int i10 = 0; i10 < count; i10++) {
                if (this.mActions.get(i10).prefersAsyncApply()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void updateAppInfo(ApplicationInfo info) {
        ApplicationInfo existing = this.mApplicationInfoCache.get(info);
        if (existing != null && !existing.sourceDir.equals(info.sourceDir)) {
            return;
        }
        this.mApplicationInfoCache.put(info);
        configureDescendantsAsChildren();
    }

    private Context getContextForResourcesEnsuringCorrectCachedApkPaths(Context context) {
        if (this.mApplication != null) {
            if (context.getUserId() == UserHandle.getUserId(this.mApplication.uid) && context.getPackageName().equals(this.mApplication.packageName)) {
                return context;
            }
            try {
                LoadedApk.checkAndUpdateApkPaths(this.mApplication);
                return context.createApplicationContext(this.mApplication, 4);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(LOG_TAG, "Package name " + this.mApplication.packageName + " not found");
            }
        }
        return context;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ActionApplyParams {
        public int applyThemeResId;
        public ColorResources colorResources;
        public Executor executor;
        public InteractionHandler handler;

        public ActionApplyParams() {
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ActionApplyParams m1368clone() {
            return new ActionApplyParams().withInteractionHandler(this.handler).withColorResources(this.colorResources).withExecutor(this.executor).withThemeResId(this.applyThemeResId);
        }

        public ActionApplyParams withInteractionHandler(InteractionHandler handler) {
            this.handler = handler;
            return this;
        }

        public ActionApplyParams withColorResources(ColorResources colorResources) {
            this.colorResources = colorResources;
            return this;
        }

        public ActionApplyParams withThemeResId(int themeResId) {
            this.applyThemeResId = themeResId;
            return this;
        }

        public ActionApplyParams withExecutor(Executor executor) {
            this.executor = executor;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ColorResources {
        private static final int ARSC_ENTRY_SIZE = 16;
        private static final int FIRST_RESOURCE_COLOR_ID = 17170461;
        private static final int LAST_RESOURCE_COLOR_ID = 17170525;
        private final SparseIntArray mColorMapping;
        private final ResourcesLoader mLoader;

        private ColorResources(ResourcesLoader loader, SparseIntArray colorMapping) {
            this.mLoader = loader;
            this.mColorMapping = colorMapping;
        }

        public void apply(Context context) {
            context.getResources().addLoaders(this.mLoader);
        }

        public SparseIntArray getColorMapping() {
            return this.mColorMapping;
        }

        private static ByteArrayOutputStream readFileContent(InputStream input) throws IOException {
            ByteArrayOutputStream content = new ByteArrayOutputStream(2048);
            byte[] buffer = new byte[4096];
            while (input.available() > 0) {
                int read = input.read(buffer);
                content.write(buffer, 0, read);
            }
            return content;
        }

        private static byte[] createCompiledResourcesContent(Context context, SparseIntArray colorResources) throws IOException {
            InputStream input = context.getResources().openRawResource(17825798);
            try {
                ByteArrayOutputStream rawContent = readFileContent(input);
                byte[] content = rawContent.toByteArray();
                if (input != null) {
                    input.close();
                }
                int valuesOffset = (content.length - 1488) - 4;
                if (valuesOffset < 0) {
                    Log.e(RemoteViews.LOG_TAG, "ARSC file for theme colors is invalid.");
                    return null;
                }
                for (int colorRes = 17170461; colorRes <= 17170525; colorRes++) {
                    int index = 65535 & colorRes;
                    int offset = (index * 16) + valuesOffset;
                    int value = colorResources.get(colorRes, context.getColor(colorRes));
                    for (int b4 = 0; b4 < 4; b4++) {
                        content[offset + b4] = (byte) (value & 255);
                        value >>= 8;
                    }
                }
                return content;
            } catch (Throwable th) {
                if (input != null) {
                    try {
                        input.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public static ColorResources create(Context context, SparseIntArray colorMapping) {
            try {
                byte[] contentBytes = createCompiledResourcesContent(context, colorMapping);
                if (contentBytes == null) {
                    return null;
                }
                FileDescriptor arscFile = null;
                try {
                    arscFile = Os.memfd_create("remote_views_theme_colors.arsc", 0);
                    OutputStream pipeWriter = new FileOutputStream(arscFile);
                    try {
                        pipeWriter.write(contentBytes);
                        ParcelFileDescriptor pfd = ParcelFileDescriptor.dup(arscFile);
                        try {
                            ResourcesLoader colorsLoader = new ResourcesLoader();
                            colorsLoader.addProvider(ResourcesProvider.loadFromTable(pfd, null));
                            ColorResources colorResources = new ColorResources(colorsLoader, colorMapping.clone());
                            if (pfd != null) {
                                pfd.close();
                            }
                            pipeWriter.close();
                            return colorResources;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    if (arscFile != null) {
                        Os.close(arscFile);
                    }
                }
            } catch (Exception ex) {
                Log.e(RemoteViews.LOG_TAG, "Failed to setup the context for theme colors", ex);
                return null;
            }
        }
    }

    public int getSequenceNumber() {
        ArrayList<Action> arrayList = this.mActions;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.view.LayoutInflater.Filter
    @Deprecated
    public boolean onLoadClass(Class clazz) {
        return clazz.isAnnotationPresent(RemoteView.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        boolean prevSquashingAllowed = dest.allowSquashing();
        if (!hasMultipleLayouts()) {
            dest.writeInt(0);
            if (this.mIsRoot) {
                this.mBitmapCache.writeBitmapsToParcel(dest, flags);
            }
            this.mApplication.writeToParcel(dest, flags);
            if (this.mIsRoot || this.mIdealSize == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                this.mIdealSize.writeToParcel(dest, flags);
            }
            dest.writeInt(this.mLayoutId);
            dest.writeInt(this.mViewId);
            dest.writeInt(this.mLightBackgroundLayoutId);
            writeActionsToParcel(dest, flags);
        } else if (hasSizedRemoteViews()) {
            dest.writeInt(2);
            if (this.mIsRoot) {
                this.mBitmapCache.writeBitmapsToParcel(dest, flags);
            }
            dest.writeInt(this.mSizedRemoteViews.size());
            for (RemoteViews view : this.mSizedRemoteViews) {
                view.writeToParcel(dest, flags);
            }
        } else {
            dest.writeInt(1);
            if (this.mIsRoot) {
                this.mBitmapCache.writeBitmapsToParcel(dest, flags);
            }
            this.mLandscape.writeToParcel(dest, flags);
            this.mPortrait.writeToParcel(dest, flags);
        }
        dest.writeInt(this.mApplyFlags);
        dest.writeLong(this.mProviderInstanceId);
        dest.restoreAllowSquashing(prevSquashingAllowed);
    }

    private void writeActionsToParcel(Parcel parcel, int flags) {
        int count;
        ArrayList<Action> arrayList = this.mActions;
        if (arrayList != null) {
            count = arrayList.size();
        } else {
            count = 0;
        }
        parcel.writeInt(count);
        for (int i10 = 0; i10 < count; i10++) {
            Action a10 = this.mActions.get(i10);
            parcel.writeInt(a10.getActionTag());
            a10.writeToParcel(parcel, flags);
        }
    }

    private static ApplicationInfo getApplicationInfo(String packageName, int userId) {
        if (packageName == null) {
            return null;
        }
        Application application = ActivityThread.currentApplication();
        if (application == null) {
            throw new IllegalStateException("Cannot create remote views out of an aplication.");
        }
        ApplicationInfo applicationInfo = application.getApplicationInfo();
        if (UserHandle.getUserId(applicationInfo.uid) != userId || !applicationInfo.packageName.equals(packageName)) {
            try {
                Context context = application.getBaseContext().createPackageContextAsUser(packageName, 0, new UserHandle(userId));
                return context.getApplicationInfo();
            } catch (PackageManager.NameNotFoundException e2) {
                throw new IllegalArgumentException("No such package " + packageName);
            }
        }
        return applicationInfo;
    }

    public boolean hasSameAppInfo(ApplicationInfo info) {
        return this.mApplication.packageName.equals(info.packageName) && this.mApplication.uid == info.uid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ViewTree {
        private static final int INSERT_AT_END_INDEX = -1;
        private ArrayList<ViewTree> mChildren;
        private View mRoot;

        private ViewTree(View root) {
            this.mRoot = root;
        }

        public void createTree() {
            if (this.mChildren != null) {
                return;
            }
            this.mChildren = new ArrayList<>();
            View view = this.mRoot;
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                int count = vg.getChildCount();
                for (int i10 = 0; i10 < count; i10++) {
                    addViewChild(vg.getChildAt(i10));
                }
            }
        }

        public ViewTree findViewTreeById(int id2) {
            if (this.mRoot.getId() == id2) {
                return this;
            }
            ArrayList<ViewTree> arrayList = this.mChildren;
            if (arrayList == null) {
                return null;
            }
            Iterator<ViewTree> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                ViewTree tree = iterator2.next();
                ViewTree result = tree.findViewTreeById(id2);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }

        public ViewTree findViewTreeParentOf(ViewTree child) {
            ArrayList<ViewTree> arrayList = this.mChildren;
            if (arrayList == null) {
                return null;
            }
            Iterator<ViewTree> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                ViewTree tree = iterator2.next();
                if (tree == child) {
                    return this;
                }
                ViewTree result = tree.findViewTreeParentOf(child);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }

        public void replaceView(View v2) {
            this.mRoot = v2;
            this.mChildren = null;
            createTree();
        }

        public <T extends View> T findViewById(int i10) {
            if (this.mChildren == null) {
                return (T) this.mRoot.findViewById(i10);
            }
            ViewTree findViewTreeById = findViewTreeById(i10);
            if (findViewTreeById == null) {
                return null;
            }
            return (T) findViewTreeById.mRoot;
        }

        public void addChild(ViewTree child) {
            addChild(child, -1);
        }

        public void addChild(ViewTree child, int index) {
            if (this.mChildren == null) {
                this.mChildren = new ArrayList<>();
            }
            child.createTree();
            if (index == -1) {
                this.mChildren.add(child);
            } else {
                this.mChildren.add(index, child);
            }
        }

        public void removeChildren(int start, int count) {
            if (this.mChildren != null) {
                for (int i10 = 0; i10 < count; i10++) {
                    this.mChildren.remove(start);
                }
            }
        }

        private void addViewChild(View v2) {
            ViewTree tree;
            if (v2.isRootNamespace()) {
                return;
            }
            if (v2.getId() != 0) {
                tree = new ViewTree(v2);
                this.mChildren.add(tree);
            } else {
                tree = this;
            }
            if ((v2 instanceof ViewGroup) && tree.mChildren == null) {
                tree.mChildren = new ArrayList<>();
                ViewGroup vg = (ViewGroup) v2;
                int count = vg.getChildCount();
                for (int i10 = 0; i10 < count; i10++) {
                    tree.addViewChild(vg.getChildAt(i10));
                }
            }
        }

        public int findChildIndex(Predicate<View> condition) {
            return findChildIndex(0, condition);
        }

        public int findChildIndex(int startIndex, Predicate<View> condition) {
            if (this.mChildren == null) {
                return -1;
            }
            for (int i10 = startIndex; i10 < this.mChildren.size(); i10++) {
                if (condition.test(this.mChildren.get(i10).mRoot)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RemoteResponse {
        public static final int INTERACTION_TYPE_CHECKED_CHANGE = 1;
        public static final int INTERACTION_TYPE_CLICK = 0;
        private ArrayList<String> mElementNames;
        private Intent mFillIntent;
        private int mInteractionType = 0;
        private PendingIntent mPendingIntent;
        private IntArray mViewIds;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        @interface InteractionType {
        }

        public static RemoteResponse fromPendingIntent(PendingIntent pendingIntent) {
            RemoteResponse response = new RemoteResponse();
            response.mPendingIntent = pendingIntent;
            return response;
        }

        public static RemoteResponse fromFillInIntent(Intent fillIntent) {
            RemoteResponse response = new RemoteResponse();
            response.mFillIntent = fillIntent;
            return response;
        }

        public RemoteResponse addSharedElement(int viewId, String sharedElementName) {
            if (this.mViewIds == null) {
                this.mViewIds = new IntArray();
                this.mElementNames = new ArrayList<>();
            }
            this.mViewIds.add(viewId);
            this.mElementNames.add(sharedElementName);
            return this;
        }

        public RemoteResponse setInteractionType(int type) {
            this.mInteractionType = type;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel dest, int flags) {
            PendingIntent.writePendingIntentOrNullToParcel(this.mPendingIntent, dest);
            if (this.mPendingIntent == null) {
                dest.writeTypedObject(this.mFillIntent, flags);
            }
            dest.writeInt(this.mInteractionType);
            IntArray intArray = this.mViewIds;
            dest.writeIntArray(intArray == null ? null : intArray.toArray());
            dest.writeStringList(this.mElementNames);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void readFromParcel(Parcel parcel) {
            PendingIntent readPendingIntentOrNullFromParcel = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
            this.mPendingIntent = readPendingIntentOrNullFromParcel;
            if (readPendingIntentOrNullFromParcel == null) {
                this.mFillIntent = (Intent) parcel.readTypedObject(Intent.CREATOR);
            }
            this.mInteractionType = parcel.readInt();
            int[] viewIds = parcel.createIntArray();
            this.mViewIds = viewIds == null ? null : IntArray.wrap(viewIds);
            this.mElementNames = parcel.createStringArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleViewInteraction(View v2, InteractionHandler handler) {
            PendingIntent pi;
            if (this.mPendingIntent != null) {
                pi = this.mPendingIntent;
            } else if (this.mFillIntent != null) {
                AdapterView<?> ancestor = getAdapterViewAncestor(v2);
                if (ancestor == null) {
                    Log.e(RemoteViews.LOG_TAG, "Collection item doesn't have AdapterView parent");
                    return;
                } else {
                    if (!(ancestor.getTag() instanceof PendingIntent)) {
                        Log.e(RemoteViews.LOG_TAG, "Attempting setOnClickFillInIntent or setOnCheckedChangeFillInIntent without calling setPendingIntentTemplate on parent.");
                        return;
                    }
                    pi = (PendingIntent) ancestor.getTag();
                }
            } else {
                Log.e(RemoteViews.LOG_TAG, "Response has neither pendingIntent nor fillInIntent");
                return;
            }
            handler.onInteraction(v2, pi, this);
        }

        private static AdapterView<?> getAdapterViewAncestor(View view) {
            if (view == null) {
                return null;
            }
            View parent = (View) view.getParent();
            while (parent != null && !(parent instanceof AdapterView) && (!(parent instanceof AppWidgetHostView) || (parent instanceof RemoteViewsAdapter.RemoteViewsFrameLayout))) {
                parent = (View) parent.getParent();
            }
            if (parent instanceof AdapterView) {
                return (AdapterView) parent;
            }
            return null;
        }

        public Pair<Intent, ActivityOptions> getLaunchOptions(View view) {
            Intent intent = this.mPendingIntent != null ? new Intent() : new Intent(this.mFillIntent);
            intent.setSourceBounds(RemoteViews.getSourceBounds(view));
            if ((view instanceof CompoundButton) && this.mInteractionType == 1) {
                intent.putExtra(RemoteViews.EXTRA_CHECKED, ((CompoundButton) view).isChecked());
            }
            ActivityOptions opts = null;
            Context context = view.getContext();
            if (context.getResources().getBoolean(R.bool.config_overrideRemoteViewsActivityTransition)) {
                TypedArray windowStyle = context.getTheme().obtainStyledAttributes(R.styleable.Window);
                int windowAnimations = windowStyle.getResourceId(8, 0);
                TypedArray windowAnimationStyle = context.obtainStyledAttributes(windowAnimations, R.styleable.WindowAnimation);
                int enterAnimationId = windowAnimationStyle.getResourceId(26, 0);
                windowStyle.recycle();
                windowAnimationStyle.recycle();
                if (enterAnimationId != 0) {
                    opts = ActivityOptions.makeCustomAnimation(context, enterAnimationId, 0);
                    opts.setPendingIntentLaunchFlags(268435456);
                }
            }
            if (opts == null && this.mViewIds != null && this.mElementNames != null) {
                View parent = (View) view.getParent();
                while (parent != null && !(parent instanceof AppWidgetHostView)) {
                    parent = (View) parent.getParent();
                }
                if (parent instanceof AppWidgetHostView) {
                    int[] array = this.mViewIds.toArray();
                    ArrayList<String> arrayList = this.mElementNames;
                    opts = ((AppWidgetHostView) parent).createSharedElementActivityOptions(array, (String[]) arrayList.toArray(new String[arrayList.size()]), intent);
                }
            }
            if (opts == null) {
                opts = ActivityOptions.makeBasic();
                opts.setPendingIntentLaunchFlags(268435456);
            }
            if (view.getDisplay() != null) {
                opts.setLaunchDisplayId(view.getDisplay().getDisplayId());
            } else {
                Log.w(RemoteViews.LOG_TAG, "getLaunchOptions: view.getDisplay() is null!", new Exception());
            }
            opts.setPendingIntentBackgroundActivityStartMode(1);
            return Pair.create(intent, opts);
        }
    }

    public static boolean startPendingIntent(View view, PendingIntent pendingIntent, Pair<Intent, ActivityOptions> options) {
        try {
            Context context = view.getContext();
            context.startIntentSender(pendingIntent.getIntentSender(), (Intent) options.first, 0, 0, 0, ((ActivityOptions) options.second).toBundle());
            return true;
        } catch (IntentSender.SendIntentException e2) {
            Log.e(LOG_TAG, "Cannot send pending intent: ", e2);
            return false;
        } catch (Exception e10) {
            Log.e(LOG_TAG, "Cannot send pending intent due to unknown exception: ", e10);
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class RemoteCollectionItems implements Parcelable {
        public static final Parcelable.Creator<RemoteCollectionItems> CREATOR = new Parcelable.Creator<RemoteCollectionItems>() { // from class: android.widget.RemoteViews.RemoteCollectionItems.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RemoteCollectionItems createFromParcel(Parcel source) {
                return new RemoteCollectionItems(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RemoteCollectionItems[] newArray(int size) {
                return new RemoteCollectionItems[size];
            }
        };
        private final boolean mHasStableIds;
        private HierarchyRootData mHierarchyRootData;
        private final long[] mIds;
        private final int mViewTypeCount;
        private final RemoteViews[] mViews;

        RemoteCollectionItems(long[] ids, RemoteViews[] views, boolean hasStableIds, int viewTypeCount) {
            this.mIds = ids;
            this.mViews = views;
            this.mHasStableIds = hasStableIds;
            this.mViewTypeCount = viewTypeCount;
            if (ids.length != views.length) {
                throw new IllegalArgumentException("RemoteCollectionItems has different number of ids and views");
            }
            if (viewTypeCount < 1) {
                throw new IllegalArgumentException("View type count must be >= 1");
            }
            int layoutIdCount = (int) Arrays.stream(views).mapToInt(new RemoteViews$RemoteCollectionItems$$ExternalSyntheticLambda0()).distinct().count();
            if (layoutIdCount > viewTypeCount) {
                throw new IllegalArgumentException("View type count is set to " + viewTypeCount + ", but the collection contains " + layoutIdCount + " different layout ids");
            }
            if (views.length > 0) {
                setHierarchyRootData(views[0].getHierarchyRootData());
                views[0].mIsRoot = true;
            }
        }

        RemoteCollectionItems(Parcel in, HierarchyRootData hierarchyRootData) {
            int firstChildIndex;
            this.mHasStableIds = in.readBoolean();
            this.mViewTypeCount = in.readInt();
            int length = in.readInt();
            long[] jArr = new long[length];
            this.mIds = jArr;
            in.readLongArray(jArr);
            boolean attached = in.readBoolean();
            RemoteViews[] remoteViewsArr = new RemoteViews[length];
            this.mViews = remoteViewsArr;
            if (attached) {
                if (hierarchyRootData == null) {
                    throw new IllegalStateException("Cannot unparcel a RemoteCollectionItems that was parceled as attached without providing data for a root RemoteViews");
                }
                this.mHierarchyRootData = hierarchyRootData;
                firstChildIndex = 0;
            } else {
                RemoteViews remoteViews = new RemoteViews(in);
                remoteViewsArr[0] = remoteViews;
                this.mHierarchyRootData = remoteViews.getHierarchyRootData();
                firstChildIndex = 1;
            }
            for (int i10 = firstChildIndex; i10 < length; i10++) {
                this.mViews[i10] = new RemoteViews(in, this.mHierarchyRootData, null, 0);
            }
        }

        void setHierarchyRootData(HierarchyRootData rootData) {
            this.mHierarchyRootData = rootData;
            for (RemoteViews view : this.mViews) {
                view.configureAsChild(rootData);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            writeToParcel(dest, flags, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToParcel(Parcel dest, int flags, boolean attached) {
            boolean prevAllowSquashing = dest.allowSquashing();
            dest.writeBoolean(this.mHasStableIds);
            dest.writeInt(this.mViewTypeCount);
            dest.writeInt(this.mIds.length);
            dest.writeLongArray(this.mIds);
            if (attached && this.mHierarchyRootData == null) {
                throw new IllegalStateException("Cannot call writeToParcelAttached for a RemoteCollectionItems without first calling setHierarchyRootData()");
            }
            dest.writeBoolean(attached);
            boolean restoreRoot = false;
            if (!attached) {
                RemoteViews[] remoteViewsArr = this.mViews;
                if (remoteViewsArr.length > 0 && !remoteViewsArr[0].mIsRoot) {
                    restoreRoot = true;
                    this.mViews[0].mIsRoot = true;
                }
            }
            for (RemoteViews view : this.mViews) {
                view.writeToParcel(dest, flags);
            }
            if (restoreRoot) {
                this.mViews[0].mIsRoot = false;
            }
            dest.restoreAllowSquashing(prevAllowSquashing);
        }

        public long getItemId(int position) {
            return this.mIds[position];
        }

        public RemoteViews getItemView(int position) {
            return this.mViews[position];
        }

        public int getItemCount() {
            return this.mIds.length;
        }

        public int getViewTypeCount() {
            return this.mViewTypeCount;
        }

        public boolean hasStableIds() {
            return this.mHasStableIds;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public static final class Builder {
            private boolean mHasStableIds;
            private int mViewTypeCount;
            private final LongArray mIds = new LongArray();
            private final List<RemoteViews> mViews = new ArrayList();

            public Builder addItem(long id2, RemoteViews view) {
                if (view == null) {
                    throw new NullPointerException();
                }
                if (view.hasMultipleLayouts()) {
                    throw new IllegalArgumentException("RemoteViews used in a RemoteCollectionItems cannot specify separate layouts for orientations or sizes.");
                }
                this.mIds.add(id2);
                this.mViews.add(view);
                return this;
            }

            public Builder setHasStableIds(boolean hasStableIds) {
                this.mHasStableIds = hasStableIds;
                return this;
            }

            public Builder setViewTypeCount(int viewTypeCount) {
                this.mViewTypeCount = viewTypeCount;
                return this;
            }

            public RemoteCollectionItems build() {
                if (this.mViewTypeCount < 1) {
                    this.mViewTypeCount = (int) this.mViews.stream().mapToInt(new RemoteViews$RemoteCollectionItems$$ExternalSyntheticLambda0()).distinct().count();
                }
                return new RemoteCollectionItems(this.mIds.toArray(), (RemoteViews[]) this.mViews.toArray(new RemoteViews[0]), this.mHasStableIds, Math.max(this.mViewTypeCount, 1));
            }
        }
    }

    public int getViewId() {
        return this.mViewId;
    }

    public void setProviderInstanceId(long id2) {
        this.mProviderInstanceId = id2;
    }

    public long getProviderInstanceId() {
        return this.mProviderInstanceId;
    }

    private int getChildId(RemoteViews child) {
        if (child == this) {
            return 0;
        }
        if (hasSizedRemoteViews()) {
            for (int i10 = 0; i10 < this.mSizedRemoteViews.size(); i10++) {
                if (this.mSizedRemoteViews.get(i10) == child) {
                    return i10 + 1;
                }
            }
        }
        if (hasLandscapeAndPortraitLayouts()) {
            if (this.mLandscape == child) {
                return 1;
            }
            if (this.mPortrait == child) {
                return 2;
            }
        }
        return 0;
    }

    public long computeUniqueId(RemoteViews parent) {
        int childId;
        if (this.mIsRoot) {
            long viewId = getProviderInstanceId();
            if (viewId != -1) {
                return viewId << 8;
            }
            return viewId;
        }
        if (parent == null) {
            return -1L;
        }
        long viewId2 = parent.getProviderInstanceId();
        if (viewId2 == -1 || (childId = parent.getChildId(this)) == -1) {
            return -1L;
        }
        return (viewId2 << 8) | childId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Pair<String, Integer> getPackageUserKey(ApplicationInfo info) {
        if (info == null || info.packageName == null) {
            return null;
        }
        return Pair.create(info.packageName, Integer.valueOf(info.uid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HierarchyRootData getHierarchyRootData() {
        return new HierarchyRootData(this.mBitmapCache, this.mApplicationInfoCache, this.mClassCookies);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class HierarchyRootData {
        final ApplicationInfoCache mApplicationInfoCache;
        final BitmapCache mBitmapCache;
        final Map<Class, Object> mClassCookies;

        HierarchyRootData(BitmapCache bitmapCache, ApplicationInfoCache applicationInfoCache, Map<Class, Object> classCookies) {
            this.mBitmapCache = bitmapCache;
            this.mApplicationInfoCache = applicationInfoCache;
            this.mClassCookies = classCookies;
        }
    }
}

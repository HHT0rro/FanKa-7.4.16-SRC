package android.widget;

import android.app.INotificationManager;
import android.app.ITransientNotificationCallback;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.IAccessibilityManager;
import com.android.internal.R;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ToastPresenter {
    private static final long LONG_DURATION_TIMEOUT = 7000;
    private static final long SHORT_DURATION_TIMEOUT = 4000;
    private static final String TAG = "ToastPresenter";
    public static final int TEXT_TOAST_LAYOUT = 17367370;
    public static final int TEXT_TOAST_LAYOUT_WITH_ICON = 17367371;
    private static final String WINDOW_TITLE = "Toast";
    private final WeakReference<AccessibilityManager> mAccessibilityManager;
    private final String mContextPackageName;
    private final INotificationManager mNotificationManager;
    private final String mPackageName;
    private final WindowManager.LayoutParams mParams = createLayoutParams();
    private final Resources mResources;
    private IBinder mToken;
    private View mView;
    private final WeakReference<WindowManager> mWindowManager;

    public static View getTextToastView(Context context, CharSequence text) {
        View view = LayoutInflater.from(context).inflate(17367370, (ViewGroup) null);
        TextView textView = (TextView) view.findViewById(16908299);
        textView.setText(text);
        return view;
    }

    public static View getTextToastViewWithIcon(Context context, CharSequence text, Drawable icon) {
        if (icon == null) {
            return getTextToastView(context, text);
        }
        View view = LayoutInflater.from(context).inflate(17367371, (ViewGroup) null);
        TextView textView = (TextView) view.findViewById(16908299);
        textView.setText(text);
        ImageView imageView = (ImageView) view.findViewById(16908294);
        if (imageView != null) {
            imageView.setImageDrawable(icon);
        }
        return view;
    }

    public ToastPresenter(Context context, IAccessibilityManager accessibilityManager, INotificationManager notificationManager, String packageName) {
        this.mResources = context.getResources();
        this.mWindowManager = new WeakReference<>((WindowManager) context.getSystemService(WindowManager.class));
        this.mNotificationManager = notificationManager;
        this.mPackageName = packageName;
        this.mContextPackageName = context.getPackageName();
        this.mAccessibilityManager = new WeakReference<>(new AccessibilityManager(context, accessibilityManager, context.getUserId()));
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.mParams;
    }

    public View getView() {
        return this.mView;
    }

    public IBinder getToken() {
        return this.mToken;
    }

    private WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.height = -2;
        params.width = -2;
        params.format = -3;
        params.windowAnimations = 16973828;
        params.type = 2005;
        params.setFitInsetsIgnoringVisibility(true);
        params.setTitle(WINDOW_TITLE);
        params.flags = 152;
        if ("com.oplus.camera".equals(this.mPackageName)) {
            params.flags |= 524288;
        }
        setShowForAllUsersIfApplicable(params, this.mPackageName);
        return params;
    }

    private void adjustLayoutParams(WindowManager.LayoutParams params, IBinder windowToken, int duration, int gravity, int xOffset, int yOffset, float horizontalMargin, float verticalMargin, boolean removeWindowAnimations) {
        Configuration config = this.mResources.getConfiguration();
        int absGravity = Gravity.getAbsoluteGravity(gravity, config.getLayoutDirection());
        params.gravity = absGravity;
        if ((absGravity & 7) == 7) {
            params.horizontalWeight = 1.0f;
        }
        if ((absGravity & 112) == 112) {
            params.verticalWeight = 1.0f;
        }
        params.f816x = xOffset;
        params.f817y = yOffset;
        params.horizontalMargin = horizontalMargin;
        params.verticalMargin = verticalMargin;
        params.packageName = this.mContextPackageName;
        params.hideTimeoutMilliseconds = duration == 1 ? LONG_DURATION_TIMEOUT : 4000L;
        params.token = windowToken;
        if (removeWindowAnimations && params.windowAnimations == 16973828) {
            params.windowAnimations = 0;
        }
    }

    public void updateLayoutParams(int xOffset, int yOffset, float horizontalMargin, float verticalMargin, int gravity) {
        Preconditions.checkState(this.mView != null, "Toast must be showing to update its layout parameters.");
        Configuration config = this.mResources.getConfiguration();
        this.mParams.gravity = Gravity.getAbsoluteGravity(gravity, config.getLayoutDirection());
        this.mParams.f816x = xOffset;
        this.mParams.f817y = yOffset;
        this.mParams.horizontalMargin = horizontalMargin;
        this.mParams.verticalMargin = verticalMargin;
        this.mView.setLayoutParams(this.mParams);
    }

    private void setShowForAllUsersIfApplicable(WindowManager.LayoutParams params, String packageName) {
        if (isCrossUserPackage(packageName)) {
            params.privateFlags = 16;
        }
    }

    private boolean isCrossUserPackage(String packageName) {
        String[] packages = this.mResources.getStringArray(R.array.config_toastCrossUserPackages);
        return ArrayUtils.contains(packages, packageName);
    }

    public void show(View view, IBinder token, IBinder windowToken, int duration, int gravity, int xOffset, int yOffset, float horizontalMargin, float verticalMargin, ITransientNotificationCallback callback) {
        show(view, token, windowToken, duration, gravity, xOffset, yOffset, horizontalMargin, verticalMargin, callback, false);
    }

    public void show(View view, IBinder token, IBinder windowToken, int duration, int gravity, int xOffset, int yOffset, float horizontalMargin, float verticalMargin, ITransientNotificationCallback callback, boolean removeWindowAnimations) {
        Preconditions.checkState(this.mView == null, "Only one toast at a time is allowed, call hide() first.");
        this.mView = view;
        this.mToken = token;
        adjustLayoutParams(this.mParams, windowToken, duration, gravity, xOffset, yOffset, horizontalMargin, verticalMargin, removeWindowAnimations);
        addToastView();
        trySendAccessibilityEvent(this.mView, this.mPackageName);
        if (callback != null) {
            try {
                callback.onToastShown();
            } catch (RemoteException e2) {
                Log.w(TAG, "Error calling back " + this.mPackageName + " to notify onToastShow()", e2);
            }
        }
    }

    public void hide(ITransientNotificationCallback callback) {
        Preconditions.checkState(this.mView != null, "No toast to hide.");
        WindowManager windowManager = this.mWindowManager.get();
        if (this.mView.getParent() != null && windowManager != null) {
            windowManager.removeViewImmediate(this.mView);
        }
        try {
            this.mNotificationManager.finishToken(this.mPackageName, this.mToken);
        } catch (RemoteException e2) {
            Log.w(TAG, "Error finishing toast window token from package " + this.mPackageName, e2);
        }
        if (callback != null) {
            try {
                callback.onToastHidden();
            } catch (RemoteException e10) {
                Log.w(TAG, "Error calling back " + this.mPackageName + " to notify onToastHide()", e10);
            }
        }
        this.mView = null;
        this.mToken = null;
    }

    public void trySendAccessibilityEvent(View view, String packageName) {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager.get();
        if (accessibilityManager == null) {
            return;
        }
        if (!accessibilityManager.isEnabled()) {
            accessibilityManager.removeClient();
            return;
        }
        AccessibilityEvent event = AccessibilityEvent.obtain(64);
        event.setClassName(Toast.class.getName());
        event.setPackageName(packageName);
        view.dispatchPopulateAccessibilityEvent(event);
        accessibilityManager.sendAccessibilityEvent(event);
        accessibilityManager.removeClient();
    }

    private void addToastView() {
        WindowManager windowManager = this.mWindowManager.get();
        if (windowManager == null) {
            return;
        }
        if (this.mView.getParent() != null) {
            windowManager.removeView(this.mView);
        }
        try {
            windowManager.addView(this.mView, this.mParams);
        } catch (WindowManager.BadTokenException e2) {
            Log.w(TAG, "Error while attempting to show toast from " + this.mPackageName, e2);
        }
    }
}

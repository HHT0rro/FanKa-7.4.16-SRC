package com.android.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.MediaRouter;
import android.util.Log;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class MediaRouteDialogPresenter {
    private static final String CHOOSER_FRAGMENT_TAG = "android.app.MediaRouteButton:MediaRouteChooserDialogFragment";
    private static final String CONTROLLER_FRAGMENT_TAG = "android.app.MediaRouteButton:MediaRouteControllerDialogFragment";
    private static final String TAG = "MediaRouter";

    public static DialogFragment showDialogFragment(Activity activity, int routeTypes, View.OnClickListener extendedSettingsClickListener) {
        MediaRouter router = (MediaRouter) activity.getSystemService("media_router");
        FragmentManager fm = activity.getFragmentManager();
        MediaRouter.RouteInfo route = router.getSelectedRoute();
        if (route.isDefault() || !route.matchesTypes(routeTypes)) {
            if (fm.findFragmentByTag(CHOOSER_FRAGMENT_TAG) != null) {
                Log.w(TAG, "showDialog(): Route chooser dialog already showing!");
                return null;
            }
            MediaRouteChooserDialogFragment f10 = new MediaRouteChooserDialogFragment();
            f10.setRouteTypes(routeTypes);
            f10.setExtendedSettingsClickListener(extendedSettingsClickListener);
            f10.show(fm, CHOOSER_FRAGMENT_TAG);
            return f10;
        }
        if (fm.findFragmentByTag(CONTROLLER_FRAGMENT_TAG) != null) {
            Log.w(TAG, "showDialog(): Route controller dialog already showing!");
            return null;
        }
        MediaRouteControllerDialogFragment f11 = new MediaRouteControllerDialogFragment();
        f11.show(fm, CONTROLLER_FRAGMENT_TAG);
        return f11;
    }

    public static Dialog createDialog(Context context, int routeTypes, View.OnClickListener extendedSettingsClickListener) {
        int theme;
        if (MediaRouteChooserDialog.isLightTheme(context)) {
            theme = 16974130;
        } else {
            theme = 16974126;
        }
        return createDialog(context, routeTypes, extendedSettingsClickListener, theme);
    }

    public static Dialog createDialog(Context context, int routeTypes, View.OnClickListener extendedSettingsClickListener, int theme) {
        return createDialog(context, routeTypes, extendedSettingsClickListener, theme, true);
    }

    public static Dialog createDialog(Context context, int routeTypes, View.OnClickListener extendedSettingsClickListener, int theme, boolean showProgressBarWhenEmpty) {
        MediaRouter router = (MediaRouter) context.getSystemService(MediaRouter.class);
        MediaRouter.RouteInfo route = router.getSelectedRoute();
        if (route.isDefault() || !route.matchesTypes(routeTypes) || route.getStatusCode() == 4) {
            MediaRouteChooserDialog d10 = new MediaRouteChooserDialog(context, theme, showProgressBarWhenEmpty);
            d10.setRouteTypes(routeTypes);
            d10.setExtendedSettingsClickListener(extendedSettingsClickListener);
            return d10;
        }
        return new MediaRouteControllerDialog(context, theme);
    }
}

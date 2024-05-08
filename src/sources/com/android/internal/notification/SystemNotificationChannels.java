package com.android.internal.notification;

import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.media.AudioAttributes;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SystemNotificationChannels {

    @Deprecated
    public static String VIRTUAL_KEYBOARD = "VIRTUAL_KEYBOARD";
    public static String PHYSICAL_KEYBOARD = "PHYSICAL_KEYBOARD";
    public static String SECURITY = "SECURITY";
    public static String CAR_MODE = "CAR_MODE";
    public static String ACCOUNT = "ACCOUNT";
    public static String DEVELOPER = "DEVELOPER";
    public static String DEVELOPER_IMPORTANT = "DEVELOPER_IMPORTANT";
    public static String UPDATES = "UPDATES";
    public static String NETWORK_STATUS = "NETWORK_STATUS";
    public static String NETWORK_ALERTS = "NETWORK_ALERTS";
    public static String NETWORK_AVAILABLE = "NETWORK_AVAILABLE";
    public static String VPN = "VPN";

    @Deprecated
    public static String DEVICE_ADMIN_DEPRECATED = "DEVICE_ADMIN";
    public static String DEVICE_ADMIN = "DEVICE_ADMIN_ALERTS";
    public static String ALERTS = "ALERTS";
    public static String RETAIL_MODE = "RETAIL_MODE";
    public static String USB = "USB";
    public static String FOREGROUND_SERVICE = "FOREGROUND_SERVICE";
    public static String HEAVY_WEIGHT_APP = "HEAVY_WEIGHT_APP";

    @Deprecated
    public static String SYSTEM_CHANGES_DEPRECATED = "SYSTEM_CHANGES";
    public static String SYSTEM_CHANGES = "SYSTEM_CHANGES_ALERTS";
    public static String DO_NOT_DISTURB = "DO_NOT_DISTURB";
    public static String ACCESSIBILITY_MAGNIFICATION = "ACCESSIBILITY_MAGNIFICATION";
    public static String ACCESSIBILITY_SECURITY_POLICY = "ACCESSIBILITY_SECURITY_POLICY";
    public static String ABUSIVE_BACKGROUND_APPS = "ABUSIVE_BACKGROUND_APPS";

    public static void createAll(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(NotificationManager.class);
        List<NotificationChannel> channelsList = new ArrayList<>();
        NotificationChannel physicalKeyboardChannel = new NotificationChannel(PHYSICAL_KEYBOARD, context.getString(17040956), 2);
        physicalKeyboardChannel.setBlockable(true);
        channelsList.add(physicalKeyboardChannel);
        NotificationChannel security = new NotificationChannel(SECURITY, context.getString(17040958), 2);
        channelsList.add(security);
        NotificationChannel car = new NotificationChannel(CAR_MODE, context.getString(17040943), 2);
        car.setBlockable(true);
        channelsList.add(car);
        channelsList.add(newAccountChannel(context));
        NotificationChannel developer = new NotificationChannel(DEVELOPER, context.getString(17040944), 2);
        developer.setBlockable(true);
        channelsList.add(developer);
        NotificationChannel developerImportant = new NotificationChannel(DEVELOPER_IMPORTANT, context.getString(17040945), 4);
        developer.setBlockable(true);
        channelsList.add(developerImportant);
        NotificationChannel updates = new NotificationChannel(UPDATES, context.getString(17040963), 2);
        channelsList.add(updates);
        NotificationChannel network = new NotificationChannel(NETWORK_STATUS, context.getString(17040955), 2);
        network.setBlockable(true);
        channelsList.add(network);
        NotificationChannel networkAlertsChannel = new NotificationChannel(NETWORK_ALERTS, context.getString(17040953), 4);
        networkAlertsChannel.setBlockable(true);
        channelsList.add(networkAlertsChannel);
        NotificationChannel networkAvailable = new NotificationChannel(NETWORK_AVAILABLE, context.getString(17040954), 2);
        networkAvailable.setBlockable(true);
        channelsList.add(networkAvailable);
        NotificationChannel vpn = new NotificationChannel(VPN, context.getString(17040967), 2);
        channelsList.add(vpn);
        NotificationChannel deviceAdmin = new NotificationChannel(DEVICE_ADMIN, getDeviceAdminNotificationChannelName(context), 4);
        channelsList.add(deviceAdmin);
        NotificationChannel alertsChannel = new NotificationChannel(ALERTS, context.getString(17040941), 3);
        channelsList.add(alertsChannel);
        NotificationChannel retail = new NotificationChannel(RETAIL_MODE, context.getString(17040957), 2);
        channelsList.add(retail);
        NotificationChannel usb = new NotificationChannel(USB, context.getString(17040964), 1);
        channelsList.add(usb);
        NotificationChannel foregroundChannel = new NotificationChannel(FOREGROUND_SERVICE, context.getString(17040949), 2);
        foregroundChannel.setBlockable(true);
        channelsList.add(foregroundChannel);
        NotificationChannel heavyWeightChannel = new NotificationChannel(HEAVY_WEIGHT_APP, context.getString(17040950), 3);
        heavyWeightChannel.setShowBadge(false);
        heavyWeightChannel.setSound(null, new AudioAttributes.Builder().setContentType(4).setUsage(10).build());
        channelsList.add(heavyWeightChannel);
        NotificationChannel systemChanges = new NotificationChannel(SYSTEM_CHANGES, context.getString(17040962), 3);
        systemChanges.setSound(null, new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
        channelsList.add(systemChanges);
        NotificationChannel dndChanges = new NotificationChannel(DO_NOT_DISTURB, context.getString(17040947), 2);
        channelsList.add(dndChanges);
        NotificationChannel newFeaturePrompt = new NotificationChannel(ACCESSIBILITY_MAGNIFICATION, context.getString(17040938), 4);
        newFeaturePrompt.setBlockable(true);
        channelsList.add(newFeaturePrompt);
        NotificationChannel accessibilitySecurityPolicyChannel = new NotificationChannel(ACCESSIBILITY_SECURITY_POLICY, context.getString(17040939), 2);
        channelsList.add(accessibilitySecurityPolicyChannel);
        NotificationChannel abusiveBackgroundAppsChannel = new NotificationChannel(ABUSIVE_BACKGROUND_APPS, context.getString(17040937), 2);
        channelsList.add(abusiveBackgroundAppsChannel);
        nm.createNotificationChannels(channelsList);
    }

    private static String getDeviceAdminNotificationChannelName(final Context context) {
        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        return dpm.getResources().getString("Core.NOTIFICATION_CHANNEL_DEVICE_ADMIN", new Supplier() { // from class: com.android.internal.notification.SystemNotificationChannels$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                String string;
                string = context.getString(17040946);
                return string;
            }
        });
    }

    public static void removeDeprecated(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(NotificationManager.class);
        nm.deleteNotificationChannel(VIRTUAL_KEYBOARD);
        nm.deleteNotificationChannel(DEVICE_ADMIN_DEPRECATED);
        nm.deleteNotificationChannel(SYSTEM_CHANGES_DEPRECATED);
    }

    public static void createAccountChannelForPackage(String pkg, int uid, Context context) {
        INotificationManager iNotificationManager = NotificationManager.getService();
        try {
            iNotificationManager.createNotificationChannelsForPackage(pkg, uid, new ParceledListSlice(Arrays.asList(newAccountChannel(context))));
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    private static NotificationChannel newAccountChannel(Context context) {
        return new NotificationChannel(ACCOUNT, context.getString(17040940), 2);
    }

    private SystemNotificationChannels() {
    }
}

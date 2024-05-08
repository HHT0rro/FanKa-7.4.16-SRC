package y8;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {
    public static void a(Context context, boolean z10) {
        context.getSharedPreferences("shared_msg_sdk", 0).edit().putBoolean("hasDefaultChannelCreated", z10).commit();
    }

    public static boolean b(Context context) {
        return context.getSharedPreferences("shared_msg_sdk", 0).getBoolean("hasDefaultChannelCreated", false);
    }
}

package android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AppSecurityPermissions {
    public static View getPermissionItemView(Context context, CharSequence grpName, CharSequence description, boolean dangerous) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        Drawable icon = context.getDrawable(dangerous ? 17302363 : 17302900);
        return getPermissionItemViewOld(context, inflater, grpName, description, dangerous, icon);
    }

    private static View getPermissionItemViewOld(Context context, LayoutInflater inflater, CharSequence grpName, CharSequence permList, boolean dangerous, Drawable icon) {
        View permView = inflater.inflate(17367103, (ViewGroup) null);
        TextView permGrpView = (TextView) permView.findViewById(16909362);
        TextView permDescView = (TextView) permView.findViewById(16909364);
        ImageView imgView = (ImageView) permView.findViewById(16909358);
        imgView.setImageDrawable(icon);
        if (grpName != null) {
            permGrpView.setText(grpName);
            permDescView.setText(permList);
        } else {
            permGrpView.setText(permList);
            permDescView.setVisibility(8);
        }
        return permView;
    }
}

package com.android.internal.app;

import android.app.ActivityManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.app.ChooserTargetActionsDialogFragment;
import com.android.internal.app.ResolverListAdapter;
import com.android.internal.app.chooser.DisplayResolveInfo;
import com.android.internal.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ChooserTargetActionsDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    public static final String INTENT_FILTER_KEY = "intent_filter";
    public static final String IS_SHORTCUT_PINNED_KEY = "is_shortcut_pinned";
    public static final String SHORTCUT_ID_KEY = "shortcut_id";
    public static final String SHORTCUT_TITLE_KEY = "shortcut_title";
    public static final String TARGET_INFOS_KEY = "target_infos";
    public static final String USER_HANDLE_KEY = "user_handle";
    protected IntentFilter mIntentFilter;
    protected boolean mIsShortcutPinned;
    protected String mShortcutId;
    protected String mShortcutTitle;
    protected ArrayList<DisplayResolveInfo> mTargetInfos = new ArrayList<>();
    protected UserHandle mUserHandle;

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            setStateFromBundle(savedInstanceState);
        } else {
            setStateFromBundle(getArguments());
        }
    }

    void setStateFromBundle(Bundle b4) {
        this.mTargetInfos = (ArrayList) b4.get(TARGET_INFOS_KEY);
        this.mUserHandle = (UserHandle) b4.get(USER_HANDLE_KEY);
        this.mShortcutId = b4.getString(SHORTCUT_ID_KEY);
        this.mShortcutTitle = b4.getString(SHORTCUT_TITLE_KEY);
        this.mIsShortcutPinned = b4.getBoolean(IS_SHORTCUT_PINNED_KEY);
        this.mIntentFilter = (IntentFilter) b4.get("intent_filter");
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(USER_HANDLE_KEY, this.mUserHandle);
        outState.putParcelableArrayList(TARGET_INFOS_KEY, this.mTargetInfos);
        outState.putString(SHORTCUT_ID_KEY, this.mShortcutId);
        outState.putBoolean(IS_SHORTCUT_PINNED_KEY, this.mIsShortcutPinned);
        outState.putString(SHORTCUT_TITLE_KEY, this.mShortcutTitle);
        outState.putParcelable("intent_filter", this.mIntentFilter);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            setStateFromBundle(savedInstanceState);
        } else {
            setStateFromBundle(getArguments());
        }
        Optional.of(getDialog()).map(new Function() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Dialog) obj).getWindow();
            }
        }).ifPresent(new Consumer() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Window) obj).setBackgroundDrawable(new ColorDrawable(0));
            }
        });
        List<Pair<Drawable, CharSequence>> items = (List) this.mTargetInfos.stream().map(new Function() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Pair lambda$onCreateView$1;
                lambda$onCreateView$1 = ChooserTargetActionsDialogFragment.this.lambda$onCreateView$1((DisplayResolveInfo) obj);
                return lambda$onCreateView$1;
            }
        }).collect(Collectors.toList());
        View v2 = inflater.inflate(17367132, container, false);
        TextView title = (TextView) v2.findViewById(16908310);
        ImageView icon = (ImageView) v2.findViewById(16908294);
        RecyclerView rv = v2.findViewById(16909199);
        ResolverListAdapter.ResolveInfoPresentationGetter pg = getProvidingAppPresentationGetter();
        title.setText(isShortcutTarget() ? this.mShortcutTitle : pg.getLabel());
        icon.setImageDrawable(pg.getIcon(this.mUserHandle));
        rv.setAdapter(new VHAdapter(items));
        return v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pair lambda$onCreateView$1(DisplayResolveInfo dri) {
        return new Pair(getItemIcon(dri), getItemLabel(dri));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    class VHAdapter extends RecyclerView.Adapter<VH> {
        List<Pair<Drawable, CharSequence>> mItems;

        VHAdapter(List<Pair<Drawable, CharSequence>> items) {
            this.mItems = items;
        }

        /* renamed from: onCreateViewHolder, reason: merged with bridge method [inline-methods] */
        public VH m2084onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VH(LayoutInflater.from(parent.getContext()).inflate(17367133, parent, false));
        }

        public void onBindViewHolder(VH holder, int position) {
            holder.bind(this.mItems.get(position), position);
        }

        public int getItemCount() {
            return this.mItems.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class VH extends RecyclerView.ViewHolder {
        ImageView mIcon;
        TextView mLabel;

        VH(View itemView) {
            super(itemView);
            this.mLabel = (TextView) itemView.findViewById(16909606);
            this.mIcon = (ImageView) itemView.findViewById(16908294);
        }

        public void bind(Pair<Drawable, CharSequence> item, final int position) {
            this.mLabel.setText((CharSequence) item.second);
            if (item.first == null) {
                this.mIcon.setVisibility(8);
            } else {
                this.mIcon.setVisibility(0);
                this.mIcon.setImageDrawable((Drawable) item.first);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$VH$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooserTargetActionsDialogFragment.VH.this.lambda$bind$0(position, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$bind$0(int position, View v2) {
            ChooserTargetActionsDialogFragment chooserTargetActionsDialogFragment = ChooserTargetActionsDialogFragment.this;
            chooserTargetActionsDialogFragment.onClick(chooserTargetActionsDialogFragment.getDialog(), position);
        }
    }

    public void onClick(DialogInterface dialog, int which) {
        if (isShortcutTarget()) {
            toggleShortcutPinned(this.mTargetInfos.get(which).getResolvedComponentName());
        } else {
            pinComponent(this.mTargetInfos.get(which).getResolvedComponentName());
        }
        ((ChooserActivity) getActivity()).handlePackagesChanged();
        dismiss();
    }

    private void toggleShortcutPinned(ComponentName name) {
        if (this.mIntentFilter == null) {
            return;
        }
        List<String> pinnedShortcuts = getPinnedShortcutsFromPackageAsUser(getContext(), this.mUserHandle, this.mIntentFilter, name.getPackageName());
        if (this.mIsShortcutPinned) {
            pinnedShortcuts.remove(this.mShortcutId);
        } else {
            pinnedShortcuts.add(this.mShortcutId);
        }
        ((LauncherApps) getContext().getSystemService(LauncherApps.class)).pinShortcuts(name.getPackageName(), pinnedShortcuts, this.mUserHandle);
    }

    private static List<String> getPinnedShortcutsFromPackageAsUser(Context context, UserHandle user, IntentFilter filter, final String packageName) {
        Context contextAsUser = context.createContextAsUser(user, 0);
        List<ShortcutManager.ShareShortcutInfo> targets = ((ShortcutManager) contextAsUser.getSystemService(ShortcutManager.class)).getShareTargets(filter);
        return (List) targets.stream().map(new Function() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ShortcutManager.ShareShortcutInfo) obj).getShortcutInfo();
            }
        }).filter(new Predicate() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ChooserTargetActionsDialogFragment.lambda$getPinnedShortcutsFromPackageAsUser$2(String.this, (ShortcutInfo) obj);
            }
        }).map(new Function() { // from class: com.android.internal.app.ChooserTargetActionsDialogFragment$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ShortcutInfo) obj).getId();
            }
        }).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getPinnedShortcutsFromPackageAsUser$2(String packageName, ShortcutInfo s2) {
        return s2.isPinned() && s2.getPackage().equals(packageName);
    }

    private void pinComponent(ComponentName name) {
        SharedPreferences sp = ChooserActivity.getPinnedSharedPrefs(getContext());
        String key = name.flattenToString();
        boolean currentVal = sp.getBoolean(name.flattenToString(), false);
        if (currentVal) {
            sp.edit().remove(key).apply();
        } else {
            sp.edit().putBoolean(key, true).apply();
        }
    }

    private Drawable getPinIcon(boolean isPinned) {
        if (isPinned) {
            return getContext().getDrawable(17302395);
        }
        return getContext().getDrawable(17302381);
    }

    private CharSequence getPinLabel(boolean isPinned, CharSequence targetLabel) {
        if (isPinned) {
            return getResources().getString(R.string.unpin_specific_target, targetLabel);
        }
        return getResources().getString(17041423, targetLabel);
    }

    protected CharSequence getItemLabel(DisplayResolveInfo dri) {
        PackageManager pm = getContext().getPackageManager();
        return getPinLabel(isPinned(dri), isShortcutTarget() ? this.mShortcutTitle : dri.getResolveInfo().loadLabel(pm));
    }

    protected Drawable getItemIcon(DisplayResolveInfo dri) {
        return getPinIcon(isPinned(dri));
    }

    private ResolverListAdapter.ResolveInfoPresentationGetter getProvidingAppPresentationGetter() {
        ActivityManager am = (ActivityManager) getContext().getSystemService("activity");
        int iconDpi = am.getLauncherLargeIconDensity();
        return new ResolverListAdapter.ResolveInfoPresentationGetter(getContext(), iconDpi, this.mTargetInfos.get(0).getResolveInfo());
    }

    private boolean isPinned(DisplayResolveInfo dri) {
        return isShortcutTarget() ? this.mIsShortcutPinned : dri.isPinned();
    }

    private boolean isShortcutTarget() {
        return this.mShortcutId != null;
    }
}

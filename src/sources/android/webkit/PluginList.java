package android.webkit;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PluginList {
    private ArrayList<Plugin> mPlugins = new ArrayList<>();

    @Deprecated
    public PluginList() {
    }

    @Deprecated
    public synchronized List getList() {
        return this.mPlugins;
    }

    @Deprecated
    public synchronized void addPlugin(Plugin plugin) {
        if (!this.mPlugins.contains(plugin)) {
            this.mPlugins.add(plugin);
        }
    }

    @Deprecated
    public synchronized void removePlugin(Plugin plugin) {
        int location = this.mPlugins.indexOf(plugin);
        if (location != -1) {
            this.mPlugins.remove(location);
        }
    }

    @Deprecated
    public synchronized void clear() {
        this.mPlugins.clear();
    }

    @Deprecated
    public synchronized void pluginClicked(Context context, int position) {
        try {
            try {
                Plugin plugin = this.mPlugins.get(position);
                plugin.dispatchClickEvent(context);
            } catch (IndexOutOfBoundsException e2) {
            }
        } catch (IndexOutOfBoundsException e10) {
        }
    }
}

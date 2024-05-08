package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class TileList<T> {
    public Tile<T> mLastAccessedTile;
    public final int mTileSize;
    private final SparseArray<Tile<T>> mTiles = new SparseArray<>(10);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        public Tile<T> mNext;
        public int mStartPosition;

        public Tile(Class<T> cls, int i10) {
            this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
        }

        public boolean containsPosition(int i10) {
            int i11 = this.mStartPosition;
            return i11 <= i10 && i10 < i11 + this.mItemCount;
        }

        public T getByPosition(int i10) {
            return this.mItems[i10 - this.mStartPosition];
        }
    }

    public TileList(int i10) {
        this.mTileSize = i10;
    }

    public Tile<T> addOrReplace(Tile<T> tile) {
        int indexOfKey = this.mTiles.indexOfKey(tile.mStartPosition);
        if (indexOfKey < 0) {
            this.mTiles.put(tile.mStartPosition, tile);
            return null;
        }
        Tile<T> valueAt = this.mTiles.valueAt(indexOfKey);
        this.mTiles.setValueAt(indexOfKey, tile);
        if (this.mLastAccessedTile == valueAt) {
            this.mLastAccessedTile = tile;
        }
        return valueAt;
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int i10) {
        if (i10 < 0 || i10 >= this.mTiles.size()) {
            return null;
        }
        return this.mTiles.valueAt(i10);
    }

    public T getItemAt(int i10) {
        Tile<T> tile = this.mLastAccessedTile;
        if (tile == null || !tile.containsPosition(i10)) {
            int indexOfKey = this.mTiles.indexOfKey(i10 - (i10 % this.mTileSize));
            if (indexOfKey < 0) {
                return null;
            }
            this.mLastAccessedTile = this.mTiles.valueAt(indexOfKey);
        }
        return this.mLastAccessedTile.getByPosition(i10);
    }

    public Tile<T> removeAtPos(int i10) {
        Tile<T> tile = this.mTiles.get(i10);
        if (this.mLastAccessedTile == tile) {
            this.mLastAccessedTile = null;
        }
        this.mTiles.delete(i10);
        return tile;
    }

    public int size() {
        return this.mTiles.size();
    }
}

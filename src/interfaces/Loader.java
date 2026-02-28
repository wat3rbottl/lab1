package interfaces;

public interface Loader<T extends Transportable> {

    boolean canLoad(T item);

    boolean canUnload();

    void load(T item);

    T unload();

}

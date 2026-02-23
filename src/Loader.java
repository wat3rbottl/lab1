public interface Loader<T extends Loadable> extends HasPosition {

    boolean canLoad(T item);

    void load(T item);

    T unload();

}

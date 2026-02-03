public interface Loader<T> {

    public void load(T item);

    public T unload();
}

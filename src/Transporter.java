public interface Transporter<T extends Transportable> {
    public void load(T item);

    public T unload();
}

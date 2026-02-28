package interfaces;

public interface Transporter<T extends Transportable> extends Loader<T> {

    default int getCapacity() { return Integer.MAX_VALUE; }

    default int getLoadCount() { return 0; }
}

public interface Rampable {

    boolean atMax();
    boolean atMin();

    default void lower(){}
    default void raise(){}

}

package mySpring;


public interface ObjectConfig {
    /**
     * Invokes object configuration to the passed object.
     * @param o passed object.
     */
    <T> void invoke(T o);
}

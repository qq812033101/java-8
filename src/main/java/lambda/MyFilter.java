package lambda;

@FunctionalInterface
public interface MyFilter<T> {
    boolean test(T t);
}

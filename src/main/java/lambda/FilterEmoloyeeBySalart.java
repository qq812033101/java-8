package lambda;

public class FilterEmoloyeeBySalart<T> implements MyFilter<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSlary() >= 5000;
    }
}

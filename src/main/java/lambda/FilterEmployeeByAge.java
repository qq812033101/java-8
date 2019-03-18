package lambda;

public class FilterEmployeeByAge<T> implements MyFilter<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }


}

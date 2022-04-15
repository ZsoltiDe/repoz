package hu.unideb.inf.model;

import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.ArrayList;
import java.util.List;

public interface JpaDAO extends AutoCloseable {
    void Save(Employee employee);
    void Upadate(Employee employee);
    List<Employee> GetList();
    void Delete (Employee student);

}

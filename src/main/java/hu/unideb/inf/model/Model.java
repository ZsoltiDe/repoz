package hu.unideb.inf.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    private Employee employee;
    private ObservableList<Employee> observableListEmployee= FXCollections.observableArrayList();
   // private EmployeePropertyClass propertyClass = new EmployeePropertyClass();
    private JpaDAO JpaDao =  new EmployeeDAO();

    public ObservableList<Employee> getObservableList() {
        return observableListEmployee;
    }

    /*public EmployeePropertyClass getPropertyClass() {
        return propertyClass;
    }*/
    /*public void setPropertyClass(EmployeePropertyClass studenProperty) {
        this.propertyClass=studenProperty;
    }*/

    public JpaDAO getJpaDao() {
        return JpaDao;
    }



    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee=employee;
        observableListEmployee.add(employee);
    }
    /*public void loadData(){

        for(int i=0;i<JpaDao.GetList().size();i++){
            EmployeePropertyClass temp= new EmployeePropertyClass();
            temp.setName(JpaDao.GetList().get(i).getFirstName());
            temp.setLastName(JpaDao.GetList().get(i).getLastName());
            observableList.add(temp);




        }




    }*/
    public void loadData(){
        for(int i=0;i<JpaDao.GetList().size();i++){
           observableListEmployee.add(JpaDao.GetList().get(i));




        }

    }




    public Model(){
        this.employee= new Employee();

    }




}







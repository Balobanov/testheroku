package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created by User on 25.10.2016.
 */
@Service
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService{
}

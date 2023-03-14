package com.shrey.Employee.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*Here we have used all args and no args contructor
   in order to user as the name suggests the contructor
   with all and no arguments*/
public class Employee {

    private long id;
    private String first_name;
    private String last_name;
    private String emailId;
}

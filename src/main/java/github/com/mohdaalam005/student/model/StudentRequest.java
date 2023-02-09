package github.com.mohdaalam005.student.model;

import lombok.Data;

@Data
public class StudentRequest extends StudentResponse {
    private String firstName ;

    private String lastName ;

    private String dob ;

    private String gender ;
}

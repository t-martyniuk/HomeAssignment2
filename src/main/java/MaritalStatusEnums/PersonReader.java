package MaritalStatusEnums;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonReader {
    private String name;
    private int age;
    private int maritalCode;

    public void printToCmd() {
        MaritalStatus status = MaritalStatus.findByDbCode(maritalCode);
        Person person = new Person (name,age,status);
        System.out.println(person.toString());
    }


}

package MaritalStatusEnums;


import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataFactory df = new DataFactory();
        Random random = new Random();
        Person person0 = new Person("", 0, MaritalStatus.SINGLE);

        while (true) {
            PersonReader reader1 = new PersonReader(df.getName(), df.getNumberBetween(20,80),df.getNumberBetween(1,5));
            reader1.printToCmd();
            Person person1 = new Person(reader1.getName(), reader1.getAge(), MaritalStatus.findByDbCode(reader1.getMaritalCode()));
            if (person0.equals(person1)) { //checking exactly the previous person, not all who were before
                System.out.println("You again?");
            }
            person0 = person1;
            Thread.sleep(1000);
        }

    }
}

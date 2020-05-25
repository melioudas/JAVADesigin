package builder.mashibing;

/**
 * 来个实际用法
 * 假设此类有好几十个属性，很复杂
 */
public class Person {
    private String name;
    private int age;
    private String content;
    private String friend;
    //可能还有很多属性
    //... ...

    public static class PersonBilder {
        Person person = new Person();

        public PersonBilder setName(String name) {
            person.name = name;
            return this;
        }

        public PersonBilder setAgeAndFriend(int age, String friend) {
            person.age = age;
            person.friend = friend;
            return this;
        }

        public Person getPerson() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", content='" + content + '\'' +
                ", friend='" + friend + '\'' +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Person.PersonBilder p = new Person.PersonBilder();
        Person person = p.setAgeAndFriend(10, "龙").getPerson();
        System.out.println(person);

    }
}
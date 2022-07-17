package kuanyan.start.comparator;

import java.util.*;

public class Base {
    private static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void printPersonList(List<Person> list) {
        for (Person person : list) {
            System.out.println(person.name + ": " + person.age);
        }
    }

    public static void printPersonQueue(Queue<Person> queue) {
        for (Person person : queue) {
            System.out.println(person.name + ": " + person.age);
        }
    }

    public static class ageComparator implements Comparator<Person> {
        // compare 方法的返回值小于0时，第一个参数o1排在前面
        // 返回的值大于0时，第二个参数o2排在前面
        // 返回值为0时，任意
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(20, "Tom"));
        personList.add(new Person(4, "Mike"));
        personList.add(new Person(25, "Jerry"));
        personList.add(new Person(16, "Jone"));
        personList.add(new Person(44, "Tony"));

        printPersonList(personList);
        System.out.println("=============");

        // 按照年龄从下到大排序
        personList.sort(new ageComparator());
        printPersonList(personList);
        System.out.println("=============");

        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(new ageComparator());
        priorityQueue.add(new Person(20, "Tom"));
        priorityQueue.add(new Person(4, "Mike"));
        priorityQueue.add(new Person(25, "Jerry"));
        priorityQueue.add(new Person(16, "Jone"));
        priorityQueue.add(new Person(44, "Tony"));

        printPersonQueue(priorityQueue);
    }
}

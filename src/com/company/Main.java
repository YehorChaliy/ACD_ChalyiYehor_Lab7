package com.company;
import java.util.*;
import java.util.ArrayList;

public class Main {

    static void menu() {
        System.out.println("Меню: ");
        System.out.println("1. Знайти максимальне та мінімальне значення записів вершин не порожнього дерева;");
        System.out.println("2. Вивести записи з усіх листів дерева;");
        System.out.println("3. Обхід дерева;");
        System.out.println("4. Видалення елемента та вивід відновленого списку;");
        System.out.println("5. Вивести невідсортирований список віку людей;");
        System.out.println("6. Вісортирований список віку людей в тому порядку, в якому вони будуть виходити на пенсію;");
        System.out.println("7. Вийти з програми;");
    }

    public static void main(String[] args) throws Exception {

        //Включення елементів в дерево:
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);
        binarySearchTree.insert(20);
        binarySearchTree.insert(17);
        binarySearchTree.insert(25);

        //Вносимо вік людей в дерево
        BinarySearchTree BinarySearchTree1 = new BinarySearchTree();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(60));
        personList.add(new Person(50));
        personList.add(new Person(67));
        personList.add(new Person(39));
        personList.add(new Person(23));
        personList.add(new Person(64));

        Scanner scanner = new Scanner(System.in);
        int selection;
        while (true) {
            menu();
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("\n");
                    System.out.println("Мінімальне значення записів вершин: "+  binarySearchTree.min());
                    System.out.println("Максимальне значення записів вершин: " + binarySearchTree.max());
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("Вивід дерева на екран: ");
                    List<Double> list =  binarySearchTree.getSortedList();
                    System.out.println(list);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("Сумму елементів дерева через обхід дерева в глубину: " + binarySearchTree.sumDeep());
                    System.out.println("Сумму елементів дерева через обхід дерева в ширину: " + binarySearchTree.sumWidth());
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    //Отримуємо відповідну ноду за допомогою методу get
                    NodeBinarySearchTree nodeBinarySearchTree = binarySearchTree.get(15);
                    System.out.println("Видаляємо ноду, яка містить число 15 і виводимо дерево:");
                    binarySearchTree.remove(15);
                    System.out.println(binarySearchTree.getSortedList());
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\nНевідсортирований список віку людей: ");
                    personList.stream().forEach(e -> System.out.print(e.getAge() + " "));
                    //Вношу вік людей у дерево
                    personList.forEach(e -> BinarySearchTree1.insert(e.getAge()));
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\nВісортирований список віку людей: ");
                    System.out.println(BinarySearchTree1.getSortedListForSecondTask());
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("\n");
                    System.out.println("Програму завершено!");
                    System.exit(0);
                default:
                    System.out.println("Введіть вірне значення!");
            }
        }


    }
}

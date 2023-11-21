package ru.pfur.skis.ui;

import ru.pfur.skis.command.AddBarCommand;
import ru.pfur.skis.command.AddNodeCommand;
import ru.pfur.skis.model.Bar;
import ru.pfur.skis.model.Model;
import ru.pfur.skis.model.Node;

import javax.swing.*;

/**
 * Created by Kamran on 5/22/2016.
 */
public class CreateSchemes extends JFrame {
    private static void createTruss(Model model) {
        double x = 5 * 50;
        double y = 5 * 50;
        double z = 5 * 50;
        double hx = 30;
        double hy = 50;
        double hz = 20;
        double n = 9;
        double nx = 5;
        double ny = 9;
        double nz = 5;

        Node node1 = new Node(10, 10, 10);
        Node node2 = new Node(10, 50, 10);
        Node node3 = new Node(50, 50, 10);
        Node node4 = new Node(50, 10, 10);
        Node node5 = new Node(10, 10, 50);
        Node node6 = new Node(10, 50, 50);
        Node node7 = new Node(50, 50, 50);
        Node node8 = new Node(50, 10, 50);

        new AddNodeCommand(model, node1);
        new AddNodeCommand(model, node2);
        new AddNodeCommand(model, node3);
        new AddNodeCommand(model, node4);
        new AddNodeCommand(model, node5);
        new AddNodeCommand(model, node6);
        new AddNodeCommand(model, node7);
        new AddNodeCommand(model, node8);

        AddBarCommand addBarCommand1 = new AddBarCommand(model, new Bar(node1, node2));
        AddBarCommand addBarCommand2 = new AddBarCommand(model, new Bar(node2, node3));
        AddBarCommand addBarCommand3 = new AddBarCommand(model, new Bar(node3, node4));
        AddBarCommand addBarCommand4 = new AddBarCommand(model, new Bar(node5, node6));
        AddBarCommand addBarCommand5 = new AddBarCommand(model, new Bar(node6, node7));
        AddBarCommand addBarCommand6 = new AddBarCommand(model, new Bar(node7, node8));
        AddBarCommand addBarCommand7 = new AddBarCommand(model, new Bar(node2, node6));
        AddBarCommand addBarCommand8 = new AddBarCommand(model, new Bar(node3, node7));


    }

    private static void smallTest(Model model) {
        Node n1 = new Node(10, 10, 10);
        Node n2 = new Node(30, 30, 30);
        Node n3 = new Node(60, 60, 60);
        Node n4 = new Node(30, 60, 60);
        Node n5 = new Node(60, 30, 60);

        new AddNodeCommand(model, n1);
        new AddNodeCommand(model, n2);
        new AddNodeCommand(model, n3);
        new AddNodeCommand(model, n4);
        new AddNodeCommand(model, n5);

        new AddBarCommand(model, new Bar(n1, n2));
    }

    private static void createTestModel(Model model) {
        double t = 0;
        double s = 0;
        Node prev = null;
        int num = 0;
        double f = (Math.PI / 2 - (-Math.PI / 2)) / 200;


        for (t = (-Math.PI / 2); t < (Math.PI / 2); t = t + f) {
            for (s = 0; s < (Math.PI / 2); s = s + 0.05) {

                num++;
                int x = (int) ((1 + Math.cos(2 * (Math.PI / 2 * t))) * Math.cos(2 * (2 * Math.PI * s)) * 100);
                int y = (int) ((1 + Math.cos(2 * (Math.PI / 2 * t))) * Math.sin(2 * (2 * Math.PI * s)) * 100);
                int z = (int) (Math.sin(2 * (Math.PI / 2 * t)) * Math.sin(2 * Math.PI * s) * 100);
                Node n = new Node(x, y, z);
                new AddNodeCommand(model, n);

                if (prev != null && prev != n) {
                    new AddBarCommand(model, new Bar(prev, n));
                    num++;
                }
                prev = n;
            }

        }
        System.out.println(num);
    }

    public static void ellipsoid(Model model) {
        double t;
        double s;
        Node prev = null;
        int num = 0;

        double f = (Math.PI / 2) / 100;

        for (t = 0; t < (Math.PI / 2); t = t + f) {
            for (s = 0; s < Math.PI / 3; s = s + 0.05) {
                num++;
                int x = (int) ((Math.sin(Math.PI / 2 * t) * Math.cos(Math.PI * s)) * 50);
                int y = (int) ((3 * Math.sin(Math.PI / 2 * t) * Math.sin(Math.PI * s)) * 50);
                int z = (int) ((2 * Math.cos(Math.PI * t)) * 50);
                Node n = new Node(x, y, z);
                new AddNodeCommand(model, n);

                if (prev != null && prev != n) {
                    new AddBarCommand(model, new Bar(prev, n));
                    num++;
                }
                prev = n;
            }

        }


        System.out.println(num);
    }

    public static void semiCycloid(Model model) {
        double t;
        double s;
        Node prev = null;
        int num = 0;

        for (t = 0; t < Math.PI / 3; t = t + 0.05) {
            for (s = 0; s < Math.PI; s = s + 0.05) {
                num++;
                int x = (int) ((2 * (3.1415 * t + Math.sin(Math.PI * t)) * Math.sin(2 * Math.PI * s)) * 20);
                int y = (int) ((8 * (1 + Math.cos(Math.PI * t))) * 20);
                int z = (int) ((2 * (3.1415 * t + Math.sin(Math.PI * t)) * Math.cos(2 * Math.PI * s)) * 20);
                Node n = new Node(x, y, z);
                new AddNodeCommand(model, n);

                if (prev != null && prev != n) {
                    new AddBarCommand(model, new Bar(prev, n));
                    num++;
                }
                prev = n;
            }
        }


        System.out.println(num);
    }

    public static void crossShell(Model model) {
        double t;
        double s;
        Node prev = null;
        int num = 0;

        for (t = 0; t < Math.PI / 3; t = t + 0.1) {
            for (s = 0; s < Math.PI; s = s + 0.1) {
                num++;
                int x = (int) ((3.1415 * t - 3.1415 * 0.5) * Math.sin(2 * Math.PI * s)) * 20;
                int y = (int) ((3.1415 * t - 3.1415 * 0.5) * Math.cos(2 * Math.PI * s)) * 20;
                int z = (int) (((2 * (Math.pow((3.1415 * t - 3.1415 * 0.5), 4) * (Math.sin(Math.pow((4 * Math.PI * s), 2))))) / 4) * 20);
                Node n = new Node(x, y, z);
                new AddNodeCommand(model, n);

                if (prev != null && prev != n) {
                    new AddBarCommand(model, new Bar(prev, n));
                    num++;
                }
                prev = n;
            }

            prev = null;
        }


        System.out.println(num);
    }

    //88
    public static void semiCon(Model model) {
        double t = 0;
        double s = 0;
        Node prev = null;
        int num = 0;

        double f = (Math.PI / 2 - (-Math.PI / 2)) / 500;

        for (t = 0; t < 1; t = t + f) {

            for (s = 0; s < 2 * Math.PI; s = s + 0.1) {
                num++;
                int x = (int) ((4 * (1 - t)) * 50);
                int y = (int) (((4 - 2 * t) * Math.cos(Math.PI * s)) * 50);
                int z = (int) ((Math.sin(Math.PI * s)) * 50);
                Node n = new Node(x, y, z);
                new AddNodeCommand(model, n);

                if (prev != null && prev != n) {
                    new AddBarCommand(model, new Bar(prev, n));
                    num++;
                }
                prev = n;
            }

        }
        System.out.println(num);
    }

    public static void corrugatedSphere(Model model) {
        double t = 0;
        double s = 0;
        Node prev = null;
        int num = 0;

        for (t = 0; t < 2 * Math.PI; t = t + 0.05) {
            for (s = 0; s < Math.PI; s = s + 0.05) {

                num++;
                int x = (int) (((5 + Math.cos(2 * Math.PI * t) + 2 * (1 - Math.sin(Math.PI * t)) * Math.cos(6 * 2 * Math.PI * s)) * Math.cos(2 * Math.PI * s)) * 20);
                int y = (int) (((5 + Math.cos(2 * Math.PI * t) + 2 * (1 - Math.sin(Math.PI * t)) * Math.cos(6 * 2 * Math.PI * s)) * Math.sin(2 * Math.PI * s)) * 20);
                int z = (int) ((5 * Math.sin(Math.PI * t)) * 20);

                Node n = new Node(z, y, x);
                new AddNodeCommand(model, n);
                if (prev != null && prev != n) {
                    new AddBarCommand(model, new Bar(prev, n));
                    num++;
                }
                prev = n;
            }


        }
        System.out.println(num);
    }

}

package com.mycompany.project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Project 
{

    public static void main(String[] args) 
    {
        App a = new App();
        a.st();
    }
}
abstract class GeometricObject {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double calculateArea() {
        return width * height;
    }

    double calculatePerimeter() {
        return 2 * (width + height);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side); 
    }
}

class App extends JFrame implements ActionListener {
    String s;
    private JFrame frame;
    private JComboBox<String> shape;
    private JTextField t1, t2, t3;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    private JButton b1;

    public void st() {
        frame = new JFrame("Geometry Calculator");
        frame.setSize(400, 350);
        frame.setLocation(600, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        String[] shapes = {"Non","Rectangle", "Circle", "Square"};
        shape = new JComboBox<>(shapes);
        l1 = new JLabel("Select Shape:");
        l1.setBounds(20, 10, 100, 20);
        shape.setBounds(120, 10, 90, 20);
        frame.add(l1);
        frame.add(shape);

        l2 = new JLabel();
        l3 = new JLabel("Height:");
        l4 = new JLabel("Radius:");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        frame.add(l2);
        frame.add(t1);
        frame.add(l3);
        frame.add(t2);
        frame.add(l4);
        frame.add(t3);

        b1 = new JButton("Calculate and Display");
        b1.setBounds(110, 140, 160, 30);
        frame.add(b1);
        b1.addActionListener(this);
        l5 = new JLabel("Area: ");
        l6 = new JLabel("Perimeter:");
        l7 = new JLabel();
        l8 = new JLabel();

        l5.setBounds(140, 180, 100, 25);
        frame.add(l5);
        l7.setBounds(200, 180, 500, 25);
        frame.add(l7);

        l6.setBounds(130, 220, 100, 25);
        frame.add(l6);
        l8.setBounds(200, 220, 500, 25);
        frame.add(l8);
        shape.addActionListener(this);
        s = (String) shape.getSelectedItem();
         l2.setVisible(false);
         l3.setVisible(false);
         l4.setVisible(false);
         t1.setVisible(false);
         t2.setVisible(false);
         t3.setVisible(false);
         b1.setVisible(false);
         l5.setVisible(false);
         l6.setVisible(false);
         l7.setVisible(false);
         l8.setVisible(false);
         frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
    {
         if(shape.getSelectedIndex()==1)
       {
           l7.setText(null);
           l8.setText(null);
           l2.setText("Width:"); 
           l2.setBounds(40, 50, 100, 25);
           t1.setBounds(90, 50, 120, 25);
           l3.setBounds(40, 90, 100, 25);
           t2.setBounds(90, 90, 120, 25);
           b1.setVisible(true);
           l5.setVisible(true);
           l6.setVisible(true);
           l7.setVisible(true);
           l8.setVisible(true);
           l2.setVisible(true);
           l3.setVisible(true);
           t1.setVisible(true);
           t2.setVisible(true);
           l4.setVisible(false);
           t3.setVisible(false);
       }
         
         else if(shape.getSelectedIndex()==0)
         {
         l7.setText(null);
         l8.setText(null);
         l2.setVisible(false);
         l3.setVisible(false);
         l4.setVisible(false);
         t1.setVisible(false);
         t2.setVisible(false);
         t3.setVisible(false);
         b1.setVisible(false);
         l5.setVisible(false);
         l6.setVisible(false);
         l7.setVisible(false);
         l8.setVisible(false);
         }
         
         else if(shape.getSelectedIndex()==2)
       {
           l7.setText(null);
           l8.setText(null);
           l4.setBounds(40, 70, 100, 25);
           t3.setBounds(90, 70, 120, 25);
           b1.setVisible(true);
           l5.setVisible(true);
           l6.setVisible(true);
           l7.setVisible(true);
           l8.setVisible(true);
           l4.setVisible(true);
           t3.setVisible(true);
           l2.setVisible(false);
           l3.setVisible(false);
           t1.setVisible(false);
           t2.setVisible(false);
       }
         
        else if(shape.getSelectedIndex()==3)
       {
           l7.setText(null);
           l8.setText(null);
           l2.setText("Side:");
           l2.setBounds(40, 70, 100, 25);
           t1.setBounds(80, 70, 120, 25);
           b1.setVisible(true);
           l5.setVisible(true);
           l6.setVisible(true);
           l7.setVisible(true);
           l8.setVisible(true);
           l2.setVisible(true);
           t1.setVisible(true);
           l3.setVisible(false);
           t2.setVisible(false);
           l4.setVisible(false);
           t3.setVisible(false);

       }
        if (e.getSource() == b1) {
            s = (String) shape.getSelectedItem();
            if ("Circle".equals(s)) {
                double radius;          
                try {
                    radius = Double.parseDouble(t3.getText());
                    String q=t3.getText();
                    t3.setText(null);
                    int l=q.length();
                    int x=0;
                   if (q.charAt(l - 1) == 'd'||q.charAt(l-1)=='f'||q.charAt(l - 1) == 'D'||q.charAt(l - 1) == 'F') 
                    {
                        x=1;
                     JOptionPane.showMessageDialog(frame, "Invalid input for Radius. Please enter a valid number.")  ;              
                    }
                    if (radius > 0&&x==0) {
     
                        Circle c = new Circle(radius);
                        l7.setText(String.valueOf(c.calculateArea()));
                        l8.setText(String.valueOf(c.calculatePerimeter()));
                    } else if(radius == 0&&x==0) {
                        JOptionPane.showMessageDialog(frame, "Radius must be greater than 0.");
                    }
                    else if(radius<0&&x==0)
                    {
                        throw new IllegalArgumentException("Radius must be greater than 0");
                    }
                } catch ( NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input for Radius. Please enter a valid number.");
                }
                catch(IllegalArgumentException om)
                {
                   JOptionPane.showMessageDialog(frame, "Radius must be greater than 0.");
                }
            } else if ("Rectangle".equals(s)) {
                double w, h;
                try {                                       
                    w = Double.parseDouble(t1.getText());
                    h = Double.parseDouble(t2.getText());
                    String a,b;
                    a=t1.getText();
                    b=t2.getText();
                    t1.setText(null);
                    t2.setText(null);
                    int v=a.length(),n=b.length();
                    int z=0;
                    if (a.charAt(v - 1) == 'd'||a.charAt(v-1)=='f'||a.charAt(v - 1) == 'D'||a.charAt(v - 1) == 'F') 
                    {
                      z=1;
          JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for Width and Height.");              
                    }
                    if (w > 0 && h > 0&&z==0) {
                        Rectangle r = new Rectangle(w, h);
                        l7.setText(String.valueOf(r.calculateArea()));
                        l8.setText(String.valueOf(r.calculatePerimeter()));                       
                    } else if((w==0||h==0)&&z==0) {
                        JOptionPane.showMessageDialog(frame, "Width and Height must be greater than 0.");
                    }
                    else if((w<0||h<0)&&z==0)
                    {
                        throw new IllegalArgumentException("Width and Height must be greater than 0");
                    }                                 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for Width and Height.");
                }
                catch(IllegalArgumentException om)
                {
                 JOptionPane.showMessageDialog(frame, "Width and Height must be greater than 0.");
                }
            } else if ("Square".equals(s)) {
                double side;
                try {
                    side = Double.parseDouble(t1.getText());
                    String p;
                    p=t1.getText();
                    t1.setText(null);
                    int m=p.length();
                    int o=0;
                    if(p.charAt(m - 1) == 'd'||p.charAt(m-1)=='f'||p.charAt(m - 1) == 'D'||p.charAt(m - 1) == 'F')
                    {
                        o=1;
                       JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number for Side."); 
                    }
                    if (side > 0&&o==0) {
                        Square sq = new Square(side);
                        l7.setText(String.valueOf(sq.calculateArea()));
                        l8.setText(String.valueOf(sq.calculatePerimeter()));
                    } else if(side==0&&o==0) {
                        JOptionPane.showMessageDialog(frame, "Side must be greater than 0.");
                    }
                    else if(side<0&&o==0)
                    {
                         throw new IllegalArgumentException("Side must be greater than 0");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number for Side.");
                }
                catch (IllegalArgumentException om) {
                        JOptionPane.showMessageDialog(frame, "Side must be greater than 0.");
                }
            }
        }
    }
}
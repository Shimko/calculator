import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Сalculator extends JFrame {
    private JButton numbers [] = new JButton[10];
    private JTextField output = new JTextField();
    private JButton backspase = new JButton("x"), equ = new JButton("=");
    private JButton plus = new JButton("+"), minus = new JButton("-"), multi = new JButton("*"), div = new JButton(":");
    private Double firstValue;
    private String operation;

    public Сalculator() {
        setTitle(" Test Window");
        backspase.setBounds(10,250,50,50);
        add(backspase);
        equ.setBounds(130,250,50,50);
        add(equ);
        plus.setBounds(190,70,50,50);
        add(plus);
        minus.setBounds(190,130,50,50);
        add(minus);
        multi.setBounds(190,190,50,50);
        add(multi);
        div.setBounds(190,250,50,50);
        add(div);

        setBounds(500,500,350,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70,250,50,50);
        add(numbers[0]);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y <3 ; y++) {
                numbers[x *3 + y +1] = new JButton((x *3 + y +1)+"");
                numbers[x *3 + y +1].setBounds(x*(50+10)+ 10, y*(50+10)+70,50 ,50);
                add(numbers[x *3 + y +1]);
            }
        }
        output.setBounds(10,10,230,50);
        output.setEditable(false);
        add(output);
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                output.setText(output.getText() +b.getText());
            }
        };
        backspase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String temp  = output.getText();
                    output.setText(temp.substring(0,temp.length() - 1));
                }catch(Exception b){
                    System.out.println("Значение отсутствует");
                }
            }
        });
        plus. addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Double.valueOf(output.getText());
                output.setText("");
                operation = "+";
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Double.valueOf(output.getText());
                output.setText("");
                operation = "-";
            }
        });
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Double.valueOf(output.getText());
                output.setText("");
                operation = "*";
            }
        });
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstValue = Double.valueOf(output.getText());
                output.setText("");
                operation = "/";
            }
        });
        equ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double secondValue = Double.valueOf(output.getText()); /* также используем double, valueOf возвращает
            десятичное значение, передаем в параметр полечение текста в поле */
                if ("+".equals(operation)) {
                    output.setText((firstValue + secondValue) + "");
                }
                if ("-".equals(operation)) {
                    output.setText((firstValue - secondValue) + "");
                }
                if ("*".equals(operation)) {
                    output.setText((firstValue * secondValue) + "");
                }
                if ("/".equals(operation)) {
                    output.setText((firstValue / secondValue) + "");
                }
                firstValue = Double.valueOf(0);
                operation = "+";
            }
        });

        for (JButton b: numbers) {
            b.addActionListener(l);
        }
        addKeyListener(new KeyAdapter() {
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Сalculator();
    }

}

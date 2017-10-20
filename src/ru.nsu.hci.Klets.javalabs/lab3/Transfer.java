package ru.nsu.hci.Klets.javalabs.lab3;

import java.util.Stack;
import java.util.Scanner;
import java.lang.String;

public class Transfer {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите Инфиксную форму: ");
        String Inf = in.nextLine();
        String Postf = InfToPostf(Inf);
        System.out.println("Постфиксная форма: " + Postf);
        float OtvetPost = CountPostf(Postf);
        System.out.println("Результат " + OtvetPost);
    }

    public static float StackToFloat(Stack stack) {
        Object A = stack.peek();
        stack.pop();
        String S = A.toString();
        float F = Float.parseFloat(S);
        return F;
    }

    public static float CountPostf(String x) {
        Stack stack = new Stack();
        String Chislo = "";
        for (char chr : x.toCharArray()) {
            if (chr >= '0' && chr <= '9' || chr == '.') {
                Chislo += chr;
            } else {
                if (chr == ' ') {
                    if (Chislo != "") {
                        stack.push(Chislo);
                        Chislo = "";
                    }
                    continue;
                }
                float last = StackToFloat(stack);
                float last2 = StackToFloat(stack);
                switch (chr) {
                    case '+':
                        stack.push(last2 + last);
                        break;
                    case '-':
                        stack.push(last2 - last);
                        break;
                    case '*':
                        stack.push(last2 * last);
                        break;
                    case '/':
                        stack.push(last2 / last);
                        break;

                    default:
                }
            }
        }
        float R = StackToFloat(stack);
        while (stack.empty() == false)
            stack.pop();
        return R;
    }

    public static String InfToPostf(String x) {
        Stack stack = new Stack();
        String yy = "";
        String y = "";
        for (char chr : x.toCharArray()) {
            if (chr >= '0' && chr <= '9' || chr == '.') {
                yy += chr;
            } else {
                if (yy != "") {
                    y += yy + ' ';
                    yy = "";
                }
                switch (chr) {
                    case '(':
                        stack.push("(");
                        break;

                    case ')':
                        while (stack.peek() != "(") {
                            y += stack.peek();
                            y += " ";
                            stack.pop();
                            if (stack.empty())
                                break;
                        }
                        stack.pop();
                        break;
                    case '+':
                        if ((stack.empty()) || (stack.peek() == "("))
                            stack.push("+");
                        else {
                            while ((stack.peek() == "+") || (stack.peek() == "-") || (stack.peek() == "*") || (stack.peek() == "/")) {
                                y += stack.peek();
                                y += " ";
                                stack.pop();
                                if (stack.empty())
                                    break;
                            }
                            stack.push("+");
                        }
                        break;
                    case '-':
                        if ((stack.empty()) || (stack.peek() == "("))
                            stack.push("-");
                        else {
                            while ((stack.peek() == "+") || (stack.peek() == "-") || (stack.peek() == "*") || (stack.peek() == "/")) {
                                y += stack.peek();
                                y += " ";
                                stack.pop();
                                if (stack.empty())
                                    break;
                            }
                            stack.push("-");
                        }
                        break;
                    case '*':
                        if ((stack.empty()) || (stack.peek() == "("))
                            stack.push("*");

                        else {
                            if ((stack.peek() == "*") || ((stack.peek() == "/"))) {
                                y += stack.peek();
                                y += " ";
                                stack.pop();
                            }
                            stack.push("*");
                        }
                        break;
                    case '/':
                        if ((stack.empty()) || (stack.peek() == "("))
                            stack.push("/");
                        else {
                            if ((stack.peek() == "*") || ((stack.peek() == "/"))) {
                                y += stack.peek();
                                y += " ";
                                stack.pop();
                            }
                            stack.push("/");
                        }
                        break;

                    default:
                }
            }
        }
        if (yy != "")
            y += yy + ' ';
        while (stack.empty() == false) {
            y += stack.peek();
            y += " ";
            stack.pop();
        }
        return y;

    }

}

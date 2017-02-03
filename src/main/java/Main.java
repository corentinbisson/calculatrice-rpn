import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by coren on 02/02/2017.
 */
public class Main {

    private static boolean trace = false;

    public static void main(String[] args) {
        if (args.length == 1) {
            evaluer(args[0]);
        } else {
            entree();
        }
    }

    public static String sommet(Stack<String> pile) {
        return pile.peek();
    }

    public static Stack<String> traitement(Stack<String> pile, String op) throws EmptyStackException, IllegalArgumentException {

        try {
            Double.parseDouble(op);
            pile.add(op);
        } catch (NumberFormatException e) {

            if (op.equals("+")) {
                double op1 = Double.parseDouble(pile.pop());
                double op2 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(op1 + op2));
            } else if (op.equals("-")) {
                double op1 = Double.parseDouble(pile.pop());
                double op2 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(op2 - op1));
            } else if (op.equals("*")) {
                double op1 = Double.parseDouble(pile.pop());
                double op2 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(op1 * op2));
            } else if (op.equals("/")) {
                double op1 = Double.parseDouble(pile.pop());
                double op2 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(op2 / +op1));
            } else if (op.equals("sqrt")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.sqrt(op1)));
            } else if (op.equals("carré")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.pow(op1, 2)));
            } else if (op.equals("sin")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.sin(op1)));
            } else if (op.equals("cos")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.cos(op1)));
            } else if (op.equals("tan")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.tan(op1)));
            } else if (op.equals("inv")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(1 / op1));
            } else if (op.equals("opp")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(-op1));
            } else if (op.equals("carré")) {
                double op1 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.pow(op1, 2)));
            } else if (op.equals("puiss")) {
                double op1 = Double.parseDouble(pile.pop());
                double op2 = Double.parseDouble(pile.pop());
                pile.push(String.valueOf(Math.pow(op2, op1)));
            } else if (op.equals("!")) {
                double op1 = Double.parseDouble(pile.pop());
                double res = Gamma.gamma(op1);
                pile.push(String.valueOf(res));

            } else if (op.equals("pile")) {
                System.out.println(pile.toString());
            } else if (op.equals("trace")) {
                trace = true;
            } else if (op.equals("notrace")) {
                trace = false;
            } else {
                System.out.println("Saisie incorrecte");
            }
        }
        if (trace) {
            System.out.println(pile.toString());
        }
        return pile;
    }

    public static double evaluer(String s) {
        Stack<String> pile = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            String op = "";
            while (i < s.length() && !String.valueOf(s.charAt(i)).equals(" ")) {
                op += String.valueOf(s.charAt(i));
                i++;
            }
            try {
                traitement(pile, op);
            } catch (EmptyStackException e) {
                System.out.println("formule incorrecte");
                return Double.NaN;
            } catch (IllegalArgumentException e) {
                System.out.println("La fonction d'Euler est applicable pour les réels strictement positifs");
                return Double.NaN;
            }
        }
        if (pile.size() == 1) {
            System.out.println(sommet(pile));
            return Double.parseDouble(sommet(pile));
        } else {
            System.out.println("formule incorrecte");
            return Double.NaN;
        }

    }

    public static void entree() {
        Stack<String> pile = new Stack<String>();
        String res;
        Scanner sc = new Scanner(System.in);
        do {
            res = sc.nextLine();
            try {
                traitement(pile, res);
            } catch (EmptyStackException e) {
                System.out.println("Vous ne pouvez pas effectuer cette opération, la pile est vide");
            } catch (IllegalArgumentException e) {
                System.out.println("La fonction d'Euler est applicable pour les réels strictement positifs");
            }

        } while (!res.equals("stop"));
    }

}

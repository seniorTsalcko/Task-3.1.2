import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите простой пример(арабские или римские числа от 1 до 10): ");
        String exp = sc.nextLine();
        System.out.println(calc(exp));
    }
    public static String calc(String exp) throws Exception {
        int number1;
        int number2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = exp.split("[+\\-*/]");
        if (operands.length != 2)
            throw new Exception("//т.к. формат операции не удовлетворяет заданию - два операнда и один оператор");
        oper = detectOperation(exp);
        if (oper == null)
            throw new Exception("//т.к. строка не является математической операцией");
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            number1 = Roman.convToArab(operands[0]);
            number2 = Roman.convToArab(operands[1]);
            isRoman = true;
        } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            isRoman = false;
        } else
            throw new Exception("//т.к. используются одновременно разные системы счисления");
        if (number1 > 10 || number2 > 10)
            throw new Exception("//т.к. значения переменных выходят за рамки условий(от 1 до 10)");
        int arabian = calculator(number1, number2, oper);
        if (isRoman) {
            if (arabian <= 0) throw new Exception("//т.к. в римской системе нет отрицательных чисел");
            result = Roman.convToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }


        static String detectOperation (String exp){
            if (exp.contains("+")) return "+";
            else if (exp.contains("-")) return "-";
            else if (exp.contains("*")) return "*";
            else if (exp.contains("/")) return "/";
            else return null;
        }

        public static int calculator (int a, int b, String oper){
            if (oper.equals("+")) return a + b;
            else if (oper.equals("-")) return a - b;
            else if (oper.equals("*")) return a * b;
            else return a / b;
        }

class Roman {
    static String[] romanArray = new String[]{"0","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII",
        "XIV","XV","XVI","XVII","XVIII","XiX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX",
        "XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII",
        "XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
        "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV",
        "LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII",
        "LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVII","XCVIII","XCIX","C"};

            public static boolean isRoman(String val) {
                for (int i = 0; i < romanArray.length; i++) {
                    if (val.equals(romanArray[i])) return true;
                }
                return false;
            }
        public static int convToArab(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }
        public static String convToRoman(int arabian) {
            return romanArray[arabian];
            }
        }
    }

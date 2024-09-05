import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Resistores {

    /*
    static Map<Integer, String> colorsResitor = new HashMap<>();
    static {
        colorsResitor.put(0,"preto");
        colorsResitor.put(1,"marrom");
        colorsResitor.put(2,"vermelho");
        colorsResitor.put(3,"laranja");
        colorsResitor.put(4,"amarelo");
        colorsResitor.put(5,"verde");
        colorsResitor.put(6,"azul");
        colorsResitor.put(7,"violeta");
        colorsResitor.put(8,"cinza");
        colorsResitor.put(9,"branco");

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor do resistor: XX ohms");
        String input = scanner.nextLine();
        String colors;
        String valueWithMultiplier = input.replace(" ohms", "");


        scanner.close();
    }
*/

    private static final Map<Integer, String> colorMap = new HashMap<>();

    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }

    public static String getResistorColorCode(String input) {
        String[] parts = input.split(" ");
        String value = parts[0];
        StringBuilder colorCode = new StringBuilder();
        int multiplier = 0;

        if (value.contains("k")) { // Casos de 1k a 999k ohms
            double number = Double.parseDouble(value.replace("k", ""));
            int firstDigit = (int) number;
            int secondDigit = (int) (number * 10) % 10;
            multiplier += 2;

            colorCode.append(colorMap.get(firstDigit)).append(" ");
            colorCode.append(colorMap.get(secondDigit)).append(" ");
            colorCode.append(colorMap.get(multiplier)).append(" ");
        } else if (value.contains("M")) {

            double number = Double.parseDouble(value.replace("M", ""));
            int firstDigit = (int) number;
            int secondDigit = (int) (number * 10) % 10;
            multiplier += 5;

            colorCode.append(colorMap.get(firstDigit)).append(" ");
            colorCode.append(colorMap.get(secondDigit)).append(" ");
            colorCode.append(colorMap.get(multiplier)).append(" ");
        } else {
            if (value.replace(" ohms", "").contains(".")) {
                multiplier = -1;
            }
            Double ohmsValue = Double.valueOf(value);
            String ohmsStr = String.valueOf(ohmsValue.intValue());
            multiplier = ohmsStr.length() - 2;

            colorCode.append(colorMap.get(Integer.parseInt(ohmsStr.split("")[0]))).append(" ");
            colorCode.append(colorMap.get(Integer.parseInt(ohmsStr.split("")[1]))).append(" ");
            colorCode.append(colorMap.get(multiplier)).append(" ");
        }

        colorCode.append("dourado"); // Tolerância padrão de 5%

        return colorCode.toString().trim();
    }

    public static void main(String[] args) {

      System.out.println("10 ohms " + getResistorColorCode("10 ohms"));
        System.out.println("100 ohms " + getResistorColorCode("100 ohms"));
        System.out.println("220 ohms " + getResistorColorCode("220 ohms"));
        System.out.println("330 ohms " + getResistorColorCode("330 ohms"));
        System.out.println("470 ohms " + getResistorColorCode("470 ohms"));
       System.out.println("470.5 ohms " + getResistorColorCode("470.5 ohms"));
       System.out.println("680 ohms " + getResistorColorCode("680 ohms"));
      System.out.println("1k ohms " + getResistorColorCode("1k ohms"));
       System.out.println("4.7k ohms " + getResistorColorCode("4.7k ohms"));
       System.out.println("2M ohms " + getResistorColorCode("2M ohms"));
       System.out.println("2.1M ohms " + getResistorColorCode("2.1M ohms"));

    }

}

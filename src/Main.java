import java.util.Scanner;

class Main {

  // Conversion methods supplied by course materials as requested
  static double convertToCelsius(String from, double temp) {
    double answer = temp;
    if (from.charAt(0) == 'f') {
      answer = (5.0 / 9) * (answer - 32);
    }
    if (from.charAt(0) == 'r') {
      answer = (5.0 / 9) * (answer - 492);
    }
    if (from.charAt(0) == 'k') {
      answer = answer - 273;
    }
    return answer;
  }

  static double convertFromCelsius(String to, double temp) {
    double answer = temp;
    if (to.charAt(0) == 'f') {
      answer = (9.0 / 5) * answer + 32;
    }
    if (to.charAt(0) == 'r') {
      answer = (9.0 / 5) * answer + 492;
    }
    if (to.charAt(0) == 'k') {
      answer = answer + 273;
    }
    return answer;
  }

  /// Requests an integer from the user in the range min, max, inclusive.
  static int inputRange(String prompt, int min, int max, Scanner scanner) {
    System.out.print(prompt);

    int result;
    while (
      !scanner.hasNextInt() ||
      (result = scanner.nextInt()) < min ||
      result > max
    ) {
      System.out.format(
        "Please enter a valid number from %d to %d: ",
        min,
        max
      );
      scanner.nextLine();
    }

    scanner.nextLine();

    return result;
  }

  /// Requests a floating point number from the user.
  static double inputDouble(String prompt, Scanner scanner) {
    System.out.print(prompt);

    while (!scanner.hasNextDouble()) {
      System.out.print("Please enter a valid number: ");
      scanner.nextLine();
    }

    double result = scanner.nextDouble();
    scanner.nextLine();

    return result;
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        System.out.print("Enter the name of the metal (or \"Quit\" to quit): ");
        String name = scanner.nextLine();

        if (name.matches("\\s*[Qq]uit\\s*")) {
          break;
        }

        double density = inputDouble("Enter the density in g/cm³: ", scanner);
        double meltingPoint = convertFromCelsius(
          "f",
          inputDouble("Enter the melting point in degrees Celsius: ", scanner)
        );
        double boilingPoint = convertFromCelsius(
          "f",
          inputDouble("Enter the boiling point in degrees Celsius: ", scanner)
        );
        int hardness = inputRange(
          "Input the hardness from 1 to 10: ",
          1,
          10,
          scanner
        );

        System.out.println("============ METAL ============");
        System.out.format("Name:          %16s\n", name);
        System.out.format("Density:       %16.2f %s\n", density, "g/cm³");
        System.out.format("Melting Point: %16.2f %s\n", meltingPoint, "°F");
        System.out.format("Boiling Point: %16.2f %s\n", boilingPoint, "°F");
        System.out.format("Hardness:      %16s\n", hardness + "/10");
      }
    }
  }
}

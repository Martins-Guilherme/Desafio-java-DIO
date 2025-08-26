import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("-----------------");
    System.out.println("**SUPER-Compras**");
    System.out.println("-----------------");
    System.out.println("Informe o valor da sua compra: ");
    String valorCompra = scanner.nextLine();
    System.out.println(calcularDesconto(valorCompra));
    scanner.close();
  }

  // Verificar se o valor informado é válido.
  public static boolean isValidNumber(String str) {
    try {
      new BigDecimal(str);
      return true;
    } catch (NumberFormatException error) {
      return false;
    }
  }

  public static String calcularDesconto(String valorCompra) {
    // VERIFICANDO SE O VALOR É NUMERAL
    if (!isValidNumber(valorCompra)) {
      return "Valor incorreto!";
    }

    BigDecimal valor = new BigDecimal(valorCompra);

    // DEFININDO AS VARIAVEIS
    BigDecimal desconto50 = new BigDecimal("50.00");
    BigDecimal desconto100 = new BigDecimal("100.00");
    BigDecimal valorFinal;
    BigDecimal valorDesconto;
    String tipoDesconto;

    // VERIFICANDO SE O VALOR É MAIOR QUE ZERO
    if (valor.compareTo(BigDecimal.ZERO) <= 0) {
      return "Valor menor que zero.";
    }
    // TODO: Verifique se o valor é menor que 50.00: Resultado = -1
    if (valor.compareTo(desconto50) < 0) {
      valorFinal = valor;
      valorDesconto = BigDecimal.ZERO;
      tipoDesconto = "Nenhum";
    }
    // TODO: Verifique se o valor é entre 50.00 e 100.00 (inclusive): Resultado = 0
    else if (valor.compareTo(desconto100) <= 0) {
      valorDesconto = valor.multiply(new BigDecimal("0.10"));
      valorFinal = valor.subtract(valorDesconto);
      tipoDesconto = "10%";
      // TODO: Caso contrário, o valor é maior que 100.00: Resultado = 1
    } else {
      valorDesconto = valor.multiply(new BigDecimal("0.20"));
      valorFinal = valor.subtract(valorDesconto);
      tipoDesconto = "20%";
    }
    // TODO: Retorne a string formatada com o desconto aplicado, conforme exigido no desafio:
    return (
      "\n===RESUMO DA COMPRA===\nValor original: R$ " +
      valor.setScale(2, RoundingMode.HALF_UP) +
      "\nDesconto aplicado: " +
      tipoDesconto +
      "\nValor desconto: R$ " +
      valorDesconto.setScale(2, RoundingMode.HALF_UP) +
      "\nValor Final: R$ " +
      valorFinal.setScale(2, RoundingMode.HALF_UP)
    );
  }
}

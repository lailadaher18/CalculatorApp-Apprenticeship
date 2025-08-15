package calculatorService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CalcController {
    BigDecimal result = BigDecimal.ZERO;
    int j = 0;
    @PostMapping("/calculate")
    public ResponseEntity<Map<String, Object>> calculate(@RequestBody Map<String, String> payload) {
        String expression = payload.get("expression");
        System.out.println(expression);
        try {

            String[] arrayItems = expression.split("(?<=[^0-9.])|(?=[^0-9.])"); //split by non-numeric characters

            System.out.println(Arrays.stream(arrayItems).toList());

            try {
                if(arrayItems[0].equals("-")){ // check for first number being negative
                    result = new BigDecimal(arrayItems[0]+arrayItems[1]);
                    System.out.println("result =" + result);
                    j=2;
                }else{
                    result = new BigDecimal(arrayItems[0]);
                    j=1;
                }
                if(arrayItems[1].equals("-")&& arrayItems[2].equals("-")){ // check for second number being negative
                    j=1;
                    arrayItems[j+1] = arrayItems[j+1] + arrayItems[j+2];
                }
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(Map.of("result", "Unknown operator: " + arrayItems[0]));
            }

            for (int i = j; i < arrayItems.length - 1; i += 2) {
                System.out.println("result =" + result);
                String operator = arrayItems[i];
                System.out.println("operator =" + arrayItems[i]);
                String secondNumber = arrayItems[i + 1];
                System.out.println("secondNumber=" + arrayItems[i + 1]);

                result = Calculator.calculate(result.toPlainString(), operator, secondNumber);
            }
            System.out.println("result =" + result);


            return ResponseEntity.ok(Map.of("result", result.toPlainString()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("result", e.getMessage()));
        }
    }
}
